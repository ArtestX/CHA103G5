package com.cha103g5.customerservicerecord.util;

import java.util.ArrayList;
import java.util.List;

import com.cha103g5.customerservicerecord.model.ChatMessage;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisHandleMessage {

	static JedisPool pool = JedisPoolUtil.getJedisPool();

	static Gson gson = new Gson();

	static Jedis jedis = pool.getResource();


	// key的設計為(發送者名稱:接收者名稱)
	public static List<String> getHistoryMsg(String sender, String receiver) {
		jedis.select(1);
		String key = new StringBuilder(sender).append(":").append(receiver).toString();
		List<String> historyData = jedis.lrange(key, 0, -1);
		jedis.close();
		return historyData;
	}


	public static void saveChatMessage(ChatMessage message) {
		jedis.select(1);
		// 對雙方來說，都要各存著歷史聊天記錄
		if ("host".equals(message.getReceiver())) {
			jedis.rpush("host:" + message.getSender(), gson.toJson(message));
			jedis.rpush("member:" + message.getSender(), gson.toJson(message));
		} else {
			jedis.rpush("host:" + message.getReceiver(), gson.toJson(message));
			jedis.rpush("member:" + message.getReceiver(), gson.toJson(message));
		}
		jedis.close();
	}

	// 將聊天訊息存儲到 Redis 中
	public static void readAll(String sender, String receiver) {
		jedis.select(1);
		Gson gson = new Gson();
		List<String> historyData = JedisHandleMessage.getHistoryMsg(sender, receiver);
		String key = new StringBuilder(sender).append(":").append(receiver).toString();
		jedis.del(key);
		for (String oneChat : historyData) {
			ChatMessage cm = gson.fromJson(oneChat, ChatMessage.class);
			if (cm.getStatus() != null) {
				cm.setStatus("read");
			}
			jedis.rpush(key, gson.toJson(cm));
		}
	}

	// 將指定發送者和接收者之間的聊天訊息標記為已讀
	public static List<String> getAllKey() {
		jedis.select(1);
		List<String> allKey = new ArrayList<String>();
		for (String key : jedis.keys("host*")) {
			if (jedis.type(key).equals("list")) {
				allKey.add(key);
			}
		}
		return allKey;
	}

	//獲取聊天室清單
	public static List<String> getChatRoomList() {
		jedis.select(1);
		List<String> allKey = new ArrayList<String>();
		for (String key : jedis.keys("host*")) {
			if (jedis.type(key).equals("list")) {
				// 將 "host:"移除, 僅保留會員名稱
				allKey.add(key.replaceAll("host:", ""));
			}
		}
		return allKey;
	}

	//會員獲取聊天訊息
	public static List<String> getMemberMemberMsg(String member) {
		jedis.select(1);
		String key = "member:" + member;
		List<String> historyData = jedis.lrange(key, 0, -1);
		jedis.close();
		return historyData;
	}

	//客服獲取聊天訊息
	public static List<String> getHostMemberMsg(String member) {
		jedis.select(1);
		String key = "host:" + member;
		List<String> historyData = jedis.lrange(key, 0, -1);
		jedis.close();
		return historyData;
	}

	//客服獲取最後聊天訊息
	public static ChatMessage getHostMemeberLastMsg(String member) {
		jedis.select(1);
		String key = "host:" + member;
		List<String> lastRow = jedis.lrange(key, 0, -1);
		ChatMessage msg = null;
		if(lastRow != null && lastRow.size()>0) {
			msg = gson.fromJson(lastRow.get((lastRow.size()-1)), ChatMessage.class);
		}
		return msg;
	}



}

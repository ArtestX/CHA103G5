package com.cha103g5.membernotice.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cha103g5.customerservicerecord.util.JedisPoolUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

public class MemberNoticeDAO implements MemberNoticeDAOinterface{
	   private final JedisPool jedisPool = JedisPoolUtil.getJedisPool();

	    private static final int REDIS_NUMBER = 15;

	    private static final String NOTICE_PREFIX = "notice: ";

	    private static final String MBR_PREFIX = "member: ";


	    // 通知存活30天
	    private final int TTL = 60 * 60 * 24 * 30;

	    @Override
	    public void insert(MemberNoticeVO memberNoticeVO, Integer memberno){
	        try (Jedis jedis = jedisPool.getResource()) {
	            jedis.select(REDIS_NUMBER);
	            // List儲存 (Key:會員ID,value:通知自增主鍵)
	            String value = NOTICE_PREFIX + jedis.incr("memberNoticeVO");
	            jedis.lpush(MBR_PREFIX + memberno ,  value);

	            // Hash儲存 (Key:通知的自增主鍵)
	            jedis.hset(value, "content", memberNoticeVO.getNoticecontent());
	            jedis.hset(value, "time", String.valueOf(memberNoticeVO.getNoticetime()));
	            jedis.hset(value, "read", String.valueOf(memberNoticeVO.getReadstat()));

	            jedis.expire(value, TTL);
	        }
	    }

	    @Override
	    public List<MemberNoticeVO> getAllByMemberno(Integer memberno) {
	        List<MemberNoticeVO> noticeList = new ArrayList<>();
	        try (Jedis jedis = jedisPool.getResource()) {
	            // 獲取所有與會員有關的通知ID
	            List<String> noticeIdList = jedis.lrange(MBR_PREFIX + memberno, 0, -1);
	            if (noticeIdList != null && !noticeIdList.isEmpty()) {
	                for (String membernoticeno : noticeIdList) {
	                    Map<String, String> noticeData = jedis.hgetAll(membernoticeno);

	                    if (noticeData == null || noticeData.isEmpty()) {
	                        jedis.lrem(MBR_PREFIX + memberno, 0, membernoticeno);
	                        continue;
	                    }

	                    MemberNoticeVO memberNoticeVO = new MemberNoticeVO();
	                    memberNoticeVO.setNoticecontent(noticeData.get("content"));
	                    memberNoticeVO.setReadstat(Boolean.parseBoolean(noticeData.get("read")) ? 1 : 0);
	                    memberNoticeVO.setNoticetime(new Timestamp(Long.parseLong(noticeData.get("time"))));
	                    noticeList.add(memberNoticeVO);
	                }
	            }
	            return noticeList;
	        }
	    }

	    @Override
	    public List<MemberNoticeVO> getNoticesByMembernoAndRead(Integer memberno, Integer readstat) {
	        List<MemberNoticeVO> noticeList = new ArrayList<>();
	        try (Jedis jedis = jedisPool.getResource()) {
	            jedis.select(REDIS_NUMBER);

	            List<String> noticeIdList = jedis.lrange(MBR_PREFIX + memberno , 0, -1);

	            for (String membernoticeno : noticeIdList) {
	                Map<String, String> noticeData = jedis.hgetAll(membernoticeno);

	                if (noticeData == null || noticeData.isEmpty()) {
	                    jedis.lrem(MBR_PREFIX + memberno , 0, membernoticeno);
	                    continue;
	                }

	                Integer readstatValue = Integer.parseInt(noticeData.get("read"));
	                if (readstatValue.equals(readstat)) {
	                    MemberNoticeVO memberNoticeVO = new MemberNoticeVO();
	                    memberNoticeVO.setNoticecontent(noticeData.get("content"));
	                    memberNoticeVO.setReadstat(readstatValue); 
	                    memberNoticeVO.setNoticetime(new Timestamp(Long.parseLong(noticeData.get("time"))));
	                    noticeList.add(memberNoticeVO);
	                }
	            }
	        }
	        return noticeList;
	    }

	    @Override
	    public int getUnreadCountByMemberno(Integer memberno) {
	        int unreadCount = 0;
	        try (Jedis jedis = jedisPool.getResource()) {
	            jedis.select(REDIS_NUMBER);

	            List<String> noticeKeys = jedis.lrange(MBR_PREFIX + memberno, 0, -1);

	            for (String noticeKey : noticeKeys) {
	                String readStatus = jedis.hget(noticeKey, "read");

	                if (readStatus == null) {
	                	 jedis.lrem(MBR_PREFIX + memberno , 0, noticeKey);
	                    continue;
	                }

	                if ("false".equals(readStatus)) {
	                    unreadCount++;
	                }
	            }
	        }
	        return unreadCount;
	    }

	    @Override
	    public void markNoticesAsRead(Integer membernoticeno) {
	        if (membernoticeno == null) {
	            return;
	        }

	        try (Jedis jedis = jedisPool.getResource()) {
	            jedis.select(REDIS_NUMBER);

	            String noticeId = MBR_PREFIX + membernoticeno;

	            if (noticeId != null && !noticeId.isEmpty()) {
	                jedis.hset(noticeId, "read", "true");
	            }
	        }catch (JedisException e) {
	            e.printStackTrace();
	        }
	    }
	

}

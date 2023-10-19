package com.cha103g5.member.service;

import static com.cha103g5.member.model.Constants.PAGE_MAX_RESULT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cha103g5.member.model.*;
import com.cha103g5.util.HibernateUtil;

public class MemberService implements MemberServiceInterface{
	
	private MemberDAOinterface dao;
	
	public MemberService() {
		dao = new MemberHibernateDAO(HibernateUtil.getSessionFactory());
	}

	@Override
	public MemberVO addMember(MemberVO memberVO) {
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO memberVO) {
		return null;
	}

	@Override
	public MemberVO getMemberByMemberno(Integer memberno) {
		return null;
	}

	@Override
	public List<MemberVO> getAllMembers(int currentPage) {
		return dao.getAll(currentPage);
	}

	@Override
	public int getPageTotal() {
		long total = dao.getTotal(); 
		// 計算Member數量每頁3筆的話總共有幾頁
		int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}

	@Override
	public List<MemberVO> getMembersByCompositeQuery(Map<String, String[]> map) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();
		
		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0];
			if (value.isEmpty() || value == null) {
				continue;
			}
			query.put(key, value);
		}
		
		System.out.println(query);
		
		return dao.getByCompositeQuery(query);
	}
	
	
	
	
}

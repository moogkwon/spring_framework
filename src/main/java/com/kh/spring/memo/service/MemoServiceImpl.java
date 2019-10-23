package com.kh.spring.memo.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.memo.dao.MemoDao;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	MemoDao dao;
	
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public List<Map<String, String>> selectMemoList() {
		return dao.selectMemoList(session);
	}

	
	
}

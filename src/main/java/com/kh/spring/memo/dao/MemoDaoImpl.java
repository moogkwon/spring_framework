package com.kh.spring.memo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDaoImpl implements MemoDao {

	@Override
	public List<Map<String, String>> selectMemoList(SqlSessionTemplate session) {
		return session.selectList("memo.selectList");
	}
	
}

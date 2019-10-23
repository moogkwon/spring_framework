package com.kh.spring.memo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


public interface MemoDao {

	List<Map<String, String>> selectMemoList(SqlSessionTemplate session);

}

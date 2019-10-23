package com.kh.spring.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.demo.model.vo.Dev;

public interface DevDao {
	int insertDev(SqlSessionTemplate sqlSession, Dev dev);

	List<Dev> selectDevList(SqlSessionTemplate sqlSession);
}

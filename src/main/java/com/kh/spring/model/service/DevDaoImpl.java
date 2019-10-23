package com.kh.spring.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;
import com.kh.spring.model.dao.DevDao;


// This Repository is needed to autowire in DevServiceImpl
@Repository
public class DevDaoImpl implements DevDao {

	
	@Override
	public int insertDev(SqlSessionTemplate sqlSession, Dev dev) {
		return sqlSession.insert("dev.insertDev", dev);
	}

	@Override
	public List<Dev> selectDevList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("dev.selectDevList");
	}
	
}

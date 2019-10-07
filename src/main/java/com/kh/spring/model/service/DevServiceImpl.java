package com.kh.spring.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.vo.Dev;
import com.kh.spring.model.dao.DevDao;
import com.kh.spring.model.dao.DevService;

@Service // This is autowired
public class DevServiceImpl implements DevService {
	
	@Autowired
	DevDao dao;
	
	@Autowired
	SqlSessionTemplate sqlSession; // 이건 root-context.xml 에 있음

	@Override
	public int insertDev(Dev dev) {
		return dao.insertDev(sqlSession, dev);
	}

}

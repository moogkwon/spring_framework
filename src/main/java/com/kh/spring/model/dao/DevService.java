package com.kh.spring.model.dao;

import java.util.List;

import com.kh.spring.demo.model.vo.Dev;

public interface DevService {

	int insertDev(Dev dev);

	List<Dev> selectDevList();
	
}

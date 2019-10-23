package com.kh.spring.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.demo.model.vo.Member;


public interface MemberDao {

	Member loginMember(SqlSessionTemplate sqlSession, Member m);

	int memberSignUp(SqlSessionTemplate sqlSession, Member m);

	

}

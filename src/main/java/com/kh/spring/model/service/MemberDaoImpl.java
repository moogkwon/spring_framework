package com.kh.spring.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Member;
import com.kh.spring.model.dao.MemberDao;

@Repository // Don't forget this on impl
public class MemberDaoImpl implements MemberDao {

	//mybatis-config.xml 에 세팅 해줘야됨. 
	@Override
	public Member loginMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("member.loginMember", m);
	}

	@Override
	public int memberSignUp(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("member.signUp", m);
	}

	
	
}

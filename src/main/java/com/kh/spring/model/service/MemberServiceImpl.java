package com.kh.spring.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.vo.Member;
import com.kh.spring.model.dao.MemberDao;
import com.kh.spring.model.dao.MemberService;

@Service // Don't forget this on impl
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	SqlSessionTemplate sqlSession; // this is located in root-context.xml

	@Override
	public Member loginMember(Member m) {
		return memberDao.loginMember(sqlSession, m);
	}

	@Override
	public int memberSignUp(Member m) {
		return memberDao.memberSignUp(sqlSession, m);
	}
	

	
}

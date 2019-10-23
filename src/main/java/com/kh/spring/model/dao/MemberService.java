package com.kh.spring.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring.demo.model.vo.Member;

public interface MemberService {

	Member loginMember(Member m);

	int memberSignUp(Member m);


}

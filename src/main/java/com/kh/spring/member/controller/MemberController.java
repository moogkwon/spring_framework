package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring.board.service.BoardService;
import com.kh.spring.common.Log4JTest;
import com.kh.spring.demo.model.vo.Member;
import com.kh.spring.model.dao.MemberService;
@SessionAttributes(value= {"loginMember"})
@Controller  // annotation 표시
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(Log4JTest.class);
	
	@Autowired 
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	BoardService bService;
	
	
	@RequestMapping("/member/memberLogin.do")
	public String loginMember(Model model, Member m, SessionStatus session) { //HttpSession session 지움
		
		Member mb = memberService.loginMember(m);
		
		logger.debug(m.getUserId());
		logger.debug(m.getPassword());
		logger.debug(pwEncoder.encode(m.getPassword()));

		String msg = "";
		String loc="/";
		
		/* if(mb.getPassword().equals(m.getPassword())) { */
		if(pwEncoder.matches(m.getPassword(), mb.getPassword())) {
			msg="로그인 성공";
			//session.setAttribute("loginMember", mb);
			model.addAttribute("loginMember", mb);
		} else {
			msg="로그인 실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	
	
	// 화상채팅 구현
	@RequestMapping("/viewChatting.do")
	public String viewChatting() {
		return "chatting/viewChatting";
	}
	
//	//option1
//	//aJax 통신 stream 이용하는 방법
//		@RequestMapping("/member/checkId.do")
//		public void ajaxStream(String userId, HttpServletResponse res) throws IOException {
//			Member m = new Member();
//			m.setUserId(userId);
//			m=memberService.loginMember(m);
//			boolean isUsable = m!= null && m.getUserId()!=null?false:true;
//			
//			res.getWriter().print(isUsable);
//		}
	
	
	
//	//option2	(Member m object thrown)
//	@RequestMapping("/member/checkId.do")
//	// viewResolver (jsonView) 를 통해서 ajax 처리하는 방법
//	public ModelAndView ajaxViewResolver(String userId, ModelAndView mv) {
//		Member m = new Member();
//		m.setUserId(userId);
//		m=memberService.loginMember(m);
//		//Member member =memberService.loginMember(m); //  객체 넘기기
//		
//		boolean isUsable=(m!=null&&m.getUserId()!=null)?false:true;
//		//mv.addObject("member", member); // JSONObject, 객체 말고 단일값만 전송
//		mv.addObject("userId", "sdfafawevwe");
//		mv.addObject("isUsable", isUsable);
//		mv.setViewName("jsonView"); // 명칭을 반드시 jsonView 라고 작성을 해야함...!
//		
//		return mv;
//	}

//	// option 2 (List)
//	@RequestMapping("/member/checkId.do")
//    @ResponseBody
//    public String responseBody(String userId, Model  model) throws JsonProcessingException {
//        
//        Member m = new Member();
//        m.setUserId(userId);
//        m = memberService.loginMember(m);
//        
//        // jackson gson 과 비슷한 역할을 함.
//        ObjectMapper mapper = new ObjectMapper(); //  json 객체를 자동으로 연결 java 와
//        List<Map<String, String>> list =  bService.selectBoardList(1,5);
//        
//        //mapper.readValue(json값, vo클래스);
//        return mapper.writeValueAsString(m);      
//    }
	
	
	//option3	(Member Object) 
	@RequestMapping("/member/checkId.do")
	@ResponseBody
	public String responseBody(String userId, Model model) throws JsonProcessingException {
		
		Member m = new Member();
		m.setUserId(userId);
		m = memberService.loginMember(m);
		
		// jackson gson 과 비슷한 역할을 함.
		ObjectMapper mapper = new ObjectMapper(); // json 객체를 자동으로 연결 java 와
		//List<Map<String, String>> list = bService.selectBoardList(1,5);
		//mapper.readValue(json값, vo클래스);
		return mapper.writeValueAsString(m);		
	}
	
	
	@RequestMapping("/member/memberEnroll.do")
	public String enroll() {
		// 화면 전환용 메소드
		return "member/memberEnroll";
	}
	
	
	// 회원가입
	@RequestMapping("/member/memberEnrollEnd.do")
	public String signUp(Model model, Member m, HttpSession session) {
		
		m.setPassword(pwEncoder.encode(m.getPassword()));
		
		int result = memberService.memberSignUp(m);
		
		String msg = "";
		String loc="/";
		if(result>0) {
			msg="회원가입 성공!";
		} else {
			msg="회원가입 실패..";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	
	
	// 로그아웃
	@RequestMapping("/member/memberLogout.do")
	public String logout(/* HttpSession session, */ SessionStatus status) {
		//System.out.println("Controller : session invalidated yo");
		/* session.invalidate(); */
		
		status.setComplete();
		return "redirect:/";
	}
	
}

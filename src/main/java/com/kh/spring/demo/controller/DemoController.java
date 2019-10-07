package com.kh.spring.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.vo.Dev;
import com.kh.spring.model.dao.DevService;

@Controller  // annotation 표시
public class DemoController {
	
	@Autowired
	DevService devService;
	//DevService devService = new DevServiceImpl(); // 이제 이거 안 씀
	
	
	@RequestMapping("/demo/demo.do") // 매핑값
	public String jangwon() {
		System.out.println("/demo/demo.do 컨트롤러 호출");
		return "demo/demo"; // 얘를 resolve 한테 넘김. servlet-context.xml 에 있는. 얘는 그냥 Dispatcher 라고 생각하면 됨
	}
	
	@RequestMapping("/demo/demo1.do")
		public String demo1(HttpServletRequest req, HttpServletResponse res) {
			String devName = req.getParameter("devName");
			int devAge = Integer.parseInt(req.getParameter("devAge"));
			String devEmail = req.getParameter("devEmail");
			String devGender = req.getParameter("devGender");
			String []devLangs = req.getParameterValues("devLang");
			
			System.out.println(devName + " " + devAge + " " + devEmail + " " + devGender + " " + devEmail);
			
			for(String a : devLangs) {
				System.out.println(a);
			}
			
			Dev dev = new Dev(devName, devAge, devEmail, devGender, devLangs);
			req.setAttribute("dev", dev);
			
			
			return "demo/demoResult";
		}
	
//	//@RequestParam(value="name명") 매개변수 지정 => 매개변수 위치
//	// 공유객체를 request 를 사용하지 않고 Model 객체를 이용하여 
//	// 데이터를 공유할 수 있음
//	@RequestMapping("/demo/demo2.do")
//		public String demo2(
//			@RequestParam(value="devName") String devName,
//			@RequestParam(value="devAge", required= false, defaultValue="19") int devAge, // 있으면 받고 없으면 받지망
//			@RequestParam(value="devEmail") String devEmail,
//			@RequestParam(value="devGender") String devGender,
//			@RequestParam(value="devLang") String[] devLang,
//			HttpServletRequest req
//		) 
//	
//	{
//		System.out.println(devName);
//		System.out.println(devAge);
//		System.out.println(devEmail);
//		System.out.println(devGender);
//		System.out.println(devLang);
//		
//		Dev dev = new Dev(devName, devAge, devEmail, devGender, devLang);
//		req.setAttribute("dev", dev);
//		
//		return "demo/demoResult";
//	}
	
	// The one on the bottom is easier than the one on the top
	//@RequestParam(value="name명") 매개변수 지정 => 매개변수 위치
//	@RequestMapping("/demo/demo2.do")
//		public String demo2(String devName, int devAge, String devEmail, String devGender, String[] devLang)
//	{
//		System.out.println(devName);
//		System.out.println(devAge);
//		System.out.println(devEmail);
//		System.out.println(devGender);
//		System.out.println(devLang);
//		
//		return "demo/demoResult";
//	}
	
	
	//@RequestParam(value="name명") 매개변수 지정 => 매개변수 위치
	// 공유객체를 request 를 사용하지 않고 Model 객체를 이용하여 
	// 데이터를 공유할 수 있음
	// 모델 객체를 이용하여 데이터 넘기기
	@RequestMapping("/demo/demo2.do")
	public String demo2(String devName, int devAge, String devEmail, String devGender, String[] devLang, Model model)
	{
		System.out.println(devName);
		System.out.println(devAge);
		System.out.println(devEmail);
		System.out.println(devGender);
		System.out.println(devLang);
		
		Dev dev = new Dev(devName, devAge, devEmail, devGender, devLang);
		
		//req.setAttribute("dev", dev);
		model.addAttribute("dev", dev);
		
		return "demo/demoResult";
	}
	
	
	// 갈수록 짧아짐
	@RequestMapping("/demo/demo3.do")
	public String demo3(@RequestParam Map map, Model model) {
		System.out.println(map);
		model.addAttribute("dev", map);
		return "demo/demoResult";
	}
	
	@RequestMapping("/demo/demo4.do")
	public String demo4(Dev dev, Model model) {
		
		model.addAttribute("dev", dev);
		return "demo/demoResult";
	}
	
	@RequestMapping("/demo/insertDev.do")
	public String insertDev(Dev dev) {
		
		int result = devService.insertDev(dev);
		
		System.out.println(result);
		
		
		// 리다이렉트로 페이지전환
		//return "/"; // ==> /WEB-INF/VIEWS//.jsp; 404! 에러 남
		//return "redirect:/demo/demo2.do"; 
		return "redirect:/";
	}
	
	
}

package com.kh.spring.memo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.spring.memo.service.MemoService;


@Controller // This is the annotation
public class MemoController {
	
	@Autowired
	MemoService memoService;
	
	@RequestMapping("/memo/memo.do")
	public String memoView(Model model) {
		List <Map<String, String>> list = memoService.selectMemoList();
		model.addAttribute("list", list);
		return "memo/memo";
	}
	
}

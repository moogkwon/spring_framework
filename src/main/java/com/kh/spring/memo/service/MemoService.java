package com.kh.spring.memo.service;

import java.util.List;
import java.util.Map;

import com.kh.spring.memo.model.vo.Memo;


public interface MemoService {

	List<Map<String, String>> selectMemoList();

}

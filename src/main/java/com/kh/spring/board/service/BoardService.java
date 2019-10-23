package com.kh.spring.board.service;

import java.util.List;
import java.util.Map;

import com.kh.spring.board.model.vo.Attachment;


public interface BoardService {

	List<Map<String, String>> selectBoardList(int cPage, int numPerPage);

	int selectBoardCount();

	int insertBoard(Map<String, String> param, List<Attachment> attachList) throws Exception;

	Map<String, String> selectBoard(int boardNo);

	List<Attachment> selectAttachList(int boardNo);

	

}

package com.kh.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.board.model.vo.Attachment;

public interface BoardDao {

	List<Map<String, String>> selectBoardList(SqlSessionTemplate sqlSession, int cPage, int numPerPage);

	int selectBoardCount(SqlSessionTemplate sqlSession);

	int insertBoard(SqlSessionTemplate sqlSession, Map<String, String> param);

	int insertAttachment(SqlSessionTemplate sqlSession, Attachment a);

	Map<String, String> selectBoard(SqlSessionTemplate sqlSession, int boardNo);

	List<Attachment> selectAttachList(SqlSessionTemplate sqlSession, int boardNo);

	

}

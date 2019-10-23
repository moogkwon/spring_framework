package com.kh.spring.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> selectBoardList(int cPage, int numPerPage) {
		return dao.selectBoardList(sqlSession, cPage, numPerPage);
	}

	@Override
	public int selectBoardCount() {
		return dao.selectBoardCount(sqlSession);
	}

	@Override
	//@Transactional(rollbackFor = Exception.class) // RuntimeException 발생시 !!!!!!! 다 rollback 하라!
	public int insertBoard(Map<String, String> param, List<Attachment> attachList) throws Exception {
		int result = 0;
		int boardNo = 0;
		
		result = dao.insertBoard(sqlSession, param); // board테이블에 데이터 입력!
		if(result==0) throw new RuntimeException();
		//result=0;
		if(attachList.size()>0) {
			for(Attachment a: attachList) {
				a.setBoardNo(Integer.parseInt(param.get("boardNo")));
				dao.insertAttachment(sqlSession, a);
				if(result==0) throw new Exception();
			}
		}
		
		return result;
	}

	@Override
	public Map<String, String> selectBoard(int boardNo) {
		return dao.selectBoard(sqlSession, boardNo);
	}

	@Override
	public List<Attachment> selectAttachList(int boardNo) {
		return dao.selectAttachList(sqlSession, boardNo);
	}
	
	
	
}

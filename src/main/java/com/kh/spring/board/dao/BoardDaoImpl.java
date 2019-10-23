package com.kh.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Attachment;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Map<String, String>> selectBoardList(SqlSessionTemplate sqlSession, int cPage, int numPerPage) {
		 RowBounds rows = new RowBounds((cPage-1)*numPerPage, numPerPage);
         return sqlSession.selectList("board.selectBoardList", null, rows);
	}

	@Override
	public int selectBoardCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("board.selectBoardCount");
	}

	@Override
	public int insertBoard(SqlSessionTemplate sqlSession, Map<String, String> param) {
		return sqlSession.insert("board.insertBoard", param);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate sqlSession, Attachment a) {
		return sqlSession.insert("board.insertAttachment",a
				);
	}

	@Override
	public Map<String, String> selectBoard(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("board.selectBoard", boardNo);
	}

	@Override
	public List<Attachment> selectAttachList(SqlSessionTemplate sqlSession, int boardNo) {
	
		return sqlSession.selectList("board.selectAttachList", boardNo);
	}
	
	


}

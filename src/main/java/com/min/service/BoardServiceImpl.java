package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.BoardMapper;
import com.min.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardSerivce{

	@Autowired
	private BoardMapper mapper;
	
	
	/*등록*/
	@Override
	public void enroll(BoardVO board) {
		mapper.enroll(board);
	}

	/*목록*/
	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}
	
	/*조회*/
	@Override
	public BoardVO getPage(int bno) {
		return mapper.getPage(bno);
	}
	
	/*수정*/
	@Override
	public int modify(BoardVO board) {
		return mapper.modify(board);
	}
	
	/*삭제*/
	@Override
	public int delete(int bno) {
		return mapper.delete(bno);
	}

}

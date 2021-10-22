package com.min.service;

import java.util.List;

import com.min.model.BoardVO;

public interface BoardSerivce {
	
	
	/*등록*/
	public void enroll(BoardVO board);
	
	
	/*목록*/
	public List<BoardVO> getList();
	
	
	/*조회*/
	public BoardVO getPage(int bno);
	
	/*수정*/
	public int modify(BoardVO board);
	
	/*삭제*/
	public int delete(int bno);
}

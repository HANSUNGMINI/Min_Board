package com.min.mapper;

import java.util.List;

import com.min.model.BoardVO;

public interface BoardMapper {
	
	
	/*등록*/
	public void enroll(BoardVO board);
	
	/*목록*/
	public List<BoardVO> getList();
	
	/*게시판 조회*/
	public BoardVO getPage(int bno);
	
	/*게시판 수정*/
	public int modify(BoardVO board);
	
	/*게시판 삭제*/
	public int delete(int bno);
}

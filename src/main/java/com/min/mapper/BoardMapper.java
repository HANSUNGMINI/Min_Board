package com.min.mapper;

import java.util.List;

import com.min.model.BoardVO;
import com.min.model.Criteria;

public interface BoardMapper {
	
	
	/*등록*/
	public void enroll(BoardVO board);
	
	/*목록*/
	public List<BoardVO> getList();
	
	/*목록(페이지 적용)*/
	public List<BoardVO> getListPaging(Criteria cri);
	
	/*게시물 총 갯수*/
	public int getTotal(Criteria cri);
	
	/*게시판 조회*/
	public BoardVO getPage(int bno);
	
	/*게시판 수정*/
	public int modify(BoardVO board);
	
	/*게시판 삭제*/
	public int delete(int bno);
	
}

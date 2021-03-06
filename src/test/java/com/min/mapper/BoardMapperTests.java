package com.min.mapper;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.model.BoardVO;
import com.min.model.Criteria;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	private static final Logger log=LoggerFactory.getLogger(BoardMapperTests.class);
	
	@Autowired
	private BoardMapper mapper;
	/*게시판 등록 TEST*/
//	@Test
//	public void testEnroll() {
//		
//		BoardVO vo=new BoardVO();
//		
//		vo.setTitle("mapper test");
//		vo.setContent("mapper test");
//		vo.setWriter("mapper test");
//		
//		mapper.enroll(vo);
//	}
	/*게시판 목록 TEST*/
//	@Test
//	public void testGetList() {
//		List<BoardVO> list=mapper.getList();
//		
//		for(int i=0;i<list.size();i++) {
//			log.info(""+list.get(i));
//		}
//	}
	/*게시판 조회 TEST*/
//	@Test
//	public void testGetPage() {
//		int bno=4;
//		
//		log.info(""+mapper.getPage(bno));
//	}
	
	/*게시판 수정 TEST*/
//	@Test
//	public void testModify() {
//		
//		BoardVO board=new BoardVO();
//		
//		board.setBno(4);
//		board.setTitle("수정 제목");
//		board.setContent("수정 내용");
//		
//		int result=mapper.modify(board);
//		log.info("result : "+result);
//	}
	/*게시판 삭제 TEST*/
//	@Test
//	public void testDelete() {
//		int result=mapper.delete(4);
//		log.info("result : "+result);
//	}
	
	/*게시판 목록 페이징 TEST*/
	@Test
	public void testGetListPaging() {
		Criteria cri=new Criteria();
		
		List list=mapper.getListPaging(cri);
		
		list.forEach(board ->log.info(""+board));
	}
}

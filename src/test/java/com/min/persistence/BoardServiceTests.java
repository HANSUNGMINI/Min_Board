package com.min.persistence;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.model.BoardVO;
import com.min.service.BoardSerivce;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	private static final Logger log=LoggerFactory.getLogger(BoardServiceTests.class);
	
	
	@Autowired
	private BoardSerivce service;
	
	/*등록 TEST*/
//	@Test
//	public void testEnroll() {
//		
//		BoardVO vo=new BoardVO();
//		
//		vo.setTitle("service Test");
//		vo.setContent("service Test");
//		vo.setWriter("service Test");
//		
//		service.enroll(vo);
//		
//	}
	/*목록 TEST*/
//	@Test
//	public void testGetList() {
//		service.getList().forEach(board ->log.info(""+board));
//	}
	/*조회 TEST*/
//	@Test
//	public void testGetPage() {
//		int bno=4;
//		
//		log.info(""+service.getPage(bno));
//	}
	/*수정 TEST*/
//	@Test
//	public void testModify() {
//		BoardVO board=new BoardVO();
//		board.setBno(3);
//		board.setTitle("수정 목록");
//		board.setContent("수정 내용 ");
//		
//		int result=service.modify(board);
//		log.info("result : "+result);
//	}
	/*삭제 TEST*/
	@Test
	public void testDelete() {
		int result=service.delete(4);
		log.info("result : "+result);
	}
}

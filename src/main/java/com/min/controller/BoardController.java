package com.min.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.min.model.BoardVO;
import com.min.service.BoardSerivce;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger log=LoggerFactory.getLogger(BoardController.class);
	
	
	@Autowired
	private BoardSerivce bservice;
	
	/*게시판 목록*/
	@GetMapping("/list")
	public void boardListGET(Model model) {
		log.info("게시판 목록 페이지 진입");
		
		model.addAttribute("list",bservice.getList());
	}
	
	/*게시판 등록페이지 접속*/
	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입");
	}
	
	/*게시판 등록*/
	@PostMapping("/enroll")
	public String boardEnrollPost(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardVO : "+board);
		bservice.enroll(board);
		
		rttr.addFlashAttribute("result","enrol success");
		
		return "redirect:/board/list";
	}
	
	/*게시판 조회*/
	@GetMapping("/get")
	public void boardGetPageGET(int bno,Model model) {
		model.addAttribute("pageInfo",bservice.getPage(bno));
	}
	
	/*게시판 수정(GET)*/
	@GetMapping("/modify")
	public void boardModifyGET(int bno,Model model) {
		model.addAttribute("pageInfo",bservice.getPage(bno));
	}
	
	/*게시판 수정(POST)*/
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board,RedirectAttributes rttr) {
		
		bservice.modify(board);
		
		rttr.addFlashAttribute("result","modify success");
		
		return "redirect:/board/list";
	}
	
	/*게시판 삭제*/
	@PostMapping("/delete")
	public String boardDeletePost(int bno,RedirectAttributes rttr) {
		bservice.delete(bno);
		
		rttr.addFlashAttribute("result","delete success");
		
		return "redirect:/board/list";
	}
	
	
}

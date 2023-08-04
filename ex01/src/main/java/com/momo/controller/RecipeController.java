package com.momo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.momo.service.CateService;
import com.momo.service.ComBoardService;
import com.momo.service.RecBoardService;
import com.momo.vo.BoardVO;
import com.momo.vo.CategoryVO;
import com.momo.vo.ComBoardVO;
import com.momo.vo.RecBoardVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/recipe1/*")
@Log4j
public class RecipeController {
	
	@Autowired
	RecBoardService service;
	
	@Autowired
	CateService cateservice;
	
	
	
	@GetMapping("/list")
	public String listTest() {
		System.out.println("dddd");
		return "/recipe/list";
	}
	
	@GetMapping("/write")
	public String recWrite() {
		
		
		
		return "/recipe/rec_write";
	}
	
	
	@GetMapping("msg")
	public void msg() {
		
	}
	
	@GetMapping("message")
	public void message(Model model) {
		
	}
	
	@PostMapping("/postWrite2")
	public String writeAction2(RecBoardVO board
								, List<MultipartFile> files
								, RedirectAttributes rttr
								, Model model) {
		log.info(board);
		
		int res;

		try {
			// 시퀀스 조회 후 시퀀스 번호를 bno에 저장
			// 게시물등록및 파일 첨부
			res = service.insertSelectKey(board, files);
			String msg = "";
			
			if(res > 0) {
				
				msg = board.getB_NO() + "번 등록되었습니다";
				// url?msg=등록 (쿼리스트링으로 전달 -> param.msg)
				//rttr.addAttribute("msg", msg);
				
				// 세션영역에 저장 -> msg
				// 새로고침시 유지되지 않음
				rttr.addFlashAttribute("msg", msg);
				
				return "redirect:/recipe1/rec_write";
				
			} else {
				msg = "등록중 예외사항이 발생 하였습니다11.";
				model.addAttribute("msg", msg);
				return "/recipe/message";
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage().indexOf("첨부파일")>-1) {
				model.addAttribute("msg", e.getMessage());
			} else {
				model.addAttribute("msg", "등록중 예외사항이 발생 하였습니다222.");
			}
			
			return "/recipe/message";
		}
		
	}
	
	// ===========================================================================
	
	
	
	@PostMapping("/postWrite")
	public String writeAction(RecBoardVO board, List<MultipartFile> files,
	        RedirectAttributes rttr, Model model) {
	    try {
	        // 게시물 등록 및 파일 첨부
	        int res = service.insertSelectKey(board, files);

	        // 레시피 등록에 성공했을 경우
	        if (res > 0) {
	            String msg = board.getB_NO() + "번 레시피가 등록되었습니다.";
	            rttr.addFlashAttribute("msg", msg);

	            // 레시피 등록 후 해당 C_NO 값을 CategoryVO에 설정
	            CategoryVO categoryVO = new CategoryVO();
	            categoryVO.setC_NO(board.getC_NO()); // rec_board 테이블의 C_NO를 categoryVO에 저장

	            // 레시피 카테고리 등록
	            cateservice.insert(categoryVO);

	            return "redirect:/recipe1/rec_write";
	        } else {
	            model.addAttribute("msg", "레시피 등록 중 오류가 발생하였습니다111.");
	            return "/recipe/message";
	        }

	    } catch (Exception e) {
	        log.info(e.getMessage());
	        if (e.getMessage().indexOf("첨부파일") > -1) {
	            model.addAttribute("msg", e.getMessage());
	        } else {
	            model.addAttribute("msg", "레시피 등록 중 오류가 발생하였습니다222.");
	        }

	        return "/recipe/message";
	    }
	}
	
	
	
	
	// =========================================================================
	
	
	@GetMapping("/rec_view")
	public String res_view() {
		return"/recipe/view";
	}
	
	
	// 카테고리 --------------------------
	
	@GetMapping("/category")
	public String category() {
		return"/recipe/cate_write";
	}
	
	@PostMapping("/cateWrite")
    public String cateWriteAction(CategoryVO vo, Model model) {
        try {
            int res = cateservice.insert(vo);
            if (res > 0) {
                String msg = vo.getC_NO() + "번 등록되었습니다";
                model.addAttribute("msg", msg);
                return "redirect:/recipe1/category";
            } else {
                String msg = "등록중 예외사항이 발생하였습니다11.";
                model.addAttribute("msg", msg);
                return "/recipe/message";
            }	
        } catch (Exception e) {
            String msg = "등록중 예외사항이 발생하였습니다22.";
            model.addAttribute("msg", msg);
            return "/recipe/message";
        }
    }
	
	
}

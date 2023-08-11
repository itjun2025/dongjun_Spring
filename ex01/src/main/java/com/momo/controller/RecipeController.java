package com.momo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.momo.service.CateService;
import com.momo.service.RecBoardService;
import com.momo.service.RecFileService;
import com.momo.service.RecMatService;
import com.momo.service.RecStepService;
import com.momo.vo.CategoryVO;
import com.momo.vo.RecBoardVO;
import com.momo.vo.RecMatVO;
import com.momo.vo.RecStepVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/recipe1/*")
@Log4j
public class RecipeController {
	
	@Autowired
	RecBoardService recservice;
	
	@Autowired
	CateService cateservice;
	
	@Autowired
	RecFileService fileservice;
	
	
	@Autowired
	RecMatService matservice;
	
	@Autowired
	RecStepService stepservice;
	
	
	
	
	
	@GetMapping("/list")
	public String listTest() {
		System.out.println("dddd");
		return "/recipe/rec_list";
	}
	
	@GetMapping("/rec_write")
	public String recWrite() {
		
		
		
		return "/recipe/rec_write";
	}
	
	
	@GetMapping("msg")
	public void msg() {
		
	}
	
	@GetMapping("message")
	public void message(Model model) {
		
	}
	
	
	
	@PostMapping("/postWrite")
    public String postWrite(RecBoardVO recBoardVO, CategoryVO catevo 
    						, RecMatVO matvo, RecStepVO stepvo 
    						,  @RequestParam("photos") List<MultipartFile> photos
    						, Model model) {
        try {
            // rec_board에 레시피 정보 등록
            int res = recservice.insertSelectKey(recBoardVO, photos);
            int res2 = cateservice.insert(catevo);
            int res3 = matservice.insert(matvo);
            int res4 = stepservice.insert(stepvo);
            if (res > 0 && res2>0 && res3>0 && res4>0) {
                
                
                String msg = recBoardVO.getB_NO() + "번 등록되었습니다";	
                model.addAttribute("msg", msg);
                return "redirect:/recipe1/list";
            } else {
                String msg = "등록 중 예외사항이 발생하였습니다.11";
                model.addAttribute("msg", msg);
                return "/recipe/message";
            }
        } catch (Exception e) {
            String msg = "등록 중 예외사항이 발생하였습니다.22";
            model.addAttribute("msg", msg);
            return "/recipe/message";
        }
    }
	
	
	
	
	
	
	
	@GetMapping("/rec_view")
	public String res_view() {
		return"/recipe/view";
	}
	
	
	// 카테고리  test --------------------------
	
//	@GetMapping("/category")
//	public String category() {
//		return"/recipe/cate_write";
//	}
//	
//	
//	@PostMapping("/cateWrite")
//    public String cateWriteAction(CategoryVO vo, Model model) {
//        try {
//            int res = cateservice.insert(vo);
//            if (res > 0) {
//                String msg = vo.getC_NO() + "번 등록되었습니다";
//                model.addAttribute("msg", msg);
//                return "redirect:/recipe1/category";
//            } else {
//                String msg = "등록중 예외사항이 발생하였습니다11.";
//                model.addAttribute("msg", msg);
//                return "/recipe/message";
//            }	
//        } catch (Exception e) {
//            String msg = "등록중 예외사항이 발생하였습니다22.";
//            model.addAttribute("msg", msg);
//            return "/recipe/message";
//        }
//    }
	
	
}

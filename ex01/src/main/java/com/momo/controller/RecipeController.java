package com.momo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe1/*")
public class RecipeController {
	
	@GetMapping("/list")
	public String listTest() {
		System.out.println("dddd");
		return "/recipe/list";
	}
	
	@GetMapping("/write")
	public String resWrite() {
		return "/recipe/rec_write";
	}
	
	@GetMapping("/com_write")
	public String comWrite(){
		return"/recipe/com_write";
	}
	@GetMapping("/rec_view")
	public String res_view() {
		return"/recipe/view";
	}
	
}

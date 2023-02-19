package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	// localhost:8080/
	// localhost:8080
	
	@GetMapping({"","/"}) 
	public String index() {
		// 머스테치 기본폴더 위치는 리소스이다
		// 뷰리졸버 설정: 템플시(프리픽스), .머스테치는 서브픽스
		return "index";
	}
	
}


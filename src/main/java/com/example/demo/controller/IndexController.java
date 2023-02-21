package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class IndexController {
	
	// localhost:8080/
	// localhost:8080
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping({"", "/"}) 
	public String index() {
		// 머스테치 기본폴더 위치는 리소스이다
		// 뷰리졸버 설정: 템플시(프리픽스), .머스테치는 서브픽스
		return "index";
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		return "manager";
	}
	
	// 스프링시큐리티 해당 주소를 낚아채는데 - securityconfig 파일 생성 후 작동 안함
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}	
	
	@PostMapping("/join")
	public String join(User user) {
		System.out.println(user);
		user.setRole("ROLE_USER");
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user); // 회원가입 잘됨. 비밀번호:1234 -> 시큐리티로 로그인을 할 수 없음. 패스워드가 암호화가 안되어있기 때문
		return "redirect:/loginForm";
	}
	
}


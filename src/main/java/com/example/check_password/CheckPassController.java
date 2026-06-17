package com.example.check_password;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckPassController {

	private static final String VALID_PASSWORD = "1234";

	@GetMapping("/check-password") 
	@ResponseBody
	public String passwordForm() {
		return """
				<html>
				<head><meta charset=\"UTF-8\"><title>비밀번호 확인</title></head>
				<body>
					<h1>비밀번호 확인</h1>
					<form method=\"post\" action=\"/check-password\">
						<input type=\"password\" name=\"password\" placeholder=\"비밀번호 입력\" required>
						<button type=\"submit\">검증</button>
					</form>
				</body>
				</html>
				""";
	}

	@PostMapping("/check-password")
	@ResponseBody
	public String checkPassword(@RequestParam("password") String password) {
		if (VALID_PASSWORD.equals(password)) {
			return "패스워드 검증되었음";
		}
		return "패스워드가 올바르지 않습니다.";
	}
}

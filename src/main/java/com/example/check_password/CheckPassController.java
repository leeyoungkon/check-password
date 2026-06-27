package com.example.check_password;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckPassController {  //temp

	private static final String VALID_PASSWORD = "1234";

	@GetMapping("/check-password") 
	@ResponseBody
	public String passwordForm() {
		return """
				<html>
				<head><meta charset=\"UTF-8\"><title>Password Check</title></head>
				<body>
					<h1>Password Check</h1>
					<form method=\"post\" action=\"/check-password\">
						<input type=\"password\" name=\"password\" placeholder=\"Enter password\" required>
						<button type=\"submit\">Verify</button>
					</form>
				</body>
				</html>
				""";
	}

	@PostMapping("/check-password")
	@ResponseBody
	public String checkPassword(@RequestParam("password") String password) {
		if (VALID_PASSWORD.equals(password)) {
			return "Password is valid.";
		}
		return "Password is incorrect.";
	} //CAM 1 test
}

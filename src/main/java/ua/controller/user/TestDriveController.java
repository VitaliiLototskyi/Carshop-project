package ua.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestDriveController {
	@RequestMapping("/testDrive")
	public String testDrive() {
		return "user-testDrive";
	}
	
	@RequestMapping(value="/redirect")
	public String redirect(){
		return "user-index";
	}
	
	
	
}

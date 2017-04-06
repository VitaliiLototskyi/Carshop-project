package ua.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Contacts {
	@RequestMapping("/contacts")
	public String contacts() {
		return "user-contacts";
	}
}

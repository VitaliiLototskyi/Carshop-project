package ua.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.Car;
import ua.service.CarService;
import ua.service.UserService;

@Controller
public class Thx {
	@Autowired
	private UserService userService;
	@Autowired
	private CarService carService;

	@RequestMapping("/thx")
	public String contacts(Principal principal) {
		return "user-thx";
	}

	@RequestMapping(value = "/ordernow/{id}")
	public String ordernow(@PathVariable(value = "id") int id,
			Principal principal) {
		Car cars = carService.findOne(id);
		String car = "Your order: " +" \n"+"\n" + cars.getName()+" "
				+ cars.getModel().getName() + ", price: "
				+ cars.getModel().getPrice()+"€" + " \n"
				+"Year: "+ cars.getYear()+" \n"
				+"Body type: "+cars.getBodyStyle()+ " \n"
				+"Fuel type: "+cars.getModel().getEngine().getEngineType() +" \n"
				+"Engine: "+ cars.getModel().getEngine().getSweptVolume()+ " \n"
				+"Gearbox type: "+ cars.getGearBox().getGearType()+ " \n"
				+"Color: "+cars.getColor().getColor()+"\n";
				
		String shop = car + ". \n"
				+ "Thank you, we'll contact you soon!";
		userService.sendMail("Car order",
				userService.findByUsername(principal.getName()).getEmail(),
				shop);
		return "redirect:/thx/";
	}

}

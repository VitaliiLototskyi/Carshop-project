package ua.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import ua.entity.Country;
import ua.entity.Producer;
import ua.service.CountryService;

@Controller
@RequestMapping("/admin/country")
@SessionAttributes(names="country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("countries", countryService.findAll());
		return "admin-country";
	}
	@ModelAttribute("country")
	public Country getForm(){
		return new Country();
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		countryService.delete(id);
		return "redirect:/admin/country";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("country", countryService.findOne(id));
		model.addAttribute("countries", countryService.findAll());
		return "admin-country";
	}

	// ������� �� �� ����� POST (��������� ������)
	@RequestMapping(method = POST)
	// ������� �� � ���������� ���� �������� name
	public String save(@ModelAttribute("country")Country form, SessionStatus status) {
		// �������� � ����� ��� ����������
		// ��'���� Category
		
		countryService.save(form);
		// ���� ���� ������ � ������� �������
		// ������� ������ �������, ��� ��������
		// �������� �������� �����
		// ���� �������� �� ��������� ������ �������
		status.setComplete();
		return "redirect:/admin/country";
	}
}

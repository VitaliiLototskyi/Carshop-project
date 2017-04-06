package ua.controller.admin;
import static ua.service.utils.ParamBuilder.getParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.mail.Session;

import ua.dto.filter.BasicFilter;
import ua.editor.CountryEditor;
import ua.entity.Country;
import ua.entity.Producer;
import ua.service.CountryService;
import ua.service.ProducerService;
import ua.validator.ProducerValidator;
import static ua.service.utils.ParamBuilder.getParams;
@Controller
@RequestMapping("/admin/producer")
@SessionAttributes(names = "producer")
public class ProducerController {
	@Autowired
	private CountryService countryService;

	@Autowired
	private ProducerService producerService;

	@ModelAttribute("producer")
	public Producer getForm() {
		return new Producer();
	}
	@InitBinder("producer")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.setValidator(new ProducerValidator(producerService));
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}

	@RequestMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", producerService.findAll(filter, pageable));
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "admin-producer";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		producerService.delete(id);
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("producer", producerService.findOne(id));
		model.addAttribute("page", producerService.findAll(filter, pageable));
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "admin-producer";
	}

	@RequestMapping(method = POST)
	public String save(@ModelAttribute("producer") Producer form,BindingResult br,Model model, SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		if(br.hasErrors()){
			model.addAttribute("page", producerService.findAll(filter, pageable));
			return "admin-category";
		}
		producerService.save(form);
		status.setComplete();
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}
}

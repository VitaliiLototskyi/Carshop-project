package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;

import ua.dto.form.ModelForm;
import ua.editor.EngineEditor;
import ua.editor.ProducerEditor;
import ua.entity.Engine;
//import ua.entity.Model;
import ua.entity.Producer;
import ua.service.EngineService;
import ua.service.ModelService;
import ua.service.ProducerService;
import ua.validator.ModelValidator;

@Controller
@RequestMapping("/admin/model")
@SessionAttributes(names = "model")
public class ModelController {
	@Autowired
	private ProducerService producerService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private EngineService engineService;

	@ModelAttribute("model")
	public ModelForm getForm() {
		return new ModelForm();
	}

	@InitBinder("model")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(Engine.class, new EngineEditor(
				engineService));
		binder.setValidator(new ModelValidator());
	}
	@RequestMapping
	public String show (Model model){
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("engines", engineService.findAll());
		return "admin-model";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		modelService.delete(id);
		return "redirect:/admin/model";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("model", modelService.findForm(id));
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("engines", engineService.findAll());
		return "admin-model";
	}
	@RequestMapping(method = POST)
	public String save(@ModelAttribute("model") @Valid ModelForm form,BindingResult br,Model model, SessionStatus status) {
		if(br.hasErrors()){
			return "admin-model";
		}
		modelService.save(form);
		status.setComplete();
		return "redirect:/admin/model";
	}
}

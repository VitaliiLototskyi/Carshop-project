package ua.controller.admin;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.dto.form.EngineForm;
import ua.editor.EngineTypeEditor;
import ua.entity.Engine;
import ua.entity.EngineType;
import ua.entity.GearBox;
import ua.entity.GearType;
import ua.service.EngineService;
import ua.validator.EngineValidator;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Controller
@RequestMapping("/admin/engine")
@SessionAttributes(names="engine")
public class EngineController {
	@Autowired
	private EngineService engineService;
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("engines", engineService.findAll());
		model.addAttribute("engineTypes", EngineType.values());
		return "admin-engine";
	}
	@InitBinder("engine")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(EngineType.class, new EngineTypeEditor());
	   binder.setValidator(new EngineValidator());
	}
	@ModelAttribute("engine")
	public EngineForm getForm() {
		return new EngineForm();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		engineService.delete(id);
		return "redirect:/admin/engine";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("engine", engineService.findForm(id));
		model.addAttribute("engines", engineService.findAll());
		model.addAttribute("engineTypes", EngineType.values());
		return "admin-engine";
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("engine") @Valid EngineForm form,BindingResult br,Model model, SessionStatus status){
		if(br.hasErrors()){
			return "admin-engine";
		}
		engineService.save(form);
		return "redirect:/admin/engine";
	}
}

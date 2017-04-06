package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

import ua.dto.form.GearBoxForm;
import ua.editor.EngineTypeEditor;
import ua.editor.GearTypeEditor;
import ua.entity.Engine;
import ua.entity.EngineType;
import ua.entity.GearBox;
import ua.entity.GearType;
import ua.entity.Producer;
import ua.service.GearBoxService;
import ua.validator.GearBoxValidator;

@Controller
@RequestMapping("/admin/gearBox")
@SessionAttributes(names = "gearBox")
public class GearBoxController {
	@Autowired
	private GearBoxService gearBoxService;;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("gearBoxes", gearBoxService.findAll());
		model.addAttribute("gearTypes", GearType.values());
		return "admin-gearBox";
	}
	@InitBinder("gearBox")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(GearType.class, new GearTypeEditor());
	   binder.setValidator(new GearBoxValidator());
	}
	@ModelAttribute("gearBox")
	public GearBoxForm getForm() {
		return new GearBoxForm();
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		gearBoxService.delete(id);
		System.out.println(System.getProperty("catalaina.home"));
		return "redirect:/admin/gearBox";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("gearBox", gearBoxService.findForm(id));
		model.addAttribute("gearBoxes", gearBoxService.findAll());
		model.addAttribute("gearTypes", GearType.values());
		return "admin-gearBox";
	}

	@RequestMapping(method = POST)
	public String save(@ModelAttribute("gearBox") @Valid GearBoxForm form,BindingResult br,Model model, SessionStatus status) {
		if(br.hasErrors()){
			return "admin-gearBox";
		}
		gearBoxService.save(form);
		return "redirect:/admin/gearBox";
	}
}

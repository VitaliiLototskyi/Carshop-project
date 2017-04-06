package ua.controller.admin;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.service.utils.ParamBuilder.getParams;


import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.CarFilter;
import ua.dto.form.CarForm;
import ua.editor.BodyStyleEditor;
import ua.editor.ColorEditor;
import ua.editor.GearBoxEditor;
import ua.editor.ModelEditor;
import ua.entity.BodyStyle;
import ua.entity.Color;
import ua.entity.GearBox;
import ua.service.CarService;
import ua.service.ColorService;
import ua.service.GearBoxService;
import ua.service.ModelService;
import ua.service.ProducerService;
import ua.validator.CarValidator;

@Controller
@RequestMapping("/admin/car")
@SessionAttributes(names = "car")
public class CarController {
	@Autowired
	private CarService carService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private GearBoxService gearBoxService;
	@Autowired
	private ProducerService producerService;

	@ModelAttribute("car")
	public CarForm getForm() {
		return new CarForm();
	}
	@ModelAttribute("filter")
	public CarFilter getFilter(){
		return new CarFilter();
	}

	@InitBinder("car")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ua.entity.Model.class, new ModelEditor(modelService));
		binder.registerCustomEditor(GearBox.class, new GearBoxEditor(gearBoxService));
		binder.registerCustomEditor(BodyStyle.class, new BodyStyleEditor());
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.setValidator(new CarValidator());
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") CarFilter filter){
		model.addAttribute("page", carService.findAll(filter, pageable));
		model.addAttribute("cars", carService.findAll());
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("gearBoxes", gearBoxService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("bodyStyles", BodyStyle.values());
		model.addAttribute("producers", producerService.findAll());
		return "admin-car";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") CarFilter filter) {
		carService.delete(id);
		return "redirect:/admin/car"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") CarFilter filter) {
		model.addAttribute("car", carService.findForm(id));
		model.addAttribute("cars", carService.findAll());
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("gearBoxes", gearBoxService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("bodyStyles", BodyStyle.values());
		model.addAttribute("page", carService.findAll(filter, pageable));
		model.addAttribute("producers", producerService.findAll());
		return "admin-car";
	}

	@RequestMapping(method = POST)
	public String save(@ModelAttribute("car") @Valid CarForm carForm,BindingResult br,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") CarFilter filter) {
		if(br.hasErrors()){
			model.addAttribute("cars", carService.findAll());
			model.addAttribute("models", modelService.findAll());
			model.addAttribute("gearBoxes", gearBoxService.findAll());
			model.addAttribute("bodyStyles", BodyStyle.values());
			model.addAttribute("colors", colorService.findAll());
			model.addAttribute("page", carService.findAll(filter, pageable));
			return "admin-car";
		}
		carService.save(carForm);
		status.setComplete();
		return "redirect:/admin/car"+getParams(pageable, filter);
	}

}
package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Color;
import ua.service.ColorService;

public class ColorEditor extends PropertyEditorSupport{
	private final ColorService service;
	
	public ColorEditor(ColorService service){
		this.service = service;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		Color ss = service.findOne(Integer.valueOf(text));
		setValue(ss);
	}
}

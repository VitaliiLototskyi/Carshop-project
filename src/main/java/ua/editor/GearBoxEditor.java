package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.GearBox;
import ua.service.GearBoxService;

public class GearBoxEditor extends PropertyEditorSupport {
	private final GearBoxService service;

	public GearBoxEditor(GearBoxService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		GearBox ss = service.findOne(Integer.valueOf(text));
		setValue(ss);
	}
}

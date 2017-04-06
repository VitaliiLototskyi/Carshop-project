package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Model;
import ua.service.ModelService;

public class ModelEditor extends PropertyEditorSupport {
	private final ModelService service;

	public ModelEditor(ModelService service) {
		this.service = service;

	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Model ss = service.findOne(Integer.valueOf(text));
		setValue(ss);
	}
}

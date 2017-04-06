package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Engine;
import ua.service.EngineService;

public class EngineEditor extends PropertyEditorSupport {
	public final EngineService service;

	public EngineEditor(EngineService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Engine ss = service.findOne(Integer.valueOf(text));
		setValue(ss);
	}
}

package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.EngineType;

public class EngineTypeEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(EngineType.valueOf(text));
	}
}

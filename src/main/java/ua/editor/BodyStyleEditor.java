package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BodyStyle;

public class BodyStyleEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(BodyStyle.valueOf(text));
	}

}

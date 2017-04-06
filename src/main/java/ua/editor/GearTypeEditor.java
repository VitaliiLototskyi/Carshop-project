package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.GearType;

public class GearTypeEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(GearType.valueOf(text));
	}
}

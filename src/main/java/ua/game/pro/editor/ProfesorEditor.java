package ua.game.pro.editor;

import java.beans.PropertyEditorSupport;

import ua.game.pro.service.ProfesorService;


public class ProfesorEditor extends PropertyEditorSupport{

	private final ProfesorService profesorService;
	
	public ProfesorEditor(ProfesorService profesorService) {
		super();
		this.profesorService=profesorService;
	}
	
	
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(profesorService.findOne(Integer.parseInt(text)));
	}

}

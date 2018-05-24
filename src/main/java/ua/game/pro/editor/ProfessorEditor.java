package ua.game.pro.editor;

import ua.game.pro.service.ProfessorService;

import java.beans.PropertyEditorSupport;


public class ProfessorEditor extends PropertyEditorSupport {

    private final ProfessorService professorService;

    public ProfessorEditor(ProfessorService professorService) {
        super();
        this.professorService = professorService;
    }


    public void setAsText(String text) throws IllegalArgumentException {
        setValue(professorService.findOne(Integer.parseInt(text)));
    }

}

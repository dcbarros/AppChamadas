package br.com.professor.view.components;

public class MenuItem {
    private final Integer OPTION;
    private final String OPTIONTEXT;

    public MenuItem(Integer oPTION, String oPTIONTEXT) {
        OPTION = oPTION;
        OPTIONTEXT = oPTIONTEXT;
    }

    public Integer getOPTION() {
        return OPTION;
    }

    public String getOPTIONTEXT() {
        return OPTIONTEXT;
    }
    
}

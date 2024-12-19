package com.travelagency.NotificationModule;
import java.util.ArrayList;
public class TemplateText {
    public ArrayList<Language> languages;
    private String templateText;
    private String templateName;
    private int placeholdersNum;
    TemplateText(String templateText, String templateName){
        this.templateText = templateText;
        this.templateName = templateName;
    }
    public String getTemplateName() {
        return templateName;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public String getTemplateText() {
        return templateText;
    }
    public int getPlaceholdersNum() {
        return placeholdersNum;
    }
    public void setPlaceholdersNum(int placeholdersNum) {
        this.placeholdersNum = placeholdersNum;
    }
    public String getTemplateText(String argumentlanguageName){
        boolean isfound = false;
        String a = "";
        for(Language langauge : languages){
            String languageName = langauge.getLanguageName();
            if(languageName.equals(argumentlanguageName)){
                isfound = true;
                a = langauge.getText();
            }
        }
        if(isfound)return a;
        return templateText;
    }
    public void addLanguage(Language language) {
        languages.add(language);
    }
    public void setTemplateText(String templateText) {
        this.templateText = templateText;
    }
}
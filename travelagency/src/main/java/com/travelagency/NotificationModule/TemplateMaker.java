package com.travelagency.NotificationModule;
import java.util.ArrayList;
public class TemplateMaker {
    protected TemplateText template;
    TemplateMaker(TemplateText TemplateText){
        this.template = TemplateText;
    }
    public String useTemplate(ArrayList<String> placeHolders){
        TemplateText templateChosen = template;
        String templateString = templateChosen.getTemplateText();
        int i = 0;
        while(templateString.contains("{x}")){
            templateString.replaceFirst("{x}", placeHolders.get(i));
            i++;
        }
        return templateString;
    }
    public void setTemplate(TemplateText template){
        this .template = template;
    }
    public boolean isValid(ArrayList<String> placeHolders){
        if(placeHolders.size() == template.getPlaceholdersNum())return true;
        return false;
    }
    public TemplateText getTemplate() {
        return template;
    }
}

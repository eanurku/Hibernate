package com.propertyeditors;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String name) throws IllegalArgumentException {
        if(name.contains("Mr.")||name.contains("Ms.")){
            setValue(name);
        }else{

            setValue("Ms. "+name);
        }
    }

}

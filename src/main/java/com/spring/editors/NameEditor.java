package com.spring.editors;


import com.spring.model.Name;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * In case a new PropertyEditor is needed,
 * it is best to create one by extending PropertyEditorSupport and overriding the desired methods with custom implementation.
 */

public class NameEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null){
            setValue(null);
        }
        else {
            String value = text.trim();
            if (!StringUtils.isEmpty(value)){
                setValue(Name.parseName(value));
            }else {
                setValue(null);
            }
        }
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return (value != null ? value.toString() : "");
    }
}

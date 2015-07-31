package com.dellkan.john.robobindingtests.viewattributes;

import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;

import org.robobinding.util.PrimitiveTypeUtils;
import org.robobinding.viewattribute.property.OneWayMultiTypePropertyViewAttribute;
import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

public class TextInputLayoutErrorAttribute implements OneWayMultiTypePropertyViewAttribute<TextInputLayout> {
    @Override
    public OneWayPropertyViewAttribute<TextInputLayout, ?> create(TextInputLayout view, Class<?> propertyType) {
        if (PrimitiveTypeUtils.integerIsAssignableFrom(propertyType)) {
            return new ResourceIdErrorAttribute();
        } else if (String.class.isAssignableFrom(propertyType)) {
            return new StringErrorAttribute();
        }

        return null;
    }

    public static class ResourceIdErrorAttribute implements OneWayPropertyViewAttribute<TextInputLayout, Integer> {
        @Override
        public void updateView(TextInputLayout textInputLayout, Integer newValue) {
            try {
                String text = textInputLayout.getContext().getString(newValue);
                if (TextUtils.isEmpty(text)) {
                    textInputLayout.setErrorEnabled(false);
                } else {
                    textInputLayout.setError(text);
                }
            } catch (Resources.NotFoundException e) {
                textInputLayout.setErrorEnabled(false);
            }
        }
    }

    public static class StringErrorAttribute implements OneWayPropertyViewAttribute<TextInputLayout, String> {
        @Override
        public void updateView(TextInputLayout textInputLayout, String newValue) {
            if (TextUtils.isEmpty(newValue)) {
                textInputLayout.setErrorEnabled(false);
            } else {
                textInputLayout.setError(newValue);
            }
        }
    }
}

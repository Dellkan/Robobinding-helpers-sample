package com.dellkan.john.robobindingtests.models;

import com.dellkan.robobinding.helpers.modelgen.ItemPresentationModel;

@ItemPresentationModel
public class ItemTest {
    protected String spinnertext;

    public ItemTest(String test) {
        this.spinnertext = test;
    }

    public String getSpinnertext() {
        return spinnertext;
    }
}

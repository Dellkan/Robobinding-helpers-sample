package com.dellkan.john.robobindingtests.models;

import com.dellkan.robobinding.helpers.modelgen.GetSet;
import com.dellkan.robobinding.helpers.modelgen.ItemPresentationModel;

@ItemPresentationModel
public class ItemTest2 {
    @GetSet
    protected String text;

    public ItemTest2(String text) {
        this.text = text;
    }
}

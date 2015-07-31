package com.dellkan.john.robobindingtests.models;

import com.dellkan.john.robobindingtests.R;
import com.dellkan.robobinding.helpers.model.Wrapper;
import com.dellkan.robobinding.helpers.modelgen.GetSet;
import com.dellkan.robobinding.helpers.modelgen.PresentationModel;
import com.dellkan.robobinding.helpers.validation.ComparisonTypes;
import com.dellkan.robobinding.helpers.validation.ValidateLength;

@PresentationModel
public class Test2 extends Wrapper {
    @ValidateLength(min=11)
    @GetSet
    public String text = "";

    @ValidateLength(comparison = ComparisonTypes.EXACTLY, min=50, error = R.string.invalid)
    @GetSet(dependsOn = {"text"})
    public int number;

    @GetSet
    public boolean more;

    @ValidateLength(comparison = ComparisonTypes.LENGTH_RANGE_INCLUDING, min = 2, max = 12, error = R.string.invalid)
    @GetSet
    public String text2 = "";
}

package com.dellkan.john.robobindingtests.models;

import com.dellkan.john.robobindingtests.R;
import com.dellkan.john.robobindingtests.Validation.ComparisonTypes;
import com.dellkan.john.robobindingtests.Validation.validators.ValidateLength;
import com.dellkan.john.robobindingtests.Validation.validators.ValidatePattern;
import com.dellkan.robobinding.helpers.model.ListItem;
import com.dellkan.robobinding.helpers.model.PresentationModelWrapper;
import com.dellkan.robobinding.helpers.modelgen.DependsOnStateOf;
import com.dellkan.robobinding.helpers.modelgen.GetSet;
import com.dellkan.robobinding.helpers.modelgen.ListItems;
import com.dellkan.robobinding.helpers.modelgen.PresentationModel;

import java.util.ArrayList;
import java.util.List;

@PresentationModel
public class Test2 extends PresentationModelWrapper {
    @ValidateLength(min=11, error = R.string.abc_action_bar_home_description)
    @GetSet
    public String text;

    @ValidateLength(comparison = ComparisonTypes.EXACTLY, min=50, error = R.string.invalid)
    @GetSet(dependsOn = {"text"})
    public Integer number;

    @GetSet
    public boolean more;

    public boolean isMore() {
        return more;
    }

    @ValidateLength(comparison = ComparisonTypes.RANGE_INCLUDING, min = 2, max = 12, error = R.string.invalid)
    @GetSet
    public float text2;

    @ValidatePattern("test")
    @GetSet()
    public String test3 = "";

    @ListItems()
    protected ListItem<ItemTest> testList = new ListItem<>();

    @ListItems()
    protected ListItem<ItemTest2> testList2 = new ListItem<>();

    @DependsOnStateOf("testListSelected")
    public boolean getGoodItemFromSpinnerSelected() {
        if (testList.getSelectedItem() != null) {
            return testList.getSelectedItem().getSpinnertext().contains("1");
        }
        return false;
    }

    public int test() {
        return 1;
    }

    public Test2() {
        testList.addItem(new ItemTest("test1"));
        testList.addItem(new ItemTest("test2"));
        testList.addItem(new ItemTest("test3"));
        testList.addItem(new ItemTest("test4"));
        testList.addItem(new ItemTest("test5"));

        testList2.addItem(new ItemTest2("test1"));
        testList2.addItem(new ItemTest2("test2"));
        testList2.addItem(new ItemTest2("test3"));
        testList2.addItem(new ItemTest2("test4"));
        testList2.addItem(new ItemTest2("test5"));
    }
}

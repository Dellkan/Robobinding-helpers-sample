package com.dellkan.john.robobindingtests.models;

import android.util.Log;

import com.dellkan.john.robobindingtests.R;
import com.dellkan.john.robobindingtests.Validation.ComparisonTypes;
import com.dellkan.john.robobindingtests.Validation.validators.ValidateLength;
import com.dellkan.john.robobindingtests.Validation.validators.ValidatePattern;
import com.dellkan.robobinding.helpers.model.Wrapper;
import com.dellkan.robobinding.helpers.modelgen.GetSet;
import com.dellkan.robobinding.helpers.modelgen.ItemPresentationModel;
import com.dellkan.robobinding.helpers.modelgen.PresentationModel;

import org.robobinding.itempresentationmodel.ItemContext;

import java.util.ArrayList;
import java.util.List;

@PresentationModel
public class Test2 extends Wrapper {
    @ValidateLength(min=11, error = R.string.abc_action_bar_home_description)
    @GetSet
    public String text;

    @ValidateLength(comparison = ComparisonTypes.EXACTLY, min=50, error = R.string.invalid)
    @GetSet(dependsOn = {"text"})
    public Integer number;

    @GetSet
    public boolean more;

    @ValidateLength(comparison = ComparisonTypes.RANGE_INCLUDING, min = 2, max = 12, error = R.string.invalid)
    @GetSet
    public float text2;

    @ValidatePattern("test")
    @GetSet()
    public String test3 = "";

    public void test() {
        try {
            ValidateLength annotation = (ValidateLength) this.getClass().getDeclaredField("test").getClass().getAnnotation(ValidateLength.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void onSpinnerItemSelected() {
        Log.e("test", "test");
    }

    @ItemPresentationModel()
    protected List<Test> testList = new ArrayList<>();

    public List<Test> getTestData() {
        if (testList.isEmpty()) {
            testList.add(new Test("Test"));
            testList.add(new Test("Test2"));
            testList.add(new Test("Test3"));
            testList.add(new Test("Test4"));
        }
        return testList;
    }

    @PresentationModel
    public static class Test implements org.robobinding.itempresentationmodel.ItemPresentationModel<Test> {
        @GetSet
        private String text;

        public Test(String text) {
            this.text = text;
        }

        @Override
        public void updateData(Test test, ItemContext itemContext) {
            this.text = test.text;
        }
    }
}

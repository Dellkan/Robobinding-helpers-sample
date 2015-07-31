package com.dellkan.john.robobindingtests.models;

import android.util.Log;

import org.robobinding.annotation.DependsOnStateOf;

public class Test {
    private String text = "";
    private int number;
    private boolean more;
    private String text2 = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @DependsOnStateOf("text")
    public String getTextError() {
        if (text.length() <= 5) {
            return "Minimum 5 characters";
        }
        return null;
    }

    public String getNumber() {
        return String.format("%d", number);
    }

    public void setNumber(String number) {
        try {
            this.number = Integer.valueOf(number);
        } catch (NumberFormatException e) {

        }
    }

    @DependsOnStateOf("number")
    public String getNumberError() {
        if (number <= 50) {
            return "Minimum 50";
        }
        return null;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean toggle) {
        more = toggle;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text) {
        text2 = text;
    }

    @DependsOnStateOf("text2")
    public String getText2Error() {
        if (text2.length() <= 2) {
            return "Minimum 5 characters";
        }
        return null;
    }

    public void onClick() {
        Log.d("Tag", "herpa derpa");
    }

    @DependsOnStateOf({"text", "number", "more", "text2"})
    public boolean isValid() {
        return text.length() > 5 && number > 50 && (!isMore() || text2.length() > 2);
    }
}

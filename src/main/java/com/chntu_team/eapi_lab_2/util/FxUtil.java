package com.chntu_team.eapi_lab_2.util;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextField;

import java.util.function.BiFunction;

public final class FxUtil {
    public static ChangeListener<String> makeFilter(TextField field, boolean numbersOnly, int maxLength) {
        return makeFilter(field, numbersOnly, maxLength, (o, n) -> n);
    }

    public static ChangeListener<String> makeFilter(TextField field,
                                              boolean numbersOnly,
                                              int maxLength,
                                              BiFunction<String, String, String> postHandle) {
        return (observable, oldValue, newValue) -> {
            String newVal = newValue;
            if (numbersOnly && !newVal.matches("\\d*"))
                newVal = newVal.replaceAll("[^\\d]", "");

            if (maxLength > 0 && newVal.length() > maxLength)
                newVal = newValue.substring(0, maxLength);

            field.setText(postHandle.apply(oldValue, newVal));
        };
    }
}

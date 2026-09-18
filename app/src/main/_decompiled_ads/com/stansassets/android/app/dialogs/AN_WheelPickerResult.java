package com.stansassets.android.app.dialogs;

import com.stansassets.core.templates.SA_Result;

/* JADX INFO: loaded from: classes4.dex */
public class AN_WheelPickerResult extends SA_Result {
    public AN_WheelPickerState m_State;
    public String m_Value;

    public AN_WheelPickerResult(String str, AN_WheelPickerState aN_WheelPickerState) {
        this.m_Value = str;
        this.m_State = aN_WheelPickerState;
    }

    public AN_WheelPickerResult(int i, String str) {
        super(i, str);
    }
}

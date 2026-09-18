package com.stansassets.android.app.dialogs;

import com.stansassets.core.templates.SA_Result;

/* JADX INFO: loaded from: classes4.dex */
public class AN_DatePickerResult extends SA_Result {
    public int m_day;
    public int m_month;
    public int m_year;

    public AN_DatePickerResult(int i, int i2, int i3) {
        this.m_year = i;
        this.m_month = i2;
        this.m_day = i3;
    }

    public AN_DatePickerResult(int i, String str) {
        super(i, str);
    }
}

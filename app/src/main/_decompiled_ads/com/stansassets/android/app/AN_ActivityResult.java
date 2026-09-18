package com.stansassets.android.app;

import android.content.Intent;
import com.stansassets.core.templates.SA_Result;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ActivityResult extends SA_Result {
    private String m_data;
    private int m_resultCode;

    public AN_ActivityResult(int i, Intent intent) {
        this.m_resultCode = i;
        if (intent != null) {
            this.m_data = intent.toString();
        }
    }
}

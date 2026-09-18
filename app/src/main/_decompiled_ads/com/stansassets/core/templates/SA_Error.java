package com.stansassets.core.templates;

/* JADX INFO: loaded from: classes4.dex */
public class SA_Error extends AN_Serialized {
    private int m_code;
    private String m_message;

    public SA_Error(int i) {
        this(i, "");
    }

    public SA_Error(int i, String str) {
        this.m_code = i;
        this.m_message = str;
    }

    public int getmCode() {
        return this.m_code;
    }

    public String getmMessage() {
        return this.m_message;
    }
}

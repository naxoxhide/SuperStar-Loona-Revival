package com.stansassets.core.templates;

/* JADX INFO: loaded from: classes4.dex */
public class SA_Result extends AN_Serialized {
    private SA_Error m_error;

    public SA_Result() {
        this.m_error = null;
    }

    public SA_Result(int i, String str) {
        this.m_error = null;
        this.m_error = new SA_Error(i, str);
    }

    public SA_Result(SA_Error sA_Error) {
        this.m_error = null;
        this.m_error = sA_Error;
    }

    public SA_Error getError() {
        return this.m_error;
    }

    public void setError(SA_Error sA_Error) {
        this.m_error = sA_Error;
    }

    public boolean HasError() {
        SA_Error sA_Error = this.m_error;
        return (sA_Error == null || sA_Error.getmMessage() == null || this.m_error.getmMessage().isEmpty()) ? false : true;
    }

    public boolean IsSucceeded() {
        return !HasError();
    }
}

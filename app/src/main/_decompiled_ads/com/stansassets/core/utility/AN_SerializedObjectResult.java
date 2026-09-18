package com.stansassets.core.utility;

import com.stansassets.core.templates.SA_Error;
import com.stansassets.core.templates.SA_Result;

/* JADX INFO: loaded from: classes4.dex */
public class AN_SerializedObjectResult extends SA_Result {
    private String m_ObjectJSON;

    public AN_SerializedObjectResult(SA_Error sA_Error) {
        super(sA_Error);
    }

    public AN_SerializedObjectResult(Object obj) {
        if (obj == null) {
            setError(new SA_Error(500, "Returned object is null"));
        }
        this.m_ObjectJSON = AN_UnityBridge.toJson(obj);
    }
}

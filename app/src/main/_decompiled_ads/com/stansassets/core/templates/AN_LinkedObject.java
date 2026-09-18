package com.stansassets.core.templates;

import com.stansassets.core.utility.AN_HashStorage;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_LinkedObject {
    private int m_HashCode;

    public AN_LinkedObject(Object obj) {
        this.m_HashCode = AN_HashStorage.add(obj);
    }

    public String toJson() {
        return AN_UnityBridge.toJson(this);
    }

    public Object getObject() {
        return AN_HashStorage.get(this.m_HashCode);
    }
}

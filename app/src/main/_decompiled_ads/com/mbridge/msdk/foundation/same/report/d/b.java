package com.mbridge.msdk.foundation.same.report.d;

import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;

/* JADX INFO: compiled from: ReportResponseHandler.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends f<String> {
    private static final String TAG = "b";

    public abstract void onFailed(String str);

    public abstract void onSuccess(String str);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onSuccess(k<String> kVar) {
        if (kVar != null) {
            onSuccess(kVar.a);
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        onFailed(com.mbridge.msdk.foundation.same.net.f.a.a(aVar));
    }
}

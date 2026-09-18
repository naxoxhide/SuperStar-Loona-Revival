package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public final com.fyber.inneractive.sdk.model.vast.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1355b;
    public com.fyber.inneractive.sdk.flow.vast.e c;

    public static class a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1356b;

        public a(String str, int i) {
            this.a = str;
            this.f1356b = i;
        }
    }

    public b(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.g gVar, com.fyber.inneractive.sdk.config.global.s sVar, com.fyber.inneractive.sdk.model.vast.b bVar) {
        this.a = bVar;
    }

    public final void a(d.InterfaceC0308d interfaceC0308d, d dVar, String str) {
        if (interfaceC0308d != null) {
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.COULD_NOT_LOAD_FMP_ENDCARD_TO_WEBVIEW);
            if (!TextUtils.isEmpty(str)) {
                inneractiveInfrastructureError.setCause(new Exception(str));
            }
            interfaceC0308d.a(dVar, inneractiveInfrastructureError);
        }
    }

    public void a(com.fyber.inneractive.sdk.flow.vast.e eVar) {
        this.c = eVar;
    }
}

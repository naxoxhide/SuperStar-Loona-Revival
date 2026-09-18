package com.kakao.adfit.common.volley;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class AuthFailureError extends VolleyError {
    private Intent c;

    public AuthFailureError(com.kakao.adfit.m.d dVar) {
        super(dVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.c != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}

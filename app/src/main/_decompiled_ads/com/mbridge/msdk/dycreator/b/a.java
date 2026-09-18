package com.mbridge.msdk.dycreator.b;

/* JADX INFO: compiled from: DyError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1944b;

    public a(b bVar) {
        if (bVar != null) {
            this.a = bVar.a();
            this.f1944b = bVar.b();
        }
    }

    public a(int i, String str) {
        this.a = i;
        this.f1944b = str;
    }

    public final String toString() {
        return "DyError{errorCode=" + this.a + '}';
    }
}

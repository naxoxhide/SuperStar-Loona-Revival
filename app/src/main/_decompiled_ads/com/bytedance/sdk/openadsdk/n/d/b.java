package com.bytedance.sdk.openadsdk.n.d;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.m;

/* JADX INFO: compiled from: GifRequestResult.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f811b;
    private Bitmap c;

    public b(byte[] bArr, int i) {
        this.a = null;
        this.f811b = null;
        this.c = null;
        this.a = bArr;
    }

    public byte[] a() {
        try {
            if (this.a == null) {
                this.a = d.a(this.f811b);
            }
        } catch (OutOfMemoryError e) {
            m.b("GifRequestResult", e.getMessage());
        }
        return this.a;
    }

    public boolean b() {
        if (this.f811b != null) {
            return true;
        }
        byte[] bArr = this.a;
        return bArr != null && bArr.length > 0;
    }

    public Bitmap c() {
        return this.f811b;
    }

    public Bitmap d() {
        return this.c;
    }

    public b(Bitmap bitmap, Bitmap bitmap2, int i) {
        this.a = null;
        this.f811b = null;
        this.c = null;
        this.c = bitmap2;
        this.f811b = bitmap;
    }
}

package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ad, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0815Ad extends Thread {
    public final /* synthetic */ AudioTrack A00;
    public final /* synthetic */ XL A01;

    public C0815Ad(XL xl, AudioTrack audioTrack) {
        this.A01 = xl;
        this.A00 = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            try {
                this.A00.flush();
                this.A00.release();
            } finally {
                this.A01.A0f.open();
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}

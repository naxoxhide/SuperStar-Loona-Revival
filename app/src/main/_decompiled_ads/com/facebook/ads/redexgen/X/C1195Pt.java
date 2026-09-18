package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1195Pt implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C07336s A00;

    public C1195Pt(C07336s c07336s) {
        this.A00 = c07336s;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        new Handler(Looper.getMainLooper()).post(new K1(this, i));
    }
}

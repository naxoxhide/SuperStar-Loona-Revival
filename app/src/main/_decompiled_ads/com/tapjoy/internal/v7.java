package com.tapjoy.internal;

import android.media.MediaPlayer;
import com.tapjoy.TJAdUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class v7 implements MediaPlayer.OnSeekCompleteListener {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2827b;
    public final /* synthetic */ int c;
    public final /* synthetic */ TJAdUnit d;

    public v7(TJAdUnit tJAdUnit, int i, int i2, int i3) {
        this.d = tJAdUnit;
        this.a = i;
        this.f2827b = i2;
        this.c = i3;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        TJAdUnit tJAdUnit = this.d;
        tJAdUnit.a.removeCallbacks(tJAdUnit.G);
        this.d.e.onVideoReady(this.a, this.f2827b, this.c);
    }
}

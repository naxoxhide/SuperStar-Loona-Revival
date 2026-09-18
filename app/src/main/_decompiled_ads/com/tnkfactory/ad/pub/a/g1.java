package com.tnkfactory.ad.pub.a;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 implements MediaPlayer.OnBufferingUpdateListener {
    public final /* synthetic */ com.tnkfactory.ad.pub.e a;

    public g1(com.tnkfactory.ad.pub.e eVar) {
        this.a = eVar;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.a.getClass();
    }
}

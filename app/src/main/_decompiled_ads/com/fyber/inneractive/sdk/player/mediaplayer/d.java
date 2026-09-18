package com.fyber.inneractive.sdk.player.mediaplayer;

import android.media.AudioManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable {
    public final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.a;
        String strC = aVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        AudioManager audioManager = (AudioManager) aVar.a.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f = streamVolume / streamMaxVolume;
        IAlog.a("%s unmute maxVolume = %d currentVolume = %d targetVolume = %s", aVar.c(), Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
        if (f == 0.0f) {
            f = 0.1f;
        }
        aVar.setVolume(f, f);
        IAlog.d(strC + "timelog: " + CampaignEx.JSON_NATIVE_VIDEO_UNMUTE + " took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }
}

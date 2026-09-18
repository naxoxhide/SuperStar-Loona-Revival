package com.bytedance.sdk.openadsdk.core.i0;

import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.media.InteractionType;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import com.iab.omid.library.bytedance2.adsession.media.PlayerState;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;

/* JADX INFO: compiled from: ViewabilityTrackerForVideo.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends g {
    private final MediaEvents g;
    private boolean h;

    public i(AdSession adSession, AdEvents adEvents, View view, MediaEvents mediaEvents) {
        super(adSession, adEvents, view);
        this.g = mediaEvents;
    }

    @Override // com.bytedance.sdk.openadsdk.core.i0.g
    public void a(boolean z, float f) {
        if (z) {
            this.f = VastProperties.createVastPropertiesForSkippableMedia(f, true, Position.STANDALONE);
        } else {
            this.f = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        a(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.i0.g
    public void b(int i) {
        if (a()) {
            switch (i) {
                case 0:
                    this.g.pause();
                    break;
                case 1:
                    this.g.resume();
                    break;
                case 2:
                case 14:
                    this.g.skipped();
                    break;
                case 4:
                    this.g.bufferStart();
                    break;
                case 5:
                    this.g.bufferFinish();
                    break;
                case 6:
                    this.g.firstQuartile();
                    break;
                case 7:
                    this.g.midpoint();
                    break;
                case 8:
                    this.g.thirdQuartile();
                    break;
                case 9:
                    this.g.complete();
                    break;
                case 10:
                    this.g.playerStateChange(PlayerState.FULLSCREEN);
                    break;
                case 11:
                    this.g.playerStateChange(PlayerState.NORMAL);
                    break;
                case 12:
                    this.g.volumeChange(this.h ? 0.0f : 1.0f);
                    break;
                case 13:
                    this.g.adUserInteraction(InteractionType.CLICK);
                    break;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.i0.g
    public void a(float f, boolean z) {
        if (a()) {
            this.g.start(f, z ? 0.0f : 1.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.i0.g
    public void a(boolean z) {
        this.h = z;
        b(12);
    }
}

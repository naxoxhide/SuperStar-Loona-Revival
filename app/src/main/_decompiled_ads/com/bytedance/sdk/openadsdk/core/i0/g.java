package com.bytedance.sdk.openadsdk.core.i0;

import android.util.Pair;
import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;
import java.util.Set;

/* JADX INFO: compiled from: ViewabilityTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final AdSession a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdEvents f612b;
    private boolean c = false;
    protected boolean d = false;
    protected int e = 0;
    protected VastProperties f;

    public g(AdSession adSession, AdEvents adEvents, View view) {
        this.a = adSession;
        this.f612b = adEvents;
        adSession.getAdSessionId();
        a(view);
    }

    void a(float f, boolean z) {
    }

    void a(View view) {
        AdSession adSession;
        if (view == null || (adSession = this.a) == null) {
            return;
        }
        adSession.registerAdView(view);
    }

    public void a(boolean z) {
    }

    public void a(boolean z, float f) {
    }

    void b() {
        a(1);
    }

    void b(int i) {
    }

    void c() {
        a(4);
    }

    public void d() {
        a(3);
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.a;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
        }
    }

    boolean a() {
        return this.d;
    }

    public void a(int i) {
        int i2;
        int i3;
        if (this.a == null || this.f612b == null) {
            return;
        }
        boolean z = false;
        if (e.c()) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && (i3 = this.e) != 0 && i3 != 4) {
                            this.a.finish();
                            this.d = false;
                            z = true;
                        }
                    } else if (!this.c && ((i2 = this.e) == 1 || i2 == 2)) {
                        this.f612b.impressionOccurred();
                        this.c = true;
                        z = true;
                    }
                } else if (this.e == 0) {
                    this.a.start();
                    if (this.f == null) {
                        this.f = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                    }
                    this.f612b.loaded(this.f);
                    this.d = true;
                    this.f = null;
                    z = true;
                }
            } else if (this.e == 0) {
                this.a.start();
                this.f612b.loaded();
                this.d = true;
                z = true;
            }
        }
        if (z) {
            this.e = i;
        }
    }

    public void a(Set<Pair<View, FriendlyObstructionPurpose>> set) {
        for (Pair<View, FriendlyObstructionPurpose> pair : set) {
            a((View) pair.first, (FriendlyObstructionPurpose) pair.second);
        }
    }
}

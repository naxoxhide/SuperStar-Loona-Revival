package com.iab.omid.library.mmadbridge.internal;

import android.view.View;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private final com.iab.omid.library.mmadbridge.weakreference.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1467b;
    private final FriendlyObstructionPurpose c;
    private final String d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.a = new com.iab.omid.library.mmadbridge.weakreference.a(view);
        this.f1467b = view.getClass().getCanonicalName();
        this.c = friendlyObstructionPurpose;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public FriendlyObstructionPurpose b() {
        return this.c;
    }

    public com.iab.omid.library.mmadbridge.weakreference.a c() {
        return this.a;
    }

    public String d() {
        return this.f1467b;
    }
}

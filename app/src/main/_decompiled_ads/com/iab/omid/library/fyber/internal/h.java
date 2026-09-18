package com.iab.omid.library.fyber.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.fyber.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class h implements d.a, com.iab.omid.library.fyber.devicevolume.c {
    private static h f;
    private float a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.fyber.devicevolume.e f1446b;
    private final com.iab.omid.library.fyber.devicevolume.b c;
    private com.iab.omid.library.fyber.devicevolume.d d;
    private c e;

    public h(com.iab.omid.library.fyber.devicevolume.e eVar, com.iab.omid.library.fyber.devicevolume.b bVar) {
        this.f1446b = eVar;
        this.c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static h c() {
        if (f == null) {
            f = new h(new com.iab.omid.library.fyber.devicevolume.e(), new com.iab.omid.library.fyber.devicevolume.b());
        }
        return f;
    }

    @Override // com.iab.omid.library.fyber.devicevolume.c
    public void a(float f2) {
        this.a = f2;
        Iterator<com.iab.omid.library.fyber.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f2);
        }
    }

    public void a(Context context) {
        this.d = this.f1446b.a(new Handler(), context, this.c.a(), this);
    }

    @Override // com.iab.omid.library.fyber.internal.d.a
    public void a(boolean z) {
        if (z) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }

    public float b() {
        return this.a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.d.d();
    }
}

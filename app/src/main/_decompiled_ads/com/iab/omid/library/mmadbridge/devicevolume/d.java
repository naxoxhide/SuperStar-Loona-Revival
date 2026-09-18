package com.iab.omid.library.mmadbridge.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ContentObserver {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f1463b;
    private final a c;
    private final c d;
    private float e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.a = context;
        this.f1463b = (AudioManager) context.getSystemService("audio");
        this.c = aVar;
        this.d = cVar;
    }

    private float a() {
        return this.c.a(this.f1463b.getStreamVolume(3), this.f1463b.getStreamMaxVolume(3));
    }

    private boolean a(float f) {
        return f != this.e;
    }

    private void b() {
        this.d.a(this.e);
    }

    public void c() {
        this.e = a();
        b();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        float fA = a();
        if (a(fA)) {
            this.e = fA;
            b();
        }
    }
}

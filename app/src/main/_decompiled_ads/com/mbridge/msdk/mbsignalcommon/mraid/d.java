package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: MraidVolumeChangeReceiver.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static double a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2327b;
    private AudioManager c;
    private boolean d = false;
    private b e;
    private a f;

    /* JADX INFO: compiled from: MraidVolumeChangeReceiver.java */
    public interface b {
        void a(double d);
    }

    public d(Context context) {
        this.f2327b = context;
        this.c = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public final double a() {
        AudioManager audioManager = this.c;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.c;
        double streamVolume = (((double) (audioManager2 != null ? audioManager2.getStreamVolume(3) : -1)) * 100.0d) / ((double) streamMaxVolume);
        a = streamVolume;
        return streamVolume;
    }

    public final b b() {
        return this.e;
    }

    public final void a(b bVar) {
        this.e = bVar;
    }

    public final void c() {
        if (this.f2327b != null) {
            this.f = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f2327b.registerReceiver(this.f, intentFilter);
            this.d = true;
        }
    }

    public final void d() {
        Context context;
        if (!this.d || (context = this.f2327b) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f);
            this.e = null;
            this.d = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: MraidVolumeChangeReceiver.java */
    private static class a extends BroadcastReceiver {
        private WeakReference<d> a;

        public a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            d dVar;
            b bVarB;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (dVar = this.a.get()) == null || (bVarB = dVar.b()) == null) {
                return;
            }
            double dA = dVar.a();
            if (dA >= 0.0d) {
                bVarB.a(dA);
            }
        }
    }
}

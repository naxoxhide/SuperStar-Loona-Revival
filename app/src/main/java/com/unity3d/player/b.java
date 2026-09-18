package com.unity3d.player;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
final class b {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f2956b;
    private a c;

    private class a extends ContentObserver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0538b f2957b;
        private final AudioManager c;
        private final int d;
        private int e;

        public a(Handler handler, AudioManager audioManager, int i, InterfaceC0538b interfaceC0538b) {
            super(handler);
            this.c = audioManager;
            this.d = 3;
            this.f2957b = interfaceC0538b;
            this.e = audioManager.getStreamVolume(3);
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z, Uri uri) {
            int streamVolume;
            AudioManager audioManager = this.c;
            if (audioManager == null || this.f2957b == null || (streamVolume = audioManager.getStreamVolume(this.d)) == this.e) {
                return;
            }
            this.e = streamVolume;
            this.f2957b.onAudioVolumeChanged(streamVolume);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.player.b$b, reason: collision with other inner class name */
    public interface InterfaceC0538b {
        void onAudioVolumeChanged(int i);
    }

    public b(Context context) {
        this.a = context;
        this.f2956b = (AudioManager) context.getSystemService("audio");
    }

    public final void a() {
        if (this.c != null) {
            this.a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public final void a(InterfaceC0538b interfaceC0538b) {
        this.c = new a(new Handler(), this.f2956b, 3, interfaceC0538b);
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}

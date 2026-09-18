package com.applovin.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private final Context E;
    private final a F;
    private boolean G;

    /* JADX INFO: renamed from: com.applovin.exoplayer2.b$b, reason: collision with other inner class name */
    public interface InterfaceC0075b {
        void m();
    }

    public b(Context context, Handler handler, InterfaceC0075b interfaceC0075b) {
        this.E = context.getApplicationContext();
        this.F = new a(handler, interfaceC0075b);
    }

    public void setEnabled(boolean z) {
        if (z && !this.G) {
            this.E.registerReceiver(this.F, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.G = true;
        } else {
            if (z || !this.G) {
                return;
            }
            this.E.unregisterReceiver(this.F);
            this.G = false;
        }
    }

    private final class a extends BroadcastReceiver implements Runnable {
        private final InterfaceC0075b H;
        private final Handler I;

        public a(Handler handler, InterfaceC0075b interfaceC0075b) {
            this.I = handler;
            this.H = interfaceC0075b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.I.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.G) {
                this.H.m();
            }
        }
    }
}

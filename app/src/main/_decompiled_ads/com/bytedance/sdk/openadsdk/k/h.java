package com.bytedance.sdk.openadsdk.k;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: VolumeChangeObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private final AudioManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f780b = -1;
    private boolean c = false;

    public h(Context context) {
        this.a = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int a() {
        return this.f780b;
    }

    public boolean b() {
        if (!this.c) {
            return false;
        }
        this.c = false;
        return true;
    }

    public void a(int i) {
        this.f780b = i;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.a == null) {
            return;
        }
        int i = 0;
        if (z) {
            int iD = DeviceUtils.d();
            if (iD != 0) {
                this.f780b = iD;
            }
            m.a("VolumeChangeObserver", "mute set volume to 0");
            a(3, 0, 0);
            this.c = true;
            return;
        }
        int i2 = this.f780b;
        if (i2 == 0) {
            i2 = DeviceUtils.i() / 15;
        } else {
            if (i2 == -1) {
                if (!z2) {
                    return;
                } else {
                    i2 = DeviceUtils.i() / 15;
                }
            }
            m.a("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.f780b);
            this.f780b = -1;
            a(3, i2, i);
            this.c = true;
        }
        i = 1;
        m.a("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.f780b);
        this.f780b = -1;
        a(3, i2, i);
        this.c = true;
    }

    private void a(int i, int i2, int i3) {
        try {
            this.a.setStreamVolume(i, i2, i3);
        } catch (Throwable unused) {
        }
    }
}

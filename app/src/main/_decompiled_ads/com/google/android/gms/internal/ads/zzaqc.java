package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaqc implements Runnable {
    private zzaqc() {
    }

    /* synthetic */ zzaqc(zzaqb zzaqbVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzaqd.zzd = MessageDigest.getInstance(SameMD5.TAG);
            countDownLatch = zzaqd.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzaqd.zzb;
        } catch (Throwable th) {
            zzaqd.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}

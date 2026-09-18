package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzrn extends Handler {
    final /* synthetic */ zzrp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzrn(zzrp zzrpVar, Looper looper) {
        super(looper);
        this.zza = zzrpVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzrp.zza(this.zza, message);
    }
}

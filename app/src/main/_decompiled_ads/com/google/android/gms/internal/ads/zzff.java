package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzff implements zzeh {
    private Message zza;
    private zzfg zzb;

    private zzff() {
    }

    /* synthetic */ zzff(zzfe zzfeVar) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzfg.zzl(this);
    }

    public final zzff zzb(Message message, zzfg zzfgVar) {
        this.zza = message;
        this.zzb = zzfgVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeh
    public final void zza() {
        Message message = this.zza;
        Objects.requireNonNull(message);
        message.sendToTarget();
        zzd();
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        Objects.requireNonNull(message);
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        zzd();
        return zSendMessageAtFrontOfQueue;
    }
}

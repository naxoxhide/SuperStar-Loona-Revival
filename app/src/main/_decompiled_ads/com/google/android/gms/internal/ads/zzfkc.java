package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfkc {
    public abstract void zzb(View view, zzfkj zzfkjVar, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();

    public static zzfkc zza(zzfkd zzfkdVar, zzfke zzfkeVar) {
        if (zzfka.zzb()) {
            return new zzfkg(zzfkdVar, zzfkeVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}

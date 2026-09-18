package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdp extends Exception {
    public final zzdo zza;

    public zzdp(String str, zzdo zzdoVar) {
        super("Unhandled input format: ".concat(String.valueOf(String.valueOf(zzdoVar))));
        this.zza = zzdoVar;
    }
}

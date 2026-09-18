package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxj {
    public final zzcx zza;
    public final int[] zzb;

    public zzxj(zzcx zzcxVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzer.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzcxVar;
        this.zzb = iArr;
    }
}

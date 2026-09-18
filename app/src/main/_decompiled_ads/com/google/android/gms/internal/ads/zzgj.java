package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzgj extends IOException {
    public final int zza;

    public zzgj(int i) {
        this.zza = i;
    }

    public zzgj(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzgj(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzgj(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfsh implements zzfsx {
    protected zzfsh() {
    }

    public static zzfsh zzc(char c) {
        return new zzfse(c);
    }

    @Override // com.google.android.gms.internal.ads.zzfsx
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}

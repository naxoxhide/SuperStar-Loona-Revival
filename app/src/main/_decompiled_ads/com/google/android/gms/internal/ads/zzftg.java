package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzftg implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzftj zzb;

    zzftg(zzftj zzftjVar, CharSequence charSequence) {
        this.zzb = zzftjVar;
        this.zza = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzfsl.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}

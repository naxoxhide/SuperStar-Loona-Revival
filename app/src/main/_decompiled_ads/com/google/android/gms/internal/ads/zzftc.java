package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzftc extends zzfth {
    final /* synthetic */ zzftd zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzftc(zzftd zzftdVar, zzftj zzftjVar, CharSequence charSequence) {
        super(zzftjVar, charSequence);
        this.zza = zzftdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfth
    final int zzc(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfth
    final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfsw.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            zzftd zzftdVar = this.zza;
            if (zzftdVar.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwv extends zzgwt {
    zzgwv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ int zza(Object obj) {
        return ((zzgwu) obj).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ int zzb(Object obj) {
        return ((zzgwu) obj).zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzgtz zzgtzVar = (zzgtz) obj;
        zzgwu zzgwuVar = zzgtzVar.zzc;
        if (zzgwuVar != zzgwu.zzc()) {
            return zzgwuVar;
        }
        zzgwu zzgwuVarZzf = zzgwu.zzf();
        zzgtzVar.zzc = zzgwuVarZzf;
        return zzgwuVarZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzgtz) obj).zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzgwu.zzc().equals(obj2)) {
            return obj;
        }
        if (zzgwu.zzc().equals(obj)) {
            return zzgwu.zze((zzgwu) obj, (zzgwu) obj2);
        }
        ((zzgwu) obj).zzd((zzgwu) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ Object zzf() {
        return zzgwu.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ Object zzg(Object obj) {
        ((zzgwu) obj).zzh();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i, int i2) {
        ((zzgwu) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i, long j) {
        ((zzgwu) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i, Object obj2) {
        ((zzgwu) obj).zzj((i << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* bridge */ /* synthetic */ void zzk(Object obj, int i, zzgsr zzgsrVar) {
        ((zzgwu) obj).zzj((i << 3) | 2, zzgsrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* bridge */ /* synthetic */ void zzl(Object obj, int i, long j) {
        ((zzgwu) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final void zzm(Object obj) {
        ((zzgtz) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzgtz) obj).zzc = (zzgwu) obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzgtz) obj).zzc = (zzgwu) obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final boolean zzq(zzgvu zzgvuVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    final /* synthetic */ void zzr(Object obj, zzgth zzgthVar) throws IOException {
        ((zzgwu) obj).zzk(zzgthVar);
    }
}

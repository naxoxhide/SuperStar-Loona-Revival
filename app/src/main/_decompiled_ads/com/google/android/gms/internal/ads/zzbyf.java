package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbyf extends zzbyz {
    private final Clock zzb;
    private final zzbyf zzc = this;
    private final zzhbp zzd;
    private final zzhbp zze;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;
    private final zzhbp zzi;
    private final zzhbp zzj;
    private final zzhbp zzk;

    /* synthetic */ zzbyf(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbyy zzbyyVar, zzbye zzbyeVar) {
        this.zzb = clock;
        zzhbc zzhbcVarZza = zzhbd.zza(context);
        this.zzd = zzhbcVarZza;
        zzhbc zzhbcVarZza2 = zzhbd.zza(zzgVar);
        this.zze = zzhbcVarZza2;
        zzhbc zzhbcVarZza3 = zzhbd.zza(zzbyyVar);
        this.zzf = zzhbcVarZza3;
        this.zzg = zzhbb.zzc(new zzbxx(zzhbcVarZza, zzhbcVarZza2, zzhbcVarZza3));
        zzhbc zzhbcVarZza4 = zzhbd.zza(clock);
        this.zzh = zzhbcVarZza4;
        zzhbp zzhbpVarZzc = zzhbb.zzc(new zzbxz(zzhbcVarZza4, zzhbcVarZza2, zzhbcVarZza3));
        this.zzi = zzhbpVarZzc;
        zzbyb zzbybVar = new zzbyb(zzhbcVarZza4, zzhbpVarZzc);
        this.zzj = zzbybVar;
        this.zzk = zzhbb.zzc(new zzbze(zzhbcVarZza, zzbybVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbyz
    final zzbxw zza() {
        return (zzbxw) this.zzg.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbyz
    final zzbya zzb() {
        return new zzbya(this.zzb, (zzbxy) this.zzi.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzbyz
    final zzbzd zzc() {
        return (zzbzd) this.zzk.zzb();
    }
}

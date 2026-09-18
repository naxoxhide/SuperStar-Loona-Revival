package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwf implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzcwf(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final zzcaz zzcazVarZza = ((zzcio) this.zzb).zza();
        final zzfdn zzfdnVarZza = ((zzcxc) this.zzc).zza();
        return new zzfsk() { // from class: com.google.android.gms.internal.ads.zzcwe
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                zzfcr zzfcrVar = (zzfcr) obj;
                com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
                zzauVar.zzp(zzfcrVar.zzD);
                zzauVar.zzq(zzfcrVar.zzE.toString());
                zzauVar.zzo(zzcazVarZza.zza);
                zzauVar.zzn(zzfdnVarZza.zzf);
                return zzauVar;
            }
        };
    }
}

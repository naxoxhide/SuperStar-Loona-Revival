package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcxh implements zzhbc {
    private final zzcxg zza;
    private final zzhbp zzb;
    private final zzhbp zzc;
    private final zzhbp zzd;
    private final zzhbp zze;

    public zzcxh(zzcxg zzcxgVar, zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3, zzhbp zzhbpVar4) {
        this.zza = zzcxgVar;
        this.zzb = zzhbpVar;
        this.zzc = zzhbpVar2;
        this.zzd = zzhbpVar3;
        this.zze = zzhbpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* synthetic */ Object zzb() {
        Context context = (Context) this.zzb.zzb();
        zzcaz zzcazVarZza = ((zzcio) this.zzc).zza();
        zzfcr zzfcrVarZza = ((zzctn) this.zzd).zza();
        zzbxq zzbxqVar = new zzbxq();
        zzbxr zzbxrVar = zzfcrVarZza.zzC;
        if (zzbxrVar == null) {
            return null;
        }
        zzfcx zzfcxVar = zzfcrVarZza.zzu;
        return new zzbxp(context, zzcazVarZza, zzbxrVar, zzfcxVar == null ? null : zzfcxVar.zzb, zzbxqVar);
    }
}

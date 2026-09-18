package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfal implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzfal(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfai zzb() {
        Context context = (Context) this.zza.zzb();
        zzfew zzfewVar = (zzfew) this.zzb.zzb();
        zzffo zzffoVar = (zzffo) this.zzc.zzb();
        zzbzw zzbzwVarZzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgn)).booleanValue() ? com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh() : com.google.android.gms.ads.internal.zzt.zzo().zzh().zzi();
        boolean z = false;
        if (zzbzwVarZzh != null && zzbzwVarZzh.zzh()) {
            z = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgp)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgm)).booleanValue() || z) {
                zzffn zzffnVarZza = zzffoVar.zza(zzffe.Rewarded, context, zzfewVar, new zzezm(new zzezj()));
                return new zzezo(new zzezy(new zzezx()), new zzezu(zzffnVarZza.zza, zzcbg.zza), zzffnVarZza.zzb, zzffnVarZza.zza.zza().zzf, zzcbg.zza);
            }
        }
        return new zzezx();
    }
}

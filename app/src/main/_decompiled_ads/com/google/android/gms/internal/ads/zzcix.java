package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcix implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;

    public zzcix(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbvr zzb() {
        Context contextZza = ((zzcic) this.zza).zza();
        zzfjh zzfjhVar = (zzfjh) this.zzb.zzb();
        com.google.android.gms.ads.internal.zzt.zzf().zzb(contextZza, zzcaz.zza(), zzfjhVar).zza("google.afma.request.getAdDictionary", zzbnx.zza, zzbnx.zza);
        zzboa zzboaVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(contextZza, zzcaz.zza(), zzfjhVar);
        zzbnu zzbnuVar = zzbnx.zza;
        return new zzbvq(contextZza, zzboaVarZzb.zza("google.afma.sdkConstants.getSdkConstants", zzbnuVar, zzbnuVar));
    }
}

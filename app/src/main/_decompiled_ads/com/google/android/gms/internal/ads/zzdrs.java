package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrs implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;
    private final zzhbp zzd;

    public zzdrs(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3, zzhbp zzhbpVar4) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
        this.zzd = zzhbpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet;
        final String str = (String) this.zza.zzb();
        Context contextZza = ((zzcic) this.zzb).zza();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        Map mapZzb = ((zzhbg) this.zzd).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeM)).booleanValue()) {
            zzaxv zzaxvVar = new zzaxv(new zzayb(contextZza));
            zzaxvVar.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzdrt
                @Override // com.google.android.gms.internal.ads.zzaxu
                public final void zza(zzazk zzazkVar) {
                    zzazkVar.zzh(str);
                }
            });
            setEmptySet = Collections.singleton(new zzdev(new zzdrv(zzaxvVar, mapZzb), zzgadVar));
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzhbk.zzb(setEmptySet);
        return setEmptySet;
    }
}

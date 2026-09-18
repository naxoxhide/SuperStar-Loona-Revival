package com.google.android.gms.internal.ads;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzasj implements zzfop {
    private final zzfms zza;
    private final zzfnj zzb;
    private final zzasw zzc;
    private final zzasi zzd;
    private final zzars zze;
    private final zzasy zzf;
    private final zzasq zzg;
    private final zzash zzh;

    zzasj(zzfms zzfmsVar, zzfnj zzfnjVar, zzasw zzaswVar, zzasi zzasiVar, zzars zzarsVar, zzasy zzasyVar, zzasq zzasqVar, zzash zzashVar) {
        this.zza = zzfmsVar;
        this.zzb = zzfnjVar;
        this.zzc = zzaswVar;
        this.zzd = zzasiVar;
        this.zze = zzarsVar;
        this.zzf = zzasyVar;
        this.zzg = zzasqVar;
        this.zzh = zzashVar;
    }

    private final Map zze() {
        HashMap map = new HashMap();
        zzfms zzfmsVar = this.zza;
        zzapj zzapjVarZzb = this.zzb.zzb();
        map.put("v", zzfmsVar.zzb());
        map.put("gms", Boolean.valueOf(this.zza.zzc()));
        map.put("int", zzapjVarZzb.zzh());
        map.put("up", Boolean.valueOf(this.zzd.zza()));
        map.put("t", new Throwable());
        zzasq zzasqVar = this.zzg;
        if (zzasqVar != null) {
            map.put("tcq", Long.valueOf(zzasqVar.zzc()));
            map.put("tpq", Long.valueOf(this.zzg.zzg()));
            map.put("tcv", Long.valueOf(this.zzg.zzd()));
            map.put("tpv", Long.valueOf(this.zzg.zzh()));
            map.put("tchv", Long.valueOf(this.zzg.zzb()));
            map.put("tphv", Long.valueOf(this.zzg.zzf()));
            map.put("tcc", Long.valueOf(this.zzg.zza()));
            map.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzfop
    public final Map zza() {
        zzasw zzaswVar = this.zzc;
        Map mapZze = zze();
        mapZze.put("lts", Long.valueOf(zzaswVar.zza()));
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfop
    public final Map zzb() {
        Map mapZze = zze();
        zzapj zzapjVarZza = this.zzb.zza();
        mapZze.put("gai", Boolean.valueOf(this.zza.zzd()));
        mapZze.put("did", zzapjVarZza.zzg());
        mapZze.put("dst", Integer.valueOf(zzapjVarZza.zzal() - 1));
        mapZze.put("doo", Boolean.valueOf(zzapjVarZza.zzai()));
        zzars zzarsVar = this.zze;
        if (zzarsVar != null) {
            mapZze.put("nt", Long.valueOf(zzarsVar.zza()));
        }
        zzasy zzasyVar = this.zzf;
        if (zzasyVar != null) {
            mapZze.put("vs", Long.valueOf(zzasyVar.zzc()));
            mapZze.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfop
    public final Map zzc() {
        zzash zzashVar = this.zzh;
        Map mapZze = zze();
        if (zzashVar != null) {
            mapZze.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, zzashVar.zza());
        }
        return mapZze;
    }

    final void zzd(View view) {
        this.zzc.zzd(view);
    }
}

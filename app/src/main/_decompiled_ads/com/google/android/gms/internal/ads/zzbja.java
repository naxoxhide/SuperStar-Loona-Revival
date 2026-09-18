package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbja implements zzbjj {
    zzbja() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgb zzcgbVar = (zzcgb) obj;
        if (zzcgbVar.zzJ() != null) {
            zzcgbVar.zzJ().zza();
        }
        com.google.android.gms.ads.internal.overlay.zzl zzlVarZzL = zzcgbVar.zzL();
        if (zzlVarZzL != null) {
            zzlVarZzL.zzb();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzl zzlVarZzM = zzcgbVar.zzM();
        if (zzlVarZzM != null) {
            zzlVarZzM.zzb();
        } else {
            zzcat.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}

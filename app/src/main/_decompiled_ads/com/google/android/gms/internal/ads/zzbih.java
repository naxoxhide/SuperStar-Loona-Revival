package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzbih implements zzbjj {
    public final /* synthetic */ zzdfd zza;
    public final /* synthetic */ zzcou zzb;

    public /* synthetic */ zzbih(zzdfd zzdfdVar, zzcou zzcouVar) {
        this.zza = zzdfdVar;
        this.zzb = zzcouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzcgb zzcgbVar = (zzcgb) obj;
        zzbji.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzcat.zzj("URL missing from click GMSG.");
        } else {
            final zzcou zzcouVar = this.zzb;
            zzfzt.zzr(zzfzt.zzn(zzfzk.zzu(zzbji.zza(zzcgbVar, str)), new zzfza() { // from class: com.google.android.gms.internal.ads.zzbij
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj2) {
                    zzcou zzcouVar2;
                    String str2 = (String) obj2;
                    zzbjj zzbjjVar = zzbji.zza;
                    return (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzju)).booleanValue() || (zzcouVar2 = zzcouVar) == null) ? zzfzt.zzh(str2) : zzcouVar2.zzc(str2, com.google.android.gms.ads.internal.client.zzay.zze());
                }
            }, zzcbg.zza), new zzbix(zzcgbVar), zzcbg.zza);
        }
    }
}

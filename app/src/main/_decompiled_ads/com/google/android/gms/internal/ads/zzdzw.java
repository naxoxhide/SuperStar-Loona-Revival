package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzw {
    public ListenableFuture zza;
    private final zzdae zzb;
    private final zzdze zzc;
    private final zzfhr zzd;
    private final zzfdn zze;
    private final zzcaz zzf;
    private final zzfjh zzg;
    private final zzfje zzh;
    private final Context zzi;
    private final zzgad zzj;

    zzdzw(zzdae zzdaeVar, zzdze zzdzeVar, zzfhr zzfhrVar, zzfdn zzfdnVar, zzcaz zzcazVar, zzfjh zzfjhVar, zzfje zzfjeVar, Context context, zzgad zzgadVar) {
        this.zzb = zzdaeVar;
        this.zzc = zzdzeVar;
        this.zzd = zzfhrVar;
        this.zze = zzfdnVar;
        this.zzf = zzcazVar;
        this.zzg = zzfjhVar;
        this.zzh = zzfjeVar;
        this.zzi = context;
        this.zzj = zzgadVar;
    }

    final /* synthetic */ zzbuo zza(zzbvg zzbvgVar, zzebh zzebhVar) {
        zzebhVar.zzc.put(HttpHeaders.CONTENT_TYPE, zzebhVar.zze);
        zzebhVar.zzc.put("User-Agent", com.google.android.gms.ads.internal.zzt.zzp().zzc(this.zzi, zzbvgVar.zzb.zza));
        Bundle bundle = new Bundle();
        for (Map.Entry entry : zzebhVar.zzc.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbuo(zzebhVar.zza, zzebhVar.zzb, bundle, zzebhVar.zzd, zzebhVar.zzf, zzbvgVar.zzd, zzbvgVar.zzh);
    }

    public final ListenableFuture zzc(final zzbvg zzbvgVar, final JSONObject jSONObject, final zzbvj zzbvjVar) {
        this.zzb.zzbr(zzbvgVar);
        zzfhi zzfhiVarZzb = this.zzd.zzb(zzfhl.PROXY, zzfzt.zzm(this.zzd.zzb(zzfhl.PREPARE_HTTP_REQUEST, zzfzt.zzh(new zzebl(jSONObject, zzbvjVar))).zze(new zzebm(zzbvgVar.zzg, this.zzh, zzfis.zza(this.zzi, 9))).zza(), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdzs
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return this.zza.zza(zzbvgVar, (zzebh) obj);
            }
        }, this.zzj));
        final zzdze zzdzeVar = this.zzc;
        zzfgw zzfgwVarZza = zzfhiVarZzb.zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzt
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzdzeVar.zzc((zzbuo) obj);
            }
        }).zza();
        this.zza = zzfgwVarZza;
        ListenableFuture listenableFutureZzn = zzfzt.zzn(this.zzd.zzb(zzfhl.PRE_PROCESS, zzfgwVarZza).zze(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzdzr
            @Override // com.google.android.gms.internal.ads.zzfgu
            public final Object zza(Object obj) {
                return new zzeau(zzebi.zza(new InputStreamReader((InputStream) obj)), jSONObject, zzbvjVar);
            }
        }).zzf(com.google.android.gms.ads.internal.zzt.zzf().zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzeau.zza, zzbnx.zzb)).zza(), new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzu
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzd((InputStream) obj);
            }
        }, this.zzj);
        zzfzt.zzr(listenableFutureZzn, new zzdzv(this), this.zzj);
        return listenableFutureZzn;
    }

    final /* synthetic */ ListenableFuture zzd(InputStream inputStream) throws Exception {
        return zzfzt.zzh(new zzfde(new zzfdb(this.zze), zzfdd.zza(new InputStreamReader(inputStream))));
    }
}

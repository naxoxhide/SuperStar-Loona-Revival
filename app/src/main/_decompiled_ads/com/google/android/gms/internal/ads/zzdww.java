package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdww implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;

    public zzdww(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfhr zzfhrVar = (zzfhr) this.zza.zzb();
        final CookieManager cookieManagerZzb = com.google.android.gms.ads.internal.zzt.zzq().zzb((Context) this.zzb.zzb());
        zzfhi zzfhiVarZzi = zzfhb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = cookieManagerZzb;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaM));
            }
        }, zzfhl.WEBVIEW_COOKIE, zzfhrVar).zzi(1L, TimeUnit.SECONDS);
        final zzdwu zzdwuVar = new zzfgu() { // from class: com.google.android.gms.internal.ads.zzdwu
            @Override // com.google.android.gms.internal.ads.zzfgu
            public final Object zza(Object obj) {
                return "";
            }
        };
        return zzfhiVarZzi.zzc(Exception.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzfhc
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh("");
            }
        }).zza();
    }
}

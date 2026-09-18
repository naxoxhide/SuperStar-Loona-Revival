package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzegj implements zzeeu {
    private final Context zza;
    private final zzdgx zzb;
    private final Executor zzc;
    private final zzfcq zzd;

    public zzegj(Context context, Executor executor, zzdgx zzdgxVar, zzfcq zzfcqVar) {
        this.zza = context;
        this.zzb = zzdgxVar;
        this.zzc = executor;
        this.zzd = zzfcqVar;
    }

    private static String zzd(zzfcr zzfcrVar) {
        try {
            return zzfcrVar.zzx.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(final zzfde zzfdeVar, final zzfcr zzfcrVar) {
        String strZzd = zzd(zzfcrVar);
        final Uri uri = strZzd != null ? Uri.parse(strZzd) : null;
        return zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzegh
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(uri, zzfdeVar, zzfcrVar, obj);
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbdj.zzg(context) && !TextUtils.isEmpty(zzd(zzfcrVar));
    }

    final /* synthetic */ ListenableFuture zzc(Uri uri, zzfde zzfdeVar, zzfcr zzfcrVar, Object obj) throws Exception {
        try {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            customTabsIntentBuild.intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(customTabsIntentBuild.intent, null);
            final zzcbl zzcblVar = new zzcbl();
            zzdfx zzdfxVarZze = this.zzb.zze(new zzctm(zzfdeVar, zzfcrVar, null), new zzdga(new zzdhf() { // from class: com.google.android.gms.internal.ads.zzegi
                @Override // com.google.android.gms.internal.ads.zzdhf
                public final void zza(boolean z, Context context, zzcxy zzcxyVar) {
                    zzcbl zzcblVar2 = zzcblVar;
                    try {
                        com.google.android.gms.ads.internal.zzt.zzi();
                        com.google.android.gms.ads.internal.overlay.zzm.zza(context, (AdOverlayInfoParcel) zzcblVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }, null));
            zzcblVar.zzc(new AdOverlayInfoParcel(zzcVar, null, zzdfxVarZze.zza(), null, new zzcaz(0, 0, false, false, false), null, null));
            this.zzd.zza();
            return zzfzt.zzh(zzdfxVarZze.zzg());
        } catch (Throwable th) {
            zzcat.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}

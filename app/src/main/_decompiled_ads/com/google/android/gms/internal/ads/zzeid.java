package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzeid implements zzeeu {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(zzfde zzfdeVar, zzfcr zzfcrVar) {
        String strOptString = zzfcrVar.zzx.optString("pubid", "");
        zzfdn zzfdnVar = zzfdeVar.zza.zza;
        zzfdl zzfdlVar = new zzfdl();
        zzfdlVar.zzp(zzfdnVar);
        zzfdlVar.zzs(strOptString);
        Bundle bundleZzd = zzd(zzfdnVar.zzd.zzm);
        Bundle bundleZzd2 = zzd(bundleZzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        bundleZzd2.putInt("gw", 1);
        String strOptString2 = zzfcrVar.zzx.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleZzd2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = zzfcrVar.zzx.optString("adJson", null);
        if (strOptString3 != null) {
            bundleZzd2.putString("_ad", strOptString3);
        }
        bundleZzd2.putBoolean("_noRefresh", true);
        Iterator<String> itKeys = zzfcrVar.zzF.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = zzfcrVar.zzF.optString(next, null);
            if (next != null) {
                bundleZzd2.putString(next, strOptString4);
            }
        }
        bundleZzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleZzd2);
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzfdnVar.zzd;
        Bundle bundle = zzlVar.zzn;
        List list = zzlVar.zzo;
        String str = zzlVar.zzp;
        int i = zzlVar.zzd;
        String str2 = zzlVar.zzq;
        List list2 = zzlVar.zze;
        boolean z = zzlVar.zzr;
        boolean z2 = zzlVar.zzf;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzlVar.zzs;
        int i2 = zzlVar.zzg;
        int i3 = zzlVar.zzt;
        boolean z3 = zzlVar.zzh;
        String str3 = zzlVar.zzu;
        String str4 = zzlVar.zzi;
        List list3 = zzlVar.zzv;
        zzfdlVar.zzE(new com.google.android.gms.ads.internal.client.zzl(zzlVar.zza, zzlVar.zzb, bundleZzd2, i, list2, z2, i2, z3, str4, zzlVar.zzj, zzlVar.zzk, zzlVar.zzl, bundleZzd, bundle, list, str, str2, z, zzcVar, i3, str3, list3, zzlVar.zzw, zzlVar.zzx, zzlVar.zzy));
        zzfdn zzfdnVarZzG = zzfdlVar.zzG();
        Bundle bundle2 = new Bundle();
        zzfcv zzfcvVar = zzfdeVar.zzb.zzb;
        Bundle bundle3 = new Bundle();
        bundle3.putStringArrayList("nofill_urls", new ArrayList<>(zzfcvVar.zza));
        bundle3.putInt("refresh_interval", zzfcvVar.zzc);
        bundle3.putString("gws_query_id", zzfcvVar.zzb);
        bundle2.putBundle("parent_common_config", bundle3);
        zzfdn zzfdnVar2 = zzfdeVar.zza.zza;
        Bundle bundle4 = new Bundle();
        bundle4.putString("initial_ad_unit_id", zzfdnVar2.zzf);
        bundle4.putString("allocation_id", zzfcrVar.zzy);
        bundle4.putStringArrayList("click_urls", new ArrayList<>(zzfcrVar.zzc));
        bundle4.putStringArrayList("imp_urls", new ArrayList<>(zzfcrVar.zzd));
        bundle4.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfcrVar.zzr));
        bundle4.putStringArrayList("fill_urls", new ArrayList<>(zzfcrVar.zzo));
        bundle4.putStringArrayList("video_start_urls", new ArrayList<>(zzfcrVar.zzi));
        bundle4.putStringArrayList("video_reward_urls", new ArrayList<>(zzfcrVar.zzj));
        bundle4.putStringArrayList("video_complete_urls", new ArrayList<>(zzfcrVar.zzk));
        bundle4.putString("transaction_id", zzfcrVar.zzl);
        bundle4.putString("valid_from_timestamp", zzfcrVar.zzm);
        bundle4.putBoolean("is_closable_area_disabled", zzfcrVar.zzR);
        bundle4.putString("recursive_server_response_data", zzfcrVar.zzaq);
        if (zzfcrVar.zzn != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("rb_amount", zzfcrVar.zzn.zzb);
            bundle5.putString("rb_type", zzfcrVar.zzn.zza);
            bundle4.putParcelableArray("rewards", new Bundle[]{bundle5});
        }
        bundle2.putBundle("parent_ad_config", bundle4);
        return zzc(zzfdnVarZzG, bundle2, zzfcrVar, zzfdeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        return !TextUtils.isEmpty(zzfcrVar.zzx.optString("pubid", ""));
    }

    protected abstract ListenableFuture zzc(zzfdn zzfdnVar, Bundle bundle, zzfcr zzfcrVar, zzfde zzfdeVar);
}

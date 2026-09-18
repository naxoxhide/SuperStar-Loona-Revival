package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenr implements zzetv {
    final zzfdn zza;
    private final long zzb;

    public zzenr(zzfdn zzfdnVar, long j) {
        Preconditions.checkNotNull(zzfdnVar, "the targeting must not be null");
        this.zza = zzfdnVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzetv
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        com.google.android.gms.ads.internal.client.zzl zzlVar = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzlVar.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i2 == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        bundle.putLong("start_signals_timestamp", this.zzb);
        zzfdz.zzf(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzlVar.zzb)), zzlVar.zzb != -1);
        zzfdz.zzb(bundle, "extras", zzlVar.zzc);
        int i3 = zzlVar.zzd;
        zzfdz.zze(bundle, "cust_gender", i3, i3 != -1);
        zzfdz.zzd(bundle, "kw", zzlVar.zze);
        int i4 = zzlVar.zzg;
        zzfdz.zze(bundle, "tag_for_child_directed_treatment", i4, i4 != -1);
        if (zzlVar.zzf) {
            bundle.putBoolean("test_request", true);
        }
        bundle.putInt("ppt_p13n", zzlVar.zzy);
        zzfdz.zze(bundle, "d_imp_hdr", 1, zzlVar.zza >= 2 && zzlVar.zzh);
        String str = zzlVar.zzi;
        zzfdz.zzf(bundle, "ppid", str, zzlVar.zza >= 2 && !TextUtils.isEmpty(str));
        Location location = zzlVar.zzk;
        if (location != null) {
            float accuracy = location.getAccuracy() * 1000.0f;
            long time = location.getTime() * 1000;
            double latitude = location.getLatitude() * 1.0E7d;
            double longitude = 1.0E7d * location.getLongitude();
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", accuracy);
            bundle2.putLong("lat", (long) latitude);
            bundle2.putLong("long", (long) longitude);
            bundle2.putLong("time", time);
            bundle.putBundle("uule", bundle2);
        }
        zzfdz.zzc(bundle, "url", zzlVar.zzl);
        zzfdz.zzd(bundle, "neighboring_content_urls", zzlVar.zzv);
        zzfdz.zzb(bundle, "custom_targeting", zzlVar.zzn);
        zzfdz.zzd(bundle, "category_exclusions", zzlVar.zzo);
        zzfdz.zzc(bundle, "request_agent", zzlVar.zzp);
        zzfdz.zzc(bundle, "request_pkg", zzlVar.zzq);
        zzfdz.zzg(bundle, "is_designed_for_families", zzlVar.zzr, zzlVar.zza >= 7);
        if (zzlVar.zza >= 8) {
            int i5 = zzlVar.zzt;
            zzfdz.zze(bundle, "tag_for_under_age_of_consent", i5, i5 != -1);
            zzfdz.zzc(bundle, "max_ad_content_rating", zzlVar.zzu);
        }
    }
}

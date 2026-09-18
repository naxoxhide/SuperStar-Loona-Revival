package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcoh implements zzcnl {
    private final CookieManager zza;

    public zzcoh(Context context) {
        this.zza = com.google.android.gms.ads.internal.zzt.zzq().zzb(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcnl
    public final void zza(Map map) {
        if (this.zza == null) {
            return;
        }
        if (((String) map.get("clear")) == null) {
            String str = (String) map.get("cookie");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.zza.setCookie((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaM), str);
            return;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaM);
        String cookie = this.zza.getCookie(str2);
        if (cookie == null) {
            return;
        }
        List listZzf = zzftj.zzc(zzfsh.zzc(';')).zzf(cookie);
        for (int i = 0; i < listZzf.size(); i++) {
            CookieManager cookieManager = this.zza;
            Iterator it = zzftj.zzc(zzfsh.zzc('=')).zzd((String) listZzf.get(i)).iterator();
            Objects.requireNonNull(it);
            if (!it.hasNext()) {
                throw new IndexOutOfBoundsException("position (0) must be less than the number of elements that remained (0)");
            }
            cookieManager.setCookie(str2, String.valueOf((String) it.next()).concat(String.valueOf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaw))));
        }
    }
}

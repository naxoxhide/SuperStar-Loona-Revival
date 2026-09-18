package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfll extends zzflh {
    private WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzfll(Map map, String str) {
        this.zzc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzflh
    public final void zzc() {
        super.zzc();
        new Handler().postDelayed(new zzflk(this), Math.max(4000 - (this.zzb == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzflh
    public final void zzg(zzfkg zzfkgVar, zzfke zzfkeVar) {
        JSONObject jSONObject = new JSONObject();
        Map mapZzi = zzfkeVar.zzi();
        Iterator it = mapZzi.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzh(zzfkgVar, zzfkeVar, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzflh
    public final void zzk() {
        WebView webView = new WebView(zzfky.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzflj(this));
        zzj(this.zza);
        zzfla.zzi(this.zza, null);
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
        } else {
            throw null;
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzavv extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzavm zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzavv() {
        zzavm zzavmVar = new zzavm();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzavmVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbdt.zzd.zze()).intValue();
        this.zzg = ((Long) zzbdt.zza.zze()).intValue();
        this.zzh = ((Long) zzbdt.zze.zze()).intValue();
        this.zzi = ((Long) zzbdt.zzc.zze()).intValue();
        this.zzj = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzS)).intValue();
        this.zzk = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzT)).intValue();
        this.zzl = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzU)).intValue();
        this.zze = ((Long) zzbdt.zzf.zze()).intValue();
        this.zzm = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzW);
        this.zzn = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzX)).booleanValue();
        this.zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzY)).booleanValue();
        this.zzp = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzZ)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00ee */
    /* JADX WARN: Code duplicated, block: B:63:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00dc A[EXC_TOP_SPLITTER, LOOP:1: B:65:0x00dc->B:70:0x00dc, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavv.run():void");
    }

    public final zzavl zza() {
        return this.zzd.zza(this.zzp);
    }

    final zzavu zzb(View view, zzavl zzavlVar) {
        if (view == null) {
            return new zzavu(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzavu(this, 0, 0);
            }
            zzavlVar.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzavu(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzcgb)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                return new zzavu(this, 0, 0);
            }
            zzavlVar.zzh();
            webView.post(new zzavt(this, zzavlVar, webView, globalVisibleRect));
            return new zzavu(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzavu(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zzavu zzavuVarZzb = zzb(viewGroup.getChildAt(i3), zzavlVar);
            i += zzavuVarZzb.zza;
            i2 += zzavuVarZzb.zzb;
        }
        return new zzavu(this, i, i2);
    }

    final void zzc(View view) {
        try {
            zzavl zzavlVar = new zzavl(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZzb = com.google.android.gms.ads.internal.zzt.zzb().zzb();
            if (contextZzb != null && !TextUtils.isEmpty(this.zzm)) {
                String str = (String) view.getTag(contextZzb.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzV), "id", contextZzb.getPackageName()));
                if (str != null && str.equals(this.zzm)) {
                    return;
                }
            }
            zzavu zzavuVarZzb = zzb(view, zzavlVar);
            zzavlVar.zzm();
            if (zzavuVarZzb.zza == 0 && zzavuVarZzb.zzb == 0) {
                return;
            }
            int i = zzavuVarZzb.zzb;
            if (i != 0) {
                if (i == 0) {
                }
                this.zzd.zzb(zzavlVar);
            } else if (zzavlVar.zzc() == 0) {
                return;
            }
            if (this.zzd.zzd(zzavlVar)) {
                return;
            }
            this.zzd.zzb(zzavlVar);
        } catch (Exception e) {
            zzcat.zzh("Exception in fetchContentOnUIThread", e);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "ContentFetchTask.fetchContent");
        }
    }

    final void zzd(zzavl zzavlVar, WebView webView, String str, boolean z) {
        zzavlVar.zzg();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzavlVar.zzl(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzavlVar.zzl(webView.getTitle() + "\n" + strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzavlVar.zzo()) {
                this.zzd.zzc(zzavlVar);
            }
        } catch (JSONException unused) {
            zzcat.zze("Json string may be malformed.");
        } catch (Throwable th) {
            zzcat.zzf("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            if (this.zza) {
                zzcat.zze("Content hash thread already started, quitting...");
            } else {
                this.zza = true;
                start();
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            zzcat.zze("ContentFetchThread: paused, pause = true");
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            zzcat.zze("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}

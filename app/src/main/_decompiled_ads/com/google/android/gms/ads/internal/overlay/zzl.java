package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbib;
import com.google.android.gms.internal.ads.zzbry;
import com.google.android.gms.internal.ads.zzbso;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzcaz;
import com.google.android.gms.internal.ads.zzcgb;
import com.google.android.gms.internal.ads.zzcgn;
import com.google.android.gms.internal.ads.zzchm;
import com.google.android.gms.internal.ads.zzcho;
import com.google.android.gms.internal.ads.zzchq;
import com.google.android.gms.internal.ads.zzcxy;
import com.google.android.gms.internal.ads.zzdfd;
import com.google.android.gms.internal.ads.zzeea;
import com.google.android.gms.internal.ads.zzeeb;
import com.google.android.gms.internal.ads.zzfkc;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzl extends zzbsu implements zzad {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcgb zzd;
    zzh zze;
    zzr zzf;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    zzg zzl;
    private Runnable zzp;
    private boolean zzq;
    private boolean zzr;
    private TextView zzv;
    boolean zzg = false;
    boolean zzj = false;
    boolean zzk = false;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private boolean zzs = false;
    private boolean zzt = false;
    private boolean zzu = true;

    public zzl(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    private final void zzJ(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzj zzjVar;
        int i;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || (zzjVar2 = adOverlayInfoParcel2.zzo) == null || !zzjVar2.zzb) ? false : true;
        boolean zZze = com.google.android.gms.ads.internal.zzt.zzq().zze(this.zzb, configuration);
        if (!this.zzk || z3) {
            if (zZze) {
                if (((Boolean) zzba.zzc().zzb(zzbci.zzaD)).booleanValue()) {
                    z = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null && (zzjVar = adOverlayInfoParcel.zzo) != null && zzjVar.zzg) {
                z2 = true;
            }
        } else if (((Boolean) zzba.zzc().zzb(zzbci.zzaE)).booleanValue()) {
            if (zZze) {
                if (((Boolean) zzba.zzc().zzb(zzbci.zzaD)).booleanValue()) {
                    z = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null) {
                z2 = true;
            }
        } else {
            z = false;
        }
        Window window = this.zzb.getWindow();
        if (((Boolean) zzba.zzc().zzb(zzbci.zzbd)).booleanValue()) {
            View decorView = window.getDecorView();
            if (z) {
                i = z2 ? 5894 : 5380;
            } else {
                i = 256;
            }
            decorView.setSystemUiVisibility(i);
            return;
        }
        if (!z) {
            window.addFlags(2048);
            window.clearFlags(1024);
            return;
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        if (z2) {
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    private static final void zzK(zzfkc zzfkcVar, View view) {
        if (zzfkcVar == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzA().zzh(zzfkcVar, view);
    }

    public final void zzA(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.zzc().zzb(zzbci.zzfU)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.zzc().zzb(zzbci.zzfV)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzba.zzc().zzb(zzbci.zzfW)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzba.zzc().zzb(zzbci.zzfX)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzt(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(-16777216);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzr = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    protected final void zzD(boolean z) throws zzf {
        boolean z2;
        if (!this.zzr) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window == null) {
            throw new zzf("Invalid activity, no window available.");
        }
        zzcgb zzcgbVar = this.zzc.zzd;
        zzcho zzchoVarZzN = zzcgbVar != null ? zzcgbVar.zzN() : null;
        boolean z3 = zzchoVarZzN != null && zzchoVarZzN.zzK();
        this.zzm = false;
        if (z3) {
            int i = this.zzc.zzj;
            if (i == 6) {
                z2 = this.zzb.getResources().getConfiguration().orientation == 1;
                this.zzm = z2;
            } else if (i == 7) {
                z2 = this.zzb.getResources().getConfiguration().orientation == 2;
                this.zzm = z2;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        zzcat.zze("Delay onShow to next orientation change: " + z2);
        zzA(this.zzc.zzj);
        window.setFlags(16777216, 16777216);
        zzcat.zze("Hardware acceleration on the AdActivity window enabled.");
        if (this.zzk) {
            this.zzl.setBackgroundColor(zza);
        } else {
            this.zzl.setBackgroundColor(-16777216);
        }
        this.zzb.setContentView(this.zzl);
        this.zzr = true;
        if (z) {
            try {
                com.google.android.gms.ads.internal.zzt.zzz();
                Activity activity = this.zzb;
                zzcgb zzcgbVar2 = this.zzc.zzd;
                zzchq zzchqVarZzO = zzcgbVar2 != null ? zzcgbVar2.zzO() : null;
                zzcgb zzcgbVar3 = this.zzc.zzd;
                String strZzS = zzcgbVar3 != null ? zzcgbVar3.zzS() : null;
                AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                zzcaz zzcazVar = adOverlayInfoParcel.zzm;
                zzcgb zzcgbVar4 = adOverlayInfoParcel.zzd;
                zzcgb zzcgbVarZza = zzcgn.zza(activity, zzchqVarZzO, strZzS, true, z3, null, null, zzcazVar, null, null, zzcgbVar4 != null ? zzcgbVar4.zzj() : null, zzaxv.zza(), null, null, null);
                this.zzd = zzcgbVarZza;
                zzcho zzchoVarZzN2 = zzcgbVarZza.zzN();
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                zzbhz zzbhzVar = adOverlayInfoParcel2.zzp;
                zzbib zzbibVar = adOverlayInfoParcel2.zze;
                zzz zzzVar = adOverlayInfoParcel2.zzi;
                zzcgb zzcgbVar5 = adOverlayInfoParcel2.zzd;
                zzchoVarZzN2.zzM(null, zzbhzVar, null, zzbibVar, zzzVar, true, null, zzcgbVar5 != null ? zzcgbVar5.zzN().zzd() : null, null, null, null, null, null, null, null, null, null, null, null);
                this.zzd.zzN().zzA(new zzchm() { // from class: com.google.android.gms.ads.internal.overlay.zze
                    @Override // com.google.android.gms.internal.ads.zzchm
                    public final void zza(boolean z4, int i2, String str, String str2) {
                        zzcgb zzcgbVar6 = this.zza.zzd;
                        if (zzcgbVar6 != null) {
                            zzcgbVar6.zzX();
                        }
                    }
                });
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                String str = adOverlayInfoParcel3.zzl;
                if (str != null) {
                    this.zzd.loadUrl(str);
                } else {
                    String str2 = adOverlayInfoParcel3.zzh;
                    if (str2 == null) {
                        throw new zzf("No URL or HTML to display in ad overlay.");
                    }
                    this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str2, "text/html", "UTF-8", null);
                }
                zzcgb zzcgbVar6 = this.zzc.zzd;
                if (zzcgbVar6 != null) {
                    zzcgbVar6.zzar(this);
                }
            } catch (Exception e) {
                zzcat.zzh("Error obtaining webview.", e);
                throw new zzf("Could not obtain webview for the overlay.", e);
            }
        } else {
            zzcgb zzcgbVar7 = this.zzc.zzd;
            this.zzd = zzcgbVar7;
            zzcgbVar7.zzak(this.zzb);
        }
        if (this.zzc.zzw && Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.zzd.zzG(), false);
        }
        this.zzd.zzaf(this);
        zzcgb zzcgbVar8 = this.zzc.zzd;
        if (zzcgbVar8 != null) {
            zzK(zzcgbVar8.zzQ(), this.zzl);
        }
        if (this.zzc.zzk != 5) {
            ViewParent parent = this.zzd.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzd.zzF());
            }
            if (this.zzk) {
                this.zzd.zzaj();
            }
            if (this.zzc.zzw) {
                TextView textView = new TextView(this.zzb);
                this.zzv = textView;
                textView.setId(View.generateViewId());
                this.zzd.zzF().setId(View.generateViewId());
                this.zzv.setTextAppearance(this.zzb, R.style.TextAppearance.Small);
                this.zzv.setMinHeight(50);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                this.zzv.setGravity(8388627);
                this.zzl.addView(this.zzv, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(3, this.zzv.getId());
                layoutParams2.addRule(12);
                this.zzl.addView(this.zzd.zzF(), layoutParams2);
            } else {
                this.zzl.addView(this.zzd.zzF(), -1, -1);
            }
        }
        if (!z && !this.zzm) {
            zze();
        }
        if (this.zzc.zzk != 5) {
            zzw(z3);
            if (this.zzd.zzaw()) {
                zzy(z3, true);
                return;
            }
            return;
        }
        Activity activity2 = this.zzb;
        zzeea zzeeaVarZze = zzeeb.zze();
        zzeeaVarZze.zza(activity2);
        zzeeaVarZze.zzb(this);
        zzeeaVarZze.zzc(this.zzc.zzq);
        zzeeaVarZze.zzd(this.zzc.zzr);
        try {
            zzf(zzeeaVarZze.zze());
        } catch (RemoteException | zzf e2) {
            throw new zzf(e2.getMessage(), e2);
        }
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzq = true;
            if (this.zzp != null) {
                com.google.android.gms.ads.internal.util.zzt.zza.removeCallbacks(this.zzp);
                com.google.android.gms.ads.internal.util.zzt.zza.post(this.zzp);
            }
        }
    }

    protected final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzo zzoVar;
        if (!this.zzb.isFinishing() || this.zzs) {
            return;
        }
        this.zzs = true;
        zzcgb zzcgbVar = this.zzd;
        if (zzcgbVar != null) {
            zzcgbVar.zzW(this.zzn - 1);
            synchronized (this.zzo) {
                if (!this.zzq && this.zzd.zzax()) {
                    if (((Boolean) zzba.zzc().zzb(zzbci.zzeG)).booleanValue() && !this.zzt && (adOverlayInfoParcel = this.zzc) != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
                        zzoVar.zzbu();
                    }
                    this.zzp = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzd
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzc();
                        }
                    };
                    com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(this.zzp, ((Long) zzba.zzc().zzb(zzbci.zzaW)).longValue());
                    return;
                }
            }
        }
        zzc();
    }

    public final void zzG(String str) {
        TextView textView = this.zzv;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (((Boolean) zzba.zzc().zzb(zzbci.zziF)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean zZzaC = this.zzd.zzaC();
        if (!zZzaC) {
            this.zzd.zzd("onbackblocked", Collections.emptyMap());
        }
        return zZzaC;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzk != 5) {
            return;
        }
        this.zzb.overridePendingTransition(0, 0);
    }

    final void zzc() {
        zzcgb zzcgbVar;
        zzo zzoVar;
        if (this.zzt) {
            return;
        }
        this.zzt = true;
        zzcgb zzcgbVar2 = this.zzd;
        if (zzcgbVar2 != null) {
            this.zzl.removeView(zzcgbVar2.zzF());
            zzh zzhVar = this.zze;
            if (zzhVar != null) {
                this.zzd.zzak(zzhVar.zzd);
                this.zzd.zzan(false);
                ViewGroup viewGroup = this.zze.zzc;
                View viewZzF = this.zzd.zzF();
                zzh zzhVar2 = this.zze;
                viewGroup.addView(viewZzF, zzhVar2.zza, zzhVar2.zzb);
                this.zze = null;
            } else if (this.zzb.getApplicationContext() != null) {
                this.zzd.zzak(this.zzb.getApplicationContext());
            }
            this.zzd = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
            zzoVar.zzby(this.zzn);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 == null || (zzcgbVar = adOverlayInfoParcel2.zzd) == null) {
            return;
        }
        zzK(zzcgbVar.zzQ(), this.zzc.zzd.zzF());
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    protected final void zze() {
        this.zzd.zzX();
    }

    public final void zzf(zzeeb zzeebVar) throws RemoteException, zzf {
        zzbso zzbsoVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbsoVar = adOverlayInfoParcel.zzv) == null) {
            throw new zzf("noioou");
        }
        zzbsoVar.zzg(ObjectWrapper.wrap(zzeebVar));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzh(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzi() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzad
    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzJ((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public void zzl(Bundle bundle) {
        if (!this.zzr) {
            this.zzb.requestWindowFeature(1);
        }
        this.zzj = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(this.zzb.getIntent());
            this.zzc = adOverlayInfoParcelZza;
            if (adOverlayInfoParcelZza == null) {
                throw new zzf("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelZza.zzw) {
                if (Build.VERSION.SDK_INT >= 28) {
                    this.zzb.setShowWhenLocked(true);
                } else {
                    this.zzb.getWindow().addFlags(524288);
                }
            }
            if (this.zzc.zzm.zzc > 7500000) {
                this.zzn = 4;
            }
            if (this.zzb.getIntent() != null) {
                this.zzu = this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            com.google.android.gms.ads.internal.zzj zzjVar = adOverlayInfoParcel.zzo;
            if (zzjVar != null) {
                boolean z = zzjVar.zza;
                this.zzk = z;
                if (z) {
                    if (adOverlayInfoParcel.zzk != 5 && zzjVar.zzf != -1) {
                        new zzk(this, null).zzb();
                    }
                }
            } else if (adOverlayInfoParcel.zzk == 5) {
                this.zzk = true;
                if (adOverlayInfoParcel.zzk != 5) {
                    new zzk(this, null).zzb();
                }
            } else {
                this.zzk = false;
            }
            if (bundle == null) {
                if (this.zzu) {
                    zzcxy zzcxyVar = this.zzc.zzt;
                    if (zzcxyVar != null) {
                        zzcxyVar.zze();
                    }
                    zzo zzoVar = this.zzc.zzc;
                    if (zzoVar != null) {
                        zzoVar.zzbv();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                if (adOverlayInfoParcel2.zzk != 1) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.zzb;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                    }
                    zzdfd zzdfdVar = this.zzc.zzu;
                    if (zzdfdVar != null) {
                        zzdfdVar.zzbK();
                    }
                }
            }
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
            zzg zzgVar = new zzg(activity, adOverlayInfoParcel3.zzn, adOverlayInfoParcel3.zzm.zza, adOverlayInfoParcel3.zzs);
            this.zzl = zzgVar;
            zzgVar.setId(1000);
            com.google.android.gms.ads.internal.zzt.zzq().zzl(this.zzb);
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            int i = adOverlayInfoParcel4.zzk;
            if (i == 1) {
                zzD(false);
                return;
            }
            if (i == 2) {
                this.zze = new zzh(adOverlayInfoParcel4.zzd);
                zzD(false);
            } else if (i == 3) {
                zzD(true);
            } else {
                if (i != 5) {
                    throw new zzf("Could not determine ad overlay type.");
                }
                zzD(false);
            }
        } catch (zzf e) {
            zzcat.zzj(e.getMessage());
            this.zzn = 4;
            this.zzb.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzm() {
        zzcgb zzcgbVar = this.zzd;
        if (zzcgbVar != null) {
            try {
                this.zzl.removeView(zzcgbVar.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzo() {
        zzo zzoVar;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
            zzoVar.zzbo();
        }
        if (!((Boolean) zzba.zzc().zzb(zzbci.zzeI)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzp(int i, String[] strArr, int[] iArr) {
        if (i == 12345) {
            Activity activity = this.zzb;
            zzeea zzeeaVarZze = zzeeb.zze();
            zzeeaVarZze.zza(activity);
            zzeeaVarZze.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzf(strArr, iArr, ObjectWrapper.wrap(zzeeaVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzr() {
        zzo zzoVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzoVar = adOverlayInfoParcel.zzc) != null) {
            zzoVar.zzbL();
        }
        zzJ(this.zzb.getResources().getConfiguration());
        if (((Boolean) zzba.zzc().zzb(zzbci.zzeI)).booleanValue()) {
            return;
        }
        zzcgb zzcgbVar = this.zzd;
        if (zzcgbVar == null || zzcgbVar.zzaz()) {
            zzcat.zzj("The webview does not exist. Ignoring action.");
        } else {
            this.zzd.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzt() {
        if (((Boolean) zzba.zzc().zzb(zzbci.zzeI)).booleanValue()) {
            zzcgb zzcgbVar = this.zzd;
            if (zzcgbVar == null || zzcgbVar.zzaz()) {
                zzcat.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzu() {
        if (((Boolean) zzba.zzc().zzb(zzbci.zzeI)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzv() {
        zzo zzoVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzoVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzoVar.zzbx();
    }

    public final void zzw(boolean z) {
        int iIntValue = ((Integer) zzba.zzc().zzb(zzbci.zzeL)).intValue();
        boolean z2 = ((Boolean) zzba.zzc().zzb(zzbci.zzaZ)).booleanValue() || z;
        zzq zzqVar = new zzq();
        zzqVar.zzd = 50;
        zzqVar.zza = true != z2 ? 0 : iIntValue;
        zzqVar.zzb = true != z2 ? iIntValue : 0;
        zzqVar.zzc = iIntValue;
        this.zzf = new zzr(this.zzb, zzqVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        if (!this.zzc.zzw || this.zzd == null) {
            layoutParams.addRule(true != z2 ? 9 : 11);
        } else {
            layoutParams.addRule(11);
            layoutParams.addRule(2, this.zzd.zzF().getId());
        }
        zzy(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzx() {
        this.zzr = true;
    }

    public final void zzy(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzj zzjVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzba.zzc().zzb(zzbci.zzaX)).booleanValue() && (adOverlayInfoParcel2 = this.zzc) != null && (zzjVar2 = adOverlayInfoParcel2.zzo) != null && zzjVar2.zzh;
        boolean z5 = ((Boolean) zzba.zzc().zzb(zzbci.zzaY)).booleanValue() && (adOverlayInfoParcel = this.zzc) != null && (zzjVar = adOverlayInfoParcel.zzo) != null && zzjVar.zzi;
        if (z && z2 && z4 && !z5) {
            new zzbry(this.zzd, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzr zzrVar = this.zzf;
        if (zzrVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzrVar.zzb(z3);
        }
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }
}

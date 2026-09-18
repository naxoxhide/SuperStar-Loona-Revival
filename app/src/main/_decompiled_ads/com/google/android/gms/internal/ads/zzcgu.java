package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzfps;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
final class zzcgu extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcgb {
    public static final /* synthetic */ int zza = 0;
    private boolean zzA;
    private boolean zzB;
    private zzbfb zzC;
    private zzbez zzD;
    private zzawj zzE;
    private int zzF;
    private int zzG;
    private zzbcx zzH;
    private final zzbcx zzI;
    private zzbcx zzJ;
    private final zzbcy zzK;
    private int zzL;
    private com.google.android.gms.ads.internal.overlay.zzl zzM;
    private boolean zzN;
    private final com.google.android.gms.ads.internal.util.zzco zzO;
    private int zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private Map zzT;
    private final WindowManager zzU;
    private final zzaxv zzV;
    private final zzchp zzb;
    private final zzaro zzc;
    private final zzbdk zzd;
    private final zzcaz zze;
    private com.google.android.gms.ads.internal.zzl zzf;
    private final com.google.android.gms.ads.internal.zza zzg;
    private final DisplayMetrics zzh;
    private final float zzi;
    private zzfcr zzj;
    private zzfcv zzk;
    private boolean zzl;
    private boolean zzm;
    private zzcgi zzn;
    private com.google.android.gms.ads.internal.overlay.zzl zzo;
    private zzfkc zzp;
    private zzchq zzq;
    private final String zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private Boolean zzw;
    private boolean zzx;
    private final String zzy;
    private zzcgx zzz;

    protected zzcgu(zzchp zzchpVar, zzchq zzchqVar, String str, boolean z, boolean z2, zzaro zzaroVar, zzbdk zzbdkVar, zzcaz zzcazVar, zzbda zzbdaVar, com.google.android.gms.ads.internal.zzl zzlVar, com.google.android.gms.ads.internal.zza zzaVar, zzaxv zzaxvVar, zzfcr zzfcrVar, zzfcv zzfcvVar) {
        zzfcv zzfcvVar2;
        super(zzchpVar);
        this.zzl = false;
        this.zzm = false;
        this.zzx = true;
        this.zzy = "";
        this.zzP = -1;
        this.zzQ = -1;
        this.zzR = -1;
        this.zzS = -1;
        this.zzb = zzchpVar;
        this.zzq = zzchqVar;
        this.zzr = str;
        this.zzu = z;
        this.zzc = zzaroVar;
        this.zzd = zzbdkVar;
        this.zze = zzcazVar;
        this.zzf = zzlVar;
        this.zzg = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzU = windowManager;
        com.google.android.gms.ads.internal.zzt.zzp();
        DisplayMetrics displayMetricsZzs = com.google.android.gms.ads.internal.util.zzt.zzs(windowManager);
        this.zzh = displayMetricsZzs;
        this.zzi = displayMetricsZzs.density;
        this.zzV = zzaxvVar;
        this.zzj = zzfcrVar;
        this.zzk = zzfcvVar;
        this.zzO = new com.google.android.gms.ads.internal.util.zzco(zzchpVar.zza(), this, this, null);
        setBackgroundColor(0);
        final WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzcat.zzh("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkD)).booleanValue()) {
                settings.setMixedContentMode(1);
            } else {
                settings.setMixedContentMode(2);
            }
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzt.zzp().zzc(zzchpVar, zzcazVar.zza));
        com.google.android.gms.ads.internal.zzt.zzp();
        final Context context = getContext();
        com.google.android.gms.ads.internal.util.zzch.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfps zzfpsVar = zzt.zza;
                String absolutePath = context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
                WebSettings webSettings = settings;
                webSettings.setDatabasePath(absolutePath);
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaJ)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return true;
            }
        });
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzaS();
        addJavascriptInterface(new zzchb(this, new zzcha(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzba();
        zzbcy zzbcyVar = new zzbcy(new zzbda(true, "make_wv", this.zzr));
        this.zzK = zzbcyVar;
        zzbcyVar.zza().zzc(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue() && (zzfcvVar2 = this.zzk) != null && zzfcvVar2.zzb != null) {
            zzbcyVar.zza().zzd("gqi", this.zzk.zzb);
        }
        zzbcyVar.zza();
        zzbcx zzbcxVarZzf = zzbda.zzf();
        this.zzI = zzbcxVarZzf;
        zzbcyVar.zzb("native:view_create", zzbcxVarZzf);
        this.zzJ = null;
        this.zzH = null;
        com.google.android.gms.ads.internal.util.zzck.zza().zzb(zzchpVar);
        com.google.android.gms.ads.internal.zzt.zzo().zzr();
    }

    private final synchronized void zzaS() {
        zzfcr zzfcrVar = this.zzj;
        if (zzfcrVar != null && zzfcrVar.zzao) {
            zzcat.zze("Disabling hardware acceleration on an overlay.");
            zzaU();
            return;
        }
        if (!this.zzu && !this.zzq.zzi()) {
            zzcat.zze("Enabling hardware acceleration on an AdView.");
            zzaW();
            return;
        }
        zzcat.zze("Enabling hardware acceleration on an overlay.");
        zzaW();
    }

    private final synchronized void zzaT() {
        if (this.zzN) {
            return;
        }
        this.zzN = true;
        com.google.android.gms.ads.internal.zzt.zzo().zzq();
    }

    private final synchronized void zzaU() {
        if (!this.zzv) {
            setLayerType(1, null);
        }
        this.zzv = true;
    }

    private final void zzaV(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", true != z ? "0" : "1");
        zzd("onAdVisibilityChanged", map);
    }

    private final synchronized void zzaW() {
        if (this.zzv) {
            setLayerType(0, null);
        }
        this.zzv = false;
    }

    private final synchronized void zzaX(String str) {
        try {
            super.loadUrl("about:blank");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "AdWebViewImpl.loadUrlUnsafe");
            zzcat.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzaY() {
        zzbcs.zza(this.zzK.zza(), this.zzI, "aeh2");
    }

    private final synchronized void zzaZ() {
        Map map = this.zzT;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzcen) it.next()).release();
            }
        }
        this.zzT = null;
    }

    private final void zzba() {
        zzbcy zzbcyVar = this.zzK;
        if (zzbcyVar == null) {
            return;
        }
        zzbda zzbdaVarZza = zzbcyVar.zza();
        zzbcq zzbcqVarZzf = com.google.android.gms.ads.internal.zzt.zzo().zzf();
        if (zzbcqVarZzf != null) {
            zzbcqVarZzf.zzf(zzbdaVarZza);
        }
    }

    private final synchronized void zzbb() {
        Boolean boolZzk = com.google.android.gms.ads.internal.zzt.zzo().zzk();
        this.zzw = boolZzk;
        if (boolZzk == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaQ(true);
            } catch (IllegalStateException unused) {
                zzaQ(false);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgb
    public final synchronized void destroy() {
        zzba();
        this.zzO.zza();
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzb();
            this.zzo.zzm();
            this.zzo = null;
        }
        this.zzp = null;
        this.zzn.zzh();
        this.zzE = null;
        this.zzf = null;
        setOnClickListener(null);
        setOnTouchListener(null);
        if (this.zzt) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
        zzaZ();
        this.zzt = true;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjV)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
            zzU();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
            com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
            zzaX("about:blank");
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(String str, ValueCallback valueCallback) {
        if (!zzaz()) {
            super.evaluateJavascript(str, valueCallback);
            return;
        }
        zzcat.zzl("#004 The webview is destroyed. Ignoring action.", null);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzt) {
                    this.zzn.zzh();
                    com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
                    zzaZ();
                    zzaT();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgb
    public final synchronized void loadData(String str, String str2, String str3) {
        if (zzaz()) {
            zzcat.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgb
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (zzaz()) {
            zzcat.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgb
    public final synchronized void loadUrl(String str) {
        if (zzaz()) {
            zzcat.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "AdWebViewImpl.loadUrl");
            zzcat.zzk("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcgi zzcgiVar = this.zzn;
        if (zzcgiVar != null) {
            zzcgiVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaz()) {
            this.zzO.zzc();
        }
        boolean z = this.zzA;
        zzcgi zzcgiVar = this.zzn;
        if (zzcgiVar != null && zzcgiVar.zzL()) {
            if (!this.zzB) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = true;
            }
            zzaR();
            z = true;
        }
        zzaV(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzcgi zzcgiVar;
        synchronized (this) {
            if (!zzaz()) {
                this.zzO.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzB && (zzcgiVar = this.zzn) != null && zzcgiVar.zzL() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = false;
            }
        }
        zzaV(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkf)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzS(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzcat.zze("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (zzaz()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaR = zzaR();
        com.google.android.gms.ads.internal.overlay.zzl zzlVarZzL = zzL();
        if (zzlVarZzL == null || !zZzaR) {
            return;
        }
        zzlVarZzL.zzn();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0080 A[Catch: all -> 0x01e0, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000d, B:10:0x0013, B:12:0x0017, B:15:0x0021, B:17:0x0029, B:20:0x002e, B:22:0x0036, B:24:0x0048, B:27:0x004d, B:29:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0074, B:47:0x008a, B:41:0x007b, B:44:0x0080, B:50:0x0097, B:52:0x009f, B:54:0x00b1, B:57:0x00b6, B:59:0x00d2, B:61:0x00da, B:60:0x00d6, B:64:0x00df, B:66:0x00e7, B:69:0x00f2, B:78:0x0116, B:80:0x011d, B:85:0x0125, B:87:0x0137, B:89:0x0145, B:93:0x0152, B:96:0x0157, B:98:0x01a2, B:99:0x01a6, B:101:0x01ad, B:106:0x01ba, B:108:0x01c0, B:109:0x01c3, B:111:0x01c7, B:112:0x01d0, B:115:0x01db), top: B:121:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected final synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (zzaz()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.zzu && !this.zzq.zzf()) {
            if (this.zzq.zzh()) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.zzq.zzj()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdG)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzcgx zzcgxVarZzq = zzq();
                float fZze = zzcgxVarZzq != null ? zzcgxVarZzq.zze() : 0.0f;
                if (fZze == 0.0f) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                float f = size2 * fZze;
                int i7 = (int) (size / fZze);
                if (size2 != 0) {
                    i3 = (int) f;
                    if (size == 0) {
                        i6 = size;
                    } else if (i3 != 0) {
                        i7 = (int) (i3 / fZze);
                        i4 = size2;
                        i5 = i3;
                        i6 = i5;
                    }
                    i4 = size2;
                    i5 = i3;
                } else if (i7 != 0) {
                    i5 = (int) (i7 * fZze);
                    i6 = size;
                    i4 = i7;
                } else {
                    size2 = 0;
                    i3 = (int) f;
                    if (size == 0) {
                        i6 = size;
                    } else if (i3 != 0) {
                        i7 = (int) (i3 / fZze);
                        i4 = size2;
                        i5 = i3;
                        i6 = i5;
                    }
                    i4 = size2;
                    i5 = i3;
                }
                setMeasuredDimension(Math.min(i5, i6), Math.min(i7, i4));
                return;
            }
            if (this.zzq.zzg()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdM)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzad("/contentHeight", new zzcgs(this));
                zzaO("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                float f2 = this.zzh.density;
                int size3 = View.MeasureSpec.getSize(i);
                int i8 = this.zzG;
                setMeasuredDimension(size3, i8 != -1 ? (int) (i8 * f2) : View.MeasureSpec.getSize(i2));
                return;
            }
            if (this.zzq.zzi()) {
                DisplayMetrics displayMetrics = this.zzh;
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size4 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size5 = View.MeasureSpec.getSize(i2);
            int i9 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : Integer.MAX_VALUE;
            int i10 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size5 : Integer.MAX_VALUE;
            zzchq zzchqVar = this.zzq;
            boolean z = zzchqVar.zzb > i9 || zzchqVar.zza > i10;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfn)).booleanValue()) {
                zzchq zzchqVar2 = this.zzq;
                float f3 = zzchqVar2.zzb;
                float f4 = this.zzi;
                z &= f3 / f4 <= ((float) i9) / f4 && ((float) zzchqVar2.zza) / f4 <= ((float) i10) / f4;
            }
            if (!z) {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                if (!this.zzm) {
                    this.zzV.zzc(10002);
                    this.zzm = true;
                }
                zzchq zzchqVar3 = this.zzq;
                setMeasuredDimension(zzchqVar3.zzb, zzchqVar3.zza);
                return;
            }
            zzchq zzchqVar4 = this.zzq;
            float f5 = zzchqVar4.zzb;
            float f6 = this.zzi;
            zzcat.zzj("Not enough space to show ad. Needs " + ((int) (f5 / f6)) + "x" + ((int) (zzchqVar4.zza / f6)) + " dp, but only has " + ((int) (size4 / f6)) + "x" + ((int) (size5 / f6)) + " dp.");
            if (getVisibility() != 8) {
                setVisibility(4);
            }
            setMeasuredDimension(0, 0);
            if (this.zzl) {
                return;
            }
            this.zzV.zzc(10001);
            this.zzl = true;
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgb
    public final void onPause() {
        if (zzaz()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            zzcat.zzh("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgb
    public final void onResume() {
        if (zzaz()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            zzcat.zzh("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzn.zzL() || this.zzn.zzJ()) {
            zzaro zzaroVar = this.zzc;
            if (zzaroVar != null) {
                zzaroVar.zzd(motionEvent);
            }
            zzbdk zzbdkVar = this.zzd;
            if (zzbdkVar != null) {
                zzbdkVar.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzbfb zzbfbVar = this.zzC;
                if (zzbfbVar != null) {
                    zzbfbVar.zzd(motionEvent);
                }
            }
        }
        if (zzaz()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcgb
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcgi) {
            this.zzn = (zzcgi) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaz()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzcat.zzh("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final synchronized void zzA(int i) {
        this.zzL = i;
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final void zzB(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzcdc
    public final synchronized void zzC(zzcgx zzcgxVar) {
        if (this.zzz != null) {
            zzcat.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzz = zzcgxVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzcfs
    public final zzfcr zzD() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzchl
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final WebViewClient zzH() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzchj
    public final zzaro zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized zzawj zzJ() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized zzbfb zzK() {
        return this.zzC;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized com.google.android.gms.ads.internal.overlay.zzl zzL() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized com.google.android.gms.ads.internal.overlay.zzl zzM() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final /* synthetic */ zzcho zzN() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzchi
    public final synchronized zzchq zzO() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzcgy
    public final zzfcv zzP() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized zzfkc zzQ() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final ListenableFuture zzR() {
        zzbdk zzbdkVar = this.zzd;
        return zzbdkVar == null ? zzfzt.zzh(null) : zzbdkVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized String zzS() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzT(zzfcr zzfcrVar, zzfcv zzfcvVar) {
        this.zzj = zzfcrVar;
        this.zzk = zzfcvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzU() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzaT();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcgt(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzV() {
        zzaY();
        HashMap map = new HashMap(1);
        map.put("version", this.zze.zza);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzW(int i) {
        if (i == 0) {
            zzbcy zzbcyVar = this.zzK;
            zzbcs.zza(zzbcyVar.zza(), this.zzI, "aebb2");
        }
        zzaY();
        this.zzK.zza();
        this.zzK.zza().zzd("close_type", String.valueOf(i));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.zze.zza);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzX() {
        if (this.zzH == null) {
            zzbcy zzbcyVar = this.zzK;
            zzbcs.zza(zzbcyVar.zza(), this.zzI, "aes2");
            this.zzK.zza();
            zzbcx zzbcxVarZzf = zzbda.zzf();
            this.zzH = zzbcxVarZzf;
            this.zzK.zzb("native:view_show", zzbcxVarZzf);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zze.zza);
        zzd("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzY() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzZ(boolean z) {
        this.zzn.zzi(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final void zza(String str) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized boolean zzaA() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final boolean zzaB() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized boolean zzaC() {
        return this.zzx;
    }

    @Override // com.google.android.gms.internal.ads.zzchg
    public final void zzaD(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z) {
        this.zzn.zzt(zzcVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzchg
    public final void zzaE(String str, String str2, int i) {
        this.zzn.zzu(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzchg
    public final void zzaF(boolean z, int i, boolean z2) {
        this.zzn.zzv(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzchg
    public final void zzaG(boolean z, int i, String str, String str2, boolean z2) {
        this.zzn.zzx(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzchg
    public final void zzaH(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zzn.zzy(z, i, str, z2, z3);
    }

    public final zzcgi zzaJ() {
        return this.zzn;
    }

    final synchronized Boolean zzaK() {
        return this.zzw;
    }

    protected final synchronized void zzaN(String str, ValueCallback valueCallback) {
        if (zzaz()) {
            zzcat.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            evaluateJavascript(str, null);
        }
    }

    protected final void zzaO(String str) {
        if (!PlatformVersion.isAtLeastKitKat()) {
            zzaP("javascript:".concat(str));
            return;
        }
        if (zzaK() == null) {
            zzbb();
        }
        if (zzaK().booleanValue()) {
            zzaN(str, null);
        } else {
            zzaP("javascript:".concat(str));
        }
    }

    protected final synchronized void zzaP(String str) {
        if (zzaz()) {
            zzcat.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    final void zzaQ(Boolean bool) {
        synchronized (this) {
            this.zzw = bool;
        }
        com.google.android.gms.ads.internal.zzt.zzo().zzv(bool);
    }

    public final boolean zzaR() {
        int i;
        int iZzv;
        if (!this.zzn.zzK() && !this.zzn.zzL()) {
            return false;
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics = this.zzh;
        int iZzv2 = zzcam.zzv(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zzh;
        int iZzv3 = zzcam.zzv(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityZza = this.zzb.zza();
        if (activityZza == null || activityZza.getWindow() == null) {
            i = iZzv2;
            iZzv = iZzv3;
        } else {
            com.google.android.gms.ads.internal.zzt.zzp();
            int[] iArrZzP = com.google.android.gms.ads.internal.util.zzt.zzP(activityZza);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            int iZzv4 = zzcam.zzv(this.zzh, iArrZzP[0]);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            iZzv = zzcam.zzv(this.zzh, iArrZzP[1]);
            i = iZzv4;
        }
        int i2 = this.zzQ;
        if (i2 == iZzv2 && this.zzP == iZzv3 && this.zzR == i && this.zzS == iZzv) {
            return false;
        }
        boolean z = (i2 == iZzv2 && this.zzP == iZzv3) ? false : true;
        this.zzQ = iZzv2;
        this.zzP = iZzv3;
        this.zzR = i;
        this.zzS = iZzv;
        new zzbry(this, "").zzi(iZzv2, iZzv3, i, iZzv, this.zzh.density, this.zzU.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzaa() {
        this.zzO.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzab(String str, String str2, String str3) {
        String str4;
        if (zzaz()) {
            zzcat.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        String[] strArr = new String[1];
        String str5 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzP);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", str5);
            jSONObject.put("sdk", "Google Mobile Ads");
            jSONObject.put("sdkVersion", "12.4.51-000");
            str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
        } catch (JSONException e) {
            zzcat.zzk("Unable to build MRAID_ENV", e);
            str4 = null;
        }
        strArr[0] = str4;
        super.loadDataWithBaseURL(str, zzchh.zza(str2, strArr), "text/html", "UTF-8", null);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzac() {
        if (this.zzJ == null) {
            this.zzK.zza();
            zzbcx zzbcxVarZzf = zzbda.zzf();
            this.zzJ = zzbcxVarZzf;
            this.zzK.zzb("native:view_load", zzbcxVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzad(String str, zzbjj zzbjjVar) {
        zzcgi zzcgiVar = this.zzn;
        if (zzcgiVar != null) {
            zzcgiVar.zzz(str, zzbjjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzae() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzaf(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzo = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzag(zzchq zzchqVar) {
        this.zzq = zzchqVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzah(zzawj zzawjVar) {
        this.zzE = zzawjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzai(boolean z) {
        this.zzx = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzaj() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzak(Context context) {
        this.zzb.setBaseContext(context);
        this.zzO.zze(this.zzb.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzal(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzy(this.zzn.zzK(), z);
        } else {
            this.zzs = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzam(zzbez zzbezVar) {
        this.zzD = zzbezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzan(boolean z) {
        boolean z2 = this.zzu;
        this.zzu = z;
        zzaS();
        if (z != z2) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzQ)).booleanValue() || !this.zzq.zzi()) {
                new zzbry(this, "").zzk(true != z ? "default" : "expanded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzao(zzbfb zzbfbVar) {
        this.zzC = zzbfbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzap(zzfkc zzfkcVar) {
        this.zzp = zzfkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzaq(int i) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzA(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzar(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzM = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzas(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar;
        int i = this.zzF + (true != z ? -1 : 1);
        this.zzF = i;
        if (i > 0 || (zzlVar = this.zzo) == null) {
            return;
        }
        zzlVar.zzE();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:8:0x000b A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0007, B:8:0x000b), top: B:16:0x0004 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:11:0x0010, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized void zzat(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar;
        if (!z) {
            zzlVar = this.zzo;
            if (zzlVar != null) {
                zzlVar.zzB(z);
                return;
            }
            return;
        }
        setBackgroundColor(0);
        zzlVar = this.zzo;
        if (zzlVar != null) {
            zzlVar.zzB(z);
            return;
        }
        return;
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzau(String str, zzbjj zzbjjVar) {
        zzcgi zzcgiVar = this.zzn;
        if (zzcgiVar != null) {
            zzcgiVar.zzH(str, zzbjjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzav(String str, Predicate predicate) {
        zzcgi zzcgiVar = this.zzn;
        if (zzcgiVar != null) {
            zzcgiVar.zzI(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized boolean zzaw() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized boolean zzax() {
        return this.zzF > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final boolean zzay(final boolean z, final int i) {
        destroy();
        this.zzV.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzcgr
            @Override // com.google.android.gms.internal.ads.zzaxu
            public final void zza(zzazk zzazkVar) {
                int i2 = zzcgu.zza;
                zzbbp zzbbpVarZza = zzbbq.zza();
                boolean zZzc = zzbbpVarZza.zzc();
                boolean z2 = z;
                if (zZzc != z2) {
                    zzbbpVarZza.zza(z2);
                }
                zzbbpVarZza.zzb(i);
                zzazkVar.zzj((zzbbq) zzbbpVarZza.zzal());
            }
        });
        this.zzV.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final synchronized boolean zzaz() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final void zzb(String str, String str2) {
        zzaO(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.ads.zzdfd
    public final void zzbK() {
        zzcgi zzcgiVar = this.zzn;
        if (zzcgiVar != null) {
            zzcgiVar.zzbK();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbj() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzf;
        if (zzlVar != null) {
            zzlVar.zzbj();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbk() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzf;
        if (zzlVar != null) {
            zzlVar.zzbk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final synchronized String zzbl() {
        zzfcv zzfcvVar = this.zzk;
        if (zzfcvVar == null) {
            return null;
        }
        return zzfcvVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final synchronized String zzbm() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zzbt(zzauv zzauvVar) {
        synchronized (this) {
            this.zzA = zzauvVar.zzj;
        }
        zzaV(zzauvVar.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbmd
    public final void zzd(String str, Map map) {
        try {
            zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzcat.zzj("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmd
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        zzcat.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzaO(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final synchronized int zzf() {
        return this.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzchc, com.google.android.gms.internal.ads.zzcdc
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzcdc
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzbcx zzk() {
        return this.zzI;
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzcdc
    public final zzbcy zzm() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzchk, com.google.android.gms.internal.ads.zzcdc
    public final zzcaz zzn() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzccr zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final synchronized zzcen zzp(String str) {
        Map map = this.zzT;
        if (map == null) {
            return null;
        }
        return (zzcen) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzcdc
    public final synchronized zzcgx zzq() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzdfd
    public final void zzs() {
        zzcgi zzcgiVar = this.zzn;
        if (zzcgiVar != null) {
            zzcgiVar.zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, com.google.android.gms.internal.ads.zzcdc
    public final synchronized void zzt(String str, zzcen zzcenVar) {
        if (this.zzT == null) {
            this.zzT = new HashMap();
        }
        this.zzT.put(str, zzcenVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final void zzu() {
        com.google.android.gms.ads.internal.overlay.zzl zzlVarZzL = zzL();
        if (zzlVarZzL != null) {
            zzlVarZzL.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final void zzv(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put("success", true != z ? "0" : "1");
        map.put("duration", Long.toString(j));
        zzd("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final synchronized void zzw() {
        zzbez zzbezVar = this.zzD;
        if (zzbezVar != null) {
            final zzdnj zzdnjVar = (zzdnj) zzbezVar;
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdnh
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdnjVar.zzd();
                    } catch (RemoteException e) {
                        zzcat.zzl("#007 Could not call remote method.", e);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final void zzz(boolean z) {
        this.zzn.zzC(false);
    }
}

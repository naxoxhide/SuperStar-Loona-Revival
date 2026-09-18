package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzarp;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzbtk;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzbzh;
import com.google.android.gms.internal.ads.zzbzj;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzcaz;
import com.google.android.gms.internal.ads.zzcbg;
import com.google.android.gms.internal.ads.zzchw;
import com.google.android.gms.internal.ads.zzcwt;
import com.google.android.gms.internal.ads.zzdda;
import com.google.android.gms.internal.ads.zzdoi;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzdst;
import com.google.android.gms.internal.ads.zzfdl;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfis;
import com.google.android.gms.internal.ads.zzfit;
import com.google.android.gms.internal.ads.zzfje;
import com.google.android.gms.internal.ads.zzfjh;
import com.google.android.gms.internal.ads.zzfjx;
import com.google.android.gms.internal.ads.zzfsk;
import com.google.android.gms.internal.ads.zzftl;
import com.google.android.gms.internal.ads.zzfyz;
import com.google.android.gms.internal.ads.zzfza;
import com.google.android.gms.internal.ads.zzfzk;
import com.google.android.gms.internal.ads.zzfzt;
import com.google.android.gms.internal.ads.zzgad;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaa extends zzbzj {
    protected static final List zza = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List zzb = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List zzc = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List zzd = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public static final /* synthetic */ int zze = 0;
    private final zzcaz zzA;
    private String zzB;
    private final List zzD;
    private final List zzE;
    private final List zzF;
    private final List zzG;
    private final zzchw zzf;
    private Context zzg;
    private final zzaro zzh;
    private final zzfek zzi;
    private final zzgad zzk;
    private final ScheduledExecutorService zzl;
    private zzbtt zzm;
    private final zzc zzq;
    private final zzdst zzr;
    private final zzfjx zzs;
    private zzdsj zzj = null;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final Set zzp = Collections.newSetFromMap(new WeakHashMap());
    private final AtomicInteger zzz = new AtomicInteger(0);
    private final boolean zzt = ((Boolean) zzba.zzc().zzb(zzbci.zzhi)).booleanValue();
    private final boolean zzu = ((Boolean) zzba.zzc().zzb(zzbci.zzhh)).booleanValue();
    private final boolean zzv = ((Boolean) zzba.zzc().zzb(zzbci.zzhk)).booleanValue();
    private final boolean zzw = ((Boolean) zzba.zzc().zzb(zzbci.zzhm)).booleanValue();
    private final String zzx = (String) zzba.zzc().zzb(zzbci.zzhl);
    private final String zzy = (String) zzba.zzc().zzb(zzbci.zzhn);
    private final String zzC = (String) zzba.zzc().zzb(zzbci.zzho);

    public zzaa(zzchw zzchwVar, Context context, zzaro zzaroVar, zzfek zzfekVar, zzgad zzgadVar, ScheduledExecutorService scheduledExecutorService, zzdst zzdstVar, zzfjx zzfjxVar, zzcaz zzcazVar) {
        List listZzY;
        this.zzf = zzchwVar;
        this.zzg = context;
        this.zzh = zzaroVar;
        this.zzi = zzfekVar;
        this.zzk = zzgadVar;
        this.zzl = scheduledExecutorService;
        this.zzq = zzchwVar.zzn();
        this.zzr = zzdstVar;
        this.zzs = zzfjxVar;
        this.zzA = zzcazVar;
        if (((Boolean) zzba.zzc().zzb(zzbci.zzhp)).booleanValue()) {
            this.zzD = zzY((String) zzba.zzc().zzb(zzbci.zzhq));
            this.zzE = zzY((String) zzba.zzc().zzb(zzbci.zzhr));
            this.zzF = zzY((String) zzba.zzc().zzb(zzbci.zzhs));
            listZzY = zzY((String) zzba.zzc().zzb(zzbci.zzht));
        } else {
            this.zzD = zza;
            this.zzE = zzb;
            this.zzF = zzc;
            listZzY = zzd;
        }
        this.zzG = listZzY;
    }

    static /* bridge */ /* synthetic */ void zzF(zzaa zzaaVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzaaVar.zzN((Uri) it.next())) {
                zzaaVar.zzz.getAndIncrement();
                return;
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzG(final zzaa zzaaVar, final String str, final String str2, final zzdsj zzdsjVar) {
        if (((Boolean) zzba.zzc().zzb(zzbci.zzgT)).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbci.zzgZ)).booleanValue()) {
                zzcbg.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzI(str, str2, zzdsjVar);
                    }
                });
            } else {
                zzaaVar.zzq.zzd(str, str2, zzdsjVar);
            }
        }
    }

    static final /* synthetic */ Uri zzP(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzX(uri, "nas", str) : uri;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    private final zzh zzQ(Context context, String str, String str2, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        byte b2;
        zzfdl zzfdlVar = new zzfdl();
        if ("REWARDED".equals(str2)) {
            zzfdlVar.zzo().zza(2);
        } else if ("REWARDED_INTERSTITIAL".equals(str2)) {
            zzfdlVar.zzo().zza(3);
        }
        zzg zzgVarZzo = this.zzf.zzo();
        zzcwt zzcwtVar = new zzcwt();
        zzcwtVar.zze(context);
        if (str == null) {
            str = "adUnitId";
        }
        zzfdlVar.zzs(str);
        if (zzlVar == null) {
            zzlVar = new com.google.android.gms.ads.internal.client.zzm().zza();
        }
        zzfdlVar.zzE(zzlVar);
        if (zzqVar == null) {
            switch (str2) {
                case "NATIVE":
                    b2 = 3;
                    break;
                case "APP_OPEN_AD":
                    b2 = 4;
                    break;
                case "REWARDED":
                    b2 = 1;
                    break;
                case "REWARDED_INTERSTITIAL":
                    b2 = 2;
                    break;
                case "BANNER":
                    b2 = 0;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                zzqVar = new com.google.android.gms.ads.internal.client.zzq(context, AdSize.BANNER);
            } else if (b2 == 1 || b2 == 2) {
                zzqVar = com.google.android.gms.ads.internal.client.zzq.zzd();
            } else if (b2 != 3) {
                zzqVar = b2 != 4 ? new com.google.android.gms.ads.internal.client.zzq() : com.google.android.gms.ads.internal.client.zzq.zzb();
            } else {
                zzqVar = com.google.android.gms.ads.internal.client.zzq.zzc();
            }
        }
        zzfdlVar.zzr(zzqVar);
        zzfdlVar.zzx(true);
        zzcwtVar.zzi(zzfdlVar.zzG());
        zzgVarZzo.zza(zzcwtVar.zzj());
        zzac zzacVar = new zzac();
        zzacVar.zza(str2);
        zzgVarZzo.zzb(new zzae(zzacVar, null));
        new zzdda();
        zzh zzhVarZzc = zzgVarZzo.zzc();
        this.zzj = zzhVarZzc.zza();
        return zzhVarZzc;
    }

    private final ListenableFuture zzR(final String str) {
        final zzdoi[] zzdoiVarArr = new zzdoi[1];
        ListenableFuture listenableFutureZzn = zzfzt.zzn(this.zzi.zza(), new zzfza() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzv(zzdoiVarArr, str, (zzdoi) obj);
            }
        }, this.zzk);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzH(zzdoiVarArr);
            }
        }, this.zzk);
        return zzfzt.zze(zzfzt.zzm((zzfzk) zzfzt.zzo(zzfzk.zzu(listenableFutureZzn), ((Integer) zzba.zzc().zzb(zzbci.zzhA)).intValue(), TimeUnit.MILLISECONDS, this.zzl), new zzfsk() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzs
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                int i = zzaa.zze;
                return ((JSONObject) obj).optString("nas");
            }
        }, this.zzk), Exception.class, new zzfsk() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzt
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                int i = zzaa.zze;
                zzcat.zzh("", (Exception) obj);
                return null;
            }
        }, this.zzk);
    }

    private final void zzS() {
        if (((Boolean) zzba.zzc().zzb(zzbci.zzjh)).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbci.zzjk)).booleanValue()) {
                return;
            }
            zzfzt.zzr(((Boolean) zzba.zzc().zzb(zzbci.zzkh)).booleanValue() ? zzfzt.zzk(new zzfyz() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
                @Override // com.google.android.gms.internal.ads.zzfyz
                public final ListenableFuture zza() {
                    return this.zza.zzu();
                }
            }, zzcbg.zza) : zzQ(this.zzg, null, AdFormat.BANNER.name(), null, null).zzc(), new zzz(this), this.zzf.zzB());
        }
    }

    private final void zzT(List list, final IObjectWrapper iObjectWrapper, zzbtk zzbtkVar, boolean z) {
        ListenableFuture listenableFutureZzb;
        if (!((Boolean) zzba.zzc().zzb(zzbci.zzhz)).booleanValue()) {
            zzcat.zzj("The updating URL feature is not enabled.");
            try {
                zzbtkVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                zzcat.zzh("", e);
                return;
            }
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (zzN((Uri) it.next())) {
                i++;
            }
        }
        if (i > 1) {
            zzcat.zzj("Multiple google urls found: ".concat(String.valueOf(String.valueOf(list))));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (zzN(uri)) {
                listenableFutureZzb = this.zzk.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzm(uri, iObjectWrapper);
                    }
                });
                if (zzW()) {
                    listenableFutureZzb = zzfzt.zzn(listenableFutureZzb, new zzfza() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzo
                        @Override // com.google.android.gms.internal.ads.zzfza
                        public final ListenableFuture zza(Object obj) {
                            zzaa zzaaVar = this.zza;
                            return zzfzt.zzm(zzaaVar.zzR("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzfsk() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzp
                                @Override // com.google.android.gms.internal.ads.zzfsk
                                public final Object apply(Object obj2) {
                                    return zzaa.zzP(uri, (String) obj2);
                                }
                            }, zzaaVar.zzk);
                        }
                    }, this.zzk);
                } else {
                    zzcat.zzi("Asset view map is empty.");
                }
            } else {
                zzcat.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                listenableFutureZzb = zzfzt.zzh(uri);
            }
            arrayList.add(listenableFutureZzb);
        }
        zzfzt.zzr(zzfzt.zzd(arrayList), new zzy(this, zzbtkVar, z), this.zzf.zzB());
    }

    private final void zzU(final List list, final IObjectWrapper iObjectWrapper, zzbtk zzbtkVar, boolean z) {
        if (!((Boolean) zzba.zzc().zzb(zzbci.zzhz)).booleanValue()) {
            try {
                zzbtkVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                zzcat.zzh("", e);
                return;
            }
        }
        ListenableFuture listenableFutureZzb = this.zzk.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzC(list, iObjectWrapper);
            }
        });
        if (zzW()) {
            listenableFutureZzb = zzfzt.zzn(listenableFutureZzb, new zzfza() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzv
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzw((ArrayList) obj);
                }
            }, this.zzk);
        } else {
            zzcat.zzi("Asset view map is empty.");
        }
        zzfzt.zzr(listenableFutureZzb, new zzx(this, zzbtkVar, z), this.zzf.zzB());
    }

    private static boolean zzV(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean zzW() {
        Map map;
        zzbtt zzbttVar = this.zzm;
        return (zzbttVar == null || (map = zzbttVar.zzb) == null || map.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri zzX(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(string.substring(0, i) + str + "=" + str2 + "&" + string.substring(i));
    }

    private static final List zzY(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzftl.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzfje zzr(ListenableFuture listenableFuture, zzbzo zzbzoVar) {
        if (!zzfjh.zza() || !((Boolean) zzbdu.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfje zzfjeVarZzb = ((zzh) zzfzt.zzp(listenableFuture)).zzb();
            zzfjeVarZzb.zzd(new ArrayList(Collections.singletonList(zzbzoVar.zzb)));
            com.google.android.gms.ads.internal.client.zzl zzlVar = zzbzoVar.zzd;
            zzfjeVarZzb.zzb(zzlVar == null ? "" : zzlVar.zzp);
            return zzfjeVarZzb;
        } catch (ExecutionException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzO(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzX(uri, "nas", str));
            }
        }
        return arrayList;
    }

    final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        this.zzh.zzc();
        String strZzh = this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        if (TextUtils.isEmpty(strZzh)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzO(uri)) {
                arrayList.add(zzX(uri, "ms", strZzh));
            } else {
                zzcat.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                arrayList.add(uri);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }

    final /* synthetic */ void zzH(zzdoi[] zzdoiVarArr) {
        zzdoi zzdoiVar = zzdoiVarArr[0];
        if (zzdoiVar != null) {
            this.zzi.zzb(zzfzt.zzh(zzdoiVar));
        }
    }

    final /* synthetic */ void zzI(String str, String str2, zzdsj zzdsjVar) {
        this.zzq.zzd(str, str2, zzdsjVar);
    }

    final boolean zzN(Uri uri) {
        return zzV(uri, this.zzD, this.zzE);
    }

    final boolean zzO(Uri uri) {
        return zzV(uri, this.zzF, this.zzG);
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zze(IObjectWrapper iObjectWrapper, final zzbzo zzbzoVar, zzbzh zzbzhVar) {
        ListenableFuture listenableFutureZzc;
        ListenableFuture listenableFuture;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfit zzfitVarZza = zzfis.zza(context, 22);
        zzfitVarZza.zzh();
        if (((Boolean) zzba.zzc().zzb(zzbci.zzkh)).booleanValue()) {
            ListenableFuture listenableFutureZzb = zzcbg.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzq(zzbzoVar);
                }
            });
            listenableFuture = listenableFutureZzb;
            listenableFutureZzc = zzfzt.zzn(listenableFutureZzb, new zzfza() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzr
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return ((zzh) obj).zzc();
                }
            }, zzcbg.zza);
        } else {
            zzh zzhVarZzQ = zzQ(this.zzg, zzbzoVar.zza, zzbzoVar.zzb, zzbzoVar.zzc, zzbzoVar.zzd);
            ListenableFuture listenableFutureZzh = zzfzt.zzh(zzhVarZzQ);
            listenableFutureZzc = zzhVarZzQ.zzc();
            listenableFuture = listenableFutureZzh;
        }
        zzfzt.zzr(listenableFutureZzc, new zzw(this, listenableFuture, zzbzoVar, zzbzhVar, zzfitVarZza, com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()), this.zzf.zzB());
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zzf(zzbtt zzbttVar) {
        this.zzm = zzbttVar;
        this.zzi.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) {
        zzT(list, iObjectWrapper, zzbtkVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) {
        zzU(list, iObjectWrapper, zzbtkVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zzi(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zzb(zzbci.zzjg)).booleanValue()) {
            if (Build.VERSION.SDK_INT < 21) {
                zzcat.zzj("Not registering the webview because the Android API level is lower than Lollopop which has security risks on webviews.");
                return;
            }
            if (!((Boolean) zzba.zzc().zzb(zzbci.zzhy)).booleanValue()) {
                zzS();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzcat.zzg("The webView cannot be null.");
                return;
            }
            if (this.zzp.contains(webView)) {
                zzcat.zzi("This webview has already been registered.");
                return;
            }
            this.zzp.add(webView);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzr, this.zzs), "gmaSdk");
            if (((Boolean) zzba.zzc().zzb(zzbci.zzhy)).booleanValue()) {
                zzS();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zzb(zzbci.zzhz)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbtt zzbttVar = this.zzm;
            this.zzn = zzbz.zza(motionEvent, zzbttVar == null ? null : zzbttVar.zza);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setLocation(this.zzn.x, this.zzn.y);
            this.zzh.zzd(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) {
        zzT(list, iObjectWrapper, zzbtkVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbzk
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) {
        zzU(list, iObjectWrapper, zzbtkVar, false);
    }

    final /* synthetic */ Uri zzm(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzarp e) {
            zzcat.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    final /* synthetic */ zzh zzq(zzbzo zzbzoVar) throws Exception {
        return zzQ(this.zzg, zzbzoVar.zza, zzbzoVar.zzb, zzbzoVar.zzc, zzbzoVar.zzd);
    }

    final /* synthetic */ ListenableFuture zzu() throws Exception {
        return zzQ(this.zzg, null, AdFormat.BANNER.name(), null, null).zzc();
    }

    final /* synthetic */ ListenableFuture zzv(zzdoi[] zzdoiVarArr, String str, zzdoi zzdoiVar) throws Exception {
        zzdoiVarArr[0] = zzdoiVar;
        Context context = this.zzg;
        zzbtt zzbttVar = this.zzm;
        Map map = zzbttVar.zzb;
        JSONObject jSONObjectZzd = zzbz.zzd(context, map, map, zzbttVar.zza, null);
        JSONObject jSONObjectZzg = zzbz.zzg(this.zzg, this.zzm.zza);
        JSONObject jSONObjectZzf = zzbz.zzf(this.zzm.zza);
        JSONObject jSONObjectZze = zzbz.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", jSONObjectZzd);
        jSONObject.put("ad_view_signal", jSONObjectZzg);
        jSONObject.put("scroll_view_signal", jSONObjectZzf);
        jSONObject.put("lock_screen_signal", jSONObjectZze);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbz.zzc(null, this.zzg, this.zzo, this.zzn));
        }
        return zzdoiVar.zzd(str, jSONObject);
    }

    final /* synthetic */ ListenableFuture zzw(final ArrayList arrayList) throws Exception {
        return zzfzt.zzm(zzR("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzfsk() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzj
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return this.zza.zzB(arrayList, (String) obj);
            }
        }, this.zzk);
    }
}

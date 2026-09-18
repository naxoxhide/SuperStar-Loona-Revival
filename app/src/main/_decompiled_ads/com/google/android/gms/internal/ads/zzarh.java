package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzarh implements zzark {
    private static zzarh zzb;
    private final Context zzc;
    private final zzfof zzd;
    private final zzfom zze;
    private final zzfoo zzf;
    private final zzasj zzg;
    private final zzfmq zzh;
    private final Executor zzi;
    private final zzfol zzj;
    private final zzasy zzl;
    private final zzasq zzm;
    private final zzash zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    zzarh(Context context, zzfmq zzfmqVar, zzfof zzfofVar, zzfom zzfomVar, zzfoo zzfooVar, zzasj zzasjVar, Executor executor, zzfml zzfmlVar, int i, zzasy zzasyVar, zzasq zzasqVar, zzash zzashVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfmqVar;
        this.zzd = zzfofVar;
        this.zze = zzfomVar;
        this.zzf = zzfooVar;
        this.zzg = zzasjVar;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzasyVar;
        this.zzm = zzasqVar;
        this.zzn = zzashVar;
        this.zzq = false;
        this.zzj = new zzarf(this, zzfmlVar);
    }

    public static synchronized zzarh zza(String str, Context context, boolean z, boolean z2) {
        return zzb(str, context, Executors.newCachedThreadPool(), z, z2);
    }

    @Deprecated
    public static synchronized zzarh zzb(String str, Context context, Executor executor, boolean z, boolean z2) {
        if (zzb == null) {
            zzfmr zzfmrVarZza = zzfms.zza();
            zzfmrVarZza.zza(str);
            zzfmrVarZza.zzc(z);
            zzfms zzfmsVarZzd = zzfmrVarZza.zzd();
            zzfmq zzfmqVarZza = zzfmq.zza(context, executor, z2);
            zzars zzarsVarZzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdf)).booleanValue() ? zzars.zzc(context) : null;
            zzasy zzasyVarZzd = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdg)).booleanValue() ? zzasy.zzd(context, executor) : null;
            zzasq zzasqVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcu)).booleanValue() ? new zzasq() : null;
            zzash zzashVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcw)).booleanValue() ? new zzash() : null;
            zzfnj zzfnjVarZze = zzfnj.zze(context, executor, zzfmqVarZza, zzfmsVarZzd);
            zzasi zzasiVar = new zzasi(context);
            zzasj zzasjVar = new zzasj(zzfmsVarZzd, zzfnjVarZze, new zzasw(context, zzasiVar), zzasiVar, zzarsVarZzc, zzasyVarZzd, zzasqVar, zzashVar);
            int iZzb = zzfns.zzb(context, zzfmqVarZza);
            zzfml zzfmlVar = new zzfml();
            zzarh zzarhVar = new zzarh(context, zzfmqVarZza, new zzfof(context, iZzb), new zzfom(context, iZzb, new zzare(zzfmqVarZza), ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcd)).booleanValue()), new zzfoo(context, zzasjVar, zzfmqVarZza, zzfmlVar), zzasjVar, executor, zzfmlVar, iZzb, zzasyVarZzd, zzasqVar, zzashVar);
            zzb = zzarhVar;
            zzarhVar.zzm();
            zzb.zzp();
        }
        return zzb;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ce A[Catch: all -> 0x0129, zzgul -> 0x012b, TRY_LEAVE, TryCatch #0 {zzgul -> 0x012b, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:27:0x009c, B:31:0x00b5, B:37:0x00ce, B:41:0x00e0, B:43:0x00e6, B:45:0x00ee, B:46:0x00f0, B:34:0x00bf, B:35:0x00c6, B:23:0x0074, B:25:0x008a, B:48:0x00fc, B:50:0x010b, B:52:0x011a), top: B:61:0x0021, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00fc A[Catch: all -> 0x0129, zzgul -> 0x012b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {zzgul -> 0x012b, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:27:0x009c, B:31:0x00b5, B:37:0x00ce, B:41:0x00e0, B:43:0x00e6, B:45:0x00ee, B:46:0x00f0, B:34:0x00bf, B:35:0x00c6, B:23:0x0074, B:25:0x008a, B:48:0x00fc, B:50:0x010b, B:52:0x011a), top: B:61:0x0021, outer: #2 }] */
    static /* bridge */ /* synthetic */ void zzj(zzarh zzarhVar) {
        String str;
        String strZzj;
        CountDownLatch countDownLatch;
        int length;
        boolean zZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfoe zzfoeVarZzt = zzarhVar.zzt(1);
        if (zzfoeVarZzt != null) {
            String strZzk = zzfoeVarZzt.zza().zzk();
            strZzj = zzfoeVarZzt.zza().zzj();
            str = strZzk;
        } else {
            str = null;
            strZzj = null;
        }
        try {
            try {
                zzfoj zzfojVarZza = zzfna.zza(zzarhVar.zzc, 1, zzarhVar.zzr, str, strZzj, "1", zzarhVar.zzh);
                byte[] bArr = zzfojVarZza.zzb;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzarhVar.zzh.zzd(5009, System.currentTimeMillis() - jCurrentTimeMillis);
                    countDownLatch = zzarhVar.zzk;
                } else {
                    try {
                        zzaui zzauiVarZzc = zzaui.zzc(zzgsr.zzv(bArr, 0, length), zzgtl.zza());
                        if (zzauiVarZzc.zzd().zzk().isEmpty() || zzauiVarZzc.zzd().zzj().isEmpty() || zzauiVarZzc.zze().zzA().length == 0) {
                            zzarhVar.zzh.zzd(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                            countDownLatch = zzarhVar.zzk;
                        } else {
                            zzfoe zzfoeVarZzt2 = zzarhVar.zzt(1);
                            if (zzfoeVarZzt2 != null) {
                                zzaul zzaulVarZza = zzfoeVarZzt2.zza();
                                if (zzauiVarZzc.zzd().zzk().equals(zzaulVarZza.zzk()) && zzauiVarZzc.zzd().zzj().equals(zzaulVarZza.zzj())) {
                                    zzarhVar.zzh.zzd(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                                    countDownLatch = zzarhVar.zzk;
                                }
                            }
                            zzfol zzfolVar = zzarhVar.zzj;
                            int i = zzfojVarZza.zzc;
                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcb)).booleanValue()) {
                                zZza = zzarhVar.zzd.zza(zzauiVarZzc, zzfolVar);
                            } else if (i == 3) {
                                zZza = zzarhVar.zze.zza(zzauiVarZzc);
                            } else if (i == 4) {
                                zZza = zzarhVar.zze.zzb(zzauiVarZzc, zzfolVar);
                            } else {
                                zzarhVar.zzh.zzd(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                                countDownLatch = zzarhVar.zzk;
                            }
                            if (zZza) {
                                zzfoe zzfoeVarZzt3 = zzarhVar.zzt(1);
                                if (zzfoeVarZzt3 != null) {
                                    if (zzarhVar.zzf.zzc(zzfoeVarZzt3)) {
                                        zzarhVar.zzq = true;
                                    }
                                    zzarhVar.zza = System.currentTimeMillis() / 1000;
                                }
                                countDownLatch = zzarhVar.zzk;
                            } else {
                                zzarhVar.zzh.zzd(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                                countDownLatch = zzarhVar.zzk;
                            }
                        }
                    } catch (NullPointerException unused) {
                        zzarhVar.zzh.zzd(2030, System.currentTimeMillis() - jCurrentTimeMillis);
                        countDownLatch = zzarhVar.zzk;
                    }
                }
            } catch (Throwable th) {
                zzarhVar.zzk.countDown();
                throw th;
            }
        } catch (zzgul e) {
            zzarhVar.zzh.zzc(4002, System.currentTimeMillis() - jCurrentTimeMillis, e);
            countDownLatch = zzarhVar.zzk;
        }
        countDownLatch.countDown();
    }

    private final void zzs() {
        zzasy zzasyVar = this.zzl;
        if (zzasyVar != null) {
            zzasyVar.zzh();
        }
    }

    private final zzfoe zzt(int i) {
        if (zzfns.zza(this.zzr)) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcb)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final String zzf(Context context, String str, View view, Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcu)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfmt zzfmtVarZza = this.zzf.zza();
        if (zzfmtVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzfmtVarZza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final String zzg(Context context) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcu)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfmt zzfmtVarZza = this.zzf.zza();
        if (zzfmtVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzfmtVarZza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final String zzh(Context context, View view, Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcu)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfmt zzfmtVarZza = this.zzf.zza();
        if (zzfmtVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzfmtVarZza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final void zzk(MotionEvent motionEvent) {
        zzfmt zzfmtVarZza = this.zzf.zza();
        if (zzfmtVarZza != null) {
            try {
                zzfmtVarZza.zzd(null, motionEvent);
            } catch (zzfon e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final void zzl(int i, int i2, int i3) {
    }

    final synchronized void zzm() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfoe zzfoeVarZzt = zzt(1);
        if (zzfoeVarZzt == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zzc(zzfoeVarZzt)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzash zzashVar = this.zzn;
        if (zzashVar != null) {
            zzashVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            if (!this.zzp) {
                if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                    return;
                }
                zzfoe zzfoeVarZzb = this.zzf.zzb();
                if ((zzfoeVarZzb == null || zzfoeVarZzb.zzd(3600L)) && zzfns.zza(this.zzr)) {
                    this.zzi.execute(new zzarg(this));
                }
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}

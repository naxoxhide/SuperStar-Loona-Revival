package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjh implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final zzcaz zzf;
    private int zzi;
    private final zzdqg zzj;
    private final List zzk;
    private final zzebk zzm;
    private final zzbvs zzn;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfjm zzg = zzfjp.zzc();
    private String zzh = "";
    private boolean zzl = false;

    public zzfjh(Context context, zzcaz zzcazVar, zzdqg zzdqgVar, zzebk zzebkVar, zzbvs zzbvsVar) {
        this.zze = context;
        this.zzf = zzcazVar;
        this.zzj = zzdqgVar;
        this.zzm = zzebkVar;
        this.zzn = zzbvsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziB)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzt.zzd();
        } else {
            this.zzk = zzfvs.zzl();
        }
    }

    public static boolean zza() {
        boolean zBooleanValue;
        synchronized (zza) {
            if (zzb == null) {
                if (((Boolean) zzbdu.zzb.zze()).booleanValue()) {
                    zzb = Boolean.valueOf(Math.random() < ((Double) zzbdu.zza.zze()).doubleValue());
                } else {
                    zzb = false;
                }
            }
            zBooleanValue = zzb.booleanValue();
        }
        return zBooleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZzax;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() == 0) {
                    return;
                }
                try {
                    synchronized (obj) {
                        bArrZzax = ((zzfjp) this.zzg.zzal()).zzax();
                        this.zzg.zzc();
                    }
                    new zzebj(this.zze, this.zzf.zza, this.zzn, Binder.getCallingUid()).zza(new zzebh((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziv), 60000, new HashMap(), bArrZzax, "application/x-protobuf", false));
                } catch (Exception e) {
                    if ((e instanceof zzdwm) && ((zzdwm) e).zza() == 3) {
                        return;
                    }
                    com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "CuiMonitor.sendCuiPing");
                }
            }
        }
    }

    public final void zzb(final zzfix zzfixVar) {
        zzcbg.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfjg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(zzfixVar);
            }
        });
    }

    final /* synthetic */ void zzc(zzfix zzfixVar) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.zzh = com.google.android.gms.ads.internal.util.zzt.zzp(this.zze);
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziw)).intValue();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkO)).booleanValue()) {
                        long j = iIntValue;
                        zzcbg.zzd.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = iIntValue;
                        zzcbg.zzd.scheduleAtFixedRate(this, j2, j2, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfixVar != null) {
            synchronized (zzc) {
                if (this.zzg.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzix)).intValue()) {
                    return;
                }
                zzfjj zzfjjVarZza = zzfjk.zza();
                zzfjjVarZza.zzt(zzfixVar.zzl());
                zzfjjVarZza.zzp(zzfixVar.zzk());
                zzfjjVarZza.zzg(zzfixVar.zzb());
                zzfjjVarZza.zzv(3);
                zzfjjVarZza.zzm(this.zzf.zza);
                zzfjjVarZza.zzb(this.zzh);
                zzfjjVarZza.zzk(Build.VERSION.RELEASE);
                zzfjjVarZza.zzq(Build.VERSION.SDK_INT);
                zzfjjVarZza.zzu(zzfixVar.zzn());
                zzfjjVarZza.zzj(zzfixVar.zza());
                zzfjjVarZza.zze(this.zzi);
                zzfjjVarZza.zzs(zzfixVar.zzm());
                zzfjjVarZza.zzc(zzfixVar.zzd());
                zzfjjVarZza.zzf(zzfixVar.zzf());
                zzfjjVarZza.zzh(zzfixVar.zzg());
                zzfjjVarZza.zzi(this.zzj.zzc(zzfixVar.zzg()));
                zzfjjVarZza.zzl(zzfixVar.zzh());
                zzfjjVarZza.zzd(zzfixVar.zze());
                zzfjjVarZza.zzr(zzfixVar.zzj());
                zzfjjVarZza.zzn(zzfixVar.zzi());
                zzfjjVarZza.zzo(zzfixVar.zzc());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziB)).booleanValue()) {
                    zzfjjVarZza.zza(this.zzk);
                }
                zzfjm zzfjmVar = this.zzg;
                zzfjn zzfjnVarZza = zzfjo.zza();
                zzfjnVarZza.zza(zzfjjVarZza);
                zzfjmVar.zzb(zzfjnVarZza);
            }
        }
    }
}

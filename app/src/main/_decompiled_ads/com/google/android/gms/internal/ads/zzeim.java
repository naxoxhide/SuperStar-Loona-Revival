package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeim implements zzfzp {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfcv zzb;
    final /* synthetic */ zzfcr zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfjt zze;
    final /* synthetic */ zzfde zzf;
    final /* synthetic */ zzeio zzg;

    zzeim(zzeio zzeioVar, long j, zzfcv zzfcvVar, zzfcr zzfcrVar, String str, zzfjt zzfjtVar, zzfde zzfdeVar) {
        this.zzg = zzeioVar;
        this.zza = j;
        this.zzb = zzfcvVar;
        this.zzc = zzfcrVar;
        this.zzd = str;
        this.zze = zzfjtVar;
        this.zzf = zzfdeVar;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006c A[Catch: all -> 0x0100, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006c, B:34:0x0078, B:35:0x007b, B:36:0x0084, B:38:0x0096, B:39:0x00ab, B:41:0x00b3, B:49:0x00f1, B:50:0x00fc, B:44:0x00d6, B:46:0x00da, B:48:0x00e4, B:52:0x00fe), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0078 A[Catch: all -> 0x0100, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006c, B:34:0x0078, B:35:0x007b, B:36:0x0084, B:38:0x0096, B:39:0x00ab, B:41:0x00b3, B:49:0x00f1, B:50:0x00fc, B:44:0x00d6, B:46:0x00da, B:48:0x00e4, B:52:0x00fe), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0096 A[Catch: all -> 0x0100, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006c, B:34:0x0078, B:35:0x007b, B:36:0x0084, B:38:0x0096, B:39:0x00ab, B:41:0x00b3, B:49:0x00f1, B:50:0x00fc, B:44:0x00d6, B:46:0x00da, B:48:0x00e4, B:52:0x00fe), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3 A[Catch: all -> 0x0100, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006c, B:34:0x0078, B:35:0x007b, B:36:0x0084, B:38:0x0096, B:39:0x00ab, B:41:0x00b3, B:49:0x00f1, B:50:0x00fc, B:44:0x00d6, B:46:0x00da, B:48:0x00e4, B:52:0x00fe), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00fe A[Catch: all -> 0x0100, DONT_GENERATE, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006c, B:34:0x0078, B:35:0x007b, B:36:0x0084, B:38:0x0096, B:39:0x00ab, B:41:0x00b3, B:49:0x00f1, B:50:0x00fc, B:44:0x00d6, B:46:0x00da, B:48:0x00e4, B:52:0x00fe), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x001a A[PHI: r5
      0x001a: PHI (r5v10 int) = (r5v0 int), (r5v1 int), (r5v1 int), (r5v1 int), (r5v11 int) binds: [B:17:0x0031, B:22:0x004c, B:24:0x0050, B:26:0x0059, B:5:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        Integer numValueOf;
        int i;
        zzeio zzeioVar;
        zzeio zzeioVar2;
        com.google.android.gms.ads.internal.client.zze zzeVarZza;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        long jElapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        int i3 = 6;
        if (!(th instanceof TimeoutException)) {
            if (th instanceof zzehw) {
                numValueOf = null;
                i3 = 3;
            } else if (th instanceof CancellationException) {
                i = 4;
            } else if (th instanceof zzfds) {
                i = 5;
            } else if (th instanceof zzdwm) {
                i3 = zzfeo.zza(th).zza == 3 ? 1 : 6;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbA)).booleanValue() && (th instanceof zzeey) && (zzeVarZzb = ((zzeey) th).zzb()) != null) {
                    numValueOf = Integer.valueOf(zzeVarZzb.zza);
                } else {
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            synchronized (this.zzg) {
                zzeioVar = this.zzg;
                if (zzeioVar.zze) {
                    zzeioVar.zzb.zza(this.zzb, this.zzc, i3, th instanceof zzeey ? (zzeey) th : null, jElapsedRealtime);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzie)).booleanValue()) {
                    zzfjx zzfjxVar = this.zzg.zzc;
                    zzfjt zzfjtVar = this.zze;
                    zzfde zzfdeVar = this.zzf;
                    zzfcr zzfcrVar = this.zzc;
                    zzfjxVar.zzd(zzfjtVar.zzc(zzfdeVar, zzfcrVar, zzfcrVar.zzp));
                }
                zzeioVar2 = this.zzg;
                if (zzeioVar2.zzg) {
                }
                LinkedHashMap linkedHashMap = zzeioVar2.zzd;
                zzfcr zzfcrVar2 = this.zzc;
                linkedHashMap.put(zzfcrVar2, new zzein(this.zzd, zzfcrVar2.zzah, i3, jElapsedRealtime, numValueOf));
                zzeVarZza = zzfeo.zza(th);
                i2 = zzeVarZza.zza;
                if ((i2 != 3 || i2 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                }
                this.zzg.zzf.zzf(this.zzc, jElapsedRealtime, zzeVarZza);
            }
        }
        i = 2;
        i3 = i;
        numValueOf = null;
        synchronized (this.zzg) {
            zzeioVar = this.zzg;
            if (zzeioVar.zze) {
                zzeioVar.zzb.zza(this.zzb, this.zzc, i3, th instanceof zzeey ? (zzeey) th : null, jElapsedRealtime);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzie)).booleanValue()) {
                zzfjx zzfjxVar2 = this.zzg.zzc;
                zzfjt zzfjtVar2 = this.zze;
                zzfde zzfdeVar2 = this.zzf;
                zzfcr zzfcrVar3 = this.zzc;
                zzfjxVar2.zzd(zzfjtVar2.zzc(zzfdeVar2, zzfcrVar3, zzfcrVar3.zzp));
            }
            zzeioVar2 = this.zzg;
            if (zzeioVar2.zzg) {
                LinkedHashMap linkedHashMap2 = zzeioVar2.zzd;
                zzfcr zzfcrVar4 = this.zzc;
                linkedHashMap2.put(zzfcrVar4, new zzein(this.zzd, zzfcrVar4.zzah, i3, jElapsedRealtime, numValueOf));
                zzeVarZza = zzfeo.zza(th);
                i2 = zzeVarZza.zza;
                zzeVarZza = i2 != 3 ? zzfeo.zza(new zzeey(13, zzeVarZza.zzd)) : zzfeo.zza(new zzeey(13, zzeVarZza.zzd));
                this.zzg.zzf.zzf(this.zzc, jElapsedRealtime, zzeVarZza);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zzb(Object obj) {
        long jElapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            zzeio zzeioVar = this.zzg;
            if (zzeioVar.zze) {
                zzeioVar.zzb.zza(this.zzb, this.zzc, 0, null, jElapsedRealtime);
            }
            zzeio zzeioVar2 = this.zzg;
            if (zzeioVar2.zzg) {
                return;
            }
            if (zzeioVar2.zzq(this.zzc)) {
                ((zzein) this.zzg.zzd.get(this.zzc)).zzd = jElapsedRealtime;
            } else {
                LinkedHashMap linkedHashMap = this.zzg.zzd;
                zzfcr zzfcrVar = this.zzc;
                linkedHashMap.put(zzfcrVar, new zzein(this.zzd, zzfcrVar.zzah, 0, jElapsedRealtime, null));
            }
            this.zzg.zzf.zzg(this.zzc, jElapsedRealtime, null);
        }
    }
}

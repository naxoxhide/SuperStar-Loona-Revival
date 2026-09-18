package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcew extends zzcen implements zzccs {
    public static final /* synthetic */ int zzd = 0;
    private zzcct zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcef zzi;
    private long zzj;
    private long zzk;

    public zzcew(zzcdc zzcdcVar, zzcdb zzcdbVar) {
        super(zzcdcVar);
        zzcfo zzcfoVar = new zzcfo(zzcdcVar.getContext(), zzcdbVar, (zzcdc) this.zzc.get(), null);
        zzcat.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzcfoVar;
        zzcfoVar.zzL(this);
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(zzcam.zze(str)));
    }

    private static String zzd(String str, Exception exc) {
        return str + RemoteSettings.FORWARD_SLASH_STRING + exc.getClass().getCanonicalName() + CertificateUtil.DELIMITER + exc.getMessage();
    }

    private final void zzx(long j) {
        com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcev
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.zza.zzb();
            }
        }, j);
    }

    @Override // com.google.android.gms.internal.ads.zzcen, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcct zzcctVar = this.zze;
        if (zzcctVar != null) {
            zzcctVar.zzL(null);
            this.zze.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzD(int i, int i2) {
    }

    public final zzcct zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcct zzcctVar = this.zze;
        this.zze = null;
        return zzcctVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.google.android.gms.internal.ads.zzcen, com.google.android.gms.internal.ads.zzcew] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [com.google.android.gms.internal.ads.zzcew] */
    /* JADX WARN: Type inference failed for: r2v31 */
    final /* synthetic */ void zzb() throws Throwable {
        String str;
        zzcew zzcewVarBooleanValue;
        zzcew zzcewVar;
        zzcew zzcewVar2;
        long j;
        String str2;
        long j2;
        String strZzc = zzc(this.zzf);
        Object obj = "error";
        try {
            zzbca zzbcaVar = zzbci.zzx;
            zzbcg zzbcgVarZzc = com.google.android.gms.ads.internal.client.zzba.zzc();
            long jLongValue = ((Long) zzbcgVarZzc.zzb(zzbcaVar)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzw)).intValue();
            zzcewVarBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue();
            try {
                synchronized (this) {
                    try {
                        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
                        long j3 = this.zzj;
                        if (jCurrentTimeMillis - j3 <= jLongValue) {
                            try {
                                if (this.zzg) {
                                    throw new IOException("Abort requested before buffering finished. ");
                                }
                                if (!this.zzh) {
                                    if (!this.zze.zzV()) {
                                        throw new IOException("ExoPlayer was released during preloading.");
                                    }
                                    long jZzz = this.zze.zzz();
                                    if (jZzz > 0) {
                                        long jZzv = this.zze.zzv();
                                        if (jZzv != this.zzk) {
                                            try {
                                                str2 = strZzc;
                                                try {
                                                    zzo(this.zzf, strZzc, jZzv, jZzz, jZzv > 0, zzcewVarBooleanValue != 0 ? this.zze.zzA() : -1L, zzcewVarBooleanValue != 0 ? this.zze.zzx() : -1L, zzcewVarBooleanValue != 0 ? this.zze.zzB() : -1L, zzcct.zzs(), zzcct.zzu());
                                                    zzcewVarBooleanValue = this;
                                                    j = jZzv;
                                                    try {
                                                        zzcewVarBooleanValue.zzk = j;
                                                        j2 = jZzz;
                                                        zzcewVarBooleanValue = zzcewVarBooleanValue;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        str = str2;
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    zzcewVarBooleanValue = this;
                                                    str = str2;
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                zzcewVarBooleanValue = this;
                                                str = strZzc;
                                                throw th;
                                            }
                                        } else {
                                            j = jZzv;
                                            str2 = strZzc;
                                            zzcewVarBooleanValue = this;
                                            j2 = jZzz;
                                        }
                                        if (j >= j2) {
                                            zzcewVarBooleanValue.zzj(zzcewVarBooleanValue.zzf, str2, j2);
                                            zzcewVar = zzcewVarBooleanValue;
                                        } else if (zzcewVarBooleanValue.zze.zzw() >= jIntValue && j > 0) {
                                            zzcewVar = zzcewVarBooleanValue;
                                        }
                                    } else {
                                        zzcewVar2 = this;
                                    }
                                    zzcewVar2.zzx(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzy)).longValue());
                                    return;
                                }
                                zzcewVar = this;
                                com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcewVar.zzi);
                            } catch (Throwable th4) {
                                th = th4;
                                obj = zzbcgVarZzc;
                                str = j3;
                            }
                        } else {
                            str = strZzc;
                            zzcewVarBooleanValue = this;
                            try {
                                throw new IOException("Timeout reached. Limit: " + jLongValue + " ms");
                            } catch (Throwable th5) {
                                th = th5;
                                obj = "downloadTimeout";
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str = strZzc;
                        zzcewVarBooleanValue = this;
                    }
                    try {
                        throw th;
                    } catch (Exception e) {
                        e = e;
                        String str3 = obj;
                        zzcat.zzj("Failed to preload url " + zzcewVarBooleanValue.zzf + " Exception: " + e.getMessage());
                        com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "VideoStreamExoPlayerCache.preload");
                        release();
                        zzcewVarBooleanValue.zzg(zzcewVarBooleanValue.zzf, str, str3, zzd(str3, e));
                        zzcewVar = zzcewVarBooleanValue;
                        com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcewVar.zzi);
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e2) {
            e = e2;
            str = strZzc;
            zzcewVarBooleanValue = this;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzi(final boolean z, final long j) {
        final zzcdc zzcdcVar = (zzcdc) this.zzc.get();
        if (zzcdcVar != null) {
            zzcbg.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceu
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzcew.zzd;
                    zzcdcVar.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzk(String str, Exception exc) {
        zzcat.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzt(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzl(String str, Exception exc) {
        zzcat.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzt(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzm(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.ads.zzcdc] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.gms.internal.ads.zzcen, com.google.android.gms.internal.ads.zzcew] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.gms.internal.ads.zzcew] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [long] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzcen] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.google.android.gms.internal.ads.zzcen
    public final boolean zzu(String str, String[] strArr) throws Throwable {
        ?? r6;
        String str2;
        ?? r5;
        long j;
        ?? r1;
        String str3;
        long j2;
        ?? r2;
        ?? r15 = this;
        ?? r13 = str;
        r15.zzf = r13;
        ?? r17 = "error";
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            r15.zze.zzF(uriArr, r15.zzb);
            ?? r0 = (zzcdc) r15.zzc.get();
            if (r0 != 0) {
                r0.zzt(strZzc, r15);
            }
            Clock clockZzB = com.google.android.gms.ads.internal.zzt.zzB();
            long jCurrentTimeMillis = clockZzB.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzy)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzx)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzw)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue();
            ?? r3 = -1;
            long j3 = jIntValue;
            r13 = r13;
            r15 = r15;
            while (true) {
                synchronized (this) {
                    try {
                        if (clockZzB.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue2 + " ms");
                        }
                        if (r15.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!r15.zzh) {
                            if (!r15.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzz = r15.zze.zzz();
                            if (jZzz > 0) {
                                long jZzv = r15.zze.zzv();
                                if (jZzv != r3) {
                                    try {
                                        long j4 = jZzz;
                                        str3 = strZzc;
                                        try {
                                            zzo(str, strZzc, jZzv, j4, jZzv > 0, zBooleanValue ? r15.zze.zzA() : -1L, zBooleanValue ? r15.zze.zzx() : -1L, zBooleanValue ? r15.zze.zzB() : -1L, zzcct.zzs(), zzcct.zzu());
                                            r2 = jZzv;
                                            j2 = jZzz;
                                            r6 = j4;
                                        } catch (Throwable th) {
                                            th = th;
                                            r5 = this;
                                            r6 = str;
                                            str2 = str3;
                                            try {
                                                throw th;
                                            } catch (Exception e) {
                                                e = e;
                                                ?? r4 = r17;
                                                zzcat.zzj("Failed to preload url " + r6 + " Exception: " + e.getMessage());
                                                com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "VideoStreamExoPlayerCache.preload");
                                                release();
                                                r5.zzg(r6, str2, r4, zzd(r4, e));
                                                return false;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r5 = this;
                                        r6 = str;
                                        str2 = strZzc;
                                    }
                                } else {
                                    str3 = strZzc;
                                    j2 = jZzz;
                                    r2 = r3;
                                    r6 = j3;
                                }
                                r5 = (jZzv > j2 ? 1 : (jZzv == j2 ? 0 : -1));
                                if (r5 >= 0) {
                                    zzj(str, str3, j2);
                                } else {
                                    try {
                                        zzcew zzcewVar = this;
                                        r6 = str;
                                        str2 = str3;
                                        if (zzcewVar.zze.zzw() < j3 || jZzv <= 0) {
                                            r1 = r2;
                                            r5 = zzcewVar;
                                            j = j3;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        throw th;
                                    }
                                }
                            } else {
                                j = j3;
                                jLongValue2 = jLongValue2;
                                r6 = r13;
                                str2 = strZzc;
                                r5 = r15;
                                r1 = r3;
                            }
                            try {
                                try {
                                    r5.wait(jLongValue);
                                } catch (Throwable th4) {
                                    th = th4;
                                    r17 = r1;
                                    throw th;
                                }
                            } catch (InterruptedException unused) {
                                throw new IOException("Wait interrupted.");
                            }
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        r6 = r13;
                        str2 = strZzc;
                        r5 = r15;
                    }
                }
                return true;
                jLongValue = jLongValue;
                r15 = r5;
                r13 = r6;
                strZzc = str2;
                j3 = j;
                jLongValue2 = jLongValue2;
                r3 = r1;
            }
        } catch (Exception e2) {
            e = e2;
            r6 = r13;
            str2 = strZzc;
            r5 = r15;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzv() {
        zzcat.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final boolean zzw(String str, String[] strArr, zzcef zzcefVar) {
        this.zzf = str;
        this.zzi = zzcefVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcdc zzcdcVar = (zzcdc) this.zzc.get();
            if (zzcdcVar != null) {
                zzcdcVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e) {
            zzcat.zzj("Failed to preload url " + str + " Exception: " + e.getMessage());
            com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, strZzc, "error", zzd("error", e));
            return false;
        }
    }
}

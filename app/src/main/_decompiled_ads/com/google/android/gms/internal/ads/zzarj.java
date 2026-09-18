package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzarj {
    protected volatile Boolean zzb;
    private final zzasp zze;
    private static final ConditionVariable zzc = new ConditionVariable();
    protected static volatile zzfos zza = null;
    private static volatile Random zzd = null;

    public zzarj(zzasp zzaspVar) {
        this.zze = zzaspVar;
        zzaspVar.zzk().execute(new zzari(this));
    }

    public static final int zzd() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zze().nextInt();
        } catch (RuntimeException unused) {
            return zze().nextInt();
        }
    }

    private static Random zze() {
        if (zzd == null) {
            synchronized (zzarj.class) {
                if (zzd == null) {
                    zzd = new Random();
                }
            }
        }
        return zzd;
    }

    public final void zzc(int i, int i2, long j, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzany zzanyVarZza = zzaoc.zza();
            zzanyVarZza.zza(this.zze.zza.getPackageName());
            zzanyVarZza.zze(j);
            if (str != null) {
                zzanyVarZza.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzanyVarZza.zzf(stringWriter.toString());
                zzanyVarZza.zzd(exc.getClass().getName());
            }
            zzfor zzforVarZza = zza.zza(((zzaoc) zzanyVarZza.zzal()).zzax());
            zzforVarZza.zza(i);
            if (i2 != -1) {
                zzforVarZza.zzb(i2);
            }
            zzforVarZza.zzc();
        } catch (Exception unused) {
        }
    }
}

package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaud implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzasp zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzaom zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzaud(zzasp zzaspVar, String str, String str2, zzaom zzaomVar, int i, int i2) {
        this.zzb = zzaspVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzaomVar;
        this.zzg = i;
        this.zzh = i2;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzl();
        return null;
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzl() throws Exception {
        int i;
        try {
            long jNanoTime = System.nanoTime();
            Method methodZzj = this.zzb.zzj(this.zzc, this.zzd);
            this.zzf = methodZzj;
            if (methodZzj == null) {
                return null;
            }
            zza();
            zzarj zzarjVarZzd = this.zzb.zzd();
            if (zzarjVarZzd != null && (i = this.zzg) != Integer.MIN_VALUE) {
                zzarjVarZzd.zzc(this.zzh, i, (System.nanoTime() - jNanoTime) / 1000, null, null);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }
}

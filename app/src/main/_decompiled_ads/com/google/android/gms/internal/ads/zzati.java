package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzati implements Callable {
    private final zzasp zza;
    private final zzaom zzb;

    public zzati(zzasp zzaspVar, zzaom zzaomVar) {
        this.zza = zzaspVar;
        this.zzb = zzaomVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzapj zzapjVarZzc = this.zza.zzc();
        if (zzapjVarZzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                try {
                    zzaom zzaomVar = this.zzb;
                    byte[] bArrZzax = zzapjVarZzc.zzax();
                    zzaomVar.zzak(bArrZzax, 0, bArrZzax.length, zzgtl.zza());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        } catch (zzgul | NullPointerException unused) {
            return null;
        }
    }
}

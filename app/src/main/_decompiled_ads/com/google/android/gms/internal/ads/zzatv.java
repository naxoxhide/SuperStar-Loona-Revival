package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzatv extends zzaud {
    private final StackTraceElement[] zzi;

    public zzatv(zzasp zzaspVar, String str, String str2, zzaom zzaomVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzaspVar, "fxU2A2MjpZ4aJWGzXeMNURilSCaKosw3oXImrqnhSVmXB+tMi32JakdNlHCV3t0c", "+EF+l1eHEjuR445L5ETgD58eDQCcfhCypNm97kN1L/4=", zzaomVar, i, 45);
        this.zzi = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzi;
        if (stackTraceElementArr != null) {
            zzasg zzasgVar = new zzasg((String) this.zzf.invoke(null, stackTraceElementArr));
            synchronized (this.zze) {
                this.zze.zzF(zzasgVar.zza.longValue());
                if (zzasgVar.zzb.booleanValue()) {
                    this.zze.zzac(true != zzasgVar.zzc.booleanValue() ? 2 : 1);
                } else {
                    this.zze.zzac(3);
                }
            }
        }
    }
}

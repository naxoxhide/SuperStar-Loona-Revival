package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzatg extends zzaud {
    private final long zzi;

    public zzatg(zzasp zzaspVar, String str, String str2, zzaom zzaomVar, long j, int i, int i2) {
        super(zzaspVar, "MbAcGuLi+XGl3MsgqAiQYLikemL120ZFxn+dIhaD+rHWJuTeO/M8+1c58cczHjCs", "Eg2eC3eNesWzbAUINzxj1mXRcYgmzS654CxZFoVQbAM=", zzaomVar, i, 25);
        this.zzi = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zzf.invoke(null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzt(jLongValue);
            long j = this.zzi;
            if (j != 0) {
                this.zze.zzT(jLongValue - j);
                this.zze.zzU(this.zzi);
            }
        }
    }
}

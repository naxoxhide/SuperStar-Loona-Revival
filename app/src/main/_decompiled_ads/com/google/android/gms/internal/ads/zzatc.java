package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzatc extends zzaud {
    private static final zzaue zzi = new zzaue();
    private final Context zzj;

    public zzatc(zzasp zzaspVar, String str, String str2, zzaom zzaomVar, int i, int i2, Context context) {
        super(zzaspVar, "gL88T2vBvJS+jBemUvhPpVS5IeaU7cU4wFVgyT6PJl7pFldWXOd3mZxVZlQUSll5", "bObXLZFRWAdU6+me08AeNX2ciqxi45ddv3QSqAplzos=", zzaomVar, i, 29);
        this.zzj = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzn("E");
        AtomicReference atomicReferenceZza = zzi.zza(this.zzj.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                if (atomicReferenceZza.get() == null) {
                    atomicReferenceZza.set((String) this.zzf.invoke(null, this.zzj));
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        synchronized (this.zze) {
            this.zze.zzn(zzapz.zza(str.getBytes(), true));
        }
    }
}

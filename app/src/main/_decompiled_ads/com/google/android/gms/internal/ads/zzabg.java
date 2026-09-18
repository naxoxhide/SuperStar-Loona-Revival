package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzabg {
    private final zzabf zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzabg(zzabf zzabfVar) {
        this.zza = zzabfVar;
    }

    public final zzabm zza(Object... objArr) {
        Constructor constructorZza;
        synchronized (this.zzb) {
            try {
                if (!this.zzb.get()) {
                    try {
                        constructorZza = this.zza.zza();
                    } catch (ClassNotFoundException unused) {
                        this.zzb.set(true);
                        constructorZza = null;
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating extension", e);
                    }
                }
                constructorZza = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzabm) constructorZza.newInstance(objArr);
        } catch (Exception e2) {
            throw new IllegalStateException("Unexpected error creating extractor", e2);
        }
    }
}

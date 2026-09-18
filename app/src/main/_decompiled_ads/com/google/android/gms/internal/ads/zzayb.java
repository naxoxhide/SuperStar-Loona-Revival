package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayb {
    zzaur zza;
    boolean zzb;
    private final ExecutorService zzc;

    public zzayb() {
        this.zzc = zzcai.zzb;
    }

    public zzayb(final Context context) {
        ExecutorService executorService = zzcai.zzb;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaxw
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeM)).booleanValue();
                zzayb zzaybVar = this.zza;
                Context context2 = context;
                if (zBooleanValue) {
                    try {
                        zzaybVar.zza = (zzaur) zzcax.zzb(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new zzcav() { // from class: com.google.android.gms.internal.ads.zzaxx
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.google.android.gms.internal.ads.zzcav
                            public final Object zza(Object obj) {
                                return zzauq.zzb(obj);
                            }
                        });
                        zzaybVar.zza.zze(ObjectWrapper.wrap(context2), "GMA_SDK");
                        zzaybVar.zzb = true;
                    } catch (RemoteException | zzcaw | NullPointerException unused) {
                        zzcat.zze("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}

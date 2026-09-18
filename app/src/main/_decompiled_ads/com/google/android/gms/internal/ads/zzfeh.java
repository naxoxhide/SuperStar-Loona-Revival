package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfeh {
    private static zzfeh zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcl zzc;
    private final AtomicReference zzd = new AtomicReference();

    zzfeh(Context context, com.google.android.gms.ads.internal.client.zzcl zzclVar) {
        this.zzb = context;
        this.zzc = zzclVar;
    }

    static com.google.android.gms.ads.internal.client.zzcl zza(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzck.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            zzcat.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfeh zzd(Context context) {
        synchronized (zzfeh.class) {
            zzfeh zzfehVar = zza;
            if (zzfehVar != null) {
                return zzfehVar;
            }
            Context applicationContext = context.getApplicationContext();
            long jLongValue = ((Long) zzbed.zzb.zze()).longValue();
            com.google.android.gms.ads.internal.client.zzcl zzclVarZza = null;
            if (jLongValue > 0 && jLongValue <= 233702200) {
                zzclVarZza = zza(applicationContext);
            }
            zzfeh zzfehVar2 = new zzfeh(applicationContext, zzclVarZza);
            zza = zzfehVar2;
            return zzfehVar2;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzen zzg() {
        com.google.android.gms.ads.internal.client.zzcl zzclVar = this.zzc;
        if (zzclVar != null) {
            try {
                return zzclVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbox zzb() {
        return (zzbox) this.zzd.get();
    }

    public final zzcaz zzc(int i, boolean z, int i2) {
        com.google.android.gms.ads.internal.client.zzen zzenVarZzg;
        com.google.android.gms.ads.internal.zzt.zzp();
        boolean zZzD = com.google.android.gms.ads.internal.util.zzt.zzD(this.zzb);
        zzcaz zzcazVar = new zzcaz(233702000, i2, true, zZzD);
        return (((Boolean) zzbed.zzc.zze()).booleanValue() && (zzenVarZzg = zzg()) != null) ? new zzcaz(233702000, zzenVarZzg.zza(), true, zZzD) : zzcazVar;
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzen zzenVarZzg = zzg();
        if (zzenVarZzg != null) {
            return zzenVarZzg.zzb();
        }
        return null;
    }

    public final void zzf(zzbox zzboxVar) {
        zzbox adapterCreator;
        if (!((Boolean) zzbed.zza.zze()).booleanValue()) {
            zzfeg.zza(this.zzd, null, zzboxVar);
            return;
        }
        com.google.android.gms.ads.internal.client.zzcl zzclVar = this.zzc;
        if (zzclVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzclVar.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference = this.zzd;
        if (adapterCreator != null) {
            zzboxVar = adapterCreator;
        }
        zzfeg.zza(atomicReference, null, zzboxVar);
    }
}

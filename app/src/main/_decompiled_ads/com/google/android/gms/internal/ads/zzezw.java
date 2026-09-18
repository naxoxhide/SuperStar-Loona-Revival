package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezw {
    public static void zza(AtomicReference atomicReference, zzezv zzezvVar) {
        Object obj = atomicReference.get();
        if (obj == null) {
            return;
        }
        try {
            zzezvVar.zza(obj);
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        } catch (NullPointerException e2) {
            zzcat.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e2);
        }
    }
}

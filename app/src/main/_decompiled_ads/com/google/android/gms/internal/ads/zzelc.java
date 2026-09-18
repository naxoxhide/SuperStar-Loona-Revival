package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzelc {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdqj zzb;

    public zzelc(zzdqj zzdqjVar) {
        this.zzb = zzdqjVar;
    }

    @CheckForNull
    public final zzbqv zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbqv) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e) {
            zzcat.zzh("Couldn't create RTB adapter : ", e);
        }
    }
}

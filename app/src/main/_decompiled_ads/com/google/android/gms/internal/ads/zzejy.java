package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzejy implements zzeew {
    private final zzelc zza;
    private final zzdqj zzb;

    zzejy(zzelc zzelcVar, zzdqj zzdqjVar) {
        this.zza = zzelcVar;
        this.zzb = zzdqjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeew
    public final zzeex zza(String str, JSONObject jSONObject) throws zzfds {
        zzbqv zzbqvVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbC)).booleanValue()) {
            try {
                zzbqvVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e) {
                zzcat.zzh("Coundn't create RTB adapter: ", e);
                zzbqvVarZzb = null;
            }
        } else {
            zzbqvVarZzb = this.zza.zza(str);
        }
        if (zzbqvVarZzb == null) {
            return null;
        }
        return new zzeex(zzbqvVarZzb, new zzegq(), str);
    }
}

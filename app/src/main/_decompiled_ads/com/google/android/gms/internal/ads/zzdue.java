package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdue implements zzdto {
    private final long zza;
    private final zzdtt zzb;
    private final zzfci zzc;

    zzdue(long j, Context context, zzdtt zzdttVar, zzchw zzchwVar, String str) {
        this.zza = j;
        this.zzb = zzdttVar;
        zzfck zzfckVarZzv = zzchwVar.zzv();
        zzfckVarZzv.zzb(context);
        zzfckVarZzv.zza(str);
        this.zzc = zzfckVarZzv.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzdto
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdto
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        try {
            this.zzc.zzf(zzlVar, new zzduc(this));
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdto
    public final void zzc() {
        try {
            this.zzc.zzk(new zzdud(this));
            this.zzc.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzcat.zzl("#007 Could not call remote method.", e);
        }
    }
}

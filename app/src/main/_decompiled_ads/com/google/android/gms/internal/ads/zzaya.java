package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaya {
    final /* synthetic */ zzayb zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzaya(zzayb zzaybVar, byte[] bArr, zzaxz zzaxzVar) {
        this.zza = zzaybVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzayb zzaybVar = this.zza;
            if (zzaybVar.zzb) {
                zzaybVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            zzcat.zzf("Clearcut log failed", e);
        }
    }

    public final zzaya zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        this.zza.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaxy
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }
}

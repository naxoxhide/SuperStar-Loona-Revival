package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaxp implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzaxh zza;
    final /* synthetic */ zzcbl zzb;
    final /* synthetic */ zzaxr zzc;

    zzaxp(zzaxr zzaxrVar, zzaxh zzaxhVar, zzcbl zzcblVar) {
        this.zzc = zzaxrVar;
        this.zza = zzaxhVar;
        this.zzb = zzcblVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzaxr zzaxrVar = this.zzc;
            if (zzaxrVar.zzb) {
                return;
            }
            zzaxrVar.zzb = true;
            final zzaxg zzaxgVar = this.zzc.zza;
            if (zzaxgVar == null) {
                return;
            }
            zzgad zzgadVar = zzcbg.zza;
            final zzaxh zzaxhVar = this.zza;
            final zzcbl zzcblVar = this.zzb;
            final ListenableFuture listenableFutureZza = zzgadVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaxm
                @Override // java.lang.Runnable
                public final void run() {
                    zzaxp zzaxpVar = this.zza;
                    zzaxg zzaxgVar2 = zzaxgVar;
                    zzcbl zzcblVar2 = zzcblVar;
                    try {
                        zzaxj zzaxjVarZzq = zzaxgVar2.zzq();
                        boolean zZzp = zzaxgVar2.zzp();
                        zzaxh zzaxhVar2 = zzaxhVar;
                        zzaxe zzaxeVarZzg = zZzp ? zzaxjVarZzq.zzg(zzaxhVar2) : zzaxjVarZzq.zzf(zzaxhVar2);
                        if (!zzaxeVarZzg.zze()) {
                            zzcblVar2.zzd(new RuntimeException("No entry contents."));
                            zzaxr.zze(zzaxpVar.zzc);
                            return;
                        }
                        zzaxo zzaxoVar = new zzaxo(zzaxpVar, zzaxeVarZzg.zzc(), 1);
                        int i = zzaxoVar.read();
                        if (i == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzaxoVar.unread(i);
                        zzcblVar2.zzc(zzaxt.zzb(zzaxoVar, zzaxeVarZzg.zzd(), zzaxeVarZzg.zzg(), zzaxeVarZzg.zza(), zzaxeVarZzg.zzf()));
                    } catch (RemoteException | IOException e) {
                        zzcat.zzh("Unable to obtain a cache service instance.", e);
                        zzcblVar2.zzd(e);
                        zzaxr.zze(zzaxpVar.zzc);
                    }
                }
            });
            final zzcbl zzcblVar2 = this.zzb;
            zzcblVar2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaxn
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzaxp.zzd;
                    if (zzcblVar2.isCancelled()) {
                        listenableFutureZza.cancel(true);
                    }
                }
            }, zzcbg.zzf);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}

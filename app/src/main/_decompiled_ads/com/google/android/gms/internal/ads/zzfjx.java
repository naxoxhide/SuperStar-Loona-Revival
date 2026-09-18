package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjx {
    private final Context zza;
    private final Executor zzb;
    private final zzcay zzc;
    private final zzfjh zzd;

    zzfjx(Context context, Executor executor, zzcay zzcayVar, zzfjh zzfjhVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcayVar;
        this.zzd = zzfjhVar;
    }

    final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    final /* synthetic */ void zzb(String str, zzfje zzfjeVar) {
        zzfit zzfitVarZza = zzfis.zza(this.zza, 14);
        zzfitVarZza.zzh();
        zzfitVarZza.zzf(this.zzc.zza(str));
        if (zzfjeVar == null) {
            this.zzd.zzb(zzfitVarZza.zzl());
        } else {
            zzfjeVar.zza(zzfitVarZza);
            zzfjeVar.zzg();
        }
    }

    public final void zzc(final String str, final zzfje zzfjeVar) {
        if (zzfjh.zza() && ((Boolean) zzbdu.zzd.zze()).booleanValue()) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfjw
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb(str, zzfjeVar);
                }
            });
        } else {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfjv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(str);
                }
            });
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), null);
        }
    }
}

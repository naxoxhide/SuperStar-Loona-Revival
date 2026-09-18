package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetz {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfje zzd;
    private final zzdso zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzetz(Context context, Executor executor, Set set, zzfje zzfjeVar, zzdso zzdsoVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfjeVar;
        this.zze = zzdsoVar;
    }

    public final ListenableFuture zza(final Object obj) {
        zzfit zzfitVarZza = zzfis.zza(this.zza, 8);
        zzfitVarZza.zzh();
        final ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        if (!((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkL)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkL)).split(","));
        }
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        for (final zzetw zzetwVar : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzetwVar.zza()))) {
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                ListenableFuture listenableFutureZzb = zzetwVar.zzb();
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetx
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb(jElapsedRealtime, zzetwVar);
                    }
                }, zzcbg.zzf);
                arrayList.add(listenableFutureZzb);
            }
        }
        ListenableFuture listenableFutureZza = zzfzt.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzety
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Iterator it = arrayList.iterator();
                while (true) {
                    Object obj2 = obj;
                    if (!it.hasNext()) {
                        return obj2;
                    }
                    zzetv zzetvVar = (zzetv) ((ListenableFuture) it.next()).get();
                    if (zzetvVar != null) {
                        zzetvVar.zzj(obj2);
                    }
                }
            }
        }, this.zzc);
        if (zzfjh.zza()) {
            zzfjd.zza(listenableFutureZza, this.zzd, zzfitVarZza);
        }
        return listenableFutureZza;
    }

    public final void zzb(long j, zzetw zzetwVar) {
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j;
        if (((Boolean) zzbee.zza.zze()).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal runtime (ms) : " + zzftl.zzc(zzetwVar.getClass().getCanonicalName()) + " = " + jElapsedRealtime);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbY)).booleanValue()) {
            zzdsn zzdsnVarZza = this.zze.zza();
            zzdsnVarZza.zzb("action", "lat_ms");
            zzdsnVarZza.zzb("lat_grp", "sig_lat_grp");
            zzdsnVarZza.zzb("lat_id", String.valueOf(zzetwVar.zza()));
            zzdsnVarZza.zzb("clat_ms", String.valueOf(jElapsedRealtime));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbZ)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zzdsnVarZza.zzb("seq_num", com.google.android.gms.ads.internal.zzt.zzo().zzg().zzd());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String strValueOf = String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzf);
                        if (zzetwVar.zza() <= 39 || zzetwVar.zza() >= 52) {
                            zzdsnVarZza.zzb("lat_clsg", strValueOf);
                        } else {
                            zzdsnVarZza.zzb("lat_gmssg", strValueOf);
                        }
                    }
                }
            }
            zzdsnVarZza.zzh();
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesl implements zzetw {
    private final Context zza;
    private final zzgad zzb;
    private final zzfdn zzc;
    private final zzcaz zzd;

    zzesl(Context context, zzgad zzgadVar, zzfdn zzfdnVar, zzcaz zzcazVar) {
        this.zza = context;
        this.zzb = zzgadVar;
        this.zzc = zzfdnVar;
        this.zzd = zzcazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 53;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0044 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0056 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x00bf A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00d1 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00eb A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    final /* synthetic */ zzesm zzc() throws Exception {
        zzfpt zzfptVar;
        boolean z;
        boolean zZzp;
        zzfpx zzfpxVarZzi;
        try {
            Context context = this.zza;
            boolean zZzb = this.zzc.zzb();
            zzfpt zzfptVar2 = new zzfpt();
            zzfpt zzfptVar3 = new zzfpt();
            boolean zZzo = true;
            if (zZzb) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcL)).booleanValue()) {
                    return new zzesm(true);
                }
            }
            if (!zZzb) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcH)).booleanValue()) {
                    zzfptVar2 = zzfpw.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcV)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzQ());
                } else if (zZzb) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcJ)).booleanValue()) {
                        zzfptVar2 = zzfpw.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcV)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzQ());
                    }
                }
            } else if (zZzb) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcJ)).booleanValue()) {
                    zzfptVar2 = zzfpw.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcV)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzQ());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcS)).booleanValue()) {
                if (this.zzd.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcR)).intValue()) {
                    zzfpx.zzi(context).zzj();
                }
            }
            if (zZzb) {
                if (zZzb) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcK)).booleanValue()) {
                        zzfpxVarZzi = zzfpx.zzi(context);
                        if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcR)).intValue()) {
                            zzfptVar3 = zzfpxVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcW)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzQ());
                            zZzo = zzfpxVarZzi.zzo();
                        }
                        zZzp = zzfpxVarZzi.zzp();
                        zzfptVar = zzfptVar3;
                        z = zZzo;
                    }
                }
                zzfptVar = zzfptVar3;
                z = true;
                zZzp = true;
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcI)).booleanValue()) {
                    zzfpxVarZzi = zzfpx.zzi(context);
                    if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcR)).intValue()) {
                        zzfptVar3 = zzfpxVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcW)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzQ());
                        zZzo = zzfpxVarZzi.zzo();
                    }
                    zZzp = zzfpxVarZzi.zzp();
                    zzfptVar = zzfptVar3;
                    z = zZzo;
                } else {
                    if (zZzb) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcK)).booleanValue()) {
                            zzfpxVarZzi = zzfpx.zzi(context);
                            if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcR)).intValue()) {
                                zzfptVar3 = zzfpxVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcW)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzh().zzQ());
                                zZzo = zzfpxVarZzi.zzo();
                            }
                            zZzp = zzfpxVarZzi.zzp();
                            zzfptVar = zzfptVar3;
                            z = zZzo;
                        }
                    }
                    zzfptVar = zzfptVar3;
                    z = true;
                    zZzp = true;
                }
            }
            return new zzesm(zzfptVar2, zzfptVar, z, zZzp, zZzb);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "PerAppIdSignal");
            return new zzesm(this.zzc.zzb());
        }
    }
}

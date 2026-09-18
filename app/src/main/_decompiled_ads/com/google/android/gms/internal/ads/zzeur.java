package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeur implements zzetw {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzbzt zzg;

    zzeur(zzbzt zzbztVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzbztVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 40;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaT)).booleanValue()) {
            return zzfzt.zzg(new Exception("Did not ad Ad ID into query param."));
        }
        return zzfzt.zze((zzfzk) zzfzt.zzo(zzfzt.zzm(zzfzk.zzu(this.zzg.zza(this.zza, this.zzd)), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzeup
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return this.zza.zzc((AdvertisingIdClient.Info) obj);
            }
        }, this.zzc), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaU)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzeuq
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return this.zza.zzd((Throwable) obj);
            }
        }, this.zzc);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x001b  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    final /* synthetic */ zzeus zzc(AdvertisingIdClient.Info info) {
        zzfpt zzfptVar = new zzfpt();
        if (!this.zze) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcO)).booleanValue()) {
                zzfpw zzfpwVarZzj = zzfpw.zzj(this.zza);
                info.getClass();
                String id = info.getId();
                id.getClass();
                zzfptVar = zzfpwVarZzj.zzi(id, this.zza.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcV)).longValue(), this.zzf);
            } else if (this.zze) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcP)).booleanValue()) {
                    try {
                        zzfpw zzfpwVarZzj2 = zzfpw.zzj(this.zza);
                        info.getClass();
                        String id2 = info.getId();
                        id2.getClass();
                        zzfptVar = zzfpwVarZzj2.zzi(id2, this.zza.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcV)).longValue(), this.zzf);
                    } catch (IOException | IllegalArgumentException e) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "AdIdInfoSignalSource.getPaidV1");
                        zzfptVar = new zzfpt();
                    }
                }
            }
        } else if (this.zze) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcP)).booleanValue()) {
                zzfpw zzfpwVarZzj3 = zzfpw.zzj(this.zza);
                info.getClass();
                String id3 = info.getId();
                id3.getClass();
                zzfptVar = zzfpwVarZzj3.zzi(id3, this.zza.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcV)).longValue(), this.zzf);
            }
        }
        return new zzeus(info, null, zzfptVar);
    }

    final /* synthetic */ zzeus zzd(Throwable th) {
        com.google.android.gms.ads.internal.client.zzay.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        return new zzeus(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ANDROID_ID), new zzfpt());
    }
}

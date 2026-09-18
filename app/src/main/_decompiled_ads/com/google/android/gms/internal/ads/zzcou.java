package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcou {
    private final Context zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzeeq zzc;
    private final zzdpy zzd;
    private final zzgad zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private zzbua zzh;

    zzcou(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzeeq zzeeqVar, zzdpy zzdpyVar, zzgad zzgadVar, zzgad zzgadVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zza = context;
        this.zzb = zzgVar;
        this.zzc = zzeeqVar;
        this.zzd = zzdpyVar;
        this.zze = zzgadVar;
        this.zzf = zzgadVar2;
        this.zzg = scheduledExecutorService;
    }

    private final ListenableFuture zzj(final String str, @Nullable final InputEvent inputEvent, Random random) {
        final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (!str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjv)) || this.zzb.zzQ()) {
            return zzfzt.zzh(str);
        }
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjw), String.valueOf(random.nextInt(Integer.MAX_VALUE)));
        if (inputEvent != null) {
            return zzfzt.zzf(zzfzt.zzn(zzfzk.zzu(this.zzc.zza()), new zzfza() { // from class: com.google.android.gms.internal.ads.zzcoo
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzd(builderBuildUpon, str, inputEvent, (Integer) obj);
                }
            }, this.zzf), Throwable.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzcop
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zze(builderBuildUpon, (Throwable) obj);
                }
            }, this.zze);
        }
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjx), "11");
        return zzfzt.zzh(builderBuildUpon.toString());
    }

    public final ListenableFuture zzc(final String str, Random random) {
        return zzfzt.zzf(zzj(str, this.zzd.zza(), random), Throwable.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzcon
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(str);
            }
        }, this.zze);
    }

    final /* synthetic */ ListenableFuture zzd(final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) throws Exception {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjx), "10");
            return zzfzt.zzh(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjy), "1");
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjx), "12");
        if (str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjz))) {
            builderBuildUpon.authority((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjA));
        }
        return zzfzt.zzn(zzfzk.zzu(this.zzc.zzb(builderBuildUpon.build(), inputEvent)), new zzfza() { // from class: com.google.android.gms.internal.ads.zzcoq
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjx);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, "12");
                return zzfzt.zzh(builder2.toString());
            }
        }, this.zzf);
    }

    final /* synthetic */ ListenableFuture zze(Uri.Builder builder, final Throwable th) throws Exception {
        this.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcom
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(th);
            }
        });
        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjx), "9");
        return zzfzt.zzh(builder.toString());
    }

    final /* synthetic */ void zzh(Throwable th) {
        zzbua zzbuaVarZza = zzbty.zza(this.zza);
        this.zzh = zzbuaVarZza;
        zzbuaVarZza.zzf(th, "AttributionReporting");
    }

    public final void zzi(String str, zzfjx zzfjxVar, Random random) {
        zzfzt.zzr(zzfzt.zzo(zzj(str, this.zzd.zza(), random), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjB)).intValue(), TimeUnit.MILLISECONDS, this.zzg), new zzcot(this, zzfjxVar, str), this.zze);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzchw implements zzcni {

    @Nullable
    private static zzchw zza;

    private static synchronized zzchw zzD(Context context, @Nullable zzbox zzboxVar, int i, boolean z, int i2, zzcja zzcjaVar) {
        zzchw zzchwVar = zza;
        if (zzchwVar != null) {
            return zzchwVar;
        }
        zzbci.zza(context);
        zzfeh zzfehVarZzd = zzfeh.zzd(context);
        zzcaz zzcazVarZzc = zzfehVarZzd.zzc(233702000, false, i2);
        zzfehVarZzd.zzf(zzboxVar);
        zzcko zzckoVar = new zzcko(null);
        zzchx zzchxVar = new zzchx();
        zzchxVar.zzd(zzcazVarZzc);
        zzchxVar.zzc(context);
        zzckoVar.zzb(new zzchz(zzchxVar, null));
        zzckoVar.zzc(new zzcmb(zzcjaVar));
        zzchw zzchwVarZza = zzckoVar.zza();
        com.google.android.gms.ads.internal.zzt.zzo().zzs(context, zzcazVarZzc);
        com.google.android.gms.ads.internal.zzt.zzc().zzi(context);
        com.google.android.gms.ads.internal.zzt.zzp().zzl(context);
        com.google.android.gms.ads.internal.zzt.zzp().zzk(context);
        com.google.android.gms.ads.internal.util.zzd.zza(context);
        com.google.android.gms.ads.internal.zzt.zzb().zzd(context);
        com.google.android.gms.ads.internal.zzt.zzv().zzb(context);
        zzchwVarZza.zza().zzc();
        zzbyz.zzd(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgf)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzau)).booleanValue()) {
                zzaxv zzaxvVar = new zzaxv(new zzayb(context));
                zzech zzechVar = new zzech(new zzecd(context), zzchwVarZza.zzA());
                com.google.android.gms.ads.internal.zzt.zzp();
                new zzedd(context, zzcazVarZzc, zzaxvVar, zzechVar, UUID.randomUUID().toString(), zzchwVarZza.zzy()).zzb(com.google.android.gms.ads.internal.zzt.zzo().zzh().zzQ());
            }
        }
        zza = zzchwVarZza;
        return zzchwVarZza;
    }

    public static zzchw zzb(Context context, @Nullable zzbox zzboxVar, int i) {
        return zzD(context, zzboxVar, 233702000, false, i, new zzcja());
    }

    public abstract zzgad zzA();

    public abstract Executor zzB();

    public abstract ScheduledExecutorService zzC();

    public abstract com.google.android.gms.ads.internal.util.zzcf zza();

    public abstract zzcml zzc();

    public abstract zzcqi zzd();

    public abstract zzcrr zze();

    public abstract zzdaa zzf();

    public abstract zzdgw zzg();

    public abstract zzdhs zzh();

    public abstract zzdpb zzi();

    public abstract zzdtx zzj();

    public abstract zzdvm zzk();

    public abstract zzdwg zzl();

    public abstract zzedz zzm();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzc zzn();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzg zzo();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzaa zzp();

    @Override // com.google.android.gms.internal.ads.zzcni
    public final zzeuu zzq(zzbvg zzbvgVar, int i) {
        return zzr(new zzeww(zzbvgVar, i));
    }

    protected abstract zzeuu zzr(zzeww zzewwVar);

    public abstract zzexr zzs();

    public abstract zzezf zzt();

    public abstract zzfaw zzu();

    public abstract zzfck zzv();

    public abstract zzfea zzw();

    public abstract zzfek zzx();

    public abstract zzfib zzy();

    public abstract zzfjh zzz();
}

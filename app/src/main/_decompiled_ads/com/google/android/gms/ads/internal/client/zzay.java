package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzbss;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcaz;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzay {
    private static final zzay zza = new zzay();
    private final zzcam zzb;
    private final zzaw zzc;
    private final String zzd;
    private final zzcaz zze;
    private final Random zzf;

    protected zzay() {
        zzcam zzcamVar = new zzcam();
        zzaw zzawVar = new zzaw(new zzk(), new zzi(), new zzeq(), new zzbhn(), new zzbxb(), new zzbss(), new zzbho());
        String strZzd = zzcam.zzd();
        zzcaz zzcazVar = new zzcaz(0, 233702000, true, false, false);
        Random random = new Random();
        this.zzb = zzcamVar;
        this.zzc = zzawVar;
        this.zzd = strZzd;
        this.zze = zzcazVar;
        this.zzf = random;
    }

    public static zzaw zza() {
        return zza.zzc;
    }

    public static zzcam zzb() {
        return zza.zzb;
    }

    public static zzcaz zzc() {
        return zza.zze;
    }

    public static String zzd() {
        return zza.zzd;
    }

    public static Random zze() {
        return zza.zzf;
    }
}

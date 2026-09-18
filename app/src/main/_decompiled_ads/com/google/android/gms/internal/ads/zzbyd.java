package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbyd {
    private Context zza;
    private Clock zzb;
    private com.google.android.gms.ads.internal.util.zzg zzc;
    private zzbyy zzd;

    private zzbyd() {
    }

    /* synthetic */ zzbyd(zzbyc zzbycVar) {
    }

    public final zzbyd zza(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzc = zzgVar;
        return this;
    }

    public final zzbyd zzb(Context context) {
        Objects.requireNonNull(context);
        this.zza = context;
        return this;
    }

    public final zzbyd zzc(Clock clock) {
        Objects.requireNonNull(clock);
        this.zzb = clock;
        return this;
    }

    public final zzbyd zzd(zzbyy zzbyyVar) {
        this.zzd = zzbyyVar;
        return this;
    }

    public final zzbyz zze() {
        zzhbk.zzc(this.zza, Context.class);
        zzhbk.zzc(this.zzb, Clock.class);
        zzhbk.zzc(this.zzc, com.google.android.gms.ads.internal.util.zzg.class);
        zzhbk.zzc(this.zzd, zzbyy.class);
        return new zzbyf(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}

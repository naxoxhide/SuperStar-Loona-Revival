package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeth implements zzetw {
    private final zzbyy zza;
    private final zzgad zzb;
    private final Context zzc;

    public zzeth(zzbyy zzbyyVar, zzgad zzgadVar, Context context) {
        this.zza = zzbyyVar;
        this.zzb = zzgadVar;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 34;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeti zzc() throws Exception {
        Long l;
        if (!this.zza.zzu(this.zzc)) {
            return new zzeti(null, null, null, null, null);
        }
        String strZze = this.zza.zze(this.zzc);
        String str = strZze == null ? "" : strZze;
        String strZzc = this.zza.zzc(this.zzc);
        String str2 = strZzc == null ? "" : strZzc;
        String strZza = this.zza.zza(this.zzc);
        String str3 = strZza == null ? "" : strZza;
        String strZzb = this.zza.zzb(this.zzc);
        String str4 = strZzb == null ? "" : strZzb;
        if ("TIME_OUT".equals(str2)) {
            l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaf);
        } else {
            l = null;
        }
        return new zzeti(str, str2, str3, str4, l);
    }
}

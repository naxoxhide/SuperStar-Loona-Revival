package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeqp implements zzetw {
    private final Context zza;
    private final zzgad zzb;

    public zzeqp(Context context, zzgad zzgadVar) {
        this.zza = context;
        this.zzb = zzgadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 19;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String strZzj;
                String strZzk;
                String strZze;
                com.google.android.gms.ads.internal.zzt.zzp();
                zzavv zzavvVarZzg = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzg();
                Bundle bundle = null;
                if (zzavvVarZzg != null && (!com.google.android.gms.ads.internal.zzt.zzo().zzh().zzN() || !com.google.android.gms.ads.internal.zzt.zzo().zzh().zzO())) {
                    if (zzavvVarZzg.zzh()) {
                        zzavvVarZzg.zzg();
                    }
                    zzavl zzavlVarZza = zzavvVarZzg.zza();
                    if (zzavlVarZza != null) {
                        strZzj = zzavlVarZza.zzd();
                        strZze = zzavlVarZza.zze();
                        strZzk = zzavlVarZza.zzf();
                        if (strZzj != null) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzh().zzw(strZzj);
                        }
                        if (strZzk != null) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzh().zzy(strZzk);
                        }
                    } else {
                        strZzj = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzj();
                        strZzk = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzk();
                        strZze = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!com.google.android.gms.ads.internal.zzt.zzo().zzh().zzO()) {
                        if (strZzk == null || TextUtils.isEmpty(strZzk)) {
                            bundle2.putString("v_fp_vertical", "no_hash");
                        } else {
                            bundle2.putString("v_fp_vertical", strZzk);
                        }
                    }
                    if (strZzj != null && !com.google.android.gms.ads.internal.zzt.zzo().zzh().zzN()) {
                        bundle2.putString("fingerprint", strZzj);
                        if (!strZzj.equals(strZze)) {
                            bundle2.putString("v_fp", strZze);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzeqq(bundle);
            }
        });
    }
}

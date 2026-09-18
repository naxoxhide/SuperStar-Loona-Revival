package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import com.tapjoy.TapjoyConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeoj implements zzetw {
    private final zzgad zza;
    private final zzdqj zzb;
    private final zzdur zzc;
    private final zzeol zzd;

    public zzeoj(zzgad zzgadVar, zzdqj zzdqjVar, zzdur zzdurVar, zzeol zzeolVar) {
        this.zza = zzgadVar;
        this.zzb = zzdqjVar;
        this.zzc = zzdurVar;
        this.zzd = zzeolVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkG)).booleanValue() && this.zzd.zza() != null) {
            zzeok zzeokVarZza = this.zzd.zza();
            Objects.requireNonNull(zzeokVarZza);
            return zzfzt.zzh(zzeokVarZza);
        }
        if (!zzftl.zzd((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbp))) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkG)).booleanValue() || (!this.zzd.zzd() && this.zzc.zzt())) {
                this.zzd.zzc(true);
                return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeoi
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzc();
                    }
                });
            }
        }
        return zzfzt.zzh(new zzeok(new Bundle()));
    }

    final /* synthetic */ zzeok zzc() throws Exception {
        List<String> listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbp)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : listAsList) {
            try {
                zzfej zzfejVarZzc = this.zzb.zzc(str, new JSONObject());
                zzfejVarZzc.zzC();
                boolean zZzt = this.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkG)).booleanValue() || zZzt) {
                    try {
                        zzbrj zzbrjVarZzf = zzfejVarZzc.zzf();
                        if (zzbrjVarZzf != null) {
                            bundle2.putString("sdk_version", zzbrjVarZzf.toString());
                        }
                    } catch (zzfds unused) {
                    }
                }
                try {
                    zzbrj zzbrjVarZze = zzfejVarZzc.zze();
                    if (zzbrjVarZze != null) {
                        bundle2.putString(TapjoyConstants.TJC_ADAPTER_VERSION, zzbrjVarZze.toString());
                    }
                } catch (zzfds unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfds unused3) {
            }
        }
        zzeok zzeokVar = new zzeok(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkG)).booleanValue()) {
            this.zzd.zzb(zzeokVar);
        }
        return zzeokVar;
    }
}

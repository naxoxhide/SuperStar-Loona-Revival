package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdli implements zzcyf {
    private final zzdjj zza;
    private final zzdjo zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdli(zzdjj zzdjjVar, zzdjo zzdjoVar, Executor executor, Executor executor2) {
        this.zza = zzdjjVar;
        this.zzb = zzdjoVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(final zzcgb zzcgbVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdlg
            @Override // java.lang.Runnable
            public final void run() {
                zzcgbVar.zzd("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcyf
    public final void zzq() {
        if (this.zzb.zzd()) {
            zzdjj zzdjjVar = this.zza;
            zzfkc zzfkcVarZzu = zzdjjVar.zzu();
            if (zzfkcVarZzu == null && zzdjjVar.zzw() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeY)).booleanValue()) {
                zzdjj zzdjjVar2 = this.zza;
                ListenableFuture listenableFutureZzw = zzdjjVar2.zzw();
                zzcbl zzcblVarZzp = zzdjjVar2.zzp();
                if (listenableFutureZzw == null || zzcblVarZzp == null) {
                    return;
                }
                zzfzt.zzr(zzfzt.zzl(listenableFutureZzw, zzcblVarZzp), new zzdlh(this), this.zzd);
                return;
            }
            if (zzfkcVarZzu == null) {
                return;
            }
            zzdjj zzdjjVar3 = this.zza;
            zzcgb zzcgbVarZzr = zzdjjVar3.zzr();
            zzcgb zzcgbVarZzs = zzdjjVar3.zzs();
            if (zzcgbVarZzr == null) {
                zzcgbVarZzr = zzcgbVarZzs != null ? zzcgbVarZzs : null;
            }
            if (zzcgbVarZzr != null) {
                zzb(zzcgbVarZzr);
            }
        }
    }
}

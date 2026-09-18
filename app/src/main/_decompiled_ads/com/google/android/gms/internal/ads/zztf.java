package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zztf extends zzsx {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzhk zzc;

    protected zztf() {
    }

    protected abstract void zzA(Object obj, zzty zztyVar, zzcv zzcvVar);

    protected final void zzB(final Object obj, zzty zztyVar) {
        zzdx.zzd(!this.zza.containsKey(obj));
        zztx zztxVar = new zztx() { // from class: com.google.android.gms.internal.ads.zztc
            @Override // com.google.android.gms.internal.ads.zztx
            public final void zza(zzty zztyVar2, zzcv zzcvVar) {
                this.zza.zzA(obj, zztyVar2, zzcvVar);
            }
        };
        zztd zztdVar = new zztd(this, obj);
        this.zza.put(obj, new zzte(zztyVar, zztxVar, zztdVar));
        Handler handler = this.zzb;
        Objects.requireNonNull(handler);
        zztyVar.zzh(handler, zztdVar);
        Handler handler2 = this.zzb;
        Objects.requireNonNull(handler2);
        zztyVar.zzg(handler2, zztdVar);
        zztyVar.zzm(zztxVar, this.zzc, zzb());
        if (zzu()) {
            return;
        }
        zztyVar.zzi(zztxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    protected final void zzj() {
        for (zzte zzteVar : this.zza.values()) {
            zzteVar.zza.zzi(zzteVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    protected final void zzl() {
        for (zzte zzteVar : this.zza.values()) {
            zzteVar.zza.zzk(zzteVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    protected void zzn(zzhk zzhkVar) {
        this.zzc = zzhkVar;
        this.zzb = zzfk.zzv(null);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    protected void zzq() {
        for (zzte zzteVar : this.zza.values()) {
            zzteVar.zza.zzp(zzteVar.zzb);
            zzteVar.zza.zzs(zzteVar.zzc);
            zzteVar.zza.zzr(zzteVar.zzc);
        }
        this.zza.clear();
    }

    protected int zzw(Object obj, int i) {
        return 0;
    }

    protected long zzx(Object obj, long j) {
        return j;
    }

    protected zztw zzy(Object obj, zztw zztwVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public void zzz() throws IOException {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zzte) it.next()).zza.zzz();
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzsx implements zzty {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzuf zzc = new zzuf();
    private final zzqx zzd = new zzqx();
    private Looper zze;
    private zzcv zzf;
    private zzol zzg;

    @Override // com.google.android.gms.internal.ads.zzty
    public /* synthetic */ zzcv zzM() {
        return null;
    }

    protected final zzol zzb() {
        zzol zzolVar = this.zzg;
        zzdx.zzb(zzolVar);
        return zzolVar;
    }

    protected final zzqx zzc(zztw zztwVar) {
        return this.zzd.zza(0, zztwVar);
    }

    protected final zzqx zzd(int i, zztw zztwVar) {
        return this.zzd.zza(0, zztwVar);
    }

    protected final zzuf zze(zztw zztwVar) {
        return this.zzc.zza(0, zztwVar);
    }

    protected final zzuf zzf(int i, zztw zztwVar) {
        return this.zzc.zza(0, zztwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzg(Handler handler, zzqy zzqyVar) {
        this.zzd.zzb(handler, zzqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzh(Handler handler, zzug zzugVar) {
        this.zzc.zzb(handler, zzugVar);
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzi(zztx zztxVar) {
        boolean z = !this.zzb.isEmpty();
        this.zzb.remove(zztxVar);
        if (z && this.zzb.isEmpty()) {
            zzj();
        }
    }

    protected void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzk(zztx zztxVar) {
        Objects.requireNonNull(this.zze);
        HashSet hashSet = this.zzb;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(zztxVar);
        if (zIsEmpty) {
            zzl();
        }
    }

    protected void zzl() {
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzm(zztx zztxVar, zzhk zzhkVar, zzol zzolVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        zzdx.zzd(z);
        this.zzg = zzolVar;
        zzcv zzcvVar = this.zzf;
        this.zza.add(zztxVar);
        if (this.zze == null) {
            this.zze = looperMyLooper;
            this.zzb.add(zztxVar);
            zzn(zzhkVar);
        } else if (zzcvVar != null) {
            zzk(zztxVar);
            zztxVar.zza(this, zzcvVar);
        }
    }

    protected abstract void zzn(zzhk zzhkVar);

    protected final void zzo(zzcv zzcvVar) {
        this.zzf = zzcvVar;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zztx) arrayList.get(i)).zza(this, zzcvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzp(zztx zztxVar) {
        this.zza.remove(zztxVar);
        if (!this.zza.isEmpty()) {
            zzi(zztxVar);
            return;
        }
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzb.clear();
        zzq();
    }

    protected abstract void zzq();

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzr(zzqy zzqyVar) {
        this.zzd.zzc(zzqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzs(zzug zzugVar) {
        this.zzc.zzh(zzugVar);
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public /* synthetic */ void zzt(zzbp zzbpVar) {
        throw null;
    }

    protected final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public /* synthetic */ boolean zzv() {
        return true;
    }
}

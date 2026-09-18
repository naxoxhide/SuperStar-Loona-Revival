package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzdr implements zzdq {
    protected zzdo zzb;
    protected zzdo zzc;
    private zzdo zzd;
    private zzdo zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzdr() {
        ByteBuffer byteBuffer = zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        this.zzd = zzdo.zza;
        zzdo zzdoVar = zzdo.zza;
        this.zze = zzdoVar;
        this.zzb = zzdoVar;
        this.zzc = zzdoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final zzdo zza(zzdo zzdoVar) throws zzdp {
        this.zzd = zzdoVar;
        this.zze = zzi(zzdoVar);
        return zzg() ? this.zze : zzdo.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzc() {
        this.zzg = zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzf() {
        zzc();
        this.zzf = zza;
        this.zzd = zzdo.zza;
        zzdo zzdoVar = zzdo.zza;
        this.zze = zzdoVar;
        this.zzb = zzdoVar;
        this.zzc = zzdoVar;
        zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public boolean zzg() {
        return this.zze != zzdo.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public boolean zzh() {
        return this.zzh && this.zzg == zza;
    }

    protected zzdo zzi(zzdo zzdoVar) throws zzdp {
        throw null;
    }

    protected final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    protected void zzk() {
    }

    protected void zzl() {
    }

    protected void zzm() {
    }

    protected final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}

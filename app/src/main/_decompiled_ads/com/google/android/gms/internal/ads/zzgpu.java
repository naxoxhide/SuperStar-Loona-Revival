package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpu extends zzgtz implements zzgvk {
    private static final zzgpu zzb;
    private int zzd;
    private int zze;
    private zzgpx zzf;

    static {
        zzgpu zzgpuVar = new zzgpu();
        zzb = zzgpuVar;
        zzgtz.zzaU(zzgpu.class, zzgpuVar);
    }

    private zzgpu() {
    }

    public static zzgpt zzc() {
        return (zzgpt) zzb.zzaA();
    }

    public static zzgpu zze(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgpu) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    static /* synthetic */ void zzh(zzgpu zzgpuVar, zzgpx zzgpxVar) {
        zzgpxVar.getClass();
        zzgpuVar.zzf = zzgpxVar;
        zzgpuVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgpu();
        }
        zzgps zzgpsVar = null;
        if (i2 == 4) {
            return new zzgpt(zzgpsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgpx zzf() {
        zzgpx zzgpxVar = this.zzf;
        return zzgpxVar == null ? zzgpx.zzc() : zzgpxVar;
    }
}

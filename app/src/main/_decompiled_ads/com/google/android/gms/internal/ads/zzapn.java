package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzapn extends zzgtz implements zzgvk {
    private static final zzapn zzb;
    private int zzd;
    private zzgsr zze = zzgsr.zzb;
    private zzgsr zzf;
    private zzgsr zzg;
    private zzgsr zzh;

    static {
        zzapn zzapnVar = new zzapn();
        zzb = zzapnVar;
        zzgtz.zzaU(zzapn.class, zzapnVar);
    }

    private zzapn() {
        zzgsr zzgsrVar = zzgsr.zzb;
        this.zzf = zzgsrVar;
        this.zzg = zzgsrVar;
        this.zzh = zzgsrVar;
    }

    public static zzapm zza() {
        return (zzapm) zzb.zzaA();
    }

    public static zzapn zzd(byte[] bArr, zzgtl zzgtlVar) throws zzgul {
        return (zzapn) zzgtz.zzaI(zzb, bArr, zzgtlVar);
    }

    static /* synthetic */ void zzi(zzapn zzapnVar, zzgsr zzgsrVar) {
        zzapnVar.zzd |= 1;
        zzapnVar.zze = zzgsrVar;
    }

    static /* synthetic */ void zzj(zzapn zzapnVar, zzgsr zzgsrVar) {
        zzapnVar.zzd |= 2;
        zzapnVar.zzf = zzgsrVar;
    }

    static /* synthetic */ void zzk(zzapn zzapnVar, zzgsr zzgsrVar) {
        zzapnVar.zzd |= 4;
        zzapnVar.zzg = zzgsrVar;
    }

    static /* synthetic */ void zzl(zzapn zzapnVar, zzgsr zzgsrVar) {
        zzapnVar.zzd |= 8;
        zzapnVar.zzh = zzgsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzapn();
        }
        zzaol zzaolVar = null;
        if (i2 == 4) {
            return new zzapm(zzaolVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgsr zze() {
        return this.zze;
    }

    public final zzgsr zzf() {
        return this.zzf;
    }

    public final zzgsr zzg() {
        return this.zzh;
    }

    public final zzgsr zzh() {
        return this.zzg;
    }
}

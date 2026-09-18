package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgmn extends zzgtz implements zzgvk {
    private static final zzgmn zzb;
    private int zzd;
    private int zze;
    private zzgsr zzf = zzgsr.zzb;
    private zzgmt zzg;

    static {
        zzgmn zzgmnVar = new zzgmn();
        zzb = zzgmnVar;
        zzgtz.zzaU(zzgmn.class, zzgmnVar);
    }

    private zzgmn() {
    }

    public static zzgmm zzc() {
        return (zzgmm) zzb.zzaA();
    }

    public static zzgmn zze(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgmn) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    static /* synthetic */ void zzj(zzgmn zzgmnVar, zzgmt zzgmtVar) {
        zzgmtVar.getClass();
        zzgmnVar.zzg = zzgmtVar;
        zzgmnVar.zzd |= 1;
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
            return zzaR(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgmn();
        }
        zzgml zzgmlVar = null;
        if (i2 == 4) {
            return new zzgmm(zzgmlVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgmt zzf() {
        zzgmt zzgmtVar = this.zzg;
        return zzgmtVar == null ? zzgmt.zze() : zzgmtVar;
    }

    public final zzgsr zzg() {
        return this.zzf;
    }
}

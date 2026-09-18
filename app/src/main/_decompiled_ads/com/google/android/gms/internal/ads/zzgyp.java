package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgyp extends zzgtz implements zzgvk {
    private static final zzgyp zzb;
    private int zzd;
    private byte zzg = 2;
    private zzgsr zze = zzgsr.zzb;
    private zzgsr zzf = zzgsr.zzb;

    static {
        zzgyp zzgypVar = new zzgyp();
        zzb = zzgypVar;
        zzgtz.zzaU(zzgyp.class, zzgypVar);
    }

    private zzgyp() {
    }

    public static zzgyo zza() {
        return (zzgyo) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgyp zzgypVar, zzgsr zzgsrVar) {
        zzgypVar.zzd |= 1;
        zzgypVar.zze = zzgsrVar;
    }

    static /* synthetic */ void zze(zzgyp zzgypVar, zzgsr zzgsrVar) {
        zzgypVar.zzd |= 2;
        zzgypVar.zzf = zzgsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgyp();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgyo(zzgxtVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}

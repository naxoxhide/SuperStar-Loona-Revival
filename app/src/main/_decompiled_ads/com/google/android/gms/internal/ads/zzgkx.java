package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgkx extends zzghv {
    private static final zzgiu zza = zzgiu.zzb(new zzgis() { // from class: com.google.android.gms.internal.ads.zzgkt
        @Override // com.google.android.gms.internal.ads.zzgis
        public final Object zza(zzgbe zzgbeVar) {
            return new zzglt((zzgks) zzgbeVar);
        }
    }, zzgks.class, zzgkl.class);
    private static final zzgiu zzb = zzgiu.zzb(new zzgis() { // from class: com.google.android.gms.internal.ads.zzgku
        @Override // com.google.android.gms.internal.ads.zzgis
        public final Object zza(zzgbe zzgbeVar) {
            return zzgrt.zzc((zzgks) zzgbeVar);
        }
    }, zzgks.class, zzgbv.class);

    public zzgkx() {
        super(zzgoo.class, new zzgkv(zzgbv.class));
    }

    public static void zzh(boolean z) throws GeneralSecurityException {
        zzgcg.zzf(new zzgkx(), true);
        int i = zzgly.zza;
        zzgly.zzc(zzgii.zzb());
        zzgif.zza().zze(zza);
        zzgif.zza().zze(zzb);
    }

    public static final void zzm(zzgoo zzgooVar) throws GeneralSecurityException {
        zzgrv.zzb(zzgooVar.zza(), 0);
        if (zzgooVar.zzh().zzd() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzn(zzgooVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzn(zzgou zzgouVar) throws GeneralSecurityException {
        if (zzgouVar.zza() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        zzgol zzgolVar = zzgol.UNKNOWN_HASH;
        int iOrdinal = zzgouVar.zzc().ordinal();
        if (iOrdinal == 1) {
            if (zzgouVar.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 2) {
            if (zzgouVar.zza() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 3) {
            if (zzgouVar.zza() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (iOrdinal == 4) {
            if (zzgouVar.zza() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (iOrdinal != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (zzgouVar.zza() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final zzghu zza() {
        return new zzgkw(this, zzgor.class);
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final zzgoy zzb() {
        return zzgoy.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final /* synthetic */ zzgvj zzc(zzgsr zzgsrVar) throws zzgul {
        return zzgoo.zzf(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final /* bridge */ /* synthetic */ void zze(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzm((zzgoo) zzgvjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final int zzf() {
        return 2;
    }
}

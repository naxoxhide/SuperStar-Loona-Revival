package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgly {
    public static final /* synthetic */ int zza = 0;
    private static final zzgrx zzb;
    private static final zzghk zzc;
    private static final zzghk zzd;
    private static final zzgiq zze;
    private static final zzgim zzf;
    private static final zzght zzg;
    private static final zzghp zzh;

    static {
        zzgrx zzgrxVarZza = zzgjr.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzgrxVarZza;
        zzghi zzghiVarZza = zzghk.zza();
        zzghiVarZza.zza(zzgqf.RAW, zzglb.zzd);
        zzghiVarZza.zza(zzgqf.TINK, zzglb.zza);
        zzghiVarZza.zza(zzgqf.LEGACY, zzglb.zzc);
        zzghiVarZza.zza(zzgqf.CRUNCHY, zzglb.zzb);
        zzc = zzghiVarZza.zzb();
        zzghi zzghiVarZza2 = zzghk.zza();
        zzghiVarZza2.zza(zzgol.SHA1, zzgla.zza);
        zzghiVarZza2.zza(zzgol.SHA224, zzgla.zzb);
        zzghiVarZza2.zza(zzgol.SHA256, zzgla.zzc);
        zzghiVarZza2.zza(zzgol.SHA384, zzgla.zzd);
        zzghiVarZza2.zza(zzgol.SHA512, zzgla.zze);
        zzd = zzghiVarZza2.zzb();
        zze = zzgiq.zzb(new zzgio() { // from class: com.google.android.gms.internal.ads.zzglu
            @Override // com.google.android.gms.internal.ads.zzgio
            public final zzgjh zza(zzgbw zzgbwVar) {
                return zzgly.zza((zzgld) zzgbwVar);
            }
        }, zzgld.class, zzgjd.class);
        zzf = zzgim.zza(new zzgik() { // from class: com.google.android.gms.internal.ads.zzglv
        }, zzgrxVarZza, zzgjd.class);
        zzg = zzght.zza(new zzghr() { // from class: com.google.android.gms.internal.ads.zzglw
        }, zzgks.class, zzgjc.class);
        zzh = zzghp.zzb(new zzghn() { // from class: com.google.android.gms.internal.ads.zzglx
            @Override // com.google.android.gms.internal.ads.zzghn
            public final zzgbe zza(zzgjh zzgjhVar, zzgch zzgchVar) {
                return zzgly.zzb((zzgjc) zzgjhVar, zzgchVar);
            }
        }, zzgrxVarZza, zzgjc.class);
    }

    public static /* synthetic */ zzgjd zza(zzgld zzgldVar) {
        zzgpd zzgpdVarZza = zzgpe.zza();
        zzgpdVarZza.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgoq zzgoqVarZzc = zzgor.zzc();
        zzgot zzgotVarZzd = zzgou.zzd();
        zzgotVarZzd.zzb(zzgldVar.zza());
        zzgotVarZzd.zza((zzgol) zzd.zzb(zzgldVar.zze()));
        zzgoqVarZzc.zzb((zzgou) zzgotVarZzd.zzal());
        zzgoqVarZzc.zza(zzgldVar.zzb());
        zzgpdVarZza.zzc(((zzgor) zzgoqVarZzc.zzal()).zzau());
        zzgpdVarZza.zza((zzgqf) zzc.zzb(zzgldVar.zzf()));
        return zzgjd.zza((zzgpe) zzgpdVarZza.zzal());
    }

    public static /* synthetic */ zzgks zzb(zzgjc zzgjcVar, zzgch zzgchVar) throws GeneralSecurityException {
        if (!zzgjcVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzgoo zzgooVarZzf = zzgoo.zzf(zzgjcVar.zze(), zzgtl.zza());
            if (zzgooVarZzf.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgkz zzgkzVarZzd = zzgld.zzd();
            zzgkzVarZzd.zzb(zzgooVarZzf.zzh().zzd());
            zzgkzVarZzd.zzc(zzgooVarZzf.zzg().zza());
            zzgkzVarZzd.zza((zzgla) zzd.zzc(zzgooVarZzf.zzg().zzc()));
            zzgkzVarZzd.zzd((zzglb) zzc.zzc(zzgjcVar.zzc()));
            zzgld zzgldVarZze = zzgkzVarZzd.zze();
            zzgkq zzgkqVarZza = zzgks.zza();
            zzgkqVarZza.zzc(zzgldVarZze);
            zzgkqVarZza.zzb(zzgry.zzb(zzgooVarZzf.zzh().zzA(), zzgchVar));
            zzgkqVarZza.zza(zzgjcVar.zzf());
            return zzgkqVarZza.zzd();
        } catch (zzgul | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static void zzc(zzgii zzgiiVar) throws GeneralSecurityException {
        zzgiiVar.zzg(zze);
        zzgiiVar.zzf(zzf);
        zzgiiVar.zze(zzg);
        zzgiiVar.zzd(zzh);
    }
}

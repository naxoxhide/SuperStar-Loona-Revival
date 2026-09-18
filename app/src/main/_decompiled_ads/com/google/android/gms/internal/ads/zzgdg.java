package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgrx zzb;
    private static final zzgiq zzc;
    private static final zzgim zzd;
    private static final zzght zze;
    private static final zzghp zzf;

    static {
        zzgrx zzgrxVarZza = zzgjr.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzgrxVarZza;
        zzc = zzgiq.zzb(new zzgio() { // from class: com.google.android.gms.internal.ads.zzgdc
            @Override // com.google.android.gms.internal.ads.zzgio
            public final zzgjh zza(zzgbw zzgbwVar) throws GeneralSecurityException {
                zzgol zzgolVar;
                zzgqf zzgqfVar;
                zzgdb zzgdbVar = (zzgdb) zzgbwVar;
                int i = zzgdg.zza;
                zzgpd zzgpdVarZza = zzgpe.zza();
                zzgpdVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
                zzgmy zzgmyVarZza = zzgmz.zza();
                zzgne zzgneVarZzc = zzgnf.zzc();
                zzgnh zzgnhVarZzc = zzgni.zzc();
                zzgnhVarZzc.zza(zzgdbVar.zzc());
                zzgneVarZzc.zzb((zzgni) zzgnhVarZzc.zzal());
                zzgneVarZzc.zza(zzgdbVar.zza());
                zzgmyVarZza.zza((zzgnf) zzgneVarZzc.zzal());
                zzgoq zzgoqVarZzc = zzgor.zzc();
                zzgot zzgotVarZzd = zzgou.zzd();
                zzgotVarZzd.zzb(zzgdbVar.zzd());
                zzgcy zzgcyVarZze = zzgdbVar.zze();
                if (zzgcy.zza.equals(zzgcyVarZze)) {
                    zzgolVar = zzgol.SHA1;
                } else if (zzgcy.zzb.equals(zzgcyVarZze)) {
                    zzgolVar = zzgol.SHA224;
                } else if (zzgcy.zzc.equals(zzgcyVarZze)) {
                    zzgolVar = zzgol.SHA256;
                } else if (zzgcy.zzd.equals(zzgcyVarZze)) {
                    zzgolVar = zzgol.SHA384;
                } else {
                    if (!zzgcy.zze.equals(zzgcyVarZze)) {
                        throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(String.valueOf(zzgcyVarZze))));
                    }
                    zzgolVar = zzgol.SHA512;
                }
                zzgotVarZzd.zza(zzgolVar);
                zzgoqVarZzc.zzb((zzgou) zzgotVarZzd.zzal());
                zzgoqVarZzc.zza(zzgdbVar.zzb());
                zzgmyVarZza.zzb((zzgor) zzgoqVarZzc.zzal());
                zzgpdVarZza.zzc(((zzgmz) zzgmyVarZza.zzal()).zzau());
                zzgcz zzgczVarZzf = zzgdbVar.zzf();
                if (zzgcz.zza.equals(zzgczVarZzf)) {
                    zzgqfVar = zzgqf.TINK;
                } else if (zzgcz.zzb.equals(zzgczVarZzf)) {
                    zzgqfVar = zzgqf.CRUNCHY;
                } else {
                    if (!zzgcz.zzc.equals(zzgczVarZzf)) {
                        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgczVarZzf))));
                    }
                    zzgqfVar = zzgqf.RAW;
                }
                zzgpdVarZza.zza(zzgqfVar);
                return zzgjd.zza((zzgpe) zzgpdVarZza.zzal());
            }
        }, zzgdb.class, zzgjd.class);
        zzd = zzgim.zza(new zzgik() { // from class: com.google.android.gms.internal.ads.zzgdd
        }, zzgrxVarZza, zzgjd.class);
        zze = zzght.zza(new zzghr() { // from class: com.google.android.gms.internal.ads.zzgde
        }, zzgcs.class, zzgjc.class);
        zzf = zzghp.zzb(new zzghn() { // from class: com.google.android.gms.internal.ads.zzgdf
            @Override // com.google.android.gms.internal.ads.zzghn
            public final zzgbe zza(zzgjh zzgjhVar, zzgch zzgchVar) throws GeneralSecurityException {
                zzgcy zzgcyVar;
                zzgcz zzgczVar;
                int i = zzgdg.zza;
                if (!((zzgjc) zzgjhVar).zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
                }
                try {
                    zzgmw zzgmwVarZze = zzgmw.zze(((zzgjc) zzgjhVar).zze(), zzgtl.zza());
                    if (zzgmwVarZze.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    if (zzgmwVarZze.zzf().zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                    }
                    if (zzgmwVarZze.zzg().zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                    }
                    zzgcx zzgcxVar = new zzgcx(null);
                    zzgcxVar.zza(zzgmwVarZze.zzf().zzh().zzd());
                    zzgcxVar.zzc(zzgmwVarZze.zzg().zzh().zzd());
                    zzgcxVar.zzd(zzgmwVarZze.zzf().zzg().zza());
                    zzgcxVar.zze(zzgmwVarZze.zzg().zzg().zza());
                    zzgol zzgolVarZzc = zzgmwVarZze.zzg().zzg().zzc();
                    zzgol zzgolVar = zzgol.UNKNOWN_HASH;
                    zzgqf zzgqfVar = zzgqf.UNKNOWN_PREFIX;
                    int iOrdinal = zzgolVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzgcyVar = zzgcy.zza;
                    } else if (iOrdinal == 2) {
                        zzgcyVar = zzgcy.zzd;
                    } else if (iOrdinal == 3) {
                        zzgcyVar = zzgcy.zzc;
                    } else if (iOrdinal == 4) {
                        zzgcyVar = zzgcy.zze;
                    } else {
                        if (iOrdinal != 5) {
                            throw new GeneralSecurityException("Unable to parse HashType: " + zzgolVarZzc.zza());
                        }
                        zzgcyVar = zzgcy.zzb;
                    }
                    zzgcxVar.zzb(zzgcyVar);
                    zzgqf zzgqfVarZzc = ((zzgjc) zzgjhVar).zzc();
                    int iOrdinal2 = zzgqfVarZzc.ordinal();
                    if (iOrdinal2 == 1) {
                        zzgczVar = zzgcz.zza;
                    } else if (iOrdinal2 == 2) {
                        zzgczVar = zzgcz.zzb;
                    } else if (iOrdinal2 == 3) {
                        zzgczVar = zzgcz.zzc;
                    } else {
                        if (iOrdinal2 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgqfVarZzc.zza());
                        }
                        zzgczVar = zzgcz.zzb;
                    }
                    zzgcxVar.zzf(zzgczVar);
                    zzgdb zzgdbVarZzg = zzgcxVar.zzg();
                    zzgcq zzgcqVar = new zzgcq(null);
                    zzgcqVar.zzd(zzgdbVarZzg);
                    zzgcqVar.zza(zzgry.zzb(zzgmwVarZze.zzf().zzh().zzA(), zzgchVar));
                    zzgcqVar.zzb(zzgry.zzb(zzgmwVarZze.zzg().zzh().zzA(), zzgchVar));
                    zzgcqVar.zzc(((zzgjc) zzgjhVar).zzf());
                    return zzgcqVar.zze();
                } catch (zzgul unused) {
                    throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
                }
            }
        }, zzgrxVarZza, zzgjc.class);
    }

    public static void zza(zzgii zzgiiVar) throws GeneralSecurityException {
        zzgiiVar.zzg(zzc);
        zzgiiVar.zzf(zzd);
        zzgiiVar.zze(zze);
        zzgiiVar.zzd(zzf);
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzger {
    public static final /* synthetic */ int zza = 0;
    private static final zzgrx zzb;
    private static final zzgiq zzc;
    private static final zzgim zzd;
    private static final zzght zze;
    private static final zzghp zzf;

    static {
        zzgrx zzgrxVarZza = zzgjr.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzgrxVarZza;
        zzc = zzgiq.zzb(new zzgio() { // from class: com.google.android.gms.internal.ads.zzgen
            @Override // com.google.android.gms.internal.ads.zzgio
            public final zzgjh zza(zzgbw zzgbwVar) throws GeneralSecurityException {
                zzgqf zzgqfVar;
                zzgem zzgemVar = (zzgem) zzgbwVar;
                int i = zzger.zza;
                zzgpd zzgpdVarZza = zzgpe.zza();
                zzgpdVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
                zzgnw zzgnwVarZzc = zzgnx.zzc();
                zzgnwVarZzc.zza(zzgemVar.zza());
                zzgpdVarZza.zzc(((zzgnx) zzgnwVarZzc.zzal()).zzau());
                zzgek zzgekVarZzb = zzgemVar.zzb();
                if (zzgek.zza.equals(zzgekVarZzb)) {
                    zzgqfVar = zzgqf.TINK;
                } else if (zzgek.zzb.equals(zzgekVarZzb)) {
                    zzgqfVar = zzgqf.CRUNCHY;
                } else {
                    if (!zzgek.zzc.equals(zzgekVarZzb)) {
                        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgekVarZzb))));
                    }
                    zzgqfVar = zzgqf.RAW;
                }
                zzgpdVarZza.zza(zzgqfVar);
                return zzgjd.zza((zzgpe) zzgpdVarZza.zzal());
            }
        }, zzgem.class, zzgjd.class);
        zzd = zzgim.zza(new zzgik() { // from class: com.google.android.gms.internal.ads.zzgeo
        }, zzgrxVarZza, zzgjd.class);
        zze = zzght.zza(new zzghr() { // from class: com.google.android.gms.internal.ads.zzgep
        }, zzgee.class, zzgjc.class);
        zzf = zzghp.zzb(new zzghn() { // from class: com.google.android.gms.internal.ads.zzgeq
            @Override // com.google.android.gms.internal.ads.zzghn
            public final zzgbe zza(zzgjh zzgjhVar, zzgch zzgchVar) throws GeneralSecurityException {
                zzgek zzgekVar;
                int i = zzger.zza;
                if (!((zzgjc) zzgjhVar).zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
                }
                try {
                    zzgnu zzgnuVarZze = zzgnu.zze(((zzgjc) zzgjhVar).zze(), zzgtl.zza());
                    if (zzgnuVarZze.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    zzgej zzgejVar = new zzgej(null);
                    zzgejVar.zzb(zzgnuVarZze.zzf().zzd());
                    zzgejVar.zza(12);
                    zzgejVar.zzc(16);
                    zzgqf zzgqfVarZzc = ((zzgjc) zzgjhVar).zzc();
                    zzgqf zzgqfVar = zzgqf.UNKNOWN_PREFIX;
                    int iOrdinal = zzgqfVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzgekVar = zzgek.zza;
                    } else if (iOrdinal == 2) {
                        zzgekVar = zzgek.zzb;
                    } else if (iOrdinal == 3) {
                        zzgekVar = zzgek.zzc;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgqfVarZzc.zza());
                        }
                        zzgekVar = zzgek.zzb;
                    }
                    zzgejVar.zzd(zzgekVar);
                    zzgem zzgemVarZze = zzgejVar.zze();
                    zzgec zzgecVar = new zzgec(null);
                    zzgecVar.zzc(zzgemVarZze);
                    zzgecVar.zzb(zzgry.zzb(zzgnuVarZze.zzf().zzA(), zzgchVar));
                    zzgecVar.zza(((zzgjc) zzgjhVar).zzf());
                    return zzgecVar.zzd();
                } catch (zzgul unused) {
                    throw new GeneralSecurityException("Parsing AesGcmKey failed");
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

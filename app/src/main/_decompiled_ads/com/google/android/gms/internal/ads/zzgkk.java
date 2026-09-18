package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgkk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgrx zzb;
    private static final zzgiq zzc;
    private static final zzgim zzd;
    private static final zzght zze;
    private static final zzghp zzf;

    static {
        zzgrx zzgrxVarZza = zzgjr.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzgrxVarZza;
        zzc = zzgiq.zzb(new zzgio() { // from class: com.google.android.gms.internal.ads.zzgkg
            @Override // com.google.android.gms.internal.ads.zzgio
            public final zzgjh zza(zzgbw zzgbwVar) throws GeneralSecurityException {
                zzgqf zzgqfVar;
                zzgkf zzgkfVar = (zzgkf) zzgbwVar;
                int i = zzgkk.zza;
                zzgpd zzgpdVarZza = zzgpe.zza();
                zzgpdVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
                zzgmp zzgmpVarZzc = zzgmq.zzc();
                zzgms zzgmsVarZzc = zzgmt.zzc();
                zzgmsVarZzc.zza(zzgkfVar.zza());
                zzgmpVarZzc.zzb((zzgmt) zzgmsVarZzc.zzal());
                zzgmpVarZzc.zza(zzgkfVar.zzb());
                zzgpdVarZza.zzc(((zzgmq) zzgmpVarZzc.zzal()).zzau());
                zzgkd zzgkdVarZzd = zzgkfVar.zzd();
                if (zzgkd.zza.equals(zzgkdVarZzd)) {
                    zzgqfVar = zzgqf.TINK;
                } else if (zzgkd.zzb.equals(zzgkdVarZzd)) {
                    zzgqfVar = zzgqf.CRUNCHY;
                } else if (zzgkd.zzd.equals(zzgkdVarZzd)) {
                    zzgqfVar = zzgqf.RAW;
                } else {
                    if (!zzgkd.zzc.equals(zzgkdVarZzd)) {
                        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgkdVarZzd))));
                    }
                    zzgqfVar = zzgqf.LEGACY;
                }
                zzgpdVarZza.zza(zzgqfVar);
                return zzgjd.zza((zzgpe) zzgpdVarZza.zzal());
            }
        }, zzgkf.class, zzgjd.class);
        zzd = zzgim.zza(new zzgik() { // from class: com.google.android.gms.internal.ads.zzgkh
        }, zzgrxVarZza, zzgjd.class);
        zze = zzght.zza(new zzghr() { // from class: com.google.android.gms.internal.ads.zzgki
        }, zzgjv.class, zzgjc.class);
        zzf = zzghp.zzb(new zzghn() { // from class: com.google.android.gms.internal.ads.zzgkj
            @Override // com.google.android.gms.internal.ads.zzghn
            public final zzgbe zza(zzgjh zzgjhVar, zzgch zzgchVar) throws GeneralSecurityException {
                zzgkd zzgkdVar;
                int i = zzgkk.zza;
                if (!((zzgjc) zzgjhVar).zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
                }
                try {
                    zzgmn zzgmnVarZze = zzgmn.zze(((zzgjc) zzgjhVar).zze(), zzgtl.zza());
                    if (zzgmnVarZze.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    zzgkc zzgkcVar = new zzgkc(null);
                    zzgkcVar.zza(zzgmnVarZze.zzg().zzd());
                    zzgkcVar.zzb(zzgmnVarZze.zzf().zza());
                    zzgqf zzgqfVarZzc = ((zzgjc) zzgjhVar).zzc();
                    zzgqf zzgqfVar = zzgqf.UNKNOWN_PREFIX;
                    int iOrdinal = zzgqfVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzgkdVar = zzgkd.zza;
                    } else if (iOrdinal == 2) {
                        zzgkdVar = zzgkd.zzc;
                    } else if (iOrdinal == 3) {
                        zzgkdVar = zzgkd.zzd;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgqfVarZzc.zza());
                        }
                        zzgkdVar = zzgkd.zzb;
                    }
                    zzgkcVar.zzc(zzgkdVar);
                    zzgkf zzgkfVarZzd = zzgkcVar.zzd();
                    zzgjt zzgjtVar = new zzgjt(null);
                    zzgjtVar.zzc(zzgkfVarZzd);
                    zzgjtVar.zza(zzgry.zzb(zzgmnVarZze.zzg().zzA(), zzgchVar));
                    zzgjtVar.zzb(((zzgjc) zzgjhVar).zzf());
                    return zzgjtVar.zzd();
                } catch (zzgul | IllegalArgumentException unused) {
                    throw new GeneralSecurityException("Parsing AesCmacKey failed");
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

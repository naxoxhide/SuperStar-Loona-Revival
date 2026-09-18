package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgea {
    public static final /* synthetic */ int zza = 0;
    private static final zzgrx zzb;
    private static final zzgiq zzc;
    private static final zzgim zzd;
    private static final zzght zze;
    private static final zzghp zzf;

    static {
        zzgrx zzgrxVarZza = zzgjr.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzgrxVarZza;
        zzc = zzgiq.zzb(new zzgio() { // from class: com.google.android.gms.internal.ads.zzgdw
            @Override // com.google.android.gms.internal.ads.zzgio
            public final zzgjh zza(zzgbw zzgbwVar) throws GeneralSecurityException {
                zzgqf zzgqfVar;
                zzgdv zzgdvVar = (zzgdv) zzgbwVar;
                int i = zzgea.zza;
                zzgpd zzgpdVarZza = zzgpe.zza();
                zzgpdVarZza.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
                zzgnn zzgnnVarZzc = zzgno.zzc();
                zzgnq zzgnqVarZzc = zzgnr.zzc();
                zzgnqVarZzc.zza(zzgdvVar.zza());
                zzgnnVarZzc.zzb((zzgnr) zzgnqVarZzc.zzal());
                zzgnnVarZzc.zza(zzgdvVar.zzb());
                zzgpdVarZza.zzc(((zzgno) zzgnnVarZzc.zzal()).zzau());
                zzgdt zzgdtVarZzc = zzgdvVar.zzc();
                if (zzgdt.zza.equals(zzgdtVarZzc)) {
                    zzgqfVar = zzgqf.TINK;
                } else if (zzgdt.zzb.equals(zzgdtVarZzc)) {
                    zzgqfVar = zzgqf.CRUNCHY;
                } else {
                    if (!zzgdt.zzc.equals(zzgdtVarZzc)) {
                        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgdtVarZzc))));
                    }
                    zzgqfVar = zzgqf.RAW;
                }
                zzgpdVarZza.zza(zzgqfVar);
                return zzgjd.zza((zzgpe) zzgpdVarZza.zzal());
            }
        }, zzgdv.class, zzgjd.class);
        zzd = zzgim.zza(new zzgik() { // from class: com.google.android.gms.internal.ads.zzgdx
        }, zzgrxVarZza, zzgjd.class);
        zze = zzght.zza(new zzghr() { // from class: com.google.android.gms.internal.ads.zzgdy
        }, zzgdn.class, zzgjc.class);
        zzf = zzghp.zzb(new zzghn() { // from class: com.google.android.gms.internal.ads.zzgdz
            @Override // com.google.android.gms.internal.ads.zzghn
            public final zzgbe zza(zzgjh zzgjhVar, zzgch zzgchVar) throws GeneralSecurityException {
                zzgdt zzgdtVar;
                int i = zzgea.zza;
                if (!((zzgjc) zzgjhVar).zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
                }
                try {
                    zzgnl zzgnlVarZze = zzgnl.zze(((zzgjc) zzgjhVar).zze(), zzgtl.zza());
                    if (zzgnlVarZze.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    zzgds zzgdsVar = new zzgds(null);
                    zzgdsVar.zzb(zzgnlVarZze.zzg().zzd());
                    zzgdsVar.zza(zzgnlVarZze.zzf().zza());
                    zzgdsVar.zzc(16);
                    zzgqf zzgqfVarZzc = ((zzgjc) zzgjhVar).zzc();
                    zzgqf zzgqfVar = zzgqf.UNKNOWN_PREFIX;
                    int iOrdinal = zzgqfVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzgdtVar = zzgdt.zza;
                    } else if (iOrdinal == 2) {
                        zzgdtVar = zzgdt.zzb;
                    } else if (iOrdinal == 3) {
                        zzgdtVar = zzgdt.zzc;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgqfVarZzc.zza());
                        }
                        zzgdtVar = zzgdt.zzb;
                    }
                    zzgdsVar.zzd(zzgdtVar);
                    zzgdv zzgdvVarZze = zzgdsVar.zze();
                    zzgdl zzgdlVar = new zzgdl(null);
                    zzgdlVar.zzc(zzgdvVarZze);
                    zzgdlVar.zzb(zzgry.zzb(zzgnlVarZze.zzg().zzA(), zzgchVar));
                    zzgdlVar.zza(((zzgjc) zzgjhVar).zzf());
                    return zzgdlVar.zzd();
                } catch (zzgul unused) {
                    throw new GeneralSecurityException("Parsing AesEaxcKey failed");
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

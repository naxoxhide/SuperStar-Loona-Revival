package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzggs {
    public static final /* synthetic */ int zza = 0;
    private static final zzgrx zzb;
    private static final zzgiq zzc;
    private static final zzgim zzd;
    private static final zzght zze;
    private static final zzghp zzf;

    static {
        zzgrx zzgrxVarZza = zzgjr.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzgrxVarZza;
        zzc = zzgiq.zzb(new zzgio() { // from class: com.google.android.gms.internal.ads.zzggo
            @Override // com.google.android.gms.internal.ads.zzgio
            public final zzgjh zza(zzgbw zzgbwVar) throws GeneralSecurityException {
                zzgqf zzgqfVar;
                int i = zzggs.zza;
                zzgpd zzgpdVarZza = zzgpe.zza();
                zzgpdVarZza.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
                zzgpdVarZza.zzc(zzgqo.zzc().zzau());
                zzggm zzggmVarZza = ((zzggn) zzgbwVar).zza();
                if (zzggm.zza.equals(zzggmVarZza)) {
                    zzgqfVar = zzgqf.TINK;
                } else if (zzggm.zzb.equals(zzggmVarZza)) {
                    zzgqfVar = zzgqf.CRUNCHY;
                } else {
                    if (!zzggm.zzc.equals(zzggmVarZza)) {
                        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzggmVarZza.toString()));
                    }
                    zzgqfVar = zzgqf.RAW;
                }
                zzgpdVarZza.zza(zzgqfVar);
                return zzgjd.zza((zzgpe) zzgpdVarZza.zzal());
            }
        }, zzggn.class, zzgjd.class);
        zzd = zzgim.zza(new zzgik() { // from class: com.google.android.gms.internal.ads.zzggp
        }, zzgrxVarZza, zzgjd.class);
        zze = zzght.zza(new zzghr() { // from class: com.google.android.gms.internal.ads.zzggq
        }, zzggi.class, zzgjc.class);
        zzf = zzghp.zzb(new zzghn() { // from class: com.google.android.gms.internal.ads.zzggr
            @Override // com.google.android.gms.internal.ads.zzghn
            public final zzgbe zza(zzgjh zzgjhVar, zzgch zzgchVar) throws GeneralSecurityException {
                zzggm zzggmVar;
                int i = zzggs.zza;
                if (!((zzgjc) zzgjhVar).zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                    throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
                }
                try {
                    zzgql zzgqlVarZze = zzgql.zze(((zzgjc) zzgjhVar).zze(), zzgtl.zza());
                    if (zzgqlVarZze.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    zzgqf zzgqfVarZzc = ((zzgjc) zzgjhVar).zzc();
                    zzgqf zzgqfVar = zzgqf.UNKNOWN_PREFIX;
                    int iOrdinal = zzgqfVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzggmVar = zzggm.zza;
                    } else if (iOrdinal == 2) {
                        zzggmVar = zzggm.zzb;
                    } else if (iOrdinal == 3) {
                        zzggmVar = zzggm.zzc;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgqfVarZzc.zza());
                        }
                        zzggmVar = zzggm.zzb;
                    }
                    return zzggi.zza(zzggmVar, zzgry.zzb(zzgqlVarZze.zzf().zzA(), zzgchVar), ((zzgjc) zzgjhVar).zzf());
                } catch (zzgul unused) {
                    throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
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

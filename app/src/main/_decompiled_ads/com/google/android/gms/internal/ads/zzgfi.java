package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgfi {
    public static final /* synthetic */ int zza = 0;
    private static final zzgrx zzb;
    private static final zzgiq zzc;
    private static final zzgim zzd;
    private static final zzght zze;
    private static final zzghp zzf;

    static {
        zzgrx zzgrxVarZza = zzgjr.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzgrxVarZza;
        zzc = zzgiq.zzb(new zzgio() { // from class: com.google.android.gms.internal.ads.zzgfe
            @Override // com.google.android.gms.internal.ads.zzgio
            public final zzgjh zza(zzgbw zzgbwVar) throws GeneralSecurityException {
                zzgqf zzgqfVar;
                zzgfd zzgfdVar = (zzgfd) zzgbwVar;
                int i = zzgfi.zza;
                zzgpd zzgpdVarZza = zzgpe.zza();
                zzgpdVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
                zzgoc zzgocVarZzc = zzgod.zzc();
                zzgocVarZzc.zza(zzgfdVar.zza());
                zzgpdVarZza.zzc(((zzgod) zzgocVarZzc.zzal()).zzau());
                zzgfb zzgfbVarZzb = zzgfdVar.zzb();
                if (zzgfb.zza.equals(zzgfbVarZzb)) {
                    zzgqfVar = zzgqf.TINK;
                } else if (zzgfb.zzb.equals(zzgfbVarZzb)) {
                    zzgqfVar = zzgqf.CRUNCHY;
                } else {
                    if (!zzgfb.zzc.equals(zzgfbVarZzb)) {
                        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgfbVarZzb))));
                    }
                    zzgqfVar = zzgqf.RAW;
                }
                zzgpdVarZza.zza(zzgqfVar);
                return zzgjd.zza((zzgpe) zzgpdVarZza.zzal());
            }
        }, zzgfd.class, zzgjd.class);
        zzd = zzgim.zza(new zzgik() { // from class: com.google.android.gms.internal.ads.zzgff
        }, zzgrxVarZza, zzgjd.class);
        zze = zzght.zza(new zzghr() { // from class: com.google.android.gms.internal.ads.zzgfg
        }, zzgev.class, zzgjc.class);
        zzf = zzghp.zzb(new zzghn() { // from class: com.google.android.gms.internal.ads.zzgfh
            @Override // com.google.android.gms.internal.ads.zzghn
            public final zzgbe zza(zzgjh zzgjhVar, zzgch zzgchVar) throws GeneralSecurityException {
                zzgfb zzgfbVar;
                int i = zzgfi.zza;
                if (!((zzgjc) zzgjhVar).zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
                }
                try {
                    zzgoa zzgoaVarZze = zzgoa.zze(((zzgjc) zzgjhVar).zze(), zzgtl.zza());
                    if (zzgoaVarZze.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    zzgfa zzgfaVar = new zzgfa(null);
                    zzgfaVar.zza(zzgoaVarZze.zzf().zzd());
                    zzgqf zzgqfVarZzc = ((zzgjc) zzgjhVar).zzc();
                    zzgqf zzgqfVar = zzgqf.UNKNOWN_PREFIX;
                    int iOrdinal = zzgqfVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzgfbVar = zzgfb.zza;
                    } else if (iOrdinal == 2) {
                        zzgfbVar = zzgfb.zzb;
                    } else if (iOrdinal == 3) {
                        zzgfbVar = zzgfb.zzc;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgqfVarZzc.zza());
                        }
                        zzgfbVar = zzgfb.zzb;
                    }
                    zzgfaVar.zzb(zzgfbVar);
                    zzgfd zzgfdVarZzc = zzgfaVar.zzc();
                    zzget zzgetVar = new zzget(null);
                    zzgetVar.zzc(zzgfdVarZzc);
                    zzgetVar.zzb(zzgry.zzb(zzgoaVarZze.zzf().zzA(), zzgchVar));
                    zzgetVar.zza(((zzgjc) zzgjhVar).zzf());
                    return zzgetVar.zzd();
                } catch (zzgul unused) {
                    throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
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

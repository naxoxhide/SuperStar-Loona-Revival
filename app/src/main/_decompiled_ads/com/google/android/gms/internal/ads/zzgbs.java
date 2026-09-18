package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgbs {
    private final zzgpm zza;
    private final List zzb;
    private final zzgmc zzc;

    private zzgbs(zzgpm zzgpmVar, List list) {
        this.zza = zzgpmVar;
        this.zzb = list;
        this.zzc = zzgmc.zza;
    }

    private zzgbs(zzgpm zzgpmVar, List list, zzgmc zzgmcVar) {
        this.zza = zzgpmVar;
        this.zzb = list;
        this.zzc = zzgmcVar;
    }

    static final zzgbs zza(zzgpm zzgpmVar) throws GeneralSecurityException {
        zzi(zzgpmVar);
        return new zzgbs(zzgpmVar, zzh(zzgpmVar));
    }

    static final zzgbs zzb(zzgpm zzgpmVar, zzgmc zzgmcVar) throws GeneralSecurityException {
        zzi(zzgpmVar);
        return new zzgbs(zzgpmVar, zzh(zzgpmVar), zzgmcVar);
    }

    public static final zzgbs zzc(zzgbw zzgbwVar) throws GeneralSecurityException {
        zzgbp zzgbpVar = new zzgbp();
        zzgbn zzgbnVar = new zzgbn(zzgbwVar, null);
        zzgbnVar.zze();
        zzgbnVar.zzd();
        zzgbpVar.zza(zzgbnVar);
        return zzgbpVar.zzb();
    }

    private static zzgjc zzf(zzgpl zzgplVar) {
        try {
            return zzgjc.zza(zzgplVar.zzc().zzg(), zzgplVar.zzc().zzf(), zzgplVar.zzc().zzc(), zzgplVar.zzf(), zzgplVar.zzf() == zzgqf.RAW ? null : Integer.valueOf(zzgplVar.zza()));
        } catch (GeneralSecurityException e) {
            throw new zzgjq("Creating a protokey serialization failed", e);
        }
    }

    @Nullable
    private static Object zzg(zzghl zzghlVar, zzgpl zzgplVar, Class cls) throws GeneralSecurityException {
        try {
            return zzgcg.zzc(zzgplVar.zzc(), cls);
        } catch (UnsupportedOperationException unused) {
            return null;
        } catch (GeneralSecurityException e) {
            if (e.getMessage().contains("No key manager found for key type ") || e.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e;
        }
    }

    private static List zzh(zzgpm zzgpmVar) {
        zzgbj zzgbjVar;
        ArrayList arrayList = new ArrayList(zzgpmVar.zza());
        for (zzgpl zzgplVar : zzgpmVar.zzh()) {
            int iZza = zzgplVar.zza();
            try {
                zzgbe zzgbeVarZza = zzgii.zzb().zza(zzf(zzgplVar), zzgch.zza());
                int iZzk = zzgplVar.zzk() - 2;
                if (iZzk == 1) {
                    zzgbjVar = zzgbj.zza;
                } else if (iZzk == 2) {
                    zzgbjVar = zzgbj.zzb;
                } else {
                    if (iZzk != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    zzgbjVar = zzgbj.zzc;
                }
                arrayList.add(new zzgbr(zzgbeVarZza, zzgbjVar, iZza, iZza == zzgpmVar.zzc(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzi(zzgpm zzgpmVar) throws GeneralSecurityException {
        if (zzgpmVar == null || zzgpmVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    @Nullable
    private static final Object zzj(zzghl zzghlVar, zzgbe zzgbeVar, Class cls) throws GeneralSecurityException {
        try {
            return zzgif.zza().zzc(zzgbeVar, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        Charset charset = zzgci.zza;
        zzgpm zzgpmVar = this.zza;
        zzgpo zzgpoVarZza = zzgpr.zza();
        zzgpoVarZza.zzb(zzgpmVar.zzc());
        for (zzgpl zzgplVar : zzgpmVar.zzh()) {
            zzgpp zzgppVarZza = zzgpq.zza();
            zzgppVarZza.zzc(zzgplVar.zzc().zzg());
            zzgppVarZza.zzd(zzgplVar.zzk());
            zzgppVarZza.zzb(zzgplVar.zzf());
            zzgppVarZza.zza(zzgplVar.zza());
            zzgpoVarZza.zza((zzgpq) zzgppVarZza.zzal());
        }
        return ((zzgpr) zzgpoVarZza.zzal()).toString();
    }

    final zzgpm zzd() {
        return this.zza;
    }

    public final Object zze(zzgbb zzgbbVar, Class cls) throws GeneralSecurityException {
        Class clsZzb = zzgcg.zzb(cls);
        if (clsZzb == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls.getName())));
        }
        zzgpm zzgpmVar = this.zza;
        Charset charset = zzgci.zza;
        int iZzc = zzgpmVar.zzc();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzgpl zzgplVar : zzgpmVar.zzh()) {
            if (zzgplVar.zzk() == 3) {
                if (!zzgplVar.zzj()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzgplVar.zza())));
                }
                if (zzgplVar.zzf() == zzgqf.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzgplVar.zza())));
                }
                if (zzgplVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzgplVar.zza())));
                }
                if (zzgplVar.zza() == iZzc) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= zzgplVar.zzc().zzc() == zzgoy.ASYMMETRIC_PUBLIC;
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzgby zzgbyVar = new zzgby(clsZzb, null);
        zzgbyVar.zzc(this.zzc);
        for (int i2 = 0; i2 < this.zza.zza(); i2++) {
            zzgpl zzgplVarZze = this.zza.zze(i2);
            if (zzgplVarZze.zzk() == 3) {
                zzghl zzghlVar = (zzghl) zzgbbVar;
                Object objZzg = zzg(zzghlVar, zzgplVarZze, clsZzb);
                Object objZzj = this.zzb.get(i2) != null ? zzj(zzghlVar, ((zzgbr) this.zzb.get(i2)).zza(), clsZzb) : null;
                if (objZzj == null && objZzg == null) {
                    throw new GeneralSecurityException("Unable to get primitive " + clsZzb.toString() + " for key of type " + zzgplVarZze.zzc().zzg());
                }
                if (zzgplVarZze.zza() == this.zza.zzc()) {
                    zzgbyVar.zzb(objZzj, objZzg, zzgplVarZze);
                } else {
                    zzgbyVar.zza(objZzj, objZzg, zzgplVarZze);
                }
            }
        }
        return zzgif.zza().zzd(zzgbyVar.zzd(), cls);
    }
}

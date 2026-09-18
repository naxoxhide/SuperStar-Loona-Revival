package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgbp {
    private final List zza = new ArrayList();
    private final zzgmc zzb = zzgmc.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgbn) it.next()).zza = false;
        }
    }

    public final zzgbp zza(zzgbn zzgbnVar) {
        if (zzgbnVar.zzf != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgbnVar.zza) {
            zzd();
        }
        zzgbnVar.zzf = this;
        this.zza.add(zzgbnVar);
        return this;
    }

    public final zzgbs zzb() throws GeneralSecurityException {
        int i;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        char c = 1;
        this.zzc = true;
        List list = this.zza;
        zzgpj zzgpjVarZzd = zzgpm.zzd();
        int i2 = 0;
        while (i2 < list.size() - 1) {
            int i3 = i2 + 1;
            if (((zzgbn) list.get(i2)).zze == zzgbo.zza && ((zzgbn) list.get(i3)).zze != zzgbo.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i2 = i3;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzgbn zzgbnVar : this.zza) {
            zzgbj unused = zzgbnVar.zzb;
            if (zzgbnVar.zze == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            int i4 = 3;
            if (zzgbnVar.zze == zzgbo.zza) {
                i = 0;
                while (true) {
                    if (i != 0 && !hashSet.contains(Integer.valueOf(i))) {
                        break;
                    }
                    SecureRandom secureRandom = new SecureRandom();
                    byte[] bArr = new byte[4];
                    int i5 = 0;
                    while (i5 == 0) {
                        secureRandom.nextBytes(bArr);
                        i5 = ((bArr[0] & 255) << 24) | ((bArr[c] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                        c = 1;
                    }
                    i = i5;
                }
            } else {
                zzgbo unused2 = zzgbnVar.zze;
                i = 0;
            }
            Integer numValueOf = Integer.valueOf(i);
            if (hashSet.contains(numValueOf)) {
                throw new GeneralSecurityException("Id " + i + " is used twice in the keyset");
            }
            hashSet.add(numValueOf);
            zzgbn.zza(zzgbnVar);
            zzgbw zzgbwVar = zzgbnVar.zzd;
            zzgbj zzgbjVarZzc = zzgbnVar.zzc();
            if (!zzgbj.zza.equals(zzgbjVarZzc)) {
                if (zzgbj.zzb.equals(zzgbjVarZzc)) {
                    i4 = 4;
                } else {
                    if (!zzgbj.zzc.equals(zzgbjVarZzc)) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    i4 = 5;
                }
            }
            if (zzgbwVar instanceof zzghy) {
                throw null;
            }
            zzgjd zzgjdVar = (zzgjd) zzgii.zzb().zzc(zzgbwVar, zzgjd.class);
            zzgoz zzgozVarZza = zzgcg.zza(zzgjdVar.zzb());
            zzgpk zzgpkVarZzd = zzgpl.zzd();
            zzgpkVarZzd.zzb(i);
            zzgpkVarZzd.zzd(i4);
            zzgpkVarZzd.zza(zzgozVarZza);
            zzgpkVarZzd.zzc(zzgjdVar.zzb().zze());
            zzgpjVarZzd.zza((zzgpl) zzgpkVarZzd.zzal());
            if (zzgbnVar.zza) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgbnVar.zzb != zzgbj.zza) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            c = 1;
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzgpjVarZzd.zzb(num.intValue());
        return zzgbs.zzb((zzgpm) zzgpjVarZzd.zzal(), this.zzb);
    }
}

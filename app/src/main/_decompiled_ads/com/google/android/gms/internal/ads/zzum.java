package com.google.android.gms.internal.ads;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzum implements zztu, zztt {
    private final zztu[] zza;
    private zztt zze;
    private zzvx zzf;
    private final zzth zzi;
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzvq zzh = new zztg(new zzvq[0]);
    private final IdentityHashMap zzb = new IdentityHashMap();
    private zztu[] zzg = new zztu[0];

    public zzum(zzth zzthVar, long[] jArr, zztu... zztuVarArr) {
        this.zzi = zzthVar;
        this.zza = zztuVarArr;
        for (int i = 0; i < zztuVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzuk(zztuVarArr[i], j);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zza(long j, zzlv zzlvVar) {
        zztu[] zztuVarArr = this.zzg;
        return (zztuVarArr.length > 0 ? zztuVarArr[0] : this.zza[0]).zza(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzb() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzc() {
        return this.zzh.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzd() {
        long j = -9223372036854775807L;
        for (zztu zztuVar : this.zzg) {
            long jZzd = zztuVar.zzd();
            if (jZzd == -9223372036854775807L) {
                if (j != -9223372036854775807L && zztuVar.zze(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (zztu zztuVar2 : this.zzg) {
                    if (zztuVar2 == zztuVar) {
                        break;
                    }
                    if (zztuVar2.zze(jZzd) != jZzd) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = jZzd;
            } else if (jZzd != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zze(long j) {
        long jZze = this.zzg[0].zze(j);
        int i = 1;
        while (true) {
            zztu[] zztuVarArr = this.zzg;
            if (i >= zztuVarArr.length) {
                return jZze;
            }
            if (zztuVarArr[i].zze(jZze) != jZze) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzf(zzxk[] zzxkVarArr, boolean[] zArr, zzvo[] zzvoVarArr, boolean[] zArr2, long j) {
        int length;
        int length2 = zzxkVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i = 0;
        int i2 = 0;
        while (true) {
            length = zzxkVarArr.length;
            if (i2 >= length) {
                break;
            }
            zzvo zzvoVar = zzvoVarArr[i2];
            Integer num = zzvoVar != null ? (Integer) this.zzb.get(zzvoVar) : null;
            iArr[i2] = num == null ? -1 : num.intValue();
            zzxk zzxkVar = zzxkVarArr[i2];
            if (zzxkVar != null) {
                String str = zzxkVar.zze().zzc;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(CertificateUtil.DELIMITER)));
            } else {
                iArr2[i2] = -1;
            }
            i2++;
        }
        this.zzb.clear();
        zzvo[] zzvoVarArr2 = new zzvo[length];
        zzvo[] zzvoVarArr3 = new zzvo[length];
        zzxk[] zzxkVarArr2 = new zzxk[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.zza.length) {
            for (int i4 = i; i4 < zzxkVarArr.length; i4++) {
                zzvoVarArr3[i4] = iArr[i4] == i3 ? zzvoVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzxk zzxkVar2 = zzxkVarArr[i4];
                    Objects.requireNonNull(zzxkVar2);
                    zzcx zzcxVar = (zzcx) this.zzd.get(zzxkVar2.zze());
                    Objects.requireNonNull(zzcxVar);
                    zzxkVarArr2[i4] = new zzuj(zzxkVar2, zzcxVar);
                } else {
                    zzxkVarArr2[i4] = null;
                }
            }
            ArrayList arrayList2 = arrayList;
            zzxk[] zzxkVarArr3 = zzxkVarArr2;
            zzvo[] zzvoVarArr4 = zzvoVarArr3;
            long jZzf = this.zza[i3].zzf(zzxkVarArr2, zArr, zzvoVarArr3, zArr2, j2);
            if (i3 == 0) {
                j2 = jZzf;
            } else if (jZzf != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i5 = 0; i5 < zzxkVarArr.length; i5++) {
                if (iArr2[i5] == i3) {
                    zzvo zzvoVar2 = zzvoVarArr4[i5];
                    Objects.requireNonNull(zzvoVar2);
                    zzvoVarArr2[i5] = zzvoVar2;
                    this.zzb.put(zzvoVar2, Integer.valueOf(i3));
                    z = true;
                } else if (iArr[i5] == i3) {
                    zzdx.zzf(zzvoVarArr4[i5] == null);
                }
            }
            if (z) {
                arrayList2.add(this.zza[i3]);
            }
            i3++;
            arrayList = arrayList2;
            zzxkVarArr2 = zzxkVarArr3;
            zzvoVarArr3 = zzvoVarArr4;
            i = 0;
        }
        int i6 = i;
        System.arraycopy(zzvoVarArr2, i6, zzvoVarArr, i6, length);
        zztu[] zztuVarArr = (zztu[]) arrayList.toArray(new zztu[i6]);
        this.zzg = zztuVarArr;
        this.zzh = new zztg(zztuVarArr);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvp
    public final /* bridge */ /* synthetic */ void zzg(zzvq zzvqVar) {
        zztt zzttVar = this.zze;
        Objects.requireNonNull(zzttVar);
        zzttVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final zzvx zzh() {
        zzvx zzvxVar = this.zzf;
        Objects.requireNonNull(zzvxVar);
        return zzvxVar;
    }

    @Override // com.google.android.gms.internal.ads.zztt
    public final void zzi(zztu zztuVar) {
        this.zzc.remove(zztuVar);
        if (!this.zzc.isEmpty()) {
            return;
        }
        int i = 0;
        for (zztu zztuVar2 : this.zza) {
            i += zztuVar2.zzh().zzc;
        }
        zzcx[] zzcxVarArr = new zzcx[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zztu[] zztuVarArr = this.zza;
            if (i2 >= zztuVarArr.length) {
                this.zzf = new zzvx(zzcxVarArr);
                zztt zzttVar = this.zze;
                Objects.requireNonNull(zzttVar);
                zzttVar.zzi(this);
                return;
            }
            zzvx zzvxVarZzh = zztuVarArr[i2].zzh();
            int i4 = zzvxVarZzh.zzc;
            int i5 = 0;
            while (i5 < i4) {
                zzcx zzcxVarZzb = zzvxVarZzh.zzb(i5);
                zzcx zzcxVarZzc = zzcxVarZzb.zzc(i2 + CertificateUtil.DELIMITER + zzcxVarZzb.zzc);
                this.zzd.put(zzcxVarZzc, zzcxVarZzb);
                zzcxVarArr[i3] = zzcxVarZzc;
                i5++;
                i3++;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzj(long j, boolean z) {
        for (zztu zztuVar : this.zzg) {
            zztuVar.zzj(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzk() throws IOException {
        int i = 0;
        while (true) {
            zztu[] zztuVarArr = this.zza;
            if (i >= zztuVarArr.length) {
                return;
            }
            zztuVarArr[i].zzk();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzl(zztt zzttVar, long j) {
        this.zze = zzttVar;
        Collections.addAll(this.zzc, this.zza);
        int i = 0;
        while (true) {
            zztu[] zztuVarArr = this.zza;
            if (i >= zztuVarArr.length) {
                return;
            }
            zztuVarArr[i].zzl(this, j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final void zzm(long j) {
        this.zzh.zzm(j);
    }

    public final zztu zzn(int i) {
        zztu zztuVar = this.zza[i];
        return zztuVar instanceof zzuk ? ((zzuk) zztuVar).zza : zztuVar;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzo(zzks zzksVar) {
        if (this.zzc.isEmpty()) {
            return this.zzh.zzo(zzksVar);
        }
        int size = this.zzc.size();
        for (int i = 0; i < size; i++) {
            ((zztu) this.zzc.get(i)).zzo(zzksVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzp() {
        return this.zzh.zzp();
    }
}

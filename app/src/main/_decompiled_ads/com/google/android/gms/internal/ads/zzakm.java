package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakm implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzakj
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzakm.zza;
            return new zzabm[]{new zzakm(0)};
        }
    };
    private final List zzb;
    private final zzfb zzc;
    private final SparseIntArray zzd;
    private final zzakp zze;
    private final SparseArray zzf;
    private final SparseBooleanArray zzg;
    private final SparseBooleanArray zzh;
    private final zzaki zzi;
    private zzakh zzj;
    private zzabp zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;
    private int zzq;

    public zzakm() {
        this(0);
    }

    /* JADX WARN: Code duplicated, block: B:95:0x01b5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v23, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.google.android.gms.internal.ads.zzakr] */
    /* JADX WARN: Type inference failed for: r8v6 */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        ?? r3;
        ?? r8;
        zzakr zzakrVar;
        long j;
        boolean z;
        long jZzd = zzabnVar.zzd();
        if (this.zzm) {
            if (jZzd != -1) {
                zzaki zzakiVar = this.zzi;
                if (!zzakiVar.zzd()) {
                    return zzakiVar.zza(zzabnVar, zzacjVar, this.zzq);
                }
            }
            if (this.zzn) {
                j = 0;
            } else {
                this.zzn = true;
                zzaki zzakiVar2 = this.zzi;
                if (zzakiVar2.zzb() != -9223372036854775807L) {
                    j = 0;
                    zzakh zzakhVar = new zzakh(zzakiVar2.zzc(), zzakiVar2.zzb(), jZzd, this.zzq, 112800);
                    this.zzj = zzakhVar;
                    this.zzk.zzO(zzakhVar.zzb());
                } else {
                    j = 0;
                    this.zzk.zzO(new zzacl(zzakiVar2.zzb(), 0L));
                }
            }
            if (this.zzo) {
                z = false;
                this.zzo = false;
                zzd(j, j);
                if (zzabnVar.zzf() != j) {
                    zzacjVar.zza = j;
                    return 1;
                }
            } else {
                z = false;
            }
            zzakh zzakhVar2 = this.zzj;
            r3 = z;
            if (zzakhVar2 != null && zzakhVar2.zze()) {
                r3 = z;
                return zzakhVar2.zza(zzabnVar, zzacjVar);
            }
        } else {
            r3 = 0;
        }
        r3 = z;
        zzfb zzfbVar = this.zzc;
        byte[] bArrZzI = zzfbVar.zzI();
        if (9400 - zzfbVar.zzc() < 188) {
            int iZza = zzfbVar.zza();
            if (iZza > 0) {
                System.arraycopy(bArrZzI, zzfbVar.zzc(), bArrZzI, r3, iZza);
            }
            this.zzc.zzE(bArrZzI, iZza);
        }
        while (true) {
            zzfb zzfbVar2 = this.zzc;
            if (zzfbVar2.zza() >= 188) {
                int iZzc = zzfbVar2.zzc();
                int iZzd = zzfbVar2.zzd();
                int iZza2 = zzaks.zza(zzfbVar2.zzI(), iZzc, iZzd);
                this.zzc.zzG(iZza2);
                int i = iZza2 + 188;
                if (i > iZzd) {
                    this.zzp += iZza2 - iZzc;
                } else {
                    this.zzp = r3;
                }
                zzfb zzfbVar3 = this.zzc;
                int iZzd2 = zzfbVar3.zzd();
                if (i > iZzd2) {
                    return r3;
                }
                int iZzf = zzfbVar3.zzf();
                if ((8388608 & iZzf) != 0) {
                    this.zzc.zzG(i);
                    return r3;
                }
                ?? r10 = (4194304 & iZzf) != 0 ? 1 : r3;
                int i2 = iZzf & 32;
                int i3 = (iZzf >> 8) & 8191;
                if ((iZzf & 16) != 0) {
                    zzakrVar = (zzakr) this.zzf.get(i3);
                } else {
                    r8 = 0;
                }
                if (r8 == 0) {
                    r8 = zzakrVar;
                    this.zzc.zzG(i);
                    return r3;
                }
                int i4 = iZzf & 15;
                int i5 = this.zzd.get(i3, i4 - 1);
                this.zzd.put(i3, i4);
                if (i5 == i4) {
                    r8 = zzakrVar;
                    this.zzc.zzG(i);
                    return r3;
                }
                if (i4 != ((i5 + 1) & 15)) {
                    r8 = zzakrVar;
                    r8.zzc();
                }
                if (i2 != 0) {
                    zzfb zzfbVar4 = this.zzc;
                    int iZzl = zzfbVar4.zzl();
                    r10 = (r10 == true ? 1 : 0) | ((zzfbVar4.zzl() & 64) != 0 ? 2 : r3);
                    this.zzc.zzH(iZzl - 1);
                }
                boolean z2 = this.zzm;
                if (z2 || !this.zzh.get(i3, r3)) {
                    this.zzc.zzF(i);
                    r8.zza(this.zzc, r10);
                    this.zzc.zzF(iZzd2);
                    if (!z2) {
                        if (this.zzm && jZzd != -1) {
                            this.zzo = true;
                        }
                    }
                } else if (this.zzm) {
                    this.zzo = true;
                }
                this.zzc.zzG(i);
                return r3;
            }
            int iZzd3 = zzfbVar2.zzd();
            int iZza3 = zzabnVar.zza(bArrZzI, iZzd3, 9400 - iZzd3);
            if (iZza3 == -1) {
                for (?? r11 = r3; r11 < this.zzf.size(); r11++) {
                    zzakr zzakrVar2 = (zzakr) this.zzf.valueAt(r11);
                    if (zzakrVar2 instanceof zzajv) {
                        zzakrVar2.zza(new zzfb(), 1);
                    }
                }
                return -1;
            }
            this.zzc.zzF(iZzd3 + iZza3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzk = zzabpVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        zzakh zzakhVar;
        int size = this.zzb.size();
        for (int i = 0; i < size; i++) {
            zzfi zzfiVar = (zzfi) this.zzb.get(i);
            if (zzfiVar.zze() != -9223372036854775807L) {
                long jZzc = zzfiVar.zzc();
                if (jZzc != -9223372036854775807L && jZzc != 0 && jZzc != j2) {
                    zzfiVar.zzf(j2);
                }
            } else {
                zzfiVar.zzf(j2);
            }
        }
        if (j2 != 0 && (zzakhVar = this.zzj) != null) {
            zzakhVar.zzd(j2);
        }
        this.zzc.zzD(0);
        this.zzd.clear();
        for (int i2 = 0; i2 < this.zzf.size(); i2++) {
            ((zzakr) this.zzf.valueAt(i2)).zzc();
        }
        this.zzp = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        byte[] bArrZzI = this.zzc.zzI();
        zzabc zzabcVar = (zzabc) zzabnVar;
        zzabcVar.zzm(bArrZzI, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    zzabcVar.zzo(i, false);
                    return true;
                }
                if (bArrZzI[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public zzakm(int i) {
        this(1, new zzfi(0L), new zzajb(0), 112800);
    }

    public zzakm(int i, zzfi zzfiVar, zzakp zzakpVar, int i2) {
        this.zze = zzakpVar;
        this.zzb = Collections.singletonList(zzfiVar);
        this.zzc = new zzfb(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzg = sparseBooleanArray;
        this.zzh = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzf = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzi = new zzaki(112800);
        this.zzk = zzabp.zza;
        this.zzq = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.zzf.put(sparseArray2.keyAt(i3), (zzakr) sparseArray2.valueAt(i3));
        }
        this.zzf.put(0, new zzake(new zzakk(this)));
    }
}

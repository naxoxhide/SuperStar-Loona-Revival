package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakl implements zzakd {
    final /* synthetic */ zzakm zza;
    private final zzfa zzb = new zzfa(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzakl(zzakm zzakmVar, int i) {
        this.zza = zzakmVar;
        this.zze = i;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00df  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:36:0x0101  */
    /* JADX WARN: Code duplicated, block: B:42:0x0117  */
    @Override // com.google.android.gms.internal.ads.zzakd
    public final void zza(zzfb zzfbVar) {
        zzfi zzfiVar;
        int i;
        int i2;
        int i3;
        int i4;
        if (zzfbVar.zzl() != 2) {
            return;
        }
        zzfi zzfiVar2 = (zzfi) this.zza.zzb.get(0);
        if ((zzfbVar.zzl() & 128) == 0) {
            return;
        }
        zzfbVar.zzH(1);
        int iZzp = zzfbVar.zzp();
        int i5 = 3;
        zzfbVar.zzH(3);
        zzfbVar.zzB(this.zzb, 2);
        this.zzb.zzl(3);
        int i6 = 13;
        this.zza.zzq = this.zzb.zzd(13);
        zzfbVar.zzB(this.zzb, 2);
        int i7 = 4;
        this.zzb.zzl(4);
        int i8 = 12;
        zzfbVar.zzH(this.zzb.zzd(12));
        this.zzc.clear();
        this.zzd.clear();
        int iZza = zzfbVar.zza();
        while (iZza > 0) {
            int i9 = 5;
            zzfbVar.zzB(this.zzb, 5);
            zzfa zzfaVar = this.zzb;
            int iZzd = zzfaVar.zzd(8);
            zzfaVar.zzl(i5);
            int iZzd2 = this.zzb.zzd(i6);
            this.zzb.zzl(i7);
            int iZzd3 = this.zzb.zzd(i8);
            int iZzc = zzfbVar.zzc();
            int i10 = iZzc + iZzd3;
            int i11 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (true) {
                if (zzfbVar.zzc() >= i10) {
                    i2 = i7;
                    break;
                }
                int iZzl = zzfbVar.zzl();
                int iZzc2 = zzfbVar.zzc() + zzfbVar.zzl();
                if (iZzc2 > i10) {
                    i2 = 4;
                    break;
                }
                if (iZzl == i9) {
                    long jZzt = zzfbVar.zzt();
                    if (jZzt == 1094921523) {
                        zzfiVar2 = zzfiVar2;
                        i11 = 129;
                    } else if (jZzt == 1161904947) {
                        zzfiVar2 = zzfiVar2;
                        i11 = 135;
                        i3 = 4;
                        iZzp = iZzp;
                    } else if (jZzt == 1094921524) {
                        zzfiVar2 = zzfiVar2;
                        i11 = 172;
                    } else if (jZzt == 1212503619) {
                        i4 = 36;
                        i11 = i4;
                    }
                    i3 = 4;
                } else if (iZzl == 106) {
                    zzfiVar2 = zzfiVar2;
                    i11 = 129;
                    i3 = 4;
                } else if (iZzl == 122) {
                    zzfiVar2 = zzfiVar2;
                    i11 = 135;
                    i3 = 4;
                    iZzp = iZzp;
                } else if (iZzl == 127) {
                    if (zzfbVar.zzl() == 21) {
                        zzfiVar2 = zzfiVar2;
                        i11 = 172;
                    }
                    i3 = 4;
                } else if (iZzl == 123) {
                    i4 = 138;
                    i11 = i4;
                    i3 = 4;
                } else if (iZzl == 10) {
                    strTrim = zzfbVar.zzy(3, zzfsi.zzc).trim();
                    i3 = 4;
                } else {
                    int i12 = 3;
                    if (iZzl == 89) {
                        ArrayList arrayList2 = new ArrayList();
                        while (zzfbVar.zzc() < iZzc2) {
                            String strTrim2 = zzfbVar.zzy(i12, zzfsi.zzc).trim();
                            int iZzl2 = zzfbVar.zzl();
                            zzfi zzfiVar3 = zzfiVar2;
                            byte[] bArr = new byte[4];
                            zzfbVar.zzC(bArr, 0, 4);
                            arrayList2.add(new zzakn(strTrim2, iZzl2, bArr));
                            zzfiVar2 = zzfiVar3;
                            iZzp = iZzp;
                            i12 = 3;
                        }
                        zzfiVar2 = zzfiVar2;
                        iZzp = iZzp;
                        i3 = 4;
                        arrayList = arrayList2;
                        i11 = 89;
                    } else {
                        zzfiVar2 = zzfiVar2;
                        iZzp = iZzp;
                        i3 = 4;
                        if (iZzl == 111) {
                            i11 = 257;
                        }
                    }
                }
                zzfbVar.zzH(iZzc2 - zzfbVar.zzc());
                i7 = i3;
                zzfiVar2 = zzfiVar2;
                iZzp = iZzp;
                i9 = 5;
            }
            zzfbVar.zzG(i10);
            zzako zzakoVar = new zzako(i11, strTrim, arrayList, Arrays.copyOfRange(zzfbVar.zzI(), iZzc, i10));
            if (iZzd == 6 || iZzd == 5) {
                iZzd = zzakoVar.zza;
            }
            iZza -= iZzd3 + 5;
            if (!this.zza.zzg.get(iZzd2)) {
                zzakr zzakrVarZza = this.zza.zze.zza(iZzd, zzakoVar);
                this.zzd.put(iZzd2, iZzd2);
                this.zzc.put(iZzd2, zzakrVarZza);
            }
            i7 = i2;
            zzfiVar2 = zzfiVar2;
            iZzp = iZzp;
            i5 = 3;
            i8 = 12;
            i6 = 13;
        }
        zzfi zzfiVar4 = zzfiVar2;
        int i13 = iZzp;
        int size = this.zzd.size();
        int i14 = 0;
        while (i14 < size) {
            SparseIntArray sparseIntArray = this.zzd;
            zzakm zzakmVar = this.zza;
            int iKeyAt = sparseIntArray.keyAt(i14);
            int iValueAt = sparseIntArray.valueAt(i14);
            zzakmVar.zzg.put(iKeyAt, true);
            this.zza.zzh.put(iValueAt, true);
            zzakr zzakrVar = (zzakr) this.zzc.valueAt(i14);
            if (zzakrVar != null) {
                zzabp zzabpVar = this.zza.zzk;
                i = i13;
                zzakq zzakqVar = new zzakq(i, iKeyAt, 8192);
                zzfiVar = zzfiVar4;
                zzakrVar.zzb(zzfiVar, zzabpVar, zzakqVar);
                this.zza.zzf.put(iValueAt, zzakrVar);
            } else {
                zzfiVar = zzfiVar4;
                i = i13;
            }
            i14++;
            zzfiVar4 = zzfiVar;
            i13 = i;
        }
        this.zza.zzf.remove(this.zze);
        this.zza.zzl = 0;
        zzakm zzakmVar2 = this.zza;
        if (zzakmVar2.zzl == 0) {
            zzakmVar2.zzk.zzD();
            this.zza.zzm = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final void zzb(zzfi zzfiVar, zzabp zzabpVar, zzakq zzakqVar) {
    }
}

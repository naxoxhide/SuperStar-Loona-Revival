package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadf implements zzabm {
    private int zzc;
    private zzadg zze;
    private long zzh;
    private zzadi zzi;
    private int zzm;
    private boolean zzn;
    private final zzfb zza = new zzfb(12);
    private final zzade zzb = new zzade(null);
    private zzabp zzd = new zzabk();
    private zzadi[] zzg = new zzadi[0];
    private long zzk = -1;
    private long zzl = -1;
    private int zzj = -1;
    private long zzf = -9223372036854775807L;

    private final zzadi zzf(int i) {
        for (zzadi zzadiVar : this.zzg) {
            if (zzadiVar.zzg(i)) {
                return zzadiVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzc = 0;
        this.zzd = zzabpVar;
        this.zzh = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        int i;
        this.zzh = -1L;
        this.zzi = null;
        for (zzadi zzadiVar : this.zzg) {
            zzadiVar.zzf(j);
        }
        if (j != 0) {
            i = 6;
        } else {
            if (this.zzg.length == 0) {
                this.zzc = 0;
                return;
            }
            i = 3;
        }
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        ((zzabc) zzabnVar).zzm(this.zza.zzI(), 0, 12, false);
        this.zza.zzG(0);
        if (this.zza.zzh() != 1179011410) {
            return false;
        }
        this.zza.zzH(4);
        return this.zza.zzh() == 541677121;
    }

    /* JADX WARN: Code duplicated, block: B:134:0x030c  */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        boolean z;
        int i;
        int i2;
        zzadi zzadiVar;
        long j;
        long j2 = this.zzh;
        int i3 = 0;
        if (j2 != -1) {
            long jZzf = zzabnVar.zzf();
            if (j2 < jZzf || j2 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + jZzf) {
                zzacjVar.zza = j2;
                z = true;
            } else {
                ((zzabc) zzabnVar).zzo((int) (j2 - jZzf), false);
                z = false;
            }
        } else {
            z = false;
        }
        this.zzh = -1L;
        if (z) {
            return 1;
        }
        int i4 = this.zzc;
        zzadi zzadiVar2 = null;
        if (i4 == 0) {
            if (!zze(zzabnVar)) {
                throw zzcc.zza("AVI Header List not found", null);
            }
            ((zzabc) zzabnVar).zzo(12, false);
            this.zzc = 1;
            return 0;
        }
        if (i4 == 1) {
            ((zzabc) zzabnVar).zzn(this.zza.zzI(), 0, 12, false);
            this.zza.zzG(0);
            zzade zzadeVar = this.zzb;
            zzfb zzfbVar = this.zza;
            zzadeVar.zza(zzfbVar);
            int i5 = zzadeVar.zza;
            if (i5 != 1414744396) {
                throw zzcc.zza("LIST expected, found: " + i5, null);
            }
            zzadeVar.zzc = zzfbVar.zzh();
            zzade zzadeVar2 = this.zzb;
            int i6 = zzadeVar2.zzc;
            if (i6 == 1819436136) {
                this.zzj = zzadeVar2.zzb;
                this.zzc = 2;
                return 0;
            }
            throw zzcc.zza("hdrl expected, found: " + i6, null);
        }
        if (i4 == 2) {
            int i7 = this.zzj - 4;
            zzfb zzfbVar2 = new zzfb(i7);
            ((zzabc) zzabnVar).zzn(zzfbVar2.zzI(), 0, i7, false);
            zzadj zzadjVarZzc = zzadj.zzc(1819436136, zzfbVar2);
            if (zzadjVarZzc.zza() != 1819436136) {
                throw zzcc.zza("Unexpected header list type " + zzadjVarZzc.zza(), null);
            }
            zzadg zzadgVar = (zzadg) zzadjVarZzc.zzb(zzadg.class);
            if (zzadgVar == null) {
                throw zzcc.zza("AviHeader not found", null);
            }
            this.zze = zzadgVar;
            this.zzf = ((long) zzadgVar.zzc) * ((long) zzadgVar.zza);
            ArrayList arrayList = new ArrayList();
            zzfvs zzfvsVar = zzadjVarZzc.zza;
            int size = zzfvsVar.size();
            int i8 = 0;
            int i9 = 0;
            while (i8 < size) {
                zzadb zzadbVar = (zzadb) zzfvsVar.get(i8);
                if (zzadbVar.zza() == 1819440243) {
                    zzadj zzadjVar = (zzadj) zzadbVar;
                    int i10 = i9 + 1;
                    zzadh zzadhVar = (zzadh) zzadjVar.zzb(zzadh.class);
                    zzadk zzadkVar = (zzadk) zzadjVar.zzb(zzadk.class);
                    if (zzadhVar == null) {
                        zzer.zzf("AviExtractor", "Missing Stream Header");
                    } else {
                        if (zzadkVar == null) {
                            zzer.zzf("AviExtractor", "Missing Stream Format");
                        } else {
                            int i11 = zzadhVar.zzd;
                            int i12 = zzadhVar.zzb;
                            int i13 = zzadhVar.zzc;
                            zzam zzamVar = zzadkVar.zza;
                            i = i10;
                            long jZzr = zzfk.zzr(i11, ((long) i12) * 1000000, i13);
                            zzak zzakVarZzb = zzamVar.zzb();
                            zzakVarZzb.zzI(i9);
                            int i14 = zzadhVar.zze;
                            if (i14 != 0) {
                                zzakVarZzb.zzN(i14);
                            }
                            zzadl zzadlVar = (zzadl) zzadjVar.zzb(zzadl.class);
                            if (zzadlVar != null) {
                                zzakVarZzb.zzL(zzadlVar.zza);
                            }
                            int iZzb = zzcb.zzb(zzamVar.zzm);
                            if (iZzb == 1) {
                                i2 = iZzb;
                            } else if (iZzb == 2) {
                                i2 = 2;
                            } else {
                                zzadiVar = null;
                            }
                            zzacs zzacsVarZzw = this.zzd.zzw(i9, i2);
                            zzacsVarZzw.zzl(zzakVarZzb.zzac());
                            zzadiVar = new zzadi(i9, i2, jZzr, zzadhVar.zzd, zzacsVarZzw);
                            this.zzf = jZzr;
                        }
                        if (zzadiVar != null) {
                            arrayList.add(zzadiVar);
                        }
                        i9 = i;
                    }
                    zzadiVar = zzadiVar2;
                    i = i10;
                    if (zzadiVar != null) {
                        arrayList.add(zzadiVar);
                    }
                    i9 = i;
                }
                i8++;
                zzadiVar2 = null;
                i3 = 0;
            }
            int i15 = i3;
            this.zzg = (zzadi[]) arrayList.toArray(new zzadi[i15]);
            this.zzd.zzD();
            this.zzc = 3;
            return i15;
        }
        if (i4 == 3) {
            long j3 = this.zzk;
            if (j3 != -1 && zzabnVar.zzf() != j3) {
                this.zzh = j3;
                return 0;
            }
            zzabc zzabcVar = (zzabc) zzabnVar;
            zzabcVar.zzm(this.zza.zzI(), 0, 12, false);
            zzabnVar.zzj();
            this.zza.zzG(0);
            this.zzb.zza(this.zza);
            zzfb zzfbVar3 = this.zza;
            zzade zzadeVar3 = this.zzb;
            int iZzh = zzfbVar3.zzh();
            int i16 = zzadeVar3.zza;
            if (i16 == 1179011410) {
                zzabcVar.zzo(12, false);
                return 0;
            }
            if (i16 != 1414744396 || iZzh != 1769369453) {
                this.zzh = zzabnVar.zzf() + ((long) zzadeVar3.zzb) + 8;
                return 0;
            }
            long jZzf2 = zzabnVar.zzf();
            this.zzk = jZzf2;
            long j4 = jZzf2 + ((long) zzadeVar3.zzb) + 8;
            this.zzl = j4;
            if (!this.zzn) {
                zzadg zzadgVar2 = this.zze;
                Objects.requireNonNull(zzadgVar2);
                if ((zzadgVar2.zzb & 16) == 16) {
                    this.zzc = 4;
                    this.zzh = j4;
                    return 0;
                }
                this.zzd.zzO(new zzacl(this.zzf, 0L));
                this.zzn = true;
            }
            this.zzh = zzabnVar.zzf() + 12;
            this.zzc = 6;
            return 0;
        }
        if (i4 == 4) {
            ((zzabc) zzabnVar).zzn(this.zza.zzI(), 0, 8, false);
            this.zza.zzG(0);
            zzfb zzfbVar4 = this.zza;
            int iZzh2 = zzfbVar4.zzh();
            int iZzh3 = zzfbVar4.zzh();
            if (iZzh2 == 829973609) {
                this.zzc = 5;
                this.zzm = iZzh3;
            } else {
                this.zzh = zzabnVar.zzf() + ((long) iZzh3);
            }
            return 0;
        }
        if (i4 == 5) {
            zzfb zzfbVar5 = new zzfb(this.zzm);
            ((zzabc) zzabnVar).zzn(zzfbVar5.zzI(), 0, this.zzm, false);
            if (zzfbVar5.zza() < 16) {
                j = 0;
            } else {
                int iZzc = zzfbVar5.zzc();
                zzfbVar5.zzH(8);
                long jZzh = zzfbVar5.zzh();
                long j5 = this.zzk;
                j = jZzh > j5 ? 0L : j5 + 8;
                zzfbVar5.zzG(iZzc);
            }
            while (zzfbVar5.zza() >= 16) {
                int iZzh4 = zzfbVar5.zzh();
                int iZzh5 = zzfbVar5.zzh();
                long jZzh2 = ((long) zzfbVar5.zzh()) + j;
                zzfbVar5.zzh();
                zzadi zzadiVarZzf = zzf(iZzh4);
                if (zzadiVarZzf != null) {
                    if ((iZzh5 & 16) == 16) {
                        zzadiVarZzf.zzb(jZzh2);
                    }
                    zzadiVarZzf.zzd();
                }
            }
            for (zzadi zzadiVar3 : this.zzg) {
                zzadiVar3.zzc();
            }
            this.zzn = true;
            this.zzd.zzO(new zzadc(this, this.zzf));
            this.zzc = 6;
            this.zzh = this.zzk;
            return 0;
        }
        if (zzabnVar.zzf() >= this.zzl) {
            return -1;
        }
        zzadi zzadiVar4 = this.zzi;
        if (zzadiVar4 != null) {
            if (!zzadiVar4.zzh(zzabnVar)) {
                return 0;
            }
            this.zzi = null;
            return 0;
        }
        if ((zzabnVar.zzf() & 1) == 1) {
            ((zzabc) zzabnVar).zzo(1, false);
        }
        zzabc zzabcVar2 = (zzabc) zzabnVar;
        zzabcVar2.zzm(this.zza.zzI(), 0, 12, false);
        this.zza.zzG(0);
        int iZzh6 = this.zza.zzh();
        if (iZzh6 == 1414744396) {
            this.zza.zzG(8);
            zzabcVar2.zzo(this.zza.zzh() != 1769369453 ? 8 : 12, false);
            zzabnVar.zzj();
            return 0;
        }
        int iZzh7 = this.zza.zzh();
        if (iZzh6 == 1263424842) {
            this.zzh = zzabnVar.zzf() + ((long) iZzh7) + 8;
            return 0;
        }
        zzabcVar2.zzo(8, false);
        zzabnVar.zzj();
        zzadi zzadiVarZzf2 = zzf(iZzh6);
        if (zzadiVarZzf2 == null) {
            this.zzh = zzabnVar.zzf() + ((long) iZzh7);
            return 0;
        }
        zzadiVarZzf2.zze(iZzh7);
        this.zzi = zzadiVarZzf2;
        return 0;
    }
}

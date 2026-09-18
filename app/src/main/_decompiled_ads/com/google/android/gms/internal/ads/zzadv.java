package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadv implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzadu
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzadv.zza;
            return new zzabm[]{new zzadv()};
        }
    };
    private zzabp zzg;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private boolean zzo;
    private zzadt zzp;
    private zzadz zzq;
    private final zzfb zzb = new zzfb(4);
    private final zzfb zzc = new zzfb(9);
    private final zzfb zzd = new zzfb(11);
    private final zzfb zze = new zzfb();
    private final zzadw zzf = new zzadw();
    private int zzh = 1;

    private final zzfb zza(zzabn zzabnVar) throws IOException {
        if (this.zzm > this.zze.zzb()) {
            zzfb zzfbVar = this.zze;
            int iZzb = zzfbVar.zzb();
            zzfbVar.zzE(new byte[Math.max(iZzb + iZzb, this.zzm)], 0);
        } else {
            this.zze.zzG(0);
        }
        this.zze.zzF(this.zzm);
        ((zzabc) zzabnVar).zzn(this.zze.zzI(), 0, this.zzm, false);
        return this.zze;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzf() {
        if (this.zzo) {
            return;
        }
        this.zzg.zzO(new zzacl(-9223372036854775807L, 0L));
        this.zzo = true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        long j;
        boolean zZzf;
        boolean z;
        long j2;
        zzdx.zzb(this.zzg);
        while (true) {
            int i = this.zzh;
            int i2 = 8;
            if (i != 1) {
                if (i == 2) {
                    ((zzabc) zzabnVar).zzo(this.zzk, false);
                    this.zzk = 0;
                    this.zzh = 3;
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    if (this.zzi) {
                        j = this.zzj + this.zzn;
                    } else {
                        j = this.zzf.zzc() == -9223372036854775807L ? 0L : this.zzn;
                    }
                    int i3 = this.zzl;
                    if (i3 == 8) {
                        if (this.zzp != null) {
                            zzf();
                            zZzf = this.zzp.zzf(zza(zzabnVar), j);
                        }
                        z = true;
                        if (!this.zzi && zZzf) {
                            this.zzi = true;
                            if (this.zzf.zzc() == -9223372036854775807L) {
                                j2 = -this.zzn;
                            } else {
                                j2 = 0;
                            }
                            this.zzj = j2;
                        }
                        this.zzk = 4;
                        this.zzh = 2;
                        if (z) {
                            return 0;
                        }
                    } else {
                        i2 = i3;
                    }
                    if (i2 == 9) {
                        if (this.zzq != null) {
                            zzf();
                            zZzf = this.zzq.zzf(zza(zzabnVar), j);
                            z = true;
                        } else {
                            ((zzabc) zzabnVar).zzo(this.zzm, false);
                            zZzf = false;
                            z = false;
                        }
                    } else if (i2 != 18 || this.zzo) {
                        ((zzabc) zzabnVar).zzo(this.zzm, false);
                        zZzf = false;
                        z = false;
                    } else {
                        zZzf = this.zzf.zzf(zza(zzabnVar), j);
                        zzadw zzadwVar = this.zzf;
                        long jZzc = zzadwVar.zzc();
                        if (jZzc != -9223372036854775807L) {
                            this.zzg.zzO(new zzacf(zzadwVar.zzd(), zzadwVar.zze(), jZzc));
                            this.zzo = true;
                        }
                        z = true;
                    }
                    if (!this.zzi) {
                        this.zzi = true;
                        if (this.zzf.zzc() == -9223372036854775807L) {
                            j2 = -this.zzn;
                        } else {
                            j2 = 0;
                        }
                        this.zzj = j2;
                    }
                    this.zzk = 4;
                    this.zzh = 2;
                    if (z) {
                        return 0;
                    }
                } else {
                    if (!zzabnVar.zzn(this.zzd.zzI(), 0, 11, true)) {
                        return -1;
                    }
                    this.zzd.zzG(0);
                    this.zzl = this.zzd.zzl();
                    this.zzm = this.zzd.zzn();
                    this.zzn = this.zzd.zzn();
                    this.zzn = (((long) (this.zzd.zzl() << 24)) | this.zzn) * 1000;
                    this.zzd.zzH(3);
                    this.zzh = 4;
                }
            } else {
                if (!zzabnVar.zzn(this.zzc.zzI(), 0, 9, true)) {
                    return -1;
                }
                this.zzc.zzG(0);
                this.zzc.zzH(4);
                int iZzl = this.zzc.zzl();
                int i4 = iZzl & 4;
                int i5 = iZzl & 1;
                if (i4 != 0 && this.zzp == null) {
                    this.zzp = new zzadt(this.zzg.zzw(8, 1));
                }
                if (i5 != 0 && this.zzq == null) {
                    this.zzq = new zzadz(this.zzg.zzw(9, 2));
                }
                this.zzg.zzD();
                this.zzk = this.zzc.zzf() - 5;
                this.zzh = 2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzg = zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        if (j == 0) {
            this.zzh = 1;
            this.zzi = false;
        } else {
            this.zzh = 3;
        }
        this.zzk = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        zzabc zzabcVar = (zzabc) zzabnVar;
        zzabcVar.zzm(this.zzb.zzI(), 0, 3, false);
        this.zzb.zzG(0);
        if (this.zzb.zzn() != 4607062) {
            return false;
        }
        zzabcVar.zzm(this.zzb.zzI(), 0, 2, false);
        this.zzb.zzG(0);
        if ((this.zzb.zzp() & 250) != 0) {
            return false;
        }
        zzabcVar.zzm(this.zzb.zzI(), 0, 4, false);
        this.zzb.zzG(0);
        int iZzf = this.zzb.zzf();
        zzabnVar.zzj();
        zzabcVar.zzl(iZzf, false);
        zzabcVar.zzm(this.zzb.zzI(), 0, 4, false);
        this.zzb.zzG(0);
        return this.zzb.zzf() == 0;
    }
}

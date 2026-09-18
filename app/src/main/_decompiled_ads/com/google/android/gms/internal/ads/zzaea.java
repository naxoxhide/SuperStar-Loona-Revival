package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaea implements zzabm {
    private zzabp zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzafu zzg;
    private zzabn zzh;
    private zzaed zzi;
    private zzahr zzj;
    private final zzfb zza = new zzfb(6);
    private long zzf = -1;

    private final int zza(zzabn zzabnVar) throws IOException {
        this.zza.zzD(2);
        ((zzabc) zzabnVar).zzm(this.zza.zzI(), 0, 2, false);
        return this.zza.zzp();
    }

    private final void zzf() {
        zzg(new zzbx[0]);
        zzabp zzabpVar = this.zzb;
        Objects.requireNonNull(zzabpVar);
        zzabpVar.zzD();
        this.zzb.zzO(new zzacl(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e4  */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        int i;
        String strZzw;
        zzaec zzaecVarZza;
        zzafu zzafuVar;
        long j;
        int i2 = this.zzc;
        if (i2 == 0) {
            this.zza.zzD(2);
            ((zzabc) zzabnVar).zzn(this.zza.zzI(), 0, 2, false);
            int iZzp = this.zza.zzp();
            this.zzd = iZzp;
            if (iZzp == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                    return 0;
                }
                zzf();
                return 0;
            }
            if ((iZzp >= 65488 && iZzp <= 65497) || iZzp == 65281) {
                return 0;
            }
            this.zzc = 1;
            return 0;
        }
        if (i2 == 1) {
            this.zza.zzD(2);
            ((zzabc) zzabnVar).zzn(this.zza.zzI(), 0, 2, false);
            this.zze = this.zza.zzp() - 2;
            this.zzc = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.zzi == null || zzabnVar != this.zzh) {
                    this.zzh = zzabnVar;
                    this.zzi = new zzaed(zzabnVar, this.zzf);
                }
                zzahr zzahrVar = this.zzj;
                Objects.requireNonNull(zzahrVar);
                int iZzb = zzahrVar.zzb(this.zzi, zzacjVar);
                if (iZzb == 1) {
                    zzacjVar.zza += this.zzf;
                }
                return iZzb;
            }
            long jZzf = zzabnVar.zzf();
            long j2 = this.zzf;
            if (jZzf != j2) {
                zzacjVar.zza = j2;
                return 1;
            }
            if (zzabnVar.zzm(this.zza.zzI(), 0, 1, true)) {
                zzabnVar.zzj();
                if (this.zzj == null) {
                    this.zzj = new zzahr(0);
                }
                zzaed zzaedVar = new zzaed(zzabnVar, this.zzf);
                this.zzi = zzaedVar;
                if (this.zzj.zze(zzaedVar)) {
                    zzahr zzahrVar2 = this.zzj;
                    long j3 = this.zzf;
                    zzabp zzabpVar = this.zzb;
                    Objects.requireNonNull(zzabpVar);
                    zzahrVar2.zzc(new zzaef(j3, zzabpVar));
                    zzafu zzafuVar2 = this.zzg;
                    Objects.requireNonNull(zzafuVar2);
                    zzg(zzafuVar2);
                    this.zzc = 5;
                } else {
                    zzf();
                }
            } else {
                zzf();
            }
            return 0;
        }
        if (this.zzd == 65505) {
            zzfb zzfbVar = new zzfb(this.zze);
            ((zzabc) zzabnVar).zzn(zzfbVar.zzI(), 0, this.zze, false);
            if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzfbVar.zzw((char) 0)) && (strZzw = zzfbVar.zzw((char) 0)) != null) {
                long jZzd = zzabnVar.zzd();
                if (jZzd == -1 || (zzaecVarZza = zzaeg.zza(strZzw)) == null || zzaecVarZza.zzb.size() < 2) {
                    zzafuVar = null;
                } else {
                    long j4 = -1;
                    long j5 = -1;
                    long j6 = -1;
                    long j7 = -1;
                    boolean zEquals = false;
                    for (int size = zzaecVarZza.zzb.size() - 1; size >= 0; size--) {
                        zzaeb zzaebVar = (zzaeb) zzaecVarZza.zzb.get(size);
                        zEquals |= "video/mp4".equals(zzaebVar.zza);
                        if (size == 0) {
                            jZzd -= zzaebVar.zzd;
                            j = 0;
                        } else {
                            j = jZzd - zzaebVar.zzc;
                        }
                        long j8 = jZzd;
                        jZzd = j;
                        if (zEquals && jZzd != j8) {
                            j7 = j8 - jZzd;
                            j6 = jZzd;
                            zEquals = false;
                        }
                        if (size == 0) {
                            j5 = j8;
                        }
                        if (size == 0) {
                            j4 = jZzd;
                        }
                    }
                    if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
                        zzafuVar = null;
                    } else {
                        zzafuVar = new zzafu(j4, j5, zzaecVarZza.zza, j6, j7);
                    }
                }
                this.zzg = zzafuVar;
                if (zzafuVar != null) {
                    this.zzf = zzafuVar.zzd;
                }
                i = 0;
            } else {
                i = 0;
            }
        } else {
            i = 0;
            ((zzabc) zzabnVar).zzo(this.zze, false);
        }
        this.zzc = i;
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzb = zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        if (zza(zzabnVar) != 65496) {
            return false;
        }
        int iZza = zza(zzabnVar);
        this.zzd = iZza;
        if (iZza == 65504) {
            this.zza.zzD(2);
            zzabc zzabcVar = (zzabc) zzabnVar;
            zzabcVar.zzm(this.zza.zzI(), 0, 2, false);
            zzabcVar.zzl(this.zza.zzp() - 2, false);
            iZza = zza(zzabnVar);
            this.zzd = iZza;
        }
        if (iZza == 65505) {
            zzabc zzabcVar2 = (zzabc) zzabnVar;
            zzabcVar2.zzl(2, false);
            this.zza.zzD(6);
            zzabcVar2.zzm(this.zza.zzI(), 0, 6, false);
            if (this.zza.zzt() == 1165519206 && this.zza.zzp() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzahr zzahrVar = this.zzj;
            Objects.requireNonNull(zzahrVar);
            zzahrVar.zzd(j, j2);
        }
    }

    private final void zzg(zzbx... zzbxVarArr) {
        zzabp zzabpVar = this.zzb;
        Objects.requireNonNull(zzabpVar);
        zzacs zzacsVarZzw = zzabpVar.zzw(1024, 4);
        zzak zzakVar = new zzak();
        zzakVar.zzB("image/jpeg");
        zzakVar.zzO(new zzby(-9223372036854775807L, zzbxVarArr));
        zzacsVarZzw.zzl(zzakVar.zzac());
    }
}

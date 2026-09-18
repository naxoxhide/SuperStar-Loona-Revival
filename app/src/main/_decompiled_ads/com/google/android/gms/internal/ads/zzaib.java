package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaib implements zzaii {
    private final zzaih zza;
    private final long zzb;
    private final long zzc;
    private final zzain zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzaib(zzain zzainVar, long j, long j2, long j3, long j4, boolean z) {
        zzdx.zzd(j >= 0 && j2 > j);
        this.zzd = zzainVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzaih();
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final /* bridge */ /* synthetic */ zzacm zze() {
        zzahz zzahzVar = null;
        if (this.zzf != 0) {
            return new zzaia(this, zzahzVar);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzg(long j) {
        this.zzh = Math.max(0L, Math.min(j, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(zzabn zzabnVar) throws IOException {
        long jMax;
        int i = this.zze;
        if (i == 0) {
            long jZzf = zzabnVar.zzf();
            this.zzg = jZzf;
            this.zze = 1;
            long j = this.zzc - 65307;
            if (j > jZzf) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long j2 = this.zzi;
                long j3 = this.zzj;
                if (j2 == j3) {
                    jMax = -1;
                } else {
                    long jZzf2 = zzabnVar.zzf();
                    if (this.zza.zzc(zzabnVar, j3)) {
                        this.zza.zzb(zzabnVar, false);
                        zzabnVar.zzj();
                        long j4 = this.zzh;
                        zzaih zzaihVar = this.zza;
                        long j5 = zzaihVar.zzb;
                        long j6 = j4 - j5;
                        int i2 = zzaihVar.zzd + zzaihVar.zze;
                        if (j6 < 0 || j6 >= 72000) {
                            if (j6 < 0) {
                                this.zzj = jZzf2;
                                this.zzl = j5;
                            } else {
                                this.zzi = zzabnVar.zzf() + ((long) i2);
                                this.zzk = j5;
                            }
                            long j7 = this.zzj;
                            long j8 = this.zzi;
                            long j9 = j7 - j8;
                            if (j9 < 100000) {
                                this.zzj = j8;
                                jMax = j8;
                            } else {
                                jMax = Math.max(j8, Math.min((zzabnVar.zzf() - (((long) i2) * (j6 <= 0 ? 2L : 1L))) + ((j6 * j9) / (this.zzl - this.zzk)), j7 - 1));
                            }
                        } else {
                            jMax = -1;
                        }
                    } else {
                        jMax = this.zzi;
                        if (jMax == jZzf2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (jMax != -1) {
                    return jMax;
                }
                this.zze = 3;
            } else if (i != 3) {
                return -1L;
            }
            while (true) {
                this.zza.zzc(zzabnVar, -1L);
                this.zza.zzb(zzabnVar, false);
                zzaih zzaihVar2 = this.zza;
                if (zzaihVar2.zzb > this.zzh) {
                    zzabnVar.zzj();
                    this.zze = 4;
                    return -(this.zzk + 2);
                }
                ((zzabc) zzabnVar).zzo(zzaihVar2.zzd + zzaihVar2.zze, false);
                this.zzi = zzabnVar.zzf();
                this.zzk = this.zza.zzb;
            }
        }
        this.zza.zza();
        if (!this.zza.zzc(zzabnVar, -1L)) {
            throw new EOFException();
        }
        this.zza.zzb(zzabnVar, false);
        zzaih zzaihVar3 = this.zza;
        ((zzabc) zzabnVar).zzo(zzaihVar3.zzd + zzaihVar3.zze, false);
        long j10 = this.zza.zzb;
        while (true) {
            zzaih zzaihVar4 = this.zza;
            if ((zzaihVar4.zza & 4) == 4 || !zzaihVar4.zzc(zzabnVar, -1L) || zzabnVar.zzf() >= this.zzc || !this.zza.zzb(zzabnVar, true)) {
                break;
            }
            zzaih zzaihVar5 = this.zza;
            if (!zzabq.zze(zzabnVar, zzaihVar5.zzd + zzaihVar5.zze)) {
                break;
            }
            j10 = this.zza.zzb;
        }
        this.zzf = j10;
        this.zze = 4;
        return this.zzg;
    }
}

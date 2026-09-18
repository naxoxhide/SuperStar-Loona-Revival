package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzvh {
    private final zzfb zza = new zzfb(32);
    private zzvg zzb;
    private zzvg zzc;
    private zzvg zzd;
    private long zze;
    private final zzxz zzf;

    public zzvh(zzxz zzxzVar) {
        this.zzf = zzxzVar;
        zzvg zzvgVar = new zzvg(0L, 65536);
        this.zzb = zzvgVar;
        this.zzc = zzvgVar;
        this.zzd = zzvgVar;
    }

    private final int zzi(int i) {
        zzvg zzvgVar = this.zzd;
        if (zzvgVar.zzc == null) {
            zzxs zzxsVarZzb = this.zzf.zzb();
            zzvg zzvgVar2 = new zzvg(this.zzd.zzb, 65536);
            zzvgVar.zzc = zzxsVarZzb;
            zzvgVar.zzd = zzvgVar2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvg zzj(zzvg zzvgVar, long j) {
        while (j >= zzvgVar.zzb) {
            zzvgVar = zzvgVar.zzd;
        }
        return zzvgVar;
    }

    private static zzvg zzk(zzvg zzvgVar, long j, ByteBuffer byteBuffer, int i) {
        zzvg zzvgVarZzj = zzj(zzvgVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (zzvgVarZzj.zzb - j));
            byteBuffer.put(zzvgVarZzj.zzc.zza, zzvgVarZzj.zza(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == zzvgVarZzj.zzb) {
                zzvgVarZzj = zzvgVarZzj.zzd;
            }
        }
        return zzvgVarZzj;
    }

    private static zzvg zzl(zzvg zzvgVar, long j, byte[] bArr, int i) {
        zzvg zzvgVarZzj = zzj(zzvgVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzvgVarZzj.zzb - j));
            System.arraycopy(zzvgVarZzj.zzc.zza, zzvgVarZzj.zza(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzvgVarZzj.zzb) {
                zzvgVarZzj = zzvgVarZzj.zzd;
            }
        }
        return zzvgVarZzj;
    }

    private static zzvg zzm(zzvg zzvgVar, zzht zzhtVar, zzvj zzvjVar, zzfb zzfbVar) {
        zzvg zzvgVarZzl;
        if (zzhtVar.zzk()) {
            long j = zzvjVar.zzb;
            int iZzp = 1;
            zzfbVar.zzD(1);
            zzvg zzvgVarZzl2 = zzl(zzvgVar, j, zzfbVar.zzI(), 1);
            long j2 = j + 1;
            byte b2 = zzfbVar.zzI()[0];
            int i = b2 & 128;
            int i2 = b2 & 127;
            zzhq zzhqVar = zzhtVar.zzb;
            byte[] bArr = zzhqVar.zza;
            if (bArr == null) {
                zzhqVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i != 0;
            zzvgVarZzl = zzl(zzvgVarZzl2, j2, zzhqVar.zza, i2);
            long j3 = j2 + ((long) i2);
            if (z) {
                zzfbVar.zzD(2);
                zzvgVarZzl = zzl(zzvgVarZzl, j3, zzfbVar.zzI(), 2);
                j3 += 2;
                iZzp = zzfbVar.zzp();
            }
            int i3 = iZzp;
            int[] iArr = zzhqVar.zzd;
            if (iArr == null || iArr.length < i3) {
                iArr = new int[i3];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhqVar.zze;
            if (iArr3 == null || iArr3.length < i3) {
                iArr3 = new int[i3];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i3 * 6;
                zzfbVar.zzD(i4);
                zzvgVarZzl = zzl(zzvgVarZzl, j3, zzfbVar.zzI(), i4);
                j3 += (long) i4;
                zzfbVar.zzG(0);
                for (int i5 = 0; i5 < i3; i5++) {
                    iArr2[i5] = zzfbVar.zzp();
                    iArr4[i5] = zzfbVar.zzo();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzvjVar.zza - ((int) (j3 - zzvjVar.zzb));
            }
            zzacr zzacrVar = zzvjVar.zzc;
            int i6 = zzfk.zza;
            zzhqVar.zzc(i3, iArr2, iArr4, zzacrVar.zzb, zzhqVar.zza, zzacrVar.zza, zzacrVar.zzc, zzacrVar.zzd);
            long j4 = zzvjVar.zzb;
            int i7 = (int) (j3 - j4);
            zzvjVar.zzb = j4 + ((long) i7);
            zzvjVar.zza -= i7;
        } else {
            zzvgVarZzl = zzvgVar;
        }
        if (!zzhtVar.zze()) {
            zzhtVar.zzi(zzvjVar.zza);
            return zzk(zzvgVarZzl, zzvjVar.zzb, zzhtVar.zzc, zzvjVar.zza);
        }
        zzfbVar.zzD(4);
        zzvg zzvgVarZzl3 = zzl(zzvgVarZzl, zzvjVar.zzb, zzfbVar.zzI(), 4);
        int iZzo = zzfbVar.zzo();
        zzvjVar.zzb += 4;
        zzvjVar.zza -= 4;
        zzhtVar.zzi(iZzo);
        zzvg zzvgVarZzk = zzk(zzvgVarZzl3, zzvjVar.zzb, zzhtVar.zzc, iZzo);
        zzvjVar.zzb += (long) iZzo;
        int i8 = zzvjVar.zza - iZzo;
        zzvjVar.zza = i8;
        ByteBuffer byteBuffer = zzhtVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i8) {
            zzhtVar.zzf = ByteBuffer.allocate(i8);
        } else {
            zzhtVar.zzf.clear();
        }
        return zzk(zzvgVarZzk, zzvjVar.zzb, zzhtVar.zzf, zzvjVar.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzvg zzvgVar = this.zzd;
        if (j == zzvgVar.zzb) {
            this.zzd = zzvgVar.zzd;
        }
    }

    public final int zza(zzt zztVar, int i, boolean z) throws IOException {
        int iZzi = zzi(i);
        zzvg zzvgVar = this.zzd;
        int iZza = zztVar.zza(zzvgVar.zzc.zza, zzvgVar.zza(this.zze), iZzi);
        if (iZza != -1) {
            zzn(iZza);
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzvg zzvgVar;
        if (j != -1) {
            while (true) {
                zzvgVar = this.zzb;
                if (j < zzvgVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzvgVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvgVar.zza) {
                this.zzc = zzvgVar;
            }
        }
    }

    public final void zzd(zzht zzhtVar, zzvj zzvjVar) {
        zzm(this.zzc, zzhtVar, zzvjVar, this.zza);
    }

    public final void zze(zzht zzhtVar, zzvj zzvjVar) {
        this.zzc = zzm(this.zzc, zzhtVar, zzvjVar, this.zza);
    }

    public final void zzf() {
        zzvg zzvgVar = this.zzb;
        if (zzvgVar.zzc != null) {
            this.zzf.zzd(zzvgVar);
            zzvgVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzvg zzvgVar2 = this.zzb;
        this.zzc = zzvgVar2;
        this.zzd = zzvgVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfb zzfbVar, int i) {
        while (i > 0) {
            int iZzi = zzi(i);
            zzvg zzvgVar = this.zzd;
            zzfbVar.zzC(zzvgVar.zzc.zza, zzvgVar.zza(this.zze), iZzi);
            i -= iZzi;
            zzn(iZzi);
        }
    }
}

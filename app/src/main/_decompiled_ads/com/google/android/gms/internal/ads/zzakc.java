package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakc implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzaka
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzakc.zza;
            return new zzabm[]{new zzakc()};
        }
    };
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    private zzajy zzj;
    private zzabp zzk;
    private boolean zzl;
    private final zzfi zzb = new zzfi(0);
    private final zzfb zzd = new zzfb(4096);
    private final SparseArray zzc = new SparseArray();
    private final zzajz zze = new zzajz();

    /* JADX WARN: Code duplicated, block: B:64:0x014f  */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        zzaje zzajgVar;
        zzdx.zzb(this.zzk);
        long jZzd = zzabnVar.zzd();
        if (jZzd != -1) {
            zzajz zzajzVar = this.zze;
            if (!zzajzVar.zze()) {
                return zzajzVar.zza(zzabnVar, zzacjVar);
            }
        }
        if (!this.zzl) {
            this.zzl = true;
            zzajz zzajzVar2 = this.zze;
            if (zzajzVar2.zzb() != -9223372036854775807L) {
                zzajy zzajyVar = new zzajy(zzajzVar2.zzd(), zzajzVar2.zzb(), jZzd);
                this.zzj = zzajyVar;
                this.zzk.zzO(zzajyVar.zzb());
            } else {
                this.zzk.zzO(new zzacl(zzajzVar2.zzb(), 0L));
            }
        }
        zzajy zzajyVar2 = this.zzj;
        if (zzajyVar2 != null && zzajyVar2.zze()) {
            return zzajyVar2.zza(zzabnVar, zzacjVar);
        }
        zzabnVar.zzj();
        long jZze = jZzd != -1 ? jZzd - zzabnVar.zze() : -1L;
        if ((jZze != -1 && jZze < 4) || !zzabnVar.zzm(this.zzd.zzI(), 0, 4, true)) {
            return -1;
        }
        this.zzd.zzG(0);
        int iZzf = this.zzd.zzf();
        if (iZzf == 441) {
            return -1;
        }
        if (iZzf == 442) {
            zzabc zzabcVar = (zzabc) zzabnVar;
            zzabcVar.zzm(this.zzd.zzI(), 0, 10, false);
            this.zzd.zzG(9);
            zzabcVar.zzo((this.zzd.zzl() & 7) + 14, false);
            return 0;
        }
        if (iZzf == 443) {
            zzabc zzabcVar2 = (zzabc) zzabnVar;
            zzabcVar2.zzm(this.zzd.zzI(), 0, 2, false);
            this.zzd.zzG(0);
            zzabcVar2.zzo(this.zzd.zzp() + 6, false);
            return 0;
        }
        if ((iZzf >> 8) != 1) {
            ((zzabc) zzabnVar).zzo(1, false);
            return 0;
        }
        int i = iZzf & 255;
        zzakb zzakbVar = (zzakb) this.zzc.get(i);
        if (!this.zzf) {
            if (zzakbVar == null) {
                zzaje zzajeVar = null;
                if (i == 189) {
                    zzajgVar = new zzaiu(null);
                    this.zzg = true;
                    this.zzi = zzabnVar.zzf();
                } else if ((i & 224) == 192) {
                    zzajgVar = new zzajs(null);
                    this.zzg = true;
                    this.zzi = zzabnVar.zzf();
                } else if ((i & 240) == 224) {
                    zzajgVar = new zzajg(null);
                    this.zzh = true;
                    this.zzi = zzabnVar.zzf();
                } else if (zzajeVar != null) {
                    zzajeVar.zzb(this.zzk, new zzakq(Integer.MIN_VALUE, i, 256));
                    zzakb zzakbVar2 = new zzakb(zzajeVar, this.zzb);
                    this.zzc.put(i, zzakbVar2);
                    zzakbVar = zzakbVar2;
                }
                zzajeVar = zzajgVar;
                if (zzajeVar != null) {
                    zzajeVar.zzb(this.zzk, new zzakq(Integer.MIN_VALUE, i, 256));
                    zzakb zzakbVar3 = new zzakb(zzajeVar, this.zzb);
                    this.zzc.put(i, zzakbVar3);
                    zzakbVar = zzakbVar3;
                }
            }
            boolean z = this.zzg;
            long j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (z && this.zzh) {
                j = this.zzi + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            if (zzabnVar.zzf() > j) {
                this.zzf = true;
                this.zzk.zzD();
            }
        }
        zzabc zzabcVar3 = (zzabc) zzabnVar;
        zzabcVar3.zzm(this.zzd.zzI(), 0, 2, false);
        this.zzd.zzG(0);
        int iZzp = this.zzd.zzp() + 6;
        if (zzakbVar == null) {
            zzabcVar3.zzo(iZzp, false);
        } else {
            this.zzd.zzD(iZzp);
            zzabcVar3.zzn(this.zzd.zzI(), 0, iZzp, false);
            this.zzd.zzG(6);
            zzakbVar.zza(this.zzd);
            zzfb zzfbVar = this.zzd;
            zzfbVar.zzF(zzfbVar.zzb());
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzk = zzabpVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        zzfi zzfiVar = this.zzb;
        if (zzfiVar.zze() != -9223372036854775807L) {
            long jZzc = zzfiVar.zzc();
            if (jZzc != -9223372036854775807L && jZzc != 0 && jZzc != j2) {
                zzfiVar.zzf(j2);
            }
        } else {
            zzfiVar.zzf(j2);
        }
        zzajy zzajyVar = this.zzj;
        if (zzajyVar != null) {
            zzajyVar.zzd(j2);
        }
        for (int i = 0; i < this.zzc.size(); i++) {
            ((zzakb) this.zzc.valueAt(i)).zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        byte[] bArr = new byte[14];
        zzabc zzabcVar = (zzabc) zzabnVar;
        zzabcVar.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzabcVar.zzl(bArr[13] & 7, false);
        zzabcVar.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }
}

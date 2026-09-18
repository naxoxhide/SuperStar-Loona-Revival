package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzva implements zztu, zzabp, zzye, zzyj, zzvm {
    private static final Map zzb;
    private static final zzam zzc;
    private long zzA;
    private boolean zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private int zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private boolean zzJ;
    private int zzK;
    private boolean zzL;
    private boolean zzM;
    private final zzyd zzN;
    private final zzxz zzO;
    private final Uri zzd;
    private final zzgi zze;
    private final zzrd zzf;
    private final zzuf zzg;
    private final zzqx zzh;
    private final zzuw zzi;
    private final long zzj;
    private final zzym zzk = new zzym("ProgressiveMediaPeriod");
    private final zzup zzl;
    private final zzea zzm;
    private final Runnable zzn;
    private final Runnable zzo;
    private final Handler zzp;
    private final boolean zzq;
    private zztt zzr;
    private zzaeq zzs;
    private zzvn[] zzt;
    private zzuy[] zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private zzuz zzy;
    private zzacm zzz;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(map);
        zzak zzakVar = new zzak();
        zzakVar.zzJ("icy");
        zzakVar.zzU("application/x-icy");
        zzc = zzakVar.zzac();
    }

    public zzva(Uri uri, zzgi zzgiVar, zzup zzupVar, zzrd zzrdVar, zzqx zzqxVar, zzyd zzydVar, zzuf zzufVar, zzuw zzuwVar, zzxz zzxzVar, String str, int i, long j) {
        this.zzd = uri;
        this.zze = zzgiVar;
        this.zzf = zzrdVar;
        this.zzh = zzqxVar;
        this.zzN = zzydVar;
        this.zzg = zzufVar;
        this.zzi = zzuwVar;
        this.zzO = zzxzVar;
        this.zzj = i;
        this.zzl = zzupVar;
        this.zzA = j;
        this.zzq = j != -9223372036854775807L;
        this.zzm = new zzea(zzdy.zza);
        this.zzn = new Runnable() { // from class: com.google.android.gms.internal.ads.zzur
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzU();
            }
        };
        this.zzo = new Runnable() { // from class: com.google.android.gms.internal.ads.zzus
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzE();
            }
        };
        this.zzp = zzfk.zzv(null);
        this.zzu = new zzuy[0];
        this.zzt = new zzvn[0];
        this.zzI = -9223372036854775807L;
        this.zzC = 1;
    }

    static /* bridge */ /* synthetic */ void zzC(final zzva zzvaVar) {
        zzvaVar.zzp.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzuq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzF();
            }
        });
    }

    private final int zzQ() {
        int iZzd = 0;
        for (zzvn zzvnVar : this.zzt) {
            iZzd += zzvnVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    private final long zzR(boolean z) {
        int i = 0;
        long jMax = Long.MIN_VALUE;
        while (true) {
            zzvn[] zzvnVarArr = this.zzt;
            if (i >= zzvnVarArr.length) {
                return jMax;
            }
            if (z) {
                jMax = Math.max(jMax, zzvnVarArr[i].zzh());
            } else {
                zzuz zzuzVar = this.zzy;
                Objects.requireNonNull(zzuzVar);
                if (zzuzVar.zzc[i]) {
                    jMax = Math.max(jMax, zzvnVarArr[i].zzh());
                }
            }
            i++;
        }
    }

    private final zzacs zzS(zzuy zzuyVar) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzuyVar.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        zzvn zzvnVar = new zzvn(this.zzO, this.zzf, this.zzh);
        zzvnVar.zzv(this);
        int i2 = length + 1;
        zzuy[] zzuyVarArr = (zzuy[]) Arrays.copyOf(this.zzu, i2);
        zzuyVarArr[length] = zzuyVar;
        int i3 = zzfk.zza;
        this.zzu = zzuyVarArr;
        zzvn[] zzvnVarArr = (zzvn[]) Arrays.copyOf(this.zzt, i2);
        zzvnVarArr[length] = zzvnVar;
        this.zzt = zzvnVarArr;
        return zzvnVar;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzT() {
        zzdx.zzf(this.zzw);
        Objects.requireNonNull(this.zzy);
        Objects.requireNonNull(this.zzz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU() {
        int i;
        if (this.zzM || this.zzw || !this.zzv || this.zzz == null) {
            return;
        }
        for (zzvn zzvnVar : this.zzt) {
            if (zzvnVar.zzi() == null) {
                return;
            }
        }
        this.zzm.zzc();
        int length = this.zzt.length;
        zzcx[] zzcxVarArr = new zzcx[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzam zzamVarZzi = this.zzt[i2].zzi();
            Objects.requireNonNull(zzamVarZzi);
            String str = zzamVarZzi.zzm;
            boolean zZzf = zzcb.zzf(str);
            boolean z = zZzf || zzcb.zzg(str);
            zArr[i2] = z;
            this.zzx = z | this.zzx;
            zzaeq zzaeqVar = this.zzs;
            if (zzaeqVar != null) {
                if (zZzf || this.zzu[i2].zzb) {
                    zzby zzbyVar = zzamVarZzi.zzk;
                    zzby zzbyVar2 = zzbyVar == null ? new zzby(-9223372036854775807L, zzaeqVar) : zzbyVar.zzc(zzaeqVar);
                    zzak zzakVarZzb = zzamVarZzi.zzb();
                    zzakVarZzb.zzO(zzbyVar2);
                    zzamVarZzi = zzakVarZzb.zzac();
                }
                if (zZzf && zzamVarZzi.zzg == -1 && zzamVarZzi.zzh == -1 && (i = zzaeqVar.zza) != -1) {
                    zzak zzakVarZzb2 = zzamVarZzi.zzb();
                    zzakVarZzb2.zzx(i);
                    zzamVarZzi = zzakVarZzb2.zzac();
                }
            }
            zzcxVarArr[i2] = new zzcx(Integer.toString(i2), zzamVarZzi.zzc(this.zzf.zza(zzamVarZzi)));
        }
        this.zzy = new zzuz(new zzvx(zzcxVarArr), zArr);
        this.zzw = true;
        zztt zzttVar = this.zzr;
        Objects.requireNonNull(zzttVar);
        zzttVar.zzi(this);
    }

    private final void zzV(int i) {
        zzT();
        zzuz zzuzVar = this.zzy;
        boolean[] zArr = zzuzVar.zzd;
        if (zArr[i]) {
            return;
        }
        zzam zzamVarZzb = zzuzVar.zza.zzb(i).zzb(0);
        this.zzg.zzc(new zzts(1, zzcb.zzb(zzamVarZzb.zzm), zzamVarZzb, 0, null, zzfk.zzs(this.zzH), -9223372036854775807L));
        zArr[i] = true;
    }

    private final void zzW(int i) {
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (this.zzJ && zArr[i] && !this.zzt[i].zzy(false)) {
            this.zzI = 0L;
            this.zzJ = false;
            this.zzE = true;
            this.zzH = 0L;
            this.zzK = 0;
            for (zzvn zzvnVar : this.zzt) {
                zzvnVar.zzq(false);
            }
            zztt zzttVar = this.zzr;
            Objects.requireNonNull(zzttVar);
            zzttVar.zzg(this);
        }
    }

    private final void zzX() {
        zzuv zzuvVar = new zzuv(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzw) {
            zzdx.zzf(zzY());
            long j = this.zzA;
            if (j != -9223372036854775807L && this.zzI > j) {
                this.zzL = true;
                this.zzI = -9223372036854775807L;
                return;
            }
            zzacm zzacmVar = this.zzz;
            Objects.requireNonNull(zzacmVar);
            zzuv.zzf(zzuvVar, zzacmVar.zzg(this.zzI).zza.zzc, this.zzI);
            for (zzvn zzvnVar : this.zzt) {
                zzvnVar.zzu(this.zzI);
            }
            this.zzI = -9223372036854775807L;
        }
        this.zzK = zzQ();
        long jZza = this.zzk.zza(zzuvVar, this, zzyd.zza(this.zzC));
        zzgn zzgnVar = zzuvVar.zzl;
        this.zzg.zzg(new zztn(zzuvVar.zzb, zzgnVar, zzgnVar.zza, Collections.emptyMap(), jZza, 0L, 0L), new zzts(1, -1, null, 0, null, zzfk.zzs(zzuvVar.zzk), zzfk.zzs(this.zzA)));
    }

    private final boolean zzY() {
        return this.zzI != -9223372036854775807L;
    }

    private final boolean zzZ() {
        return this.zzE || zzY();
    }

    static /* bridge */ /* synthetic */ long zzr(zzva zzvaVar, boolean z) {
        return zzvaVar.zzR(true);
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzD() {
        this.zzv = true;
        this.zzp.post(this.zzn);
    }

    final /* synthetic */ void zzF() {
        this.zzG = true;
    }

    final void zzH() throws IOException {
        this.zzk.zzi(zzyd.zza(this.zzC));
    }

    final void zzI(int i) throws IOException {
        this.zzt[i].zzn();
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzye
    public final /* bridge */ /* synthetic */ void zzJ(zzyi zzyiVar, long j, long j2, boolean z) {
        zzuv zzuvVar = (zzuv) zzyiVar;
        zzhj zzhjVar = zzuvVar.zzd;
        zztn zztnVar = new zztn(zzuvVar.zzb, zzuvVar.zzl, zzhjVar.zzh(), zzhjVar.zzi(), j, j2, zzhjVar.zzg());
        long unused = zzuvVar.zzb;
        this.zzg.zzd(zztnVar, new zzts(1, -1, null, 0, null, zzfk.zzs(zzuvVar.zzk), zzfk.zzs(this.zzA)));
        if (z) {
            return;
        }
        for (zzvn zzvnVar : this.zzt) {
            zzvnVar.zzq(false);
        }
        if (this.zzF > 0) {
            zztt zzttVar = this.zzr;
            Objects.requireNonNull(zzttVar);
            zzttVar.zzg(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzye
    public final /* bridge */ /* synthetic */ void zzK(zzyi zzyiVar, long j, long j2) {
        zzacm zzacmVar;
        if (this.zzA == -9223372036854775807L && (zzacmVar = this.zzz) != null) {
            boolean zZzh = zzacmVar.zzh();
            long jZzR = zzR(true);
            long j3 = jZzR == Long.MIN_VALUE ? 0L : jZzR + 10000;
            this.zzA = j3;
            this.zzi.zza(j3, zZzh, this.zzB);
        }
        zzuv zzuvVar = (zzuv) zzyiVar;
        zzhj zzhjVar = zzuvVar.zzd;
        zztn zztnVar = new zztn(zzuvVar.zzb, zzuvVar.zzl, zzhjVar.zzh(), zzhjVar.zzi(), j, j2, zzhjVar.zzg());
        long unused = zzuvVar.zzb;
        this.zzg.zze(zztnVar, new zzts(1, -1, null, 0, null, zzfk.zzs(zzuvVar.zzk), zzfk.zzs(this.zzA)));
        this.zzL = true;
        zztt zzttVar = this.zzr;
        Objects.requireNonNull(zzttVar);
        zzttVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void zzL() {
        for (zzvn zzvnVar : this.zzt) {
            zzvnVar.zzp();
        }
        this.zzl.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzvm
    public final void zzM(zzam zzamVar) {
        this.zzp.post(this.zzn);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzvn zzvnVar : this.zzt) {
                zzvnVar.zzo();
            }
        }
        this.zzk.zzj(this);
        this.zzp.removeCallbacksAndMessages(null);
        this.zzr = null;
        this.zzM = true;
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzO(final zzacm zzacmVar) {
        this.zzp.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzut
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(zzacmVar);
            }
        });
    }

    final boolean zzP(int i) {
        return !zzZ() && this.zzt[i].zzy(this.zzL);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zza(long j, zzlv zzlvVar) {
        zzT();
        if (!this.zzz.zzh()) {
            return 0L;
        }
        zzack zzackVarZzg = this.zzz.zzg(j);
        zzacn zzacnVar = zzackVarZzg.zza;
        zzacn zzacnVar2 = zzackVarZzg.zzb;
        long j2 = zzlvVar.zzf;
        if (j2 == 0) {
            if (zzlvVar.zzg == 0) {
                return j;
            }
            j2 = 0;
        }
        long j3 = zzacnVar.zzb;
        int i = zzfk.zza;
        long j4 = j - j2;
        long j5 = zzlvVar.zzg;
        long j6 = j + j5;
        long j7 = j ^ j6;
        long j8 = j5 ^ j6;
        if (((j ^ j2) & (j ^ j4)) < 0) {
            j4 = Long.MIN_VALUE;
        }
        if ((j7 & j8) < 0) {
            j6 = Long.MAX_VALUE;
        }
        boolean z = j4 <= j3 && j3 <= j6;
        long j9 = zzacnVar2.zzb;
        boolean z2 = j4 <= j9 && j9 <= j6;
        if (z && z2) {
            if (Math.abs(j3 - j) > Math.abs(j9 - j)) {
                return j9;
            }
        } else if (!z) {
            return z2 ? j9 : j4;
        }
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzb() {
        long jZzR;
        zzT();
        if (this.zzL || this.zzF == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzI;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            jZzR = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzuz zzuzVar = this.zzy;
                if (zzuzVar.zzb[i] && zzuzVar.zzc[i] && !this.zzt[i].zzx()) {
                    jZzR = Math.min(jZzR, this.zzt[i].zzh());
                }
            }
        } else {
            jZzR = Long.MAX_VALUE;
        }
        if (jZzR == Long.MAX_VALUE) {
            jZzR = zzR(false);
        }
        return jZzR == Long.MIN_VALUE ? this.zzH : jZzR;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzc() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzd() {
        if (!this.zzE) {
            return -9223372036854775807L;
        }
        if (!this.zzL && zzQ() <= this.zzK) {
            return -9223372036854775807L;
        }
        this.zzE = false;
        return this.zzH;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zze(long j) {
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (true != this.zzz.zzh()) {
            j = 0;
        }
        this.zzE = false;
        this.zzH = j;
        if (zzY()) {
            this.zzI = j;
            return j;
        }
        if (this.zzC != 7) {
            int length = this.zzt.length;
            for (int i = 0; i < length; i++) {
                zzvn zzvnVar = this.zzt[i];
                if ((this.zzq ? zzvnVar.zzz(zzvnVar.zza()) : zzvnVar.zzA(j, false)) || (!zArr[i] && this.zzx)) {
                }
            }
            return j;
        }
        this.zzJ = false;
        this.zzI = j;
        this.zzL = false;
        zzym zzymVar = this.zzk;
        if (zzymVar.zzl()) {
            for (zzvn zzvnVar2 : this.zzt) {
                zzvnVar2.zzk();
            }
            this.zzk.zzg();
        } else {
            zzymVar.zzh();
            for (zzvn zzvnVar3 : this.zzt) {
                zzvnVar3.zzq(false);
            }
        }
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzf(zzxk[] zzxkVarArr, boolean[] zArr, zzvo[] zzvoVarArr, boolean[] zArr2, long j) {
        boolean z;
        zzxk zzxkVar;
        zzT();
        zzuz zzuzVar = this.zzy;
        zzvx zzvxVar = zzuzVar.zza;
        boolean[] zArr3 = zzuzVar.zzc;
        int i = this.zzF;
        int i2 = 0;
        for (int i3 = 0; i3 < zzxkVarArr.length; i3++) {
            zzvo zzvoVar = zzvoVarArr[i3];
            if (zzvoVar != null && (zzxkVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((zzux) zzvoVar).zzb;
                zzdx.zzf(zArr3[i4]);
                this.zzF--;
                zArr3[i4] = false;
                zzvoVarArr[i3] = null;
            }
        }
        if (this.zzq) {
            z = false;
        } else {
            if (this.zzD) {
                if (i != 0) {
                    z = false;
                }
            } else if (j == 0) {
                z = false;
                j = 0;
            }
            z = true;
        }
        for (int i5 = 0; i5 < zzxkVarArr.length; i5++) {
            if (zzvoVarArr[i5] == null && (zzxkVar = zzxkVarArr[i5]) != null) {
                zzdx.zzf(zzxkVar.zzc() == 1);
                zzdx.zzf(zzxkVar.zza(0) == 0);
                int iZza = zzvxVar.zza(zzxkVar.zze());
                zzdx.zzf(!zArr3[iZza]);
                this.zzF++;
                zArr3[iZza] = true;
                zzvoVarArr[i5] = new zzux(this, iZza);
                zArr2[i5] = true;
                if (!z) {
                    zzvn zzvnVar = this.zzt[iZza];
                    z = (zzvnVar.zzb() == 0 || zzvnVar.zzA(j, true)) ? false : true;
                }
            }
        }
        if (this.zzF == 0) {
            this.zzJ = false;
            this.zzE = false;
            if (this.zzk.zzl()) {
                zzvn[] zzvnVarArr = this.zzt;
                int length = zzvnVarArr.length;
                while (i2 < length) {
                    zzvnVarArr[i2].zzk();
                    i2++;
                }
                this.zzk.zzg();
            } else {
                for (zzvn zzvnVar2 : this.zzt) {
                    zzvnVar2.zzq(false);
                }
            }
        } else if (z) {
            j = zze(j);
            while (i2 < zzvoVarArr.length) {
                if (zzvoVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.zzD = true;
        return j;
    }

    final int zzg(int i, zzkn zzknVar, zzht zzhtVar, int i2) {
        if (zzZ()) {
            return -3;
        }
        zzV(i);
        int iZze = this.zzt[i].zze(zzknVar, zzhtVar, i2, this.zzL);
        if (iZze == -3) {
            zzW(i);
        }
        return iZze;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final zzvx zzh() {
        zzT();
        return this.zzy.zza;
    }

    final int zzi(int i, long j) {
        if (zzZ()) {
            return 0;
        }
        zzV(i);
        zzvn zzvnVar = this.zzt[i];
        int iZzc = zzvnVar.zzc(j, this.zzL);
        zzvnVar.zzw(iZzc);
        if (iZzc != 0) {
            return iZzc;
        }
        zzW(i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzj(long j, boolean z) {
        if (this.zzq) {
            return;
        }
        zzT();
        if (zzY()) {
            return;
        }
        boolean[] zArr = this.zzy.zzc;
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            this.zzt[i].zzj(j, false, zArr[i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzk() throws IOException {
        zzH();
        if (this.zzL && !this.zzw) {
            throw zzcc.zza("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzl(zztt zzttVar, long j) {
        this.zzr = zzttVar;
        this.zzm.zze();
        zzX();
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final void zzm(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzo(zzks zzksVar) {
        if (this.zzL) {
            return false;
        }
        zzym zzymVar = this.zzk;
        if (zzymVar.zzk() || this.zzJ) {
            return false;
        }
        if (this.zzw && this.zzF == 0) {
            return false;
        }
        boolean zZze = this.zzm.zze();
        if (zzymVar.zzl()) {
            return zZze;
        }
        zzX();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzp() {
        return this.zzk.zzl() && this.zzm.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzye
    public final /* bridge */ /* synthetic */ zzyg zzu(zzyi zzyiVar, long j, long j2, IOException iOException, int i) {
        long jMin;
        zzyg zzygVarZzb;
        zzacm zzacmVar;
        zzuv zzuvVar = (zzuv) zzyiVar;
        zzhj zzhjVar = zzuvVar.zzd;
        zztn zztnVar = new zztn(zzuvVar.zzb, zzuvVar.zzl, zzhjVar.zzh(), zzhjVar.zzi(), j, j2, zzhjVar.zzg());
        long unused = zzuvVar.zzk;
        int i2 = zzfk.zza;
        if ((iOException instanceof zzcc) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzha) || (iOException instanceof zzyl)) {
            jMin = -9223372036854775807L;
            break;
        }
        Throwable cause = iOException;
        while (true) {
            if (cause == null) {
                jMin = Math.min((i - 1) * 1000, 5000);
                break;
            }
            if ((cause instanceof zzgj) && ((zzgj) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
            cause = cause.getCause();
        }
        if (jMin == -9223372036854775807L) {
            zzygVarZzb = zzym.zzd;
        } else {
            int iZzQ = zzQ();
            boolean z = iZzQ > this.zzK;
            if (this.zzG || !((zzacmVar = this.zzz) == null || zzacmVar.zza() == -9223372036854775807L)) {
                this.zzK = iZzQ;
            } else {
                boolean z2 = this.zzw;
                if (!z2 || zzZ()) {
                    this.zzE = z2;
                    this.zzH = 0L;
                    this.zzK = 0;
                    for (zzvn zzvnVar : this.zzt) {
                        zzvnVar.zzq(false);
                    }
                    zzuv.zzf(zzuvVar, 0L, 0L);
                } else {
                    this.zzJ = true;
                    zzygVarZzb = zzym.zzc;
                }
            }
            zzygVarZzb = zzym.zzb(z, jMin);
        }
        boolean z3 = !zzygVarZzb.zzc();
        this.zzg.zzf(zztnVar, new zzts(1, -1, null, 0, null, zzfk.zzs(zzuvVar.zzk), zzfk.zzs(this.zzA)), iOException, z3);
        if (z3) {
            long unused2 = zzuvVar.zzb;
        }
        return zzygVarZzb;
    }

    final zzacs zzv() {
        return zzS(new zzuy(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final zzacs zzw(int i, int i2) {
        return zzS(new zzuy(i, false));
    }

    final /* synthetic */ void zzE() {
        if (this.zzM) {
            return;
        }
        zztt zzttVar = this.zzr;
        Objects.requireNonNull(zzttVar);
        zzttVar.zzg(this);
    }

    final /* synthetic */ void zzG(zzacm zzacmVar) {
        this.zzz = this.zzs == null ? zzacmVar : new zzacl(-9223372036854775807L, 0L);
        if (zzacmVar.zza() == -9223372036854775807L && this.zzA != -9223372036854775807L) {
            this.zzz = new zzuu(this, this.zzz);
        }
        this.zzA = this.zzz.zza();
        boolean z = false;
        if (!this.zzG && zzacmVar.zza() == -9223372036854775807L) {
            z = true;
        }
        this.zzB = z;
        this.zzC = true == z ? 7 : 1;
        this.zzi.zza(this.zzA, zzacmVar.zzh(), this.zzB);
        if (this.zzw) {
            return;
        }
        zzU();
    }
}

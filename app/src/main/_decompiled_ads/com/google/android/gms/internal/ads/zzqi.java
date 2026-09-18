package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.util.Pair;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqi implements zzpi {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private float zzI;
    private ByteBuffer zzJ;
    private int zzK;
    private ByteBuffer zzL;
    private byte[] zzM;
    private int zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private int zzS;
    private zzl zzT;
    private zzpu zzU;
    private long zzV;
    private boolean zzW;
    private boolean zzX;
    private final zzpy zzY;
    private final zzpq zzZ;
    private final zzpn zzd;
    private final zzqs zze;
    private final zzfvs zzf;
    private final zzfvs zzg;
    private final zzea zzh;
    private final zzpm zzi;
    private final ArrayDeque zzj;
    private zzqg zzk;
    private final zzqb zzl;
    private final zzqb zzm;
    private final zzpv zzn;
    private zzol zzo;
    private zzpf zzp;
    private zzpx zzq;
    private zzpx zzr;
    private zzdn zzs;
    private AudioTrack zzt;
    private zzon zzu;
    private zzk zzv;
    private zzqa zzw;
    private zzqa zzx;
    private zzcg zzy;
    private boolean zzz;

    /* synthetic */ zzqi(zzpw zzpwVar, zzqh zzqhVar) {
        this.zzu = zzpwVar.zza;
        this.zzY = zzpwVar.zzd;
        int i = zzfk.zza;
        this.zzn = zzpwVar.zzc;
        zzpq zzpqVar = zzpwVar.zze;
        Objects.requireNonNull(zzpqVar);
        this.zzZ = zzpqVar;
        zzea zzeaVar = new zzea(zzdy.zza);
        this.zzh = zzeaVar;
        zzeaVar.zze();
        this.zzi = new zzpm(new zzqd(this, null));
        zzpn zzpnVar = new zzpn();
        this.zzd = zzpnVar;
        zzqs zzqsVar = new zzqs();
        this.zze = zzqsVar;
        this.zzf = zzfvs.zzo(new zzdu(), zzpnVar, zzqsVar);
        this.zzg = zzfvs.zzm(new zzqr());
        this.zzI = 1.0f;
        this.zzv = zzk.zza;
        this.zzS = 0;
        this.zzT = new zzl(0, 0.0f);
        this.zzx = new zzqa(zzcg.zza, 0L, 0L, null);
        this.zzy = zzcg.zza;
        this.zzz = false;
        this.zzj = new ArrayDeque();
        this.zzl = new zzqb(100L);
        this.zzm = new zzqb(100L);
    }

    static /* synthetic */ void zzF(AudioTrack audioTrack, zzea zzeaVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            zzeaVar.zze();
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            zzeaVar.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzH() {
        zzpx zzpxVar = this.zzr;
        return zzpxVar.zzc == 0 ? this.zzA / ((long) zzpxVar.zzb) : this.zzB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzI() {
        zzpx zzpxVar = this.zzr;
        if (zzpxVar.zzc != 0) {
            return this.zzD;
        }
        long j = this.zzC;
        long j2 = zzpxVar.zzd;
        int i = zzfk.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzJ(zzpx zzpxVar) throws zzpe {
        try {
            return zzpxVar.zza(false, this.zzv, this.zzS);
        } catch (zzpe e) {
            zzpf zzpfVar = this.zzp;
            if (zzpfVar != null) {
                zzpfVar.zza(e);
            }
            throw e;
        }
    }

    private final void zzK(long j) {
        zzcg zzcgVar;
        boolean z;
        if (zzU()) {
            zzpy zzpyVar = this.zzY;
            zzcgVar = this.zzy;
            zzpyVar.zzc(zzcgVar);
        } else {
            zzcgVar = zzcg.zza;
        }
        zzcg zzcgVar2 = zzcgVar;
        this.zzy = zzcgVar2;
        if (zzU()) {
            zzpy zzpyVar2 = this.zzY;
            z = this.zzz;
            zzpyVar2.zzd(z);
        } else {
            z = false;
        }
        this.zzz = z;
        ArrayDeque arrayDeque = this.zzj;
        long jMax = Math.max(0L, j);
        zzpx zzpxVar = this.zzr;
        long jZzI = zzI();
        int i = zzpxVar.zze;
        int i2 = zzfk.zza;
        arrayDeque.add(new zzqa(zzcgVar2, jMax, (jZzI * 1000000) / ((long) i), null));
        zzP();
        zzpf zzpfVar = this.zzp;
        if (zzpfVar != null) {
            ((zzqn) zzpfVar).zza.zzc.zzs(this.zzz);
        }
    }

    private final void zzL() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        this.zzi.zzc(zzI());
        this.zzt.stop();
    }

    private final void zzM(long j) throws Exception {
        ByteBuffer byteBufferZzb;
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzJ;
            if (byteBuffer == null) {
                byteBuffer = zzdq.zza;
            }
            zzQ(byteBuffer, j);
            return;
        }
        while (!this.zzs.zzg()) {
            do {
                byteBufferZzb = this.zzs.zzb();
                if (byteBufferZzb.hasRemaining()) {
                    zzQ(byteBufferZzb, j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzJ;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzs.zze(this.zzJ);
                    }
                }
            } while (!byteBufferZzb.hasRemaining());
            return;
        }
    }

    private final void zzN(zzcg zzcgVar) {
        zzqa zzqaVar = new zzqa(zzcgVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzS()) {
            this.zzw = zzqaVar;
        } else {
            this.zzx = zzqaVar;
        }
    }

    private final void zzO() {
        if (zzS()) {
            if (zzfk.zza >= 21) {
                this.zzt.setVolume(this.zzI);
                return;
            }
            AudioTrack audioTrack = this.zzt;
            float f = this.zzI;
            audioTrack.setStereoVolume(f, f);
        }
    }

    private final void zzP() {
        zzdn zzdnVar = this.zzr.zzi;
        this.zzs = zzdnVar;
        zzdnVar.zzc();
    }

    private final void zzQ(ByteBuffer byteBuffer, long j) throws Exception {
        int iWrite;
        zzpf zzpfVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzL;
            if (byteBuffer2 != null) {
                zzdx.zzd(byteBuffer2 == byteBuffer);
            } else {
                this.zzL = byteBuffer;
                if (zzfk.zza < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.zzM;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.zzM = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.zzM, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.zzN = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (zzfk.zza < 21) {
                int iZza = this.zzi.zza(this.zzC);
                if (iZza > 0) {
                    iWrite = this.zzt.write(this.zzM, this.zzN, Math.min(iRemaining2, iZza));
                    if (iWrite > 0) {
                        this.zzN += iWrite;
                        byteBuffer.position(byteBuffer.position() + iWrite);
                    }
                } else {
                    iWrite = 0;
                }
            } else {
                iWrite = this.zzt.write(byteBuffer, iRemaining2, 1);
            }
            this.zzV = SystemClock.elapsedRealtime();
            if (iWrite < 0) {
                zzph zzphVar = new zzph(iWrite, this.zzr.zza, ((zzfk.zza >= 24 && iWrite == -6) || iWrite == -32) && zzI() > 0);
                zzpf zzpfVar2 = this.zzp;
                if (zzpfVar2 != null) {
                    zzpfVar2.zza(zzphVar);
                }
                if (zzphVar.zzb) {
                    this.zzu = zzon.zza;
                    throw zzphVar;
                }
                this.zzm.zzb(zzphVar);
                return;
            }
            this.zzm.zza();
            if (zzT(this.zzt)) {
                if (this.zzD > 0) {
                    this.zzX = false;
                }
                if (this.zzQ && (zzpfVar = this.zzp) != null && iWrite < iRemaining2) {
                    zzqo zzqoVar = ((zzqn) zzpfVar).zza;
                    if (zzqoVar.zzl != null) {
                        zzqoVar.zzl.zza();
                    }
                }
            }
            int i = this.zzr.zzc;
            if (i == 0) {
                this.zzC += (long) iWrite;
            }
            if (iWrite == iRemaining2) {
                if (i != 0) {
                    zzdx.zzf(byteBuffer == this.zzJ);
                    this.zzD += ((long) this.zzE) * ((long) this.zzK);
                }
                this.zzL = null;
            }
        }
    }

    private final boolean zzR() throws Exception {
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzL;
            if (byteBuffer == null) {
                return true;
            }
            zzQ(byteBuffer, Long.MIN_VALUE);
            return this.zzL == null;
        }
        this.zzs.zzd();
        zzM(Long.MIN_VALUE);
        if (!this.zzs.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzL;
        return byteBuffer2 == null || !byteBuffer2.hasRemaining();
    }

    private final boolean zzS() {
        return this.zzt != null;
    }

    private static boolean zzT(AudioTrack audioTrack) {
        return zzfk.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzU() {
        zzpx zzpxVar = this.zzr;
        if (zzpxVar.zzc != 0) {
            return false;
        }
        int i = zzpxVar.zza.zzB;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final int zza(zzam zzamVar) {
        if (!"audio/raw".equals(zzamVar.zzm)) {
            return this.zzu.zza(zzamVar) != null ? 2 : 0;
        }
        if (zzfk.zzF(zzamVar.zzB)) {
            return zzamVar.zzB != 2 ? 1 : 2;
        }
        zzer.zzf("DefaultAudioSink", "Invalid PCM encoding: " + zzamVar.zzB);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final long zzb(boolean z) {
        long jZzo;
        if (!zzS() || this.zzG) {
            return Long.MIN_VALUE;
        }
        long jZzb = this.zzi.zzb(z);
        zzpx zzpxVar = this.zzr;
        long jZzI = zzI();
        int i = zzpxVar.zze;
        int i2 = zzfk.zza;
        long jMin = Math.min(jZzb, (jZzI * 1000000) / ((long) i));
        while (!this.zzj.isEmpty() && jMin >= ((zzqa) this.zzj.getFirst()).zzc) {
            this.zzx = (zzqa) this.zzj.remove();
        }
        zzqa zzqaVar = this.zzx;
        long j = jMin - zzqaVar.zzc;
        if (zzqaVar.zza.equals(zzcg.zza)) {
            jZzo = this.zzx.zzb + j;
        } else if (this.zzj.isEmpty()) {
            jZzo = this.zzY.zza(j) + this.zzx.zzb;
        } else {
            zzqa zzqaVar2 = (zzqa) this.zzj.getFirst();
            jZzo = zzqaVar2.zzb - zzfk.zzo(zzqaVar2.zzc - jMin, this.zzx.zza.zzc);
        }
        zzpx zzpxVar2 = this.zzr;
        return jZzo + ((this.zzY.zzb() * 1000000) / ((long) zzpxVar2.zze));
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final zzcg zzc() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final zzoq zzd(zzam zzamVar) {
        return this.zzW ? zzoq.zza : this.zzZ.zza(zzamVar, this.zzv);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0162  */
    /* JADX WARN: Code duplicated, block: B:55:0x0165  */
    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zze(zzam zzamVar, int i, int[] iArr) throws zzpd {
        int iIntValue;
        int i2;
        zzdn zzdnVar;
        int iZzl;
        int iIntValue2;
        int i3;
        int iZzl2;
        int iMax;
        int i4;
        zzpx zzpxVar;
        int[] iArr2;
        if ("audio/raw".equals(zzamVar.zzm)) {
            zzdx.zzd(zzfk.zzF(zzamVar.zzB));
            iZzl = zzfk.zzl(zzamVar.zzB, zzamVar.zzz);
            zzfvp zzfvpVar = new zzfvp();
            int i5 = zzamVar.zzB;
            zzfvpVar.zzh(this.zzf);
            zzfvpVar.zzg(this.zzY.zze());
            zzdn zzdnVar2 = new zzdn(zzfvpVar.zzi());
            if (zzdnVar2.equals(this.zzs)) {
                zzdnVar2 = this.zzs;
            }
            this.zze.zzq(zzamVar.zzC, zzamVar.zzD);
            if (zzfk.zza < 21 && zzamVar.zzz == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i6 = 0; i6 < 6; i6++) {
                    iArr2[i6] = i6;
                }
            } else {
                iArr2 = iArr;
            }
            this.zzd.zzo(iArr2);
            try {
                zzdo zzdoVarZza = zzdnVar2.zza(new zzdo(zzamVar.zzA, zzamVar.zzz, zzamVar.zzB));
                iIntValue = zzdoVarZza.zzd;
                int i7 = zzdoVarZza.zzb;
                int i8 = zzdoVarZza.zzc;
                iIntValue2 = zzfk.zzg(i8);
                iZzl2 = zzfk.zzl(iIntValue, i8);
                zzdnVar = zzdnVar2;
                i3 = i7;
                i2 = 0;
            } catch (zzdp e) {
                throw new zzpd(e, zzamVar);
            }
        } else {
            zzdn zzdnVar3 = new zzdn(zzfvs.zzl());
            int i9 = zzamVar.zzA;
            zzoq zzoqVar = zzoq.zza;
            Pair pairZza = this.zzu.zza(zzamVar);
            if (pairZza == null) {
                throw new zzpd("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzamVar))), zzamVar);
            }
            iIntValue = ((Integer) pairZza.first).intValue();
            i2 = 2;
            zzdnVar = zzdnVar3;
            iZzl = -1;
            iIntValue2 = ((Integer) pairZza.second).intValue();
            i3 = i9;
            iZzl2 = -1;
        }
        if (iIntValue == 0) {
            throw new zzpd("Invalid output encoding (mode=" + i2 + ") for: " + String.valueOf(zzamVar), zzamVar);
        }
        if (iIntValue2 == 0) {
            throw new zzpd("Invalid output channel config (mode=" + i2 + ") for: " + String.valueOf(zzamVar), zzamVar);
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i3, iIntValue2, iIntValue);
        zzdx.zzf(minBufferSize != -2);
        int i10 = iZzl2 != -1 ? iZzl2 : 1;
        int i11 = zzamVar.zzi;
        int i12 = 250000;
        if (i2 != 0) {
            if (i2 != 1) {
                int i13 = 5;
                if (iIntValue == 5) {
                    i12 = 500000;
                    iIntValue = 5;
                } else {
                    i13 = iIntValue;
                }
                iZzl2 = iZzl2;
                iMax = zzfya.zza((((long) i12) * ((long) (i11 != -1 ? zzfxy.zza(i11, 8, RoundingMode.CEILING) : zzqk.zzb(iIntValue)))) / 1000000);
                i4 = i13;
            } else {
                iMax = zzfya.zza((((long) zzqk.zzb(iIntValue)) * 50000000) / 1000000);
            }
            int iMax2 = (((Math.max(minBufferSize, iMax) + i10) - 1) / i10) * i10;
            this.zzW = false;
            zzpxVar = new zzpx(zzamVar, iZzl, i2, iZzl2, i3, iIntValue2, i4, iMax2, zzdnVar, false, false);
            if (zzS()) {
                this.zzq = zzpxVar;
            } else {
                this.zzr = zzpxVar;
            }
        }
        iMax = Math.max(zzqk.zza(250000, i3, i10), Math.min(minBufferSize * 4, zzqk.zza(750000, i3, i10)));
        i4 = iIntValue;
        int iMax3 = (((Math.max(minBufferSize, iMax) + i10) - 1) / i10) * i10;
        this.zzW = false;
        zzpxVar = new zzpx(zzamVar, iZzl, i2, iZzl2, i3, iIntValue2, i4, iMax3, zzdnVar, false, false);
        if (zzS()) {
            this.zzq = zzpxVar;
        } else {
            this.zzr = zzpxVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzf() {
        if (zzS()) {
            this.zzA = 0L;
            this.zzB = 0L;
            this.zzC = 0L;
            this.zzD = 0L;
            this.zzX = false;
            this.zzE = 0;
            this.zzx = new zzqa(this.zzy, 0L, 0L, null);
            this.zzH = 0L;
            this.zzw = null;
            this.zzj.clear();
            this.zzJ = null;
            this.zzK = 0;
            this.zzL = null;
            this.zzP = false;
            this.zzO = false;
            this.zze.zzp();
            zzP();
            if (this.zzi.zzi()) {
                this.zzt.pause();
            }
            if (zzT(this.zzt)) {
                zzqg zzqgVar = this.zzk;
                Objects.requireNonNull(zzqgVar);
                zzqgVar.zzb(this.zzt);
            }
            if (zzfk.zza < 21 && !this.zzR) {
                this.zzS = 0;
            }
            zzpx zzpxVar = this.zzq;
            if (zzpxVar != null) {
                this.zzr = zzpxVar;
                this.zzq = null;
            }
            this.zzi.zzd();
            final AudioTrack audioTrack = this.zzt;
            final zzea zzeaVar = this.zzh;
            zzeaVar.zzc();
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzfk.zzC("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpr
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzqi.zzF(audioTrack, zzeaVar);
                    }
                });
            }
            this.zzt = null;
        }
        this.zzm.zza();
        this.zzl.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzg() {
        this.zzF = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzh() {
        this.zzQ = false;
        if (zzS() && this.zzi.zzl()) {
            this.zzt.pause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzi() {
        this.zzQ = true;
        if (zzS()) {
            this.zzi.zzg();
            this.zzt.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzj() throws zzph {
        if (!this.zzO && zzS() && zzR()) {
            zzL();
            this.zzO = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzk() {
        zzf();
        zzfvs zzfvsVar = this.zzf;
        int size = zzfvsVar.size();
        for (int i = 0; i < size; i++) {
            ((zzdq) zzfvsVar.get(i)).zzf();
        }
        zzfvs zzfvsVar2 = this.zzg;
        int size2 = zzfvsVar2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzdq) zzfvsVar2.get(i2)).zzf();
        }
        zzdn zzdnVar = this.zzs;
        if (zzdnVar != null) {
            zzdnVar.zzf();
        }
        this.zzQ = false;
        this.zzW = false;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzl(zzk zzkVar) {
        if (this.zzv.equals(zzkVar)) {
            return;
        }
        this.zzv = zzkVar;
        zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzm(int i) {
        if (this.zzS != i) {
            this.zzS = i;
            this.zzR = i != 0;
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzn(zzl zzlVar) {
        if (this.zzT.equals(zzlVar)) {
            return;
        }
        if (this.zzt != null) {
            int i = this.zzT.zza;
        }
        this.zzT = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzo(zzdy zzdyVar) {
        this.zzi.zzf(zzdyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzp(zzpf zzpfVar) {
        this.zzp = zzpfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzq(int i, int i2) {
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzT(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzr(zzcg zzcgVar) {
        this.zzy = new zzcg(Math.max(0.1f, Math.min(zzcgVar.zzc, 8.0f)), Math.max(0.1f, Math.min(zzcgVar.zzd, 8.0f)));
        zzN(zzcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzs(zzol zzolVar) {
        this.zzo = zzolVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzu(boolean z) {
        this.zzz = z;
        zzN(this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzv(float f) {
        if (this.zzI != f) {
            this.zzI = f;
            zzO();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:115:0x021d  */
    /* JADX WARN: Code duplicated, block: B:146:0x02cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:190:0x03ad A[Catch: zzpe -> 0x03b1, TryCatch #3 {zzpe -> 0x03b1, blocks: (B:36:0x0077, B:49:0x00ce, B:51:0x00d6, B:53:0x00dc, B:54:0x00e3, B:55:0x00ec, B:57:0x00f2, B:59:0x00f6, B:60:0x00fb, B:64:0x0111, B:66:0x0125, B:68:0x012b, B:69:0x0130, B:45:0x008c, B:47:0x0095, B:188:0x03a5, B:190:0x03ad, B:191:0x03b0, B:39:0x0080, B:41:0x0085), top: B:205:0x0077, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:208:? A[Catch: zzpe -> 0x03b1, SYNTHETIC, TRY_LEAVE, TryCatch #3 {zzpe -> 0x03b1, blocks: (B:36:0x0077, B:49:0x00ce, B:51:0x00d6, B:53:0x00dc, B:54:0x00e3, B:55:0x00ec, B:57:0x00f2, B:59:0x00f6, B:60:0x00fb, B:64:0x0111, B:66:0x0125, B:68:0x012b, B:69:0x0130, B:45:0x008c, B:47:0x0095, B:188:0x03a5, B:190:0x03ad, B:191:0x03b0, B:39:0x0080, B:41:0x0085), top: B:205:0x0077, inners: #2 }] */
    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzw(ByteBuffer byteBuffer, long j, int i) throws Exception {
        AudioTrack audioTrackZzJ;
        zzol zzolVar;
        boolean z;
        int iZza;
        int i2;
        int i3;
        int i4;
        byte b2;
        int i5;
        int i6;
        ByteBuffer byteBuffer2 = this.zzJ;
        zzdx.zzd(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.zzq != null) {
            if (!zzR()) {
                return false;
            }
            zzpx zzpxVar = this.zzq;
            zzpx zzpxVar2 = this.zzr;
            if (zzpxVar2.zzc == zzpxVar.zzc && zzpxVar2.zzg == zzpxVar.zzg && zzpxVar2.zze == zzpxVar.zze && zzpxVar2.zzf == zzpxVar.zzf && zzpxVar2.zzd == zzpxVar.zzd) {
                boolean z2 = zzpxVar2.zzj;
                boolean z3 = zzpxVar.zzj;
                boolean z4 = zzpxVar2.zzk;
                boolean z5 = zzpxVar.zzk;
                this.zzr = zzpxVar;
                this.zzq = null;
                AudioTrack audioTrack = this.zzt;
                if (audioTrack != null && zzT(audioTrack)) {
                    boolean z6 = this.zzr.zzk;
                }
            } else {
                zzL();
                if (zzx()) {
                    return false;
                }
                zzf();
            }
            zzK(j);
        }
        if (!zzS()) {
            try {
                if (!this.zzh.zzd()) {
                    return false;
                }
                try {
                    zzpx zzpxVar3 = this.zzr;
                    Objects.requireNonNull(zzpxVar3);
                    audioTrackZzJ = zzJ(zzpxVar3);
                } catch (zzpe e) {
                    zzpx zzpxVar4 = this.zzr;
                    if (zzpxVar4.zzh > 1000000) {
                        zzam zzamVar = zzpxVar4.zza;
                        int i7 = zzpxVar4.zzb;
                        int i8 = zzpxVar4.zzc;
                        int i9 = zzpxVar4.zzd;
                        int i10 = zzpxVar4.zze;
                        int i11 = zzpxVar4.zzf;
                        int i12 = zzpxVar4.zzg;
                        zzdn zzdnVar = zzpxVar4.zzi;
                        boolean z7 = zzpxVar4.zzj;
                        boolean z8 = zzpxVar4.zzk;
                        zzpx zzpxVar5 = new zzpx(zzamVar, i7, i8, i9, i10, i11, i12, DurationKt.NANOS_IN_MILLIS, zzdnVar, false, false);
                        try {
                            audioTrackZzJ = zzJ(zzpxVar5);
                            this.zzr = zzpxVar5;
                        } catch (zzpe e2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(e, e2);
                            } catch (Exception unused) {
                            }
                            if (this.zzr.zzb()) {
                                throw e;
                            }
                            this.zzW = true;
                            throw e;
                        }
                    }
                    if (this.zzr.zzb()) {
                        throw e;
                    }
                    this.zzW = true;
                    throw e;
                }
                this.zzt = audioTrackZzJ;
                if (zzT(audioTrackZzJ)) {
                    AudioTrack audioTrack2 = this.zzt;
                    if (this.zzk == null) {
                        this.zzk = new zzqg(this);
                    }
                    this.zzk.zza(audioTrack2);
                    boolean z9 = this.zzr.zzk;
                }
                if (zzfk.zza >= 31 && (zzolVar = this.zzo) != null) {
                    zzpt.zza(this.zzt, zzolVar);
                }
                this.zzS = this.zzt.getAudioSessionId();
                zzpm zzpmVar = this.zzi;
                AudioTrack audioTrack3 = this.zzt;
                zzpx zzpxVar6 = this.zzr;
                zzpmVar.zze(audioTrack3, zzpxVar6.zzc == 2, zzpxVar6.zzg, zzpxVar6.zzd, zzpxVar6.zzh);
                zzO();
                int i13 = this.zzT.zza;
                zzpu zzpuVar = this.zzU;
                if (zzpuVar != null && zzfk.zza >= 23) {
                    zzps.zza(this.zzt, zzpuVar);
                }
                this.zzG = true;
            } catch (zzpe e3) {
                if (e3.zzb) {
                    throw e3;
                }
                this.zzl.zzb(e3);
                return false;
            }
        }
        this.zzl.zza();
        if (this.zzG) {
            this.zzH = Math.max(0L, j);
            this.zzF = false;
            this.zzG = false;
            zzK(j);
            if (this.zzQ) {
                zzi();
            }
        }
        if (!this.zzi.zzk(zzI())) {
            return false;
        }
        if (this.zzJ == null) {
            zzdx.zzd(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            zzpx zzpxVar7 = this.zzr;
            if (zzpxVar7.zzc != 0 && this.zzE == 0) {
                int i14 = zzpxVar7.zzg;
                switch (i14) {
                    case 5:
                    case 6:
                    case 18:
                        z = true;
                        iZza = zzaan.zza(byteBuffer);
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 7:
                    case 8:
                        int i15 = zzabj.zza;
                        if (byteBuffer.getInt(0) != -233094848) {
                            if (byteBuffer.getInt(0) == -398277519) {
                                iZza = 1024;
                            } else if (byteBuffer.getInt(0) == 622876772) {
                                iZza = 4096;
                            } else {
                                int iPosition = byteBuffer.position();
                                byte b3 = byteBuffer.get(iPosition);
                                if (b3 != -2) {
                                    if (b3 != -1) {
                                        if (b3 != 31) {
                                            i4 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                            i5 = byteBuffer.get(iPosition + 5) & 252;
                                            i3 = 2;
                                        } else {
                                            i3 = 2;
                                            i4 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                            b2 = byteBuffer.get(iPosition + 6);
                                        }
                                        i2 = (i5 >> i3) | i4;
                                        z = true;
                                    } else {
                                        i3 = 2;
                                        i4 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                        b2 = byteBuffer.get(iPosition + 7);
                                    }
                                    i5 = b2 & 60;
                                    i2 = (i5 >> i3) | i4;
                                    z = true;
                                } else {
                                    z = true;
                                    i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                                }
                                iZza = (i2 + (z ? 1 : 0)) * 32;
                            }
                            z = true;
                        } else {
                            z = true;
                            iZza = 1024;
                        }
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 9:
                        iZza = zzach.zzc(zzfk.zzh(byteBuffer, byteBuffer.position()));
                        if (iZza == -1) {
                            throw new IllegalArgumentException();
                        }
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 10:
                    case 16:
                        iZza = 1024;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 11:
                    case 12:
                        iZza = 2048;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 13:
                    case 19:
                    default:
                        throw new IllegalStateException("Unexpected audio encoding: " + i14);
                    case 14:
                        int i16 = zzaan.zza;
                        int iPosition2 = byteBuffer.position();
                        int iLimit = byteBuffer.limit() - 10;
                        int i17 = iPosition2;
                        while (true) {
                            if (i17 > iLimit) {
                                i6 = -1;
                            } else if ((zzfk.zzh(byteBuffer, i17 + 4) & (-2)) == -126718022) {
                                i6 = i17 - iPosition2;
                            } else {
                                i17++;
                            }
                        }
                        if (i6 == -1) {
                            iZza = 0;
                        } else {
                            iZza = (40 << ((byteBuffer.get((byteBuffer.position() + i6) + ((byteBuffer.get((byteBuffer.position() + i6) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                        }
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 15:
                        iZza = 512;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 17:
                        int i18 = zzaaq.zza;
                        byte[] bArr = new byte[16];
                        int iPosition3 = byteBuffer.position();
                        byteBuffer.get(bArr);
                        byteBuffer.position(iPosition3);
                        iZza = zzaaq.zza(new zzfa(bArr, 16)).zzc;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 20:
                        iZza = zzaci.zzb(byteBuffer);
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                }
            }
            if (this.zzw != null) {
                if (!zzR()) {
                    return false;
                }
                zzK(j);
                this.zzw = null;
            }
            long j2 = this.zzH;
            zzpx zzpxVar8 = this.zzr;
            long jZzH = zzH() - this.zze.zzo();
            int i19 = zzpxVar8.zza.zzA;
            int i20 = zzfk.zza;
            long j3 = j2 + ((jZzH * 1000000) / ((long) i19));
            if (!this.zzF && Math.abs(j3 - j) > 200000) {
                zzpf zzpfVar = this.zzp;
                if (zzpfVar != null) {
                    zzpfVar.zza(new zzpg(j, j3));
                }
                this.zzF = true;
            }
            if (this.zzF) {
                if (!zzR()) {
                    return false;
                }
                long j4 = j - j3;
                this.zzH += j4;
                this.zzF = false;
                zzK(j);
                zzpf zzpfVar2 = this.zzp;
                if (zzpfVar2 != null && j4 != 0) {
                    ((zzqn) zzpfVar2).zza.zzaj();
                }
            }
            if (this.zzr.zzc == 0) {
                this.zzA += (long) byteBuffer.remaining();
            } else {
                this.zzB += ((long) this.zzE) * ((long) i);
            }
            this.zzJ = byteBuffer;
            this.zzK = i;
        }
        zzM(j);
        if (!this.zzJ.hasRemaining()) {
            this.zzJ = null;
            this.zzK = 0;
            return true;
        }
        if (!this.zzi.zzj(zzI())) {
            return false;
        }
        zzer.zzf("DefaultAudioSink", "Resetting stalled audio track");
        zzf();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzx() {
        return zzS() && this.zzi.zzh(zzI());
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzy() {
        return !zzS() || (this.zzO && !zzx());
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzz(zzam zzamVar) {
        return zza(zzamVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzt(AudioDeviceInfo audioDeviceInfo) {
        zzpu zzpuVar = audioDeviceInfo == null ? null : new zzpu(audioDeviceInfo);
        this.zzU = zzpuVar;
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzps.zza(audioTrack, zzpuVar);
        }
    }
}

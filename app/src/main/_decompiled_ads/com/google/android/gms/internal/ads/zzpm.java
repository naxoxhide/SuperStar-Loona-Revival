package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzpm {
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private boolean zzE;
    private long zzF;
    private long zzG;
    private boolean zzH;
    private long zzI;
    private zzdy zzJ;
    private final zzpl zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private int zze;
    private zzpk zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private Method zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    public zzpm(zzpl zzplVar) {
        this.zza = zzplVar;
        int i = zzfk.zza;
        try {
            this.zzn = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
        this.zzJ = zzdy.zza;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0089  */
    private final long zzm() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzy != -9223372036854775807L) {
            return Math.min(this.zzB, this.zzA + zzfk.zzn(zzfk.zzo(zzfk.zzq(jElapsedRealtime) - this.zzy, this.zzj), this.zzg));
        }
        if (jElapsedRealtime - this.zzs >= 5) {
            AudioTrack audioTrack = this.zzc;
            Objects.requireNonNull(audioTrack);
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
                long j = 0;
                if (this.zzh) {
                    if (playState == 2) {
                        if (playbackHeadPosition == 0) {
                            this.zzv = this.zzt;
                        }
                        playState = 2;
                    }
                    playbackHeadPosition += this.zzv;
                }
                if (zzfk.zza > 29) {
                    if (this.zzt > playbackHeadPosition) {
                        this.zzu++;
                    }
                    this.zzt = playbackHeadPosition;
                } else {
                    if (playbackHeadPosition != 0) {
                        j = playbackHeadPosition;
                    } else if (this.zzt > 0 && playState == 3) {
                        if (this.zzz == -9223372036854775807L) {
                            this.zzz = jElapsedRealtime;
                        }
                    }
                    this.zzz = -9223372036854775807L;
                    playbackHeadPosition = j;
                    if (this.zzt > playbackHeadPosition) {
                        this.zzu++;
                    }
                    this.zzt = playbackHeadPosition;
                }
            }
            this.zzs = jElapsedRealtime;
        }
        return this.zzt + this.zzI + (this.zzu << 32);
    }

    private final long zzn() {
        long jZzm = zzm();
        int i = this.zzg;
        int i2 = zzfk.zza;
        return (jZzm * 1000000) / ((long) i);
    }

    private final void zzo() {
        this.zzl = 0L;
        this.zzx = 0;
        this.zzw = 0;
        this.zzm = 0L;
        this.zzD = 0L;
        this.zzG = 0L;
        this.zzk = false;
    }

    public final int zza(long j) {
        return this.zze - ((int) (j - (zzm() * ((long) this.zzd))));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    /* JADX WARN: Code duplicated, block: B:21:0x0079  */
    /* JADX WARN: Code duplicated, block: B:23:0x0091  */
    /* JADX WARN: Code duplicated, block: B:25:0x00da  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:28:0x0139  */
    /* JADX WARN: Code duplicated, block: B:39:0x017c A[Catch: Exception -> 0x0195, TRY_LEAVE, TryCatch #0 {Exception -> 0x0195, blocks: (B:35:0x0150, B:37:0x0156, B:39:0x017c), top: B:67:0x0150 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x0091, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x00f5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x017c, please report this as an issue */
    public final long zzb(boolean z) {
        long jZzn;
        zzpk zzpkVar;
        Method method;
        long jMax;
        long jZzb;
        long jZza;
        long jZzn2;
        int i;
        zzpm zzpmVar = this;
        AudioTrack audioTrack = zzpmVar.zzc;
        Objects.requireNonNull(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            long jNanoTime = System.nanoTime() / 1000;
            if (jNanoTime - zzpmVar.zzm >= 30000) {
                long jZzn3 = zzn();
                if (jZzn3 != 0) {
                    zzpmVar.zzb[zzpmVar.zzw] = zzfk.zzp(jZzn3, zzpmVar.zzj) - jNanoTime;
                    zzpmVar.zzw = (zzpmVar.zzw + 1) % 10;
                    int i2 = zzpmVar.zzx;
                    if (i2 < 10) {
                        zzpmVar.zzx = i2 + 1;
                    }
                    zzpmVar.zzm = jNanoTime;
                    zzpmVar.zzl = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = zzpmVar.zzx;
                        if (i3 >= i4) {
                            break;
                        }
                        zzpmVar.zzl += zzpmVar.zzb[i3] / ((long) i4);
                        i3++;
                    }
                    if (!zzpmVar.zzh) {
                        zzpkVar = zzpmVar.zzf;
                        Objects.requireNonNull(zzpkVar);
                        if (zzpkVar.zzg(jNanoTime)) {
                            jZzb = zzpkVar.zzb();
                            jZza = zzpkVar.zza();
                            jZzn2 = zzn();
                            if (Math.abs(jZzb - jNanoTime) > 5000000) {
                                zzqi zzqiVar = ((zzqd) zzpmVar.zza).zza;
                                zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzn2 + ", " + zzqiVar.zzH() + ", " + zzqiVar.zzI());
                                zzpkVar.zzd();
                            } else {
                                i = zzpmVar.zzg;
                                int i5 = zzfk.zza;
                                if (Math.abs(((jZza * 1000000) / ((long) i)) - jZzn2) > 5000000) {
                                    zzqi zzqiVar2 = ((zzqd) zzpmVar.zza).zza;
                                    zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzn2 + ", " + zzqiVar2.zzH() + ", " + zzqiVar2.zzI());
                                    zzpkVar.zzd();
                                } else {
                                    zzpkVar.zzc();
                                }
                            }
                            zzpmVar = this;
                        }
                        if (zzpmVar.zzq && (method = zzpmVar.zzn) != null && jNanoTime - zzpmVar.zzr >= 500000) {
                            try {
                                AudioTrack audioTrack2 = zzpmVar.zzc;
                                Objects.requireNonNull(audioTrack2);
                                Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                                int i6 = zzfk.zza;
                                long jIntValue = (((long) num.intValue()) * 1000) - zzpmVar.zzi;
                                zzpmVar.zzo = jIntValue;
                                jMax = Math.max(jIntValue, 0L);
                                zzpmVar.zzo = jMax;
                                if (jMax > 5000000) {
                                    zzer.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + jMax);
                                    zzpmVar.zzo = 0L;
                                }
                            } catch (Exception unused) {
                                zzpmVar.zzn = null;
                            }
                            zzpmVar.zzr = jNanoTime;
                        }
                    }
                }
            } else if (!zzpmVar.zzh) {
                zzpkVar = zzpmVar.zzf;
                Objects.requireNonNull(zzpkVar);
                if (zzpkVar.zzg(jNanoTime)) {
                    jZzb = zzpkVar.zzb();
                    jZza = zzpkVar.zza();
                    jZzn2 = zzn();
                    if (Math.abs(jZzb - jNanoTime) > 5000000) {
                        zzqi zzqiVar3 = ((zzqd) zzpmVar.zza).zza;
                        zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzn2 + ", " + zzqiVar3.zzH() + ", " + zzqiVar3.zzI());
                        zzpkVar.zzd();
                    } else {
                        i = zzpmVar.zzg;
                        int i7 = zzfk.zza;
                        if (Math.abs(((jZza * 1000000) / ((long) i)) - jZzn2) > 5000000) {
                            zzqi zzqiVar4 = ((zzqd) zzpmVar.zza).zza;
                            zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzn2 + ", " + zzqiVar4.zzH() + ", " + zzqiVar4.zzI());
                            zzpkVar.zzd();
                        } else {
                            zzpkVar.zzc();
                        }
                    }
                    zzpmVar = this;
                }
                if (zzpmVar.zzq) {
                    AudioTrack audioTrack3 = zzpmVar.zzc;
                    Objects.requireNonNull(audioTrack3);
                    Integer num2 = (Integer) method.invoke(audioTrack3, new Object[0]);
                    int i8 = zzfk.zza;
                    long jIntValue2 = (((long) num2.intValue()) * 1000) - zzpmVar.zzi;
                    zzpmVar.zzo = jIntValue2;
                    jMax = Math.max(jIntValue2, 0L);
                    zzpmVar.zzo = jMax;
                    if (jMax > 5000000) {
                        zzer.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + jMax);
                        zzpmVar.zzo = 0L;
                    }
                    zzpmVar.zzr = jNanoTime;
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        zzpk zzpkVar2 = zzpmVar.zzf;
        Objects.requireNonNull(zzpkVar2);
        boolean zZzf = zzpkVar2.zzf();
        if (zZzf) {
            long jZza2 = zzpkVar2.zza();
            int i9 = zzpmVar.zzg;
            int i10 = zzfk.zza;
            jZzn = ((jZza2 * 1000000) / ((long) i9)) + zzfk.zzo(jNanoTime2 - zzpkVar2.zzb(), zzpmVar.zzj);
        } else {
            jZzn = zzpmVar.zzx == 0 ? zzn() : zzfk.zzo(zzpmVar.zzl + jNanoTime2, zzpmVar.zzj);
            if (!z) {
                jZzn = Math.max(0L, jZzn - zzpmVar.zzo);
            }
        }
        if (zzpmVar.zzE != zZzf) {
            zzpmVar.zzG = zzpmVar.zzD;
            zzpmVar.zzF = zzpmVar.zzC;
        }
        long j = jNanoTime2 - zzpmVar.zzG;
        if (j < 1000000) {
            long jZzo = zzpmVar.zzF + zzfk.zzo(j, zzpmVar.zzj);
            long j2 = (j * 1000) / 1000000;
            jZzn = ((jZzn * j2) + ((1000 - j2) * jZzo)) / 1000;
        }
        if (!zzpmVar.zzk) {
            long j3 = zzpmVar.zzC;
            if (jZzn > j3) {
                zzpmVar.zzk = true;
                int i11 = zzfk.zza;
                long jCurrentTimeMillis = System.currentTimeMillis() - zzfk.zzs(zzfk.zzp(zzfk.zzs(jZzn - j3), zzpmVar.zzj));
                zzqi zzqiVar5 = ((zzqd) zzpmVar.zza).zza;
                if (zzqiVar5.zzp != null) {
                    ((zzqn) zzqiVar5.zzp).zza.zzc.zzr(jCurrentTimeMillis);
                }
            }
        }
        zzpmVar.zzD = jNanoTime2;
        zzpmVar.zzC = jZzn;
        zzpmVar.zzE = zZzf;
        return jZzn;
    }

    public final void zzc(long j) {
        this.zzA = zzm();
        this.zzy = zzfk.zzq(SystemClock.elapsedRealtime());
        this.zzB = j;
    }

    public final void zzd() {
        zzo();
        this.zzc = null;
        this.zzf = null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    public final void zze(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        long j;
        this.zzc = audioTrack;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = new zzpk(audioTrack);
        this.zzg = audioTrack.getSampleRate();
        boolean z2 = true;
        if (!z || zzfk.zza >= 23) {
            z2 = false;
        } else if (i != 5) {
            if (i == 6) {
                i = 6;
            } else {
                z2 = false;
            }
        }
        this.zzh = z2;
        boolean zZzF = zzfk.zzF(i);
        this.zzq = zZzF;
        if (zZzF) {
            j = (((long) (i3 / i2)) * 1000000) / ((long) this.zzg);
        } else {
            j = -9223372036854775807L;
        }
        this.zzi = j;
        this.zzt = 0L;
        this.zzu = 0L;
        this.zzH = false;
        this.zzI = 0L;
        this.zzv = 0L;
        this.zzp = false;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzr = 0L;
        this.zzo = 0L;
        this.zzj = 1.0f;
    }

    public final void zzf(zzdy zzdyVar) {
        this.zzJ = zzdyVar;
    }

    public final boolean zzh(long j) {
        if (j > zzfk.zzn(zzb(false), this.zzg)) {
            return true;
        }
        if (this.zzh) {
            AudioTrack audioTrack = this.zzc;
            Objects.requireNonNull(audioTrack);
            if (audioTrack.getPlayState() == 2 && zzm() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzi() {
        AudioTrack audioTrack = this.zzc;
        Objects.requireNonNull(audioTrack);
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzj(long j) {
        return this.zzz != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.zzz >= 200;
    }

    public final boolean zzk(long j) {
        AudioTrack audioTrack = this.zzc;
        Objects.requireNonNull(audioTrack);
        int playState = audioTrack.getPlayState();
        if (this.zzh) {
            if (playState == 2) {
                this.zzp = false;
                return false;
            }
            if (playState == 1) {
                if (zzm() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzp;
        boolean zZzh = zzh(j);
        this.zzp = zZzh;
        if (z && !zZzh && playState != 1) {
            zzpl zzplVar = this.zza;
            int i = this.zze;
            long jZzs = zzfk.zzs(this.zzi);
            zzqd zzqdVar = (zzqd) zzplVar;
            zzqi zzqiVar = zzqdVar.zza;
            if (zzqiVar.zzp != null) {
                ((zzqn) zzqdVar.zza.zzp).zza.zzc.zzt(i, jZzs, SystemClock.elapsedRealtime() - zzqiVar.zzV);
            }
        }
        return true;
    }

    public final boolean zzl() {
        zzo();
        if (this.zzy != -9223372036854775807L) {
            return false;
        }
        zzpk zzpkVar = this.zzf;
        Objects.requireNonNull(zzpkVar);
        zzpkVar.zze();
        return true;
    }

    public final void zzg() {
        zzpk zzpkVar = this.zzf;
        Objects.requireNonNull(zzpkVar);
        zzpkVar.zze();
    }
}

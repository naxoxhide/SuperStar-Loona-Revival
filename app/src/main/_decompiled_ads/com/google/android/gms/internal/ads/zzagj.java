package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzagj implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzagf
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzagj.zza;
            return new zzabm[]{new zzagj(0)};
        }
    };
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;
    private zzagi zzB;
    private boolean zzC;
    private int zzD;
    private long zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private long zzI;
    private zzes zzJ;
    private zzes zzK;
    private boolean zzL;
    private boolean zzM;
    private int zzN;
    private long zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private int[] zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private byte zzag;
    private boolean zzah;
    private zzabp zzai;
    private final zzage zzh;
    private final zzagl zzi;
    private final SparseArray zzj;
    private final boolean zzk;
    private final zzfb zzl;
    private final zzfb zzm;
    private final zzfb zzn;
    private final zzfb zzo;
    private final zzfb zzp;
    private final zzfb zzq;
    private final zzfb zzr;
    private final zzfb zzs;
    private final zzfb zzt;
    private final zzfb zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzfk.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfsi.zzc);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(map);
    }

    public zzagj() {
        this(0);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzn(zzabn zzabnVar, zzagi zzagiVar, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzagiVar.zzb)) {
            zzv(zzabnVar, zzb, i);
            int i3 = this.zzaa;
            zzu();
            return i3;
        }
        if ("S_TEXT/ASS".equals(zzagiVar.zzb)) {
            zzv(zzabnVar, zzd, i);
            int i4 = this.zzaa;
            zzu();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(zzagiVar.zzb)) {
            zzv(zzabnVar, zze, i);
            int i5 = this.zzaa;
            zzu();
            return i5;
        }
        zzacs zzacsVar = zzagiVar.zzV;
        if (!this.zzac) {
            if (zzagiVar.zzg) {
                this.zzV &= -1073741825;
                if (!this.zzad) {
                    ((zzabc) zzabnVar).zzn(this.zzn.zzI(), 0, 1, false);
                    this.zzZ++;
                    if ((this.zzn.zzI()[0] & 128) == 128) {
                        throw zzcc.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzag = this.zzn.zzI()[0];
                    this.zzad = true;
                }
                byte b2 = this.zzag;
                if ((b2 & 1) == 1) {
                    int i6 = b2 & 2;
                    this.zzV |= 1073741824;
                    if (!this.zzah) {
                        ((zzabc) zzabnVar).zzn(this.zzs.zzI(), 0, 8, false);
                        this.zzZ += 8;
                        this.zzah = true;
                        this.zzn.zzI()[0] = (byte) ((i6 != 2 ? 0 : 128) | 8);
                        this.zzn.zzG(0);
                        zzacsVar.zzs(this.zzn, 1, 1);
                        this.zzaa++;
                        this.zzs.zzG(0);
                        zzacsVar.zzs(this.zzs, 8, 1);
                        this.zzaa += 8;
                    }
                    if (i6 == 2) {
                        if (!this.zzae) {
                            ((zzabc) zzabnVar).zzn(this.zzn.zzI(), 0, 1, false);
                            this.zzZ++;
                            this.zzn.zzG(0);
                            this.zzaf = this.zzn.zzl();
                            this.zzae = true;
                        }
                        int i7 = this.zzaf * 4;
                        this.zzn.zzD(i7);
                        ((zzabc) zzabnVar).zzn(this.zzn.zzI(), 0, i7, false);
                        this.zzZ += i7;
                        int i8 = (this.zzaf >> 1) + 1;
                        int i9 = (i8 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzv;
                        if (byteBuffer == null || byteBuffer.capacity() < i9) {
                            this.zzv = ByteBuffer.allocate(i9);
                        }
                        this.zzv.position(0);
                        this.zzv.putShort((short) i8);
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            i2 = this.zzaf;
                            if (i10 >= i2) {
                                break;
                            }
                            int iZzo = this.zzn.zzo();
                            int i12 = iZzo - i11;
                            if (i10 % 2 == 0) {
                                this.zzv.putShort((short) i12);
                            } else {
                                this.zzv.putInt(i12);
                            }
                            i10++;
                            i11 = iZzo;
                        }
                        int i13 = (i - this.zzZ) - i11;
                        if ((i2 & 1) == 1) {
                            this.zzv.putInt(i13);
                        } else {
                            this.zzv.putShort((short) i13);
                            this.zzv.putInt(0);
                        }
                        this.zzt.zzE(this.zzv.array(), i9);
                        zzacsVar.zzs(this.zzt, i9, 1);
                        this.zzaa += i9;
                    }
                }
            } else {
                byte[] bArr = zzagiVar.zzh;
                if (bArr != null) {
                    this.zzq.zzE(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzagiVar.zzb) ? zzagiVar.zzf > 0 : z) {
                this.zzV |= 268435456;
                this.zzu.zzD(0);
                int iZzd = (this.zzq.zzd() + i) - this.zzZ;
                this.zzn.zzD(4);
                this.zzn.zzI()[0] = (byte) ((iZzd >> 24) & 255);
                this.zzn.zzI()[1] = (byte) ((iZzd >> 16) & 255);
                this.zzn.zzI()[2] = (byte) ((iZzd >> 8) & 255);
                this.zzn.zzI()[3] = (byte) (iZzd & 255);
                zzacsVar.zzs(this.zzn, 4, 2);
                this.zzaa += 4;
            }
            this.zzac = true;
        }
        int iZzd2 = i + this.zzq.zzd();
        if (!"V_MPEG4/ISO/AVC".equals(zzagiVar.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzagiVar.zzb)) {
            if (zzagiVar.zzS != null) {
                zzdx.zzf(this.zzq.zzd() == 0);
                zzagiVar.zzS.zzd(zzabnVar);
            }
            while (true) {
                int i14 = this.zzZ;
                if (i14 >= iZzd2) {
                    break;
                }
                int iZzo2 = zzo(zzabnVar, zzacsVar, iZzd2 - i14);
                this.zzZ += iZzo2;
                this.zzaa += iZzo2;
            }
        } else {
            byte[] bArrZzI = this.zzm.zzI();
            bArrZzI[0] = 0;
            bArrZzI[1] = 0;
            bArrZzI[2] = 0;
            int i15 = zzagiVar.zzW;
            int i16 = 4 - i15;
            while (this.zzZ < iZzd2) {
                int i17 = this.zzab;
                if (i17 == 0) {
                    int iMin = Math.min(i15, this.zzq.zza());
                    ((zzabc) zzabnVar).zzn(bArrZzI, i16 + iMin, i15 - iMin, false);
                    if (iMin > 0) {
                        this.zzq.zzC(bArrZzI, i16, iMin);
                    }
                    this.zzZ += i15;
                    this.zzm.zzG(0);
                    this.zzab = this.zzm.zzo();
                    this.zzl.zzG(0);
                    zzacq.zzb(zzacsVar, this.zzl, 4);
                    this.zzaa += 4;
                } else {
                    int iZzo3 = zzo(zzabnVar, zzacsVar, i17);
                    this.zzZ += iZzo3;
                    this.zzaa += iZzo3;
                    this.zzab -= iZzo3;
                }
            }
        }
        if ("A_VORBIS".equals(zzagiVar.zzb)) {
            this.zzo.zzG(0);
            zzacq.zzb(zzacsVar, this.zzo, 4);
            this.zzaa += 4;
        }
        int i18 = this.zzaa;
        zzu();
        return i18;
    }

    private final int zzo(zzabn zzabnVar, zzacs zzacsVar, int i) throws IOException {
        int iZza = this.zzq.zza();
        if (iZza <= 0) {
            return zzacq.zza(zzacsVar, zzabnVar, i, false);
        }
        int iMin = Math.min(i, iZza);
        zzacq.zzb(zzacsVar, this.zzq, iMin);
        return iMin;
    }

    private final long zzp(long j) throws zzcc {
        long j2 = this.zzy;
        if (j2 != -9223372036854775807L) {
            return zzfk.zzr(j, j2, 1000L);
        }
        throw zzcc.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzq(int i) throws zzcc {
        if (this.zzJ == null || this.zzK == null) {
            throw zzcc.zza("Element " + i + " must be in a Cues", null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzr(int i) throws zzcc {
        if (this.zzB != null) {
            return;
        }
        throw zzcc.zza("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    @RequiresNonNull({"#1.output"})
    private final void zzs(zzagi zzagiVar, long j, int i, int i2, int i3) {
        byte b2;
        int i4;
        byte[] bArrZzw;
        int iZzd;
        zzact zzactVar = zzagiVar.zzS;
        if (zzactVar != null) {
            zzactVar.zzc(zzagiVar.zzV, j, i, i2, i3, zzagiVar.zzi);
        } else {
            if ("S_TEXT/UTF8".equals(zzagiVar.zzb) || "S_TEXT/ASS".equals(zzagiVar.zzb) || "S_TEXT/WEBVTT".equals(zzagiVar.zzb)) {
                if (this.zzR > 1) {
                    zzer.zzf("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.zzP;
                    if (j2 == -9223372036854775807L) {
                        zzer.zzf("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = zzagiVar.zzb;
                        byte[] bArrZzI = this.zzr.zzI();
                        int iHashCode = str.hashCode();
                        if (iHashCode != 738597099) {
                            if (iHashCode != 1045209816) {
                                if (iHashCode == 1422270023 && str.equals("S_TEXT/UTF8")) {
                                    b2 = 0;
                                } else {
                                    b2 = -1;
                                }
                            } else if (str.equals("S_TEXT/WEBVTT")) {
                                b2 = 2;
                            } else {
                                b2 = -1;
                            }
                        } else if (str.equals("S_TEXT/ASS")) {
                            b2 = 1;
                        } else {
                            b2 = -1;
                        }
                        if (b2 == 0) {
                            i4 = 19;
                            bArrZzw = zzw(j2, "%02d:%02d:%02d,%03d", 1000L);
                        } else if (b2 == 1) {
                            i4 = 21;
                            bArrZzw = zzw(j2, "%01d:%02d:%02d:%02d", 10000L);
                        } else {
                            if (b2 != 2) {
                                throw new IllegalArgumentException();
                            }
                            i4 = 25;
                            bArrZzw = zzw(j2, "%02d:%02d:%02d.%03d", 1000L);
                        }
                        System.arraycopy(bArrZzw, 0, bArrZzI, i4, bArrZzw.length);
                        for (int iZzc = this.zzr.zzc(); iZzc < this.zzr.zzd(); iZzc++) {
                            if (this.zzr.zzI()[iZzc] == 0) {
                                this.zzr.zzF(iZzc);
                                break;
                            }
                        }
                        zzacs zzacsVar = zzagiVar.zzV;
                        zzfb zzfbVar = this.zzr;
                        zzacq.zzb(zzacsVar, zzfbVar, zzfbVar.zzd());
                        iZzd = i2 + this.zzr.zzd();
                    }
                }
                iZzd = i2;
            } else {
                iZzd = i2;
            }
            if ((i & 268435456) != 0) {
                if (this.zzR > 1) {
                    this.zzu.zzD(0);
                } else {
                    int iZzd2 = this.zzu.zzd();
                    zzagiVar.zzV.zzs(this.zzu, iZzd2, 2);
                    iZzd += iZzd2;
                }
            }
            zzagiVar.zzV.zzt(j, i, iZzd, i3, zzagiVar.zzi);
        }
        this.zzM = true;
    }

    private final void zzt(zzabn zzabnVar, int i) throws IOException {
        if (this.zzn.zzd() >= i) {
            return;
        }
        if (this.zzn.zzb() < i) {
            zzfb zzfbVar = this.zzn;
            int iZzb = zzfbVar.zzb();
            zzfbVar.zzA(Math.max(iZzb + iZzb, i));
        }
        zzfb zzfbVar2 = this.zzn;
        ((zzabc) zzabnVar).zzn(zzfbVar2.zzI(), zzfbVar2.zzd(), i - zzfbVar2.zzd(), false);
        this.zzn.zzF(i);
    }

    private final void zzu() {
        this.zzZ = 0;
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = false;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = 0;
        this.zzag = (byte) 0;
        this.zzah = false;
        this.zzq.zzD(0);
    }

    private final void zzv(zzabn zzabnVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzr.zzb() < i2) {
            zzfb zzfbVar = this.zzr;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2 + i);
            zzfbVar.zzE(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzr.zzI(), 0, length);
        }
        ((zzabc) zzabnVar).zzn(this.zzr.zzI(), length, i, false);
        this.zzr.zzG(0);
        this.zzr.zzF(i2);
    }

    private static byte[] zzw(long j, String str, long j2) {
        zzdx.zzd(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String str2 = String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2)));
        int i4 = zzfk.zza;
        return str2.getBytes(zzfsi.zzc);
    }

    private static int[] zzx(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        this.zzM = false;
        while (!this.zzM) {
            if (!this.zzh.zzc(zzabnVar)) {
                for (int i = 0; i < this.zzj.size(); i++) {
                    zzagi zzagiVar = (zzagi) this.zzj.valueAt(i);
                    Objects.requireNonNull(zzagiVar.zzV);
                    zzact zzactVar = zzagiVar.zzS;
                    if (zzactVar != null) {
                        zzactVar.zza(zzagiVar.zzV, zzagiVar.zzi);
                    }
                }
                return -1;
            }
            long jZzf = zzabnVar.zzf();
            if (this.zzF) {
                this.zzH = jZzf;
                zzacjVar.zza = this.zzG;
                this.zzF = false;
                return 1;
            }
            if (this.zzC) {
                long j = this.zzH;
                if (j != -1) {
                    zzacjVar.zza = j;
                    this.zzH = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzai = zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        this.zzI = -9223372036854775807L;
        this.zzN = 0;
        this.zzh.zzb();
        this.zzi.zze();
        zzu();
        for (int i = 0; i < this.zzj.size(); i++) {
            zzact zzactVar = ((zzagi) this.zzj.valueAt(i)).zzS;
            if (zzactVar != null) {
                zzactVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        return new zzagk().zza(zzabnVar);
    }

    protected final void zzh(int i) throws zzcc {
        int i2;
        int i3;
        zzacm zzaclVar;
        int i4;
        zzdx.zzb(this.zzai);
        if (i == 160) {
            if (this.zzN != 2) {
                return;
            }
            zzagi zzagiVar = (zzagi) this.zzj.get(this.zzT);
            Objects.requireNonNull(zzagiVar.zzV);
            if (this.zzY > 0 && "A_OPUS".equals(zzagiVar.zzb)) {
                zzfb zzfbVar = this.zzu;
                byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzY).array();
                zzfbVar.zzE(bArrArray, bArrArray.length);
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.zzR; i6++) {
                i5 += this.zzS[i6];
            }
            int i7 = 0;
            while (i7 < this.zzR) {
                long j = this.zzO + ((long) ((zzagiVar.zze * i7) / 1000));
                int i8 = this.zzV;
                if (i7 == 0) {
                    if (!this.zzX) {
                        i8 |= 1;
                    }
                    i3 = i8;
                    i2 = 0;
                } else {
                    i2 = i7;
                    i3 = i8;
                }
                int i9 = this.zzS[i2];
                int i10 = i5 - i9;
                zzs(zzagiVar, j, i3, i9, i10);
                i7 = i2 + 1;
                i5 = i10;
            }
            this.zzN = 0;
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i11 = this.zzD;
                if (i11 != -1) {
                    long j2 = this.zzE;
                    if (j2 != -1) {
                        if (i11 == 475249515) {
                            this.zzG = j2;
                            return;
                        }
                        return;
                    }
                }
                throw zzcc.zza("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                zzr(i);
                zzagi zzagiVar2 = this.zzB;
                if (zzagiVar2.zzg) {
                    if (zzagiVar2.zzi == null) {
                        throw zzcc.zza("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    zzagiVar2.zzk = new zzad(null, new zzac(zzo.zza, null, "video/webm", this.zzB.zzi.zzb));
                    return;
                }
                return;
            }
            if (i == 28032) {
                zzr(i);
                zzagi zzagiVar3 = this.zzB;
                if (zzagiVar3.zzg && zzagiVar3.zzh != null) {
                    throw zzcc.zza("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.zzy == -9223372036854775807L) {
                    this.zzy = 1000000L;
                }
                long j3 = this.zzz;
                if (j3 != -9223372036854775807L) {
                    this.zzA = zzp(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.zzj.size() == 0) {
                    throw zzcc.zza("No valid tracks were found", null);
                }
                this.zzai.zzD();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.zzC) {
                zzabp zzabpVar = this.zzai;
                zzes zzesVar = this.zzJ;
                zzes zzesVar2 = this.zzK;
                if (this.zzx == -1 || this.zzA == -9223372036854775807L || zzesVar == null || zzesVar.zza() == 0 || zzesVar2 == null || zzesVar2.zza() != zzesVar.zza()) {
                    zzaclVar = new zzacl(this.zzA, 0L);
                } else {
                    int iZza = zzesVar.zza();
                    int[] iArrCopyOf = new int[iZza];
                    long[] jArrCopyOf = new long[iZza];
                    long[] jArrCopyOf2 = new long[iZza];
                    long[] jArrCopyOf3 = new long[iZza];
                    for (int i12 = 0; i12 < iZza; i12++) {
                        jArrCopyOf3[i12] = zzesVar.zzb(i12);
                        jArrCopyOf[i12] = this.zzx + zzesVar2.zzb(i12);
                    }
                    int i13 = 0;
                    while (true) {
                        i4 = iZza - 1;
                        if (i13 >= i4) {
                            break;
                        }
                        int i14 = i13 + 1;
                        iArrCopyOf[i13] = (int) (jArrCopyOf[i14] - jArrCopyOf[i13]);
                        jArrCopyOf2[i13] = jArrCopyOf3[i14] - jArrCopyOf3[i13];
                        i13 = i14;
                    }
                    iArrCopyOf[i4] = (int) ((this.zzx + this.zzw) - jArrCopyOf[i4]);
                    long j4 = this.zzA - jArrCopyOf3[i4];
                    jArrCopyOf2[i4] = j4;
                    if (j4 <= 0) {
                        zzer.zzf("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j4);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i4);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i4);
                    }
                    zzaclVar = new zzaba(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                zzabpVar.zzO(zzaclVar);
                this.zzC = true;
            }
            this.zzJ = null;
            this.zzK = null;
            return;
        }
        zzagi zzagiVar4 = this.zzB;
        zzdx.zzb(zzagiVar4);
        String str = zzagiVar4.zzb;
        if (str == null) {
            throw zzcc.zza("CodecId is missing in TrackEntry element", null);
        }
        switch (str) {
            case "V_VP8":
            case "V_VP9":
            case "V_AV1":
            case "V_MPEG2":
            case "V_MPEG4/ISO/SP":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/AVC":
            case "V_MPEGH/ISO/HEVC":
            case "V_MS/VFW/FOURCC":
            case "V_THEORA":
            case "A_OPUS":
            case "A_VORBIS":
            case "A_AAC":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "A_AC3":
            case "A_EAC3":
            case "A_TRUEHD":
            case "A_DTS":
            case "A_DTS/EXPRESS":
            case "A_DTS/LOSSLESS":
            case "A_FLAC":
            case "A_MS/ACM":
            case "A_PCM/INT/LIT":
            case "A_PCM/INT/BIG":
            case "A_PCM/FLOAT/IEEE":
            case "S_TEXT/UTF8":
            case "S_TEXT/ASS":
            case "S_TEXT/WEBVTT":
            case "S_VOBSUB":
            case "S_HDMV/PGS":
            case "S_DVBSUB":
                zzagiVar4.zze(this.zzai, zzagiVar4.zzc);
                this.zzj.put(zzagiVar4.zzc, zzagiVar4);
                break;
        }
        this.zzB = null;
    }

    protected final void zzk(int i, long j, long j2) throws zzcc {
        zzdx.zzb(this.zzai);
        if (i == 160) {
            this.zzX = false;
            this.zzY = 0L;
            return;
        }
        if (i == 174) {
            this.zzB = new zzagi();
            return;
        }
        if (i == 187) {
            this.zzL = false;
            return;
        }
        if (i == 19899) {
            this.zzD = -1;
            this.zzE = -1L;
            return;
        }
        if (i == 20533) {
            zzr(i);
            this.zzB.zzg = true;
            return;
        }
        if (i == 21968) {
            zzr(i);
            this.zzB.zzw = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzx;
            if (j3 != -1 && j3 != j) {
                throw zzcc.zza("Multiple Segment elements not supported", null);
            }
            this.zzx = j;
            this.zzw = j2;
            return;
        }
        if (i == 475249515) {
            this.zzJ = new zzes(32);
            this.zzK = new zzes(32);
        } else if (i == 524531317 && !this.zzC) {
            if (this.zzk && this.zzG != -1) {
                this.zzF = true;
            } else {
                this.zzai.zzO(new zzacl(this.zzA, 0L));
                this.zzC = true;
            }
        }
    }

    public zzagj(int i) {
        zzagc zzagcVar = new zzagc();
        this.zzx = -1L;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzG = -1L;
        this.zzH = -1L;
        this.zzI = -9223372036854775807L;
        this.zzh = zzagcVar;
        zzagcVar.zza(new zzagh(this, null));
        this.zzk = true;
        this.zzi = new zzagl();
        this.zzj = new SparseArray();
        this.zzn = new zzfb(4);
        this.zzo = new zzfb(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzfb(4);
        this.zzl = new zzfb(zzfy.zza);
        this.zzm = new zzfb(4);
        this.zzq = new zzfb();
        this.zzr = new zzfb();
        this.zzs = new zzfb(8);
        this.zzt = new zzfb();
        this.zzu = new zzfb();
        this.zzS = new int[1];
    }

    protected final void zzl(int i, String str) throws zzcc {
        if (i == 134) {
            zzr(i);
            this.zzB.zzb = str;
            return;
        }
        if (i == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw zzcc.zza("DocType " + str + " not supported", null);
        }
        if (i == 21358) {
            zzr(i);
            this.zzB.zza = str;
        } else {
            if (i != 2274716) {
                return;
            }
            zzr(i);
            this.zzB.zzY = str;
        }
    }

    protected final void zzg(int i, int i2, zzabn zzabnVar) throws IOException {
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = 1;
        int i10 = 0;
        if (i8 != 161 && i8 != 163) {
            if (i8 == 165) {
                if (this.zzN != 2) {
                    return;
                }
                zzagi zzagiVar = (zzagi) this.zzj.get(this.zzT);
                if (this.zzW != 4 || !"V_VP9".equals(zzagiVar.zzb)) {
                    ((zzabc) zzabnVar).zzo(i2, false);
                    return;
                }
                this.zzu.zzD(i2);
                ((zzabc) zzabnVar).zzn(this.zzu.zzI(), 0, i2, false);
                return;
            }
            if (i8 == 16877) {
                zzr(i);
                zzagi zzagiVar2 = this.zzB;
                if (zzagiVar2.zzX != 1685485123 && zzagiVar2.zzX != 1685480259) {
                    ((zzabc) zzabnVar).zzo(i2, false);
                    return;
                }
                zzagiVar2.zzM = new byte[i2];
                ((zzabc) zzabnVar).zzn(zzagiVar2.zzM, 0, i2, false);
                return;
            }
            if (i8 == 16981) {
                zzr(i);
                zzagi zzagiVar3 = this.zzB;
                zzagiVar3.zzh = new byte[i2];
                ((zzabc) zzabnVar).zzn(zzagiVar3.zzh, 0, i2, false);
                return;
            }
            if (i8 == 18402) {
                byte[] bArr = new byte[i2];
                ((zzabc) zzabnVar).zzn(bArr, 0, i2, false);
                zzr(i);
                this.zzB.zzi = new zzacr(1, bArr, 0, 0);
                return;
            }
            if (i8 == 21419) {
                Arrays.fill(this.zzp.zzI(), (byte) 0);
                ((zzabc) zzabnVar).zzn(this.zzp.zzI(), 4 - i2, i2, false);
                this.zzp.zzG(0);
                this.zzD = (int) this.zzp.zzt();
                return;
            }
            if (i8 == 25506) {
                zzr(i);
                zzagi zzagiVar4 = this.zzB;
                zzagiVar4.zzj = new byte[i2];
                ((zzabc) zzabnVar).zzn(zzagiVar4.zzj, 0, i2, false);
                return;
            }
            if (i8 != 30322) {
                throw zzcc.zza("Unexpected id: " + i8, null);
            }
            zzr(i);
            zzagi zzagiVar5 = this.zzB;
            zzagiVar5.zzu = new byte[i2];
            ((zzabc) zzabnVar).zzn(zzagiVar5.zzu, 0, i2, false);
            return;
        }
        int i11 = 8;
        if (this.zzN == 0) {
            this.zzT = (int) this.zzi.zzd(zzabnVar, false, true, 8);
            this.zzU = this.zzi.zza();
            this.zzP = -9223372036854775807L;
            this.zzN = 1;
            this.zzn.zzD(0);
        }
        zzagi zzagiVar6 = (zzagi) this.zzj.get(this.zzT);
        if (zzagiVar6 == null) {
            ((zzabc) zzabnVar).zzo(i2 - this.zzU, false);
            this.zzN = 0;
            return;
        }
        Objects.requireNonNull(zzagiVar6.zzV);
        if (this.zzN == 1) {
            zzt(zzabnVar, 3);
            int i12 = (this.zzn.zzI()[2] & 6) >> 1;
            if (i12 == 0) {
                this.zzR = 1;
                int[] iArrZzx = zzx(this.zzS, 1);
                this.zzS = iArrZzx;
                iArrZzx[0] = (i2 - this.zzU) - 3;
            } else {
                zzt(zzabnVar, 4);
                int i13 = (this.zzn.zzI()[3] & 255) + 1;
                this.zzR = i13;
                int[] iArrZzx2 = zzx(this.zzS, i13);
                this.zzS = iArrZzx2;
                if (i12 == 2) {
                    int i14 = (i2 - this.zzU) - 4;
                    int i15 = this.zzR;
                    Arrays.fill(iArrZzx2, 0, i15, i14 / i15);
                } else if (i12 == 1) {
                    int i16 = 0;
                    int i17 = 0;
                    int i18 = 4;
                    while (true) {
                        i4 = this.zzR - 1;
                        if (i16 >= i4) {
                            break;
                        }
                        this.zzS[i16] = 0;
                        do {
                            i18++;
                            zzt(zzabnVar, i18);
                            i5 = this.zzn.zzI()[i18 - 1] & 255;
                            int[] iArr = this.zzS;
                            i6 = iArr[i16] + i5;
                            iArr[i16] = i6;
                        } while (i5 == 255);
                        i17 += i6;
                        i16++;
                    }
                    this.zzS[i4] = ((i2 - this.zzU) - i18) - i17;
                } else {
                    if (i12 != 3) {
                        throw zzcc.zza("Unexpected lacing value: 2", null);
                    }
                    int i19 = 0;
                    int i20 = 0;
                    int i21 = 4;
                    while (true) {
                        int i22 = this.zzR - 1;
                        if (i19 >= i22) {
                            this.zzS[i22] = ((i2 - this.zzU) - i21) - i20;
                            break;
                        }
                        this.zzS[i19] = i10;
                        i21++;
                        zzt(zzabnVar, i21);
                        int i23 = i21 - 1;
                        if (this.zzn.zzI()[i23] == 0) {
                            throw zzcc.zza("No valid varint length mask found", null);
                        }
                        int i24 = i10;
                        while (true) {
                            if (i24 >= i11) {
                                j = 0;
                                break;
                            }
                            int i25 = i9 << (7 - i24);
                            if ((this.zzn.zzI()[i23] & i25) != 0) {
                                i21 += i24;
                                zzt(zzabnVar, i21);
                                j = (~i25) & this.zzn.zzI()[i23] & 255;
                                int i26 = i23 + 1;
                                while (i26 < i21) {
                                    j = (j << i11) | ((long) (this.zzn.zzI()[i26] & 255));
                                    i26++;
                                    i11 = 8;
                                }
                                if (i19 <= 0) {
                                    break;
                                }
                                j -= (1 << ((i24 * 7) + 6)) - 1;
                                break;
                            }
                            i24++;
                            i9 = 1;
                            i11 = 8;
                        }
                        if (j < -2147483648L || j > 2147483647L) {
                            throw zzcc.zza("EBML lacing sample size out of range.", null);
                        }
                        int[] iArr2 = this.zzS;
                        int i27 = (int) j;
                        if (i19 != 0) {
                            i27 += iArr2[i19 - 1];
                        }
                        iArr2[i19] = i27;
                        i20 += i27;
                        i19++;
                        i9 = 1;
                        i10 = 0;
                        i11 = 8;
                    }
                }
            }
            this.zzO = this.zzI + zzp((this.zzn.zzI()[0] << 8) | (this.zzn.zzI()[1] & 255));
            if (zzagiVar6.zzd == 2) {
                i7 = 1;
            } else {
                if (i8 == 163) {
                    if ((this.zzn.zzI()[2] & 128) == 128) {
                        i8 = 163;
                        i7 = 1;
                    } else {
                        i8 = 163;
                    }
                }
                i7 = 0;
            }
            this.zzV = i7;
            this.zzN = 2;
            this.zzQ = 0;
            i3 = 163;
        } else {
            i3 = 163;
        }
        if (i8 == i3) {
            while (true) {
                int i28 = this.zzQ;
                if (i28 >= this.zzR) {
                    this.zzN = 0;
                    return;
                }
                zzs(zzagiVar6, ((long) ((this.zzQ * zzagiVar6.zze) / 1000)) + this.zzO, this.zzV, zzn(zzabnVar, zzagiVar6, this.zzS[i28], false), 0);
                this.zzQ++;
            }
        } else {
            while (true) {
                int i29 = this.zzQ;
                if (i29 >= this.zzR) {
                    return;
                }
                int[] iArr3 = this.zzS;
                iArr3[i29] = zzn(zzabnVar, zzagiVar6, iArr3[i29], true);
                this.zzQ++;
            }
        }
    }

    protected final void zzj(int i, long j) throws zzcc {
        boolean z;
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw zzcc.zza("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw zzcc.zza("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                zzr(i);
                this.zzB.zzd = (int) j;
                return;
            case 136:
                z = j == 1;
                zzr(i);
                this.zzB.zzU = z;
                return;
            case 155:
                this.zzP = zzp(j);
                return;
            case 159:
                zzr(i);
                this.zzB.zzN = (int) j;
                return;
            case 176:
                zzr(i);
                this.zzB.zzl = (int) j;
                return;
            case 179:
                zzq(i);
                this.zzJ.zzc(zzp(j));
                return;
            case 186:
                zzr(i);
                this.zzB.zzm = (int) j;
                return;
            case 215:
                zzr(i);
                this.zzB.zzc = (int) j;
                return;
            case 231:
                this.zzI = zzp(j);
                return;
            case 238:
                this.zzW = (int) j;
                return;
            case 241:
                if (this.zzL) {
                    return;
                }
                zzq(i);
                this.zzK.zzc(j);
                this.zzL = true;
                return;
            case 251:
                this.zzX = true;
                return;
            case 16871:
                zzr(i);
                this.zzB.zzX = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw zzcc.zza("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw zzcc.zza("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw zzcc.zza("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw zzcc.zza("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw zzcc.zza("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.zzE = j + this.zzx;
                return;
            case 21432:
                int i2 = (int) j;
                zzr(i);
                if (i2 == 0) {
                    this.zzB.zzv = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzB.zzv = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzB.zzv = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzB.zzv = 3;
                    return;
                }
            case 21680:
                zzr(i);
                this.zzB.zzn = (int) j;
                return;
            case 21682:
                zzr(i);
                this.zzB.zzp = (int) j;
                return;
            case 21690:
                zzr(i);
                this.zzB.zzo = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzr(i);
                this.zzB.zzT = z;
                return;
            case 21998:
                zzr(i);
                this.zzB.zzf = (int) j;
                return;
            case 22186:
                zzr(i);
                this.zzB.zzQ = j;
                return;
            case 22203:
                zzr(i);
                this.zzB.zzR = j;
                return;
            case 25188:
                zzr(i);
                this.zzB.zzO = (int) j;
                return;
            case 30114:
                this.zzY = j;
                return;
            case 30321:
                int i3 = (int) j;
                zzr(i);
                if (i3 == 0) {
                    this.zzB.zzq = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzB.zzq = 1;
                    return;
                } else if (i3 == 2) {
                    this.zzB.zzq = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.zzB.zzq = 3;
                    return;
                }
            case 2352003:
                zzr(i);
                this.zzB.zze = (int) j;
                return;
            case 2807729:
                this.zzy = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        zzr(i);
                        if (i4 == 1) {
                            this.zzB.zzz = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.zzB.zzz = 1;
                            return;
                        }
                    case 21946:
                        zzr(i);
                        int iZzb = zzs.zzb((int) j);
                        if (iZzb != -1) {
                            this.zzB.zzy = iZzb;
                            return;
                        }
                        return;
                    case 21947:
                        zzr(i);
                        this.zzB.zzw = true;
                        int iZza = zzs.zza((int) j);
                        if (iZza != -1) {
                            this.zzB.zzx = iZza;
                            return;
                        }
                        return;
                    case 21948:
                        zzr(i);
                        this.zzB.zzA = (int) j;
                        return;
                    case 21949:
                        zzr(i);
                        this.zzB.zzB = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    protected final void zzi(int i, double d) throws zzcc {
        if (i == 181) {
            zzr(i);
            this.zzB.zzP = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzz = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzr(i);
                this.zzB.zzC = (float) d;
                break;
            case 21970:
                zzr(i);
                this.zzB.zzD = (float) d;
                break;
            case 21971:
                zzr(i);
                this.zzB.zzE = (float) d;
                break;
            case 21972:
                zzr(i);
                this.zzB.zzF = (float) d;
                break;
            case 21973:
                zzr(i);
                this.zzB.zzG = (float) d;
                break;
            case 21974:
                zzr(i);
                this.zzB.zzH = (float) d;
                break;
            case 21975:
                zzr(i);
                this.zzB.zzI = (float) d;
                break;
            case 21976:
                zzr(i);
                this.zzB.zzJ = (float) d;
                break;
            case 21977:
                zzr(i);
                this.zzB.zzK = (float) d;
                break;
            case 21978:
                zzr(i);
                this.zzB.zzL = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        zzr(i);
                        this.zzB.zzr = (float) d;
                        break;
                    case 30324:
                        zzr(i);
                        this.zzB.zzs = (float) d;
                        break;
                    case 30325:
                        zzr(i);
                        this.zzB.zzt = (float) d;
                        break;
                }
                break;
        }
    }
}

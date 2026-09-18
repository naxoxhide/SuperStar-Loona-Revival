package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzse extends zzic {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private zzrz zzA;
    private int zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private long zzL;
    private int zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzid zza;
    private boolean zzaa;
    private long zzab;
    private long zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private zzsd zzag;
    private long zzah;
    private boolean zzai;
    private zzre zzaj;
    private zzre zzak;
    private final zzrv zzc;
    private final zzsg zzd;
    private final float zze;
    private final zzht zzf;
    private final zzht zzg;
    private final zzht zzh;
    private final zzrs zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzqp zzl;
    private zzam zzm;
    private zzam zzn;
    private MediaCrypto zzo;
    private boolean zzp;
    private long zzq;
    private float zzr;
    private float zzs;
    private zzrw zzt;
    private zzam zzu;
    private MediaFormat zzv;
    private boolean zzw;
    private float zzx;
    private ArrayDeque zzy;
    private zzsc zzz;

    public zzse(int i, zzrv zzrvVar, zzsg zzsgVar, boolean z, float f) {
        super(i);
        this.zzc = zzrvVar;
        Objects.requireNonNull(zzsgVar);
        this.zzd = zzsgVar;
        this.zze = f;
        this.zzf = new zzht(0, 0);
        this.zzg = new zzht(0, 0);
        this.zzh = new zzht(2, 0);
        zzrs zzrsVar = new zzrs();
        this.zzi = zzrsVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzr = 1.0f;
        this.zzs = 1.0f;
        this.zzq = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        zzaL(zzsd.zza);
        zzrsVar.zzi(0);
        zzrsVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzqp();
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzV = 0;
        this.zzM = -1;
        this.zzN = -1;
        this.zzL = -9223372036854775807L;
        this.zzab = -9223372036854775807L;
        this.zzac = -9223372036854775807L;
        this.zzah = -9223372036854775807L;
        this.zzW = 0;
        this.zzX = 0;
    }

    protected static boolean zzaG(zzam zzamVar) {
        return zzamVar.zzH == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzaH(zzrz zzrzVar, MediaCrypto mediaCrypto) throws Exception {
        zzrw zzsvVar;
        long j;
        zzru zzruVar;
        int i;
        int i2;
        String string;
        String str = zzrzVar.zza;
        float fZzW = zzfk.zza < 23 ? -1.0f : zzW(this.zzs, this.zzm, zzQ());
        if (fZzW <= this.zze) {
            fZzW = -1.0f;
        }
        zzax(this.zzm);
        zzh();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodec mediaCodec = null;
        zzru zzruVarZzac = zzac(zzrzVar, this.zzm, null, fZzW);
        if (zzfk.zza >= 31) {
            zzsb.zza(zzruVarZzac, zzn());
        }
        try {
            Trace.beginSection("createCodec:" + str);
            if (zzfk.zza < 23 || zzfk.zza < 31) {
                try {
                    zzrz zzrzVar2 = zzruVarZzac.zza;
                    Objects.requireNonNull(zzrzVar2);
                    String str2 = zzrzVar2.zza;
                    Trace.beginSection("createCodec:".concat(str2));
                    MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str2);
                    Trace.endSection();
                    try {
                        Trace.beginSection("configureCodec");
                        mediaCodecCreateByCodecName.configure(zzruVarZzac.zzb, zzruVarZzac.zzd, (MediaCrypto) null, 0);
                        Trace.endSection();
                        Trace.beginSection("startCodec");
                        mediaCodecCreateByCodecName.start();
                        Trace.endSection();
                        zzsvVar = new zzsv(mediaCodecCreateByCodecName, null);
                    } catch (IOException | RuntimeException e) {
                        e = e;
                        mediaCodec = mediaCodecCreateByCodecName;
                        if (mediaCodec != null) {
                            mediaCodec.release();
                        }
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (RuntimeException e3) {
                    e = e3;
                }
            } else {
                int iZzb = zzcb.zzb(zzruVarZzac.zzc.zzm);
                zzer.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzfk.zzA(iZzb)));
                zzsvVar = new zzrj(iZzb, false).zzc(zzruVarZzac);
            }
            this.zzt = zzsvVar;
            Trace.endSection();
            zzh();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (zzrzVar.zze(this.zzm)) {
                j = jElapsedRealtime;
                zzruVar = zzruVarZzac;
                i = 0;
            } else {
                Object[] objArr = new Object[2];
                zzam zzamVar = this.zzm;
                zzn zznVar = zzam.zza;
                if (zzamVar == null) {
                    string = "null";
                    j = jElapsedRealtime;
                    zzruVar = zzruVarZzac;
                    i = 0;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("id=");
                    sb.append(zzamVar.zzb);
                    sb.append(", mimeType=");
                    sb.append(zzamVar.zzm);
                    if (zzamVar.zzi != -1) {
                        sb.append(", bitrate=");
                        sb.append(zzamVar.zzi);
                    }
                    if (zzamVar.zzj != null) {
                        sb.append(", codecs=");
                        sb.append(zzamVar.zzj);
                    }
                    if (zzamVar.zzp != null) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        int i3 = 0;
                        while (true) {
                            zzad zzadVar = zzamVar.zzp;
                            zzruVar = zzruVarZzac;
                            if (i3 >= zzadVar.zzb) {
                                break;
                            }
                            UUID uuid = zzadVar.zza(i3).zza;
                            if (uuid.equals(zzo.zzb)) {
                                linkedHashSet.add("cenc");
                            } else if (uuid.equals(zzo.zzc)) {
                                linkedHashSet.add("clearkey");
                            } else if (uuid.equals(zzo.zze)) {
                                linkedHashSet.add("playready");
                            } else if (uuid.equals(zzo.zzd)) {
                                linkedHashSet.add("widevine");
                            } else {
                                if (uuid.equals(zzo.zza)) {
                                    linkedHashSet.add("universal");
                                } else {
                                    linkedHashSet.add("unknown (" + uuid.toString() + ")");
                                }
                                i3++;
                                zzruVarZzac = zzruVar;
                                jElapsedRealtime = jElapsedRealtime;
                            }
                            i3++;
                            zzruVarZzac = zzruVar;
                            jElapsedRealtime = jElapsedRealtime;
                        }
                        j = jElapsedRealtime;
                        sb.append(", drm=[");
                        zzfsl.zzb(sb, linkedHashSet, ",");
                        sb.append(']');
                    } else {
                        j = jElapsedRealtime;
                        zzruVar = zzruVarZzac;
                    }
                    if (zzamVar.zzr != -1 && zzamVar.zzs != -1) {
                        sb.append(", res=");
                        sb.append(zzamVar.zzr);
                        sb.append("x");
                        sb.append(zzamVar.zzs);
                    }
                    zzs zzsVar = zzamVar.zzy;
                    if (zzsVar != null && zzsVar.zze()) {
                        sb.append(", color=");
                        sb.append(zzamVar.zzy.zzd());
                    }
                    if (zzamVar.zzt != -1.0f) {
                        sb.append(", fps=");
                        sb.append(zzamVar.zzt);
                    }
                    if (zzamVar.zzz != -1) {
                        sb.append(", channels=");
                        sb.append(zzamVar.zzz);
                    }
                    if (zzamVar.zzA != -1) {
                        sb.append(", sample_rate=");
                        sb.append(zzamVar.zzA);
                    }
                    if (zzamVar.zzd != null) {
                        sb.append(", language=");
                        sb.append(zzamVar.zzd);
                    }
                    if (zzamVar.zzc != null) {
                        sb.append(", label=");
                        sb.append(zzamVar.zzc);
                    }
                    if (zzamVar.zze != 0) {
                        ArrayList arrayList = new ArrayList();
                        if ((zzamVar.zze & 1) != 0) {
                            arrayList.add("default");
                        }
                        if ((zzamVar.zze & 2) != 0) {
                            arrayList.add("forced");
                        }
                        sb.append(", selectionFlags=[");
                        zzfsl.zzb(sb, arrayList, ",");
                        sb.append("]");
                    }
                    string = sb.toString();
                    i = 0;
                }
                objArr[i] = string;
                objArr[1] = str;
                zzer.zzf("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", objArr));
            }
            this.zzA = zzrzVar;
            this.zzx = fZzW;
            this.zzu = this.zzm;
            if (zzfk.zza <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (zzfk.zzd.startsWith("SM-T585") || zzfk.zzd.startsWith("SM-A510") || zzfk.zzd.startsWith("SM-A520") || zzfk.zzd.startsWith("SM-J700"))) {
                i2 = 2;
            } else {
                i2 = (zzfk.zza >= 24 || !(("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(zzfk.zzb) || "flounder_lte".equals(zzfk.zzb) || "grouper".equals(zzfk.zzb) || "tilapia".equals(zzfk.zzb)))) ? i : 1;
            }
            this.zzB = i2;
            this.zzC = (zzfk.zza < 21 && this.zzu.zzo.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) ? 1 : i;
            this.zzD = (zzfk.zza == 19 && zzfk.zzd.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str))) ? 1 : i;
            this.zzE = (zzfk.zza == 29 && "c2.android.aac.decoder".equals(str)) ? 1 : i;
            this.zzF = ((zzfk.zza > 23 || !"OMX.google.vorbis.decoder".equals(str)) && (zzfk.zza > 19 || !(("hb2000".equals(zzfk.zzb) || "stvm8".equals(zzfk.zzb)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) ? i : 1;
            this.zzG = (zzfk.zza == 21 && "OMX.google.aac.decoder".equals(str)) ? 1 : i;
            this.zzH = (zzfk.zza < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(zzfk.zzc) && (zzfk.zzb.startsWith("baffin") || zzfk.zzb.startsWith("grand") || zzfk.zzb.startsWith("fortuna") || zzfk.zzb.startsWith("gprimelte") || zzfk.zzb.startsWith("j2y18lte") || zzfk.zzb.startsWith("ms01"))) ? 1 : i;
            String str3 = zzrzVar.zza;
            this.zzK = ((zzfk.zza > 25 || !"OMX.rk.video_decoder.avc".equals(str3)) && (zzfk.zza > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str3) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str3) || "OMX.bcm.vdec.avc.tunnel".equals(str3) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str3) || "OMX.bcm.vdec.hevc.tunnel".equals(str3) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str3))) && !("Amazon".equals(zzfk.zzc) && "AFTS".equals(zzfk.zzd) && zzrzVar.zzf)) ? i : 1;
            this.zzt.zzr();
            if (zzbc() == 2) {
                zzh();
                this.zzL = SystemClock.elapsedRealtime() + 1000;
            }
            this.zza.zza++;
            zzag(str, zzruVar, jElapsedRealtime2, jElapsedRealtime2 - j);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final void zzaJ() {
        this.zzM = -1;
        this.zzg.zzc = null;
    }

    private final void zzaK() {
        this.zzN = -1;
        this.zzO = null;
    }

    private final void zzaL(zzsd zzsdVar) {
        this.zzag = zzsdVar;
        if (zzsdVar.zzd != -9223372036854775807L) {
            this.zzai = true;
        }
    }

    private final void zzaM() throws zzil {
        this.zzaj = this.zzak;
        this.zzW = 0;
        this.zzX = 0;
    }

    private final boolean zzaN() throws zzil {
        if (this.zzY) {
            this.zzW = 1;
            if (this.zzD || this.zzF) {
                this.zzX = 3;
                return false;
            }
            this.zzX = 2;
        } else {
            zzaM();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    private final boolean zzaO() throws zzil {
        zzrw zzrwVar = this.zzt;
        boolean z = 0;
        if (zzrwVar == null || this.zzW == 2 || this.zzad) {
            return false;
        }
        if (this.zzM < 0) {
            int iZza = zzrwVar.zza();
            this.zzM = iZza;
            if (iZza < 0) {
                return false;
            }
            this.zzg.zzc = this.zzt.zzf(iZza);
            this.zzg.zzb();
        }
        if (this.zzW == 1) {
            if (!this.zzK) {
                this.zzZ = true;
                this.zzt.zzj(this.zzM, 0, 0, 0L, 4);
                zzaJ();
            }
            this.zzW = 2;
            return false;
        }
        if (this.zzI) {
            this.zzI = false;
            this.zzg.zzc.put(zzb);
            this.zzt.zzj(this.zzM, 0, 38, 0L, 0);
            zzaJ();
            this.zzY = true;
            return true;
        }
        if (this.zzV == 1) {
            for (int i = 0; i < this.zzu.zzo.size(); i++) {
                this.zzg.zzc.put((byte[]) this.zzu.zzo.get(i));
            }
            this.zzV = 2;
        }
        int iPosition = this.zzg.zzc.position();
        zzkn zzknVarZzj = zzj();
        try {
            int iZzbd = zzbd(zzknVarZzj, this.zzg, 0);
            if (iZzbd == -3) {
                if (zzN()) {
                    this.zzac = this.zzab;
                }
                return false;
            }
            if (iZzbd == -5) {
                if (this.zzV == 2) {
                    this.zzg.zzb();
                    this.zzV = 1;
                }
                zzZ(zzknVarZzj);
                return true;
            }
            zzht zzhtVar = this.zzg;
            if (zzhtVar.zzf()) {
                this.zzac = this.zzab;
                if (this.zzV == 2) {
                    zzhtVar.zzb();
                    this.zzV = 1;
                }
                this.zzad = true;
                if (!this.zzY) {
                    zzaI();
                    return false;
                }
                try {
                    if (!this.zzK) {
                        this.zzZ = true;
                        this.zzt.zzj(this.zzM, 0, 0, 0L, 4);
                        zzaJ();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw zzi(e, this.zzm, false, zzfk.zzi(e.getErrorCode()));
                }
            }
            if (!this.zzY && !zzhtVar.zzg()) {
                zzhtVar.zzb();
                if (this.zzV == 2) {
                    this.zzV = 1;
                }
                return true;
            }
            boolean zZzk = zzhtVar.zzk();
            if (zZzk) {
                zzhtVar.zzb.zzb(iPosition);
            }
            if (this.zzC && !zZzk) {
                ByteBuffer byteBuffer = this.zzg.zzc;
                byte[] bArr = zzfy.zza;
                int iPosition2 = byteBuffer.position();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i2 + 1;
                    if (i4 >= iPosition2) {
                        byteBuffer.clear();
                        break;
                    }
                    int i5 = byteBuffer.get(i2) & 255;
                    if (i3 == 3) {
                        if (i5 == 1) {
                            if ((byteBuffer.get(i4) & 31) == 7) {
                                ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                                byteBufferDuplicate.position(i2 - 3);
                                byteBufferDuplicate.limit(iPosition2);
                                byteBuffer.position(0);
                                byteBuffer.put(byteBufferDuplicate);
                                break;
                            }
                            i5 = 1;
                        }
                    } else if (i5 == 0) {
                        i3++;
                    }
                    if (i5 != 0) {
                        i3 = 0;
                    }
                    i2 = i4;
                }
                if (this.zzg.zzc.position() == 0) {
                    return true;
                }
                this.zzC = false;
            }
            long j = this.zzg.zze;
            if (this.zzaf) {
                if (this.zzk.isEmpty()) {
                    this.zzag.zze.zzd(j, this.zzm);
                } else {
                    ((zzsd) this.zzk.peekLast()).zze.zzd(j, this.zzm);
                }
                this.zzaf = false;
            }
            long jMax = Math.max(this.zzab, j);
            this.zzab = jMax;
            if (zzN() || this.zzg.zzh()) {
                this.zzac = jMax;
            }
            this.zzg.zzj();
            zzht zzhtVar2 = this.zzg;
            if (zzhtVar2.zze()) {
                zzae(zzhtVar2);
            }
            zzaw(this.zzg);
            try {
                if (zZzk) {
                    this.zzt.zzk(this.zzM, 0, this.zzg.zzb, j, 0);
                } else {
                    this.zzt.zzj(this.zzM, 0, this.zzg.zzc.limit(), j, 0);
                }
                zzaJ();
                this.zzY = true;
                this.zzV = 0;
                zzid zzidVar = this.zza;
                z = zzidVar.zzc + 1;
                zzidVar.zzc = z;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw zzi(e2, this.zzm, z, zzfk.zzi(e2.getErrorCode()));
            }
        } catch (zzhs e3) {
            zzaf(e3);
            zzaQ(0);
            zzaj();
            return true;
        }
    }

    private final boolean zzaP() {
        return this.zzN >= 0;
    }

    private final boolean zzaQ(int i) throws zzil {
        zzht zzhtVar = this.zzf;
        zzkn zzknVarZzj = zzj();
        zzhtVar.zzb();
        int iZzbd = zzbd(zzknVarZzj, this.zzf, i | 4);
        if (iZzbd == -5) {
            zzZ(zzknVarZzj);
            return true;
        }
        if (iZzbd != -4 || !this.zzf.zzf()) {
            return false;
        }
        this.zzad = true;
        zzaI();
        return false;
    }

    private final boolean zzaR(long j) {
        if (this.zzq == -9223372036854775807L) {
            return true;
        }
        zzh();
        return SystemClock.elapsedRealtime() - j < this.zzq;
    }

    private final boolean zzaS(zzam zzamVar) throws zzil {
        if (zzfk.zza >= 23 && this.zzt != null && this.zzX != 3 && zzbc() != 0) {
            float fZzW = zzW(this.zzs, zzamVar, zzQ());
            float f = this.zzx;
            if (f == fZzW) {
                return true;
            }
            if (fZzW == -1.0f) {
                zzab();
                return false;
            }
            if (f == -1.0f && fZzW <= this.zze) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fZzW);
            this.zzt.zzp(bundle);
            this.zzx = fZzW;
        }
        return true;
    }

    private final void zzaa() {
        this.zzT = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzS = false;
        this.zzR = false;
        this.zzl.zzb();
    }

    private final void zzab() throws zzil {
        if (this.zzY) {
            this.zzW = 1;
            this.zzX = 3;
        } else {
            zzay();
            zzau();
        }
    }

    private final void zzaj() {
        try {
            this.zzt.zzi();
        } finally {
            zzaz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzA() {
        try {
            zzaa();
            zzay();
        } finally {
            this.zzak = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r5 >= r1) goto L14;
     */
    @Override // com.google.android.gms.internal.ads.zzic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzD(com.google.android.gms.internal.ads.zzam[] r13, long r14, long r16) throws com.google.android.gms.internal.ads.zzil {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zzsd r1 = r0.zzag
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L20
            com.google.android.gms.internal.ads.zzsd r1 = new com.google.android.gms.internal.ads.zzsd
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaL(r1)
            return
        L20:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L55
            long r1 = r0.zzab
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L38
            long r5 = r0.zzah
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L55
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L55
        L38:
            com.google.android.gms.internal.ads.zzsd r1 = new com.google.android.gms.internal.ads.zzsd
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaL(r1)
            com.google.android.gms.internal.ads.zzsd r1 = r0.zzag
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L54
            r12.zzak()
        L54:
            return
        L55:
            java.util.ArrayDeque r1 = r0.zzk
            com.google.android.gms.internal.ads.zzsd r9 = new com.google.android.gms.internal.ads.zzsd
            long r3 = r0.zzab
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzse.zzD(com.google.android.gms.internal.ads.zzam[], long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlr
    public void zzK(float f, float f2) throws zzil {
        this.zzr = f;
        this.zzs = f2;
        zzaS(this.zzu);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10901. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzS(long r24, long r26) throws com.google.android.gms.internal.ads.zzil {
        /*
            Method dump skipped, instruction units count: 1090
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzse.zzS(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public boolean zzT() {
        return this.zzae;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public boolean zzU() {
        if (this.zzm != null) {
            if (zzP() || zzaP()) {
                return true;
            }
            if (this.zzL != -9223372036854775807L) {
                zzh();
                if (SystemClock.elapsedRealtime() < this.zzL) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzlt
    public final int zzV(zzam zzamVar) throws zzil {
        try {
            return zzX(this.zzd, zzamVar);
        } catch (zzsn e) {
            throw zzi(e, zzamVar, false, 4002);
        }
    }

    protected float zzW(float f, zzam zzamVar, zzam[] zzamVarArr) {
        throw null;
    }

    protected abstract int zzX(zzsg zzsgVar, zzam zzamVar) throws zzsn;

    protected zzie zzY(zzrz zzrzVar, zzam zzamVar, zzam zzamVar2) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    protected zzie zzZ(zzkn zzknVar) throws zzil {
        boolean z = true;
        this.zzaf = true;
        zzam zzamVar = zzknVar.zza;
        Objects.requireNonNull(zzamVar);
        if (zzamVar.zzm == null) {
            throw zzi(new IllegalArgumentException(), zzamVar, false, 4005);
        }
        zzre zzreVar = zzknVar.zzb;
        this.zzak = zzreVar;
        this.zzm = zzamVar;
        if (this.zzR) {
            this.zzT = true;
            return null;
        }
        zzrw zzrwVar = this.zzt;
        if (zzrwVar == null) {
            this.zzy = null;
            zzau();
            return null;
        }
        zzrz zzrzVar = this.zzA;
        zzam zzamVar2 = this.zzu;
        zzre zzreVar2 = this.zzaj;
        if (zzreVar2 != zzreVar) {
            zzab();
            return new zzie(zzrzVar.zza, zzamVar2, zzamVar, 0, 128);
        }
        boolean z2 = zzreVar != zzreVar2;
        zzdx.zzf(!z2 || zzfk.zza >= 23);
        zzie zzieVarZzY = zzY(zzrzVar, zzamVar2, zzamVar);
        int i = zzieVarZzY.zzd;
        int i2 = 2;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (zzaS(zzamVar)) {
                        this.zzu = zzamVar;
                        if (!z2 || zzaN()) {
                        }
                    } else {
                        i2 = 16;
                    }
                } else if (zzaS(zzamVar)) {
                    this.zzU = true;
                    this.zzV = 1;
                    int i3 = this.zzB;
                    if (i3 != 2 && (i3 != 1 || zzamVar.zzr != zzamVar2.zzr || zzamVar.zzs != zzamVar2.zzs)) {
                        z = false;
                    }
                    this.zzI = z;
                    this.zzu = zzamVar;
                    if (!z2 || zzaN()) {
                    }
                } else {
                    i2 = 16;
                }
            } else if (zzaS(zzamVar)) {
                this.zzu = zzamVar;
                if (z2) {
                    if (zzaN()) {
                    }
                } else if (this.zzY) {
                    this.zzW = 1;
                    if (this.zzD || this.zzF) {
                        this.zzX = 3;
                    } else {
                        this.zzX = 1;
                    }
                }
            } else {
                i2 = 16;
            }
            return (zzieVarZzY.zzd != 0 || (this.zzt == zzrwVar && this.zzX != 3)) ? zzieVarZzY : new zzie(zzrzVar.zza, zzamVar2, zzamVar, 0, i2);
        }
        zzab();
        i2 = 0;
        if (zzieVarZzY.zzd != 0) {
        }
    }

    protected final void zzaA() {
        zzaz();
        this.zzy = null;
        this.zzA = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
        this.zzaa = false;
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzC = false;
        this.zzD = false;
        this.zzE = false;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzK = false;
        this.zzU = false;
        this.zzV = 0;
        this.zzp = false;
    }

    protected final boolean zzaB() throws zzil {
        boolean zZzaC = zzaC();
        if (zZzaC) {
            zzau();
        }
        return zZzaC;
    }

    protected final boolean zzaC() {
        if (this.zzt == null) {
            return false;
        }
        int i = this.zzX;
        if (i == 3 || this.zzD || ((this.zzE && !this.zzaa) || (this.zzF && this.zzZ))) {
            zzay();
            return true;
        }
        if (i == 2) {
            zzdx.zzf(zzfk.zza >= 23);
            if (zzfk.zza >= 23) {
                try {
                    zzaM();
                } catch (zzil e) {
                    zzer.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzay();
                    return true;
                }
            }
        }
        zzaj();
        return false;
    }

    protected final boolean zzaD() {
        return this.zzR;
    }

    protected final boolean zzaE(zzam zzamVar) {
        return this.zzak == null && zzan(zzamVar);
    }

    protected boolean zzaF(zzrz zzrzVar) {
        return true;
    }

    protected abstract zzru zzac(zzrz zzrzVar, zzam zzamVar, MediaCrypto mediaCrypto, float f);

    protected abstract List zzad(zzsg zzsgVar, zzam zzamVar, boolean z) throws zzsn;

    protected void zzae(zzht zzhtVar) throws zzil {
        throw null;
    }

    protected void zzaf(Exception exc) {
        throw null;
    }

    protected void zzag(String str, zzru zzruVar, long j, long j2) {
        throw null;
    }

    protected void zzah(String str) {
        throw null;
    }

    protected void zzai(zzam zzamVar, MediaFormat mediaFormat) throws zzil {
        throw null;
    }

    protected void zzak() {
    }

    protected void zzal() throws zzil {
    }

    protected abstract boolean zzam(long j, long j2, zzrw zzrwVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzamVar) throws zzil;

    protected boolean zzan(zzam zzamVar) {
        return false;
    }

    protected final float zzao() {
        return this.zzr;
    }

    protected final long zzap() {
        return this.zzag.zzd;
    }

    protected final long zzaq() {
        return this.zzag.zzc;
    }

    protected final zzrw zzar() {
        return this.zzt;
    }

    protected zzrx zzas(Throwable th, zzrz zzrzVar) {
        return new zzrx(th, zzrzVar);
    }

    protected final zzrz zzat() {
        return this.zzA;
    }

    protected final void zzau() throws zzil {
        zzam zzamVar;
        if (this.zzt != null || this.zzR || (zzamVar = this.zzm) == null) {
            return;
        }
        if (zzaE(zzamVar)) {
            zzam zzamVar2 = this.zzm;
            zzaa();
            String str = zzamVar2.zzm;
            if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                this.zzi.zzn(32);
            } else {
                this.zzi.zzn(1);
            }
            this.zzR = true;
            return;
        }
        this.zzaj = this.zzak;
        String str2 = this.zzm.zzm;
        if (this.zzaj != null) {
            boolean z = zzrf.zza;
        }
        try {
            if (this.zzy == null) {
                try {
                    List listZzad = zzad(this.zzd, this.zzm, false);
                    listZzad.isEmpty();
                    this.zzy = new ArrayDeque();
                    if (!listZzad.isEmpty()) {
                        this.zzy.add((zzrz) listZzad.get(0));
                    }
                    this.zzz = null;
                } catch (zzsn e) {
                    throw new zzsc(this.zzm, (Throwable) e, false, -49998);
                }
            }
            if (this.zzy.isEmpty()) {
                throw new zzsc(this.zzm, (Throwable) null, false, -49999);
            }
            zzrz zzrzVar = (zzrz) this.zzy.peekFirst();
            while (this.zzt == null) {
                zzrz zzrzVar2 = (zzrz) this.zzy.peekFirst();
                if (!zzaF(zzrzVar2)) {
                    return;
                }
                try {
                    zzaH(zzrzVar2, null);
                } catch (Exception e2) {
                    if (zzrzVar2 != zzrzVar) {
                        throw e2;
                    }
                    try {
                        zzer.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                        Thread.sleep(50L);
                        zzaH(zzrzVar2, null);
                    } catch (Exception e3) {
                        zzer.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(String.valueOf(String.valueOf(zzrzVar2))), e3);
                        this.zzy.removeFirst();
                        zzsc zzscVar = new zzsc(this.zzm, (Throwable) e3, false, zzrzVar2);
                        zzaf(zzscVar);
                        zzsc zzscVar2 = this.zzz;
                        if (zzscVar2 == null) {
                            this.zzz = zzscVar;
                        } else {
                            this.zzz = zzsc.zza(zzscVar2, zzscVar);
                        }
                        if (this.zzy.isEmpty()) {
                            throw this.zzz;
                        }
                    }
                }
            }
            this.zzy = null;
        } catch (zzsc e4) {
            throw zzi(e4, this.zzm, false, 4001);
        }
    }

    protected void zzav(long j) {
        this.zzah = j;
        while (!this.zzk.isEmpty() && j >= ((zzsd) this.zzk.peek()).zzb) {
            zzaL((zzsd) this.zzk.poll());
            zzak();
        }
    }

    protected void zzaw(zzht zzhtVar) throws zzil {
    }

    protected void zzax(zzam zzamVar) throws zzil {
    }

    protected final void zzay() {
        try {
            zzrw zzrwVar = this.zzt;
            if (zzrwVar != null) {
                zzrwVar.zzl();
                this.zza.zzb++;
                zzah(this.zzA.zza);
            }
        } finally {
            this.zzt = null;
            this.zzo = null;
            this.zzaj = null;
            zzaA();
        }
    }

    protected void zzaz() {
        zzaJ();
        zzaK();
        this.zzL = -9223372036854775807L;
        this.zzZ = false;
        this.zzY = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzP = false;
        this.zzQ = false;
        this.zzab = -9223372036854775807L;
        this.zzac = -9223372036854775807L;
        this.zzah = -9223372036854775807L;
        this.zzW = 0;
        this.zzX = 0;
        this.zzV = this.zzU ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlt
    public final int zze() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzw() {
        this.zzm = null;
        zzaL(zzsd.zza);
        this.zzk.clear();
        zzaC();
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzx(boolean z, boolean z2) throws zzil {
        this.zza = new zzid();
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzy(long j, boolean z) throws zzil {
        this.zzad = false;
        this.zzae = false;
        if (this.zzR) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzS = false;
            this.zzl.zzb();
        } else {
            zzaB();
        }
        zzfh zzfhVar = this.zzag.zze;
        if (zzfhVar.zza() > 0) {
            this.zzaf = true;
        }
        zzfhVar.zze();
        this.zzk.clear();
    }

    private final void zzaI() throws zzil {
        int i = this.zzX;
        if (i == 1) {
            zzaj();
            return;
        }
        if (i == 2) {
            zzaj();
            zzaM();
        } else if (i != 3) {
            this.zzae = true;
            zzal();
        } else {
            zzay();
            zzau();
        }
    }
}

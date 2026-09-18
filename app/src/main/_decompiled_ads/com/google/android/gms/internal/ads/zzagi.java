package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.unity3d.services.core.device.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzagi {
    public byte[] zzM;
    public zzact zzS;
    public boolean zzT;
    public zzacs zzV;
    public int zzW;
    private int zzX;
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzacr zzi;
    public byte[] zzj;
    public zzad zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = 0;
    public int zzq = -1;
    public float zzr = 0.0f;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public byte[] zzu = null;
    public int zzv = -1;
    public boolean zzw = false;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = 1000;
    public int zzB = 200;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public int zzN = 1;
    public int zzO = -1;
    public int zzP = 8000;
    public long zzQ = 0;
    public long zzR = 0;
    public boolean zzU = true;
    private String zzY = "eng";

    protected zzagi() {
    }

    private static Pair zzf(zzfb zzfbVar) throws zzcc {
        try {
            zzfbVar.zzH(16);
            long jZzr = zzfbVar.zzr();
            if (jZzr == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzr == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzr != 826496599) {
                zzer.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzc = zzfbVar.zzc() + 20;
            byte[] bArrZzI = zzfbVar.zzI();
            while (true) {
                int length = bArrZzI.length;
                if (iZzc >= length - 4) {
                    throw zzcc.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzc + 1;
                if (bArrZzI[iZzc] == 0 && bArrZzI[i] == 0 && bArrZzI[iZzc + 2] == 1 && bArrZzI[iZzc + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzI, iZzc, length)));
                }
                iZzc = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzcc {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i3 += 255;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzfb zzfbVar) throws zzcc {
        try {
            int iZzj = zzfbVar.zzj();
            if (iZzj == 1) {
                return true;
            }
            if (iZzj == 65534) {
                zzfbVar.zzG(24);
                if (zzfbVar.zzs() == zzagj.zzf.getMostSignificantBits() && zzfbVar.zzs() == zzagj.zzf.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzcc {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzcc.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x0190  */
    /* JADX WARN: Code duplicated, block: B:132:0x0253 A[PHI: r10
      0x0253: PHI (r10v8 int) = (r10v2 int), (r10v3 int), (r10v4 int), (r10v5 int), (r10v6 int), (r10v7 int), (r10v0 int) binds: [B:136:0x026f, B:130:0x0237, B:127:0x0216, B:125:0x0211, B:123:0x020c, B:121:0x0208, B:116:0x01e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:174:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:179:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:180:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:183:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:184:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:186:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:190:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:193:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:195:0x0400  */
    /* JADX WARN: Code duplicated, block: B:198:0x0407  */
    /* JADX WARN: Code duplicated, block: B:201:0x0415  */
    /* JADX WARN: Code duplicated, block: B:204:0x041a  */
    /* JADX WARN: Code duplicated, block: B:206:0x0420  */
    /* JADX WARN: Code duplicated, block: B:229:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:234:0x0502  */
    /* JADX WARN: Code duplicated, block: B:253:0x054e  */
    /* JADX WARN: Code duplicated, block: B:255:0x056e  */
    /* JADX WARN: Code duplicated, block: B:257:0x0574  */
    /* JADX WARN: Code duplicated, block: B:273:0x05a7  */
    @EnsuresNonNull({"this.output"})
    @RequiresNonNull({"codecId"})
    public final void zze(zzabp zzabpVar, int i) throws zzcc {
        byte b2;
        List listSingletonList;
        List list;
        String str;
        int i2;
        String str2;
        String str3;
        int i3;
        zzak zzakVar;
        int iIntValue;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        zzabi zzabiVarZza;
        String str4 = this.zzb;
        int i8 = 1;
        int iZzk = 4;
        int i9 = 0;
        switch (str4) {
            case "V_MPEG4/ISO/AP":
                b2 = 6;
                break;
            case "V_MPEG4/ISO/SP":
                b2 = 4;
                break;
            case "A_MS/ACM":
                b2 = 23;
                break;
            case "A_TRUEHD":
                b2 = 18;
                break;
            case "A_VORBIS":
                b2 = 11;
                break;
            case "A_MPEG/L2":
                b2 = 14;
                break;
            case "A_MPEG/L3":
                b2 = 15;
                break;
            case "V_MS/VFW/FOURCC":
                b2 = 9;
                break;
            case "S_DVBSUB":
                b2 = 32;
                break;
            case "V_MPEG4/ISO/ASP":
                b2 = 5;
                break;
            case "V_MPEG4/ISO/AVC":
                b2 = 7;
                break;
            case "S_VOBSUB":
                b2 = 30;
                break;
            case "A_DTS/LOSSLESS":
                b2 = 21;
                break;
            case "A_AAC":
                b2 = 13;
                break;
            case "A_AC3":
                b2 = 16;
                break;
            case "A_DTS":
                b2 = 19;
                break;
            case "V_AV1":
                b2 = 2;
                break;
            case "V_VP8":
                b2 = 0;
                break;
            case "V_VP9":
                b2 = 1;
                break;
            case "S_HDMV/PGS":
                b2 = 31;
                break;
            case "V_THEORA":
                b2 = 10;
                break;
            case "A_DTS/EXPRESS":
                b2 = 20;
                break;
            case "A_PCM/FLOAT/IEEE":
                b2 = 26;
                break;
            case "A_PCM/INT/BIG":
                b2 = 25;
                break;
            case "A_PCM/INT/LIT":
                b2 = 24;
                break;
            case "S_TEXT/ASS":
                b2 = 28;
                break;
            case "V_MPEGH/ISO/HEVC":
                b2 = 8;
                break;
            case "S_TEXT/WEBVTT":
                b2 = 29;
                break;
            case "S_TEXT/UTF8":
                b2 = 27;
                break;
            case "V_MPEG2":
                b2 = 3;
                break;
            case "A_EAC3":
                b2 = 17;
                break;
            case "A_FLAC":
                b2 = 22;
                break;
            case "A_OPUS":
                b2 = 12;
                break;
            default:
                b2 = -1;
                break;
        }
        int i10 = 4096;
        String str5 = "audio/raw";
        zzs zzsVar = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        byte[] bArr = null;
        switch (b2) {
            case 0:
                str5 = "video/x-vnd.on2.vp8";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null && (zzabiVarZza = zzabi.zza(new zzfb(this.zzM))) != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i11 = (z ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                } else if (zzcb.zzg(str3)) {
                    if (this.zzp == 0) {
                        i6 = this.zzn;
                        iIntValue = -1;
                        if (i6 == -1) {
                            i6 = this.zzl;
                        }
                        this.zzn = i6;
                        i7 = this.zzo;
                        if (i7 == -1) {
                            i7 = this.zzm;
                        }
                        this.zzo = i7;
                    } else {
                        iIntValue = -1;
                    }
                    i4 = this.zzn;
                    if (i4 != iIntValue || (i5 = this.zzo) == iIntValue) {
                        f = -1.0f;
                    } else {
                        f = (this.zzm * i4) / (this.zzl * i5);
                    }
                    if (this.zzw) {
                        if (this.zzC != -1.0f && this.zzD != -1.0f && this.zzE != -1.0f && this.zzF != -1.0f && this.zzG != -1.0f && this.zzH != -1.0f && this.zzI != -1.0f && this.zzJ != -1.0f && this.zzK != -1.0f && this.zzL != -1.0f) {
                            bArr = new byte[25];
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferOrder.put((byte) 0);
                            byteBufferOrder.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzK + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzL + 0.5f));
                            byteBufferOrder.putShort((short) this.zzA);
                            byteBufferOrder.putShort((short) this.zzB);
                        }
                        zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                    }
                    if (this.zza != null && zzagj.zzg.containsKey(this.zza)) {
                        iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                    }
                    if (this.zzq == 0 || Float.compare(this.zzr, 0.0f) != 0 || Float.compare(this.zzs, 0.0f) != 0) {
                        i9 = iIntValue;
                    } else if (Float.compare(this.zzt, 0.0f) != 0) {
                        if (Float.compare(this.zzt, 90.0f) == 0) {
                            i9 = 90;
                        } else if (Float.compare(this.zzt, -180.0f) == 0 || Float.compare(this.zzt, 180.0f) == 0) {
                            i9 = 180;
                        } else if (Float.compare(this.zzt, -90.0f) == 0) {
                            i9 = 270;
                        } else {
                            i9 = iIntValue;
                        }
                    }
                    zzakVar.zzab(this.zzl);
                    zzakVar.zzH(this.zzm);
                    zzakVar.zzR(f);
                    zzakVar.zzT(i9);
                    zzakVar.zzS(this.zzu);
                    zzakVar.zzX(this.zzv);
                    zzakVar.zzA(zzsVar);
                    i8 = 2;
                } else {
                    if ("application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                        throw zzcc.zza("Unexpected MIME type.", null);
                    }
                    i8 = 3;
                }
                if (this.zza != null && !zzagj.zzg.containsKey(this.zza)) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i11);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac = zzakVar.zzac();
                zzacs zzacsVarZzw = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw;
                zzacsVarZzw.zzl(zzamVarZzac);
                return;
            case 1:
                str5 = "video/x-vnd.on2.vp9";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z2 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i12 = (z2 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder2 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder2.put((byte) 0);
                                byteBufferOrder2.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder2.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder2.putShort((short) this.zzA);
                                byteBufferOrder2.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i12);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac2 = zzakVar.zzac();
                zzacs zzacsVarZzw2 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw2;
                zzacsVarZzw2.zzl(zzamVarZzac2);
                return;
            case 2:
                str5 = MimeTypes.VIDEO_AV1;
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z3 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i13 = (z3 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder3 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder3.put((byte) 0);
                                byteBufferOrder3.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder3.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder3.putShort((short) this.zzA);
                                byteBufferOrder3.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i13);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac3 = zzakVar.zzac();
                zzacs zzacsVarZzw3 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw3;
                zzacsVarZzw3.zzl(zzamVarZzac3);
                return;
            case 3:
                str5 = "video/mpeg2";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z4 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i14 = (z4 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder4 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder4.put((byte) 0);
                                byteBufferOrder4.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder4.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder4.putShort((short) this.zzA);
                                byteBufferOrder4.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i14);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac4 = zzakVar.zzac();
                zzacs zzacsVarZzw4 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw4;
                zzacsVarZzw4.zzl(zzamVarZzac4);
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr2 = this.zzj;
                listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str5 = "video/mp4v-es";
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z5 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i15 = (z5 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder5 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder5.put((byte) 0);
                                byteBufferOrder5.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder5.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder5.putShort((short) this.zzA);
                                byteBufferOrder5.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i15);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac5 = zzakVar.zzac();
                zzacs zzacsVarZzw5 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw5;
                zzacsVarZzw5.zzl(zzamVarZzac5);
                return;
            case 7:
                zzaar zzaarVarZza = zzaar.zza(new zzfb(zzi(this.zzb)));
                list = zzaarVarZza.zza;
                this.zzW = zzaarVarZza.zzb;
                str = zzaarVarZza.zzi;
                str5 = "video/avc";
                i2 = -1;
                iZzk = -1;
                List list2 = list;
                str2 = str;
                listSingletonList = list2;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z6 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i16 = (z6 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder6 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder6.put((byte) 0);
                                byteBufferOrder6.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder6.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder6.putShort((short) this.zzA);
                                byteBufferOrder6.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i16);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac6 = zzakVar.zzac();
                zzacs zzacsVarZzw6 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw6;
                zzacsVarZzw6.zzl(zzamVarZzac6);
                return;
            case 8:
                zzacd zzacdVarZza = zzacd.zza(new zzfb(zzi(this.zzb)));
                list = zzacdVarZza.zza;
                this.zzW = zzacdVarZza.zzb;
                str = zzacdVarZza.zzg;
                str5 = "video/hevc";
                i2 = -1;
                iZzk = -1;
                List list3 = list;
                str2 = str;
                listSingletonList = list3;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z7 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i17 = (z7 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder7 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder7.put((byte) 0);
                                byteBufferOrder7.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder7.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder7.putShort((short) this.zzA);
                                byteBufferOrder7.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i17);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac7 = zzakVar.zzac();
                zzacs zzacsVarZzw7 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw7;
                zzacsVarZzw7.zzl(zzamVarZzac7);
                return;
            case 9:
                Pair pairZzf = zzf(new zzfb(zzi(this.zzb)));
                str5 = (String) pairZzf.first;
                listSingletonList = (List) pairZzf.second;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z8 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i18 = (z8 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder8 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder8.put((byte) 0);
                                byteBufferOrder8.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder8.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder8.putShort((short) this.zzA);
                                byteBufferOrder8.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i18);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac8 = zzakVar.zzac();
                zzacs zzacsVarZzw8 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw8;
                zzacsVarZzw8.zzl(zzamVarZzac8);
                return;
            case 10:
                str5 = "video/x-unknown";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z9 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i19 = (z9 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder9 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder9.put((byte) 0);
                                byteBufferOrder9.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder9.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder9.putShort((short) this.zzA);
                                byteBufferOrder9.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i19);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac9 = zzakVar.zzac();
                zzacs zzacsVarZzw9 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw9;
                zzacsVarZzw9.zzl(zzamVarZzac9);
                return;
            case 11:
                i10 = 8192;
                listSingletonList = zzg(zzi(str4));
                str5 = "audio/vorbis";
                str2 = null;
                i2 = i10;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z10 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i110 = (z10 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder10 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder10.put((byte) 0);
                                byteBufferOrder10.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder10.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder10.putShort((short) this.zzA);
                                byteBufferOrder10.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i110);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac10 = zzakVar.zzac();
                zzacs zzacsVarZzw10 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw10;
                zzacsVarZzw10.zzl(zzamVarZzac10);
                return;
            case 12:
                i10 = 5760;
                listSingletonList = new ArrayList(3);
                listSingletonList.add(zzi(this.zzb));
                listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzQ).array());
                listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzR).array());
                str5 = "audio/opus";
                str2 = null;
                i2 = i10;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z11 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i111 = (z11 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder11 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder11.put((byte) 0);
                                byteBufferOrder11.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder11.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder11.putShort((short) this.zzA);
                                byteBufferOrder11.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i111);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac11 = zzakVar.zzac();
                zzacs zzacsVarZzw11 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw11;
                zzacsVarZzw11.zzl(zzamVarZzac11);
                return;
            case 13:
                listSingletonList = Collections.singletonList(zzi(str4));
                zzaaj zzaajVarZza = zzaak.zza(this.zzj);
                this.zzP = zzaajVarZza.zza;
                this.zzN = zzaajVarZza.zzb;
                str2 = zzaajVarZza.zzc;
                str5 = "audio/mp4a-latm";
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z12 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i112 = (z12 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder12 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder12.put((byte) 0);
                                byteBufferOrder12.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder12.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder12.putShort((short) this.zzA);
                                byteBufferOrder12.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i112);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac12 = zzakVar.zzac();
                zzacs zzacsVarZzw12 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw12;
                zzacsVarZzw12.zzl(zzamVarZzac12);
                return;
            case 14:
                str5 = "audio/mpeg-L2";
                listSingletonList = null;
                str2 = null;
                i2 = i10;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z13 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i113 = (z13 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder13 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder13.put((byte) 0);
                                byteBufferOrder13.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder13.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder13.putShort((short) this.zzA);
                                byteBufferOrder13.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i113);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac13 = zzakVar.zzac();
                zzacs zzacsVarZzw13 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw13;
                zzacsVarZzw13.zzl(zzamVarZzac13);
                return;
            case 15:
                str5 = "audio/mpeg";
                listSingletonList = null;
                str2 = null;
                i2 = i10;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z14 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i114 = (z14 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder14 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder14.put((byte) 0);
                                byteBufferOrder14.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder14.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder14.putShort((short) this.zzA);
                                byteBufferOrder14.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i114);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac14 = zzakVar.zzac();
                zzacs zzacsVarZzw14 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw14;
                zzacsVarZzw14.zzl(zzamVarZzac14);
                return;
            case 16:
                str5 = "audio/ac3";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z15 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i115 = (z15 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder15 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder15.put((byte) 0);
                                byteBufferOrder15.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder15.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder15.putShort((short) this.zzA);
                                byteBufferOrder15.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i115);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac15 = zzakVar.zzac();
                zzacs zzacsVarZzw15 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw15;
                zzacsVarZzw15.zzl(zzamVarZzac15);
                return;
            case 17:
                str5 = "audio/eac3";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z16 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i116 = (z16 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder16 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder16.put((byte) 0);
                                byteBufferOrder16.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder16.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder16.putShort((short) this.zzA);
                                byteBufferOrder16.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i116);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac16 = zzakVar.zzac();
                zzacs zzacsVarZzw16 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw16;
                zzacsVarZzw16.zzl(zzamVarZzac16);
                return;
            case 18:
                this.zzS = new zzact();
                str5 = "audio/true-hd";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z17 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i117 = (z17 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder17 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder17.put((byte) 0);
                                byteBufferOrder17.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder17.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder17.putShort((short) this.zzA);
                                byteBufferOrder17.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i117);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac17 = zzakVar.zzac();
                zzacs zzacsVarZzw17 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw17;
                zzacsVarZzw17.zzl(zzamVarZzac17);
                return;
            case 19:
            case 20:
                str5 = "audio/vnd.dts";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z18 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i118 = (z18 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder18 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder18.put((byte) 0);
                                byteBufferOrder18.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder18.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder18.putShort((short) this.zzA);
                                byteBufferOrder18.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i118);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac18 = zzakVar.zzac();
                zzacs zzacsVarZzw18 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw18;
                zzacsVarZzw18.zzl(zzamVarZzac18);
                return;
            case 21:
                str5 = "audio/vnd.dts.hd";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z19 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i119 = (z19 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder19 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder19.put((byte) 0);
                                byteBufferOrder19.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder19.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder19.putShort((short) this.zzA);
                                byteBufferOrder19.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i119);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac19 = zzakVar.zzac();
                zzacs zzacsVarZzw19 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw19;
                zzacsVarZzw19.zzl(zzamVarZzac19);
                return;
            case 22:
                listSingletonList = Collections.singletonList(zzi(str4));
                str5 = "audio/flac";
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z110 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1110 = (z110 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder110 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder110.put((byte) 0);
                                byteBufferOrder110.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder110.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder110.putShort((short) this.zzA);
                                byteBufferOrder110.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1110);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac110 = zzakVar.zzac();
                zzacs zzacsVarZzw110 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw110;
                zzacsVarZzw110.zzl(zzamVarZzac110);
                return;
            case 23:
                if (zzh(new zzfb(zzi(this.zzb)))) {
                    iZzk = zzfk.zzk(this.zzO);
                    if (iZzk == 0) {
                        zzer.zzf("MatroskaExtractor", "Unsupported PCM bit depth: " + this.zzO + ". Setting mimeType to audio/x-unknown");
                    } else {
                        listSingletonList = null;
                        str2 = null;
                        i2 = -1;
                    }
                    if (this.zzM != null) {
                        str2 = zzabiVarZza.zza;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z111 = this.zzU;
                    if (true != this.zzT) {
                        i3 = 0;
                    } else {
                        i3 = 2;
                    }
                    int i1111 = (z111 ? 1 : 0) | i3;
                    zzakVar = new zzak();
                    if (!zzcb.zzf(str3)) {
                        if (zzcb.zzg(str3)) {
                            if (this.zzp == 0) {
                                i6 = this.zzn;
                                iIntValue = -1;
                                if (i6 == -1) {
                                    i6 = this.zzl;
                                }
                                this.zzn = i6;
                                i7 = this.zzo;
                                if (i7 == -1) {
                                    i7 = this.zzm;
                                }
                                this.zzo = i7;
                            } else {
                                iIntValue = -1;
                            }
                            i4 = this.zzn;
                            if (i4 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.zzw) {
                                if (this.zzC != -1.0f) {
                                    bArr = new byte[25];
                                    ByteBuffer byteBufferOrder111 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                    byteBufferOrder111.put((byte) 0);
                                    byteBufferOrder111.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) (this.zzK + 0.5f));
                                    byteBufferOrder111.putShort((short) (this.zzL + 0.5f));
                                    byteBufferOrder111.putShort((short) this.zzA);
                                    byteBufferOrder111.putShort((short) this.zzB);
                                }
                                zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                            }
                            if (this.zza != null) {
                                iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                            }
                            if (this.zzq == 0) {
                                i9 = iIntValue;
                            } else {
                                i9 = iIntValue;
                            }
                            zzakVar.zzab(this.zzl);
                            zzakVar.zzH(this.zzm);
                            zzakVar.zzR(f);
                            zzakVar.zzT(i9);
                            zzakVar.zzS(this.zzu);
                            zzakVar.zzX(this.zzv);
                            zzakVar.zzA(zzsVar);
                            i8 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i8 = 3;
                        }
                        break;
                    } else {
                        zzakVar.zzy(this.zzN);
                        zzakVar.zzV(this.zzP);
                        zzakVar.zzP(iZzk);
                    }
                    if (this.zza != null) {
                        zzakVar.zzL(this.zza);
                    }
                    zzakVar.zzI(i);
                    zzakVar.zzU(str3);
                    zzakVar.zzN(i2);
                    zzakVar.zzM(this.zzY);
                    zzakVar.zzW(i1111);
                    zzakVar.zzK(listSingletonList);
                    zzakVar.zzz(str2);
                    zzakVar.zzD(this.zzk);
                    zzam zzamVarZzac111 = zzakVar.zzac();
                    zzacs zzacsVarZzw111 = zzabpVar.zzw(this.zzc, i8);
                    this.zzV = zzacsVarZzw111;
                    zzacsVarZzw111.zzl(zzamVarZzac111);
                    return;
                }
                zzer.zzf("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                listSingletonList = null;
                str2 = null;
                str5 = "audio/x-unknown";
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z112 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1112 = (z112 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder112 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder112.put((byte) 0);
                                byteBufferOrder112.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder112.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder112.putShort((short) this.zzA);
                                byteBufferOrder112.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1112);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac112 = zzakVar.zzac();
                zzacs zzacsVarZzw112 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw112;
                zzacsVarZzw112.zzl(zzamVarZzac112);
                return;
            case 24:
                iZzk = zzfk.zzk(this.zzO);
                if (iZzk == 0) {
                    zzer.zzf("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.zzO + ". Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str2 = null;
                    str5 = "audio/x-unknown";
                    i2 = -1;
                    iZzk = -1;
                } else {
                    listSingletonList = null;
                    str2 = null;
                    i2 = -1;
                }
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z113 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1113 = (z113 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder113 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder113.put((byte) 0);
                                byteBufferOrder113.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder113.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder113.putShort((short) this.zzA);
                                byteBufferOrder113.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1113);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac113 = zzakVar.zzac();
                zzacs zzacsVarZzw113 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw113;
                zzacsVarZzw113.zzl(zzamVarZzac113);
                return;
            case 25:
                int i20 = this.zzO;
                if (i20 == 8) {
                    iZzk = 3;
                } else if (i20 == 16) {
                    iZzk = 268435456;
                } else if (i20 == 24) {
                    iZzk = 1342177280;
                } else {
                    if (i20 != 32) {
                        zzer.zzf("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + i20 + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str2 = null;
                        str5 = "audio/x-unknown";
                        i2 = -1;
                        iZzk = -1;
                        if (this.zzM != null) {
                            str2 = zzabiVarZza.zza;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        boolean z114 = this.zzU;
                        if (true != this.zzT) {
                            i3 = 0;
                        } else {
                            i3 = 2;
                        }
                        int i1114 = (z114 ? 1 : 0) | i3;
                        zzakVar = new zzak();
                        if (!zzcb.zzf(str3)) {
                            if (zzcb.zzg(str3)) {
                                if (this.zzp == 0) {
                                    i6 = this.zzn;
                                    iIntValue = -1;
                                    if (i6 == -1) {
                                        i6 = this.zzl;
                                    }
                                    this.zzn = i6;
                                    i7 = this.zzo;
                                    if (i7 == -1) {
                                        i7 = this.zzm;
                                    }
                                    this.zzo = i7;
                                } else {
                                    iIntValue = -1;
                                }
                                i4 = this.zzn;
                                if (i4 != iIntValue) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.zzw) {
                                    if (this.zzC != -1.0f) {
                                        bArr = new byte[25];
                                        ByteBuffer byteBufferOrder114 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                        byteBufferOrder114.put((byte) 0);
                                        byteBufferOrder114.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                        byteBufferOrder114.putShort((short) (this.zzK + 0.5f));
                                        byteBufferOrder114.putShort((short) (this.zzL + 0.5f));
                                        byteBufferOrder114.putShort((short) this.zzA);
                                        byteBufferOrder114.putShort((short) this.zzB);
                                    }
                                    zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                                }
                                if (this.zza != null) {
                                    iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                                }
                                if (this.zzq == 0) {
                                    i9 = iIntValue;
                                } else {
                                    i9 = iIntValue;
                                }
                                zzakVar.zzab(this.zzl);
                                zzakVar.zzH(this.zzm);
                                zzakVar.zzR(f);
                                zzakVar.zzT(i9);
                                zzakVar.zzS(this.zzu);
                                zzakVar.zzX(this.zzv);
                                zzakVar.zzA(zzsVar);
                                i8 = 2;
                            } else {
                                if ("application/x-subrip".equals(str3)) {
                                }
                                i8 = 3;
                            }
                            break;
                        } else {
                            zzakVar.zzy(this.zzN);
                            zzakVar.zzV(this.zzP);
                            zzakVar.zzP(iZzk);
                        }
                        if (this.zza != null) {
                            zzakVar.zzL(this.zza);
                        }
                        zzakVar.zzI(i);
                        zzakVar.zzU(str3);
                        zzakVar.zzN(i2);
                        zzakVar.zzM(this.zzY);
                        zzakVar.zzW(i1114);
                        zzakVar.zzK(listSingletonList);
                        zzakVar.zzz(str2);
                        zzakVar.zzD(this.zzk);
                        zzam zzamVarZzac114 = zzakVar.zzac();
                        zzacs zzacsVarZzw114 = zzabpVar.zzw(this.zzc, i8);
                        this.zzV = zzacsVarZzw114;
                        zzacsVarZzw114.zzl(zzamVarZzac114);
                        return;
                    }
                    iZzk = 1610612736;
                }
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z115 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1115 = (z115 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder115 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder115.put((byte) 0);
                                byteBufferOrder115.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder115.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder115.putShort((short) this.zzA);
                                byteBufferOrder115.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1115);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac115 = zzakVar.zzac();
                zzacs zzacsVarZzw115 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw115;
                zzacsVarZzw115.zzl(zzamVarZzac115);
                return;
            case 26:
                int i21 = this.zzO;
                if (i21 == 32) {
                    listSingletonList = null;
                    str2 = null;
                    i2 = -1;
                } else {
                    zzer.zzf("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + i21 + ". Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str2 = null;
                    str5 = "audio/x-unknown";
                    i2 = -1;
                    iZzk = -1;
                }
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z116 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1116 = (z116 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder116 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder116.put((byte) 0);
                                byteBufferOrder116.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder116.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder116.putShort((short) this.zzA);
                                byteBufferOrder116.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1116);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac116 = zzakVar.zzac();
                zzacs zzacsVarZzw116 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw116;
                zzacsVarZzw116.zzl(zzamVarZzac116);
                return;
            case 27:
                str5 = "application/x-subrip";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z117 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1117 = (z117 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder117 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder117.put((byte) 0);
                                byteBufferOrder117.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder117.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder117.putShort((short) this.zzA);
                                byteBufferOrder117.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1117);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac117 = zzakVar.zzac();
                zzacs zzacsVarZzw117 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw117;
                zzacsVarZzw117.zzl(zzamVarZzac117);
                return;
            case 28:
                listSingletonList = zzfvs.zzn(zzagj.zzc, zzi(this.zzb));
                str2 = null;
                str5 = "text/x-ssa";
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z118 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1118 = (z118 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder118 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder118.put((byte) 0);
                                byteBufferOrder118.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder118.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder118.putShort((short) this.zzA);
                                byteBufferOrder118.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1118);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac118 = zzakVar.zzac();
                zzacs zzacsVarZzw118 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw118;
                zzacsVarZzw118.zzl(zzamVarZzac118);
                return;
            case 29:
                str5 = "text/vtt";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z119 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i1119 = (z119 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder119 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder119.put((byte) 0);
                                byteBufferOrder119.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder119.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder119.putShort((short) this.zzA);
                                byteBufferOrder119.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i1119);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac119 = zzakVar.zzac();
                zzacs zzacsVarZzw119 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw119;
                zzacsVarZzw119.zzl(zzamVarZzac119);
                return;
            case 30:
                listSingletonList = zzfvs.zzm(zzi(str4));
                str5 = "application/vobsub";
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1110 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i11110 = (z1110 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1110 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1110.put((byte) 0);
                                byteBufferOrder1110.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder1110.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder1110.putShort((short) this.zzA);
                                byteBufferOrder1110.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i11110);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac1110 = zzakVar.zzac();
                zzacs zzacsVarZzw1110 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw1110;
                zzacsVarZzw1110.zzl(zzamVarZzac1110);
                return;
            case 31:
                str5 = "application/pgs";
                listSingletonList = null;
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1111 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i11111 = (z1111 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1111 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1111.put((byte) 0);
                                byteBufferOrder1111.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder1111.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder1111.putShort((short) this.zzA);
                                byteBufferOrder1111.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i11111);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac1111 = zzakVar.zzac();
                zzacs zzacsVarZzw1111 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw1111;
                zzacsVarZzw1111.zzl(zzamVarZzac1111);
                return;
            case 32:
                byte[] bArr3 = new byte[4];
                System.arraycopy(zzi(str4), 0, bArr3, 0, 4);
                listSingletonList = zzfvs.zzm(bArr3);
                str5 = "application/dvbsubs";
                str2 = null;
                i2 = -1;
                iZzk = -1;
                if (this.zzM != null) {
                    str2 = zzabiVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1112 = this.zzU;
                if (true != this.zzT) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
                int i11112 = (z1112 ? 1 : 0) | i3;
                zzakVar = new zzak();
                if (!zzcb.zzf(str3)) {
                    if (zzcb.zzg(str3)) {
                        if (this.zzp == 0) {
                            i6 = this.zzn;
                            iIntValue = -1;
                            if (i6 == -1) {
                                i6 = this.zzl;
                            }
                            this.zzn = i6;
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzm;
                            }
                            this.zzo = i7;
                        } else {
                            iIntValue = -1;
                        }
                        i4 = this.zzn;
                        if (i4 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzw) {
                            if (this.zzC != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1112 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1112.put((byte) 0);
                                byteBufferOrder1112.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1112.putShort((short) (this.zzK + 0.5f));
                                byteBufferOrder1112.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder1112.putShort((short) this.zzA);
                                byteBufferOrder1112.putShort((short) this.zzB);
                            }
                            zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr);
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzagj.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzq == 0) {
                            i9 = iIntValue;
                        } else {
                            i9 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzH(this.zzm);
                        zzakVar.zzR(f);
                        zzakVar.zzT(i9);
                        zzakVar.zzS(this.zzu);
                        zzakVar.zzX(this.zzv);
                        zzakVar.zzA(zzsVar);
                        i8 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i8 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzN);
                    zzakVar.zzV(this.zzP);
                    zzakVar.zzP(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzL(this.zza);
                }
                zzakVar.zzI(i);
                zzakVar.zzU(str3);
                zzakVar.zzN(i2);
                zzakVar.zzM(this.zzY);
                zzakVar.zzW(i11112);
                zzakVar.zzK(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzD(this.zzk);
                zzam zzamVarZzac1112 = zzakVar.zzac();
                zzacs zzacsVarZzw1112 = zzabpVar.zzw(this.zzc, i8);
                this.zzV = zzacsVarZzw1112;
                zzacsVarZzw1112.zzl(zzamVarZzac1112);
                return;
            default:
                throw zzcc.zza("Unrecognized codec identifier.", null);
        }
    }
}

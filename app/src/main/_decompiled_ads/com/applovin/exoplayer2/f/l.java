package com.applovin.exoplayer2.f;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    private static final Pattern IS = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<i>> IT = new HashMap<>();
    private static int IU = -1;

    private interface c {
        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        MediaCodecInfo dd(int i);

        int kA();

        boolean kB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface f<T> {
        int getScore(T t);
    }

    private static int cW(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int cX(int i) {
        if (i == 66) {
            return 1;
        }
        if (i == 77) {
            return 2;
        }
        if (i == 88) {
            return 4;
        }
        if (i == 100) {
            return 8;
        }
        if (i == 110) {
            return 16;
        }
        if (i != 122) {
            return i != 244 ? -1 : 64;
        }
        return 32;
    }

    private static int cY(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int cZ(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? -1 : 8;
        }
        return 4;
    }

    private static int da(int i) {
        if (i == 10) {
            return 1;
        }
        if (i == 11) {
            return 2;
        }
        if (i == 20) {
            return 4;
        }
        if (i == 21) {
            return 8;
        }
        if (i == 30) {
            return 16;
        }
        if (i == 31) {
            return 32;
        }
        if (i == 40) {
            return 64;
        }
        if (i == 41) {
            return 128;
        }
        if (i == 50) {
            return 256;
        }
        if (i == 51) {
            return 512;
        }
        switch (i) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int db(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int dc(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 20;
            if (i != 20) {
                i2 = 23;
                if (i != 23) {
                    i2 = 29;
                    if (i != 29) {
                        i2 = 39;
                        if (i != 39) {
                            i2 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public static class b extends Exception {
        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public static i ky() throws b {
        return a("audio/raw", false, false);
    }

    public static i a(String str, boolean z, boolean z2) throws b {
        List<i> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<i> getDecoderInfos(String str, boolean z, boolean z2) throws b {
        c dVar;
        a aVar = new a(str, z, z2);
        HashMap<a, List<i>> map = IT;
        List<i> list = map.get(aVar);
        if (list != null) {
            return list;
        }
        if (ai.acV >= 21) {
            dVar = new e(z, z2);
        } else {
            dVar = new d();
        }
        ArrayList<i> arrayListA = a(aVar, dVar);
        if (z && arrayListA.isEmpty() && 21 <= ai.acV && ai.acV <= 23) {
            arrayListA = a(aVar, new d());
            if (!arrayListA.isEmpty()) {
                q.h("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListA.get(0).name);
            }
        }
        a(str, arrayListA);
        List<i> listUnmodifiableList = Collections.unmodifiableList(arrayListA);
        map.put(aVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static List<i> a(List<i> list, final v vVar) {
        ArrayList arrayList = new ArrayList(list);
        a(arrayList, new f() { // from class: com.applovin.exoplayer2.f.-$$Lambda$l$-pbCzwY13BomNDzTFMzIZWgX7a4
            @Override // com.applovin.exoplayer2.f.l.f
            public final int getScore(Object obj) {
                return l.a(vVar, (i) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(v vVar, i iVar) {
        try {
            return iVar.l(vVar) ? 1 : 0;
        } catch (b unused) {
            return -1;
        }
    }

    public static int kz() throws b {
        if (IU == -1) {
            int iMax = 0;
            i iVarA = a("video/avc", false, false);
            if (iVarA != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrJV = iVarA.jV();
                int length = codecProfileLevelArrJV.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(cW(codecProfileLevelArrJV[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, ai.acV >= 21 ? 345600 : 172800);
            }
            IU = iMax;
        }
        return IU;
    }

    public static Pair<Integer, Integer> r(v vVar) {
        if (vVar.dw == null) {
            return null;
        }
        String[] strArrSplit = vVar.dw.split("\\.");
        if ("video/dolby-vision".equals(vVar.dz)) {
            return a(vVar.dw, strArrSplit);
        }
        byte b2 = 0;
        String str = strArrSplit[0];
        str.hashCode();
        switch (str.hashCode()) {
            case 3004662:
                if (!str.equals("av01")) {
                    b2 = -1;
                }
                break;
            case 3006243:
                b2 = !str.equals("avc1") ? (byte) -1 : (byte) 1;
                break;
            case 3006244:
                b2 = !str.equals("avc2") ? (byte) -1 : (byte) 2;
                break;
            case 3199032:
                b2 = !str.equals("hev1") ? (byte) -1 : (byte) 3;
                break;
            case 3214780:
                b2 = !str.equals("hvc1") ? (byte) -1 : (byte) 4;
                break;
            case 3356560:
                b2 = !str.equals("mp4a") ? (byte) -1 : (byte) 5;
                break;
            case 3624515:
                b2 = !str.equals("vp09") ? (byte) -1 : (byte) 6;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                return a(vVar.dw, strArrSplit, vVar.dK);
            case 1:
            case 2:
                return c(vVar.dw, strArrSplit);
            case 3:
            case 4:
                return b(vVar.dw, strArrSplit);
            case 5:
                return e(vVar.dw, strArrSplit);
            case 6:
                return d(vVar.dw, strArrSplit);
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:59:0x0107 A[Catch: Exception -> 0x015d, TRY_ENTER, TryCatch #1 {Exception -> 0x015d, blocks: (B:3:0x0008, B:5:0x001b, B:62:0x0129, B:8:0x002d, B:11:0x0038, B:56:0x00ff, B:59:0x0107, B:61:0x010d, B:63:0x0133, B:64:0x015b), top: B:71:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:83:0x0133 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private static ArrayList<i> a(a aVar, c cVar) throws b {
        String strA;
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        a aVar2 = aVar;
        try {
            ArrayList<i> arrayList = new ArrayList<>();
            String str3 = aVar2.eg;
            int iKA = cVar.kA();
            boolean zKB = cVar.kB();
            int i3 = 0;
            while (i3 < iKA) {
                MediaCodecInfo mediaCodecInfoDd = cVar.dd(i3);
                if (a(mediaCodecInfoDd)) {
                    i = i3;
                    z = zKB;
                    i2 = iKA;
                } else {
                    String name = mediaCodecInfoDd.getName();
                    if (a(mediaCodecInfoDd, name, zKB, str3) && (strA = a(mediaCodecInfoDd, name, str3)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoDd.getCapabilitiesForType(strA);
                            boolean zA = cVar.a("tunneled-playback", strA, capabilitiesForType);
                            boolean zB = cVar.b("tunneled-playback", strA, capabilitiesForType);
                            if ((aVar2.hi || !zB) && (!aVar2.hi || zA)) {
                                boolean zA2 = cVar.a("secure-playback", strA, capabilitiesForType);
                                boolean zB2 = cVar.b("secure-playback", strA, capabilitiesForType);
                                if ((aVar2.Hu || !zB2) && (!aVar2.Hu || zA2)) {
                                    boolean zC = c(mediaCodecInfoDd);
                                    boolean zE = e(mediaCodecInfoDd);
                                    boolean zG = g(mediaCodecInfoDd);
                                    if (zKB && aVar2.Hu == zA2) {
                                        str = strA;
                                        i = i3;
                                        z = zKB;
                                        i2 = iKA;
                                        arrayList.add(i.a(name, str3, strA, capabilitiesForType, zC, zE, zG, false, false));
                                    } else if (zKB) {
                                        str = strA;
                                        i = i3;
                                        z = zKB;
                                        i2 = iKA;
                                        if (!z) {
                                            continue;
                                        }
                                    } else {
                                        try {
                                            if (aVar2.Hu) {
                                                str = strA;
                                                i = i3;
                                                z = zKB;
                                                i2 = iKA;
                                                if (!z && zA2) {
                                                    try {
                                                        str2 = name;
                                                        try {
                                                            arrayList.add(i.a(name + ".secure", str3, str, capabilitiesForType, zC, zE, zG, false, true));
                                                            return arrayList;
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            if (ai.acV > 23 && !arrayList.isEmpty()) {
                                                                q.i("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                                i3 = i + 1;
                                                                aVar2 = aVar;
                                                                iKA = i2;
                                                                zKB = z;
                                                            } else {
                                                                q.i("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                                throw e;
                                                            }
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        str2 = name;
                                                    }
                                                }
                                            } else {
                                                str = strA;
                                                i = i3;
                                                z = zKB;
                                                i2 = iKA;
                                                try {
                                                    arrayList.add(i.a(name, str3, strA, capabilitiesForType, zC, zE, zG, false, false));
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    str2 = name;
                                                    if (ai.acV > 23) {
                                                    }
                                                    q.i("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                    throw e;
                                                }
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            str = strA;
                                            i = i3;
                                            z = zKB;
                                            i2 = iKA;
                                            str2 = name;
                                            if (ai.acV > 23) {
                                            }
                                            q.i("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                            throw e;
                                        }
                                    }
                                } else {
                                    i = i3;
                                    z = zKB;
                                    i2 = iKA;
                                }
                            } else {
                                i = i3;
                                z = zKB;
                                i2 = iKA;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = strA;
                            str2 = name;
                            i = i3;
                            z = zKB;
                            i2 = iKA;
                        }
                    } else {
                        i = i3;
                        z = zKB;
                        i2 = iKA;
                    }
                }
                i3 = i + 1;
                aVar2 = aVar;
                iKA = i2;
                zKB = z;
            }
            return arrayList;
        } catch (Exception e7) {
            throw new b(e7);
        }
    }

    private static String a(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (ai.acV < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (ai.acV < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(ai.acW) || ("Xiaomi".equals(ai.acX) && ai.acW.startsWith("HM")))) {
            return false;
        }
        if (ai.acV == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(ai.acW) || "protou".equals(ai.acW) || "ville".equals(ai.acW) || "villeplus".equals(ai.acW) || "villec2".equals(ai.acW) || ai.acW.startsWith("gee") || "C6602".equals(ai.acW) || "C6603".equals(ai.acW) || "C6606".equals(ai.acW) || "C6616".equals(ai.acW) || "L36h".equals(ai.acW) || "SO-02E".equals(ai.acW))) {
            return false;
        }
        if (ai.acV == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(ai.acW) || "C1505".equals(ai.acW) || "C1604".equals(ai.acW) || "C1605".equals(ai.acW))) {
            return false;
        }
        if (ai.acV < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(ai.acX) && (ai.acW.startsWith("zeroflte") || ai.acW.startsWith("zerolte") || ai.acW.startsWith("zenlte") || "SC-05G".equals(ai.acW) || "marinelteatt".equals(ai.acW) || "404SC".equals(ai.acW) || "SC-04G".equals(ai.acW) || "SCV31".equals(ai.acW)))) {
            return false;
        }
        if (ai.acV <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(ai.acX) && (ai.acW.startsWith("d2") || ai.acW.startsWith("serrano") || ai.acW.startsWith("jflte") || ai.acW.startsWith("santos") || ai.acW.startsWith("t0"))) {
            return false;
        }
        if (ai.acV <= 19 && ai.acW.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static void a(String str, List<i> list) {
        if ("audio/raw".equals(str)) {
            if (ai.acV < 26 && ai.acW.equals("R9") && list.size() == 1 && list.get(0).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(i.a("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            a(list, new f() { // from class: com.applovin.exoplayer2.f.-$$Lambda$l$BksAqb0rZGkejkBVAXAbJxdePmQ
                @Override // com.applovin.exoplayer2.f.l.f
                public final int getScore(Object obj) {
                    return l.d((i) obj);
                }
            });
        }
        if (ai.acV < 21 && list.size() > 1) {
            String str2 = list.get(0).name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                a(list, new f() { // from class: com.applovin.exoplayer2.f.-$$Lambda$l$Ifz3Prmm0fXo22zTD61_tZMhITc
                    @Override // com.applovin.exoplayer2.f.l.f
                    public final int getScore(Object obj) {
                        return l.c((i) obj);
                    }
                });
            }
        }
        if (ai.acV >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).name)) {
            return;
        }
        list.add(list.remove(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int d(i iVar) {
        String str = iVar.name;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (ai.acV >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(i iVar) {
        return iVar.name.startsWith("OMX.google") ? 1 : 0;
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        return ai.acV >= 29 && b(mediaCodecInfo);
    }

    private static boolean b(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean c(MediaCodecInfo mediaCodecInfo) {
        if (ai.acV >= 29) {
            return d(mediaCodecInfo);
        }
        return !e(mediaCodecInfo);
    }

    private static boolean d(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean e(MediaCodecInfo mediaCodecInfo) {
        if (ai.acV >= 29) {
            return f(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || (lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
    }

    private static boolean f(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean g(MediaCodecInfo mediaCodecInfo) {
        if (ai.acV >= 29) {
            return h(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        return (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) ? false : true;
    }

    private static boolean h(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        if (strArr.length < 3) {
            q.h("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = IS.matcher(strArr[1]);
        if (!matcher.matches()) {
            q.h("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numX = X(strGroup);
        if (numX == null) {
            q.h("MediaCodecUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numY = Y(str2);
        if (numY == null) {
            q.h("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
            return null;
        }
        return new Pair<>(numX, numY);
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        if (strArr.length < 4) {
            q.h("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = IS.matcher(strArr[1]);
        if (!matcher.matches()) {
            q.h("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                q.h("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i = 2;
        }
        String str2 = strArr[3];
        Integer numW = W(str2);
        if (numW == null) {
            q.h("MediaCodecUtil", "Unknown HEVC level string: " + str2);
            return null;
        }
        return new Pair<>(Integer.valueOf(i), numW);
    }

    private static Pair<Integer, Integer> c(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            q.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i2 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int i3 = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
                i2 = i3;
            } else {
                q.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int iCX = cX(i2);
            if (iCX == -1) {
                q.h("MediaCodecUtil", "Unknown AVC profile: " + i2);
                return null;
            }
            int iCY = cY(i);
            if (iCY == -1) {
                q.h("MediaCodecUtil", "Unknown AVC level: " + i);
                return null;
            }
            return new Pair<>(Integer.valueOf(iCX), Integer.valueOf(iCY));
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static Pair<Integer, Integer> d(String str, String[] strArr) {
        if (strArr.length < 3) {
            q.h("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int iCZ = cZ(i);
            if (iCZ == -1) {
                q.h("MediaCodecUtil", "Unknown VP9 profile: " + i);
                return null;
            }
            int iDa = da(i2);
            if (iDa == -1) {
                q.h("MediaCodecUtil", "Unknown VP9 level: " + i2);
                return null;
            }
            return new Pair<>(Integer.valueOf(iCZ), Integer.valueOf(iDa));
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr, com.applovin.exoplayer2.m.b bVar) {
        if (strArr.length < 4) {
            q.h("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i = 1;
        try {
            int i2 = Integer.parseInt(strArr[1]);
            int i3 = Integer.parseInt(strArr[2].substring(0, 2));
            int i4 = Integer.parseInt(strArr[3]);
            if (i2 != 0) {
                q.h("MediaCodecUtil", "Unknown AV1 profile: " + i2);
                return null;
            }
            if (i4 != 8 && i4 != 10) {
                q.h("MediaCodecUtil", "Unknown AV1 bit depth: " + i4);
                return null;
            }
            if (i4 != 8) {
                i = (bVar == null || !(bVar.adl != null || bVar.yk == 7 || bVar.yk == 6)) ? 2 : 4096;
            }
            int iDb = db(i3);
            if (iDb == -1) {
                q.h("MediaCodecUtil", "Unknown AV1 level: " + i3);
                return null;
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(iDb));
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static Pair<Integer, Integer> e(String str, String[] strArr) {
        int iDc;
        if (strArr.length != 3) {
            q.h("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(u.fv(Integer.parseInt(strArr[1], 16))) && (iDc = dc(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(iDc), 0);
            }
        } catch (NumberFormatException unused) {
            q.h("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(f fVar, Object obj, Object obj2) {
        return fVar.getScore(obj2) - fVar.getScore(obj);
    }

    private static <T> void a(List<T> list, final f<T> fVar) {
        Collections.sort(list, new Comparator() { // from class: com.applovin.exoplayer2.f.-$$Lambda$l$fe_Su_TVyvUdCLVK6FSH4dvaoFw
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return l.a(fVar, obj, obj2);
            }
        });
    }

    private static final class e implements c {
        private final int IV;
        private MediaCodecInfo[] IW;

        @Override // com.applovin.exoplayer2.f.l.c
        public boolean kB() {
            return true;
        }

        public e(boolean z, boolean z2) {
            this.IV = (z || z2) ? 1 : 0;
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public int kA() {
            kC();
            return this.IW.length;
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public MediaCodecInfo dd(int i) {
            kC();
            return this.IW[i];
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        private void kC() {
            if (this.IW == null) {
                this.IW = new MediaCodecList(this.IV).getCodecInfos();
            }
        }
    }

    private static final class d implements c {
        @Override // com.applovin.exoplayer2.f.l.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public boolean kB() {
            return false;
        }

        private d() {
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public int kA() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public MediaCodecInfo dd(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.applovin.exoplayer2.f.l.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }
    }

    private static final class a {
        public final boolean Hu;
        public final String eg;
        public final boolean hi;

        public a(String str, boolean z, boolean z2) {
            this.eg = str;
            this.Hu = z;
            this.hi = z2;
        }

        public int hashCode() {
            return ((((this.eg.hashCode() + 31) * 31) + (this.Hu ? 1231 : 1237)) * 31) + (this.hi ? 1231 : 1237);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.eg, aVar.eg) && this.Hu == aVar.Hu && this.hi == aVar.hi;
        }
    }

    private static Integer W(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "H30":
                return 2;
            case "H60":
                return 8;
            case "H63":
                return 32;
            case "H90":
                return 128;
            case "H93":
                return 512;
            case "L30":
                return 1;
            case "L60":
                return 4;
            case "L63":
                return 16;
            case "L90":
                return 64;
            case "L93":
                return 256;
            case "H120":
                return 2048;
            case "H123":
                return 8192;
            case "H150":
                return 32768;
            case "H153":
                return 131072;
            case "H156":
                return 524288;
            case "H180":
                return 2097152;
            case "H183":
                return 8388608;
            case "H186":
                return 33554432;
            case "L120":
                return 1024;
            case "L123":
                return 4096;
            case "L150":
                return 16384;
            case "L153":
                return 65536;
            case "L156":
                return 262144;
            case "L180":
                return 1048576;
            case "L183":
                return 4194304;
            case "L186":
                return 16777216;
            default:
                return null;
        }
    }

    private static Integer X(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "00":
                return 1;
            case "01":
                return 2;
            case "02":
                return 4;
            case "03":
                return 8;
            case "04":
                return 16;
            case "05":
                return 32;
            case "06":
                return 64;
            case "07":
                return 128;
            case "08":
                return 256;
            case "09":
                return 512;
            default:
                return null;
        }
    }

    private static Integer Y(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "01":
                return 1;
            case "02":
                return 2;
            case "03":
                return 4;
            case "04":
                return 8;
            case "05":
                return 16;
            case "06":
                return 32;
            case "07":
                return 64;
            case "08":
                return 128;
            case "09":
                return 256;
            case "10":
                return 512;
            case "11":
                return 1024;
            case "12":
                return 2048;
            case "13":
                return 4096;
            default:
                return null;
        }
    }
}

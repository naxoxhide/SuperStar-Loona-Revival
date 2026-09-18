package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final SparseIntArray d;
    public static final SparseIntArray e;
    public static final Map<String, Integer> f;
    public static final com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a = new com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a("OMX.google.raw.decoder", null, null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f1159b = Pattern.compile("^\\D?(\\d+)$");
    public static final HashMap<a, List<com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a>> c = new HashMap<>();
    public static int g = -1;

    public static final class a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1160b;

        public a(String str, boolean z) {
            this.a = str;
            this.f1160b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.a, aVar.a) && this.f1160b == aVar.f1160b;
        }

        public int hashCode() {
            String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f1160b ? 1231 : 1237);
        }
    }

    public static class b extends Exception {
        public b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public interface c {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d$d, reason: collision with other inner class name */
    public static final class C0293d implements c {
        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public boolean b() {
            return false;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    public static final class e implements c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaCodecInfo[] f1161b;

        public e(boolean z) {
            this.a = z ? 1 : 0;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public boolean b() {
            return true;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public int a() {
            if (this.f1161b == null) {
                this.f1161b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.f1161b.length;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.c
        public MediaCodecInfo a(int i) {
            if (this.f1161b == null) {
                this.f1161b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.f1161b[i];
        }
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a(String str, boolean z) throws b {
        List<com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a> listUnmodifiableList;
        synchronized (d.class) {
            a aVar = new a(str, z);
            listUnmodifiableList = c.get(aVar);
            if (listUnmodifiableList == null) {
                int i = u.a;
                List<com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a> listA = a(aVar, i >= 21 ? new e(z) : new C0293d());
                if (z && ((ArrayList) listA).isEmpty() && 21 <= i && i <= 23) {
                    listA = a(aVar, new C0293d());
                    ArrayList arrayList = (ArrayList) listA;
                    if (!arrayList.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a) arrayList.get(0)).a);
                    }
                }
                if (i < 26) {
                    if (listA.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(listA.get(0).a)) {
                        for (int i2 = 1; i2 < listA.size(); i2++) {
                            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar2 = listA.get(i2);
                            if ("OMX.google.raw.decoder".equals(aVar2.a)) {
                                listA.remove(i2);
                                listA.add(0, aVar2);
                                break;
                            }
                        }
                    }
                }
                listUnmodifiableList = Collections.unmodifiableList(listA);
                c.put(aVar, listUnmodifiableList);
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            return null;
        }
        return listUnmodifiableList.get(0);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        f = map;
        map.put("L30", 1);
        map.put("L60", 4);
        map.put("L63", 16);
        map.put("L90", 64);
        map.put("L93", 256);
        map.put("L120", 1024);
        map.put("L123", 4096);
        map.put("L150", 16384);
        map.put("L153", 65536);
        map.put("L156", 262144);
        map.put("L180", 1048576);
        map.put("L183", 4194304);
        map.put("L186", 16777216);
        map.put("H30", 2);
        map.put("H60", 8);
        map.put("H63", 32);
        map.put("H90", 128);
        map.put("H93", 512);
        map.put("H120", 2048);
        map.put("H123", 8192);
        map.put("H150", 32768);
        map.put("H153", 131072);
        map.put("H156", 524288);
        map.put("H180", 2097152);
        map.put("H183", 8388608);
        map.put("H186", 33554432);
    }

    public static int a() throws b {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i;
        if (g == -1) {
            int iMax = 0;
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVarA = a("video/avc", false);
            if (aVarA != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = aVarA.e;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArr[iMax].level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, u.a >= 21 ? 345600 : 172800);
            }
            g = iMax;
        }
        return g;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0066  */
    public static List<com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a> a(a aVar, c cVar) throws b {
        boolean z;
        try {
            ArrayList arrayList = new ArrayList();
            String str = aVar.a;
            int iA = cVar.a();
            boolean zB = cVar.b();
            for (int i = 0; i < iA; i++) {
                MediaCodecInfo mediaCodecInfoA = cVar.a(i);
                String name = mediaCodecInfoA.getName();
                if (a(mediaCodecInfoA, name, zB)) {
                    String[] supportedTypes = mediaCodecInfoA.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str2 = supportedTypes[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(str2);
                                boolean zA = cVar.a(str, capabilitiesForType);
                                if (u.a <= 22) {
                                    String str3 = u.d;
                                    if ((str3.equals("ODROID-XU3") || str3.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = false;
                                }
                                if ((zB && aVar.f1160b == zA) || !(zB || aVar.f1160b)) {
                                    arrayList.add(new com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a(name, str, capabilitiesForType, z));
                                } else if (!zB && zA) {
                                    arrayList.add(new com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a(name + ".secure", str, capabilitiesForType, z));
                                    return arrayList;
                                }
                            } catch (Exception e2) {
                                if (u.a <= 23 && !arrayList.isEmpty()) {
                                    Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                } else {
                                    Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str2 + ")");
                                    throw e2;
                                }
                            }
                        }
                        i2++;
                        cVar = cVar;
                    }
                }
            }
            return arrayList;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    public static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = u.a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(u.f1242b)) {
            return false;
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str2 = u.f1242b;
            if ("dlxu".equals(str2) || "protou".equals(str2) || "ville".equals(str2) || "villeplus".equals(str2) || "villec2".equals(str2) || str2.startsWith("gee") || "C6602".equals(str2) || "C6603".equals(str2) || "C6606".equals(str2) || "C6616".equals(str2) || "L36h".equals(str2) || "SO-02E".equals(str2)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str3 = u.f1242b;
            if ("C1504".equals(str3) || "C1505".equals(str3) || "C1604".equals(str3) || "C1605".equals(str3)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(u.c)) {
            String str4 = u.f1242b;
            if (str4.startsWith("d2") || str4.startsWith("serrano") || str4.startsWith("jflte") || str4.startsWith("santos") || str4.startsWith("t0")) {
                return false;
            }
        }
        return (i <= 19 && u.f1242b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
    }
}

package com.applovin.exoplayer2.l;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    private static final ArrayList<a> acl = new ArrayList<>();
    private static final Pattern acm = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    private static final class a {
        public final int V;
        public final String acn;
        public final String eg;
    }

    public static String fv(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static boolean aW(String str) {
        return "audio".equals(bc(str));
    }

    public static boolean aX(String str) {
        return "video".equals(bc(str));
    }

    public static boolean aY(String str) {
        return "text".equals(bc(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean j(String str, String str2) {
        b bVarBf;
        int iPb;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/ac3":
            case "audio/raw":
            case "audio/eac3":
            case "audio/flac":
            case "audio/mpeg":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
                return true;
            case "audio/mp4a-latm":
                return (str2 == null || (bVarBf = bf(str2)) == null || (iPb = bVarBf.pb()) == 0 || iPb == 16) ? false : true;
            default:
                return false;
        }
    }

    public static String aZ(String str) {
        b bVarBf;
        String strFv = null;
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.startsWith("avc1") || lowerCase.startsWith("avc3")) {
            return "video/avc";
        }
        if (lowerCase.startsWith("hev1") || lowerCase.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (lowerCase.startsWith("dvav") || lowerCase.startsWith("dva1") || lowerCase.startsWith("dvhe") || lowerCase.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (lowerCase.startsWith("av01")) {
            return MimeTypes.VIDEO_AV1;
        }
        if (lowerCase.startsWith("vp9") || lowerCase.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (lowerCase.startsWith("vp8") || lowerCase.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (lowerCase.startsWith("mp4a")) {
            if (lowerCase.startsWith("mp4a.") && (bVarBf = bf(lowerCase)) != null) {
                strFv = fv(bVarBf.aco);
            }
            return strFv == null ? "audio/mp4a-latm" : strFv;
        }
        if (lowerCase.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (lowerCase.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (lowerCase.startsWith("ac-3") || lowerCase.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (lowerCase.startsWith("ec-3") || lowerCase.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (lowerCase.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (lowerCase.startsWith("ac-4") || lowerCase.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (lowerCase.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (lowerCase.startsWith("dtse")) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (lowerCase.startsWith("dtsh") || lowerCase.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (lowerCase.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (lowerCase.startsWith("opus")) {
            return "audio/opus";
        }
        if (lowerCase.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (lowerCase.startsWith("flac")) {
            return "audio/flac";
        }
        if (lowerCase.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (lowerCase.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (lowerCase.contains("cea708")) {
            return "application/cea-708";
        }
        return (lowerCase.contains("eia608") || lowerCase.contains("cea608")) ? "application/cea-608" : bd(lowerCase);
    }

    public static int ba(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (aW(str)) {
            return 1;
        }
        if (aX(str)) {
            return 2;
        }
        if (aY(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return be(str);
    }

    public static int k(String str, String str2) {
        b bVarBf;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (bVarBf = bf(str2)) == null) {
                    return 0;
                }
                return bVarBf.pb();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String bb(String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return "audio/flac";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return str;
        }
    }

    private static String bc(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    private static String bd(String str) {
        int size = acl.size();
        for (int i = 0; i < size; i++) {
            a aVar = acl.get(i);
            if (str.startsWith(aVar.acn)) {
                return aVar.eg;
            }
        }
        return null;
    }

    private static int be(String str) {
        int size = acl.size();
        for (int i = 0; i < size; i++) {
            a aVar = acl.get(i);
            if (str.equals(aVar.eg)) {
                return aVar.V;
            }
        }
        return -1;
    }

    static b bf(String str) {
        Matcher matcher = acm.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new b(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static final class b {
        public final int aco;
        public final int acp;

        public b(int i, int i2) {
            this.aco = i;
            this.acp = i2;
        }

        public int pb() {
            int i = this.acp;
            if (i == 2) {
                return 10;
            }
            if (i == 5) {
                return 11;
            }
            if (i == 29) {
                return 12;
            }
            if (i == 42) {
                return 16;
            }
            if (i != 22) {
                return i != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }
}

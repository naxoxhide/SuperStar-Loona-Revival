package com.applovin.exoplayer2.i.e;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class c {
    public final boolean Pn;
    public final int RC;
    public final Integer RD;
    public final float RE;
    public final boolean RF;
    public final boolean RG;
    public final boolean RH;
    public final String name;

    private static boolean eA(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private c(String str, int i, Integer num, float f, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.RC = i;
        this.RD = num;
        this.RE = f;
        this.RF = z;
        this.RG = z2;
        this.Pn = z3;
        this.RH = z4;
    }

    public static c a(String str, a aVar) {
        com.applovin.exoplayer2.l.a.checkArgument(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        if (strArrSplit.length != aVar.fR) {
            q.h("SsaStyle", ai.a("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(aVar.fR), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            return new c(strArrSplit[aVar.RI].trim(), aVar.RJ != -1 ? ad(strArrSplit[aVar.RJ].trim()) : -1, aVar.RK != -1 ? ae(strArrSplit[aVar.RK].trim()) : null, aVar.RL != -1 ? af(strArrSplit[aVar.RL].trim()) : -3.4028235E38f, aVar.RM != -1 && ag(strArrSplit[aVar.RM].trim()), aVar.RN != -1 && ag(strArrSplit[aVar.RN].trim()), aVar.RO != -1 && ag(strArrSplit[aVar.RO].trim()), aVar.RP != -1 && ag(strArrSplit[aVar.RP].trim()));
        } catch (RuntimeException e) {
            q.b("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ad(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            if (eA(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        q.h("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static Integer ae(String str) {
        long j;
        try {
            if (str.startsWith("&H")) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            com.applovin.exoplayer2.l.a.checkArgument(j <= 4294967295L);
            return Integer.valueOf(Color.argb(com.applovin.exoplayer2.common.b.c.ad(((j >> 24) & 255) ^ 255), com.applovin.exoplayer2.common.b.c.ad(j & 255), com.applovin.exoplayer2.common.b.c.ad((j >> 8) & 255), com.applovin.exoplayer2.common.b.c.ad((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            q.b("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    private static float af(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            q.b("SsaStyle", "Failed to parse font size: '" + str + "'", e);
            return -3.4028235E38f;
        }
    }

    private static boolean ag(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            q.b("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }

    static final class a {
        public final int RI;
        public final int RJ;
        public final int RK;
        public final int RL;
        public final int RM;
        public final int RN;
        public final int RO;
        public final int RP;
        public final int fR;

        private a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.RI = i;
            this.RJ = i2;
            this.RK = i3;
            this.RL = i4;
            this.RM = i5;
            this.RN = i6;
            this.RO = i7;
            this.RP = i8;
            this.fR = i9;
        }

        public static a ai(String str) {
            String[] strArrSplit = TextUtils.split(str.substring(7), ",");
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            for (int i9 = 0; i9 < strArrSplit.length; i9++) {
                String lowerCase = Ascii.toLowerCase(strArrSplit[i9].trim());
                lowerCase.hashCode();
                switch (lowerCase) {
                    case "italic":
                        i6 = i9;
                        break;
                    case "underline":
                        i7 = i9;
                        break;
                    case "strikeout":
                        i8 = i9;
                        break;
                    case "primarycolour":
                        i3 = i9;
                        break;
                    case "bold":
                        i5 = i9;
                        break;
                    case "name":
                        i = i9;
                        break;
                    case "fontsize":
                        i4 = i9;
                        break;
                    case "alignment":
                        i2 = i9;
                        break;
                }
            }
            if (i != -1) {
                return new a(i, i2, i3, i4, i5, i6, i7, i8, strArrSplit.length);
            }
            return null;
        }
    }

    static final class b {
        private static final Pattern RQ = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern RR = Pattern.compile(ai.a("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern RT = Pattern.compile(ai.a("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern RU = Pattern.compile("\\\\an(\\d+)");
        public final int RC;
        public final PointF RV;

        private b(int i, PointF pointF) {
            this.RC = i;
            this.RV = pointF;
        }

        public static b aj(String str) {
            Matcher matcher = RQ.matcher(str);
            PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                String str2 = (String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1));
                try {
                    PointF pointFAl = al(str2);
                    if (pointFAl != null) {
                        pointF = pointFAl;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iAm = am(str2);
                    if (iAm != -1) {
                        i = iAm;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i, pointF);
        }

        public static String ak(String str) {
            return RQ.matcher(str).replaceAll("");
        }

        private static PointF al(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = RR.matcher(str);
            Matcher matcher2 = RT.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    q.g("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) com.applovin.exoplayer2.l.a.checkNotNull(strGroup)).trim()), Float.parseFloat(((String) com.applovin.exoplayer2.l.a.checkNotNull(strGroup2)).trim()));
        }

        private static int am(String str) {
            Matcher matcher = RU.matcher(str);
            if (matcher.find()) {
                return c.ad((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1)));
            }
            return -1;
        }
    }
}

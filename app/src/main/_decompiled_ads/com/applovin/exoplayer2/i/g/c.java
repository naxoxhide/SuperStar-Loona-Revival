package com.applovin.exoplayer2.i.g;

import android.text.Layout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.aj;
import com.applovin.exoplayer2.l.q;
import com.facebook.appevents.integrity.IntegrityManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.applovin.exoplayer2.i.d {
    private static final Pattern Si = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern Sj = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern Sk = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern Sl = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern Sm = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern Sn = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern So = Pattern.compile("^(\\d+) (\\d+)$");
    private static final b Sp = new b(30.0f, 1, 1);
    private static final a Sq = new a(32, 15);
    private final XmlPullParserFactory Sr;

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.Sr = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    @Override // com.applovin.exoplayer2.i.d
    protected com.applovin.exoplayer2.i.f c(byte[] bArr, int i, boolean z) throws com.applovin.exoplayer2.i.h {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.Sr.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new e(""));
            C0104c c0104cE = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarD = Sp;
            a aVarA = Sq;
            int i2 = 0;
            h hVar = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarD = d(xmlPullParserNewPullParser);
                            aVarA = a(xmlPullParserNewPullParser, Sq);
                            c0104cE = e(xmlPullParserNewPullParser);
                        }
                        C0104c c0104c = c0104cE;
                        b bVar2 = bVarD;
                        a aVar = aVarA;
                        if (!aq(name)) {
                            q.g("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i2++;
                            bVarD = bVar2;
                        } else {
                            if ("head".equals(name)) {
                                bVar = bVar2;
                                a(xmlPullParserNewPullParser, map, aVar, c0104c, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    d dVarA = a(xmlPullParserNewPullParser, dVar, map2, bVar);
                                    arrayDeque.push(dVarA);
                                    if (dVar != null) {
                                        dVar.a(dVarA);
                                    }
                                } catch (com.applovin.exoplayer2.i.h e) {
                                    q.b("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            bVarD = bVar;
                        }
                        c0104cE = c0104c;
                        aVarA = aVar;
                    } else if (eventType == 4) {
                        ((d) com.applovin.exoplayer2.l.a.checkNotNull(dVar)).a(d.as(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            hVar = new h((d) com.applovin.exoplayer2.l.a.checkNotNull((d) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new com.applovin.exoplayer2.i.h("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new com.applovin.exoplayer2.i.h("Unable to decode source", e3);
        }
    }

    private static b d(XmlPullParser xmlPullParser) throws com.applovin.exoplayer2.i.h {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrL = ai.l(attributeValue2, " ");
            if (strArrL.length != 2) {
                throw new com.applovin.exoplayer2.i.h("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(strArrL[0]) / Integer.parseInt(strArrL[1]);
        }
        b bVar = Sp;
        int i2 = bVar.Sv;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = bVar.Sw;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new b(i * f, i2, i3);
    }

    private static a a(XmlPullParser xmlPullParser, a aVar) throws com.applovin.exoplayer2.i.h {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = So.matcher(attributeValue);
        if (!matcher.matches()) {
            q.h("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1)));
            int i2 = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(2)));
            if (i == 0 || i2 == 0) {
                throw new com.applovin.exoplayer2.i.h("Invalid cell resolution " + i + " " + i2);
            }
            return new a(i, i2);
        } catch (NumberFormatException unused) {
            q.h("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static C0104c e(XmlPullParser xmlPullParser) {
        String strC = aj.c(xmlPullParser, "extent");
        if (strC == null) {
            return null;
        }
        Matcher matcher = Sn.matcher(strC);
        if (!matcher.matches()) {
            q.h("TtmlDecoder", "Ignoring non-pixel tts extent: " + strC);
            return null;
        }
        try {
            return new C0104c(Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1))), Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            q.h("TtmlDecoder", "Ignoring malformed tts extent: " + strC);
            return null;
        }
    }

    private static Map<String, g> a(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, C0104c c0104c, Map<String, e> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (aj.b(xmlPullParser, "style")) {
                String strC = aj.c(xmlPullParser, "style");
                g gVarA = a(xmlPullParser, new g());
                if (strC != null) {
                    for (String str : ao(strC)) {
                        gVarA.b(map.get(str));
                    }
                }
                String strMQ = gVarA.mQ();
                if (strMQ != null) {
                    map.put(strMQ, gVarA);
                }
            } else if (aj.b(xmlPullParser, "region")) {
                e eVarA = a(xmlPullParser, aVar, c0104c);
                if (eVarA != null) {
                    map2.put(eVarA.f2do, eVarA);
                }
            } else if (aj.b(xmlPullParser, "metadata")) {
                a(xmlPullParser, map3);
            }
        } while (!aj.a(xmlPullParser, "head"));
        return map;
    }

    private static void a(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String strC;
        do {
            xmlPullParser.next();
            if (aj.b(xmlPullParser, "image") && (strC = aj.c(xmlPullParser, "id")) != null) {
                map.put(strC, xmlPullParser.nextText());
            }
        } while (!aj.a(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Code duplicated, block: B:44:0x016d  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ba  */
    private static e a(XmlPullParser xmlPullParser, a aVar, C0104c c0104c) {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        float f5;
        int i2;
        String strC = aj.c(xmlPullParser, "id");
        if (strC == null) {
            return null;
        }
        String strC2 = aj.c(xmlPullParser, "origin");
        if (strC2 != null) {
            Pattern pattern = Sm;
            Matcher matcher = pattern.matcher(strC2);
            Pattern pattern2 = Sn;
            Matcher matcher2 = pattern2.matcher(strC2);
            if (matcher.matches()) {
                try {
                    float f6 = Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1))) / 100.0f;
                    f = Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(2))) / 100.0f;
                    f2 = f6;
                } catch (NumberFormatException unused) {
                    q.h("TtmlDecoder", "Ignoring region with malformed origin: " + strC2);
                    return null;
                }
            } else {
                if (!matcher2.matches()) {
                    q.h("TtmlDecoder", "Ignoring region with unsupported origin: " + strC2);
                    return null;
                }
                if (c0104c == null) {
                    q.h("TtmlDecoder", "Ignoring region with missing tts:extent: " + strC2);
                    return null;
                }
                try {
                    int i3 = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher2.group(1)));
                    int i4 = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher2.group(2)));
                    f2 = i3 / c0104c.dE;
                    f = i4 / c0104c.height;
                } catch (NumberFormatException unused2) {
                    q.h("TtmlDecoder", "Ignoring region with malformed origin: " + strC2);
                    return null;
                }
            }
            String strC3 = aj.c(xmlPullParser, "extent");
            if (strC3 != null) {
                Matcher matcher3 = pattern.matcher(strC3);
                Matcher matcher4 = pattern2.matcher(strC3);
                if (matcher3.matches()) {
                    try {
                        f3 = Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher3.group(1))) / 100.0f;
                        f4 = Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher3.group(2))) / 100.0f;
                    } catch (NumberFormatException unused3) {
                        q.h("TtmlDecoder", "Ignoring region with malformed extent: " + strC2);
                        return null;
                    }
                } else {
                    if (!matcher4.matches()) {
                        q.h("TtmlDecoder", "Ignoring region with unsupported extent: " + strC2);
                        return null;
                    }
                    if (c0104c == null) {
                        q.h("TtmlDecoder", "Ignoring region with missing tts:extent: " + strC2);
                        return null;
                    }
                    try {
                        int i5 = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher4.group(1)));
                        int i6 = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher4.group(2)));
                        f3 = i5 / c0104c.dE;
                        f4 = i6 / c0104c.height;
                    } catch (NumberFormatException unused4) {
                        q.h("TtmlDecoder", "Ignoring region with malformed extent: " + strC2);
                        return null;
                    }
                }
                String strC4 = aj.c(xmlPullParser, "displayAlign");
                if (strC4 != null) {
                    String lowerCase = Ascii.toLowerCase(strC4);
                    lowerCase.hashCode();
                    if (lowerCase.equals("center")) {
                        f5 = f + (f4 / 2.0f);
                        i = 1;
                    } else if (lowerCase.equals("after")) {
                        f5 = f + f4;
                        i = 2;
                    } else {
                        i = 0;
                        f5 = f;
                    }
                } else {
                    i = 0;
                    f5 = f;
                }
                float f7 = 1.0f / aVar.St;
                String strC5 = aj.c(xmlPullParser, "writingMode");
                if (strC5 != null) {
                    String lowerCase2 = Ascii.toLowerCase(strC5);
                    lowerCase2.hashCode();
                    switch (lowerCase2) {
                        case "tb":
                        case "tblr":
                            i2 = 2;
                            break;
                        case "tbrl":
                            i2 = 1;
                            break;
                        default:
                            i2 = Integer.MIN_VALUE;
                            break;
                    }
                } else {
                    i2 = Integer.MIN_VALUE;
                }
                return new e(strC, f2, f5, 0, i, f3, f4, 1, f7, i2);
            }
            q.h("TtmlDecoder", "Ignoring region without an extent");
            return null;
        }
        q.h("TtmlDecoder", "Ignoring region without an origin");
        return null;
    }

    private static String[] ao(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : ai.l(strTrim, "\\s+");
    }

    private static g a(XmlPullParser xmlPullParser, g gVar) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "fontStyle":
                    gVar = a(gVar).V("italic".equalsIgnoreCase(attributeValue));
                    break;
                case "fontFamily":
                    gVar = a(gVar).au(attributeValue);
                    break;
                case "textAlign":
                    gVar = a(gVar).c(ap(attributeValue));
                    break;
                case "textDecoration":
                    String lowerCase = Ascii.toLowerCase(attributeValue);
                    lowerCase.hashCode();
                    switch (lowerCase) {
                        case "nounderline":
                            gVar = a(gVar).T(false);
                            break;
                        case "underline":
                            gVar = a(gVar).T(true);
                            break;
                        case "nolinethrough":
                            gVar = a(gVar).S(false);
                            break;
                        case "linethrough":
                            gVar = a(gVar).S(true);
                            break;
                    }
                    break;
                case "fontWeight":
                    gVar = a(gVar).U("bold".equalsIgnoreCase(attributeValue));
                    break;
                case "id":
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        gVar = a(gVar).av(attributeValue);
                        break;
                    }
                    break;
                case "ruby":
                    String lowerCase2 = Ascii.toLowerCase(attributeValue);
                    lowerCase2.hashCode();
                    switch (lowerCase2) {
                        case "baseContainer":
                        case "base":
                            gVar = a(gVar).eF(2);
                            break;
                        case "container":
                            gVar = a(gVar).eF(1);
                            break;
                        case "delimiter":
                            gVar = a(gVar).eF(4);
                            break;
                        case "textContainer":
                        case "text":
                            gVar = a(gVar).eF(3);
                            break;
                    }
                    break;
                case "color":
                    gVar = a(gVar);
                    try {
                        gVar.eD(com.applovin.exoplayer2.l.f.aS(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        q.h("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                    break;
                case "shear":
                    gVar = a(gVar).s(ar(attributeValue));
                    break;
                case "textCombine":
                    String lowerCase3 = Ascii.toLowerCase(attributeValue);
                    lowerCase3.hashCode();
                    if (!lowerCase3.equals("all")) {
                        if (lowerCase3.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                            gVar = a(gVar).W(false);
                        }
                        break;
                    } else {
                        gVar = a(gVar).W(true);
                        break;
                    }
                    break;
                case "fontSize":
                    try {
                        gVar = a(gVar);
                        a(attributeValue, gVar);
                        break;
                    } catch (com.applovin.exoplayer2.i.h unused2) {
                        q.h("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                    break;
                case "textEmphasis":
                    gVar = a(gVar).a(com.applovin.exoplayer2.i.g.b.an(attributeValue));
                    break;
                case "rubyPosition":
                    String lowerCase4 = Ascii.toLowerCase(attributeValue);
                    lowerCase4.hashCode();
                    if (!lowerCase4.equals("before")) {
                        if (lowerCase4.equals("after")) {
                            gVar = a(gVar).eG(2);
                        }
                        break;
                    } else {
                        gVar = a(gVar).eG(1);
                        break;
                    }
                    break;
                case "backgroundColor":
                    gVar = a(gVar);
                    try {
                        gVar.eE(com.applovin.exoplayer2.l.f.aS(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        q.h("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                    break;
                case "multiRowAlign":
                    gVar = a(gVar).d(ap(attributeValue));
                    break;
            }
        }
        return gVar;
    }

    private static g a(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static Layout.Alignment ap(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:66:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:6:0x0038  */
    private static d a(XmlPullParser xmlPullParser, d dVar, Map<String, e> map, b bVar) throws com.applovin.exoplayer2.i.h {
        long j;
        long j2;
        int attributeCount = xmlPullParser.getAttributeCount();
        g gVarA = a(xmlPullParser, (g) null);
        String strSubstring = null;
        String str = "";
        long jA = -9223372036854775807L;
        long jA2 = -9223372036854775807L;
        long jA3 = -9223372036854775807L;
        String[] strArr = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    jA3 = a(attributeValue, bVar);
                    break;
                case "end":
                    jA2 = a(attributeValue, bVar);
                    break;
                case "begin":
                    jA = a(attributeValue, bVar);
                    break;
                case "style":
                    String[] strArrAo = ao(attributeValue);
                    if (strArrAo.length > 0) {
                        strArr = strArrAo;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (dVar != null) {
            j = -9223372036854775807L;
            if (dVar.Gi != -9223372036854775807L) {
                if (jA != -9223372036854775807L) {
                    jA += dVar.Gi;
                }
                if (jA2 != -9223372036854775807L) {
                    jA2 += dVar.Gi;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        long j3 = jA;
        if (jA2 != j) {
            j2 = jA2;
        } else if (jA3 != j) {
            j2 = j3 + jA3;
        } else if (dVar == null || dVar.Sy == j) {
            j2 = jA2;
        } else {
            j2 = dVar.Sy;
        }
        return d.a(xmlPullParser.getName(), j3, j2, gVarA, strArr, str, strSubstring, dVar);
    }

    private static boolean aq(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static void a(String str, g gVar) throws com.applovin.exoplayer2.i.h {
        Matcher matcher;
        String[] strArrL = ai.l(str, "\\s+");
        if (strArrL.length == 1) {
            matcher = Sk.matcher(str);
        } else if (strArrL.length == 2) {
            matcher = Sk.matcher(strArrL[1]);
            q.h("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new com.applovin.exoplayer2.i.h("Invalid number of entries for fontSize: " + strArrL.length + ".");
        }
        if (matcher.matches()) {
            String str2 = (String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(3));
            str2.hashCode();
            switch (str2) {
                case "%":
                    gVar.eH(3);
                    break;
                case "em":
                    gVar.eH(2);
                    break;
                case "px":
                    gVar.eH(1);
                    break;
                default:
                    throw new com.applovin.exoplayer2.i.h("Invalid unit for fontSize: '" + str2 + "'.");
            }
            gVar.t(Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1))));
            return;
        }
        throw new com.applovin.exoplayer2.i.h("Invalid expression for fontSize: '" + str + "'.");
    }

    private static float ar(String str) {
        Matcher matcher = Sl.matcher(str);
        if (!matcher.matches()) {
            q.h("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1)))));
        } catch (NumberFormatException e) {
            q.b("TtmlDecoder", "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    private static long a(String str, b bVar) throws com.applovin.exoplayer2.i.h {
        double d;
        double d2;
        Matcher matcher = Si.matcher(str);
        if (matcher.matches()) {
            double d3 = (Long.parseLong((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1))) * 3600) + (Long.parseLong((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(2))) * 60) + Long.parseLong((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(3)));
            String strGroup = matcher.group(4);
            double d4 = d3 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d5 = d4 + (strGroup2 != null ? Long.parseLong(strGroup2) / bVar.Su : 0.0d);
            String strGroup3 = matcher.group(6);
            return (long) ((d5 + (strGroup3 != null ? (Long.parseLong(strGroup3) / ((double) bVar.Sv)) / ((double) bVar.Su) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = Sj.matcher(str);
        if (matcher2.matches()) {
            double d6 = Double.parseDouble((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher2.group(1)));
            String str2 = (String) com.applovin.exoplayer2.l.a.checkNotNull(matcher2.group(2));
            str2.hashCode();
            switch (str2) {
                case "f":
                    d = bVar.Su;
                    d6 /= d;
                    return (long) (d6 * 1000000.0d);
                case "h":
                    d2 = 3600.0d;
                    break;
                case "m":
                    d2 = 60.0d;
                    break;
                case "t":
                    d = bVar.Sw;
                    d6 /= d;
                    return (long) (d6 * 1000000.0d);
                case "ms":
                    d = 1000.0d;
                    d6 /= d;
                    return (long) (d6 * 1000000.0d);
                default:
                    return (long) (d6 * 1000000.0d);
            }
            d6 *= d2;
            return (long) (d6 * 1000000.0d);
        }
        throw new com.applovin.exoplayer2.i.h("Malformed time expression: " + str);
    }

    private static final class b {
        final float Su;
        final int Sv;
        final int Sw;

        b(float f, int i, int i2) {
            this.Su = f;
            this.Sv = i;
            this.Sw = i2;
        }
    }

    private static final class a {
        final int Ss;
        final int St;

        a(int i, int i2) {
            this.Ss = i;
            this.St = i2;
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.i.g.c$c, reason: collision with other inner class name */
    private static final class C0104c {
        final int dE;
        final int height;

        C0104c(int i, int i2) {
            this.dE = i;
            this.height = i2;
        }
    }
}

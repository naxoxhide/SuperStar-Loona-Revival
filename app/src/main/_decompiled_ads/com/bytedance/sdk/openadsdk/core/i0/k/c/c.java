package com.bytedance.sdk.openadsdk.core.i0.k.c;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: LinearParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static void a(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.i0.a aVar, int i, double d) throws XmlPullParserException, IOException {
        boolean z = false;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("Linear")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if (z && TextUtils.isEmpty(aVar.n())) {
                    e.a(xmlPullParser);
                }
                String name = xmlPullParser.getName();
                name.hashCode();
                name.hashCode();
                switch (name) {
                    case "VideoClicks":
                        a(xmlPullParser, aVar);
                        break;
                    case "Duration":
                        aVar.a(b(xmlPullParser));
                        break;
                    case "MediaFiles":
                        a(xmlPullParser, i, d, aVar);
                        z = true;
                        break;
                    case "Icons":
                        com.bytedance.sdk.openadsdk.core.i0.b bVarA = a(xmlPullParser);
                        if (bVarA != null && aVar.h() == null) {
                            aVar.a(bVarA);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "TrackingEvents":
                        a(xmlPullParser, aVar.m());
                        break;
                    default:
                        e.a(xmlPullParser);
                        break;
                }
            }
        }
    }

    public static double b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String[] strArrSplit = e.b(xmlPullParser, "Duration").split(CertificateUtil.DELIMITER);
        if (strArrSplit.length != 3) {
            return 0.0d;
        }
        try {
            return (Integer.parseInt(strArrSplit[0].trim()) * 60 * 60) + (Integer.parseInt(strArrSplit[1].trim()) * 60) + Float.parseFloat(strArrSplit[2].trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.i0.l.c> c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return e.a(xmlPullParser, "Tracking");
    }

    private static String a(XmlPullParser xmlPullParser, int i, double d, com.bytedance.sdk.openadsdk.core.i0.a aVar) throws XmlPullParserException, IOException {
        int i2 = Integer.MIN_VALUE;
        String str = null;
        double d2 = Double.NEGATIVE_INFINITY;
        int i3 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("MediaFiles")) {
                break;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("MediaFile")) {
                String str2 = e.g;
                String attributeValue = xmlPullParser.getAttributeValue(str2, "type");
                int iD = e.d(xmlPullParser.getAttributeValue(str2, "width"));
                int iD2 = e.d(xmlPullParser.getAttributeValue(str2, "height"));
                int iD3 = e.d(xmlPullParser.getAttributeValue(str2, "bitrate"));
                String strB = e.b(xmlPullParser, "MediaFile");
                if (iD > 0 && iD2 > 0 && com.bytedance.sdk.openadsdk.core.i0.m.d.a.contains(attributeValue) && !TextUtils.isEmpty(strB)) {
                    double dA = com.bytedance.sdk.openadsdk.core.i0.m.d.a(i, d, iD, iD2, iD3, attributeValue);
                    if (dA > d2) {
                        str = strB;
                        d2 = dA;
                        i2 = iD;
                        i3 = iD2;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            aVar.g(str);
            aVar.b(i2);
            aVar.a(i3);
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x00d9  */
    public static com.bytedance.sdk.openadsdk.core.i0.b a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        char c;
        byte b2;
        ArrayList arrayList;
        int i;
        int i2;
        com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar;
        ArrayList arrayList2;
        com.bytedance.sdk.openadsdk.core.i0.b bVar = null;
        while (true) {
            int i3 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("Icons")) {
                return bVar;
            }
            xmlPullParser.next();
            int i4 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Icon")) {
                String str = e.g;
                int iD = e.d(xmlPullParser.getAttributeValue(str, "width"));
                int iD2 = e.d(xmlPullParser.getAttributeValue(str, "height"));
                if (iD > 0 && iD <= 300 && iD2 > 0 && iD2 <= 300) {
                    int iA = com.bytedance.sdk.openadsdk.core.i0.l.a.a(xmlPullParser.getAttributeValue(str, "offset"));
                    int iA2 = com.bytedance.sdk.openadsdk.core.i0.l.a.a(xmlPullParser.getAttributeValue(str, "duration"));
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    e.a aVar = null;
                    String strB = null;
                    while (true) {
                        if (xmlPullParser.next() == i3 && xmlPullParser.getName().equals("Icon")) {
                            if (aVar != null && (bVar == null || TextUtils.isEmpty(bVar.a()))) {
                                bVar = new com.bytedance.sdk.openadsdk.core.i0.b(iD, iD2, iA, iA2, aVar.f617b, aVar.c, aVar.a, arrayList3, arrayList4, strB);
                                e.a(xmlPullParser, "Icons", i3);
                            }
                        } else {
                            ArrayList arrayList5 = arrayList3;
                            ArrayList arrayList6 = arrayList4;
                            if (xmlPullParser.getEventType() != i4) {
                                arrayList3 = arrayList5;
                                arrayList4 = arrayList6;
                            } else {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                name.hashCode();
                                switch (name.hashCode()) {
                                    case -1044238411:
                                        if (!name.equals("IconViewTracking")) {
                                            b2 = -1;
                                        } else {
                                            c = 0;
                                            b2 = c;
                                        }
                                        break;
                                    case -375340334:
                                        if (!name.equals("IFrameResource")) {
                                            b2 = -1;
                                        } else {
                                            c = 1;
                                            b2 = c;
                                        }
                                        break;
                                    case 676623548:
                                        if (!name.equals("StaticResource")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 2;
                                        }
                                        break;
                                    case 1030746596:
                                        if (!name.equals("IconClicks")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 3;
                                        }
                                        break;
                                    case 1928285401:
                                        if (!name.equals("HTMLResource")) {
                                            b2 = -1;
                                        } else {
                                            c = 4;
                                            b2 = c;
                                        }
                                        break;
                                    default:
                                        b2 = -1;
                                        break;
                                }
                                switch (b2) {
                                    case 0:
                                        arrayList = arrayList5;
                                        i = 3;
                                        i2 = 2;
                                        arrayList6 = arrayList6;
                                        arrayList6.add(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(e.b(xmlPullParser, "IconViewTracking")).a());
                                        break;
                                    case 1:
                                        arrayList = arrayList5;
                                        i = 3;
                                        i2 = 2;
                                        if (aVar != null) {
                                            e.a(xmlPullParser);
                                        } else {
                                            aVar = new e.a(e.b(xmlPullParser, "IFrameResource"), com.bytedance.sdk.openadsdk.core.i0.m.a.c.NONE, com.bytedance.sdk.openadsdk.core.i0.m.a.d.IFRAME_RESOURCE);
                                        }
                                        arrayList6 = arrayList6;
                                        break;
                                    case 2:
                                        arrayList = arrayList5;
                                        i = 3;
                                        i2 = 2;
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar2 = com.bytedance.sdk.openadsdk.core.i0.m.a.c.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(e.g, "creativeType").toLowerCase();
                                        Set<String> set = com.bytedance.sdk.openadsdk.core.i0.m.a.a;
                                        String strB2 = (set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.i0.m.a.f625b.contains(lowerCase)) ? e.b(xmlPullParser, "StaticResource") : null;
                                        if (set.contains(lowerCase)) {
                                            cVar = com.bytedance.sdk.openadsdk.core.i0.m.a.c.IMAGE;
                                        } else {
                                            cVar = com.bytedance.sdk.openadsdk.core.i0.m.a.c.JAVASCRIPT;
                                        }
                                        aVar = new e.a(strB2, cVar, com.bytedance.sdk.openadsdk.core.i0.m.a.d.STATIC_RESOURCE);
                                        arrayList6 = arrayList6;
                                        break;
                                    case 3:
                                        while (true) {
                                            i = 3;
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("IconClicks")) {
                                                arrayList = arrayList5;
                                                i2 = 2;
                                            } else {
                                                if (xmlPullParser.getEventType() == 2) {
                                                    if (xmlPullParser.getName().equals("IconClickThrough")) {
                                                        strB = e.b(xmlPullParser, "IconClickThrough");
                                                    } else {
                                                        if (xmlPullParser.getName().equals("IconClickTracking")) {
                                                            arrayList2 = arrayList5;
                                                            arrayList2.add(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(e.b(xmlPullParser, "IconClickTracking")).a());
                                                        }
                                                        arrayList5 = arrayList2;
                                                    }
                                                }
                                                arrayList2 = arrayList5;
                                                arrayList5 = arrayList2;
                                            }
                                            break;
                                        }
                                        break;
                                    case 4:
                                        if (aVar != null && aVar.c != com.bytedance.sdk.openadsdk.core.i0.m.a.d.IFRAME_RESOURCE) {
                                            e.a(xmlPullParser);
                                        } else {
                                            aVar = new e.a(e.b(xmlPullParser, "HTMLResource"), com.bytedance.sdk.openadsdk.core.i0.m.a.c.NONE, com.bytedance.sdk.openadsdk.core.i0.m.a.d.HTML_RESOURCE);
                                        }
                                        arrayList = arrayList5;
                                        i = 3;
                                        i2 = 2;
                                        break;
                                    default:
                                        e.a(xmlPullParser);
                                        arrayList = arrayList5;
                                        i = 3;
                                        i2 = 2;
                                        break;
                                }
                                i4 = i2;
                                arrayList3 = arrayList;
                                arrayList4 = arrayList6;
                                i3 = i;
                            }
                        }
                    }
                } else {
                    e.a(xmlPullParser);
                }
            }
        }
    }

    public static void a(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.i0.d dVar) throws XmlPullParserException, IOException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if ("Tracking".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(e.g, "event");
                    if (TextUtils.isEmpty(attributeValue)) {
                        e.a(xmlPullParser, "Tracking", 3);
                    } else {
                        attributeValue.hashCode();
                        attributeValue.hashCode();
                        switch (attributeValue) {
                            case "midpoint":
                                dVar.a(e.b(xmlPullParser, "Tracking"), 0.5f);
                                break;
                            case "thirdQuartile":
                                dVar.a(e.b(xmlPullParser, "Tracking"), 0.75f);
                                break;
                            case "resume":
                                dVar.j(c(xmlPullParser));
                                break;
                            case "unmute":
                                dVar.l(c(xmlPullParser));
                                break;
                            case "complete":
                                dVar.d(c(xmlPullParser));
                                break;
                            case "mute":
                                dVar.h(c(xmlPullParser));
                                break;
                            case "skip":
                                dVar.k(c(xmlPullParser));
                                break;
                            case "close":
                                dVar.c(c(xmlPullParser));
                                break;
                            case "pause":
                                dVar.i(c(xmlPullParser));
                                break;
                            case "start":
                            case "creativeView":
                                dVar.a(e.b(xmlPullParser, "Tracking"), 0L);
                                break;
                            case "firstQuartile":
                                dVar.a(e.b(xmlPullParser, "Tracking"), 0.25f);
                                break;
                        }
                    }
                } else if (xmlPullParser.getEventType() == 4) {
                    xmlPullParser.nextTag();
                } else {
                    e.a(xmlPullParser);
                }
            }
        }
    }

    private static void a(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.i0.a aVar) throws XmlPullParserException, IOException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("VideoClicks")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ClickThrough")) {
                    aVar.a(e.b(xmlPullParser, "ClickThrough"));
                } else if (!name.equals("ClickTracking")) {
                    e.a(xmlPullParser);
                } else {
                    aVar.m().b(e.a(xmlPullParser, "ClickTracking"));
                }
            }
        }
    }
}

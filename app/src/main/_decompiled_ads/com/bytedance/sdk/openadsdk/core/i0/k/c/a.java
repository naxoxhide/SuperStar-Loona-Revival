package com.bytedance.sdk.openadsdk.core.i0.k.c;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: CompanionAdsParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x00e4  */
    public static com.bytedance.sdk.openadsdk.core.i0.c a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        com.bytedance.sdk.openadsdk.core.i0.c cVar;
        int i;
        int i2;
        char c;
        byte b2;
        int i3;
        int i4;
        e.a aVar;
        int i5;
        int i6;
        e.a aVar2;
        int i7;
        int i8;
        if (context == null) {
            e.a(xmlPullParser);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i9 = displayMetrics.widthPixels;
        int i10 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        int i11 = (int) (i9 / f);
        int i12 = (int) (i10 / f);
        float f2 = Float.MIN_VALUE;
        com.bytedance.sdk.openadsdk.core.i0.c cVar2 = null;
        while (true) {
            int i13 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("CompanionAds")) {
                return cVar2;
            }
            xmlPullParser.next();
            int i14 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Companion")) {
                String str = e.g;
                int iD = e.d(xmlPullParser.getAttributeValue(str, "width"));
                int iD2 = e.d(xmlPullParser.getAttributeValue(str, "height"));
                if (iD < 300 || iD2 < 250) {
                    i2 = i12;
                    i = i11;
                    cVar = cVar2;
                    e.a(xmlPullParser);
                    i12 = i2;
                    i11 = i;
                    cVar2 = cVar;
                } else {
                    e.a aVar3 = new e.a();
                    while (true) {
                        if (xmlPullParser.getEventType() != i13 || !xmlPullParser.getName().equals("Companion")) {
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == i14) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                name.hashCode();
                                e.a aVar4 = aVar3;
                                cVar2 = cVar2;
                                switch (name.hashCode()) {
                                    case -375340334:
                                        if (!name.equals("IFrameResource")) {
                                            b2 = -1;
                                        } else {
                                            c = 0;
                                            b2 = c;
                                        }
                                        break;
                                    case -348198615:
                                        if (!name.equals("CompanionClickThrough")) {
                                            b2 = -1;
                                        } else {
                                            c = 1;
                                            b2 = c;
                                        }
                                        break;
                                    case 611554000:
                                        if (!name.equals("TrackingEvents")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 2;
                                        }
                                        break;
                                    case 676623548:
                                        if (!name.equals("StaticResource")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 3;
                                        }
                                        break;
                                    case 1877773523:
                                        if (!name.equals("CompanionClickTracking")) {
                                            b2 = -1;
                                        } else {
                                            c = 4;
                                            b2 = c;
                                        }
                                        break;
                                    case 1928285401:
                                        if (!name.equals("HTMLResource")) {
                                            b2 = -1;
                                        } else {
                                            c = 5;
                                            b2 = c;
                                        }
                                        break;
                                    default:
                                        b2 = -1;
                                        break;
                                }
                                switch (b2) {
                                    case 0:
                                        i7 = i12;
                                        int i15 = iD2;
                                        i14 = 2;
                                        i8 = i11;
                                        int i16 = iD;
                                        Point pointA = com.bytedance.sdk.openadsdk.core.i0.m.a.a(context, i16, i15, com.bytedance.sdk.openadsdk.core.i0.m.a.d.HTML_RESOURCE);
                                        int i17 = pointA.x;
                                        int i18 = pointA.y;
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar = com.bytedance.sdk.openadsdk.core.i0.m.a.d.IFRAME_RESOURCE;
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar3 = com.bytedance.sdk.openadsdk.core.i0.m.a.c.NONE;
                                        float fA = com.bytedance.sdk.openadsdk.core.i0.c.a(i8, i7, i17, i18, dVar, cVar3);
                                        String strB = e.b(xmlPullParser, "IFrameResource");
                                        if (!TextUtils.isEmpty(strB) && fA > aVar4.g && fA > f2) {
                                            aVar4.g = fA;
                                            aVar4.a(strB, cVar3, dVar);
                                            aVar3 = aVar4;
                                            iD2 = i15;
                                            iD = i16;
                                            i12 = i7;
                                            i11 = i8;
                                            cVar2 = cVar2;
                                            i13 = 3;
                                        } else {
                                            e.a(xmlPullParser, "Companion", 3);
                                            aVar3 = aVar4;
                                            iD2 = i15;
                                            iD = i16;
                                            i13 = 3;
                                            i12 = i7;
                                            i11 = i8;
                                            cVar2 = cVar2;
                                        }
                                        break;
                                    case 1:
                                        i7 = i12;
                                        i14 = 2;
                                        i8 = i11;
                                        aVar4.d = e.b(xmlPullParser, "CompanionClickThrough");
                                        aVar3 = aVar4;
                                        i12 = i7;
                                        i11 = i8;
                                        cVar2 = cVar2;
                                        i13 = 3;
                                        break;
                                    case 2:
                                        i3 = i12;
                                        i4 = iD2;
                                        aVar = aVar4;
                                        int i19 = 3;
                                        i5 = i11;
                                        i6 = iD;
                                        while (true) {
                                            if (xmlPullParser.next() == i19 && xmlPullParser.getName().equals("TrackingEvents")) {
                                                aVar3 = aVar;
                                                iD2 = i4;
                                                iD = i6;
                                                i12 = i3;
                                                i11 = i5;
                                                i13 = 3;
                                                i14 = 2;
                                            } else {
                                                if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Tracking")) {
                                                    aVar.b(e.b(xmlPullParser, "Tracking"));
                                                }
                                                i19 = 3;
                                            }
                                            break;
                                        }
                                        break;
                                    case 3:
                                        i3 = i12;
                                        i4 = iD2;
                                        aVar = aVar4;
                                        i5 = i11;
                                        i6 = iD;
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar4 = com.bytedance.sdk.openadsdk.core.i0.m.a.c.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(e.g, "creativeType").toLowerCase();
                                        Set<String> set = com.bytedance.sdk.openadsdk.core.i0.m.a.a;
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar5 = set.contains(lowerCase) ? com.bytedance.sdk.openadsdk.core.i0.m.a.c.IMAGE : com.bytedance.sdk.openadsdk.core.i0.m.a.c.JAVASCRIPT;
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar2 = com.bytedance.sdk.openadsdk.core.i0.m.a.d.STATIC_RESOURCE;
                                        Point pointA2 = com.bytedance.sdk.openadsdk.core.i0.m.a.a(context, i6, i4, dVar2);
                                        float fA2 = com.bytedance.sdk.openadsdk.core.i0.c.a(i5, i3, pointA2.x, pointA2.y, dVar2, cVar5);
                                        String strB2 = (set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.i0.m.a.f625b.contains(lowerCase)) ? e.b(xmlPullParser, "StaticResource") : null;
                                        if (fA2 >= aVar.g && fA2 > f2 && !TextUtils.isEmpty(strB2)) {
                                            aVar.g = fA2;
                                            aVar.a(strB2, cVar5, dVar2);
                                            aVar3 = aVar;
                                            iD2 = i4;
                                            iD = i6;
                                            i12 = i3;
                                            i11 = i5;
                                            i13 = 3;
                                            i14 = 2;
                                        } else {
                                            e.a(xmlPullParser, "Companion", 3);
                                            aVar3 = aVar;
                                            iD2 = i4;
                                            iD = i6;
                                            i13 = 3;
                                            i12 = i3;
                                            i11 = i5;
                                            i14 = 2;
                                        }
                                        break;
                                    case 4:
                                        i3 = i12;
                                        aVar2 = aVar4;
                                        i5 = i11;
                                        aVar2.a(e.b(xmlPullParser, "CompanionClickTracking"));
                                        aVar3 = aVar2;
                                        i12 = i3;
                                        i11 = i5;
                                        i13 = 3;
                                        i14 = 2;
                                        break;
                                    case 5:
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar3 = com.bytedance.sdk.openadsdk.core.i0.m.a.d.HTML_RESOURCE;
                                        Point pointA3 = com.bytedance.sdk.openadsdk.core.i0.m.a.a(context, iD, iD2, dVar3);
                                        int i20 = pointA3.x;
                                        int i21 = pointA3.y;
                                        com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar6 = com.bytedance.sdk.openadsdk.core.i0.m.a.c.NONE;
                                        int i22 = i11;
                                        int i23 = i12;
                                        aVar2 = aVar4;
                                        i3 = i12;
                                        int i24 = iD2;
                                        i5 = i11;
                                        int i25 = iD;
                                        float fA3 = com.bytedance.sdk.openadsdk.core.i0.c.a(i22, i23, i20, i21, dVar3, cVar6);
                                        String strB3 = e.b(xmlPullParser, "HTMLResource");
                                        if (!TextUtils.isEmpty(strB3) && fA3 > aVar2.g && fA3 > f2) {
                                            aVar2.g = fA3;
                                            aVar2.a(strB3, cVar6, dVar3);
                                            iD2 = i24;
                                            iD = i25;
                                            aVar3 = aVar2;
                                            i12 = i3;
                                            i11 = i5;
                                            i13 = 3;
                                            i14 = 2;
                                        } else {
                                            e.a(xmlPullParser, "Companion", 3);
                                            i13 = 3;
                                            iD2 = i24;
                                            iD = i25;
                                            aVar3 = aVar2;
                                            i12 = i3;
                                            i11 = i5;
                                            i14 = 2;
                                        }
                                        break;
                                    default:
                                        e.a(xmlPullParser);
                                        aVar3 = aVar4;
                                        i13 = 3;
                                        i14 = 2;
                                        break;
                                }
                            }
                        } else if (!TextUtils.isEmpty(aVar3.a) && aVar3.g >= f2) {
                            cVar2 = new com.bytedance.sdk.openadsdk.core.i0.c(iD, iD2, aVar3.f617b, aVar3.c, aVar3.a, aVar3.e, aVar3.f, aVar3.d);
                            f2 = aVar3.g;
                        }
                    }
                }
            }
            i2 = i12;
            i = i11;
            cVar = cVar2;
            i12 = i2;
            i11 = i;
            cVar2 = cVar;
        }
    }
}

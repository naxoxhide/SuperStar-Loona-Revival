package com.bytedance.sdk.openadsdk.core.i0.k.c;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: InLineParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static com.bytedance.sdk.openadsdk.core.i0.a a(Context context, XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list, int i, double d) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, e.g, "InLine");
        com.bytedance.sdk.openadsdk.core.i0.a aVar = new com.bytedance.sdk.openadsdk.core.i0.a();
        while (true) {
            if (xmlPullParser.next() != 3 || !"InLine".equals(xmlPullParser.getName())) {
                if (xmlPullParser.getEventType() == 2) {
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    name.hashCode();
                    switch (name) {
                        case "AdVerifications":
                            aVar.a(d.a(xmlPullParser));
                            break;
                        case "Creatives":
                            if (!TextUtils.isEmpty(aVar.n()) && aVar.c() != null) {
                                e.a(xmlPullParser);
                                break;
                            } else {
                                while (xmlPullParser.next() != 3) {
                                    if (xmlPullParser.getEventType() == 2) {
                                        if ("Creative".equals(xmlPullParser.getName())) {
                                            a(context, xmlPullParser, aVar, i, d);
                                        } else {
                                            e.a(xmlPullParser);
                                        }
                                    }
                                }
                                break;
                            }
                            break;
                        case "Description":
                            aVar.c(e.b(xmlPullParser, name));
                            break;
                        case "Error":
                            list.addAll(e.a(xmlPullParser, name));
                            break;
                        case "Extensions":
                            while (true) {
                                if (xmlPullParser.getEventType() != 3 || !"Extensions".equals(xmlPullParser.getName())) {
                                    xmlPullParser.next();
                                    if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                        aVar.a(d.a(xmlPullParser));
                                    }
                                }
                            }
                            break;
                        case "AdTitle":
                            aVar.f(e.b(xmlPullParser, name));
                            break;
                        case "Impression":
                            aVar.m().g(e.a(xmlPullParser, name));
                            break;
                        default:
                            e.a(xmlPullParser);
                            break;
                    }
                }
            } else {
                aVar.m().e(list);
                return aVar;
            }
        }
    }

    public static void a(Context context, XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.i0.a aVar, int i, double d) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(aVar.n())) {
                    c.a(xmlPullParser, aVar, i, d);
                } else if ("CompanionAds".equals(xmlPullParser.getName()) && aVar.c() == null) {
                    aVar.a(a.a(context, xmlPullParser));
                } else {
                    e.a(xmlPullParser);
                }
            }
        }
    }
}

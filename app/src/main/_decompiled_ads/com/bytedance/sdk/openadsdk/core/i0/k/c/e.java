package com.bytedance.sdk.openadsdk.core.i0.k.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: VastXmlPullParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bytedance.sdk.openadsdk.core.i0.k.b {
    public static final String g = null;

    public e(Context context, int i, int i2) {
        super(context, i, i2);
    }

    private void a(com.bytedance.sdk.openadsdk.core.i0.a aVar) {
        if (this.f == null) {
            this.f = new com.bytedance.sdk.openadsdk.core.i0.k.b.a();
        }
        com.bytedance.sdk.openadsdk.core.i0.k.b.a aVar2 = this.f;
        aVar2.a = this.e;
        aVar2.f616b = this.a;
        if (aVar != null) {
            aVar2.c = aVar.m().c.size() <= 0;
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.i0.l.c> c(String str) {
        return a(str, false);
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.i0.k.b
    public com.bytedance.sdk.openadsdk.core.i0.a b(String str, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        this.e = 0;
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (this.f615b == null) {
            this.e = -1;
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            this.e = -2;
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                    xmlPullParserNewPullParser.setInput(byteArrayInputStream, "UTF-8");
                    xmlPullParserNewPullParser.nextTag();
                    com.bytedance.sdk.openadsdk.core.i0.a aVarB = b(xmlPullParserNewPullParser, list);
                    a(aVarB);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                    }
                    return aVarB;
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                this.e = -3;
                a((com.bytedance.sdk.openadsdk.core.i0.a) null);
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            }
        } catch (Exception unused5) {
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: compiled from: VastXmlPullParser.java */
    static class a {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.core.i0.m.a.c f617b;
        com.bytedance.sdk.openadsdk.core.i0.m.a.d c;
        String d;
        final List<com.bytedance.sdk.openadsdk.core.i0.l.c> e = new ArrayList();
        final List<com.bytedance.sdk.openadsdk.core.i0.l.c> f = new ArrayList();
        float g = Float.MIN_VALUE;

        public a() {
        }

        public void a(String str, com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar, com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar) {
            this.a = str;
            this.f617b = cVar;
            this.c = dVar;
        }

        public void b(String str) {
            this.f.add(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(str).a());
        }

        public void a(String str) {
            this.e.add(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(str).a());
        }

        public a(String str, com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar, com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar) {
            a(str, cVar, dVar);
        }
    }

    public static List<com.bytedance.sdk.openadsdk.core.i0.l.c> a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return c(b(xmlPullParser, str));
    }

    public static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static void a(XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        while (xmlPullParser.getEventType() != 1) {
            if (str.equals(xmlPullParser.getName()) && xmlPullParser.getEventType() == i) {
                return;
            } else {
                xmlPullParser.next();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.i0.a a(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) throws Throwable {
        if (this.a >= 5) {
            a(xmlPullParser);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.i0.d dVar = new com.bytedance.sdk.openadsdk.core.i0.d(null);
        String strA = null;
        com.bytedance.sdk.openadsdk.core.i0.c cVarA = null;
        while (true) {
            if (xmlPullParser.getEventType() == 3 && "Wrapper".equals(xmlPullParser.getName())) {
                com.bytedance.sdk.openadsdk.core.i0.a aVarB = b(strA, list);
                if (aVarB != null) {
                    if (aVarB.c() == null) {
                        aVarB.a(cVarA);
                    }
                    aVarB.m().a(dVar);
                }
                return aVarB;
            }
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                name.hashCode();
                switch (name) {
                    case "VASTAdTagURI":
                        strA = a(b(xmlPullParser, "VASTAdTagURI"), list);
                        if (!TextUtils.isEmpty(strA)) {
                            break;
                        } else {
                            a(xmlPullParser, "Wrapper", 3);
                            this.e = -2;
                            return null;
                        }
                        break;
                    case "Error":
                        list.add(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(b(xmlPullParser, "Error")).a());
                        break;
                    case "TrackingEvents":
                        c.a(xmlPullParser, dVar);
                        break;
                    case "CompanionAds":
                        cVarA = com.bytedance.sdk.openadsdk.core.i0.k.c.a.a(this.f615b, xmlPullParser);
                        break;
                    case "ClickTracking":
                        dVar.b(a(xmlPullParser, "ClickTracking"));
                        break;
                    case "Impression":
                        dVar.g(a(xmlPullParser, name));
                        break;
                }
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.i0.a b(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) throws Throwable {
        xmlPullParser.require(2, g, "VAST");
        boolean z = false;
        String strB = null;
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if ("Error".equals(name)) {
                    strB = b(xmlPullParser, name);
                } else if ("Ad".equals(name)) {
                    if (a(xmlPullParser.getAttributeValue(g, "sequence"))) {
                        while (true) {
                            if (xmlPullParser.next() == 3 && "Ad".equals(xmlPullParser.getName())) {
                                break;
                            }
                            if (xmlPullParser.getEventType() == 2) {
                                String name2 = xmlPullParser.getName();
                                if ("InLine".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.i0.a aVarA = b.a(this.f615b, xmlPullParser, list, this.c, this.d);
                                    if (aVarA != null) {
                                        if (!TextUtils.isEmpty(aVarA.n())) {
                                            return aVarA;
                                        }
                                        this.e = -6;
                                        return null;
                                    }
                                } else if ("Wrapper".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.i0.a aVarA2 = a(xmlPullParser, list);
                                    if (aVarA2 != null) {
                                        return aVarA2;
                                    }
                                } else {
                                    a(xmlPullParser);
                                }
                            }
                        }
                    } else {
                        a(xmlPullParser);
                    }
                    z = true;
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (!z) {
            this.e = -4;
            b(strB);
        }
        if (this.e == 0) {
            this.e = -5;
        }
        return null;
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i0.l.c.a(com.bytedance.sdk.openadsdk.core.i0.l.c.b(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(str).a()), this.a > 0 ? com.bytedance.sdk.openadsdk.core.i0.k.a.NO_ADS_VAST_RESPONSE : com.bytedance.sdk.openadsdk.core.i0.k.a.UNDEFINED_ERROR, -1L, null), (com.bytedance.sdk.openadsdk.core.i0.l.c.e) null);
    }

    private static List<com.bytedance.sdk.openadsdk.core.i0.l.c> a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return Collections.singletonList(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(str).a(z).a());
    }

    public static String b(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strTrim;
        String str2 = g;
        xmlPullParser.require(2, str2, str);
        if (xmlPullParser.next() == 4) {
            strTrim = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        } else {
            strTrim = "";
        }
        xmlPullParser.require(3, str2, str);
        return strTrim;
    }
}

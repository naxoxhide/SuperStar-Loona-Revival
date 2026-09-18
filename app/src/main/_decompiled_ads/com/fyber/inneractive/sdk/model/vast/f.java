package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public String a;
    public l e;
    public List<com.fyber.inneractive.sdk.measurement.f> d = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f963b = new ArrayList();
    public List<k> c = new ArrayList();

    public final void a(Node node) {
        com.fyber.inneractive.sdk.measurement.f fVar;
        Node nodeD = v0.d(node, "AdVerifications");
        if (nodeD != null) {
            for (Node node2 : (ArrayList) v0.c(nodeD, "Verification")) {
                if (node2 == null) {
                    fVar = null;
                } else {
                    com.fyber.inneractive.sdk.measurement.f fVar2 = new com.fyber.inneractive.sdk.measurement.f();
                    fVar2.e = v0.b(node2, "vendor");
                    Node nodeD2 = v0.d(node2, "JavaScriptResource");
                    if (nodeD2 != null) {
                        fVar2.g = true;
                        try {
                            fVar2.f = v0.a(nodeD2);
                            fVar2.f950b = v0.b(nodeD2, "apiFramework");
                            fVar2.a = new URL(fVar2.f);
                        } catch (MalformedURLException unused) {
                        }
                    }
                    Node nodeD3 = v0.d(node2, "TrackingEvents");
                    if (nodeD3 != null) {
                        for (Node node3 : (ArrayList) v0.c(nodeD3, "Tracking")) {
                            s sVarA = s.a(node3);
                            if (node3 != null && sVarA.a.equalsIgnoreCase("verificationNotExecuted")) {
                                fVar2.a(t.EVENT_VERIFICATION_NOT_EXECUTED, sVarA.f971b);
                            }
                        }
                    }
                    Node nodeD4 = v0.d(node2, "VerificationParameters");
                    if (nodeD4 != null) {
                        fVar2.d = v0.a(nodeD4);
                    }
                    fVar = fVar2;
                }
                if (fVar != null) {
                    IAlog.a("Verification Found - %s", fVar.toString());
                    this.d.add(fVar);
                }
            }
        }
    }

    public void b(Node node) {
        Iterator it;
        k kVar;
        g gVar;
        o oVar;
        if (node == null) {
            return;
        }
        Node nodeD = v0.d(node, "AdSystem");
        if (nodeD != null) {
            v0.b(nodeD, "version");
            v0.a(nodeD);
        }
        Node nodeD2 = v0.d(node, "Error");
        if (nodeD2 != null) {
            String strA = v0.a(nodeD2);
            if (!TextUtils.isEmpty(strA)) {
                this.a = strA;
            }
        }
        Iterator it2 = ((ArrayList) v0.c(node, ADXLogUtil.EVENT_IMPRESSION)).iterator();
        while (it2.hasNext()) {
            String strA2 = v0.a((Node) it2.next());
            if (!TextUtils.isEmpty(strA2)) {
                this.f963b.add(strA2);
            }
        }
        Node nodeD3 = v0.d(node, "Creatives");
        if (nodeD3 != null) {
            Iterator it3 = ((ArrayList) v0.c(nodeD3, "Creative")).iterator();
            while (it3.hasNext()) {
                Node node2 = (Node) it3.next();
                if (node2 == null) {
                    it = it3;
                    kVar = null;
                } else {
                    k kVar2 = new k();
                    v0.b(node2, "AdID");
                    v0.b(node2, "id");
                    v0.a(node2, "sequence");
                    Node nodeD4 = v0.d(node2, "Linear");
                    if (nodeD4 != null) {
                        n nVar = new n();
                        Node nodeD5 = v0.d(nodeD4, "MediaFiles");
                        if (nodeD5 != null) {
                            ArrayList arrayList = (ArrayList) v0.c(nodeD5, "MediaFile");
                            if (!arrayList.isEmpty()) {
                                nVar.a = new ArrayList();
                                for (Iterator it4 = arrayList.iterator(); it4.hasNext(); it4 = it4) {
                                    Node node3 = (Node) it4.next();
                                    if (node3 == null) {
                                        oVar = null;
                                    } else {
                                        oVar = new o();
                                        oVar.a = v0.b(node3, "delivery");
                                        oVar.f969b = v0.a(node3, "width");
                                        oVar.c = v0.a(node3, "height");
                                        oVar.d = v0.b(node3, "type");
                                        v0.b(node3, "id");
                                        oVar.f = v0.b(node3, "apiFramework");
                                        oVar.e = v0.a(node3, "bitrate");
                                        String strB = v0.b(node3, "maintainAspectRatio");
                                        if (!TextUtils.isEmpty(strB)) {
                                            try {
                                                Boolean.valueOf(strB);
                                            } catch (NumberFormatException unused) {
                                            }
                                        }
                                        String strB2 = v0.b(node3, "scalable");
                                        if (!TextUtils.isEmpty(strB2)) {
                                            try {
                                                Boolean.valueOf(strB2);
                                            } catch (NumberFormatException unused2) {
                                            }
                                        }
                                        oVar.g = v0.a(node3);
                                    }
                                    if (oVar != null) {
                                        nVar.a.add(oVar);
                                    }
                                    it3 = it3;
                                }
                            }
                        }
                        it = it3;
                        Node nodeD6 = v0.d(nodeD4, "VideoClicks");
                        if (nodeD6 != null) {
                            nVar.c = v0.a(v0.d(nodeD6, "ClickThrough"));
                            ArrayList arrayList2 = (ArrayList) v0.c(nodeD6, "ClickTracking");
                            if (!arrayList2.isEmpty()) {
                                nVar.d = new ArrayList();
                                Iterator it5 = arrayList2.iterator();
                                while (it5.hasNext()) {
                                    String strA3 = v0.a((Node) it5.next());
                                    if (!TextUtils.isEmpty(strA3)) {
                                        nVar.d.add(strA3);
                                    }
                                }
                            }
                        }
                        Node nodeD7 = v0.d(nodeD4, "TrackingEvents");
                        if (nodeD7 != null) {
                            ArrayList arrayList3 = (ArrayList) v0.c(nodeD7, "Tracking");
                            if (!arrayList3.isEmpty()) {
                                nVar.f968b = new ArrayList();
                                Iterator it6 = arrayList3.iterator();
                                while (it6.hasNext()) {
                                    s sVarA = s.a((Node) it6.next());
                                    if (sVarA != null) {
                                        nVar.f968b.add(sVarA);
                                    }
                                }
                            }
                        }
                        Node nodeD8 = v0.d(nodeD4, "Duration");
                        if (nodeD8 != null) {
                            nVar.e = v0.a(nodeD8);
                        }
                        kVar2.a = nVar;
                    } else {
                        it = it3;
                    }
                    Node nodeD9 = v0.d(node2, "CompanionAds");
                    if (nodeD9 != null) {
                        List<Node> listC = v0.c(nodeD9, "Companion");
                        kVar2.f966b = new ArrayList();
                        for (Node node4 : (ArrayList) listC) {
                            if (node4 == null) {
                                gVar = null;
                            } else {
                                gVar = new g();
                                gVar.a = v0.a(node4, "width");
                                gVar.f964b = v0.a(node4, "height");
                                gVar.c = v0.b(node4, "id");
                                v0.b(node4, "apiFramework");
                                v0.a(node4, "expandedWidth");
                                v0.a(node4, "expandedHeight");
                                Node nodeD10 = v0.d(node4, "StaticResource");
                                if (nodeD10 != null) {
                                    j jVar = new j();
                                    jVar.a = v0.b(nodeD10, "creativeType");
                                    jVar.f965b = v0.a(nodeD10);
                                    gVar.d = jVar;
                                }
                                Node nodeD11 = v0.d(node4, "HTMLResource");
                                if (nodeD11 != null) {
                                    gVar.f = v0.a(nodeD11);
                                }
                                Node nodeD12 = v0.d(node4, "IFrameResource");
                                if (nodeD12 != null) {
                                    gVar.e = v0.a(nodeD12);
                                }
                                Node nodeD13 = v0.d(node4, "CompanionClickThrough");
                                if (nodeD13 != null) {
                                    gVar.g = v0.a(nodeD13);
                                }
                                ArrayList arrayList4 = (ArrayList) v0.c(node4, "CompanionClickTracking");
                                if (arrayList4.size() > 0) {
                                    gVar.h = new ArrayList();
                                    Iterator it7 = arrayList4.iterator();
                                    while (it7.hasNext()) {
                                        String strA4 = v0.a((Node) it7.next());
                                        if (!TextUtils.isEmpty(strA4)) {
                                            gVar.h.add(strA4);
                                        }
                                    }
                                }
                                Node nodeD14 = v0.d(node4, "TrackingEvents");
                                if (nodeD14 != null) {
                                    ArrayList arrayList5 = (ArrayList) v0.c(nodeD14, "Tracking");
                                    if (!arrayList5.isEmpty()) {
                                        gVar.j = new ArrayList();
                                        Iterator it8 = arrayList5.iterator();
                                        while (it8.hasNext()) {
                                            s sVarA2 = s.a((Node) it8.next());
                                            if (sVarA2 != null) {
                                                gVar.j.add(sVarA2);
                                            }
                                        }
                                    }
                                }
                            }
                            if (gVar != null) {
                                kVar2.f966b.add(gVar);
                            }
                        }
                    }
                    kVar = kVar2;
                }
                if (kVar != null) {
                    this.c.add(kVar);
                }
                it3 = it;
            }
        }
        Node nodeD15 = v0.d(node, "Extensions");
        if (nodeD15 != null) {
            for (Node node5 : (ArrayList) v0.c(nodeD15, "Extension")) {
                if ("AdVerifications".equalsIgnoreCase(v0.b(node5, "type"))) {
                    a(node5);
                }
                if ("FMPCompanionAssets".equalsIgnoreCase(v0.b(node5, "type"))) {
                    IAlog.a("parseFMPCompanionAssetsTag", new Object[0]);
                    Node nodeD16 = v0.d(node5, "FMPCompanionAssets");
                    if (nodeD16 != null) {
                        l lVar = new l();
                        Node nodeD17 = v0.d(nodeD16, "Name");
                        if (nodeD17 != null) {
                            lVar.a = v0.a(nodeD17);
                        }
                        Node nodeD18 = v0.d(nodeD16, "Description");
                        if (nodeD18 != null) {
                            lVar.f967b = v0.a(nodeD18);
                        }
                        Node nodeD19 = v0.d(nodeD16, "Icons");
                        if (nodeD19 != null) {
                            lVar.c = new ArrayList();
                            Iterator it9 = ((ArrayList) v0.c(nodeD19, "Icon")).iterator();
                            while (it9.hasNext()) {
                                lVar.c.add(v0.a((Node) it9.next()));
                            }
                        }
                        Node nodeD20 = v0.d(nodeD16, "Rating");
                        if (nodeD20 != null) {
                            try {
                                lVar.d = Float.parseFloat(v0.a(nodeD20));
                            } catch (Exception unused3) {
                            }
                        }
                        Node nodeD21 = v0.d(nodeD16, "Screenshots");
                        if (nodeD21 != null) {
                            lVar.e = new ArrayList();
                            Iterator it10 = ((ArrayList) v0.c(nodeD21, "Screenshot")).iterator();
                            while (it10.hasNext()) {
                                String strA5 = v0.a((Node) it10.next());
                                if (!TextUtils.isEmpty(strA5)) {
                                    lVar.e.add(strA5);
                                }
                            }
                        }
                        this.e = lVar;
                    }
                }
            }
        }
        a(node);
    }
}

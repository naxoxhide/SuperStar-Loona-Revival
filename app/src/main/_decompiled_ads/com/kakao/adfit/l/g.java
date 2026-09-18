package com.kakao.adfit.l;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: VastXmlParser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/kakao/adfit/l/g;", "", "", "data", "Lorg/xmlpull/v1/XmlPullParser;", "a", "p", "Lcom/kakao/adfit/l/e;", "", CampaignEx.JSON_KEY_AD_K, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "c", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/util/ArrayList;", "Lcom/kakao/adfit/l/d;", "h", "g", "Lcom/kakao/adfit/l/b;", "j", "i", "name", "Lcom/kakao/adfit/l/e$a;", "Lcom/kakao/adfit/l/e$a;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class g {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final VastModel.a model = new VastModel.a();

    /* JADX INFO: Access modifiers changed from: private */
    public final Tracking i(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "Tracking");
        Tracking.a aVarB = new Tracking.a().a(p.getAttributeValue(null, "event")).b(p.getAttributeValue(null, "offset"));
        String strNextText = p.nextText();
        Intrinsics.checkNotNullExpressionValue(strNextText, "p.nextText()");
        Tracking trackingA = aVarB.c(StringsKt.trim((CharSequence) strNextText).toString()).a();
        p.require(3, null, "Tracking");
        return trackingA;
    }

    public final VastModel b(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        XmlPullParser xmlPullParserA = a(data);
        if (xmlPullParserA == null) {
            return null;
        }
        return a(xmlPullParserA);
    }

    private final XmlPullParser a(String data) {
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(data));
            return xmlPullParserNewPullParser;
        } catch (Exception e) {
            com.kakao.adfit.k.f.b("Failed to create XmlPullParser.", e);
            com.kakao.adfit.e.f.a.a(new RuntimeException("Failed to create XmlPullParser.", e));
            return null;
        }
    }

    private final VastModel a(XmlPullParser p) {
        try {
            if (p.getEventType() == 0) {
                p.next();
            }
            k(p);
        } catch (Exception e) {
            com.kakao.adfit.k.f.c("Failed to parse VAST xml.", e);
            com.kakao.adfit.e.f.a.a(new RuntimeException("Failed to parse VAST xml.", e));
        }
        return this.model.a();
    }

    static /* synthetic */ void a(g gVar, XmlPullParser xmlPullParser, String str, int i, Object obj) throws XmlPullParserException, IOException {
        if ((i & 2) != 0) {
            str = xmlPullParser.getName();
            Intrinsics.checkNotNullExpressionValue(str, "p.name");
        }
        gVar.a(xmlPullParser, str);
    }

    private final void a(XmlPullParser p, String name) throws XmlPullParserException, IOException {
        p.require(2, null, name);
        int i = 1;
        do {
            int next = p.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        } while (i > 0);
        Unit unit = Unit.INSTANCE;
        p.require(3, null, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Tracking> j(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "TrackingEvents");
        ArrayList<Tracking> arrayList = new ArrayList<>();
        while (p.nextTag() == 2) {
            if (Intrinsics.areEqual(p.getName(), "Tracking")) {
                arrayList.add(i(p));
            } else {
                a(this, p, null, 2, null);
            }
        }
        p.require(3, null, "TrackingEvents");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0041  */
    /* JADX WARN: Code duplicated, block: B:17:0x005e  */
    public final VastMediaFile g(XmlPullParser p) throws XmlPullParserException, IOException {
        VastMediaFile vastMediaFileA;
        int iIntValue;
        int iIntValue2;
        p.require(2, null, "MediaFile");
        String attributeValue = p.getAttributeValue(null, "delivery");
        String attributeValue2 = p.getAttributeValue(null, "type");
        if (Intrinsics.areEqual(attributeValue, "progressive") && Intrinsics.areEqual(attributeValue2, "video/mp4")) {
            VastMediaFile.a aVar = new VastMediaFile.a();
            String attributeValue3 = p.getAttributeValue(null, "width");
            int iIntValue3 = 0;
            if (attributeValue3 != null) {
                Intrinsics.checkNotNullExpressionValue(attributeValue3, "getAttributeValue(null, \"width\")");
                Integer intOrNull = StringsKt.toIntOrNull(attributeValue3);
                if (intOrNull != null) {
                    iIntValue = intOrNull.intValue();
                } else {
                    iIntValue = 0;
                }
            } else {
                iIntValue = 0;
            }
            VastMediaFile.a aVarC = aVar.c(iIntValue);
            String attributeValue4 = p.getAttributeValue(null, "height");
            if (attributeValue4 != null) {
                Intrinsics.checkNotNullExpressionValue(attributeValue4, "getAttributeValue(null, \"height\")");
                Integer intOrNull2 = StringsKt.toIntOrNull(attributeValue4);
                if (intOrNull2 != null) {
                    iIntValue2 = intOrNull2.intValue();
                } else {
                    iIntValue2 = 0;
                }
            } else {
                iIntValue2 = 0;
            }
            VastMediaFile.a aVarB = aVarC.b(iIntValue2);
            String attributeValue5 = p.getAttributeValue(null, "bitrate");
            if (attributeValue5 != null) {
                Intrinsics.checkNotNullExpressionValue(attributeValue5, "getAttributeValue(null, \"bitrate\")");
                Integer intOrNull3 = StringsKt.toIntOrNull(attributeValue5);
                if (intOrNull3 != null) {
                    iIntValue3 = intOrNull3.intValue();
                }
            }
            VastMediaFile.a aVarA = aVarB.a(iIntValue3);
            String strNextText = p.nextText();
            Intrinsics.checkNotNullExpressionValue(strNextText, "p.nextText()");
            vastMediaFileA = aVarA.a(StringsKt.trim((CharSequence) strNextText).toString()).a();
        } else {
            p.nextText();
            vastMediaFileA = null;
        }
        p.require(3, null, "MediaFile");
        return vastMediaFileA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<VastMediaFile> h(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "MediaFiles");
        ArrayList<VastMediaFile> arrayList = new ArrayList<>();
        while (p.nextTag() == 2) {
            if (Intrinsics.areEqual(p.getName(), "MediaFile")) {
                VastMediaFile vastMediaFileG = g(p);
                if (vastMediaFileG != null) {
                    arrayList.add(vastMediaFileG);
                }
            } else {
                a(this, p, null, 2, null);
            }
        }
        p.require(3, null, "MediaFiles");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "Linear");
        while (p.nextTag() == 2) {
            String name = p.getName();
            if (name != null) {
                int iHashCode = name.hashCode();
                if (iHashCode != -1927368268) {
                    if (iHashCode != -385055469) {
                        if (iHashCode == 611554000 && name.equals("TrackingEvents")) {
                            this.model.b(j(p));
                        }
                    } else if (name.equals("MediaFiles")) {
                        this.model.a(h(p));
                    }
                } else if (name.equals("Duration")) {
                    VastModel.a aVar = this.model;
                    String strNextText = p.nextText();
                    Intrinsics.checkNotNullExpressionValue(strNextText, "p.nextText()");
                    aVar.a(StringsKt.trim((CharSequence) strNextText).toString());
                }
            }
            a(this, p, null, 2, null);
        }
        Unit unit = Unit.INSTANCE;
        p.require(3, null, "Linear");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "Creative");
        while (p.nextTag() == 2) {
            if (Intrinsics.areEqual(p.getName(), "Linear")) {
                f(p);
            } else {
                a(this, p, null, 2, null);
            }
        }
        Unit unit = Unit.INSTANCE;
        p.require(3, null, "Creative");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "Creatives");
        while (p.nextTag() == 2) {
            if (Intrinsics.areEqual(p.getName(), "Creative")) {
                c(p);
            } else {
                a(this, p, null, 2, null);
            }
        }
        Unit unit = Unit.INSTANCE;
        p.require(3, null, "Creatives");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "InLine");
        while (p.nextTag() == 2) {
            String name = p.getName();
            if (Intrinsics.areEqual(name, "Creatives")) {
                d(p);
            } else if (Intrinsics.areEqual(name, "Error")) {
                VastModel.a aVar = this.model;
                String strNextText = p.nextText();
                Intrinsics.checkNotNullExpressionValue(strNextText, "p.nextText()");
                aVar.b(StringsKt.trim((CharSequence) strNextText).toString());
            } else {
                a(this, p, null, 2, null);
            }
        }
        Unit unit = Unit.INSTANCE;
        p.require(3, null, "InLine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "Ad");
        while (p.nextTag() == 2) {
            if (Intrinsics.areEqual(p.getName(), "InLine")) {
                e(p);
            } else {
                a(this, p, null, 2, null);
            }
        }
        Unit unit = Unit.INSTANCE;
        p.require(3, null, "Ad");
    }

    private final void k(XmlPullParser p) throws XmlPullParserException, IOException {
        p.require(2, null, "VAST");
        while (p.nextTag() == 2) {
            if (Intrinsics.areEqual(p.getName(), "Ad")) {
                b(p);
            } else {
                a(this, p, null, 2, null);
            }
        }
        Unit unit = Unit.INSTANCE;
        p.require(3, null, "VAST");
    }
}

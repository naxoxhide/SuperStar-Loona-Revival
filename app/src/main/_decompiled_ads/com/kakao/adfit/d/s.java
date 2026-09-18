package com.kakao.adfit.d;

import android.graphics.Color;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.l.VastMediaFile;
import com.kakao.adfit.l.VastModel;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAd.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0000\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000H\u0000\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0000\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0000H\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000H\u0000\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0000H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u0000H\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u0000H\u0000\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0000H\u0000\u001a\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u00020\u0000H\u0000\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u0000H\u0000\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0019*\u00020\u0000H\u0000\u001a\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u001c*\u00020\u001bH\u0003¢\u0006\u0004\b\u0010\u0010\u001d¨\u0006\u001e"}, d2 = {"Lorg/json/JSONObject;", "Lcom/kakao/adfit/d/p;", "i", "Lcom/kakao/adfit/d/p$j;", CampaignEx.JSON_KEY_AD_K, "Lcom/kakao/adfit/d/p$c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p$k;", "l", "Lcom/kakao/adfit/d/p$f;", "e", "Lcom/kakao/adfit/d/p$e;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/d/p$g;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/d/p$b;", "a", "Lcom/kakao/adfit/d/p$l;", InneractiveMediationDefs.GENDER_MALE, "Lcom/kakao/adfit/d/p$d;", "c", "Lcom/kakao/adfit/d/p$h;", "h", "Lcom/kakao/adfit/d/p$h$a;", "g", "Lcom/kakao/adfit/d/p$i;", "j", "", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "library_networkRelease"}, k = 2, mv = {1, 6, 0})
public final class s {
    public static final p.b a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strE = com.kakao.adfit.k.p.e(jSONObject, "type");
        if (strE != null) {
            int iHashCode = strE.hashCode();
            if (iHashCode != 100313435) {
                if (iHashCode != 104256825) {
                    if (iHashCode == 112202875 && strE.equals("video")) {
                        return m(jSONObject);
                    }
                } else if (strE.equals("multi")) {
                    return h(jSONObject);
                }
            } else if (strE.equals("image")) {
                return c(jSONObject);
            }
        }
        return null;
    }

    public static final p.c b(JSONObject jSONObject) {
        p.e eVarD;
        Integer numA;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strE = com.kakao.adfit.k.p.e(jSONObject, "url");
        if (strE == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("width");
        int iOptInt2 = jSONObject.optInt("height");
        String strE2 = com.kakao.adfit.k.p.e(jSONObject, "bgcolor");
        int iIntValue = (strE2 == null || (numA = a(strE2)) == null) ? 0 : numA.intValue();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("link");
        if (jSONObjectOptJSONObject != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
            eVarD = d(jSONObjectOptJSONObject);
        } else {
            eVarD = null;
        }
        return new p.c(strE, iOptInt, iOptInt2, iIntValue, eVarD);
    }

    public static final p.d c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        p.c cVarB;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        p.j jVarK = null;
        if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || (cVarB = b(jSONObjectOptJSONObject)) == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("callToAction");
        if (jSONObjectOptJSONObject2 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(key)");
            jVarK = k(jSONObjectOptJSONObject2);
        }
        return new p.d(cVarB, jVarK, com.kakao.adfit.a.f.a(jSONObject));
    }

    public static final p.e d(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strE = com.kakao.adfit.k.p.e(jSONObject, "url");
        List listEmptyList = null;
        if (strE == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("clicktrackers");
        if (jSONArrayOptJSONArray != null) {
            Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
            ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object objOpt = jSONArrayOptJSONArray.opt(i);
                if (!(objOpt instanceof String)) {
                    objOpt = null;
                }
                String str = (String) objOpt;
                if (str != null) {
                    arrayList.add(str);
                }
            }
            listEmptyList = arrayList;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return new p.e(strE, listEmptyList);
    }

    public static final p.f e(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        p.k kVarL = l(jSONObject);
        if (kVarL != null) {
            return kVarL;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mainImage");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
        return b(jSONObjectOptJSONObject);
    }

    public static final p.g f(JSONObject jSONObject) {
        p.c cVarB;
        p.c cVarB2;
        ArrayList arrayList;
        Long longOrNull;
        p.c cVarB3;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        p.k kVarL = l(jSONObject);
        if (kVarL != null) {
            p.k kVar = kVarL.getImage() != null ? kVarL : null;
            if (kVar != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("backgroundImage");
                if (jSONObjectOptJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                    cVarB = b(jSONObjectOptJSONObject);
                } else {
                    cVarB = null;
                }
                if (cVarB == null) {
                    return null;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("textImage");
                if (jSONObjectOptJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(key)");
                    cVarB2 = b(jSONObjectOptJSONObject2);
                } else {
                    cVarB2 = null;
                }
                if (cVarB2 == null) {
                    return null;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("objectImages");
                if (jSONArrayOptJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
                    arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                    int length = jSONArrayOptJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject3, "optJSONObject(index)");
                            cVarB3 = b(jSONObjectOptJSONObject3);
                        } else {
                            cVarB3 = null;
                        }
                        if (cVarB3 != null) {
                            arrayList.add(cVarB3);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    ArrayList arrayList2 = arrayList.isEmpty() ^ true ? arrayList : null;
                    if (arrayList2 != null) {
                        String strE = com.kakao.adfit.k.p.e(jSONObject, TJAdUnitConstants.String.INTERVAL);
                        return new p.g(kVar, cVarB, cVarB2, arrayList2, (strE == null || (longOrNull = StringsKt.toLongOrNull(strE)) == null) ? 0L : longOrNull.longValue() * ((long) 1000), com.kakao.adfit.k.p.e(jSONObject, "intervalKey"));
                    }
                }
            }
        }
        return null;
    }

    public static final p.h.a g(JSONObject jSONObject) {
        p.c cVarB;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strE = com.kakao.adfit.k.p.e(jSONObject, "landingUrl");
        p.j jVarK = null;
        if (strE != null) {
            String str = StringsKt.isBlank(strE) ^ true ? strE : null;
            if (str != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("image");
                if (jSONObjectOptJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                    cVarB = b(jSONObjectOptJSONObject);
                } else {
                    cVarB = null;
                }
                if (cVarB == null) {
                    return null;
                }
                String strE2 = com.kakao.adfit.k.p.e(jSONObject, "title");
                String strE3 = com.kakao.adfit.k.p.e(jSONObject, "price");
                String strE4 = com.kakao.adfit.k.p.e(jSONObject, "discountPrice");
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("callToAction");
                if (jSONObjectOptJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(key)");
                    jVarK = k(jSONObjectOptJSONObject2);
                }
                return new p.h.a(cVarB, strE2, strE3, strE4, jVarK, str, com.kakao.adfit.a.f.a(jSONObject));
            }
        }
        return null;
    }

    public static final p.h h(JSONObject jSONObject) {
        ArrayList arrayList;
        p.h.a aVarG;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("multi");
        if (jSONArrayOptJSONArray != null) {
            Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
            arrayList = new ArrayList(jSONArrayOptJSONArray.length());
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(index)");
                    aVarG = g(jSONObjectOptJSONObject);
                } else {
                    aVarG = null;
                }
                if (aVarG != null) {
                    arrayList.add(aVarG);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            if (!(!arrayList.isEmpty())) {
                arrayList = null;
            }
            if (arrayList != null) {
                return new p.h(arrayList, com.kakao.adfit.a.f.a(jSONObject));
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x011a A[RETURN] */
    public static final p i(JSONObject jSONObject) {
        String strE;
        String strE2;
        p.e eVarD;
        p.e eVarD2;
        p.c cVarB;
        p.e eVarD3;
        ArrayList arrayList;
        boolean z;
        p.g gVarF;
        p.b bVarA;
        p.c cVarB2;
        p.i iVarJ;
        p.j jVarK;
        boolean z2;
        p.j jVarK2;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strE3 = com.kakao.adfit.k.p.e(jSONObject, "type");
        if (strE3 == null) {
            return null;
        }
        if (!Intrinsics.areEqual(strE3, "native")) {
            strE3 = null;
        }
        if (strE3 == null || (strE = com.kakao.adfit.k.p.e(jSONObject, "landingUrl")) == null) {
            return null;
        }
        String str = StringsKt.isBlank(strE) ^ true ? strE : null;
        if (str == null || (strE2 = com.kakao.adfit.k.p.e(jSONObject, "adInfoUrl")) == null) {
            return null;
        }
        String str2 = StringsKt.isBlank(strE2) ^ true ? strE2 : null;
        if (str2 == null) {
            return null;
        }
        String strE4 = com.kakao.adfit.k.p.e(jSONObject, "title");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("titleLink");
        if (jSONObjectOptJSONObject != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
            eVarD = d(jSONObjectOptJSONObject);
        } else {
            eVarD = null;
        }
        String strE5 = com.kakao.adfit.k.p.e(jSONObject, "body");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("bodyLink");
        if (jSONObjectOptJSONObject2 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(key)");
            eVarD2 = d(jSONObjectOptJSONObject2);
        } else {
            eVarD2 = null;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("bodyExt");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("profileIcon");
        if (jSONObjectOptJSONObject4 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject4, "optJSONObject(key)");
            cVarB = b(jSONObjectOptJSONObject4);
        } else {
            cVarB = null;
        }
        String strE6 = com.kakao.adfit.k.p.e(jSONObject, "profileName");
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("profileNameLink");
        if (jSONObjectOptJSONObject5 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject5, "optJSONObject(key)");
            eVarD3 = d(jSONObjectOptJSONObject5);
        } else {
            eVarD3 = null;
        }
        p.f fVarE = e(jSONObject);
        String strE7 = com.kakao.adfit.k.p.e(jSONObject, "callToAction");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("callToActions");
        if (jSONArrayOptJSONArray != null) {
            Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
            ArrayList arrayList2 = new ArrayList(jSONArrayOptJSONArray.length());
            int length = jSONArrayOptJSONArray.length();
            int i = 0;
            while (i < length) {
                int i2 = length;
                JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject6 != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject6, "optJSONObject(index)");
                    jVarK2 = k(jSONObjectOptJSONObject6);
                } else {
                    jVarK2 = null;
                }
                if (jVarK2 != null) {
                    arrayList2.add(jVarK2);
                }
                i++;
                length = i2;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (fVarE == null && strE4 == null && strE5 == null && cVarB == null && strE6 == null && strE7 == null) {
            if (arrayList != null) {
                z = true;
                z2 = arrayList.isEmpty() ^ true;
                if (!z2) {
                    return null;
                }
            } else {
                z = true;
            }
            if (!z2) {
                return null;
            }
        } else {
            z = true;
        }
        String strE8 = com.kakao.adfit.k.p.e(jSONObject, "dspId");
        if (strE8 == null) {
            strE8 = "";
        }
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("motion");
        if (jSONObjectOptJSONObject7 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject7, "optJSONObject(key)");
            gVarF = f(jSONObjectOptJSONObject7);
        } else {
            gVarF = null;
        }
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("expandable");
        if (jSONObjectOptJSONObject8 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject8, "optJSONObject(key)");
            bVarA = a(jSONObjectOptJSONObject8);
        } else {
            bVarA = null;
        }
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("adInfoIcon");
        if (jSONObjectOptJSONObject9 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject9, "optJSONObject(key)");
            cVarB2 = b(jSONObjectOptJSONObject9);
        } else {
            cVarB2 = null;
        }
        JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("mainImageAdInfoPosition");
        if (jSONObjectOptJSONObject10 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject10, "optJSONObject(key)");
            iVarJ = j(jSONObjectOptJSONObject10);
        } else {
            iVarJ = null;
        }
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("plusFriend");
        if (jSONObjectOptJSONObject11 != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject11, "optJSONObject(key)");
            jVarK = k(jSONObjectOptJSONObject11);
        } else {
            jVarK = null;
        }
        return new p(strE4, eVarD, strE5, eVarD2, jSONObjectOptJSONObject3, cVarB, strE6, eVarD3, fVarE, strE7, arrayList, gVarF, bVarA, cVarB2, str2, true, true, iVarJ, jVarK, com.kakao.adfit.k.p.e(jSONObject, "altText"), com.kakao.adfit.k.p.e(jSONObject, "feedbackUrl"), com.kakao.adfit.k.p.e(jSONObject, "ckeywords"), str, (StringsKt.isBlank(strE8) || Intrinsics.areEqual(strE8, "ADFIT")) ? z : false, strE8, com.kakao.adfit.k.p.e(jSONObject, "displayUrl"), com.kakao.adfit.a.f.a(jSONObject));
    }

    public static final p.i j(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        int iOptInt = jSONObject.optInt("width");
        int iOptInt2 = jSONObject.optInt("height");
        if (iOptInt > 0 || iOptInt2 > 0) {
            return new p.i(jSONObject.optInt("x"), jSONObject.optInt("y"), iOptInt, iOptInt2);
        }
        return null;
    }

    public static final p.j k(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strE = com.kakao.adfit.k.p.e(jSONObject, "text");
        p.e eVarD = null;
        if (strE == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("link");
        if (jSONObjectOptJSONObject != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
            eVarD = d(jSONObjectOptJSONObject);
        }
        return new p.j(strE, eVarD, jSONObject.optJSONObject("ext"));
    }

    public static final p.k l(JSONObject jSONObject) {
        VastModel vastModelB;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strE = com.kakao.adfit.k.p.e(jSONObject, "vastTag");
        p.c cVarB = null;
        if (strE != null && (vastModelB = new com.kakao.adfit.l.g().b(strE)) != null) {
            List<VastMediaFile> listC = vastModelB.c();
            if (!(listC != null && (listC.isEmpty() ^ true))) {
                vastModelB = null;
            }
            if (vastModelB != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoImage");
                if (jSONObjectOptJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                    cVarB = b(jSONObjectOptJSONObject);
                }
                return new p.k(vastModelB, cVarB);
            }
        }
        return null;
    }

    public static final p.l m(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        p.k kVarL = l(jSONObject);
        p.j jVarK = null;
        if (kVarL == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("callToAction");
        if (jSONObjectOptJSONObject != null) {
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
            jVarK = k(jSONObjectOptJSONObject);
        }
        return new p.l(kVarL, jVarK, com.kakao.adfit.a.f.a(jSONObject));
    }

    private static final Integer a(String str) {
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception unused) {
            return null;
        }
    }
}

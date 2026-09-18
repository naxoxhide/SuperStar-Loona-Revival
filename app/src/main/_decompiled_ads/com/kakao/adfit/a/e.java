package com.kakao.adfit.a;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR'\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR'\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\r\u0010\bR'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u0005\u0010\bR'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/kakao/adfit/a/e;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "renderedTrackers", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "viewableTrackers", "getExposeTrackers", "exposeTrackers", "clickTrackers", "e", "hideTrackers", "<init>", "()V", "Lorg/json/JSONArray;", "events", "(Lorg/json/JSONArray;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ArrayList<String> renderedTrackers;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> viewableTrackers;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ArrayList<String> exposeTrackers;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ArrayList<String> clickTrackers;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final ArrayList<String> hideTrackers;

    public e() {
        this.renderedTrackers = new ArrayList<>();
        this.viewableTrackers = new ArrayList<>();
        this.exposeTrackers = new ArrayList<>();
        this.clickTrackers = new ArrayList<>();
        this.hideTrackers = new ArrayList<>();
    }

    public final ArrayList<String> a() {
        return this.clickTrackers;
    }

    public final ArrayList<String> b() {
        return this.hideTrackers;
    }

    public final ArrayList<String> c() {
        return this.renderedTrackers;
    }

    public final ArrayList<String> d() {
        return this.viewableTrackers;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public e(JSONArray events) {
        String strOptString;
        String strOptString2;
        Intrinsics.checkNotNullParameter(events, "events");
        this.renderedTrackers = new ArrayList<>();
        this.viewableTrackers = new ArrayList<>();
        this.exposeTrackers = new ArrayList<>();
        this.clickTrackers = new ArrayList<>();
        this.hideTrackers = new ArrayList<>();
        int length = events.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = events.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("type")) != null && (strOptString2 = jSONObjectOptJSONObject.optString("url")) != null) {
                Locale ENGLISH = Locale.ENGLISH;
                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                String lowerCase = strOptString.toLowerCase(ENGLISH);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                switch (lowerCase.hashCode()) {
                    case -1289153596:
                        if (lowerCase.equals("expose")) {
                            this.exposeTrackers.add(strOptString2);
                        }
                        break;
                    case -494845771:
                        if (lowerCase.equals(TJAdUnitConstants.String.VIDEO_RENDERED)) {
                            this.renderedTrackers.add(strOptString2);
                        }
                        break;
                    case 3202370:
                        if (lowerCase.equals("hide")) {
                            this.hideTrackers.add(strOptString2);
                        }
                        break;
                    case 94750088:
                        if (lowerCase.equals("click")) {
                            this.clickTrackers.add(strOptString2);
                        }
                        break;
                    case 1196225919:
                        if (lowerCase.equals("viewable")) {
                            this.viewableTrackers.add(strOptString2);
                        }
                        break;
                }
            }
        }
    }
}

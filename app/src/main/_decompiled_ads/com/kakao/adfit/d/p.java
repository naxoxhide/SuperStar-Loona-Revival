package com.kakao.adfit.d;

import androidx.core.app.NotificationCompat;
import com.facebook.share.internal.ShareConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakao.adfit.l.VastModel;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAd.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 o2\u00020\u0001:\f\u0003\t\u000e\u0011\u0015\u001b \u000f&+(4B\u008d\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\b\u0012\b\u0010*\u001a\u0004\u0018\u00010%\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-\u0012\b\u00108\u001a\u0004\u0018\u000103\u0012\b\u0010=\u001a\u0004\u0018\u000109\u0012\b\u0010>\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010?\u001a\u00020\u0002\u0012\u0006\u0010E\u001a\u00020@\u0012\u0006\u0010H\u001a\u00020@\u0012\b\u0010N\u001a\u0004\u0018\u00010I\u0012\b\u0010S\u001a\u0004\u0018\u00010.\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010]\u001a\u00020\u0002\u0012\u0006\u0010_\u001a\u00020@\u0012\u0006\u0010b\u001a\u00020\u0002\u0012\b\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010j\u001a\u00020f¢\u0006\u0004\bm\u0010nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u0019\u0010$\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b#\u0010\fR\u0019\u0010*\u001a\u0004\u0018\u00010%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010,\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001f\u00102\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0006¢\u0006\f\n\u0004\b(\u0010/\u001a\u0004\b0\u00101R\u0019\u00108\u001a\u0004\u0018\u0001038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010=\u001a\u0004\u0018\u0001098\u0006¢\u0006\f\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010>\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u0015\u0010\u001eR\u0017\u0010?\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0017\u0010E\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010H\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bF\u0010B\u001a\u0004\bG\u0010DR\u0019\u0010N\u001a\u0004\u0018\u00010I8\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010S\u001a\u0004\u0018\u00010.8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0019\u0010U\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bT\u0010\u0004\u001a\u0004\b \u0010\u0006R\u0019\u0010X\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bV\u0010\u0004\u001a\u0004\bW\u0010\u0006R\u0019\u0010[\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bY\u0010\u0004\u001a\u0004\bZ\u0010\u0006R\u0017\u0010]\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\\\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u0017\u0010_\u001a\u00020@8\u0006¢\u0006\f\n\u0004\b^\u0010B\u001a\u0004\b_\u0010DR\u0017\u0010b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006R\u0019\u0010e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bc\u0010\u0004\u001a\u0004\bd\u0010\u0006R\u001a\u0010j\u001a\u00020f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\b\u0003\u0010iR\u001a\u0010l\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\bk\u0010\u0004\u001a\u0004\b4\u0010\u0006¨\u0006p"}, d2 = {"Lcom/kakao/adfit/d/p;", "Lcom/kakao/adfit/a/a;", "", "a", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "title", "Lcom/kakao/adfit/d/p$e;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p$e;", "getTitleLink", "()Lcom/kakao/adfit/d/p$e;", "titleLink", "c", "h", "body", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getBodyLink", "bodyLink", "Lorg/json/JSONObject;", "e", "Lorg/json/JSONObject;", "getBodyExt", "()Lorg/json/JSONObject;", "bodyExt", "Lcom/kakao/adfit/d/p$c;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/d/p$c;", InneractiveMediationDefs.GENDER_MALE, "()Lcom/kakao/adfit/d/p$c;", "profileIcon", "g", "n", "profileName", "getProfileNameLink", "profileNameLink", "Lcom/kakao/adfit/d/p$f;", "i", "Lcom/kakao/adfit/d/p$f;", CampaignEx.JSON_KEY_AD_K, "()Lcom/kakao/adfit/d/p$f;", ShareConstants.WEB_DIALOG_PARAM_MEDIA, "j", "callToAction", "", "Lcom/kakao/adfit/d/p$j;", "Ljava/util/List;", "getCallToActions", "()Ljava/util/List;", "callToActions", "Lcom/kakao/adfit/d/p$g;", "l", "Lcom/kakao/adfit/d/p$g;", "getMotion", "()Lcom/kakao/adfit/d/p$g;", "motion", "Lcom/kakao/adfit/d/p$b;", "Lcom/kakao/adfit/d/p$b;", "getExpandable", "()Lcom/kakao/adfit/d/p$b;", "expandable", "adInfoIcon", "adInfoUrl", "", "p", "Z", "getUseAdInfoIcon", "()Z", "useAdInfoIcon", CampaignEx.JSON_KEY_AD_Q, "getUseAdInfoUrl", "useAdInfoUrl", "Lcom/kakao/adfit/d/p$i;", CampaignEx.JSON_KEY_AD_R, "Lcom/kakao/adfit/d/p$i;", "getMainImageAdInfoPosition", "()Lcom/kakao/adfit/d/p$i;", "mainImageAdInfoPosition", "s", "Lcom/kakao/adfit/d/p$j;", "getPlusFriend", "()Lcom/kakao/adfit/d/p$j;", "plusFriend", "t", "altText", "u", "getFeedbackUrl", "feedbackUrl", "v", "getCkeywords", "ckeywords", "w", "landingUrl", "x", "isHouseAd", "y", "getDspId", "dspId", "z", "getDisplayUrl", "displayUrl", "Lcom/kakao/adfit/a/e;", "A", "Lcom/kakao/adfit/a/e;", "()Lcom/kakao/adfit/a/e;", "tracker", "B", "name", "<init>", "(Ljava/lang/String;Lcom/kakao/adfit/d/p$e;Ljava/lang/String;Lcom/kakao/adfit/d/p$e;Lorg/json/JSONObject;Lcom/kakao/adfit/d/p$c;Ljava/lang/String;Lcom/kakao/adfit/d/p$e;Lcom/kakao/adfit/d/p$f;Ljava/lang/String;Ljava/util/List;Lcom/kakao/adfit/d/p$g;Lcom/kakao/adfit/d/p$b;Lcom/kakao/adfit/d/p$c;Ljava/lang/String;ZZLcom/kakao/adfit/d/p$i;Lcom/kakao/adfit/d/p$j;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/kakao/adfit/a/e;)V", "C", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class p implements com.kakao.adfit.a.a {
    private static final AtomicInteger D = new AtomicInteger(1);

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final com.kakao.adfit.a.e tracker;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String title;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final e titleLink;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String body;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final e bodyLink;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final JSONObject bodyExt;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final c profileIcon;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String profileName;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final e profileNameLink;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final f media;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final String callToAction;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final List<j> callToActions;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final g motion;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final b expandable;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final c adInfoIcon;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final String adInfoUrl;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final boolean useAdInfoIcon;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final boolean useAdInfoUrl;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final i mainImageAdInfoPosition;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final j plusFriend;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final String altText;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final String feedbackUrl;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final String ckeywords;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final String landingUrl;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final boolean isHouseAd;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final String dspId;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private final String displayUrl;

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/d/p$b;", "", "Lcom/kakao/adfit/a/e;", "a", "Lcom/kakao/adfit/a/e;", "getTrackers", "()Lcom/kakao/adfit/a/e;", "trackers", "<init>", "(Lcom/kakao/adfit/a/e;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final com.kakao.adfit.a.e trackers;

        public b(com.kakao.adfit.a.e trackers) {
            Intrinsics.checkNotNullParameter(trackers, "trackers");
            this.trackers = trackers;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/d/p$c;", "Lcom/kakao/adfit/d/p$f;", "", "a", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", "url", "", "I", "c", "()I", "width", "height", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getBackgroundColor", "backgroundColor", "Lcom/kakao/adfit/d/p$e;", "e", "Lcom/kakao/adfit/d/p$e;", "getLink", "()Lcom/kakao/adfit/d/p$e;", "link", "<init>", "(Ljava/lang/String;IIILcom/kakao/adfit/d/p$e;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c implements f {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final String url;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int width;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final int height;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final int backgroundColor;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private final e link;

        public c(String url, int i, int i2, int i3, e eVar) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.width = i;
            this.height = i2;
            this.backgroundColor = i3;
            this.link = eVar;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getWidth() {
            return this.width;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/kakao/adfit/d/p$d;", "Lcom/kakao/adfit/d/p$b;", "Lcom/kakao/adfit/d/p$c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p$c;", "getImage", "()Lcom/kakao/adfit/d/p$c;", "image", "Lcom/kakao/adfit/d/p$j;", "c", "Lcom/kakao/adfit/d/p$j;", "getCallToAction", "()Lcom/kakao/adfit/d/p$j;", "callToAction", "Lcom/kakao/adfit/a/e;", "trackers", "<init>", "(Lcom/kakao/adfit/d/p$c;Lcom/kakao/adfit/d/p$j;Lcom/kakao/adfit/a/e;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final c image;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final j callToAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c image, j jVar, com.kakao.adfit.a.e trackers) {
            super(trackers);
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(trackers, "trackers");
            this.image = image;
            this.callToAction = jVar;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/d/p$e;", "", "", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "getTrackers", "()Ljava/util/List;", "trackers", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class e {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final String url;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final List<String> trackers;

        public e(String url, List<String> trackers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(trackers, "trackers");
            this.url = url;
            this.trackers = trackers;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/kakao/adfit/d/p$f;", "", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface f {
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/kakao/adfit/d/p$g;", "", "Lcom/kakao/adfit/d/p$k;", "a", "Lcom/kakao/adfit/d/p$k;", "getVideo", "()Lcom/kakao/adfit/d/p$k;", "video", "Lcom/kakao/adfit/d/p$c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p$c;", "getBackgroundImage", "()Lcom/kakao/adfit/d/p$c;", "backgroundImage", "c", "getTextImage", "textImage", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/util/List;", "getObjectImages", "()Ljava/util/List;", "objectImages", "", "e", "J", "getInterval", "()J", TJAdUnitConstants.String.INTERVAL, "", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/lang/String;", "getIntervalKey", "()Ljava/lang/String;", "intervalKey", "<init>", "(Lcom/kakao/adfit/d/p$k;Lcom/kakao/adfit/d/p$c;Lcom/kakao/adfit/d/p$c;Ljava/util/List;JLjava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class g {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final k video;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final c backgroundImage;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final c textImage;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final List<c> objectImages;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private final long interval;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private final String intervalKey;

        public g(k video, c backgroundImage, c textImage, List<c> objectImages, long j, String str) {
            Intrinsics.checkNotNullParameter(video, "video");
            Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
            Intrinsics.checkNotNullParameter(textImage, "textImage");
            Intrinsics.checkNotNullParameter(objectImages, "objectImages");
            this.video = video;
            this.backgroundImage = backgroundImage;
            this.textImage = textImage;
            this.objectImages = objectImages;
            this.interval = j;
            this.intervalKey = str;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\rB\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/kakao/adfit/d/p$h;", "Lcom/kakao/adfit/d/p$b;", "", "Lcom/kakao/adfit/d/p$h$a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "getItems", "()Ljava/util/List;", FirebaseAnalytics.Param.ITEMS, "Lcom/kakao/adfit/a/e;", "trackers", "<init>", "(Ljava/util/List;Lcom/kakao/adfit/a/e;)V", "a", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class h extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final List<a> items;

        /* JADX INFO: compiled from: NativeAd.kt */
        @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/kakao/adfit/d/p$h$a;", "", "Lcom/kakao/adfit/d/p$c;", "a", "Lcom/kakao/adfit/d/p$c;", "getImage", "()Lcom/kakao/adfit/d/p$c;", "image", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getPrice", "price", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getDiscountPrice", "discountPrice", "Lcom/kakao/adfit/d/p$j;", "e", "Lcom/kakao/adfit/d/p$j;", "getCallToAction", "()Lcom/kakao/adfit/d/p$j;", "callToAction", InneractiveMediationDefs.GENDER_FEMALE, "getLandingUrl", "landingUrl", "Lcom/kakao/adfit/a/e;", "g", "Lcom/kakao/adfit/a/e;", "getTrackers", "()Lcom/kakao/adfit/a/e;", "trackers", "<init>", "(Lcom/kakao/adfit/d/p$c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/adfit/d/p$j;Ljava/lang/String;Lcom/kakao/adfit/a/e;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata */
            private final c image;

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final String title;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            private final String price;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            private final String discountPrice;

            /* JADX INFO: renamed from: e, reason: from kotlin metadata */
            private final j callToAction;

            /* JADX INFO: renamed from: f, reason: from kotlin metadata */
            private final String landingUrl;

            /* JADX INFO: renamed from: g, reason: from kotlin metadata */
            private final com.kakao.adfit.a.e trackers;

            public a(c image, String str, String str2, String str3, j jVar, String landingUrl, com.kakao.adfit.a.e trackers) {
                Intrinsics.checkNotNullParameter(image, "image");
                Intrinsics.checkNotNullParameter(landingUrl, "landingUrl");
                Intrinsics.checkNotNullParameter(trackers, "trackers");
                this.image = image;
                this.title = str;
                this.price = str2;
                this.discountPrice = str3;
                this.callToAction = jVar;
                this.landingUrl = landingUrl;
                this.trackers = trackers;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(List<a> items, com.kakao.adfit.a.e trackers) {
            super(trackers);
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(trackers, "trackers");
            this.items = items;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/kakao/adfit/d/p$i;", "", "", "a", "I", "getX", "()I", "x", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getY", "y", "c", "getW", "w", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getH", "h", "<init>", "(IIII)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class i {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int x;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int y;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final int w;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final int h;

        public i(int i, int i2, int i3, int i4) {
            this.x = i;
            this.y = i2;
            this.w = i3;
            this.h = i4;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/d/p$j;", "", "", "a", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "Lcom/kakao/adfit/d/p$e;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p$e;", "getLink", "()Lcom/kakao/adfit/d/p$e;", "link", "Lorg/json/JSONObject;", "c", "Lorg/json/JSONObject;", "getExt", "()Lorg/json/JSONObject;", "ext", "<init>", "(Ljava/lang/String;Lcom/kakao/adfit/d/p$e;Lorg/json/JSONObject;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class j {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final String text;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final e link;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final JSONObject ext;

        public j(String text, e eVar, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.link = eVar;
            this.ext = jSONObject;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010\"\u0004\b\u0003\u0010\u0011R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\t\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u0003\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/kakao/adfit/d/p$k;", "Lcom/kakao/adfit/d/p$f;", "Lcom/kakao/adfit/l/e;", "a", "Lcom/kakao/adfit/l/e;", "e", "()Lcom/kakao/adfit/l/e;", "vast", "Lcom/kakao/adfit/d/p$c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p$c;", "()Lcom/kakao/adfit/d/p$c;", "image", "", "c", "I", "()I", "(I)V", "duration", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, NotificationCompat.CATEGORY_PROGRESS, "", "Z", "()Z", "(Z)V", CampaignEx.JSON_NATIVE_VIDEO_MUTE, "<init>", "(Lcom/kakao/adfit/l/e;Lcom/kakao/adfit/d/p$c;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class k implements f {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final VastModel vast;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final c image;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private int duration;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private int progress;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private boolean mute;

        public k(VastModel vast, c cVar) {
            Intrinsics.checkNotNullParameter(vast, "vast");
            this.vast = vast;
            this.image = cVar;
            this.duration = (int) com.kakao.adfit.l.f.a(vast.getDuration());
            this.mute = true;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final c getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getMute() {
            return this.mute;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getProgress() {
            return this.progress;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final VastModel getVast() {
            return this.vast;
        }

        public final void a(int i) {
            this.duration = i;
        }

        public final void b(int i) {
            this.progress = i;
        }

        public final void a(boolean z) {
            this.mute = z;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/kakao/adfit/d/p$l;", "Lcom/kakao/adfit/d/p$b;", "Lcom/kakao/adfit/d/p$k;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p$k;", "getVideo", "()Lcom/kakao/adfit/d/p$k;", "video", "Lcom/kakao/adfit/d/p$j;", "c", "Lcom/kakao/adfit/d/p$j;", "getCallToAction", "()Lcom/kakao/adfit/d/p$j;", "callToAction", "Lcom/kakao/adfit/a/e;", "trackers", "<init>", "(Lcom/kakao/adfit/d/p$k;Lcom/kakao/adfit/d/p$j;Lcom/kakao/adfit/a/e;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class l extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final k video;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final j callToAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(k video, j jVar, com.kakao.adfit.a.e trackers) {
            super(trackers);
            Intrinsics.checkNotNullParameter(video, "video");
            Intrinsics.checkNotNullParameter(trackers, "trackers");
            this.video = video;
            this.callToAction = jVar;
        }
    }

    public p(String str, e eVar, String str2, e eVar2, JSONObject jSONObject, c cVar, String str3, e eVar3, f fVar, String str4, List<j> list, g gVar, b bVar, c cVar2, String adInfoUrl, boolean z, boolean z2, i iVar, j jVar, String str5, String str6, String str7, String landingUrl, boolean z3, String dspId, String str8, com.kakao.adfit.a.e tracker) {
        Intrinsics.checkNotNullParameter(adInfoUrl, "adInfoUrl");
        Intrinsics.checkNotNullParameter(landingUrl, "landingUrl");
        Intrinsics.checkNotNullParameter(dspId, "dspId");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.title = str;
        this.titleLink = eVar;
        this.body = str2;
        this.bodyLink = eVar2;
        this.bodyExt = jSONObject;
        this.profileIcon = cVar;
        this.profileName = str3;
        this.profileNameLink = eVar3;
        this.media = fVar;
        this.callToAction = str4;
        this.callToActions = list;
        this.motion = gVar;
        this.expandable = bVar;
        this.adInfoIcon = cVar2;
        this.adInfoUrl = adInfoUrl;
        this.useAdInfoIcon = z;
        this.useAdInfoUrl = z2;
        this.mainImageAdInfoPosition = iVar;
        this.plusFriend = jVar;
        this.altText = str5;
        this.feedbackUrl = str6;
        this.ckeywords = str7;
        this.landingUrl = landingUrl;
        this.isHouseAd = z3;
        this.dspId = dspId;
        this.displayUrl = str8;
        this.tracker = tracker;
        this.name = "NativeAd-" + D.getAndIncrement();
    }

    @Override // com.kakao.adfit.a.a
    /* JADX INFO: renamed from: a, reason: from getter */
    public com.kakao.adfit.a.e getTracker() {
        return this.tracker;
    }

    @Override // com.kakao.adfit.a.a
    public ArrayList<String> b() {
        return com.kakao.adfit.a.a.C0442a.c(this);
    }

    @Override // com.kakao.adfit.a.a
    public ArrayList<String> c() {
        return com.kakao.adfit.a.a.C0442a.b(this);
    }

    @Override // com.kakao.adfit.a.a
    public ArrayList<String> d() {
        return com.kakao.adfit.a.a.C0442a.a(this);
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final c getAdInfoIcon() {
        return this.adInfoIcon;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getAdInfoUrl() {
        return this.adInfoUrl;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getAltText() {
        return this.altText;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getCallToAction() {
        return this.callToAction;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getLandingUrl() {
        return this.landingUrl;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final f getMedia() {
        return this.media;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final c getProfileIcon() {
        return this.profileIcon;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getProfileName() {
        return this.profileName;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}

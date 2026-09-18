package com.kakao.adfit.e;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.common.matrix.MatrixLevel;
import com.kakao.adfit.h.MatrixBreadcrumb;
import com.kakao.adfit.h.MatrixContexts;
import com.kakao.adfit.h.MatrixDebugMeta;
import com.kakao.adfit.h.MatrixException;
import com.kakao.adfit.h.MatrixMessage;
import com.kakao.adfit.h.MatrixSdkPackage;
import com.kakao.adfit.h.MatrixThread;
import com.kakao.adfit.h.MatrixUser;
import com.kakao.adfit.k.p;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.e.h, reason: from toString */
/* JADX INFO: compiled from: MatrixEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u0000 i2\u00020\u0001:\u0001\fBý\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u000104\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010O\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010T\u0012\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u000104\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010[\u0012\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010a¢\u0006\u0004\bg\u0010hJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b\u001b\u0010.R$\u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b#\u0010.R$\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010+\u001a\u0004\b#\u0010-\"\u0004\b\f\u0010.R*\u0010:\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00106\u001a\u0004\b7\u00108\"\u0004\b\u001b\u00109R*\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00106\u001a\u0004\b0\u00108\"\u0004\b\u0013\u00109R$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010F\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010+\u001a\u0004\bE\u0010-\"\u0004\b*\u0010.R$\u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010+\u001a\u0004\b*\u0010-\"\u0004\b\u0013\u0010.R$\u0010N\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010J\u001a\u0004\bK\u0010L\"\u0004\b\f\u0010MR$\u0010S\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010P\u001a\u0004\b>\u0010Q\"\u0004\b\f\u0010RR$\u0010X\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010U\u001a\u0004\b\u0013\u0010V\"\u0004\b\f\u0010WR*\u0010Z\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00106\u001a\u0004\b\f\u00108\"\u0004\b\f\u00109R$\u0010`\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b\u001b\u0010^\"\u0004\b\f\u0010_R0\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bG\u0010d\"\u0004\b\f\u0010e¨\u0006j"}, d2 = {"Lcom/kakao/adfit/e/h;", "", "Lorg/json/JSONObject;", "p", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/kakao/adfit/e/i;", "a", "Lcom/kakao/adfit/e/i;", "g", "()Lcom/kakao/adfit/e/i;", "(Lcom/kakao/adfit/e/i;)V", "id", "Lcom/kakao/adfit/h/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/h/d;", "getTimestamp", "()Lcom/kakao/adfit/h/d;", "setTimestamp", "(Lcom/kakao/adfit/h/d;)V", "timestamp", "", "c", "Ljava/lang/Throwable;", "n", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "throwable", "Lcom/kakao/adfit/h/j;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/h/j;", "getMessage", "()Lcom/kakao/adfit/h/j;", "setMessage", "(Lcom/kakao/adfit/h/j;)V", "message", "e", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "(Ljava/lang/String;)V", TapjoyConstants.TJC_PLATFORM, InneractiveMediationDefs.GENDER_FEMALE, "i", "release", "dist", "", "Lcom/kakao/adfit/h/p;", "Ljava/util/List;", InneractiveMediationDefs.GENDER_MALE, "()Ljava/util/List;", "(Ljava/util/List;)V", "threads", "Lcom/kakao/adfit/h/h;", "exception", "Lcom/kakao/adfit/common/matrix/MatrixLevel;", "j", "Lcom/kakao/adfit/common/matrix/MatrixLevel;", "getLevel", "()Lcom/kakao/adfit/common/matrix/MatrixLevel;", "setLevel", "(Lcom/kakao/adfit/common/matrix/MatrixLevel;)V", "level", CampaignEx.JSON_KEY_AD_K, "serverName", "l", "environment", "Lcom/kakao/adfit/h/q;", "Lcom/kakao/adfit/h/q;", "o", "()Lcom/kakao/adfit/h/q;", "(Lcom/kakao/adfit/h/q;)V", "user", "Lcom/kakao/adfit/h/m;", "Lcom/kakao/adfit/h/m;", "()Lcom/kakao/adfit/h/m;", "(Lcom/kakao/adfit/h/m;)V", "sdk", "Lcom/kakao/adfit/h/c;", "Lcom/kakao/adfit/h/c;", "()Lcom/kakao/adfit/h/c;", "(Lcom/kakao/adfit/h/c;)V", "contexts", "Lcom/kakao/adfit/h/b;", "breadcrumbs", "Lcom/kakao/adfit/h/f;", CampaignEx.JSON_KEY_AD_Q, "Lcom/kakao/adfit/h/f;", "()Lcom/kakao/adfit/h/f;", "(Lcom/kakao/adfit/h/f;)V", "debugMeta", "", CampaignEx.JSON_KEY_AD_R, "Ljava/util/Map;", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "tags", "<init>", "(Lcom/kakao/adfit/e/i;Lcom/kakao/adfit/h/d;Ljava/lang/Throwable;Lcom/kakao/adfit/h/j;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/kakao/adfit/common/matrix/MatrixLevel;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/adfit/h/q;Lcom/kakao/adfit/h/m;Lcom/kakao/adfit/h/c;Ljava/util/List;Lcom/kakao/adfit/h/f;Ljava/util/Map;)V", "s", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixEvent {

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private i id;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private com.kakao.adfit.h.d timestamp;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private Throwable throwable;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private MatrixMessage message;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private String platform;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private String release;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private String dist;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private List<MatrixThread> threads;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    private List<MatrixException> exception;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
    private MatrixLevel level;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
    private String serverName;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
    private String environment;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata and from toString */
    private MatrixUser user;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata and from toString */
    private MatrixSdkPackage sdk;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata and from toString */
    private MatrixContexts contexts;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata and from toString */
    private List<MatrixBreadcrumb> breadcrumbs;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata and from toString */
    private MatrixDebugMeta debugMeta;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata and from toString */
    private Map<String, String> tags;

    /* JADX INFO: renamed from: com.kakao.adfit.e.h$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixEvent.kt */
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J,\u0010\u0006\u001a\u00020\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0007R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001d\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0010R\u0014\u0010\u001e\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0010¨\u0006#"}, d2 = {"Lcom/kakao/adfit/e/h$a;", "", "Lorg/json/JSONObject;", "", SDKConstants.PARAM_KEY, "", "a", "Lcom/kakao/adfit/h/j;", "message", "", "throwable", "Lcom/kakao/adfit/common/matrix/MatrixLevel;", "level", "Lcom/kakao/adfit/e/h;", "json", "KEY_BREADCRUMBS", "Ljava/lang/String;", "KEY_CONTEXTS", "KEY_DEBUG_META", "KEY_DIST", "KEY_ENVIRONMENT", "KEY_EXCEPTION", "KEY_ID", "KEY_LEVEL", "KEY_MESSAGE", "KEY_PLATFORM", "KEY_RELEASE", "KEY_SDK", "KEY_SERVER_NAME", "KEY_TAGS", "KEY_THREADS", "KEY_TIMESTAMP", "KEY_USER", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MatrixEvent a(Companion companion, MatrixMessage matrixMessage, Throwable th, MatrixLevel matrixLevel, int i, Object obj) {
            if ((i & 1) != 0) {
                matrixMessage = null;
            }
            if ((i & 2) != 0) {
                th = null;
            }
            if ((i & 4) != 0) {
                matrixLevel = null;
            }
            return companion.a(matrixMessage, th, matrixLevel);
        }

        @JvmStatic
        public final MatrixEvent a(MatrixMessage message, Throwable throwable, MatrixLevel level) {
            return new MatrixEvent(i.INSTANCE.b(), com.kakao.adfit.h.d.INSTANCE.a(), throwable, message, null, null, null, null, null, level, null, null, null, null, null, null, null, null, 261616, null);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x009b  */
        /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
        @JvmStatic
        public final MatrixEvent a(JSONObject json) {
            MatrixMessage matrixMessageA;
            ArrayList arrayList;
            ArrayList arrayList2;
            MatrixUser matrixUserA;
            MatrixSdkPackage matrixSdkPackageA;
            MatrixContexts matrixContextsA;
            ArrayList arrayList3;
            MatrixDebugMeta matrixDebugMetaA;
            MatrixBreadcrumb matrixBreadcrumbA;
            MatrixException matrixExceptionA;
            MatrixThread matrixThreadA;
            Intrinsics.checkNotNullParameter(json, "json");
            String strE = p.e(json, "event_id");
            i iVarA = strE != null ? i.INSTANCE.a(strE) : null;
            String strE2 = p.e(json, "timestamp");
            com.kakao.adfit.h.d dVarA = strE2 != null ? com.kakao.adfit.h.d.INSTANCE.a(strE2) : null;
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("message");
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                matrixMessageA = MatrixMessage.INSTANCE.a(jSONObjectOptJSONObject);
            } else {
                matrixMessageA = null;
            }
            String strE3 = p.e(json, TapjoyConstants.TJC_PLATFORM);
            String strE4 = p.e(json, "release");
            String strE5 = p.e(json, "dist");
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("threads");
            if (jSONObjectOptJSONObject2 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(key)");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("values");
                if (jSONArrayOptJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
                    arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                    int length = jSONArrayOptJSONArray.length();
                    int i = 0;
                    while (i < length) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject3, "optJSONObject(index)");
                            matrixThreadA = MatrixThread.INSTANCE.a(jSONObjectOptJSONObject3);
                        } else {
                            matrixThreadA = null;
                        }
                        if (matrixThreadA != null) {
                            arrayList.add(matrixThreadA);
                        }
                        i++;
                        jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    }
                } else {
                    arrayList = null;
                }
            } else {
                arrayList = null;
            }
            JSONObject jSONObjectOptJSONObject4 = json.optJSONObject("exception");
            if (jSONObjectOptJSONObject4 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject4, "optJSONObject(key)");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("values");
                if (jSONArrayOptJSONArray2 != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray2, "optJSONArray(key)");
                    arrayList2 = new ArrayList(jSONArrayOptJSONArray2.length());
                    int length2 = jSONArrayOptJSONArray2.length();
                    int i2 = 0;
                    while (i2 < length2) {
                        JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject5 != null) {
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject5, "optJSONObject(index)");
                            matrixExceptionA = MatrixException.INSTANCE.a(jSONObjectOptJSONObject5);
                        } else {
                            matrixExceptionA = null;
                        }
                        if (matrixExceptionA != null) {
                            arrayList2.add(matrixExceptionA);
                        }
                        i2++;
                        jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList2 = null;
            }
            String strE6 = p.e(json, "level");
            MatrixLevel matrixLevelA = strE6 != null ? MatrixLevel.INSTANCE.a(strE6) : null;
            String strE7 = p.e(json, "server_name");
            String strE8 = p.e(json, "environment");
            JSONObject jSONObjectOptJSONObject6 = json.optJSONObject("user");
            if (jSONObjectOptJSONObject6 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject6, "optJSONObject(key)");
                matrixUserA = MatrixUser.INSTANCE.a(jSONObjectOptJSONObject6);
            } else {
                matrixUserA = null;
            }
            JSONObject jSONObjectOptJSONObject7 = json.optJSONObject("sdk");
            if (jSONObjectOptJSONObject7 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject7, "optJSONObject(key)");
                matrixSdkPackageA = MatrixSdkPackage.INSTANCE.a(jSONObjectOptJSONObject7);
            } else {
                matrixSdkPackageA = null;
            }
            JSONObject jSONObjectOptJSONObject8 = json.optJSONObject("contexts");
            if (jSONObjectOptJSONObject8 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject8, "optJSONObject(key)");
                matrixContextsA = MatrixContexts.INSTANCE.a(jSONObjectOptJSONObject8);
            } else {
                matrixContextsA = null;
            }
            JSONArray jSONArrayOptJSONArray3 = json.optJSONArray("breadcrumbs");
            if (jSONArrayOptJSONArray3 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray3, "optJSONArray(key)");
                ArrayList arrayList4 = new ArrayList(jSONArrayOptJSONArray3.length());
                int length3 = jSONArrayOptJSONArray3.length();
                int i3 = 0;
                while (i3 < length3) {
                    int i4 = length3;
                    JSONObject jSONObjectOptJSONObject9 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    if (jSONObjectOptJSONObject9 != null) {
                        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject9, "optJSONObject(index)");
                        matrixBreadcrumbA = MatrixBreadcrumb.INSTANCE.a(jSONObjectOptJSONObject9);
                    } else {
                        matrixBreadcrumbA = null;
                    }
                    if (matrixBreadcrumbA != null) {
                        arrayList4.add(matrixBreadcrumbA);
                    }
                    i3++;
                    length3 = i4;
                    jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                }
                arrayList3 = arrayList4;
            } else {
                arrayList3 = null;
            }
            JSONObject jSONObjectOptJSONObject10 = json.optJSONObject("debug_meta");
            if (jSONObjectOptJSONObject10 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject10, "optJSONObject(key)");
                matrixDebugMetaA = MatrixDebugMeta.INSTANCE.a(jSONObjectOptJSONObject10);
            } else {
                matrixDebugMetaA = null;
            }
            return new MatrixEvent(iVarA, dVarA, null, matrixMessageA, strE3, strE4, strE5, arrayList, arrayList2, matrixLevelA, strE7, strE8, matrixUserA, matrixSdkPackageA, matrixContextsA, arrayList3, matrixDebugMetaA, a(json, "tags"), 4, null);
        }

        private final Map<String, String> a(JSONObject jSONObject, String str) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            HashMap map = new HashMap(jSONObjectOptJSONObject.length());
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "json.keys()");
            while (itKeys.hasNext()) {
                String it = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object objOpt = jSONObjectOptJSONObject.opt(it);
                String str2 = objOpt instanceof String ? (String) objOpt : null;
                if (str2 != null) {
                    map.put(it, str2);
                }
            }
            return map;
        }
    }

    public MatrixEvent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public MatrixEvent(i iVar, com.kakao.adfit.h.d dVar, Throwable th, MatrixMessage matrixMessage, String str, String str2, String str3, List<MatrixThread> list, List<MatrixException> list2, MatrixLevel matrixLevel, String str4, String str5, MatrixUser matrixUser, MatrixSdkPackage matrixSdkPackage, MatrixContexts matrixContexts, List<MatrixBreadcrumb> list3, MatrixDebugMeta matrixDebugMeta, Map<String, String> map) {
        this.id = iVar;
        this.timestamp = dVar;
        this.throwable = th;
        this.message = matrixMessage;
        this.platform = str;
        this.release = str2;
        this.dist = str3;
        this.threads = list;
        this.exception = list2;
        this.level = matrixLevel;
        this.serverName = str4;
        this.environment = str5;
        this.user = matrixUser;
        this.sdk = matrixSdkPackage;
        this.contexts = matrixContexts;
        this.breadcrumbs = list3;
        this.debugMeta = matrixDebugMeta;
        this.tags = map;
    }

    public final void a(i iVar) {
        this.id = iVar;
    }

    public final void b(List<MatrixException> list) {
        this.exception = list;
    }

    public final void c(String str) {
        this.platform = str;
    }

    public final void d(String str) {
        this.release = str;
    }

    public final void e(String str) {
        this.serverName = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixEvent)) {
            return false;
        }
        MatrixEvent matrixEvent = (MatrixEvent) other;
        return Intrinsics.areEqual(this.id, matrixEvent.id) && Intrinsics.areEqual(this.timestamp, matrixEvent.timestamp) && Intrinsics.areEqual(this.throwable, matrixEvent.throwable) && Intrinsics.areEqual(this.message, matrixEvent.message) && Intrinsics.areEqual(this.platform, matrixEvent.platform) && Intrinsics.areEqual(this.release, matrixEvent.release) && Intrinsics.areEqual(this.dist, matrixEvent.dist) && Intrinsics.areEqual(this.threads, matrixEvent.threads) && Intrinsics.areEqual(this.exception, matrixEvent.exception) && this.level == matrixEvent.level && Intrinsics.areEqual(this.serverName, matrixEvent.serverName) && Intrinsics.areEqual(this.environment, matrixEvent.environment) && Intrinsics.areEqual(this.user, matrixEvent.user) && Intrinsics.areEqual(this.sdk, matrixEvent.sdk) && Intrinsics.areEqual(this.contexts, matrixEvent.contexts) && Intrinsics.areEqual(this.breadcrumbs, matrixEvent.breadcrumbs) && Intrinsics.areEqual(this.debugMeta, matrixEvent.debugMeta) && Intrinsics.areEqual(this.tags, matrixEvent.tags);
    }

    public final List<MatrixException> f() {
        return this.exception;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final i getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    public int hashCode() {
        i iVar = this.id;
        int iHashCode = (iVar == null ? 0 : iVar.hashCode()) * 31;
        com.kakao.adfit.h.d dVar = this.timestamp;
        int iHashCode2 = (iHashCode + (dVar == null ? 0 : dVar.hashCode())) * 31;
        Throwable th = this.throwable;
        int iHashCode3 = (iHashCode2 + (th == null ? 0 : th.hashCode())) * 31;
        MatrixMessage matrixMessage = this.message;
        int iHashCode4 = (iHashCode3 + (matrixMessage == null ? 0 : matrixMessage.hashCode())) * 31;
        String str = this.platform;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.release;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dist;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<MatrixThread> list = this.threads;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<MatrixException> list2 = this.exception;
        int iHashCode9 = (iHashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        MatrixLevel matrixLevel = this.level;
        int iHashCode10 = (iHashCode9 + (matrixLevel == null ? 0 : matrixLevel.hashCode())) * 31;
        String str4 = this.serverName;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.environment;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        MatrixUser matrixUser = this.user;
        int iHashCode13 = (iHashCode12 + (matrixUser == null ? 0 : matrixUser.hashCode())) * 31;
        MatrixSdkPackage matrixSdkPackage = this.sdk;
        int iHashCode14 = (iHashCode13 + (matrixSdkPackage == null ? 0 : matrixSdkPackage.hashCode())) * 31;
        MatrixContexts matrixContexts = this.contexts;
        int iHashCode15 = (iHashCode14 + (matrixContexts == null ? 0 : matrixContexts.hashCode())) * 31;
        List<MatrixBreadcrumb> list3 = this.breadcrumbs;
        int iHashCode16 = (iHashCode15 + (list3 == null ? 0 : list3.hashCode())) * 31;
        MatrixDebugMeta matrixDebugMeta = this.debugMeta;
        int iHashCode17 = (iHashCode16 + (matrixDebugMeta == null ? 0 : matrixDebugMeta.hashCode())) * 31;
        Map<String, String> map = this.tags;
        return iHashCode17 + (map != null ? map.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getRelease() {
        return this.release;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final MatrixSdkPackage getSdk() {
        return this.sdk;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getServerName() {
        return this.serverName;
    }

    public final Map<String, String> l() {
        return this.tags;
    }

    public final List<MatrixThread> m() {
        return this.threads;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final MatrixUser getUser() {
        return this.user;
    }

    public final JSONObject p() throws JSONException {
        JSONObject jSONObjectPut;
        JSONObject jSONObjectPut2;
        String lowerCase;
        JSONArray jSONArray;
        String string;
        JSONObject jSONObject = new JSONObject();
        i iVar = this.id;
        JSONObject jSONObject2 = null;
        JSONObject jSONObjectPutOpt = jSONObject.putOpt("event_id", iVar != null ? iVar.toString() : null);
        com.kakao.adfit.h.d dVar = this.timestamp;
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("timestamp", dVar != null ? dVar.getTimestamp() : null);
        MatrixMessage matrixMessage = this.message;
        JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt("message", matrixMessage != null ? matrixMessage.a() : null).putOpt(TapjoyConstants.TJC_PLATFORM, this.platform).putOpt("release", this.release).putOpt("dist", this.dist);
        List<MatrixThread> list = this.threads;
        if (list != null) {
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Object objB = ((MatrixThread) it.next()).b();
                if (objB == null) {
                    objB = JSONObject.NULL;
                }
                jSONArray2.put(objB);
            }
            jSONObjectPut = jSONObject3.put("values", jSONArray2);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"values\", toJsonArray(transform))");
        } else {
            jSONObjectPut = null;
        }
        JSONObject jSONObjectPutOpt4 = jSONObjectPutOpt3.putOpt("threads", jSONObjectPut);
        List<MatrixException> list2 = this.exception;
        if (list2 != null) {
            JSONObject jSONObject4 = new JSONObject();
            JSONArray jSONArray3 = new JSONArray();
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                Object objC = ((MatrixException) it2.next()).c();
                if (objC == null) {
                    objC = JSONObject.NULL;
                }
                jSONArray3.put(objC);
            }
            jSONObjectPut2 = jSONObject4.put("values", jSONArray3);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject().put(\"values\", toJsonArray(transform))");
        } else {
            jSONObjectPut2 = null;
        }
        JSONObject jSONObjectPutOpt5 = jSONObjectPutOpt4.putOpt("exception", jSONObjectPut2);
        MatrixLevel matrixLevel = this.level;
        if (matrixLevel == null || (string = matrixLevel.toString()) == null) {
            lowerCase = null;
        } else {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            lowerCase = string.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        }
        JSONObject jSONObjectPutOpt6 = jSONObjectPutOpt5.putOpt("level", lowerCase).putOpt("server_name", this.serverName).putOpt("environment", this.environment);
        MatrixUser matrixUser = this.user;
        JSONObject jSONObjectPutOpt7 = jSONObjectPutOpt6.putOpt("user", matrixUser != null ? matrixUser.a() : null);
        MatrixSdkPackage matrixSdkPackage = this.sdk;
        JSONObject jSONObjectPutOpt8 = jSONObjectPutOpt7.putOpt("sdk", matrixSdkPackage != null ? matrixSdkPackage.a() : null);
        MatrixContexts matrixContexts = this.contexts;
        JSONObject jSONObjectPutOpt9 = jSONObjectPutOpt8.putOpt("contexts", matrixContexts != null ? matrixContexts.d() : null);
        List<MatrixBreadcrumb> list3 = this.breadcrumbs;
        if (list3 != null) {
            jSONArray = new JSONArray();
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                Object objA = ((MatrixBreadcrumb) it3.next()).a();
                if (objA == null) {
                    objA = JSONObject.NULL;
                }
                jSONArray.put(objA);
            }
        } else {
            jSONArray = null;
        }
        JSONObject jSONObjectPutOpt10 = jSONObjectPutOpt9.putOpt("breadcrumbs", jSONArray);
        MatrixDebugMeta matrixDebugMeta = this.debugMeta;
        JSONObject jSONObjectPutOpt11 = jSONObjectPutOpt10.putOpt("debug_meta", matrixDebugMeta != null ? matrixDebugMeta.a() : null);
        Map<String, String> map = this.tags;
        if (map != null) {
            jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        JSONObject jSONObjectPutOpt12 = jSONObjectPutOpt11.putOpt("tags", jSONObject2);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt12, "JSONObject()\n           …GS, tags?.toJsonObject())");
        return jSONObjectPutOpt12;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MatrixEvent(id=").append(this.id).append(", timestamp=").append(this.timestamp).append(", throwable=").append(this.throwable).append(", message=").append(this.message).append(", platform=").append(this.platform).append(", release=").append(this.release).append(", dist=").append(this.dist).append(", threads=").append(this.threads).append(", exception=").append(this.exception).append(", level=").append(this.level).append(", serverName=").append(this.serverName).append(", environment=");
        sb.append(this.environment).append(", user=").append(this.user).append(", sdk=").append(this.sdk).append(", contexts=").append(this.contexts).append(", breadcrumbs=").append(this.breadcrumbs).append(", debugMeta=").append(this.debugMeta).append(", tags=").append(this.tags).append(')');
        return sb.toString();
    }

    public final void a(String str) {
        this.dist = str;
    }

    public final void b(String str) {
        this.environment = str;
    }

    public final void c(List<MatrixThread> list) {
        this.threads = list;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getDist() {
        return this.dist;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getEnvironment() {
        return this.environment;
    }

    public final void a(MatrixUser matrixUser) {
        this.user = matrixUser;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final MatrixContexts getContexts() {
        return this.contexts;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final MatrixDebugMeta getDebugMeta() {
        return this.debugMeta;
    }

    public final void a(MatrixSdkPackage matrixSdkPackage) {
        this.sdk = matrixSdkPackage;
    }

    public final void a(MatrixContexts matrixContexts) {
        this.contexts = matrixContexts;
    }

    public final List<MatrixBreadcrumb> a() {
        return this.breadcrumbs;
    }

    public final void a(List<MatrixBreadcrumb> list) {
        this.breadcrumbs = list;
    }

    public final void a(MatrixDebugMeta matrixDebugMeta) {
        this.debugMeta = matrixDebugMeta;
    }

    public final void a(Map<String, String> map) {
        this.tags = map;
    }

    public /* synthetic */ MatrixEvent(i iVar, com.kakao.adfit.h.d dVar, Throwable th, MatrixMessage matrixMessage, String str, String str2, String str3, List list, List list2, MatrixLevel matrixLevel, String str4, String str5, MatrixUser matrixUser, MatrixSdkPackage matrixSdkPackage, MatrixContexts matrixContexts, List list3, MatrixDebugMeta matrixDebugMeta, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iVar, (i & 2) != 0 ? null : dVar, (i & 4) != 0 ? null : th, (i & 8) != 0 ? null : matrixMessage, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : matrixLevel, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : matrixUser, (i & 8192) != 0 ? null : matrixSdkPackage, (i & 16384) != 0 ? null : matrixContexts, (i & 32768) != 0 ? null : list3, (i & 65536) != 0 ? null : matrixDebugMeta, (i & 131072) != 0 ? null : map);
    }
}

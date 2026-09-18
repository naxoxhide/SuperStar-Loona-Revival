package com.kakao.adfit.e;

import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.kakao.adfit.common.matrix.exception.InvalidDsnException;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Dsn.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B7\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/kakao/adfit/e/b;", "", "Ljava/net/URI;", "a", "Ljava/net/URI;", "c", "()Ljava/net/URI;", ShareConstants.MEDIA_URI, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getProjectId", "()Ljava/lang/String;", "projectId", "publicKey", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "secretKey", "e", "getPath", MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "<init>", "(Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", InneractiveMediationDefs.GENDER_FEMALE, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final URI uri;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String projectId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String publicKey;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String secretKey;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String path;

    /* JADX INFO: renamed from: com.kakao.adfit.e.b$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Dsn.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/kakao/adfit/e/b$a;", "", "", "dsn", "Lcom/kakao/adfit/e/b;", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(String dsn) {
            Intrinsics.checkNotNullParameter(dsn, "dsn");
            try {
                URI uri = new URI(dsn);
                String userInfo = uri.getUserInfo();
                if (userInfo != null) {
                    boolean z = true;
                    String str = userInfo.length() > 0 ? userInfo : null;
                    if (str != null) {
                        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
                        Object obj = listSplit$default.get(0);
                        if (!(((String) obj).length() > 0)) {
                            obj = null;
                        }
                        String str2 = (String) obj;
                        if (str2 == null) {
                            throw new IllegalArgumentException("Invalid DSN: No public key provided.");
                        }
                        String str3 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
                        String uriPath = uri.getPath();
                        Intrinsics.checkNotNullExpressionValue(uriPath, "uriPath");
                        if (StringsKt.endsWith$default(uriPath, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                            Intrinsics.checkNotNullExpressionValue(uriPath, "uriPath");
                            uriPath = uriPath.substring(0, uriPath.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(uriPath, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                        Intrinsics.checkNotNullExpressionValue(uriPath, "uriPath");
                        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) uriPath, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null) + 1;
                        Intrinsics.checkNotNullExpressionValue(uriPath, "uriPath");
                        String strSubstring = uriPath.substring(0, iLastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        String str4 = !StringsKt.endsWith$default(strSubstring, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null) ? strSubstring + '/' : strSubstring;
                        Intrinsics.checkNotNullExpressionValue(uriPath, "uriPath");
                        String strSubstring2 = uriPath.substring(iLastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                        if (strSubstring2.length() <= 0) {
                            z = false;
                        }
                        String str5 = z ? strSubstring2 : null;
                        if (str5 != null) {
                            return new b(new URI(uri.getScheme(), null, uri.getHost(), uri.getPort(), str4 + "api/" + str5, null, null), str5, str2, str3, str4);
                        }
                        throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
                    }
                }
                throw new IllegalArgumentException("Invalid DSN: No key provided.");
            } catch (Exception e) {
                throw new InvalidDsnException(e);
            }
        }
    }

    public b(URI uri, String projectId, String publicKey, String str, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        this.uri = uri;
        this.projectId = projectId;
        this.publicKey = publicKey;
        this.secretKey = str;
        this.path = str2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getPublicKey() {
        return this.publicKey;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final URI getUri() {
        return this.uri;
    }
}

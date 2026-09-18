package com.kakao.adfit.i;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TransportResults.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0019\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/kakao/adfit/i/j;", "", "", "a", "Z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "isSuccess", "", "I", "()I", "responseCode", "<init>", "(ZI)V", "c", "Lcom/kakao/adfit/i/h;", "Lcom/kakao/adfit/i/i;", "Lcom/kakao/adfit/i/c;", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public abstract class j {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean isSuccess;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int responseCode;

    /* JADX INFO: renamed from: com.kakao.adfit.i.j$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TransportResults.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/kakao/adfit/i/j$a;", "", "", "responseCode", "Lcom/kakao/adfit/i/j;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ j a(Companion companion, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            return companion.a(i);
        }

        public final j b(int responseCode) {
            return responseCode == 200 ? h.d : new i(responseCode);
        }

        public final j a(int responseCode) {
            return new c(responseCode);
        }
    }

    private j(boolean z, int i) {
        this.isSuccess = z;
        this.responseCode = i;
    }

    public /* synthetic */ j(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }
}

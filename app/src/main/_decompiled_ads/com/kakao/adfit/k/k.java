package com.kakao.adfit.k;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: compiled from: Disposable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/kakao/adfit/k/k;", "", "", "a", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface k {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* JADX INFO: renamed from: com.kakao.adfit.k.k$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Disposable.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/k/k$a;", "", "Lcom/kakao/adfit/k/k;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/k/k;", "a", "()Lcom/kakao/adfit/k/k;", "DISPOSED", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final k DISPOSED = new C0466a();

        /* JADX INFO: renamed from: com.kakao.adfit.k.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Disposable.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0007\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/kakao/adfit/k/k$a$a", "Lcom/kakao/adfit/k/k;", "", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "isDisposed", "()Z", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
        public static final class C0466a implements k {

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final boolean isDisposed = true;

            C0466a() {
            }

            @Override // com.kakao.adfit.k.k
            public void a() {
            }
        }

        private Companion() {
        }

        public final k a() {
            return DISPOSED;
        }
    }

    void a();
}

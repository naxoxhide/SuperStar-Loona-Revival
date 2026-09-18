package com.kakao.adfit.f;

import com.kakao.adfit.e.MatrixEvent;
import com.kakao.adfit.k.f;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CachedEventSender.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/kakao/adfit/f/a;", "Ljava/lang/Runnable;", "", "run", "Lcom/kakao/adfit/i/d;", "a", "Lcom/kakao/adfit/i/d;", "connection", "Lcom/kakao/adfit/f/c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/f/c;", "eventCache", "", "c", "J", "flushTimeoutMillis", "<init>", "(Lcom/kakao/adfit/i/d;Lcom/kakao/adfit/f/c;J)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final com.kakao.adfit.i.d connection;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final c eventCache;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final long flushTimeoutMillis;

    /* JADX INFO: renamed from: com.kakao.adfit.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CachedEventSender.kt */
    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\"\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\f\u0010\u000fR*\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00058\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\b\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/f/a$a;", "Lcom/kakao/adfit/g/a;", "Lcom/kakao/adfit/g/c;", "Lcom/kakao/adfit/g/d;", "Lcom/kakao/adfit/g/b;", "", "c", "", "a", "", "J", "flushTimeoutMillis", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "()Z", "(Z)V", "isRetry", "value", "isSuccess", "Ljava/util/concurrent/CountDownLatch;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/util/concurrent/CountDownLatch;", "latch", "<init>", "(J)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class C0457a implements com.kakao.adfit.g.a, com.kakao.adfit.g.c, com.kakao.adfit.g.d, com.kakao.adfit.g.b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final long flushTimeoutMillis;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isRetry;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private boolean isSuccess;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final CountDownLatch latch = new CountDownLatch(1);

        public C0457a(long j) {
            this.flushTimeoutMillis = j;
        }

        @Override // com.kakao.adfit.g.b
        public void a() {
        }

        @Override // com.kakao.adfit.g.d
        public void a(boolean z) {
            this.isSuccess = z;
            this.latch.countDown();
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public boolean getIsRetry() {
            return this.isRetry;
        }

        public boolean c() {
            try {
                return this.latch.await(this.flushTimeoutMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                f.b("Exception while awaiting on lock.", e);
                return false;
            }
        }

        @Override // com.kakao.adfit.g.c
        public void b(boolean z) {
            this.isRetry = z;
        }
    }

    public a(com.kakao.adfit.i.d connection, c eventCache, long j) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(eventCache, "eventCache");
        this.connection = connection;
        this.eventCache = eventCache;
        this.flushTimeoutMillis = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (MatrixEvent matrixEvent : this.eventCache) {
            C0457a c0457a = new C0457a(this.flushTimeoutMillis);
            try {
                this.connection.a(matrixEvent, c0457a);
                if (!c0457a.c()) {
                    f.e("Timed out waiting for event submission: " + matrixEvent.getId());
                }
            } catch (IOException e) {
                f.c("Capturing cached event $" + matrixEvent.getId() + " failed.", e);
            }
            if (!c0457a.getIsRetry()) {
                this.eventCache.a(matrixEvent);
            }
        }
    }

    public /* synthetic */ a(com.kakao.adfit.i.d dVar, c cVar, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, cVar, (i & 4) != 0 ? 15000L : j);
    }
}

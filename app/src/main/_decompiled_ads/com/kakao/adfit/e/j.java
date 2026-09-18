package com.kakao.adfit.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.kakao.adfit.common.matrix.MatrixLevel;
import com.kakao.adfit.common.matrix.exception.ExceptionMechanismException;
import com.kakao.adfit.h.MatrixMechanism;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MatrixUncaughtExceptionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0003\u001a\u00020\u0005*\u00020\u0004H\u0002J\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/e/j;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "", "a", "", "", "Landroid/content/Context;", "context", "Ljava/lang/Thread;", "thread", "e", "uncaughtException", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Thread$UncaughtExceptionHandler;", "defaultExceptionHandler", "", "c", "Ljava/lang/String;", "appPackageName", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class j implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final AtomicBoolean initialized = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String appPackageName;

    /* JADX INFO: compiled from: MatrixUncaughtExceptionHandler.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/kakao/adfit/e/j$a;", "Lcom/kakao/adfit/g/b;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "a", "", "J", "flushTimeoutMillis", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "latch", "<init>", "(J)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class a implements com.kakao.adfit.g.b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final long flushTimeoutMillis;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final CountDownLatch latch = new CountDownLatch(1);

        public a(long j) {
            this.flushTimeoutMillis = j;
        }

        @Override // com.kakao.adfit.g.b
        public void a() {
            this.latch.countDown();
        }

        public boolean b() {
            try {
                return this.latch.await(this.flushTimeoutMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                com.kakao.adfit.k.f.b("Exception while awaiting for flush in UncaughtExceptionHint", e);
                Thread.currentThread().interrupt();
                return false;
            }
        }
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.initialized.get()) {
            return;
        }
        this.appPackageName = context.getPackageName();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kakao.adfit.e.-$$Lambda$j$5nDf-IqDxue2xKPGbRGwrFSni8M
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable e) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(e, "e");
        com.kakao.adfit.k.f.c("Uncaught exception received. " + e);
        f fVar = f.a;
        if (fVar.b() && a(e)) {
            try {
                MatrixEvent matrixEventA = MatrixEvent.Companion.a(MatrixEvent.INSTANCE, null, new ExceptionMechanismException(new MatrixMechanism("UncaughtExceptionHandler", Boolean.FALSE), e, thread), MatrixLevel.FATAL, 1, null);
                a aVar = new a(1000L);
                fVar.a(matrixEventA, aVar);
                if (!aVar.b()) {
                    com.kakao.adfit.k.f.e("Timed out waiting to flush event to disk before crashing. Event: " + matrixEventA.getId());
                }
            } catch (Exception unused) {
                com.kakao.adfit.k.f.b("Error sending uncaught exception to Matrix.", e);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        if (this.initialized.compareAndSet(false, true)) {
            this.defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private final boolean a(Throwable th) {
        String str = this.appPackageName;
        while (th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if (className != null) {
                        Intrinsics.checkNotNullExpressionValue(className, "element.className ?: return@forEach");
                        if (StringsKt.startsWith$default(className, "com.kakao.adfit", false, 2, (Object) null)) {
                            return true;
                        }
                        if (str != null && StringsKt.startsWith$default(className, str, false, 2, (Object) null)) {
                            return false;
                        }
                    }
                }
            }
            th = th.getCause();
        }
        return false;
    }
}

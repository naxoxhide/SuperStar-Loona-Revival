package com.kakao.adfit.common.matrix.exception;

import com.kakao.adfit.h.MatrixMechanism;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExceptionMechanismException.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00060\u0001j\u0002`\u0002:\u0001\u0004B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/kakao/adfit/common/matrix/exception/ExceptionMechanismException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcom/kakao/adfit/h/i;", "a", "Lcom/kakao/adfit/h/i;", "()Lcom/kakao/adfit/h/i;", "exceptionMechanism", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Throwable;", "c", "()Ljava/lang/Throwable;", "throwable", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "()Ljava/lang/Thread;", "thread", "<init>", "(Lcom/kakao/adfit/h/i;Ljava/lang/Throwable;Ljava/lang/Thread;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class ExceptionMechanismException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final MatrixMechanism exceptionMechanism;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Throwable throwable;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Thread thread;

    public ExceptionMechanismException(MatrixMechanism matrixMechanism, Throwable th, Thread thread) {
        this.exceptionMechanism = matrixMechanism;
        this.throwable = th;
        this.thread = thread;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final MatrixMechanism getExceptionMechanism() {
        return this.exceptionMechanism;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Thread getThread() {
        return this.thread;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }
}

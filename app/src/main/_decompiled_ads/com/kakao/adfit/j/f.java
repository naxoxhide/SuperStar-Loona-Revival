package com.kakao.adfit.j;

import com.kakao.adfit.common.matrix.exception.ExceptionMechanismException;
import com.kakao.adfit.h.MatrixException;
import com.kakao.adfit.h.MatrixMechanism;
import com.kakao.adfit.h.MatrixStackTrace;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MatrixExceptionFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/kakao/adfit/j/f;", "", "Ljava/util/Deque;", "Lcom/kakao/adfit/h/h;", "exceptions", "", "a", "", "throwable", "Lcom/kakao/adfit/h/i;", "exceptionMechanism", "Ljava/lang/Thread;", "thread", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/j/g;", "Lcom/kakao/adfit/j/g;", "stackTraceFactory", "<init>", "(Lcom/kakao/adfit/j/g;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class f {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final g stackTraceFactory;

    public f(g stackTraceFactory) {
        Intrinsics.checkNotNullParameter(stackTraceFactory, "stackTraceFactory");
        this.stackTraceFactory = stackTraceFactory;
    }

    private final List<MatrixException> a(Deque<MatrixException> exceptions) {
        return new ArrayList(exceptions);
    }

    public final List<MatrixException> b(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return a(a(throwable));
    }

    private final MatrixException a(Throwable throwable, MatrixMechanism exceptionMechanism, Thread thread) {
        Package r0 = throwable.getClass().getPackage();
        String fullClassName = throwable.getClass().getName();
        MatrixException matrixException = new MatrixException(null, null, null, null, null, null, 63, null);
        String message = throwable.getMessage();
        if (r0 != null) {
            Intrinsics.checkNotNullExpressionValue(fullClassName, "fullClassName");
            fullClassName = StringsKt.replace$default(fullClassName, r0.getName() + '.', "", false, 4, (Object) null);
        }
        String name = r0 != null ? r0.getName() : null;
        MatrixStackTrace matrixStackTrace = new MatrixStackTrace(this.stackTraceFactory.a(throwable.getStackTrace()));
        if (thread != null) {
            matrixException.a(Long.valueOf(thread.getId()));
        }
        matrixException.a(matrixStackTrace);
        matrixException.b(fullClassName);
        matrixException.a(exceptionMechanism);
        matrixException.a(name);
        matrixException.c(message);
        return matrixException;
    }

    public final Deque<MatrixException> a(Throwable throwable) {
        MatrixMechanism exceptionMechanism;
        Thread threadCurrentThread;
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (throwable != null && hashSet.add(throwable)) {
            if (throwable instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) throwable;
                exceptionMechanism = exceptionMechanismException.getExceptionMechanism();
                Throwable throwable2 = exceptionMechanismException.getThrowable();
                if (throwable2 != null) {
                    throwable = throwable2;
                }
                threadCurrentThread = exceptionMechanismException.getThread();
            } else {
                exceptionMechanism = null;
                threadCurrentThread = Thread.currentThread();
            }
            arrayDeque.addFirst(a(throwable, exceptionMechanism, threadCurrentThread));
            throwable = throwable.getCause();
        }
        return arrayDeque;
    }
}

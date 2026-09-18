package com.kakao.adfit.j;

import com.kakao.adfit.h.MatrixStackFrame;
import com.kakao.adfit.h.MatrixStackTrace;
import com.kakao.adfit.h.MatrixThread;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixThreadFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ:\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/j/h;", "", "", "crashed", "", "Ljava/lang/StackTraceElement;", "stackFramesElements", "Ljava/lang/Thread;", "thread", "Lcom/kakao/adfit/h/p;", "a", "(Z[Ljava/lang/StackTraceElement;Ljava/lang/Thread;)Lcom/kakao/adfit/h/p;", "", "", "mechanismThreadIds", "", "threads", "Lcom/kakao/adfit/j/g;", "Lcom/kakao/adfit/j/g;", "stackTraceFactory", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "attachStacktrace", "<init>", "(Lcom/kakao/adfit/j/g;Z)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final g stackTraceFactory;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean attachStacktrace;

    public h(g stackTraceFactory, boolean z) {
        Intrinsics.checkNotNullParameter(stackTraceFactory, "stackTraceFactory");
        this.stackTraceFactory = stackTraceFactory;
        this.attachStacktrace = z;
    }

    public final List<MatrixThread> a(List<Long> mechanismThreadIds) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Intrinsics.checkNotNullExpressionValue(allStackTraces, "getAllStackTraces()");
        return a(allStackTraces, mechanismThreadIds);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    public final List<MatrixThread> a(Map<Thread, StackTraceElement[]> threads, List<Long> mechanismThreadIds) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Thread thread = Thread.currentThread();
        if (threads.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!threads.containsKey(thread)) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(thread, "thread");
            arrayList.add(a(true, stackTrace, thread));
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : threads.entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            boolean z = false;
            if (key == thread) {
                z = true;
            } else if (mechanismThreadIds != null && mechanismThreadIds.contains(Long.valueOf(key.getId()))) {
                z = true;
            }
            arrayList.add(a(z, value, key));
        }
        return arrayList;
    }

    public /* synthetic */ h(g gVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, (i & 2) != 0 ? false : z);
    }

    private final MatrixThread a(boolean crashed, StackTraceElement[] stackFramesElements, Thread thread) {
        MatrixThread matrixThread = new MatrixThread(null, null, null, null, null, null, null, null, 255, null);
        matrixThread.a(thread.getName());
        matrixThread.a(Integer.valueOf(thread.getPriority()));
        matrixThread.a(Long.valueOf(thread.getId()));
        matrixThread.c(Boolean.valueOf(thread.isDaemon()));
        matrixThread.b(thread.getState().name());
        matrixThread.a(Boolean.valueOf(crashed));
        if (this.attachStacktrace) {
            List<MatrixStackFrame> listA = this.stackTraceFactory.a(stackFramesElements);
            if (listA != null && (listA.isEmpty() ^ true)) {
                matrixThread.a(new MatrixStackTrace(listA));
            }
        }
        return matrixThread;
    }
}

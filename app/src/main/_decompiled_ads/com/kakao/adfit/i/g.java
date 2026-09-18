package com.kakao.adfit.i;

import com.google.android.gms.ads.RequestConfiguration;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QueuedThreadPoolExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB7\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0016¨\u0006#"}, d2 = {"Lcom/kakao/adfit/i/g;", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/lang/Runnable;", "task", "Ljava/util/concurrent/Future;", "submit", "Ljava/lang/Thread;", "t", CampaignEx.JSON_KEY_AD_R, "", "beforeExecute", "", "afterExecute", "", "a", "I", "maxQueueSize", "Ljava/util/concurrent/atomic/AtomicInteger;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/concurrent/atomic/AtomicInteger;", "currentlyRunning", "", "()Z", "isSchedulingAllowed", "corePoolSize", "", "keepAliveTime", "Ljava/util/concurrent/TimeUnit;", "unit", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "Ljava/util/concurrent/RejectedExecutionHandler;", "handler", "<init>", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class g extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int maxQueueSize;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger currentlyRunning;

    /* JADX INFO: compiled from: QueuedThreadPoolExecutor.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u000f\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ \u0010\b\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\b\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/kakao/adfit/i/g$a;", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "Ljava/util/concurrent/Future;", "", "mayInterruptIfRunning", "cancel", "isCancelled", "isDone", "get", "()Ljava/lang/Object;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class a<T> implements Future<T> {
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            throw new CancellationException();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            throw new CancellationException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i, int i2, long j, TimeUnit unit, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(i, i, j, unit, new LinkedBlockingQueue(), threadFactory, handler);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.maxQueueSize = i2;
        this.currentlyRunning = new AtomicInteger();
    }

    private final boolean a() {
        return getQueue().size() + this.currentlyRunning.get() < this.maxQueueSize;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r, Throwable t) {
        Intrinsics.checkNotNullParameter(r, "r");
        try {
            super.afterExecute(r, t);
        } finally {
            this.currentlyRunning.decrementAndGet();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread t, Runnable r) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(r, "r");
        try {
            super.beforeExecute(t, r);
        } finally {
            this.currentlyRunning.incrementAndGet();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!a()) {
            return new a();
        }
        Future<?> futureSubmit = super.submit(task);
        Intrinsics.checkNotNullExpressionValue(futureSubmit, "super.submit(task)");
        return futureSubmit;
    }
}

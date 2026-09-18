package com.kakao.adfit.i;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.common.matrix.MatrixItemType;
import com.kakao.adfit.e.MatrixEvent;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0003\b\u000e\u0012B'\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aB)\b\u0016\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/kakao/adfit/i/b;", "Ljava/io/Closeable;", "Lcom/kakao/adfit/i/d;", "Lcom/kakao/adfit/e/h;", "event", "", ViewHierarchyConstants.HINT_KEY, "", "a", "close", "Lcom/kakao/adfit/i/e;", "Lcom/kakao/adfit/i/e;", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/kakao/adfit/i/f;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/i/f;", "transportGate", "Lcom/kakao/adfit/f/c;", "c", "Lcom/kakao/adfit/f/c;", "eventCache", "Ljava/util/concurrent/ExecutorService;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/util/concurrent/ExecutorService;", "executor", "<init>", "(Lcom/kakao/adfit/i/e;Lcom/kakao/adfit/i/f;Lcom/kakao/adfit/f/c;Ljava/util/concurrent/ExecutorService;)V", "", "maxQueueSize", "(Lcom/kakao/adfit/i/e;Lcom/kakao/adfit/i/f;Lcom/kakao/adfit/f/c;I)V", "e", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class b implements Closeable, d {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e transport;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final f transportGate;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final com.kakao.adfit.f.c eventCache;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ExecutorService executor;

    /* JADX INFO: compiled from: AsyncConnection.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/i/b$a;", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", CampaignEx.JSON_KEY_AD_R, "Ljava/lang/Thread;", "newThread", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "cnt", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final AtomicInteger cnt = new AtomicInteger();

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Intrinsics.checkNotNullParameter(r, "r");
            Thread thread = new Thread(r, "AdFitMatrix-AsyncConnection-" + this.cnt.getAndIncrement());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.i.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: AsyncConnection.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0007\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u000e"}, d2 = {"Lcom/kakao/adfit/i/b$b;", "", "", "maxQueueSize", "Lcom/kakao/adfit/f/c;", "eventCache", "Lcom/kakao/adfit/i/g;", "a", ViewHierarchyConstants.HINT_KEY, "", TapjoyConstants.TJC_RETRY, "", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final g a(int maxQueueSize, final com.kakao.adfit.f.c eventCache) {
            g gVar = new g(maxQueueSize, maxQueueSize, 30L, TimeUnit.SECONDS, new a(), new RejectedExecutionHandler() { // from class: com.kakao.adfit.i.-$$Lambda$b$b$DUN26tlUs9amAdFouCLMNEcnNh8
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    b.Companion.a(eventCache, runnable, threadPoolExecutor);
                }
            });
            gVar.allowCoreThreadTimeOut(true);
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(com.kakao.adfit.f.c eventCache, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Intrinsics.checkNotNullParameter(eventCache, "$eventCache");
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                if (!(cVar.getHint() instanceof com.kakao.adfit.g.a)) {
                    eventCache.b(cVar.getEvent());
                }
                b.INSTANCE.a(cVar.getHint(), true);
                com.kakao.adfit.k.f.e("Event rejected: " + cVar.getEvent().getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(Object hint, boolean retry) {
            if (hint instanceof com.kakao.adfit.g.d) {
                ((com.kakao.adfit.g.d) hint).a(false);
            }
            if (hint instanceof com.kakao.adfit.g.c) {
                ((com.kakao.adfit.g.c) hint).b(retry);
            }
        }
    }

    /* JADX INFO: compiled from: AsyncConnection.kt */
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\f\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0012\u0010\u001fR\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/kakao/adfit/i/b$c;", "Ljava/lang/Runnable;", "Lcom/kakao/adfit/i/j;", "a", "", "run", "Lcom/kakao/adfit/i/e;", "Lcom/kakao/adfit/i/e;", "getTransport", "()Lcom/kakao/adfit/i/e;", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/kakao/adfit/i/f;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/i/f;", "getTransportGate", "()Lcom/kakao/adfit/i/f;", "transportGate", "Lcom/kakao/adfit/f/c;", "c", "Lcom/kakao/adfit/f/c;", "getEventCache", "()Lcom/kakao/adfit/f/c;", "eventCache", "Lcom/kakao/adfit/e/h;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/e/h;", "()Lcom/kakao/adfit/e/h;", "event", "", "e", "Ljava/lang/Object;", "()Ljava/lang/Object;", ViewHierarchyConstants.HINT_KEY, InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/i/j;", "failedResult", "<init>", "(Lcom/kakao/adfit/i/e;Lcom/kakao/adfit/i/f;Lcom/kakao/adfit/f/c;Lcom/kakao/adfit/e/h;Ljava/lang/Object;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final e transport;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final f transportGate;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final com.kakao.adfit.f.c eventCache;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final MatrixEvent event;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private final Object hint;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private final j failedResult;

        public c(e transport, f transportGate, com.kakao.adfit.f.c eventCache, MatrixEvent event, Object obj) {
            Intrinsics.checkNotNullParameter(transport, "transport");
            Intrinsics.checkNotNullParameter(transportGate, "transportGate");
            Intrinsics.checkNotNullParameter(eventCache, "eventCache");
            Intrinsics.checkNotNullParameter(event, "event");
            this.transport = transport;
            this.transportGate = transportGate;
            this.eventCache = eventCache;
            this.event = event;
            this.hint = obj;
            this.failedResult = j.INSTANCE.a(-1);
        }

        private final j a() {
            j jVarA = this.failedResult;
            this.eventCache.b(this.event);
            Object obj = this.hint;
            if (obj instanceof com.kakao.adfit.g.b) {
                ((com.kakao.adfit.g.b) obj).a();
                com.kakao.adfit.k.f.a("Disk flush event fired: " + this.event.getId());
            }
            if (this.transportGate.a()) {
                try {
                    jVarA = this.transport.a(this.event);
                    if (!jVarA.getIsSuccess()) {
                        throw new IllegalStateException("The transport failed to send the event with response code " + jVarA.getResponseCode());
                    }
                    this.eventCache.a(this.event);
                } catch (IOException e) {
                    Object obj2 = this.hint;
                    if (obj2 instanceof com.kakao.adfit.g.c) {
                        ((com.kakao.adfit.g.c) obj2).b(true);
                    }
                    throw new IllegalStateException("Sending the event failed.", e);
                }
            } else {
                Object obj3 = this.hint;
                if (obj3 instanceof com.kakao.adfit.g.c) {
                    ((com.kakao.adfit.g.c) obj3).b(true);
                }
            }
            return jVarA;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final MatrixEvent getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final Object getHint() {
            return this.hint;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = this.failedResult;
            try {
                try {
                    j jVarA = a();
                    if (this.hint instanceof com.kakao.adfit.g.d) {
                        com.kakao.adfit.k.f.a("Marking event submission result: " + jVarA.getIsSuccess());
                        ((com.kakao.adfit.g.d) this.hint).a(jVarA.getIsSuccess());
                    }
                } catch (Exception e) {
                    com.kakao.adfit.k.f.b("Event submission failed: " + this.event.getId());
                    throw e;
                }
            } catch (Throwable th) {
                if (this.hint instanceof com.kakao.adfit.g.d) {
                    com.kakao.adfit.k.f.a("Marking event submission result: " + jVar.getIsSuccess());
                    ((com.kakao.adfit.g.d) this.hint).a(jVar.getIsSuccess());
                }
                throw th;
            }
        }
    }

    public b(e transport, f transportGate, com.kakao.adfit.f.c eventCache, ExecutorService executor) {
        Intrinsics.checkNotNullParameter(transport, "transport");
        Intrinsics.checkNotNullParameter(transportGate, "transportGate");
        Intrinsics.checkNotNullParameter(eventCache, "eventCache");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.transport = transport;
        this.transportGate = transportGate;
        this.eventCache = eventCache;
        this.executor = executor;
    }

    @Override // com.kakao.adfit.i.d
    public void a(MatrixEvent event, Object hint) {
        com.kakao.adfit.f.c cVar;
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        com.kakao.adfit.f.c cVar2 = this.eventCache;
        if (hint instanceof com.kakao.adfit.g.a) {
            z = true;
            cVar = com.kakao.adfit.f.d.a;
        } else {
            cVar = cVar2;
            z = false;
        }
        if (!this.transport.a(MatrixItemType.Event)) {
            this.executor.submit(new c(this.transport, this.transportGate, cVar, event, hint));
            return;
        }
        if (z) {
            this.eventCache.a(event);
        }
        INSTANCE.a(hint, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.executor.shutdown();
        com.kakao.adfit.k.f.a("Shutting down AsyncConnection");
        try {
            if (!this.executor.awaitTermination(1L, TimeUnit.MINUTES)) {
                com.kakao.adfit.k.f.e("Failed to shutdown the async connection async sender within 1 minute. Trying to force it now.");
                this.executor.shutdownNow();
            }
            this.transport.close();
        } catch (InterruptedException unused) {
            com.kakao.adfit.k.f.a("Thread interrupted while closing the connection.");
            Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(e transport, f transportGate, com.kakao.adfit.f.c eventCache, int i) {
        this(transport, transportGate, eventCache, INSTANCE.a(i, eventCache));
        Intrinsics.checkNotNullParameter(transport, "transport");
        Intrinsics.checkNotNullParameter(transportGate, "transportGate");
        Intrinsics.checkNotNullParameter(eventCache, "eventCache");
        this.executor.submit(new com.kakao.adfit.f.a(this, eventCache, 0L, 4, null));
    }
}

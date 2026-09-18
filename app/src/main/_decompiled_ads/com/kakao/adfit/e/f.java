package com.kakao.adfit.e;

import android.content.Context;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakao.adfit.common.matrix.transport.HttpTransport;
import com.kakao.adfit.h.MatrixBreadcrumb;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Matrix.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\b\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\b\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\fH\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R$\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u001b\"\u0004\b\b\u0010\u001cR\u0011\u0010 \u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u001f¨\u0006#"}, d2 = {"Lcom/kakao/adfit/e/f;", "Lcom/kakao/adfit/e/d;", "Landroid/content/Context;", "context", "", "Lcom/kakao/adfit/e/c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/i/d;", "a", "", "maxBreadcrumb", "Ljava/util/Queue;", "Lcom/kakao/adfit/h/b;", "", "c", "Lcom/kakao/adfit/e/h;", "event", "", ViewHierarchyConstants.HINT_KEY, "Lcom/kakao/adfit/e/i;", "", "throwable", "breadcrumb", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "clientReference", "value", "()Lcom/kakao/adfit/e/d;", "(Lcom/kakao/adfit/e/d;)V", "client", "", "()Z", "isEnabled", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class f implements d {
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AtomicReference<d> clientReference = new AtomicReference<>(new k());

    private f() {
    }

    public i a(Throwable th, Object obj) {
        return d.a.a(this, th, obj);
    }

    public final boolean b() {
        return !(clientReference.get() instanceof k);
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (b()) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        synchronized (this) {
            f fVar = a;
            if (fVar.b()) {
                return;
            }
            fVar.a(new g(fVar.b(context), fVar.a(context), a(fVar, 0, 1, null)));
            Unit unit = Unit.INSTANCE;
            com.kakao.adfit.k.f.d("Matrix is initialized.");
            new j().a(context);
        }
    }

    private final d a() {
        d dVar = clientReference.get();
        Intrinsics.checkNotNullExpressionValue(dVar, "clientReference.get()");
        return dVar;
    }

    private final List<c> b(Context context) {
        com.kakao.adfit.j.g gVar = new com.kakao.adfit.j.g(CollectionsKt.emptyList(), CollectionsKt.listOf("com.kakao.adfit"));
        return CollectionsKt.listOf((Object[]) new c[]{new e(new com.kakao.adfit.j.h(gVar, false, 2, null), new com.kakao.adfit.j.f(gVar)), new a(context)});
    }

    private final void a(d dVar) {
        clientReference.set(dVar);
    }

    private final com.kakao.adfit.i.d a(Context context) {
        b bVarA = b.INSTANCE.a("https://328dfa7b946e4e70b732594978f42a90@aem-collector.daumkakao.io/3695");
        com.kakao.adfit.j.e eVar = new com.kakao.adfit.j.e();
        return new com.kakao.adfit.i.b(new HttpTransport(bVarA, eVar, new com.kakao.adfit.j.b(), null, 0, 0, 56, null), new com.kakao.adfit.i.a(context), new com.kakao.adfit.f.b(context, 10, eVar), 10);
    }

    static /* synthetic */ Queue a(f fVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        return fVar.a(i);
    }

    private final Queue<MatrixBreadcrumb> a(int maxBreadcrumb) {
        com.kakao.adfit.j.j jVarA = com.kakao.adfit.j.j.a(new com.kakao.adfit.j.a(maxBreadcrumb));
        Intrinsics.checkNotNullExpressionValue(jVarA, "synchronizedQueue(Circul…FifoQueue(maxBreadcrumb))");
        return jVarA;
    }

    @Override // com.kakao.adfit.e.d
    public i a(MatrixEvent event, Object hint) {
        Intrinsics.checkNotNullParameter(event, "event");
        return a().a(event, hint);
    }

    public final i a(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return a(throwable, (Object) null);
    }

    @Override // com.kakao.adfit.e.d
    public void a(MatrixBreadcrumb breadcrumb) {
        Intrinsics.checkNotNullParameter(breadcrumb, "breadcrumb");
        a().a(breadcrumb);
    }
}

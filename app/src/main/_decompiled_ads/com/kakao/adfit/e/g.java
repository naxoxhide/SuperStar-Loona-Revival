package com.kakao.adfit.e;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakao.adfit.h.MatrixBreadcrumb;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/e/g;", "Lcom/kakao/adfit/e/d;", "Lcom/kakao/adfit/e/h;", "event", "a", "", ViewHierarchyConstants.HINT_KEY, "Lcom/kakao/adfit/e/i;", "Lcom/kakao/adfit/h/b;", "breadcrumb", "", "", "Lcom/kakao/adfit/e/c;", "Ljava/util/List;", "eventProcessors", "Lcom/kakao/adfit/i/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/i/d;", "connection", "Ljava/util/Queue;", "c", "Ljava/util/Queue;", "breadcrumbs", "<init>", "(Ljava/util/List;Lcom/kakao/adfit/i/d;Ljava/util/Queue;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<c> eventProcessors;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.kakao.adfit.i.d connection;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Queue<MatrixBreadcrumb> breadcrumbs;

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends c> eventProcessors, com.kakao.adfit.i.d connection, Queue<MatrixBreadcrumb> breadcrumbs) {
        Intrinsics.checkNotNullParameter(eventProcessors, "eventProcessors");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(breadcrumbs, "breadcrumbs");
        this.eventProcessors = eventProcessors;
        this.connection = connection;
        this.breadcrumbs = breadcrumbs;
    }

    @Override // com.kakao.adfit.e.d
    public i a(MatrixEvent event, Object hint) {
        Intrinsics.checkNotNullParameter(event, "event");
        i id = event.getId();
        if (id == null) {
            id = i.INSTANCE.b();
            event.a(id);
        }
        if (!(hint instanceof com.kakao.adfit.g.a) && a(event) == null) {
            com.kakao.adfit.k.f.a("Event was dropped: " + id);
            return i.INSTANCE.a();
        }
        for (c cVar : this.eventProcessors) {
            if (cVar.a(event, hint) == null) {
                com.kakao.adfit.k.f.a("Event was dropped by processor: " + id + ", " + cVar.getClass().getName());
                return i.INSTANCE.a();
            }
        }
        try {
            this.connection.a(event, hint);
        } catch (IOException e) {
            com.kakao.adfit.k.f.c("Capturing event " + id + " failed.", e);
        }
        return id;
    }

    private final MatrixEvent a(MatrixEvent event) {
        List<MatrixBreadcrumb> listA = event.a();
        if (listA == null) {
            event.a(CollectionsKt.toList(this.breadcrumbs));
        } else {
            event.a(CollectionsKt.plus((Collection) listA, (Iterable) this.breadcrumbs));
        }
        return event;
    }

    @Override // com.kakao.adfit.e.d
    public void a(MatrixBreadcrumb breadcrumb) {
        Intrinsics.checkNotNullParameter(breadcrumb, "breadcrumb");
        this.breadcrumbs.add(breadcrumb);
    }
}

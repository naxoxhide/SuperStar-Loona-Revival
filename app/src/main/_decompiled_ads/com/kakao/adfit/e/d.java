package com.kakao.adfit.e;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakao.adfit.h.MatrixBreadcrumb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IMatrixClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/e/d;", "", "Lcom/kakao/adfit/e/h;", "event", ViewHierarchyConstants.HINT_KEY, "Lcom/kakao/adfit/e/i;", "a", "Lcom/kakao/adfit/h/b;", "breadcrumb", "", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface d {

    /* JADX INFO: compiled from: IMatrixClient.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static i a(d dVar, Throwable throwable, Object obj) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return dVar.a(MatrixEvent.Companion.a(MatrixEvent.INSTANCE, null, throwable, null, 5, null), obj);
        }
    }

    i a(MatrixEvent event, Object hint);

    void a(MatrixBreadcrumb breadcrumb);
}

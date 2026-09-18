package com.kakao.adfit.f;

import com.kakao.adfit.e.MatrixEvent;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpEventCache.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/f/d;", "Lcom/kakao/adfit/f/c;", "Lcom/kakao/adfit/e/h;", "event", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "", "iterator", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class d implements c {
    public static final d a = new d();

    private d() {
    }

    @Override // com.kakao.adfit.f.c
    public void a(MatrixEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.kakao.adfit.f.c
    public void b(MatrixEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // java.lang.Iterable
    public Iterator<MatrixEvent> iterator() {
        return CollectionsKt.emptyList().iterator();
    }
}

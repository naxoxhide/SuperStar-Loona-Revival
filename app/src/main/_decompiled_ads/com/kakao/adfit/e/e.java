package com.kakao.adfit.e;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakao.adfit.AdFitSdk;
import com.kakao.adfit.h.MatrixException;
import com.kakao.adfit.h.MatrixSdkPackage;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainEventProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/kakao/adfit/e/e;", "Lcom/kakao/adfit/e/c;", "Lcom/kakao/adfit/e/h;", "event", "", "a", "", "c", "Lcom/kakao/adfit/h/m;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", ViewHierarchyConstants.HINT_KEY, "Lcom/kakao/adfit/j/h;", "Lcom/kakao/adfit/j/h;", "threadFactory", "Lcom/kakao/adfit/j/f;", "Lcom/kakao/adfit/j/f;", "exceptionFactory", "<init>", "(Lcom/kakao/adfit/j/h;Lcom/kakao/adfit/j/f;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final com.kakao.adfit.j.h threadFactory;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.kakao.adfit.j.f exceptionFactory;

    public e(com.kakao.adfit.j.h threadFactory, com.kakao.adfit.j.f exceptionFactory) {
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        Intrinsics.checkNotNullParameter(exceptionFactory, "exceptionFactory");
        this.threadFactory = threadFactory;
        this.exceptionFactory = exceptionFactory;
    }

    private final String a() {
        return "AdFit-network@3.13.6+@f1250a8a-1aac-4206-aaaa-acb32eeb9eb3";
    }

    private final MatrixSdkPackage b() {
        return new MatrixSdkPackage("com.kakao.adfit.ads", AdFitSdk.SDK_VERSION, null, 4, null);
    }

    private final String c() {
        return "network";
    }

    @Override // com.kakao.adfit.e.c
    public MatrixEvent a(MatrixEvent event, Object hint) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPlatform() == null) {
            event.c("java");
        }
        Throwable throwable = event.getThrowable();
        if (throwable != null) {
            event.b(this.exceptionFactory.b(throwable));
        }
        if (!(hint instanceof com.kakao.adfit.g.a)) {
            a(event);
        }
        return event;
    }

    private final void a(MatrixEvent event) {
        if (event.getRelease() == null) {
            event.d(a());
        }
        if (event.getServerName() == null) {
            event.e(c());
        }
        if (event.getSdk() == null) {
            event.a(b());
        }
        if (event.m() == null) {
            ArrayList arrayList = null;
            List<MatrixException> listF = event.f();
            if (listF != null) {
                for (MatrixException matrixException : listF) {
                    Long threadId = matrixException.getThreadId();
                    if (matrixException.getMechanism() != null && threadId != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(threadId);
                    }
                }
            }
            event.c(this.threadFactory.a(arrayList));
        }
    }
}

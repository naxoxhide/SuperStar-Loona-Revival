package com.kakao.adfit.j;

import com.kakao.adfit.h.MatrixStackFrame;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MatrixStackTraceFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0007\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/kakao/adfit/j/g;", "", "", "Ljava/lang/StackTraceElement;", "elements", "", "Lcom/kakao/adfit/h/n;", "a", "([Ljava/lang/StackTraceElement;)Ljava/util/List;", "", "className", "", "Ljava/util/List;", "inAppExcludes", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "inAppIncludes", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class g {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<String> inAppExcludes;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<String> inAppIncludes;

    public g(List<String> inAppExcludes, List<String> inAppIncludes) {
        Intrinsics.checkNotNullParameter(inAppExcludes, "inAppExcludes");
        Intrinsics.checkNotNullParameter(inAppIncludes, "inAppIncludes");
        this.inAppExcludes = inAppExcludes;
        this.inAppIncludes = inAppIncludes;
    }

    public final List<MatrixStackFrame> a(StackTraceElement[] elements) {
        ArrayList arrayList = new ArrayList();
        if (elements != null) {
            for (StackTraceElement stackTraceElement : elements) {
                if (stackTraceElement != null) {
                    String className = stackTraceElement.getClassName();
                    String methodName = stackTraceElement.getMethodName();
                    String fileName = stackTraceElement.getFileName();
                    Integer numValueOf = Integer.valueOf(stackTraceElement.getLineNumber());
                    arrayList.add(new MatrixStackFrame(className, methodName, fileName, numValueOf.intValue() > 0 ? numValueOf : null, Boolean.valueOf(a(stackTraceElement.getClassName())), Boolean.valueOf(stackTraceElement.isNativeMethod())));
                }
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        CollectionsKt.reverse(arrayList);
        return arrayList;
    }

    public final boolean a(String className) {
        if (className == null || className.length() == 0) {
            return true;
        }
        Iterator<String> it = this.inAppIncludes.iterator();
        while (it.hasNext()) {
            if (StringsKt.startsWith$default(className, it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        Iterator<String> it2 = this.inAppExcludes.iterator();
        while (it2.hasNext() && !StringsKt.startsWith$default(className, it2.next(), false, 2, (Object) null)) {
        }
        return false;
    }
}

package com.kakao.adfit.k;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tapjoy.TJAdUnitConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/k/a;", "", "Landroid/view/View$AccessibilityDelegate;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View$AccessibilityDelegate;", "a", "()Landroid/view/View$AccessibilityDelegate;", "clickableViewAccessibilityDelegate", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final View.AccessibilityDelegate clickableViewAccessibilityDelegate = new C0462a();

    /* JADX INFO: renamed from: com.kakao.adfit.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/kakao/adfit/k/a$a", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", TJAdUnitConstants.String.VIDEO_INFO, "", "onInitializeAccessibilityNodeInfo", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class C0462a extends View.AccessibilityDelegate {
        C0462a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (info.isClickable()) {
                info.setClassName(Button.class.getName());
            }
        }
    }

    private a() {
    }

    public final View.AccessibilityDelegate a() {
        return clickableViewAccessibilityDelegate;
    }
}

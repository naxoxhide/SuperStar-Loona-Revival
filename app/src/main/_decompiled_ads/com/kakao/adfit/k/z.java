package com.kakao.adfit.k;

import android.content.Context;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/k/z;", "", "Landroid/content/Context;", "context", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "Z", "isInitialized", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class z {
    public static final z a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isInitialized;

    private z() {
    }

    private final void a(Context context) {
        if (!x.a(context)) {
            throw new SecurityException("Ensure that you add the INTERNET, ACCESS_NETWORK_STATE in your AndroidManifest.xml");
        }
        f.a.b(context);
        b.a.a(context);
        com.kakao.adfit.e.f.a.c(context);
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInitialized) {
            return;
        }
        isInitialized = true;
        a(context);
    }
}

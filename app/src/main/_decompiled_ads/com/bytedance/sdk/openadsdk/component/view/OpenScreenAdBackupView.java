package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;

/* JADX INFO: loaded from: classes2.dex */
public class OpenScreenAdBackupView extends BackupView {
    private NativeExpressView m;

    public OpenScreenAdBackupView(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(View view, int i, m mVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, mVar);
        }
    }

    public void a(NativeExpressView nativeExpressView) {
        this.m = nativeExpressView;
        nativeExpressView.addView(this, new FrameLayout.LayoutParams(-1, -1));
    }
}

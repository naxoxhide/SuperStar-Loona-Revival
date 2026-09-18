package com.mbridge.msdk.activity;

import android.os.Build;
import android.os.Bundle;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;

/* JADX INFO: loaded from: classes3.dex */
public class MBCommonActivity extends DomainMBCommonActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1868b = false;

    @Override // com.mbridge.msdk.activity.DomainMBCommonActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.browserView != null) {
            this.browserView.setListener(null);
            this.browserView.destroy();
        }
        BrowserView browserViewRemove = b.a.remove(this.a);
        if (browserViewRemove != null) {
            browserViewRemove.setListener(null);
            browserViewRemove.destroy();
        }
        this.f1868b = true;
        super.finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f1868b) {
            return;
        }
        if (this.browserView != null) {
            this.browserView.setListener(null);
            this.browserView.destroy();
        }
        BrowserView browserViewRemove = b.a.remove(this.a);
        if (browserViewRemove != null) {
            browserViewRemove.setListener(null);
            browserViewRemove.destroy();
        }
    }
}

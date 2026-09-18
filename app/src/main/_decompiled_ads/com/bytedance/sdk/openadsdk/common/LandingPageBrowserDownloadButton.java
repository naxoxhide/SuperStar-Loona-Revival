package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class LandingPageBrowserDownloadButton extends Button {
    public LandingPageBrowserDownloadButton(Context context) {
        super(context);
        a();
    }

    private void a() {
        setId(com.bytedance.sdk.openadsdk.utils.h.m0);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, b0.a(context, 48.0f)));
        setBackgroundResource(t.e(context, "tt_browser_download_selector"));
        setText(t.j(context, "tt_video_download_apk"));
        setTextColor(-1);
        setTextSize(2, 16.0f);
    }
}

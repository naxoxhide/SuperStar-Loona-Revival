package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class TTBackUpAdImageView extends PAGImageView {
    public TTBackUpAdImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setId(520093739);
        setImageResource(t.e(getContext(), "tt_ad_logo_new"));
        setPadding(b0.a(getContext(), 1.0f), b0.a(getContext(), 1.0f), b0.a(getContext(), 1.0f), b0.a(getContext(), 1.0f));
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.customview.PAGImageView, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = b0.a(getContext(), 28.0f);
        layoutParams.height = b0.a(getContext(), 13.0f);
        super.setLayoutParams(layoutParams);
    }
}

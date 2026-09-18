package com.bytedance.sdk.openadsdk.api.banner;

import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes2.dex */
public final class PAGBannerSize {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f427b;
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(320, 50);
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, 250);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);

    public PAGBannerSize(int i, int i2) {
        this.a = i;
        this.f427b = i2;
    }

    public int getHeight() {
        return this.f427b;
    }

    public int getWidth() {
        return this.a;
    }
}

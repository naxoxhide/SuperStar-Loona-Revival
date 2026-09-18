package com.tnkfactory.ad;

import com.tnkfactory.ad.pub.a.j1;

/* JADX INFO: loaded from: classes4.dex */
public class NativeViewBinder extends j1 {
    public NativeViewBinder(int i) {
        a(4, i);
    }

    public NativeViewBinder addClickView(int i) {
        a(100, i);
        return this;
    }

    public NativeViewBinder advertiserLogoId(int i) {
        a(6, i);
        return this;
    }

    public NativeViewBinder advertiserNameId(int i) {
        a(5, i);
        return this;
    }

    public NativeViewBinder callToActionId(int i) {
        a(7, i);
        return this;
    }

    public NativeViewBinder contentId(int i) {
        a(4, i);
        return this;
    }

    public NativeViewBinder downloadCountId(int i) {
        a(9, i);
        return this;
    }

    public NativeViewBinder iconId(int i) {
        a(3, i);
        return this;
    }

    public NativeViewBinder numberRatingId(int i) {
        a(11, i);
        return this;
    }

    public NativeViewBinder starRatingColors(int i, int i2, int i3) {
        this.w = i;
        this.x = i2;
        this.y = i3;
        return this;
    }

    public NativeViewBinder starRatingId(int i) {
        a(10, i);
        return this;
    }

    public NativeViewBinder starRatingProperties(int i, float f, float f2) {
        this.z = i;
        this.B = f;
        this.A = f2;
        return this;
    }

    public NativeViewBinder textId(int i) {
        a(2, i);
        return this;
    }

    public NativeViewBinder titleId(int i) {
        a(1, i);
        return this;
    }

    public NativeViewBinder watermarkIconId(int i) {
        a(8, i);
        return this;
    }

    public NativeViewBinder starRatingProperties(int i, float f, float f2, int i2, int i3, int i4) {
        this.z = i;
        this.B = f;
        this.A = f2;
        this.w = i2;
        this.x = i3;
        this.y = i4;
        return this;
    }
}

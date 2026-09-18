package com.tapjoy.internal;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.tapjoy.TJAdUnitActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class c8 implements Runnable {
    public final /* synthetic */ float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f2737b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ com.tapjoy.c e;

    public c8(com.tapjoy.c cVar, float f, float f2, float f3, float f4) {
        this.e = cVar;
        this.a = f;
        this.f2737b = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitActivity tJAdUnitActivity = this.e.a.d;
        float f = this.a;
        float f2 = this.f2737b;
        float f3 = this.c;
        float f4 = this.d;
        DisplayMetrics displayMetrics = tJAdUnitActivity.getResources().getDisplayMetrics();
        int iApplyDimension = (int) TypedValue.applyDimension(1, f, displayMetrics);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, f2, displayMetrics);
        int iApplyDimension3 = (int) TypedValue.applyDimension(1, f3, displayMetrics);
        int iApplyDimension4 = (int) TypedValue.applyDimension(1, f4, displayMetrics);
        ViewGroup viewGroup = (ViewGroup) tJAdUnitActivity.g.getVideoView().getParent();
        ((ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()).setMargins(iApplyDimension, iApplyDimension2, iApplyDimension3, iApplyDimension4);
        viewGroup.requestLayout();
    }
}

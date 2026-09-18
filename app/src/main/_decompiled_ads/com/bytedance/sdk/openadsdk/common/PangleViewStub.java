package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class PangleViewStub extends View {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f525b;

    public interface a {
        View a(Context context);
    }

    public PangleViewStub(Context context, a aVar) {
        super(context);
        this.a = aVar;
        b();
    }

    private View a() {
        a aVar;
        if (this.f525b == null && (aVar = this.a) != null) {
            this.f525b = aVar.a(getContext());
            a(this.f525b, (ViewGroup) getParent());
        }
        return this.f525b;
    }

    private void b() {
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        View view = this.f525b;
        if (view != null) {
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }

    private void a(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }
}

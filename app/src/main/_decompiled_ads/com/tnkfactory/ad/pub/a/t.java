package com.tnkfactory.ad.pub.a;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes4.dex */
public final class t {
    public Bitmap a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f2889b;

    public t(Context context, String str) {
        this.a = null;
        this.f2889b = null;
        if (str == null || str.length() == 0) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 0) {
            this.a = g0.b(context, strArrSplit[0].replace("http:", "https:"));
        }
        if (strArrSplit.length > 1) {
            this.f2889b = g0.b(context, strArrSplit[1].replace("http:", "https:"));
        }
    }

    public t(Bitmap bitmap) {
        this.f2889b = null;
        this.a = bitmap;
    }

    public final void a(View view) {
        Drawable bitmapDrawable;
        if (view == null) {
            return;
        }
        Resources resources = view.getContext().getResources();
        if (this.a == null) {
            view.setBackground(null);
            return;
        }
        if (this.f2889b == null) {
            bitmapDrawable = new BitmapDrawable(resources, this.a);
        } else if (view instanceof ToggleButton) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_checked}, new BitmapDrawable(resources, this.f2889b));
            stateListDrawable.addState(new int[0], new BitmapDrawable(resources, this.a));
            bitmapDrawable = stateListDrawable;
        } else {
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            stateListDrawable2.addState(new int[]{R.attr.state_pressed}, new BitmapDrawable(resources, this.f2889b));
            stateListDrawable2.addState(new int[0], new BitmapDrawable(resources, this.a));
            bitmapDrawable = stateListDrawable2;
        }
        view.setBackground(bitmapDrawable);
    }
}

package com.igaworks.adpopcorn.cores.common;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static void a(View view) {
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(null);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i));
            }
            if (!(view instanceof AdapterView)) {
                viewGroup.removeAllViews();
            }
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        }
    }
}

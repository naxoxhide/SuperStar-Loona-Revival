package com.igaworks.adpopcorn.activity.c.j;

import android.content.Context;
import android.widget.ImageView;
import com.igaworks.adpopcorn.R;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ImageView {
    public c(Context context) {
        super(context);
    }

    public void setChecked(boolean z) {
        setScaleType(ImageView.ScaleType.FIT_XY);
        if (z) {
            setImageResource(R.drawable.onestore_ic_all_check_on);
        } else {
            setImageBitmap(null);
        }
    }
}

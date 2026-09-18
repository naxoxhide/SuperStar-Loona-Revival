package com.igaworks.adpopcorn.activity.c.j;

import android.content.Context;
import android.widget.ImageView;
import com.igaworks.adpopcorn.R;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ImageView {
    private boolean a;

    public d(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        setScaleType(ImageView.ScaleType.FIT_XY);
        setImageResource(z ? R.drawable.onestore_ic_radio_on : R.drawable.onestore_ic_check_off);
        this.a = z;
    }
}

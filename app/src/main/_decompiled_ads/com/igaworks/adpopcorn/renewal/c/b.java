package com.igaworks.adpopcorn.renewal.c;

import android.content.Context;
import android.graphics.PorterDuff;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;

/* JADX INFO: loaded from: classes2.dex */
public class b extends i {
    private boolean n;

    public b(Context context) {
        super(context, d.a(context, 2));
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.n;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        if (z) {
            setImageResource(R.drawable.ap_reward_ic_checkbox_on);
            setColorFilter(ApRewardStyle.mainOfferwallColor, PorterDuff.Mode.MULTIPLY);
        } else {
            setImageResource(0);
        }
        this.n = z;
    }
}

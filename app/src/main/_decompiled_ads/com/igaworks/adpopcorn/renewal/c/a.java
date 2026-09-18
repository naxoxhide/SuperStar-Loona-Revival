package com.igaworks.adpopcorn.renewal.c;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;

/* JADX INFO: loaded from: classes2.dex */
public class a extends i {
    private boolean n;

    public a(Context context) {
        super(context, d.a(context, 2));
        setImageResource(R.drawable.ap_reward_ic_checkbox_off);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.n;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        if (z) {
            setImageResource(R.drawable.ap_reward_ic_checkbox_on);
            setColorFilter(ApRewardStyle.mainOfferwallColor, PorterDuff.Mode.XOR);
        } else {
            setImageResource(R.drawable.ap_reward_ic_checkbox_off);
            setColorFilter((ColorFilter) null);
        }
        this.n = z;
    }
}

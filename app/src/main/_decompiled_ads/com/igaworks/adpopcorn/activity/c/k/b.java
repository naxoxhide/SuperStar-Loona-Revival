package com.igaworks.adpopcorn.activity.c.k;

import android.content.Context;
import android.widget.ImageView;
import com.igaworks.adpopcorn.R;

/* JADX INFO: loaded from: classes2.dex */
public class b extends ImageView {
    public b(Context context) {
        super(context);
        setImageResource(R.drawable.tpmn_radionull);
    }

    public void setChecked(boolean z) {
        setImageResource(z ? R.drawable.tpmn_radiofull : R.drawable.tpmn_radionull);
    }
}

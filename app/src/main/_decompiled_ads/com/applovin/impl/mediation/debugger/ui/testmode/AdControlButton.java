package com.applovin.impl.mediation.debugger.ui.testmode;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.utils.g;
import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: loaded from: classes.dex */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {
    private final com.applovin.impl.adview.a aqJ;
    private final GradientDrawable atH;
    private final Button atI;
    private b atJ;
    private a atK;
    private MaxAdFormat format;

    public interface a {
        void onClick(AdControlButton adControlButton);
    }

    public enum b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, null, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.atH = gradientDrawable;
        Button button = new Button(getContext());
        this.atI = button;
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a(getContext(), 20, R.attr.progressBarStyleSmall);
        this.aqJ = aVar;
        this.atJ = b.LOAD;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        gradientDrawable.setCornerRadius(20.0f);
        button.setBackground(gradientDrawable);
        xc();
        aVar.setColor(-1);
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
        a(b.LOAD);
    }

    public b getControlState() {
        return this.atJ;
    }

    public void setControlState(b bVar) {
        if (this.atJ != bVar) {
            a(bVar);
        }
        this.atJ = bVar;
    }

    public MaxAdFormat getFormat() {
        return this.format;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.format = maxAdFormat;
    }

    private void a(b bVar) {
        if (b.LOADING == bVar) {
            setEnabled(false);
            this.aqJ.qN();
        } else {
            setEnabled(true);
            this.aqJ.qO();
        }
        this.atI.setText(b(bVar));
        this.atH.setColor(c(bVar));
    }

    private String b(b bVar) {
        if (b.LOAD == bVar) {
            return ADXLogUtil.EVENT_LOAD;
        }
        return b.LOADING == bVar ? "" : "Show";
    }

    private int c(b bVar) {
        if (b.LOAD == bVar) {
            return g.a(com.applovin.sdk.R.color.applovin_sdk_brand_color, getContext());
        }
        if (b.LOADING == bVar) {
            return g.a(com.applovin.sdk.R.color.applovin_sdk_brand_color, getContext());
        }
        return g.a(com.applovin.sdk.R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    public void setOnClickListener(a aVar) {
        this.atK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.atK;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    private void xc() {
        this.atI.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{g.a(com.applovin.sdk.R.color.applovin_sdk_highlightTextColor, getContext()), -1}));
    }
}

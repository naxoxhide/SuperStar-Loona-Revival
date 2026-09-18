package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SubtitleView extends FrameLayout implements an.d {
    private List<com.applovin.exoplayer2.i.a> OV;
    private c VU;
    private float VV;
    private int YW;
    private float YX;
    private boolean YY;
    private boolean YZ;
    private int Za;
    private a Zb;
    private View Zc;

    interface a {
        void a(List<com.applovin.exoplayer2.i.a> list, c cVar, float f, int i, float f2);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OV = Collections.emptyList();
        this.VU = c.VW;
        this.YW = 0;
        this.YX = 0.0533f;
        this.VV = 0.08f;
        this.YY = true;
        this.YZ = true;
        b bVar = new b(context);
        this.Zb = bVar;
        this.Zc = bVar;
        addView(bVar);
        this.Za = 1;
    }

    @Override // com.applovin.exoplayer2.an.d
    public void e(List<com.applovin.exoplayer2.i.a> list) {
        setCues(list);
    }

    public void setCues(List<com.applovin.exoplayer2.i.a> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.OV = list;
        nY();
    }

    public void setViewType(int i) {
        if (this.Za == i) {
            return;
        }
        if (i == 1) {
            setView(new b(getContext()));
        } else if (i == 2) {
            setView(new l(getContext()));
        } else {
            throw new IllegalArgumentException();
        }
        this.Za = i;
    }

    private <T extends View & a> void setView(T t) {
        removeView(this.Zc);
        View view = this.Zc;
        if (view instanceof l) {
            ((l) view).destroy();
        }
        this.Zc = t;
        this.Zb = t;
        addView(t);
    }

    public void nW() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setFractionalTextSize(float f) {
        a(f, false);
    }

    public void a(float f, boolean z) {
        c(z ? 1 : 0, f);
    }

    private void c(int i, float f) {
        this.YW = i;
        this.YX = f;
        nY();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.YY = z;
        nY();
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.YZ = z;
        nY();
    }

    public void nX() {
        setStyle(getUserCaptionStyle());
    }

    public void setStyle(c cVar) {
        this.VU = cVar;
        nY();
    }

    public void setBottomPaddingFraction(float f) {
        this.VV = f;
        nY();
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (ai.acV < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        if (ai.acV < 19 || isInEditMode()) {
            return c.VW;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager != null && captioningManager.isEnabled()) {
            return c.a(captioningManager.getUserStyle());
        }
        return c.VW;
    }

    private void nY() {
        this.Zb.a(getCuesWithStylingPreferencesApplied(), this.VU, this.YX, this.YW, this.VV);
    }

    private List<com.applovin.exoplayer2.i.a> getCuesWithStylingPreferencesApplied() {
        if (this.YY && this.YZ) {
            return this.OV;
        }
        ArrayList arrayList = new ArrayList(this.OV.size());
        for (int i = 0; i < this.OV.size(); i++) {
            arrayList.add(b(this.OV.get(i)));
        }
        return arrayList;
    }

    private com.applovin.exoplayer2.i.a b(com.applovin.exoplayer2.i.a aVar) {
        com.applovin.exoplayer2.i.a.C0098a c0098aLP = aVar.lP();
        if (!this.YY) {
            j.a(c0098aLP);
        } else if (!this.YZ) {
            j.b(c0098aLP);
        }
        return c0098aLP.lU();
    }
}

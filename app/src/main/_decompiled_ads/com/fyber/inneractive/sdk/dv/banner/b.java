package com.fyber.inneractive.sdk.dv.banner;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.r;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.l;
import com.google.android.gms.ads.AdView;

/* JADX INFO: loaded from: classes2.dex */
public class b extends r<a, InneractiveAdViewEventsListener> implements com.fyber.inneractive.sdk.interfaces.b {
    public ViewGroup l;

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void a() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void a(int i) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void a(ViewGroup viewGroup) {
        AdContent adcontent;
        if (this.a == null) {
            IAlog.e("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        if (viewGroup == null || (adcontent = this.f928b) == 0) {
            return;
        }
        a aVar = (a) adcontent;
        if (aVar.i != 0) {
            aVar.h = this;
            if (aVar.j) {
                w();
                aVar.j = false;
            }
            this.l = viewGroup;
            viewGroup.addView((View) ((a) this.f928b).i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.flow.r, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            a aVar = (a) adcontent;
            if (aVar.i != 0) {
                ((AdView) aVar.i).destroy();
            }
            ((a) this.f928b).a();
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.l = null;
        }
        super.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.interfaces.b
    public int f() {
        AdContent adcontent = this.f928b;
        if (adcontent == 0) {
            return 0;
        }
        a aVar = (a) adcontent;
        if (aVar.i == 0 || ((AdView) aVar.i).getAdSize() == null) {
            return 0;
        }
        return l.b(((AdView) ((a) this.f928b).i).getAdSize().getWidth());
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.interfaces.b
    public int p() {
        AdContent adcontent = this.f928b;
        if (adcontent == 0) {
            return 0;
        }
        a aVar = (a) adcontent;
        if (aVar.i == 0 || ((AdView) aVar.i).getAdSize() == null) {
            return 0;
        }
        return l.b(((AdView) ((a) this.f928b).i).getAdSize().getHeight());
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void r() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void u() {
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.l = null;
        }
    }

    public void w() {
        E();
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            a aVar = (a) adcontent;
            if (((f) aVar.f927b) != null) {
                b((f) aVar.f927b);
                a aVar2 = (a) this.f928b;
                if (aVar2.d == null || ((a0) aVar2.d).c == null) {
                    return;
                }
                a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, ((a0) aVar2.d).c.f899b == UnitDisplayType.MRECT ? com.fyber.inneractive.sdk.cache.session.enums.b.RECTANGLE_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.b.BANNER_DISPLAY);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.r
    public View y() {
        return this.l;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public boolean a(q qVar) {
        return qVar instanceof com.fyber.inneractive.sdk.dv.a;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public boolean a(View view) {
        ViewGroup viewGroup = this.l;
        return viewGroup != null && viewGroup.equals(view);
    }
}

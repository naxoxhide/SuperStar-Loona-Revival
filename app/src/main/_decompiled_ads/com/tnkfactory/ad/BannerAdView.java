package com.tnkfactory.ad;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tnkfactory.ad.pub.R;
import com.tnkfactory.ad.pub.a.b;
import com.tnkfactory.ad.pub.a.r;

/* JADX INFO: loaded from: classes4.dex */
public class BannerAdView extends RelativeLayout implements AdItem {
    public static final /* synthetic */ int d = 0;
    public r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2857b;
    public a c;

    public class a implements ViewTreeObserver.OnWindowFocusChangeListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            BannerAdView bannerAdView = BannerAdView.this;
            int i = BannerAdView.d;
            bannerAdView.a(z);
        }
    }

    public BannerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2857b = false;
        this.c = null;
        this.a = b.a(this).a(context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AdView, 0, 0).getString(R.styleable.AdView_placement_id));
        a();
    }

    public BannerAdView(Context context, String str) {
        super(context);
        this.f2857b = false;
        this.c = null;
        this.a = b.a(this).a(str);
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            a aVar = new a();
            this.c = aVar;
            viewTreeObserver.addOnWindowFocusChangeListener(aVar);
        }
    }

    public final void a(boolean z) {
        r rVar = this.a;
        if (rVar == null) {
            return;
        }
        if (!z) {
            rVar.h();
        } else if (getVisibility() == 0 && this.f2857b) {
            this.a.i();
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getPlacementId() {
        r rVar = this.a;
        if (rVar != null) {
            return rVar.a;
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getTransactionId() {
        r rVar = this.a;
        if (rVar != null) {
            return rVar.c();
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public Object getValue(String str) {
        r rVar = this.a;
        if (rVar != null) {
            return rVar.a(str);
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isEmpty() {
        r rVar = this.a;
        if (rVar != null) {
            return rVar.e();
        }
        return true;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isInvalidated() {
        r rVar = this.a;
        if (rVar != null) {
            return rVar.f();
        }
        return true;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isLoaded() {
        r rVar = this.a;
        if (rVar != null) {
            return rVar.g();
        }
        return false;
    }

    @Override // com.tnkfactory.ad.AdItem
    public void load() {
        r rVar = this.a;
        if (rVar != null) {
            this.f2857b = true;
            rVar.c(getContext());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r rVar = this.a;
        if (rVar != null) {
            rVar.b();
            if (Build.VERSION.SDK_INT < 18 || this.c == null) {
                return;
            }
            getViewTreeObserver().removeOnWindowFocusChangeListener(this.c);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        r rVar = this.a;
        if (rVar != null) {
            int[] iArrA = rVar.a(i, i2);
            setMeasuredDimension(iArrA[0], iArrA[1]);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a(z);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setListener(AdListener adListener) {
        r rVar = this.a;
        if (rVar != null) {
            rVar.f2886b = adListener;
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setValue(String str, Object obj) {
        r rVar = this.a;
        if (rVar != null) {
            rVar.a(str, obj);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            r rVar = this.a;
            if (rVar != null) {
                rVar.h();
                return;
            }
            return;
        }
        r rVar2 = this.a;
        if (rVar2 == null || !this.f2857b) {
            return;
        }
        rVar2.i();
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
    }
}

package com.tnkfactory.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tnkfactory.ad.pub.R;
import com.tnkfactory.ad.pub.a.b;
import com.tnkfactory.ad.pub.a.r;

/* JADX INFO: loaded from: classes4.dex */
public class FeedAdView extends RelativeLayout implements AdItem {
    public r a;

    public FeedAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = b.a(this).a(context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AdView, 0, 0).getString(R.styleable.AdView_placement_id));
    }

    public FeedAdView(Context context, String str) {
        super(context);
        this.a = b.a(this).a(str);
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
            rVar.c(getContext());
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

    @Override // com.tnkfactory.ad.AdItem
    public void show() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
    }
}

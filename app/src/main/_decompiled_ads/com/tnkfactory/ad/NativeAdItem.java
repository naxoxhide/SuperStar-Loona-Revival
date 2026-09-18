package com.tnkfactory.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tnkfactory.ad.pub.a.b;
import com.tnkfactory.ad.pub.a.r;

/* JADX INFO: loaded from: classes4.dex */
public class NativeAdItem implements AdItem {
    public r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2860b;

    public NativeAdItem(Context context, String str) {
        this.f2860b = context;
        this.a = b.a(this).a(str);
    }

    public NativeAdItem(Context context, String str, AdListener adListener) {
        this(context, str);
        setListener(adListener);
    }

    public void attach(ViewGroup viewGroup, NativeViewBinder nativeViewBinder) {
        this.a.a(viewGroup, nativeViewBinder);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
    }

    public String getAdDesc() {
        return this.a.e.t;
    }

    public Bitmap getAdIconBitmap() {
        return this.a.e.a();
    }

    public Bitmap getAdMarkBitmap() {
        return this.a.e.b();
    }

    public float getAdRating() {
        return this.a.e.v;
    }

    public String getAdTitle() {
        return this.a.e.s;
    }

    public View getImageView(Context context) {
        return this.a.b(context);
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
            rVar.c(this.f2860b);
        }
    }

    public void sendImpression(Context context) {
        this.a.d(context);
    }

    public void setAdEventView(ViewGroup viewGroup) {
        this.a.a(viewGroup);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setListener(AdListener adListener) {
        r rVar = this.a;
        if (rVar != null) {
            rVar.f2886b = adListener;
        }
    }

    public void setPolicyEventView(View view) {
        this.a.a(view);
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

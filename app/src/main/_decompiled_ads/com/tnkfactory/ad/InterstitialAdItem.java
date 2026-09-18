package com.tnkfactory.ad;

import android.content.Context;
import com.tnkfactory.ad.pub.a.b;
import com.tnkfactory.ad.pub.a.r;

/* JADX INFO: loaded from: classes4.dex */
public class InterstitialAdItem implements AdItem {
    public r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2859b;

    public InterstitialAdItem(Context context, String str) {
        this.f2859b = context;
        this.a = b.a(this).a(str);
    }

    public InterstitialAdItem(Context context, String str, AdListener adListener) {
        this(context, str);
        setListener(adListener);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
        this.a.a();
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
            rVar.c(this.f2859b);
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
        r rVar = this.a;
        if (rVar != null) {
            rVar.e(this.f2859b);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
        r rVar = this.a;
        if (rVar != null) {
            rVar.e(context);
        }
    }
}

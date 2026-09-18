package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.f;
import b.b.a.a.d.d.h.g;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements d, e, com.bytedance.sdk.component.adexpress.dynamic.animation.view.b {
    private static final View.OnTouchListener u = new a();
    private static final View.OnClickListener v = new b();
    protected float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f266b;
    protected float c;
    protected float d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected Context i;
    protected g j;
    protected h k;
    protected DynamicRootView l;
    protected View m;
    protected boolean n;
    protected b.b.a.a.d.d.f.a.b o;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.a p;
    private float q;
    private float r;
    private float s;
    private float t;

    static class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    static class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context);
        this.i = context;
        this.l = dynamicRootView;
        this.k = hVar;
        this.a = hVar.r();
        this.f266b = hVar.s();
        this.c = hVar.q();
        this.d = hVar.f();
        this.g = (int) b.b.a.a.d.g.d.a(this.i, this.a);
        this.h = (int) b.b.a.a.d.g.d.a(this.i, this.f266b);
        this.e = (int) b.b.a.a.d.g.d.a(this.i, this.c);
        this.f = (int) b.b.a.a.d.g.d.a(this.i, this.d);
        g gVar = new g(hVar.n());
        this.j = gVar;
        if (gVar.k() > 0) {
            this.e += this.j.k() * 2;
            this.f += this.j.k() * 2;
            this.g -= this.j.k();
            this.h -= this.j.k();
            List<h> listE = hVar.e();
            if (listE != null) {
                for (h hVar2 : listE) {
                    hVar2.f(hVar2.r() + b.b.a.a.d.g.d.c(this.i, this.j.k()));
                    hVar2.g(hVar2.s() + b.b.a.a.d.g.d.c(this.i, this.j.k()));
                    hVar2.c(b.b.a.a.d.g.d.c(this.i, this.j.k()));
                    hVar2.d(b.b.a.a.d.g.d.c(this.i, this.j.k()));
                }
            }
        }
        this.n = this.j.T() > 0.0d;
        this.p = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.a();
    }

    public void a(int i) {
        g gVar = this.j;
        if (gVar != null && gVar.a(i)) {
            c();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).a(i);
                }
            }
        }
    }

    protected void b(View view) {
        f fVarG;
        h hVar = this.k;
        if (hVar == null || (fVarG = hVar.n().g()) == null) {
            return;
        }
        view.setTag(t.g(getContext(), "tt_id_open_landing_page"), Boolean.valueOf(fVarG.y0()));
    }

    protected boolean d() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.m;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (i()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = u;
            onClickListener = v;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
        }
        a(view2);
        b(view2);
        return true;
    }

    protected boolean e() {
        h hVar = this.k;
        return hVar == null || hVar.n() == null || this.k.n().g() == null || this.k.n().g().y() == null;
    }

    public void f() {
        if (e()) {
            return;
        }
        View view = this.m;
        if (view == null) {
            view = this;
        }
        b.b.a.a.d.d.f.a.b bVar = new b.b.a.a.d.d.f.a.b(view, this.k.n().g().y());
        this.o = bVar;
        bVar.a();
    }

    public boolean g() {
        c();
        h();
        d();
        return true;
    }

    protected Drawable getBackgroundDrawable() {
        return a(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.n;
    }

    public int getClickArea() {
        return this.j.p();
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public b.b.a.a.d.d.j.a getDynamicClickListener() {
        return this.l.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.f;
    }

    public f getDynamicLayoutBrickValue() {
        b.b.a.a.d.d.h.e eVarN;
        h hVar = this.k;
        if (hVar == null || (eVarN = hVar.n()) == null) {
            return null;
        }
        return eVarN.g();
    }

    public int getDynamicWidth() {
        return this.e;
    }

    public String getImageObjectFit() {
        return this.j.u();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getMarqueeValue() {
        return this.s;
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(a(a(this.j.e().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getRippleValue() {
        return this.q;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getShineValue() {
        return this.r;
    }

    public float getStretchValue() {
        return this.t;
    }

    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
        layoutParams.topMargin = this.h;
        int i = this.g;
        layoutParams.leftMargin = i;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(i);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    public boolean i() {
        g gVar = this.j;
        return (gVar == null || gVar.p() == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.p.a(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.a aVar = this.p;
        View view = this.m;
        if (view == null) {
            view = this;
        }
        aVar.a(view, i, i2);
    }

    public void setMarqueeValue(float f) {
        this.s = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.q = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.r = f;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z) {
        this.n = z;
    }

    public void setStretchValue(float f) {
        this.t = f;
        this.p.a(this, f);
    }

    protected GradientDrawable.Orientation b(String str) {
        try {
            int i = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    protected void a(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.k.q());
            jSONObject.put("height", this.k.f());
            if (b.b.a.a.d.c.c()) {
                view.setTag(b.b.a.a.d.d.a.t, this.j.q());
                view.setTag(b.b.a.a.d.d.a.u, this.k.n().f());
                view.setTag(b.b.a.a.d.d.a.v, this.k.g());
                view.setTag(b.b.a.a.d.d.a.w, jSONObject.toString());
            } else {
                view.setTag(t.g(getContext(), "tt_id_click_tag"), this.j.q());
                view.setTag(t.g(getContext(), "tt_id_click_area_type"), this.k.n().f());
                view.setTag(t.g(getContext(), "tt_id_click_area_id"), this.k.g());
                view.setTag(t.g(getContext(), "tt_id_area_rect_info"), jSONObject.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void b() {
        b.b.a.a.d.d.f.a.b bVar = this.o;
        if (bVar != null) {
            bVar.b();
        }
    }

    protected Drawable a(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iA;
        if (!TextUtils.isEmpty(this.j.e())) {
            try {
                String strE = this.j.e();
                String strSubstring = strE.substring(strE.indexOf("(") + 1, strE.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{g.b(strArrSplit[1]), g.b(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{g.b(strArrSplit[1].substring(0, 7)), g.b(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[iArr.length - 1];
                        iArr[iArr.length - 1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableA = a(b(strArrSplit[0]), iArr);
                gradientDrawableA.setShape(0);
                gradientDrawableA.setCornerRadius(b.b.a.a.d.g.d.a(this.i, this.j.j()));
                return gradientDrawableA;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fA = b.b.a.a.d.g.d.a(this.i, this.j.j());
        drawable.setCornerRadius(fA);
        if (fA < 1.0f) {
            float fA2 = b.b.a.a.d.g.d.a(this.i, this.j.m());
            float fA3 = b.b.a.a.d.g.d.a(this.i, this.j.n());
            float fA4 = b.b.a.a.d.g.d.a(this.i, this.j.g());
            float fA5 = b.b.a.a.d.g.d.a(this.i, this.j.h());
            float[] fArr = new float[8];
            if (fA2 > 0.0f) {
                fArr[0] = fA2;
                fArr[1] = fA2;
            }
            if (fA3 > 0.0f) {
                fArr[2] = fA3;
                fArr[3] = fA3;
            }
            if (fA4 > 0.0f) {
                fArr[4] = fA4;
                fArr[5] = fA4;
            }
            if (fA5 > 0.0f) {
                fArr[6] = fA5;
                fArr[7] = fA5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iA = Color.parseColor(str);
        } else {
            iA = this.j.a();
        }
        drawable.setColor(iA);
        if (this.j.l() > 0.0f) {
            drawable.setStroke((int) b.b.a.a.d.g.d.a(this.i, this.j.l()), this.j.i());
            return drawable;
        }
        if (this.j.k() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.j.k(), this.j.i());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.k.n().f(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new c((int) fA, this.j.k());
    }

    protected com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b a(Bitmap bitmap) {
        return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a(bitmap, null);
    }

    private Drawable[] a(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = g.b(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawableA = a(b(strArrSplit[0]), iArr);
                gradientDrawableA.setShape(0);
                gradientDrawableA.setCornerRadius(b.b.a.a.d.g.d.a(this.i, this.j.j()));
                drawableArr[(list.size() - 1) - i] = gradientDrawableA;
            }
        }
        return drawableArr;
    }

    private List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && (i = i - 1) == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    protected GradientDrawable a(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iArr[0]);
                return gradientDrawable;
            }
            return new GradientDrawable(orientation, iArr);
        }
        return new GradientDrawable();
    }
}

package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.b.a.a.h.h;
import b.b.a.a.h.j;
import b.b.a.a.h.k;
import b.b.a.a.h.o;
import b.b.a.a.h.u;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.utils.t;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {
    private String z;

    class a implements o<Bitmap> {
        a() {
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
        }

        @Override // b.b.a.a.h.o
        public void a(k<Bitmap> kVar) {
            Bitmap bitmapC = kVar.c();
            if (bitmapC == null || kVar.e() == null) {
                return;
            }
            DynamicImageView.this.m.setBackground(new BitmapDrawable(DynamicImageView.this.getResources(), bitmapC));
        }
    }

    class b implements h {
        b() {
        }

        @Override // b.b.a.a.h.h
        public Bitmap a(Bitmap bitmap) {
            return b.b.a.a.d.g.a.a(DynamicImageView.this.i, bitmap, 25);
        }
    }

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, b.b.a.a.d.d.h.h hVar) {
        super(context, dynamicRootView, hVar);
        if (this.j.j() > 0.0f) {
            TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
            this.m = tTRoundRectImageView;
            tTRoundRectImageView.setXRound((int) b.b.a.a.d.g.d.a(context, this.j.j()));
            ((TTRoundRectImageView) this.m).setYRound((int) b.b.a.a.d.g.d.a(context, this.j.j()));
        } else if (e() || !"arrowButton".equals(hVar.n().f())) {
            this.m = new ImageView(context);
        } else {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.j);
            this.m = animationImageView;
        }
        this.z = getImageKey();
        this.m.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(hVar.n().f())) {
            if (this.j.L() > 0 || this.j.I() > 0) {
                int iMin = Math.min(this.e, this.f);
                this.e = iMin;
                this.f = Math.min(iMin, this.f);
                this.g = (int) (this.g + b.b.a.a.d.g.d.a(context, this.j.L() + (this.j.I() / 2) + 0.5f));
            } else {
                int iMax = Math.max(this.e, this.f);
                this.e = iMax;
                this.f = Math.max(iMax, this.f);
            }
            this.j.a(this.e / 2);
        }
        addView(this.m, new FrameLayout.LayoutParams(this.e, this.f));
    }

    private String getImageKey() {
        Map<String, String> mapK = this.l.getRenderRequest().k();
        if (mapK == null || mapK.size() <= 0) {
            return null;
        }
        return mapK.get(this.j.v());
    }

    private boolean k() {
        String strR = this.j.r();
        if (this.j.c()) {
            return true;
        }
        if (TextUtils.isEmpty(strR)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strR);
            return Math.abs((((float) this.e) / (((float) this.f) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if ("arrowButton".equals(this.k.n().f())) {
            ((ImageView) this.m).setImageResource(t.e(this.i, "tt_white_righterbackicon_titlebar"));
            if (Build.VERSION.SDK_INT >= 19 && ((ImageView) this.m).getDrawable() != null) {
                ((ImageView) this.m).getDrawable().setAutoMirrored(true);
            }
            this.m.setPadding(0, 0, 0, 0);
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.m.setBackgroundColor(this.j.a());
        String strA = this.k.n().a();
        if ("user".equals(strA)) {
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.m).setColorFilter(this.j.S());
            ((ImageView) this.m).setImageDrawable(t.f(getContext(), "tt_user"));
            ImageView imageView = (ImageView) this.m;
            int i = this.e / 10;
            imageView.setPadding(i, this.f / 5, i, 0);
        } else if (strA != null && strA.startsWith("@")) {
            try {
                ((ImageView) this.m).setImageResource(Integer.parseInt(strA.substring(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        j jVarA = b.b.a.a.d.e.a.a.d().c().a(this.j.v()).a(this.z);
        String strJ = this.l.getRenderRequest().j();
        if (!TextUtils.isEmpty(strJ)) {
            jVarA.b(strJ);
        }
        if (!b.b.a.a.d.c.c()) {
            jVarA.a((ImageView) this.m);
        }
        if (!k() || Build.VERSION.SDK_INT < 17) {
            if (b.b.a.a.d.c.c()) {
                jVarA.a((ImageView) this.m);
            }
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.FIT_CENTER);
            b.b.a.a.d.e.a.a.d().c().a(this.j.v()).a(u.BITMAP).a(new b()).a(new a());
        }
        if ((this.m instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return true;
    }
}

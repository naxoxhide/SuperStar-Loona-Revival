package com.bytedance.sdk.openadsdk.component.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: TTAppOpenAdUserInfoLayoutHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static boolean d;
    private static Drawable e;
    private LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTRoundRectImageView f552b;
    private TextView c;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.component.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTAppOpenAdUserInfoLayoutHelper.java */
    class ViewOnClickListenerC0190a implements View.OnClickListener {
        ViewOnClickListenerC0190a(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public static Drawable c() {
        return e;
    }

    public void a(PAGAppOpenBaseLayout pAGAppOpenBaseLayout, q qVar, float f, float f2, boolean z) {
        if (pAGAppOpenBaseLayout != null) {
            this.a = pAGAppOpenBaseLayout.getUserInfo();
            this.f552b = pAGAppOpenBaseLayout.getAppIcon();
            this.c = pAGAppOpenBaseLayout.getAppName();
            this.a.setOnClickListener(new ViewOnClickListenerC0190a(this));
        }
        a(qVar, f, f2, z);
    }

    public void b() {
        if (d) {
            return;
        }
        try {
            int iC = h.a().c();
            if (iC != 0) {
                e = o.a().getResources().getDrawable(iC);
            }
        } catch (Throwable unused) {
        }
        d = true;
    }

    public void a() {
        String strK = h.a().k();
        if (TextUtils.isEmpty(strK)) {
            this.c.setVisibility(8);
        } else {
            this.c.setText(strK);
        }
        b();
        try {
            Drawable drawable = e;
            if (drawable == null) {
                this.f552b.setVisibility(8);
            } else {
                this.f552b.setImageDrawable(drawable);
                if (this.c.getVisibility() == 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f552b.getLayoutParams();
                    marginLayoutParams.setMargins(0, 0, 0, 0);
                    this.f552b.setLayoutParams(marginLayoutParams);
                }
            }
        } catch (Throwable unused) {
            this.f552b.setVisibility(8);
        }
    }

    private void a(q qVar, float f, float f2, boolean z) {
        int iE;
        int iB;
        int iM = qVar.m();
        if (iM == 1 || iM == 3) {
            if (z) {
                iE = qVar.N0().c();
                iB = qVar.N0().a();
            } else {
                iE = qVar.d0().get(0).e();
                iB = qVar.d0().get(0).b();
            }
            if (iE <= 0 || iB <= 0) {
                return;
            }
            float f3 = iB;
            float fMin = f2 - (f3 * Math.min(f / iE, f2 / f3));
            try {
                float fA = b0.a(o.a(), 60.0f);
                if (fMin < fA) {
                    fMin = fA;
                }
                this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) fMin));
            } catch (Throwable unused) {
            }
        }
    }
}

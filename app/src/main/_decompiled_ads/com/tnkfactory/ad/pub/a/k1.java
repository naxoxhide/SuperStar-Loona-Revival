package com.tnkfactory.ad.pub.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class k1 extends FrameLayout {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2874b;

    public class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    public k1(Context context) {
        super(context);
        this.a = 0;
        this.f2874b = i.d(context);
    }

    public final void a() {
        try {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                windowManager.removeView(this);
            }
        } catch (Exception e) {
            Logger.e(com.tnkfactory.ad.pub.a.a.a("error #2014 : ").append(e.toString()).toString());
        }
    }

    public final boolean a(boolean z) {
        WindowManager windowManager;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1);
        layoutParams.type = 2;
        layoutParams.format = -3;
        if (z) {
            layoutParams.flags = 66816;
        } else {
            layoutParams.flags = 65792;
            Resources resources = getContext().getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                this.a = resources.getDimensionPixelSize(identifier);
            }
        }
        setFitsSystemWindows(true);
        setBackgroundColor(-1610612736);
        setOnClickListener(new a());
        if ((getContext() instanceof Activity) && !((Activity) getContext()).isFinishing() && (windowManager = (WindowManager) getContext().getSystemService("window")) != null) {
            try {
                windowManager.addView(this, layoutParams);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int[] getViewSize() {
        int width;
        int height;
        if (this.f2874b) {
            int width2 = getWidth();
            int height2 = getHeight() - this.a;
            if (width2 < height2) {
                width = Math.min(height2 / 2, width2);
                height = (int) (((double) width) * 1.9d);
            } else {
                height = Math.min(width2 / 2, height2);
                width = (int) (((double) height) * 1.9d);
            }
        } else {
            width = getWidth();
            height = getHeight() - this.a;
        }
        return new int[]{width, height};
    }
}

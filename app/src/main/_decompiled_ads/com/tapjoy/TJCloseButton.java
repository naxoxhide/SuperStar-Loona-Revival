package com.tapjoy;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.tapjoy.internal.k8;

/* JADX INFO: loaded from: classes4.dex */
public class TJCloseButton extends ImageButton {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2685b;

    public enum ClosePosition {
        TOP_LEFT(new int[]{10, 9}),
        TOP_CENTER(new int[]{10, 14}),
        TOP_RIGHT(new int[]{10, 11}),
        CENTER(new int[]{13}),
        BOTTOM_LEFT(new int[]{12, 9}),
        BOTTOM_CENTER(new int[]{12, 14}),
        BOTTOM_RIGHT(new int[]{12, 11});

        public final RelativeLayout.LayoutParams a = new RelativeLayout.LayoutParams((int) (((double) TapjoyConnectCore.getDeviceScreenDensityScale()) * 75.0d), (int) (((double) TapjoyConnectCore.getDeviceScreenDensityScale()) * 75.0d));

        ClosePosition(int[] iArr) {
            for (int i : iArr) {
                this.a.addRule(i);
            }
            int deviceScreenDensityScale = (int) (TapjoyConnectCore.getDeviceScreenDensityScale() * (-10.0f));
            this.a.setMargins(0, deviceScreenDensityScale, deviceScreenDensityScale, 0);
        }

        public final RelativeLayout.LayoutParams a() {
            return this.a;
        }
    }

    public TJCloseButton(Context context) {
        this(context, ClosePosition.TOP_RIGHT);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        setAlpha(0.0f);
        setVisibility(0);
        this.f2685b = true;
        setClickable(false);
        new Handler().postDelayed(new k8(this), 2000L);
    }

    public void setClickableRequested(boolean z) {
        this.a = z;
        if (this.f2685b) {
            return;
        }
        setClickable(z);
    }

    public TJCloseButton(Context context, ClosePosition closePosition) {
        super(context);
        this.a = true;
        setImageBitmap(TapjoyIcons.getCloseCircularImage(new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale()));
        setScaleType(ImageView.ScaleType.FIT_XY);
        setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        setLayoutParams(closePosition.a());
    }
}

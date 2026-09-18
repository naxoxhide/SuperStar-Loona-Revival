package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class ac {
    private final View aFH;
    private final x logger;
    private final n sdk;

    public ac(View view, n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.aFH = view;
    }

    public long a(com.applovin.impl.mediation.b.e eVar) {
        if (x.Fk()) {
            this.logger.f("ViewabilityTracker", "Checking visibility...");
        }
        long j = 0;
        Point pointW = com.applovin.impl.sdk.utils.h.W(this.aFH.getContext());
        if (!this.aFH.isShown()) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "View is hidden");
            }
            j = 2;
        }
        if (this.aFH.getAlpha() < eVar.yr()) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "View is transparent");
            }
            j |= 4;
        }
        Animation animation = this.aFH.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "View is animating");
            }
            j |= 8;
        }
        if (this.aFH.getParent() == null) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "No parent view found");
            }
            j |= 16;
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.aFH.getContext(), this.aFH.getWidth());
        if (iPxToDp < Math.min(eVar.yp(), pointW.x)) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "View has width (" + iPxToDp + ") below threshold");
            }
            j |= 32;
        }
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.aFH.getContext(), this.aFH.getHeight());
        if (iPxToDp2 < eVar.yq()) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "View has height (" + iPxToDp2 + ") below threshold");
            }
            j |= 64;
        }
        Rect rect = new Rect(0, 0, pointW.x, pointW.y);
        int[] iArr = {-1, -1};
        this.aFH.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], iArr[0] + this.aFH.getWidth(), iArr[1] + this.aFH.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            }
            j |= 128;
        }
        Activity activityAx = this.sdk.BK().Ax();
        if (activityAx != null && !com.applovin.impl.sdk.utils.u.a(this.aFH, activityAx)) {
            if (x.Fk()) {
                this.logger.i("ViewabilityTracker", "View is not in top activity's view hierarchy");
            }
            j |= 256;
        }
        if (x.Fk()) {
            this.logger.f("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j));
        }
        return j;
    }
}

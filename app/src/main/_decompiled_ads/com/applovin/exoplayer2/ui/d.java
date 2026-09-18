package com.applovin.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.applovin.exoplayer2.l.ai;
import com.applovin.sdk.R;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class d extends View implements k {
    private int NK;
    private long WA;
    private int WB;
    private Rect WC;
    private ValueAnimator WD;
    private float WE;
    private boolean WF;
    private boolean WG;
    private long WH;
    private long WI;
    private long[] WJ;
    private boolean[] WK;
    private final Rect Wa;
    private final Rect Wb;
    private final Rect Wc;
    private final Rect Wd;
    private final Paint We;
    private final Paint Wf;
    private final Paint Wg;
    private final Paint Wh;
    private final Paint Wi;
    private final Paint Wj;
    private final Drawable Wk;
    private final int Wl;
    private final int Wm;
    private final int Wn;
    private final int Wo;
    private final int Wp;
    private final int Wq;
    private final int Wr;
    private final int Ws;
    private final int Wt;
    private final StringBuilder Wu;
    private final Formatter Wv;
    private final Runnable Ww;
    private final Point Wx;
    private final float Wy;
    private int Wz;
    private final CopyOnWriteArraySet<k.a> hv;
    private long uc;
    private long zE;

    private static int e(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    private static int f(float f, int i) {
        return (int) (i / f);
    }

    public d(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        this.Wa = new Rect();
        this.Wb = new Rect();
        this.Wc = new Rect();
        this.Wd = new Rect();
        Paint paint = new Paint();
        this.We = paint;
        Paint paint2 = new Paint();
        this.Wf = paint2;
        Paint paint3 = new Paint();
        this.Wg = paint3;
        Paint paint4 = new Paint();
        this.Wh = paint4;
        Paint paint5 = new Paint();
        this.Wi = paint5;
        Paint paint6 = new Paint();
        this.Wj = paint6;
        paint6.setAntiAlias(true);
        this.hv = new CopyOnWriteArraySet<>();
        this.Wx = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.Wy = f;
        this.Wt = e(f, -50);
        int iE = e(f, 4);
        int iE2 = e(f, 26);
        int iE3 = e(f, 4);
        int iE4 = e(f, 12);
        int iE5 = e(f, 0);
        int iE6 = e(f, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinDefaultTimeBar, i, i2);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.AppLovinDefaultTimeBar_al_scrubber_drawable);
                this.Wk = drawable;
                if (drawable != null) {
                    a(drawable);
                    iE2 = Math.max(drawable.getMinimumHeight(), iE2);
                }
                this.Wl = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_bar_height, iE);
                this.Wm = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_touch_target_height, iE2);
                this.Wn = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_bar_gravity, 0);
                this.Wo = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_width, iE3);
                this.Wp = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_enabled_size, iE4);
                this.Wq = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_disabled_size, iE5);
                this.Wr = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_dragged_size, iE6);
                int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_color, -1);
                int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_scrubber_color, -1);
                int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_buffered_color, -855638017);
                int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_unplayed_color, 872415231);
                int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_color, -1291845888);
                int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_ad_marker_color, 872414976);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.Wl = iE;
            this.Wm = iE2;
            this.Wn = 0;
            this.Wo = iE3;
            this.Wp = iE4;
            this.Wq = iE5;
            this.Wr = iE6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.Wk = null;
        }
        StringBuilder sb = new StringBuilder();
        this.Wu = sb;
        this.Wv = new Formatter(sb, Locale.getDefault());
        this.Ww = new Runnable() { // from class: com.applovin.exoplayer2.ui.-$$Lambda$d$RK6WagiNvw-tSnTr3ayUu-jSVqI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.ln();
            }
        };
        Drawable drawable2 = this.Wk;
        if (drawable2 != null) {
            this.Ws = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.Ws = (Math.max(this.Wq, Math.max(this.Wp, this.Wr)) + 1) / 2;
        }
        this.WE = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.WD = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.applovin.exoplayer2.ui.-$$Lambda$d$XHeA0Qmw-ylf3fEvr5Y9E69Wg9g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.a(valueAnimator2);
            }
        });
        this.zE = -9223372036854775807L;
        this.WA = -9223372036854775807L;
        this.Wz = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ln() {
        an(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.WE = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.Wa);
    }

    public void setPlayedColor(int i) {
        this.We.setColor(i);
        invalidate(this.Wa);
    }

    public void setScrubberColor(int i) {
        this.Wj.setColor(i);
        invalidate(this.Wa);
    }

    public void setBufferedColor(int i) {
        this.Wf.setColor(i);
        invalidate(this.Wa);
    }

    public void setUnplayedColor(int i) {
        this.Wg.setColor(i);
        invalidate(this.Wa);
    }

    public void setAdMarkerColor(int i) {
        this.Wh.setColor(i);
        invalidate(this.Wa);
    }

    public void setPlayedAdMarkerColor(int i) {
        this.Wi.setColor(i);
        invalidate(this.Wa);
    }

    @Override // com.applovin.exoplayer2.ui.k
    public void a(k.a aVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(aVar);
        this.hv.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.applovin.exoplayer2.l.a.checkArgument(j > 0);
        this.Wz = -1;
        this.WA = j;
    }

    public void setKeyCountIncrement(int i) {
        com.applovin.exoplayer2.l.a.checkArgument(i > 0);
        this.Wz = i;
        this.WA = -9223372036854775807L;
    }

    @Override // com.applovin.exoplayer2.ui.k
    public void setPosition(long j) {
        if (this.uc == j) {
            return;
        }
        this.uc = j;
        setContentDescription(getProgressText());
        nr();
    }

    @Override // com.applovin.exoplayer2.ui.k
    public void setBufferedPosition(long j) {
        if (this.WI == j) {
            return;
        }
        this.WI = j;
        nr();
    }

    @Override // com.applovin.exoplayer2.ui.k
    public void setDuration(long j) {
        if (this.zE == j) {
            return;
        }
        this.zE = j;
        if (this.WG && j == -9223372036854775807L) {
            an(true);
        }
        nr();
    }

    @Override // com.applovin.exoplayer2.ui.k
    public long getPreferredUpdateDelay() {
        int iF = f(this.Wy, this.Wb.width());
        if (iF != 0) {
            long j = this.zE;
            if (j != 0 && j != -9223372036854775807L) {
                return j / ((long) iF);
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // com.applovin.exoplayer2.ui.k
    public void a(long[] jArr, boolean[] zArr, int i) {
        com.applovin.exoplayer2.l.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.NK = i;
        this.WJ = jArr;
        this.WK = zArr;
        nr();
    }

    @Override // android.view.View, com.applovin.exoplayer2.ui.k
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.WG || z) {
            return;
        }
        an(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.zE > 0) {
            Point pointA = a(motionEvent);
            int i = pointA.x;
            int i2 = pointA.y;
            int action = motionEvent.getAction();
            if (action == 0) {
                float f = i;
                if (b(f, i2)) {
                    w(f);
                    bi(getScrubberPosition());
                    nr();
                    invalidate();
                    return true;
                }
            } else if (action == 1) {
                if (this.WG) {
                    an(motionEvent.getAction() == 3);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.WG) {
                        an(motionEvent.getAction() == 3);
                        return true;
                    }
                }
            } else if (this.WG) {
                if (i2 < this.Wt) {
                    int i3 = this.WB;
                    w(i3 + ((i - i3) / 3));
                } else {
                    this.WB = i;
                    w(i);
                }
                bj(getScrubberPosition());
                nr();
                invalidate();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (bk(positionIncrement)) {
                            removeCallbacks(this.Ww);
                            postDelayed(this.Ww, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (bk(positionIncrement)) {
                            removeCallbacks(this.Ww);
                            postDelayed(this.Ww, 1000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (this.WG) {
                            an(false);
                            return true;
                        }
                        break;
                }
            } else if (this.WG) {
                an(false);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!this.WG || z) {
            return;
        }
        an(false);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ns();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.Wk;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.Wm;
        } else if (mode != 1073741824) {
            size = Math.min(this.Wm, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        ns();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingBottom;
        int iMax;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i5 - getPaddingRight();
        int i7 = this.WF ? 0 : this.Ws;
        if (this.Wn == 1) {
            paddingBottom = (i6 - getPaddingBottom()) - this.Wm;
            int paddingBottom2 = i6 - getPaddingBottom();
            int i8 = this.Wl;
            iMax = (paddingBottom2 - i8) - Math.max(i7 - (i8 / 2), 0);
        } else {
            paddingBottom = (i6 - this.Wm) / 2;
            iMax = (i6 - this.Wl) / 2;
        }
        this.Wa.set(paddingLeft, paddingBottom, paddingRight, this.Wm + paddingBottom);
        this.Wb.set(this.Wa.left + i7, iMax, this.Wa.right - i7, this.Wl + iMax);
        if (ai.acV >= 29) {
            H(i5, i6);
        }
        nr();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.Wk;
        if (drawable == null || !a(drawable, i)) {
            return;
        }
        invalidate();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.zE <= 0) {
            return;
        }
        if (ai.acV >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.zE <= 0) {
            return false;
        }
        if (i == 8192) {
            if (bk(-getPositionIncrement())) {
                an(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (bk(getPositionIncrement())) {
                an(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    private void bi(long j) {
        this.WH = j;
        this.WG = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<k.a> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().a(this, j);
        }
    }

    private void bj(long j) {
        if (this.WH == j) {
            return;
        }
        this.WH = j;
        Iterator<k.a> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().b(this, j);
        }
    }

    private void an(boolean z) {
        removeCallbacks(this.Ww);
        this.WG = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<k.a> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.WH, z);
        }
    }

    private boolean bk(long j) {
        long j2 = this.zE;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.WG ? this.WH : this.uc;
        long jB = ai.b(j3 + j, 0L, j2);
        if (jB == j3) {
            return false;
        }
        if (!this.WG) {
            bi(jB);
        } else {
            bj(jB);
        }
        nr();
        return true;
    }

    private void nr() {
        this.Wc.set(this.Wb);
        this.Wd.set(this.Wb);
        long j = this.WG ? this.WH : this.uc;
        if (this.zE > 0) {
            this.Wc.right = Math.min(this.Wb.left + ((int) ((((long) this.Wb.width()) * this.WI) / this.zE)), this.Wb.right);
            this.Wd.right = Math.min(this.Wb.left + ((int) ((((long) this.Wb.width()) * j) / this.zE)), this.Wb.right);
        } else {
            this.Wc.right = this.Wb.left;
            this.Wd.right = this.Wb.left;
        }
        invalidate(this.Wa);
    }

    private void w(float f) {
        this.Wd.right = ai.k((int) f, this.Wb.left, this.Wb.right);
    }

    private Point a(MotionEvent motionEvent) {
        this.Wx.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.Wx;
    }

    private long getScrubberPosition() {
        if (this.Wb.width() <= 0 || this.zE == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.Wd.width()) * this.zE) / ((long) this.Wb.width());
    }

    private boolean b(float f, float f2) {
        return this.Wa.contains((int) f, (int) f2);
    }

    private void a(Canvas canvas) {
        int iHeight = this.Wb.height();
        int iCenterY = this.Wb.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.zE <= 0) {
            canvas.drawRect(this.Wb.left, iCenterY, this.Wb.right, i, this.Wg);
            return;
        }
        int i2 = this.Wc.left;
        int i3 = this.Wc.right;
        int iMax = Math.max(Math.max(this.Wb.left, i3), this.Wd.right);
        if (iMax < this.Wb.right) {
            canvas.drawRect(iMax, iCenterY, this.Wb.right, i, this.Wg);
        }
        int iMax2 = Math.max(i2, this.Wd.right);
        if (i3 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i3, i, this.Wf);
        }
        if (this.Wd.width() > 0) {
            canvas.drawRect(this.Wd.left, iCenterY, this.Wd.right, i, this.We);
        }
        if (this.NK == 0) {
            return;
        }
        long[] jArr = (long[]) com.applovin.exoplayer2.l.a.checkNotNull(this.WJ);
        boolean[] zArr = (boolean[]) com.applovin.exoplayer2.l.a.checkNotNull(this.WK);
        int i4 = this.Wo / 2;
        for (int i5 = 0; i5 < this.NK; i5++) {
            int iMin = this.Wb.left + Math.min(this.Wb.width() - this.Wo, Math.max(0, ((int) ((((long) this.Wb.width()) * ai.b(jArr[i5], 0L, this.zE)) / this.zE)) - i4));
            canvas.drawRect(iMin, iCenterY, iMin + this.Wo, i, zArr[i5] ? this.Wi : this.Wh);
        }
    }

    private void b(Canvas canvas) {
        int i;
        if (this.zE <= 0) {
            return;
        }
        int iK = ai.k(this.Wd.right, this.Wd.left, this.Wb.right);
        int iCenterY = this.Wd.centerY();
        Drawable drawable = this.Wk;
        if (drawable == null) {
            if (this.WG || isFocused()) {
                i = this.Wr;
            } else {
                i = isEnabled() ? this.Wp : this.Wq;
            }
            canvas.drawCircle(iK, iCenterY, (int) ((i * this.WE) / 2.0f), this.Wj);
            return;
        }
        int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.WE)) / 2;
        int intrinsicHeight = ((int) (this.Wk.getIntrinsicHeight() * this.WE)) / 2;
        this.Wk.setBounds(iK - intrinsicWidth, iCenterY - intrinsicHeight, iK + intrinsicWidth, iCenterY + intrinsicHeight);
        this.Wk.draw(canvas);
    }

    private void ns() {
        Drawable drawable = this.Wk;
        if (drawable != null && drawable.isStateful() && this.Wk.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void H(int i, int i2) {
        Rect rect = this.WC;
        if (rect != null && rect.width() == i && this.WC.height() == i2) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i, i2);
        this.WC = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private String getProgressText() {
        return ai.a(this.Wu, this.Wv, this.uc);
    }

    private long getPositionIncrement() {
        long j = this.WA;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.zE;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / ((long) this.Wz);
    }

    private boolean a(Drawable drawable) {
        return ai.acV >= 23 && a(drawable, getLayoutDirection());
    }

    private static boolean a(Drawable drawable, int i) {
        return ai.acV >= 23 && drawable.setLayoutDirection(i);
    }
}

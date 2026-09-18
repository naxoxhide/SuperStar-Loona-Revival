package com.applovin.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;

/* JADX INFO: loaded from: classes.dex */
final class i {
    private int Oi;
    private int Qa;
    private int Qc;
    private float VV;
    private int VX;
    private int VY;
    private CharSequence YA;
    private Layout.Alignment YB;
    private Bitmap YC;
    private float YD;
    private int YE;
    private int YF;
    private float YG;
    private int YH;
    private float YI;
    private float YJ;
    private float YK;
    private float YL;
    private int YM;
    private int YN;
    private int YO;
    private int YP;
    private StaticLayout YQ;
    private StaticLayout YR;
    private int YS;
    private int YT;
    private int YU;
    private Rect YV;
    private final float Ys;
    private final float Yt;
    private final float Yu;
    private final float Yv;
    private final float Yw;
    private final TextPaint Yx;
    private final Paint Yy;
    private final Paint Yz;

    public i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.Yw = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Yv = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.Ys = fRound;
        this.Yt = fRound;
        this.Yu = fRound;
        TextPaint textPaint = new TextPaint();
        this.Yx = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.Yy = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.Yz = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public void a(com.applovin.exoplayer2.i.a aVar, c cVar, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        boolean z = aVar.NZ == null;
        int i5 = -16777216;
        if (z) {
            if (TextUtils.isEmpty(aVar.NW)) {
                return;
            } else {
                i5 = aVar.Oh ? aVar.Oi : cVar.Oi;
            }
        }
        if (a(this.YA, aVar.NW) && ai.r(this.YB, aVar.NX) && this.YC == aVar.NZ && this.YD == aVar.Oa && this.YE == aVar.Ob && ai.r(Integer.valueOf(this.YF), Integer.valueOf(aVar.Oc)) && this.YG == aVar.Od && ai.r(Integer.valueOf(this.YH), Integer.valueOf(aVar.Oe)) && this.YI == aVar.Of && this.YJ == aVar.Og && this.Qa == cVar.Qa && this.Qc == cVar.Qc && this.Oi == i5 && this.VX == cVar.VX && this.VY == cVar.VY && ai.r(this.Yx.getTypeface(), cVar.VZ) && this.YK == f && this.YL == f2 && this.VV == f3 && this.YM == i && this.YN == i2 && this.YO == i3 && this.YP == i4) {
            a(canvas, z);
            return;
        }
        this.YA = aVar.NW;
        this.YB = aVar.NX;
        this.YC = aVar.NZ;
        this.YD = aVar.Oa;
        this.YE = aVar.Ob;
        this.YF = aVar.Oc;
        this.YG = aVar.Od;
        this.YH = aVar.Oe;
        this.YI = aVar.Of;
        this.YJ = aVar.Og;
        this.Qa = cVar.Qa;
        this.Qc = cVar.Qc;
        this.Oi = i5;
        this.VX = cVar.VX;
        this.VY = cVar.VY;
        this.Yx.setTypeface(cVar.VZ);
        this.YK = f;
        this.YL = f2;
        this.VV = f3;
        this.YM = i;
        this.YN = i2;
        this.YO = i3;
        this.YP = i4;
        if (z) {
            com.applovin.exoplayer2.l.a.checkNotNull(this.YA);
            nU();
        } else {
            com.applovin.exoplayer2.l.a.checkNotNull(this.YC);
            nV();
        }
        a(canvas, z);
    }

    private void nU() {
        SpannableStringBuilder spannableStringBuilder;
        int i;
        int i2;
        int iMax;
        int iMin;
        int iRound;
        int i3;
        CharSequence charSequence = this.YA;
        if (charSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) charSequence;
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.YA);
        }
        int i4 = this.YO - this.YM;
        int i5 = this.YP - this.YN;
        this.Yx.setTextSize(this.YK);
        int i6 = (int) ((this.YK * 0.125f) + 0.5f);
        int i7 = i6 * 2;
        int i8 = i4 - i7;
        float f = this.YI;
        if (f != -3.4028235E38f) {
            i8 = (int) (i8 * f);
        }
        int i9 = i8;
        if (i9 <= 0) {
            q.h("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.YL > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.YL), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.VX == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.Qc) > 0) {
            int i10 = this.VX;
            if (i10 == 0 || i10 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.Qc), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.Qc), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.YB;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.Yx, i9, alignment2, this.Yv, this.Yw, true);
        this.YQ = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.YQ.getLineCount();
        int iMax2 = 0;
        for (int i11 = 0; i11 < lineCount; i11++) {
            iMax2 = Math.max((int) Math.ceil(this.YQ.getLineWidth(i11)), iMax2);
        }
        if (this.YI == -3.4028235E38f || iMax2 >= i9) {
            i9 = iMax2;
        }
        int i12 = i9 + i7;
        float f2 = this.YG;
        if (f2 != -3.4028235E38f) {
            int iRound2 = Math.round(i4 * f2);
            int i13 = this.YM;
            int i14 = iRound2 + i13;
            int i15 = this.YH;
            i = 1;
            if (i15 != 1) {
                i2 = 2;
                if (i15 == 2) {
                    i14 -= i12;
                }
            } else {
                i2 = 2;
                i14 = ((i14 * 2) - i12) / 2;
            }
            iMax = Math.max(i14, i13);
            iMin = Math.min(i12 + iMax, this.YO);
        } else {
            i = 1;
            i2 = 2;
            iMax = ((i4 - i12) / 2) + this.YM;
            iMin = iMax + i12;
        }
        int i16 = iMin - iMax;
        if (i16 <= 0) {
            q.h("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f3 = this.YD;
        if (f3 != -3.4028235E38f) {
            if (this.YE == 0) {
                iRound = Math.round(i5 * f3) + this.YN;
                int i17 = this.YF;
                if (i17 == i2) {
                    iRound -= height;
                } else if (i17 == i) {
                    iRound = ((iRound * 2) - height) / i2;
                }
            } else {
                int lineBottom = this.YQ.getLineBottom(0) - this.YQ.getLineTop(0);
                float f4 = this.YD;
                if (f4 >= 0.0f) {
                    iRound = Math.round(f4 * lineBottom) + this.YN;
                } else {
                    iRound = Math.round((f4 + 1.0f) * lineBottom) + this.YP;
                    iRound -= height;
                }
            }
            int i18 = iRound + height;
            int i19 = this.YP;
            if (i18 <= i19) {
                int i20 = this.YN;
                if (iRound < i20) {
                    i3 = i20;
                }
                this.YQ = new StaticLayout(spannableStringBuilder, this.Yx, i16, alignment2, this.Yv, this.Yw, true);
                this.YR = new StaticLayout(spannableStringBuilder2, this.Yx, i16, alignment2, this.Yv, this.Yw, true);
                this.YS = iMax;
                this.YT = i3;
                this.YU = i6;
            }
            iRound = i19 - height;
        } else {
            iRound = (this.YP - height) - ((int) (i5 * this.VV));
        }
        i3 = iRound;
        this.YQ = new StaticLayout(spannableStringBuilder, this.Yx, i16, alignment2, this.Yv, this.Yw, true);
        this.YR = new StaticLayout(spannableStringBuilder2, this.Yx, i16, alignment2, this.Yv, this.Yw, true);
        this.YS = iMax;
        this.YT = i3;
        this.YU = i6;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0056  */
    /* JADX WARN: Code duplicated, block: B:16:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    private void nV() {
        int iRound;
        float f;
        int i;
        float f2;
        Bitmap bitmap = this.YC;
        int i2 = this.YO;
        int i3 = this.YM;
        int i4 = this.YP;
        int i5 = this.YN;
        float f3 = i2 - i3;
        float f4 = i3 + (this.YG * f3);
        float f5 = i4 - i5;
        float f6 = i5 + (this.YD * f5);
        int iRound2 = Math.round(f3 * this.YI);
        float f7 = this.YJ;
        if (f7 != -3.4028235E38f) {
            iRound = Math.round(f5 * f7);
        } else {
            iRound = Math.round(iRound2 * (bitmap.getHeight() / bitmap.getWidth()));
        }
        int i6 = this.YH;
        if (i6 != 2) {
            if (i6 == 1) {
                f = iRound2 / 2;
            }
            int iRound3 = Math.round(f4);
            i = this.YF;
            if (i == 2) {
                if (i == 1) {
                    f2 = iRound / 2;
                }
                int iRound4 = Math.round(f6);
                this.YV = new Rect(iRound3, iRound4, iRound2 + iRound3, iRound + iRound4);
            }
            f2 = iRound;
            f6 -= f2;
            int iRound5 = Math.round(f6);
            this.YV = new Rect(iRound3, iRound5, iRound2 + iRound3, iRound + iRound5);
        }
        f = iRound2;
        f4 -= f;
        int iRound6 = Math.round(f4);
        i = this.YF;
        if (i == 2) {
            if (i == 1) {
                f2 = iRound / 2;
            }
            int iRound7 = Math.round(f6);
            this.YV = new Rect(iRound6, iRound7, iRound2 + iRound6, iRound + iRound7);
        }
        f2 = iRound;
        f6 -= f2;
        int iRound8 = Math.round(f6);
        this.YV = new Rect(iRound6, iRound8, iRound2 + iRound6, iRound + iRound8);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            c(canvas);
            return;
        }
        com.applovin.exoplayer2.l.a.checkNotNull(this.YV);
        com.applovin.exoplayer2.l.a.checkNotNull(this.YC);
        d(canvas);
    }

    private void c(Canvas canvas) {
        StaticLayout staticLayout = this.YQ;
        StaticLayout staticLayout2 = this.YR;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.YS, this.YT);
        if (Color.alpha(this.Oi) > 0) {
            this.Yy.setColor(this.Oi);
            canvas.drawRect(-this.YU, 0.0f, staticLayout.getWidth() + this.YU, staticLayout.getHeight(), this.Yy);
        }
        int i = this.VX;
        if (i == 1) {
            this.Yx.setStrokeJoin(Paint.Join.ROUND);
            this.Yx.setStrokeWidth(this.Ys);
            this.Yx.setColor(this.VY);
            this.Yx.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            TextPaint textPaint = this.Yx;
            float f = this.Yt;
            float f2 = this.Yu;
            textPaint.setShadowLayer(f, f2, f2, this.VY);
        } else if (i == 3 || i == 4) {
            boolean z = i == 3;
            int i2 = z ? -1 : this.VY;
            int i3 = z ? this.VY : -1;
            float f3 = this.Yt / 2.0f;
            this.Yx.setColor(this.Qa);
            this.Yx.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.Yx.setShadowLayer(this.Yt, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.Yx.setShadowLayer(this.Yt, f3, f3, i3);
        }
        this.Yx.setColor(this.Qa);
        this.Yx.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.Yx.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    private void d(Canvas canvas) {
        canvas.drawBitmap(this.YC, (Rect) null, this.YV, this.Yz);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}

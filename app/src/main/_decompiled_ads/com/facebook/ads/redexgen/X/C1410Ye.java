package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.DefaultMediaViewVideoRenderer;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.primitives.SignedBytes;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ye, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1410Ye extends C5O implements MediaViewApi, Repairable, C7P {
    public static byte[] A0E;
    public static String[] A0F = {"5egxRyJvv3hsImr6xVPVZGZzS", "S92E58UIdGCmPOb4LYA51SRur0tU5vPU", "gB2LJBWgacco1yi3dwEv6yCRJyLib4yq", "IRYDxixZynQ1VjnPzR0JfxvjieAE", "Yx6PPUM30uHFy3rHO75LIsUaVykI", "YSQgGTlHzzB", "fqdcFq1cD4m6uZ0nLvDLKOa7nCA9CaYH", "MqJIv4BM2hfR6AMSoGkEEGT8SPZgcE8o"};
    public static final String A0G;
    public View A00;
    public View A01;
    public ImageView A02;
    public MediaView A03;
    public MediaViewListener A04;
    public MediaViewVideoRenderer A05;
    public AdComponentViewParentApi A06;
    public YA A07;
    public C05910x A08;
    public NI A09;
    public AnonymousClass95 A0A;
    public PK A0B;
    public boolean A0C;
    public boolean A0D;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 47);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0E = new byte[]{56, 26, 9, 20, 14, 8, 30, 23, 91, 9, 30, 21, 31, 30, 9, 30, 9, 91, 22, 14, 8, 15, 91, 25, 30, 91, 8, 30, 15, 91, 25, 30, 29, 20, 9, 30, 91, 21, 26, 15, 18, 13, 30, 58, 31, 85, 26, 30, 29, 41, 56, 53, 57, 50, 63, 57, 18, 57, 40, 43, 51, 46, 55, SignedBytes.MAX_POWER_OF_TWO, 100, 104, 110, 108, 41, 123, 108, 103, 109, 108, 123, 108, 123, 41, 100, 124, 122, 125, 41, 107, 108, 41, 122, 108, 125, 41, 107, 108, 111, 102, 123, 108, 41, 103, 104, 125, 96, 127, 108, 72, 109, 39, 96, 68, 72, 78, 76, 9, 91, 76, 71, 77, 76, 91, 76, 91, 9, 68, 92, 90, 93, 9, 75, 76, 9, 90, 76, 93, 9, 75, 76, 79, 70, 91, 76, 9, 71, 72, 93, SignedBytes.MAX_POWER_OF_TWO, 95, 76, 107, 72, 71, 71, 76, 91, 104, 77, 7, 18, 53, 45, 58, 55, 50, 63, 123, 13, 50, 62, 44, 123, 56, 52, 53, 40, 47, 41, 46, 56, 47, 52, 41, 123, 43, 58, 41, 58, 54, 40, 123, 47, 34, 43, 62, 117, 1, 46, 59, 38, 57, 42, 111, 14, 43, 111, 6, 44, 32, 33, 111, 38, 60, 111, 33, 58, 35, 35, 97, 11, 52, 57, 56, 50, 125, 47, 56, 51, 57, 56, 47, 56, 47, 125, 48, 40, 46, 41, 125, 63, 56, 125, 46, 56, 41, 125, 63, 56, 59, 50, 47, 56, 125, 51, 60, 41, 52, 43, 56, 28, 57, 115, 26, 11, 18, 96, 108, 110, 45, 101, 98, 96, 102, 97, 108, 108, 104, 45, 98, 103, 112, 45, 109, 98, 119, 106, 117, 102, 45, 96, 111, 106, 96, 104, 102, 103, 117, 106, 103, 102, 108, 86, 113, 111, 62};
    }

    static {
        A08();
        A0G = MediaView.class.getSimpleName();
    }

    private void A05() {
        AnonymousClass95 anonymousClass95 = this.A0A;
        if (anonymousClass95 != null) {
            anonymousClass95.setVisibility(8);
            C3H.A0A(this.A0A.getDynamicWebViewController().A0O(), new ColorDrawable(0));
            this.A03.removeView(this.A0A);
            this.A0A = null;
        }
    }

    private void A06() {
        if (!this.A0D) {
            View view = this.A01;
            String[] strArr = A0F;
            if (strArr[4].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[5] = "HiqmuX4YAHl";
            strArr2[0] = "JtgDxExoVYEb5OmxUIRsQ7gjV";
            if (view != null) {
                LV.A0J(this.A08);
            }
            float f = C1066Ku.A02;
            float density = 4.0f * f;
            int hPadding = Math.round(density);
            float density2 = 12.0f * f;
            int vPadding = Math.round(density2);
            this.A08.setChildSpacing(hPadding);
            this.A08.setPadding(0, vPadding, 0, vPadding);
            this.A08.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            C05910x c05910x = this.A08;
            this.A01 = c05910x;
            this.A03.addView(c05910x, layoutParams);
            return;
        }
        throw new IllegalStateException(A04(0, 46, 84));
    }

    private void A07() {
        EnumC1071Kz.A04(this.A03, EnumC1071Kz.A0A);
        EnumC1071Kz.A04(this.A09, EnumC1071Kz.A0A);
        EnumC1071Kz.A04(this.A05, EnumC1071Kz.A0A);
        EnumC1071Kz.A04(this.A01, EnumC1071Kz.A0A);
    }

    private final void A09(View view, ViewGroup.LayoutParams layoutParams) {
        A01(false);
        this.A03.addView(view, layoutParams);
        A01(true);
    }

    private void A0A(View view, UJ uj) {
        PK pk = this.A0B;
        if (pk != null) {
            MediaView mediaView = this.A03;
            String[] strArr = A0F;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[6] = "tYahJlzELN2bWoIKGOvNb4V2q4om3tal";
            strArr2[2] = "knO8IZUpKtredd0Q2IkvjJrJQGpJW1Qq";
            mediaView.removeView(pk);
        }
        if (!uj.A1d()) {
            return;
        }
        String strA1C = uj.A1C();
        Context context = this.A03.getContext();
        String[] strArr3 = A0F;
        String str = strArr3[5];
        String mediationData = strArr3[0];
        if (str.length() != mediationData.length()) {
            String[] strArr4 = A0F;
            strArr4[4] = "LedcnhOkj71a4gNr9a9uwwPVwkpS";
            strArr4[3] = "bOPNktfa058vxRDYU7HJ2aiUk3a2";
            if (context == null) {
                return;
            }
        } else if (context == null) {
            return;
        }
        PK pkA01 = PJ.A01(this.A07, strA1C);
        if (A0F[7].charAt(21) != 'L') {
            A0F[1] = "IBU68ioTGuVBWJ1dkmCJ7UK76Osi7EVF";
            this.A0B = pkA01;
            if (pkA01 == null) {
                return;
            }
        } else {
            this.A0B = pkA01;
            if (pkA01 == null) {
                return;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(5, view.getId());
        layoutParams.addRule(7, view.getId());
        layoutParams.addRule(6, view.getId());
        layoutParams.addRule(8, view.getId());
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.addRule(16, view.getId());
            layoutParams.addRule(17, view.getId());
        }
        A09(this.A0B, layoutParams);
        this.A06.bringChildToFront(this.A0B);
    }

    private void A0B(ImageView imageView) {
        if (!this.A0D) {
            ImageView imageView2 = this.A02;
            String[] strArr = A0F;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[6] = "9onWrVOda1qlu0pAvyXYf5LKITz29A5r";
            strArr2[2] = "G6pev0JETY7bhqmEZOziJsmCoQM1bBBX";
            if (imageView2 != null) {
                LV.A0J(imageView2);
            }
            imageView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A03.addView(imageView, layoutParams);
            imageView.setId(LV.A00());
            this.A02 = imageView;
            return;
        }
        throw new IllegalStateException(A04(106, 49, 6));
    }

    private final void A0C(YA ya, AttributeSet attributeSet, int i, int i2, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(ya, attributeSet, i, i2));
        A0H(new NI(ya, attributeSet, i, i2));
        this.A08 = new C05910x(ya, attributeSet, i);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(ya, attributeSet, i, i2));
        A07();
    }

    private final void A0D(YA ya, AttributeSet attributeSet, int i, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(ya, attributeSet, i));
        A0H(new NI(ya, attributeSet, i));
        this.A08 = new C05910x(ya, attributeSet, i);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(ya, attributeSet, i));
        A07();
    }

    private final void A0E(YA ya, AttributeSet attributeSet, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(ya, attributeSet));
        A0H(new NI(ya, attributeSet));
        this.A08 = new C05910x(ya, attributeSet);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(ya, attributeSet));
        A07();
    }

    private final void A0F(YA ya, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(ya));
        A0H(new NI(ya));
        this.A08 = new C05910x(ya);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(ya));
        A07();
    }

    private void A0G(UJ uj, boolean z, J4 j4) {
        T8 t8A04 = new T8(this.A02, this.A07).A04();
        if (z) {
            t8A04.A06(new C1417Yl(this, uj));
        }
        t8A04.A07(j4.getUrl());
    }

    private void A0H(NI ni) {
        if (!this.A0D) {
            NI ni2 = this.A09;
            if (ni2 != null) {
                this.A03.removeView(ni2);
            }
            ni.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A03.addView(ni, layoutParams);
            this.A09 = ni;
            return;
        }
        throw new IllegalStateException(A04(63, 43, 38));
    }

    private boolean A0I(NativeAd nativeAd) {
        List<NativeAd> carousel = ((C5W) nativeAd.getNativeAdApi()).A03();
        if (carousel == null) {
            return false;
        }
        Iterator<NativeAd> it = carousel.iterator();
        while (it.hasNext()) {
            if (it.next().getAdCoverImage() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0J(NativeAd nativeAd) {
        return Build.VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(((C5W) nativeAd.getNativeAdApi()).A02());
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0360 A[PHI: r1
      0x0360: PHI (r1v14 android.view.View) = (r1v11 android.view.View), (r1v17 android.view.View) binds: [B:69:0x03b3, B:65:0x035e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x03b6 A[PHI: r1
      0x03b6: PHI (r1v12 android.view.View) = (r1v11 android.view.View), (r1v17 android.view.View) binds: [B:69:0x03b3, B:65:0x035e] A[DONT_GENERATE, DONT_INLINE]] */
    public final void A0L(NativeAd nativeAd) {
        View view;
        AbstractC1485aT f8;
        YA adObjectContext = ((UJ) nativeAd.getInternalNativeAd()).A11();
        adObjectContext.A0H(this);
        this.A07.A0G(adObjectContext);
        this.A07.A0F(adObjectContext.A0E());
        this.A0D = true;
        UJ ujA0L = UJ.A0L(nativeAd.getInternalNativeAd());
        ujA0L.A1Q(this.A03);
        this.A02.setVisibility(8);
        this.A02.setImageDrawable(null);
        if (ujA0L.A0z() != null) {
            boolean zA0k = ujA0L.A0z().A0k();
            if (A0F[7].charAt(21) == 'L') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[4] = "CvXrj9TTP1W52m7bIbynzmDbx8Ql";
            strArr[3] = "OGerX4RrBYJpkLXwbXTHIjvyoHPN";
            if (zA0k) {
                if (!TextUtils.isEmpty(ujA0L.A0z().A0v().A0D().A08())) {
                    ujA0L.A11().A0E().AFV(EnumC05720d.A09);
                } else {
                    ujA0L.A11().A0E().AFV(EnumC05720d.A08);
                }
                A05();
                this.A09.setVisibility(8);
                this.A09.setImage(null, null);
                this.A05.setVisibility(8);
                this.A05.unsetNativeAd();
                ((C5V) this.A05.getMediaViewVideoRendererApi()).A03();
                View view2 = this.A01;
                if (view2 != null) {
                    view2.setVisibility(8);
                    View view3 = this.A01;
                    if (view3 instanceof N9) {
                        N9 n9 = (N9) view3;
                        if (A0F[1].charAt(24) != 't') {
                            String[] strArr2 = A0F;
                            strArr2[4] = "rVZQRbya12lyykx5Eq2uFJ3JGH4l";
                            strArr2[3] = "XRSLHysRpGcYp4QaXPRJ4K4uNDdg";
                            n9.A04();
                        } else {
                            n9.A04();
                        }
                    } else {
                        ((ED) view3).setAdapter(null);
                    }
                }
                A01(false);
                C1415Yj c1415Yj = new C1415Yj(this, ujA0L, nativeAd);
                YA ya = this.A07;
                AnonymousClass95 anonymousClass95 = new AnonymousClass95(ya, ya.A09(), c1415Yj, ujA0L.A0z(), A04(261, 31, 44), 4, ujA0L.A19());
                this.A0A = anonymousClass95;
                EnumC1071Kz.A04(anonymousClass95, EnumC1071Kz.A0A);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                this.A03.addView(this.A0A, layoutParams);
                AnonymousClass95 anonymousClass96 = this.A0A;
                this.A00 = anonymousClass96;
                bringChildToFront(anonymousClass96);
                this.A0A.setVisibility(0);
                A0A(this.A0A, ujA0L);
                A01(true);
                return;
            }
        }
        if (!A0I(nativeAd)) {
            if (A0J(nativeAd)) {
                ujA0L.A11().A0E().AFV(EnumC05720d.A0C);
                ujA0L.A1b(this.A0C);
                this.A00 = this.A05.getMediaViewVideoRendererApi().getVideoView();
                A05();
                this.A09.setVisibility(8);
                this.A09.setImage(null, null);
                View view4 = this.A01;
                if (view4 != null) {
                    view4.setVisibility(8);
                    View view5 = this.A01;
                    if (view5 instanceof N9) {
                        ((N9) view5).A04();
                    } else {
                        ((ED) view5).setAdapter(null);
                    }
                }
                bringChildToFront(this.A05);
                this.A05.setNativeAd(nativeAd);
                ((C5V) this.A05.getMediaViewVideoRendererApi()).A04(nativeAd);
                this.A05.setVisibility(0);
                if (ujA0L.getAdCoverImage() != null) {
                    new T8(this.A03, this.A07).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C1413Yh(this, ujA0L)).A07(ujA0L.getAdCoverImage().getUrl());
                }
                if (BuildConfigApi.isDebug()) {
                    Log.i(A0G, A04(ChooserType.REQUEST_CAPTURE_VIDEO, 9, 44) + ((C5W) nativeAd.getNativeAdApi()).A02());
                }
                A0A(this.A05, ujA0L);
                return;
            }
            if (nativeAd.getAdCoverImage() == null) {
                return;
            }
            ujA0L.A11().A0E().AFV(EnumC05720d.A0A);
            this.A00 = this.A09.getBodyImageView();
            A05();
            this.A05.setVisibility(8);
            this.A05.unsetNativeAd();
            ((C5V) this.A05.getMediaViewVideoRendererApi()).A03();
            View view6 = this.A01;
            if (view6 != null) {
                view6.setVisibility(8);
                String[] strArr3 = A0F;
                if (strArr3[6].charAt(12) != strArr3[2].charAt(12)) {
                    A0F[7] = "Dgm0JyWXySbfCdb16XoSe7MN32Vp1QVj";
                    view = this.A01;
                    if (view instanceof N9) {
                        ((N9) view).A04();
                    } else {
                        ((ED) view).setAdapter(null);
                    }
                } else {
                    String[] strArr4 = A0F;
                    strArr4[6] = "D0GPDFfrMR6XieFyYC2vHynCiCjpaNUA";
                    strArr4[2] = "H5HDOQyqBcm6nNekaOStoZQ6HlGjXfWv";
                    view = this.A01;
                    if (view instanceof N9) {
                        ((N9) view).A04();
                    } else {
                        ((ED) view).setAdapter(null);
                    }
                }
            }
            bringChildToFront(this.A09);
            this.A09.setVisibility(0);
            new T8(this.A09, this.A07).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C1412Yg(this, ujA0L)).A07(ujA0L.getAdCoverImage().getUrl());
            A0A(this.A09, ujA0L);
            return;
        }
        ujA0L.A11().A0E().AFV(EnumC05720d.A03);
        boolean z = ujA0L.A17() == J7.A0B;
        if (IP.A2I(this.A07) && !z) {
            A01(false);
            int width = this.A03.getWidth();
            for (ViewGroup viewGroup = (ViewGroup) this.A03.getParent(); width == 0 && viewGroup != null; viewGroup = (ViewGroup) viewGroup.getParent()) {
                width = viewGroup.getWidth();
            }
            LV.A0J(this.A01);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            N9 n10 = new N9(this.A07);
            this.A01 = n10;
            this.A03.addView(n10, layoutParams2);
            ((N9) this.A01).A05(ujA0L, width);
            LV.A0K(this.A01);
            A01(true);
        } else {
            C05910x c05910x = this.A08;
            this.A01 = c05910x;
            c05910x.setCurrentPosition(0);
            ((C05910x) this.A01).setShowTextInCarousel(z);
            if (!z) {
                f8 = new F8((C05910x) this.A01, ujA0L.A1H(), this.A07);
            } else {
                f8 = new F9(this.A07, (C05910x) this.A01, ujA0L.A1H(), ujA0L.A16());
            }
            f8.A0G(new C1414Yi(this, ujA0L));
            ((ED) this.A01).setAdapter(f8);
        }
        this.A00 = this.A01;
        A05();
        this.A09.setVisibility(8);
        this.A09.setImage(null, null);
        this.A05.setVisibility(8);
        this.A05.unsetNativeAd();
        ((C5V) this.A05.getMediaViewVideoRendererApi()).A03();
        bringChildToFront(this.A01);
        this.A01.setVisibility(0);
        A0A(this.A01, ujA0L);
    }

    public final void A0M(NativeAdBaseApi nativeAdBaseApi, boolean z) {
        YA yaA11 = ((UJ) nativeAdBaseApi).A11();
        YA adObjectContext = this.A07;
        adObjectContext.A0G(yaA11);
        yaA11.A0H(this);
        this.A0D = true;
        UJ ujA0L = UJ.A0L(nativeAdBaseApi);
        ujA0L.A1P(this.A03);
        this.A09.setVisibility(8);
        this.A09.setImage(null, null);
        this.A05.setVisibility(8);
        this.A05.unsetNativeAd();
        ((C5V) this.A05.getMediaViewVideoRendererApi()).A03();
        View view = this.A01;
        if (view != null) {
            view.setVisibility(8);
            View view2 = this.A01;
            if (view2 instanceof N9) {
                ((N9) view2).A04();
            } else {
                ((ED) view2).setAdapter(null);
            }
        }
        this.A02.setVisibility(0);
        bringChildToFront(this.A02);
        this.A00 = this.A02;
        J4 adIcon = ujA0L.getAdIcon();
        if (adIcon != null) {
            Bitmap bitmapA0M = ujA0L.A10().A0M(adIcon.getUrl());
            if (bitmapA0M != null) {
                this.A02.setImageBitmap(bitmapA0M);
                if (z) {
                    this.A03.post(new C1418Ym(this, ujA0L));
                }
            } else {
                A0G(ujA0L, z, adIcon);
            }
        } else {
            UI uiA15 = ujA0L.A15();
            AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
            yaA11.A0E().A2i(ujA0L.A0x(), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            if (uiA15 != null) {
                uiA15.ABH(JG.A00(adErrorType));
            }
            Log.e(A04(46, 17, 115), adErrorType.getDefaultErrorMessage());
            if (nativeAdBaseApi.isAdLoaded()) {
                YA adObjectContext2 = this.A07;
                adObjectContext2.A07().A9M(A04(258, 3, 84), C07597x.A0W, new C07607y(A04(192, 23, 96)));
            }
        }
        A0A(this.A02, ujA0L);
    }

    public final boolean A0N() {
        View view = this.A01;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.facebook.ads.redexgen.X.C7P
    public final YA A5p() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.C5O, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void bringChildToFront(View view) {
        if (view == this.A01 || view == this.A05 || view == this.A09 || view == this.A02) {
            this.A06.bringChildToFront(view);
            PK pk = this.A0B;
            if (pk != null) {
                this.A06.bringChildToFront(pk);
            }
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void destroy() {
        this.A05.pause(false);
        this.A05.getMediaViewVideoRendererApi().destroy();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final View getAdContentsView() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaHeight() {
        if (this.A09.getVisibility() == 0) {
            return this.A09.getImageHeight();
        }
        if (this.A05.getVisibility() == 0) {
            return this.A05.getMediaViewVideoRendererApi().getVideoView().getHeight();
        }
        if (this.A03.getVisibility() == 0) {
            return this.A03.getHeight();
        }
        if (A0F[1].charAt(24) == 't') {
            throw new RuntimeException();
        }
        A0F[7] = "3C5Zne3gt6SFfa7y1AnuQltffgpI3Oh8";
        return 0;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaWidth() {
        if (this.A09.getVisibility() == 0) {
            return this.A09.getImageWidth();
        }
        if (this.A05.getVisibility() == 0) {
            return this.A05.getMediaViewVideoRendererApi().getVideoView().getWidth();
        }
        if (this.A03.getVisibility() == 0) {
            return this.A03.getWidth();
        }
        String[] strArr = A0F;
        if (strArr[6].charAt(12) == strArr[2].charAt(12)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[5] = "pFreRfYdfw1";
        strArr2[0] = "pVUprXCJsnglf8IlGtX2XFBaJ";
        return 0;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaView mediaView) {
        Context context = adViewConstructorParams.getContext();
        if (context instanceof YA) {
            this.A07 = (YA) context;
        } else {
            this.A07 = C5Q.A02(context);
        }
        this.A07.A0H(this);
        switch (adViewConstructorParams.getInitializationType()) {
            case 0:
                A0F(this.A07, mediaView);
                break;
            case 1:
                A0E(this.A07, adViewConstructorParams.getAttributeSet(), mediaView);
                break;
            case 2:
                A0D(this.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), mediaView);
                break;
            case 3:
                A0C(this.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), adViewConstructorParams.getDefStyleRes(), mediaView);
                break;
            default:
                throw new IllegalArgumentException(A04(155, 37, 116));
        }
        A01(true);
    }

    @Override // com.facebook.ads.redexgen.X.C5O, com.facebook.ads.internal.api.AdComponentViewApi
    public final void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        super.onAttachedToView(adComponentView, adComponentViewParentApi);
        this.A06 = adComponentViewParentApi;
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        int currentHeight = this.A03.getWidth();
        int height = this.A03.getHeight();
        if (currentHeight > 0 && height > 0) {
            this.A03.repair(th);
            this.A03.getLayoutParams().width = currentHeight;
            MediaView mediaView = this.A03;
            if (A0F[1].charAt(24) == 116) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[5] = "Mgb6bOJjyiN";
            strArr[0] = "MTEeDXbdwkPsq4eW7ABfM3WBi";
            mediaView.getLayoutParams().height = height;
            this.A03.setBackgroundColor(-3355444);
            return;
        }
        this.A03.repair(th);
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setListener(MediaViewListener mediaViewListener) {
        this.A04 = mediaViewListener;
        if (mediaViewListener == null) {
            ((C5V) this.A05.getMediaViewVideoRendererApi()).A07(null);
        } else {
            ((C5V) this.A05.getMediaViewVideoRendererApi()).A07(new C1411Yf(this, mediaViewListener));
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        if (!this.A0D) {
            MediaViewVideoRenderer mediaViewVideoRenderer2 = this.A05;
            if (A0F[7].charAt(21) == 'L') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[6] = "ifAS5bhxfK6Gg4eu5Yemnhg9EBEfp9jT";
            strArr[2] = "R5YDbsM1msNnvJcIFydw3DY2O0brJ9d9";
            if (mediaViewVideoRenderer2 != null) {
                this.A03.removeView(mediaViewVideoRenderer2);
                this.A05.getMediaViewVideoRendererApi().destroy();
            }
            ((C5V) mediaViewVideoRenderer.getMediaViewVideoRendererApi()).A05(this.A07.A09());
            mediaViewVideoRenderer.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((C1410Ye) this.A03.getMediaViewApi()).A09(mediaViewVideoRenderer, layoutParams);
            this.A05 = mediaViewVideoRenderer;
            this.A0C = !(mediaViewVideoRenderer instanceof DefaultMediaViewVideoRenderer);
            mediaViewVideoRenderer.setId(LV.A00());
            return;
        }
        throw new IllegalStateException(A04(215, 43, 114));
    }
}

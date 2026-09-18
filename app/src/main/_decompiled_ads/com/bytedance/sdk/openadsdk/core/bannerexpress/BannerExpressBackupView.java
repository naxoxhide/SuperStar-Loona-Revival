package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.RatioFrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class BannerExpressBackupView extends BackupView {
    public static m[] q = {new m(1, 6.4f, 320, 50), new m(4, 1.2f, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, 250)};
    private h m;
    private NativeExpressView n;
    private String o;
    private PAGBannerAdWrapperListener p;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(((BackupView) BannerExpressBackupView.this).a, ((BackupView) BannerExpressBackupView.this).f646b, ((BackupView) BannerExpressBackupView.this).e);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BannerExpressBackupView.this.s();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(((BackupView) BannerExpressBackupView.this).a, ((BackupView) BannerExpressBackupView.this).f646b, ((BackupView) BannerExpressBackupView.this).e);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BannerExpressBackupView.this.s();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(((BackupView) BannerExpressBackupView.this).a, ((BackupView) BannerExpressBackupView.this).f646b, ((BackupView) BannerExpressBackupView.this).e);
        }
    }

    class f implements NativeVideoTsView.h {
        f() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.h
        public void a(View view, int i) {
            if (BannerExpressBackupView.this.p != null) {
                BannerExpressBackupView.this.p.onAdClicked(view, i);
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BannerExpressBackupView.this.s();
        }
    }

    static {
        new AtomicInteger(1);
    }

    public BannerExpressBackupView(Context context) {
        super(context);
        this.a = context;
    }

    private void m() {
        m mVarB = b(this.n.getExpectExpressWidth(), this.n.getExpectExpressHeight());
        if (this.n.getExpectExpressWidth() <= 0 || this.n.getExpectExpressHeight() <= 0) {
            int i = b0.i(this.a);
            this.f = i;
            this.g = Float.valueOf(i / mVarB.f658b).intValue();
        } else {
            this.f = b0.a(this.a, this.n.getExpectExpressWidth());
            this.g = b0.a(this.a, this.n.getExpectExpressHeight());
        }
        int i2 = this.f;
        if (i2 > 0 && i2 > b0.i(this.a)) {
            float fI = b0.i(this.a) / this.f;
            this.f = b0.i(this.a);
            this.g = Float.valueOf(this.g * fI).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f, this.g);
        }
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        int i3 = mVarB.a;
        if (i3 == 1) {
            q();
        } else if (i3 == 4) {
            r();
        } else {
            r();
        }
    }

    private h n() {
        int iA = b0.a(this.a, 45.0f);
        int iA2 = b0.a(this.a, 25.0f);
        int i = (int) (((double) iA2) / 5.0d);
        int iA3 = b0.a(this.a, 10.0f);
        int iA4 = b0.a(this.a, 2.0f);
        int iA5 = b0.a(this.a, 3.0f);
        b0.a(this.a, 11.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        addView(relativeLayout, -1, -1);
        ImageView imageView = new ImageView(this.a);
        imageView.setId(520093738);
        TextView textView = new TextView(this.a);
        textView.setId(520093730);
        TextView textView2 = new TextView(this.a);
        textView2.setId(520093731);
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(this.a, null);
        tTRatingBar2.setId(520093735);
        View tTBackUpAdImageView = new TTBackUpAdImageView(this.a);
        tTBackUpAdImageView.setId(520093739);
        TextView textView3 = new TextView(this.a);
        textView3.setId(520093703);
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setId(520093697);
        h hVar = new h(imageView, textView, textView2, tTRatingBar2, tTBackUpAdImageView, textView3, imageView2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            layoutParams.addRule(20);
        }
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(t.c(this.a, "tt_white"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, iA2);
        if (i2 >= 17) {
            layoutParams2.setMarginStart(iA3);
            layoutParams2.addRule(16, textView3.getId());
            layoutParams2.addRule(17, imageView.getId());
            textView.setTextDirection(5);
        }
        layoutParams2.leftMargin = iA3;
        layoutParams2.addRule(0, textView3.getId());
        layoutParams2.addRule(1, imageView.getId());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(80);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF333333"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, iA2);
        layoutParams3.addRule(3, textView.getId());
        if (i2 >= 17) {
            layoutParams3.setMarginStart(iA3);
            layoutParams3.addRule(17, imageView.getId());
        }
        layoutParams3.leftMargin = iA3;
        layoutParams3.topMargin = iA4;
        layoutParams3.addRule(1, imageView.getId());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setTextColor(Color.parseColor("#FF333333"));
        textView2.setTextSize(12.0f);
        textView2.setTypeface(Typeface.defaultFromStyle(1));
        textView2.setLayoutParams(layoutParams3);
        relativeLayout.addView(textView2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = iA4;
        layoutParams4.addRule(3, textView.getId());
        layoutParams4.addRule(6, textView2.getId());
        if (i2 >= 17) {
            layoutParams4.setMarginStart(iA4);
            layoutParams4.addRule(17, textView2.getId());
            layoutParams4.addRule(16, textView3.getId());
        }
        layoutParams4.leftMargin = iA4;
        layoutParams4.addRule(1, textView2.getId());
        layoutParams4.addRule(0, textView3.getId());
        tTRatingBar2.setLayoutParams(layoutParams4);
        relativeLayout.addView(tTRatingBar2);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        if (i2 >= 17) {
            layoutParams5.addRule(21);
            layoutParams5.setMarginEnd(iA5);
        }
        layoutParams5.addRule(11);
        layoutParams5.addRule(12);
        layoutParams5.topMargin = iA5;
        layoutParams5.rightMargin = iA5;
        tTBackUpAdImageView.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTBackUpAdImageView);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        if (i2 >= 17) {
            layoutParams6.setMarginEnd(iA2);
            layoutParams6.addRule(21);
        }
        layoutParams6.rightMargin = iA2;
        textView3.setBackgroundResource(t.e(this.a, "tt_backup_btn_1"));
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setGravity(17);
        textView3.setMaxLines(1);
        textView3.setPadding(iA3, i, iA3, i);
        textView3.setText(t.k(this.a, "tt_video_download_apk"));
        textView3.setTextColor(Color.parseColor("#f0f0f0"));
        textView3.setTextSize(10.0f);
        textView3.setLayoutParams(layoutParams6);
        relativeLayout.addView(textView3);
        int i3 = iA5 * 5;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i3, i3);
        if (i2 >= 17) {
            layoutParams7.addRule(21);
            layoutParams7.setMarginEnd(iA5);
        }
        layoutParams7.addRule(11);
        layoutParams7.topMargin = iA5;
        layoutParams7.rightMargin = iA5;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageResource(t.e(this.a, "tt_dislike_icon"));
        imageView2.setLayoutParams(layoutParams7);
        relativeLayout.addView(imageView2);
        return hVar;
    }

    private h o() {
        float fA = b0.a(this.a, 5.0f);
        float fA2 = b0.a(this.a, 7.0f);
        float fA3 = b0.a(this.a, 8.0f);
        float fA4 = b0.a(this.a, 18.0f);
        float fA5 = b0.a(this.a, 15.0f);
        float fA6 = b0.a(this.a, 45.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        int i = (int) fA3;
        relativeLayout.setPadding(i, i, i, i);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        TextView textView = new TextView(this.a);
        textView.setId(520093730);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            layoutParams2.setMarginEnd((int) fA4);
            textView.setTextDirection(5);
        }
        int i3 = (int) fA4;
        layoutParams2.rightMargin = i3;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(GravityCompat.START);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(14.0f);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(this.a);
        textView2.setId(520093733);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.addRule(3, textView.getId());
        layoutParams3.topMargin = (int) (fA3 / 2.0f);
        if (i2 >= 17) {
            layoutParams3.setMarginEnd(i3);
            textView2.setTextDirection(5);
        }
        layoutParams3.rightMargin = i3;
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(GravityCompat.START);
        textView2.setMaxLines(2);
        textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
        textView2.setTextSize(12.0f);
        textView2.setLayoutParams(layoutParams3);
        relativeLayout.addView(textView2);
        ImageView imageView = new ImageView(this.a);
        imageView.setId(520093697);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        int i4 = (int) fA5;
        layoutParams4.width = i4;
        layoutParams4.height = i4;
        if (i2 >= 17) {
            layoutParams4.addRule(21);
        }
        layoutParams4.addRule(11);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(t.e(this.a, "tt_titlebar_close_press_for_dark"));
        imageView.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        if (i2 >= 17) {
            linearLayout.setLayoutDirection(3);
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(3, textView2.getId());
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        relativeLayout.addView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.weight = 1.0f;
        frameLayout.setLayoutParams(layoutParams6);
        linearLayout.addView(frameLayout);
        RatioImageView ratioImageView = new RatioImageView(this.a);
        ratioImageView.setId(520093736);
        ratioImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        frameLayout.addView(ratioImageView, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setId(520093737);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
        layoutParams7.weight = 1.0f;
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams7);
        linearLayout.addView(linearLayout2);
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setId(520093738);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        int i5 = (int) fA6;
        layoutParams8.width = i5;
        layoutParams8.height = i5;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setLayoutParams(layoutParams8);
        linearLayout2.addView(imageView2);
        TextView textView3 = new TextView(this.a);
        textView3.setId(520093730);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.topMargin = (int) fA2;
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setGravity(17);
        textView3.setMaxLines(1);
        textView3.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView3.setTextSize(12.0f);
        textView3.setLayoutParams(layoutParams9);
        linearLayout2.addView(textView3);
        TextView textView4 = new TextView(this.a);
        textView4.setId(520093703);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.topMargin = (int) (fA3 * 2.0f);
        textView4.setBackgroundResource(t.e(this.a, "tt_backup_btn_1"));
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        textView4.setMaxLines(1);
        int i6 = (int) (2.0f * fA);
        int i7 = (int) fA;
        textView4.setPadding(i6, i7, i6, i7);
        textView4.setText(t.k(this.a, "tt_video_download_apk"));
        textView4.setTextColor(t.c(this.a, "tt_white"));
        textView4.setTextSize(10.0f);
        textView4.setLayoutParams(layoutParams10);
        linearLayout2.addView(textView4);
        View tTBackUpAdImageView = new TTBackUpAdImageView(this.a);
        tTBackUpAdImageView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(12);
        tTBackUpAdImageView.setLayoutParams(layoutParams11);
        relativeLayout.addView(tTBackUpAdImageView);
        return new h(imageView2, textView, tTBackUpAdImageView, textView4, imageView, textView3, textView2, ratioImageView);
    }

    private h p() {
        float fA = b0.a(this.a, 4.0f);
        float fA2 = b0.a(this.a, 5.0f);
        float fA3 = b0.a(this.a, 8.0f);
        float fA4 = b0.a(this.a, 15.0f);
        float fA5 = b0.a(this.a, 18.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        int i = (int) fA3;
        relativeLayout.setPadding(i, i, i, i);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        TextView textView = new TextView(this.a);
        textView.setId(520093730);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.width = -1;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            layoutParams2.setMarginEnd((int) fA5);
            textView.setTextDirection(5);
        }
        layoutParams2.rightMargin = (int) fA5;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(GravityCompat.START);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(14.0f);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        ImageView imageView = new ImageView(this.a);
        imageView.setId(520093697);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        int i3 = (int) fA4;
        layoutParams3.width = i3;
        layoutParams3.height = i3;
        if (i2 >= 17) {
            layoutParams3.addRule(21);
        }
        layoutParams3.addRule(11);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(t.e(this.a, "tt_titlebar_close_press_for_dark"));
        imageView.setLayoutParams(layoutParams3);
        relativeLayout.addView(imageView);
        TextView textView2 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        textView2.setId(520093703);
        layoutParams4.addRule(11);
        if (i2 >= 17) {
            layoutParams4.addRule(21);
        }
        layoutParams4.addRule(12);
        layoutParams4.topMargin = i;
        textView2.setBackgroundResource(t.e(this.a, "tt_backup_btn_1"));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        int i4 = (int) (2.0f * fA2);
        int i5 = (int) fA2;
        textView2.setPadding(i4, i5, i4, i5);
        textView2.setText(t.k(this.a, "tt_video_download_apk"));
        textView2.setTextColor(t.c(this.a, "tt_white"));
        textView2.setTextSize(10.0f);
        textView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView2);
        TextView textView3 = new TextView(this.a);
        textView3.setId(520093733);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(4, textView2.getId());
        if (i2 >= 17) {
            layoutParams5.addRule(20);
            layoutParams5.addRule(16, textView2.getId());
            textView3.setTextDirection(5);
        }
        layoutParams5.addRule(12);
        layoutParams5.rightMargin = (int) fA;
        layoutParams5.addRule(0, textView2.getId());
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setGravity(GravityCompat.START);
        textView3.setMaxLines(1);
        textView3.setTextColor(Color.parseColor("#FFAEAEAE"));
        textView3.setTextSize(12.0f);
        textView3.setLayoutParams(layoutParams5);
        relativeLayout.addView(textView3);
        FrameLayout frameLayout = new FrameLayout(this.a);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(2, textView2.getId());
        layoutParams6.addRule(3, textView.getId());
        layoutParams6.topMargin = i;
        frameLayout.setLayoutParams(layoutParams6);
        relativeLayout.addView(frameLayout);
        RatioFrameLayout ratioFrameLayout = new RatioFrameLayout(this.a);
        ratioFrameLayout.setId(520093736);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams7.gravity = 17;
        ratioFrameLayout.setLayoutParams(layoutParams7);
        frameLayout.addView(ratioFrameLayout);
        View tTBackUpAdImageView = new TTBackUpAdImageView(this.a);
        tTBackUpAdImageView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, textView2.getId());
        tTBackUpAdImageView.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTBackUpAdImageView);
        return new h(textView, tTBackUpAdImageView, textView2, imageView, textView3, ratioFrameLayout);
    }

    private void q() {
        float fA = (this.g * 1.0f) / b0.a(this.a, 50.0f);
        float f2 = this.g * 1.0f;
        float f3 = this.f;
        if (f2 / f3 > 0.21875f) {
            fA = (f3 * 1.0f) / b0.a(this.a, 320.0f);
        }
        h hVarN = n();
        this.m = hVarN;
        ImageView imageView = hVarN.k;
        ImageView imageView2 = hVarN.e;
        TextView textView = hVarN.f;
        TextView textView2 = hVarN.g;
        TTRatingBar2 tTRatingBar2 = hVarN.h;
        TextView textView3 = hVarN.j;
        textView.setTextSize(2, b0.c(this.a, textView.getTextSize()) * fA);
        textView2.setTextSize(2, b0.c(this.a, textView2.getTextSize()) * fA);
        textView3.setTextSize(2, b0.c(this.a, textView3.getTextSize()) * fA);
        View view = this.m.i;
        if (view != null) {
            view.setOnClickListener(new a());
        }
        imageView.setOnClickListener(new b());
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (b0.a(this.a, 45.0f) * fA);
            layoutParams.height = (int) (b0.a(this.a, 45.0f) * fA);
        }
        if (this.f646b.b0() != null && !TextUtils.isEmpty(this.f646b.b0().d())) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.f646b.b0().d(), this.f646b.b0().e(), this.f646b.b0().b(), imageView2, this.f646b);
        }
        textView.setText(getTitle());
        if (TextUtils.isEmpty(this.f646b.r())) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(this.f646b.r());
        }
        b0.a(textView2, tTRatingBar2, this.f646b);
        a(imageView2, true);
        imageView2.setTag(520093762, Boolean.TRUE);
        a(this, true);
        a(textView3, true);
    }

    private void r() {
        q qVar = this.f646b;
        if (qVar != null) {
            int iC0 = qVar.c0();
            float fA = (this.g * 1.0f) / b0.a(this.a, 250.0f);
            if (this.f646b.N0() != null) {
                h hVarP = p();
                this.m = hVarP;
                ImageView imageView = hVarP.k;
                TextView textView = hVarP.f;
                TextView textView2 = hVarP.c;
                TextView textView3 = hVarP.j;
                RatioFrameLayout ratioFrameLayout = hVarP.a;
                textView.setTextSize(2, b0.c(this.a, textView.getTextSize()) * fA);
                textView2.setTextSize(2, b0.c(this.a, textView2.getTextSize()) * fA);
                textView3.setTextSize(2, b0.c(this.a, textView3.getTextSize()) * fA);
                View view = this.m.i;
                if (view != null) {
                    view.setOnClickListener(new e());
                }
                if (iC0 == 15) {
                    ratioFrameLayout.setRatio(0.5625f);
                } else if (iC0 == 5) {
                    ratioFrameLayout.setRatio(1.7777778f);
                } else {
                    ratioFrameLayout.setRatio(1.0f);
                }
                ratioFrameLayout.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                NativeVideoTsView videoView = getVideoView();
                if (videoView != null) {
                    NativeExpressView nativeExpressView = this.n;
                    if (nativeExpressView instanceof NativeExpressVideoView) {
                        videoView.setVideoAdInteractionListener((NativeExpressVideoView) nativeExpressView);
                    }
                    ratioFrameLayout.addView(videoView, layoutParams);
                    videoView.setAdCreativeClickListener(new f());
                    com.bytedance.sdk.openadsdk.core.nativeexpress.f clickCreativeListener = this.n.getClickCreativeListener();
                    if (clickCreativeListener != null) {
                        clickCreativeListener.a(videoView.getNativeVideoController());
                    }
                }
                textView.setText(getNameOrSource());
                textView2.setText(getDescription());
                if (TextUtils.isEmpty(this.f646b.r())) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(this.f646b.r());
                }
                imageView.setOnClickListener(new g());
                int iA = b0.a(this.a, 15.0f);
                b0.a(imageView, iA, iA, iA, iA);
                a(videoView, true);
                if (videoView != null) {
                    videoView.setTag(520093762, Boolean.TRUE);
                }
                a(this, true);
                a(textView3, true);
                a(ratioFrameLayout);
                return;
            }
            h hVarO = o();
            this.m = hVarO;
            ImageView imageView2 = hVarO.k;
            RatioImageView ratioImageView = hVarO.f557b;
            ImageView imageView3 = hVarO.e;
            TextView textView4 = hVarO.f;
            TextView textView5 = hVarO.c;
            TextView textView6 = hVarO.d;
            TextView textView7 = hVarO.j;
            ViewGroup.LayoutParams layoutParams2 = imageView3.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = (int) (b0.a(this.a, 45.0f) * fA);
                layoutParams2.height = (int) (b0.a(this.a, 45.0f) * fA);
            }
            textView4.setTextSize(2, b0.c(this.a, textView4.getTextSize()) * fA);
            textView5.setTextSize(2, b0.c(this.a, textView5.getTextSize()) * fA);
            textView6.setTextSize(2, b0.c(this.a, textView6.getTextSize()) * fA);
            textView7.setTextSize(2, b0.c(this.a, textView7.getTextSize()) * fA);
            try {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView4.getLayoutParams();
                float f2 = fA - 1.0f;
                if (f2 > 0.0f) {
                    layoutParams3.topMargin = b0.a(this.a, f2 * 8.0f);
                }
                ((LinearLayout.LayoutParams) textView7.getLayoutParams()).setMargins(0, (int) (b0.a(this.a, 16.0f) * fA), 0, 0);
            } catch (Throwable unused) {
            }
            View view2 = this.m.i;
            if (view2 != null) {
                view2.setOnClickListener(new c());
            }
            if (iC0 == 33) {
                ratioImageView.setRatio(1.0f);
            } else {
                if (ratioImageView.getParent() instanceof FrameLayout) {
                    ((LinearLayout.LayoutParams) ((FrameLayout) ratioImageView.getParent()).getLayoutParams()).weight = 2.5f;
                }
                ratioImageView.setRatio(1.91f);
            }
            imageView2.setOnClickListener(new d());
            int iA2 = b0.a(this.a, 15.0f);
            b0.a(imageView2, iA2, iA2, iA2, iA2);
            a((ImageView) ratioImageView);
            if (this.f646b.b0() != null && !TextUtils.isEmpty(this.f646b.b0().d())) {
                com.bytedance.sdk.openadsdk.n.c.b().a(this.f646b.b0().d(), this.f646b.b0().e(), this.f646b.b0().b(), imageView3, this.f646b);
            }
            textView6.setText(getNameOrSource());
            textView4.setText(getNameOrSource());
            textView5.setText(getDescription());
            if (TextUtils.isEmpty(this.f646b.r())) {
                textView7.setVisibility(8);
            } else {
                textView7.setText(this.f646b.r());
            }
            a(ratioImageView, true);
            ratioImageView.setTag(520093762, Boolean.TRUE);
            a(this, true);
            a(textView7, true);
        }
    }

    public void s() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.c;
        if (bVar != null) {
            bVar.a();
        } else {
            TTDelegateActivity.a(this.f646b, this.o);
        }
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.p = pAGBannerAdWrapperListener;
    }

    public void setClosedListenerKey(String str) {
        this.o = str;
    }

    public static m b(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 450.0d) / 600.0d) ? q[1] : q[0];
        } catch (Throwable unused) {
            return q[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(View view, int i, com.bytedance.sdk.openadsdk.core.f0.m mVar) {
        h hVar;
        NativeExpressView nativeExpressView = this.n;
        if (nativeExpressView != null) {
            if ((i == 1 || i == 2) && (hVar = this.m) != null) {
                ImageView imageView = hVar.k;
                if (i == 1) {
                    nativeExpressView.getClickListener().a(imageView);
                } else {
                    nativeExpressView.getClickCreativeListener().a(imageView);
                }
            }
            this.n.a(view, i, mVar);
        }
    }

    private static class h {
        private RatioFrameLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RatioImageView f557b;
        public TextView c;
        public TextView d;
        ImageView e;
        TextView f;
        TextView g;
        TTRatingBar2 h;
        View i;
        TextView j;
        ImageView k;

        h(ImageView imageView, TextView textView, TextView textView2, TTRatingBar2 tTRatingBar2, View view, TextView textView3, ImageView imageView2) {
            this.e = imageView;
            this.f = textView;
            this.g = textView2;
            this.h = tTRatingBar2;
            this.i = view;
            this.j = textView3;
            this.k = imageView2;
        }

        h(ImageView imageView, TextView textView, View view, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, RatioImageView ratioImageView) {
            this(imageView, textView, null, null, view, textView2, imageView2);
            this.d = textView3;
            this.c = textView4;
            this.f557b = ratioImageView;
        }

        h(TextView textView, View view, TextView textView2, ImageView imageView, TextView textView3, RatioFrameLayout ratioFrameLayout) {
            this(null, textView, null, null, view, textView2, imageView);
            this.c = textView3;
            this.a = ratioFrameLayout;
        }
    }

    void a(q qVar, NativeExpressView nativeExpressView, b.c.a.a.a.a.c cVar) {
        setBackgroundColor(-1);
        this.f646b = qVar;
        this.n = nativeExpressView;
        this.e = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        m();
    }

    private void a(ImageView imageView) {
        com.bytedance.sdk.openadsdk.n.c.b().a(this.f646b.d0().get(0), imageView, this.f646b);
    }
}

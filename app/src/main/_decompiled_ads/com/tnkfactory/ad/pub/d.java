package com.tnkfactory.ad.pub;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.pub.a.b1;
import com.tnkfactory.ad.pub.a.c1;
import com.tnkfactory.ad.pub.a.d1;
import com.tnkfactory.ad.pub.a.l;
import com.tnkfactory.ad.pub.a.w0;
import com.tnkfactory.ad.pub.model.EvtTrackUrls;
import com.tnkfactory.ad.pub.model.Vdo_iconsVO;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends RelativeLayout {
    public boolean A;
    public boolean B;
    public com.tnkfactory.ad.pub.a C;
    public String D;
    public ArrayList<String> E;
    public b F;
    public c G;
    public RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.tnkfactory.ad.pub.e f2912b;
    public RelativeLayout.LayoutParams c;
    public ToggleButton d;
    public ToggleButton e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public i s;
    public k t;
    public c1 u;
    public d1 v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2913b;

        public a(String str, int i) {
            this.a = str;
            this.f2913b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tnkfactory.ad.pub.c.a.a();
            com.tnkfactory.ad.pub.c.a.a(this.a, this.f2913b);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d dVar = d.this;
            if (!dVar.o || dVar.f2912b.getPlayTimeLeft() <= 0) {
                return;
            }
            d.this.setPanelVisible(false);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:23:0x007d  */
        @Override // java.lang.Runnable
        public final void run() {
            long j;
            String str;
            long j2;
            d dVar = d.this;
            if (dVar.k > 0) {
                int playTimeLeft = dVar.f2912b.getPlayTimeLeft();
                long playCurrentTime = d.this.f2912b.getPlayCurrentTime();
                d dVar2 = d.this;
                if (dVar2.j != null) {
                    String str2 = dVar2.C.i0;
                    if (str2 == null) {
                        j = 0;
                    } else {
                        String[] strArrSplit = str2.split(CertificateUtil.DELIMITER);
                        if (strArrSplit.length == 0) {
                            j = 0;
                        } else {
                            try {
                                if (strArrSplit.length == 3) {
                                    int iIndexOf = strArrSplit[2].indexOf(".");
                                    if (iIndexOf != -1) {
                                        strArrSplit[2] = strArrSplit[2].substring(0, iIndexOf);
                                    }
                                    j2 = ((long) (Integer.parseInt(strArrSplit[0]) * 3600)) + 0 + ((long) (Integer.parseInt(strArrSplit[1]) * 60));
                                    str = strArrSplit[2];
                                } else if (strArrSplit.length == 2) {
                                    long j3 = ((long) (Integer.parseInt(strArrSplit[0]) * 60)) + 0;
                                    str = strArrSplit[1];
                                    j2 = j3;
                                } else {
                                    j = 0;
                                }
                                j = j2 + ((long) Integer.parseInt(str));
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                    long j4 = j - (playCurrentTime / 1000);
                    d dVar3 = d.this;
                    if (!dVar3.q || TextUtils.isEmpty(dVar3.C.i0) || j4 < 0) {
                        d.this.j.setText("");
                    } else {
                        d.this.j.setText(String.valueOf(j4) + " 초 남았습니다.");
                    }
                }
                if (playTimeLeft < 0) {
                    return;
                }
                d dVar4 = d.this;
                int i = dVar4.k;
                float f = (i - playTimeLeft) / i;
                ImageView imageView = dVar4.h;
                if (imageView != null) {
                    ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();
                    if (d.this.q) {
                        if (clipDrawable != null) {
                            clipDrawable.setLevel((int) (10000.0f * f));
                        }
                    } else if (clipDrawable != null) {
                        clipDrawable.setLevel(0);
                    }
                }
                d dVar5 = d.this;
                TextView textView = dVar5.i;
                if (textView != null) {
                    if (!dVar5.q || playTimeLeft <= 300) {
                        textView.setText("");
                    } else {
                        textView.setText(String.valueOf(playTimeLeft / 1000));
                    }
                }
                d dVar6 = d.this;
                if (dVar6.q) {
                    dVar6.postDelayed(this, 200L);
                }
                d dVar7 = d.this;
                k kVar = dVar7.t;
                if (kVar != null) {
                    double d = f;
                    if (d >= 0.25d && !dVar7.x) {
                        dVar7.x = true;
                        ((com.tnkfactory.ad.pub.b.a) kVar).a(25);
                        EvtTrackUrls evtTrackUrls = d.this.C.g0;
                        if (evtTrackUrls != null && evtTrackUrls.firstQuartile != null) {
                            com.tnkfactory.ad.pub.c.a.a().a(d.this.C.g0.firstQuartile);
                        }
                    }
                    if (d >= 0.5d) {
                        d dVar8 = d.this;
                        if (!dVar8.y) {
                            dVar8.y = true;
                            ((com.tnkfactory.ad.pub.b.a) dVar8.t).a(50);
                            EvtTrackUrls evtTrackUrls2 = d.this.C.g0;
                            if (evtTrackUrls2 != null && evtTrackUrls2.midpoint != null) {
                                com.tnkfactory.ad.pub.c.a.a().a(d.this.C.g0.midpoint);
                            }
                        }
                    }
                    if (d >= 0.75d) {
                        d dVar9 = d.this;
                        if (dVar9.z) {
                            return;
                        }
                        dVar9.z = true;
                        ((com.tnkfactory.ad.pub.b.a) dVar9.t).a(75);
                        EvtTrackUrls evtTrackUrls3 = d.this.C.g0;
                        if (evtTrackUrls3 == null || evtTrackUrls3.thirdQuartile == null) {
                            return;
                        }
                        com.tnkfactory.ad.pub.c.a.a().a(d.this.C.g0.thirdQuartile);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.tnkfactory.ad.pub.d$d, reason: collision with other inner class name */
    public class C0533d implements j {
        public final /* synthetic */ Context a;

        public C0533d(Context context) {
            this.a = context;
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d dVar = d.this;
            dVar.getClass();
            ToggleButton toggleButton = (ToggleButton) view;
            if (dVar.f2912b == null) {
                return;
            }
            if (!toggleButton.isChecked()) {
                dVar.a();
                return;
            }
            dVar.r = true;
            dVar.f2912b.d();
            dVar.a(700L);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tnkfactory.ad.pub.c.a aVarA;
            ArrayList<String> arrayList;
            d dVar = d.this;
            dVar.getClass();
            if (view == null) {
                return;
            }
            boolean zIsChecked = ((ToggleButton) view).isChecked();
            dVar.p = zIsChecked;
            if (zIsChecked) {
                EvtTrackUrls evtTrackUrls = dVar.C.g0;
                if (evtTrackUrls != null && !evtTrackUrls.mute.isEmpty()) {
                    aVarA = com.tnkfactory.ad.pub.c.a.a();
                    arrayList = dVar.C.g0.mute;
                    aVarA.a(arrayList);
                }
            } else {
                EvtTrackUrls evtTrackUrls2 = dVar.C.g0;
                if (evtTrackUrls2 != null && !evtTrackUrls2.unmute.isEmpty()) {
                    aVarA = com.tnkfactory.ad.pub.c.a.a();
                    arrayList = dVar.C.g0.unmute;
                    aVarA.a(arrayList);
                }
            }
            dVar.f2912b.setVolumeOn(!dVar.p);
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ Context a;

        public g(Context context) {
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d dVar = d.this;
            if (dVar.f2912b == null || !dVar.q) {
                return;
            }
            ArrayList<String> arrayList = dVar.E;
            if (arrayList != null && !arrayList.isEmpty()) {
                com.tnkfactory.ad.pub.c.a.a().a(d.this.E);
            }
            if (TextUtils.isEmpty(d.this.D)) {
                return;
            }
            d dVar2 = d.this;
            Context context = this.a;
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(dVar2.D));
                intent.addFlags(268435456);
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.putExtra("com.android.browser.application_id", context.getApplicationContext().getPackageName());
                context.startActivity(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            d.this.a();
            d.this.r = true;
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d dVar = d.this;
            if (dVar.f2912b == null || !dVar.q) {
                return;
            }
            com.tnkfactory.ad.pub.a aVar = dVar.C;
            if (aVar != null && !aVar.g0.skip.isEmpty()) {
                com.tnkfactory.ad.pub.c.a.a().a(d.this.C.g0.skip);
                d.this.f2912b.getClass();
            }
            k kVar = d.this.t;
            if (kVar != null) {
                com.tnkfactory.ad.pub.b.a(com.tnkfactory.ad.pub.b.this, AdListener.CLOSE_SIMPLE);
            }
        }
    }

    public interface i {
    }

    public interface j {
    }

    public interface k {
    }

    public d(Context context, int i2, boolean z, int i3) {
        super(context);
        this.c = null;
        this.k = 0;
        this.m = false;
        this.n = true;
        this.o = true;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.F = new b();
        this.G = new c();
        this.l = z;
        if (z) {
            this.r = true;
        }
        a(context, i2, i3);
    }

    public static void a(d dVar, boolean z) {
        if (!z) {
            if (dVar.q) {
                dVar.b();
            }
        } else {
            if (!dVar.r || dVar.q) {
                return;
            }
            dVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanelVisible(boolean z) {
        this.o = z;
        int i2 = z ? 0 : 4;
        if (this.C.g0 == null) {
            ToggleButton toggleButton = this.d;
            if (toggleButton != null && toggleButton.getVisibility() != i2) {
                this.d.setVisibility(i2);
                if (i2 == 4) {
                    this.d.startAnimation(l.a(2));
                }
            }
        } else {
            this.d.setVisibility(4);
        }
        ToggleButton toggleButton2 = this.e;
        if (toggleButton2 != null) {
            toggleButton2.setVisibility(i2);
        }
        TextView textView = this.i;
        if (textView != null) {
            if (this.B) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(i2);
            }
        }
    }

    public final void a() {
        this.r = false;
        b();
    }

    public final void a(long j2) {
        removeCallbacks(this.F);
        if (j2 > 0) {
            postDelayed(this.F, j2);
        }
    }

    public final void a(String str, int i2) {
        try {
            new Thread(new a(str, i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        ToggleButton toggleButton = this.d;
        if (toggleButton != null) {
            toggleButton.setChecked(false);
        }
        com.tnkfactory.ad.pub.e eVar = this.f2912b;
        if (eVar == null || !this.q) {
            return;
        }
        MediaPlayer mediaPlayer = eVar.a;
        if (mediaPlayer != null) {
            eVar.h = 4;
            if (mediaPlayer.isPlaying()) {
                eVar.a.pause();
                eVar.b();
            }
            j jVar = eVar.l;
            if (jVar != null) {
                eVar.a.getCurrentPosition();
                C0533d c0533d = (C0533d) jVar;
                d.this.q = false;
                d dVar = d.this;
                dVar.removeCallbacks(dVar.G);
                EvtTrackUrls evtTrackUrls = d.this.C.g0;
                if (evtTrackUrls != null && !evtTrackUrls.pause.isEmpty()) {
                    com.tnkfactory.ad.pub.c.a.a().a(d.this.C.g0.pause);
                }
            }
            eVar.getPlayCurrentTime();
        }
        setPanelVisible(true);
        a(-1L);
    }

    public final void c() {
        ToggleButton toggleButton = this.d;
        if (toggleButton != null) {
            toggleButton.setChecked(true);
        }
        com.tnkfactory.ad.pub.e eVar = this.f2912b;
        if (eVar != null) {
            eVar.d();
            a(700L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.u == null) {
            this.u = new c1(this);
            getViewTreeObserver().addOnGlobalLayoutListener(this.u);
        }
        if (this.v == null) {
            this.v = new d1(this);
            getViewTreeObserver().addOnScrollChangedListener(this.v);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.u != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.u);
            this.u = null;
        }
        if (this.v != null) {
            getViewTreeObserver().removeOnScrollChangedListener(this.v);
            this.v = null;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.q) {
            setPanelVisible(true);
            a(2000L);
        }
        return true;
    }

    public void setAdData(com.tnkfactory.ad.pub.a aVar) {
        this.C = aVar;
    }

    public void setAutoStart(boolean z) {
        this.m = z;
        if (z) {
            this.r = true;
        }
    }

    public void setKeepRatio(boolean z) {
        this.n = z;
    }

    public void setMediaPath(String str) {
        this.f2912b.setMediaPath(str);
    }

    public void setMuteOnStart(boolean z) {
        this.p = z;
        ToggleButton toggleButton = this.e;
        if (toggleButton != null) {
            toggleButton.setChecked(z);
            this.e.setSelected(this.p);
        }
    }

    public void setVideoActionListener(i iVar) {
        this.s = iVar;
    }

    public void setVideoClipRound(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setOutlineProvider(new w0(i2));
        }
    }

    public void setVideoFrameLayoutParams(RelativeLayout.LayoutParams layoutParams) {
        this.c = layoutParams;
    }

    public void setVideoProgressListener(k kVar) {
        this.t = kVar;
    }

    public static void a(d dVar, Context context, com.tnkfactory.ad.pub.a aVar, ImageView imageView) {
        int i2;
        int i3;
        dVar.getClass();
        ArrayList<Vdo_iconsVO> arrayList = aVar.h0;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Vdo_iconsVO vdo_iconsVO = null;
        for (int i4 = 0; i4 < aVar.h0.size(); i4++) {
            ArrayList<Vdo_iconsVO> arrayList2 = aVar.h0;
            if (arrayList2 != null && (arrayList2.get(i4).program.equals("ad") || aVar.h0.get(i4).program.equals("ad_1") || aVar.h0.get(i4).program.equals("ad_2"))) {
                vdo_iconsVO = aVar.h0.get(i4);
                dVar.D = vdo_iconsVO.icon_click_url;
                dVar.E = vdo_iconsVO.icon_click_tracking_url;
            }
        }
        if (vdo_iconsVO != null) {
            new Thread(new b1(vdo_iconsVO, imageView)).start();
        }
        int iApplyDimension = -1;
        int iApplyDimension2 = (vdo_iconsVO == null || vdo_iconsVO.width.isEmpty()) ? -1 : (int) TypedValue.applyDimension(0, Integer.parseInt(vdo_iconsVO.width), context.getResources().getDisplayMetrics());
        if (vdo_iconsVO != null && !vdo_iconsVO.height.isEmpty()) {
            iApplyDimension = (int) TypedValue.applyDimension(0, Integer.parseInt(vdo_iconsVO.height), context.getResources().getDisplayMetrics());
        }
        if (vdo_iconsVO != null && !vdo_iconsVO.icon_view_tracking_url.isEmpty()) {
            com.tnkfactory.ad.pub.c.a.a().a(vdo_iconsVO.icon_view_tracking_url);
        }
        if (iApplyDimension2 > 0 || iApplyDimension > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iApplyDimension2, iApplyDimension);
            if (!vdo_iconsVO.xPosition.isEmpty()) {
                String str = vdo_iconsVO.xPosition;
                str.getClass();
                if (!str.equals("left")) {
                    i3 = str.equals("right") ? 11 : 9;
                }
                layoutParams.addRule(i3);
            }
            if (!vdo_iconsVO.yPosition.isEmpty()) {
                String str2 = vdo_iconsVO.yPosition;
                str2.getClass();
                if (!str2.equals(TJAdUnitConstants.String.BOTTOM)) {
                    i2 = str2.equals("top") ? 10 : 12;
                }
                layoutParams.addRule(i2);
            }
            imageView.setLayoutParams(layoutParams);
        }
    }

    public static void a(d dVar, int i2, String str) {
        int i3;
        dVar.getClass();
        if (i2 == -1010) {
            i3 = TTAdConstant.DEEPLINK_UNAVAILABLE_CODE;
        } else if (i2 == -1007) {
            i3 = TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE;
        } else if (i2 == -1004) {
            i3 = TTAdConstant.MATE_IS_NULL_CODE;
        } else if (i2 != -110) {
            return;
        } else {
            i3 = TTAdConstant.AD_ID_IS_NULL_CODE;
        }
        dVar.a(str, i3);
    }

    public final void a(Context context, int i2, int i3) {
        this.c = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.a = relativeLayout;
        relativeLayout.setLayoutParams(this.c);
        addView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.tnkfactory.ad.pub.e eVar = new com.tnkfactory.ad.pub.e(context);
        this.f2912b = eVar;
        eVar.setLayoutParams(layoutParams);
        this.f2912b.setVideoPlayListener(new C0533d(context));
        this.a.addView(this.f2912b);
        if (this.l) {
            this.f2912b.setLooping(true);
            this.f2912b.setMute(true);
            return;
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        layoutParams2.addRule(13);
        ToggleButton toggleButton = new ToggleButton(context);
        this.d = toggleButton;
        toggleButton.setLayoutParams(layoutParams2);
        this.d.setText((CharSequence) null);
        this.d.setTextOn(null);
        this.d.setTextOff(null);
        this.d.setBackgroundResource(R.drawable.btn_video_play);
        this.d.setOnClickListener(new e());
        this.a.addView(this.d);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iApplyDimension2, iApplyDimension2);
        if ((i3 & 1) == 0) {
            layoutParams3.addRule(11);
        } else {
            layoutParams3.addRule(9);
        }
        if ((i3 & 2) == 0) {
            layoutParams3.addRule(10);
        } else {
            layoutParams3.addRule(12);
        }
        int i4 = iApplyDimension2 / 4;
        layoutParams3.rightMargin = i4;
        layoutParams3.topMargin = i4;
        layoutParams3.leftMargin = i4;
        layoutParams3.bottomMargin = i4;
        ToggleButton toggleButton2 = new ToggleButton(context);
        this.e = toggleButton2;
        toggleButton2.setLayoutParams(layoutParams3);
        this.e.setText((CharSequence) null);
        this.e.setTextOn(null);
        this.e.setTextOff(null);
        this.e.setBackgroundResource(R.drawable.btn_video_volume);
        this.e.setOnClickListener(new f());
        this.a.addView(this.e);
        this.e.setChecked(this.p);
        this.e.setSelected(this.p);
        if ((i2 & 1) != 0) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()));
            layoutParams4.addRule(12);
            ImageView imageView = new ImageView(context);
            this.h = imageView;
            imageView.setLayoutParams(layoutParams4);
            this.h.setBackgroundColor(0);
            this.h.setScaleType(ImageView.ScaleType.FIT_XY);
            ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(-16729344), 3, 1);
            clipDrawable.setLevel(0);
            this.h.setImageDrawable(clipDrawable);
            addView(this.h);
        }
        if ((i2 & 2) != 0) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(12);
            layoutParams5.addRule(9);
            layoutParams5.leftMargin = 10;
            layoutParams5.bottomMargin = 10;
            TextView textView = new TextView(context);
            this.i = textView;
            textView.setLayoutParams(layoutParams5);
            this.i.setTextColor(-1);
            this.i.setTextSize(14.0f);
            this.a.addView(this.i);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(10);
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = 10;
        layoutParams6.topMargin = 10;
        TextView textView2 = new TextView(context);
        this.j = textView2;
        textView2.setLayoutParams(layoutParams6);
        this.j.setTextColor(-1);
        this.j.setTextSize(18.0f);
        this.a.addView(this.j);
        int iApplyDimension3 = (int) TypedValue.applyDimension(1, 40.0f, context.getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(iApplyDimension3, iApplyDimension3);
        ImageView imageView2 = new ImageView(context);
        this.f = imageView2;
        imageView2.setLayoutParams(layoutParams7);
        this.f.setOnClickListener(new g(context));
        this.a.addView(this.f);
        ImageView imageView3 = new ImageView(context);
        this.g = imageView3;
        imageView3.setOnClickListener(new h());
        this.g.setClickable(false);
        this.a.addView(this.g);
    }
}

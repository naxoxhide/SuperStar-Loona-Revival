package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.RatioFrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class VastBannerBackupView extends BackupView implements b.a.a.a.a.a.a.g.c.d, b.a.a.a.a.a.a.g.c.InterfaceC0008c {
    private NativeExpressView m;
    private b.c.a.a.a.a.c n;
    private NativeVideoTsView o;
    private ShadowImageView p;
    private String q;
    private long r;
    private PAGBannerAdWrapperListener s;

    class a implements NativeVideoTsView.h {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.h
        public void a(View view, int i) {
            if (VastBannerBackupView.this.s != null) {
                VastBannerBackupView.this.s.onAdClicked(view, i);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(((BackupView) VastBannerBackupView.this).a, ((BackupView) VastBannerBackupView.this).f646b, ((BackupView) VastBannerBackupView.this).e);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VastBannerBackupView.this.p();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VastBannerBackupView.this.o != null) {
                boolean z = !VastBannerBackupView.this.o.I();
                int iE = z ? t.e(VastBannerBackupView.this.getContext(), "tt_mute_wrapper") : t.e(VastBannerBackupView.this.getContext(), "tt_unmute_wrapper");
                VastBannerBackupView.this.o.setIsQuiet(z);
                VastBannerBackupView.this.p.setImageResource(iE);
                if (((BackupView) VastBannerBackupView.this).f646b == null || ((BackupView) VastBannerBackupView.this).f646b.M0() == null || ((BackupView) VastBannerBackupView.this).f646b.M0().m() == null) {
                    return;
                }
                if (z) {
                    ((BackupView) VastBannerBackupView.this).f646b.M0().m().e(VastBannerBackupView.this.r);
                } else {
                    ((BackupView) VastBannerBackupView.this).f646b.M0().m().i(VastBannerBackupView.this.r);
                }
            }
        }
    }

    private static class e {
        public FrameLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RatioFrameLayout f559b;
        public ShadowImageView c;
        public ShadowImageView d;
        public TTBackUpAdImageView e;
        public PAGImageView f;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public VastBannerBackupView(Context context) {
        super(context);
        this.a = context;
    }

    private void m() {
        m mVarB = BannerExpressBackupView.b(this.m.getExpectExpressWidth(), this.m.getExpectExpressHeight());
        if (this.m.getExpectExpressWidth() <= 0 || this.m.getExpectExpressHeight() <= 0) {
            int i = b0.i(this.a);
            this.f = i;
            this.g = Float.valueOf(i / mVarB.f658b).intValue();
        } else {
            this.f = b0.a(this.a, this.m.getExpectExpressWidth());
            this.g = b0.a(this.a, this.m.getExpectExpressHeight());
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
        o();
    }

    private e n() {
        e eVar = new e(null);
        eVar.a = new FrameLayout(this.a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        eVar.a.setLayoutParams(layoutParams);
        eVar.f559b = new RatioFrameLayout(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        eVar.f559b.setLayoutParams(layoutParams2);
        eVar.a.addView(eVar.f559b);
        int iA = b0.a(this.a, 20.0f);
        int iA2 = b0.a(this.a, 5.0f);
        eVar.c = new ShadowImageView(this.a);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA, iA);
        layoutParams3.setMargins(iA2, iA2, iA2, iA2);
        eVar.c.setScaleType(ImageView.ScaleType.CENTER);
        eVar.c.setImageDrawable(t.f(this.a, "tt_mute_wrapper"));
        eVar.c.setBackground(t.f(this.a, "tt_mute_btn_bg"));
        eVar.c.setLayoutParams(layoutParams3);
        eVar.a.addView(eVar.c);
        ShadowImageView shadowImageView = new ShadowImageView(this.a);
        eVar.d = shadowImageView;
        shadowImageView.setId(520093697);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iA, iA);
        layoutParams4.gravity = GravityCompat.END;
        int iA3 = b0.a(this.a, 7.0f);
        int iA4 = b0.a(this.a, 3.0f);
        layoutParams4.setMargins(iA3, iA3, iA3, iA3);
        eVar.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        eVar.d.setPadding(iA4, iA4, iA4, iA4);
        eVar.d.setImageDrawable(t.f(this.a, "tt_pangle_ad_close_drawable"));
        eVar.d.setBackground(t.f(this.a, "tt_mute_btn_bg"));
        eVar.d.setLayoutParams(layoutParams4);
        eVar.a.addView(eVar.d);
        eVar.e = new TTBackUpAdImageView(this.a);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 8388691;
        layoutParams5.setMargins(iA2, iA2, iA2, iA2);
        eVar.e.setLayoutParams(layoutParams5);
        eVar.a.addView(eVar.e);
        eVar.f = new PAGImageView(this.a);
        int iA5 = b0.a(this.a, 11.0f);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iA5, iA5);
        layoutParams6.gravity = 8388693;
        layoutParams6.rightMargin = iA2;
        layoutParams6.bottomMargin = iA2;
        eVar.f.setVisibility(8);
        eVar.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        eVar.f.setLayoutParams(layoutParams6);
        eVar.a.addView(eVar.f);
        return eVar;
    }

    private void o() {
        View view;
        q qVar = this.f646b;
        if (qVar != null) {
            int iC0 = qVar.c0();
            e eVarN = n();
            if (eVarN == null || (view = eVarN.a) == null) {
                return;
            }
            addView(view);
            ShadowImageView shadowImageView = eVarN.d;
            TTBackUpAdImageView tTBackUpAdImageView = eVarN.e;
            PAGImageView pAGImageView = eVarN.f;
            if (pAGImageView != null && this.f646b.d()) {
                b0.a((View) pAGImageView, 0);
                com.bytedance.sdk.openadsdk.n.c.b().a((int) b0.a(o.a(), 11.0f, true), pAGImageView, this.f646b);
            }
            this.p = eVarN.c;
            NativeVideoTsView videoView = getVideoView();
            if (videoView instanceof NativeVideoTsView) {
                this.o = videoView;
                videoView.setVideoAdLoadListener(this);
                this.o.setVideoAdInteractionListener(this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(shadowImageView, FriendlyObstructionPurpose.CLOSE_AD));
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                arrayList.add(new Pair(tTBackUpAdImageView, friendlyObstructionPurpose));
                arrayList.add(new Pair(pAGImageView, friendlyObstructionPurpose));
                arrayList.add(new Pair(this.p, FriendlyObstructionPurpose.VIDEO_CONTROLS));
                this.o.a(arrayList);
                this.o.setAdCreativeClickListener(new a());
            }
            if (tTBackUpAdImageView != null) {
                tTBackUpAdImageView.setOnClickListener(new b());
            }
            if (shadowImageView != null) {
                shadowImageView.setOnClickListener(new c());
                NativeExpressView nativeExpressView = this.m;
                if (nativeExpressView != null) {
                    if (nativeExpressView.getClickListener() != null) {
                        this.m.getClickListener().a(shadowImageView);
                    }
                    if (this.m.getClickCreativeListener() != null) {
                        this.m.getClickCreativeListener().a(shadowImageView);
                    }
                }
            }
            ShadowImageView shadowImageView2 = this.p;
            if (shadowImageView2 != null) {
                shadowImageView2.setOnClickListener(new d());
            }
            RatioFrameLayout ratioFrameLayout = eVarN.f559b;
            q qVar2 = this.f646b;
            if (qVar2 != null && qVar2.M0() != null && ratioFrameLayout != null) {
                int iO = this.f646b.M0().o();
                float fL = this.f646b.M0().l();
                if (iO > 0 && fL > 0.0f) {
                    ratioFrameLayout.setRatio(iO / fL);
                } else if (iC0 == 15) {
                    ratioFrameLayout.setRatio(0.5625f);
                } else if (iC0 == 5) {
                    ratioFrameLayout.setRatio(1.7777778f);
                } else {
                    ratioFrameLayout.setRatio(1.0f);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (videoView != null && ratioFrameLayout != null) {
                ratioFrameLayout.addView(videoView, layoutParams);
                videoView.setTag(520093762, Boolean.TRUE);
            }
            a((View) videoView, true);
            a((View) this, true);
            a(ratioFrameLayout);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void c() {
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void g() {
    }

    public long getVideoProgress() {
        return this.r;
    }

    @Override // b.a.a.a.a.a.a.g.c.d
    public void l() {
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void onVideoAdPaused() {
    }

    public void p() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.c;
        if (bVar != null) {
            bVar.a();
        } else {
            TTDelegateActivity.a(this.f646b, this.q);
        }
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.s = pAGBannerAdWrapperListener;
    }

    public void setClosedListenerKey(String str) {
        this.q = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(View view, int i, com.bytedance.sdk.openadsdk.core.f0.m mVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, mVar);
            NativeVideoTsView nativeVideoTsView = this.o;
            if (nativeVideoTsView == null || !(nativeVideoTsView.getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c)) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.o.getNativeVideoController()).K();
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void b() {
        ShadowImageView shadowImageView = this.p;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(8);
        }
    }

    public void a(q qVar, NativeExpressView nativeExpressView, b.c.a.a.a.a.c cVar) {
        setBackgroundColor(-16777216);
        this.f646b = qVar;
        this.m = nativeExpressView;
        this.n = cVar;
        this.e = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        m();
    }

    @Override // b.a.a.a.a.a.a.g.c.d
    public void a(int i, int i2) {
        ShadowImageView shadowImageView = this.p;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(8);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void a(long j, long j2) {
        this.r = j;
    }
}

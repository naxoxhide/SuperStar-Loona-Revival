package com.mbridge.msdk.nativex.view;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.iab.omid.library.mmadbridge.adsession.media.PlayerState;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.iab.omid.library.mmadbridge.adsession.media.VastProperties;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.nativex.view.mbfullview.BaseView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeFullView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeTopFullView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.out.OnMBMediaViewListener;
import com.mbridge.msdk.out.OnMBMediaViewListenerPlus;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import com.mbridge.msdk.video.signal.communication.IRewardCommunication;
import com.mbridge.msdk.videocommon.download.h;
import com.mbridge.msdk.videocommon.download.n;
import com.mbridge.msdk.videocommon.view.MyImageView;
import com.mbridge.msdk.widget.MBAdChoice;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBMediaView extends LinearLayout implements VideoPlayerStatusListener, IRewardCommunication {
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_1_LANDING_PAGE = 1;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_2_NORMAL_FULLSCREEN = 2;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_3_NORMAL_FULLSCREEN_ENDCARD = 3;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_4_NORMAL_FULLSCREEN_LP = 4;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_6_SMALLVIDEO = 6;
    public static final String TAG = "MBMediaView";
    public static final int WHAT_VIEW_FULL_SCREEN = 2;
    public static final int WHAT_VIEW_SMALL_SCREEN = 1;
    private static int o = 2;
    private static int p = 1;
    private WindVaneWebViewForNV A;
    private WindVaneWebViewForNV B;
    private MyImageView C;
    private ProgressBar D;
    private View E;
    private BaseView F;
    private RelativeLayout G;
    private RelativeLayout H;
    private TextView I;
    private ProgressBar J;
    private RelativeLayout K;
    private int L;
    private Handler M;
    private CampaignEx N;
    private int O;
    private int P;
    private double Q;
    private double R;
    private int S;
    private int T;
    private e U;
    private SensorManager V;
    private Sensor W;
    private boolean a;
    private com.mbridge.msdk.videocommon.download.a aa;
    private a ab;
    private OnMBMediaViewListener ac;
    private OnMBMediaViewListenerPlus ad;
    private int ae;
    private boolean af;
    private boolean ag;
    private RelativeLayout ah;
    private ImageView ai;
    private int aj;
    private boolean ak;
    private Context al;
    private boolean am;
    private Runnable an;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2339b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private ArrayList<String> m;
    private ArrayList<String> n;
    private boolean q;
    private boolean r;
    private AdSession s;
    private AdEvents t;
    private MediaEvents u;
    private int v;
    private MediaViewPlayerView w;
    private RelativeLayout x;
    private RelativeLayout y;
    private RelativeLayout z;

    private enum a {
        BIG_IMAGE,
        VIDEO,
        GIF
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i, int i2) {
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void setOrientation(Object obj, String str) {
    }

    public MBMediaView(Context context) {
        super(context);
        this.a = true;
        this.f2339b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.aa = null;
        this.ab = null;
        this.af = false;
        this.ag = false;
        this.ak = false;
        this.am = false;
        this.an = new Runnable() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (!MBMediaView.this.h) {
                        MBMediaView mBMediaView = MBMediaView.this;
                        if (!mBMediaView.a((View) mBMediaView)) {
                            MBMediaView.S(MBMediaView.this);
                        } else {
                            MBMediaView.T(MBMediaView.this);
                        }
                    }
                    MBMediaView.this.M.postDelayed(this, 300L);
                } catch (Exception e2) {
                    aa.d(MBMediaView.TAG, e2.getMessage());
                }
            }
        };
        a(context);
    }

    public MBMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.f2339b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.aa = null;
        this.ab = null;
        this.af = false;
        this.ag = false;
        this.ak = false;
        this.am = false;
        this.an = new Runnable() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (!MBMediaView.this.h) {
                        MBMediaView mBMediaView = MBMediaView.this;
                        if (!mBMediaView.a((View) mBMediaView)) {
                            MBMediaView.S(MBMediaView.this);
                        } else {
                            MBMediaView.T(MBMediaView.this);
                        }
                    }
                    MBMediaView.this.M.postDelayed(this, 300L);
                } catch (Exception e2) {
                    aa.d(MBMediaView.TAG, e2.getMessage());
                }
            }
        };
        a(context);
    }

    private void a(Context context) {
        try {
            c();
            b();
            this.al = context;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private void a() {
        com.mbridge.msdk.videocommon.download.a aVar = this.aa;
        if (aVar != null) {
            aVar.b((com.mbridge.msdk.videocommon.listener.a) null);
        }
    }

    private void b() {
        int iA = t.a(getContext(), "mbridge_nativex_mbmediaview", "layout");
        if (iA == -1) {
            aa.d(TAG, "can not find mediaview resource");
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(iA, (ViewGroup) null);
        this.y = (RelativeLayout) viewInflate.findViewById(t.a(getContext(), "mbridge_rl_mediaview_root", "id"));
        this.x = (RelativeLayout) viewInflate.findViewById(t.a(getContext(), "mbridge_ll_playerview_container", "id"));
        this.C = (MyImageView) viewInflate.findViewById(t.a(getContext(), "mbridge_my_big_img", "id"));
        this.D = (ProgressBar) viewInflate.findViewById(t.a(getContext(), "mbridge_native_pb", "id"));
        this.z = (RelativeLayout) viewInflate.findViewById(t.a(getContext(), "mbridge_nativex_webview_layout", "id"));
        this.A = (WindVaneWebViewForNV) viewInflate.findViewById(t.a(getContext(), "mbridge_nativex_webview_layout_webview", "id"));
        this.y.setClickable(true);
        addView(viewInflate, -1, -1);
    }

    private void c() {
        this.M = new Handler() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                Object obj;
                if (message != null) {
                    try {
                        int i = message.what;
                        if (i == 1) {
                            MBMediaView.this.q();
                        } else if (i == 3 && (obj = message.obj) != null && (obj instanceof View)) {
                            if (MBMediaView.this.a((View) obj)) {
                                MBMediaView.b(MBMediaView.this);
                            }
                        }
                    } catch (Exception e2) {
                        aa.d(MBMediaView.TAG, e2.getMessage());
                    }
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.c) {
                try {
                    SensorManager sensorManager = (SensorManager) getContext().getSystemService("sensor");
                    this.V = sensorManager;
                    this.W = sensorManager.getDefaultSensor(1);
                    e eVar = new e();
                    this.U = eVar;
                    this.V.registerListener(eVar, this.W, 2);
                } catch (Throwable th) {
                    aa.d(TAG, th.getMessage());
                }
            }
            if (Build.VERSION.SDK_INT >= 11) {
                this.g = isHardwareAccelerated();
            }
            this.aj = getOrientation();
            d();
            this.M.postDelayed(this.an, 300L);
        } catch (Throwable th2) {
            aa.d(TAG, th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        e eVar;
        super.onDetachedFromWindow();
        try {
            if (this.s != null) {
                MediaViewPlayerView mediaViewPlayerView = this.w;
                if (mediaViewPlayerView != null) {
                    mediaViewPlayerView.unregisterView();
                }
                this.s.finish();
                this.s = null;
            }
            if (this.u != null) {
                this.u = null;
            }
            if (this.t != null) {
                this.t = null;
            }
            this.M.removeCallbacks(this.an);
            Handler handler = this.M;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            try {
                SensorManager sensorManager = this.V;
                if (sensorManager != null && (eVar = this.U) != null) {
                    sensorManager.unregisterListener(eVar);
                }
            } catch (Throwable th) {
                aa.d(TAG, th.getMessage());
            }
            a();
        } catch (Throwable th2) {
            aa.d(TAG, th2.getMessage());
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        MediaViewPlayerView mediaViewPlayerView;
        super.onWindowFocusChanged(z);
        try {
            this.e = z;
            if (this.ab == a.VIDEO && (mediaViewPlayerView = this.w) != null) {
                mediaViewPlayerView.setIsFrontDesk(z);
            }
            try {
                if (this.h) {
                    MediaViewPlayerView mediaViewPlayerView2 = this.w;
                    if (mediaViewPlayerView2 != null) {
                        if (this.e) {
                            if (mediaViewPlayerView2.isPlaying()) {
                                aa.b(TAG, "fullscreen windowfocuse true isPlaying do nothing return");
                            } else {
                                MediaViewPlayerView mediaViewPlayerView3 = this.w;
                                if (mediaViewPlayerView3 != null && !mediaViewPlayerView3.isComplete() && !this.w.getIsActiviePause()) {
                                    this.w.onClickPlayButton();
                                }
                            }
                        } else {
                            mediaViewPlayerView2.pause();
                        }
                    } else {
                        aa.d(TAG, "fullscreen playerview is null return");
                    }
                }
            } catch (Throwable th) {
                aa.d(TAG, th.getMessage());
            }
            requestLayout();
        } catch (Throwable th2) {
            aa.d(TAG, th2.getMessage());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        try {
            this.O = getHeight();
            int width = getWidth();
            this.P = width;
            if (width == 0) {
                this.P = getMeasuredWidth();
            }
            if (this.O == 0) {
                this.O = getMeasuredHeight();
            }
            if (this.P == 0 && this.O == 0) {
                this.P = (int) A();
            }
            if (this.ab == a.VIDEO && !this.h) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (this.O == 0 || ((layoutParams != null && layoutParams.height == -2) || (layoutParams != null && layoutParams.height == -1))) {
                    this.O = (int) ((((double) this.P) * this.R) / this.Q);
                }
                h();
                return;
            }
            if (this.ab == a.BIG_IMAGE && !this.h) {
                f();
            } else {
                if (this.ab != a.GIF || this.h) {
                    return;
                }
                g();
            }
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    public void setNativeAd(Campaign campaign) {
        String str;
        if (campaign == null) {
            return;
        }
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx == null || campaignEx != campaign) {
                this.e = true;
                this.g = true;
                this.h = false;
                this.i = false;
                this.j = false;
                this.r = false;
                y();
                CampaignEx campaignEx2 = (CampaignEx) campaign;
                this.N = campaignEx2;
                if (campaignEx2.getMediaViewHolder() == null) {
                    CampaignEx.b bVar = new CampaignEx.b();
                    bVar.l = this.N.getAdvImpList();
                    this.N.setMediaViewHolder(bVar);
                }
                if (this.N.getAdType() == 94 || this.N.getAdType() == 287) {
                    str = this.N.getRequestId() + this.N.getId() + this.N.getVideoUrlEncode();
                } else {
                    str = this.N.getId() + this.N.getVideoUrlEncode() + this.N.getBidToken();
                }
                this.aa = com.mbridge.msdk.videocommon.download.c.getInstance().a(o(), str);
                if (this.q) {
                    if (this.s != null) {
                        MediaViewPlayerView mediaViewPlayerView = this.w;
                        if (mediaViewPlayerView != null) {
                            mediaViewPlayerView.unregisterView();
                        }
                        this.s.finish();
                        this.s = null;
                    }
                    if (this.u != null) {
                        this.u = null;
                    }
                    if (this.t != null) {
                        this.t = null;
                    }
                }
                CampaignEx campaignEx3 = this.N;
                if (campaignEx3 != null && campaignEx3.isActiveOm()) {
                    this.s = com.mbridge.msdk.a.b.a(getContext(), TextUtils.isEmpty(this.N.getVideoUrlEncode()), this.N.getOmid(), this.N.getRequestId(), this.N.getId(), o(), "", this.N.getRequestIdNotice());
                }
                if (this.q) {
                    d();
                }
            }
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    public void setOnMediaViewListener(OnMBMediaViewListener onMBMediaViewListener) {
        this.ac = onMBMediaViewListener;
    }

    public void setOnMediaViewListener(OnMBMediaViewListenerPlus onMBMediaViewListenerPlus) {
        this.ad = onMBMediaViewListenerPlus;
    }

    public void setIsAllowFullScreen(boolean z) {
        this.d = z;
    }

    public void setAllowVideoRefresh(boolean z) {
        this.a = z;
    }

    public void setAllowLoopPlay(boolean z) {
        this.f2339b = z;
    }

    public void setAllowScreenChange(boolean z) {
        this.c = z;
    }

    public void destory() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.w;
            if (mediaViewPlayerView != null) {
                mediaViewPlayerView.release();
            }
            a();
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private void d() {
        AdSession adSession;
        try {
            this.ab = a(true);
            changeNoticeURL();
            if (this.ab == a.BIG_IMAGE) {
                CampaignEx campaignEx = this.N;
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) && (adSession = this.s) != null) {
                    try {
                        adSession.registerAdView(this.C);
                        this.t = AdEvents.createAdEvents(this.s);
                        this.s.start();
                        AdEvents adEvents = this.t;
                        if (adEvents != null) {
                            adEvents.impressionOccurred();
                        }
                    } catch (Exception e2) {
                        aa.a("omsdk", e2.getMessage());
                    }
                }
                j();
                m();
            } else if (this.ab == a.VIDEO) {
                e();
            } else if (this.ab == a.GIF) {
                n();
                l();
            }
            this.q = true;
        } catch (Throwable th) {
            aa.b(TAG, th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        z();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i;
        int i2;
        int i3;
        try {
            if (this.ab != a.BIG_IMAGE || (i = this.P) == 0 || (i2 = this.T) == 0 || (i3 = this.S) == 0) {
                return;
            }
            int i4 = (i * i2) / i3;
            MyImageView myImageView = this.C;
            if (myImageView == null || i4 == 0) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) myImageView.getLayoutParams();
            layoutParams.width = this.P;
            layoutParams.height = i4;
            this.C.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        RelativeLayout relativeLayout;
        int i;
        int i2;
        try {
            if (this.ab == a.GIF) {
                int i3 = this.P;
                if (i3 != 0 && (i = this.T) != 0 && (i2 = this.S) != 0) {
                    int i4 = (i3 * i) / i2;
                    RelativeLayout relativeLayout2 = this.z;
                    if (relativeLayout2 != null && i4 != 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
                        layoutParams.width = this.P;
                        layoutParams.height = i4;
                        layoutParams.addRule(13);
                        this.z.setLayoutParams(layoutParams);
                    }
                } else if (i3 != 0 && (relativeLayout = this.z) != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams2.width = this.P;
                    layoutParams2.height = (this.P * 627) / 1200;
                    layoutParams2.addRule(13);
                    this.z.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            if (this.ab != a.VIDEO || this.x == null) {
                return;
            }
            int iA = (int) A();
            int iK = af.k(getContext());
            if (!this.h) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams.width = this.P;
                layoutParams.height = this.O;
                layoutParams.addRule(13);
                this.x.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                layoutParams2.width = iA;
                layoutParams2.height = iK;
                layoutParams2.addRule(13);
                this.G.setLayoutParams(layoutParams2);
            }
            q();
            if (!this.h) {
                a(this.w, this.P, this.O);
            } else {
                a(this.w, iA, iK);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    private void i() {
        try {
            this.w.showSoundIndicator(this.l);
            this.w.showProgressView(this.k);
            OnMBMediaViewListener onMBMediaViewListener = this.ac;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onExitFullscreen();
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.ad;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onExitFullscreen();
            }
            MediaEvents mediaEvents = this.u;
            if (mediaEvents != null) {
                mediaEvents.playerStateChange(PlayerState.NORMAL);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    protected final void a(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.m.contains(str)) {
                return;
            }
            this.m.add(str);
            OnMBMediaViewListener onMBMediaViewListener = this.ac;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onVideoStart();
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.ad;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onVideoStart();
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    protected final void b(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.n.contains(str)) {
                return;
            }
            this.n.add(str);
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.ad;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onVideoComplete();
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    private void j() {
        try {
            af.a((ImageView) this.C);
            this.C.setVisibility(0);
            this.x.setVisibility(8);
            this.z.setVisibility(8);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private void k() {
        try {
            this.x.setVisibility(0);
            this.C.setVisibility(8);
            this.z.setVisibility(8);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            this.x.setVisibility(8);
            this.C.setVisibility(8);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private void m() {
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx == null) {
                return;
            }
            String imageUrl = campaignEx.getImageUrl();
            if (ak.a(imageUrl) || getContext() == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(imageUrl, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.12
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (MBMediaView.this.C == null || MBMediaView.this.ab != a.BIG_IMAGE) {
                        return;
                    }
                    if (bitmap != null) {
                        MBMediaView.this.S = bitmap.getWidth();
                        MBMediaView.this.T = bitmap.getHeight();
                        MBMediaView.this.C.setImageUrl(str);
                        MBMediaView.this.C.setImageBitmap(bitmap);
                    }
                    MBMediaView.this.C.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.12.1
                        @Override // com.mbridge.msdk.widget.a
                        protected final void a(View view) {
                            if (MBMediaView.this.al != null) {
                                MBMediaView.this.b(MBMediaView.this.al);
                            } else {
                                MBMediaView.this.b(view.getContext());
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private void n() {
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx == null) {
                return;
            }
            String gifUrl = campaignEx.getGifUrl();
            if (ak.a(gifUrl) || getContext() == null) {
                return;
            }
            this.A.loadDataWithBaseURL(null, "<!DOCTYPE html><html lang=\"en\"><head>  <meta charset=\"UTF-8\">  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">  <title>Document</title>  <style>  *{    margin: 0;    padding: 0;  }  html, body{    width: 100%;    height: 100%;  }  body{    background-image: url('gifUrl');    background-position: center;    background-size: contain;    background-repeat: no-repeat;  }  </style></head><body></body></html>".replace("gifUrl", gifUrl), "text/html", "utf-8", null);
            this.A.setInterceptTouch(true);
            this.z.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.13
                @Override // com.mbridge.msdk.widget.a
                protected final void a(View view) {
                    if (MBMediaView.this.al == null) {
                        MBMediaView.this.b(view.getContext());
                    } else {
                        MBMediaView mBMediaView = MBMediaView.this;
                        mBMediaView.b(mBMediaView.al);
                    }
                    aa.b(MBMediaView.TAG, "CLICK WEBVIEW LAYOUT ");
                }
            });
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o() {
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx == null || !ak.b(campaignEx.getCampaignUnitId())) {
                return null;
            }
            return this.N.getCampaignUnitId();
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
            return null;
        }
    }

    private a a(boolean z) {
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx == null) {
                return null;
            }
            if (ak.a(campaignEx.getVideoUrlEncode())) {
                a aVar = ak.b(this.N.getImageUrl()) ? a.BIG_IMAGE : null;
                if (!ak.b(this.N.getGifUrl())) {
                    return aVar;
                }
                if (ak.a(this.N.getImageUrl())) {
                    aVar = a.GIF;
                }
                this.A.setWebViewClient(new g(this));
                n();
                return aVar;
            }
            if (Build.VERSION.SDK_INT >= 14 && this.g && this.aa != null) {
                if (ak.b(this.N.getVideoUrlEncode()) && ak.a(this.N.getImageUrl())) {
                    return a.VIDEO;
                }
                if (!ak.b(this.N.getVideoUrlEncode()) || !ak.b(this.N.getImageUrl())) {
                    return null;
                }
                if (n.a(this.aa, s())) {
                    return a.VIDEO;
                }
                a aVar2 = a.BIG_IMAGE;
                if (!z || !this.a) {
                    return aVar2;
                }
                this.aa.b(new f(this));
                return aVar2;
            }
            return a.BIG_IMAGE;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return a.BIG_IMAGE;
        }
    }

    private void p() {
        try {
            if (this.N == null) {
                aa.b(TAG, "campaign is null addPlayerView return");
            }
            MediaViewPlayerView mediaViewPlayerView = this.w;
            if (mediaViewPlayerView != null && mediaViewPlayerView.getParent() != null) {
                ((ViewGroup) this.w.getParent()).removeView(this.w);
            }
            k();
            MediaViewPlayerView mediaViewPlayerView2 = new MediaViewPlayerView(getContext());
            this.w = mediaViewPlayerView2;
            mediaViewPlayerView2.showProgressView(this.k);
            this.w.showSoundIndicator(this.l);
            if (this.f) {
                this.w.openSound();
            } else {
                this.w.closeSound();
            }
            this.w.setAllowLoopPlay(this.f2339b);
            this.w.initPlayerViewData(r(), this.N, u(), this, this.aa, o());
            this.w.setOnMediaViewPlayerViewListener(new c(this));
            this.x.addView(this.w, -1, -1);
            try {
                MediaViewPlayerView mediaViewPlayerView3 = this.w;
                if (mediaViewPlayerView3 != null) {
                    mediaViewPlayerView3.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.11
                        @Override // com.mbridge.msdk.widget.a
                        protected final void a(View view) {
                            try {
                                if (!MBMediaView.this.h) {
                                    MBMediaView.d(MBMediaView.this);
                                }
                                MBMediaView.this.w.showSoundIndicator(true);
                                MBMediaView.this.w.showProgressView(true);
                                if (!MBMediaView.this.d || MBMediaView.this.h || (MBMediaView.this.E != null && MBMediaView.this.E.getParent() != null)) {
                                    if (!MBMediaView.this.h) {
                                        if (MBMediaView.this.al == null) {
                                            MBMediaView.this.b(view.getContext());
                                        } else {
                                            MBMediaView mBMediaView = MBMediaView.this;
                                            mBMediaView.b(mBMediaView.al);
                                        }
                                        if (MBMediaView.this.u != null) {
                                            MBMediaView.this.u.adUserInteraction(InteractionType.CLICK);
                                            return;
                                        }
                                        return;
                                    }
                                    aa.b(MBMediaView.TAG, "fullScreenShowUI");
                                    MBMediaView.i(MBMediaView.this);
                                    return;
                                }
                                if (!MBMediaView.this.w.halfLoadingViewisVisible() && MBMediaView.this.w.isPlaying()) {
                                    MBMediaView.h(MBMediaView.this);
                                    return;
                                }
                                aa.b(MBMediaView.TAG, "is loading or no playing return;");
                            } catch (Throwable th) {
                                aa.b(MBMediaView.TAG, th.getMessage(), th);
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                aa.d(TAG, th.getMessage());
            }
            AdSession adSession = this.s;
            if (adSession != null) {
                MediaViewPlayerView mediaViewPlayerView4 = this.w;
                if (mediaViewPlayerView4 != null) {
                    mediaViewPlayerView4.registerView(adSession);
                }
                this.t = AdEvents.createAdEvents(this.s);
                this.u = MediaEvents.createMediaEvents(this.s);
                this.s.start();
                this.t.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
                this.w.setVideoEvents(this.u);
                try {
                    AdEvents adEvents = this.t;
                    if (adEvents != null) {
                        adEvents.impressionOccurred();
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    aa.a("omsdk", e2.getMessage());
                    return;
                }
                aa.d(TAG, th.getMessage());
            }
        } catch (Throwable th2) {
            aa.d(TAG, th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            if (getVisibility() != 0) {
                return;
            }
            if (a((View) this)) {
                com.mbridge.msdk.c.f fVarT = t();
                int i = 0;
                int iE = fVarT != null ? fVarT.e() : 0;
                CampaignEx campaignEx = this.N;
                if (campaignEx == null || campaignEx.getImpReportType() != 1) {
                    i = iE;
                }
                Message messageObtainMessage = this.M.obtainMessage();
                messageObtainMessage.what = 3;
                messageObtainMessage.obj = this;
                this.M.sendMessageDelayed(messageObtainMessage, (i == 0 ? 0L : ((long) i) * 1000) + 300);
            }
            if (this.ab == a.VIDEO) {
                MediaViewPlayerView mediaViewPlayerView = this.w;
                if (mediaViewPlayerView == null) {
                    p();
                    return;
                }
                if (this.N != mediaViewPlayerView.getCampaign()) {
                    this.w.release();
                    p();
                    if (getParent() != null) {
                        ((View) getParent()).invalidate();
                    }
                    requestLayout();
                }
            }
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private String r() {
        try {
            if (this.N == null) {
                return null;
            }
            com.mbridge.msdk.videocommon.download.a aVar = this.aa;
            if (aVar != null && aVar.j() == 5) {
                String strH = this.aa.h();
                if (new File(strH).exists() && this.aa.i() == af.a(new File(strH))) {
                    return strH;
                }
            }
            String videoUrlEncode = this.N.getVideoUrlEncode();
            if (ak.b(videoUrlEncode)) {
                return videoUrlEncode;
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        try {
            CampaignEx campaignEx = this.N;
            return !an.a(view, campaignEx == null ? 0 : campaignEx.getImpReportType());
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return false;
        }
    }

    private int s() {
        if (t() != null) {
            return t().f();
        }
        return 100;
    }

    private com.mbridge.msdk.c.f t() {
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx != null && !ak.a(campaignEx.getCampaignUnitId())) {
                String campaignUnitId = this.N.getCampaignUnitId();
                String strH = com.mbridge.msdk.foundation.controller.b.d().h();
                if (!ak.a(campaignUnitId) && !ak.a(strH)) {
                    com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e(strH, campaignUnitId);
                    return fVarE != null ? fVarE : com.mbridge.msdk.c.f.d(campaignUnitId);
                }
                return com.mbridge.msdk.c.f.d(campaignUnitId);
            }
            return null;
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
            return null;
        }
    }

    private boolean u() {
        try {
            com.mbridge.msdk.c.f fVarT = t();
            if (fVarT == null) {
                return false;
            }
            int iJ = fVarT.j();
            if (iJ == 1) {
                return af.b(getContext());
            }
            if (iJ == 2) {
                return false;
            }
            if (iJ == 3) {
                return af.c(getContext());
            }
            return af.b(getContext());
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i) {
        MediaEvents mediaEvents = this.u;
        if (mediaEvents != null) {
            try {
                mediaEvents.start(i, this.f ? 1.0f : 0.0f);
            } catch (IllegalArgumentException e2) {
                aa.a("omsdk", e2.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        MediaEvents mediaEvents = this.u;
        if (mediaEvents != null) {
            mediaEvents.complete();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(final String str) {
        try {
            aa.b("error", str);
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.15
                @Override // java.lang.Runnable
                public final void run() {
                    MBMediaView.r(MBMediaView.this);
                    MBMediaView.a(MBMediaView.this, str);
                    NativeController.insertExcludeId(MBMediaView.this.N.getCampaignUnitId(), MBMediaView.this.N);
                }
            };
            com.mbridge.msdk.foundation.controller.c.a();
            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
        aa.b("bufferMsg", str);
        MediaEvents mediaEvents = this.u;
        if (mediaEvents != null) {
            mediaEvents.bufferStart();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
        aa.b("bufferend", "bufferend");
        MediaEvents mediaEvents = this.u;
        if (mediaEvents != null) {
            mediaEvents.bufferFinish();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
        aa.b("errorstr", str);
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.nativex.view.MBMediaView$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BaseView.a.values().length];
            a = iArr;
            try {
                iArr[BaseView.a.FULL_MIDDLE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BaseView.a.FULL_TOP_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View v() {
        try {
            this.ah = new RelativeLayout(getContext());
            this.ah.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ImageView imageView = new ImageView(getContext());
            this.ai = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.b(getContext(), 30.0f), af.b(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = af.b(getContext(), 8.0f);
            layoutParams.rightMargin = af.b(getContext(), 8.0f);
            this.ai.setLayoutParams(layoutParams);
            this.ai.setBackgroundResource(t.a(getContext(), "mbridge_nativex_close", "drawable"));
            this.ai.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBMediaView.this.exitFullScreen();
                }
            });
            this.B.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.ah.addView(this.B);
            this.ah.addView(this.ai);
            return this.ah;
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
            return null;
        }
    }

    public void exitFullScreen() {
        try {
            w();
            if (this.f2339b) {
                this.w.onClickPlayButton();
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    public void showEndCardWebViewCloseBtn() {
        ImageView imageView = this.ai;
        if (imageView == null || imageView.getVisibility() == 0) {
            return;
        }
        this.ai.setVisibility(0);
    }

    public void hideEndCardWebViewCloseBtn() {
        ImageView imageView = this.ai;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.ai.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.content);
            FrameLayout frameLayout2 = (FrameLayout) getRootView().findViewById(100);
            RelativeLayout relativeLayout = (RelativeLayout) getRootView().findViewById(101);
            RelativeLayout relativeLayout2 = (RelativeLayout) getRootView().findViewById(103);
            if (relativeLayout2 == null && relativeLayout != null) {
                relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(103);
            }
            RelativeLayout relativeLayout3 = (RelativeLayout) getRootView().findViewById(t.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            if (relativeLayout3 == null && relativeLayout2 != null) {
                relativeLayout3 = (RelativeLayout) relativeLayout2.findViewById(t.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            }
            RelativeLayout relativeLayout4 = (RelativeLayout) getRootView().findViewById(t.a(getContext(), "mbridge_full_player_parent", "id"));
            if (relativeLayout4 == null && relativeLayout3 != null) {
                relativeLayout4 = (RelativeLayout) relativeLayout3.findViewById(t.a(getContext(), "mbridge_full_player_parent", "id"));
            }
            ProgressBar progressBar = (ProgressBar) getRootView().findViewById(t.a(getContext(), "mbridge_full_pb_loading", "id"));
            RelativeLayout relativeLayout5 = (RelativeLayout) getRootView().findViewById(t.a(getContext(), "mbridge_full_rl_install", "id"));
            LinearLayout linearLayout = (LinearLayout) getRootView().findViewById(t.a(getContext(), "mbridge_full_ll_pro_dur", "id"));
            ViewGroup viewGroup = frameLayout2 != null ? (ViewGroup) frameLayout2.getParent() : null;
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(linearLayout);
            } else if (linearLayout != null && linearLayout.getParent() != null) {
                ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
            }
            RelativeLayout relativeLayout6 = this.ah;
            if (relativeLayout6 != null) {
                if (relativeLayout2 != null) {
                    relativeLayout2.removeView(relativeLayout6);
                } else if (relativeLayout6.getParent() != null) {
                    ((ViewGroup) this.ah.getParent()).removeView(this.ah);
                }
                this.B.setBackListener(null);
                this.B.setObject(null);
                this.B = null;
                this.ah = null;
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(relativeLayout5);
            } else if (relativeLayout5 != null && relativeLayout5.getParent() != null) {
                ((ViewGroup) relativeLayout5.getParent()).removeView(relativeLayout5);
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(progressBar);
            } else if (progressBar != null && progressBar.getParent() != null) {
                ((ViewGroup) progressBar.getParent()).removeView(progressBar);
            }
            if (relativeLayout4 != null) {
                relativeLayout4.removeView(this.w);
            }
            if (relativeLayout3 != null) {
                relativeLayout3.removeView(relativeLayout4);
            } else if (relativeLayout4 != null && relativeLayout4.getParent() != null) {
                ((ViewGroup) relativeLayout4.getParent()).removeView(relativeLayout4);
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(relativeLayout3);
            } else if (relativeLayout3 != null && relativeLayout3.getParent() != null) {
                ((ViewGroup) relativeLayout3.getParent()).removeView(relativeLayout3);
            } else {
                BaseView baseView = this.F;
                if (baseView != null) {
                    baseView.removeView(this.G);
                }
            }
            if (relativeLayout != null) {
                relativeLayout.removeView(relativeLayout2);
            } else if (relativeLayout2 != null && relativeLayout2.getParent() != null) {
                ((ViewGroup) relativeLayout2.getParent()).removeView(relativeLayout2);
            } else {
                View view = this.E;
                if (view != null) {
                    ((ViewGroup) view).removeView(this.F);
                    ((ViewGroup) this.E.getParent()).removeView(this.E);
                }
            }
            if (frameLayout != null) {
                if (relativeLayout != null) {
                    frameLayout.removeView(relativeLayout);
                } else {
                    frameLayout.removeView(this.E);
                    if (this.E.getParent() != null) {
                        ((ViewGroup) this.E.getParent()).removeView(this.E);
                        this.E.setVisibility(8);
                    }
                }
            }
            setVisibility(0);
            requestLayout();
            if (viewGroup != null) {
                if (this.w.getParent() != null && this.w.getParent() != viewGroup) {
                    ((ViewGroup) this.w.getParent()).removeView(this.w);
                }
                viewGroup.addView(this.w, this.L);
                viewGroup.removeView(frameLayout2);
                viewGroup.invalidate();
            }
            i();
            this.h = false;
            MediaViewPlayerView mediaViewPlayerView = this.w;
            if (mediaViewPlayerView != null) {
                mediaViewPlayerView.setExitFullScreen();
                if (this.f) {
                    this.w.openSound();
                } else {
                    this.w.closeSound();
                }
                this.w.gonePauseView();
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    private boolean x() {
        try {
            this.G = this.F.getMBridgeFullPlayContainer();
            this.K = this.F.getMBridgeFullPlayerParent();
            this.H = this.F.getMBridgeFullClose();
            this.I = this.F.getMBridgeFullTvInstall();
            this.J = this.F.getMBridgeFullPb();
            return true;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return false;
        }
    }

    private void y() {
        try {
            this.i = af.j(getContext()) >= af.k(getContext());
            this.j = this.i;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private void z() {
        String[] strArrSplit;
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx == null || ak.a(campaignEx.getVideoResolution()) || (strArrSplit = this.N.getVideoResolution().split("x")) == null || strArrSplit.length != 2) {
                return;
            }
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            double dC = af.c(str);
            double dC2 = af.c(str2);
            if (dC <= 0.0d || dC2 <= 0.0d) {
                return;
            }
            this.Q = dC;
            this.R = dC2;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float A() {
        try {
            float fJ = af.j(getContext());
            return this.i ? fJ + af.l(getContext()) : fJ;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return 0.0f;
        }
    }

    private float B() {
        try {
            float fK = af.k(getContext());
            return !this.i ? fK + af.l(getContext()) : fK;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return 0.0f;
        }
    }

    private boolean c(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private void a(View view, float f2, float f3) {
        if (view == null) {
            return;
        }
        try {
            double d2 = this.Q;
            double d3 = 0.0d;
            if (d2 > 0.0d) {
                double d4 = this.R;
                if (d4 > 0.0d) {
                    double d5 = d2 / d4;
                    if (f2 > 0.0f && f3 > 0.0f) {
                        d3 = f2 / f3;
                    }
                    double dA = af.a(Double.valueOf(d5));
                    double dA2 = af.a(Double.valueOf(d3));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    boolean z = c(getContext()) && this.i;
                    int i = -1;
                    if (dA > dA2) {
                        double d6 = (((double) f2) * this.R) / this.Q;
                        layoutParams2.width = -1;
                        if (!z) {
                            i = (int) d6;
                        }
                        layoutParams2.height = i;
                        layoutParams2.addRule(13);
                        layoutParams.width = this.P;
                        layoutParams.height = (int) d6;
                        layoutParams.addRule(13);
                    } else if (dA < dA2) {
                        double d7 = ((double) f3) * d5;
                        layoutParams2.width = z ? -1 : (int) d7;
                        layoutParams2.height = -1;
                        layoutParams2.addRule(13);
                        layoutParams.width = (int) d7;
                        layoutParams.height = this.O;
                        layoutParams.addRule(13);
                    } else {
                        layoutParams2.width = -1;
                        layoutParams2.height = -1;
                        layoutParams.width = this.P;
                        layoutParams.height = this.O;
                        layoutParams.addRule(13);
                    }
                    if (!this.h) {
                        this.x.setLayoutParams(layoutParams);
                    }
                    view.setLayoutParams(layoutParams2);
                    return;
                }
            }
            b(view);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            if (this.i) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = (((int) A()) * 9) / 16;
                layoutParams.addRule(13);
            }
            view.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        try {
            if (this.H == null && this.ai == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.b(getContext(), 30.0f), af.b(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = af.b(getContext(), 8.0f);
            layoutParams.rightMargin = af.b(getContext(), 8.0f);
            RelativeLayout relativeLayout = this.H;
            if (relativeLayout != null) {
                relativeLayout.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.ai;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            updateViewManger(false);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        try {
            if (this.H == null && this.ai == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.b(getContext(), 30.0f), af.b(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            if (this.ae == 0 && af.a(getContext())) {
                layoutParams.rightMargin = af.l(getContext()) + af.b(getContext(), 8.0f);
            } else {
                layoutParams.rightMargin = af.b(getContext(), 8.0f);
            }
            layoutParams.topMargin = af.b(getContext(), 8.0f);
            RelativeLayout relativeLayout = this.H;
            if (relativeLayout != null) {
                relativeLayout.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.ai;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            updateViewManger(true);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    public void updateViewManger(boolean z) {
        com.mbridge.msdk.nativex.view.mbfullview.a aVarA = com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext());
        boolean z2 = true;
        int i = 0;
        if (aVarA != null) {
            try {
                this.F.getmAnimationPlayer().clearAnimation();
                aVarA.a(z, !this.w.isComplete(), this.F);
                aVarA.a(z, this.F, this.ae);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                return;
            }
        }
        BaseView baseView = this.F;
        if (!(baseView instanceof MBridgeTopFullView) || aVarA == null) {
            return;
        }
        if (z) {
            z2 = false;
        }
        if (baseView instanceof MBridgeTopFullView) {
            MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
            if (!z2) {
                i = 8;
            }
            mBridgeTopFullView.getMBridgeFullViewDisplayIcon().setVisibility(i);
            mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setVisibility(i);
            mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setVisibility(i);
            mBridgeTopFullView.getStarLevelLayoutView().setVisibility(i);
        }
    }

    private void E() {
        int i;
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx == null || campaignEx.getNativeVideoTracking() == null) {
                return;
            }
            String[] strArrC = this.N.getNativeVideoTracking().c();
            if (this.i) {
                i = o;
            } else {
                i = p;
            }
            for (String str : strArrC) {
                if (!TextUtils.isEmpty(str)) {
                    Context context = getContext();
                    CampaignEx campaignEx2 = this.N;
                    com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), str + "&orienation=" + i, false, false);
                }
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    public void changeNoticeURL() {
        String str;
        CampaignEx campaignEx = this.N;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (noticeUrl.contains("is_video")) {
                if (this.ab == a.VIDEO) {
                    if (noticeUrl.contains("is_video=2")) {
                        noticeUrl = noticeUrl.replace("is_video=2", "is_video=1");
                    }
                } else if (this.ab == a.BIG_IMAGE && noticeUrl.contains("is_video=1")) {
                    noticeUrl = noticeUrl.replace("is_video=1", "is_video=2");
                }
            } else {
                if (this.ab == a.VIDEO) {
                    str = "1";
                } else {
                    str = this.ab == a.BIG_IMAGE ? "2" : "";
                }
                StringBuilder sb = new StringBuilder(noticeUrl);
                if (noticeUrl.contains("?")) {
                    sb.append("&is_video=").append(str);
                } else {
                    sb.append("?is_video=").append(str);
                }
                noticeUrl = sb.toString();
            }
            this.N.setNoticeUrl(noticeUrl);
        }
    }

    public String getAddNVT2ToNoticeURL() {
        CampaignEx campaignEx = this.N;
        if (campaignEx == null) {
            return null;
        }
        String noticeUrl = campaignEx.getNoticeUrl();
        if (TextUtils.isEmpty(noticeUrl) || noticeUrl.contains(CampaignEx.JSON_KEY_NV_T2)) {
            return noticeUrl;
        }
        StringBuilder sb = new StringBuilder(noticeUrl);
        sb.append("&nv_t2=").append(this.N.getNvT2());
        return sb.toString();
    }

    public boolean canShowVideo() {
        return a(false) == a.VIDEO;
    }

    private class e implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        private e() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            int iRound;
            if (MBMediaView.this.ak) {
                return;
            }
            try {
                float[] fArr = sensorEvent.values;
                float f = -fArr[0];
                float f2 = -fArr[1];
                float f3 = -fArr[2];
                if (((f * f) + (f2 * f2)) * 4.0f >= f3 * f3) {
                    iRound = 90 - Math.round(((float) Math.atan2(-f2, f)) * 57.29578f);
                    while (iRound >= 360) {
                        iRound -= 360;
                    }
                    while (iRound < 0) {
                        iRound += 360;
                    }
                } else {
                    iRound = -1;
                }
                float fA = MBMediaView.this.A();
                int iK = af.k(MBMediaView.this.getContext());
                if ((iRound <= 45 || iRound >= 135) && (iRound <= 225 || iRound >= 315)) {
                    if (((iRound <= 135 || iRound >= 225) && ((iRound <= 315 || iRound >= 360) && ((iRound < 0 || iRound > 45) && iRound != -1))) || fA > iK || !MBMediaView.this.j) {
                        return;
                    }
                    MBMediaView.this.i = false;
                    MBMediaView.this.j = false;
                    MBMediaView.this.M.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.e.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(MBMediaView.this.F, MBMediaView.this.i);
                                MBMediaView.this.C();
                                MBMediaView.this.h();
                                MBMediaView.this.f();
                                MBMediaView.this.g();
                                if (MBMediaView.this.B != null) {
                                    MBMediaView.this.B.orientation(MBMediaView.this.i);
                                }
                            } catch (Exception e) {
                                aa.d(MBMediaView.TAG, e.getMessage());
                            }
                        }
                    }, 200L);
                    return;
                }
                if (fA < iK || MBMediaView.this.j) {
                    return;
                }
                MBMediaView.this.i = true;
                MBMediaView.this.j = true;
                MBMediaView.this.M.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.e.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(MBMediaView.this.F, MBMediaView.this.i);
                            MBMediaView.this.D();
                            MBMediaView.this.h();
                            MBMediaView.this.f();
                            MBMediaView.this.g();
                            if (MBMediaView.this.B != null) {
                                MBMediaView.this.B.orientation(MBMediaView.this.i);
                            }
                        } catch (Exception e) {
                            aa.d(MBMediaView.TAG, e.getMessage());
                        }
                    }
                }, 200L);
            } catch (Throwable th) {
                aa.b(MBMediaView.TAG, th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindVaneWebViewForNV F() {
        try {
            WindVaneWebViewForNV windVaneWebViewForNV = this.B;
            if (windVaneWebViewForNV != null && this.ag) {
                return windVaneWebViewForNV;
            }
            if (this.ag) {
                return null;
            }
            b(true);
            return null;
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
            return null;
        }
    }

    private void b(boolean z) {
        try {
            int nvT2 = this.N.getNvT2();
            if (this.B == null) {
                WindVaneWebViewForNV windVaneWebViewForNV = new WindVaneWebViewForNV(getContext());
                this.B = windVaneWebViewForNV;
                windVaneWebViewForNV.setObject(this);
                this.B.setBackListener(new com.mbridge.msdk.nativex.listener.b() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.6
                    @Override // com.mbridge.msdk.nativex.listener.b
                    public final void a() {
                        MBMediaView.this.exitFullScreen();
                    }
                });
                this.B.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.7
                    @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                    public final void a(WebView webView, String str) {
                        super.a(webView, str);
                        MBMediaView.this.af = true;
                    }

                    @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                    public final void a(WebView webView, int i, String str, String str2) {
                        super.a(webView, i, str, str2);
                        MBMediaView.this.af = false;
                    }
                });
            }
            if (nvT2 != 3) {
                if (nvT2 == 4) {
                    this.ag = true;
                    if (this.N != null) {
                        BrowserView.MBDownloadListener mBDownloadListener = new BrowserView.MBDownloadListener(this.N);
                        mBDownloadListener.setTitle(this.N.getAppName());
                        this.B.setDownloadListener(mBDownloadListener);
                        this.B.setFilter(new d());
                        return;
                    }
                    return;
                }
                return;
            }
            String str = this.N.getendcard_url();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.N.getMediaViewHolder();
            if (str.contains(".zip") && str.contains("md5filename")) {
                String strB = com.mbridge.msdk.videocommon.download.g.a().b(str);
                if (ak.b(strB)) {
                    this.ag = true;
                    this.B.loadUrl(strB);
                    return;
                }
                return;
            }
            String strB2 = h.a().b(str);
            if (ak.b(strB2)) {
                aa.a(TAG, "load html...");
                this.ag = true;
                this.B.loadDataWithBaseURL(str, strB2, "text/html", "UTF-8", null);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    private static final class g extends WebViewClient {
        WeakReference<MBMediaView> a;

        public g(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                MBMediaView mBMediaView = this.a.get();
                if (mBMediaView == null || mBMediaView.ab == null || mBMediaView.ab != a.BIG_IMAGE) {
                    return;
                }
                mBMediaView.l();
                mBMediaView.ab = a.GIF;
                mBMediaView.changeNoticeURL();
            } catch (Exception e) {
                aa.d(MBMediaView.TAG, e.getMessage());
            }
        }
    }

    private static final class f implements com.mbridge.msdk.videocommon.listener.a {
        WeakReference<MBMediaView> a;

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
        }

        public f(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                mBMediaView.M.post(new b(mBMediaView));
            }
        }
    }

    private static final class b implements Runnable {
        WeakReference<MBMediaView> a;

        public b(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                try {
                    if (mBMediaView.ab == null || mBMediaView.ab != a.BIG_IMAGE) {
                        return;
                    }
                    mBMediaView.e();
                    mBMediaView.ab = a.VIDEO;
                    mBMediaView.changeNoticeURL();
                } catch (Throwable th) {
                    aa.b(MBMediaView.TAG, th.getMessage(), th);
                }
            }
        }
    }

    private static final class c implements com.mbridge.msdk.nativex.listener.a {
        WeakReference<MBMediaView> a;

        public c(MBMediaView mBMediaView) {
            this.a = new WeakReference<>(mBMediaView);
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void a() {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                MBMediaView.N(mBMediaView);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void b() {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                MBMediaView.O(mBMediaView);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void c() {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                MBMediaView.P(mBMediaView);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void d() {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                MBMediaView.Q(mBMediaView);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void a(String str) {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                mBMediaView.a(str);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public final void b(String str) {
            MBMediaView mBMediaView = this.a.get();
            if (mBMediaView != null) {
                mBMediaView.b(str);
            }
        }
    }

    public BaseView.a handleViewStyleResult(Context context) {
        int nvT2 = this.N.getNvT2();
        if (nvT2 == 1) {
            b(context);
        } else {
            if (nvT2 == 2 || nvT2 == 3 || nvT2 == 4) {
                return BaseView.a.FULL_MIDDLE_VIEW;
            }
            if (nvT2 == 6) {
                return BaseView.a.FULL_TOP_VIEW;
            }
        }
        return null;
    }

    private static final class d implements com.mbridge.msdk.mbsignalcommon.base.a {
        private d() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.base.a
        public final boolean a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (ae.a.a(str)) {
                        ae.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, (NativeListener.NativeTrackingListener) null);
                        return true;
                    }
                    if (URLUtil.isNetworkUrl(str)) {
                        return false;
                    }
                    ae.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, (BaseTrackingListener) null);
                    return true;
                }
            } catch (Exception e) {
                aa.d(MBMediaView.TAG, e.getMessage());
            }
            return false;
        }
    }

    public void setProgressVisibility(boolean z) {
        this.k = z;
        MediaViewPlayerView mediaViewPlayerView = this.w;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showProgressView(z);
        }
    }

    public void setSoundIndicatorVisibility(boolean z) {
        this.l = z;
        MediaViewPlayerView mediaViewPlayerView = this.w;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showSoundIndicator(z);
        }
    }

    public void setVideoSoundOnOff(boolean z) {
        this.f = z;
        MediaViewPlayerView mediaViewPlayerView = this.w;
        if (mediaViewPlayerView != null) {
            if (z) {
                mediaViewPlayerView.openSound();
            } else {
                mediaViewPlayerView.closeSound();
            }
        }
    }

    public BaseView getFullScreenViewByStyle(Context context, BaseView.a aVar) {
        BaseView mBridgeFullView;
        BaseView baseView;
        int i = AnonymousClass10.a[aVar.ordinal()];
        if (i == 1) {
            mBridgeFullView = new MBridgeFullView(context);
        } else {
            if (i != 2) {
                baseView = null;
            } else {
                mBridgeFullView = new MBridgeTopFullView(context);
            }
            baseView.setStytle(aVar);
            return baseView;
        }
        baseView = mBridgeFullView;
        baseView.setStytle(aVar);
        return baseView;
    }

    public void setFullScreenViewBackgroundColor(int i) {
        this.v = i;
    }

    public void setFollowActivityOrientation(boolean z) {
        this.ak = z;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.ak || this.aj == configuration.orientation) {
            return;
        }
        int i = configuration.orientation;
        this.aj = i;
        this.i = i == 0;
        this.j = this.aj == 0;
        this.M.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.8
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(MBMediaView.this.F, MBMediaView.this.i);
                    if (MBMediaView.this.aj == 0) {
                        MBMediaView.this.D();
                    } else {
                        MBMediaView.this.C();
                    }
                    MBMediaView.this.h();
                    MBMediaView.this.f();
                    MBMediaView.this.g();
                    if (MBMediaView.this.B != null) {
                        MBMediaView.this.B.orientation(MBMediaView.this.i);
                    }
                } catch (Exception e2) {
                    aa.d(MBMediaView.TAG, e2.getMessage());
                }
            }
        }, 200L);
    }

    public boolean ismCurIsFullScreen() {
        return this.h;
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void cai(Object obj, String str) {
        aa.a(TAG, "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("packageName");
            if (TextUtils.isEmpty(strOptString)) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "packageName is empty");
            }
            int i = af.c(com.mbridge.msdk.foundation.controller.b.d().g(), strOptString) ? 1 : 2;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.b.f2325b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", i);
                jSONObject.put("data", jSONObject2);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e2) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, e2.getMessage());
                aa.a(TAG, e2.getMessage());
            }
        } catch (JSONException e3) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + e3.getLocalizedMessage());
            aa.b(TAG, "cai", e3);
        } catch (Throwable th) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + th.getLocalizedMessage());
            aa.b(TAG, "cai", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.N);
            String strA = a(arrayList, o(), "MAL_16.5.41,3.0.1");
            String strEncodeToString = !TextUtils.isEmpty(strA) ? Base64.encodeToString(strA.getBytes(), 2) : "";
            aa.d(TAG, "getEndScreenInfo-mCampaign.name:" + this.N.getAppName());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, strEncodeToString);
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void install(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            Context context = this.al;
            if (context != null) {
                b(context);
            } else {
                if (!(obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) || (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) == null) {
                    return;
                }
                b(windVaneWebView.getContext());
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        aa.d(TAG, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
            return;
        }
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextG == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                    contextG = windVaneWebView.getContext();
                }
            } catch (Exception e2) {
                aa.d(TAG, e2.getMessage());
            }
        }
        if (contextG == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.b.a(contextG, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.b.b(contextG, strOptString);
            }
        } catch (JSONException e3) {
            aa.d(TAG, e3.getMessage());
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str).optInt("state", 1);
                } catch (Exception e2) {
                    aa.d(TAG, e2.getMessage());
                }
            }
            aa.d(TAG, "SHOW CLOSE BTN ");
            showEndCardWebViewCloseBtn();
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, a(0));
        } catch (Exception e3) {
            aa.d(TAG, e3.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().b(obj, a(1));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            exitFullScreen();
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, a(0));
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().b(obj, a(1));
        }
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            aa.d(TAG, "code to string is error");
            return "";
        }
    }

    private String a(List<CampaignEx> list, String str, String str2) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONArray camplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("campaignList", camplistToJson);
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sdk_info", str2);
            return jSONObject.toString();
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        try {
            try {
                OnMBMediaViewListener onMBMediaViewListener = this.ac;
                if (onMBMediaViewListener != null) {
                    onMBMediaViewListener.onVideoAdClicked(this.N);
                }
                OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.ad;
                if (onMBMediaViewListenerPlus != null) {
                    onMBMediaViewListenerPlus.onVideoAdClicked(this.N);
                }
            } catch (Exception e2) {
                aa.d(TAG, e2.getMessage());
            }
            if (this.N != null && !ak.a(o())) {
                if (!this.N.isReportClick()) {
                    this.N.setReportClick(true);
                    CampaignEx campaignEx = this.N;
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && this.N.getNativeVideoTracking().l() != null) {
                        Context context2 = getContext();
                        CampaignEx campaignEx2 = this.N;
                        com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx2.getCampaignUnitId(), this.N.getNativeVideoTracking().l(), false, false);
                    }
                }
                com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), o());
                aVar.a(new NativeListener.NativeTrackingListener() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.14
                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDismissLoading(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDownloadFinish(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDownloadProgress(int i) {
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onDownloadStart(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final boolean onInterceptDefaultLoadingDialog() {
                        return true;
                    }

                    @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                    public final void onShowLoading(Campaign campaign) {
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onStartRedirection(Campaign campaign, String str) {
                        try {
                            MBMediaView.n(MBMediaView.this);
                            MBMediaView.o(MBMediaView.this);
                            MBMediaView.a(MBMediaView.this, campaign, str);
                        } catch (Exception e3) {
                            aa.d(MBMediaView.TAG, e3.getMessage());
                        }
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onRedirectionFailed(Campaign campaign, String str) {
                        try {
                            MBMediaView.p(MBMediaView.this);
                            MBMediaView.q(MBMediaView.this);
                            MBMediaView.b(MBMediaView.this, campaign, str);
                        } catch (Exception e3) {
                            aa.d(MBMediaView.TAG, e3.getMessage());
                        }
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onFinishRedirection(Campaign campaign, String str) {
                        try {
                            MBMediaView.p(MBMediaView.this);
                            MBMediaView.q(MBMediaView.this);
                            MBMediaView.c(MBMediaView.this, campaign, str);
                        } catch (Exception e3) {
                            aa.d(MBMediaView.TAG, e3.getMessage());
                        }
                    }
                });
                aVar.a(this.N);
            }
        } catch (Exception e3) {
            aa.d(TAG, e3.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i, int i2) {
        int i3;
        String str;
        CampaignEx.b mediaViewHolder;
        CampaignEx.b mediaViewHolder2;
        try {
            CampaignEx campaignEx = this.N;
            if (campaignEx != null && (mediaViewHolder2 = campaignEx.getMediaViewHolder()) != null && !mediaViewHolder2.h && mediaViewHolder2.l != null && mediaViewHolder2.l.size() > 0) {
                Map<Integer, String> map = mediaViewHolder2.l;
                Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> next = it.next();
                    Integer key = next.getKey();
                    String value = next.getValue();
                    if (i >= key.intValue() && !TextUtils.isEmpty(value)) {
                        Context context = getContext();
                        CampaignEx campaignEx2 = this.N;
                        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), value, false, false);
                        it.remove();
                    }
                }
                if (map.size() <= 0) {
                    mediaViewHolder2.h = true;
                }
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
        try {
            CampaignEx campaignEx3 = this.N;
            if (campaignEx3 != null && (mediaViewHolder = campaignEx3.getMediaViewHolder()) != null && !mediaViewHolder.i && i2 != 0) {
                List<Map<Integer, String>> listI = this.N.getNativeVideoTracking().i();
                int i4 = ((i + 1) * 100) / i2;
                if (listI != null) {
                    int i5 = 0;
                    while (i5 < listI.size()) {
                        Map<Integer, String> map2 = listI.get(i5);
                        if (map2 != null && map2.size() > 0) {
                            Iterator<Map.Entry<Integer, String>> it2 = map2.entrySet().iterator();
                            while (it2.hasNext()) {
                                Map.Entry<Integer, String> next2 = it2.next();
                                int iIntValue = next2.getKey().intValue();
                                String value2 = next2.getValue();
                                if (iIntValue <= i4 && !TextUtils.isEmpty(value2)) {
                                    Context context2 = getContext();
                                    CampaignEx campaignEx4 = this.N;
                                    com.mbridge.msdk.click.a.a(context2, campaignEx4, campaignEx4.getCampaignUnitId(), new String[]{value2}, false, true);
                                    it2.remove();
                                    listI.remove(i5);
                                    i5--;
                                }
                            }
                        }
                        i5++;
                    }
                    if (listI.size() <= 0) {
                        mediaViewHolder.i = true;
                    }
                }
            }
        } catch (Throwable unused) {
            aa.d(TAG, "reportPlayPercentageData error");
        }
        MediaEvents mediaEvents = this.u;
        if (mediaEvents != null) {
            int i6 = (i * 100) / i2;
            int i7 = ((i + 1) * 100) / i2;
            if (i6 <= 25 && 25 < i7) {
                mediaEvents.firstQuartile();
            } else if (i6 <= 50 && 50 < i7) {
                mediaEvents.midpoint();
            } else if (i6 <= 75 && 75 < i7) {
                mediaEvents.thirdQuartile();
            }
        }
        if (s() == 100 || this.am) {
            return;
        }
        int iG = t() != null ? t().g() : 0;
        int iS = s();
        if (iS == 0) {
            return;
        }
        if (iG > iS) {
            iG = iS / 2;
        }
        if (iG < 0 || i < (i3 = (iG * i2) / 100)) {
            return;
        }
        if (this.N.getAdType() == 94 || this.N.getAdType() == 287) {
            str = this.N.getRequestId() + this.N.getId() + this.N.getVideoUrlEncode();
        } else {
            str = this.N.getId() + this.N.getVideoUrlEncode() + this.N.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.c.getInstance().a(o(), str);
        if (aVarA != null) {
            aVarA.o();
            this.am = true;
            aa.d(TAG, "CDRate is : " + i3 + " and start download !");
        }
    }

    static /* synthetic */ void b(MBMediaView mBMediaView) {
        CampaignEx campaignEx = mBMediaView.N;
        if (campaignEx == null || campaignEx.getMediaViewHolder() == null) {
            return;
        }
        com.mbridge.msdk.foundation.controller.b.d().a(mBMediaView.getContext());
        com.mbridge.msdk.mbnative.d.b.a(mBMediaView.N, mBMediaView.getContext(), mBMediaView.o(), null);
        CampaignEx.b mediaViewHolder = mBMediaView.N.getMediaViewHolder();
        if (!mediaViewHolder.a && mBMediaView.ab == a.VIDEO && ak.b(mBMediaView.N.getImpressionURL())) {
            mediaViewHolder.a = true;
            String impressionURL = mBMediaView.N.getImpressionURL();
            if (!impressionURL.contains("is_video=1")) {
                StringBuilder sb = new StringBuilder(impressionURL);
                if (impressionURL.contains("?")) {
                    sb.append("&is_video=1");
                } else {
                    sb.append("?is_video=1");
                }
                impressionURL = sb.toString();
            }
            Context context = mBMediaView.getContext();
            CampaignEx campaignEx2 = mBMediaView.N;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), impressionURL, false, true, com.mbridge.msdk.click.a.a.g);
        }
    }

    static /* synthetic */ void d(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.N;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.g || mBMediaView.N.getNativeVideoTracking() == null || mBMediaView.N.getNativeVideoTracking().t() == null) {
            return;
        }
        mediaViewHolder.g = true;
        Context context = mBMediaView.getContext();
        CampaignEx campaignEx2 = mBMediaView.N;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.N.getNativeVideoTracking().t(), false, false);
    }

    static /* synthetic */ void h(MBMediaView mBMediaView) {
        BitmapDrawable bitmapDrawableA;
        CampaignEx campaignEx;
        try {
            if (mBMediaView.getRootView() != null && (mBMediaView.getRootView() instanceof ViewGroup)) {
                BaseView.a aVarHandleViewStyleResult = mBMediaView.handleViewStyleResult(mBMediaView.getContext());
                if (aVarHandleViewStyleResult == null) {
                    return;
                }
                BaseView fullScreenViewByStyle = mBMediaView.getFullScreenViewByStyle(mBMediaView.getContext(), aVarHandleViewStyleResult);
                mBMediaView.F = fullScreenViewByStyle;
                if (fullScreenViewByStyle != null && mBMediaView.x()) {
                    com.mbridge.msdk.nativex.view.mbfullview.a.a(mBMediaView.getContext()).a(mBMediaView.F.style, mBMediaView.N, mBMediaView.F);
                    mBMediaView.h = true;
                    mBMediaView.r = false;
                    MediaViewPlayerView mediaViewPlayerView = mBMediaView.w;
                    if (mediaViewPlayerView != null) {
                        mediaViewPlayerView.setEnterFullScreen();
                        mBMediaView.w.setIsActivePause(false);
                    }
                    try {
                        OnMBMediaViewListener onMBMediaViewListener = mBMediaView.ac;
                        if (onMBMediaViewListener != null) {
                            onMBMediaViewListener.onEnterFullscreen();
                        }
                        OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = mBMediaView.ad;
                        if (onMBMediaViewListenerPlus != null) {
                            onMBMediaViewListenerPlus.onEnterFullscreen();
                        }
                        MediaEvents mediaEvents = mBMediaView.u;
                        if (mediaEvents != null) {
                            mediaEvents.playerStateChange(PlayerState.FULLSCREEN);
                        }
                    } catch (Exception e2) {
                        aa.d(TAG, e2.getMessage());
                    }
                    FrameLayout frameLayout = (FrameLayout) mBMediaView.getRootView().findViewById(R.id.content);
                    RelativeLayout relativeLayout = new RelativeLayout(mBMediaView.getContext());
                    mBMediaView.E = relativeLayout;
                    relativeLayout.setClickable(true);
                    ViewGroup viewGroup = (ViewGroup) mBMediaView.w.getParent();
                    int childCount = viewGroup.getChildCount();
                    int i = 0;
                    while (i < childCount && viewGroup.getChildAt(i) != mBMediaView.w) {
                        i++;
                    }
                    mBMediaView.L = i;
                    FrameLayout frameLayout2 = new FrameLayout(mBMediaView.getContext());
                    frameLayout2.setId(100);
                    viewGroup.addView(frameLayout2, i, new ViewGroup.LayoutParams(mBMediaView.getWidth(), mBMediaView.getHeight()));
                    viewGroup.removeView(mBMediaView.w);
                    ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    relativeLayout.setId(101);
                    new RelativeLayout.LayoutParams(-1, -1);
                    mBMediaView.K.addView(mBMediaView.w, new RelativeLayout.LayoutParams(-1, -1));
                    if (mBMediaView.K != null && (campaignEx = mBMediaView.N) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
                        try {
                            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.b.d().g());
                            mBAdChoice.setCampaign(mBMediaView.N);
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f), af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f));
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(12);
                            mBMediaView.K.addView(mBAdChoice, layoutParams2);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (frameLayout != null && (bitmapDrawableA = com.mbridge.msdk.foundation.controller.b.d().a(mBMediaView.o(), mBMediaView.N.getAdType())) != null) {
                        ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
                        af.a(imageView, bitmapDrawableA, mBMediaView.getResources().getDisplayMetrics());
                        mBMediaView.F.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
                    }
                    frameLayout.addView(relativeLayout, layoutParams);
                    int i2 = -16777216;
                    if (AnonymousClass10.a[mBMediaView.F.style.ordinal()] == 2) {
                        i2 = -1;
                    }
                    int i3 = mBMediaView.v;
                    if (i3 != 0) {
                        relativeLayout.setBackgroundColor(i3);
                    } else {
                        relativeLayout.setBackgroundColor(i2);
                    }
                    mBMediaView.F.setId(103);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                    int[] iArr = new int[2];
                    frameLayout.getLocationInWindow(iArr);
                    int i4 = iArr[1];
                    mBMediaView.ae = i4;
                    if (i4 == 0) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            WindowInsets rootWindowInsets = mBMediaView.getRootWindowInsets();
                            if (rootWindowInsets != null) {
                                layoutParams3.setMargins(0, rootWindowInsets.getStableInsetTop(), 0, 0);
                            }
                        } else {
                            layoutParams3.setMargins(0, af.f(mBMediaView.getContext()), 0, 0);
                        }
                    }
                    relativeLayout.addView(mBMediaView.F, layoutParams3);
                    try {
                        mBMediaView.y();
                        mBMediaView.a(mBMediaView.G, mBMediaView.A(), mBMediaView.B());
                        com.mbridge.msdk.nativex.view.mbfullview.a.a(mBMediaView.getContext()).a(mBMediaView.F, mBMediaView.i);
                        if (mBMediaView.i) {
                            mBMediaView.D();
                        } else {
                            mBMediaView.C();
                        }
                        mBMediaView.M.postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.5
                            @Override // java.lang.Runnable
                            public final void run() {
                                MBMediaView.this.r = true;
                                if (MBMediaView.this.h) {
                                    TextView unused = MBMediaView.this.I;
                                }
                            }
                        }, 3000L);
                    } catch (Throwable th) {
                        aa.d(TAG, th.getMessage());
                    }
                    try {
                        mBMediaView.E.setFocusableInTouchMode(true);
                        mBMediaView.E.requestFocus();
                        mBMediaView.E.setOnKeyListener(new View.OnKeyListener() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.18
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
                                try {
                                    if (keyEvent.getKeyCode() != 4) {
                                        return false;
                                    }
                                    MBMediaView.this.w();
                                    return true;
                                } catch (Throwable th2) {
                                    aa.d(MBMediaView.TAG, th2.getMessage());
                                    return false;
                                }
                            }
                        });
                        mBMediaView.E.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MBMediaView.i(MBMediaView.this);
                            }
                        });
                        mBMediaView.H.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MBMediaView.this.w();
                            }
                        });
                        mBMediaView.I.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.nativex.view.MBMediaView.4
                            @Override // com.mbridge.msdk.widget.a
                            protected final void a(View view) {
                                try {
                                    MBMediaView.this.b(view.getContext());
                                    if (MBMediaView.this.u != null) {
                                        MBMediaView.this.u.adUserInteraction(InteractionType.CLICK);
                                    }
                                } catch (Exception e4) {
                                    aa.d(MBMediaView.TAG, e4.getMessage());
                                }
                            }
                        });
                    } catch (Exception e4) {
                        aa.d(TAG, e4.getMessage());
                    }
                    MediaViewPlayerView mediaViewPlayerView2 = mBMediaView.w;
                    if (mediaViewPlayerView2 != null) {
                        mediaViewPlayerView2.openSound();
                    }
                    mBMediaView.w.setMediaViewPlayListener(new MediaViewPlayerView.a(mBMediaView.w) { // from class: com.mbridge.msdk.nativex.view.MBMediaView.16
                        @Override // com.mbridge.msdk.nativex.view.MediaViewPlayerView.a
                        public final void a() {
                            int nvT2 = MBMediaView.this.N.getNvT2();
                            if (MBMediaView.this.h && (nvT2 == 3 || nvT2 == 4)) {
                                WindVaneWebViewForNV windVaneWebViewForNVF = MBMediaView.this.F();
                                if (windVaneWebViewForNVF != null) {
                                    View viewV = MBMediaView.this.v();
                                    if (viewV != null) {
                                        if (nvT2 == 3 && MBMediaView.this.af) {
                                            com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(viewV, MBMediaView.this.F);
                                            Context context = MBMediaView.this.getContext();
                                            CampaignEx campaignEx2 = MBMediaView.this.N;
                                            String campaignUnitId = MBMediaView.this.N.getCampaignUnitId();
                                            if (campaignEx2 != null) {
                                                try {
                                                    if (campaignEx2.getNativeVideoTracking() != null && campaignEx2.getNativeVideoTracking().r() != null) {
                                                        for (String str : campaignEx2.getNativeVideoTracking().r()) {
                                                            if (!TextUtils.isEmpty(str)) {
                                                                com.mbridge.msdk.click.a.a(context, campaignEx2, campaignUnitId, str, false, true);
                                                            }
                                                        }
                                                    }
                                                } catch (Exception e5) {
                                                    e5.printStackTrace();
                                                }
                                            }
                                        } else if (nvT2 == 4) {
                                            com.mbridge.msdk.nativex.view.mbfullview.a.a(MBMediaView.this.getContext()).a(viewV, MBMediaView.this.F);
                                            String clickURL = MBMediaView.this.N.getClickURL();
                                            if (!TextUtils.isEmpty(clickURL)) {
                                                com.mbridge.msdk.click.a.a(MBMediaView.this.getContext(), MBMediaView.this.N, MBMediaView.this.o(), MBMediaView.this.getAddNVT2ToNoticeURL(), true, false, com.mbridge.msdk.click.a.a.i);
                                                MBMediaView.this.B.loadUrl(clickURL);
                                            }
                                        } else {
                                            super.a();
                                            return;
                                        }
                                        windVaneWebViewForNVF.webViewShow(MBMediaView.this.N, MBMediaView.this.o());
                                        windVaneWebViewForNVF.orientation(MBMediaView.this.i);
                                        return;
                                    }
                                    super.a();
                                    return;
                                }
                                super.a();
                                return;
                            }
                            super.a();
                        }
                    });
                    mBMediaView.b(false);
                    CampaignEx campaignEx2 = mBMediaView.N;
                    if (campaignEx2 == null || campaignEx2.getMediaViewHolder() == null || mBMediaView.N.getMediaViewHolder().k || TextUtils.isEmpty(mBMediaView.N.getCampaignUnitId()) || mBMediaView.N.getNativeVideoTracking() == null || mBMediaView.N.getNativeVideoTracking().c() == null) {
                        return;
                    }
                    mBMediaView.N.getMediaViewHolder().k = true;
                    mBMediaView.E();
                    return;
                }
                return;
            }
            aa.b(TAG, "rootView is null");
        } catch (Exception e5) {
            aa.d(TAG, e5.getMessage());
        }
    }

    static /* synthetic */ void i(MBMediaView mBMediaView) {
        try {
            MediaViewPlayerView mediaViewPlayerView = mBMediaView.w;
            if (mediaViewPlayerView == null) {
                return;
            }
            mediaViewPlayerView.onClickPlayerView();
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    static /* synthetic */ void n(MBMediaView mBMediaView) {
        try {
            ProgressBar progressBar = mBMediaView.D;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void o(MBMediaView mBMediaView) {
        try {
            ProgressBar progressBar = mBMediaView.J;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void a(MBMediaView mBMediaView, Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = mBMediaView.ac;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onStartRedirection(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = mBMediaView.ad;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onStartRedirection(campaign, str);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void p(MBMediaView mBMediaView) {
        try {
            ProgressBar progressBar = mBMediaView.D;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void q(MBMediaView mBMediaView) {
        try {
            ProgressBar progressBar = mBMediaView.J;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void b(MBMediaView mBMediaView, Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = mBMediaView.ac;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onRedirectionFailed(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = mBMediaView.ad;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onRedirectionFailed(campaign, str);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void c(MBMediaView mBMediaView, Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = mBMediaView.ac;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onFinishRedirection(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = mBMediaView.ad;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onFinishRedirection(campaign, str);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void r(MBMediaView mBMediaView) {
        CampaignEx campaignEx = mBMediaView.N;
        if (campaignEx == null || campaignEx.getMediaViewHolder() == null || mBMediaView.N.getMediaViewHolder().d || TextUtils.isEmpty(mBMediaView.N.getCampaignUnitId()) || mBMediaView.N.getNativeVideoTracking() == null || mBMediaView.N.getNativeVideoTracking().o() == null) {
            return;
        }
        mBMediaView.N.getMediaViewHolder().d = true;
        Context context = mBMediaView.getContext();
        CampaignEx campaignEx2 = mBMediaView.N;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.N.getNativeVideoTracking().o(), false, false);
    }

    static /* synthetic */ void a(MBMediaView mBMediaView, String str) {
        try {
            q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(mBMediaView.getContext()));
            com.mbridge.msdk.foundation.entity.n nVar = null;
            if (!TextUtils.isEmpty(mBMediaView.N.getNoticeUrl())) {
                int iR = w.r(mBMediaView.getContext());
                nVar = new com.mbridge.msdk.foundation.entity.n("2000021", iR, mBMediaView.N.getNoticeUrl(), str, w.a(mBMediaView.getContext(), iR));
            } else if (!TextUtils.isEmpty(mBMediaView.N.getClickURL())) {
                int iR2 = w.r(mBMediaView.getContext());
                nVar = new com.mbridge.msdk.foundation.entity.n("2000021", iR2, mBMediaView.N.getClickURL(), str, w.a(mBMediaView.getContext(), iR2));
            }
            if (nVar != null) {
                nVar.q(mBMediaView.N.getId());
                nVar.e(mBMediaView.N.getVideoUrlEncode());
                nVar.s(str);
                nVar.m(mBMediaView.N.getRequestId());
                nVar.o(mBMediaView.N.getRequestIdNotice());
                nVar.p(mBMediaView.o());
                qVarA.a(nVar);
            }
        } catch (Exception e2) {
            aa.d(TAG, e2.getMessage());
        }
    }

    static /* synthetic */ void N(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.N;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f2082b || mBMediaView.N.getNativeVideoTracking() == null || mBMediaView.N.getNativeVideoTracking().j() == null) {
            return;
        }
        mediaViewHolder.f2082b = true;
        Context context = mBMediaView.getContext();
        CampaignEx campaignEx2 = mBMediaView.N;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.N.getNativeVideoTracking().j(), false, false);
    }

    static /* synthetic */ void O(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.N;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.c || mBMediaView.N.getNativeVideoTracking() == null || mBMediaView.N.getNativeVideoTracking().k() == null) {
            return;
        }
        mediaViewHolder.c = true;
        Context context = mBMediaView.getContext();
        CampaignEx campaignEx2 = mBMediaView.N;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.N.getNativeVideoTracking().k(), false, false);
    }

    static /* synthetic */ void P(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.N;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.e || mBMediaView.N.getNativeVideoTracking() == null || mBMediaView.N.getNativeVideoTracking().m() == null) {
            return;
        }
        mediaViewHolder.e = true;
        Context context = mBMediaView.getContext();
        CampaignEx campaignEx2 = mBMediaView.N;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.N.getNativeVideoTracking().m(), false, false);
    }

    static /* synthetic */ void Q(MBMediaView mBMediaView) {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = mBMediaView.N;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f || mBMediaView.N.getNativeVideoTracking() == null || mBMediaView.N.getNativeVideoTracking().n() == null) {
            return;
        }
        mediaViewHolder.f = true;
        Context context = mBMediaView.getContext();
        CampaignEx campaignEx2 = mBMediaView.N;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), mBMediaView.N.getNativeVideoTracking().n(), false, false);
    }

    static /* synthetic */ void S(MBMediaView mBMediaView) {
        try {
            MediaViewPlayerView mediaViewPlayerView = mBMediaView.w;
            if (mediaViewPlayerView != null && mediaViewPlayerView.hasPrepare() && mBMediaView.w.isPlaying()) {
                try {
                    MediaViewPlayerView mediaViewPlayerView2 = mBMediaView.w;
                    if (mediaViewPlayerView2 != null) {
                        mediaViewPlayerView2.pause();
                    }
                } catch (Throwable th) {
                    aa.d(TAG, th.getMessage());
                }
            }
        } catch (Throwable th2) {
            aa.d(TAG, th2.getMessage());
        }
    }

    static /* synthetic */ void T(MBMediaView mBMediaView) {
        try {
            MediaViewPlayerView mediaViewPlayerView = mBMediaView.w;
            if (mediaViewPlayerView == null || !mediaViewPlayerView.hasPrepare() || mBMediaView.w.isPlaying() || mBMediaView.w.isComplete() || !mBMediaView.w.hasPrepare()) {
                return;
            }
            mBMediaView.w.startOrPlayVideo();
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }
}

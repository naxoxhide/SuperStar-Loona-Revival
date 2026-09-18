package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.video.bt.module.b.c;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.widget.FeedBackButton;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBridgeBTContainer extends AbstractJSContainer implements com.mbridge.msdk.video.signal.b {
    private static final String a = "MBridgeBTContainer";
    private boolean A;
    private String B;
    private boolean C;
    private List<CampaignEx> D;
    private List<com.mbridge.msdk.videocommon.download.a> E;
    private com.mbridge.msdk.video.bt.module.a.a F;
    private h G;
    private h H;
    private com.mbridge.msdk.video.bt.module.a.b I;
    private String J;
    private String K;
    private String L;
    private String M;
    private boolean N;
    private int O;
    private d P;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2471b;
    private int c;
    private FrameLayout d;
    private MBridgeBTLayout e;
    private WindVaneWebView f;
    private LayoutInflater g;
    private Context h;
    private TextView i;
    private ImageView y;
    private boolean z;

    @Override // com.mbridge.msdk.video.signal.d
    public void click(int i, String str) {
    }

    @Override // com.mbridge.msdk.video.signal.d
    public void handlerH5Exception(int i, String str) {
    }

    public MBridgeBTContainer(Context context) {
        super(context);
        this.f2471b = 0;
        this.c = 1;
        this.z = false;
        this.A = true;
        this.C = false;
        init(context);
    }

    public MBridgeBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2471b = 0;
        this.c = 1;
        this.z = false;
        this.A = true;
        this.C = false;
        init(context);
    }

    public void init(Context context) {
        this.h = context;
        this.g = LayoutInflater.from(context);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onCreate() {
        String cMPTEntryUrl;
        WindVaneWebView windVaneWebViewA;
        CampaignEx campaignEx;
        try {
            int iFindLayout = findLayout("mbridge_bt_container");
            if (iFindLayout < 0) {
                a("mbridge_bt_container layout null");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) this.g.inflate(iFindLayout, this);
            this.d = frameLayout;
            if (frameLayout == null) {
                a("ViewIds null");
                return;
            }
            this.K = "";
            List<CampaignEx> list = this.D;
            if (list == null || list.size() <= 0) {
                cMPTEntryUrl = "";
            } else {
                CampaignEx campaignEx2 = this.D.get(0);
                cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                this.K = campaignEx2.getRequestId();
                this.L = campaignEx2.getCurrentLRid();
            }
            com.mbridge.msdk.videocommon.a.C0524a c0524aA = com.mbridge.msdk.videocommon.a.a(this.k + "_" + this.K + "_" + cMPTEntryUrl);
            RelativeLayout.LayoutParams layoutParams = null;
            byte b2 = 0;
            if (c0524aA != null) {
                this.B = c0524aA.b();
                aa.a(a, "get BT wraper.getTag = " + this.B);
                c0524aA.a("");
                windVaneWebViewA = c0524aA.a();
            } else {
                windVaneWebViewA = null;
            }
            this.f = windVaneWebViewA;
            com.mbridge.msdk.videocommon.a.b(this.k + "_" + this.K + "_" + cMPTEntryUrl);
            if (this.f != null) {
                com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this.j, this, this.f);
                registerJsFactory(bVar);
                this.f.setApiManagerJSFactory(bVar);
                if (this.f.getParent() != null) {
                    a("preload template webview is null or load error");
                    return;
                }
                if (this.f.getObject() instanceof j) {
                    bVar.a((j) this.f.getObject());
                    if (this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.k, af.e(getContext()));
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", this.o.a());
                            jSONObject2.put("amount", this.o.b());
                            jSONObject2.put("id", this.p);
                            jSONObject.put("userId", this.n);
                            jSONObject.put(ReportUtil.EVENT_TYPE_REWARD, jSONObject2);
                            jSONObject.put("playVideoMute", this.q);
                            jSONObject.put("extra", this.M);
                        } catch (JSONException e) {
                            aa.a(a, e.getMessage());
                        } catch (Exception e2) {
                            aa.a(a, e2.getMessage());
                        }
                        this.H = new c(c(), "");
                        String string = jSONObject.toString();
                        try {
                            HashMap map = new HashMap();
                            map.put("type", "1");
                            m.a().b("2000133", this.L, map);
                        } catch (Exception unused) {
                        }
                        getJSNotifyProxy().a(string);
                        getJSCommon().b(true);
                        getJSCommon().a(new b());
                    }
                    ((com.mbridge.msdk.video.signal.a.c) getJSCommon()).l.a();
                }
                this.f.setBackgroundColor(0);
                LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K);
                if (linkedHashMapB != null && linkedHashMapB.containsKey(this.B)) {
                    View view = linkedHashMapB.get(this.B);
                    if (view instanceof MBridgeBTLayout) {
                        this.e = (MBridgeBTLayout) view;
                        com.mbridge.msdk.foundation.c.b.a().a(this.k + "_1", new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.1
                            @Override // com.mbridge.msdk.foundation.c.a
                            public final void a() {
                                String string2;
                                try {
                                    JSONObject jSONObject3 = new JSONObject();
                                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                        jSONObject3.put("status", 1);
                                    }
                                    string2 = jSONObject3.toString();
                                } catch (Throwable th) {
                                    aa.b(MBridgeBTContainer.a, th.getMessage(), th);
                                    string2 = "";
                                }
                                g.a().a((WebView) MBridgeBTContainer.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                            }

                            @Override // com.mbridge.msdk.foundation.c.a
                            public final void b() {
                                String string2;
                                try {
                                    JSONObject jSONObject3 = new JSONObject();
                                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                        jSONObject3.put("status", 2);
                                    }
                                    string2 = jSONObject3.toString();
                                } catch (Throwable th) {
                                    aa.b(MBridgeBTContainer.a, th.getMessage(), th);
                                    string2 = "";
                                }
                                g.a().a((WebView) MBridgeBTContainer.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                            }

                            @Override // com.mbridge.msdk.foundation.c.a
                            public final void a(String str) {
                                String string2;
                                try {
                                    JSONObject jSONObject3 = new JSONObject();
                                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                        jSONObject3.put("status", 2);
                                    }
                                    string2 = jSONObject3.toString();
                                } catch (Throwable th) {
                                    aa.b(MBridgeBTContainer.a, th.getMessage(), th);
                                    string2 = "";
                                }
                                g.a().a((WebView) MBridgeBTContainer.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                            }
                        });
                        this.e.addView(this.f, 0, new FrameLayout.LayoutParams(-1, -1));
                        com.mbridge.msdk.foundation.c.b.a().c(this.k + "_2");
                        FeedBackButton feedBackButtonB = com.mbridge.msdk.foundation.c.b.a().b(this.k + "_1");
                        if (com.mbridge.msdk.foundation.c.b.a().b() && feedBackButtonB != null) {
                            try {
                                layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            if (layoutParams == null) {
                                layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.c.b.a, com.mbridge.msdk.foundation.c.b.f2065b);
                            }
                            layoutParams.topMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 10.0f);
                            layoutParams.leftMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 10.0f);
                            feedBackButtonB.setLayoutParams(layoutParams);
                            ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(feedBackButtonB);
                            }
                            this.e.addView(feedBackButtonB);
                        }
                        this.e.setTag(this.B);
                        linkedHashMapB.put(this.B, this.e);
                        for (View view2 : linkedHashMapB.values()) {
                            if (view2 instanceof MBridgeBTRootLayout) {
                                MBridgeBTRootLayout mBridgeBTRootLayout = (MBridgeBTRootLayout) view2;
                                this.J = mBridgeBTRootLayout.getInstanceId();
                                this.d.addView(mBridgeBTRootLayout, new FrameLayout.LayoutParams(-1, -1));
                                break;
                            }
                        }
                        linkedHashMapB.remove(this.J);
                        linkedHashMapB.put(this.J, this);
                    }
                    com.mbridge.msdk.video.bt.a.c.a().a(this.k, this.q);
                    com.mbridge.msdk.video.bt.a.c.a().a(this.B, this.K);
                    com.mbridge.msdk.video.bt.a.c.a().a(this.J, this.K);
                    com.mbridge.msdk.video.bt.a.c.a().a(this.k + "_" + this.K, this.j);
                    try {
                        com.mbridge.msdk.foundation.same.f.b.a().execute(new a(this.D, getContext().getApplicationContext(), this.k, this.l));
                    } catch (Throwable unused2) {
                        aa.a(a, "remove campaign failed");
                    }
                    List<CampaignEx> list2 = this.D;
                    if (list2 == null || list2.size() <= 0) {
                        return;
                    }
                    a(this.m, this.D.get(0));
                    return;
                }
                a("big template webviewLayout is null");
                return;
            }
            List<CampaignEx> list3 = this.D;
            if (list3 != null && list3.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
                Context context = this.h;
                if (this.P == null) {
                    a("ChoiceOneCallback is null");
                    return;
                }
                HashMap map2 = new HashMap();
                map2.put("choice_one_callback", this.P);
                com.mbridge.msdk.video.dynview.b.a();
                new com.mbridge.msdk.video.dynview.h.a(context, this.D, new com.mbridge.msdk.video.dynview.e.g() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.2
                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                        CampaignEx campaignEx3;
                        String str;
                        if (aVar != null) {
                            if (MBridgeBTContainer.this.d != null && aVar.a() != null) {
                                MBridgeBTContainer.this.d.removeAllViews();
                                MBridgeBTContainer.this.d.addView(aVar.a());
                                MBridgeBTContainer mBridgeBTContainer = MBridgeBTContainer.this;
                                mBridgeBTContainer.i = (TextView) mBridgeBTContainer.findViewById(mBridgeBTContainer.findID("mbridge_choice_one_countdown_tv"));
                                MBridgeBTContainer mBridgeBTContainer2 = MBridgeBTContainer.this;
                                mBridgeBTContainer2.y = (ImageView) mBridgeBTContainer2.findViewById(mBridgeBTContainer2.findID("mbridge_iv_link"));
                                if (MBridgeBTContainer.this.F != null) {
                                    MBridgeBTContainer.this.F.a();
                                    MBridgeBTContainer.this.F.a(2, MBridgeBTContainer.this.l, MBridgeBTContainer.this.k);
                                }
                                if (MBridgeBTContainer.this.D == null || MBridgeBTContainer.this.D.size() <= 0 || (campaignEx3 = (CampaignEx) MBridgeBTContainer.this.D.get(0)) == null) {
                                    return;
                                }
                                if (campaignEx3.isBidCampaign()) {
                                    MBridgeBTContainer.a(MBridgeBTContainer.this, campaignEx3);
                                }
                                String onlyImpressionURL = campaignEx3.getOnlyImpressionURL();
                                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), MBridgeBTContainer.this.k);
                                int iZ = cVarA != null ? cVarA.z() : 1;
                                if (campaignEx3.getSpareOfferFlag() == 1) {
                                    str = onlyImpressionURL + "&to=1&cbt=" + campaignEx3.getCbt() + "&tmorl=" + iZ;
                                } else {
                                    str = onlyImpressionURL + "&to=0&cbt=" + campaignEx3.getCbt() + "&tmorl=" + iZ;
                                }
                                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx3, MBridgeBTContainer.this.k, str, false, true, com.mbridge.msdk.click.a.a.h);
                                com.mbridge.msdk.foundation.same.a.d.a.put(campaignEx3.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                                MBridgeBTContainer.this.a(campaignEx3);
                                try {
                                    HashMap map3 = new HashMap();
                                    map3.put("type", "choseFromTwoShow");
                                    com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx3, map3);
                                    return;
                                } catch (Exception e4) {
                                    if (MBridgeConstans.DEBUG) {
                                        e4.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                            MBridgeBTContainer.this.a("nativeview is null");
                        }
                    }

                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                        MBridgeBTContainer.this.a("nativeview is null" + (aVar != null ? "errorCode:" + aVar.a() + "Msg:" + aVar.b() : ""));
                    }
                }, map2);
                return;
            }
            a("big template webview is null");
        } catch (Throwable th) {
            a("onCreate exception " + th);
        }
    }

    private static final class a implements Runnable {
        private List<CampaignEx> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f2472b;
        private String c;
        private String d;

        public a(List<CampaignEx> list, Context context, String str, String str2) {
            this.a = list;
            this.f2472b = context;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<CampaignEx> list = this.a;
            if (list == null || list.size() <= 0) {
                return;
            }
            try {
                f.a(com.mbridge.msdk.foundation.db.h.a(this.f2472b)).a(this.c, this.a);
                com.mbridge.msdk.videocommon.a.a.a().c(this.d, this.a.get(0).getAdType());
            } catch (Exception unused) {
                aa.a(MBridgeBTContainer.a, "remove campaign failed");
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    protected final void a(String str) {
        h hVar = this.G;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    protected final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, this.k, it.next(), false, true);
                }
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onConfigurationChanged(configuration);
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    private com.mbridge.msdk.video.bt.module.a.b c() {
        if (this.I == null) {
            this.I = new com.mbridge.msdk.video.bt.module.a.b() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.3
                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.l);
                            jSONObject2.put("unitId", MBridgeBTContainer.this.k);
                            jSONObject.put("data", jSONObject2);
                            aa.a(MBridgeBTContainer.a, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", cVar.a());
                                jSONObject3.put("amount", cVar.b());
                                jSONObject2.put(ReportUtil.EVENT_TYPE_REWARD, jSONObject3);
                            }
                            jSONObject2.put("isComplete", z);
                            jSONObject2.put("convert", z ? 1 : 2);
                            jSONObject.put("data", jSONObject2);
                            aa.a(MBridgeBTContainer.a, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(boolean z, int i) {
                    MBridgeBTContainer.this.N = z;
                    MBridgeBTContainer.this.O = i;
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, String str2) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.l);
                            jSONObject2.put("unitId", MBridgeBTContainer.this.k);
                            jSONObject2.put("error", str2);
                            jSONObject.put("data", jSONObject2);
                            aa.a(MBridgeBTContainer.a, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put("unitId", str3);
                            jSONObject.put("data", jSONObject2);
                            aa.a(MBridgeBTContainer.a, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void b(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put("unitId", str3);
                            jSONObject.put("data", jSONObject2);
                            aa.a(MBridgeBTContainer.a, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void c(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put("unitId", str3);
                            jSONObject.put("data", jSONObject2);
                            aa.a(MBridgeBTContainer.a, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, int i, String str2, String str3) {
                    if (MBridgeBTContainer.this.G != null) {
                        MBridgeBTContainer.this.G.a(i, str2, str3);
                    }
                }
            };
        }
        return this.I;
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        CampaignEx campaignEx;
        super.onResume();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a aVarA = com.mbridge.msdk.video.dynview.b.a.a();
            if (aVarA.a != null) {
                aVarA.a.a();
            }
        }
        if (com.mbridge.msdk.foundation.c.b.c) {
            return;
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onResume();
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        CampaignEx campaignEx;
        super.onStop();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a.a().b();
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onStop();
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onBackPressed();
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onBackPressed();
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onBackPressed();
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        CampaignEx campaignEx;
        super.onPause();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a aVarA = com.mbridge.msdk.video.dynview.b.a.a();
            if (aVarA.a != null) {
                aVarA.a.b();
            }
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onPause();
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onAdClose() {
        if (this.j != null) {
            this.j.finish();
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.C) {
            return;
        }
        this.C = true;
        super.onDestroy();
        com.mbridge.msdk.video.bt.a.c.a().d(this.k + "_" + this.K);
        try {
            WindVaneWebView windVaneWebView = this.f;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f.clearWebView();
                this.f.release();
            }
            if (this.I != null) {
                this.I = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            if (this.h != null) {
                this.h = null;
            }
            List<CampaignEx> list = this.D;
            if (list != null && list.size() > 0) {
                for (CampaignEx campaignEx : this.D) {
                    if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                        com.mbridge.msdk.videocommon.a.b(this.k + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
                com.mbridge.msdk.video.dynview.b.a.a().b();
            }
            com.mbridge.msdk.video.bt.a.c.a().f(this.B);
            com.mbridge.msdk.video.bt.a.c.a().g(this.k);
            com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K).remove(this.B);
            com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K).remove(this.J);
            com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K).clear();
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.mbridge.msdk.video.signal.b
    public void reactDeveloper(Object obj, String str) {
        if (this.F != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("type");
                String strOptString = jSONObject.optString("unitId", getUnitId());
                String strOptString2 = jSONObject.optString(MBridgeConstans.PLACEMENT_ID, getPlacementId());
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                CampaignEx campaignEx = this.D.get(0);
                boolean z = true;
                if (iOptInt == 1 && jSONObjectOptJSONObject != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("expired");
                    if (campaignEx != null) {
                        if (zOptBoolean) {
                            campaignEx.setSpareOfferFlag(1);
                        } else {
                            campaignEx.setSpareOfferFlag(0);
                        }
                    }
                }
                setCBT(campaignEx);
                JSONObject jSONObjectOptJSONObject2 = null;
                switch (iOptInt) {
                    case 1:
                        this.F.a();
                        this.F.a(2, strOptString2, strOptString);
                        a(obj);
                        break;
                    case 2:
                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("error") : null;
                        this.F.a(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("msg") : "");
                        this.F.a(4, strOptString2, strOptString);
                        a(obj);
                        break;
                    case 3:
                        this.F.a(strOptString2, strOptString);
                        this.F.a(5, strOptString2, strOptString);
                        a(obj);
                        break;
                    case 4:
                        try {
                            HashMap map = new HashMap();
                            map.put("type", "2");
                            map.put("update", "1");
                            m.a().b("2000147", this.L, map);
                        } catch (Throwable th) {
                            aa.d(a, th.getMessage());
                        }
                        this.F.b(strOptString2, strOptString);
                        this.F.a(6, strOptString2, strOptString);
                        a(obj);
                        break;
                    case 5:
                        this.F.a(jSONObject.optBoolean("isAutoClick"), strOptString2, strOptString);
                        a(obj);
                        break;
                    case 6:
                        if (jSONObjectOptJSONObject != null) {
                            if (jSONObjectOptJSONObject.optInt("convert") != 1) {
                                z = false;
                            }
                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(ReportUtil.EVENT_TYPE_REWARD);
                            String strOptString3 = jSONObjectOptJSONObject.optString("extra");
                            if (!TextUtils.isEmpty(strOptString3)) {
                                this.M = strOptString3;
                            }
                        } else {
                            z = false;
                        }
                        CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                        com.mbridge.msdk.videocommon.b.c cVarA = com.mbridge.msdk.videocommon.b.c.a(jSONObjectOptJSONObject2);
                        if (cVarA == null) {
                            cVarA = this.o;
                        }
                        this.F.a(7, strOptString2, strOptString);
                        try {
                            HashMap map2 = new HashMap();
                            map2.put("type", "2");
                            m.a().c(campaignWithBackData.getCurrentLRid(), "2000152", map2);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                        if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.o || this.t == com.mbridge.msdk.foundation.same.a.p)) {
                            this.F.a(this.N, this.O);
                        }
                        if (!z) {
                            cVarA.a(0);
                        }
                        this.F.a(z, cVarA);
                        aa.a(a, "sendToServerRewardInfo");
                        if (!this.r && z) {
                            if (campaignWithBackData != null) {
                                com.mbridge.msdk.video.module.b.b.a(campaignWithBackData, cVarA, strOptString, this.n, this.M);
                            } else {
                                com.mbridge.msdk.video.module.b.b.a(campaignEx, cVarA, strOptString, this.n, this.M);
                            }
                        }
                        try {
                            m.a().a("2000134", campaignWithBackData, new HashMap());
                        } catch (Throwable th2) {
                            aa.a(a, th2.getMessage());
                        }
                        a(obj);
                        break;
                    default:
                        a(obj);
                        break;
                }
            } catch (JSONException e2) {
                a(obj, e2.getMessage());
                aa.a(a, e2.getMessage());
                return;
            }
        }
        a(obj, "listener is null");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void reportUrls(Object obj, String str) {
        aa.a(a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int iOptInt = jSONObject.optInt("type");
                String strA = af.a(jSONObject.optString("url"), "&tun=", w.y() + "");
                int iOptInt2 = jSONObject.optInt("report");
                if (iOptInt2 == 0) {
                    Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                    List<CampaignEx> list = this.D;
                    com.mbridge.msdk.click.a.a(contextG, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                    List<CampaignEx> list2 = this.D;
                    com.mbridge.msdk.click.a.a(contextG2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, Base64.encodeToString("".getBytes(), 2));
        } catch (Throwable th) {
            aa.b(a, "reportUrls", th);
        }
    }

    public void appendSubView(MBridgeBTContainer mBridgeBTContainer, MBTempContainer mBTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                int iOptInt = jSONObject.optInt("left", -999);
                int iOptInt2 = jSONObject.optInt("top", -999);
                int iOptInt3 = jSONObject.optInt("right", -999);
                int iOptInt4 = jSONObject.optInt(TJAdUnitConstants.String.BOTTOM, -999);
                if (iOptInt != -999 && contextG != null) {
                    layoutParams.leftMargin = af.b(contextG, iOptInt);
                }
                if (iOptInt2 != -999 && contextG != null) {
                    layoutParams.topMargin = af.b(contextG, iOptInt2);
                }
                if (iOptInt3 != -999 && contextG != null) {
                    layoutParams.rightMargin = af.b(contextG, iOptInt3);
                }
                if (iOptInt4 != -999 && contextG != null) {
                    layoutParams.bottomMargin = af.b(contextG, iOptInt4);
                }
                int iOptInt5 = jSONObject.optInt("width");
                int iOptInt6 = jSONObject.optInt("height");
                if (iOptInt5 > 0) {
                    layoutParams.width = iOptInt5;
                }
                if (iOptInt6 > 0) {
                    layoutParams.height = iOptInt6;
                }
            }
            mBridgeBTContainer.addView(mBTempContainer, layoutParams);
            mBTempContainer.setActivity(this.j);
            mBTempContainer.setMute(this.q);
            mBTempContainer.setBidCampaign(this.z);
            mBTempContainer.setIV(this.r);
            mBTempContainer.setBigOffer(this.A);
            mBTempContainer.setIVRewardEnable(this.t, this.u, this.v);
            mBTempContainer.setShowRewardListener(this.H);
            mBTempContainer.setCampaignDownLoadTask(d(mBTempContainer.getCampaign()));
            mBTempContainer.setMBridgeTempCallback(c());
            mBTempContainer.setWebViewFront(getJSCommon().a());
            mBTempContainer.init(this.h);
            mBTempContainer.onCreate();
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    private com.mbridge.msdk.videocommon.download.a d(CampaignEx campaignEx) {
        List<com.mbridge.msdk.videocommon.download.a> list = this.E;
        if (list == null || campaignEx == null) {
            return null;
        }
        for (com.mbridge.msdk.videocommon.download.a aVar : list) {
            if (aVar.k().getId().equals(campaignEx.getId())) {
                aa.a(a, "tempContainer task initSuccess");
                return aVar;
            }
        }
        return null;
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.f2471b);
                jSONObject2.put("id", this.B);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                g.a().a((WebView) this.f, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.mbridge.msdk.video.bt.a.c.a().a((WebView) this.f, "broadcast", this.B);
            }
        }
    }

    public int findID(String str) {
        return t.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return t.a(getContext(), str, "layout");
    }

    public void setBTContainerCallback(com.mbridge.msdk.video.bt.module.a.a aVar) {
        this.F = aVar;
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.D = list;
    }

    public List<CampaignEx> getCampaigns() {
        return this.D;
    }

    public void setCampaignDownLoadTasks(List<com.mbridge.msdk.videocommon.download.a> list) {
        this.E = list;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.x = bVar;
    }

    public void setShowRewardVideoListener(h hVar) {
        this.G = hVar;
    }

    public void setChoiceOneCallback(d dVar) {
        this.P = dVar;
    }

    public void setCBT(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (campaignEx.getSpareOfferFlag() == 1) {
                if (this.m != null) {
                    if (this.m.z() == 1) {
                        campaignEx.setCbt(1);
                        return;
                    } else {
                        campaignEx.setCbt(0);
                        return;
                    }
                }
                return;
            }
            campaignEx.setCbt(0);
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        TextView textView;
        FrameLayout.LayoutParams layoutParams;
        try {
            String strA = o.a(i, i2, i3, i4, i5);
            aa.d(a, strA);
            WindVaneWebView windVaneWebView = this.f;
            if (windVaneWebView != null && (windVaneWebView.getObject() instanceof j) && !TextUtils.isEmpty(strA)) {
                ((j) this.f.getObject()).b(strA);
                g.a().a((WebView) this.f, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
            }
            List<CampaignEx> list = this.D;
            if (list != null && list.size() > 0) {
                try {
                    if (this.D.get(0).isDynamicView() && (textView = this.i) != null && (layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams()) != null) {
                        if (i2 > 0) {
                            layoutParams.leftMargin = i2;
                        }
                        if (i3 > 0) {
                            layoutParams.rightMargin = i3;
                        }
                        if (i4 > 0) {
                            layoutParams.topMargin = i4;
                        }
                        if (i5 > 0) {
                            layoutParams.bottomMargin = i5;
                        }
                        this.i.setLayoutParams(layoutParams);
                        if (this.y != null) {
                            try {
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.y.getLayoutParams());
                                layoutParams2.leftMargin = layoutParams.rightMargin;
                                layoutParams2.topMargin = layoutParams.topMargin;
                                this.y.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e2) {
                    aa.d(a, e2.getMessage());
                }
            }
            com.mbridge.msdk.video.bt.a.c.a().a(i, i2, i3, i4, i5);
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.k, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setNotchPadding(i2, i3, i4, i5);
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).setNotchPadding(i, i2, i3, i4, i5);
                }
                if ((view instanceof WindVaneWebView) && !TextUtils.isEmpty(strA)) {
                    g.a().a(view, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.M = str;
    }

    private class b extends com.mbridge.msdk.video.signal.a.c.a {
        private b() {
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void a() {
            super.a();
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            ae.a(campaign, MBridgeBTContainer.this.d);
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            ae.b(campaign, MBridgeBTContainer.this.d);
            if (campaign == null || !(campaign instanceof CampaignEx)) {
                return;
            }
            try {
                CampaignEx campaignEx = (CampaignEx) campaign;
                String strOptString = new JSONObject(MBridgeBTContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && strOptString.equals("1.0") && MBridgeBTContainer.this.j != null) {
                    if (!MBridgeBTContainer.this.A) {
                        MBridgeBTContainer.this.j.finish();
                    } else {
                        MBridgeBTContainer.this.onAdClose();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            ae.b(campaign, MBridgeBTContainer.this.d);
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void a(boolean z) {
            super.a(z);
            MBridgeBTContainer.this.H.a(z, MBridgeBTContainer.this.l, MBridgeBTContainer.this.k);
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void a(int i, String str) {
            super.a(i, str);
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void b() {
            super.b();
        }
    }

    public void addNativeCloseButtonWhenWebViewCrash() {
        try {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
            int iB = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 48.0f);
            int iB2 = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 20.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB, iB);
            layoutParams.setMargins(iB2, iB2, iB2, iB2);
            layoutParams.gravity = 5;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_reward_close", "drawable"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeBTContainer.this.onAdClose();
                }
            });
            addView(imageView);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    static /* synthetic */ void a(MBridgeBTContainer mBridgeBTContainer, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                HashMap map = new HashMap();
                List<com.mbridge.msdk.foundation.entity.c> listB = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).b(campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
                if (listB == null || listB.size() <= 0 || listB.get(0) == null) {
                    return;
                }
                int iD = listB.get(0).d();
                String strB = listB.get(0).b();
                if (iD == 1) {
                    map.put("encrypt_p=", "encrypt_p=" + strB);
                    map.put("irlfa=", "irlfa=1");
                    for (Map.Entry entry : map.entrySet()) {
                        campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll((String) entry.getKey(), (String) entry.getValue()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

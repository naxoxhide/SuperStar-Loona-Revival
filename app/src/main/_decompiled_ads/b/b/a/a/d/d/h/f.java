package b.b.a.a.d.d.h;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DynamicLayoutBrickValue.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private boolean A;
    private int A0;
    private int B;
    private int B0;
    private int C;
    private String C0;
    private int D;
    private String D0;
    private int E;
    private int F;
    private double G;
    private int H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    private String M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private String R;
    private int S;
    private boolean T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private float a;
    private String a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f89b;
    private String b0;
    private boolean c;
    private boolean c0;
    private float d;
    private int d0;
    private float e;
    private int e0;
    private float f;
    private int f0;
    private float g;
    private List<a> g0;
    private float h;
    private int h0;
    private double i;
    private int i0;
    private double j;
    private int j0;
    private String k;
    private int k0;
    private String l;
    private boolean l0;
    private String m;
    private boolean m0;
    private String n;
    private boolean n0;
    private String o;
    private int o0;
    private String p;
    private boolean p0;
    private String q;
    private double q0;
    private String r;
    private JSONObject r0;
    private String s;
    private JSONObject s0;
    private boolean t;
    private int t0;
    private int u;
    private String u0;
    private String v;
    private boolean v0;
    private String w;
    private JSONObject w0;
    private String x;
    private int x0;
    private String y;
    private int y0;
    private String z;
    private int z0;

    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        f fVar = new f();
        fVar.a(jSONObject.optString("adType", "embeded"));
        fVar.i(jSONObject.optString("clickArea", "creative"));
        fVar.j(jSONObject.optString("clickTigger", "click"));
        fVar.n(jSONObject.optString("fontFamily", "PingFangSC"));
        fVar.v(jSONObject.optString("textAlign", "left"));
        fVar.k(jSONObject.optString("color", "#999999"));
        fVar.d(jSONObject.optString("bgColor", TJAdUnitConstants.String.TRANSPARENT));
        fVar.f(jSONObject.optString("bgImgUrl", ""));
        fVar.g(jSONObject.optString("borderColor", "#000000"));
        fVar.h(jSONObject.optString("borderStyle", "solid"));
        fVar.o(jSONObject.optString("heightMode", DebugKt.DEBUG_PROPERTY_VALUE_AUTO));
        fVar.w(jSONObject.optString("widthMode", "fixed"));
        fVar.r(jSONObject.optString("interactText", ""));
        fVar.d(jSONObject.optBoolean("isShowBgControl", false));
        fVar.q(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            fVar.m(jSONObjectOptJSONObject.optInt("translateY", 0));
        }
        fVar.s(jSONObject.optString("interactType", ""));
        fVar.l(jSONObject.optInt("interactSlideDirection", -1));
        fVar.t(jSONObject.optString("justifyHorizontal", "space-around"));
        fVar.u(jSONObject.optString("justifyVertical", "flex-start"));
        fVar.d(jSONObject.optDouble("timingStart"));
        fVar.c(jSONObject.optDouble("timingEnd"));
        fVar.i((float) jSONObject.optDouble("width", 0.0d));
        fVar.d((float) jSONObject.optDouble("height", 0.0d));
        fVar.a((float) jSONObject.optDouble("borderRadius", 0.0d));
        fVar.b((float) jSONObject.optDouble("borderSize", 0.0d));
        fVar.e(jSONObject.optBoolean("interactValidate", false));
        fVar.c((float) jSONObject.optDouble("fontSize", 0.0d));
        fVar.e((float) jSONObject.optDouble("paddingBottom", 0.0d));
        fVar.f((float) jSONObject.optDouble("paddingLeft", 0.0d));
        fVar.g((float) jSONObject.optDouble("paddingRight", 0.0d));
        fVar.h((float) jSONObject.optDouble("paddingTop", 0.0d));
        fVar.f(jSONObject.optBoolean("lineFeed", false));
        fVar.q(jSONObject.optInt("lineCount", 0));
        fVar.b(jSONObject.optDouble("lineHeight", 1.2d));
        fVar.p(jSONObject.optInt("letterSpacing", 0));
        fVar.c(jSONObject.optBoolean("isDataFixed", false));
        fVar.j(jSONObject.optInt("fontWeight"));
        fVar.g(jSONObject.optBoolean("lineLimit"));
        fVar.v(jSONObject.optInt("position"));
        fVar.b(jSONObject.optString("align"));
        fVar.m(jSONObject.optBoolean("useLeft"));
        fVar.n(jSONObject.optBoolean("useRight"));
        fVar.o(jSONObject.optBoolean("useTop"));
        fVar.l(jSONObject.optBoolean("useBottom"));
        fVar.l(jSONObject.optString("data"));
        fVar.s(jSONObject.optInt("marginLeft"));
        fVar.t(jSONObject.optInt("marginRight"));
        fVar.u(jSONObject.optInt("marginTop"));
        fVar.r(jSONObject.optInt("marginBottom"));
        fVar.y(jSONObject.optInt("tagMaxCount"));
        fVar.a(jSONObject.optBoolean("allowTextFlow"));
        fVar.A(jSONObject.optInt("textFlowType"));
        fVar.z(jSONObject.optInt("textFlowDuration"));
        fVar.o(jSONObject.optInt("left"));
        fVar.w(jSONObject.optInt("right"));
        fVar.B(jSONObject.optInt("top"));
        fVar.i(jSONObject.optInt(TJAdUnitConstants.String.BOTTOM));
        fVar.c(jSONObject.optString("alignItems", "flex-start"));
        fVar.m(jSONObject.optString("direction", ""));
        fVar.h(jSONObject.optBoolean("loop", false));
        fVar.D(jSONObject.optInt("zIndex"));
        fVar.n(jSONObject.optInt("interactVisibleTime"));
        fVar.k(jSONObject.optInt("interactHiddenTime"));
        fVar.e(jSONObject.optString("bgGradient"));
        fVar.a(jSONObject.optInt("areaType"));
        fVar.x(jSONObject.optInt("interactSlideThreshold", 0));
        fVar.C(jSONObject.optInt("interactBottomDistance", 0));
        fVar.i(jSONObject.optBoolean("openPlayableLandingPage", false));
        fVar.d(jSONObject.optJSONObject("video"));
        fVar.b(jSONObject.optJSONObject("image"));
        fVar.f(jSONObject.optInt("borderShadowExtent"));
        fVar.b(jSONObject.optBoolean("bgGauseBlur"));
        fVar.b(jSONObject.optInt("bgGauseBlurRadius"));
        fVar.k(jSONObject.optBoolean("showTimeProgress", false));
        fVar.j(jSONObject.optBoolean("showPlayButton", false));
        fVar.a(jSONObject.optDouble("bgColorCg", 0.0d));
        fVar.c(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        fVar.g(jSONObject.optInt("borderTopLeftRadius", 0));
        fVar.h(jSONObject.optInt("borderTopRightRadius", 0));
        fVar.d(jSONObject.optInt("borderBottomLeftRadius", 0));
        fVar.e(jSONObject.optInt("borderBottomRightRadius", 0));
        fVar.c(jSONObject.optJSONObject("interactI18n"));
        fVar.p(jSONObject.optString("imageObjectFit"));
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.f(jSONObject2.optString("animationType"));
                    aVar.b(jSONObject2.optDouble("animationDuration"));
                    aVar.d(jSONObject2.optDouble("animationScaleX"));
                    aVar.e(jSONObject2.optDouble("animationScaleY"));
                    aVar.e(jSONObject2.optString("animationTimeFunction"));
                    aVar.a(jSONObject2.optDouble("animationDelay"));
                    aVar.e(jSONObject2.optInt("animationIterationCount"));
                    aVar.a(jSONObject2.optString("animationDirection"));
                    aVar.c(jSONObject2.optDouble("animationInterval"));
                    aVar.a(jSONObject2.optInt("animationBorderWidth"));
                    aVar.a(jSONObject2.optLong(SDKConstants.PARAM_KEY));
                    aVar.b(jSONObject2.optInt("animationEffectWidth"));
                    aVar.f(jSONObject2.optInt("animationSwing", 1));
                    aVar.g(jSONObject2.optInt("animationTranslateX"));
                    aVar.h(jSONObject2.optInt("animationTranslateY"));
                    aVar.b(jSONObject2.optString("animationRippleBackgroundColor"));
                    aVar.d(jSONObject2.optString("animationScaleDirection"));
                    aVar.d(jSONObject2.optInt("animationFadeStart"));
                    aVar.c(jSONObject2.optInt("animationFadeEnd"));
                    aVar.c(jSONObject2.optString("animationRubInDirection"));
                    if (fVar.o0() > 0.0d) {
                        aVar.a(aVar.b() + fVar.o0());
                    }
                    arrayList.add(aVar);
                }
                fVar.a(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fVar;
    }

    public float A() {
        return this.h;
    }

    public boolean A0() {
        return this.N;
    }

    public int B() {
        return this.J;
    }

    public boolean B0() {
        return this.O;
    }

    public String C() {
        return this.p;
    }

    public boolean C0() {
        return this.P;
    }

    public void D(int i) {
        this.d0 = i;
    }

    public void D0() {
        a(this, this.s0);
    }

    public String E() {
        return this.s;
    }

    public void E0() {
        a(this, this.r0);
    }

    public String F() {
        return this.u0;
    }

    public int G() {
        return this.e0;
    }

    public JSONObject H() {
        return this.w0;
    }

    public boolean I() {
        return this.t;
    }

    public int J() {
        return this.t0;
    }

    public String K() {
        return this.r;
    }

    public int L() {
        return this.u;
    }

    public String M() {
        return this.v;
    }

    public boolean N() {
        return this.c;
    }

    public int O() {
        return this.f0;
    }

    public boolean P() {
        return this.v0;
    }

    public String Q() {
        return this.y;
    }

    public String R() {
        return this.z;
    }

    public int S() {
        return this.W;
    }

    public int T() {
        return this.H;
    }

    public int U() {
        return this.B;
    }

    public double V() {
        return this.G;
    }

    public int W() {
        return this.D;
    }

    public int X() {
        return this.E;
    }

    public int Y() {
        return this.F;
    }

    public int Z() {
        return this.C;
    }

    public void a(String str) {
    }

    public float a0() {
        return this.d;
    }

    public void b(float f) {
        this.f89b = f;
    }

    public float b0() {
        return this.e;
    }

    public void c(int i) {
        this.x0 = i;
    }

    public float c0() {
        return this.f;
    }

    public void d(float f) {
    }

    public void d(int i) {
        this.B0 = i;
    }

    public float d0() {
        return this.g;
    }

    public void e(int i) {
        this.A0 = i;
    }

    public int e0() {
        return this.L;
    }

    public void f(float f) {
        this.e = f;
    }

    public int f0() {
        return this.X;
    }

    public void g(int i) {
        this.z0 = i;
    }

    public boolean g0() {
        return this.n0;
    }

    public void h(String str) {
    }

    public void h(boolean z) {
        this.c0 = z;
    }

    public boolean h0() {
        return this.m0;
    }

    public String i() {
        return this.n;
    }

    public void i(float f) {
    }

    public int i0() {
        return this.i0;
    }

    public int j() {
        return this.x0;
    }

    public int j0() {
        return this.S;
    }

    public int k() {
        return this.B0;
    }

    public String k0() {
        return this.k;
    }

    public int l() {
        return this.A0;
    }

    public int l0() {
        return this.V;
    }

    public String m() {
        return this.o;
    }

    public int m0() {
        return this.U;
    }

    public float n() {
        return this.a;
    }

    public void n(String str) {
    }

    public double n0() {
        return this.j;
    }

    public void o(String str) {
        this.p = str;
    }

    public double o0() {
        return this.i;
    }

    public float p() {
        return this.f89b;
    }

    public int p0() {
        return this.Y;
    }

    public int q() {
        return this.z0;
    }

    public String q0() {
        return this.q;
    }

    public int r() {
        return this.y0;
    }

    public int r0() {
        return this.o0;
    }

    public void s(String str) {
        this.v = str;
    }

    public int s0() {
        return this.d0;
    }

    public String t() {
        return this.w;
    }

    public boolean t0() {
        return this.T;
    }

    public String u() {
        return this.x;
    }

    public boolean u0() {
        return this.I;
    }

    public void v(String str) {
        this.k = str;
    }

    public boolean v0() {
        return this.A;
    }

    public void w(String str) {
        this.q = str;
    }

    public boolean w0() {
        return this.K;
    }

    public String x() {
        return this.b0;
    }

    public boolean x0() {
        return this.c0;
    }

    public void y(int i) {
        this.S = i;
    }

    public boolean y0() {
        return this.p0;
    }

    public void z(int i) {
        this.V = i;
    }

    public boolean z0() {
        return this.Q;
    }

    public void A(int i) {
        this.U = i;
    }

    public void B(int i) {
        this.Y = i;
    }

    public void C(int i) {
        this.o0 = i;
    }

    public String D() {
        return this.C0;
    }

    public void b(double d) {
        this.G = d;
    }

    public void c(float f) {
        this.h = f;
    }

    public void d(double d) {
        this.i = d;
    }

    public double e() {
        return this.q0;
    }

    public void f(String str) {
        this.n = str;
    }

    public void g(float f) {
        this.f = f;
    }

    public void h(int i) {
        this.y0 = i;
    }

    public void i(String str) {
        this.w = str;
    }

    public void j(String str) {
        this.x = str;
    }

    public void k(String str) {
        this.l = str;
    }

    public void l(int i) {
        this.t0 = i;
    }

    public void m(int i) {
        this.u = i;
    }

    public void n(boolean z) {
        this.O = z;
    }

    public void o(boolean z) {
        this.P = z;
    }

    public void p(int i) {
        this.H = i;
    }

    public void q(String str) {
        this.s = str;
    }

    public void r(String str) {
        this.r = str;
    }

    public void s(int i) {
        this.E = i;
    }

    public void t(String str) {
        this.y = str;
    }

    public void u(String str) {
        this.z = str;
    }

    public String v() {
        return this.l;
    }

    public String w() {
        return this.R;
    }

    public void x(int i) {
        this.i0 = i;
    }

    public List<a> y() {
        return this.g0;
    }

    public int z() {
        List<a> list = this.g0;
        if (list == null) {
            return 0;
        }
        for (a aVar : list) {
            if ("translate".equals(aVar.s()) && aVar.r() < 0) {
                return -aVar.r();
            }
        }
        return 0;
    }

    public void b(String str) {
        this.M = str;
    }

    public void c(double d) {
        this.j = d;
    }

    public String d() {
        return this.m;
    }

    public void e(String str) {
        this.D0 = str;
    }

    public void f(boolean z) {
        this.A = z;
    }

    public void g(String str) {
        this.o = str;
    }

    public String h() {
        return this.D0;
    }

    public void i(int i) {
        this.Z = i;
    }

    public void j(int i) {
        this.J = i;
    }

    public void k(int i) {
        this.e0 = i;
    }

    public void l(boolean z) {
        this.Q = z;
    }

    public void m(boolean z) {
        this.N = z;
    }

    public void n(int i) {
        this.f0 = i;
    }

    public void o(int i) {
        this.W = i;
    }

    public void p(String str) {
        this.C0 = str;
    }

    public void q(int i) {
        this.B = i;
    }

    public void r(int i) {
        this.D = i;
    }

    public int s() {
        return this.Z;
    }

    public void t(int i) {
        this.F = i;
    }

    public void u(int i) {
        this.C = i;
    }

    public void v(int i) {
        this.L = i;
    }

    public void w(int i) {
        this.X = i;
    }

    public String b() {
        return this.a0;
    }

    public void c(boolean z) {
        this.I = z;
    }

    public void d(String str) {
        this.m = str;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(int i) {
        this.j0 = i;
    }

    public void g(boolean z) {
        this.K = z;
    }

    public void h(float f) {
        this.g = f;
    }

    public void i(boolean z) {
        this.p0 = z;
    }

    public void j(boolean z) {
        this.n0 = z;
    }

    public void k(boolean z) {
        this.m0 = z;
    }

    public void l(String str) {
        this.R = str;
    }

    public void m(String str) {
        this.b0 = str;
    }

    public int o() {
        return this.j0;
    }

    public void b(boolean z) {
        this.l0 = z;
    }

    public void c(String str) {
        this.a0 = str;
    }

    public void d(boolean z) {
        this.t = z;
    }

    public void e(float f) {
        this.d = f;
    }

    public boolean f() {
        return this.l0;
    }

    public int g() {
        return this.k0;
    }

    public void b(int i) {
        this.k0 = i;
    }

    public int c() {
        return this.h0;
    }

    public void d(JSONObject jSONObject) {
        this.r0 = jSONObject;
    }

    public void b(JSONObject jSONObject) {
        this.s0 = jSONObject;
    }

    public void c(JSONObject jSONObject) {
        this.w0 = jSONObject;
    }

    public void a(double d) {
        this.q0 = d;
    }

    public void a(float f) {
        this.a = f;
    }

    public String a() {
        return this.M;
    }

    public void a(boolean z) {
        this.T = z;
    }

    public void a(List<a> list) {
        this.g0 = list;
    }

    public void a(int i) {
        this.h0 = i;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(f fVar, JSONObject jSONObject) {
        if (fVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b2 = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b2 = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b2 = 1;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b2 = 2;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b2 = 3;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b2 = 4;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b2 = 5;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b2 = 6;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b2 = 7;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b2 = 8;
                    }
                    break;
                case -1383228885:
                    if (next.equals(TJAdUnitConstants.String.BOTTOM)) {
                        b2 = 9;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        b2 = 10;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b2 = 11;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        b2 = 12;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b2 = 13;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b2 = 14;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b2 = 15;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b2 = 16;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        b2 = 17;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b2 = 18;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b2 = 19;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b2 = 20;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        b2 = 21;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b2 = 22;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b2 = 23;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b2 = 24;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b2 = 25;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b2 = 26;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b2 = 27;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b2 = 28;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b2 = 29;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b2 = 30;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        b2 = 31;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b2 = 32;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        b2 = 33;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b2 = 34;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b2 = 35;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b2 = 36;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b2 = 37;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        b2 = 38;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b2 = 39;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b2 = 40;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b2 = 41;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b2 = 42;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        b2 = 43;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b2 = 44;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b2 = 45;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b2 = 46;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b2 = 47;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b2 = 48;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        b2 = 49;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b2 = 50;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b2 = 51;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b2 = 52;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b2 = 53;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b2 = 54;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b2 = 55;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b2 = 56;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b2 = 57;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b2 = 58;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b2 = 59;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b2 = 60;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b2 = Base64.padSymbol;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b2 = 62;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b2 = 63;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    fVar.d(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    fVar.i(jSONObject.optString(next));
                    break;
                case 2:
                    fVar.f(jSONObject.optString(next));
                    break;
                case 3:
                    fVar.q(jSONObject.optInt(next));
                    break;
                case 4:
                    fVar.i(jSONObject.optBoolean(next));
                    break;
                case 5:
                    fVar.g(jSONObject.optBoolean(next));
                    break;
                case 6:
                    fVar.q(jSONObject.optString(next));
                    break;
                case 7:
                    fVar.f((float) jSONObject.optDouble(next));
                    break;
                case 8:
                    fVar.a(jSONObject.optString(next));
                    break;
                case 9:
                    fVar.i(jSONObject.optInt(next));
                    break;
                case 10:
                    fVar.n(jSONObject.optString(next));
                    break;
                case 11:
                    fVar.d((float) jSONObject.optDouble(next));
                    break;
                case 12:
                    fVar.v(jSONObject.optString(next));
                    break;
                case 13:
                    fVar.c(jSONObject.optString(next));
                    break;
                case 14:
                    fVar.e(jSONObject.optBoolean(next));
                    break;
                case 15:
                    fVar.u(jSONObject.optInt(next));
                    break;
                case 16:
                    fVar.l(jSONObject.optBoolean(next));
                    break;
                case 17:
                    fVar.m(jSONObject.optString(next));
                    break;
                case 18:
                    fVar.y(jSONObject.optInt(next));
                    break;
                case 19:
                    fVar.k(jSONObject.optInt(next));
                    break;
                case 20:
                    fVar.o(jSONObject.optBoolean(next));
                    break;
                case 21:
                    fVar.j(jSONObject.optInt(next));
                    break;
                case 22:
                    fVar.D(jSONObject.optInt(next));
                    break;
                case 23:
                    fVar.d(jSONObject.optDouble(next));
                    break;
                case 24:
                    fVar.b(jSONObject.optDouble(next));
                    break;
                case 25:
                    fVar.z(jSONObject.optInt(next));
                    break;
                case 26:
                    fVar.n(jSONObject.optBoolean(next));
                    break;
                case 27:
                    fVar.r(jSONObject.optInt(next));
                    break;
                case 28:
                    fVar.d(jSONObject.optString(next));
                    break;
                case 29:
                    fVar.m(jSONObject.optBoolean(next));
                    break;
                case 30:
                    fVar.w(jSONObject.optString(next));
                    break;
                case 31:
                    fVar.B(jSONObject.optInt(next));
                    break;
                case 32:
                    fVar.l(jSONObject.optString(next));
                    break;
                case 33:
                    fVar.o(jSONObject.optInt(next));
                    break;
                case 34:
                    fVar.h(jSONObject.optBoolean(next));
                    break;
                case 35:
                    fVar.h((float) jSONObject.optDouble(next));
                    break;
                case 36:
                    fVar.b(jSONObject.optString(next));
                    break;
                case 37:
                    fVar.k(jSONObject.optString(next));
                    break;
                case 38:
                    fVar.w(jSONObject.optInt(next));
                    break;
                case 39:
                    fVar.i((float) jSONObject.optDouble(next));
                    break;
                case 40:
                    fVar.c(jSONObject.optDouble(next));
                    break;
                case 41:
                    fVar.e((float) jSONObject.optDouble(next));
                    break;
                case 42:
                    fVar.a(jSONObject.optBoolean(next));
                    break;
                case 43:
                    fVar.c((float) jSONObject.optDouble(next));
                    break;
                case 44:
                    fVar.u(jSONObject.optString(next));
                    break;
                case 45:
                    fVar.n(jSONObject.optInt(next));
                    break;
                case 46:
                    fVar.g((float) jSONObject.optDouble(next));
                    break;
                case 47:
                    fVar.g(jSONObject.optString(next));
                    break;
                case 48:
                    fVar.h(jSONObject.optString(next));
                    break;
                case 49:
                    fVar.v(jSONObject.optInt(next));
                    break;
                case 50:
                    fVar.c(jSONObject.optBoolean(next));
                    break;
                case 51:
                    fVar.t(jSONObject.optInt(next));
                    break;
                case 52:
                    fVar.t(jSONObject.optString(next));
                    break;
                case 53:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        fVar.m(jSONObjectOptJSONObject.optInt("translateY", 0));
                    }
                    break;
                case 54:
                    fVar.f(jSONObject.optBoolean(next));
                    break;
                case 55:
                    fVar.r(jSONObject.optString(next));
                    break;
                case 56:
                    fVar.s(jSONObject.optString(next));
                    break;
                case 57:
                    fVar.a((float) jSONObject.optDouble(next));
                    break;
                case 58:
                    fVar.j(jSONObject.optString(next));
                    break;
                case 59:
                    fVar.o(jSONObject.optString(next));
                    break;
                case 60:
                    fVar.A(jSONObject.optInt(next));
                    break;
                case 61:
                    fVar.b((float) jSONObject.optDouble(next));
                    break;
                case 62:
                    fVar.s(jSONObject.optInt(next));
                    break;
                case 63:
                    fVar.p(jSONObject.optInt(next));
                    break;
            }
        }
    }
}

package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;

/* JADX INFO: loaded from: classes2.dex */
public class InteractViewContainer extends FrameLayout implements g {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DynamicBaseWidget f276b;
    private b.b.a.a.d.d.h.g c;
    private View d;
    private f e;
    private String f;
    private RippleView g;
    private View.OnTouchListener h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private DynamicBrushMaskView n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InteractViewContainer.this.g.c();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InteractViewContainer.this.c();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InteractViewContainer.this.c();
        }
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        super(context);
        this.a = context;
        this.f276b = dynamicBaseWidget;
        this.c = gVar;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.h != null) {
            setOnClickListener((View.OnClickListener) this.f276b.getDynamicClickListener());
            performClick();
            setVisibility(8);
        }
    }

    private void d() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.f = this.c.D();
        this.i = this.c.M();
        f fVarA = h.a(this.a, this.f276b, this.c, this.j, this.k, this.l, this.m);
        this.e = fVarA;
        if (fVarA != null) {
            this.d = fVarA.b();
            if (TextUtils.equals(this.f, "6")) {
                if (!this.c.z() || TextUtils.isEmpty(this.c.w())) {
                    this.g = new RippleView(this.a, Color.parseColor("#99000000"));
                } else {
                    this.g = new RippleView(this.a, b.b.a.a.d.d.h.g.b(this.c.w()));
                }
                addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                post(new a());
            }
            if (TextUtils.equals(this.f, "20")) {
                this.n = (DynamicBrushMaskView) this.e.b();
            }
            addView(this.e.b());
            a(this.e.b());
            setVisibility(0);
        }
    }

    private boolean e() {
        return (this.c.E() || TextUtils.equals("9", this.f) || TextUtils.equals("16", this.f) || TextUtils.equals("17", this.f) || TextUtils.equals("18", this.f) || TextUtils.equals("20", this.f) || TextUtils.equals("29", this.f) || TextUtils.equals("10", this.f)) ? false : true;
    }

    public void f() {
        f fVar = this.e;
        if (fVar != null) {
            fVar.c();
        }
    }

    public void g() {
        if (this.d != null && TextUtils.equals(this.f, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).f();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            f fVar = this.e;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.m.b(e.getMessage());
        }
    }

    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 int, still in use, count: 8, list:
      (r2v0 int) from 0x0013: IF  (r2v0 int) != (48 int)  -> B:7:0x0015 A[HIDDEN]
      (r2v0 int) from 0x0017: IF  (r2v0 int) != (50 int)  -> B:9:0x0019 A[HIDDEN]
      (r2v0 int) from 0x001b: IF  (r2v0 int) != (1598 int)  -> B:11:0x001d A[HIDDEN]
      (r2v0 int) from 0x001f: IF  (r2v0 int) != (1600 int)  -> B:13:0x0021 A[HIDDEN]
      (r2v0 int) from 0x0023: IF  (r2v0 int) != (1602 int)  -> B:15:0x0025 A[HIDDEN]
      (r2v0 int) from 0x0027: IF  (r2v0 int) != (1607 int)  -> B:17:0x0029 A[HIDDEN]
      (r2v0 int) from 0x002c: SWITCH (r2v0 int)
     case 1567: goto B:49:0x0096
     case 1568: goto B:45:0x0088
     case 1569: goto B:41:0x007a
     case 1570: goto B:37:0x006c
     case 1571: goto B:33:0x005e
     default: goto B:19:0x002f A[RegionRef:SW:18]
      (r2v0 int) from 0x002f: SWITCH (r2v0 int)
     case 1573: goto B:29:0x0050
     case 1574: goto B:25:0x0042
     case 1575: goto B:21:0x0034
     default: goto B:98:0x0125 A[RegionRef:SW:19]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(ViewGroup viewGroup) {
        byte b2;
        if (this.d == null) {
            return;
        }
        String str = this.f;
        str.hashCode();
        byte b3 = -1;
        if (iHashCode != 48) {
            if (iHashCode != 50) {
                if (iHashCode != 1598) {
                    if (iHashCode != 1600) {
                        if (iHashCode != 1602) {
                            if (iHashCode != 1607) {
                                switch (str) {
                                    case "5":
                                        b3 = 2;
                                        break;
                                    case "6":
                                        b2 = 3;
                                        b3 = b2;
                                        break;
                                    case "7":
                                        b2 = 4;
                                        b3 = b2;
                                        break;
                                    case "8":
                                        b2 = 5;
                                        b3 = b2;
                                        break;
                                    case "9":
                                        b2 = 6;
                                        b3 = b2;
                                        break;
                                    default:
                                        switch (str) {
                                            case 1567:
                                                if (str.equals("10")) {
                                                    b2 = 7;
                                                    b3 = b2;
                                                }
                                                break;
                                            case 1568:
                                                if (str.equals("11")) {
                                                    b2 = 8;
                                                    b3 = b2;
                                                }
                                                break;
                                            case 1569:
                                                if (str.equals("12")) {
                                                    b2 = 9;
                                                    b3 = b2;
                                                }
                                                break;
                                            case 1570:
                                                if (str.equals("13")) {
                                                    b2 = 10;
                                                    b3 = b2;
                                                }
                                                break;
                                            case 1571:
                                                if (str.equals("14")) {
                                                    b2 = 11;
                                                    b3 = b2;
                                                }
                                                break;
                                            default:
                                                switch (iHashCode) {
                                                    case 1573:
                                                        if (str.equals("16")) {
                                                            b2 = 12;
                                                            b3 = b2;
                                                        }
                                                        break;
                                                    case 1574:
                                                        if (str.equals("17")) {
                                                            b2 = 13;
                                                            b3 = b2;
                                                        }
                                                        break;
                                                    case 1575:
                                                        if (str.equals("18")) {
                                                            b2 = 14;
                                                            b3 = b2;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                }
                            } else if (str.equals("29")) {
                                b2 = 18;
                                b3 = b2;
                            }
                        } else if (str.equals("24")) {
                            b2 = 17;
                            b3 = b2;
                        }
                    } else if (str.equals("22")) {
                        b2 = 16;
                        b3 = b2;
                    }
                } else if (str.equals("20")) {
                    b2 = 15;
                    b3 = b2;
                }
            } else if (str.equals("2")) {
                b2 = 1;
                b3 = b2;
            }
        } else if (str.equals("0")) {
            b3 = 0;
        }
        switch (b3) {
            case 0:
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.d(this, this.i);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.b(this, this);
                break;
            case 2:
                if (!this.c.z() || TextUtils.isEmpty(this.c.w())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                } else {
                    setBackgroundColor(b.b.a.a.d.d.h.g.b(this.c.w()));
                }
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.c(this);
                break;
            case 3:
                if (!this.c.z() || TextUtils.isEmpty(this.c.w())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.e(this);
                break;
            case 5:
            case 8:
                this.f276b.setClipChildren(false);
                this.f276b.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.f276b.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.e(this);
                break;
            case 6:
            case 13:
                this.d.setTag(2);
                break;
            case 7:
            case 10:
            case 17:
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.d(this, this.i);
                break;
            case 9:
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.c(this);
                break;
            case 11:
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.b(this, this);
                break;
            case 12:
                View view = this.d;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.d).getShakeLayout().setTag(2);
                }
                this.d.setTag(2);
                break;
            case 14:
                View view2 = this.d;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.d).getWriggleLayout().setTag(2);
                }
                this.d.setTag(2);
                break;
            case 15:
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.a(this, this.i, viewGroup);
                break;
            case 16:
                if (!b.b.a.a.d.c.c()) {
                    this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.f(this, this.i, viewGroup);
                } else {
                    this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.d(this, this.i);
                }
                break;
            case 18:
                View view3 = this.d;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.d).getShakeView().setTag(2);
                }
                this.h = new com.bytedance.sdk.component.adexpress.dynamic.interact.r.d(this, this.i);
                break;
        }
        View.OnTouchListener onTouchListener = this.h;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (e()) {
            setOnClickListener((View.OnClickListener) this.f276b.getDynamicClickListener());
        }
    }

    public void b() {
        if (this.d != null && TextUtils.equals(this.f, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).b();
            }
        }
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar, int i, int i2, int i3, int i4) {
        super(context);
        this.a = context;
        this.f276b = dynamicBaseWidget;
        this.c = gVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        d();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.g
    public void a() {
        if (TextUtils.equals(this.f, "6")) {
            RippleView rippleView = this.g;
            if (rippleView != null) {
                rippleView.a();
                postDelayed(new b(), 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.f, "20")) {
            DynamicBrushMaskView dynamicBrushMaskView = this.n;
            if (dynamicBrushMaskView != null) {
                dynamicBrushMaskView.d();
                postDelayed(new c(), 400L);
                return;
            }
            return;
        }
        c();
    }
}

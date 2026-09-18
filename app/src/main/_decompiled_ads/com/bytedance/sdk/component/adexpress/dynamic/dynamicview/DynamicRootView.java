package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.f;
import b.b.a.a.d.d.h.h;
import b.b.a.a.d.f.k;
import b.b.a.a.d.f.m;
import b.b.a.a.d.f.n;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.theme.a, b.b.a.a.d.d.d {
    private k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DynamicBaseWidget f272b;
    protected final n c;
    private b.b.a.a.d.d.j.a d;
    private ThemeStatusBroadcastReceiver e;
    private b.b.a.a.d.d.b f;
    private ViewGroup g;
    private int h;
    private List<b.b.a.a.d.d.c> i;
    private b.b.a.a.d.d.e j;
    boolean k;
    private int l;
    private int m;
    private m n;
    private Context o;
    private String p;
    private Map<Integer, String> q;
    public View r;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, m mVar, b.b.a.a.d.d.j.a aVar) {
        super(context);
        this.g = null;
        this.h = 0;
        this.i = new ArrayList();
        this.l = 0;
        this.m = 0;
        this.o = context;
        n nVar = new n();
        this.c = nVar;
        nVar.b(2);
        this.d = aVar;
        aVar.b(this);
        this.e = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.a(this);
        this.k = z;
        this.n = mVar;
    }

    public void a(h hVar, int i) {
        this.f272b = a(hVar, this, i);
        this.c.b(true);
        this.c.b(this.f272b.c);
        this.c.a(this.f272b.d);
        this.c.a(this.r);
        this.a.a(this.c);
    }

    public void b(int i) {
        this.c.b(false);
        this.c.a(i);
        this.a.a(this.c);
    }

    public String getBgColor() {
        return this.p;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.q;
    }

    public b.b.a.a.d.d.j.a getDynamicClickListener() {
        return this.d;
    }

    public int getLogoUnionHeight() {
        return this.l;
    }

    public k getRenderListener() {
        return this.a;
    }

    public m getRenderRequest() {
        return this.n;
    }

    public int getScoreCountWithIcon() {
        return this.m;
    }

    public ViewGroup getTimeOut() {
        return this.g;
    }

    public List<b.b.a.a.d.d.c> getTimeOutListener() {
        return this.i;
    }

    public int getTimedown() {
        return this.h;
    }

    public void setBgColor(String str) {
        this.p = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.q = map;
    }

    public void setDislikeView(View view) {
        this.d.a(view);
    }

    public void setLogoUnionHeight(int i) {
        this.l = i;
    }

    public void setMuteListener(b.b.a.a.d.d.b bVar) {
        this.f = bVar;
    }

    public void setRenderListener(k kVar) {
        this.a = kVar;
        this.d.a(kVar);
    }

    public void setScoreCountWithIcon(int i) {
        this.m = i;
    }

    @Override // b.b.a.a.d.d.d
    public void setSoundMute(boolean z) {
        b.b.a.a.d.d.b bVar = this.f;
        if (bVar != null) {
            bVar.setSoundMute(z);
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.g = viewGroup;
    }

    public void setTimeOutListener(b.b.a.a.d.d.c cVar) {
        this.i.add(cVar);
    }

    @Override // b.b.a.a.d.d.d
    public void setTimeUpdate(int i) {
        this.j.setTimeUpdate(i);
    }

    public void setTimedown(int i) {
        this.h = i;
    }

    public void setVideoListener(b.b.a.a.d.d.e eVar) {
        this.j = eVar;
    }

    public DynamicBaseWidget a(h hVar, ViewGroup viewGroup, int i) {
        if (hVar == null) {
            return null;
        }
        List<h> listE = hVar.e();
        DynamicBaseWidget dynamicBaseWidgetA = b.b.a.a.d.d.g.b.a(this.o, this, hVar);
        if (dynamicBaseWidgetA instanceof DynamicUnKnowView) {
            b(i == 3 ? 128 : 118);
            return null;
        }
        a(hVar);
        dynamicBaseWidgetA.g();
        if (viewGroup != null) {
            viewGroup.addView(dynamicBaseWidgetA);
            a(viewGroup, hVar);
        }
        if (listE == null || listE.size() <= 0) {
            return null;
        }
        Iterator<h> it = listE.iterator();
        while (it.hasNext()) {
            a(it.next(), dynamicBaseWidgetA, i);
        }
        return dynamicBaseWidgetA;
    }

    private void a(h hVar) {
        f fVarG;
        b.b.a.a.d.d.h.e eVarN = hVar.n();
        if (eVarN == null || (fVarG = eVarN.g()) == null) {
            return;
        }
        this.c.a(fVarG.y0());
    }

    private void a(ViewGroup viewGroup, h hVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !hVar.t()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void a(double d, double d2, double d3, double d4, float f) {
        this.c.e(d);
        this.c.f(d2);
        this.c.d(d3);
        this.c.c(d4);
        this.c.c(f);
        this.c.d(f);
        this.c.a(f);
        this.c.b(f);
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.a
    public void a(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.f272b;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.a(i);
    }

    @Override // b.b.a.a.d.d.d
    public void a(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (this.i.get(i3) != null) {
                this.i.get(i3).a(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // b.b.a.a.d.d.d
    public void a() {
        try {
            this.j.a();
        } catch (Exception unused) {
        }
    }
}

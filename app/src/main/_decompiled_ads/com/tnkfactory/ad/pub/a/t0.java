package com.tnkfactory.ad.pub.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.pub.model.EvtTrackUrls;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class t0 extends e {
    public static final /* synthetic */ int q = 0;
    public int n;
    public u0 o;
    public boolean p;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i < i4 - i2 ? 1 : 0;
            t0 t0Var = t0.this;
            if (t0Var.d.L != i9) {
                t0Var.f = false;
                t0Var.a(AdListener.CLOSE_SIMPLE, false);
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f2890b;

        public b(int i, boolean z) {
            this.a = i;
            this.f2890b = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            t0 t0Var = t0.this;
            t0Var.f = false;
            t0Var.a(this.a, this.f2890b);
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ com.tnkfactory.ad.pub.d a;

        public c(com.tnkfactory.ad.pub.d dVar) {
            this.a = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            com.tnkfactory.ad.pub.d dVar = this.a;
            dVar.r = true;
            dVar.c();
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            t0 t0Var = t0.this;
            int i = this.a;
            t0Var.setVisibility(8);
            t0Var.postDelayed(new v0(t0Var, i), t0Var.f2865b.getDuration());
            t0Var.startAnimation(t0Var.f2865b);
        }
    }

    public t0(Context context, int i, int i2, com.tnkfactory.ad.pub.a aVar) {
        super(context, i, i2, aVar, true);
        this.o = null;
        this.p = false;
        this.n = aVar.P;
    }

    public final k1 a(ViewParent viewParent) {
        if (viewParent != null) {
            return viewParent instanceof k1 ? (k1) viewParent : a(viewParent.getParent());
        }
        return null;
    }

    @Override // com.tnkfactory.ad.pub.a.e
    public final void a(int i, boolean z) {
        if (this.f) {
            View viewA = this.h.a(u.a("c77c179fed549e"));
            com.tnkfactory.ad.pub.d dVar = viewA instanceof com.tnkfactory.ad.pub.d ? (com.tnkfactory.ad.pub.d) viewA : null;
            if (dVar != null) {
                dVar.a();
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(Html.fromHtml(m0.a().e));
                builder.setMessage(m0.a().f);
                builder.setNegativeButton(Html.fromHtml(m0.a().g), new b(i, z));
                builder.setPositiveButton(Html.fromHtml(m0.a().h), new c(dVar));
                builder.setCancelable(false);
                builder.create().show();
                return;
            }
        }
        super.a(i, z);
        u0 u0Var = this.o;
        if (u0Var != null) {
            this.e.removeCallbacks(u0Var);
            this.o = null;
        }
        k1 k1VarA = a(getParent());
        if (k1VarA == null) {
            return;
        }
        k1VarA.setBackgroundColor(0);
        if (!z || this.f2865b == null || i == AdListener.CLOSE_EXIT) {
            k1 k1VarA2 = a(getParent());
            if (k1VarA2 != null) {
                k1VarA2.a();
            }
            j0 j0Var = this.c;
            if (j0Var != null) {
                j0Var.a(i);
            }
        } else {
            Iterator it = ((ArrayList) l0.a(this, com.tnkfactory.ad.pub.e.class)).iterator();
            while (it.hasNext()) {
                ((View) it.next()).setVisibility(8);
            }
            post(new d(i));
        }
        com.tnkfactory.ad.pub.a aVar = this.d;
        if (aVar != null) {
            EvtTrackUrls evtTrackUrls = aVar.g0;
            if (evtTrackUrls != null && !evtTrackUrls.skip.isEmpty()) {
                com.tnkfactory.ad.pub.c.a.a().a(this.d.g0.skip);
            }
            EvtTrackUrls evtTrackUrls2 = this.d.g0;
            if (evtTrackUrls2 == null || evtTrackUrls2.close.isEmpty()) {
                return;
            }
            com.tnkfactory.ad.pub.c.a.a().a(this.d.g0.close);
        }
    }

    @Override // com.tnkfactory.ad.pub.a.e
    public final void b() {
        addOnLayoutChangeListener(new a());
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        this.p = true;
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || !this.p) {
            return false;
        }
        this.p = false;
        int i2 = this.n;
        if (i2 >= 0) {
            a(i2, true);
        }
        return true;
    }
}

package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class TTAdDislikeDialog extends PAGFrameLayout {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTDislikeListView f526b;
    private TTDislikeListView c;
    private RelativeLayout d;
    private View e;
    private com.bytedance.sdk.openadsdk.dislike.c.g f;
    private com.bytedance.sdk.openadsdk.dislike.c.g g;
    private q h;
    private e i;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTAdDislikeDialog.this.n();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTAdDislikeDialog.this.r();
            if (TTAdDislikeDialog.this.i != null) {
                TTAdDislikeDialog.this.i.b(view);
            }
        }
    }

    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i);
                if (filterWord.hasSecondOptions()) {
                    TTAdDislikeDialog.this.a(filterWord);
                    if (TTAdDislikeDialog.this.i != null) {
                        TTAdDislikeDialog.this.i.a(i, filterWord);
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
            }
            if (TTAdDislikeDialog.this.i != null) {
                try {
                    TTAdDislikeDialog.this.i.a(i, TTAdDislikeDialog.this.h.W().get(i));
                } catch (Throwable unused2) {
                }
            }
            TTAdDislikeDialog.this.n();
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (TTAdDislikeDialog.this.i != null) {
                try {
                    TTAdDislikeDialog.this.i.a(i, (FilterWord) adapterView.getAdapter().getItem(i));
                } catch (Throwable unused) {
                }
            }
            TTAdDislikeDialog.this.n();
        }
    }

    public interface e {
        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);

        void c(View view);
    }

    public TTAdDislikeDialog(Context context, q qVar) {
        this(context.getApplicationContext());
        this.h = qVar;
        o();
    }

    private void o() {
        if (this.h == null) {
            return;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        com.bytedance.sdk.openadsdk.dislike.c.g gVar = new com.bytedance.sdk.openadsdk.dislike.c.g(layoutInflaterFrom, this.h.W());
        this.f = gVar;
        this.f526b.setAdapter((ListAdapter) gVar);
        com.bytedance.sdk.openadsdk.dislike.c.g gVar2 = new com.bytedance.sdk.openadsdk.dislike.c.g(layoutInflaterFrom, new ArrayList());
        this.g = gVar2;
        gVar2.a(false);
        this.c.setAdapter((ListAdapter) this.g);
        this.f526b.setMaterialMeta(this.h.N());
        this.c.setMaterialMeta(this.h.N());
    }

    private void p() {
        this.d = (RelativeLayout) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.j1);
        this.e = this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.m1);
        TextView textView = (TextView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.k1);
        TextView textView2 = (TextView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.l1);
        textView.setText(t.k(getContext(), "tt_dislike_header_tv_back"));
        textView2.setText(t.k(getContext(), "tt_dislike_header_tv_title"));
        textView.setOnClickListener(new b());
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.n1);
        this.f526b = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new c());
        TTDislikeListView tTDislikeListView2 = (TTDislikeListView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.o1);
        this.c = tTDislikeListView2;
        tTDislikeListView2.setOnItemClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.f526b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        com.bytedance.sdk.openadsdk.dislike.c.g gVar = this.g;
        if (gVar != null) {
            gVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    public void n() {
        setVisibility(8);
        e eVar = this.i;
        if (eVar != null) {
            eVar.c(this);
        }
    }

    public void q() {
        m.a("TTAD.DisLD", "showDislike: ");
        if (this.a.getParent() == null) {
            addView(this.a);
        }
        r();
        setVisibility(0);
        e eVar = this.i;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public void setCallback(e eVar) {
        this.i = eVar;
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new a());
        setBackgroundColor(Color.parseColor("#80000000"));
        this.a = new com.bytedance.sdk.openadsdk.dislike.d().a(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = b0.a(getContext(), 20.0f);
        layoutParams.rightMargin = b0.a(getContext(), 20.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClickable(true);
        p();
        o();
    }

    public TTAdDislikeDialog(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTAdDislikeDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTAdDislikeDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.dislike.c.g gVar = this.g;
        if (gVar != null) {
            gVar.a(filterWord.getOptions());
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(0);
        }
        TTDislikeListView tTDislikeListView = this.f526b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView2 = this.c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(0);
        }
    }
}

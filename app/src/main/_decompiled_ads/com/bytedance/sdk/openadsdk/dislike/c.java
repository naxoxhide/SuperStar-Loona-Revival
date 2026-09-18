package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TTDislikeDialogDefault.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends TTDislikeDialogAbstract {
    private TTDislikeListView d;
    private TTDislikeListView e;
    private RelativeLayout f;
    private View g;
    private g h;
    private g i;
    private f j;
    private String k;
    private String l;
    private List<FilterWord> m;

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    class a implements DialogInterface.OnShowListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (c.this.j != null) {
                c.this.j.a();
            }
        }
    }

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.j != null) {
                c.this.j.c();
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.dislike.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    class ViewOnClickListenerC0228c implements View.OnClickListener {
        ViewOnClickListenerC0228c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.d();
            if (c.this.j != null) {
                c.this.j.b();
            }
        }
    }

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i);
                if (filterWord.hasSecondOptions()) {
                    c.this.a(filterWord);
                    if (c.this.j != null) {
                        c.this.j.a(i, filterWord);
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
            }
            if (c.this.j != null) {
                try {
                    c.this.j.a(i, (FilterWord) c.this.m.get(i));
                } catch (Throwable unused2) {
                }
            }
            c.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    class e implements AdapterView.OnItemClickListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.j != null) {
                try {
                    c.this.j.a(i, (FilterWord) adapterView.getAdapter().getItem(i));
                } catch (Throwable unused) {
                }
            }
            c.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    public interface f {
        void a();

        void a(int i, FilterWord filterWord);

        void b();

        void c();
    }

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    public static class g extends BaseAdapter {
        private boolean a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<FilterWord> f767b;
        private final LayoutInflater c;

        /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
        private static class a {
            TextView a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ImageView f768b;

            private a() {
            }

            /* synthetic */ a(a aVar) {
                this();
            }
        }

        public g(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f767b = list;
            this.c = layoutInflater;
        }

        public void a(boolean z) {
            this.a = z;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f767b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f767b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewA;
            a aVar;
            if (view == null) {
                aVar = new a(null);
                viewA = a(this.c.getContext());
                aVar.a = (TextView) viewA.findViewById(h.p1);
                aVar.f768b = (ImageView) viewA.findViewById(h.q1);
                viewA.setTag(aVar);
            } else {
                viewA = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f767b.get(i);
            aVar.a.setText(filterWord.getName());
            if (i != this.f767b.size() - 1) {
                aVar.a.setBackgroundResource(t.e(this.c.getContext(), "tt_dislike_middle_seletor"));
            } else {
                aVar.a.setBackgroundResource(t.e(this.c.getContext(), "tt_dislike_bottom_seletor"));
            }
            if (this.a && i == 0) {
                aVar.a.setBackgroundResource(t.e(this.c.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f768b.setVisibility(0);
            } else {
                aVar.f768b.setVisibility(8);
            }
            return viewA;
        }

        private View a(Context context) {
            PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
            pAGFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            PAGTextView pAGTextView = new PAGTextView(context);
            pAGTextView.setId(h.p1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b0.a(context, 44.0f));
            layoutParams.gravity = 17;
            pAGTextView.setLayoutParams(layoutParams);
            pAGTextView.setGravity(17);
            pAGTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
            pAGTextView.setTextSize(16.0f);
            PAGImageView pAGImageView = new PAGImageView(context);
            pAGImageView.setId(h.q1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b0.a(context, 44.0f), b0.a(context, 44.0f));
            layoutParams2.gravity = 8388629;
            pAGImageView.setLayoutParams(layoutParams2);
            pAGImageView.setRotation(180.0f);
            pAGImageView.setScaleType(ImageView.ScaleType.CENTER);
            pAGImageView.setImageResource(t.e(context, "tt_lefterbackicon_titlebar_press_wrapper"));
            pAGFrameLayout.addView(pAGTextView);
            pAGFrameLayout.addView(pAGImageView);
            return pAGFrameLayout;
        }

        public void a(List<FilterWord> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.f767b.clear();
            this.f767b.addAll(list);
            notifyDataSetChanged();
        }

        public void a() {
            this.f767b.clear();
            notifyDataSetChanged();
        }
    }

    public c(Context context, String str, List<FilterWord> list) {
        super(context, t.l(context, "tt_dislikeDialog"));
        this.l = str;
        this.m = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.g;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.d;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        g gVar = this.i;
        if (gVar != null) {
            gVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.e;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(b0.i(getContext()) - 120, -2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public View getLayoutView() {
        return new com.bytedance.sdk.openadsdk.dislike.d().a(getContext());
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return new int[]{h.n1, h.o1};
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            c();
            a(getContext());
            b();
            setMaterialMeta(this.l, this.m);
        } catch (Throwable unused) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            d();
        } catch (WindowManager.BadTokenException unused) {
            m.a("dislike bad token");
        }
    }

    private void b() {
        setOnShowListener(new a());
        setOnDismissListener(new b());
        g gVar = new g(getLayoutInflater(), this.m);
        this.h = gVar;
        this.d.setAdapter((ListAdapter) gVar);
        g gVar2 = new g(getLayoutInflater(), new ArrayList());
        this.i = gVar2;
        gVar2.a(false);
        this.e.setAdapter((ListAdapter) this.i);
    }

    private void c() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 50;
            window.setAttributes(attributes);
        }
    }

    public void a(String str, List<FilterWord> list) {
        g gVar = this.h;
        if (gVar == null || this.m == null || str == null) {
            return;
        }
        this.l = str;
        this.m = list;
        gVar.a(list);
        setMaterialMeta(str, list);
    }

    public void a(f fVar) {
        this.j = fVar;
    }

    public void a(String str) {
        this.k = str;
    }

    private void a(Context context) {
        this.f = (RelativeLayout) findViewById(h.j1);
        this.g = findViewById(h.m1);
        TextView textView = (TextView) findViewById(h.k1);
        TextView textView2 = (TextView) findViewById(h.l1);
        textView.setText(t.k(getContext(), "tt_dislike_header_tv_back"));
        textView2.setText(t.k(getContext(), "tt_dislike_header_tv_title"));
        textView.setOnClickListener(new ViewOnClickListenerC0228c());
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(h.n1);
        this.d = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new d());
        this.d.setClosedListenerKey(this.k);
        TTDislikeListView tTDislikeListView2 = (TTDislikeListView) findViewById(h.o1);
        this.e = tTDislikeListView2;
        tTDislikeListView2.setOnItemClickListener(new e());
        this.e.setClosedListenerKey(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        g gVar = this.i;
        if (gVar != null) {
            gVar.a(filterWord.getOptions());
        }
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        View view = this.g;
        if (view != null) {
            view.setVisibility(0);
        }
        TTDislikeListView tTDislikeListView = this.d;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView2 = this.e;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(0);
        }
    }
}

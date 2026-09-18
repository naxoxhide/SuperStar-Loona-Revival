package com.bytedance.sdk.openadsdk.b.m.p;

import android.R;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;

/* JADX INFO: compiled from: RewardFullDislikeManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private final com.bytedance.sdk.openadsdk.b.m.p.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTAdDislikeDialog f491b;
    private TTAdDislikeToast c;

    public c(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.c.a(TTAdDislikeToast.getDislikeSendTip());
    }

    public void a() {
        TTAdDislikeToast tTAdDislikeToast = this.c;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.o();
        }
    }

    public void b(com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
        if (this.a.V.isFinishing()) {
            return;
        }
        if (this.a.w.get()) {
            this.c.a(TTAdDislikeToast.getDislikeTip());
        } else {
            a(bVar);
            this.f491b.q();
        }
    }

    /* JADX INFO: compiled from: RewardFullDislikeManager.java */
    class a implements TTAdDislikeDialog.e {
        final /* synthetic */ com.bytedance.sdk.openadsdk.b.m.q.b a;

        a(com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
            this.a = bVar;
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(View view) {
            c.this.a.v.set(true);
            this.a.z();
            if (c.this.a.G.w()) {
                c.this.a.G.B();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void b(View view) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void c(View view) {
            c.this.a.v.set(false);
            c.this.a.G.a(this.a);
            if (c.this.a.G.v()) {
                c.this.a.G.E();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(int i, FilterWord filterWord) {
            if (c.this.a.w.get() || filterWord == null || filterWord.hasSecondOptions()) {
                return;
            }
            c.this.a.w.set(true);
            c.this.c();
        }
    }

    private void a(com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
        if (this.f491b == null) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
            TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog(aVar.V, aVar.a);
            this.f491b = tTAdDislikeDialog;
            tTAdDislikeDialog.setCallback(new a(bVar));
            ((FrameLayout) this.a.V.findViewById(R.id.content)).addView(this.f491b);
        }
        if (this.c == null) {
            this.c = new TTAdDislikeToast(this.a.V);
            ((FrameLayout) this.a.V.findViewById(R.id.content)).addView(this.c);
        }
    }

    public void b() {
        TTAdDislikeToast tTAdDislikeToast = this.c;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.n();
        }
    }
}

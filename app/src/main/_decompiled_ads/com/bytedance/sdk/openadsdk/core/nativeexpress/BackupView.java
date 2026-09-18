package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BackupView extends PAGFrameLayout {
    protected Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected q f646b;
    protected com.bytedance.sdk.openadsdk.dislike.b c;
    protected TTDislikeDialogAbstract d;
    protected String e;
    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected String k;
    private com.bytedance.sdk.openadsdk.d.g l;

    class a implements com.bytedance.sdk.openadsdk.core.nativeexpress.a {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a
        public void a(View view, int i, com.bytedance.sdk.openadsdk.core.f0.m mVar) {
            BackupView.this.a(view, i, mVar);
        }
    }

    class b implements NativeVideoTsView.i {
        b(BackupView backupView) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.i
        public void a(boolean z, long j, long j2, long j3, boolean z2) {
        }
    }

    public BackupView(Context context) {
        super(context);
        this.e = "embeded_ad";
        this.i = true;
        this.j = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    protected abstract void a(View view, int i, com.bytedance.sdk.openadsdk.core.f0.m mVar);

    protected void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.c0.b bVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.a;
            q qVar = this.f646b;
            String str = this.e;
            bVar = new com.bytedance.sdk.openadsdk.core.c0.a(context, qVar, str, a0.f(str));
        } else {
            Context context2 = this.a;
            q qVar2 = this.f646b;
            String str2 = this.e;
            bVar = new com.bytedance.sdk.openadsdk.core.c0.b(context2, qVar2, str2, a0.f(str2));
        }
        view.setOnTouchListener(bVar);
        view.setOnClickListener(bVar);
        bVar.a(new a());
    }

    protected void e(int i) {
        this.j = com.bytedance.sdk.openadsdk.core.o.d().f(String.valueOf(this.h));
        int iB = com.bytedance.sdk.openadsdk.core.o.d().b(i);
        if (3 == iB) {
            this.i = false;
            return;
        }
        int iB2 = com.bytedance.sdk.component.utils.p.b(com.bytedance.sdk.openadsdk.core.o.a());
        if (1 == iB && a0.h(iB2)) {
            this.i = true;
            return;
        }
        if (2 == iB) {
            if (a0.f(iB2) || a0.h(iB2) || a0.g(iB2)) {
                this.i = true;
                return;
            }
            return;
        }
        if (5 == iB) {
            if (a0.h(iB2) || a0.g(iB2)) {
                this.i = true;
            }
        }
    }

    protected String getDescription() {
        if (TextUtils.isEmpty(this.f646b.K0())) {
            return !TextUtils.isEmpty(this.f646b.B()) ? this.f646b.B() : "";
        }
        return this.f646b.K0();
    }

    protected String getNameOrSource() {
        q qVar = this.f646b;
        if (qVar == null) {
            return "";
        }
        if (qVar.h() == null || TextUtils.isEmpty(this.f646b.h().a())) {
            return !TextUtils.isEmpty(this.f646b.F0()) ? this.f646b.F0() : "";
        }
        return this.f646b.h().a();
    }

    public float getRealHeight() {
        return b0.b(this.a, this.g);
    }

    public float getRealWidth() {
        return b0.b(this.a, this.f);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    protected String getTitle() {
        if (this.f646b.h() != null && !TextUtils.isEmpty(this.f646b.h().a())) {
            return this.f646b.h().a();
        }
        if (TextUtils.isEmpty(this.f646b.F0())) {
            return !TextUtils.isEmpty(this.f646b.K0()) ? this.f646b.K0() : "";
        }
        return this.f646b.F0();
    }

    protected NativeVideoTsView getVideoView() {
        NativeVideoTsView nativeVideoTsView;
        q qVar = this.f646b;
        if (qVar != null && this.a != null) {
            if (q.c(qVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.a, this.f646b, this.e, true, false, this.l);
                    nativeVideoTsView.setVideoCacheUrl(this.k);
                    nativeVideoTsView.setControllerStatusCallBack(new b(this));
                    nativeVideoTsView.setIsAutoPlay(this.i);
                    nativeVideoTsView.setIsQuiet(this.j);
                } catch (Throwable unused) {
                    nativeVideoTsView = null;
                }
            } else {
                nativeVideoTsView = null;
            }
            if (q.c(this.f646b) && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                return nativeVideoTsView;
            }
        }
        return null;
    }

    public void setDislikeInner(t tVar) {
        if (tVar instanceof com.bytedance.sdk.openadsdk.dislike.b) {
            this.c = (com.bytedance.sdk.openadsdk.dislike.b) tVar;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        q qVar;
        if (tTDislikeDialogAbstract != null && (qVar = this.f646b) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(qVar.N(), this.f646b.W());
        }
        this.d = tTDislikeDialogAbstract;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public BackupView(Context context, String str) {
        super(context);
        this.e = "embeded_ad";
        this.i = true;
        this.j = true;
        this.k = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    protected void a(View view) {
        q qVar = this.f646b;
        if (qVar == null || qVar.N0() == null || view == null) {
            return;
        }
        if (this.f646b.V() == 1 && this.i) {
            a(view, true);
        } else {
            a(view, false);
        }
    }
}

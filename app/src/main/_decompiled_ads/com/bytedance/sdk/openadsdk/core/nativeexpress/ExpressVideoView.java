package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    private boolean O;

    public ExpressVideoView(Context context, q qVar, String str, com.bytedance.sdk.openadsdk.d.g gVar) {
        super(context, qVar, false, str, false, false, gVar);
        this.O = false;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    private void Q() {
        b0.a((View) this.o, 0);
        b0.a((View) this.p, 0);
        b0.a((View) this.r, 8);
    }

    private void S() {
        D();
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.n.c.b().a(this.f679b.N0().b(), this.f679b.N0().c(), this.f679b.N0().a(), this.p, this.f679b);
            }
        }
        Q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void C() {
        if (!this.i || !p.b(this.t)) {
            this.g = false;
        }
        super.C();
    }

    public void R() {
        ImageView imageView = this.r;
        if (imageView != null) {
            b0.a((View) imageView, 8);
        }
    }

    protected void T() {
        D();
        b0.a((View) this.o, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void b(boolean z) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.q;
        if (imageView != null && imageView.getVisibility() == 0) {
            b0.d(this.o);
        }
        x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.q;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            S();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        ImageView imageView = this.q;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            S();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.O = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public void setShowAdInteractionView(boolean z) {
        b.a.a.a.a.a.a.g.b bVarG;
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar == null || (bVarG = cVar.g()) == null) {
            return;
        }
        bVarG.a(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void x() {
        if (this.O) {
            super.x();
        }
    }
}

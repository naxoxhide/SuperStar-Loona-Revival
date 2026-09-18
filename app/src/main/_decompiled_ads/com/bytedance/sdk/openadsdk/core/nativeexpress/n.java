package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: NativeRender.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends b.b.a.a.d.f.a<BackupView> {
    private BackupView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f659b;
    private b.b.a.a.d.f.c c;
    private b.b.a.a.d.f.g d;
    private b.b.a.a.d.f.m e;
    AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: compiled from: NativeRender.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.c();
        }
    }

    public n(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, b.b.a.a.d.f.m mVar) {
        this.f659b = view;
        this.e = mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f.get()) {
            return;
        }
        b.b.a.a.d.f.c cVar = this.c;
        boolean z = false;
        if (cVar != null && cVar.a((NativeExpressView) this.f659b, 0)) {
            z = true;
        }
        if (!z) {
            this.d.a(107);
            return;
        }
        this.e.o().h();
        BackupView backupView = (BackupView) this.f659b.findViewWithTag("tt_express_backup_fl_tag_26");
        this.a = backupView;
        if (backupView == null) {
            this.d.a(107);
            return;
        }
        b.b.a.a.d.f.n nVar = new b.b.a.a.d.f.n();
        float realWidth = backupView == null ? 0.0f : backupView.getRealWidth();
        BackupView backupView2 = this.a;
        float realHeight = backupView2 != null ? backupView2.getRealHeight() : 0.0f;
        nVar.b(true);
        nVar.b(realWidth);
        nVar.a(realHeight);
        this.d.a(this.a, nVar);
    }

    @Override // b.b.a.a.d.f.d
    public void a(b.b.a.a.d.f.g gVar) {
        this.d = gVar;
        y.a(new a());
    }

    @Override // b.b.a.a.d.f.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BackupView e() {
        return this.a;
    }

    @Override // b.b.a.a.d.f.a
    public void a(b.b.a.a.d.f.c cVar) {
        this.c = cVar;
    }
}

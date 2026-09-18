package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.List;

/* JADX INFO: compiled from: TTAdDislikeImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements t {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f766b;
    private t.a c;

    /* JADX INFO: compiled from: TTAdDislikeImpl.java */
    class a implements c.f {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.dislike.c.f
        public void a() {
            m.a("TTAdDislikeImpl", "onDislikeShow: ");
        }

        @Override // com.bytedance.sdk.openadsdk.dislike.c.f
        public void b() {
            m.b("TTAdDislikeImpl", "onDislikeOptionBack: ");
        }

        @Override // com.bytedance.sdk.openadsdk.dislike.c.f
        public void c() {
            m.b("TTAdDislikeImpl", "onDislikeDismiss: ");
            try {
                if (b.this.c != null) {
                    b.this.c.a();
                }
            } catch (Throwable th) {
                m.b("TTAdDislikeImpl", "dislike callback cancel error: ", th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.dislike.c.f
        public void a(int i, FilterWord filterWord) {
            try {
                if (!filterWord.hasSecondOptions() && b.this.c != null) {
                    b.this.c.a(i, filterWord.getName());
                }
                m.b("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + String.valueOf(filterWord.getName()));
            } catch (Throwable th) {
                m.b("TTAdDislikeImpl", "dislike callback selected error: ", th);
            }
        }
    }

    public b(Context context, String str, List<FilterWord> list) {
        if (!(context instanceof Activity)) {
            m.b("Dislike Initialization must use activity, please pass in TTAdManager.createAdNative(activity)");
        }
        this.a = context;
        a(str, list);
    }

    public void b(String str, List<FilterWord> list) {
        this.f766b.a(str, list);
    }

    private void a(String str, List<FilterWord> list) {
        c cVar = new c(this.a, str, list);
        this.f766b = cVar;
        cVar.a(new a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void a() {
        Context context = this.a;
        if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.f766b.isShowing()) {
            return;
        }
        this.f766b.show();
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void a(t.a aVar) {
        this.c = aVar;
    }

    public void a(String str) {
        c cVar = this.f766b;
        if (cVar != null) {
            cVar.a(str);
        }
    }
}

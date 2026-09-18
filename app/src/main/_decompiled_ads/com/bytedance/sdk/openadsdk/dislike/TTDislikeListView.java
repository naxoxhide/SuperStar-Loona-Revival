package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class TTDislikeListView extends ListView {
    private AdapterView.OnItemClickListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f764b;
    private String c;
    protected IListenerManager d;
    private AdapterView.OnItemClickListener e;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                throw new IllegalArgumentException("Adapter data is abnormal, it must be FilterWord");
            }
            FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
            if (!filterWord.hasSecondOptions()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                if (!TextUtils.isEmpty(TTDislikeListView.this.f764b)) {
                    com.bytedance.sdk.openadsdk.dislike.a.a().a(TTDislikeListView.this.f764b, arrayList);
                }
                if (!TextUtils.isEmpty(TTDislikeListView.this.c)) {
                    if (com.bytedance.sdk.openadsdk.m.b.b()) {
                        TTDislikeListView.this.a("onItemClickClosed");
                    } else {
                        com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVarC = h.a().c(TTDislikeListView.this.c);
                        if (hVarC != null) {
                            hVarC.onItemClickClosed();
                            h.a().f(TTDislikeListView.this.c);
                        }
                    }
                }
            }
            try {
                if (TTDislikeListView.this.a != null) {
                    TTDislikeListView.this.a.onItemClick(adapterView, view, i, j);
                }
            } catch (Throwable unused) {
            }
        }
    }

    class b extends g {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(TTDislikeListView.this.c)) {
                    return;
                }
                TTDislikeListView.this.a(6).executeDisLikeClosedCallback(TTDislikeListView.this.c, this.c);
            } catch (Throwable th) {
                m.b("TTDislikeListView", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }
    }

    static class c extends g {
        final /* synthetic */ int c;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.bannerexpress.a.h d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, int i, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVar, String str2) {
            super(str);
            this.c = i;
            this.d = hVar;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.multipro.aidl.a aVarC = com.bytedance.sdk.openadsdk.multipro.aidl.a.c();
            if (this.c == 6 && this.d != null) {
                try {
                    m.a("TTDislikeListView", "start registerDislikeClickCloseListener ! ");
                    com.bytedance.sdk.openadsdk.multipro.aidl.e.b bVar = new com.bytedance.sdk.openadsdk.multipro.aidl.e.b(this.e, this.d);
                    IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(aVarC.a(6));
                    if (iListenerManagerAsInterface != null) {
                        iListenerManagerAsInterface.registerDisLikeClosedListener(this.e, bVar);
                        m.a("TTDislikeListView", "end registerDislikeClickCloseListener ! ");
                    }
                } catch (RemoteException e) {
                    m.b("TTDislikeListView", e.getMessage());
                    m.a("TTDislikeListView", "multiProcess registerDislikeClickCloseListener error");
                }
            }
        }
    }

    static class d extends g {
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, int i, String str2) {
            super(str);
            this.c = i;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.multipro.aidl.a aVarC = com.bytedance.sdk.openadsdk.multipro.aidl.a.c();
            if (this.c != 6) {
                return;
            }
            try {
                m.a("TTDislikeListView", "start unregisterDislikeClickCloseListener ! ");
                IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(aVarC.a(6));
                if (iListenerManagerAsInterface != null) {
                    iListenerManagerAsInterface.unregisterDisLikeClosedListener(this.d);
                    m.a("TTDislikeListView", "end unregisterDislikeClickCloseListener ! ");
                }
            } catch (RemoteException unused) {
                m.a("TTDislikeListView", "multiProcess unregisterMultiProcessListener error");
            }
        }
    }

    public TTDislikeListView(Context context) {
        super(context);
        this.e = new a();
        a();
    }

    public void setClosedListenerKey(String str) {
        this.c = str;
    }

    public void setMaterialMeta(String str) {
        this.f764b = str;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.a = onItemClickListener;
    }

    private void a() {
        super.setOnItemClickListener(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        y.a(new b("Reward_executeMultiProcessCallback", str), 5);
    }

    protected IListenerManager a(int i) {
        if (this.d == null) {
            this.d = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.c().a(i));
        }
        return this.d;
    }

    public static void a(int i, String str, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVar) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            y.a(new c("DislikeClosed_registerMultiProcessListener", i, hVar, str), 5);
        }
    }

    public static void a(int i, String str) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            y.a(new d("DislikeClosed_unregisterMultiProcessListener", i, str), 5);
        }
    }
}

package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.m.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends TTBaseActivity {
    private static final Map<String, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h> c = Collections.synchronizedMap(new HashMap());
    private Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f401b;

    private void i() {
        int intExtra = this.a.getIntExtra("type", 0);
        if (intExtra != 1) {
            if (intExtra != 6) {
                finish();
            } else {
                a(this.a.getStringExtra("ext_info"), this.a.getStringExtra("filter_words"), this.a.getStringExtra("closed_listener_key"));
            }
        }
    }

    private void j() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!l.e()) {
            finish();
            return;
        }
        j();
        this.a = getIntent();
        if (o.a() == null) {
            o.a(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (o.a() == null) {
            o.a(this);
        }
        setIntent(intent);
        this.a = intent;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.a != null) {
            i();
        }
    }

    public static void a(q qVar, String str, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVar) {
        if (qVar == null) {
            return;
        }
        Intent intent = new Intent(o.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("ext_info", qVar.N());
        intent.putExtra("filter_words", com.bytedance.sdk.openadsdk.tool.a.a(qVar.W()));
        intent.putExtra("closed_listener_key", str);
        if (hVar != null) {
            if (b.b()) {
                h.a().a(str, hVar);
            } else {
                c.put(str, hVar);
            }
        }
        if (o.a() != null) {
            o.a().startActivity(intent);
        }
    }

    class a implements t.a {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.t.a
        public void a(int i, String str) {
            com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVar;
            m.d("showDislike", "closedListenerKey=" + this.a + ",onSelected->position=" + i + ",value=" + str);
            if (TTDelegateActivity.c != null && TTDelegateActivity.c.size() > 0 && !TextUtils.isEmpty(this.a) && !b.b() && (hVar = (com.bytedance.sdk.openadsdk.core.bannerexpress.a.h) TTDelegateActivity.c.get(this.a)) != null) {
                hVar.onItemClickClosed();
            }
            TTDelegateActivity.this.a(this.a);
            TTDelegateActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.core.t.a
        public void a() {
            TTDelegateActivity.this.a(this.a);
            TTDelegateActivity.this.finish();
        }
    }

    public static void a(q qVar, String str) {
        a(qVar, str, (com.bytedance.sdk.openadsdk.core.bannerexpress.a.h) null);
    }

    private void a(String str, String str2, String str3) {
        if (str2 != null && str != null && this.f401b == null) {
            com.bytedance.sdk.openadsdk.dislike.b bVar = new com.bytedance.sdk.openadsdk.dislike.b(this, str, com.bytedance.sdk.openadsdk.tool.a.a(str2));
            this.f401b = bVar;
            bVar.a(str3);
            this.f401b.a(new a(str3));
        }
        t tVar = this.f401b;
        if (tVar != null) {
            tVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        m.d("showDislike", "removeDislikeListener....closedListenerKey=" + str);
        Map<String, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h> map = c;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.remove(str);
        if (m.c()) {
            m.d("showDislike", "removeDislikeListener....mListenerMap.size:" + map.size());
        }
    }
}

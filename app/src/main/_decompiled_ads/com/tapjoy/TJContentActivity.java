package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tapjoy.internal.t1;
import com.tapjoy.internal.v1;

/* JADX INFO: loaded from: classes4.dex */
public class TJContentActivity extends Activity {
    public static volatile ContentProducer c;
    public ContentProducer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2687b = false;

    public static abstract class AbstractContentProducer implements ContentProducer {
        @Override // com.tapjoy.TJContentActivity.ContentProducer
        public void dismiss(Activity activity) {
        }

        @Override // com.tapjoy.TJContentActivity.ContentProducer
        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        }
    }

    public interface ContentProducer {
        void dismiss(Activity activity);

        void onActivityResult(Activity activity, int i, int i2, Intent intent);

        void show(Activity activity);
    }

    public static void start(Context context, ContentProducer contentProducer, boolean z) {
        Intent intent = new Intent(context, (Class<?>) TJContentActivity.class);
        intent.setFlags(276889600);
        intent.putExtra("com.tapjoy.internal.content.producer.id", toIdentityString(contentProducer));
        intent.putExtra("com.tapjoy.internal.content.fullscreen", z);
        synchronized (TJContentActivity.class) {
            c = contentProducer;
            context.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        this.a.onActivityResult(this, i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        boolean z = true;
        requestWindowFeature(1);
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("com.tapjoy.internal.content.producer.id");
        if (stringExtra == null) {
            z = false;
        } else {
            synchronized (TJContentActivity.class) {
                if (c == null || !stringExtra.equals(toIdentityString(c))) {
                    z = false;
                } else {
                    this.a = c;
                    c = null;
                    if (intent.getBooleanExtra("com.tapjoy.internal.content.fullscreen", false)) {
                        getWindow().setFlags(1024, 1024);
                    }
                    this.a.show(this);
                }
            }
        }
        if (z) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        ContentProducer contentProducer = this.a;
        if (contentProducer != null) {
            contentProducer.dismiss(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        if (v1.m.j) {
            this.f2687b = true;
            t1.a(this);
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        if (this.f2687b) {
            this.f2687b = false;
            t1.b(this);
        }
        super.onStop();
    }

    public static String toIdentityString(Object obj) {
        return obj == null ? "null" : obj.getClass().getName() + "" + System.identityHashCode(obj);
    }
}

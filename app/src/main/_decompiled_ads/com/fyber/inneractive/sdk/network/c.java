package com.fyber.inneractive.sdk.network;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.fyber.inneractive.sdk.util.j0 {
    public Handler d;
    public int e;
    public final BlockingQueue<JSONObject> a = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONArray f981b = new JSONArray();
    public boolean f = false;
    public boolean g = false;
    public final HandlerThread c = new HandlerThread("EventCollectorHandlerThread", 0);

    public class a implements Runnable {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f982b;

        public a(int i, long j) {
            this.a = i;
            this.f982b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d.sendEmptyMessageDelayed(this.a, this.f982b);
        }
    }

    public final void a(int i, long j) {
        Handler handler = this.d;
        if (handler != null) {
            handler.post(new a(i, j));
        }
    }

    @Override // com.fyber.inneractive.sdk.util.j0
    public void handleMessage(Message message) {
        String string;
        int i = message.what;
        if (i == 12312329 || i == 20150330) {
            if (this.f && this.a.size() > 0) {
                while (true) {
                    JSONObject jSONObjectPoll = null;
                    string = null;
                    if (this.a.size() <= 0) {
                        break;
                    }
                    try {
                        jSONObjectPoll = this.a.poll();
                    } catch (Throwable unused) {
                    }
                    if (jSONObjectPoll != null) {
                        this.f981b.put(jSONObjectPoll);
                    }
                }
                if (this.f981b.length() > 0) {
                    JSONArray jSONArray = this.f981b;
                    String strB = com.fyber.inneractive.sdk.config.a.b();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        string = jSONArray.toString();
                    } catch (Throwable unused2) {
                    }
                    if (string != null) {
                        i0 i0Var = new i0(new e(this, strB, jSONArray, jCurrentTimeMillis), strB, string, x.a().b());
                        IAConfigManager.M.s.a.offer(i0Var);
                        i0Var.a(q0.QUEUED);
                    }
                    this.f981b = new JSONArray();
                }
            }
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(12312329);
                a(12312329, this.e * 1000);
            }
        }
    }

    public void a(int i) {
        this.f = true;
        this.e = i;
        Handler handler = this.d;
        if (handler != null && handler.hasMessages(12312329)) {
            this.d.removeMessages(12312329);
        }
        a(12312329, this.e * 1000);
    }
}

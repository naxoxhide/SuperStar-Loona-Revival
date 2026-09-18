package com.mbridge.msdk.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportMonitor.java */
/* JADX INFO: loaded from: classes4.dex */
public class t {
    private static volatile t d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m f2053b;
    private w c;
    private volatile boolean e = false;
    private int f = 30000;
    private final HashMap<String, String> g = new HashMap<>();
    Handler a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.e.t.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                t.this.c();
                t.this.a.removeMessages(1);
                t.this.d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private t() {
    }

    public final void a(Context context, w wVar, int i, JSONObject jSONObject) {
        this.c = wVar;
        this.f = i;
        m mVarA = m.a("monitor", context, wVar);
        this.f2053b = mVarA;
        if (mVarA != null) {
            mVarA.a(jSONObject);
            this.f2053b.a();
        }
        b();
    }

    public static t a() {
        if (d == null) {
            synchronized (t.class) {
                if (d == null) {
                    d = new t();
                }
            }
        }
        return d;
    }

    public final synchronized void b() {
        if (this.e) {
            return;
        }
        this.e = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.a.sendEmptyMessageDelayed(1, this.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005a A[Catch: Exception -> 0x00af, TRY_LEAVE, TryCatch #0 {Exception -> 0x00af, blocks: (B:5:0x0008, B:7:0x000d, B:9:0x001b, B:12:0x002e, B:15:0x003a, B:18:0x005a, B:23:0x00a8, B:20:0x0074), top: B:28:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[SYNTHETIC] */
    public final void c() {
        m[] mVarArrD = m.d();
        if (mVarArrD.length == 0) {
            return;
        }
        try {
            for (m mVar : mVarArrD) {
                String strC = mVar.c();
                if (!"monitor".equals(strC)) {
                    String strB = mVar.b();
                    long[] jArrF = mVar.f();
                    long j = jArrF[1];
                    if (j != 0) {
                        long j2 = jArrF[0];
                        if (this.g.containsKey(strC)) {
                            if (!(j2 + "").equals(this.g.get(strC))) {
                                this.g.put(strC, j2 + "");
                                if (this.f2053b != null) {
                                    try {
                                        e eVar = new e("event_lib_monitor");
                                        eVar.b(1);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put(SDKConstants.PARAM_KEY, "m_report_rate");
                                        jSONObject.put("task_name", strC);
                                        jSONObject.put("task_count", j);
                                        jSONObject.put("task_session_id", strB);
                                        jSONObject.put("task_ts", j2);
                                        eVar.a(jSONObject);
                                        this.f2053b.a(eVar);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            this.g.put(strC, j2 + "");
                            if (this.f2053b != null) {
                                e eVar2 = new e("event_lib_monitor");
                                eVar2.b(1);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(SDKConstants.PARAM_KEY, "m_report_rate");
                                jSONObject2.put("task_name", strC);
                                jSONObject2.put("task_count", j);
                                jSONObject2.put("task_session_id", strB);
                                jSONObject2.put("task_ts", j2);
                                eVar2.a(jSONObject2);
                                this.f2053b.a(eVar2);
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

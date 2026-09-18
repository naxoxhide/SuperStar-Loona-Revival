package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ai;
import com.tapjoy.TapjoyConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: MBRevenueBatchReportManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l {
    private static final String a = "l";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile l f2178b = null;
    private static String c = "roas";
    private com.mbridge.msdk.e.m d;
    private Handler e;
    private int f;
    private long g;
    private String h;
    private BatchReportDao i;
    private AtomicInteger j;
    private Stack<Long> k;
    private Executor l = Executors.newSingleThreadExecutor();
    private volatile int m;
    private boolean n;

    private l() {
        com.mbridge.msdk.c.a aVarH;
        com.mbridge.msdk.e.o oVar;
        this.f = 1;
        this.g = 0L;
        this.h = com.mbridge.msdk.foundation.same.net.f.d.a().H;
        this.m = 0;
        this.n = false;
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB != null && (aVarH = cVarB.h()) != null) {
            this.f = aVarH.f();
            this.g = ((long) aVarH.g()) * 1000;
            this.h = com.mbridge.msdk.foundation.same.net.f.d.a().H;
            this.m = aVarH.h();
            boolean z = aVarH.a() == 1;
            this.n = z;
            if (z && this.m != 1) {
                int iA = ac.a().a("bcp", "type", ac.a().a("t_r_t", 0));
                if (iA != 0 && iA != 1) {
                    iA = 0;
                }
                w.a aVarA = new w.a().a(new i()).a(new u());
                if (iA == 1) {
                    oVar = new com.mbridge.msdk.e.o(new t((byte) 2), com.mbridge.msdk.foundation.same.net.f.d.a().i, com.mbridge.msdk.foundation.same.net.f.d.a().m);
                } else {
                    oVar = new com.mbridge.msdk.e.o(new com.mbridge.msdk.e.a.a.g(), com.mbridge.msdk.foundation.same.net.f.d.a().H, 0);
                }
                this.d = com.mbridge.msdk.e.m.a(c, com.mbridge.msdk.foundation.controller.b.d().g(), aVarA.a(iA, oVar).e(ac.a().a("t_m_e_t", 604800000)).a(ac.a().a("t_m_e_s", 50)).d(ac.a().a("t_m_r_c", 50)).b(ac.a().a("t_m_t", 15000)).c(ac.a().a("t_m_r_t_s", 2)).a());
                JSONObject jSONObjectC = h.c();
                try {
                    jSONObjectC.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, com.mbridge.msdk.foundation.tools.w.s(com.mbridge.msdk.foundation.controller.b.d().g()) ? "pad" : "phone");
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                        jSONObjectC.put(com.mbridge.msdk.foundation.same.net.g.d.d, com.mbridge.msdk.foundation.tools.w.s());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.d.a(jSONObjectC);
                this.d.a();
            }
        }
        aa.a(a, "初始化批量上报： " + this.h + " " + this.f + " " + this.g + " " + this.m);
        this.j = new AtomicInteger(0);
        this.k = new Stack<>();
        this.i = BatchReportDao.getInstance(com.mbridge.msdk.foundation.controller.b.d().g());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.e = new Handler(handlerThread.getLooper()) { // from class: com.mbridge.msdk.foundation.same.report.l.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) throws Throwable {
                int i = message.what;
                if (i == 1) {
                    Bundle data = message.getData();
                    if (l.this.e == null || l.this.i == null || data == null) {
                        return;
                    }
                    l.this.e.removeMessages(2);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ArrayList<BatchReportMessage> batchReportMessages = l.this.i.getBatchReportMessages(jCurrentTimeMillis, 2);
                    l.a(l.this, batchReportMessages, jCurrentTimeMillis);
                    l.this.j.set(0);
                    aa.a(l.a, "超时上报触发了，需要上报的数据： " + (batchReportMessages != null ? batchReportMessages.size() : 0));
                    return;
                }
                if (i == 2) {
                    Bundle data2 = message.getData();
                    if (l.this.e == null || l.this.i == null || data2 == null) {
                        return;
                    }
                    l.this.e.removeMessages(1);
                    long j = data2.getLong("last_report_time");
                    ArrayList<BatchReportMessage> batchReportMessages2 = l.this.i.getBatchReportMessages(j, 2);
                    l.a(l.this, batchReportMessages2, j);
                    aa.a(l.a, "队列上报触发了，需要上报的数据： " + (batchReportMessages2 != null ? batchReportMessages2.size() : 0));
                    return;
                }
                if (i == 3) {
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        l.b(l.this, data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                        return;
                    }
                    return;
                }
                if (i != 4) {
                    return;
                }
                Bundle data4 = message.getData();
                if (l.this.e == null || l.this.i == null || data4 == null || !l.this.n) {
                    return;
                }
                l.this.e.removeMessages(4);
                ArrayList<BatchReportMessage> batchReportMessages3 = l.this.i.getBatchReportMessages(System.currentTimeMillis(), 2);
                if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                    for (int i2 = 0; i2 < batchReportMessages3.size(); i2++) {
                        BatchReportMessage batchReportMessage = batchReportMessages3.get(i2);
                        l.a(l.this, batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                    }
                }
                aa.a(l.a, "切换上报lib，需要上报的数据： " + (batchReportMessages3 != null ? batchReportMessages3.size() : 0));
            }
        };
    }

    public static synchronized l a() {
        if (f2178b == null) {
            f2178b = new l();
        }
        return f2178b;
    }

    public final void b() {
        Handler handler = this.e;
        if (handler == null || handler.hasMessages(1) || this.m == 1 || this.n) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        this.e.sendMessageDelayed(messageObtain, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        HashMap map = new HashMap();
        map.put("state", i + "");
        if (i == 2) {
            map.put("reason", str);
        }
        m.a().b("m_ad_rev_s_s", "roas", "", "", map);
    }

    public final synchronized void a(final String str) {
        if (this.m == 1) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.l.3
            @Override // java.lang.Runnable
            public final void run() {
                if (l.this.i == null) {
                    return;
                }
                aa.a(l.a, "接收到上报数据： " + str);
                if (!l.this.n) {
                    if (l.this.m != 1) {
                        l.a(l.this, str);
                    }
                } else {
                    l.a(l.this, str, 0L);
                    if (((Integer) ai.b(com.mbridge.msdk.foundation.controller.b.d().g(), "roas_use_event", 0)).intValue() == 0) {
                        ai.a(com.mbridge.msdk.foundation.controller.b.d().g(), "roas_use_event", 1);
                        l.this.e.sendEmptyMessage(4);
                    }
                }
            }
        };
        com.mbridge.msdk.foundation.controller.c.a();
        Executor executor = this.l;
        if (executor != null) {
            executor.execute(runnable);
        } else {
            runnable.run();
        }
    }

    private JSONObject b(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    jSONObject.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static /* synthetic */ void a(l lVar, ArrayList arrayList, long j) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("report_message", arrayList);
        bundle.putLong("last_report_time", j);
        messageObtain.setData(bundle);
        messageObtain.what = 3;
        lVar.e.sendMessage(messageObtain);
    }

    static /* synthetic */ void b(l lVar, final ArrayList arrayList, final long j) {
        if (arrayList != null && arrayList.size() > 0) {
            aa.a(a, "需要上报的数据条数： " + arrayList.size());
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (contextG == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.net.g.d dVarA = q.a(contextG);
            dVarA.a("app_id", com.mbridge.msdk.foundation.controller.b.d().h());
            dVarA.a("m_sdk", "msdk");
            dVarA.a("lqswt", String.valueOf(1));
            dVarA.a(TapjoyConstants.TJC_DEVICE_TYPE_NAME, com.mbridge.msdk.foundation.tools.w.s(contextG) ? "pad" : "phone");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                dVarA.a(com.mbridge.msdk.foundation.same.net.g.d.d, com.mbridge.msdk.foundation.tools.w.s());
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i);
                    if (batchReportMessage != null) {
                        sb.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                        if (i >= 0 && i < size - 1) {
                            sb.append("\n");
                        }
                    }
                } catch (Throwable th) {
                    aa.d(a, th.getMessage());
                }
            }
            try {
                String strEncode = URLEncoder.encode(sb.toString(), "utf-8");
                dVarA.a("data", strEncode);
                aa.a(a, "需要批量上报的数据： " + strEncode);
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.b.d().g());
                lVar.a(0, "");
                aVar.post(0, lVar.h, dVarA, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.l.2
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str) {
                        aa.a(l.a, "批量上报成功");
                        l.this.a(1, "");
                        try {
                            if (l.this.i != null) {
                                l.this.i.deleteBatchReportMessagesByTimestamp(j);
                            }
                        } catch (Exception e) {
                            aa.d(l.a, e.getMessage());
                        }
                        synchronized (l.this.k) {
                            l.this.k.clear();
                        }
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str) {
                        Stack stack;
                        aa.a(l.a, "批量上报失败： " + str);
                        l.this.a(2, str);
                        synchronized (l.this.k) {
                            l.this.k.add(Long.valueOf(j));
                            if (l.this.i != null) {
                                l.this.i.updateMessagesReportState(arrayList);
                            }
                            if (l.this.k.size() >= 5) {
                                aa.a(l.a, "批量上报失败，上报失败的数据超过阈值");
                                try {
                                    try {
                                        l.this.k.pop();
                                        long jLongValue = ((Long) l.this.k.pop()).longValue();
                                        l.this.k.clear();
                                        if (l.this.i != null) {
                                            l.this.i.deleteBatchReportMessagesByTimestamp(jLongValue);
                                        }
                                        stack = l.this.k;
                                    } catch (Exception e) {
                                        aa.d(l.a, e.getMessage());
                                        stack = l.this.k;
                                    }
                                    stack.clear();
                                } catch (Throwable th2) {
                                    l.this.k.clear();
                                    throw th2;
                                }
                            }
                        }
                    }
                });
                return;
            } catch (Exception e) {
                aa.d(a, e.getMessage());
                return;
            }
        }
        aa.a(a, "需要上报的数据条数： 0");
    }

    static /* synthetic */ void a(l lVar, String str, long j) {
        if (lVar.d != null) {
            com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("roas");
            eVar.a(true);
            if (j != 0) {
                eVar.a(j);
            }
            eVar.b(1);
            try {
                eVar.a(lVar.b(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lVar.d.a(eVar);
        }
    }

    static /* synthetic */ void a(l lVar, String str) {
        lVar.i.addReportMessage(str, 2);
        Handler handler = lVar.e;
        if (handler != null && !handler.hasMessages(1)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            lVar.e.sendMessageDelayed(messageObtain, lVar.g);
        }
        if (lVar.j.incrementAndGet() < lVar.f || lVar.e == null) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putLong("last_report_time", System.currentTimeMillis());
        messageObtain2.setData(bundle);
        messageObtain2.what = 2;
        lVar.e.sendMessage(messageObtain2);
        lVar.j.set(0);
    }
}

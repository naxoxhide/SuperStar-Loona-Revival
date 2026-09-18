package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: MIMManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q {
    private static volatile String d;
    private CopyOnWriteArrayList<CampaignEx> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile b f2222b;
    private final AtomicBoolean c;
    private volatile Boolean e;
    private CampaignEx f;
    private int g;
    private Context h;

    private q() {
        this.g = 0;
        this.a = new CopyOnWriteArrayList<>();
        this.c = new AtomicBoolean(false);
    }

    public static q a() {
        return a.a;
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (this.e == null || campaignEx == null || !this.e.booleanValue()) {
                return;
            }
            this.f = campaignEx;
            this.a.add(campaignEx);
        } catch (Exception e) {
            aa.d("MIMManager", e.getMessage());
        }
    }

    public final void b(CampaignEx campaignEx) {
        try {
            if (this.e == null || campaignEx == null || !this.e.booleanValue()) {
                return;
            }
            this.f = null;
            try {
                this.a.remove(campaignEx);
            } catch (Exception e) {
                aa.a("MIMManager", e.getMessage());
            }
        } catch (Exception e2) {
            aa.d("MIMManager", e2.getMessage());
        }
    }

    final CampaignEx b() {
        return this.f;
    }

    public final void c() {
        this.g++;
    }

    public final void d() {
        int i = this.g - 1;
        this.g = i;
        if (i <= 0) {
            Context context = this.h;
            if (this.f2222b == null || context == null) {
                return;
            }
            try {
                try {
                    context.unregisterReceiver(this.f2222b);
                } catch (Exception e) {
                    aa.a("MIMManager", e.getMessage());
                }
            } finally {
                this.f = null;
                this.a.clear();
                this.a = null;
                this.f2222b = null;
                this.h = null;
            }
        }
    }

    public final void a(final Context context) {
        this.h = context;
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.q.1
            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.c.compareAndSet(false, true)) {
                    try {
                        q qVar = q.this;
                        qVar.e = qVar.g();
                    } catch (Exception e) {
                        aa.a("MIMManager", e.getMessage());
                    }
                    if (q.this.e == null || !q.this.e.booleanValue() || context == null) {
                        return;
                    }
                    try {
                        q.this.f2222b = new b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                        intentFilter.addAction(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                        intentFilter.addAction(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                        context.registerReceiver(q.this.f2222b, intentFilter);
                    } catch (Exception e2) {
                        aa.a("MIMManager", e2.getMessage());
                    }
                }
            }
        });
    }

    public final Boolean e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean g() {
        Cursor cursorQuery;
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        Boolean boolValueOf = null;
        if (contextG != null) {
            try {
                if (contextG.getContentResolver() != null) {
                    try {
                        cursorQuery = contextG.getContentResolver().query(Uri.parse(u.b("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), null, null, null, null);
                    } catch (Exception unused) {
                        cursorQuery = null;
                    }
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            try {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null") && (string.equalsIgnoreCase(TJAdUnitConstants.String.FALSE) || string.equalsIgnoreCase("true"))) {
                                    boolValueOf = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e) {
                                aa.a("MIMManager", e.getMessage());
                            }
                            try {
                                d = cursorQuery.getString(cursorQuery.getColumnIndex("detailStyle"));
                            } catch (Exception e2) {
                                aa.a("MIMManager", e2.getMessage());
                            }
                        }
                        try {
                            cursorQuery.close();
                        } catch (Exception e3) {
                            aa.a("MIMManager", e3.getMessage());
                        }
                    }
                }
            } catch (Exception e4) {
                aa.d("MIMManager", e4.getMessage());
            }
        }
        return boolValueOf;
    }

    public final String f() {
        try {
            return d == null ? "" : String.format("[%s]", d);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MIMManager.java */
    static final class a {
        private static final q a = new q();
    }

    /* JADX INFO: compiled from: MIMManager.java */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX WARN: Code duplicated, block: B:36:0x0083 A[Catch: Exception -> 0x00a8, TryCatch #0 {Exception -> 0x00a8, blocks: (B:13:0x0033, B:16:0x003a, B:18:0x004b, B:21:0x0052, B:24:0x005d, B:36:0x0083, B:37:0x008a, B:31:0x006f, B:32:0x0075, B:33:0x007b), top: B:43:0x0033 }] */
        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context context, Intent intent) {
            final CampaignEx campaignExA;
            Runnable runnable;
            Runnable runnable2;
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equals(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN=")) || action.equals(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN=")) || !action.equals(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"))) {
                return;
            }
            try {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                final int i = extras.getInt("statusCode", -1);
                String string = extras.getString("packageName", "");
                if (i == -1 || TextUtils.isEmpty(string) || (campaignExA = a.a.a(string)) == null) {
                    return;
                }
                final q qVar = a.a;
                if (i == 3001) {
                    runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.q.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            String[] strArrU;
                            try {
                                Context context2 = context;
                                CampaignEx campaignEx = campaignExA;
                                if (campaignEx != null) {
                                    try {
                                        com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                        if (nativeVideoTracking == null || (strArrU = nativeVideoTracking.u()) == null) {
                                            return;
                                        }
                                        for (String str : strArrU) {
                                            com.mbridge.msdk.click.a.a(context2, campaignEx, campaignEx.getCampaignUnitId(), str, false, false);
                                        }
                                        return;
                                    } catch (Exception e) {
                                        aa.d("MIMManager", e.getMessage());
                                        return;
                                    }
                                    aa.d("MIMManager", e.getMessage());
                                }
                            } catch (Exception e2) {
                                aa.d("MIMManager", e2.getMessage());
                            }
                        }
                    };
                } else {
                    if (i != 3002) {
                        if (i != 3008) {
                            runnable2 = null;
                        } else {
                            runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.q.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String[] strArrW;
                                    try {
                                        try {
                                            Context context2 = context;
                                            CampaignEx campaignEx = campaignExA;
                                            if (campaignEx != null) {
                                                try {
                                                    com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                                    if (nativeVideoTracking != null && (strArrW = nativeVideoTracking.w()) != null) {
                                                        for (String str : strArrW) {
                                                            com.mbridge.msdk.click.a.a(context2, campaignEx, campaignEx.getCampaignUnitId(), str, false, false);
                                                        }
                                                    }
                                                } catch (Exception e) {
                                                    aa.d("MIMManager", e.getMessage());
                                                }
                                            }
                                        } finally {
                                            if (q.this.a != null && q.this.a.contains(campaignExA)) {
                                                q.this.a.remove(campaignExA);
                                            }
                                        }
                                    } catch (Exception e2) {
                                        aa.d("MIMManager", e2.getMessage());
                                    }
                                }
                            };
                        }
                        if (runnable2 != null) {
                            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable2);
                        }
                        final q qVar2 = a.a;
                        final String str = "dm_page_status";
                        final CampaignEx campaignExB = a.a.b();
                        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.q.5
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    if (context == null || TextUtils.isEmpty(str) || campaignExB == null) {
                                        return;
                                    }
                                    StringBuffer stringBufferAppend = new StringBuffer().append("key=2000100&");
                                    stringBufferAppend.append("network_type=").append(w.r(context)).append("&");
                                    if (!TextUtils.isEmpty(campaignExB.getRequestIdNotice())) {
                                        stringBufferAppend.append("rid_n=").append(campaignExB.getRequestIdNotice()).append("&");
                                    }
                                    if (!TextUtils.isEmpty(campaignExB.getRequestId())) {
                                        stringBufferAppend.append("rid=").append(campaignExB.getRequestId()).append("&");
                                    }
                                    if (!TextUtils.isEmpty(campaignExB.getCampaignUnitId())) {
                                        stringBufferAppend.append("unit_id=").append(campaignExB.getCampaignUnitId()).append("&");
                                        String str2 = com.mbridge.msdk.foundation.controller.b.c.get(campaignExB.getCampaignUnitId());
                                        StringBuilder sbAppend = new StringBuilder().append("u_stid=");
                                        if (str2 == null) {
                                            str2 = "";
                                        }
                                        stringBufferAppend.append(sbAppend.append(str2).append("&").toString());
                                    }
                                    if (!TextUtils.isEmpty(campaignExB.getId())) {
                                        stringBufferAppend.append("cid=").append(campaignExB.getId()).append("&");
                                    }
                                    stringBufferAppend.append("status=").append(str).append("&");
                                    stringBufferAppend.append("code=").append(i);
                                    if (com.mbridge.msdk.foundation.same.report.k.a().c()) {
                                        com.mbridge.msdk.foundation.same.report.k.a().a(stringBufferAppend.toString());
                                        return;
                                    }
                                    try {
                                        new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, com.mbridge.msdk.foundation.same.report.q.a(stringBufferAppend.toString(), context), null);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        aa.d("MIMManager", e.getMessage());
                                    }
                                } catch (Throwable th) {
                                    aa.d("MIMManager", th.getMessage());
                                }
                            }
                        });
                    }
                    runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.q.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            String[] strArrV;
                            try {
                                Context context2 = context;
                                CampaignEx campaignEx = campaignExA;
                                if (campaignEx != null) {
                                    try {
                                        com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                        if (nativeVideoTracking == null || (strArrV = nativeVideoTracking.v()) == null) {
                                            return;
                                        }
                                        for (String str2 : strArrV) {
                                            com.mbridge.msdk.click.a.a(context2, campaignEx, campaignEx.getCampaignUnitId(), str2, false, false);
                                        }
                                        return;
                                    } catch (Exception e) {
                                        aa.d("MIMManager", e.getMessage());
                                        return;
                                    }
                                    aa.d("MIMManager", e.getMessage());
                                }
                            } catch (Exception e2) {
                                aa.d("MIMManager", e2.getMessage());
                            }
                        }
                    };
                }
                runnable2 = runnable;
                if (runnable2 != null) {
                    com.mbridge.msdk.foundation.same.f.b.a().execute(runnable2);
                }
                final q qVar3 = a.a;
                final String str2 = "dm_page_status";
                final CampaignEx campaignExB2 = a.a.b();
                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.q.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (context == null || TextUtils.isEmpty(str2) || campaignExB2 == null) {
                                return;
                            }
                            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000100&");
                            stringBufferAppend.append("network_type=").append(w.r(context)).append("&");
                            if (!TextUtils.isEmpty(campaignExB2.getRequestIdNotice())) {
                                stringBufferAppend.append("rid_n=").append(campaignExB2.getRequestIdNotice()).append("&");
                            }
                            if (!TextUtils.isEmpty(campaignExB2.getRequestId())) {
                                stringBufferAppend.append("rid=").append(campaignExB2.getRequestId()).append("&");
                            }
                            if (!TextUtils.isEmpty(campaignExB2.getCampaignUnitId())) {
                                stringBufferAppend.append("unit_id=").append(campaignExB2.getCampaignUnitId()).append("&");
                                String str3 = com.mbridge.msdk.foundation.controller.b.c.get(campaignExB2.getCampaignUnitId());
                                StringBuilder sbAppend = new StringBuilder().append("u_stid=");
                                if (str3 == null) {
                                    str3 = "";
                                }
                                stringBufferAppend.append(sbAppend.append(str3).append("&").toString());
                            }
                            if (!TextUtils.isEmpty(campaignExB2.getId())) {
                                stringBufferAppend.append("cid=").append(campaignExB2.getId()).append("&");
                            }
                            stringBufferAppend.append("status=").append(str2).append("&");
                            stringBufferAppend.append("code=").append(i);
                            if (com.mbridge.msdk.foundation.same.report.k.a().c()) {
                                com.mbridge.msdk.foundation.same.report.k.a().a(stringBufferAppend.toString());
                                return;
                            }
                            try {
                                new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, com.mbridge.msdk.foundation.same.report.q.a(stringBufferAppend.toString(), context), null);
                            } catch (Exception e) {
                                e.printStackTrace();
                                aa.d("MIMManager", e.getMessage());
                            }
                        } catch (Throwable th) {
                            aa.d("MIMManager", th.getMessage());
                        }
                    }
                });
            } catch (Exception e) {
                aa.d("MIMManager", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            CampaignEx campaignEx = this.f;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.a;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            for (CampaignEx campaignEx2 : this.a) {
                if (campaignEx2 != null && TextUtils.equals(campaignEx2.getPackageName(), str)) {
                    return campaignEx2;
                }
            }
            return null;
        } catch (Exception e) {
            aa.d("MIMManager", e.getMessage());
            return null;
        }
    }
}

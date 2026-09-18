package com.mbridge.msdk.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.reward.adapter.c;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: LoopTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1939b;
    private LinkedList<i> c;
    private LinkedList<i> d;
    private int e;
    private int f;
    private f g;
    private com.mbridge.msdk.videocommon.d.a h;
    private o i;
    private h j;
    private Handler k;

    /* JADX INFO: renamed from: com.mbridge.msdk.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoopTimer.java */
    static class C0471a {
        static a a = new a();
    }

    private a() {
        this.f1939b = false;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = 0;
        this.f = 0;
        this.k = new Handler() { // from class: com.mbridge.msdk.d.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                synchronized (a.this) {
                    int i = message.what;
                    if (i != 1) {
                        if (i == 2) {
                            a.c(a.this);
                        }
                    } else {
                        if (a.this.f1939b) {
                            return;
                        }
                        a aVar = a.this;
                        a.a(aVar, aVar.a);
                        sendMessageDelayed(obtainMessage(1), a.this.a);
                    }
                }
            }
        };
    }

    private boolean a(i iVar) {
        boolean z = false;
        if (iVar == null || TextUtils.isEmpty(iVar.a())) {
            return false;
        }
        String strA = iVar.a();
        try {
            if (this.g != null) {
                com.mbridge.msdk.videocommon.d.a aVar = this.h;
                int iA = this.g.a(strA, aVar != null ? aVar.f() : 0L);
                if (iA != -1) {
                    if (iA != 1) {
                    }
                } else if (!TextUtils.isEmpty(strA)) {
                    LinkedList<i> linkedList = this.c;
                    if (linkedList != null && linkedList.contains(strA)) {
                        this.c.remove(strA);
                    } else {
                        LinkedList<i> linkedList2 = this.d;
                        if (linkedList2 != null && linkedList2.contains(strA)) {
                            this.d.remove(strA);
                        }
                    }
                    o oVar = this.i;
                    if (oVar != null) {
                        oVar.a(strA);
                    }
                }
                try {
                    Handler handler = this.k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                    aa.b("LoopTimer", th.getMessage(), th);
                    return z;
                }
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (contextG == null) {
                return;
            }
            final c cVar = new c(contextG, str, str2);
            cVar.b(z);
            cVar.a(new com.mbridge.msdk.reward.adapter.a() { // from class: com.mbridge.msdk.d.a.2
                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(List<CampaignEx> list) {
                }

                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(List<CampaignEx> list, String str3) {
                    a.this.k.sendMessage(a.this.k.obtainMessage(2));
                    cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                }

                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(String str3) {
                    a.this.k.sendMessage(a.this.k.obtainMessage(2));
                    cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                }
            });
            cVar.a(1, 8000, false);
        } catch (Exception e) {
            aa.b("LoopTimer", e.getMessage(), e);
        }
    }

    public final void a(String str, String str2) {
        if (this.c.contains(str2)) {
            return;
        }
        this.c.add(new i(str, str2, 94));
        o oVar = this.i;
        if (oVar != null) {
            oVar.a(str, str2, 94);
        }
    }

    public final void b(String str, String str2) {
        if (this.d.contains(str2)) {
            return;
        }
        this.d.add(new i(str, str2, 287));
        o oVar = this.i;
        if (oVar != null) {
            oVar.a(str, str2, 287);
        }
    }

    public final void a(long j) {
        if (this.j == null) {
            this.j = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
        }
        if (this.i == null) {
            this.i = o.a(this.j);
        }
        List<i> listA = this.i.a(287);
        if (listA != null) {
            this.d.addAll(listA);
            for (i iVar : listA) {
                b(iVar.b(), iVar.a());
            }
        }
        List<i> listA2 = this.i.a(94);
        if (listA2 != null) {
            this.c.addAll(listA2);
            for (i iVar2 : listA2) {
                a(iVar2.b(), iVar2.a());
            }
        }
        if (this.g == null) {
            this.g = f.a(this.j);
        }
        if (this.h == null) {
            this.h = com.mbridge.msdk.videocommon.d.b.a().b();
        }
        this.a = j;
        this.f1939b = false;
        Handler handler = this.k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.a);
    }

    static /* synthetic */ void a(a aVar, long j) {
        LinkedList<i> linkedList = aVar.c;
        if (linkedList == null || linkedList.size() <= 0 || aVar.e == 0 || aVar.c.size() <= aVar.e) {
            LinkedList<i> linkedList2 = aVar.d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f == 0 || aVar.d.size() == aVar.f) {
                aVar.f = 0;
                aVar.e = 0;
                Handler handler = aVar.k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }

    static /* synthetic */ void c(a aVar) {
        try {
            LinkedList<i> linkedList = aVar.c;
            if (linkedList != null && linkedList.size() > 0 && aVar.e < aVar.c.size()) {
                i iVar = aVar.c.get(aVar.e);
                aVar.e++;
                if (aVar.a(iVar)) {
                    aVar.a(iVar.b(), iVar.a(), false);
                }
            } else {
                LinkedList<i> linkedList2 = aVar.d;
                if (linkedList2 != null && linkedList2.size() > 0 && aVar.f < aVar.d.size()) {
                    i iVar2 = aVar.d.get(aVar.f);
                    aVar.f++;
                    if (aVar.a(iVar2)) {
                        aVar.a(iVar2.b(), iVar2.a(), true);
                    }
                }
            }
        } catch (Throwable th) {
            aa.b("LoopTimer", th.getMessage(), th);
        }
    }
}

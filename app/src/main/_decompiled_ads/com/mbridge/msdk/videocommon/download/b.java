package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: DownLoadH5SourceListener.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements g.c {
    private static String a = "DownLoadH5SourceListener";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, b> f2663b;
    private k c;
    private CopyOnWriteArrayList<g.d> d;
    private String e;

    @Override // com.mbridge.msdk.videocommon.download.g.c
    public final void a() {
    }

    public b(ConcurrentMap<String, b> concurrentMap, k kVar, g.d dVar, String str) {
        CopyOnWriteArrayList<g.d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.d = copyOnWriteArrayList;
        this.f2663b = concurrentMap;
        this.c = kVar;
        copyOnWriteArrayList.add(dVar);
        this.e = str;
    }

    public final void a(g.d dVar) {
        this.d.add(dVar);
    }

    @Override // com.mbridge.msdk.videocommon.download.g.c
    public final void a(String str, byte[] bArr, String str2) {
        String message;
        try {
            ConcurrentMap<String, b> concurrentMap = this.f2663b;
            if (concurrentMap == null) {
                for (g.d dVar : this.d) {
                    if (dVar != null) {
                        dVar.a(str2, "mResDownloadingMap  is null");
                        this.d.remove(dVar);
                    }
                }
                return;
            }
            if (concurrentMap.containsKey(str2)) {
                this.f2663b.remove(str2);
            }
            if (bArr == null || bArr.length <= 0) {
                message = "response data is error";
            } else {
                String strA = this.c.a(str2, bArr);
                if (TextUtils.isEmpty(strA)) {
                    for (g.d dVar2 : this.d) {
                        if (dVar2 != null) {
                            dVar2.a(str2, false);
                            this.d.remove(dVar2);
                        }
                    }
                    return;
                }
                message = "data save failed:" + strA;
            }
            for (g.d dVar3 : this.d) {
                if (dVar3 != null) {
                    dVar3.a(str2, message);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            try {
                message = e.getMessage();
            } catch (Throwable th) {
                aa.b(a, th.getMessage(), th);
                message = "";
            }
        }
    }

    @Override // com.mbridge.msdk.videocommon.download.g.c
    public final void a(String str) {
        try {
            ConcurrentMap<String, b> concurrentMap = this.f2663b;
            if (concurrentMap == null) {
                for (g.d dVar : this.d) {
                    if (dVar != null) {
                        dVar.a(this.e, "mResDownloadingMap  is null");
                        this.d.remove(dVar);
                    }
                }
                return;
            }
            if (concurrentMap.containsKey(this.e)) {
                this.f2663b.remove(this.e);
            }
            for (g.d dVar2 : this.d) {
                if (dVar2 != null) {
                    dVar2.a(this.e, str);
                    this.d.remove(dVar2);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            try {
                str = e.getMessage();
            } catch (Throwable th) {
                aa.b(a, th.getMessage(), th);
            }
        }
    }
}

package com.bytedance.sdk.openadsdk.h;

import b.b.a.a.h.i;
import b.b.a.a.h.s;
import com.bytedance.sdk.component.utils.m;

/* JADX INFO: compiled from: StepTrackImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements s {
    private static int e;
    private long a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f774b;
    private boolean c;
    private String d;

    public e() {
        e++;
        this.d = "image_request_" + e;
    }

    private String c(String str, i iVar) {
        b.b.a.a.h.x.a aVarI;
        if (str != null) {
            str.hashCode();
            str.hashCode();
            switch (str) {
                case "success":
                    return "success";
                case "raw_cache":
                    return "raw cache";
                case "image_type":
                    return "image type：";
                case "disk_cache":
                    return "disk cache";
                case "decode":
                    return "decode";
                case "failed":
                    if (!(iVar instanceof b.b.a.a.h.x.c) || (aVarI = ((b.b.a.a.h.x.c) iVar).i()) == null) {
                        return "fail";
                    }
                    Throwable thB = aVarI.b();
                    return "fail：code:" + aVarI.a() + ", msg:" + aVarI.c() + ", exception:" + (thB != null ? thB.getMessage() : "null \r\n");
                case "check_duplicate":
                    return "duplicate request";
                case "memory_cache":
                    return "memory cache";
                case "net_request":
                    return "net request";
                case "generate_key":
                    return "generate key:" + iVar.e();
                case "cache_policy":
                    return "cache policy";
            }
        }
        return str;
    }

    @Override // b.b.a.a.h.s
    public void a(String str, i iVar) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.a;
        this.f774b += jCurrentTimeMillis;
        m.a("ImageLoaderStep", this.d + " end:" + c(str, iVar) + ",cost：" + jCurrentTimeMillis + " ms， total：" + this.f774b + "\r\n");
    }

    @Override // b.b.a.a.h.s
    public void b(String str, i iVar) {
        if (!this.c) {
            m.a("ImageLoaderStep", "start " + this.d + " request:" + iVar.a() + ", width:" + iVar.b() + ",height:" + iVar.c());
            this.c = true;
        }
        this.a = System.currentTimeMillis();
        m.a("ImageLoaderStep", this.d + " start:" + c(str, iVar));
    }
}

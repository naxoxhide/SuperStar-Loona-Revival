package com.bytedance.sdk.openadsdk.f;

import android.util.Pair;
import b.b.a.a.f.a.e;
import b.b.a.a.f.a.f;
import b.b.a.a.f.a.i;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.m;
import b.b.a.a.f.a.n;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DefaultNetWork.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements INetWork {
    protected j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected j f769b;

    public a() {
        j.a aVar = new j.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.a = aVar.a(10L, timeUnit).b(10L, timeUnit).c(10L, timeUnit).a();
        this.f769b = new j.a().a(10L, timeUnit).b(30L, timeUnit).c(30L, timeUnit).a();
    }

    private Map<String, String> a(f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < fVar.a(); i++) {
            map.put(fVar.a(i), fVar.b(i));
        }
        return map;
    }

    public Response doGet(String str) throws Exception {
        n nVarB = this.a.a(new l.a().b().a(str).a()).b();
        return new Response(a(nVarB.c()), nVarB.b() == 200 ? nVarB.a().d() : null, nVarB.b(), nVarB.e());
    }

    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        e.a aVar = new e.a();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                aVar.a((String) pair.first, (String) pair.second);
            }
        }
        n nVarB = this.a.a(new l.a().a(str).a((m) aVar.a()).a()).b();
        return new Response(a(nVarB.c()), nVarB.b() == 200 ? nVarB.a().d() : null, nVarB.b(), nVarB.e());
    }

    public void downloadFile(String str, long j, BufferOutputStream bufferOutputStream) throws Exception {
        int iB;
        Exception e;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                n nVarB = this.f769b.a(new l.a().b().a(str).a()).b();
                iB = nVarB.b();
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(nVarB.a().a());
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = bufferedInputStream2.read(bArr, 0, 2048);
                            if (i == -1) {
                                CloseableUtils.close(bufferedInputStream2);
                                return;
                            }
                            bufferOutputStream.write(bArr, 0, i);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = bufferedInputStream2;
                        throw new RuntimeException("downloadFile failed, code: " + iB + ", url:" + str + ", caused by:" + e.getMessage(), e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        CloseableUtils.close(bufferedInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            iB = 0;
            e = e4;
        }
    }

    public Response doPost(String str, String str2) throws Exception {
        n nVarB = this.a.a(new l.a().a(str).a(m.a(i.a("application/json; charset=utf-8"), str2)).a()).b();
        return new Response(a(nVarB.c()), nVarB.b() == 200 ? nVarB.a().d() : null, nVarB.b(), nVarB.e());
    }
}

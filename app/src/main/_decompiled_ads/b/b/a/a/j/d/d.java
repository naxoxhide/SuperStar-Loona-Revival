package b.b.a.a.j.d;

import android.text.TextUtils;
import b.b.a.a.f.a.f;
import b.b.a.a.f.a.i;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.m;
import b.b.a.a.f.a.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: PostExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends c {
    m e;

    public d(j jVar) {
        super(jVar);
        this.e = null;
    }

    public void a(JSONObject jSONObject) {
        this.e = m.a(i.a("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : JsonUtils.EMPTY_JSON);
    }

    public b.b.a.a.j.b b() {
        try {
            l.a aVar = new l.a();
            if (TextUtils.isEmpty(this.d)) {
                b.b.a.a.j.f.d.a("PostExecutor", "execute: Url is Empty");
                return new b.b.a.a.j.b(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            aVar.a(this.d);
            if (this.e == null) {
                b.b.a.a.j.f.d.a("PostExecutor", "RequestBody is null, content type is not support!!");
                return new b.b.a.a.j.b(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            a(aVar);
            aVar.a((Object) a());
            n nVarB = this.a.a(aVar.a(this.e).a()).b();
            if (nVarB == null) {
                return null;
            }
            HashMap map = new HashMap();
            f fVarC = nVarB.c();
            if (fVarC != null) {
                for (int i = 0; i < fVarC.a(); i++) {
                    map.put(fVarC.a(i), fVarC.b(i));
                }
            }
            return new b.b.a.a.j.b(nVarB.d(), nVarB.b(), nVarB.e(), map, nVarB.a().d(), nVarB.h(), nVarB.g());
        } catch (Throwable th) {
            return new b.b.a.a.j.b(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    public m c() {
        return this.e;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = JsonUtils.EMPTY_JSON;
        }
        this.e = m.a(i.a("application/json; charset=utf-8"), str);
    }

    /* JADX INFO: compiled from: PostExecutor.java */
    class a implements b.b.a.a.f.a.c {
        final /* synthetic */ b.b.a.a.j.c.a a;

        a(b.b.a.a.j.c.a aVar) {
            this.a = aVar;
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, IOException iOException) {
            b.b.a.a.j.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(d.this, iOException);
            }
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, n nVar) throws IOException {
            IOException iOException;
            b.b.a.a.j.c.a aVar = this.a;
            if (aVar != null) {
                if (nVar == null) {
                    aVar.a(d.this, new IOException("No response"));
                    return;
                }
                b.b.a.a.j.b bVar2 = null;
                try {
                    HashMap map = new HashMap();
                    f fVarC = nVar.c();
                    if (fVarC != null) {
                        for (int i = 0; i < fVarC.a(); i++) {
                            map.put(fVarC.a(i), fVarC.b(i));
                        }
                    }
                    iOException = null;
                    bVar2 = new b.b.a.a.j.b(nVar.d(), nVar.b(), nVar.e(), map, nVar.a().d(), nVar.h(), nVar.g());
                } catch (Throwable th) {
                    iOException = new IOException(th);
                }
                if (bVar2 != null) {
                    this.a.a(d.this, bVar2);
                    return;
                }
                b.b.a.a.j.c.a aVar2 = this.a;
                d dVar = d.this;
                if (iOException == null) {
                    iOException = new IOException("Unexpected exception");
                }
                aVar2.a(dVar, iOException);
            }
        }
    }

    private byte[] c(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes("utf-8"));
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e) {
                                com.bytedance.sdk.component.utils.m.b("PostExecutor", e.toString());
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            gZIPOutputStream = gZIPOutputStream2;
                            com.bytedance.sdk.component.utils.m.b("PostExecutor", e.toString());
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e3) {
                                    com.bytedance.sdk.component.utils.m.b("PostExecutor", e3.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream = gZIPOutputStream2;
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e4) {
                                    com.bytedance.sdk.component.utils.m.b("PostExecutor", e4.toString());
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                throw th;
                            }
                            byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException e5) {
                                com.bytedance.sdk.component.utils.m.b("PostExecutor", e5.toString());
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e = e7;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (IOException e8) {
            com.bytedance.sdk.component.utils.m.b("PostExecutor", e8.toString());
        }
        return byteArray;
    }

    public void a(String str, byte[] bArr) {
        this.e = m.a(i.a(str), bArr);
    }

    public void a(b.b.a.a.j.c.a aVar) {
        try {
            l.a aVar2 = new l.a();
            if (TextUtils.isEmpty(this.d)) {
                aVar.a(this, new IOException("Url is Empty"));
                return;
            }
            aVar2.a(this.d);
            if (this.e == null) {
                if (aVar != null) {
                    aVar.a(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                a(aVar2);
                aVar2.a((Object) a());
                this.a.a(aVar2.a(this.e).a()).a(new a(aVar));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.a(this, new IOException(th.getMessage()));
        }
    }

    public void a(String str, boolean z) {
        if (z) {
            a("application/json; charset=utf-8", c(str));
            a(HttpHeaders.CONTENT_ENCODING, "gzip");
        } else {
            d(str);
        }
    }
}

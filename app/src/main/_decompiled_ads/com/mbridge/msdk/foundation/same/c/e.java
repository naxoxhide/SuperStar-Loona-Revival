package com.mbridge.msdk.foundation.same.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.k;
import java.io.File;

/* JADX INFO: compiled from: CommonImageTask.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends com.mbridge.msdk.foundation.same.e.a {
    private String a;
    private String e;
    private String f;
    private boolean g;
    private a h;
    private boolean i;

    /* JADX INFO: compiled from: CommonImageTask.java */
    public interface a {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void b() {
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void a(a aVar) {
        this.h = aVar;
    }

    public e(String str, String str2, String str3) {
        this.g = false;
        this.i = false;
        this.a = str;
        this.e = str2;
        this.f = str3;
    }

    public e(String str, String str2, String str3, h hVar) {
        this.g = false;
        this.i = false;
        this.a = str;
        this.e = str2;
        this.f = str3;
        this.i = true;
    }

    private void e() {
        try {
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            com.mbridge.msdk.foundation.same.net.g.b.downloadFile(file, this.e, new com.mbridge.msdk.foundation.same.net.f<Void>() { // from class: com.mbridge.msdk.foundation.same.c.e.1
                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onFinish() {
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onProgressChange(long j, long j2) {
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onSuccess(k kVar) {
                    Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.e.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            e eVar = e.this;
                            String unused = e.this.f;
                            e.this.c();
                        }
                    };
                    if (e.this.i) {
                        com.mbridge.msdk.foundation.same.f.b.f().execute(runnable);
                    } else {
                        runnable.run();
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onError(final com.mbridge.msdk.foundation.same.net.a.a aVar) {
                    Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.e.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.this.a(e.this.e, "load image from http faild because http return code: " + aVar.a + ".image url is " + e.this.e);
                        }
                    };
                    if (e.this.i) {
                        com.mbridge.msdk.foundation.same.f.b.f().execute(runnable);
                    } else {
                        runnable.run();
                    }
                }
            });
        } catch (Exception e) {
            a(this.e, e.getMessage());
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        } catch (OutOfMemoryError e2) {
            a(this.e, e2.getMessage());
        }
    }

    protected final void c() {
        if (new File(this.f).exists()) {
            String str = this.e;
            String str2 = this.f;
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(str, str2);
                return;
            }
            return;
        }
        a(this.e, "load image faild.because file[" + this.f + "] is not exist!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void a() {
        if (!this.g) {
            if (TextUtils.isEmpty(this.f)) {
                a(this.e, "save path is null.");
                return;
            }
            File file = new File(this.f);
            if (!file.exists() || file.length() <= 0) {
                e();
                return;
            } else {
                c();
                return;
            }
        }
        e();
    }
}

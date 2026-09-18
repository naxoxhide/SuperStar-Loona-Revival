package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ae;
import java.net.URI;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: WebViewSpiderLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends c implements com.mbridge.msdk.foundation.same.e.a.b {
    private d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CommonJumpLoader.JumpLoaderResult f1938b;
    private boolean d;
    private Context e;
    private com.mbridge.msdk.foundation.same.e.b f;
    private f.a g;
    private boolean c = true;
    private Handler h = new Handler(Looper.getMainLooper());

    public i(Context context) {
        this.e = context;
        this.f = new com.mbridge.msdk.foundation.same.e.b(context, 2);
    }

    public final void a(String str, d dVar, boolean z, String str2, String str3, CampaignEx campaignEx, boolean z2, boolean z3, int i) {
        this.a = dVar;
        this.d = z;
        this.f.a(new a(this.e, str, str2, str3, campaignEx, z2, z3, i), this);
    }

    @Override // com.mbridge.msdk.click.c
    public final void a() {
        this.c = false;
    }

    /* JADX INFO: compiled from: WebViewSpiderLoader.java */
    private class a extends com.mbridge.msdk.foundation.same.e.a {
        private final Context f;
        private String g;
        private String h;
        private String i;
        private CampaignEx j;
        private boolean k;
        private boolean l;
        private int m;
        private final Semaphore e = new Semaphore(0);
        private h.a n = new h.a() { // from class: com.mbridge.msdk.click.i.a.1
            @Override // com.mbridge.msdk.click.h.a
            public final boolean c(String str) {
                return false;
            }

            @Override // com.mbridge.msdk.click.h.a
            public final boolean a(String str) {
                boolean zA = a.this.a(str);
                if (zA) {
                    a();
                }
                return zA;
            }

            @Override // com.mbridge.msdk.click.h.a
            public final boolean b(String str) {
                boolean zA = a.this.a(str);
                if (zA) {
                    a();
                }
                return zA;
            }

            @Override // com.mbridge.msdk.click.h.a
            public final void a(String str, boolean z, String str2) {
                a.this.a(str);
                i.this.f1938b.setContent(str2);
                a();
            }

            private void a() {
                synchronized (i.this) {
                    i.this.f1938b.setSuccess(true);
                    a.a(a.this);
                }
            }

            @Override // com.mbridge.msdk.click.h.a
            public final void a(int i, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    i.this.f1938b.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    i.this.f1938b.setContent(str3);
                }
                a.this.a(str);
                a();
            }
        };

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void b() {
        }

        public a(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z, boolean z2, int i) {
            this.f = context;
            this.g = str;
            this.h = str2;
            this.i = str3;
            this.j = campaignEx;
            this.k = z;
            this.l = z2;
            this.m = i;
        }

        private CommonJumpLoader.JumpLoaderResult a(String str, boolean z, boolean z2, CampaignEx campaignEx, int i) {
            String scheme;
            String str2;
            String str3 = str;
            String host = "";
            if (i.this.d) {
                String strA = com.mbridge.msdk.c.c.a(this.f, str3);
                if (!TextUtils.isEmpty(strA)) {
                    str3 = str3 + strA;
                }
            }
            String str4 = str3;
            CommonJumpLoader.JumpLoaderResult jumpLoaderResult = new CommonJumpLoader.JumpLoaderResult();
            f fVar = new f();
            try {
                if (b(str4)) {
                    str2 = "";
                } else {
                    URI uriCreate = URI.create(str4);
                    scheme = uriCreate.getScheme();
                    try {
                        host = uriCreate.getHost();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                    str2 = host;
                    host = scheme;
                }
            } catch (Exception e2) {
                e = e2;
                scheme = "";
            }
            String str5 = str4;
            String scheme2 = host;
            String host2 = str2;
            for (int i2 = 0; i2 < 10; i2++) {
                if (!i.this.c) {
                    return null;
                }
                i.this.g = fVar.a(str5, z, z2, campaignEx);
                if (i.this.g != null) {
                    if (!TextUtils.isEmpty(i.this.g.h)) {
                        jumpLoaderResult.setUrl(str5);
                        jumpLoaderResult.setExceptionMsg(i.this.g.h);
                        jumpLoaderResult.setType(1);
                        jumpLoaderResult.setHeader(i.this.g.a());
                        jumpLoaderResult.setSuccess(false);
                        if (i2 != 0) {
                            break;
                        }
                        com.mbridge.msdk.click.a.a.a().a(str5, i.this.g.h, campaignEx, this.i, z, z2, i);
                        break;
                    }
                    jumpLoaderResult.setSuccess(true);
                    int i3 = i.this.g.f;
                    if (!(i3 == 301 || i3 == 302 || i3 == 307)) {
                        if (i.this.g.f == 200) {
                            jumpLoaderResult.setjumpDone(true);
                            jumpLoaderResult.setUrl(str5);
                            jumpLoaderResult.setContent(i.this.g.g);
                            break;
                        }
                        jumpLoaderResult.setjumpDone(false);
                        jumpLoaderResult.setUrl(str5);
                        if (i2 != 0) {
                            break;
                        }
                        com.mbridge.msdk.click.a.a.a().a(str5, "error code:" + i.this.g.f, campaignEx, this.i, z, z2, i);
                        break;
                    }
                    jumpLoaderResult.setIs302Jump(true);
                    if (!TextUtils.isEmpty(i.this.g.a)) {
                        str5 = i.this.g.a;
                        if (!b(str5)) {
                            if (!b(str5)) {
                                try {
                                    URI uriCreate2 = URI.create(str5);
                                    scheme2 = uriCreate2.getScheme();
                                    host2 = uriCreate2.getHost();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                        } else if (str5.startsWith(RemoteSettings.FORWARD_SLASH_STRING) && !TextUtils.isEmpty(scheme2) && !TextUtils.isEmpty(host2)) {
                            str5 = scheme2 + "://" + host2 + str5;
                            host2 = null;
                            scheme2 = null;
                        } else {
                            jumpLoaderResult.setjumpDone(true);
                            jumpLoaderResult.setUrl(str5);
                            break;
                        }
                        if (!ae.a.a(str5)) {
                            if (i.this.d) {
                                String strA2 = com.mbridge.msdk.c.c.a(this.f, str5);
                                if (!TextUtils.isEmpty(strA2)) {
                                    str5 = str5 + strA2;
                                }
                            }
                        } else {
                            jumpLoaderResult.setjumpDone(true);
                            jumpLoaderResult.setUrl(str5);
                            break;
                        }
                    } else {
                        jumpLoaderResult.setjumpDone(true);
                        jumpLoaderResult.setUrl(str5);
                        break;
                    }
                } else {
                    jumpLoaderResult.setUrl(str5);
                    jumpLoaderResult.setSuccess(false);
                    break;
                }
            }
            return jumpLoaderResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(String str) {
            CampaignEx campaignEx = this.j;
            if (campaignEx != null) {
                campaignEx.getLinkType();
            }
            if (ae.a.a(str)) {
                i.this.f1938b.setCode(1);
                i.this.f1938b.setUrl(str);
                i.this.f1938b.setjumpDone(true);
                return true;
            }
            i.this.f1938b.setCode(2);
            i.this.f1938b.setUrl(str);
            return false;
        }

        private boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void a() {
            if (i.this.a != null) {
                i.this.a.a(null);
            }
            i.this.f1938b = new CommonJumpLoader.JumpLoaderResult();
            i.this.f1938b.setUrl(this.g);
            i.this.f1938b = a(this.g, this.k, this.l, this.j, this.m);
            if (!TextUtils.isEmpty(i.this.f1938b.getExceptionMsg())) {
                i.this.f1938b.setSuccess(true);
            }
            if (i.this.c && i.this.f1938b.isSuccess()) {
                if (i.this.g != null) {
                    i.this.f1938b.setStatusCode(i.this.g.f);
                }
                if (ae.a.a(i.this.f1938b.getUrl()) || 200 != i.this.g.f || TextUtils.isEmpty(i.this.f1938b.getContent()) || i.this.f1938b.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    if (i.this.g != null) {
                        i.this.f1938b.setType(1);
                        i.this.f1938b.setExceptionMsg(i.this.g.h);
                        i.this.f1938b.setStatusCode(i.this.g.f);
                        i.this.f1938b.setHeader(i.this.g.a());
                        i.this.f1938b.setContent(i.this.g.g);
                    }
                    a(i.this.f1938b.getUrl());
                    return;
                }
                i.this.f1938b.setType(2);
                if (TextUtils.isEmpty(i.this.f1938b.getContent())) {
                    try {
                        new h().a(this.h, this.i, this.f, i.this.f1938b.getUrl(), this.n);
                    } catch (Exception unused) {
                    }
                } else {
                    new h().a(this.h, this.i, this.f, i.this.f1938b.getUrl(), i.this.f1938b.getContent(), this.n);
                }
                this.e.acquireUninterruptibly();
            }
        }

        static /* synthetic */ void a(a aVar) {
            aVar.e.release();
        }
    }

    @Override // com.mbridge.msdk.foundation.same.e.a.b
    public final void a(com.mbridge.msdk.foundation.same.e.a.EnumC0483a enumC0483a) {
        if (enumC0483a == com.mbridge.msdk.foundation.same.e.a.EnumC0483a.FINISH && this.c) {
            this.h.post(new Runnable() { // from class: com.mbridge.msdk.click.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.a != null) {
                        if (i.this.f1938b.isSuccess()) {
                            i.this.a.b(i.this.f1938b);
                        } else {
                            i.this.a.a(i.this.f1938b, i.this.f1938b.getMsg());
                        }
                    }
                }
            });
        }
    }
}

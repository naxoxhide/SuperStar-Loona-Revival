package com.mbridge.msdk.video.module.a.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: VideoViewStatisticsListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class o extends k {
    protected int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Map<Integer, String> q;
    private int r;

    public o(CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        this.p = false;
        this.k = 0;
        this.r = -1;
        if (this.a) {
            this.q = campaignEx.getAdvImpList();
        }
        this.k = campaignEx.getVideoCompleteTime();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0125 A[Catch: all -> 0x0145, TryCatch #0 {all -> 0x0145, blocks: (B:16:0x001e, B:17:0x0026, B:18:0x0056, B:63:0x013f, B:19:0x0062, B:21:0x006d, B:23:0x0071, B:26:0x0082, B:28:0x0086, B:29:0x008c, B:31:0x00a8, B:32:0x00b1, B:34:0x00b5, B:39:0x00bd, B:40:0x00c1, B:41:0x00da, B:44:0x00e0, B:46:0x00e4, B:48:0x00ed, B:50:0x00f1, B:52:0x0103, B:54:0x0107, B:55:0x0117, B:57:0x011b, B:58:0x0125, B:60:0x0129, B:62:0x012d), top: B:68:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0129 A[Catch: all -> 0x0145, TryCatch #0 {all -> 0x0145, blocks: (B:16:0x001e, B:17:0x0026, B:18:0x0056, B:63:0x013f, B:19:0x0062, B:21:0x006d, B:23:0x0071, B:26:0x0082, B:28:0x0086, B:29:0x008c, B:31:0x00a8, B:32:0x00b1, B:34:0x00b5, B:39:0x00bd, B:40:0x00c1, B:41:0x00da, B:44:0x00e0, B:46:0x00e4, B:48:0x00ed, B:50:0x00f1, B:52:0x0103, B:54:0x0107, B:55:0x0117, B:57:0x011b, B:58:0x0125, B:60:0x0129, B:62:0x012d), top: B:68:0x0004 }] */
    @Override // com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i, final Object obj) {
        int i2;
        try {
            if (i == 2) {
                if (this.a && !this.n) {
                    this.n = true;
                    d();
                    com.mbridge.msdk.video.module.b.b.e(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b);
                }
            } else if (i != 130) {
                if (i == 6) {
                    if (this.a) {
                        this.n = true;
                        d();
                        com.mbridge.msdk.video.module.b.b.e(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b);
                    }
                } else if (i != 7) {
                    int videoLength = 0;
                    if (i == 15) {
                        g();
                        f();
                        e();
                        if (obj == null || !(obj instanceof MBridgeVideoView.a)) {
                            i2 = 0;
                        } else {
                            int i3 = ((MBridgeVideoView.a) obj).a;
                            videoLength = ((MBridgeVideoView.a) obj).f2542b;
                            i2 = i3;
                        }
                        if (videoLength == 0 && this.f2548b != null) {
                            videoLength = this.f2548b.getVideoLength();
                        }
                        com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b, i2, videoLength, this.j);
                        com.mbridge.msdk.video.module.b.b.a(this.f2548b, this.q, this.g, i2);
                        if (!this.o) {
                            this.o = true;
                            com.mbridge.msdk.video.module.b.b.a(this.f2548b, this.g);
                        }
                        if (!this.p) {
                            int i4 = this.k;
                            if (i4 != 0) {
                                videoLength = i4;
                            }
                            if (i2 >= videoLength) {
                                this.p = true;
                                i = 17;
                            }
                        }
                        aa.d("NotifyListener", "onPlayProgress:" + i2);
                        this.r = i2;
                    } else if (i == 16) {
                        if (this.a) {
                            this.n = true;
                            d();
                            com.mbridge.msdk.video.module.b.b.e(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b);
                        }
                    } else {
                        switch (i) {
                            case 11:
                                com.mbridge.msdk.videocommon.download.c.getInstance().b(false);
                                d();
                                break;
                            case 12:
                                Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.o.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Object obj2 = obj;
                                        if (obj2 == null || !(obj2 instanceof String)) {
                                            return;
                                        }
                                        o.this.a((String) obj2);
                                    }
                                };
                                com.mbridge.msdk.foundation.controller.c.a();
                                com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
                                d();
                                b();
                                c();
                                k.AnonymousClass4 anonymousClass4 = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.4
                                    AnonymousClass4() {
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        try {
                                            if (ac.a().a("c_r_v_f_w_s_e", false) || !k.this.a || k.this.e == null) {
                                                return;
                                            }
                                            if (k.this.e.k() != null && !TextUtils.isEmpty(k.this.e.k().getVideoUrlEncode())) {
                                                p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).b(k.this.e.k().getVideoUrlEncode());
                                            }
                                            if (TextUtils.isEmpty(k.this.e.h())) {
                                                return;
                                            }
                                            File file = new File(k.this.e.h());
                                            if (file.exists() && file.isFile() && file.delete()) {
                                                aa.a("NotifyListener", "DEL File :" + file.getAbsolutePath());
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                com.mbridge.msdk.foundation.controller.c.a();
                                com.mbridge.msdk.foundation.same.f.b.a().execute(anonymousClass4);
                                com.mbridge.msdk.videocommon.download.c.getInstance().b(false);
                                break;
                            case 13:
                                b();
                                c();
                                break;
                        }
                    }
                } else if (this.a && obj != null && (obj instanceof Integer)) {
                    int iIntValue = ((Integer) obj).intValue();
                    if (iIntValue == 2) {
                        if (!this.m) {
                            this.m = true;
                            com.mbridge.msdk.video.module.b.b.b(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b);
                        }
                    } else if (iIntValue == 1 && !this.l) {
                        this.l = true;
                        com.mbridge.msdk.video.module.b.b.c(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b);
                    }
                }
            } else if (obj instanceof Integer) {
                this.k = ((Integer) obj).intValue();
            }
            this.i.a(i, obj);
        } catch (Throwable th) {
            aa.b("NotifyListener", th.getMessage(), th);
        }
    }
}

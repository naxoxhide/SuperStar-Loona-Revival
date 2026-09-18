package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.y;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: CampaignDownLoadTask.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements Serializable {
    private DownloadRequest A;
    private int B;
    private boolean C;
    private int D;
    private File E;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private com.mbridge.msdk.c.f K;
    private com.mbridge.msdk.videocommon.d.c L;
    private com.mbridge.msdk.c.f M;
    private String R;
    private boolean a;
    private int c;
    private int d;
    private volatile int f;
    private com.mbridge.msdk.videocommon.listener.a h;
    private com.mbridge.msdk.videocommon.listener.a i;
    private CampaignEx j;
    private String k;
    private Context l;
    private long m;
    private String n;
    private String o;
    private long p;
    private String q;
    private long s;
    private p v;
    private String x;
    private DownloadRequest y;
    private DownloadMessage z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2662b = false;
    private boolean e = false;
    private CopyOnWriteArrayList<d> g = new CopyOnWriteArrayList<>();
    private boolean r = false;
    private int t = 100;
    private boolean u = false;
    private boolean w = false;
    private int F = 1;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private OnDownloadStateListener S = new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.1
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            try {
                a.this.f = 1;
                if (a.this.v == null) {
                    a.this.v = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                }
                a.this.v.a(a.this.j, a.this.m, a.this.q, a.this.f);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            try {
                if (a.this.v == null) {
                    a.this.v = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                }
                a.this.v.a(a.this.n, a.this.p, 5);
                a aVar = a.this;
                aVar.a(aVar.p, false);
                if (a.this.B != 0 && a.this.B != 100) {
                    a aVar2 = a.this;
                    aVar2.c(aVar2.f(1));
                }
                if (a.this.B == 100) {
                    a aVar3 = a.this;
                    aVar3.c(aVar3.f(3));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            try {
                if (a.this.A == null || a.this.A.getStatus() == DownloadStatus.CANCELLED) {
                    return;
                }
                String message = "Video Download Error";
                if (downloadError != null && downloadError.getException() != null) {
                    message = downloadError.getException().getMessage();
                }
                a.this.u();
                a.this.a(3, message);
                a.this.a(message);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
        }
    };
    private OnProgressStateListener T = new OnProgressStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.2
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                a.this.p = downloadProgress.getCurrent();
                a.this.m = downloadProgress.getTotal();
                a.this.B = downloadProgress.getCurrentDownloadRate();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
            if (MBridgeConstans.DEBUG) {
                aa.d("CampaignDownLoadTask", "name：" + a.this.j.getAppName() + " Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate: " + a.this.t + " - " + a.this.d + " total & current: " + downloadProgress.getTotal() + " - " + downloadProgress.getCurrent());
            }
        }
    };
    private OnDownloadStateListener U = new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.3
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            a.this.f = 1;
            if (a.this.v == null) {
                a.this.v = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
            }
            a.this.v.a(a.this.j, a.this.m, a.this.q, a.this.f);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            try {
                aa.d("CampaignDownLoadTask", "onDownloadComplete callback : " + a.this.p + "    " + a.this.m);
                if (a.this.v == null) {
                    a.this.v = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                }
                a.this.v.a(a.this.n, a.this.p, 5);
                a aVar = a.this;
                aVar.a(aVar.p, true);
                a aVar2 = a.this;
                aVar2.c(aVar2.f(3));
            } catch (Exception e) {
                aa.d("CampaignDownLoadTask", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            if (a.this.y == null || a.this.y.getStatus() == DownloadStatus.CANCELLED) {
                return;
            }
            String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
            a.this.u();
            a.this.a(3, message);
            a.this.a(message);
        }
    };
    private OnProgressStateListener V = new OnProgressStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.4
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                a.this.p = downloadProgress.getCurrent();
                a.this.m = downloadProgress.getTotal();
                a.this.B = downloadProgress.getCurrentDownloadRate();
                if (a.this.t != 100 && downloadProgress.getCurrentDownloadRate() >= a.this.t) {
                    aa.d("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate = " + a.this.t + " " + a.this.d);
                    if (a.this.e) {
                        return;
                    }
                    a.this.e = true;
                    if (!a.this.C) {
                        a aVar = a.this;
                        aVar.c(aVar.f(1));
                        a.this.a(downloadProgress.getCurrent(), false);
                    }
                    if (a.this.y == null || a.this.F != 2 || a.this.C) {
                        return;
                    }
                    a.this.y.cancel(downloadMessage);
                }
            } catch (Exception e) {
                aa.d("CampaignDownLoadTask", e.getMessage());
            }
        }
    };

    public a(Context context, CampaignEx campaignEx, String str, int i) {
        int iB;
        File file;
        this.a = false;
        this.c = 1;
        this.f = 0;
        this.p = 0L;
        this.J = false;
        this.R = "";
        if (context == null && campaignEx == null) {
            return;
        }
        com.mbridge.msdk.c.c cVarG = com.mbridge.msdk.c.d.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarG != null) {
            this.J = cVarG.f();
        }
        this.G = com.mbridge.msdk.foundation.same.a.D;
        this.H = com.mbridge.msdk.foundation.same.a.E;
        this.I = com.mbridge.msdk.foundation.same.a.C;
        this.s = System.currentTimeMillis();
        this.l = com.mbridge.msdk.foundation.controller.b.d().g();
        this.j = campaignEx;
        this.k = str;
        this.c = i;
        if (campaignEx != null) {
            this.n = campaignEx.getVideoUrlEncode();
        }
        this.x = y.d(this.n);
        this.o = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator;
        this.q = this.o + this.x;
        this.a = ac.a().a("u_n_d_r_r", false);
        aa.b("CampaignDownLoadTask", this.j.getAppName() + " videoLocalPath:" + this.q + " videoUrl: " + this.j.getVideoUrlEncode() + " " + this.t);
        if (campaignEx != null) {
            this.R = campaignEx.getCurrentLRid();
        }
        try {
            if (TextUtils.isEmpty(this.n)) {
                return;
            }
            File file2 = null;
            if (!TextUtils.isEmpty(this.o)) {
                file2 = new File(this.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (file2 != null && file2.exists() && ((file = this.E) == null || !file.exists())) {
                File file3 = new File(file2 + "/.nomedia");
                this.E = file3;
                if (!file3.exists()) {
                    this.E.createNewFile();
                }
            }
            p pVarA = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
            com.mbridge.msdk.foundation.entity.m mVarA = pVarA.a(this.n, "");
            if (mVarA != null) {
                this.p = mVarA.b();
                if (this.f != 2) {
                    this.f = mVarA.d();
                }
                if (this.f == 1) {
                    this.f = 2;
                }
                this.m = mVarA.c();
                if (mVarA.a() > 0) {
                    this.s = mVarA.a();
                }
                if (this.f == 5) {
                    if (Objects.exists(new File(this.o + this.x), this.o, this.x)) {
                        this.q = this.o + this.x;
                    } else {
                        t();
                    }
                } else if (this.f != 0) {
                    this.q = this.o + this.x;
                }
            } else {
                pVarA.a(this.n, this.s);
            }
            String str2 = this.n;
            if (TextUtils.isEmpty(str2)) {
                this.i.a("VideoUrl is NULL, Please check it.", "");
                return;
            }
            if (this.f == 1) {
                aa.a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
                return;
            }
            if (this.f == 5 && Utils.getDownloadRate(this.m, this.p) >= this.t) {
                aa.a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar = this.h;
                if (aVar != null) {
                    aVar.a(this.n);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
                if (aVar2 != null) {
                    aVar2.a(this.n);
                }
                try {
                    File file4 = new File(this.q);
                    if (Objects.exists(file4, this.o, this.x) && file4.isFile()) {
                        file4.setLastModified(System.currentTimeMillis());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                    return;
                }
            }
            if (this.c == 3) {
                aa.a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
                a(0L, false);
                return;
            }
            try {
                iB = b(this.j);
            } catch (Exception unused) {
                iB = 100;
            }
            if (iB == 0) {
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.h;
                if (aVar3 != null) {
                    aVar3.a(this.n);
                }
                com.mbridge.msdk.videocommon.listener.a aVar4 = this.i;
                if (aVar4 != null) {
                    aVar4.a(this.n);
                }
            }
            if (iB != 100 && this.a) {
                this.A = a(new DownloadMessage(new Object(), str2, this.x, iB, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO), this.S, this.T);
            }
            this.y = a(new DownloadMessage(new Object(), str2, this.x, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO), this.U, this.V);
        } catch (Exception e2) {
            aa.b("CampaignDownLoadTask", e2.getMessage());
        }
    }

    public final void a(boolean z) {
        this.N = z;
    }

    public final boolean a() {
        return this.N;
    }

    public final void b(boolean z) {
        this.O = z;
    }

    public final boolean b() {
        return this.O;
    }

    public final void c(boolean z) {
        this.P = z;
    }

    public final boolean c() {
        return this.P;
    }

    public final void d(boolean z) {
        this.Q = z;
    }

    public final boolean d() {
        return this.Q;
    }

    public final String e() {
        return this.n;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final boolean f() {
        return this.w;
    }

    public final void e(boolean z) {
        this.w = z;
    }

    public final long g() {
        return this.s;
    }

    public final void f(boolean z) {
        this.r = z;
    }

    public final String h() {
        return this.q;
    }

    public final long i() {
        return this.m;
    }

    public final int j() {
        return this.f;
    }

    public final void a(int i, int i2) {
        this.f = i;
        if (this.v == null) {
            this.v = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        this.v.a(this.n, i2, i);
    }

    public final CampaignEx k() {
        return this.j;
    }

    public final void a(CampaignEx campaignEx) {
        this.j = campaignEx;
        if (campaignEx != null) {
            this.R = campaignEx.getCurrentLRid();
        }
    }

    public final void c(int i) {
        aa.a("CampaignDownLoadTask", "set ready rate: " + i);
        this.t = i;
    }

    public final long l() {
        return this.p;
    }

    public final void d(int i) {
        this.D = i;
    }

    public final void e(int i) {
        this.F = i;
    }

    private DownloadRequest<?> a(DownloadMessage downloadMessage, OnDownloadStateListener onDownloadStateListener, OnProgressStateListener onProgressStateListener) {
        return MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(this.G).withConnectTimeout(this.I).withWriteTimeout(this.H).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.o).withDownloadStateListener(onDownloadStateListener).withProgressStateListener(onProgressStateListener).with("do_us_fi_re", Boolean.toString(this.J)).with(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, this.R).with("down_type", "4").build();
    }

    public final void a(long j, boolean z) {
        p pVar;
        aa.d("CampaignDownLoadTask", "setStateToDone ： mProgressSize " + this.p + "  progressSize " + j + "  " + this.B + "%   FileSize : " + this.m + "  " + this.j.getAppName());
        if (this.t == 100 && this.c != 3 && j != this.m && !z) {
            File file = new File(this.q);
            aa.d("CampaignDownLoadTask", "progressSize = " + j + " fileSize = " + this.m + " " + z + " absFileSize = " + (Objects.exists(file, this.o, this.x) ? file.length() : 0L));
            a("File size is not match witch download size.");
            return;
        }
        this.f = 5;
        if (j == this.m) {
            a(1, "");
        }
        long j2 = this.m;
        if (j2 != 0 && (pVar = this.v) != null) {
            pVar.b(this.n, j2);
        }
        this.f2662b = false;
        a(j, this.f);
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.h;
        if (aVar != null) {
            aVar.a(str, this.n);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a(str, this.n);
        }
        aa.d("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.f == 4 || this.f == 2 || this.f == 5) {
            return;
        }
        this.f = 4;
        CampaignEx campaignEx = this.j;
        if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && this.j.getRsIgnoreCheckRule().size() > 0 && this.j.getRsIgnoreCheckRule().contains(0)) {
            aa.b("CampaignDownLoadTask", "Is not check video download status");
        } else {
            a(this.p, this.f);
        }
    }

    public final void m() {
        aa.d("CampaignDownLoadTask", "startForLoadRefactor()");
        try {
            if (TextUtils.isEmpty(this.n)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.h;
                if (aVar != null) {
                    aVar.a(this.n);
                    return;
                }
                return;
            }
            if (this.n != null) {
                aa.d("CampaignDownLoadTask", new URL(this.n).getPath());
            }
            if (this.c == 3) {
                aa.d("CampaignDownLoadTask", "startForLoadRefactor: Dlnet is 3, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a(this.n);
                    return;
                }
                return;
            }
            if (this.t == 0 && this.F == 2) {
                aa.d("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.h;
                if (aVar3 != null) {
                    aVar3.a(this.n);
                    return;
                }
                return;
            }
            try {
                if (this.f == 5 && Utils.getDownloadRate(this.m, this.p) >= this.t && Objects.exists(new File(this.o + this.x), this.o, this.x)) {
                    this.q = this.o + this.x;
                    com.mbridge.msdk.videocommon.listener.a aVar4 = this.h;
                    if (aVar4 != null) {
                        aVar4.a(this.n);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                aa.d("CampaignDownLoadTask", "startForLoadRefactor: " + e.getMessage());
            }
            boolean z = this.a && this.F == 2 && this.t != 100;
            aa.d("CampaignDownLoadTask", "start: ready rate is " + this.t + " and video ctn type is " + this.F + " and isUseNewDownloadReadyRate " + z);
            if (z) {
                DownloadRequest downloadRequest = this.A;
                if (downloadRequest != null) {
                    downloadRequest.start();
                    return;
                }
                DownloadRequest downloadRequest2 = this.y;
                if (downloadRequest2 != null) {
                    downloadRequest2.start();
                    return;
                }
                return;
            }
            DownloadRequest downloadRequest3 = this.y;
            if (downloadRequest3 != null) {
                downloadRequest3.start();
                return;
            }
            DownloadRequest downloadRequest4 = this.A;
            if (downloadRequest4 != null) {
                downloadRequest4.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar5 = this.h;
            if (aVar5 != null) {
                aVar5.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void n() {
        aa.d("CampaignDownLoadTask", "start()");
        try {
            if (TextUtils.isEmpty(this.n)) {
                return;
            }
            if (this.n != null) {
                aa.d("CampaignDownLoadTask", new URL(this.n).getPath());
            }
            int i = this.t;
            if (i == 0 && this.F == 2) {
                aa.d("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                return;
            }
            boolean z = this.a && this.F == 2 && i != 100;
            aa.d("CampaignDownLoadTask", "start: ready rate is " + this.t + " and video ctn type is " + this.F + " and isUseNewDownloadReadyRate " + z);
            if (z) {
                DownloadRequest downloadRequest = this.A;
                if (downloadRequest != null) {
                    downloadRequest.start();
                    return;
                }
                DownloadRequest downloadRequest2 = this.y;
                if (downloadRequest2 != null) {
                    downloadRequest2.start();
                    return;
                }
                return;
            }
            DownloadRequest downloadRequest3 = this.y;
            if (downloadRequest3 != null) {
                downloadRequest3.start();
                return;
            }
            DownloadRequest downloadRequest4 = this.A;
            if (downloadRequest4 != null) {
                downloadRequest4.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.h;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    private int b(CampaignEx campaignEx) {
        int iC;
        if (campaignEx == null) {
            return 100;
        }
        if (campaignEx.getReady_rate() != -1) {
            iC = campaignEx.getReady_rate();
            aa.a("CampaignDownLoadTask", "ready_rate(campaign): " + iC);
        } else {
            iC = c(campaignEx);
            aa.a("CampaignDownLoadTask", "ready_rate(reward_unit_setting): " + iC);
        }
        try {
            return Math.max(iC, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 100;
        }
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.K == null) {
                    this.K = com.mbridge.msdk.c.d.a().c(com.mbridge.msdk.foundation.controller.b.d().h(), this.k);
                }
                return this.K.f();
            }
            if (campaignEx.getAdType() == 42) {
                if (this.M == null) {
                    this.M = com.mbridge.msdk.c.d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.k);
                }
                return d((CampaignEx) null);
            }
            if (this.L == null) {
                this.L = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.k, false);
            }
            return this.L.r();
        } catch (Throwable th) {
            aa.b("CampaignDownLoadTask", th.getMessage(), th);
            return 100;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.c.f fVar = this.M;
            if (fVar != null) {
                return fVar.f();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void o() {
        boolean z = true;
        try {
            this.C = true;
            if (this.F == 1) {
                aa.d("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.F);
                return;
            }
            if (this.c == 3) {
                aa.d("CampaignDownLoadTask", "Can not call resume(), because dlnet = " + this.c);
                return;
            }
            aa.d("CampaignDownLoadTask", "resume()");
            if (!this.a || this.F != 2 || this.t == 100) {
                z = false;
            }
            aa.d("CampaignDownLoadTask", "resume: ready rate is " + this.t + " and video ctn type is " + this.F + " and isUseNewDownloadReadyRate " + z);
            if (this.z == null) {
                this.z = new DownloadMessage(new Object(), this.n, this.x, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            }
            if (z) {
                DownloadRequest<?> downloadRequestA = a(new DownloadMessage(new Object(), this.n, this.x, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO), this.S, this.T);
                this.A = downloadRequestA;
                downloadRequestA.start();
            } else {
                DownloadRequest<?> downloadRequestA2 = a(new DownloadMessage(new Object(), this.n, this.x, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO), this.U, this.V);
                this.y = downloadRequestA2;
                downloadRequestA2.start();
            }
            c(f(2));
        } catch (Exception e) {
            aa.d("CampaignDownLoadTask", e.getMessage());
        }
    }

    public final void b(String str) {
        u();
        a(2, str);
        this.f = 4;
    }

    public final void a(d dVar) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(dVar);
        }
    }

    public final String p() {
        String message = "";
        if (this.c == 3) {
            return "";
        }
        String str = this.o + this.x;
        File file = new File(str);
        try {
            if (!Objects.exists(file, this.o, this.x)) {
                message = "file is not exist ";
            } else if (!file.isFile()) {
                message = "file is not file ";
            } else if (!file.canRead()) {
                message = "file can not read ";
            } else if (file.length() > 0) {
                this.q = str;
            } else {
                message = "file length is 0 ";
            }
        } catch (Throwable th) {
            aa.d("CampaignDownLoadTask", th.getMessage());
            message = th.getMessage();
        }
        if (this.f == 5 && !TextUtils.isEmpty(message)) {
            t();
        }
        return message;
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.h = aVar;
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.i = aVar;
    }

    private void a(long j, int i) {
        this.p = j;
        int i2 = this.t;
        if (100 * j >= ((long) i2) * this.m && !this.u && i != 4) {
            if (i2 == 100 && i != 5) {
                this.f = 5;
                return;
            }
            this.u = true;
            aa.d("CampaignDownLoadTask", "UpdateListener : state: " + i + " progress : " + j);
            String strP = p();
            if (TextUtils.isEmpty(strP)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.h;
                if (aVar != null) {
                    aVar.a(this.n);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
                if (aVar2 != null) {
                    aVar2.a(this.n);
                }
            } else {
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.h;
                if (aVar3 != null) {
                    aVar3.a("file is not effective " + strP, this.n);
                }
                com.mbridge.msdk.videocommon.listener.a aVar4 = this.i;
                if (aVar4 != null) {
                    aVar4.a("file is not effective " + strP, this.n);
                }
            }
        }
        if (!this.f2662b && j > 0) {
            this.f2662b = true;
            if (this.v == null) {
                this.v = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
            }
            this.v.a(this.n, j, this.f);
        }
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            for (d dVar : copyOnWriteArrayList) {
                if (dVar != null) {
                    dVar.a(j, i);
                }
            }
        }
    }

    public final void q() {
        if (this.g != null) {
            this.g = null;
        }
    }

    private void t() {
        if (this.v == null) {
            this.v = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        try {
            try {
                this.v.b(this.n);
                if (!ac.a().a("r_d_v_b_l", true)) {
                    File file = new File(this.q);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                }
            } finally {
                this.f = 0;
            }
        } catch (Throwable unused) {
            aa.d("CampaignDownLoadTask", "del DB or file failed");
        }
    }

    public final void r() {
        try {
            try {
                t();
                CampaignEx campaignEx = this.j;
                if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
                    return;
                }
                com.mbridge.msdk.videocommon.a.a aVarA = com.mbridge.msdk.videocommon.a.a.a();
                if (aVarA != null) {
                    aVarA.a(this.j);
                }
            } catch (Exception unused) {
                aa.d("CampaignDownLoadTask", "del file is failed");
            }
        } finally {
            this.f = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.reward.b.a");
            cls.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(cls.newInstance(), this.k, this.j);
            Class<?> cls2 = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            cls2.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(cls2.newInstance(), this.k, this.j);
        } catch (Exception e) {
            aa.d("CampaignDownLoadTask", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0091 A[Catch: Exception -> 0x00a0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a0, blocks: (B:7:0x0059, B:14:0x0068, B:16:0x0075, B:18:0x0084, B:20:0x0091), top: B:25:0x0059 }] */
    public void a(int i, String str) {
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n(this.l, this.j, i, Long.toString(this.s != 0 ? System.currentTimeMillis() - this.s : 0L), this.m, this.D);
        nVar.q(this.j.getId());
        nVar.e(this.j.getVideoUrlEncode());
        nVar.s(str);
        nVar.m(this.j.getRequestId());
        nVar.n(this.j.getCurrentLRid());
        nVar.o(this.j.getRequestIdNotice());
        nVar.p(this.k);
        try {
            int i2 = this.D;
            if (i2 == 94 || i2 == 287) {
                if (ac.a().a("r_l_b_m_t_r_i", true)) {
                    a(nVar, this.j);
                    com.mbridge.msdk.foundation.same.report.m.a().a(nVar, this.j);
                    return;
                }
            } else if (i2 == 296) {
                if (ac.a().a("r_l_b_m_t_b", false)) {
                    a(nVar, this.j);
                    com.mbridge.msdk.foundation.same.report.m.a().a(nVar, this.j);
                    return;
                }
                if (ac.a().a("r_l_b_m_t_r_i", true)) {
                    a(nVar, this.j);
                    com.mbridge.msdk.foundation.same.report.m.a().a(nVar, this.j);
                    return;
                }
            }
        } catch (Exception unused) {
        }
        q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.same.report.k.a().c()) {
                com.mbridge.msdk.foundation.same.report.k.a().a(str);
                return;
            }
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.b.d().g());
            com.mbridge.msdk.foundation.same.net.g.d dVarA = com.mbridge.msdk.foundation.same.report.q.a(str, com.mbridge.msdk.foundation.controller.b.d().g(), this.k);
            CampaignEx campaignEx = this.j;
            if (campaignEx != null && campaignEx.getAdType() != 42) {
                dVarA.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
            }
            aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, dVarA, null);
        } catch (Exception e) {
            aa.d("CampaignDownLoadTask", e.getMessage());
        }
    }

    public final String s() {
        try {
            File file = new File(this.q);
            if (Objects.exists(file, this.o, this.x) && file.isFile()) {
                return this.q;
            }
        } catch (Exception e) {
            aa.d("CampaignDownLoadTask", e.getMessage());
        }
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(int i) {
        if (this.j == null || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.j.getRequestId()) || TextUtils.isEmpty(this.j.getVideoUrlEncode())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("key=").append("2000077").append("&").append("unit_id=").append(this.k).append("&").append("rid=").append(this.j.getRequestId()).append("&").append("rid_n=").append(this.j.getRequestIdNotice()).append("&").append("package_name=").append(com.mbridge.msdk.foundation.controller.b.d().b()).append("&").append("app_id=").append(com.mbridge.msdk.foundation.controller.b.d().h()).append("&").append("video_url=").append(URLEncoder.encode(this.j.getVideoUrlEncode())).append("&").append("process_size=").append(this.p).append("&").append("file_size=").append(this.m).append("&").append("ready_rate=").append(this.t).append("&").append("cd_rate=").append(this.d).append("&").append("cid=").append(this.j.getId()).append("&").append("type=").append(this.f).append("&").append("video_download_status=").append(i);
        return sb.toString();
    }

    private static void a(com.mbridge.msdk.foundation.entity.n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), campaignEx.getCampaignUnitId());
            if (cVarA != null) {
                nVar.l(cVarA.l());
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB != null) {
                nVar.k(aVarB.c());
            }
        } catch (Exception e) {
            aa.d("CampaignDownLoadTask", e.getMessage());
        }
    }
}

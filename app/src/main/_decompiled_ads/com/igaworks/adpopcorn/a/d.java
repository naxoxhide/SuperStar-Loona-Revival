package com.igaworks.adpopcorn.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.igaworks.adpopcorn.activity.ApVideoAdActivity;
import com.igaworks.adpopcorn.cores.common.APPopupAdError;
import com.igaworks.adpopcorn.cores.common.APUpdateLog;
import com.igaworks.adpopcorn.cores.common.APVideoError;
import com.igaworks.adpopcorn.cores.common.l;
import com.igaworks.adpopcorn.cores.model.APClientRewardItem;
import com.igaworks.adpopcorn.cores.model.j;
import com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAPLoadVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPOpenCampaignPageEventListener;
import com.igaworks.adpopcorn.interfaces.IAPPopupAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener;
import com.igaworks.adpopcorn.interfaces.IAPShowVideoAdEventListener;
import com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener;
import com.igaworks.adpopcorn.interfaces.IAdPopcornParticipateEventListener;
import com.igaworks.adpopcorn.interfaces.IOnestoreEventListener;
import com.igaworks.adpopcorn.nativead.custom.ApCustomRewardCPMError;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements IAPClientRewardCallbackListener, com.igaworks.adpopcorn.a.g.a.d {
    public static boolean E = false;
    private static Activity F;
    private static d G;
    private IAPOpenCampaignPageEventListener A;
    private com.igaworks.adpopcorn.cores.model.g B;
    private Dialog C;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f1486b;
    private com.igaworks.adpopcorn.a.c c;
    private com.igaworks.adpopcorn.a.h.b.b h;
    private com.igaworks.adpopcorn.a.h.a.a i;
    private com.igaworks.adpopcorn.cores.common.g n;
    private com.igaworks.adpopcorn.a.g.a o;
    private com.igaworks.adpopcorn.activity.b.d.c p;
    private List<j> q;
    private IAPLoadVideoAdEventListener s;
    private IAPShowVideoAdEventListener t;
    private List<com.igaworks.adpopcorn.cores.model.h> v;
    private IAPPopupAdEventListener x;
    private com.igaworks.adpopcorn.activity.b.d.a y;
    private IAdPopcornParticipateEventListener z;
    private IAdPOPcornEventListener d = null;
    private IAPClientRewardCallbackListener e = null;
    private IAPRewardInfoCallbackListener f = null;
    private HashMap<String, IOnestoreEventListener> g = null;
    private com.igaworks.adpopcorn.a.h.b.c j = new com.igaworks.adpopcorn.a.h.b.c();
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private int r = -1;
    private String u = "";
    private int w = -1;
    View.OnClickListener D = new h();

    class a implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.a.d$a$a, reason: collision with other inner class name */
        class C0396a implements com.igaworks.adpopcorn.cores.common.a.c {
            C0396a() {
            }

            @Override // com.igaworks.adpopcorn.cores.common.a.c
            public void a(com.igaworks.adpopcorn.cores.common.a.d dVar) {
                if (dVar != null) {
                    a aVar = a.this;
                    d.this.d(aVar.a, dVar.a());
                }
            }
        }

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a(d.this.a).a(d.this.a, new C0396a());
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1488b;

        class a implements com.igaworks.adpopcorn.cores.common.a.c {
            a() {
            }

            @Override // com.igaworks.adpopcorn.cores.common.a.c
            public void a(com.igaworks.adpopcorn.cores.common.a.d dVar) {
                if (dVar != null) {
                    b bVar = b.this;
                    d.this.a(bVar.a, bVar.f1488b, dVar.a());
                }
            }
        }

        b(String str, String str2) {
            this.a = str;
            this.f1488b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a(d.this.a).a(d.this.a, new a());
        }
    }

    class c implements Runnable {

        class a implements com.igaworks.adpopcorn.cores.common.a.c {
            a() {
            }

            @Override // com.igaworks.adpopcorn.cores.common.a.c
            public void a(com.igaworks.adpopcorn.cores.common.a.d dVar) {
                if (dVar != null) {
                    d.this.f(dVar.a());
                }
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a(d.this.a).a(d.this.a, new a());
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.a.d$d, reason: collision with other inner class name */
    class DialogInterfaceOnDismissListenerC0397d implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC0397d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (d.this.w >= d.this.v.size() - 1) {
                    d.this.w = -1;
                    if (d.this.x != null) {
                        d.this.x.OnLoadPopupAdFailure(new APPopupAdError(5005, APPopupAdError.ALL_LOADED_POPUP_AD_SHOWN_MESSAGE));
                    }
                } else {
                    d.g(d.this);
                    if (d.this.x != null) {
                        d.this.x.OnLoadPopupAdSuccess();
                    }
                    d.this.k();
                }
            } catch (Exception unused) {
            } finally {
                if (d.this.x != null) {
                    d.this.x.OnPopupAdClose();
                }
            }
        }
    }

    class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (d.this.C != null) {
                d.this.C = null;
            }
            if (d.this.A != null) {
                d.this.A.OnClosed();
            }
        }
    }

    class f implements DialogInterface.OnDismissListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (d.this.C != null) {
                d.this.C = null;
            }
            if (d.this.A != null) {
                d.this.A.OnClosed();
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.b();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.igaworks.adpopcorn.a.g.a aVar;
            d dVar;
            String str;
            if (d.this.B != null) {
                d.this.l();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("auth", d.this.B.a());
                    jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(d.this.a));
                    jSONObject.put("channel_code", 5);
                    if (d.E) {
                        aVar = d.this.o;
                        dVar = d.this;
                        str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
                    } else {
                        aVar = d.this.o;
                        dVar = d.this;
                        str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
                    }
                    aVar.a(1, str, jSONObject, dVar);
                } catch (Exception unused) {
                    d.this.c();
                }
            }
        }
    }

    public d(Context context, com.igaworks.adpopcorn.a.c cVar) {
        this.h = new com.igaworks.adpopcorn.a.h.b.b();
        this.i = new com.igaworks.adpopcorn.a.h.a.a();
        this.a = context;
        G = this;
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.n = gVarA;
        if (gVarA != null) {
            gVarA.d();
        }
        try {
            this.a = context;
            this.c = cVar;
            cVar.d(com.igaworks.adpopcorn.cores.common.c.b(context));
            if (this.h == null) {
                this.h = new com.igaworks.adpopcorn.a.h.b.b();
            }
            this.h.a(this.c.b(), this.c.g(), this.c.c());
            if (this.i == null) {
                this.i = new com.igaworks.adpopcorn.a.h.a.a();
            }
            this.i.a(this.c.b(), this.c.c(), this.a);
        } catch (Exception unused) {
        }
        com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "adpopcorn sdk version : " + APUpdateLog.SDK_VERSION, 3);
        com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "adpopcorn sdk app key : " + this.c.b(), 3);
        com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "adpopcorn sdk hash key : " + this.c.c(), 3);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0070 A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0088 A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0090 A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x00a7 A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x00af A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d1 A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00d8 A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00e0 A[Catch: Exception -> 0x0107, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00e9 A[PHI: r12
      0x00e9: PHI (r12v2 java.lang.String) = (r12v1 java.lang.String), (r12v4 java.lang.String) binds: [B:29:0x00de, B:31:0x00e6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ee A[Catch: Exception -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0100 A[Catch: Exception -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0107, blocks: (B:5:0x0019, B:8:0x0031, B:9:0x0044, B:13:0x0065, B:14:0x0068, B:16:0x0070, B:17:0x0083, B:21:0x00a4, B:22:0x00a7, B:24:0x00af, B:25:0x00c9, B:27:0x00d1, B:31:0x00e6, B:34:0x00ee, B:40:0x0100, B:28:0x00d8, B:30:0x00e0, B:18:0x0088, B:20:0x0090, B:10:0x0049, B:12:0x0051), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0115  */
    /* JADX WARN: Code duplicated, block: B:68:0x0156  */
    /* JADX WARN: Code duplicated, block: B:76:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static d a(Context context) {
        boolean z;
        d dVar;
        PackageManager packageManager;
        boolean z2;
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        Object obj;
        if (G == null) {
            com.igaworks.adpopcorn.a.c cVar = new com.igaworks.adpopcorn.a.c(context);
            boolean z3 = true;
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                String str = "";
                try {
                    if (applicationInfo.metaData.containsKey("adpopcorn_app_key")) {
                        sbAppend = new StringBuilder().append(applicationInfo.metaData.get("adpopcorn_app_key")).append("");
                    } else {
                        if (applicationInfo.metaData.containsKey("igaworks_app_key")) {
                            sbAppend = new StringBuilder().append(applicationInfo.metaData.get("igaworks_app_key")).append("");
                        } else {
                            if (applicationInfo.metaData.containsKey("adpopcorn_hash_key")) {
                                sbAppend2 = new StringBuilder().append(applicationInfo.metaData.get("adpopcorn_hash_key")).append("");
                            } else if (applicationInfo.metaData.containsKey("igaworks_hash_key")) {
                                sbAppend2 = new StringBuilder().append(applicationInfo.metaData.get("igaworks_hash_key")).append("");
                            } else {
                                if (applicationInfo.metaData.containsKey("igaworks_market_info")) {
                                    cVar.c(applicationInfo.metaData.get("igaworks_market_info") + "");
                                }
                                if (applicationInfo.metaData.containsKey("adpopcorn_reward_server_type")) {
                                    obj = applicationInfo.metaData.get("adpopcorn_reward_server_type");
                                } else if (applicationInfo.metaData.containsKey("igaworks_reward_server_type")) {
                                    obj = applicationInfo.metaData.get("igaworks_reward_server_type");
                                } else if (str == null && str.equals("client")) {
                                    try {
                                        com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : client", 3);
                                        z = true;
                                    } catch (Exception e2) {
                                        e = e2;
                                        z = true;
                                        e.printStackTrace();
                                    }
                                } else {
                                    com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                    z = false;
                                }
                                str = (String) obj;
                                if (str == null) {
                                    com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                    z = false;
                                } else {
                                    com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                    z = false;
                                }
                            }
                            cVar.b(sbAppend2.toString());
                            if (applicationInfo.metaData.containsKey("igaworks_market_info")) {
                                cVar.c(applicationInfo.metaData.get("igaworks_market_info") + "");
                            }
                            if (applicationInfo.metaData.containsKey("adpopcorn_reward_server_type")) {
                                obj = applicationInfo.metaData.get("adpopcorn_reward_server_type");
                            } else if (applicationInfo.metaData.containsKey("igaworks_reward_server_type")) {
                                obj = applicationInfo.metaData.get("igaworks_reward_server_type");
                            } else if (str == null) {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            } else {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            }
                            str = (String) obj;
                            if (str == null) {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            } else {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            }
                        }
                        dVar = new d(context, cVar);
                        G = dVar;
                        if (z) {
                            dVar.a(true);
                        }
                        G.e(context);
                        G.d(context);
                        packageManager = context.getPackageManager();
                        packageManager.getApplicationInfo("com.skt.skaf.A000Z00040", 0);
                        z2 = true;
                        if (!z2) {
                            try {
                                packageManager.getApplicationInfo("com.kt.olleh.storefront", 0);
                                z2 = true;
                            } catch (Exception unused) {
                                z2 = false;
                            }
                        }
                        if (!z2) {
                            try {
                                packageManager.getApplicationInfo("com.kt.olleh.istore", 0);
                                z2 = true;
                            } catch (Exception unused2) {
                                z2 = false;
                            }
                        }
                        if (!z2) {
                            try {
                                packageManager.getApplicationInfo("com.lguplus.appstore", 0);
                                z2 = true;
                            } catch (Exception unused3) {
                                z2 = false;
                            }
                        }
                        if (z2) {
                            z3 = z2;
                        } else {
                            try {
                                packageManager.getApplicationInfo("android.lgt.appstore", 0);
                            } catch (Exception unused4) {
                                z3 = false;
                            }
                        }
                        cVar.b(z3);
                    }
                    if (applicationInfo.metaData.containsKey("adpopcorn_hash_key")) {
                        sbAppend2 = new StringBuilder().append(applicationInfo.metaData.get("adpopcorn_hash_key")).append("");
                    } else {
                        if (applicationInfo.metaData.containsKey("igaworks_hash_key")) {
                            sbAppend2 = new StringBuilder().append(applicationInfo.metaData.get("igaworks_hash_key")).append("");
                        } else {
                            if (applicationInfo.metaData.containsKey("igaworks_market_info")) {
                                cVar.c(applicationInfo.metaData.get("igaworks_market_info") + "");
                            }
                            if (applicationInfo.metaData.containsKey("adpopcorn_reward_server_type")) {
                                obj = applicationInfo.metaData.get("adpopcorn_reward_server_type");
                            } else if (applicationInfo.metaData.containsKey("igaworks_reward_server_type")) {
                                obj = applicationInfo.metaData.get("igaworks_reward_server_type");
                            } else if (str == null) {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            } else {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            }
                            str = (String) obj;
                            if (str == null) {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            } else {
                                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                                z = false;
                            }
                        }
                        dVar = new d(context, cVar);
                        G = dVar;
                        if (z) {
                            dVar.a(true);
                        }
                        G.e(context);
                        G.d(context);
                        packageManager = context.getPackageManager();
                        packageManager.getApplicationInfo("com.skt.skaf.A000Z00040", 0);
                        z2 = true;
                        if (!z2) {
                            packageManager.getApplicationInfo("com.kt.olleh.storefront", 0);
                            z2 = true;
                        }
                        if (!z2) {
                            packageManager.getApplicationInfo("com.kt.olleh.istore", 0);
                            z2 = true;
                        }
                        if (!z2) {
                            packageManager.getApplicationInfo("com.lguplus.appstore", 0);
                            z2 = true;
                        }
                        if (z2) {
                            packageManager.getApplicationInfo("android.lgt.appstore", 0);
                        } else {
                            z3 = z2;
                        }
                        cVar.b(z3);
                    }
                    if (applicationInfo.metaData.containsKey("adpopcorn_reward_server_type")) {
                        obj = applicationInfo.metaData.get("adpopcorn_reward_server_type");
                    } else {
                        if (applicationInfo.metaData.containsKey("igaworks_reward_server_type")) {
                            obj = applicationInfo.metaData.get("igaworks_reward_server_type");
                        } else if (str == null) {
                            com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                            z = false;
                        } else {
                            com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                            z = false;
                        }
                        dVar = new d(context, cVar);
                        G = dVar;
                        if (z) {
                            dVar.a(true);
                        }
                        G.e(context);
                        G.d(context);
                        packageManager = context.getPackageManager();
                        packageManager.getApplicationInfo("com.skt.skaf.A000Z00040", 0);
                        z2 = true;
                        if (!z2) {
                            packageManager.getApplicationInfo("com.kt.olleh.storefront", 0);
                            z2 = true;
                        }
                        if (!z2) {
                            packageManager.getApplicationInfo("com.kt.olleh.istore", 0);
                            z2 = true;
                        }
                        if (!z2) {
                            packageManager.getApplicationInfo("com.lguplus.appstore", 0);
                            z2 = true;
                        }
                        if (z2) {
                            packageManager.getApplicationInfo("android.lgt.appstore", 0);
                        } else {
                            z3 = z2;
                        }
                        cVar.b(z3);
                    }
                    packageManager.getApplicationInfo("com.skt.skaf.A000Z00040", 0);
                    z2 = true;
                } catch (Exception unused5) {
                    z2 = false;
                }
                cVar.a(sbAppend.toString());
                cVar.b(sbAppend2.toString());
                if (applicationInfo.metaData.containsKey("igaworks_market_info")) {
                    cVar.c(applicationInfo.metaData.get("igaworks_market_info") + "");
                }
                str = (String) obj;
                if (str == null) {
                    com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                    z = false;
                } else {
                    com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "reward server type : s2s", 3);
                    z = false;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            dVar = new d(context, cVar);
            G = dVar;
            if (z) {
                dVar.a(true);
            }
            G.e(context);
            G.d(context);
            packageManager = context.getPackageManager();
            if (!z2) {
                packageManager.getApplicationInfo("com.kt.olleh.storefront", 0);
                z2 = true;
            }
            if (!z2) {
                packageManager.getApplicationInfo("com.kt.olleh.istore", 0);
                z2 = true;
            }
            if (!z2) {
                packageManager.getApplicationInfo("com.lguplus.appstore", 0);
                z2 = true;
            }
            if (z2) {
                packageManager.getApplicationInfo("android.lgt.appstore", 0);
            } else {
                z3 = z2;
            }
            cVar.b(z3);
        }
        return G;
    }

    private void a(Context context, j jVar) {
        try {
            try {
                a(jVar.d(), jVar.b(), jVar.c(), jVar.h(), jVar.e(), jVar.f(), jVar.g(), jVar.j(), jVar.k(), jVar.l(), jVar.r(), jVar.a(), jVar.s(), jVar.n(), jVar.o(), jVar.q(), jVar.i(), jVar.p(), jVar.m());
                try {
                    IAPShowVideoAdEventListener iAPShowVideoAdEventListener = this.t;
                    if (iAPShowVideoAdEventListener != null) {
                        iAPShowVideoAdEventListener.OnShowVideoAdSuccess();
                    }
                    if (this.r >= this.q.size() - 1) {
                        this.r = -1;
                        if (this.s != null) {
                            this.s.OnLoadVideoAdFailure(new APVideoError(5005, APVideoError.ALL_LOADED_VIDEO_SHOWN_MESSAGE));
                            return;
                        }
                        return;
                    }
                    this.r++;
                    IAPLoadVideoAdEventListener iAPLoadVideoAdEventListener = this.s;
                    if (iAPLoadVideoAdEventListener != null) {
                        iAPLoadVideoAdEventListener.OnLoadVideoAdSuccess();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    private void a(com.igaworks.adpopcorn.cores.model.f fVar) {
        try {
            c();
            if (fVar != null && fVar.d()) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackCollectAdPopcornAction timeout", 3);
            } else if (fVar != null && fVar.a().length() > 0) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackCollectAdPopcornAction return string = " + fVar.a(), 3);
                try {
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    if (jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false) {
                        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackCollectAdPopcornAction success", 3);
                        com.igaworks.adpopcorn.a.b.a().b(this.a, "adpopcorn_action", "collected_action_list", "");
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, String str2) {
        c();
        b();
        String str3 = this.n.h;
        try {
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.a aVar = new com.igaworks.adpopcorn.activity.b.d.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), str, str2, -1, str3, new g(), c(this.a), false);
            this.y = aVar;
            aVar.setCancelable(false);
            this.y.setCanceledOnTouchOutside(false);
            this.y.show();
        } catch (Exception unused) {
        }
    }

    private void a(String str, String str2, double d, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, boolean z, String str11, int i2, String str12, String str13, int i3, String str14) {
        try {
            Intent intentPutExtra = new Intent(this.a, (Class<?>) ApVideoAdActivity.class).putExtra("cKey", str).putExtra("joinAuth", str2).putExtra("averageRating", d).putExtra("landscapeImageURL", str3).putExtra("clickAction", str4).putExtra("campaignDescription", str5).putExtra("iconImageURL", str6).putExtra("campaignName", str7).putExtra("numberOfDownloads", str8).putExtra("redirectURL", str9).putExtra("videoURL", str10).putExtra("ADType", i).putExtra("AutoRedirect", z).putExtra("fromVideoAPI", true).putExtra("rewardName", str11).putExtra("skipAllowSeconds", i2).putExtra("videoImpressionURL", str12).putExtra("moreClickReportURL", str13).putExtra("PartiTypeCode", i3).putExtra("campaignCondition", str14);
            intentPutExtra.setFlags(268435456);
            this.a.startActivity(intentPutExtra);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        try {
            JSONObject jSONObjectA = this.i.a(this.j.d(), this.j.b(), str, str2, str3);
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            this.o.a(16, "https://apapi.adpopcorn.com/ap/v1/sdk/media/clientcompletereward", jSONObjectA, str2, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "sendCompleteClientRewardRequestForUnity Exception - \n " + e2.getMessage(), 0);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.igaworks.adpopcorn.activity.b.d.a aVar = this.y;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.y.dismiss();
        this.y = null;
    }

    public static void b(Activity activity) {
        F = activity;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0058 A[Catch: Exception -> 0x0077, TRY_LEAVE, TryCatch #2 {Exception -> 0x0077, blocks: (B:13:0x0049, B:15:0x0058), top: B:48:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:20:0x0064 A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #3 {Exception -> 0x0075, blocks: (B:18:0x005e, B:20:0x0064), top: B:50:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    /* JADX WARN: Code duplicated, block: B:25:0x0070 A[Catch: Exception -> 0x0079, TRY_LEAVE, TryCatch #1 {Exception -> 0x0079, blocks: (B:23:0x006a, B:25:0x0070), top: B:46:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0079 A[PHI: r1 r11
      0x0079: PHI (r1v2 int) = (r1v1 int), (r1v4 int), (r1v6 int), (r1v6 int) binds: [B:28:0x0077, B:27:0x0075, B:42:0x0079, B:24:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r11v6 boolean) = (r11v5 boolean), (r11v13 boolean), (r11v13 boolean), (r11v13 boolean) binds: [B:28:0x0077, B:27:0x0075, B:42:0x0079, B:24:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x007c A[Catch: Exception -> 0x008d, TRY_ENTER, TryCatch #0 {Exception -> 0x008d, blocks: (B:4:0x000e, B:6:0x0014, B:36:0x0089, B:10:0x0023, B:12:0x002d, B:31:0x007c, B:33:0x0080, B:34:0x0085), top: B:44:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0080 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:4:0x000e, B:6:0x0014, B:36:0x0089, B:10:0x0023, B:12:0x002d, B:31:0x007c, B:33:0x0080, B:34:0x0085), top: B:44:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0085 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:4:0x000e, B:6:0x0014, B:36:0x0089, B:10:0x0023, B:12:0x002d, B:31:0x007c, B:33:0x0080, B:34:0x0085), top: B:44:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0089 A[Catch: Exception -> 0x008d, PHI: r11
      0x0089: PHI (r11v4 com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener) = 
      (r11v2 com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener)
      (r11v8 com.igaworks.adpopcorn.interfaces.IAPRewardInfoCallbackListener)
     binds: [B:8:0x001f, B:35:0x0087] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x008d, blocks: (B:4:0x000e, B:6:0x0014, B:36:0x0089, B:10:0x0023, B:12:0x002d, B:31:0x007c, B:33:0x0080, B:34:0x0085), top: B:44:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    private void b(com.igaworks.adpopcorn.cores.model.f fVar) {
        IAPRewardInfoCallbackListener iAPRewardInfoCallbackListener;
        boolean z;
        int i;
        String string;
        IAPRewardInfoCallbackListener iAPRewardInfoCallbackListener2;
        JSONObject jSONObject;
        if (fVar != null) {
            try {
                if (fVar.d()) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackGetEarnableRewardInfo timeout", 3);
                    iAPRewardInfoCallbackListener = this.f;
                    if (iAPRewardInfoCallbackListener != null) {
                        iAPRewardInfoCallbackListener.OnEarnableTotalRewardInfo(false, 0, "");
                    }
                } else if (fVar != null && fVar.a().length() > 0) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackGetEarnableRewardInfo httpString : " + fVar.a(), 3);
                    try {
                        jSONObject = new JSONObject(fVar.a());
                        if (jSONObject.has("Result")) {
                            z = jSONObject.getBoolean("Result");
                        } else {
                            z = false;
                        }
                        try {
                            if (jSONObject.has("TotalCount")) {
                                i = jSONObject.getInt("TotalCount");
                            } else {
                                i = 0;
                            }
                            try {
                                if (jSONObject.has("TotalReward")) {
                                    string = jSONObject.getString("TotalReward");
                                } else {
                                    string = "";
                                }
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            i = 0;
                        }
                    } catch (Exception unused3) {
                        z = false;
                        i = 0;
                    }
                    if (z) {
                        iAPRewardInfoCallbackListener2 = this.f;
                        if (iAPRewardInfoCallbackListener2 != null) {
                            iAPRewardInfoCallbackListener2.OnEarnableTotalRewardInfo(true, i, string);
                        }
                    } else {
                        iAPRewardInfoCallbackListener = this.f;
                        if (iAPRewardInfoCallbackListener != null) {
                            iAPRewardInfoCallbackListener.OnEarnableTotalRewardInfo(false, 0, "");
                        }
                    }
                }
            } catch (Exception unused4) {
                IAPRewardInfoCallbackListener iAPRewardInfoCallbackListener3 = this.f;
                if (iAPRewardInfoCallbackListener3 != null) {
                    iAPRewardInfoCallbackListener3.OnEarnableTotalRewardInfo(false, 0, "");
                }
            }
        } else if (fVar != null) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackGetEarnableRewardInfo httpString : " + fVar.a(), 3);
            jSONObject = new JSONObject(fVar.a());
            if (jSONObject.has("Result")) {
                z = jSONObject.getBoolean("Result");
            } else {
                z = false;
            }
            if (jSONObject.has("TotalCount")) {
                i = jSONObject.getInt("TotalCount");
            } else {
                i = 0;
            }
            if (jSONObject.has("TotalReward")) {
                string = jSONObject.getString("TotalReward");
            } else {
                string = "";
            }
            if (z) {
                iAPRewardInfoCallbackListener2 = this.f;
                if (iAPRewardInfoCallbackListener2 != null) {
                    iAPRewardInfoCallbackListener2.OnEarnableTotalRewardInfo(true, i, string);
                }
            } else {
                iAPRewardInfoCallbackListener = this.f;
                if (iAPRewardInfoCallbackListener != null) {
                    iAPRewardInfoCallbackListener.OnEarnableTotalRewardInfo(false, 0, "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.igaworks.adpopcorn.activity.b.d.c cVar = this.p;
        if (cVar != null) {
            cVar.dismiss();
            this.p = null;
        }
    }

    private boolean c(Context context) {
        try {
            Configuration configuration = ((Activity) context).getResources().getConfiguration();
            return configuration != null && configuration.orientation == 2;
        } catch (Exception unused) {
        }
    }

    private void d(com.igaworks.adpopcorn.cores.model.f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        c();
        if (fVar != null && fVar.d()) {
            com.igaworks.adpopcorn.cores.common.g gVar = this.n;
            str = gVar.p;
            str2 = gVar.e;
        } else if (fVar == null || fVar.a().length() <= 0) {
            com.igaworks.adpopcorn.cores.common.g gVar2 = this.n;
            str = gVar2.Y;
            str2 = gVar2.g;
        } else {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackJoinOpenCampaign result = " + fVar.a(), 3);
                JSONObject jSONObject = new JSONObject(fVar.a());
                boolean z = jSONObject.getBoolean("Result");
                String string = jSONObject.getString("ResultMsg");
                int i = jSONObject.getInt("ResultCode");
                String string2 = (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) ? "" : jSONObject.getString("RedirectURL");
                if (z) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackJoinOpenCampaign success, redirectURL = " + string2, 3);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Uri uri = Uri.parse(string2);
                    if (this.B.h0()) {
                        uri = Uri.parse(this.B.M());
                    }
                    intent.setData(uri);
                    try {
                        this.a.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                        com.igaworks.adpopcorn.cores.common.g gVar3 = this.n;
                        str3 = gVar3.q;
                        str4 = gVar3.w;
                    }
                } else {
                    if (i != 999 && i != 1000) {
                        a(this.n.q, string);
                        return;
                    }
                    com.igaworks.adpopcorn.cores.common.g gVar4 = this.n;
                    str3 = gVar4.q;
                    str4 = gVar4.l0;
                }
                a(str3, str4);
                return;
            } catch (Exception unused2) {
            }
        }
        a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2) {
        try {
            JSONObject jSONObjectA = this.i.a(this.j.d(), this.j.b(), this.j.a(), str, str2);
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            this.o.a(16, "https://apapi.adpopcorn.com/ap/v1/sdk/media/clientcompletereward", jSONObjectA, str, this);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "sendCompleteClientRewardRequest Exception - \n " + e2.getMessage(), 0);
            e2.printStackTrace();
        }
    }

    public static boolean d(String str) {
        try {
            if (F == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.parse(str));
            F.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:115:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:117:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00ec A[Catch: Exception -> 0x0180, TryCatch #0 {Exception -> 0x0180, blocks: (B:3:0x0016, B:5:0x001b, B:7:0x0021, B:9:0x0032, B:11:0x003c, B:13:0x0040, B:70:0x00ec, B:72:0x00f8, B:74:0x00fe, B:76:0x0103, B:78:0x0109, B:80:0x010e, B:82:0x0114, B:84:0x0119, B:86:0x011f, B:87:0x0122, B:89:0x0128, B:97:0x0146, B:98:0x014d, B:104:0x017c, B:99:0x0150, B:100:0x0156, B:68:0x00e7, B:101:0x0165, B:103:0x0176), top: B:119:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0128 A[Catch: Exception -> 0x0180, TryCatch #0 {Exception -> 0x0180, blocks: (B:3:0x0016, B:5:0x001b, B:7:0x0021, B:9:0x0032, B:11:0x003c, B:13:0x0040, B:70:0x00ec, B:72:0x00f8, B:74:0x00fe, B:76:0x0103, B:78:0x0109, B:80:0x010e, B:82:0x0114, B:84:0x0119, B:86:0x011f, B:87:0x0122, B:89:0x0128, B:97:0x0146, B:98:0x014d, B:104:0x017c, B:99:0x0150, B:100:0x0156, B:68:0x00e7, B:101:0x0165, B:103:0x0176), top: B:119:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0139  */
    private void e(com.igaworks.adpopcorn.cores.model.f fVar) {
        IAPLoadVideoAdEventListener iAPLoadVideoAdEventListener;
        APVideoError aPVideoError;
        IAPShowVideoAdEventListener iAPShowVideoAdEventListener;
        String string;
        String string2;
        String string3;
        int i;
        boolean z;
        j jVar;
        String string4 = "";
        try {
            c();
            if (fVar != null && fVar.d()) {
                Toast.makeText(this.a, this.n.t0, 1).show();
            } else if (fVar == null || fVar.a().length() <= 0) {
                Toast.makeText(this.a, this.n.t0, 1).show();
                if (this.t != null) {
                    aPVideoError = new APVideoError(9999, "Unknown excepton");
                    iAPShowVideoAdEventListener = this.t;
                    iAPShowVideoAdEventListener.OnShowVideoAdFailure(aPVideoError);
                }
            } else {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_VIDEO_AD", "return string = " + fVar.a(), 3);
                try {
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    z = (!jSONObject.has("Result") || jSONObject.isNull("Result")) ? false : jSONObject.getBoolean("Result");
                    try {
                        string3 = (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) ? "" : jSONObject.getString("RedirectURL");
                        try {
                            string2 = (!jSONObject.has("Auth") || jSONObject.isNull("Auth")) ? "" : jSONObject.getString("Auth");
                            try {
                                i = (!jSONObject.has("ResultCode") || jSONObject.isNull("ResultCode")) ? 0 : jSONObject.getInt("ResultCode");
                                try {
                                    string = (!jSONObject.has("VideoImpressionURL") || jSONObject.isNull("VideoImpressionURL")) ? "" : jSONObject.getString("VideoImpressionURL");
                                    try {
                                        if (jSONObject.has("MoreClickReportURL") && !jSONObject.isNull("MoreClickReportURL")) {
                                            string4 = jSONObject.getString("MoreClickReportURL");
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    string = "";
                                }
                            } catch (Exception e4) {
                                e = e4;
                                string = "";
                                i = 0;
                                e.printStackTrace();
                                if (z) {
                                    jVar = this.q.get(this.r);
                                    if (string3 != null) {
                                        jVar.j(string3);
                                    }
                                    if (string2 != null) {
                                        jVar.a(string2);
                                    }
                                    if (string != null) {
                                        jVar.n(string);
                                    }
                                    if (string4 != null) {
                                        jVar.g(string4);
                                    }
                                    a(this.a, jVar);
                                    return;
                                }
                                Toast.makeText(this.a, this.n.t0, 1).show();
                                if (this.t != null) {
                                    if (i != 980) {
                                    }
                                    aPVideoError = new APVideoError(999, "Terminated or invalid campaign");
                                    iAPShowVideoAdEventListener = this.t;
                                    iAPShowVideoAdEventListener.OnShowVideoAdFailure(aPVideoError);
                                }
                                if (this.r >= this.q.size() - 1) {
                                    this.r = 0;
                                    if (this.s != null) {
                                        this.s.OnLoadVideoAdFailure(new APVideoError(5005, APVideoError.ALL_LOADED_VIDEO_SHOWN_MESSAGE));
                                        return;
                                    }
                                    return;
                                }
                                this.r++;
                                iAPLoadVideoAdEventListener = this.s;
                                if (iAPLoadVideoAdEventListener != null) {
                                    iAPLoadVideoAdEventListener.OnLoadVideoAdSuccess();
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            string = "";
                            string2 = string;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        string = "";
                        string2 = string;
                        string3 = string2;
                    }
                } catch (Exception e7) {
                    e = e7;
                    string = "";
                    string2 = string;
                    string3 = string2;
                    i = 0;
                    z = false;
                }
                if (z) {
                    jVar = this.q.get(this.r);
                    if (string3 != null && string3.length() > 0) {
                        jVar.j(string3);
                    }
                    if (string2 != null && string2.length() > 0) {
                        jVar.a(string2);
                    }
                    if (string != null && string.length() > 0) {
                        jVar.n(string);
                    }
                    if (string4 != null && string4.length() > 0) {
                        jVar.g(string4);
                    }
                    a(this.a, jVar);
                    return;
                }
                Toast.makeText(this.a, this.n.t0, 1).show();
                if (this.t != null) {
                    if (i != 980 || i == 999) {
                        aPVideoError = new APVideoError(999, "Terminated or invalid campaign");
                        iAPShowVideoAdEventListener = this.t;
                    } else {
                        aPVideoError = i == 2000 ? new APVideoError(2000, "Already completed campaign") : new APVideoError(9999, "Unknown excepton");
                        iAPShowVideoAdEventListener = this.t;
                    }
                    iAPShowVideoAdEventListener.OnShowVideoAdFailure(aPVideoError);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            Toast.makeText(this.a, this.n.t0, 1).show();
            if (this.t != null) {
                this.t.OnShowVideoAdFailure(new APVideoError(9999, "Unknown excepton"));
            }
        }
        if (this.r >= this.q.size() - 1) {
            this.r = 0;
            if (this.s != null) {
                this.s.OnLoadVideoAdFailure(new APVideoError(5005, APVideoError.ALL_LOADED_VIDEO_SHOWN_MESSAGE));
                return;
            }
            return;
        }
        this.r++;
        iAPLoadVideoAdEventListener = this.s;
        if (iAPLoadVideoAdEventListener != null) {
            iAPLoadVideoAdEventListener.OnLoadVideoAdSuccess();
        }
    }

    private void f(com.igaworks.adpopcorn.cores.model.f fVar) {
        APPopupAdError aPPopupAdError;
        if (fVar != null) {
            try {
                if (fVar.d()) {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackLoadPopupAd timeout", 3);
                    return;
                }
            } catch (Exception unused) {
                this.w = -1;
                if (this.x != null) {
                    this.x.OnLoadPopupAdFailure(new APPopupAdError(9999, "Unknown excepton"));
                    return;
                }
                return;
            }
        }
        if (fVar == null || fVar.a().length() <= 0) {
            return;
        }
        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackLoadPopupAd return string = " + fVar.a(), 3);
        JSONObject jSONObject = new JSONObject(fVar.a());
        boolean z = jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false;
        int i = jSONObject.has("ResultCode") ? jSONObject.getInt("ResultCode") : 0;
        String string = jSONObject.has("ResultMsg") ? jSONObject.getString("ResultMsg") : "";
        if (z) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackLoadPopupAd success", 3);
            this.w = 0;
            List<com.igaworks.adpopcorn.cores.model.h> listA = com.igaworks.adpopcorn.a.f.e.a(this.a, fVar.a());
            this.v = listA;
            if (listA != null && listA.size() > 0) {
                IAPPopupAdEventListener iAPPopupAdEventListener = this.x;
                if (iAPPopupAdEventListener != null) {
                    iAPPopupAdEventListener.OnLoadPopupAdSuccess();
                }
                k();
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackLoadPopupAd success, but no Ad", 3);
            aPPopupAdError = new APPopupAdError(1000, "Can not find available campaign");
        } else {
            this.w = -1;
            if (this.x == null) {
                return;
            } else {
                aPPopupAdError = new APPopupAdError(i, string);
            }
        }
        this.x.OnLoadPopupAdFailure(aPPopupAdError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        try {
            JSONObject jSONObjectA = this.h.a(str);
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "sendPendingClientRewardRequest", 3);
            if (jSONObjectA != null) {
                if (this.o == null) {
                    this.o = new com.igaworks.adpopcorn.a.g.a(this.a);
                }
                this.o.a(15, "https://apapi.adpopcorn.com/ap/v1/sdk/media/clientpendingreward", jSONObjectA, "", this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ int g(d dVar) {
        int i = dVar.w;
        dVar.w = i + 1;
        return i;
    }

    private void g(com.igaworks.adpopcorn.cores.model.f fVar) {
        int i;
        boolean z;
        APVideoError aPVideoError;
        try {
            c();
            if (fVar != null && fVar.d()) {
                Toast.makeText(this.a, this.n.t0, 1).show();
                return;
            }
            if (fVar == null || fVar.a().length() <= 0) {
                return;
            }
            String string = "";
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_VIDEO_AD", "callbackLoadVideoAd httpString : " + fVar.a(), 3);
            boolean z2 = false;
            int i2 = 0;
            try {
                JSONObject jSONObject = new JSONObject(fVar.a());
                z = jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false;
                try {
                    i2 = jSONObject.has("ResultCode") ? jSONObject.getInt("ResultCode") : 0;
                    if (jSONObject.has("ResultMsg")) {
                        string = jSONObject.getString("ResultMsg");
                    }
                } catch (Exception unused) {
                    i = i2;
                    z2 = z;
                    z = z2;
                    i2 = i;
                }
            } catch (Exception unused2) {
                i = 0;
            }
            if (z) {
                List<j> listB = com.igaworks.adpopcorn.a.f.f.b(fVar.a());
                this.q = listB;
                if (listB != null && listB.size() > 0) {
                    IAPLoadVideoAdEventListener iAPLoadVideoAdEventListener = this.s;
                    if (iAPLoadVideoAdEventListener != null) {
                        iAPLoadVideoAdEventListener.OnLoadVideoAdSuccess();
                        return;
                    }
                    return;
                }
                if (this.s == null) {
                    return;
                } else {
                    aPVideoError = new APVideoError(i2, string);
                }
            } else if (this.s == null) {
                return;
            } else {
                aPVideoError = new APVideoError(i2, string);
            }
            this.s.OnLoadVideoAdFailure(aPVideoError);
        } catch (Exception unused3) {
            if (this.s != null) {
                this.s.OnLoadVideoAdFailure(new APVideoError(9999, "Unknown excepton"));
            }
        }
    }

    private void i(com.igaworks.adpopcorn.cores.model.f fVar) {
        Dialog dialog;
        DialogInterface.OnDismissListener fVar2;
        try {
            c();
            if (fVar != null && fVar.a().length() > 0) {
                if (fVar.d()) {
                    IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener = this.A;
                    if (iAPOpenCampaignPageEventListener != null) {
                        iAPOpenCampaignPageEventListener.OnOpenFailure();
                        return;
                    }
                    return;
                }
                if (fVar == null || fVar.a().length() <= 0) {
                    IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener2 = this.A;
                    if (iAPOpenCampaignPageEventListener2 != null) {
                        iAPOpenCampaignPageEventListener2.OnOpenFailure();
                        return;
                    }
                    return;
                }
                try {
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackOpenCampaignPage result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    if (jSONObject.has("IsTest")) {
                        E = jSONObject.getBoolean("IsTest");
                    }
                    if (!jSONObject.getBoolean("Result") || jSONObject.getString("Campaign") == null) {
                        IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener3 = this.A;
                        if (iAPOpenCampaignPageEventListener3 != null) {
                            iAPOpenCampaignPageEventListener3.OnOpenFailure();
                            return;
                        }
                        return;
                    }
                    this.B = com.igaworks.adpopcorn.a.f.d.b(this.a, jSONObject.getString("Campaign"));
                    com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackOpenCampaignPage success", 3);
                    if (c(this.a)) {
                        Context context = this.a;
                        com.igaworks.adpopcorn.activity.b.a aVar = new com.igaworks.adpopcorn.activity.b.a(context, com.igaworks.adpopcorn.activity.b.d.a(context), this.B, this.n, this.D, true, false);
                        this.C = aVar;
                        aVar.show();
                        dialog = this.C;
                        fVar2 = new e();
                    } else {
                        Context context2 = this.a;
                        com.igaworks.adpopcorn.activity.b.a aVar2 = new com.igaworks.adpopcorn.activity.b.a(context2, com.igaworks.adpopcorn.activity.b.d.a(context2), this.B, this.n, this.D, false, false);
                        this.C = aVar2;
                        aVar2.show();
                        dialog = this.C;
                        fVar2 = new f();
                    }
                    dialog.setOnDismissListener(fVar2);
                    IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener4 = this.A;
                    if (iAPOpenCampaignPageEventListener4 != null) {
                        iAPOpenCampaignPageEventListener4.OnOpenSuccess();
                        return;
                    }
                    return;
                } catch (JSONException unused) {
                    IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener5 = this.A;
                    if (iAPOpenCampaignPageEventListener5 != null) {
                        iAPOpenCampaignPageEventListener5.OnOpenFailure();
                        return;
                    }
                    return;
                }
            }
            IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener6 = this.A;
            if (iAPOpenCampaignPageEventListener6 != null) {
                iAPOpenCampaignPageEventListener6.OnOpenFailure();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener7 = this.A;
            if (iAPOpenCampaignPageEventListener7 != null) {
                iAPOpenCampaignPageEventListener7.OnOpenFailure();
            }
        }
    }

    private void j(com.igaworks.adpopcorn.cores.model.f fVar) {
        if (fVar != null) {
            try {
                if (fVar.a().length() > 0) {
                    if (fVar.d()) {
                        IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener = this.z;
                        if (iAdPopcornParticipateEventListener != null) {
                            iAdPopcornParticipateEventListener.OnParticipateResult(false, 200, ApCustomRewardCPMError.EXCEPTION_MESSAGE, null);
                            return;
                        }
                        return;
                    }
                    if (fVar == null || fVar.a().length() <= 0) {
                        IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener2 = this.z;
                        if (iAdPopcornParticipateEventListener2 != null) {
                            iAdPopcornParticipateEventListener2.OnParticipateResult(false, 200, ApCustomRewardCPMError.EXCEPTION_MESSAGE, null);
                            return;
                        }
                        return;
                    }
                    try {
                        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackTryParticipate result = " + fVar.a(), 3);
                        JSONObject jSONObject = new JSONObject(fVar.a());
                        boolean z = jSONObject.getBoolean("Result");
                        int i = jSONObject.getInt("ResultCode");
                        String string = jSONObject.getString("ResultMsg");
                        String string2 = (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) ? "" : jSONObject.getString("RedirectURL");
                        if (z) {
                            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "callbackTryParticipate success, landingURL = " + string2, 3);
                            IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener3 = this.z;
                            if (iAdPopcornParticipateEventListener3 != null) {
                                iAdPopcornParticipateEventListener3.OnParticipateResult(true, 1, ADXLogUtil.EVENT_LOAD_SUCCESS, string2);
                                return;
                            }
                            return;
                        }
                        c();
                        IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener4 = this.z;
                        if (iAdPopcornParticipateEventListener4 != null) {
                            iAdPopcornParticipateEventListener4.OnParticipateResult(false, i, string, string2);
                            return;
                        }
                        return;
                    } catch (JSONException unused) {
                        IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener5 = this.z;
                        if (iAdPopcornParticipateEventListener5 != null) {
                            iAdPopcornParticipateEventListener5.OnParticipateResult(false, 200, ApCustomRewardCPMError.EXCEPTION_MESSAGE, null);
                            return;
                        }
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener6 = this.z;
                if (iAdPopcornParticipateEventListener6 != null) {
                    iAdPopcornParticipateEventListener6.OnParticipateResult(false, 200, ApCustomRewardCPMError.EXCEPTION_MESSAGE, null);
                    return;
                }
                return;
            }
        }
        IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener7 = this.z;
        if (iAdPopcornParticipateEventListener7 != null) {
            iAdPopcornParticipateEventListener7.OnParticipateResult(false, 200, ApCustomRewardCPMError.EXCEPTION_MESSAGE, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Context context;
        String strE;
        Configuration configuration;
        try {
            Activity activity = this.f1486b;
            if ((activity == null || (configuration = activity.getResources().getConfiguration()) == null || configuration.orientation != 2) ? false : true) {
                context = this.a;
                strE = this.v.get(this.w).d();
            } else {
                context = this.a;
                strE = this.v.get(this.w).e();
            }
            com.igaworks.adpopcorn.cores.common.e.a(context, strE, 0, 0);
        } catch (Exception unused) {
        }
    }

    protected List<APClientRewardItem> a(String str) {
        com.igaworks.adpopcorn.a.f.c cVar = new com.igaworks.adpopcorn.a.f.c(this.a, str);
        List<APClientRewardItem> listA = cVar.a();
        this.j.a(cVar.d());
        this.j.b(cVar.b());
        this.j.a(cVar.e());
        this.j.a(cVar.c());
        this.j.c(cVar.f());
        this.j.d(cVar.g());
        return listA;
    }

    public void a() {
        IAPShowVideoAdEventListener iAPShowVideoAdEventListener = this.t;
        if (iAPShowVideoAdEventListener != null) {
            iAPShowVideoAdEventListener.OnVideoAdClose();
        }
    }

    public void a(int i) {
        try {
            com.igaworks.adpopcorn.a.b.a().b(this.a, "adpopcorn_sdk_flag", "exceptionPermissionList", i);
        } catch (Exception unused) {
        }
    }

    public void a(Activity activity) {
        Configuration configuration;
        this.a = activity;
        this.f1486b = activity;
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        this.n = gVarA;
        gVarA.d();
        com.igaworks.adpopcorn.cores.common.d.a(activity);
        Activity activity2 = this.f1486b;
        if (activity2 == null || (configuration = activity2.getResources().getConfiguration()) == null) {
            return;
        }
        int i = configuration.orientation;
    }

    public void a(Activity activity, String str) {
        try {
            com.igaworks.adpopcorn.cores.common.d.a(activity);
            com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
            gVarA.d();
            int iA = com.igaworks.adpopcorn.activity.b.d.a(activity);
            boolean z = false;
            boolean z2 = iA == 16973841;
            Configuration configuration = activity.getResources().getConfiguration();
            if (configuration != null && configuration.orientation == 2) {
                z = true;
            }
            new com.igaworks.adpopcorn.activity.b.c(activity, iA, z, gVarA, z2, str).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, int i, String[] strArr, int[] iArr) {
    }

    public void a(Context context, IAPLoadVideoAdEventListener iAPLoadVideoAdEventListener) {
        try {
            this.a = context;
            this.s = iAPLoadVideoAdEventListener;
            this.r = 0;
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(context);
            }
            this.o.a(17, "https://apapi.adpopcorn.com/ap/v1/sdk/video/videolist", this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, IAPPopupAdEventListener iAPPopupAdEventListener) {
        try {
            this.a = context;
            this.x = iAPPopupAdEventListener;
            List<com.igaworks.adpopcorn.cores.model.h> list = this.v;
            if (list != null) {
                list.clear();
            }
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(context);
            }
            this.o.a(22, "https://apapi.adpopcorn.com/ap/v1/sdk/media/popup", this);
            b("load_popup_ad", "");
        } catch (Exception unused) {
            if (iAPPopupAdEventListener != null) {
                iAPPopupAdEventListener.OnLoadPopupAdFailure(new APPopupAdError(9999, "Unknown excepton"));
            }
        }
    }

    public void a(Context context, IAPShowVideoAdEventListener iAPShowVideoAdEventListener) {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            if (this.r == -1 && this.s != null) {
                this.s.OnLoadVideoAdFailure(new APVideoError(5003, APVideoError.NO_VIDEO_LOADED_MESSAGE));
                return;
            }
            this.a = context;
            this.t = iAPShowVideoAdEventListener;
            com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
            this.n = gVarA;
            gVarA.d();
            List<j> list = this.q;
            if (list == null || list.size() <= 0) {
                return;
            }
            j jVar = this.q.get(this.r);
            if (jVar == null || jVar.b() == null || jVar.b().length() <= 0) {
                a(context, jVar);
                return;
            }
            l();
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(context);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", jVar.b());
            jSONObject.put("network", com.igaworks.adpopcorn.cores.common.c.b(context));
            if (E) {
                aVar = this.o;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/video/joinvideocampaign";
            } else {
                aVar = this.o;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/video/joinvideocampaign";
            }
            aVar.a(18, str, jSONObject, this);
        } catch (Exception e2) {
            e2.printStackTrace();
            c();
            if (iAPShowVideoAdEventListener != null) {
                iAPShowVideoAdEventListener.OnShowVideoAdFailure(new APVideoError(9999, "Unknown excepton"));
            }
        }
    }

    public void a(Context context, String str, IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener) {
        try {
            this.a = context;
            this.A = iAPOpenCampaignPageEventListener;
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(context);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("campaign_key", str);
            l();
            this.o.a(25, "https://apapi.adpopcorn.com/ap/v1/sdk/media/opencampaignpage", jSONObject, this);
        } catch (Exception unused) {
            IAPOpenCampaignPageEventListener iAPOpenCampaignPageEventListener2 = this.A;
            if (iAPOpenCampaignPageEventListener2 != null) {
                iAPOpenCampaignPageEventListener2.OnOpenFailure();
            }
        }
    }

    public void a(Context context, String str, boolean z) {
        if (!z) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(context, "ADPOPCORN", "AdPopcorn >> setUserId : " + str, 2);
            } catch (Exception unused) {
                return;
            }
        }
        com.igaworks.adpopcorn.a.b.a().b(context, "adpopcorn_parameter", "adpopcorn_sdk_usn", str);
        h(str);
    }

    public void a(Context context, boolean z) {
        com.igaworks.adpopcorn.a.b.a().b(context, "adpopcorn_parameter", "check_user_agreement", z);
    }

    public void a(IAPClientRewardCallbackListener iAPClientRewardCallbackListener) {
        this.e = iAPClientRewardCallbackListener;
    }

    public void a(IAPRewardInfoCallbackListener iAPRewardInfoCallbackListener) {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        this.f = iAPRewardInfoCallbackListener;
        if (this.o == null) {
            this.o = new com.igaworks.adpopcorn.a.g.a(this.a);
        }
        if (E) {
            aVar = this.o;
            str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/offerwallsummary";
        } else {
            aVar = this.o;
            str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/offerwallsummary";
        }
        aVar.a(21, str, this);
    }

    public void a(IAdPOPcornEventListener iAdPOPcornEventListener) {
        this.d = iAdPOPcornEventListener;
    }

    public void a(String str, IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener) {
        try {
            this.z = iAdPopcornParticipateEventListener;
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("campaign_key", str);
            this.o.a(24, "https://apapi.adpopcorn.com/ap/v1/sdk/media/tryparticipatecampaign", jSONObject, this);
        } catch (Exception unused) {
            IAdPopcornParticipateEventListener iAdPopcornParticipateEventListener2 = this.z;
            if (iAdPopcornParticipateEventListener2 != null) {
                iAdPopcornParticipateEventListener2.OnParticipateResult(false, 200, ApCustomRewardCPMError.EXCEPTION_MESSAGE, null);
            }
        }
    }

    public void a(String str, IOnestoreEventListener iOnestoreEventListener) {
        try {
            if (this.g == null) {
                this.g = new HashMap<>();
            }
            this.g.put(str, iOnestoreEventListener);
        } catch (Exception unused) {
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        HashMap<String, IOnestoreEventListener> map;
        IOnestoreEventListener iOnestoreEventListener;
        if (str4 == null) {
            str4 = e().b();
        }
        if (str4 == null || (map = this.g) == null || (iOnestoreEventListener = map.get(str4)) == null) {
            return;
        }
        iOnestoreEventListener.OnParticipatedSuccess(str, str2, str3);
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void b(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        Boolean bool = Boolean.FALSE;
        String str = applicationInfo.metaData.containsKey("igaworks_reward_server_type") ? (String) applicationInfo.metaData.get("igaworks_reward_server_type") : "";
        if (str != null && str.equals("client")) {
            bool = Boolean.TRUE;
        }
        if (bool == null || !bool.booleanValue() || a(context).h()) {
            return;
        }
        com.igaworks.adpopcorn.cores.common.h.a(context, "Environment setting fail", new Throwable().getStackTrace(), "you should set IAdPOPcornRewardItemCallbackListener. Because 'igaworks_reward_server_type' property is set 'client' in your 'AndroidManifest.xml'", 0);
        com.igaworks.adpopcorn.cores.common.h.a("you should set IAdPOPcornRewardItemCallbackListener. Because 'igaworks_reward_server_type' property is set 'client' in your 'AndroidManifest.xml'", context);
        throw new RuntimeException("you should set IAdPOPcornRewardItemCallbackListener. Because 'igaworks_reward_server_type' property is set 'client' in your 'AndroidManifest.xml'");
    }

    public void b(String str) {
        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "didGiveRewardItem", 3);
        try {
            if (this.c.j()) {
                d(str, this.c.a());
            } else {
                new Thread(new a(str)).start();
            }
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "didGiveRewardItem Exception - \n " + e2.getMessage(), 0);
            e2.printStackTrace();
        }
    }

    public void b(String str, String str2) {
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "collectAdpopcornAction : " + str + ", params : " + str2, 2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
            if (str2 != null && str2.length() > 0) {
                jSONObject.put("additional_data", str2);
            }
            jSONObject.put("action_timestamp", Calendar.getInstance().getTimeInMillis());
            if (!str.equals("open_offerwall")) {
                String strA = com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_action", "collected_action_list", "");
                JSONArray jSONArray = (strA == null || strA.length() <= 0) ? new JSONArray() : new JSONArray(strA);
                jSONArray.put(jSONObject);
                com.igaworks.adpopcorn.a.b.a().b(this.a, "adpopcorn_action", "collected_action_list", jSONArray.toString());
                return;
            }
            d();
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            this.o.a(20, E ? "https://apapi-staging.adpopcorn.com/ap/v1/sdk/behavior/action" : "https://apapi.adpopcorn.com/ap/v1/sdk/behavior/action", "action", jSONArray2, this);
        } catch (Exception unused) {
        }
    }

    public void b(boolean z) {
        this.m = z;
    }

    public void c(com.igaworks.adpopcorn.cores.model.f fVar) {
        if (fVar != null) {
            try {
                if (fVar.a() != null) {
                    List<APClientRewardItem> listA = a(fVar.a());
                    if (listA == null) {
                        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "rewardItem null", 0);
                    }
                    if (listA == null || listA.size() <= 0) {
                        return;
                    }
                    onGetRewardInfo(this.j.e(), this.j.c(), (APClientRewardItem[]) listA.toArray(new APClientRewardItem[0]));
                    return;
                }
            } catch (Exception e2) {
                com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "callbackGetPendingRewardItems = \n " + e2.getMessage(), 0);
                e2.printStackTrace();
                return;
            }
        }
        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "callbackGetPendingRewardItems response Null", 0);
    }

    public void c(String str) {
        HashMap<String, IOnestoreEventListener> map;
        IOnestoreEventListener iOnestoreEventListener;
        if (this.d != null) {
            com.igaworks.adpopcorn.cores.common.h.b(this.a, "AP_OFFER", "called onClosedOfferWallPage", 3);
            this.d.OnClosedOfferWallPage();
        }
        if (str == null || (map = this.g) == null || (iOnestoreEventListener = map.get(str)) == null) {
            return;
        }
        iOnestoreEventListener.OnClosedOfferWallPage();
    }

    public void c(String str, String str2) {
        com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "didGiveRewardItemWithRewardKey", 3);
        try {
            if (this.c.j()) {
                a(str, str2, this.c.a());
            } else {
                new Thread(new b(str, str2)).start();
            }
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "didGiveRewardItemWithRewardKey Exception - \n " + e2.getMessage(), 0);
            e2.printStackTrace();
        }
    }

    public void c(boolean z) {
        try {
            if (this.k && h()) {
                if (this.c.j()) {
                    f(this.c.a());
                } else {
                    new Thread(new c()).start();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean c(Activity activity) {
        try {
            com.igaworks.adpopcorn.cores.common.h.b(this.a, "AP_OFFER", "setScreenConfiguration : " + activity.getRequestedOrientation(), 3);
            if (activity.getRequestedOrientation() != -1) {
                int i = activity.getResources().getConfiguration().orientation;
                return i != 1 && i == 2;
            }
        } catch (Exception unused) {
        }
        boolean zA = com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "allScreenOrientation", false);
        Configuration configuration = activity.getResources().getConfiguration();
        com.igaworks.adpopcorn.cores.common.h.b(this.a, "AP_OFFER", "isSupportAllScreenOrientation : " + zA + ", config.orientation : " + configuration.orientation, 3);
        if (!zA) {
            int i2 = configuration.orientation;
            if (i2 == 1) {
                if (!com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "portrait_sensor", false) || Build.VERSION.SDK_INT < 9) {
                    activity.setRequestedOrientation(1);
                } else {
                    activity.setRequestedOrientation(7);
                }
                return false;
            }
            if (i2 == 2) {
                if (!com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "landscape_sensor", true) || Build.VERSION.SDK_INT < 9) {
                    activity.setRequestedOrientation(0);
                } else {
                    activity.setRequestedOrientation(6);
                }
                return true;
            }
        } else if (configuration.orientation == 2) {
            return true;
        }
        return false;
    }

    public void d() {
        try {
            String strA = com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_action", "collected_action_list", "");
            if (strA == null || strA.length() <= 0) {
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN", "flushAdPopcornAction activity exists", 2);
            JSONArray jSONArray = new JSONArray(strA);
            if (this.o == null) {
                this.o = new com.igaworks.adpopcorn.a.g.a(this.a);
            }
            this.o.a(20, E ? "https://apapi-staging.adpopcorn.com/ap/v1/sdk/behavior/action" : "https://apapi.adpopcorn.com/ap/v1/sdk/behavior/action", "action", jSONArray, this);
        } catch (Exception unused) {
        }
    }

    public void d(Activity activity) {
        com.igaworks.adpopcorn.cores.model.h hVar;
        Configuration configuration;
        try {
            com.igaworks.adpopcorn.cores.common.d.a(activity);
            if (this.w == -1 && this.x != null) {
                this.x.OnShowPopupAdFailure(new APPopupAdError(5003, APPopupAdError.NO_POPUP_AD_LOADED_MESSAGE));
                return;
            }
            this.a = activity;
            this.f1486b = activity;
            List<com.igaworks.adpopcorn.cores.model.h> list = this.v;
            if (list == null || list.size() <= 0 || (hVar = this.v.get(this.w)) == null) {
                return;
            }
            boolean z = false;
            Activity activity2 = this.f1486b;
            if (activity2 != null && (configuration = activity2.getResources().getConfiguration()) != null && configuration.orientation == 2) {
                z = true;
            }
            com.igaworks.adpopcorn.activity.b.h hVar2 = new com.igaworks.adpopcorn.activity.b.h(this.f1486b, com.igaworks.adpopcorn.activity.b.d.a(this.a), z, hVar);
            hVar2.setOnDismissListener(new DialogInterfaceOnDismissListenerC0397d());
            hVar2.show();
            b("impression_popup_ad", hVar.b());
            IAPPopupAdEventListener iAPPopupAdEventListener = this.x;
            if (iAPPopupAdEventListener != null) {
                iAPPopupAdEventListener.OnShowPopupAdSuccess();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.x != null) {
                this.x.OnShowPopupAdFailure(new APPopupAdError(9999, "Unknown excepton"));
            }
        }
    }

    public void d(Context context) {
        try {
            String strA = com.igaworks.adpopcorn.a.b.a().a(context, "adpopcorn_parameter", "adpopcorn_sdk_market", "__UNDEFINED__MARKET__");
            if (strA.equals("__UNDEFINED__MARKET__")) {
                return;
            }
            g(strA);
        } catch (Exception unused) {
        }
    }

    public com.igaworks.adpopcorn.a.c e() {
        return this.c;
    }

    public String e(Context context) {
        try {
            String strA = com.igaworks.adpopcorn.a.b.a().a(context, "adpopcorn_parameter", "adpopcorn_sdk_usn", "__UNDEFINED__USN__");
            if (!strA.equals("__UNDEFINED__USN__")) {
                com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", "restoreUsn : " + strA, 3);
                a(context, strA, true);
                return strA;
            }
        } catch (Exception unused) {
        }
        return this.u;
    }

    public void e(String str) {
        try {
            HashMap<String, IOnestoreEventListener> map = this.g;
            if (map != null) {
                map.remove(str);
                if (this.g.isEmpty()) {
                    this.g = null;
                }
            }
        } catch (Exception unused) {
        }
    }

    public void e(String str, String str2) {
        Context context;
        StringBuilder sbAppend;
        String strB;
        try {
            com.igaworks.adpopcorn.a.c cVar = this.c;
            if (cVar != null) {
                cVar.a(str, str2);
            }
            if (str.equals("igaworks_app_key") || str.equals("adpopcorn_app_key")) {
                this.h.a(this.c.b(), this.c.g(), this.c.c());
                this.i.a(this.c.b(), this.c.c(), this.a);
                context = this.a;
                sbAppend = new StringBuilder().append("change adpopcorn sdk app key : ");
                strB = this.c.b();
            } else {
                if (!str.equals("igaworks_hash_key") && !str.equals("adpopcorn_hash_key")) {
                    return;
                }
                this.h.a(this.c.b(), this.c.g(), this.c.c());
                this.i.a(this.c.b(), this.c.c(), this.a);
                context = this.a;
                sbAppend = new StringBuilder().append("change adpopcorn sdk hash key : ");
                strB = this.c.c();
            }
            com.igaworks.adpopcorn.cores.common.h.b(context, "AP_OFFER", sbAppend.append(strB).toString(), 3);
        } catch (Exception unused) {
        }
    }

    public boolean f() {
        return this.l;
    }

    public void g(String str) {
        com.igaworks.adpopcorn.a.c cVar = this.c;
        if (cVar != null) {
            cVar.c(str);
        }
    }

    public boolean g() {
        return this.m;
    }

    public void h(com.igaworks.adpopcorn.cores.model.f fVar) {
        try {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "callbackOnRewardCompleted", 3);
            if (fVar == null || fVar.a() == null) {
                return;
            }
            com.igaworks.adpopcorn.a.f.b bVar = new com.igaworks.adpopcorn.a.f.b(this.a, fVar.a());
            bVar.a();
            boolean zC = bVar.c();
            int iD = bVar.d();
            String strB = bVar.b();
            String strB2 = fVar.b();
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "callback On Reward Completed " + zC + RemoteSettings.FORWARD_SLASH_STRING + strB + RemoteSettings.FORWARD_SLASH_STRING + iD + RemoteSettings.FORWARD_SLASH_STRING + strB2, 3);
            onDidGiveRewardItemResult(zC, strB, iD, strB2);
        } catch (Exception e2) {
            com.igaworks.adpopcorn.cores.common.h.a(this.a, "ADPOPCORN_CLIENT_REWARD", "callbackOnRewardCompleted Exception - \n" + e2.getMessage(), 0);
            e2.printStackTrace();
        }
    }

    public void h(String str) {
        com.igaworks.adpopcorn.a.c cVar;
        try {
            com.igaworks.adpopcorn.a.c cVar2 = this.c;
            if (cVar2 != null) {
                cVar2.e(str);
            }
            com.igaworks.adpopcorn.a.h.b.b bVar = this.h;
            if (bVar == null || (cVar = this.c) == null) {
                return;
            }
            bVar.a(cVar.b(), this.c.g(), this.c.c());
        } catch (Exception unused) {
        }
    }

    public boolean h() {
        return this.e != null;
    }

    public void i() {
        if (this.d != null) {
            com.igaworks.adpopcorn.cores.common.h.b(this.a, "AP_OFFER", "called OnAgreePrivacy", 3);
            this.d.OnAgreePrivacy();
        }
    }

    public void j() {
        if (this.d != null) {
            com.igaworks.adpopcorn.cores.common.h.b(this.a, "AP_OFFER", "called onDisagreePrivacy", 3);
            this.d.OnDisagreePrivacy();
        }
    }

    public void l() {
        try {
            if (((Activity) this.a).isFinishing()) {
                return;
            }
            Context context = this.a;
            com.igaworks.adpopcorn.activity.b.d.c cVar = new com.igaworks.adpopcorn.activity.b.d.c(context, com.igaworks.adpopcorn.activity.b.d.a(context));
            this.p = cVar;
            cVar.setCancelable(false);
            this.p.show();
        } catch (Exception unused) {
        }
    }

    @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
    public void onDidGiveRewardItemResult(boolean z, String str, int i, String str2) {
        IAPClientRewardCallbackListener iAPClientRewardCallbackListener = this.e;
        if (iAPClientRewardCallbackListener != null) {
            iAPClientRewardCallbackListener.onDidGiveRewardItemResult(z, str, i, str2);
        }
    }

    @Override // com.igaworks.adpopcorn.interfaces.IAPClientRewardCallbackListener
    public void onGetRewardInfo(boolean z, String str, APClientRewardItem[] aPClientRewardItemArr) {
        IAPClientRewardCallbackListener iAPClientRewardCallbackListener = this.e;
        if (iAPClientRewardCallbackListener != null) {
            iAPClientRewardCallbackListener.onGetRewardInfo(z, str, aPClientRewardItemArr);
        }
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i, com.igaworks.adpopcorn.cores.model.f fVar) {
        if (i == 1) {
            d(fVar);
            return;
        }
        if (i == 24) {
            j(fVar);
            return;
        }
        if (i == 25) {
            i(fVar);
            return;
        }
        switch (i) {
            case 15:
                c(fVar);
                break;
            case 16:
                h(fVar);
                break;
            case 17:
                g(fVar);
                break;
            case 18:
                e(fVar);
                break;
            default:
                switch (i) {
                    case 20:
                        a(fVar);
                        break;
                    case 21:
                        b(fVar);
                        break;
                    case 22:
                        f(fVar);
                        break;
                }
                break;
        }
    }
}

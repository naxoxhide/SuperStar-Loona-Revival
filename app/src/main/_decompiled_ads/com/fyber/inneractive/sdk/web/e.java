package com.fyber.inneractive.sdk.web;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.ScriptInjector;

/* JADX INFO: loaded from: classes2.dex */
public class e extends AsyncTask<Void, Void, String> {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1360b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ d e;

    public e(d dVar, String str, String str2, String str3, String str4) {
        this.e = dVar;
        this.a = str;
        this.f1360b = str2;
        this.c = str3;
        this.d = str4;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0078  */
    /* JADX WARN: Code duplicated, block: B:18:0x0083  */
    /* JADX WARN: Code duplicated, block: B:21:0x009b  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:40:0x010b  */
    /* JADX WARN: Code duplicated, block: B:43:0x011c  */
    /* JADX WARN: Code duplicated, block: B:48:0x012a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0135  */
    /* JADX WARN: Code duplicated, block: B:53:0x0142  */
    /* JADX WARN: Code duplicated, block: B:56:0x014f  */
    /* JADX WARN: Code duplicated, block: B:58:0x015e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0167  */
    /* JADX WARN: Code duplicated, block: B:62:0x016e  */
    @Override // android.os.AsyncTask
    public String doInBackground(Void[] voidArr) {
        boolean zA;
        String strC;
        com.fyber.inneractive.sdk.response.e eVarD;
        boolean z;
        String string;
        com.fyber.inneractive.sdk.measurement.b bVar;
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        d dVar = this.e;
        String str = this.a;
        String str2 = this.f1360b;
        String str3 = this.c;
        c0 c0Var = (c0) dVar;
        c0Var.getClass();
        StringBuilder sb2 = new StringBuilder();
        String string2 = null;
        if (TextUtils.isEmpty(str)) {
            IAlog.a("loadHtml called with an empty HTML!", new Object[0]);
        } else {
            sb2.append("<html><head>");
            sb2.append("<link rel=\"icon\" href=\"data:,\">");
            if (c0Var.E) {
                String strC2 = com.fyber.inneractive.sdk.util.l.c("ia_js_load_monitor.txt");
                if (!TextUtils.isEmpty(strC2)) {
                    sb2.append(strC2);
                    sb2.append("<script> window.iaPreCachedAd = true; </script>");
                    IAConfigManager iAConfigManager = IAConfigManager.M;
                    zA = iAConfigManager.u.f886b.a("use_js_inline", false);
                    if (zA || iAConfigManager.G.f849b == null) {
                        sb2.append("<script src=\"https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js\"></script>");
                    } else {
                        sb2.append("<script type=\"text/javascript\">").append(iAConfigManager.G.f849b).append("</script>");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        sb2.append(str2);
                    }
                    sb2.append("<script>var prevWindowOnError = window.onerror; window.onerror = function(err) {if (typeof prevWindowOnError === 'function') {prevWindowOnError.apply();} console.log('WINDOW.ONERROR Javascript Error: ' + err);};</script>");
                    sb2.append("</head>");
                    sb2.append("<style>body{text-align:center !important;margin:0;padding:0;}");
                    if (!TextUtils.isEmpty(str3)) {
                        sb2.append(str3);
                    }
                    sb2.append("</style>");
                    sb2.append("<body id=\"iaBody\">");
                    if (c0Var.A && c0Var.p()) {
                        if (zA || iAConfigManager.G.c == null) {
                            sb2.append("<link rel=\"stylesheet\" href=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css\">");
                        } else {
                            sb2.append("<style type=\"text/css\">").append(iAConfigManager.G.c).append("</style>");
                        }
                        if (zA || iAConfigManager.G.d == null) {
                            sb2.append("<script src=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js\"></script>");
                        } else {
                            sb2.append("<script type=\"text/javascript\">").append(iAConfigManager.G.d).append("</script>");
                        }
                    }
                    strC = com.fyber.inneractive.sdk.util.l.c("ia_mraid_bridge.txt");
                    if (!TextUtils.isEmpty(strC)) {
                        sb2.append("<div id='iaScriptBr' style='display:none;'>");
                        sb2.append(strC);
                        sb2.append("</div>");
                        if (IAlog.a >= 2) {
                            sb2.append("<script type=\"text/javascript\">window.mraidbridge.loggingEnabled = true;</script>");
                        }
                    }
                    sb2.append(str);
                    sb2.append("</body></html>");
                    if (c0Var.H != null) {
                        eVarD = c0Var.s.d();
                        if (eVarD == null && eVarD.H) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.fyber.inneractive.sdk.measurement.a aVar = c0Var.H;
                        string = sb2.toString();
                        bVar = (com.fyber.inneractive.sdk.measurement.b) aVar;
                        if (z) {
                            sb = new StringBuilder();
                            if (!TextUtils.isEmpty(bVar.c)) {
                                sb.append(bVar.c);
                            }
                            if (!TextUtils.isEmpty(bVar.d)) {
                                sb.append(bVar.d);
                            }
                            string2 = ScriptInjector.injectScriptContentIntoHtml(sb.toString(), string);
                        } else {
                            string2 = string;
                        }
                        if (!TextUtils.isEmpty(bVar.f946b)) {
                            string2 = ScriptInjector.injectScriptContentIntoHtml(bVar.f946b, string2);
                        }
                    } else {
                        string2 = sb2.toString();
                    }
                }
            } else {
                sb2.append("<script> window.iaPreCachedAd = true; </script>");
                IAConfigManager iAConfigManager2 = IAConfigManager.M;
                zA = iAConfigManager2.u.f886b.a("use_js_inline", false);
                if (zA) {
                    sb2.append("<script src=\"https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js\"></script>");
                } else {
                    sb2.append("<script src=\"https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js\"></script>");
                }
                if (!TextUtils.isEmpty(str2)) {
                    sb2.append(str2);
                }
                sb2.append("<script>var prevWindowOnError = window.onerror; window.onerror = function(err) {if (typeof prevWindowOnError === 'function') {prevWindowOnError.apply();} console.log('WINDOW.ONERROR Javascript Error: ' + err);};</script>");
                sb2.append("</head>");
                sb2.append("<style>body{text-align:center !important;margin:0;padding:0;}");
                if (!TextUtils.isEmpty(str3)) {
                    sb2.append(str3);
                }
                sb2.append("</style>");
                sb2.append("<body id=\"iaBody\">");
                if (c0Var.A) {
                    if (zA) {
                        sb2.append("<link rel=\"stylesheet\" href=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css\">");
                    } else {
                        sb2.append("<link rel=\"stylesheet\" href=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css\">");
                    }
                    if (zA) {
                        sb2.append("<script src=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js\"></script>");
                    } else {
                        sb2.append("<script src=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js\"></script>");
                    }
                }
                strC = com.fyber.inneractive.sdk.util.l.c("ia_mraid_bridge.txt");
                if (!TextUtils.isEmpty(strC)) {
                    sb2.append("<div id='iaScriptBr' style='display:none;'>");
                    sb2.append(strC);
                    sb2.append("</div>");
                    if (IAlog.a >= 2) {
                        sb2.append("<script type=\"text/javascript\">window.mraidbridge.loggingEnabled = true;</script>");
                    }
                }
                sb2.append(str);
                sb2.append("</body></html>");
                if (c0Var.H != null) {
                    eVarD = c0Var.s.d();
                    if (eVarD == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    com.fyber.inneractive.sdk.measurement.a aVar2 = c0Var.H;
                    string = sb2.toString();
                    bVar = (com.fyber.inneractive.sdk.measurement.b) aVar2;
                    if (z) {
                        sb = new StringBuilder();
                        if (!TextUtils.isEmpty(bVar.c)) {
                            sb.append(bVar.c);
                        }
                        if (!TextUtils.isEmpty(bVar.d)) {
                            sb.append(bVar.d);
                        }
                        string2 = ScriptInjector.injectScriptContentIntoHtml(sb.toString(), string);
                    } else {
                        string2 = string;
                    }
                    if (!TextUtils.isEmpty(bVar.f946b)) {
                        string2 = ScriptInjector.injectScriptContentIntoHtml(bVar.f946b, string2);
                    }
                } else {
                    string2 = sb2.toString();
                }
            }
        }
        d dVar2 = this.e;
        dVar2.getClass();
        IAlog.a("%sbuild html string took %d msec", IAlog.a(dVar2), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        return string2;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        String str2 = str;
        String str3 = com.fyber.inneractive.sdk.util.p.a() ? "http://" : "https://";
        if (TextUtils.isEmpty(str2) || isCancelled()) {
            if (isCancelled()) {
                return;
            }
            d dVar = this.e;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.EMPTY_FINAL_HTML);
            d.InterfaceC0308d interfaceC0308d = dVar.f;
            if (interfaceC0308d != null) {
                interfaceC0308d.a(dVar, inneractiveInfrastructureError);
            }
            dVar.b(true);
            return;
        }
        this.e.o = null;
        if (TextUtils.isEmpty(this.d)) {
            this.e.p = str3 + "wv.inner-active.mobi/";
        } else {
            this.e.p = str3 + this.d;
        }
        d dVar2 = this.e;
        g gVar = dVar2.f1358b;
        if (gVar != null) {
            gVar.loadDataWithBaseURL(dVar2.p, str2, "text/html", "utf-8", null);
            this.e.q = str2;
            return;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.COULD_NOT_LOAD_TO_WEBVIEW);
        d.InterfaceC0308d interfaceC0308d2 = dVar2.f;
        if (interfaceC0308d2 != null) {
            interfaceC0308d2.a(dVar2, inneractiveInfrastructureError2);
        }
        dVar2.b(true);
    }
}

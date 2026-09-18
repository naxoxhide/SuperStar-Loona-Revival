package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.x;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f859b;

    public h(String str, boolean z) {
        this.a = str;
        this.f859b = z;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public boolean a(Uri uri, l lVar) {
        return "fybernativebrowser".equalsIgnoreCase(uri.getScheme()) || "fybernativebrowser".equalsIgnoreCase(this.a) || this.f859b;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008d A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:7:0x0014, B:10:0x002d, B:12:0x0033, B:17:0x003e, B:19:0x0042, B:20:0x0051, B:29:0x008d, B:30:0x0095, B:27:0x0083, B:22:0x0060, B:24:0x0079, B:25:0x007e, B:8:0x001d), top: B:41:0x0014, inners: #0, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0095 A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #1 {all -> 0x00a4, blocks: (B:7:0x0014, B:10:0x002d, B:12:0x0033, B:17:0x003e, B:19:0x0042, B:20:0x0051, B:29:0x008d, B:30:0x0095, B:27:0x0083, B:22:0x0060, B:24:0x0079, B:25:0x007e, B:8:0x001d), top: B:41:0x0014, inners: #0, #3, #5 }] */
    @Override // com.fyber.inneractive.sdk.click.a
    public b a(Context context, Uri uri, List<i> list) {
        String name;
        x.a aVar;
        boolean z;
        String string = uri.toString();
        x.c cVar = x.c.OPEN_EVERYTHING;
        try {
            name = context.getClass().getName();
        } catch (Throwable unused) {
            name = "failed";
        }
        try {
            IAlog.a("IAJavaUtil - valid url found: '%s' opening browser", string);
            try {
                try {
                    context.startActivity(x.a(context, string));
                    aVar = new x.a(x.d.OPEN_IN_EXTERNAL_BROWSER, null, name);
                } catch (ActivityNotFoundException unused2) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("googlechrome://navigate?url=%s", string)));
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    z = true;
                    if (z) {
                        aVar = new x.a(x.d.OPENED_USING_CHROME_NAVIGATE, null, name);
                    } else {
                        aVar = new x.a(x.d.FAILED, new x.b("tryOpeningChromeGracefully has failed and couldn't open the url"), name);
                    }
                } catch (Throwable unused3) {
                    if (!((x.e(string) || x.d(string)) ? false : true) || cVar == x.c.DO_NOT_OPEN_IN_INTERNAL_BROWSER) {
                        aVar = new x.a(x.d.FAILED, new x.b("canOpenInExternalBrowser has decided it cant be opened and shouldUseInternalBrowser was set to true"), name);
                    } else {
                        context.startActivity(x.a(context, string, (String) null));
                        aVar = new x.a(x.d.OPENED_IN_INTERNAL_BROWSER, null, name);
                    }
                }
            } catch (Throwable unused4) {
                IAlog.e("Failed opening chrome for a special uri.", new Object[0]);
                z = false;
                if (z) {
                    aVar = new x.a(x.d.OPENED_USING_CHROME_NAVIGATE, null, name);
                } else {
                    aVar = new x.a(x.d.FAILED, new x.b("tryOpeningChromeGracefully has failed and couldn't open the url"), name);
                }
            }
        } catch (Throwable th) {
            IAlog.a("IAJavaUtil - could not open a browser for url: %s", string);
            aVar = new x.a(x.d.FAILED, th, name);
        }
        if (list != null) {
            Throwable th2 = aVar.f1351b;
            if (th2 != null) {
                list.add(new i(string, false, null, th2.toString()));
            } else {
                list.add(new i(string, true, l.d.OPENED_IN_EXTERNAL_BROWSER, null));
            }
        }
        return l.a(uri.toString(), l.d.OPENED_IN_EXTERNAL_BROWSER, "FyberNativeBrowser");
    }
}

package com.applovin.impl.sdk.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final Activity aIV;
    private AlertDialog aIW;
    private a aIX;
    private final n sdk;

    public interface a {
        void sR();

        void sS();
    }

    public b(Activity activity, n nVar) {
        this.sdk = nVar;
        this.aIV = activity;
    }

    public void a(a aVar) {
        this.aIX = aVar;
    }

    public void Ju() {
        this.aIV.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.-$$Lambda$b$DmqtBVo4GZEAbMXnJOaX2Kk8Vco
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jy() {
        AlertDialog alertDialog = this.aIW;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jx() {
        this.aIW = new AlertDialog.Builder(this.aIV).setTitle((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMc)).setMessage((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMd)).setCancelable(false).setPositiveButton((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMf), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.-$$Lambda$b$SAQvNYivPXbaXz2NiIHCSZhcKJ8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.c(dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) this.sdk.a(com.applovin.impl.sdk.c.b.aMe), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.-$$Lambda$b$IYQInV9xy63gVk-ZYh7YPprhXxo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.b(dialogInterface, i);
            }
        }).show();
    }

    public void Jv() {
        this.aIV.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.-$$Lambda$b$nSQEXV8k1UolF-fvViHE_ez2YOA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        this.aIX.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        this.aIX.sS();
    }

    public void a(final e eVar, final Runnable runnable) {
        this.aIV.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.-$$Lambda$b$iB_VBRFj5Z47BwlYrldJoLyBIHQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(eVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(e eVar, final Runnable runnable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aIV);
        builder.setTitle(eVar.Hb());
        String strHc = eVar.Hc();
        if (AppLovinSdkUtils.isValidString(strHc)) {
            builder.setMessage(strHc);
        }
        builder.setPositiveButton(eVar.Hd(), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.-$$Lambda$b$jbgVQQLQhUioOb9zZUA3rwCys68
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.a(runnable, dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        this.aIW = builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean Jw() {
        AlertDialog alertDialog = this.aIW;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}

package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@2.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcc implements zzf {
    private final Application zza;
    private final zzby zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zzg zze;
    private final zzaq zzf;
    private final zzbe zzg;
    private final zzas zzh;

    zzcc(Application application, zzby zzbyVar, Handler handler, Executor executor, zzg zzgVar, zzaq zzaqVar, zzbe zzbeVar, zzas zzasVar) {
        this.zza = application;
        this.zzb = zzbyVar;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzgVar;
        this.zzf = zzaqVar;
        this.zzg = zzbeVar;
        this.zzh = zzasVar;
    }

    private final void zzf(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            Log.d("UserMessagingPlatform", "Action[browser]: empty url.");
        }
        Uri uri = Uri.parse(strOptString);
        if (uri.getScheme() == null) {
            Log.d("UserMessagingPlatform", "Action[browser]: empty scheme: ".concat(String.valueOf(strOptString)));
        }
        try {
            this.zzb.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException e) {
            Log.d("UserMessagingPlatform", "Action[browser]: can not open url: ".concat(String.valueOf(strOptString)), e);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzf
    public final Executor zza() {
        final Handler handler = this.zzc;
        return new Executor() { // from class: com.google.android.gms.internal.consent_sdk.zzca
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.consent_sdk.zzf
    public final boolean zzb(String str, JSONObject jSONObject) {
        byte b2;
        byte b3 = -1;
        switch (str) {
            case "load_complete":
                b2 = 0;
                break;
            case "configure_app_assets":
                b2 = 3;
                break;
            case "browser":
                b2 = 2;
                break;
            case "dismiss":
                b2 = 1;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0) {
            this.zzg.zze();
            return true;
        }
        if (b2 != 1) {
            if (b2 == 2) {
                zzf(jSONObject);
                return true;
            }
            if (b2 != 3) {
                return false;
            }
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzcb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzc();
                }
            });
            return true;
        }
        String strOptString = jSONObject.optString("status");
        switch (strOptString.hashCode()) {
            case -954325659:
                if (strOptString.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) {
                    b3 = 3;
                }
                break;
            case -258041904:
                if (strOptString.equals("personalized")) {
                    b3 = 0;
                }
                break;
            case 429411856:
                if (strOptString.equals("CONSENT_SIGNAL_SUFFICIENT")) {
                    b3 = 4;
                }
                break;
            case 467888915:
                if (strOptString.equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) {
                    b3 = 1;
                }
                break;
            case 1666911234:
                if (strOptString.equals("non_personalized")) {
                    b3 = 2;
                }
                break;
        }
        if (b3 == 0 || b3 == 1 || b3 == 2 || b3 == 3 || b3 == 4) {
            this.zzg.zzc(3);
        } else {
            this.zzg.zzd(new zzi(1, "We are getting something wrong with the webview."));
        }
        return true;
    }

    final /* synthetic */ void zzc() {
        String strConcat;
        Application application = this.zza;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, application.getPackageManager().getApplicationLabel(application.getApplicationInfo()).toString());
            Drawable applicationIcon = application.getPackageManager().getApplicationIcon(application.getApplicationInfo());
            if (applicationIcon == null) {
                strConcat = null;
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strConcat = "data:image/png;base64,".concat(String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2)));
            }
            jSONObject.put("app_icon", strConcat);
            jSONObject.put("stored_infos_map", this.zzh.zzc());
        } catch (JSONException unused) {
        }
        this.zzg.zza().zzc("UMP_configureFormWithAppAssets", jSONObject.toString());
    }

    final void zzd(String str) {
        Log.d("UserMessagingPlatform", "Receive consent action: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        this.zze.zzb(uri.getQueryParameter("action"), uri.getQueryParameter("args"), this, this.zzf);
    }

    final void zze(int i, String str, String str2) {
        this.zzg.zzf(new zzi(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", Integer.valueOf(i), str2, str)));
    }
}

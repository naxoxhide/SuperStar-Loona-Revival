package com.applovin.impl.privacy.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdError;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {
    private final i axG;
    private List<e> axH;
    private final n sdk;

    public interface a {
        void onFlowCompleted(com.applovin.impl.privacy.a.a aVar);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "consent_flow_manager";
    }

    public c(n nVar) {
        this.sdk = nVar;
        this.axG = new i(nVar);
    }

    public d zU() {
        return (d) this.sdk.Ci();
    }

    public boolean isEnabled() {
        Map<String, String> extraParameters = this.sdk.getSettings().getExtraParameters();
        if (extraParameters.containsKey("consent_flow_enabled")) {
            return Boolean.parseBoolean(extraParameters.get("consent_flow_enabled"));
        }
        return zU().isEnabled();
    }

    public d.a zV() {
        return zU().zV();
    }

    public Uri getPrivacyPolicyUri() {
        return zU().getPrivacyPolicyUri();
    }

    public Uri getTermsOfServiceUri() {
        return zU().getTermsOfServiceUri();
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography() {
        return zU().getDebugUserGeography();
    }

    private static d.a A(JSONObject jSONObject) {
        return jSONObject.has("consent_flow_settings") ? d.a.UNIFIED : d.a.TERMS;
    }

    public static d D(Context context) {
        if (context == null) {
            x.H("AppLovinSdk", "Failed to get default terms flow settings.");
            return new d(false, AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, d.a.TERMS, null, null);
        }
        String strA = u.a(context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName()), context, (n) null);
        JSONObject jSONObjectJsonObjectFromJsonString = StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject();
        d.a aVarA = A(jSONObjectJsonObjectFromJsonString);
        int i = AnonymousClass1.axI[aVarA.ordinal()];
        if (i == 1) {
            return B(JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "consent_flow_settings", new JSONObject()));
        }
        if (i == 2) {
            return C(JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "terms_flow_settings", new JSONObject()));
        }
        throw new IllegalStateException("Unknown consent flow type: " + aVarA);
    }

    /* JADX INFO: renamed from: com.applovin.impl.privacy.a.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] axI;

        static {
            int[] iArr = new int[d.a.values().length];
            axI = iArr;
            try {
                iArr[d.a.UNIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                axI[d.a.TERMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static d B(JSONObject jSONObject) {
        Boolean bool = JsonUtils.getBoolean(jSONObject, "consent_flow_enabled", false);
        String string = JsonUtils.getString(jSONObject, "consent_flow_debug_user_geography", "");
        String string2 = JsonUtils.getString(jSONObject, "consent_flow_terms_of_service", null);
        Uri uri = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        String string3 = JsonUtils.getString(jSONObject, "consent_flow_privacy_policy", null);
        return new d(bool.booleanValue(), ci(string), d.a.UNIFIED, StringUtils.isValidString(string3) ? Uri.parse(string3) : null, uri);
    }

    public static d C(JSONObject jSONObject) {
        Boolean bool = JsonUtils.getBoolean(jSONObject, "terms_flow_enabled", false);
        String string = JsonUtils.getString(jSONObject, "terms_flow_terms_of_service", null);
        Uri uri = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        String string2 = JsonUtils.getString(jSONObject, "terms_flow_privacy_policy", null);
        return new d(bool.booleanValue(), AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, d.a.TERMS, StringUtils.isValidString(string2) ? Uri.parse(string2) : null, uri);
    }

    private static AppLovinSdkConfiguration.ConsentFlowUserGeography ci(String str) {
        if ("gdpr".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
        }
        if ("other".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER;
        }
        return AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
    }

    public void a(final Activity activity, final a aVar) {
        if (!isEnabled()) {
            aVar.onFlowCompleted(new com.applovin.impl.privacy.a.a(com.applovin.impl.privacy.a.a.axE, "Failed to start consent flow. Please make sure that the consent flow is enabled."));
            return;
        }
        List<e> list = this.axH;
        if (list == null || list.size() == 0) {
            this.sdk.a((com.applovin.impl.sdk.c.d<boolean>) com.applovin.impl.sdk.c.d.aRo, false);
            aVar.onFlowCompleted(new com.applovin.impl.privacy.a.a(com.applovin.impl.privacy.a.a.ERROR_CODE_UNSPECIFIED, "User may not be eligible for flow."));
        } else {
            a(activity, new Runnable() { // from class: com.applovin.impl.privacy.a.-$$Lambda$c$plaYOgGERHBtvQn-1HEuf4XHiXE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(activity, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity, final a aVar) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("ConsentFlowManager", "Starting consent flow with states: " + this.axH);
        }
        if (!this.sdk.BJ()) {
            this.sdk.a((com.applovin.impl.sdk.c.d<boolean>) com.applovin.impl.sdk.c.d.aRo, true);
        }
        this.axG.a(this.axH, activity, new a() { // from class: com.applovin.impl.privacy.a.-$$Lambda$c$eu28v1NB5nM738YODrNPlUzgdQw
            @Override // com.applovin.impl.privacy.a.c.a
            public final void onFlowCompleted(a aVar2) {
                this.f$0.a(aVar, aVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, com.applovin.impl.privacy.a.a aVar2) {
        if (aVar2 == null) {
            this.sdk.a((com.applovin.impl.sdk.c.d<boolean>) com.applovin.impl.sdk.c.d.aRo, false);
            this.axH = null;
        }
        aVar.onFlowCompleted(aVar2);
    }

    private void a(final Activity activity, Runnable runnable) {
        if (zU().getPrivacyPolicyUri() != null) {
            runnable.run();
        } else {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.privacy.a.-$$Lambda$c$vhkwJy6llScAMsPm5_YpXycudbQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.g(activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Activity activity) {
        final Uri uriZX = zX();
        new AlertDialog.Builder(activity).setTitle("Missing Privacy Policy URL").setMessage("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL").setNeutralButton("Go To Documentation", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.privacy.a.-$$Lambda$c$qAHxgcDXKiyPa8Yn6oVrfOJtteY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.b(uriZX, dialogInterface, i);
            }
        }).setNegativeButton("DISMISS", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.privacy.a.-$$Lambda$c$LNoHVW0HO7vWqaVDe4sZFv1ANuU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                c.a(uriZX, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Uri uri, DialogInterface dialogInterface, int i) {
        s.a(uri, n.getApplicationContext(), this.sdk);
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, DialogInterface dialogInterface, int i) {
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    public boolean zW() {
        n nVar = n.aAz;
        if (!nVar.Bp()) {
            return false;
        }
        c cVarCj = nVar.Cj();
        List<e> list = cVarCj.axH;
        return cVarCj.axG.zW() || (list != null && list.size() > 0);
    }

    private Uri zX() {
        return Uri.parse((String) this.sdk.a(this.sdk.Bq() ? com.applovin.impl.sdk.c.b.aQR : com.applovin.impl.sdk.c.b.aQQ));
    }

    public void zY() {
        if (!this.sdk.Bo() && isEnabled()) {
            if (zU().zV() == d.a.UNIFIED) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("AppLovinSdk", "Generating Unified Consent Flow...");
                }
                this.axH = b.h(this.sdk);
            } else {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("AppLovinSdk", "Generating Terms Flow...");
                }
                this.axH = b.i(this.sdk);
            }
        }
        if (u.ah(n.getApplicationContext())) {
            AppLovinCommunicator.getInstance(n.getApplicationContext()).subscribe(this, "start_sdk_consent_flow");
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (getTermsOfServiceUri() != null && appLovinCommunicatorMessage.getMessageData().getBoolean("include_tos")) {
            this.axH = j.l(this.sdk);
        } else {
            this.axH = j.k(this.sdk);
        }
        if (this.axH.size() == 0) {
            u.a("No Consent Flow Available", (String) null, this.sdk.CD());
        } else {
            a(this.sdk.CD(), new a() { // from class: com.applovin.impl.privacy.a.-$$Lambda$c$TO_5MMiAp932C83WG9G_2WZYdqI
                @Override // com.applovin.impl.privacy.a.c.a
                public final void onFlowCompleted(a aVar) {
                    this.f$0.a(aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.privacy.a.a aVar) {
        AppLovinCommunicator.getInstance(n.getApplicationContext()).getMessagingService().publish(new AppLovinCommunicatorMessage(new Bundle(), "sdk_consent_flow_finished", this));
    }

    public JSONObject zZ() {
        d dVarZU = zU();
        Uri privacyPolicyUri = dVarZU.getPrivacyPolicyUri();
        Uri termsOfServiceUri = dVarZU.getTermsOfServiceUri();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "enabled", String.valueOf(isEnabled()));
        JsonUtils.putString(jSONObject, "privacy_policy_url", privacyPolicyUri != null ? privacyPolicyUri.toString() : "");
        JsonUtils.putString(jSONObject, "terms_of_service_url", termsOfServiceUri != null ? termsOfServiceUri.toString() : "");
        return jSONObject;
    }

    public String uI() {
        zU();
        Object privacyPolicyUri = getPrivacyPolicyUri();
        Object termsOfServiceUri = getTermsOfServiceUri();
        StringBuilder sbAppend = new StringBuilder().append("\nConsent Flow Enabled - ").append(isEnabled()).append("\nPrivacy Policy - ");
        if (privacyPolicyUri == null) {
            privacyPolicyUri = AdError.UNDEFINED_DOMAIN;
        }
        StringBuilder sbAppend2 = sbAppend.append(privacyPolicyUri).append("\nTerms of Service - ");
        if (termsOfServiceUri == null) {
            termsOfServiceUri = AdError.UNDEFINED_DOMAIN;
        }
        return sbAppend2.append(termsOfServiceUri).toString();
    }
}

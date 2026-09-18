package com.applovin.impl.privacy.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private final com.applovin.impl.sdk.utils.a aiO = new com.applovin.impl.sdk.utils.a() { // from class: com.applovin.impl.privacy.a.i.1
        @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if ((activity instanceof AppLovinWebViewActivity) || i.this.ayl == null) {
                return;
            }
            if (i.this.aym != null) {
                i.this.aym.dismiss();
                i.this.aym = null;
            }
            e eVar = i.this.ayl;
            i.this.ayl = null;
            i.this.a(eVar, activity);
        }
    };
    private final int ayi;
    private List<e> ayj;
    private c.a ayk;
    private e ayl;
    private Dialog aym;
    private final n sdk;

    public i(n nVar) {
        this.sdk = nVar;
        this.ayi = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aQS)).intValue();
    }

    public void a(List<e> list, Activity activity, c.a aVar) {
        if (this.ayj != null) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("AppLovinSdk", "Unable to start states: " + list);
            }
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("AppLovinSdk", "Consent flow already in progress for states: " + this.ayj);
            }
            aVar.onFlowCompleted(new a(a.axF, "Consent flow is already in progress."));
            return;
        }
        this.ayj = list;
        this.ayk = aVar;
        n.E(activity).a(this.aiO);
        a(Aj(), activity);
    }

    public boolean zW() {
        return this.ayj != null;
    }

    public void aI(boolean z) {
        if (this.sdk.Cj().zV() == d.a.TERMS) {
            return;
        }
        com.applovin.impl.privacy.a.b(z, n.getApplicationContext());
    }

    public void Ai() {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppLovinSdk", "Reinitializing SDK and ending consent flow");
        }
        this.ayj = null;
        this.sdk.BK().b(this.aiO);
        c.a aVar = this.ayk;
        if (aVar != null) {
            aVar.onFlowCompleted(null);
            this.ayk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final e eVar, final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.privacy.a.-$$Lambda$i$PaHeb_aNCrBsj-Us_2lNlbJmtvQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(eVar, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final e eVar, final Activity activity) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppLovinSdk", "Transitioning to state: " + eVar);
        }
        if (eVar.Aa() == e.b.ALERT) {
            if (com.applovin.impl.sdk.utils.b.i(activity)) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.privacy.a.i.2
                    @Override // java.lang.Runnable
                    public void run() {
                        i iVar = i.this;
                        iVar.a(eVar, iVar.sdk.CD());
                    }
                }, TimeUnit.SECONDS.toMillis(1L));
                return;
            }
            f fVar = (f) eVar;
            this.ayl = fVar;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            for (final g gVar : fVar.Ad()) {
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.applovin.impl.privacy.a.i.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        i.this.ayl = null;
                        i.this.aym = null;
                        e eVarCm = i.this.cm(gVar.Af());
                        if (eVarCm == null) {
                            i.this.sdk.BL();
                            if (x.Fk()) {
                                i.this.sdk.BL().i("AppLovinSdk", "Consent flow failed to get destination state for TOS/PP alert. Finishing flow...");
                            }
                            i.this.Ai();
                            return;
                        }
                        i.this.a(eVarCm, activity);
                        if (eVarCm.Aa() != e.b.ALERT) {
                            dialogInterface.dismiss();
                        }
                    }
                };
                if (gVar.Ae() == g.a.POSITIVE) {
                    builder.setPositiveButton(gVar.getTitle(), onClickListener);
                } else if (gVar.Ae() == g.a.NEGATIVE) {
                    builder.setNegativeButton(gVar.getTitle(), onClickListener);
                } else {
                    builder.setNeutralButton(gVar.getTitle(), onClickListener);
                }
            }
            String title = fVar.getTitle();
            SpannableString spannableString = null;
            if (StringUtils.isValidString(title)) {
                spannableString = new SpannableString(title);
                String strGy = n.gy(R.string.applovin_terms_of_service_text);
                String strGy2 = n.gy(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(title, Arrays.asList(strGy, strGy2))) {
                    final Uri termsOfServiceUri = this.sdk.Cj().getTermsOfServiceUri();
                    if (termsOfServiceUri != null) {
                        StringUtils.addLinks(spannableString, Pattern.compile(strGy), new ClickableSpan() { // from class: com.applovin.impl.privacy.a.i.4
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                u.a(termsOfServiceUri, activity, i.this.sdk);
                            }
                        }, true);
                    }
                    final Uri privacyPolicyUri = this.sdk.Cj().getPrivacyPolicyUri();
                    StringUtils.addLinks(spannableString, Pattern.compile(strGy2), new ClickableSpan() { // from class: com.applovin.impl.privacy.a.i.5
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            u.a(privacyPolicyUri, activity, i.this.sdk);
                        }
                    }, true);
                }
            }
            final AlertDialog alertDialogCreate = builder.setTitle(spannableString).setMessage(fVar.getMessage()).create();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.privacy.a.-$$Lambda$i$m852X_RZC06RRiZRzafynfWcjTA
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f$0.a(alertDialogCreate, dialogInterface);
                }
            });
            this.aym = alertDialogCreate;
            alertDialogCreate.show();
            return;
        }
        if (eVar.Aa() == e.b.EVENT) {
            h hVar = (h) eVar;
            String name = hVar.getName();
            Map<String, String> mapAh = hVar.Ah();
            if (mapAh == null) {
                mapAh = new HashMap<>(1);
            }
            mapAh.put("flow_type", this.sdk.Cj().zV().getType());
            this.sdk.BD().trackEvent(name, mapAh);
            b(hVar, activity);
            return;
        }
        if (eVar.Aa() == e.b.HAS_USER_CONSENT) {
            aI(true);
            b(eVar, activity);
            return;
        }
        if (eVar.Aa() == e.b.CMP_LOAD) {
            if (com.applovin.impl.sdk.utils.b.i(activity)) {
                a(eVar);
                return;
            } else {
                this.sdk.Cl().loadCmp(activity, new CmpServiceImpl.a() { // from class: com.applovin.impl.privacy.a.i.6
                    @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.a
                    public void c(AppLovinCmpError appLovinCmpError) {
                        i.this.a(eVar, activity, Boolean.valueOf(appLovinCmpError == null));
                    }
                });
                return;
            }
        }
        if (eVar.Aa() == e.b.CMP_SHOW) {
            if (com.applovin.impl.sdk.utils.b.i(activity)) {
                a(eVar);
                return;
            } else {
                this.sdk.BD().trackEvent("cf_start");
                this.sdk.Cl().showCmp(activity, new CmpServiceImpl.b() { // from class: com.applovin.impl.privacy.a.i.7
                    @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.b
                    public void d(AppLovinCmpError appLovinCmpError) {
                        i.this.b(eVar, activity);
                    }
                });
                return;
            }
        }
        if (eVar.Aa() == e.b.DECISION) {
            e.a aVarAb = eVar.Ab();
            if (aVarAb == e.a.IS_AL_GDPR) {
                a(eVar, activity, Boolean.valueOf(this.sdk.getConfiguration().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR || (this.sdk.Cj().getDebugUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR && u.b(n.getApplicationContext(), this.sdk))));
                return;
            }
            throw new IllegalStateException("Unsupported decision type: " + aVarAb);
        }
        if (eVar.Aa() == e.b.TERMS_FLOW) {
            List<e> listI = b.i(this.sdk);
            if (listI != null && listI.size() > 0) {
                this.sdk.BD().trackEvent("cf_start");
                this.ayj = listI;
                a(Aj(), activity);
                return;
            }
            Ai();
            return;
        }
        if (eVar.Aa() == e.b.REINIT) {
            Ai();
            return;
        }
        throw new IllegalStateException("No destination consent flow state found!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.ayi);
    }

    private void a(final e eVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.privacy.a.i.8
            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                iVar.a(eVar, iVar.sdk.CD());
            }
        }, TimeUnit.SECONDS.toMillis(1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar, Activity activity) {
        a(eVar, activity, (Boolean) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, Activity activity, Boolean bool) {
        a(cm(eVar.b(bool)), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e cm(String str) {
        List<e> list = this.ayj;
        if (list == null) {
            return null;
        }
        for (e eVar : list) {
            if (str.equalsIgnoreCase(eVar.mQ())) {
                return eVar;
            }
        }
        return null;
    }

    private e Aj() {
        for (e eVar : this.ayj) {
            if (eVar.Ac()) {
                return eVar;
            }
        }
        return null;
    }
}

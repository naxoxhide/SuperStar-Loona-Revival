package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.applovin.impl.mediation.debugger.ui.a {
    private com.applovin.impl.mediation.debugger.ui.d.d aqt;
    private n sdk;

    private enum a {
        TC_NETWORKS,
        AC_NETWORKS
    }

    public void initialize(n nVar) {
        this.sdk = nVar;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final boolean zCx = com.applovin.impl.privacy.b.d.cx(nVar.Ck().Ar());
        if (!zCx) {
            arrayList2.add(b("Has User Consent", AppLovinPrivacySettings.hasUserConsent(this)));
        }
        for (com.applovin.impl.privacy.b.c cVar : nVar.Ck().As()) {
            Boolean boolAw = cVar.Aw();
            if (boolAw != null) {
                if (cVar.At() == com.applovin.impl.privacy.b.c.a.TCF_VENDOR) {
                    arrayList.add(b(cVar.getDisplayName(), boolAw.booleanValue()));
                } else if (cVar.At() == com.applovin.impl.privacy.b.c.a.ATP_NETWORK) {
                    arrayList2.add(b(cVar.getDisplayName(), boolAw.booleanValue()));
                }
            }
        }
        com.applovin.impl.mediation.debugger.ui.d.d dVar = new com.applovin.impl.mediation.debugger.ui.d.d(this) { // from class: com.applovin.impl.mediation.debugger.ui.e.b.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int tM() {
                return a.values().length;
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int gg(int i) {
                if (i == a.TC_NETWORKS.ordinal()) {
                    return arrayList.size();
                }
                return arrayList2.size();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                if (i == a.TC_NETWORKS.ordinal()) {
                    return new e("TCF VENDORS (TC STRING)");
                }
                return new e(zCx ? "ATP NETWORKS (AC STRING)" : "APPLOVIN PRIVACY SETTING");
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                if (i == a.TC_NETWORKS.ordinal()) {
                    return arrayList;
                }
                return arrayList2;
            }
        };
        this.aqt = dVar;
        dVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        return this.sdk;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Network Consent Statuses");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.aqt);
    }

    private com.applovin.impl.mediation.debugger.ui.d.c b(String str, boolean z) {
        return com.applovin.impl.mediation.debugger.ui.d.c.wV().bO(str).bP(String.valueOf(z)).wW();
    }
}

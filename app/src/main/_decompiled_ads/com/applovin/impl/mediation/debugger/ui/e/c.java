package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerCmpNetworksListActivity;
import com.applovin.mediation.MaxDebuggerTcfStringActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.applovin.impl.mediation.debugger.ui.a {
    private com.applovin.impl.mediation.debugger.ui.d.d aqt;
    private final Set<String> atc = new TreeSet();
    private final Set<String> atd = new TreeSet();
    private final Set<String> ate = new TreeSet();
    private final Set<String> atf = new TreeSet();
    private final Set<String> atg = new TreeSet();
    private n sdk;

    private enum a {
        CMP_SDK_ID,
        CMP_SDK_VERSION,
        INSTRUCTIONS,
        MISSING_NETWORKS
    }

    private enum b {
        GDPR_APPLIES,
        TC_STRING,
        AC_STRING
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.e.c$c, reason: collision with other inner class name */
    private enum EnumC0131c {
        IAB_TCF_PARAMETERS,
        CMP_CONFIGURATION
    }

    public void initialize(final n nVar) {
        this.sdk = nVar;
        final com.applovin.impl.privacy.b.b bVarCk = nVar.Ck();
        A(bVarCk.As());
        com.applovin.impl.mediation.debugger.ui.d.d dVar = new com.applovin.impl.mediation.debugger.ui.d.d(this) { // from class: com.applovin.impl.mediation.debugger.ui.e.c.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int tM() {
                return EnumC0131c.values().length;
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int gg(int i) {
                if (i == EnumC0131c.IAB_TCF_PARAMETERS.ordinal()) {
                    return b.values().length;
                }
                return a.values().length;
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                if (i == EnumC0131c.IAB_TCF_PARAMETERS.ordinal()) {
                    return new e("IAB TCF Parameters");
                }
                return new e("CMP CONFIGURATION");
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                return i == EnumC0131c.IAB_TCF_PARAMETERS.ordinal() ? c.this.xa() : c.this.xb();
            }
        };
        this.aqt = dVar;
        dVar.a(new com.applovin.impl.mediation.debugger.ui.d.d.a() { // from class: com.applovin.impl.mediation.debugger.ui.e.c.2
            @Override // com.applovin.impl.mediation.debugger.ui.d.d.a
            public void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
                final String name;
                final String strAr;
                if (aVar.wO() == EnumC0131c.IAB_TCF_PARAMETERS.ordinal()) {
                    if (aVar.wP() == b.TC_STRING.ordinal()) {
                        name = com.applovin.impl.sdk.c.d.aRs.getName();
                        strAr = bVarCk.Aq();
                    } else {
                        name = com.applovin.impl.sdk.c.d.aRt.getName();
                        strAr = bVarCk.Ar();
                    }
                    com.applovin.impl.sdk.utils.b.a(c.this, MaxDebuggerTcfStringActivity.class, nVar.BK(), new com.applovin.impl.sdk.utils.b.a<MaxDebuggerTcfStringActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.e.c.2.1
                        @Override // com.applovin.impl.sdk.utils.b.a
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onActivityCreated(MaxDebuggerTcfStringActivity maxDebuggerTcfStringActivity) {
                            maxDebuggerTcfStringActivity.initialize(name, strAr, nVar);
                        }
                    });
                    return;
                }
                com.applovin.impl.sdk.utils.b.a(c.this, MaxDebuggerCmpNetworksListActivity.class, nVar.BK(), new com.applovin.impl.sdk.utils.b.a<MaxDebuggerCmpNetworksListActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.e.c.2.2
                    @Override // com.applovin.impl.sdk.utils.b.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onActivityCreated(MaxDebuggerCmpNetworksListActivity maxDebuggerCmpNetworksListActivity) {
                        maxDebuggerCmpNetworksListActivity.initialize(c.this.ate, c.this.atf, c.this.atc, c.this.atd, c.this.atg, nVar);
                    }
                });
            }
        });
        this.aqt.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        return this.sdk;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("CMP (Consent Management Platform)");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.aqt);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.applovin.impl.mediation.debugger.ui.d.d dVar = this.aqt;
        if (dVar != null) {
            dVar.a(null);
        }
    }

    private void A(List<com.applovin.impl.privacy.b.c> list) {
        for (com.applovin.impl.privacy.b.c cVar : list) {
            Boolean boolAw = cVar.Aw();
            if (boolAw == null) {
                this.atg.add(cVar.getDisplayName());
            } else if (cVar.At() == com.applovin.impl.privacy.b.c.a.TCF_VENDOR) {
                if (boolAw.booleanValue()) {
                    this.atc.add(cVar.Au());
                } else {
                    this.ate.add(cVar.Au());
                }
            } else if (cVar.At() == com.applovin.impl.privacy.b.c.a.ATP_NETWORK) {
                if (boolAw.booleanValue()) {
                    this.atd.add(cVar.Au());
                } else {
                    this.atf.add(cVar.Au());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.applovin.impl.mediation.debugger.ui.d.c> xa() {
        ArrayList arrayList = new ArrayList(b.values().length);
        Integer numAp = this.sdk.Ck().Ap();
        String strAq = this.sdk.Ck().Aq();
        String strAr = this.sdk.Ck().Ar();
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRr.getName(), numAp));
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRs.getName(), strAq, !com.applovin.impl.privacy.b.d.cv(strAq)));
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRt.getName(), strAr, false));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.applovin.impl.mediation.debugger.ui.d.c> xb() {
        ArrayList arrayList = new ArrayList(b.values().length);
        Integer numAn = this.sdk.Ck().An();
        Integer numAo = this.sdk.Ck().Ao();
        int size = this.ate.size() + this.atf.size();
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRp.getName(), numAn));
        arrayList.add(a(com.applovin.impl.sdk.c.d.aRq.getName(), numAo));
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.DETAIL).bO("To check which of your integrated networks are missing from your CMP, first make sure that you have granted consent to all networks through your CMP flow. Then add the following networks to your CMP network list.").wW());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.RIGHT_DETAIL).bO("Configured CMP Networks").bP(size > 0 ? "Missing " + size + " network(s)" : "").gm(size > 0 ? SupportMenu.CATEGORY_MASK : -16777216).y(this).aF(true).wW());
        return arrayList;
    }

    private com.applovin.impl.mediation.debugger.ui.d.c a(String str, Integer num) {
        return com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.RIGHT_DETAIL).bO(str).bP(num != null ? num.toString() : "No value set").gm(num != null ? -16777216 : SupportMenu.CATEGORY_MASK).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c a(String str, String str2, boolean z) {
        boolean zIsValidString = StringUtils.isValidString(str2);
        if (zIsValidString && str2.length() > 35) {
            str2 = str2.substring(0, 35) + "...";
        }
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO = com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.DETAIL).bO(str);
        if (!zIsValidString) {
            str2 = "No value set";
        }
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarAF = aVarBO.bP(str2).gm(z ? SupportMenu.CATEGORY_MASK : -16777216).aF(zIsValidString);
        if (zIsValidString) {
            aVarAF.y(this);
        }
        return aVarAF.wW();
    }
}

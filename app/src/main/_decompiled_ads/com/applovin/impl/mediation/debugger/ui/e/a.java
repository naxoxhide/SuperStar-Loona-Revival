package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private com.applovin.impl.mediation.debugger.ui.d.d aqt;
    private n sdk;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.e.a$a, reason: collision with other inner class name */
    private enum EnumC0129a {
        MISSING_TC_NETWORKS,
        MISSING_AC_NETWORKS,
        LISTED_TC_NETWORKS,
        LISTED_AC_NETWORKS,
        OTHER_NETWORKS
    }

    public void initialize(final Set<String> set, final Set<String> set2, final Set<String> set3, final Set<String> set4, final Set<String> set5, n nVar) {
        this.sdk = nVar;
        com.applovin.impl.mediation.debugger.ui.d.d dVar = new com.applovin.impl.mediation.debugger.ui.d.d(this) { // from class: com.applovin.impl.mediation.debugger.ui.e.a.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int tM() {
                return EnumC0129a.values().length;
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int gg(int i) {
                if (i == EnumC0129a.MISSING_TC_NETWORKS.ordinal()) {
                    return set.size();
                }
                if (i == EnumC0129a.MISSING_AC_NETWORKS.ordinal()) {
                    return set2.size();
                }
                if (i == EnumC0129a.LISTED_TC_NETWORKS.ordinal()) {
                    return set3.size();
                }
                if (i == EnumC0129a.LISTED_AC_NETWORKS.ordinal()) {
                    return set4.size();
                }
                return set5.size();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                if (i == EnumC0129a.MISSING_TC_NETWORKS.ordinal()) {
                    return new e("MISSING TCF VENDORS (TC STRING)");
                }
                if (i == EnumC0129a.MISSING_AC_NETWORKS.ordinal()) {
                    return new e("MISSING ATP NETWORKS (AC STRING)");
                }
                if (i == EnumC0129a.LISTED_TC_NETWORKS.ordinal()) {
                    return new e("LISTED TCF VENDORS (TC STRING)");
                }
                if (i == EnumC0129a.LISTED_AC_NETWORKS.ordinal()) {
                    return new e("LISTED ATP NETWORKS (AC STRING)");
                }
                return new e("NON-CONFIGURABLE NETWORKS");
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                Set set6;
                boolean z = true;
                if (i == EnumC0129a.MISSING_TC_NETWORKS.ordinal()) {
                    set6 = set;
                } else if (i == EnumC0129a.MISSING_AC_NETWORKS.ordinal()) {
                    set6 = set2;
                } else {
                    if (i == EnumC0129a.LISTED_TC_NETWORKS.ordinal()) {
                        set6 = set3;
                    } else if (i == EnumC0129a.LISTED_AC_NETWORKS.ordinal()) {
                        set6 = set4;
                    } else {
                        set6 = set5;
                    }
                    z = false;
                }
                ArrayList arrayList = new ArrayList(set6.size());
                Iterator it = set6.iterator();
                while (it.hasNext()) {
                    arrayList.add(a.this.b((String) it.next(), z));
                }
                return arrayList;
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
        setTitle("Configured CMP Networks");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.aqt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.c b(String str, boolean z) {
        return com.applovin.impl.mediation.debugger.ui.d.c.wV().bO(str).gl(z ? SupportMenu.CATEGORY_MASK : -16777216).wW();
    }
}

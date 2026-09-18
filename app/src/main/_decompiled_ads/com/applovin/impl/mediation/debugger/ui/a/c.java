package com.applovin.impl.mediation.debugger.ui.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.mediation.d.c$$ExternalSynthetic0;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerWaterfallKeywordsActivity;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.applovin.impl.mediation.debugger.ui.a {
    private com.applovin.impl.mediation.debugger.b.a.a apR;
    private com.applovin.impl.mediation.debugger.ui.d.d aqt;
    private n sdk;

    public enum a {
        TARGETED_WATERFALL,
        OTHER_WATERFALLS
    }

    public void initialize(final com.applovin.impl.mediation.debugger.b.a.a aVar, final n nVar) {
        this.apR = aVar;
        this.sdk = nVar;
        com.applovin.impl.mediation.debugger.ui.d.d dVar = new com.applovin.impl.mediation.debugger.ui.d.d(this) { // from class: com.applovin.impl.mediation.debugger.ui.a.c.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int tM() {
                return aVar.uH().size();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int gg(int i) {
                com.applovin.impl.mediation.debugger.b.a.b bVar = aVar.uH().get(i);
                int i2 = bVar.uJ() != null ? 1 : 0;
                int i3 = 2;
                com.applovin.impl.mediation.debugger.b.a.f fVarUK = bVar.uK();
                if (fVarUK.uX() != null && fVarUK.uY() != null) {
                    i3 = 3;
                }
                if (fVarUK.uZ() != null) {
                    i3++;
                }
                if (fVarUK.getKeywords() != null) {
                    i3++;
                }
                return i2 + 1 + i3;
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                if (i == a.TARGETED_WATERFALL.ordinal()) {
                    return new com.applovin.impl.mediation.debugger.ui.d.e("TARGETED WATERFALL FOR CURRENT DEVICE");
                }
                if (i == a.OTHER_WATERFALLS.ordinal()) {
                    return new com.applovin.impl.mediation.debugger.ui.d.e("OTHER WATERFALLS");
                }
                return new com.applovin.impl.mediation.debugger.ui.d.e("");
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                ArrayList arrayList = new ArrayList();
                com.applovin.impl.mediation.debugger.b.a.b bVar = aVar.uH().get(i);
                arrayList.add(c.this.bJ(bVar.getName()));
                if (bVar.uJ() != null) {
                    arrayList.add(c.this.u("AB Test Experiment Name", bVar.uJ()));
                }
                com.applovin.impl.mediation.debugger.b.a.f fVarUK = bVar.uK();
                c cVar = c.this;
                arrayList.add(cVar.u("Device ID Targeting", cVar.bK(fVarUK.uV())));
                c cVar2 = c.this;
                arrayList.add(cVar2.u("Device Type Targeting", cVar2.bL(fVarUK.uW())));
                if (fVarUK.uZ() != null) {
                    c cVar3 = c.this;
                    arrayList.add(cVar3.u("Gender", cVar3.p(fVarUK.uZ())));
                }
                if (fVarUK.uX() != null && fVarUK.uY() != null) {
                    arrayList.add(c.this.u(HttpHeaders.AGE, fVarUK.uX() + "-" + fVarUK.uY()));
                }
                if (fVarUK.getKeywords() != null) {
                    arrayList.add(c.this.q(fVarUK.getKeywords()));
                }
                return arrayList;
            }
        };
        this.aqt = dVar;
        dVar.a(new com.applovin.impl.mediation.debugger.ui.d.d.a() { // from class: com.applovin.impl.mediation.debugger.ui.a.-$$Lambda$c$lFj55hDMnnOwJcKhdi0FnssAfwU
            @Override // com.applovin.impl.mediation.debugger.ui.d.d.a
            public final void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar2, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
                this.f$0.a(nVar, aVar, aVar2, cVar);
            }
        });
        this.aqt.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final n nVar, final com.applovin.impl.mediation.debugger.b.a.a aVar, final com.applovin.impl.mediation.debugger.ui.d.a aVar2, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
        if (aVar2.wP() == 0) {
            com.applovin.impl.sdk.utils.b.a(this, MaxDebuggerAdUnitDetailActivity.class, nVar.BK(), new com.applovin.impl.sdk.utils.b.a() { // from class: com.applovin.impl.mediation.debugger.ui.a.-$$Lambda$c$CXNf6e5osHSM8kxWDJJBTiEhm_g
                @Override // com.applovin.impl.sdk.utils.b.a
                public final void onActivityCreated(Activity activity) {
                    c.a(aVar, aVar2, nVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        } else if (cVar.wT().toString().equals("Keywords")) {
            com.applovin.impl.sdk.utils.b.a(this, MaxDebuggerWaterfallKeywordsActivity.class, nVar.BK(), new com.applovin.impl.sdk.utils.b.a() { // from class: com.applovin.impl.mediation.debugger.ui.a.-$$Lambda$c$6jwz2Bb6Htkdmmf35fvQtWV8e6A
                @Override // com.applovin.impl.sdk.utils.b.a
                public final void onActivityCreated(Activity activity) {
                    c.a(aVar, aVar2, nVar, (MaxDebuggerWaterfallKeywordsActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.mediation.debugger.b.a.a aVar, com.applovin.impl.mediation.debugger.ui.d.a aVar2, n nVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(aVar, aVar.uH().get(aVar2.wO()), null, nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.mediation.debugger.b.a.a aVar, com.applovin.impl.mediation.debugger.ui.d.a aVar2, n nVar, MaxDebuggerWaterfallKeywordsActivity maxDebuggerWaterfallKeywordsActivity) {
        com.applovin.impl.mediation.debugger.b.a.b bVar = aVar.uH().get(aVar2.wO());
        maxDebuggerWaterfallKeywordsActivity.initialize(bVar.getName(), bVar.uK().getKeywords(), nVar);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        return this.sdk;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.apR.getName());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.aqt);
        listView.setDividerHeight(0);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.applovin.impl.mediation.debugger.ui.d.d dVar = this.aqt;
        if (dVar != null) {
            dVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.c bJ(String str) {
        return com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.RIGHT_DETAIL).a(StringUtils.createSpannedString(str, -16777216, 18, 1)).y(this).aF(true).wW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.c u(String str, String str2) {
        return com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.RIGHT_DETAIL).bO(str).bP(str2).wW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bK(String str) {
        if (str.equals("idfa")) {
            return "IDFA Only";
        }
        return str.equals("dnt") ? "No IDFA Only" : "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bL(String str) {
        if (str.equals("phone")) {
            return "Phones";
        }
        return str.equals("tablet") ? "Tablets" : "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.equals(InneractiveMediationDefs.GENDER_MALE)) {
                arrayList.add("Male");
            } else if (str.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                arrayList.add("Female");
            } else {
                arrayList.add(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            }
        }
        return c$$ExternalSynthetic0.m0(", ", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.c q(List<String> list) {
        return com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.DETAIL).bO("Keywords").b(StringUtils.createSpannedString(list.size() + " keyword group(s)", -7829368, 14)).y(this).aF(true).wW();
    }
}

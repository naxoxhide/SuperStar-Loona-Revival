package com.applovin.impl.mediation.debugger.ui.b;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private FrameLayout akw;
    private ListView akx;
    private b anY;
    private DataSetObserver aqI;
    private com.applovin.impl.adview.a aqJ;

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        b bVar = this.anY;
        if (bVar != null) {
            return bVar.getSdk();
        }
        return null;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.akw = (FrameLayout) findViewById(android.R.id.content);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter((ListAdapter) this.anY);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share == menuItem.getItemId()) {
            wd();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        b bVar = this.anY;
        if (bVar == null || bVar.isInitialized()) {
            return;
        }
        we();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        b bVar = this.anY;
        if (bVar != null) {
            bVar.unregisterDataSetObserver(this.aqI);
            this.anY.a(null);
        }
    }

    public void setListAdapter(b bVar, final com.applovin.impl.sdk.a aVar) {
        DataSetObserver dataSetObserver;
        b bVar2 = this.anY;
        if (bVar2 != null && (dataSetObserver = this.aqI) != null) {
            bVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.anY = bVar;
        this.aqI = new DataSetObserver() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                a.this.wf();
                a aVar2 = a.this;
                aVar2.w(aVar2);
            }
        };
        w(this);
        this.anY.registerDataSetObserver(this.aqI);
        this.anY.a(new d.a() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2
            @Override // com.applovin.impl.mediation.debugger.ui.d.d.a
            public void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar2, final c cVar) {
                int iWO = aVar2.wO();
                if (iWO == b.e.APP_INFO.ordinal()) {
                    u.a(cVar.wj(), cVar.vP(), a.this);
                    return;
                }
                if (iWO == b.e.MAX.ordinal()) {
                    n sdk = a.this.anY.getSdk();
                    if (sdk.Cj().isEnabled()) {
                        int iWP = aVar2.wP();
                        if (sdk.Cj().zV() == com.applovin.impl.privacy.a.d.a.TERMS) {
                            iWP++;
                        }
                        if (iWP == b.c.PRIVACY_POLICY_URL.ordinal()) {
                            if (sdk.Cj().getPrivacyPolicyUri() != null) {
                                s.a(sdk.Cj().getPrivacyPolicyUri(), n.getApplicationContext(), sdk);
                                return;
                            } else {
                                u.a("Missing Privacy Policy URL", "You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL", a.this);
                                return;
                            }
                        }
                        if (iWP == b.c.TERMS_OF_SERVICE_URL.ordinal()) {
                            if (sdk.Cj().getTermsOfServiceUri() != null) {
                                s.a(sdk.Cj().getTermsOfServiceUri(), n.getApplicationContext(), sdk);
                                return;
                            }
                            return;
                        }
                    }
                    u.a(cVar.wj(), cVar.vP(), a.this);
                    return;
                }
                if (iWO == b.e.PRIVACY.ordinal()) {
                    if (aVar2.wP() == b.d.CMP.ordinal()) {
                        if (StringUtils.isValidString(a.this.anY.getSdk().Ck().Ak())) {
                            com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTcfInfoListActivity.class, aVar, new com.applovin.impl.sdk.utils.b.a<MaxDebuggerTcfInfoListActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.1
                                @Override // com.applovin.impl.sdk.utils.b.a
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public void onActivityCreated(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                                    maxDebuggerTcfInfoListActivity.initialize(a.this.anY.getSdk());
                                }
                            });
                            return;
                        } else {
                            u.a("", cVar.vP(), a.this);
                            return;
                        }
                    }
                    if (aVar2.wP() == b.d.NETWORK_CONSENT_STATUSES.ordinal()) {
                        com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTcfConsentStatusesListActivity.class, aVar, new com.applovin.impl.sdk.utils.b.a<MaxDebuggerTcfConsentStatusesListActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.2
                            @Override // com.applovin.impl.sdk.utils.b.a
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onActivityCreated(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                                maxDebuggerTcfConsentStatusesListActivity.initialize(a.this.anY.getSdk());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (iWO == b.e.ADS.ordinal()) {
                    if (aVar2.wP() == b.a.AD_UNITS.ordinal()) {
                        if (a.this.anY.wh().size() > 0) {
                            com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerAdUnitsListActivity.class, aVar, new com.applovin.impl.sdk.utils.b.a<MaxDebuggerAdUnitsListActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.3
                                @Override // com.applovin.impl.sdk.utils.b.a
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public void onActivityCreated(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                    maxDebuggerAdUnitsListActivity.initialize(a.this.anY.wh(), false, a.this.anY.getSdk());
                                }
                            });
                            return;
                        } else {
                            u.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", a.this);
                            return;
                        }
                    }
                    if (aVar2.wP() == b.a.SELECT_LIVE_NETWORKS.ordinal()) {
                        if (a.this.anY.wk().size() > 0 || a.this.anY.wl().size() > 0) {
                            if (a.this.anY.getSdk().CC().isEnabled()) {
                                u.a("Restart Required", cVar.vP(), a.this);
                                return;
                            } else {
                                com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTestLiveNetworkActivity.class, aVar, new com.applovin.impl.sdk.utils.b.a<MaxDebuggerTestLiveNetworkActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.4
                                    @Override // com.applovin.impl.sdk.utils.b.a
                                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                    public void onActivityCreated(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                                        maxDebuggerTestLiveNetworkActivity.initialize(a.this.anY.wk(), a.this.anY.wl(), a.this.anY.getSdk());
                                    }
                                });
                                return;
                            }
                        }
                        u.a("Complete Integrations", "Please complete integrations in order to access this.", a.this);
                        return;
                    }
                    if (aVar2.wP() == b.a.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                        if (a.this.anY.getSdk().CC().isEnabled()) {
                            if (a.this.anY.wm().size() > 0) {
                                com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerTestModeNetworkActivity.class, aVar, new com.applovin.impl.sdk.utils.b.a<MaxDebuggerTestModeNetworkActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.5
                                    @Override // com.applovin.impl.sdk.utils.b.a
                                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                    public void onActivityCreated(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                                        maxDebuggerTestModeNetworkActivity.initialize(a.this.anY.wm(), a.this.anY.getSdk());
                                    }
                                });
                                return;
                            } else {
                                u.a("Complete Integrations", "Please complete integrations in order to access this.", a.this);
                                return;
                            }
                        }
                        a.this.getSdk().CC().xk();
                        u.a("Restart Required", cVar.vP(), a.this);
                        return;
                    }
                    if (aVar2.wP() == b.a.INITIALIZATION_AD_UNITS.ordinal()) {
                        com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerAdUnitsListActivity.class, aVar, new com.applovin.impl.sdk.utils.b.a<MaxDebuggerAdUnitsListActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.6
                            @Override // com.applovin.impl.sdk.utils.b.a
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onActivityCreated(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                maxDebuggerAdUnitsListActivity.initialize(a.this.anY.wi(), true, a.this.anY.getSdk());
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((iWO == b.e.INCOMPLETE_NETWORKS.ordinal() || iWO == b.e.COMPLETED_NETWORKS.ordinal()) && (cVar instanceof com.applovin.impl.mediation.debugger.ui.b.a.a)) {
                    com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerDetailActivity.class, aVar, new com.applovin.impl.sdk.utils.b.a<MaxDebuggerDetailActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.7
                        @Override // com.applovin.impl.sdk.utils.b.a
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onActivityCreated(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                            maxDebuggerDetailActivity.initialize(((com.applovin.impl.mediation.debugger.ui.b.a.a) cVar).wz());
                        }
                    });
                }
            }
        });
    }

    private void wd() {
        String strWn = this.anY.wn();
        if (TextUtils.isEmpty(strWn)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", strWn);
        intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
        intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
        startActivity(Intent.createChooser(intent, null));
    }

    private void we() {
        wf();
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a(this, 50, android.R.attr.progressBarStyleLarge);
        this.aqJ = aVar;
        aVar.setColor(-3355444);
        this.akw.addView(this.aqJ, new FrameLayout.LayoutParams(-1, -1, 17));
        this.akw.bringChildToFront(this.aqJ);
        this.aqJ.qN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf() {
        com.applovin.impl.adview.a aVar = this.aqJ;
        if (aVar != null) {
            aVar.qO();
            this.akw.removeView(this.aqJ);
            this.aqJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final Context context) {
        if (!StringUtils.isValidString(this.anY.vP()) || this.anY.wg()) {
            return;
        }
        this.anY.az(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.debugger.ui.b.-$$Lambda$a$qh9kVzSmNAcPpCzTQ-H2kOfVxBk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.x(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Context context) {
        u.a(this.anY.wj(), this.anY.vP(), context);
    }
}

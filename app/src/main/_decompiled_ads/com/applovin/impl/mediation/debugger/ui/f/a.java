package com.applovin.impl.mediation.debugger.ui.f;

import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private ListView akx;
    private List<c> aqk;
    private List<c> aql;
    private d aqt;
    private List<com.applovin.impl.mediation.debugger.b.a.c> atA;
    private List<com.applovin.impl.mediation.debugger.b.a.c> atz;
    private n sdk;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.f.a$a, reason: collision with other inner class name */
    enum EnumC0132a {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public a() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    public void initialize(List<com.applovin.impl.mediation.debugger.b.a.c> list, List<com.applovin.impl.mediation.debugger.b.a.c> list2, final n nVar) {
        this.sdk = nVar;
        this.atz = list;
        this.atA = list2;
        this.aqk = B(list);
        this.aql = B(list2);
        d dVar = new d(this) { // from class: com.applovin.impl.mediation.debugger.ui.f.a.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected c wZ() {
                return new c.a(c.b.SECTION_CENTERED).bO("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").wW();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int tM() {
                return EnumC0132a.COUNT.ordinal();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int gg(int i) {
                return i == EnumC0132a.BIDDERS.ordinal() ? a.this.aqk.size() : a.this.aql.size();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected c gh(int i) {
                if (i == EnumC0132a.BIDDERS.ordinal()) {
                    return new e("BIDDERS");
                }
                return new e("WATERFALL");
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected List<c> gi(int i) {
                return i == EnumC0132a.BIDDERS.ordinal() ? a.this.aqk : a.this.aql;
            }
        };
        this.aqt = dVar;
        dVar.a(new d.a() { // from class: com.applovin.impl.mediation.debugger.ui.f.-$$Lambda$a$HeTdq35R2DK_RiVSmKVJc9WuhrY
            @Override // com.applovin.impl.mediation.debugger.ui.d.d.a
            public final void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                this.f$0.a(nVar, aVar, cVar);
            }
        });
        this.aqt.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(n nVar, com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
        List<String> listUO = b(aVar).uO();
        if (listUO.equals(nVar.CC().xj())) {
            nVar.CC().C(null);
        } else {
            nVar.CC().C(listUO);
        }
        this.aqt.notifyDataSetChanged();
    }

    private List<c> B(List<com.applovin.impl.mediation.debugger.b.a.c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final com.applovin.impl.mediation.debugger.b.a.c cVar : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(cVar.uP(), this) { // from class: com.applovin.impl.mediation.debugger.ui.f.a.2
                @Override // com.applovin.impl.mediation.debugger.ui.d.c
                public SpannedString wT() {
                    return StringUtils.createSpannedString(cVar.getDisplayName(), isEnabled() ? -16777216 : -7829368, 18, 1);
                }

                @Override // com.applovin.impl.mediation.debugger.ui.b.a.a, com.applovin.impl.mediation.debugger.ui.d.c
                public int tO() {
                    if (a.this.sdk.CC().xj() == null || !a.this.sdk.CC().xj().equals(cVar.uO())) {
                        return 0;
                    }
                    return R.drawable.applovin_ic_check_mark_borderless;
                }

                @Override // com.applovin.impl.mediation.debugger.ui.b.a.a, com.applovin.impl.mediation.debugger.ui.d.c
                public int tP() {
                    if (a.this.sdk.CC().xj() == null || !a.this.sdk.CC().xj().equals(cVar.uO())) {
                        return super.tP();
                    }
                    return -16776961;
                }
            });
        }
        return arrayList;
    }

    private com.applovin.impl.mediation.debugger.b.a.c b(com.applovin.impl.mediation.debugger.ui.d.a aVar) {
        if (aVar.wO() == EnumC0132a.BIDDERS.ordinal()) {
            return this.atz.get(aVar.wP());
        }
        return this.atA.get(aVar.wP());
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter((ListAdapter) this.aqt);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        return this.sdk;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.aqk = B(this.atz);
        this.aql = B(this.atA);
        this.aqt.wY();
    }
}

package com.applovin.impl.mediation.debugger.ui.a;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.applovin.impl.mediation.debugger.ui.a {
    private String aqF;
    private com.applovin.impl.mediation.debugger.ui.d.d aqt;
    private n sdk;

    public void initialize(String str, List<String> list, n nVar) {
        this.aqF = str;
        this.sdk = nVar;
        final List<com.applovin.impl.mediation.debugger.ui.d.c> listS = s(list);
        com.applovin.impl.mediation.debugger.ui.d.d dVar = new com.applovin.impl.mediation.debugger.ui.d.d(this) { // from class: com.applovin.impl.mediation.debugger.ui.a.f.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int tM() {
                return 1;
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int gg(int i) {
                return listS.size();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                return new com.applovin.impl.mediation.debugger.ui.d.e("KEYWORDS");
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                return listS;
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
        setTitle(this.aqF);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.aqt);
        listView.setDividerHeight(0);
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> s(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.DETAIL).bO(it.next().replace("1:", "+").replace("0:", "-")).wW());
        }
        return arrayList;
    }
}

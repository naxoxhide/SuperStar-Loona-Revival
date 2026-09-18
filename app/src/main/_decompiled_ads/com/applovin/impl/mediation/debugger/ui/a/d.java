package com.applovin.impl.mediation.debugger.ui.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerAdUnitWaterfallsListActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.applovin.impl.mediation.debugger.ui.a {
    private ListView akx;
    private boolean aqA;
    private com.applovin.impl.mediation.debugger.ui.d.d aqt;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> aqz;
    private n sdk;

    public void initialize(final List<com.applovin.impl.mediation.debugger.b.a.a> list, boolean z, final n nVar) {
        this.aqA = z;
        this.sdk = nVar;
        this.aqz = r(list);
        com.applovin.impl.mediation.debugger.ui.d.d dVar = new com.applovin.impl.mediation.debugger.ui.d.d(this) { // from class: com.applovin.impl.mediation.debugger.ui.a.d.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int tM() {
                return 1;
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected int gg(int i) {
                return list.size();
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
                return new com.applovin.impl.mediation.debugger.ui.d.e("");
            }

            @Override // com.applovin.impl.mediation.debugger.ui.d.d
            protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
                return d.this.aqz;
            }
        };
        this.aqt = dVar;
        dVar.a(new com.applovin.impl.mediation.debugger.ui.d.d.a() { // from class: com.applovin.impl.mediation.debugger.ui.a.-$$Lambda$d$6Z-vgxotI-3O-H-hwVKIs9dHiw0
            @Override // com.applovin.impl.mediation.debugger.ui.d.d.a
            public final void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
                this.f$0.a(list, nVar, aVar, cVar);
            }
        });
        this.aqt.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, final n nVar, com.applovin.impl.mediation.debugger.ui.d.a aVar, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
        final com.applovin.impl.mediation.debugger.b.a.a aVar2 = (com.applovin.impl.mediation.debugger.b.a.a) list.get(aVar.wP());
        if (aVar2.uH().size() == 1) {
            com.applovin.impl.sdk.utils.b.a(this, MaxDebuggerAdUnitDetailActivity.class, nVar.BK(), new com.applovin.impl.sdk.utils.b.a() { // from class: com.applovin.impl.mediation.debugger.ui.a.-$$Lambda$d$kX0X1pMyjsi0tv1r17RlirLgUp8
                @Override // com.applovin.impl.sdk.utils.b.a
                public final void onActivityCreated(Activity activity) {
                    ((MaxDebuggerAdUnitDetailActivity) activity).initialize(aVar2, null, null, nVar);
                }
            });
        } else {
            com.applovin.impl.sdk.utils.b.a(this, MaxDebuggerAdUnitWaterfallsListActivity.class, nVar.BK(), new com.applovin.impl.sdk.utils.b.a() { // from class: com.applovin.impl.mediation.debugger.ui.a.-$$Lambda$d$CotIFG4u6UnETX7MvDKNhr9hpU8
                @Override // com.applovin.impl.sdk.utils.b.a
                public final void onActivityCreated(Activity activity) {
                    ((MaxDebuggerAdUnitWaterfallsListActivity) activity).initialize(aVar2, nVar);
                }
            });
        }
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        return this.sdk;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle((this.aqA ? "Selective Init " : "") + "Ad Units");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter((ListAdapter) this.aqt);
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> r(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.mediation.debugger.b.a.a aVar : list) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(aVar.mQ(), -16777216));
            spannableStringBuilder.append((CharSequence) new SpannedString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(aVar.tG(), -16777216));
            arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.DETAIL).a(StringUtils.createSpannedString(aVar.getName(), -16777216, 18, 1)).b(new SpannedString(spannableStringBuilder)).y(this).aF(true).wW());
        }
        return arrayList;
    }
}

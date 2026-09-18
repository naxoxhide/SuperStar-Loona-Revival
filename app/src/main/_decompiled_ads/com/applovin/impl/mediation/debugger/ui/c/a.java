package com.applovin.impl.mediation.debugger.ui.c;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.mediation.debugger.ui.a {
    private ListView akx;
    private b arV;

    public a() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    public void initialize(final com.applovin.impl.mediation.debugger.b.c.b bVar) {
        setTitle(bVar.getDisplayName());
        b bVar2 = new b(bVar, this);
        this.arV = bVar2;
        bVar2.a(new d.a() { // from class: com.applovin.impl.mediation.debugger.ui.c.a.1
            @Override // com.applovin.impl.mediation.debugger.ui.d.d.a
            public void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                if (aVar.wO() == b.a.TEST_ADS.ordinal()) {
                    n sdk = bVar.getSdk();
                    com.applovin.impl.mediation.debugger.b.c.b.EnumC0123b enumC0123bVn = bVar.vn();
                    if (a.this.arV.a(aVar)) {
                        if (com.applovin.impl.mediation.debugger.b.c.b.EnumC0123b.READY == enumC0123bVn) {
                            com.applovin.impl.sdk.utils.b.a(a.this, MaxDebuggerMultiAdActivity.class, sdk.BK(), new com.applovin.impl.sdk.utils.b.a<MaxDebuggerMultiAdActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.c.a.1.1
                                @Override // com.applovin.impl.sdk.utils.b.a
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public void onActivityCreated(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                                    maxDebuggerMultiAdActivity.initialize(bVar);
                                }
                            });
                            return;
                        } else if (com.applovin.impl.mediation.debugger.b.c.b.EnumC0123b.DISABLED == enumC0123bVn) {
                            sdk.CC().xk();
                            u.a(cVar.wj(), cVar.vP(), a.this);
                            return;
                        } else {
                            u.a(cVar.wj(), cVar.vP(), a.this);
                            return;
                        }
                    }
                    u.a(cVar.wj(), cVar.vP(), a.this);
                    return;
                }
                u.a(cVar.wj(), cVar.vP(), a.this);
            }
        });
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.akx = listView;
        listView.setAdapter((ListAdapter) this.arV);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        b bVar = this.arV;
        if (bVar != null) {
            return bVar.wz().getSdk();
        }
        return null;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.arV.wz().vt().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.arV.wH();
            this.arV.wY();
        }
    }
}

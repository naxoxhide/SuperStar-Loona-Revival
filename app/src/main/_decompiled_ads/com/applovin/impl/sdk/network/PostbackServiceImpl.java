package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.EventServiceImpl;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PostbackServiceImpl implements AppLovinPostbackService {
    private final n sdk;

    public String toString() {
        return "PostbackService{}";
    }

    public PostbackServiceImpl(n nVar) {
        this.sdk = nVar;
    }

    @Override // com.applovin.sdk.AppLovinPostbackService
    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(i.E(this.sdk).da(str).aS(false).Ie(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(iVar, q.b.POSTBACKS, appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(i iVar, q.b bVar, AppLovinPostbackListener appLovinPostbackListener) {
        j jVar = new j(iVar, bVar, this.sdk, appLovinPostbackListener);
        jVar.bf(a(iVar));
        this.sdk.BM().a(jVar, bVar);
    }

    private boolean a(i iVar) {
        Map<String, String> mapHP = iVar.HP();
        if (mapHP == null) {
            return false;
        }
        String str = mapHP.get("event");
        if ("postinstall".equals(str)) {
            str = mapHP.get("sub_event");
        }
        return EventServiceImpl.ALLOW_PRE_INIT_EVENT_TYPES.contains(str);
    }
}

package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

/* JADX INFO: loaded from: classes4.dex */
public class SplashResData extends BaseRespData {
    private a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EAction f1994b;

    public a getBaseViewData() {
        return this.a;
    }

    public void setBaseViewData(a aVar) {
        this.a = aVar;
    }

    public EAction geteAction() {
        return this.f1994b;
    }

    public void seteAction(EAction eAction) {
        this.f1994b = eAction;
    }
}

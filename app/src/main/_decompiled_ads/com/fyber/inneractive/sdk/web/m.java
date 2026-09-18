package com.fyber.inneractive.sdk.web;

import android.window.OnBackInvokedCallback;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class m implements OnBackInvokedCallback {
    public final /* synthetic */ i a;

    public m(i iVar) {
        this.a = iVar;
    }

    @Override // android.window.OnBackInvokedCallback
    public void onBackInvoked() {
        i iVar = this.a;
        if (iVar.o()) {
            IAlog.d("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
            iVar.r();
        }
    }
}

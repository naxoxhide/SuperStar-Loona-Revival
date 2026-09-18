package com.tapjoy.internal;

import android.app.Activity;
import android.content.Intent;
import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJCorePlacement;
import com.tapjoy.TJMemoryDataStorage;

/* JADX INFO: loaded from: classes4.dex */
public final class o8 {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJCorePlacement f2792b;

    public o8(TJCorePlacement tJCorePlacement, String str) {
        this.f2792b = tJCorePlacement;
        this.a = str;
    }

    public final void a(Activity activity, String str, String str2) {
        if (str2 == null) {
            this.f2792b.d.setRedirectURL(str);
        } else {
            this.f2792b.d.setBaseURL(str);
            this.f2792b.d.setHttpResponse(str2);
        }
        this.f2792b.d.setHasProgressSpinner(true);
        this.f2792b.d.setContentViewId(this.a);
        TJMemoryDataStorage.getInstance().put(this.f2792b.d.getPlacementName(), this.f2792b.d);
        Intent intent = new Intent(this.f2792b.f2688b, (Class<?>) TJAdUnitActivity.class);
        intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_NAME, this.f2792b.d.getPlacementName());
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }
}

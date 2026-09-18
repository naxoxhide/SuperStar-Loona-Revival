package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ls, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1090Ls extends LinearLayout {
    public static int A00 = (int) (C1066Ku.A02 * 56.0f);

    public abstract void A04();

    public abstract void A05();

    public abstract void A06(C1M c1m, boolean z);

    public abstract boolean A07();

    public abstract View getDetailsContainer();

    public abstract int getToolbarActionMode();

    public abstract int getToolbarHeight();

    public abstract InterfaceC1089Lr getToolbarListener();

    public abstract void setAdReportingVisible(boolean z);

    public abstract void setCTAClickListener(View.OnClickListener onClickListener);

    public abstract void setCTAClickListener(T3 t3);

    public abstract void setFullscreen(boolean z);

    public abstract void setPageDetails(C1X c1x, String str, int i, C05971d c05971d);

    public abstract void setPageDetailsVisible(boolean z);

    public abstract void setProgress(float f);

    public abstract void setProgressClickListener(View.OnClickListener onClickListener);

    public abstract void setProgressImage(EnumC1075Ld enumC1075Ld);

    public abstract void setProgressImmediate(float f);

    public abstract void setProgressSpinnerInvisible(boolean z);

    public abstract void setToolbarActionMessage(String str);

    public abstract void setToolbarActionMode(int i);

    public abstract void setToolbarListener(InterfaceC1089Lr interfaceC1089Lr);

    public AbstractC1090Ls(Context context) {
        super(context);
    }
}

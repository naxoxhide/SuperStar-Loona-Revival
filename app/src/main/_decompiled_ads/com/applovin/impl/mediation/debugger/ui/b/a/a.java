package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.R;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    private final Context E;
    private final com.applovin.impl.mediation.debugger.b.c.b arS;

    public a(com.applovin.impl.mediation.debugger.b.c.b bVar, Context context) {
        super(c.b.DETAIL);
        this.arS = bVar;
        this.E = context;
        this.ass = wB();
        this.ast = wC();
    }

    public com.applovin.impl.mediation.debugger.b.c.b wz() {
        return this.arS;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.c
    public boolean isEnabled() {
        return this.arS.vl() != com.applovin.impl.mediation.debugger.b.c.b.a.MISSING;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.c
    public int wA() {
        int iVx = this.arS.vx();
        return iVx > 0 ? iVx : R.drawable.applovin_ic_mediation_placeholder;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.c
    public int tO() {
        return isEnabled() ? R.drawable.applovin_ic_disclosure_arrow : super.wA();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.c
    public int tP() {
        return g.a(R.color.applovin_sdk_disclosureButtonColor, this.E);
    }

    private SpannedString wB() {
        return StringUtils.createSpannedString(this.arS.getDisplayName(), isEnabled() ? -16777216 : -7829368, 18, 1);
    }

    private SpannedString wC() {
        if (!isEnabled()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) wD());
        spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
        spannableStringBuilder.append((CharSequence) wE());
        if (this.arS.vl() == com.applovin.impl.mediation.debugger.b.c.b.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Invalid Integration", SupportMenu.CATEGORY_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString wD() {
        if (this.arS.vo()) {
            if (TextUtils.isEmpty(this.arS.getSdkVersion())) {
                return StringUtils.createListItemDetailSpannedString(this.arS.vp() ? "Retrieving SDK Version..." : "SDK Found", -16777216);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.arS.getSdkVersion(), -16777216));
            return new SpannedString(spannableStringBuilder);
        }
        return StringUtils.createListItemDetailSpannedString("SDK Missing", SupportMenu.CATEGORY_MASK);
    }

    private SpannedString wE() {
        if (this.arS.vp()) {
            if (!TextUtils.isEmpty(this.arS.getAdapterVersion())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
                spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.arS.getAdapterVersion(), -16777216));
                if (this.arS.vq()) {
                    spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(255, WorkQueueKt.MASK, 0)));
                    spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.arS.vs(), -16777216));
                }
                return new SpannedString(spannableStringBuilder);
            }
            return StringUtils.createListItemDetailSpannedString("Adapter Found", -16777216);
        }
        return StringUtils.createListItemDetailSpannedString("Adapter Missing", SupportMenu.CATEGORY_MASK);
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + ((Object) this.ass) + ", detailText=" + ((Object) this.ast) + ", network=" + this.arS + "}";
    }
}

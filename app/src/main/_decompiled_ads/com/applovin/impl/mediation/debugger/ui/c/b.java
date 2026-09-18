package com.applovin.impl.mediation.debugger.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    private final com.applovin.impl.mediation.debugger.b.c.b arS;
    private List<c> arZ;
    private final List<c> asa;
    private final List<c> asb;
    private final List<c> asc;
    private final List<c> asd;
    private SpannedString ase;

    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }

    b(com.applovin.impl.mediation.debugger.b.c.b bVar, Context context) {
        super(context);
        this.arS = bVar;
        if (bVar.vl() == com.applovin.impl.mediation.debugger.b.c.b.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.ase = new SpannedString(spannableString);
        } else {
            this.ase = new SpannedString("");
        }
        this.arZ = wI();
        this.asa = x(bVar.vB());
        this.asb = wM();
        this.asc = y(bVar.vC());
        this.asd = wN();
        notifyDataSetChanged();
    }

    public com.applovin.impl.mediation.debugger.b.c.b wz() {
        return this.arS;
    }

    public void wH() {
        this.arZ = wI();
    }

    public boolean a(com.applovin.impl.mediation.debugger.ui.d.a aVar) {
        return aVar.wO() == a.TEST_ADS.ordinal() && aVar.wP() == this.asd.size() - 1;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected int tM() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected int gg(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return this.arZ.size();
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return this.asa.size();
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return this.asb.size();
        }
        if (i == a.DEPENDENCIES.ordinal()) {
            return this.asc.size();
        }
        return this.asd.size();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected c gh(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return new e("INTEGRATIONS");
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return new e("PERMISSIONS");
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return new e("CONFIGURATION");
        }
        if (i == a.DEPENDENCIES.ordinal()) {
            return new e("DEPENDENCIES");
        }
        return new e("TEST ADS");
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected List<c> gi(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return this.arZ;
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return this.asa;
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return this.asb;
        }
        if (i == a.DEPENDENCIES.ordinal()) {
            return this.asc;
        }
        return this.asd;
    }

    private List<c> wI() {
        ArrayList arrayList = new ArrayList(3);
        CollectionUtils.addObjectIfExists(wJ(), arrayList);
        CollectionUtils.addObjectIfExists(wK(), arrayList);
        CollectionUtils.addObjectIfExists(wL(), arrayList);
        return arrayList;
    }

    private c wJ() {
        c.a aVarBP = c.wV().bO("SDK").bP(this.arS.getSdkVersion());
        if (TextUtils.isEmpty(this.arS.getSdkVersion())) {
            aVarBP.gk(aB(this.arS.vo())).gn(aD(this.arS.vo()));
        }
        return aVarBP.wW();
    }

    private c wK() {
        c.a aVarBP = c.wV().bO("Adapter").bP(this.arS.getAdapterVersion());
        if (TextUtils.isEmpty(this.arS.getAdapterVersion())) {
            aVarBP.gk(aB(this.arS.vp())).gn(aD(this.arS.vp()));
        }
        return aVarBP.wW();
    }

    private c wL() {
        if (this.arS.vE()) {
            return null;
        }
        return c.wV().bO("Initialization Status").bP(gj(this.arS.vm())).aF(false).wW();
    }

    private List<c> x(List<com.applovin.impl.mediation.debugger.b.c.c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.c.c cVar : list) {
                arrayList.add(a(cVar.getName(), cVar.vj(), cVar.vk(), true));
            }
        }
        return arrayList;
    }

    private List<c> wM() {
        ArrayList arrayList = new ArrayList(1);
        if (this.arS.vD()) {
            arrayList.add(a("Java 8", "For optimal performance, please enable Java 8 support. See: https://dash.applovin.com/documentation/mediation/android/getting-started/integration", n.CF(), true));
        }
        return arrayList;
    }

    private List<c> y(List<com.applovin.impl.mediation.debugger.b.c.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.c.a aVar : list) {
                arrayList.add(a(aVar.getName(), aVar.vj(), aVar.vk(), true));
            }
        }
        return arrayList;
    }

    private List<c> wN() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.arS.vG())) {
            arrayList.add(c.a(c.b.DETAIL).bO(this.arS.vG()).wW());
        }
        if (this.arS.vn() == com.applovin.impl.mediation.debugger.b.c.b.EnumC0123b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.arS.vw() != null) {
            arrayList.add(z(this.arS.vw()));
        }
        if (this.arS.vH()) {
            arrayList.add(a("Not an Age Restricted User", "Test mode requires Age Restricted User (COPPA) to be set to false.", !AppLovinPrivacySettings.isAgeRestrictedUser(this.E) && AppLovinPrivacySettings.isAgeRestrictedUserSet(this.E), false));
        }
        arrayList.add(a(this.arS.vn()));
        return arrayList;
    }

    private c z(List<String> list) {
        return c.wV().bO("Region/VPN Required").bP(CollectionUtils.implode(list, ", ", list.size())).wW();
    }

    private c a(com.applovin.impl.mediation.debugger.b.c.b.EnumC0123b enumC0123b) {
        c.a aVarWV = c.wV();
        if (enumC0123b == com.applovin.impl.mediation.debugger.b.c.b.EnumC0123b.READY) {
            aVarWV.y(this.E);
        }
        return aVarWV.bO("Test Mode").bP(enumC0123b.vN()).gm(enumC0123b.vO()).bQ("Restart Required").bR(enumC0123b.vP()).aF(true).wW();
    }

    private c a(String str, String str2, boolean z, boolean z2) {
        return c.a(z ? c.b.RIGHT_DETAIL : c.b.DETAIL).bO(str).b(z ? null : this.ase).bQ("Instructions").bR(str2).gk(z ? R.drawable.applovin_ic_check_mark_bordered : aC(z2)).gn(z ? g.a(R.color.applovin_sdk_checkmarkColor, this.E) : aE(z2)).aF(!z).wW();
    }

    private int aB(boolean z) {
        return z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }

    private int aC(boolean z) {
        return z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private int aD(boolean z) {
        return g.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E);
    }

    private int aE(boolean z) {
        return g.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.E);
    }

    private String gj(int i) {
        if (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i) {
            return "Initialized";
        }
        if (MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i) {
            return ADXLogUtil.EVENT_LOAD_FAILURE;
        }
        return MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i ? "Initializing..." : "Not Initialized";
    }
}

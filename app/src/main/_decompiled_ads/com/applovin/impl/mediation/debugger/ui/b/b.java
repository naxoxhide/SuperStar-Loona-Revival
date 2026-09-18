package com.applovin.impl.mediation.debugger.ui.b;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.d.c$$ExternalSynthetic0;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.applovin.impl.mediation.debugger.ui.d.d implements AppLovinCommunicatorSubscriber, com.applovin.impl.mediation.debugger.a.InterfaceC0121a {
    private final AtomicBoolean akD;
    private String apI;
    private List<com.applovin.impl.mediation.debugger.b.a.a> aqN;
    private List<com.applovin.impl.mediation.debugger.b.a.a> aqO;
    private List<com.applovin.impl.mediation.debugger.b.b.b> aqP;
    private String aqQ;
    private String aqR;
    private Boolean aqS;
    private boolean aqT;
    private final StringBuilder aqU;
    private boolean aqV;
    private List<com.applovin.impl.mediation.debugger.b.c.b> aqW;
    private List<com.applovin.impl.mediation.debugger.b.c.b> aqX;
    private List<com.applovin.impl.mediation.debugger.b.c.b> aqY;
    private List<com.applovin.impl.mediation.debugger.b.a.c> aqZ;
    private List<com.applovin.impl.mediation.debugger.b.a.c> ara;
    private List<com.applovin.impl.mediation.debugger.b.c.b> arb;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arc;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> ard;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> are;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arf;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arg;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arh;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> ari;
    private n sdk;

    public enum a {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        SELECT_TEST_MODE_NETWORKS,
        INITIALIZATION_AD_UNITS,
        COUNT
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.b.b$b, reason: collision with other inner class name */
    private enum EnumC0127b {
        SUCCESS,
        WARNING,
        ERROR
    }

    public enum c {
        SDK_VERSION,
        PLUGIN_VERSION,
        AD_REVIEW_VERSION,
        CONSENT_FLOW_TYPE,
        GOOGLE_UMP_SDK,
        PRIVACY_POLICY_URL,
        TERMS_OF_SERVICE_URL,
        APP_ADS_TXT
    }

    public enum d {
        CMP,
        NETWORK_CONSENT_STATUSES,
        IS_AGE_RESTRICTED_USER,
        DO_NOT_SELL,
        COUNT
    }

    public enum e {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public b(Context context) {
        super(context);
        this.aqU = new StringBuilder("");
        this.akD = new AtomicBoolean();
        this.aqV = false;
        this.aqW = new ArrayList();
        this.aqX = new ArrayList();
        this.aqY = new ArrayList();
        this.aqZ = new ArrayList();
        this.ara = new ArrayList();
        this.arb = new ArrayList();
        this.arc = new ArrayList();
        this.ard = new ArrayList();
        this.are = new ArrayList();
        this.arf = new ArrayList();
        this.arg = new ArrayList();
        this.arh = new ArrayList();
        this.ari = new ArrayList();
    }

    public boolean isInitialized() {
        return this.akD.get();
    }

    public boolean wg() {
        return this.aqV;
    }

    public void az(boolean z) {
        this.aqV = z;
    }

    public n getSdk() {
        return this.sdk;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.a> wh() {
        return this.aqN;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.a> wi() {
        return this.aqO;
    }

    public String wj() {
        return this.aqQ;
    }

    public String vP() {
        return this.apI;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.c> wk() {
        return this.aqZ;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.c> wl() {
        return this.ara;
    }

    public List<com.applovin.impl.mediation.debugger.b.c.b> wm() {
        return this.arb;
    }

    public String wn() {
        return this.aqU.toString();
    }

    public void a(List<com.applovin.impl.mediation.debugger.b.c.b> list, List<com.applovin.impl.mediation.debugger.b.a.a> list2, List<com.applovin.impl.mediation.debugger.b.a.a> list3, List<com.applovin.impl.mediation.debugger.b.b.b> list4, String str, String str2, String str3, Boolean bool, boolean z, n nVar) {
        this.sdk = nVar;
        this.aqN = list2;
        this.aqO = list3;
        this.aqP = list4;
        this.aqQ = str;
        this.apI = str2;
        this.aqR = str3;
        this.aqS = bool;
        this.aqT = z;
        if (list != null && this.akD.compareAndSet(false, true)) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().f("MediationDebuggerListAdapter", "Populating networks...");
            }
            nVar.Ck().F(list);
            t(list);
            u(list2);
            v(this.aqX);
            this.arc.addAll(wp());
            this.ard.addAll(wq());
            this.are.addAll(wr());
            this.arf.addAll(ws());
            this.arg = w(this.aqW);
            this.arh = w(this.aqX);
            this.ari = w(this.aqY);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            arrayList.add("live_networks_updated");
            arrayList.add("test_mode_networks_updated");
            AppLovinCommunicator.getInstance(this.E).subscribe(this, arrayList);
            wo();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.debugger.ui.b.-$$Lambda$8I12hK5yAJQycBeGLZVBXFHLeRA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected int tM() {
        return e.COUNT.ordinal();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected int gg(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return this.arc.size();
        }
        if (i == e.MAX.ordinal()) {
            return this.ard.size();
        }
        if (i == e.PRIVACY.ordinal()) {
            return this.are.size();
        }
        if (i == e.ADS.ordinal()) {
            return this.arf.size();
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return this.arg.size();
        }
        if (i == e.COMPLETED_NETWORKS.ordinal()) {
            return this.arh.size();
        }
        return this.ari.size();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("APP INFO");
        }
        if (i == e.MAX.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("MAX");
        }
        if (i == e.PRIVACY.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("PRIVACY");
        }
        if (i == e.ADS.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("ADS");
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("INCOMPLETE SDK INTEGRATIONS");
        }
        if (i == e.COMPLETED_NETWORKS.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("COMPLETED SDK INTEGRATIONS");
        }
        return new com.applovin.impl.mediation.debugger.ui.d.e("MISSING SDK INTEGRATIONS");
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return this.arc;
        }
        if (i == e.MAX.ordinal()) {
            return this.ard;
        }
        if (i == e.PRIVACY.ordinal()) {
            return this.are;
        }
        if (i == e.ADS.ordinal()) {
            return this.arf;
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return this.arg;
        }
        if (i == e.COMPLETED_NETWORKS.ordinal()) {
            return this.arh;
        }
        return this.ari;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.are = wr();
            wY();
            return;
        }
        if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.arg = w(this.aqW);
            this.arh = w(this.aqX);
            wY();
        } else if ("live_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.arf = v(b((List<String>) appLovinCommunicatorMessage.getMessageData().getStringArrayList("live_networks"), true), null);
            wY();
        } else if ("test_mode_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.arf = v(null, b((List<String>) appLovinCommunicatorMessage.getMessageData().getStringArrayList("test_mode_networks"), false));
            wY();
        }
    }

    @Override // com.applovin.impl.mediation.debugger.a.InterfaceC0121a
    public void a(com.applovin.impl.mediation.debugger.b.b.a aVar, String str) {
        com.applovin.impl.mediation.debugger.b.b.b bVar;
        String strA;
        EnumC0127b enumC0127bB;
        ArrayList arrayList = new ArrayList();
        for (com.applovin.impl.mediation.debugger.b.b.b bVar2 : this.aqP) {
            List<com.applovin.impl.mediation.debugger.b.b.b> list = aVar.va().get(bVar2.vd());
            if (list == null || !list.contains(bVar2)) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().i("MediationDebuggerListAdapter", str + " is missing a required entry: " + bVar2.vg());
                }
                arrayList.add(bVar2);
            }
        }
        if (arrayList.isEmpty()) {
            strA = "All required entries found at " + str + ".";
            enumC0127bB = EnumC0127b.SUCCESS;
        } else {
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = (com.applovin.impl.mediation.debugger.b.b.b) it.next();
            } while (!bVar.vc());
            if (bVar != null) {
                strA = a(com.applovin.impl.mediation.debugger.a.b.MISSING_APPLOVIN_ENTRIES, str, bVar.vg());
                enumC0127bB = b(com.applovin.impl.mediation.debugger.a.b.MISSING_APPLOVIN_ENTRIES);
            } else {
                strA = a(com.applovin.impl.mediation.debugger.a.b.MISSING_NON_APPLOVIN_ENTRIES, str, null);
                enumC0127bB = b(com.applovin.impl.mediation.debugger.a.b.MISSING_NON_APPLOVIN_ENTRIES);
            }
        }
        this.ard.add(a(strA, enumC0127bB));
        wY();
    }

    @Override // com.applovin.impl.mediation.debugger.a.InterfaceC0121a
    public void b(com.applovin.impl.mediation.debugger.a.b bVar, String str) {
        if (bVar == com.applovin.impl.mediation.debugger.a.b.DEVELOPER_URI_NOT_FOUND) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("MediationDebuggerListAdapter", "Developer URI was not found; app-ads.txt row will not show on the mediation debugger");
                return;
            }
            return;
        }
        this.ard.add(a(a(bVar, str, null), b(bVar)));
        wY();
    }

    private void wo() {
        Map<String, String> mapA;
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + u.b(this.E, this.sdk));
        sb.append("\nTest Mode - " + (this.sdk.CC().isEnabled() ? "enabled" : "disabled"));
        if (this.sdk.BT() != null) {
            sb.append("\nTarget SDK - " + this.sdk.BS().Eg().Ep());
        } else {
            sb.append("\nTarget SDK - " + this.sdk.BQ().CY().get("target_sdk"));
        }
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOy);
        String version = f.getVersion();
        sb.append("\nSDK Version - " + str);
        StringBuilder sbAppend = new StringBuilder().append("\nPlugin Version - ");
        if (!StringUtils.isValidString(str2)) {
            str2 = "None";
        }
        sb.append(sbAppend.append(str2).toString());
        StringBuilder sbAppend2 = new StringBuilder().append("\nAd Review Version - ");
        if (!StringUtils.isValidString(version)) {
            version = "Disabled";
        }
        sb.append(sbAppend2.append(version).toString());
        if (this.sdk.Bq() && (mapA = u.a(this.sdk.getSettings())) != null) {
            String str3 = mapA.get("UnityVersion");
            sb.append("\nUnity Version - " + (StringUtils.isValidString(str3) ? str3 : "None"));
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(com.applovin.impl.privacy.a.A(this.E));
        sb.append(this.sdk.Cj().uI());
        sb.append("\n========== CMP (CONSENT MANAGEMENT PLATFORM) ==========");
        sb.append(this.sdk.Ck().uI());
        sb.append("\n========== NETWORK CONSENT STATUSES ==========");
        Iterator<com.applovin.impl.privacy.b.c> it = this.sdk.Ck().As().iterator();
        while (it.hasNext()) {
            sb.append(it.next().uI());
        }
        sb.append("\n========== NETWORKS ==========");
        Iterator<com.applovin.impl.mediation.debugger.b.c.b> it2 = this.aqX.iterator();
        while (it2.hasNext()) {
            a(sb, it2.next().vI());
        }
        Iterator<com.applovin.impl.mediation.debugger.b.c.b> it3 = this.aqW.iterator();
        while (it3.hasNext()) {
            a(sb, it3.next().vI());
        }
        sb.append("\n========== AD UNITS ==========");
        Iterator<com.applovin.impl.mediation.debugger.b.a.a> it4 = this.aqN.iterator();
        while (it4.hasNext()) {
            a(sb, it4.next().uI());
        }
        sb.append("\n========== END ==========");
        x.D("MediationDebuggerListAdapter", sb.toString());
        this.aqU.append(sb.toString());
    }

    private void a(StringBuilder sb, String str) {
        String string = sb.toString();
        if (string.length() + str.length() >= ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aKu)).intValue()) {
            x.D("MediationDebuggerListAdapter", string);
            this.aqU.append(string);
            sb.setLength(1);
        }
        sb.append(str);
    }

    private void t(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        for (com.applovin.impl.mediation.debugger.b.c.b bVar : list) {
            if (!bVar.vr()) {
                if (bVar.vl() == com.applovin.impl.mediation.debugger.b.c.b.a.INCOMPLETE_INTEGRATION || bVar.vl() == com.applovin.impl.mediation.debugger.b.c.b.a.INVALID_INTEGRATION) {
                    this.aqW.add(bVar);
                } else if (bVar.vl() == com.applovin.impl.mediation.debugger.b.c.b.a.COMPLETE) {
                    this.aqX.add(bVar);
                } else if (bVar.vl() == com.applovin.impl.mediation.debugger.b.c.b.a.MISSING) {
                    this.aqY.add(bVar);
                }
            }
        }
    }

    private void u(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator<com.applovin.impl.mediation.debugger.b.a.a> it = list.iterator();
        while (it.hasNext()) {
            com.applovin.impl.mediation.debugger.b.a.b bVarUG = it.next().uG();
            Iterator<com.applovin.impl.mediation.debugger.b.a.e> it2 = bVarUG.uL().iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().uR());
            }
            Iterator<com.applovin.impl.mediation.debugger.b.a.e> it3 = bVarUG.uM().iterator();
            while (it3.hasNext()) {
                hashSet2.add(it3.next().uR());
            }
        }
        this.aqZ = new ArrayList(hashSet);
        this.ara = new ArrayList(hashSet2);
        Collections.sort(this.aqZ);
        Collections.sort(this.ara);
    }

    private void v(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        for (com.applovin.impl.mediation.debugger.b.c.b bVar : list) {
            if (bVar.vn() == com.applovin.impl.mediation.debugger.b.c.b.EnumC0123b.READY) {
                this.arb.add(bVar);
            }
        }
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> wp() {
        String str;
        ArrayList arrayList = new ArrayList(7);
        try {
            str = this.E.getPackageManager().getPackageInfo(this.E.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Package Name").bP(this.E.getPackageName()).wW());
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO = com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("App Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(aVarBO.bP(str).wW());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("OS").bP(u.Lz()).wW());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Account").bP(StringUtils.isValidString(this.aqR) ? this.aqR : "None").wW());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Mediation Provider").bP(StringUtils.isValidString(this.sdk.getMediationProvider()) ? this.sdk.getMediationProvider() : "None").wW());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("OM SDK Version").bP(this.sdk.Cn().getSdkVersion()).wW());
        arrayList.add(aA(n.CF()));
        if (this.aqS != null) {
            arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Google Families Policy").bP(String.valueOf(this.aqS)).wW());
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> wq() {
        Map<String, String> mapA;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("SDK Version").bP(AppLovinSdk.VERSION).wW());
        String str = (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOy);
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO = com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Plugin Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(aVarBO.bP(str).wW());
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO2 = com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Ad Review Version");
        String version = f.getVersion();
        if (StringUtils.isValidString(version)) {
            String sdkKey = f.getSdkKey();
            if (!StringUtils.isValidString(sdkKey) || sdkKey.equals(this.sdk.getSdkKey())) {
                aVarBO2.bP(version);
            } else {
                a(aVarBO2, "MAX Ad Review integrated with wrong SDK key. Please check that your " + (this.sdk.Bq() ? "SDK key is downloaded" : "Gradle plugin snippet is integrated") + " from the correct account.");
            }
        } else {
            a(aVarBO2, "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps.");
        }
        arrayList.add(aVarBO2.wW());
        if (this.sdk.Bq() && (mapA = u.a(this.sdk.getSettings())) != null) {
            String str2 = mapA.get("UnityVersion");
            arrayList.add(w("Unity Version", StringUtils.isValidString(str2) ? str2 : "None"));
        }
        if (this.sdk.Cj().isEnabled()) {
            arrayList.add(wt());
            if (this.sdk.Cj().zV() == com.applovin.impl.privacy.a.d.a.UNIFIED) {
                arrayList.add(wu());
            }
            arrayList.add(wv());
            arrayList.add(ww());
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> wr() {
        ArrayList arrayList = new ArrayList(d.COUNT.ordinal());
        arrayList.add(wx());
        if (StringUtils.isValidString(this.sdk.Ck().Aq())) {
            arrayList.add(wy());
        } else {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(com.applovin.impl.privacy.a.zN(), false, this.E));
        }
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(com.applovin.impl.privacy.a.zM(), true, this.E));
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(com.applovin.impl.privacy.a.zO(), true, this.E));
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> ws() {
        boolean zIsEnabled = this.sdk.CC().isEnabled();
        List<String> listXj = this.sdk.CC().xj();
        if (zIsEnabled) {
            return v(null, b(listXj, false));
        }
        return v(b(listXj, true), null);
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> v(String str, String str2) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("View Ad Units (" + this.aqN.size() + ")").y(this.E).aF(true).wW());
        arrayList.add(bM(str));
        arrayList.add(bN(str2));
        if (!this.aqO.isEmpty()) {
            arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Selective Init Ad Units (" + this.aqO.size() + ")").y(this.E).aF(true).wW());
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> w(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<com.applovin.impl.mediation.debugger.b.c.b> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(it.next(), this.E));
        }
        return arrayList;
    }

    private com.applovin.impl.mediation.debugger.ui.d.c w(String str, String str2) {
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO = com.applovin.impl.mediation.debugger.ui.d.c.wV().bO(str);
        if (StringUtils.isValidString(str2)) {
            aVarBO.bP(str2);
        } else {
            aVarBO.gk(R.drawable.applovin_ic_x_mark);
            aVarBO.gn(g.a(R.color.applovin_sdk_xmarkColor, this.E));
        }
        return aVarBO.wW();
    }

    private void a(com.applovin.impl.mediation.debugger.ui.d.c.a aVar, String str) {
        aVar.bQ("MAX Ad Review").bR(str).gk(R.drawable.applovin_ic_x_mark).gn(g.a(R.color.applovin_sdk_xmarkColor, this.E)).aF(true);
    }

    private com.applovin.impl.mediation.debugger.ui.d.c bM(String str) {
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarWV = com.applovin.impl.mediation.debugger.ui.d.c.wV();
        if (!this.sdk.CC().isEnabled()) {
            aVarWV.y(this.E);
        }
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO = aVarWV.bO((StringUtils.isValidString(str) ? "" : "Select ") + "Live Network");
        if (this.sdk.CC().isEnabled()) {
            str = "Enable";
        }
        return aVarBO.bP(str).gm(-16776961).bR("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").aF(true).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c bN(String str) {
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarWV = com.applovin.impl.mediation.debugger.ui.d.c.wV();
        if (this.sdk.CC().isEnabled()) {
            aVarWV.y(this.E);
        }
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO = aVarWV.bO((StringUtils.isValidString(str) ? "" : "Select ") + "Test Mode Network");
        if (!this.sdk.CC().isEnabled()) {
            str = "Enable";
        }
        return aVarBO.bP(str).gm(-16776961).bR("Please re-launch the app to enable test mode. This will allow the selection of test mode networks.").aF(true).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c aA(boolean z) {
        return com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Java 8").gk(z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).gn(g.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E)).bQ("Upgrade to Java 8").bR("For optimal performance, please enable Java 8 support. This will be required in a future SDK release. See: https://dash.applovin.com/documentation/mediation/android/getting-started/integration").aF(!z).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wt() {
        boolean z = this.sdk.Cj().zV() == com.applovin.impl.privacy.a.d.a.TERMS;
        return com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.DETAIL).bO("Flow Type").bP(z ? "MAX Terms Flow" : "MAX Terms and Privacy Policy Flow").gk(z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_check_mark_bordered).gn(g.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_checkmarkColor, this.E)).bQ("MAX Terms Flow").bR("MAX Terms Flow is deprecated and will be removed in a future SDK version. For more details, see:\nhttps://dash.applovin.com/documentation/mediation/android/getting-started/terms-and-privacy-policy-flow").aF(z).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wu() {
        boolean zHasSupportedCmp = this.sdk.Cl().hasSupportedCmp();
        return com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Google UMP SDK").gk(zHasSupportedCmp ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).gn(g.a(zHasSupportedCmp ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E)).bQ("Google UMP SDK").bR("In order to use MAX Terms and Privacy Policy Flow, you must add the Google User Messaging Platform SDK as a dependency. For more details, see:\nhttps://dash.applovin.com/documentation/mediation/android/getting-started/terms-and-privacy-policy-flow\"").aF(!zHasSupportedCmp).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wv() {
        boolean z = this.sdk.Cj().getPrivacyPolicyUri() != null;
        return com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Privacy Policy URL").gk(z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).gn(g.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E)).aF(true).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c ww() {
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarBO = com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Terms of Service URL");
        if (this.sdk.Cj().getTermsOfServiceUri() != null) {
            aVarBO.gk(R.drawable.applovin_ic_check_mark_bordered);
            aVarBO.gn(g.a(R.color.applovin_sdk_checkmarkColor, this.E));
            aVarBO.aF(true);
        } else {
            aVarBO.bP("None");
            aVarBO.aF(false);
        }
        return aVarBO.wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c a(String str, EnumC0127b enumC0127b) {
        int i;
        int iA;
        if (enumC0127b == EnumC0127b.SUCCESS) {
            i = R.drawable.applovin_ic_check_mark_bordered;
            iA = g.a(R.color.applovin_sdk_checkmarkColor, this.E);
        } else if (enumC0127b == EnumC0127b.WARNING) {
            i = R.drawable.applovin_ic_warning;
            iA = g.a(R.color.applovin_sdk_warningColor, this.E);
        } else {
            i = R.drawable.applovin_ic_x_mark;
            iA = g.a(R.color.applovin_sdk_xmarkColor, this.E);
        }
        return com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("app-ads.txt").gk(i).gn(iA).bQ("app-ads.txt").bR(str).aF(true).wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wx() {
        String strAk = this.sdk.Ck().Ak();
        boolean zIsValidString = StringUtils.isValidString(strAk);
        com.applovin.impl.mediation.debugger.ui.d.c.a aVarA = com.applovin.impl.mediation.debugger.ui.d.c.a(com.applovin.impl.mediation.debugger.ui.d.c.b.DETAIL);
        aVarA.bO("CMP (Consent Management Platform)");
        if (!zIsValidString) {
            strAk = "None";
        }
        aVarA.bP(strAk);
        if (this.aqT) {
            aVarA.aF(true);
            if (zIsValidString) {
                aVarA.y(this.E);
            } else {
                Integer numAn = this.sdk.Ck().An();
                String str = "SharedPreferences value for key IABTCF_CmpSdkID is " + numAn + ".";
                if (numAn == null || numAn.intValue() == 0) {
                    aVarA.bR("No CMP found. " + str + "\n\nBy January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                    boolean z = this.sdk.getConfiguration().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
                    aVarA.gk(z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning);
                    aVarA.gn(g.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.E));
                } else {
                    aVarA.bR("Your integrated CMP might not be Google-certified. " + str + "\n\nBy January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                    aVarA.gk(R.drawable.applovin_ic_warning);
                    aVarA.gn(g.a(R.color.applovin_sdk_warningColor, this.E));
                }
            }
        }
        return aVarA.wW();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wy() {
        return com.applovin.impl.mediation.debugger.ui.d.c.wV().bO("Network Consent Statuses").y(this.E).aF(true).wW();
    }

    private String a(com.applovin.impl.mediation.debugger.a.b bVar, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "app-ads.txt URL";
        }
        int i = AnonymousClass1.arj[bVar.ordinal()];
        if (i == 1) {
            return "Could not retrieve developer website from the Play Store for this package name. Check back once this app has been published on the Play Store.";
        }
        if (i == 2) {
            return "Unable to find app-ads.txt file or parse entries of the file at " + str + ".\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        if (i != 3) {
            return i != 4 ? "" : "Text file at " + str + " is missing some of the suggested lines.\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        return "Text file at " + str + " is missing the required AppLovin line:\n\n" + str2 + "\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.b.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] arj;

        static {
            int[] iArr = new int[com.applovin.impl.mediation.debugger.a.b.values().length];
            arj = iArr;
            try {
                iArr[com.applovin.impl.mediation.debugger.a.b.DEVELOPER_URI_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                arj[com.applovin.impl.mediation.debugger.a.b.APPADSTXT_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                arj[com.applovin.impl.mediation.debugger.a.b.MISSING_APPLOVIN_ENTRIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                arj[com.applovin.impl.mediation.debugger.a.b.MISSING_NON_APPLOVIN_ENTRIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private EnumC0127b b(com.applovin.impl.mediation.debugger.a.b bVar) {
        int i = AnonymousClass1.arj[bVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return EnumC0127b.ERROR;
        }
        if (i == 4) {
            return EnumC0127b.WARNING;
        }
        return EnumC0127b.ERROR;
    }

    private String b(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (z) {
            for (com.applovin.impl.mediation.debugger.b.a.c cVar : this.aqZ) {
                if (list.equals(cVar.uO())) {
                    return cVar.getDisplayName();
                }
            }
            for (com.applovin.impl.mediation.debugger.b.a.c cVar2 : this.ara) {
                if (list.equals(cVar2.uO())) {
                    return cVar2.getDisplayName();
                }
            }
        } else {
            for (com.applovin.impl.mediation.debugger.b.c.b bVar : this.arb) {
                if (list.equals(Collections.singletonList(bVar.getName()))) {
                    return bVar.getDisplayName();
                }
            }
        }
        return c$$ExternalSynthetic0.m0(",", list);
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.akD.get() + "}";
    }
}

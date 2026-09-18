package com.applovin.impl.sdk;

import android.os.Bundle;
import android.view.View;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {
    private final AppLovinCommunicator agf;
    private final n sdk;

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    k(n nVar) {
        this.sdk = nVar;
        AppLovinCommunicator appLovinCommunicator = AppLovinCommunicator.getInstance(n.getApplicationContext());
        this.agf = appLovinCommunicator;
        if (nVar.Bo() || !((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue()) {
            return;
        }
        appLovinCommunicator.a(nVar);
        appLovinCommunicator.subscribe(this, com.applovin.impl.communicator.c.akg);
    }

    public void a(JSONObject jSONObject, boolean z) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("safedk_init")) {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
            bundle.putString("applovin_random_token", this.sdk.Bz());
            bundle.putString("compass_random_token", this.sdk.By());
            bundle.putString(TapjoyConstants.TJC_DEVICE_TYPE_NAME, AppLovinSdkUtils.isTablet(n.getApplicationContext()) ? "tablet" : "phone");
            bundle.putString("init_success", String.valueOf(z));
            bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(com.applovin.impl.mediation.e.c.f(this.sdk)));
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", (JSONObject) null);
            Bundle bundle2 = (Bundle) bundle.clone();
            bundle2.putString("user_id", this.sdk.Bx());
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject());
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQZ)).booleanValue()) {
                JSONObject jSONObject4 = new JSONObject();
                JsonUtils.putBoolean(jSONObject4, "deactivated", true);
                JsonUtils.putJSONObject(jSONObject3, "safeDKDeactivation", jSONObject4);
            }
            bundle2.putBundle("settings", JsonUtils.toBundle(jSONObject3));
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
            }
            c(bundle2, "safedk_init");
        }
    }

    public void z(String str, String str2) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("user_info")) {
            Bundle bundle = new Bundle(2);
            bundle.putString("user_id", StringUtils.emptyIfNull(str));
            bundle.putString("applovin_random_token", str2);
            c(bundle, "user_info");
        }
    }

    public void a(com.applovin.impl.mediation.b.a aVar, String str) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("max_ad_events")) {
            Bundle bundleK = k(aVar);
            bundleK.putString("type", str);
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("CommunicatorService", "Sending \"max_ad_events\" message: " + bundleK);
            }
            c(bundleK, "max_ad_events");
        }
    }

    public void j(com.applovin.impl.mediation.b.a aVar) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("max_revenue_events")) {
            Bundle bundleK = k(aVar);
            bundleK.putAll(JsonUtils.toBundle(aVar.xx()));
            bundleK.putString(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, this.sdk.getConfiguration().getCountryCode());
            BundleUtils.putStringIfValid(TapjoyConstants.TJC_USER_SEGMENT, this.sdk.getUserSegment().getName(), bundleK);
            c(bundleK, "max_revenue_events");
        }
    }

    public void b(com.applovin.impl.mediation.b.a aVar, String str) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("ad_callback_blocked_after_hidden")) {
            Bundle bundleK = k(aVar);
            bundleK.putString("callback_name", str);
            c(bundleK, "ad_callback_blocked_after_hidden");
        }
    }

    public void b(MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("adapter_initialization_status")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str);
            bundle.putInt("init_status", initializationStatus.getCode());
            c(bundle, "adapter_initialization_status");
        }
    }

    public void Bb() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("privacy_setting_updated")) {
            c(new Bundle(), "privacy_setting_updated");
        }
    }

    public void A(String str, String str2) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("network_sdk_version_updated")) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str2);
            bundle.putString("sdk_version", str);
            c(bundle, "network_sdk_version_updated");
        }
    }

    public void G(List<String> list) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("live_networks_updated")) {
            if (list == null || list.isEmpty()) {
                c(Bundle.EMPTY, "live_networks_updated");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("live_networks", new ArrayList<>(list));
            c(bundle, "live_networks_updated");
        }
    }

    public void H(List<String> list) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("test_mode_networks_updated")) {
            if (list == null || list.isEmpty()) {
                c(Bundle.EMPTY, "test_mode_networks_updated");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("test_mode_networks", new ArrayList<>(list));
            c(bundle, "test_mode_networks_updated");
        }
    }

    public void b(String str, String str2, String str3) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("responses")) {
            String strMaybeConvertToIndentedString = JsonUtils.maybeConvertToIndentedString(str3, 2);
            String strMaybeConvertToIndentedString2 = JsonUtils.maybeConvertToIndentedString(str, 2);
            Bundle bundle = new Bundle();
            bundle.putString("request_url", str2);
            bundle.putString("request_body", strMaybeConvertToIndentedString);
            bundle.putString("response", strMaybeConvertToIndentedString2);
            c(bundle, "responses");
        }
    }

    public void a(String str, String str2, int i, Object obj, String str3, boolean z) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber("receive_http_response")) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString("url", str2);
            bundle.putInt("code", i);
            bundle.putBundle("body", JsonUtils.toBundle(obj));
            bundle.putBoolean("success", z);
            BundleUtils.putString("error_message", str3, bundle);
            c(bundle, "receive_http_response");
        }
    }

    public void c(Bundle bundle, String str) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue() && this.agf.hasSubscriber(str) && !this.sdk.Bo()) {
            this.agf.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this));
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        long jLongValue;
        long jLongValue2;
        Map<String, Object> map;
        Map<String, Object> mapCY;
        Map<String, Object> mapCS;
        Map<String, Object> mapA;
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQY)).booleanValue()) {
            if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
                Map<String, Object> map2 = BundleUtils.toMap(messageData.getBundle("post_body"));
                Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
                String string = messageData.getString("id", "");
                if (!map2.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                    map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
                }
                this.sdk.Cs().a(new com.applovin.impl.sdk.network.h.a().dh(messageData.getString("url")).di(messageData.getString("backup_url")).n(stringMap).p(map2).o(stringMap2).aV(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()).df(string).ID());
                return;
            }
            if ("send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
                String string2 = messageData2.getString("http_method", "POST");
                if (messageData2.containsKey("timeout_sec")) {
                    jLongValue = TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec"));
                } else {
                    jLongValue = ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNX)).longValue();
                }
                int i = messageData2.getInt("retry_count", ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNY)).intValue());
                if (messageData2.containsKey("retry_delay_sec")) {
                    jLongValue2 = TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec"));
                } else {
                    jLongValue2 = ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNZ)).longValue();
                }
                Map<String, String> stringMap3 = BundleUtils.toStringMap(messageData2.getBundle("query_params"));
                long j = jLongValue2;
                if ("GET".equalsIgnoreCase(string2)) {
                    if (messageData2.getBoolean("include_data_collector_info", true)) {
                        if (this.sdk.BT() != null) {
                            mapA = this.sdk.BT().a(null, false, false);
                        } else {
                            mapA = this.sdk.BQ().a(null, false, false);
                        }
                        stringMap3.putAll(BundleUtils.toStringMap(CollectionUtils.toBundle(mapA)));
                    }
                    i = i;
                    map = null;
                } else {
                    map = BundleUtils.toMap(messageData2.getBundle("post_body"));
                    if (messageData2.getBoolean("include_data_collector_info", true)) {
                        if (this.sdk.BT() != null) {
                            mapCY = this.sdk.BT().DF();
                            mapCS = this.sdk.BT().CS();
                        } else {
                            mapCY = this.sdk.BQ().CY();
                            mapCS = this.sdk.BQ().CS();
                        }
                        if (mapCS.containsKey("idfv") && mapCS.containsKey("idfv_scope")) {
                            String str = (String) mapCS.get("idfv");
                            int iIntValue = ((Integer) mapCS.get("idfv_scope")).intValue();
                            mapCS.remove("idfv");
                            mapCS.remove("idfv_scope");
                            mapCY.put("idfv", str);
                            mapCY.put("idfv_scope", Integer.valueOf(iIntValue));
                        }
                        mapCY.put("server_installed_at", this.sdk.a(com.applovin.impl.sdk.c.b.aKq));
                        mapCY.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
                        map.put("app", mapCY);
                        map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, mapCS);
                    } else {
                        i = i;
                    }
                }
                this.sdk.BM().a(new com.applovin.impl.sdk.network.a(appLovinCommunicatorMessage.getPublisherId(), com.applovin.impl.sdk.network.c.D(this.sdk).da(messageData2.getString("url")).dc(messageData2.getString("backup_url")).k(stringMap3).db(string2).l(BundleUtils.toStringMap(messageData2.getBundle("headers"))).K(map != null ? new JSONObject(map) : null).gD((int) jLongValue).gC(i).gE((int) j).ad(new JSONObject()).aS(messageData2.getBoolean("is_encoding_enabled", false)).Ie(), this.sdk), com.applovin.impl.sdk.e.q.b.MAIN);
                return;
            }
            if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.sdk.BB().addCustomQueryParams(com.applovin.impl.sdk.utils.u.s(BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
            } else if ("set_ad_request_post_body".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.sdk.BB().setCustomPostBody(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
            } else if ("set_mediate_request_post_body_data".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.sdk.Cw().setCustomPostBodyData(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
            }
        }
    }

    public boolean respondsToTopic(String str) {
        return com.applovin.impl.communicator.c.akg.contains(str);
    }

    private Bundle k(com.applovin.impl.mediation.b.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("id", aVar.xz());
        bundle.putString("network_name", aVar.yz());
        bundle.putString("max_ad_unit_id", aVar.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", aVar.getThirdPartyAdPlacementId());
        bundle.putString(FirebaseAnalytics.Param.AD_FORMAT, aVar.getFormat().getLabel());
        BundleUtils.putStringIfValid(CampaignEx.JSON_KEY_CREATIVE_ID, aVar.getCreativeId(), bundle);
        BundleUtils.putStringIfValid("adomain", aVar.xA(), bundle);
        BundleUtils.putStringIfValid("dsp_name", aVar.getDspName(), bundle);
        if (aVar.xE()) {
            BundleUtils.putStringIfValid("hybrid_ad_format", aVar.xD().getLabel(), bundle);
        }
        if (aVar.xC()) {
            bundle.putString("custom_js_network_name", aVar.getNetworkName());
        } else if ("CUSTOM_NETWORK_SDK".equalsIgnoreCase(aVar.yz())) {
            bundle.putString("custom_sdk_network_name", aVar.getNetworkName());
        }
        bundle.putAll(JsonUtils.toBundle(aVar.xv()));
        if (aVar instanceof com.applovin.impl.mediation.b.e) {
            View viewYk = null;
            if (aVar instanceof com.applovin.impl.mediation.b.b) {
                viewYk = ((com.applovin.impl.mediation.b.b) aVar).getAdView();
            } else if (aVar instanceof com.applovin.impl.mediation.b.d) {
                com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) aVar;
                if (!dVar.ur()) {
                    viewYk = dVar.yk() != null ? dVar.yk() : dVar.yl();
                }
            }
            bundle.putString("ad_view", viewYk != null ? viewYk.getClass().getName() + '@' + Integer.toHexString(viewYk.hashCode()) : "N/A");
        }
        return bundle;
    }
}

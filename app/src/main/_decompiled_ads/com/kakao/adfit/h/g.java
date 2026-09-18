package com.kakao.adfit.h;

import androidx.browser.customtabs.CustomTabsCallback;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.g, reason: from toString */
/* JADX INFO: compiled from: MatrixDevice.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u0091\u00012\u00020\u0001:\u0001\u0003BÖ\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000100\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f\u0012\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0004\u0012\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR$\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR$\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010/\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010C\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R$\u0010G\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010*\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R$\u0010K\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010:\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R$\u0010O\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010:\u001a\u0004\bM\u0010<\"\u0004\bN\u0010>R$\u0010V\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010Z\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010Q\u001a\u0004\bX\u0010S\"\u0004\bY\u0010UR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010Q\u001a\u0004\bd\u0010S\"\u0004\be\u0010UR$\u0010j\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010\u000b\u001a\u0004\bh\u0010\r\"\u0004\bi\u0010\u000fR$\u0010n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010*\u001a\u0004\bl\u0010,\"\u0004\bm\u0010.R$\u0010r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010\u000b\u001a\u0004\bp\u0010\r\"\u0004\bq\u0010\u000fR$\u0010v\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010]\u001a\u0004\bt\u0010_\"\u0004\bu\u0010aR$\u0010z\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010]\u001a\u0004\bx\u0010_\"\u0004\by\u0010aR$\u0010~\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010*\u001a\u0004\b|\u0010,\"\u0004\b}\u0010.R+\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u000b\u001a\u0005\b\u0088\u0001\u0010\r\"\u0005\b\u0089\u0001\u0010\u000fR(\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010\u000b\u001a\u0005\b\u008c\u0001\u0010\r\"\u0005\b\u008d\u0001\u0010\u000f¨\u0006\u0092\u0001"}, d2 = {"Lcom/kakao/adfit/h/g;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getName", "setName", "name", "c", "getManufacturer", "setManufacturer", "manufacturer", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getBrand", "setBrand", "brand", "e", "getFamily", "setFamily", "family", InneractiveMediationDefs.GENDER_FEMALE, "getModel", "setModel", DeviceRequestsHelper.DEVICE_INFO_MODEL, "g", "getModelId", "setModelId", "modelId", "h", "Ljava/lang/Boolean;", "getSimulator", "()Ljava/lang/Boolean;", "setSimulator", "(Ljava/lang/Boolean;)V", "simulator", "", "i", "Ljava/util/List;", "getArchs", "()Ljava/util/List;", "setArchs", "(Ljava/util/List;)V", "archs", "", "j", "Ljava/lang/Long;", "getMemorySize", "()Ljava/lang/Long;", "setMemorySize", "(Ljava/lang/Long;)V", "memorySize", CampaignEx.JSON_KEY_AD_K, "getFreeMemorySize", "setFreeMemorySize", "freeMemorySize", "l", "getLowMemory", "setLowMemory", "lowMemory", InneractiveMediationDefs.GENDER_MALE, "getStorageSize", "setStorageSize", "storageSize", "n", "getFreeStorageSize", "setFreeStorageSize", "freeStorageSize", "o", "Ljava/lang/Integer;", "getScreenWidthPixels", "()Ljava/lang/Integer;", "setScreenWidthPixels", "(Ljava/lang/Integer;)V", "screenWidthPixels", "p", "getScreenHeightPixels", "setScreenHeightPixels", "screenHeightPixels", "", CampaignEx.JSON_KEY_AD_Q, "Ljava/lang/Float;", "getScreenDensity", "()Ljava/lang/Float;", "setScreenDensity", "(Ljava/lang/Float;)V", "screenDensity", CampaignEx.JSON_KEY_AD_R, "getScreenDpi", "setScreenDpi", "screenDpi", "s", "getOrientation", "setOrientation", "orientation", "t", "getOnline", "setOnline", CustomTabsCallback.ONLINE_EXTRAS_KEY, "u", "getConnectionType", "setConnectionType", "connectionType", "v", "getBatteryLevel", "setBatteryLevel", "batteryLevel", "w", "getBatteryTemperature", "setBatteryTemperature", "batteryTemperature", "x", "getCharging", "setCharging", "charging", "Lcom/kakao/adfit/h/d;", "y", "Lcom/kakao/adfit/h/d;", "getBootTime", "()Lcom/kakao/adfit/h/d;", "setBootTime", "(Lcom/kakao/adfit/h/d;)V", "bootTime", "z", "getTimezone", "setTimezone", TapjoyConstants.TJC_DEVICE_TIMEZONE, "A", "getLanguage", "setLanguage", "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Lcom/kakao/adfit/h/d;Ljava/lang/String;Ljava/lang/String;)V", "B", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixDevice {

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: A, reason: from kotlin metadata and from toString */
    private String language;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String id;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private String manufacturer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private String brand;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private String family;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private String model;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private String modelId;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private Boolean simulator;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    private List<String> archs;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
    private Long memorySize;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
    private Long freeMemorySize;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
    private Boolean lowMemory;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata and from toString */
    private Long storageSize;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata and from toString */
    private Long freeStorageSize;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata and from toString */
    private Integer screenWidthPixels;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata and from toString */
    private Integer screenHeightPixels;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata and from toString */
    private Float screenDensity;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata and from toString */
    private Integer screenDpi;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata and from toString */
    private String orientation;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata and from toString */
    private Boolean online;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata and from toString */
    private String connectionType;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata and from toString */
    private Float batteryLevel;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata and from toString */
    private Float batteryTemperature;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata and from toString */
    private Boolean charging;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata and from toString */
    private d bootTime;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata and from toString */
    private String timezone;

    /* JADX INFO: renamed from: com.kakao.adfit.h.g$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixDevice.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\fR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\fR\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\fR\u0014\u0010 \u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\fR\u0014\u0010!\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\fR\u0014\u0010\"\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\fR\u0014\u0010#\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\fR\u0014\u0010$\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\fR\u0014\u0010%\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\fR\u0014\u0010'\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\fR\u0014\u0010(\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\fR\u0014\u0010)\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\fR\u0014\u0010*\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\fR\u0014\u0010+\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\f¨\u0006."}, d2 = {"Lcom/kakao/adfit/h/g$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/g;", "a", "", "networkType", "", TJAdUnitConstants.String.ROTATION, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "CONNECTION_TYPE_CELLULAR", "Ljava/lang/String;", "CONNECTION_TYPE_ETHERNET", "CONNECTION_TYPE_WIFI", "KEY_ARCHS", "KEY_BATTERY_LEVEL", "KEY_BATTERY_TEMPERATURE", "KEY_BOOT_TIME", "KEY_BRAND", "KEY_CHARGING", "KEY_CONNECTION_TYPE", "KEY_FAMILY", "KEY_FREE_MEMORY_SIZE", "KEY_FREE_STORAGE_SIZE", "KEY_ID", "KEY_LANGUAGE", "KEY_LOW_MEMORY", "KEY_MANUFACTURER", "KEY_MEMORY_SIZE", "KEY_MODEL", "KEY_MODEL_ID", "KEY_NAME", "KEY_ONLINE", "KEY_ORIENTATION", "KEY_SCREEN_DENSITY", "KEY_SCREEN_DPI", "KEY_SCREEN_HEIGHT_PIXELS", "KEY_SCREEN_WIDTH_PIXELS", "KEY_SIMULATOR", "KEY_STORAGE_SIZE", "KEY_TIMEZONE", "ORIENTATION_LANDSCAPE", "ORIENTATION_PORTRAIT", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixDevice a(JSONObject json) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(json, "json");
            String strE = com.kakao.adfit.k.p.e(json, "id");
            String strE2 = com.kakao.adfit.k.p.e(json, "name");
            String strE3 = com.kakao.adfit.k.p.e(json, "manufacturer");
            String strE4 = com.kakao.adfit.k.p.e(json, "brand");
            String strE5 = com.kakao.adfit.k.p.e(json, "family");
            String strE6 = com.kakao.adfit.k.p.e(json, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            String strE7 = com.kakao.adfit.k.p.e(json, "model_id");
            Boolean boolA = com.kakao.adfit.k.p.a(json, "simulator");
            JSONArray jSONArrayOptJSONArray = json.optJSONArray("archs");
            if (jSONArrayOptJSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
                arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object objOpt = jSONArrayOptJSONArray.opt(i);
                    if (!(objOpt instanceof String)) {
                        objOpt = null;
                    }
                    String str = (String) objOpt;
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
            } else {
                arrayList = null;
            }
            Long lD = com.kakao.adfit.k.p.d(json, "memory_size");
            Long lD2 = com.kakao.adfit.k.p.d(json, "free_memory");
            Boolean boolA2 = com.kakao.adfit.k.p.a(json, "low_memory");
            Long lD3 = com.kakao.adfit.k.p.d(json, "storage_size");
            Long lD4 = com.kakao.adfit.k.p.d(json, "free_storage");
            Integer numC = com.kakao.adfit.k.p.c(json, "screen_width_pixels");
            Integer numC2 = com.kakao.adfit.k.p.c(json, "screen_height_pixels");
            Float fB = com.kakao.adfit.k.p.b(json, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY);
            Integer numC3 = com.kakao.adfit.k.p.c(json, "screen_dpi");
            String strE8 = com.kakao.adfit.k.p.e(json, "orientation");
            Boolean boolA3 = com.kakao.adfit.k.p.a(json, CustomTabsCallback.ONLINE_EXTRAS_KEY);
            String strE9 = com.kakao.adfit.k.p.e(json, TapjoyConstants.TJC_CONNECTION_TYPE);
            Float fB2 = com.kakao.adfit.k.p.b(json, "battery_level");
            Float fB3 = com.kakao.adfit.k.p.b(json, "battery_temperature");
            Boolean boolA4 = com.kakao.adfit.k.p.a(json, "charging");
            String strE10 = com.kakao.adfit.k.p.e(json, "boot_time");
            return new MatrixDevice(strE, strE2, strE3, strE4, strE5, strE6, strE7, boolA, arrayList, lD, lD2, boolA2, lD3, lD4, numC, numC2, fB, numC3, strE8, boolA3, strE9, fB2, fB3, boolA4, strE10 != null ? d.INSTANCE.a(strE10) : null, com.kakao.adfit.k.p.e(json, TapjoyConstants.TJC_DEVICE_TIMEZONE), com.kakao.adfit.k.p.e(json, "language"));
        }

        public final String a(int networkType) {
            if (networkType == 1) {
                return "cellular";
            }
            if (networkType == 2) {
                return TapjoyConstants.TJC_CONNECTION_TYPE_WIFI;
            }
            if (networkType != 3) {
                return null;
            }
            return "ethernet";
        }

        public final String b(int rotation) {
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation != 3) {
                            return null;
                        }
                    }
                }
                return TJAdUnitConstants.String.LANDSCAPE;
            }
            return TJAdUnitConstants.String.PORTRAIT;
        }
    }

    public MatrixDevice() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
    }

    public MatrixDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, List<String> list, Long l, Long l2, Boolean bool2, Long l3, Long l4, Integer num, Integer num2, Float f, Integer num3, String str8, Boolean bool3, String str9, Float f2, Float f3, Boolean bool4, d dVar, String str10, String str11) {
        this.id = str;
        this.name = str2;
        this.manufacturer = str3;
        this.brand = str4;
        this.family = str5;
        this.model = str6;
        this.modelId = str7;
        this.simulator = bool;
        this.archs = list;
        this.memorySize = l;
        this.freeMemorySize = l2;
        this.lowMemory = bool2;
        this.storageSize = l3;
        this.freeStorageSize = l4;
        this.screenWidthPixels = num;
        this.screenHeightPixels = num2;
        this.screenDensity = f;
        this.screenDpi = num3;
        this.orientation = str8;
        this.online = bool3;
        this.connectionType = str9;
        this.batteryLevel = f2;
        this.batteryTemperature = f3;
        this.charging = bool4;
        this.bootTime = dVar;
        this.timezone = str10;
        this.language = str11;
    }

    public final JSONObject a() throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("id", this.id).putOpt("name", this.name).putOpt("manufacturer", this.manufacturer).putOpt("brand", this.brand).putOpt("family", this.family).putOpt(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.model).putOpt("model_id", this.modelId).putOpt("simulator", this.simulator);
        List<String> list = this.archs;
        if (list != null) {
            jSONArray = new JSONArray();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toString());
            }
        } else {
            jSONArray = null;
        }
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("archs", jSONArray).putOpt("memory_size", this.memorySize).putOpt("free_memory", this.freeMemorySize).putOpt("low_memory", this.lowMemory).putOpt("storage_size", this.storageSize).putOpt("free_storage", this.freeStorageSize).putOpt("screen_width_pixels", this.screenWidthPixels).putOpt("screen_height_pixels", this.screenHeightPixels).putOpt(TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, this.screenDensity).putOpt("screen_dpi", this.screenDpi).putOpt("orientation", this.orientation).putOpt(CustomTabsCallback.ONLINE_EXTRAS_KEY, this.online).putOpt(TapjoyConstants.TJC_CONNECTION_TYPE, this.connectionType).putOpt("battery_level", this.batteryLevel).putOpt("battery_temperature", this.batteryTemperature).putOpt("charging", this.charging);
        d dVar = this.bootTime;
        JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt("boot_time", dVar != null ? dVar.getTimestamp() : null).putOpt(TapjoyConstants.TJC_DEVICE_TIMEZONE, this.timezone).putOpt("language", this.language);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt3, "JSONObject()\n           …t(KEY_LANGUAGE, language)");
        return jSONObjectPutOpt3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixDevice)) {
            return false;
        }
        MatrixDevice matrixDevice = (MatrixDevice) other;
        return Intrinsics.areEqual(this.id, matrixDevice.id) && Intrinsics.areEqual(this.name, matrixDevice.name) && Intrinsics.areEqual(this.manufacturer, matrixDevice.manufacturer) && Intrinsics.areEqual(this.brand, matrixDevice.brand) && Intrinsics.areEqual(this.family, matrixDevice.family) && Intrinsics.areEqual(this.model, matrixDevice.model) && Intrinsics.areEqual(this.modelId, matrixDevice.modelId) && Intrinsics.areEqual(this.simulator, matrixDevice.simulator) && Intrinsics.areEqual(this.archs, matrixDevice.archs) && Intrinsics.areEqual(this.memorySize, matrixDevice.memorySize) && Intrinsics.areEqual(this.freeMemorySize, matrixDevice.freeMemorySize) && Intrinsics.areEqual(this.lowMemory, matrixDevice.lowMemory) && Intrinsics.areEqual(this.storageSize, matrixDevice.storageSize) && Intrinsics.areEqual(this.freeStorageSize, matrixDevice.freeStorageSize) && Intrinsics.areEqual(this.screenWidthPixels, matrixDevice.screenWidthPixels) && Intrinsics.areEqual(this.screenHeightPixels, matrixDevice.screenHeightPixels) && Intrinsics.areEqual((Object) this.screenDensity, (Object) matrixDevice.screenDensity) && Intrinsics.areEqual(this.screenDpi, matrixDevice.screenDpi) && Intrinsics.areEqual(this.orientation, matrixDevice.orientation) && Intrinsics.areEqual(this.online, matrixDevice.online) && Intrinsics.areEqual(this.connectionType, matrixDevice.connectionType) && Intrinsics.areEqual((Object) this.batteryLevel, (Object) matrixDevice.batteryLevel) && Intrinsics.areEqual((Object) this.batteryTemperature, (Object) matrixDevice.batteryTemperature) && Intrinsics.areEqual(this.charging, matrixDevice.charging) && Intrinsics.areEqual(this.bootTime, matrixDevice.bootTime) && Intrinsics.areEqual(this.timezone, matrixDevice.timezone) && Intrinsics.areEqual(this.language, matrixDevice.language);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.manufacturer;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.brand;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.family;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.model;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.modelId;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.simulator;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<String> list = this.archs;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Long l = this.memorySize;
        int iHashCode10 = (iHashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.freeMemorySize;
        int iHashCode11 = (iHashCode10 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool2 = this.lowMemory;
        int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l3 = this.storageSize;
        int iHashCode13 = (iHashCode12 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.freeStorageSize;
        int iHashCode14 = (iHashCode13 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Integer num = this.screenWidthPixels;
        int iHashCode15 = (iHashCode14 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.screenHeightPixels;
        int iHashCode16 = (iHashCode15 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f = this.screenDensity;
        int iHashCode17 = (iHashCode16 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num3 = this.screenDpi;
        int iHashCode18 = (iHashCode17 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str8 = this.orientation;
        int iHashCode19 = (iHashCode18 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool3 = this.online;
        int iHashCode20 = (iHashCode19 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str9 = this.connectionType;
        int iHashCode21 = (iHashCode20 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Float f2 = this.batteryLevel;
        int iHashCode22 = (iHashCode21 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.batteryTemperature;
        int iHashCode23 = (iHashCode22 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Boolean bool4 = this.charging;
        int iHashCode24 = (iHashCode23 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        d dVar = this.bootTime;
        int iHashCode25 = (iHashCode24 + (dVar == null ? 0 : dVar.hashCode())) * 31;
        String str10 = this.timezone;
        int iHashCode26 = (iHashCode25 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.language;
        return iHashCode26 + (str11 != null ? str11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MatrixDevice(id=").append(this.id).append(", name=").append(this.name).append(", manufacturer=").append(this.manufacturer).append(", brand=").append(this.brand).append(", family=").append(this.family).append(", model=").append(this.model).append(", modelId=").append(this.modelId).append(", simulator=").append(this.simulator).append(", archs=").append(this.archs).append(", memorySize=").append(this.memorySize).append(", freeMemorySize=").append(this.freeMemorySize).append(", lowMemory=");
        sb.append(this.lowMemory).append(", storageSize=").append(this.storageSize).append(", freeStorageSize=").append(this.freeStorageSize).append(", screenWidthPixels=").append(this.screenWidthPixels).append(", screenHeightPixels=").append(this.screenHeightPixels).append(", screenDensity=").append(this.screenDensity).append(", screenDpi=").append(this.screenDpi).append(", orientation=").append(this.orientation).append(", online=").append(this.online).append(", connectionType=").append(this.connectionType).append(", batteryLevel=").append(this.batteryLevel).append(", batteryTemperature=").append(this.batteryTemperature);
        sb.append(", charging=").append(this.charging).append(", bootTime=").append(this.bootTime).append(", timezone=").append(this.timezone).append(", language=").append(this.language).append(')');
        return sb.toString();
    }

    public /* synthetic */ MatrixDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, List list, Long l, Long l2, Boolean bool2, Long l3, Long l4, Integer num, Integer num2, Float f, Integer num3, String str8, Boolean bool3, String str9, Float f2, Float f3, Boolean bool4, d dVar, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? null : l2, (i & 2048) != 0 ? null : bool2, (i & 4096) != 0 ? null : l3, (i & 8192) != 0 ? null : l4, (i & 16384) != 0 ? null : num, (i & 32768) != 0 ? null : num2, (i & 65536) != 0 ? null : f, (i & 131072) != 0 ? null : num3, (i & 262144) != 0 ? null : str8, (i & 524288) != 0 ? null : bool3, (i & 1048576) != 0 ? null : str9, (i & 2097152) != 0 ? null : f2, (i & 4194304) != 0 ? null : f3, (i & 8388608) != 0 ? null : bool4, (i & 16777216) != 0 ? null : dVar, (i & 33554432) != 0 ? null : str10, (i & 67108864) != 0 ? null : str11);
    }
}

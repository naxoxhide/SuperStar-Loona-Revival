package com.kakao.adfit.l;

import androidx.core.app.NotificationCompat;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.d.p;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VastEventTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u00101\u001a\u000200\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b2\u00103J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\"\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\r\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010%\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u0004\u0010\u001e\"\u0004\b$\u0010 R\u0016\u0010&\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR&\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010)R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010,R\u0016\u0010/\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010.¨\u00064"}, d2 = {"Lcom/kakao/adfit/l/c;", "", "", "Lcom/kakao/adfit/l/a$d;", "a", "", "duration", "", "i", "h", InneractiveMediationDefs.GENDER_FEMALE, "c", "position", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "g", "e", "j", CampaignEx.JSON_KEY_AD_K, "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "sendTracking", "<set-?>", "I", "getDuration", "()I", "getLatestPosition", "latestPosition", "", "Z", "()Z", "setStarted", "(Z)V", "isStarted", "isPlaying", "setPlaying", "setCompleted", "isCompleted", "playButtonClicked", "", "", "Ljava/util/Map;", "trackings", "Lcom/kakao/adfit/l/a;", "Ljava/util/List;", "progressTrackings", "Ljava/lang/String;", "errorTracking", "Lcom/kakao/adfit/d/p$k;", "asset", "<init>", "(Lcom/kakao/adfit/d/p$k;Lkotlin/jvm/functions/Function1;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function1<String, Unit> sendTracking;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int duration;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private int latestPosition;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private boolean isStarted;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private boolean isPlaying;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private boolean isCompleted;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private boolean playButtonClicked;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Map<String, List<String>> trackings;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private List<ProgressTracking> progressTrackings;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final String errorTracking;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p.k asset, Function1<? super String, Unit> sendTracking) {
        String string;
        ProgressTracking.d dVarA;
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(sendTracking, "sendTracking");
        this.sendTracking = sendTracking;
        this.duration = asset.getDuration();
        this.latestPosition = asset.getProgress();
        this.errorTracking = asset.getVast().getErrorUrl();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        List<Tracking> listD = asset.getVast().d();
        Iterator<T> it = (listD == null ? CollectionsKt.emptyList() : listD).iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                this.trackings = map;
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((ProgressTracking) it2.next()).getOffset().a(this.duration);
                }
                this.progressTrackings = arrayList;
                if (this.duration <= 0 || this.latestPosition <= 0) {
                    return;
                }
                this.isStarted = true;
                return;
            }
            Tracking tracking = (Tracking) it.next();
            String event = tracking.getEvent();
            if (!(event == null || event.length() == 0)) {
                String url = tracking.getUrl();
                if (url != null && url.length() != 0) {
                    z = false;
                }
                if (!z) {
                    String event2 = tracking.getEvent();
                    if (event2 != null) {
                        switch (event2.hashCode()) {
                            case -1638835128:
                                if (event2.equals("midpoint")) {
                                    arrayList.add(new ProgressTracking(50.0f, tracking.getUrl()));
                                }
                                break;
                            case -1337830390:
                                if (event2.equals(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE)) {
                                    arrayList.add(new ProgressTracking(75.0f, tracking.getUrl()));
                                }
                                break;
                            case -1001078227:
                                if (event2.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                                    String offset = tracking.getOffset();
                                    if (offset != null && (string = StringsKt.trim((CharSequence) offset).toString()) != null && (dVarA = a(string)) != null) {
                                        arrayList.add(new ProgressTracking(dVarA, tracking.getUrl()));
                                    }
                                }
                                break;
                            case 560220243:
                                if (event2.equals(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE)) {
                                    arrayList.add(new ProgressTracking(25.0f, tracking.getUrl()));
                                }
                                break;
                            case 790771261:
                                if (event2.equals("thirtySeconds")) {
                                    arrayList.add(new ProgressTracking(30000, tracking.getUrl()));
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    String event3 = tracking.getEvent();
                    Object arrayList2 = map.get(event3);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        map.put(event3, arrayList2);
                    }
                    ((Collection) arrayList2).add(tracking.getUrl());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getIsCompleted() {
        return this.isCompleted;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getIsStarted() {
        return this.isStarted;
    }

    public final void c() {
        if (!this.isStarted || this.isCompleted) {
            return;
        }
        int i = this.latestPosition;
        int i2 = this.duration;
        if (i < i2) {
            b(i2);
        }
        this.isCompleted = true;
        this.isPlaying = false;
        this.playButtonClicked = false;
        this.latestPosition = 0;
        List<String> list = this.trackings.get("complete");
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.sendTracking.invoke((String) it.next());
            }
        }
    }

    public final void d() {
        if (this.isCompleted) {
            return;
        }
        String str = this.errorTracking;
        boolean z = false;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            }
        }
        if (z) {
            this.sendTracking.invoke(this.errorTracking);
        }
    }

    public final void e() {
        List<String> list = this.trackings.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.sendTracking.invoke((String) it.next());
            }
        }
    }

    public final void f() {
        if (this.isPlaying && this.isStarted && !this.isCompleted) {
            this.isPlaying = false;
            List<String> list = this.trackings.get(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    this.sendTracking.invoke((String) it.next());
                }
            }
        }
    }

    public final void g() {
        this.playButtonClicked = true;
    }

    public final void h() {
        if (this.isPlaying || !this.isStarted || this.isCompleted) {
            return;
        }
        this.isPlaying = true;
        List<String> list = this.trackings.get(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.sendTracking.invoke((String) it.next());
            }
        }
    }

    public final void i() {
        if (this.isCompleted) {
            return;
        }
        if (this.isStarted) {
            this.isPlaying = true;
            return;
        }
        this.isStarted = true;
        List<String> list = this.trackings.get("start");
        if (list != null) {
            for (String strReplace$default : list) {
                if (StringsKt.contains$default((CharSequence) strReplace$default, (CharSequence) "[VX_START_TYPE]", false, 2, (Object) null)) {
                    strReplace$default = StringsKt.replace$default(strReplace$default, "[VX_START_TYPE]", !this.playButtonClicked ? "VIDEO_AUTO_START" : "VIDEO_MANUAL_START", false, 4, (Object) null);
                }
                this.sendTracking.invoke(strReplace$default);
            }
        }
    }

    public final void j() {
        List<String> list = this.trackings.get(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.sendTracking.invoke((String) it.next());
            }
        }
    }

    public final void k() {
        if (this.isStarted && this.isCompleted) {
            this.isStarted = false;
            this.isPlaying = false;
            this.isCompleted = false;
            this.playButtonClicked = false;
            this.latestPosition = 0;
        }
    }

    public final void a(int duration) {
        if (this.isStarted || this.duration == duration) {
            return;
        }
        this.duration = duration;
        List<ProgressTracking> list = this.progressTrackings;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ProgressTracking) it.next()).getOffset().a(duration);
        }
        this.progressTrackings = list;
    }

    public final void b(int position) {
        int i;
        if (!this.isStarted || this.isCompleted || (i = this.latestPosition) >= position) {
            return;
        }
        if (i == 0) {
            for (ProgressTracking progressTracking : this.progressTrackings) {
                if (progressTracking.getOffset().getMillis() <= position) {
                    this.sendTracking.invoke(progressTracking.getUrl());
                }
            }
        } else {
            for (ProgressTracking progressTracking2 : this.progressTrackings) {
                int i2 = this.latestPosition + 1;
                int millis = progressTracking2.getOffset().getMillis();
                if (i2 <= millis && millis <= position) {
                    this.sendTracking.invoke(progressTracking2.getUrl());
                }
            }
        }
        this.latestPosition = position;
    }

    private final ProgressTracking.d a(String str) {
        if (StringsKt.endsWith$default(str, "%", false, 2, (Object) null)) {
            String strSubstring = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Float floatOrNull = StringsKt.toFloatOrNull(strSubstring);
            if (floatOrNull != null) {
                return new ProgressTracking.PercentageTimeOffset(floatOrNull.floatValue());
            }
            return null;
        }
        return new ProgressTracking.MillisTimeOffset((int) f.a(str));
    }
}

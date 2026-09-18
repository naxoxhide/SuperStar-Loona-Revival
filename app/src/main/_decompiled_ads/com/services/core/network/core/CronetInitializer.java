package com.unity3d.services.core.network.core;

import android.content.Context;
import androidx.startup.Initializer;
import com.google.android.gms.net.CronetProviderInstaller;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CronetInitializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/unity3d/services/core/network/core/CronetInitializer;", "Landroidx/startup/Initializer;", "", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "sendDuration", "startTime", "", "success", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CronetInitializer implements Initializer<Unit> {
    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit create(Context context) {
        create2(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public void create2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final long jNanoTime = System.nanoTime();
        CronetProviderInstaller.installProvider(context).addOnCompleteListener(new OnCompleteListener() { // from class: com.unity3d.services.core.network.core.-$$Lambda$CronetInitializer$10ZCNy6Y31E9CLbZTG9801a-acY
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                CronetInitializer.create$lambda$0(this.f$0, jNanoTime, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void create$lambda$0(CronetInitializer this$0, long j, Task it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.sendDuration(j, it.isSuccessful());
    }

    private final void sendDuration(long startTime, boolean success) {
        Metric metric;
        SDKMetricsSender sDKMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
        if (success) {
            metric = new Metric("native_cronet_play_services_success", Long.valueOf(millis), null, 4, null);
        } else {
            metric = new Metric("native_cronet_play_services_failure", Long.valueOf(millis), null, 4, null);
        }
        sDKMetricsSender.sendMetric(metric);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }
}

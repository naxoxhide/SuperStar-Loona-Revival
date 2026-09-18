package com.unity3d.services;

import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.task.EmptyParams;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: UnityAdsSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/unity3d/services/UnityAdsSDK;", "Lcom/unity3d/services/core/di/IServiceComponent;", "()V", "initializeSDK", "Lcom/unity3d/services/core/domain/task/InitializeSDK;", "getInitializeSDK", "()Lcom/unity3d/services/core/domain/task/InitializeSDK;", "initializeSDK$delegate", "Lkotlin/Lazy;", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "getSdkScope", "()Lkotlinx/coroutines/CoroutineScope;", "sdkScope$delegate", MobileAdsBridgeBase.initializeMethodName, "Lkotlinx/coroutines/Job;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UnityAdsSDK implements IServiceComponent {
    public static final UnityAdsSDK INSTANCE;

    /* JADX INFO: renamed from: initializeSDK$delegate, reason: from kotlin metadata */
    private static final Lazy initializeSDK;

    /* JADX INFO: renamed from: sdkScope$delegate, reason: from kotlin metadata */
    private static final Lazy sdkScope;

    private UnityAdsSDK() {
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    static {
        UnityAdsSDK unityAdsSDK = new UnityAdsSDK();
        INSTANCE = unityAdsSDK;
        final UnityAdsSDK unityAdsSDK2 = unityAdsSDK;
        final String str = "sdk";
        sdkScope = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<CoroutineScope>() { // from class: com.unity3d.services.UnityAdsSDK$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                IServiceComponent iServiceComponent = unityAdsSDK2;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
            }
        });
        final UnityAdsSDK unityAdsSDK3 = unityAdsSDK;
        final String str2 = "";
        initializeSDK = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<InitializeSDK>() { // from class: com.unity3d.services.UnityAdsSDK$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.core.domain.task.InitializeSDK, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InitializeSDK invoke() {
                IServiceComponent iServiceComponent = unityAdsSDK3;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str2, Reflection.getOrCreateKotlinClass(InitializeSDK.class));
            }
        });
    }

    private final CoroutineScope getSdkScope() {
        return (CoroutineScope) sdkScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InitializeSDK getInitializeSDK() {
        return (InitializeSDK) initializeSDK.getValue();
    }

    /* JADX INFO: renamed from: com.unity3d.services.UnityAdsSDK$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: UnityAdsSDK.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.services.UnityAdsSDK$initialize$1", f = "UnityAdsSDK.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (UnityAdsSDK.INSTANCE.getInitializeSDK().mo489invokegIAlus(EmptyParams.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            }
            return Unit.INSTANCE;
        }
    }

    public final Job initialize() {
        return BuildersKt__Builders_commonKt.launch$default(getSdkScope(), null, null, new AnonymousClass1(null), 3, null);
    }
}

package com.unity3d.services.core.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryAsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeContentObserver;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.SDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.LegacyHttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: ServiceProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/unity3d/services/core/di/ServiceProvider;", "Lcom/unity3d/services/core/di/IServiceProvider;", "()V", "NAMED_SDK", "", "serviceRegistry", "Lcom/unity3d/services/core/di/IServicesRegistry;", "getRegistry", MobileAdsBridgeBase.initializeMethodName, "provideHttpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "configFileFromLocalStorage", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "provideSDKDispatchers", "provideSDKErrorHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "provideSDKMetricSender", "provideSDKScope", "Lkotlinx/coroutines/CoroutineScope;", "errorHandler", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ServiceProvider implements IServiceProvider {
    public static final ServiceProvider INSTANCE;
    public static final String NAMED_SDK = "sdk";
    private static final IServicesRegistry serviceRegistry;

    private ServiceProvider() {
    }

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(new Function1<ServicesRegistry, Unit>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServicesRegistry servicesRegistry) {
                invoke2(servicesRegistry);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final ServicesRegistry registry) {
                Intrinsics.checkNotNullParameter(registry, "$this$registry");
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class)), LazyKt.lazy(new Function0<SDKMetricsSender>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SDKMetricsSender invoke() {
                        return ServiceProvider.INSTANCE.provideSDKMetricSender();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class)), LazyKt.lazy(new Function0<ISDKDispatchers>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ISDKDispatchers invoke() {
                        return ServiceProvider.INSTANCE.provideSDKDispatchers();
                    }
                }));
                registry.updateService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class)), LazyKt.lazy(new Function0<CoroutineExceptionHandler>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineExceptionHandler invoke() {
                        return ServiceProvider.INSTANCE.provideSDKErrorHandler((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (SDKMetricsSender) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class))));
                    }
                }));
                registry.updateService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineScope.class)), LazyKt.lazy(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return ServiceProvider.INSTANCE.provideSDKScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class)), LazyKt.lazy(new Function0<HttpClient>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.5
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HttpClient invoke() {
                        return ServiceProvider.INSTANCE.provideHttpClient((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class)), ServiceFactoryKt.factoryOf(new Function0<InitializeStateNetworkError>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.6
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateNetworkError invoke() {
                        return new InitializeStateNetworkError((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class)), LazyKt.lazy(new Function0<ConfigFileFromLocalStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.7
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ConfigFileFromLocalStorage invoke() {
                        return new ConfigFileFromLocalStorage((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateReset.class)), LazyKt.lazy(new Function0<InitializeStateReset>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.8
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateReset invoke() {
                        return new InitializeStateReset((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateError.class)), LazyKt.lazy(new Function0<InitializeStateError>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.9
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateError invoke() {
                        return new InitializeStateError((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class)), LazyKt.lazy(new Function0<InitializeStateConfigWithLoader>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.10
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateConfigWithLoader invoke() {
                        return new InitializeStateConfigWithLoader((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (TokenStorage) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class))), (SDKMetricsSender) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfig.class)), LazyKt.lazy(new Function0<InitializeStateConfig>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.11
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateConfig invoke() {
                        return new InitializeStateConfig((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateConfigWithLoader) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreate.class)), LazyKt.lazy(new Function0<InitializeStateCreate>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.12
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateCreate invoke() {
                        return new InitializeStateCreate((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class)), LazyKt.lazy(new Function0<InitializeStateLoadCache>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.13
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateLoadCache invoke() {
                        return new InitializeStateLoadCache((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreateWithRemote.class)), LazyKt.lazy(new Function0<InitializeStateCreateWithRemote>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.14
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateCreateWithRemote invoke() {
                        return new InitializeStateCreateWithRemote((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class)), LazyKt.lazy(new Function0<InitializeStateLoadWeb>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.15
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateLoadWeb invoke() {
                        return new InitializeStateLoadWeb((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (HttpClient) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateComplete.class)), LazyKt.lazy(new Function0<InitializeStateComplete>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.16
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateComplete invoke() {
                        return new InitializeStateComplete((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeSDK.class)), LazyKt.lazy(new Function0<InitializeSDK>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.17
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeSDK invoke() {
                        return new InitializeSDK((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))), (InitializeStateReset) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateReset.class))), (InitializeStateError) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateError.class))), (InitializeStateConfig) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfig.class))), (InitializeStateCreate) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreate.class))), (InitializeStateLoadCache) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class))), (InitializeStateCreateWithRemote) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreateWithRemote.class))), (InitializeStateLoadWeb) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class))), (InitializeStateComplete) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateComplete.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class)), LazyKt.lazy(new Function0<TokenStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.18
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TokenStorage invoke() {
                        return new InMemoryTokenStorage();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AsyncTokenStorage.class)), LazyKt.lazy(new Function0<AsyncTokenStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.19
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AsyncTokenStorage invoke() {
                        return new InMemoryAsyncTokenStorage(null, new Handler(Looper.getMainLooper()), SDKMetrics.getInstance(), (TokenStorage) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChange.class)), LazyKt.lazy(new Function0<VolumeChange>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.20
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final VolumeChange invoke() {
                        return new VolumeChangeContentObserver();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChangeMonitor.class)), LazyKt.lazy(new Function0<VolumeChangeMonitor>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.21
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final VolumeChangeMonitor invoke() {
                        return new VolumeChangeMonitor(SharedInstances.INSTANCE.getWebViewEventSender(), (VolumeChange) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChange.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MeasurementsService.class)), LazyKt.lazy(new Function0<MeasurementsService>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.22
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MeasurementsService invoke() {
                        Context applicationContext = ClientProperties.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext()");
                        return new MeasurementsService(applicationContext, (ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TopicsService.class)), LazyKt.lazy(new Function0<TopicsService>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.23
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TopicsService invoke() {
                        Context applicationContext = ClientProperties.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext()");
                        return new TopicsService(applicationContext, (ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
                    }
                }));
            }
        });
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISDKDispatchers provideSDKDispatchers() {
        return new SDKDispatchers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineExceptionHandler provideSDKErrorHandler(ISDKDispatchers dispatchers, SDKMetricsSender sdkMetricsSender) {
        return new SDKErrorHandler(dispatchers, sdkMetricsSender);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope provideSDKScope(ISDKDispatchers dispatchers, CoroutineExceptionHandler errorHandler) {
        return CoroutineScopeKt.CoroutineScope(dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(errorHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SDKMetricsSender provideSDKMetricSender() {
        SDKMetricsSender sDKMetrics = SDKMetrics.getInstance();
        Intrinsics.checkNotNullExpressionValue(sDKMetrics, "getInstance()");
        return sDKMetrics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpClient provideHttpClient(ISDKDispatchers dispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage) {
        IExperiments experiments;
        Configuration configuration = (Configuration) BuildersKt__BuildersKt.runBlocking$default(null, new ServiceProvider$provideHttpClient$config$1(configFileFromLocalStorage, null), 1, null);
        if ((configuration == null || (experiments = configuration.getExperiments()) == null || !experiments.isOkHttpEnabled()) ? false : true) {
            return new OkHttp3Client(dispatchers, new OkHttpClient());
        }
        return new LegacyHttpClient(dispatchers);
    }
}

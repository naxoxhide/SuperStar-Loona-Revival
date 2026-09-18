package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.ktx.FirebaseKt;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: FirebaseSessions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", "", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "backgroundDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "blockingDispatcher", "transportFactoryProvider", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/google/firebase/inject/Provider;)V", "applicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLogger;", "sessionCoordinator", "Lcom/google/firebase/sessions/SessionCoordinator;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "initiateSessionStart", "", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "(Lcom/google/firebase/sessions/SessionDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "subscriber", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "shouldCollectEvents", "", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FirebaseSessions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "FirebaseSessions";
    private final ApplicationInfo applicationInfo;
    private final EventGDTLogger eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final SessionCoordinator sessionCoordinator;
    private final SessionGenerator sessionGenerator;
    private final SessionsSettings sessionSettings;
    private final TimeProvider timeProvider;

    /* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1, reason: invalid class name */
    /* JADX INFO: compiled from: FirebaseSessions.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions", f = "FirebaseSessions.kt", i = {0, 0, 1, 1, 1}, l = {111, 134, 149}, m = "initiateSessionStart", n = {"this", "sessionDetails", "this", "sessionDetails", "subscribers"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FirebaseSessions.this.initiateSessionStart(null, this);
        }
    }

    public static final FirebaseSessions getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final FirebaseSessions getInstance(FirebaseApp firebaseApp) {
        return INSTANCE.getInstance(firebaseApp);
    }

    public FirebaseSessions(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, CoroutineDispatcher backgroundDispatcher, CoroutineDispatcher blockingDispatcher, Provider<TransportFactory> transportFactoryProvider) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
        Intrinsics.checkNotNullParameter(transportFactoryProvider, "transportFactoryProvider");
        this.firebaseApp = firebaseApp;
        ApplicationInfo applicationInfo = SessionEvents.INSTANCE.getApplicationInfo(firebaseApp);
        this.applicationInfo = applicationInfo;
        Context applicationContext = firebaseApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
        CoroutineDispatcher coroutineDispatcher = backgroundDispatcher;
        SessionsSettings sessionsSettings = new SessionsSettings(applicationContext, blockingDispatcher, coroutineDispatcher, firebaseInstallations, applicationInfo);
        this.sessionSettings = sessionsSettings;
        Time time = new Time();
        this.timeProvider = time;
        EventGDTLogger eventGDTLogger = new EventGDTLogger(transportFactoryProvider);
        this.eventGDTLogger = eventGDTLogger;
        this.sessionCoordinator = new SessionCoordinator(firebaseInstallations, eventGDTLogger);
        SessionGenerator sessionGenerator = new SessionGenerator(shouldCollectEvents(), time, null, 4, null);
        this.sessionGenerator = sessionGenerator;
        final SessionInitiator sessionInitiator = new SessionInitiator(time, coroutineDispatcher, new SessionInitiateListener() { // from class: com.google.firebase.sessions.FirebaseSessions$sessionInitiateListener$1
            @Override // com.google.firebase.sessions.SessionInitiateListener
            public Object onInitiateSession(SessionDetails sessionDetails, Continuation<? super Unit> continuation) throws Throwable {
                Object objInitiateSessionStart = this.this$0.initiateSessionStart(sessionDetails, continuation);
                return objInitiateSessionStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInitiateSessionStart : Unit.INSTANCE;
            }
        }, sessionsSettings, sessionGenerator);
        final Context applicationContext2 = firebaseApp.getApplicationContext().getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks());
            firebaseApp.addLifecycleEventListener(new FirebaseAppLifecycleListener() { // from class: com.google.firebase.sessions.-$$Lambda$FirebaseSessions$oR81NTTllSLpO2I7m_BxJeraP0c
                @Override // com.google.firebase.FirebaseAppLifecycleListener
                public final void onDeleted(String str, FirebaseOptions firebaseOptions) {
                    FirebaseSessions.m402_init_$lambda0(applicationContext2, sessionInitiator, str, firebaseOptions);
                }
            });
        } else {
            Log.e(TAG, "Failed to register lifecycle callbacks, unexpected context " + applicationContext2.getClass() + '.');
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    public static final void m402_init_$lambda0(Context context, SessionInitiator sessionInitiator, String str, FirebaseOptions firebaseOptions) {
        Intrinsics.checkNotNullParameter(sessionInitiator, "$sessionInitiator");
        Log.w(TAG, "FirebaseApp instance deleted. Sessions library will not collect session data.");
        ((Application) context).unregisterActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks());
    }

    public final void register(SessionSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        FirebaseSessionsDependencies.INSTANCE.register$com_google_firebase_firebase_sessions(subscriber);
        Log.d(TAG, "Registering Sessions SDK subscriber with name: " + subscriber.getSessionSubscriberName() + ", data collection enabled: " + subscriber.isDataCollectionEnabled());
        if (this.sessionGenerator.getHasGenerateSession()) {
            subscriber.onSessionChanged(new SessionSubscriber.SessionDetails(this.sessionGenerator.getCurrentSession().getSessionId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:53:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:57:0x0107  */
    /* JADX WARN: Code duplicated, block: B:59:0x010f A[Catch: IllegalStateException -> 0x0033, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IllegalStateException -> 0x0033, blocks: (B:13:0x002e, B:59:0x010f), top: B:66:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x012a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initiateSessionStart(SessionDetails sessionDetails, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FirebaseSessions firebaseSessions;
        FirebaseSessions firebaseSessions2;
        SessionDetails sessionDetails2;
        Map<SessionSubscriber.Name, ? extends SessionSubscriber> map;
        SessionEvent sessionEventStartSession;
        SessionCoordinator sessionCoordinator;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object registeredSubscribers$com_google_firebase_firebase_sessions = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
                FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = sessionDetails;
                anonymousClass1.label = 1;
                registeredSubscribers$com_google_firebase_firebase_sessions = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(anonymousClass1);
                if (registeredSubscribers$com_google_firebase_firebase_sessions == coroutine_suspended) {
                    return coroutine_suspended;
                }
                firebaseSessions = this;
            } else {
                if (i == 1) {
                    sessionDetails = (SessionDetails) anonymousClass1.L$1;
                    firebaseSessions = (FirebaseSessions) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
                } else if (i == 2) {
                    map = (Map) anonymousClass1.L$2;
                    sessionDetails2 = (SessionDetails) anonymousClass1.L$1;
                    firebaseSessions2 = (FirebaseSessions) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
                    if (!firebaseSessions2.sessionSettings.getSessionsEnabled()) {
                        Log.d(TAG, "Sessions SDK disabled. Events will not be sent.");
                        return Unit.INSTANCE;
                    }
                    if (!firebaseSessions2.sessionGenerator.getCollectEvents()) {
                        Log.d(TAG, "Sessions SDK has dropped this session due to sampling.");
                        return Unit.INSTANCE;
                    }
                    sessionEventStartSession = SessionEvents.INSTANCE.startSession(firebaseSessions2.firebaseApp, sessionDetails2, firebaseSessions2.sessionSettings, map);
                    sessionCoordinator = firebaseSessions2.sessionCoordinator;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.label = 3;
                    if (sessionCoordinator.attemptLoggingSessionEvent(sessionEventStartSession, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
                }
                return Unit.INSTANCE;
            }
            Map<SessionSubscriber.Name, ? extends SessionSubscriber> map2 = (Map) registeredSubscribers$com_google_firebase_firebase_sessions;
            if (map2.isEmpty()) {
                Log.d(TAG, "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
                return Unit.INSTANCE;
            }
            Iterator it = map2.values().iterator();
            while (it.hasNext()) {
                ((SessionSubscriber) it.next()).onSessionChanged(new SessionSubscriber.SessionDetails(sessionDetails.getSessionId()));
            }
            Collection<? extends SessionSubscriber> collectionValues = map2.values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator it2 = collectionValues.iterator();
                while (it2.hasNext()) {
                    if (((SessionSubscriber) it2.next()).isDataCollectionEnabled()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                Log.d(TAG, "Data Collection is disabled for all subscribers. Skipping this Session Event");
                return Unit.INSTANCE;
            }
            Log.d(TAG, "Data Collection is enabled for at least one Subscriber");
            SessionsSettings sessionsSettings = firebaseSessions.sessionSettings;
            anonymousClass1.L$0 = firebaseSessions;
            anonymousClass1.L$1 = sessionDetails;
            anonymousClass1.L$2 = map2;
            anonymousClass1.label = 2;
            if (sessionsSettings.updateSettings(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            firebaseSessions2 = firebaseSessions;
            sessionDetails2 = sessionDetails;
            map = map2;
            if (!firebaseSessions2.sessionSettings.getSessionsEnabled()) {
                Log.d(TAG, "Sessions SDK disabled. Events will not be sent.");
                return Unit.INSTANCE;
            }
            if (!firebaseSessions2.sessionGenerator.getCollectEvents()) {
                Log.d(TAG, "Sessions SDK has dropped this session due to sampling.");
                return Unit.INSTANCE;
            }
            sessionEventStartSession = SessionEvents.INSTANCE.startSession(firebaseSessions2.firebaseApp, sessionDetails2, firebaseSessions2.sessionSettings, map);
            sessionCoordinator = firebaseSessions2.sessionCoordinator;
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 3;
            if (sessionCoordinator.attemptLoggingSessionEvent(sessionEventStartSession, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (IllegalStateException e) {
            Log.w(TAG, "FirebaseApp is not initialized. Sessions library will not collect session data.", e);
        }
    }

    private final boolean shouldCollectEvents() {
        return Math.random() <= this.sessionSettings.getSamplingRate();
    }

    /* JADX INFO: compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", "", "()V", "TAG", "", "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance$annotations", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "app", "Lcom/google/firebase/FirebaseApp;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final FirebaseSessions getInstance() {
            return getInstance(FirebaseKt.getApp(Firebase.INSTANCE));
        }

        @JvmStatic
        public final FirebaseSessions getInstance(FirebaseApp app) {
            Intrinsics.checkNotNullParameter(app, "app");
            Object obj = app.get(FirebaseSessions.class);
            Intrinsics.checkNotNullExpressionValue(obj, "app.get(FirebaseSessions::class.java)");
            return (FirebaseSessions) obj;
        }
    }
}

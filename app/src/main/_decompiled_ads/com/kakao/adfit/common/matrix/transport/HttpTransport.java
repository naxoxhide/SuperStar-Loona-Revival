package com.kakao.adfit.common.matrix.transport;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.net.HttpHeaders;
import com.kakao.adfit.common.matrix.MatrixItemType;
import com.kakao.adfit.e.MatrixEvent;
import com.kakao.adfit.i.e;
import com.kakao.adfit.i.j;
import com.kakao.adfit.j.d;
import com.kakao.adfit.k.f;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HttpTransport.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0002\u0007?B?\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010(\u001a\u00020&\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u0012¢\u0006\u0004\b<\u0010=J-\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\u0007\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0007\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0018\u0010\u0007\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0007\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0018\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u0007\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010'R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010,R\u0014\u00102\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006@"}, d2 = {"Lcom/kakao/adfit/common/matrix/transport/HttpTransport;", "Lcom/kakao/adfit/i/e;", "R", "Ljava/net/HttpURLConnection;", "Lkotlin/Function1;", "Ljava/io/BufferedWriter;", "block", "a", "(Ljava/net/HttpURLConnection;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/kakao/adfit/common/matrix/MatrixItemType;", "itemType", "Lcom/kakao/adfit/common/matrix/transport/HttpTransport$DataCategory;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "connection", "", "message", "Lcom/kakao/adfit/i/j;", "", "", "responseCode", "rateLimitHeader", "retryAfterHeader", "errorCode", "dataCategory", "Ljava/util/Date;", "date", "", "", "Ljava/net/Proxy;", "proxy", "Ljava/net/URL;", "url", "Lcom/kakao/adfit/e/h;", "event", "close", "Lcom/kakao/adfit/j/d;", "Lcom/kakao/adfit/j/d;", "serializer", "Lcom/kakao/adfit/j/c;", "Lcom/kakao/adfit/j/c;", "currentDateProvider", "c", "Ljava/net/Proxy;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "I", "connectionTimeoutMillis", "e", "readTimeoutMillis", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/net/URL;", "storeUrl", "g", "Ljava/lang/String;", "authHeader", "", "h", "Ljava/util/Map;", "retryAfterLimit", "Lcom/kakao/adfit/e/b;", "dsn", "<init>", "(Lcom/kakao/adfit/e/b;Lcom/kakao/adfit/j/d;Lcom/kakao/adfit/j/c;Ljava/net/Proxy;II)V", "i", "DataCategory", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class HttpTransport implements e {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final d serializer;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.kakao.adfit.j.c currentDateProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Proxy proxy;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int connectionTimeoutMillis;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int readTimeoutMillis;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final URL storeUrl;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String authHeader;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Map<DataCategory, Date> retryAfterLimit;

    /* JADX INFO: compiled from: HttpTransport.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0083\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/kakao/adfit/common/matrix/transport/HttpTransport$DataCategory;", "", "", "a", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "category", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "All", "Default", "Error", "Session", "Attachment", "Transaction", "Security", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private enum DataCategory {
        All("__all__"),
        Default("default"),
        Error("error"),
        Session("session"),
        Attachment("attachment"),
        Transaction("transaction"),
        Security("security"),
        Unknown("unknown");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final String category;

        /* JADX INFO: renamed from: com.kakao.adfit.common.matrix.transport.HttpTransport$DataCategory$a, reason: from kotlin metadata */
        /* JADX INFO: compiled from: HttpTransport.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/kakao/adfit/common/matrix/transport/HttpTransport$DataCategory$a;", "", "", "category", "Lcom/kakao/adfit/common/matrix/transport/HttpTransport$DataCategory;", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final DataCategory a(String category) {
                Intrinsics.checkNotNullParameter(category, "category");
                try {
                    return DataCategory.valueOf(StringsKt.capitalize(category));
                } catch (IllegalArgumentException unused) {
                    f.e("Unknown category: " + category);
                    return DataCategory.Unknown;
                }
            }
        }

        DataCategory(String str) {
            this.category = str;
        }

        public final String getCategory() {
            return this.category;
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.common.matrix.transport.HttpTransport$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: HttpTransport.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/common/matrix/transport/HttpTransport$a;", "", "Lcom/kakao/adfit/e/b;", "Ljava/net/URL;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "a", "", "HTTP_RETRY_AFTER_DEFAULT_DELAY_MILLIS", "J", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String a(com.kakao.adfit.e.b bVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("Sentry sentry_version=").append(7);
            sb.append(",sentry_client=").append("com.kakao.adfit.ads/3.13.6");
            sb.append(",sentry_key=").append(bVar.getPublicKey());
            String strB = bVar.getSecretKey();
            boolean z = false;
            if (strB != null) {
                if (strB.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                sb.append(",sentry_secret=").append(bVar.getSecretKey());
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final URL b(com.kakao.adfit.e.b bVar) {
            try {
                URI uriC = bVar.getCom.facebook.share.internal.ShareConstants.MEDIA_URI java.lang.String();
                URL url = uriC.resolve(uriC.getPath() + "/store/").toURL();
                Intrinsics.checkNotNullExpressionValue(url, "uri.let { it.resolve(it.…th + \"/store/\").toURL() }");
                return url;
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e);
            } catch (URISyntaxException e2) {
                throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e2);
            }
        }
    }

    /* JADX INFO: compiled from: HttpTransport.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MatrixItemType.values().length];
            iArr[MatrixItemType.Event.ordinal()] = 1;
            iArr[MatrixItemType.Session.ordinal()] = 2;
            iArr[MatrixItemType.Attachment.ordinal()] = 3;
            iArr[MatrixItemType.Transaction.ordinal()] = 4;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: HttpTransport.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/io/BufferedWriter;", "writer", "", "a", "(Ljava/io/BufferedWriter;)V"}, k = 3, mv = {1, 6, 0})
    static final class c extends Lambda implements Function1<BufferedWriter, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MatrixEvent f1714b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MatrixEvent matrixEvent) {
            super(1);
            this.f1714b = matrixEvent;
        }

        public final void a(BufferedWriter writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            HttpTransport.this.serializer.a(this.f1714b, writer);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BufferedWriter bufferedWriter) {
            a(bufferedWriter);
            return Unit.INSTANCE;
        }
    }

    public HttpTransport(com.kakao.adfit.e.b dsn, d serializer, com.kakao.adfit.j.c currentDateProvider, Proxy proxy, int i, int i2) {
        Intrinsics.checkNotNullParameter(dsn, "dsn");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(currentDateProvider, "currentDateProvider");
        this.serializer = serializer;
        this.currentDateProvider = currentDateProvider;
        this.proxy = proxy;
        this.connectionTimeoutMillis = i;
        this.readTimeoutMillis = i2;
        Companion companion = INSTANCE;
        this.storeUrl = companion.b(dsn);
        this.authHeader = companion.a(dsn);
        this.retryAfterLimit = new ConcurrentHashMap();
    }

    private final boolean a(int responseCode) {
        if (responseCode != 200) {
            if (!(200 <= responseCode && responseCode < 300)) {
                return false;
            }
        }
        return true;
    }

    private final DataCategory b(MatrixItemType itemType) {
        int i = b.a[itemType.ordinal()];
        if (i == 1) {
            return DataCategory.Error;
        }
        if (i == 2) {
            return DataCategory.Session;
        }
        if (i != 3) {
            return i != 4 ? DataCategory.Unknown : DataCategory.Transaction;
        }
        return DataCategory.Attachment;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final HttpURLConnection a(Proxy proxy) {
        return a(this.storeUrl, proxy);
    }

    public final HttpURLConnection a(URL url, Proxy proxy) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        if (proxy == null) {
            proxy = Proxy.NO_PROXY;
        }
        URLConnection uRLConnectionOpenConnection = url.openConnection(proxy);
        Objects.requireNonNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        return (HttpURLConnection) uRLConnectionOpenConnection;
    }

    @Override // com.kakao.adfit.i.e
    public j a(MatrixEvent event) throws IOException {
        Intrinsics.checkNotNullParameter(event, "event");
        HttpURLConnection httpURLConnectionA = a();
        try {
            try {
                a(httpURLConnectionA, new c(event));
                return a(httpURLConnectionA, "Event sent " + event.getId() + " successfully");
            } catch (IOException e) {
                f.b("An exception occurred while submitting the event to the Sentry server.", e);
                return a(httpURLConnectionA, "Event sent " + event.getId() + " successfully");
            }
        } catch (Throwable unused) {
            return a(httpURLConnectionA, "Event sent " + event.getId() + " successfully");
        }
    }

    public /* synthetic */ HttpTransport(com.kakao.adfit.e.b bVar, d dVar, com.kakao.adfit.j.c cVar, Proxy proxy, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, dVar, cVar, (i3 & 8) != 0 ? null : proxy, (i3 & 16) != 0 ? 5000 : i, (i3 & 32) != 0 ? 5000 : i2);
    }

    private final <R> R a(HttpURLConnection httpURLConnection, Function1<? super BufferedWriter, ? extends R> function1) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                Writer outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, Charsets.UTF_8);
                BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
                try {
                    R rInvoke = function1.invoke(bufferedWriter);
                    CloseableKt.closeFinally(bufferedWriter, null);
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    CloseableKt.closeFinally(outputStream, null);
                    return rInvoke;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedWriter, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(gZIPOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(outputStream, th5);
                throw th6;
            }
        }
    }

    @Override // com.kakao.adfit.i.e
    public boolean a(MatrixItemType itemType) {
        Date date;
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Date date2 = new Date(this.currentDateProvider.a());
        Date date3 = this.retryAfterLimit.get(DataCategory.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        DataCategory dataCategoryB = b(itemType);
        if (dataCategoryB == DataCategory.Unknown || (date = this.retryAfterLimit.get(dataCategoryB)) == null) {
            return false;
        }
        return !date2.after(date);
    }

    private final HttpURLConnection a() throws IOException {
        HttpURLConnection httpURLConnectionA = a(this.proxy);
        httpURLConnectionA.setRequestMethod("POST");
        httpURLConnectionA.setDoOutput(true);
        httpURLConnectionA.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpURLConnectionA.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnectionA.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpURLConnectionA.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
        httpURLConnectionA.setRequestProperty("X-Sentry-Auth", this.authHeader);
        httpURLConnectionA.setRequestProperty(HttpHeaders.CONNECTION, "close");
        httpURLConnectionA.setConnectTimeout(this.connectionTimeoutMillis);
        httpURLConnectionA.setReadTimeout(this.readTimeoutMillis);
        httpURLConnectionA.connect();
        return httpURLConnectionA;
    }

    private final j a(HttpURLConnection connection, String message) {
        try {
            int responseCode = connection.getResponseCode();
            a(connection, responseCode);
            if (!a(responseCode)) {
                f.b("Request failed, API returned " + responseCode);
                return j.INSTANCE.a(responseCode);
            }
            return j.INSTANCE.b(responseCode);
        } catch (IOException unused) {
            f.b("Error reading and logging the response stream");
            return j.Companion.a(j.INSTANCE, 0, 1, null);
        } finally {
            a(connection);
        }
    }

    private final void a(HttpURLConnection connection) {
        try {
            connection.getInputStream().close();
        } catch (IOException unused) {
        } finally {
            connection.disconnect();
        }
    }

    private final void a(HttpURLConnection connection, int responseCode) {
        a(connection.getHeaderField("X-Sentry-Rate-Limits"), connection.getHeaderField(HttpHeaders.RETRY_AFTER), responseCode);
    }

    private final void a(String rateLimitHeader, String retryAfterHeader, int errorCode) {
        if (rateLimitHeader == null) {
            if (errorCode == 429) {
                a(DataCategory.All, new Date(this.currentDateProvider.a() + a(retryAfterHeader)));
                return;
            }
            return;
        }
        Iterator it = StringsKt.split$default((CharSequence) rateLimitHeader, new String[]{","}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.replace$default((String) it.next(), " ", "", false, 4, (Object) null), new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
            if (!listSplit$default.isEmpty()) {
                long jA = a((String) listSplit$default.get(0));
                if (listSplit$default.size() > 1) {
                    Date date = new Date(this.currentDateProvider.a() + jA);
                    String str = (String) listSplit$default.get(1);
                    if (str.length() == 0) {
                        a(DataCategory.All, date);
                    } else {
                        Iterator it2 = StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null).iterator();
                        while (it2.hasNext()) {
                            DataCategory dataCategoryA = DataCategory.INSTANCE.a((String) it2.next());
                            if (DataCategory.Unknown != dataCategoryA) {
                                a(dataCategoryA, date);
                            }
                        }
                    }
                }
            }
        }
    }

    private final void a(DataCategory dataCategory, Date date) {
        Date date2 = this.retryAfterLimit.get(dataCategory);
        if (date2 == null || date.after(date2)) {
            this.retryAfterLimit.put(dataCategory, date);
        }
    }

    private final long a(String retryAfterHeader) {
        Double doubleOrNull;
        if (retryAfterHeader == null || (doubleOrNull = StringsKt.toDoubleOrNull(retryAfterHeader)) == null) {
            return 60000L;
        }
        return (long) (doubleOrNull.doubleValue() * ((double) 1000));
    }
}

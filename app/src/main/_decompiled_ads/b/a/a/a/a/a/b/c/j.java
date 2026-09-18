package b.a.a.a.a.a.b.c;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SkipProxySelector.java */
/* JADX INFO: loaded from: classes.dex */
class j extends ProxySelector {
    private static final List<Proxy> d = Collections.singletonList(Proxy.NO_PROXY);
    private final ProxySelector a = ProxySelector.getDefault();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f46b;
    private final int c;

    private j(String str, int i) {
        this.f46b = str;
        this.c = i;
    }

    static void a(String str, int i) {
        ProxySelector.setDefault(new j(str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.f46b.equalsIgnoreCase(uri.getHost()) && this.c == uri.getPort()) ? d : this.a.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}

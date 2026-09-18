package com.mbridge.msdk.foundation.same.net.e;

import android.os.SystemClock;
import com.mbridge.msdk.foundation.same.net.g;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.l;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: BasicNetwork.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements g {
    private static final String a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.net.stack.a f2142b;
    private final com.mbridge.msdk.foundation.same.net.c c;

    public a(com.mbridge.msdk.foundation.same.net.stack.a aVar, com.mbridge.msdk.foundation.same.net.c cVar) {
        this.f2142b = aVar;
        this.c = cVar;
    }

    @Override // com.mbridge.msdk.foundation.same.net.g
    public final c a(i<?> iVar) throws com.mbridge.msdk.foundation.same.net.a.a {
        b bVarPerformRequest;
        byte[] bArrA;
        Object obj;
        byte[] bArrA2;
        b bVarPerformRequest2;
        if (iVar == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        l lVarM = iVar.m();
        String str = "SocketTimeoutException ex= ";
        String str2 = "perform-discard-cancelled";
        if ((lVarM != null ? lVarM.a() : 0) <= 0) {
            if (iVar.c()) {
                iVar.a("perform-discard-cancelled");
                this.c.b(iVar);
                throw new com.mbridge.msdk.foundation.same.net.a.a(-2, null);
            }
            try {
                try {
                    iVar.f();
                    bVarPerformRequest2 = this.f2142b.performRequest(iVar);
                    try {
                        int iA = bVarPerformRequest2.a();
                        bArrA2 = iVar.a(bVarPerformRequest2, this.c);
                        try {
                            SystemClock.elapsedRealtime();
                            if (iA < 200 || iA > 399) {
                                throw new IOException();
                            }
                            return new c(iA, bArrA2, bVarPerformRequest2.b());
                        } catch (IOException e) {
                            e = e;
                            SystemClock.elapsedRealtime();
                            String str3 = "IOException ex= " + e.getMessage();
                            if (bVarPerformRequest2 == null) {
                                throw new com.mbridge.msdk.foundation.same.net.a.a(14, null);
                            }
                            int iA2 = bVarPerformRequest2.a();
                            if (bArrA2 != null) {
                                c cVar = new c(iA2, bArrA2, bVarPerformRequest2.b());
                                if (iA2 >= 400 && iA2 <= 499) {
                                    throw new com.mbridge.msdk.foundation.same.net.a.a(6, cVar);
                                }
                                if (iA2 >= 500 && iA2 <= 599) {
                                    throw new com.mbridge.msdk.foundation.same.net.a.a(7, cVar);
                                }
                                throw new com.mbridge.msdk.foundation.same.net.a.a(2, cVar);
                            }
                            throw new com.mbridge.msdk.foundation.same.net.a.a(15, null);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bArrA2 = null;
                    }
                } catch (ConnectException e3) {
                    SystemClock.elapsedRealtime();
                    String str4 = "ConnectException ex= " + e3.getMessage();
                    throw new com.mbridge.msdk.foundation.same.net.a.a(12, null);
                } catch (MalformedURLException e4) {
                    SystemClock.elapsedRealtime();
                    String str5 = "MalformedURLException ex= " + e4.getMessage();
                    throw new com.mbridge.msdk.foundation.same.net.a.a(4, null);
                } catch (SocketTimeoutException e5) {
                    SystemClock.elapsedRealtime();
                    String str6 = "SocketTimeoutException ex= " + e5.getMessage();
                    throw new com.mbridge.msdk.foundation.same.net.a.a(10, null);
                } catch (UnknownHostException e6) {
                    SystemClock.elapsedRealtime();
                    String str7 = "UnknownHostException ex= " + e6.getMessage();
                    throw new com.mbridge.msdk.foundation.same.net.a.a(9, null);
                } catch (SSLProtocolException e7) {
                    SystemClock.elapsedRealtime();
                    String str8 = "SSLProtocolException ex= " + e7.getMessage();
                    throw new com.mbridge.msdk.foundation.same.net.a.a(11, null);
                } catch (ConnectTimeoutException e8) {
                    SystemClock.elapsedRealtime();
                    String str9 = "ConnectTimeoutException ex= " + e8.getMessage();
                    throw new com.mbridge.msdk.foundation.same.net.a.a(3, null);
                }
            } catch (IOException e9) {
                e = e9;
                bArrA2 = null;
                bVarPerformRequest2 = null;
            }
        } else {
            while (!iVar.c()) {
                try {
                    try {
                        iVar.f();
                        try {
                            bVarPerformRequest = this.f2142b.performRequest(iVar);
                            try {
                                int iA3 = bVarPerformRequest.a();
                                try {
                                    bArrA = iVar.a(bVarPerformRequest, this.c);
                                    try {
                                        SystemClock.elapsedRealtime();
                                        try {
                                            if (iA3 < 200 || iA3 > 399) {
                                                throw new IOException();
                                            }
                                            return new c(iA3, bArrA, bVarPerformRequest.b());
                                        } catch (ConnectException e10) {
                                            e = e10;
                                            str = str;
                                            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            String str10 = "ConnectException ex= " + e.getMessage();
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(12, null), jElapsedRealtime2);
                                            str = str;
                                            str2 = str2;
                                        } catch (MalformedURLException e11) {
                                            e = e11;
                                            str = str;
                                            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            String str11 = "MalformedURLException ex= " + e.getMessage();
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(4, null), jElapsedRealtime3);
                                            str = str;
                                            str2 = str2;
                                        } catch (SocketTimeoutException e12) {
                                            e = e12;
                                            str = str;
                                            long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            str = str;
                                            String str12 = str + e.getMessage();
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(10, null), jElapsedRealtime4);
                                            str2 = str2;
                                        } catch (UnknownHostException e13) {
                                            e = e13;
                                            str = str;
                                            long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            String str13 = "UnknownHostException ex= " + e.getMessage();
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(9, null), jElapsedRealtime5);
                                            str = str;
                                            str2 = str2;
                                        } catch (SSLProtocolException e14) {
                                            e = e14;
                                            str = str;
                                            long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            String str14 = "SSLProtocolException ex= " + e.getMessage();
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(11, null), jElapsedRealtime6);
                                            str = str;
                                            str2 = str2;
                                        } catch (ConnectTimeoutException e15) {
                                            e = e15;
                                            str = str;
                                            long jElapsedRealtime7 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            String str15 = "ConnectTimeoutException ex= " + e.getMessage();
                                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(3, null), jElapsedRealtime7);
                                            str = str;
                                            str2 = str2;
                                        } catch (IOException e16) {
                                            e = e16;
                                        }
                                    } catch (IOException e17) {
                                        e = e17;
                                        str2 = str2;
                                    }
                                } catch (ConnectException e18) {
                                    e = e18;
                                    str2 = str2;
                                } catch (MalformedURLException e19) {
                                    e = e19;
                                    str2 = str2;
                                } catch (SocketTimeoutException e20) {
                                    e = e20;
                                    str2 = str2;
                                } catch (UnknownHostException e21) {
                                    e = e21;
                                    str2 = str2;
                                } catch (SSLProtocolException e22) {
                                    e = e22;
                                    str2 = str2;
                                } catch (ConnectTimeoutException e23) {
                                    e = e23;
                                    str2 = str2;
                                }
                            } catch (IOException e24) {
                                e = e24;
                                bArrA = null;
                            }
                        } catch (ConnectException e25) {
                            e = e25;
                            long jElapsedRealtime8 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            String str16 = "ConnectException ex= " + e.getMessage();
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(12, null), jElapsedRealtime8);
                            str = str;
                            str2 = str2;
                        } catch (MalformedURLException e26) {
                            e = e26;
                            long jElapsedRealtime9 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            String str17 = "MalformedURLException ex= " + e.getMessage();
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(4, null), jElapsedRealtime9);
                            str = str;
                            str2 = str2;
                        } catch (SocketTimeoutException e27) {
                            e = e27;
                            long jElapsedRealtime10 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            str = str;
                            String str18 = str + e.getMessage();
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(10, null), jElapsedRealtime10);
                            str2 = str2;
                        } catch (UnknownHostException e28) {
                            e = e28;
                            long jElapsedRealtime11 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            String str19 = "UnknownHostException ex= " + e.getMessage();
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(9, null), jElapsedRealtime11);
                            str = str;
                            str2 = str2;
                        } catch (SSLProtocolException e29) {
                            e = e29;
                            long jElapsedRealtime12 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            String str110 = "SSLProtocolException ex= " + e.getMessage();
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(11, null), jElapsedRealtime12);
                            str = str;
                            str2 = str2;
                        } catch (ConnectTimeoutException e30) {
                            e = e30;
                            long jElapsedRealtime13 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            String str111 = "ConnectTimeoutException ex= " + e.getMessage();
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(3, null), jElapsedRealtime13);
                            str = str;
                            str2 = str2;
                        }
                    } catch (ConnectException e31) {
                        e = e31;
                    } catch (MalformedURLException e32) {
                        e = e32;
                    } catch (SocketTimeoutException e33) {
                        e = e33;
                    } catch (UnknownHostException e34) {
                        e = e34;
                    } catch (SSLProtocolException e35) {
                        e = e35;
                    } catch (ConnectTimeoutException e36) {
                        e = e36;
                    }
                } catch (IOException e37) {
                    e = e37;
                    bVarPerformRequest = null;
                }
                long jElapsedRealtime14 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                str = str;
                String str20 = "IOException ex= " + e.getMessage();
                if (bVarPerformRequest == null) {
                    a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(14, null), jElapsedRealtime14);
                } else {
                    int iA4 = bVarPerformRequest.a();
                    if (bArrA != null) {
                        c cVar2 = new c(iA4, bArrA, bVarPerformRequest.b());
                        if (iA4 >= 400 && iA4 <= 499) {
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(6, null), jElapsedRealtime14);
                            obj = null;
                        } else {
                            if (iA4 >= 500 && iA4 <= 599) {
                                throw new com.mbridge.msdk.foundation.same.net.a.a(7, cVar2);
                            }
                            obj = null;
                            a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(2, null), jElapsedRealtime14);
                        }
                        str = str;
                    } else {
                        a(iVar, new com.mbridge.msdk.foundation.same.net.a.a(15, null), jElapsedRealtime14);
                    }
                    str2 = str2;
                }
                str = str;
                str2 = str2;
            }
            iVar.a(str2);
            this.c.b(iVar);
            throw new com.mbridge.msdk.foundation.same.net.a.a(-2, null);
        }
    }

    private void a(i<?> iVar, com.mbridge.msdk.foundation.same.net.a.a aVar, long j) throws com.mbridge.msdk.foundation.same.net.a.a {
        if (iVar == null || aVar == null) {
            throw new com.mbridge.msdk.foundation.same.net.a.a(4, null);
        }
        boolean z = false;
        try {
            l lVarM = iVar.m();
            if (lVarM != null) {
                long jF = lVarM.f();
                if (lVarM.a(aVar) && j < jF) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        }
        if (z) {
            this.c.e(iVar);
            return;
        }
        throw aVar;
    }
}

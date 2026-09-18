package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzamv implements zzalz {
    protected final zzamx zza;

    @Deprecated
    protected final zzamu zzb;
    private final zzamu zzc;

    public zzamv(zzamu zzamuVar) {
        zzamx zzamxVar = new zzamx(4096);
        this.zzc = zzamuVar;
        this.zzb = zzamuVar;
        this.zza = zzamxVar;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:145:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x02db  */
    /* JADX WARN: Code duplicated, block: B:150:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:164:0x0336  */
    /* JADX WARN: Code duplicated, block: B:175:0x02b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x038f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x0389 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzalz
    public zzamc zza(zzamg zzamgVar) throws Throwable {
        zzane zzaneVar;
        byte[] bArr;
        int iZzb;
        zzani zzaniVar;
        zzamc zzamcVar;
        zzani zzaniVar2;
        int iZzb2;
        Map mapEmptyMap;
        byte[] byteArray;
        byte[] bArrZzb;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            boolean z = true;
            try {
                zzalp zzalpVarZzd = zzamgVar.zzd();
                if (zzalpVarZzd == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str = zzalpVarZzd.zzb;
                    if (str != null) {
                        map.put(HttpHeaders.IF_NONE_MATCH, str);
                    }
                    long j = zzalpVarZzd.zzd;
                    if (j > 0) {
                        map.put(HttpHeaders.IF_MODIFIED_SINCE, zzand.zzc(j));
                    }
                    mapEmptyMap = map;
                }
                String strZzk = zzamgVar.zzk();
                HashMap map2 = new HashMap();
                map2.putAll(mapEmptyMap);
                map2.putAll(zzamgVar.zzl());
                URL url = new URL(strZzk);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
                int iZzb3 = zzamgVar.zzb();
                httpURLConnection.setConnectTimeout(iZzb3);
                httpURLConnection.setReadTimeout(iZzb3);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                "https".equals(url.getProtocol());
                try {
                    for (String str2 : map2.keySet()) {
                        httpURLConnection.setRequestProperty(str2, (String) map2.get(str2));
                    }
                    if (zzamgVar.zza() != 0) {
                        httpURLConnection.setRequestMethod("POST");
                        byte[] bArrZzx = zzamgVar.zzx();
                        if (bArrZzx != null) {
                            httpURLConnection.setDoOutput(true);
                            if (!httpURLConnection.getRequestProperties().containsKey(HttpHeaders.CONTENT_TYPE)) {
                                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
                            }
                            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            dataOutputStream.write(bArrZzx);
                            dataOutputStream.close();
                        }
                    } else {
                        httpURLConnection.setRequestMethod("GET");
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        try {
                            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (!z) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    zzamgVar.zza();
                    if ((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) {
                        zzaneVar = new zzane(responseCode, zzang.zza(httpURLConnection.getHeaderFields()), -1, null);
                        httpURLConnection.disconnect();
                    } else {
                        try {
                            zzaneVar = new zzane(responseCode, zzang.zza(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new zzanf(httpURLConnection));
                        } catch (Throwable th2) {
                            th = th2;
                            if (!z) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (IOException e) {
                                    e = e;
                                    zzaneVar = null;
                                    bArr = null;
                                    if (e instanceof SocketTimeoutException) {
                                        zzaniVar = new zzani("socket", new zzamo(), null);
                                    } else {
                                        if (!(e instanceof MalformedURLException)) {
                                            throw new RuntimeException("Bad URL ".concat(String.valueOf(zzamgVar.zzk())), e);
                                        }
                                        if (zzaneVar != null) {
                                            throw new zzamd(e);
                                        }
                                        iZzb = zzaneVar.zzb();
                                        zzams.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb), zzamgVar.zzk());
                                        if (bArr != null) {
                                            zzamcVar = new zzamc(iZzb, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaneVar.zzd());
                                            if (iZzb == 401) {
                                            }
                                            zzaniVar = new zzani("auth", new zzalo(zzamcVar), null);
                                        } else {
                                            zzaniVar = new zzani("network", new zzamb(), null);
                                        }
                                    }
                                    zzaniVar2 = zzaniVar;
                                    zzalu zzaluVarZzy = zzamgVar.zzy();
                                    iZzb2 = zzamgVar.zzb();
                                    try {
                                        zzaluVarZzy.zzc(zzaniVar2.zzb);
                                        zzamgVar.zzm(String.format("%s-retry [timeout=%s]", zzaniVar2.zza, Integer.valueOf(iZzb2)));
                                    } catch (zzamp e2) {
                                        zzamgVar.zzm(String.format("%s-timeout-giveup [timeout=%s]", zzaniVar2.zza, Integer.valueOf(iZzb2)));
                                        throw e2;
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        int iZzb4 = zzaneVar.zzb();
                        List listZzd = zzaneVar.zzd();
                        if (iZzb4 == 304) {
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            zzalp zzalpVarZzd2 = zzamgVar.zzd();
                            if (zzalpVarZzd2 == null) {
                                return new zzamc(304, (byte[]) null, true, jElapsedRealtime2, listZzd);
                            }
                            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                            if (!listZzd.isEmpty()) {
                                Iterator it = listZzd.iterator();
                                while (it.hasNext()) {
                                    treeSet.add(((zzaly) it.next()).zza());
                                }
                            }
                            ArrayList arrayList = new ArrayList(listZzd);
                            List list = zzalpVarZzd2.zzh;
                            if (list != null) {
                                if (!list.isEmpty()) {
                                    for (zzaly zzalyVar : zzalpVarZzd2.zzh) {
                                        if (!treeSet.contains(zzalyVar.zza())) {
                                            arrayList.add(zzalyVar);
                                        }
                                    }
                                }
                            } else if (!zzalpVarZzd2.zzg.isEmpty()) {
                                for (Map.Entry entry : zzalpVarZzd2.zzg.entrySet()) {
                                    if (!treeSet.contains(entry.getKey())) {
                                        arrayList.add(new zzaly((String) entry.getKey(), (String) entry.getValue()));
                                    }
                                }
                            }
                            return new zzamc(304, zzalpVarZzd2.zza, true, jElapsedRealtime2, (List) arrayList);
                        }
                        InputStream inputStreamZzc = zzaneVar.zzc();
                        if (inputStreamZzc != null) {
                            int iZza = zzaneVar.zza();
                            try {
                                zzamx zzamxVar = this.zza;
                                zzanj zzanjVar = new zzanj(zzamxVar, iZza);
                                try {
                                    bArrZzb = zzamxVar.zzb(1024);
                                    while (true) {
                                        try {
                                            int i = inputStreamZzc.read(bArrZzb);
                                            if (i == -1) {
                                                break;
                                            }
                                            zzanjVar.write(bArrZzb, 0, i);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            try {
                                                inputStreamZzc.close();
                                            } catch (IOException unused) {
                                                zzams.zzd("Error occurred when closing InputStream", new Object[0]);
                                            }
                                            zzamxVar.zza(bArrZzb);
                                            zzanjVar.close();
                                            throw th;
                                        }
                                        if (e instanceof SocketTimeoutException) {
                                            zzaniVar = new zzani("socket", new zzamo(), null);
                                        } else {
                                            if (!(e instanceof MalformedURLException)) {
                                                throw new RuntimeException("Bad URL ".concat(String.valueOf(zzamgVar.zzk())), e);
                                            }
                                            if (zzaneVar != null) {
                                                throw new zzamd(e);
                                            }
                                            iZzb = zzaneVar.zzb();
                                            zzams.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb), zzamgVar.zzk());
                                            if (bArr != null) {
                                                zzamcVar = new zzamc(iZzb, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaneVar.zzd());
                                                if (iZzb == 401 && iZzb != 403) {
                                                    if (iZzb < 400 || iZzb > 499) {
                                                        throw new zzamn(zzamcVar);
                                                    }
                                                    throw new zzalt(zzamcVar);
                                                }
                                                zzaniVar = new zzani("auth", new zzalo(zzamcVar), null);
                                            } else {
                                                zzaniVar = new zzani("network", new zzamb(), null);
                                            }
                                        }
                                        zzaniVar2 = zzaniVar;
                                        zzalu zzaluVarZzy2 = zzamgVar.zzy();
                                        iZzb2 = zzamgVar.zzb();
                                        zzaluVarZzy2.zzc(zzaniVar2.zzb);
                                        zzamgVar.zzm(String.format("%s-retry [timeout=%s]", zzaniVar2.zza, Integer.valueOf(iZzb2)));
                                    }
                                    byteArray = zzanjVar.toByteArray();
                                    try {
                                        inputStreamZzc.close();
                                    } catch (IOException unused2) {
                                        zzams.zzd("Error occurred when closing InputStream", new Object[0]);
                                    }
                                    zzamxVar.zza(bArrZzb);
                                    zzanjVar.close();
                                } catch (Throwable th4) {
                                    th = th4;
                                    bArrZzb = null;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                bArr = null;
                            }
                        } else {
                            byteArray = new byte[0];
                        }
                        try {
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            if (zzams.zzb || jElapsedRealtime3 > 3000) {
                                Object[] objArr = new Object[5];
                                objArr[0] = zzamgVar;
                                objArr[1] = Long.valueOf(jElapsedRealtime3);
                                objArr[2] = byteArray != null ? Integer.valueOf(byteArray.length) : "null";
                                objArr[3] = Integer.valueOf(iZzb4);
                                objArr[4] = Integer.valueOf(zzamgVar.zzy().zza());
                                zzams.zza("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                            }
                            if (iZzb4 < 200 || iZzb4 > 299) {
                                throw new IOException();
                            }
                            return new zzamc(iZzb4, byteArray, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listZzd);
                        } catch (IOException e4) {
                            e = e4;
                            bArr = byteArray;
                        }
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (IOException e6) {
                e = e6;
            }
        }
    }
}

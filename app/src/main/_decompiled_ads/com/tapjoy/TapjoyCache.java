package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tapjoy.internal.da;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyCache {
    public static final String CACHE_DIRECTORY_NAME = "Tapjoy/Cache/";
    public static final int CACHE_LIMIT = -1;
    public static TapjoyCache f = null;
    public static boolean unit_test_mode = false;
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TapjoyCacheMap f2706b;
    public final Vector c;
    public final ExecutorService d;
    public File e;

    public class CacheAssetThread implements Callable<Boolean> {
        public final URL a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2707b;
        public final long c;

        public CacheAssetThread(URL url, String str, long j) {
            this.a = url;
            this.f2707b = str;
            this.c = j;
            if (j <= 0) {
                this.c = 86400L;
            }
            TapjoyCache.this.c.add(TapjoyCache.a(url.toString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:106:? A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:90:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v13, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v22 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v12, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r7v13, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v21, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r7v23 */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9 */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Throwable {
            Exception e;
            ?? r7;
            SocketTimeoutException e2;
            ?? r8;
            Throwable th;
            BufferedInputStream bufferedInputStream;
            int responseCode;
            TapjoyCache tapjoyCache = TapjoyCache.this;
            String string = this.a.toString();
            tapjoyCache.getClass();
            String strA = TapjoyCache.a(string);
            if (TapjoyCache.this.f2706b.containsKey(strA)) {
                if (new File(TapjoyCache.this.f2706b.get(strA).getLocalFilePath()).exists()) {
                    if (this.c != 0) {
                        TapjoyCache.this.f2706b.get(strA).resetTimeToLive(this.c);
                    } else {
                        TapjoyCache.this.f2706b.get(strA).resetTimeToLive(86400L);
                    }
                    TapjoyLog.d("TapjoyCache", "Reseting time to live for " + this.a.toString());
                    TapjoyCache.this.c.remove(strA);
                    return Boolean.TRUE;
                }
                TapjoyCache.getInstance().removeAssetFromCache(strA);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                File file = new File(TapjoyCache.this.e + RemoteSettings.FORWARD_SLASH_STRING + TapjoyUtil.SHA256(strA));
                ?? bufferedOutputStream = " to ";
                TapjoyLog.d("TapjoyCache", "Downloading and caching asset from: " + this.a + " to " + file);
                BufferedInputStream bufferedInputStream2 = null;
                ?? r6 = 0;
                BufferedInputStream bufferedInputStream3 = null;
                try {
                    try {
                        URLConnection uRLConnectionOpenConnection = this.a.openConnection();
                        uRLConnectionOpenConnection.setConnectTimeout(15000);
                        uRLConnectionOpenConnection.setReadTimeout(30000);
                        uRLConnectionOpenConnection.connect();
                        if ((uRLConnectionOpenConnection instanceof HttpURLConnection) && (responseCode = ((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode()) != 200) {
                            throw new IOException("Unexpected response code: " + responseCode);
                        }
                        bufferedInputStream = new BufferedInputStream(uRLConnectionOpenConnection.getInputStream());
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                            try {
                                TapjoyUtil.writeFileToDevice(bufferedInputStream, bufferedOutputStream);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException unused) {
                                }
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused2) {
                                }
                                TapjoyCachedAssetData tapjoyCachedAssetData = new TapjoyCachedAssetData(this.a.toString(), file.getAbsolutePath(), this.c);
                                String str = this.f2707b;
                                if (str != null) {
                                    tapjoyCachedAssetData.setOfferID(str);
                                }
                                TapjoyCache.this.f2706b.put(strA, tapjoyCachedAssetData);
                                TapjoyCache.this.getClass();
                                TapjoyCache.this.c.remove(strA);
                                TapjoyLog.d("TapjoyCache", "----- Download complete -----" + tapjoyCachedAssetData.toString());
                                return Boolean.TRUE;
                            } catch (SocketTimeoutException e3) {
                                e2 = e3;
                                bufferedInputStream3 = bufferedInputStream;
                                r8 = bufferedOutputStream;
                                TapjoyLog.e("TapjoyCache", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.NETWORK_ERROR, "Network timeout during caching: " + e2.toString()));
                                TapjoyCache.this.c.remove(strA);
                                TapjoyUtil.deleteFileOrDirectory(file);
                                Boolean bool = Boolean.FALSE;
                                if (bufferedInputStream3 != null) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (r8 != 0) {
                                    try {
                                        r8.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                return bool;
                            } catch (Exception e4) {
                                e = e4;
                                bufferedInputStream2 = bufferedInputStream;
                                r7 = bufferedOutputStream;
                                TapjoyLog.e("TapjoyCache", "Error caching asset: " + e.toString());
                                TapjoyCache.this.c.remove(strA);
                                TapjoyUtil.deleteFileOrDirectory(file);
                                Boolean bool2 = Boolean.FALSE;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                if (r7 != 0) {
                                    try {
                                        r7.close();
                                    } catch (IOException unused6) {
                                    }
                                }
                                return bool2;
                            } catch (Throwable th2) {
                                th = th2;
                                r6 = bufferedOutputStream;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException unused7) {
                                    }
                                }
                                if (r6 != 0) {
                                    throw th;
                                }
                                try {
                                    r6.close();
                                    throw th;
                                } catch (IOException unused8) {
                                    throw th;
                                }
                            }
                        } catch (SocketTimeoutException e5) {
                            e2 = e5;
                            bufferedOutputStream = 0;
                        } catch (Exception e6) {
                            e = e6;
                            bufferedOutputStream = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (r6 != 0) {
                                throw th;
                            }
                            r6.close();
                            throw th;
                        }
                    } catch (SocketTimeoutException e7) {
                        e2 = e7;
                        r8 = 0;
                    } catch (Exception e8) {
                        e = e8;
                        r7 = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = 0;
                        th = th;
                        bufferedInputStream = null;
                        r6 = bufferedOutputStream;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (r6 != 0) {
                            throw th;
                        }
                        r6.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    th = th;
                    bufferedInputStream = null;
                    r6 = bufferedOutputStream;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (r6 != 0) {
                        throw th;
                    }
                    r6.close();
                    throw th;
                }
            } catch (Exception unused9) {
                TapjoyCache.this.c.remove(strA);
                return Boolean.FALSE;
            }
        }
    }

    public TapjoyCache(Context context) {
        if (f == null || unit_test_mode) {
            f = this;
            this.a = context;
            this.f2706b = new TapjoyCacheMap(context, -1);
            this.c = new Vector();
            this.d = Executors.newFixedThreadPool(5);
            a();
        }
    }

    public static TapjoyCache getInstance() {
        return f;
    }

    public static void setInstance(TapjoyCache tapjoyCache) {
        f = tapjoyCache;
    }

    public final void a() {
        if (Environment.getExternalStorageDirectory() != null) {
            TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tapjoy"));
            TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tjcache/tmp/"));
        }
        File file = new File(this.a.getFilesDir() + "/Tapjoy/Cache/");
        this.e = file;
        if (!file.exists()) {
            if (this.e.mkdirs()) {
                TapjoyLog.d("TapjoyCache", "Created directory at: " + this.e.getPath());
            } else {
                TapjoyLog.e("TapjoyCache", "Error initalizing cache");
                f = null;
            }
        }
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            File file2 = new File(entry.getKey());
            if (file2.exists() && file2.isFile()) {
                TapjoyCachedAssetData tapjoyCachedAssetDataFromRawJSONString = TapjoyCachedAssetData.fromRawJSONString(entry.getValue().toString());
                if (tapjoyCachedAssetDataFromRawJSONString != null) {
                    TapjoyLog.d("TapjoyCache", "Loaded Asset: " + tapjoyCachedAssetDataFromRawJSONString.getAssetURL());
                    String strA = a(tapjoyCachedAssetDataFromRawJSONString.getAssetURL());
                    if (strA == null || "".equals(strA) || strA.length() <= 0) {
                        TapjoyLog.e("TapjoyCache", "Removing asset because deserialization failed.");
                        editorEdit.remove(entry.getKey()).apply();
                    } else if (tapjoyCachedAssetDataFromRawJSONString.getTimeOfDeathInSeconds() < System.currentTimeMillis() / 1000) {
                        TapjoyLog.d("TapjoyCache", "Asset expired, removing from cache: " + tapjoyCachedAssetDataFromRawJSONString.getAssetURL());
                        if (tapjoyCachedAssetDataFromRawJSONString.getLocalFilePath() != null && tapjoyCachedAssetDataFromRawJSONString.getLocalFilePath().length() > 0) {
                            TapjoyUtil.deleteFileOrDirectory(new File(tapjoyCachedAssetDataFromRawJSONString.getLocalFilePath()));
                        }
                    } else {
                        this.f2706b.put(strA, tapjoyCachedAssetDataFromRawJSONString);
                    }
                } else {
                    TapjoyLog.e("TapjoyCache", "Removing asset because deserialization failed.");
                    editorEdit.remove(entry.getKey()).apply();
                }
            } else {
                TapjoyLog.d("TapjoyCache", "Removing reference to missing asset: " + entry.getKey());
                editorEdit.remove(entry.getKey()).apply();
            }
        }
    }

    public Future<Boolean> cacheAssetFromJSONObject(JSONObject jSONObject) {
        try {
            return cacheAssetFromURL(jSONObject.getString("url"), jSONObject.optString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID), Long.valueOf(jSONObject.optLong(TapjoyConstants.TJC_TIME_TO_LIVE)).longValue());
        } catch (JSONException unused) {
            TapjoyLog.e("TapjoyCache", "Required parameters to cache an asset from JSON is not present");
            return null;
        }
    }

    public Future<Boolean> cacheAssetFromURL(String str, String str2, long j) {
        try {
            URL url = new URL(str);
            if (!this.c.contains(a(str))) {
                return startCachingThread(url, str2, j);
            }
            TapjoyLog.d("TapjoyCache", "URL is already in the process of being cached: ".concat(str));
            return null;
        } catch (MalformedURLException unused) {
            TapjoyLog.d("TapjoyCache", "Invalid cache assetURL");
            return null;
        }
    }

    public void cacheAssetGroup(JSONArray jSONArray, TJCacheListener tJCacheListener) {
        if (jSONArray != null && jSONArray.length() > 0) {
            new da(this, jSONArray, tJCacheListener).start();
        } else if (tJCacheListener != null) {
            tJCacheListener.onCachingComplete(1);
        }
    }

    public String cachedAssetsToJSON() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, TapjoyCachedAssetData> entry : this.f2706b.entrySet()) {
            try {
                jSONObject.put(entry.getKey().toString(), entry.getValue().toRawJSONString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void clearTapjoyCache() {
        TapjoyLog.d("TapjoyCache", "Cleaning Tapjoy cache!");
        TapjoyUtil.deleteFileOrDirectory(this.e);
        if (this.e.mkdirs()) {
            TapjoyLog.d("TapjoyCache", "Created new cache directory at: " + this.e.getPath());
        }
        this.f2706b = new TapjoyCacheMap(this.a, -1);
    }

    public TapjoyCacheMap getCachedData() {
        return this.f2706b;
    }

    public TapjoyCachedAssetData getCachedDataForURL(String str) {
        String strA = a(str);
        if (strA != "") {
            return this.f2706b.get(strA);
        }
        return null;
    }

    public String getPathOfCachedURL(String str) {
        String strA = a(str);
        if (strA == "" || !this.f2706b.containsKey(strA)) {
            return str;
        }
        TapjoyCachedAssetData tapjoyCachedAssetData = this.f2706b.get(strA);
        if (new File(tapjoyCachedAssetData.getLocalFilePath()).exists()) {
            return tapjoyCachedAssetData.getLocalURL();
        }
        getInstance().removeAssetFromCache(str);
        return str;
    }

    public boolean isURLCached(String str) {
        return this.f2706b.get(a(str)) != null;
    }

    public boolean isURLDownloading(String str) {
        String strA;
        return (this.c == null || (strA = a(str)) == "" || !this.c.contains(strA)) ? false : true;
    }

    public void printCacheInformation() {
        TapjoyLog.d("TapjoyCache", "------------- Cache Data -------------");
        TapjoyLog.d("TapjoyCache", "Number of files in cache: " + this.f2706b.size());
        TapjoyLog.d("TapjoyCache", "Cache Size: " + TapjoyUtil.fileOrDirectorySize(this.e));
        TapjoyLog.d("TapjoyCache", "--------------------------------------");
    }

    public boolean removeAssetFromCache(String str) {
        String strA = a(str);
        return (strA == "" || this.f2706b.remove((Object) strA) == null) ? false : true;
    }

    public Future<Boolean> startCachingThread(URL url, String str, long j) {
        if (url != null) {
            return this.d.submit(new CacheAssetThread(url, str, j));
        }
        return null;
    }

    public String getCachedOfferIDs() {
        ArrayList arrayList = new ArrayList();
        TapjoyCacheMap tapjoyCacheMap = this.f2706b;
        if (tapjoyCacheMap == null) {
            return "";
        }
        Iterator<Map.Entry<String, TapjoyCachedAssetData>> it = tapjoyCacheMap.entrySet().iterator();
        while (it.hasNext()) {
            String offerId = it.next().getValue().getOfferId();
            if (offerId != null && offerId.length() != 0 && !arrayList.contains(offerId)) {
                arrayList.add(offerId);
            }
        }
        return TextUtils.join(",", arrayList);
    }

    public static String a(String str) {
        if (str.startsWith("//")) {
            str = "http:".concat(str);
        }
        try {
            return new URL(str).getFile();
        } catch (MalformedURLException unused) {
            TapjoyLog.e("TapjoyCache", "Invalid URL " + str);
            return "";
        }
    }
}

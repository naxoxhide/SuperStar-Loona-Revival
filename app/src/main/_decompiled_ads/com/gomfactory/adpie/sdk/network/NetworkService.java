package com.gomfactory.adpie.sdk.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkService implements Runnable {
    public static final String TAG = "NetworkService";
    private String mEncodedParam;
    private Handler mHandler;
    private String mMethod;
    private String mRequestUrl;
    private Thread thread = null;
    private Thread timerThread = null;
    private int responseCode = -1;
    private boolean isSuccessOpenConnection = false;

    public NetworkService(String str, String str2, Handler handler, String str3) {
        this.mRequestUrl = null;
        this.mMethod = null;
        this.mEncodedParam = null;
        this.mHandler = null;
        if (TextUtils.isEmpty(str3)) {
            this.mRequestUrl = null;
        } else if (str3.equalsIgnoreCase("GET")) {
            this.mRequestUrl = appendParameter(str, str2);
        } else if (str3.equalsIgnoreCase("POST")) {
            this.mRequestUrl = str;
            this.mEncodedParam = str2;
        }
        this.mMethod = str3;
        this.mHandler = handler;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02d7 A[PHI: r0
      0x02d7: PHI (r0v12 java.lang.Thread) = (r0v10 java.lang.Thread), (r0v25 java.lang.Thread) binds: [B:100:0x02d5, B:65:0x020c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:107:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:121:0x032a  */
    /* JADX WARN: Code duplicated, block: B:139:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0319 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0323 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x031e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x02cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x0207 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x02c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x0314 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x02d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x030f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x02bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x01f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0202 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0123 A[EDGE_INSN: B:181:0x0123->B:32:0x0123 BREAK  A[LOOP:0: B:171:0x010b->B:31:0x0111], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x00fb A[Catch: all -> 0x0210, Exception -> 0x0219, TRY_LEAVE, TryCatch #24 {Exception -> 0x0219, all -> 0x0210, blocks: (B:25:0x00f1, B:27:0x00fb, B:45:0x0179, B:47:0x0187, B:48:0x01bf, B:19:0x00d2), top: B:178:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0111 A[Catch: all -> 0x016b, Exception -> 0x016e, LOOP:0: B:171:0x010b->B:31:0x0111, LOOP_END, TryCatch #28 {Exception -> 0x016e, all -> 0x016b, blocks: (B:29:0x010b, B:31:0x0111, B:32:0x0123, B:34:0x0131, B:35:0x0167), top: B:171:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0131 A[Catch: all -> 0x016b, Exception -> 0x016e, TryCatch #28 {Exception -> 0x016e, all -> 0x016b, blocks: (B:29:0x010b, B:31:0x0111, B:32:0x0123, B:34:0x0131, B:35:0x0167), top: B:171:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0179 A[Catch: all -> 0x0210, Exception -> 0x0219, TRY_ENTER, TryCatch #24 {Exception -> 0x0219, all -> 0x0210, blocks: (B:25:0x00f1, B:27:0x00fb, B:45:0x0179, B:47:0x0187, B:48:0x01bf, B:19:0x00d2), top: B:178:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0187 A[Catch: all -> 0x0210, Exception -> 0x0219, TryCatch #24 {Exception -> 0x0219, all -> 0x0210, blocks: (B:25:0x00f1, B:27:0x00fb, B:45:0x0179, B:47:0x0187, B:48:0x01bf, B:19:0x00d2), top: B:178:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:83:0x024d A[Catch: all -> 0x02df, TryCatch #27 {all -> 0x02df, blocks: (B:81:0x023f, B:83:0x024d, B:84:0x028a), top: B:169:0x023f }] */
    /* JADX WARN: Code duplicated, block: B:87:0x029b  */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        HttpURLConnection httpURLConnection;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Thread thread;
        Thread thread2;
        OutputStreamWriter outputStreamWriter2;
        BufferedWriter bufferedWriter2;
        int responseCode;
        String str;
        String line;
        this.responseCode = -1;
        this.isSuccessOpenConnection = false;
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "<<start>>" + this.mRequestUrl);
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.mRequestUrl).openConnection();
            try {
                TLSSocketFactory tLSSocketFactory = new TLSSocketFactory();
                HttpsURLConnection.setDefaultSSLSocketFactory(tLSSocketFactory);
                TrafficStats.setThreadStatsTag(tLSSocketFactory.hashCode());
                this.isSuccessOpenConnection = true;
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + " -> (open connection!)");
                }
                httpURLConnection2.setConnectTimeout(2000);
                httpURLConnection2.setReadTimeout(4000);
                if (this.mMethod.equalsIgnoreCase("GET")) {
                    httpURLConnection2.setRequestMethod("GET");
                } else {
                    if (this.mMethod.equalsIgnoreCase("POST")) {
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                        if (this.mEncodedParam != null) {
                            outputStreamWriter2 = new OutputStreamWriter(httpURLConnection2.getOutputStream(), "UTF-8");
                            try {
                                bufferedWriter2 = new BufferedWriter(outputStreamWriter2);
                                try {
                                    bufferedWriter2.write(this.mEncodedParam);
                                    bufferedWriter2.flush();
                                } catch (Exception e) {
                                    e = e;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    BufferedWriter bufferedWriter3 = bufferedWriter2;
                                    outputStreamWriter = outputStreamWriter2;
                                    e = e;
                                    httpURLConnection = httpURLConnection2;
                                    bufferedWriter = bufferedWriter3;
                                    try {
                                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                            String str2 = TAG;
                                            AdPieLog.d(str2, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + "<<param>>" + this.mEncodedParam + " -> error : " + e.getMessage());
                                            AdPieLog.e(str2, e);
                                        }
                                        gotFailureMessage();
                                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                                        }
                                        NetworkServiceManager.getInstance().didComplete(this);
                                        if (bufferedWriter != null) {
                                            try {
                                                bufferedWriter.close();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        if (outputStreamWriter != null) {
                                            try {
                                                outputStreamWriter.close();
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception unused3) {
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Exception unused4) {
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception unused5) {
                                            }
                                        }
                                        thread2 = this.timerThread;
                                        if (thread2 != null) {
                                            thread2.interrupt();
                                            this.timerThread = null;
                                        }
                                        this.thread = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                                        }
                                        NetworkServiceManager.getInstance().didComplete(this);
                                        if (bufferedWriter != null) {
                                            try {
                                                bufferedWriter.close();
                                            } catch (Exception unused6) {
                                            }
                                        }
                                        if (outputStreamWriter != null) {
                                            try {
                                                outputStreamWriter.close();
                                            } catch (Exception unused7) {
                                            }
                                        }
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception unused8) {
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Exception unused9) {
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception unused10) {
                                            }
                                        }
                                        thread = this.timerThread;
                                        if (thread != null) {
                                            thread.interrupt();
                                            this.timerThread = null;
                                        }
                                        this.thread = null;
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    httpURLConnection = httpURLConnection2;
                                    bufferedWriter = bufferedWriter2;
                                    outputStreamWriter = outputStreamWriter2;
                                    th = th;
                                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                        AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                                    }
                                    NetworkServiceManager.getInstance().didComplete(this);
                                    if (bufferedWriter != null) {
                                        bufferedWriter.close();
                                    }
                                    if (outputStreamWriter != null) {
                                        outputStreamWriter.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    thread = this.timerThread;
                                    if (thread != null) {
                                        thread.interrupt();
                                        this.timerThread = null;
                                    }
                                    this.thread = null;
                                    throw th;
                                }
                            } catch (Exception e2) {
                                inputStreamReader = null;
                                bufferedReader = null;
                                httpURLConnection = httpURLConnection2;
                                bufferedWriter = null;
                                outputStreamWriter = outputStreamWriter2;
                                e = e2;
                                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                    String str3 = TAG;
                                    AdPieLog.d(str3, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + "<<param>>" + this.mEncodedParam + " -> error : " + e.getMessage());
                                    AdPieLog.e(str3, e);
                                }
                                gotFailureMessage();
                                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                    AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                                }
                                NetworkServiceManager.getInstance().didComplete(this);
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                                if (outputStreamWriter != null) {
                                    outputStreamWriter.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                thread2 = this.timerThread;
                                if (thread2 != null) {
                                    thread2.interrupt();
                                    this.timerThread = null;
                                }
                            } catch (Throwable th3) {
                                inputStreamReader = null;
                                bufferedReader = null;
                                httpURLConnection = httpURLConnection2;
                                bufferedWriter = null;
                                outputStreamWriter = outputStreamWriter2;
                                th = th3;
                                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                    AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                                }
                                NetworkServiceManager.getInstance().didComplete(this);
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                                if (outputStreamWriter != null) {
                                    outputStreamWriter.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                thread = this.timerThread;
                                if (thread != null) {
                                    thread.interrupt();
                                    this.timerThread = null;
                                }
                                this.thread = null;
                                throw th;
                            }
                        }
                        responseCode = httpURLConnection2.getResponseCode();
                        this.responseCode = responseCode;
                        if (responseCode == 200) {
                            str = "";
                            inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream());
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                while (true) {
                                    try {
                                        line = bufferedReader.readLine();
                                        if (line != null) {
                                            break;
                                        } else {
                                            str = str + line;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        BufferedWriter bufferedWriter4 = bufferedWriter2;
                                        outputStreamWriter = outputStreamWriter2;
                                        e = e;
                                        httpURLConnection = httpURLConnection2;
                                        bufferedWriter = bufferedWriter4;
                                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                            String str4 = TAG;
                                            AdPieLog.d(str4, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + "<<param>>" + this.mEncodedParam + " -> error : " + e.getMessage());
                                            AdPieLog.e(str4, e);
                                        }
                                        gotFailureMessage();
                                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                                        }
                                        NetworkServiceManager.getInstance().didComplete(this);
                                        if (bufferedWriter != null) {
                                            bufferedWriter.close();
                                        }
                                        if (outputStreamWriter != null) {
                                            outputStreamWriter.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        thread2 = this.timerThread;
                                        if (thread2 != null) {
                                            thread2.interrupt();
                                            this.timerThread = null;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        httpURLConnection = httpURLConnection2;
                                        bufferedWriter = bufferedWriter2;
                                        outputStreamWriter = outputStreamWriter2;
                                        th = th;
                                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                                        }
                                        NetworkServiceManager.getInstance().didComplete(this);
                                        if (bufferedWriter != null) {
                                            bufferedWriter.close();
                                        }
                                        if (outputStreamWriter != null) {
                                            outputStreamWriter.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        thread = this.timerThread;
                                        if (thread != null) {
                                            thread.interrupt();
                                            this.timerThread = null;
                                        }
                                        this.thread = null;
                                        throw th;
                                    }
                                }
                                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                    AdPieLog.d(TAG, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + "<<param>>" + this.mEncodedParam + "<<response>>" + str);
                                }
                                gotSuccessMessage(str);
                            } catch (Exception e4) {
                                e = e4;
                                bufferedReader = null;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = null;
                            }
                        } else {
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(TAG, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + "<<param>>" + this.mEncodedParam + "<<code>>" + this.responseCode);
                            }
                            gotFailureMessage();
                            inputStreamReader = null;
                            bufferedReader = null;
                        }
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                        }
                        NetworkServiceManager.getInstance().didComplete(this);
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (Exception unused11) {
                            }
                        }
                        if (outputStreamWriter2 != null) {
                            try {
                                outputStreamWriter2.close();
                            } catch (Exception unused12) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused13) {
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Exception unused14) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused15) {
                            }
                        }
                        thread2 = this.timerThread;
                        if (thread2 != null) {
                            thread2.interrupt();
                            this.timerThread = null;
                        }
                    }
                    this.thread = null;
                }
                outputStreamWriter2 = null;
                bufferedWriter2 = null;
                responseCode = httpURLConnection2.getResponseCode();
                this.responseCode = responseCode;
                if (responseCode == 200) {
                    str = "";
                    inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream());
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        line = bufferedReader.readLine();
                        if (line != null) {
                            break;
                            break;
                        }
                        str = str + line;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + "<<param>>" + this.mEncodedParam + "<<response>>" + str);
                    }
                    gotSuccessMessage(str);
                } else {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, "[" + this.mMethod + "]<<url>>" + this.mRequestUrl + "<<param>>" + this.mEncodedParam + "<<code>>" + this.responseCode);
                    }
                    gotFailureMessage();
                    inputStreamReader = null;
                    bufferedReader = null;
                }
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "<<finish>>" + this.mRequestUrl);
                }
                NetworkServiceManager.getInstance().didComplete(this);
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
                if (outputStreamWriter2 != null) {
                    outputStreamWriter2.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                thread2 = this.timerThread;
                if (thread2 != null) {
                    thread2.interrupt();
                    this.timerThread = null;
                }
            } catch (Exception e5) {
                e = e5;
                outputStreamWriter = null;
                inputStreamReader = null;
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                bufferedWriter = null;
            } catch (Throwable th6) {
                th = th6;
                outputStreamWriter = null;
                inputStreamReader = null;
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                bufferedWriter = null;
            }
        } catch (Exception e6) {
            e = e6;
            outputStreamWriter = null;
            bufferedWriter = null;
            httpURLConnection = null;
            inputStreamReader = null;
            bufferedReader = null;
        } catch (Throwable th7) {
            th = th7;
            outputStreamWriter = null;
            bufferedWriter = null;
            httpURLConnection = null;
            inputStreamReader = null;
            bufferedReader = null;
        }
        this.thread = null;
    }

    private String appendParameter(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        int iIndexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (iIndexOf == -1) {
            sb.append('?');
        } else if (iIndexOf < length && str.charAt(length) != '&') {
            sb.append(Typography.amp);
        }
        sb.append(str2);
        return sb.toString();
    }

    public void process() {
        if (TextUtils.isEmpty(this.mMethod)) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, new Exception("Undefined http method."));
            }
            gotFailureMessage();
            NetworkServiceManager.getInstance().didComplete(this);
            return;
        }
        if (!this.mMethod.equalsIgnoreCase("GET") && !this.mMethod.equalsIgnoreCase("POST")) {
            gotFailureMessage();
            NetworkServiceManager.getInstance().didComplete(this);
            return;
        }
        if (TextUtils.isEmpty(this.mRequestUrl)) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, new Exception("Request url cannot be null."));
            }
            gotFailureMessage();
            NetworkServiceManager.getInstance().didComplete(this);
            return;
        }
        Thread thread = new Thread(this);
        this.thread = thread;
        thread.start();
        Thread thread2 = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.network.NetworkService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(NetworkService.TAG, "[" + NetworkService.this.mMethod + "]<<url>>" + NetworkService.this.mRequestUrl + " -> (start timer)");
                    }
                    Thread.sleep(3000L);
                    if (!NetworkService.this.isSuccessOpenConnection) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(NetworkService.TAG, "[" + NetworkService.this.mMethod + "]<<url>>" + NetworkService.this.mRequestUrl + " -> (connection timeout)");
                        }
                        NetworkService.this.gotFailureMessage();
                    }
                } catch (InterruptedException unused) {
                }
                NetworkService.this.timerThread = null;
            }
        });
        this.timerThread = thread2;
        thread2.start();
    }

    public void gotFailureMessage() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, -1));
            }
            this.mHandler = null;
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public void gotSuccessMessage(String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, 200, str));
            }
            this.mHandler = null;
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }
}

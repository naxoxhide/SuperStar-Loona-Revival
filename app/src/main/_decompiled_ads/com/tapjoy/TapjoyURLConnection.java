package com.tapjoy;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyURLConnection {
    public static final int TYPE_GET = 0;
    public static final int TYPE_POST = 1;

    public String getContentLength(String str) {
        String headerField;
        try {
            String strReplaceAll = str.replaceAll(" ", "%20");
            TapjoyLog.d("TapjoyURLConnection", "requestURL: " + strReplaceAll);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strReplaceAll).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(30000);
            headerField = httpURLConnection.getHeaderField("content-length");
        } catch (Exception e) {
            TapjoyLog.e("TapjoyURLConnection", "Exception: " + e.toString());
            headerField = null;
        }
        TapjoyLog.d("TapjoyURLConnection", "content-length: " + headerField);
        return headerField;
    }

    public TapjoyHttpURLResponse getRedirectFromURL(String str) {
        return getResponseFromURL(str, "", 0, true, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map<String, String> map) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map<String, String> map, int i) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), i);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str) {
        return getResponseFromURL(str, "", 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2) {
        return getResponseFromURL(str, str2, 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i) {
        return getResponseFromURL(str, str2, i, false, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, ShareTarget.ENCODING_TYPE_URL_ENCODED, TapjoyUtil.convertURLParams(map3, false));
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, "application/json;charset=utf-8", str2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x005d A[Catch: Exception -> 0x0161, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x006b A[Catch: Exception -> 0x0161, LOOP:0: B:13:0x0065->B:15:0x006b, LOOP_END, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0084 A[Catch: Exception -> 0x0161, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x008b A[Catch: Exception -> 0x0161, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00eb A[Catch: Exception -> 0x0161, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00fb A[Catch: Exception -> 0x0161, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0106 A[Catch: Exception -> 0x0161, LOOP:1: B:26:0x0100->B:28:0x0106, LOOP_END, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0127 A[Catch: Exception -> 0x0161, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x015d A[Catch: Exception -> 0x0161, TRY_LEAVE, TryCatch #3 {Exception -> 0x0161, blocks: (B:9:0x004e, B:10:0x0051, B:12:0x005d, B:13:0x0065, B:15:0x006b, B:18:0x0084, B:20:0x008b, B:21:0x00ce, B:23:0x00eb, B:25:0x00fb, B:26:0x0100, B:28:0x0106, B:29:0x011b, B:30:0x0121, B:32:0x0127, B:33:0x012f, B:40:0x015d, B:38:0x0143, B:35:0x0137), top: B:73:0x004e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x011b A[EDGE_INSN: B:76:0x011b->B:29:0x011b BREAK  A[LOOP:1: B:26:0x0100->B:28:0x0106], SYNTHETIC] */
    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i, boolean z, Map<String, String> map, String str3, String str4) {
        BufferedReader bufferedReader;
        String headerField;
        StringBuilder sb;
        String line;
        TapjoyHttpURLResponse tapjoyHttpURLResponse = new TapjoyHttpURLResponse();
        HttpURLConnection httpURLConnection = null;
        try {
            String str5 = str + str2;
            TapjoyLog.i("TapjoyURLConnection", "http " + (i == 0 ? "get" : "post") + ": " + str5);
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str5).openConnection();
            if (z) {
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setConnectTimeout(15000);
                    httpURLConnection2.setReadTimeout(30000);
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (i == 1) {
                        httpURLConnection2.setRequestMethod("POST");
                        if (str4 != null) {
                            TapjoyLog.i("TapjoyURLConnection", "Content-Type: " + str3);
                            TapjoyLog.i("TapjoyURLConnection", "Content:");
                            TapjoyLog.i("TapjoyURLConnection", str4);
                            httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, str3);
                            httpURLConnection2.setRequestProperty(HttpHeaders.CONNECTION, "close");
                            httpURLConnection2.setDoOutput(true);
                            httpURLConnection2.setFixedLengthStreamingMode(str4.length());
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection2.getOutputStream());
                            outputStreamWriter.write(str4);
                            outputStreamWriter.close();
                        }
                    }
                    httpURLConnection2.connect();
                    tapjoyHttpURLResponse.statusCode = httpURLConnection2.getResponseCode();
                    tapjoyHttpURLResponse.headerFields = httpURLConnection2.getHeaderFields();
                    tapjoyHttpURLResponse.date = httpURLConnection2.getDate();
                    tapjoyHttpURLResponse.expires = httpURLConnection2.getExpiration();
                    bufferedReader = z ? null : new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                    if (!z) {
                        sb = new StringBuilder();
                        while (true) {
                            line = bufferedReader.readLine();
                            if (line != null) {
                                break;
                            }
                            sb.append(line + '\n');
                        }
                        tapjoyHttpURLResponse.response = sb.toString();
                    }
                    if (tapjoyHttpURLResponse.statusCode == 302) {
                        tapjoyHttpURLResponse.redirectURL = httpURLConnection2.getHeaderField(HttpHeaders.LOCATION);
                    }
                    headerField = httpURLConnection2.getHeaderField("content-length");
                    if (headerField != null) {
                        try {
                            tapjoyHttpURLResponse.contentLength = Integer.valueOf(headerField).intValue();
                        } catch (Exception e) {
                            TapjoyLog.e("TapjoyURLConnection", "Exception: " + e.toString());
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } else if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Exception e2) {
                    httpURLConnection = httpURLConnection2;
                    e = e2;
                    TapjoyLog.e("TapjoyURLConnection", "Exception: " + e.toString());
                    tapjoyHttpURLResponse.statusCode = 0;
                    if (httpURLConnection != null) {
                        try {
                            if (tapjoyHttpURLResponse.response == null) {
                                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                                StringBuilder sb2 = new StringBuilder();
                                while (true) {
                                    String line2 = bufferedReader2.readLine();
                                    if (line2 == null) {
                                        break;
                                    }
                                    sb2.append(line2 + '\n');
                                }
                                tapjoyHttpURLResponse.response = sb2.toString();
                            }
                        } catch (Exception e3) {
                            TapjoyLog.e("TapjoyURLConnection", "Exception trying to get error code/content: " + e3.toString());
                        }
                    }
                }
            } else {
                httpURLConnection2.setConnectTimeout(15000);
                httpURLConnection2.setReadTimeout(30000);
                if (map != null) {
                    while (r10.hasNext()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (i == 1) {
                    httpURLConnection2.setRequestMethod("POST");
                    if (str4 != null) {
                        TapjoyLog.i("TapjoyURLConnection", "Content-Type: " + str3);
                        TapjoyLog.i("TapjoyURLConnection", "Content:");
                        TapjoyLog.i("TapjoyURLConnection", str4);
                        httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, str3);
                        httpURLConnection2.setRequestProperty(HttpHeaders.CONNECTION, "close");
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setFixedLengthStreamingMode(str4.length());
                        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(httpURLConnection2.getOutputStream());
                        outputStreamWriter2.write(str4);
                        outputStreamWriter2.close();
                    }
                }
                httpURLConnection2.connect();
                tapjoyHttpURLResponse.statusCode = httpURLConnection2.getResponseCode();
                tapjoyHttpURLResponse.headerFields = httpURLConnection2.getHeaderFields();
                tapjoyHttpURLResponse.date = httpURLConnection2.getDate();
                tapjoyHttpURLResponse.expires = httpURLConnection2.getExpiration();
                if (z) {
                }
                if (!z) {
                    sb = new StringBuilder();
                    while (true) {
                        line = bufferedReader.readLine();
                        if (line != null) {
                            break;
                            break;
                        }
                        sb.append(line + '\n');
                    }
                    tapjoyHttpURLResponse.response = sb.toString();
                }
                if (tapjoyHttpURLResponse.statusCode == 302) {
                    tapjoyHttpURLResponse.redirectURL = httpURLConnection2.getHeaderField(HttpHeaders.LOCATION);
                }
                headerField = httpURLConnection2.getHeaderField("content-length");
                if (headerField != null) {
                    tapjoyHttpURLResponse.contentLength = Integer.valueOf(headerField).intValue();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } else if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        TapjoyLog.i("TapjoyURLConnection", "response status: " + tapjoyHttpURLResponse.statusCode);
        StringBuilder sb3 = new StringBuilder("response size: ");
        String str6 = tapjoyHttpURLResponse.response;
        TapjoyLog.i("TapjoyURLConnection", sb3.append(str6 != null ? str6.length() : 0).toString());
        String str7 = tapjoyHttpURLResponse.redirectURL;
        if (str7 != null && str7.length() > 0) {
            TapjoyLog.i("TapjoyURLConnection", "redirectURL: " + tapjoyHttpURLResponse.redirectURL);
        }
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        return tapjoyHttpURLResponse;
    }
}

package com.mbridge.msdk.videocommon.download;

import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: DownLoadUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static void a(final String str, final g.c cVar, final boolean z) {
        try {
            if (!ak.a(str) && URLUtil.isNetworkUrl(str)) {
                f.a.a.a(new com.mbridge.msdk.foundation.same.e.a() { // from class: com.mbridge.msdk.videocommon.download.e.1
                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public final void b() {
                    }

                    /* JADX WARN: Code duplicated, block: B:107:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:112:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:49:0x00d4 A[Catch: Exception -> 0x00d8, TRY_ENTER, TryCatch #5 {Exception -> 0x00d8, blocks: (B:36:0x009f, B:38:0x00a4, B:49:0x00d4, B:53:0x00dc), top: B:106:0x0004 }] */
                    /* JADX WARN: Code duplicated, block: B:53:0x00dc A[Catch: Exception -> 0x00d8, TRY_LEAVE, TryCatch #5 {Exception -> 0x00d8, blocks: (B:36:0x009f, B:38:0x00a4, B:49:0x00d4, B:53:0x00dc), top: B:106:0x0004 }] */
                    /* JADX WARN: Code duplicated, block: B:65:0x00fc  */
                    /* JADX WARN: Code duplicated, block: B:66:0x00fe A[Catch: all -> 0x00fa, TryCatch #8 {all -> 0x00fa, blocks: (B:57:0x00e9, B:60:0x00ef, B:62:0x00f2, B:66:0x00fe, B:68:0x0104, B:70:0x010a, B:72:0x0112, B:74:0x0116, B:75:0x011c, B:77:0x0120), top: B:112:0x00e9 }] */
                    /* JADX WARN: Code duplicated, block: B:75:0x011c A[Catch: all -> 0x00fa, TryCatch #8 {all -> 0x00fa, blocks: (B:57:0x00e9, B:60:0x00ef, B:62:0x00f2, B:66:0x00fe, B:68:0x0104, B:70:0x010a, B:72:0x0112, B:74:0x0116, B:75:0x011c, B:77:0x0120), top: B:112:0x00e9 }] */
                    /* JADX WARN: Code duplicated, block: B:77:0x0120 A[Catch: all -> 0x00fa, TRY_LEAVE, TryCatch #8 {all -> 0x00fa, blocks: (B:57:0x00e9, B:60:0x00ef, B:62:0x00f2, B:66:0x00fe, B:68:0x0104, B:70:0x010a, B:72:0x0112, B:74:0x0116, B:75:0x011c, B:77:0x0120), top: B:112:0x00e9 }] */
                    /* JADX WARN: Code duplicated, block: B:95:0x0159 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:96:0x015b A[Catch: Exception -> 0x0157, TRY_LEAVE, TryCatch #6 {Exception -> 0x0157, blocks: (B:92:0x0153, B:96:0x015b), top: B:107:0x0153 }] */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v17, types: [com.mbridge.msdk.videocommon.download.g$c] */
                    /* JADX WARN: Type inference failed for: r6v0 */
                    /* JADX WARN: Type inference failed for: r6v1 */
                    /* JADX WARN: Type inference failed for: r6v10 */
                    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r6v12 */
                    /* JADX WARN: Type inference failed for: r6v13 */
                    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r6v3 */
                    /* JADX WARN: Type inference failed for: r6v4 */
                    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r6v8 */
                    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r7v0 */
                    /* JADX WARN: Type inference failed for: r7v1 */
                    /* JADX WARN: Type inference failed for: r7v14 */
                    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r7v3 */
                    /* JADX WARN: Type inference failed for: r7v4 */
                    /* JADX WARN: Type inference failed for: r7v5 */
                    /* JADX WARN: Type inference failed for: r7v9 */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public final void a() throws Throwable {
                        ?? r6;
                        InputStream inputStream;
                        byte[] byteArray;
                        String message;
                        ?? byteArrayOutputStream;
                        ?? r7;
                        g.c cVar2;
                        boolean z2;
                        String str2;
                        boolean z3 = false;
                        InputStream inputStream2 = null;
                        try {
                            try {
                                g.c cVar3 = cVar;
                                if (cVar3 != null) {
                                    cVar3.a();
                                }
                                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                                httpURLConnection.setReadTimeout(30000);
                                httpURLConnection.setConnectTimeout(20000);
                                int responseCode = httpURLConnection.getResponseCode();
                                aa.a("DownLoadUtils", "response code " + responseCode);
                                try {
                                    if (responseCode == 200) {
                                        inputStream = httpURLConnection.getInputStream();
                                        try {
                                            byte[] bArr = new byte[6144];
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            while (true) {
                                                try {
                                                    try {
                                                        int i = inputStream.read(bArr);
                                                        if (i == -1) {
                                                            break;
                                                        } else {
                                                            byteArrayOutputStream.write(bArr, 0, i);
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        inputStream2 = inputStream;
                                                        r6 = byteArrayOutputStream;
                                                        if (inputStream2 != null) {
                                                            try {
                                                                inputStream2.close();
                                                                if (r6 != 0) {
                                                                    r6.close();
                                                                }
                                                            } catch (Exception e) {
                                                                e.printStackTrace();
                                                                e.getMessage();
                                                                throw th;
                                                            }
                                                        } else if (r6 != 0) {
                                                            r6.close();
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    byteArray = null;
                                                    r7 = 0;
                                                }
                                                message = e.getMessage();
                                                aa.d("DownLoadUtils", "getStringFromUrl failed " + e.getLocalizedMessage());
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (byteArrayOutputStream != 0) {
                                                    byteArrayOutputStream.close();
                                                }
                                                if (z3) {
                                                    try {
                                                        if (z && byteArray != null && byteArray.length > 0) {
                                                            cVar.a(null, byteArray, str);
                                                        } else if (!z3 && ak.b(r7) && r7.length() > 0 && r7.contains("<mbridgeloadend></mbridgeloadend>")) {
                                                            ?? r0 = cVar;
                                                            if (r0 != 0) {
                                                                r0.a(r7, byteArray, str);
                                                            }
                                                        } else {
                                                            cVar2 = cVar;
                                                            if (cVar2 != null) {
                                                                cVar2.a("content write failed:" + message);
                                                            }
                                                        }
                                                    } catch (Throwable th2) {
                                                        if (MBridgeConstans.DEBUG) {
                                                            th2.printStackTrace();
                                                        }
                                                        g.c cVar4 = cVar;
                                                        if (cVar4 != null) {
                                                            try {
                                                                cVar4.a(th2.getMessage());
                                                                return;
                                                            } catch (Exception e3) {
                                                                e3.printStackTrace();
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                } else if (!z3) {
                                                    cVar2 = cVar;
                                                    if (cVar2 != null) {
                                                        cVar2.a("content write failed:" + message);
                                                    }
                                                } else {
                                                    cVar2 = cVar;
                                                    if (cVar2 != null) {
                                                        cVar2.a("content write failed:" + message);
                                                    }
                                                }
                                            }
                                            if (byteArrayOutputStream.toByteArray() != null) {
                                                byteArray = byteArrayOutputStream.toByteArray();
                                                try {
                                                    str2 = !z ? new String(byteArray) : null;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    r7 = 0;
                                                }
                                            } else {
                                                byteArray = null;
                                                str2 = null;
                                            }
                                            z2 = true;
                                            message = "";
                                            byteArrayOutputStream = byteArrayOutputStream;
                                            r7 = str2;
                                        } catch (Exception e5) {
                                            e = e5;
                                            byteArray = null;
                                            byteArrayOutputStream = byteArray;
                                            r7 = byteArrayOutputStream;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            byteArrayOutputStream = 0;
                                            inputStream2 = inputStream;
                                            r6 = byteArrayOutputStream;
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                                if (r6 != 0) {
                                                    r6.close();
                                                }
                                            } else if (r6 != 0) {
                                                r6.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        message = "responseCode is " + responseCode;
                                        z2 = false;
                                        inputStream = null;
                                        byteArray = null;
                                        byteArrayOutputStream = 0;
                                        r7 = 0;
                                    }
                                    httpURLConnection.disconnect();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != 0) {
                                        byteArrayOutputStream.close();
                                    }
                                    z3 = z2;
                                } catch (Exception e6) {
                                    e = e6;
                                    message = e.getMessage();
                                    aa.d("DownLoadUtils", "getStringFromUrl failed " + e.getLocalizedMessage());
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != 0) {
                                        byteArrayOutputStream.close();
                                    }
                                }
                            } catch (Exception e7) {
                                e = e7;
                                inputStream = null;
                                byteArray = null;
                            } catch (Throwable th4) {
                                th = th4;
                                r6 = 0;
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                    if (r6 != 0) {
                                        r6.close();
                                    }
                                } else if (r6 != 0) {
                                    r6.close();
                                }
                                throw th;
                            }
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            message = e8.getMessage();
                        }
                        if (z3) {
                            if (z) {
                                if (!z3) {
                                    cVar2 = cVar;
                                    if (cVar2 != null) {
                                        cVar2.a("content write failed:" + message);
                                    }
                                } else {
                                    cVar2 = cVar;
                                    if (cVar2 != null) {
                                        cVar2.a("content write failed:" + message);
                                    }
                                }
                            } else if (!z3) {
                                cVar2 = cVar;
                                if (cVar2 != null) {
                                    cVar2.a("content write failed:" + message);
                                }
                            } else {
                                cVar2 = cVar;
                                if (cVar2 != null) {
                                    cVar2.a("content write failed:" + message);
                                }
                            }
                        } else if (!z3) {
                            cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.a("content write failed:" + message);
                            }
                        } else {
                            cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.a("content write failed:" + message);
                            }
                        }
                    }
                });
                return;
            }
            if (cVar != null) {
                cVar.a("url is error");
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }
}

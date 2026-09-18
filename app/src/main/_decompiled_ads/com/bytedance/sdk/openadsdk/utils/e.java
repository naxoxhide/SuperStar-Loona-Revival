package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: CpuUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: compiled from: CpuUtils.java */
    static class a implements FilenameFilter {
        private final Pattern a = Pattern.compile("^cpu[0-9]+$");

        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    public static int a() {
        File[] fileArrListFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 0);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (fileArrListFiles = file.listFiles(new a())) == null) {
                return 0;
            }
            return Math.max(fileArrListFiles.length, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int b(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("cpu_max_frequency", 0);
    }

    public static int c(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("cpu_min_frequency", 0);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0070 A[Catch: Exception -> 0x0073, TRY_LEAVE, TryCatch #5 {Exception -> 0x0073, blocks: (B:30:0x006b, B:32:0x0070), top: B:48:0x006b }] */
    public static int b(int i) {
        int i2;
        FileReader fileReader = null;
        int i3 = 0;
        BufferedReader bufferedReader = null;
        while (true) {
            i--;
            if (i < 0) {
                return i3;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                    try {
                        String line = bufferedReader2.readLine();
                        if (!TextUtils.isEmpty(line) && ((i2 = Integer.parseInt(line)) < i3 || i3 == 0)) {
                            i3 = i2;
                        }
                        try {
                            bufferedReader2.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader = bufferedReader2;
                        fileReader = fileReader2;
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        fileReader = fileReader2;
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.m.b("CpuUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused3) {
                                    throw th2;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileReader = fileReader2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static int a(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).a("cpu_count", 0);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006d A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:28:0x0068, B:30:0x006d), top: B:36:0x0068 }] */
    public static int a(int i) {
        int i2;
        FileReader fileReader = null;
        int i3 = 0;
        BufferedReader bufferedReader = null;
        while (true) {
            i--;
            if (i < 0) {
                return i3;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                    try {
                        String line = bufferedReader2.readLine();
                        if (!TextUtils.isEmpty(line) && (i2 = Integer.parseInt(line)) > i3) {
                            i3 = i2;
                        }
                        try {
                            bufferedReader2.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader = bufferedReader2;
                        fileReader = fileReader2;
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        fileReader = fileReader2;
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.m.b("CpuUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused3) {
                                    throw th2;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileReader = fileReader2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }
}

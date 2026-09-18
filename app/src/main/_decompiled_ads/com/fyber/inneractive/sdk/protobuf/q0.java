package com.fyber.inneractive.sdk.protobuf;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    /* JADX WARN: Code duplicated, block: B:87:0x0236  */
    /* JADX WARN: Code duplicated, block: B:88:0x0238  */
    public static void a(o0 o0Var, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : o0Var.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            boolean zBooleanValue = true;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String str2 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1, strSubstring.length() - 4);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i, a(str2), GeneratedMessageLite.invokeOrDie(method2, o0Var, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String str3 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1, strSubstring.length() - 3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i, a(str3), GeneratedMessageLite.invokeOrDie(method3, o0Var, new Object[0]));
                }
            }
            if (((Method) map2.get("set" + strSubstring)) != null && (!strSubstring.endsWith("Bytes") || !map.containsKey("get" + strSubstring.substring(0, strSubstring.length() - 5)))) {
                String str4 = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1);
                Method method4 = (Method) map.get("get" + strSubstring);
                Method method5 = (Method) map.get("has" + strSubstring);
                if (method4 != null) {
                    Object objInvokeOrDie = GeneratedMessageLite.invokeOrDie(method4, o0Var, new Object[0]);
                    if (method5 == null) {
                        if (objInvokeOrDie instanceof Boolean) {
                            zEquals = !((Boolean) objInvokeOrDie).booleanValue();
                        } else if (objInvokeOrDie instanceof Integer) {
                            if (((Integer) objInvokeOrDie).intValue() == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objInvokeOrDie instanceof Float) {
                            if (((Float) objInvokeOrDie).floatValue() == 0.0f) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objInvokeOrDie instanceof Double) {
                            if (((Double) objInvokeOrDie).doubleValue() == 0.0d) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objInvokeOrDie instanceof String) {
                            zEquals = objInvokeOrDie.equals("");
                        } else if (objInvokeOrDie instanceof i) {
                            zEquals = objInvokeOrDie.equals(i.f1293b);
                        } else if (!(objInvokeOrDie instanceof o0) ? !((objInvokeOrDie instanceof Enum) && ((Enum) objInvokeOrDie).ordinal() == 0) : objInvokeOrDie != ((o0) objInvokeOrDie).getDefaultInstanceForType()) {
                            zEquals = false;
                        } else {
                            zEquals = true;
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) GeneratedMessageLite.invokeOrDie(method5, o0Var, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        a(sb, i, a(str4), objInvokeOrDie);
                    }
                }
            }
        }
        if (o0Var instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<T, Object>> itF = ((GeneratedMessageLite.ExtendableMessage) o0Var).extensions.f();
            while (itF.hasNext()) {
                Map.Entry entry = (Map.Entry) itF.next();
                a(sb, i, "[" + ((GeneratedMessageLite.d) entry.getKey()).f1273b + "]", entry.getValue());
            }
        }
        l1 l1Var = ((GeneratedMessageLite) o0Var).unknownFields;
        if (l1Var != null) {
            for (int i2 = 0; i2 < l1Var.a; i2++) {
                int i3 = l1Var.f1300b[i2];
                int i4 = r1.a;
                a(sb, i, String.valueOf(i3 >>> 3), l1Var.c[i2]);
            }
        }
    }

    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(i1.a(i.a((String) obj))).append(Typography.quote);
            return;
        }
        if (obj instanceof i) {
            sb.append(": \"").append(i1.a((i) obj)).append(Typography.quote);
            return;
        }
        if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            a((GeneratedMessageLite) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i4 = i + 2;
            a(sb, i4, SDKConstants.PARAM_KEY, entry.getKey());
            a(sb, i4, "value", entry.getValue());
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ").append(obj.toString());
    }

    public static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }
}

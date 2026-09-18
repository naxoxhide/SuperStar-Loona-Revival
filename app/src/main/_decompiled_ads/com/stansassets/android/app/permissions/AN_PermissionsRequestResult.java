package com.stansassets.android.app.permissions;

import com.stansassets.core.templates.SA_Result;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AN_PermissionsRequestResult extends SA_Result {
    public ArrayList<AN_PermissionsRequestResponce> m_grantResults = new ArrayList<>();

    public AN_PermissionsRequestResult(String[] strArr, int[] iArr) {
        for (int i = 0; i < strArr.length; i++) {
            AN_PermissionsRequestResponce aN_PermissionsRequestResponce = new AN_PermissionsRequestResponce();
            aN_PermissionsRequestResponce.m_permission = strArr[i];
            aN_PermissionsRequestResponce.m_grantResult = iArr[i];
            this.m_grantResults.add(aN_PermissionsRequestResponce);
        }
    }
}

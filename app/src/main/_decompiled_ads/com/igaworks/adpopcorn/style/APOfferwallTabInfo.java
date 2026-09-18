package com.igaworks.adpopcorn.style;

import com.igaworks.adpopcorn.cores.common.g;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class APOfferwallTabInfo implements Serializable {
    private String fifthTabTitle;
    private int fifthTabType;
    private String firstTabTitle;
    private int firstTabType;
    private String fourthTabTitle;
    private int fourthTabType;
    private String secondTabTitle;
    private int secondTabType;
    private int tabCount;
    private String thirdTabTitle;
    private int thirdTabType;

    public class TabType {
        public static final int ALL_TYPE = 0;
        public static final int CPM_TYPE = 10;
        public static final int CPS_TYPE = 9;
        public static final int EXECUTE_TYPE = 4;
        public static final int INSTALL_TYPE = 3;
        public static final int MISSION_TYPE = 2;
        public static final int NEWS_TYPE = 11;
        public static final int NONE = -1;
        public static final int QUICK_COMPLETE_TYPE = 1;
        public static final int REGIST_TYPE = 5;
        public static final int SOCIAL_TYPE = 6;
        public static final int TCPA_TYPE = 7;
        public static final int THE_OTHERS_TYPE = 8;

        public TabType(APOfferwallTabInfo aPOfferwallTabInfo) {
        }
    }

    public APOfferwallTabInfo() {
        g gVarA = g.a();
        this.tabCount = 3;
        this.firstTabTitle = gVarA.A1;
        this.firstTabType = 0;
        this.secondTabTitle = gVarA.B1;
        this.secondTabType = 1;
        this.thirdTabTitle = gVarA.C1;
        this.thirdTabType = 8;
        this.fourthTabTitle = "";
        this.fourthTabType = -1;
        this.fifthTabTitle = "";
        this.fifthTabType = -1;
    }

    public int getTabCount() {
        return this.tabCount;
    }

    public String getTabTitle(int i) {
        if (i > this.tabCount) {
            return "";
        }
        if (i == 0) {
            return this.firstTabTitle;
        }
        if (i == 1) {
            return this.secondTabTitle;
        }
        if (i == 2) {
            return this.thirdTabTitle;
        }
        if (i == 3) {
            return this.fourthTabTitle;
        }
        return i == 4 ? this.fifthTabTitle : "";
    }

    public int getTabType(int i) {
        if (i > this.tabCount) {
            return -1;
        }
        if (i == 0) {
            return this.firstTabType;
        }
        if (i == 1) {
            return this.secondTabType;
        }
        if (i == 2) {
            return this.thirdTabType;
        }
        if (i == 3) {
            return this.fourthTabType;
        }
        if (i == 4) {
            return this.fifthTabType;
        }
        return -1;
    }

    public void setTabCount(int i) {
        int i2 = 5;
        if (i <= 5) {
            i2 = 2;
            if (i >= 2) {
                this.tabCount = i;
                return;
            }
        }
        this.tabCount = i2;
    }

    public void setTabTitle(String str, String str2, String str3, String str4, String str5) {
        if (str != null && str.length() > 0) {
            this.firstTabTitle = str;
        }
        if (str2 != null && str2.length() > 0) {
            this.secondTabTitle = str2;
        }
        if (str3 != null && str3.length() > 0) {
            this.thirdTabTitle = str3;
        }
        if (str4 != null && str4.length() > 0) {
            this.fourthTabTitle = str4;
        }
        if (str5 == null || str5.length() <= 0) {
            return;
        }
        this.fifthTabTitle = str5;
    }

    public void setTabType(int i, int i2, int i3, int i4, int i5) {
        if (i == 8 || i2 == 8 || i3 == 8 || i4 == 8 || i5 == 8) {
            this.firstTabType = i;
            this.secondTabType = i2;
            this.thirdTabType = i3;
            this.fourthTabType = i4;
            this.fifthTabType = i5;
        }
    }
}

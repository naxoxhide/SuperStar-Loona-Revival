package com.tnkfactory.ad.pub.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class Vdo_iconUrls {
    public ArrayList<String> xPosition = new ArrayList<>();
    public ArrayList<String> duration = new ArrayList<>();
    public ArrayList<String> icon_url = new ArrayList<>();
    public ArrayList<String> offset = new ArrayList<>();
    public ArrayList<String> yPosition = new ArrayList<>();
    public ArrayList<String> width = new ArrayList<>();
    public ArrayList<String> height = new ArrayList<>();
    public ArrayList<String> program = new ArrayList<>();
    public ArrayList<String> icon_click_url = new ArrayList<>();

    public void addduration(String str) {
        this.duration.add(str);
    }

    public void addheight(String str) {
        this.height.add(str);
    }

    public void addicon_click_url(String str) {
        this.icon_click_url.add(str);
    }

    public void addicon_url(String str) {
        this.icon_url.add(str);
    }

    public void addoffset(String str) {
        this.offset.add(str);
    }

    public void addprogram(String str) {
        this.program.add(str);
    }

    public void addwidth(String str) {
        this.width.add(str);
    }

    public void addxPosition(String str) {
        this.xPosition.add(str);
    }

    public void addyPosition(String str) {
        this.yPosition.add(str);
    }

    public ArrayList<String> getduration() {
        return this.duration;
    }

    public ArrayList<String> getheight() {
        return this.height;
    }

    public ArrayList<String> geticon_click_url() {
        return this.icon_click_url;
    }

    public ArrayList<String> geticon_url() {
        return this.icon_url;
    }

    public ArrayList<String> getoffset() {
        return this.offset;
    }

    public ArrayList<String> getprogram() {
        return this.program;
    }

    public ArrayList<String> getwidth() {
        return this.width;
    }

    public ArrayList<String> getxPosition() {
        return this.xPosition;
    }

    public ArrayList<String> getyPosition() {
        return this.yPosition;
    }
}

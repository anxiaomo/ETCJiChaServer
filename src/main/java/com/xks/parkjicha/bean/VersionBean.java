package com.xks.parkjicha.bean;

/**
 * Created by Anxiaomo on 2016/11/14.
 */
public class VersionBean {
    private String versioncode;
    private String versionname;
    private String versionmsg;
    private String downloadurl;
    private String createtime;
    private String createuser;
    private boolean isforce;

    public VersionBean(String versioncode, String versionname, String versionmsg, String downloadurl, String createtime, String createuser, boolean isforce) {
        this.versioncode = versioncode;
        this.versionname = versionname;
        this.versionmsg = versionmsg;
        this.downloadurl = downloadurl;
        this.createtime = createtime;
        this.createuser = createuser;
        this.isforce = isforce;
    }

    public String getVersioncode() {
        return versioncode;
    }

    public void setVersioncode(String versioncode) {
        this.versioncode = versioncode;
    }

    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname;
    }

    public String getVersionmsg() {
        return versionmsg;
    }

    public void setVersionmsg(String versionmsg) {
        this.versionmsg = versionmsg;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public boolean isforce() {
        return isforce;
    }

    public void setIsforce(boolean isforce) {
        this.isforce = isforce;
    }

    @Override
    public String toString() {
        return "VersionBean{" +
                "versioncode='" + versioncode + '\'' +
                ", versionname='" + versionname + '\'' +
                ", versionmsg='" + versionmsg + '\'' +
                ", downloadurl='" + downloadurl + '\'' +
                ", createtime='" + createtime + '\'' +
                ", createuser='" + createuser + '\'' +
                ", isforce=" + isforce +
                '}';
    }
}

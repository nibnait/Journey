package com.shakool.pojo;

public class Plan {
    private String userid;//用户id
    private String spoint;//计划起点
    private String epoint;//计划终点
    private String stime;//计划开始时间
    private String etime;//计划结束时间
    private long addTime;//计划分享给大家的时间

    public Plan() {
    }

    public Plan(String userid, String spoint, String epoint, String stime, String etime, long addTime) {
        this.userid = userid;
        this.spoint = spoint;
        this.epoint = epoint;
        this.stime = stime;
        this.etime = etime;
        this.addTime = addTime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSpoint() {
        return spoint;
    }

    public void setSpoint(String spoint) {
        this.spoint = spoint;
    }

    public String getEpoint() {
        return epoint;
    }

    public void setEpoint(String epoint) {
        this.epoint = epoint;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "{\"userid\":\"" + userid + "\", \"spoint\":\"" + spoint + "\", \"epoint\":\"" + epoint + "\", \"stime\":\"" + stime + "\", \"etime\":\"" + etime + "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        if (!userid.equals(plan.userid)) return false;
        if (!spoint.equals(plan.spoint)) return false;
        if (!epoint.equals(plan.epoint)) return false;
        if (!stime.equals(plan.stime)) return false;
        return etime.equals(plan.etime);

    }

    @Override
    public int hashCode() {
        int result = userid.hashCode();
        result = 31 * result + spoint.hashCode();
        result = 31 * result + epoint.hashCode();
        result = 31 * result + stime.hashCode();
        result = 31 * result + etime.hashCode();
        return result;
    }
}
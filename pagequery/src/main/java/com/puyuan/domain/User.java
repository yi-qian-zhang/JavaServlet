package com.puyuan.domain;

/**
 * @author clap of thunder
 * @date 2022-04-02 11:09
 * @description
 */
public class User {
    private int tid;
    private String tname;
    private String salary;
    private String subject;
    private String style;

    public User() {
    }

    public User(int tid, String tname, String salary, String subject, String style) {
        this.tid = tid;
        this.tname = tname;
        this.salary = salary;
        this.subject = subject;
        this.style = style;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "User{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", salary='" + salary + '\'' +
                ", subject='" + subject + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}

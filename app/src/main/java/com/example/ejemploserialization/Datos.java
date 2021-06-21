package com.example.ejemploserialization;

import java.io.Serializable;

public class Datos implements Serializable {
    private boolean Net;
    private boolean Java;
    private boolean Oracle;
    private String Schedule;

    public Datos() {
    }

    public Datos(boolean net, boolean java, boolean oracle, String schedule) {
        Net = net;
        Java = java;
        Oracle = oracle;
        Schedule = schedule;
    }
    public boolean isNet() {
        return Net;
    }
    public void setNet(boolean net) {
        Net = net;
    }
    public boolean isOracle() {
        return Oracle;
    }
    public void setOracle(boolean oracle) {
        Oracle = oracle;
    }
    public boolean isJava() {
        return Java;
    }
    public void setJava(boolean java) {
        Java = java;
    }
    public String getSchedule() {
        return Schedule;
    }
    public void setSchedule(String schedule) {
        Schedule = schedule;
    }
}
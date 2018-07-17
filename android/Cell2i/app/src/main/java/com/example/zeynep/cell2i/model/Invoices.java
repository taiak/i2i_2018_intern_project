package com.example.zeynep.cell2i.model;

/**
 * Created by rumey on 10.07.2018.
 */

public class Invoices {
    private String invoices_month;
    private String cost;
    private String date;
    private String paid;
    private String paidInfo;
    private String info;

    public Invoices() {
        this.invoices_month = invoices_month;
        this.cost = cost;
        this.date = date;
    }

    public String getInvoices_month() {
        return invoices_month;
    }

    public void setInvoices_month(String invoices_month) {
        this.invoices_month = invoices_month;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getPaidInfo() {
        return paidInfo;
    }

    public void setPaidInfo(String paidInfo) {
        this.paidInfo = paidInfo;
    }

    public String getCheckPaidInfo() {
        return info;
    }

    public void setCheckPaidInfo(String info) {
        this.info = info;
    }

}

package com.example.kisileruygulamasi.data.entity;

import java.util.List;

public class KisilerCevap {
    private List<Kisiler> kisiler;
    private int success;

    public KisilerCevap() {
    }

    public KisilerCevap(List<Kisiler> kisiler, int success) {
        this.kisiler = kisiler;
        this.success = success;
    }

    public List<Kisiler> getKisiler() {
        return kisiler;
    }

    public void setKisiler(List<Kisiler> kisiler) {
        this.kisiler = kisiler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}

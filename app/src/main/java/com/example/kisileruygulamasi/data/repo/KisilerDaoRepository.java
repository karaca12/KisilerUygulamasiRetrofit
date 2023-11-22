package com.example.kisileruygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisileruygulamasi.data.entity.CRUDCevap;
import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.data.entity.KisilerCevap;
import com.example.kisileruygulamasi.retrofit.KisilerDao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KisilerDaoRepository {
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData<>();
    private KisilerDao kisilerDao;

    public KisilerDaoRepository(KisilerDao kisilerDao) {
        this.kisilerDao = kisilerDao;
    }

    public void kaydet(String kisi_ad, String kisi_tel) {
        kisilerDao.kaydet(kisi_ad, kisi_tel).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void guncelle(int kisi_id, String kisi_ad, String kisi_tel) {
        kisilerDao.guncelle(kisi_id, kisi_ad, kisi_tel).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }


    public void sil(int kisi_id) {
        kisilerDao.sil(kisi_id).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                kisileriYukle();
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void ara(String aramaKelimesi) {
        kisilerDao.ara(aramaKelimesi).enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> list = response.body().getKisiler();
                kisilerListesi.setValue(list);
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void kisileriYukle() {
        kisilerDao.kisileriYukle().enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> list = response.body().getKisiler();
                kisilerListesi.setValue(list);
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }
}

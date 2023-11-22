package com.example.kisileruygulamasi.retrofit;

import com.example.kisileruygulamasi.data.entity.CRUDCevap;
import com.example.kisileruygulamasi.data.entity.KisilerCevap;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface KisilerDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    //http://kasimadalan.pe.hu/ -> Base Url
    //kisiler/tum_kisiler.php -> API Url

    @GET("kisiler/tum_kisiler.php")
    Call<KisilerCevap> kisileriYukle();

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    Call<CRUDCevap> kaydet(@Field("kisi_ad") String kisi_ad, @Field("kisi_tel") String kisi_tel);

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    Call<CRUDCevap> guncelle(@Field("kisi_id") int kisi_id, @Field("kisi_ad") String kisi_ad,
                             @Field("kisi_tel") String kisi_tel);

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    Call<CRUDCevap> sil(@Field("kisi_id") int kisi_id);

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    Call<KisilerCevap> ara(@Field("kisi_ad") String kisi_ad);
}

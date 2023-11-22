package com.example.kisileruygulamasi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.databinding.CardTasarimBinding;
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections;
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {
    private List<Kisiler> kisilerListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;

    public KisilerAdapter(List<Kisiler> kisilerListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.kisilerListesi = kisilerListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewKisiAd.setText(kisi.getKisi_ad());
        t.textViewKisiTel.setText(kisi.getKisi_tel());

        t.imageViewSil.setOnClickListener(v -> {
            Snackbar.make(v,kisi.getKisi_ad()+" silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET",v1 -> {
                        viewModel.sil(kisi.getKisi_id());
                    })
                    .show();
        });

        t.cardViewSatir.setOnClickListener(v -> {
            AnasayfaFragmentDirections.KisiDetayGecis gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi);
            Navigation.findNavController(v).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
    }
}

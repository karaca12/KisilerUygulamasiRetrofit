package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding;
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter;
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);

        binding.kisilerRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.kisilerListesi.observe(getViewLifecycleOwner(),kisilerListesi -> {
            KisilerAdapter adapter = new KisilerAdapter(kisilerListesi,requireContext(),viewModel);
            binding.kisilerRv.setAdapter(adapter);
        });

        binding.fab.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.kisiKayitGecis);
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {//Klavye üzerindeki arama iconu ile çalışır.
                viewModel.ara(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {//Harf girdikçe veya sildikçe çalışır.
                viewModel.ara(newText);
                return true;
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.kisileriYukle();
    }
}
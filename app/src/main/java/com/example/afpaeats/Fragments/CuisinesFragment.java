package com.example.afpaeats.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.afpaeats.Adapters.CuisinesAdapter;
import com.example.afpaeats.Entities.TypeCuisines;
import com.example.afpaeats.R;
import com.google.gson.Gson;

public class CuisinesFragment extends Fragment {

    Context _context;
    static TypeCuisines _typeCuisines;

    public CuisinesFragment() {
        // Required empty public constructor
    }

    public static CuisinesFragment newInstance(String typeCuisinesJson) {
        CuisinesFragment fragment = new CuisinesFragment();

        Gson gson = new Gson();

        _typeCuisines = gson.fromJson(typeCuisinesJson, TypeCuisines.class);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cuisines, container, false);
        RecyclerView rvwCuisines = view.findViewById(R.id.rvwCuisines);

        //on instancie notre adapter
        CuisinesAdapter cuisinesAdapter = new CuisinesAdapter(_typeCuisines,_context);

        //la manière dont les adherents doivent s'afficher
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(_context, LinearLayoutManager.VERTICAL, false);


        rvwCuisines.setLayoutManager(layoutManager);

        //Effet sur le recyclerView
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        rvwCuisines.setItemAnimator(defaultItemAnimator);

        //on passe notre adapter à notre recyclerview
        rvwCuisines.setAdapter(cuisinesAdapter);

        return view;
    }
}

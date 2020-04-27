package com.example.afpaeats.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afpaeats.Entities.TypeCuisine;
import com.example.afpaeats.Entities.TypeCuisines;
import com.example.afpaeats.R;

public class CuisinesAdapter extends RecyclerView.Adapter<TypeCuisineHolder> {

    //notre liste d'adherents
    TypeCuisines _typeCuisines;
    Context _context;

    public CuisinesAdapter(TypeCuisines typeCuisines, Context context) {
        //on initialise notre liste adherents via le constructeur
        this._typeCuisines = typeCuisines;
        this._context = context;
    }

    @NonNull
    @Override
    public TypeCuisineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //on récupére le fichier xml graphique parmi les layouts
        View view = LayoutInflater.from(_context).inflate(R.layout.item_type_cuisne,parent,false);
        //on passe notre objet(view) à notre view holder
        return new TypeCuisineHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeCuisineHolder adherentHolder, int position) {
        //on recupére un adherent parmi la liste des adherents en fonction de sa position
        TypeCuisine typeCuisine = this._typeCuisines.get(position);
        //on passe l'objet adherent a notre viewholder
        adherentHolder.setTypeCuisine(typeCuisine);
    }

    @Override
    public int getItemCount() {
        return _typeCuisines.size();
    }
}

class TypeCuisineHolder extends RecyclerView.ViewHolder {

    public final TextView txtNom;

    public TypeCuisineHolder(@NonNull View view) {
        super(view);

        //on initialise les widgets qui sont dans le layout
        txtNom = view.findViewById(R.id.txtNom);
    }

    public void setTypeCuisine(TypeCuisine typeCuisine)
    {
        // le match des donneés avec les widgets
        txtNom.setText(typeCuisine.getNom());
    }
}
package com.example.afpaeats.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afpaeats.Entities.Produit;
import com.example.afpaeats.Entities.Produits;
import com.example.afpaeats.Entities.Session;
import com.example.afpaeats.R;
import com.example.afpaeats.Utilities.Functions;

public class PanierAdapter extends RecyclerView.Adapter<ItemPanierHolder> {

    Produits _produits;
    Context _context;

    public PanierAdapter(Produits produits, Context context) {
        this._produits = produits;
        this._context = context;
    }

    @NonNull
    @Override
    public ItemPanierHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //on récupére le fichier xml graphique parmi les layouts
        View view = LayoutInflater.from(_context).inflate(R.layout.item_produit,parent,false);
        //on passe notre objet(view) à notre view holder
        return new ItemPanierHolder(view, _context);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPanierHolder itemPanierHolder, int position) {
        //on recupére un produit parmi la liste des produits en fonction de sa position
        Produit produit = this._produits.get(position);
        //on passe l'objet produit a notre viewholder
        itemPanierHolder.setProduit(produit);
    }

    @Override
    public int getItemCount() {
        return _produits.size();
    }
}

class ItemPanierHolder extends RecyclerView.ViewHolder {

    public final TextView txtNom;
    Button btnAjouterPanier;
    Produit _produit;

    public ItemPanierHolder(@NonNull View view, final Context context) {
        super(view);

        //on initialise les widgets qui sont dans le layout
        txtNom = view.findViewById(R.id.txtNom);
        btnAjouterPanier = view.findViewById(R.id.btnAjouterPanier);

        btnAjouterPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session.getPanier().add(_produit);
                Functions.getToast(context, "Produit ajouté");
            }
        });
    }

    public void setProduit(Produit produit)
    {
        this._produit = produit;
        // le match des donneés avec les widgets
        txtNom.setText(produit.getNom());
    }
}
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
        import com.example.afpaeats.R;

public class ProduitsAdapter extends RecyclerView.Adapter<ProduitHolder> {

    Produits _produits;
    Context _context;

    public ProduitsAdapter(Produits produits, Context context) {
        this._produits = produits;
        this._context = context;
    }

    @NonNull
    @Override
    public ProduitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //on récupére le fichier xml graphique parmi les layouts
        View view = LayoutInflater.from(_context).inflate(R.layout.item_produit,parent,false);
        //on passe notre objet(view) à notre view holder
        return new ProduitHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitHolder produitHolder, int position) {
        //on recupére un produit parmi la liste des produits en fonction de sa position
        Produit produit = this._produits.get(position);
        //on passe l'objet produit a notre viewholder
        produitHolder.setProduit(produit);
    }

    @Override
    public int getItemCount() {
        return _produits.size();
    }
}

class ProduitHolder extends RecyclerView.ViewHolder {

    public final TextView txtNom;
    Button btnAjouterPanier;
    Produit _produit;

    public ProduitHolder(@NonNull View view) {
        super(view);

        //on initialise les widgets qui sont dans le layout
        txtNom = view.findViewById(R.id.txtNom);
        btnAjouterPanier = view.findViewById(R.id.btnAjouterPanier);

        btnAjouterPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
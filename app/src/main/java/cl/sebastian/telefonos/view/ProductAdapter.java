package cl.sebastian.telefonos.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.sebastian.telefonos.R;
import cl.sebastian.telefonos.model.Producto;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductVH>{

    List<Producto> listProduct;

    public ProductAdapter(List<Producto> listProduct) {
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Producto p = listProduct.get(position);
        holder.bind(p);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }


    public void updateItems(List<Producto> pListProduct){
        listProduct.clear();
        listProduct.addAll(pListProduct);
        notifyDataSetChanged();

    }

    public class ProductVH extends RecyclerView.ViewHolder{
        private TextView tvName;
        public ProductVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.nameView);
        }

        public void bind(Producto p) {
            tvName.setText(p.getName());
        }
    }
}

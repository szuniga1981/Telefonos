package cl.sebastian.telefonos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.sebastian.telefonos.R;
import cl.sebastian.telefonos.model.Producto;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductVH>{

    List<Producto> listProduct;
    Context context;
    public ProductAdapter(List<Producto> listProduct, Context context) {
        this.listProduct = listProduct;
        this.context=context;
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
        private TextView tvId;
        private TextView tvPrice;
        private ImageView imgPhone;


        public ProductVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.nameView);
            tvId=itemView.findViewById(R.id.idView);
            tvPrice=itemView.findViewById(R.id.priceView);
            imgPhone=itemView.findViewById(R.id.imageView);

        }

        public void bind(Producto p) {
            tvName.setText(p.getName());
            tvId.setText(String.valueOf(p.getId()));
            tvPrice.setText(String.valueOf(p.getPrice()));
            Glide.with(context).load(p.getImage()).into(imgPhone);
        }

    }
}

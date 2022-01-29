package com.kanyi.bigtuna.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kanyi.bigtuna.R;
import com.kanyi.bigtuna.models.ModelCartItem;
import com.kanyi.bigtuna.models.ModelOrderedItem;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterOrderedItem extends RecyclerView.Adapter<AdapterOrderedItem.HolderOrderedItem> {

    private Context context;
    private ArrayList<ModelOrderedItem> orderedItemArrayList;

    public AdapterOrderedItem(Context context, ArrayList<ModelOrderedItem> orderedItemArrayList) {
        this.context = context;
        this.orderedItemArrayList = orderedItemArrayList;
    }

    @NonNull
    @Override
    public HolderOrderedItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.row_ordereditem,parent, false);

        return new HolderOrderedItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderOrderedItem holder, int position) {

        ModelOrderedItem modelOrderedItem = orderedItemArrayList.get(position);
        String getpId = modelOrderedItem.getpId();
        String name = modelOrderedItem.getName();
        String cost = modelOrderedItem.getCost();
        String price = modelOrderedItem.getPrice();
        String quantity = modelOrderedItem.getQuantity();

        holder.itemTitleTv.setText(name);
        holder.itemPriceEachTv.setText("$"+price);
        holder.itemPriceTv.setText("$"+cost);
        holder.itemQuantityTv.setText("["+quantity+"]");

    }

    @Override
    public int getItemCount() {
        return orderedItemArrayList.size();
    }

    class HolderOrderedItem extends RecyclerView.ViewHolder{

        private Text itemTitleTv, itemPriceTv, itemPriceEachTv, itemQuantityTv;

        public HolderOrderedItem(@NonNull View itemView) {
            super(itemView);

            itemTitleTv = itemView.findViewById(R.id.itemTitleTv);
            itemPriceTv = itemView.findViewById(R.id.itemPriceTv);
            itemPriceEachTv = itemView.findViewById(R.id.itemPriceEachTv);
            itemQuantityTv = itemView.findViewById(R.id.itemQuantityTv);

        }
    }
}

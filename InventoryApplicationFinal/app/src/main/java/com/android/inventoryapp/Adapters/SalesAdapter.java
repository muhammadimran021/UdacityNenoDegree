package com.android.inventoryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.inventoryapp.Models.Products;
import com.android.inventoryapp.Models.Sales_Details;
import com.android.inventoryapp.R;

import java.util.ArrayList;

public class SalesAdapter extends BaseAdapter {

    private ArrayList<Sales_Details> sales_detailses;
    private Context context;

    public SalesAdapter(ArrayList<Sales_Details> sales_detailses, Context context) {
        this.sales_detailses = sales_detailses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sales_detailses.size();
    }

    @Override
    public Object getItem(int position) {
        return sales_detailses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return sales_detailses.get(position).getSid();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.sale_layout,null);

        Sales_Details sales = sales_detailses.get(position);

        TextView nameView = (TextView) view.findViewById(R.id.sale_nameView);
        TextView quantityView = (TextView) view.findViewById(R.id.sale_QuantityView);
        TextView priceView = (TextView) view.findViewById(R.id.sale_priceView);
        TextView quantityLeft = (TextView) view.findViewById(R.id.sale_Quantityletf);

        nameView.setText(sales.getProdutName());
        quantityView.setText("Sales :"+String.valueOf(sales.getsQuantity()));
        priceView.setText("PKR "+String.valueOf(5)+"/");
        quantityLeft.setText("Quantity Available :"+String.valueOf(sales.getsQuantityLeft()));

        return view;
    }
}

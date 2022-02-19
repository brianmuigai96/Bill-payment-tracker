package com.moringaschool.bill_tracker.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.models.Bill;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    Context context;
    ArrayList<Bill> mbill;

    public BillAdapter(Context context, ArrayList<Bill> mbill) {
        this.context = context;
        this.mbill = mbill;
    }

    @Override
    public BillAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflate =LayoutInflater.from(context);
        View view = inflate.inflate(R.layout.add_bill_strip,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(mbill.get(position).getBillName());
        holder.textView2.setText(mbill.get(position).getDueDate());
        holder.textView3.setText(mbill.get(position).getAmount());





    }

    @Override
    public int getItemCount() {
        return mbill.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 =itemView.findViewById(R.id.nameEditText);
            textView2 =itemView.findViewById(R.id.dueDate);
            textView3 =itemView.findViewById(R.id.amount);
        }


    }
}

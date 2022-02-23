package com.moringaschool.bill_tracker.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.bill_tracker.R;
import com.moringaschool.bill_tracker.models.Bill;
import com.moringaschool.bill_tracker.ui.AddBill;
import com.moringaschool.bill_tracker.ui.BillDetailActivity;
import com.moringaschool.bill_tracker.ui.DashboardActivity;

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
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
        holder.textView1.setText(mbill.get(position).getBillName());
        holder.textView2.setText(mbill.get(position).getDueDate());
        holder.textView3.setText(mbill.get(position).getAmount());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,BillDetailActivity.class);
                intent.putExtra("Bill",mbill.get(position));
                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return mbill.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 =itemView.findViewById(R.id.nameEditText);
            textView2 =itemView.findViewById(R.id.dueDate);
            textView3 =itemView.findViewById(R.id.amount);
            cardView =itemView.findViewById(R.id.cardview);
        }


    }
}

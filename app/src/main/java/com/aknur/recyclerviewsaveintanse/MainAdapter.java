package com.aknur.recyclerviewsaveintanse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.xml.namespace.QName;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<ListItem> list;

    MainAdapter(Context context,List<ListItem> list){
            this.inflater=LayoutInflater.from(context);
            this.list=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recycler_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem=list.get(position);
        holder.textView.setText(listItem.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        public ViewHolder(@NonNull View view) {
            super(view);
            textView=(TextView)view.findViewById(R.id.texter);
        }

    }

}

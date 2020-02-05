package com.epicteck.ajayimajebijoshua.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.epicteck.ajayimajebijoshua.R;
import com.epicteck.ajayimajebijoshua.interfaces.FilterItemClickedListener;
import com.epicteck.ajayimajebijoshua.models.Filter;
import com.epicteck.ajayimajebijoshua.viewholders.FilterViewHolder;

import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Filter> filterList;
    private FilterItemClickedListener filterItemClickedListener;

    public FilterAdapter(Context c, List<Filter> list, FilterItemClickedListener filterItemClickedListener){
        inflater = LayoutInflater.from(c) ;

        this.context = c;

        this.filterItemClickedListener = filterItemClickedListener;

        this.filterList = list;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_layout, parent, false);

        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        Filter filter = filterList.get(position);

        holder.bind(filter, position, this.filterItemClickedListener);
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public void setFilters(List<Filter> filterList){
        if(filterList ==null){
            return;
        }

        this.filterList.clear();
        this.filterList.addAll(filterList);
        notifyDataSetChanged();
    }
}

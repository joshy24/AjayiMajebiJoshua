package com.epicteck.ajayimajebijoshua.viewholders;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.epicteck.ajayimajebijoshua.R;
import com.epicteck.ajayimajebijoshua.interfaces.FilterItemClickedListener;
import com.epicteck.ajayimajebijoshua.models.Filter;
import com.epicteck.ajayimajebijoshua.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.layout)
    View layout;

    @BindView(R.id.date)
    TextView date;

    @BindView(R.id.gender)
    TextView gender;

    @BindView(R.id.countries)
    TextView countries;

    @BindView(R.id.color)
    TextView color;

    public FilterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Filter filter , final int position, final FilterItemClickedListener filterItemClickedListener){
        String d = filter.getStart_year() +" - "+filter.getEnd_year();
        date.setText(d);

        gender.setText(StringUtil.toFirstUpper(filter.getGender()));

        if(filter.getCountries().size()>0){
            StringBuilder countrys = new StringBuilder();

            for(int i=0; i<filter.getCountries().size(); i++){
                if(i==filter.getCountries().size()-1){
                    //dont add a , if its the last index
                    countrys.append(StringUtil.toFirstUpper(filter.getCountries().get(i)));
                }
                else{
                    countrys.append(StringUtil.toFirstUpper(filter.getCountries().get(i))).append(", ");
                }
            }

            countries.setText(countrys.toString());
        }

        if(filter.getColors().size()>0){
            StringBuilder colors = new StringBuilder();

            for(int j=0; j<filter.getColors().size(); j++){

                if(j==filter.getColors().size()-1){
                    //dont add a , if its the last index
                    colors.append(StringUtil.toFirstUpper(filter.getColors().get(j)));
                }
                else{
                    colors.append(StringUtil.toFirstUpper(filter.getColors().get(j))).append(", ");
                }
            }

            color.setText(colors.toString());
        }

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterItemClickedListener.onItemClicked(filter);
            }
        });
    }
}

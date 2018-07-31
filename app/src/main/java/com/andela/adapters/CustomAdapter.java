package com.andela.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.Article;
import com.andela.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

    private List<Article> myarticles;
    private Context context;

    public CustomAdapter(List<Article> myarticles, Context context) {
        this.myarticles = myarticles;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.article_item_list, parent, false);


        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.title.setText(myarticles.get(position).getTitle());
        holder.subtext.setText(myarticles.get(position).getDescription());
        holder.source.setText(myarticles.get(position).getSource().getName());
        holder.time.setText(myarticles.get(position).getPublishedAt());


        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(myarticles.get(position).getUrlToImage())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return myarticles.size();
    }


     class CustomViewHolder  extends RecyclerView.ViewHolder{

        public View mview = null;
        private ImageView thumbnail;
        private TextView title;
        private TextView subtext;
        private TextView source;
        private TextView time;

         CustomViewHolder(View itemView) {
            super(itemView);

            mview = itemView;

            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            subtext = itemView.findViewById(R.id.subtext);
            source = itemView.findViewById(R.id.source);
            time = itemView.findViewById(R.id.time);



        }
    }
}

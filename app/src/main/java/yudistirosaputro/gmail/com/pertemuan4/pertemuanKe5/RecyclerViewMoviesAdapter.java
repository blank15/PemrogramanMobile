package yudistirosaputro.gmail.com.pertemuan4.pertemuanKe5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import yudistirosaputro.gmail.com.pertemuan4.R;

/**
 * Created by blank15 on 11/04/2018.
 */

public class RecyclerViewMoviesAdapter extends RecyclerView.Adapter<RecyclerViewMoviesAdapter.ViewHolder> {

    private List<Movie> movieList;
    Context context;

    public RecyclerViewMoviesAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewTitle.setText(movieList.get(position).getTitle());
        holder.textViewYear.setText(movieList.get(position).getYear());
        holder.textViewGenre.setText(movieList.get(position).getGenre());
        holder.textViewRating.setText(movieList.get(position).getRating());
        holder.imageView.setBackground(context.getResources().getDrawable(movieList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle,textViewYear,textViewGenre,textViewRating;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textViewTitle = itemView.findViewById(R.id.textTitle);
            textViewYear = itemView.findViewById(R.id.textYear);
            textViewGenre = itemView.findViewById(R.id.textGenre);
            textViewRating = itemView.findViewById(R.id.textRating);

        }
    }
}

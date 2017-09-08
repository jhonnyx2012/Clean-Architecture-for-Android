package jhonnyx.clean.marvel.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import jhonnyx.clean.marvel.R;
import jhonnyx.clean.marvel.domain.model.Comic;
import jhonnyx.clean.marvel.util.GlideUtils;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ViewHolder> {
    private ArrayList<Comic> list;
    private Context context;
    private OnItemClickListener listener;

    public ComicAdapter(Context context) {
        this.context=context;
        this.list = new ArrayList<>();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_comic_grid, viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int i) {
        final Comic item = getItem(i);
        holder.progressBar.setVisibility(View.VISIBLE);
        DrawableRequestBuilder<String> glideRequest = Glide.with(context)
                .load(item.thumbnailUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(GlideUtils.getGlideListener(holder.progressBar));
        glideRequest.into(holder.ivThumbnail);
        holder.tvPrice.setText(item.price);
        holder.tvTitle.setText(item.title);
        holder.ivThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(item);
            }
        });
    }

    public Comic getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Comic> results) {
        list.clear();
        list.addAll(results);
        notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ivThumbnail)
        ImageView ivThumbnail;

        @BindView(R.id.tvPrice)
        TextView tvPrice;

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.progressBar)
        View progressBar;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,itemView);
        }
    }
}
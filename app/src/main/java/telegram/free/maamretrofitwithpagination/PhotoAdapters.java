package telegram.free.maamretrofitwithpagination;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import telegram.free.maamretrofitwithpagination.Photos.ModelClass.PhotosModel;
import telegram.free.maamretrofitwithpagination.databinding.CustomDesignBinding;

public class PhotoAdapters extends PagedListAdapter<PhotosModel, PhotoAdapters.CustomView> {

    public PhotoAdapters() {
        super(PhotosModel.callback);
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomDesignBinding designBinding=CustomDesignBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CustomView(designBinding.getRoot());
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {
         holder.binding.tvTitle.setText(getCurrentList().get(position).getTitle());
         holder.binding.tvAlbumId.setText(getCurrentList().get(position).getAlbumId()+"");
         holder.binding.tvId.setText(getCurrentList().get(position).getId()+"");
        Log.d("url_thumnail",getCurrentList().get(position).getUrl()+"_");
        Picasso.get().load(getCurrentList().get(position).getUrl()).into(holder.binding.ivThumnail);

//        Glide.with(holder.binding.getRoot()).load(getCurrentList().get(position).getUrl()).placeholder(R.drawable.ic_launcher_background).dontAnimate().into(holder.binding.ivThumnail);
    }

    public class CustomView extends RecyclerView.ViewHolder{
        CustomDesignBinding binding;
        public CustomView(@NonNull View itemView) {
            super(itemView);
            binding=CustomDesignBinding.bind(itemView);
        }
    }
}

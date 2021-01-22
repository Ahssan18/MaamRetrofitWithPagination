package telegram.free.maamretrofitwithpagination.Photos.ModelClass;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import telegram.free.maamretrofitwithpagination.Networking.ApiServices;
import telegram.free.maamretrofitwithpagination.Networking.RetrofitClientInstance;

public class PhotoDataSource extends PageKeyedDataSource<Long, PhotosModel> {
    ApiServices apiServices;
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, PhotosModel> callback) {
        apiServices= RetrofitClientInstance.getRetrofitInstance().create(ApiServices.class);
        apiServices.getAllPhotos(1).enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {
                Log.d("page_lehjgfjg","call_");
                List<PhotosModel> list=response.body();
                callback.onResult(list,null,(long)2);
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, PhotosModel> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, PhotosModel> callback) {
        apiServices.getAllPhotos(params.key).enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {
                List<PhotosModel> list=response.body();
                Log.d("_page_lehjgfjg",((params.requestedLoadSize)+1)+"_");
                callback.onResult(list,(params.key)+1);
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {

            }
        });

    }
}

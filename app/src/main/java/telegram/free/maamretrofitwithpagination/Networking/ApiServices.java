package telegram.free.maamretrofitwithpagination.Networking;

import android.provider.Contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import telegram.free.maamretrofitwithpagination.Photos.ModelClass.PhotosModel;

public interface ApiServices {
    @GET("/photos")
    Call<List<PhotosModel>> getAllPhotos(@Query("albumId") long albumId);
}

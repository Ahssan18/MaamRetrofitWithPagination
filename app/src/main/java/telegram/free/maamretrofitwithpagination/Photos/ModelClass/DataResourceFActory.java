package telegram.free.maamretrofitwithpagination.Photos.ModelClass;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class DataResourceFActory extends DataSource.Factory {
    PhotoDataSource photoDataSource;

    public MutableLiveData<PhotoDataSource> getPhotosModelMutableLiveData() {
        return photosModelMutableLiveData;
    }

    MutableLiveData<PhotoDataSource> photosModelMutableLiveData;

    public DataResourceFActory() {
        photosModelMutableLiveData=new MutableLiveData<>();
    }

    @Override
    public DataSource create() {
        photoDataSource=new PhotoDataSource();
        photosModelMutableLiveData.postValue(photoDataSource);
        return photoDataSource;
    }
}

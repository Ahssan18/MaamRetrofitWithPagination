package telegram.free.maamretrofitwithpagination.Photos.ModelClass;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivityViewModel extends AndroidViewModel {
    DataResourceFActory dataResourceFActory;
    MutableLiveData<PhotoDataSource> mutableLiveData;
    Executor executor;

    public LiveData<PagedList<PhotosModel>> getListLiveData() {
        return listLiveData;
    }

    LiveData<PagedList<PhotosModel>> listLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        dataResourceFActory = new DataResourceFActory();
        mutableLiveData = dataResourceFActory.getPhotosModelMutableLiveData();
        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build();
        executor = Executors.newFixedThreadPool(5);
        listLiveData=(new LivePagedListBuilder<Long,PhotosModel>(dataResourceFActory,config))
                .setFetchExecutor(executor)
                .build();
    }
}

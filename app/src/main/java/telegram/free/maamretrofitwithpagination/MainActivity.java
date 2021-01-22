package telegram.free.maamretrofitwithpagination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import telegram.free.maamretrofitwithpagination.Photos.ModelClass.MainActivityViewModel;
import telegram.free.maamretrofitwithpagination.Photos.ModelClass.PhotosModel;
import telegram.free.maamretrofitwithpagination.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    ActivityMainBinding activityMainBinding;
    List<PhotosModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        init();
        getData();
    }

    private void getData() {
        viewModel.getListLiveData().observe(this, photosModels -> {
            activityMainBinding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
            PhotoAdapters adapters=new PhotoAdapters();
            adapters.submitList(photosModels);
            activityMainBinding.recyclerView.setAdapter(adapters);

        });
    }

    private void init() {
        list=new ArrayList<>();
        viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }
}
package com.example.popularmoviesapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.popularmoviesapp.RoomDatabase.FavoriteMovie;
import com.example.popularmoviesapp.RoomDatabase.MovieDatabase;


import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<FavoriteMovie>> movies;

    public MainViewModel(Application application) {
        super(application);
        MovieDatabase database = MovieDatabase.getInstance(this.getApplication());
//        Log.d(TAG, "Actively retrieving favorite movies from the DataBase");
        movies = database.movieDao().loadAllMovies();
    }

    LiveData<List<FavoriteMovie>> getMovies() {
        return movies;
    }
}

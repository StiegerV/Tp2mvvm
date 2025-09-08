package com.prueba.tp2mvvm;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.prueba.tp2mvvm.modelo.LibroModel;

public class LibroViewModel extends AndroidViewModel {

    private LiveData<LibroModel> libroMutable;
    public LibroViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<LibroModel> getLibroMutable(){
        if (libroMutable==null){
            libroMutable=new MutableLiveData<>();
        }

        return libroMutable;
    }

    public void recuperarMutable(Intent ynt){
        LibroModel libro =
    }

}

package com.prueba.tp2mvvm;

import android.app.Application;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.prueba.tp2mvvm.modelo.LibroModel;

public class LibroViewModel extends AndroidViewModel {

    private MutableLiveData<LibroModel> libroMutable;
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
        if (libroMutable==null){
            libroMutable=new MutableLiveData<>();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            LibroModel libro =(LibroModel) ynt.getSerializableExtra("libro",LibroModel.class);
            libroMutable.setValue(libro);
        }
    }

}

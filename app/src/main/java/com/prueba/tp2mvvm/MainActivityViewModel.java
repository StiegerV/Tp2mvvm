package com.prueba.tp2mvvm;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.prueba.tp2mvvm.modelo.LibroModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> mensaje;
    private MutableLiveData<LibroModel> libroEncontrado;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensajeMutable(){
        //para que la activity le pueda poner un ubserver
        if (mensaje==null){
            mensaje=new MutableLiveData<>();
        }

        return mensaje;
    }


    public LiveData<LibroModel> getLibro(){
        if(libroEncontrado==null){
            libroEncontrado=new MutableLiveData<>();
        }

        return libroEncontrado;
    }


    public void Buscar(String libro){


       LibroModel libro1=new LibroModel("El hobbit (título original en inglés: The Hobbit, or There and Back Again, usualmente abreviado como The Hobbit) es una novela fantástica del filólogo y escritor británico J. R. R. Tolkien. Fue escrita por partes desde finales de los años 1920 hasta principios de los años 1930 y, en un principio, tan solo tenía el objetivo de divertir a los hijos pequeños de Tolkien","Tolkien","El hobbit",R.drawable.tolkien1);
        LibroModel libro2=new LibroModel("El Señor de los Anillos (título original en inglés: The Lord of the Rings) es una novela de fantasía épica escrita por el filólogo y escritor británico J. R. R. Tolkien.","Tolkien","El señor de las vanillas",R.drawable.tolkien2);
        LibroModel libro3=new LibroModel("The Voynich manuscript is an illustrated codex, hand-written in an unknown script referred to as Voynichese.[18] The vellum on which it is written has been carbon-dated to the early 15th century (1404–1438)","no se","el manuscrito de voynich",R.drawable.voynic);
        List<LibroModel> libros=new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        LibroModel encontro=null;
            for (LibroModel lib :libros){
                if (lib.getTitulo().toLowerCase().contains(libro.toLowerCase())){
                    encontro=lib;
                }
            }

            if (encontro!=null){
               libroEncontrado.setValue(encontro);
            }else{
                mensaje.setValue("No se encontro el libro");
            }
    }




}

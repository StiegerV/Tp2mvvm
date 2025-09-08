package com.prueba.tp2mvvm;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.prueba.tp2mvvm.databinding.ActivityLibroBinding;

public class LibroActivity extends AppCompatActivity {

    private ActivityLibroBinding binding;
    private LibroViewModel libroViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        libroViewModel = new ViewModelProvider(this).get(LibroViewModel.class);

        libroViewModel.recuperarMutable(getIntent());


        libroViewModel.getLibroMutable().observe(this, libro -> {
            if (libro != null) {
                binding.tvDescripcion.setText(libro.getDescripcion());
                binding.tvTags.setText(libro.getAutor());
                binding.ivPortada.setImageResource(libro.getImagen());
            }
        });
    }
}
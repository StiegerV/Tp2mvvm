package com.prueba.tp2mvvm;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.prueba.tp2mvvm.databinding.ActivityLibroBinding;

public class LibroActivity extends AppCompatActivity {

    private ActivityLibroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String titulo=intent.getStringExtra("titulo");
        String descripcion = intent.getStringExtra("descripcion");
        String tags = intent.getStringExtra("tags");
        int portada = intent.getIntExtra("imagen", 0);

    binding.tvTitulo.setText(titulo);
        binding.tvDescripcion.setText(descripcion);
        binding.tvTags.setText(tags);
        binding.ivPortada.setImageResource(portada);

    }
}
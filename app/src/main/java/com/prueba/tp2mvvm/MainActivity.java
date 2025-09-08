package com.prueba.tp2mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.prueba.tp2mvvm.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aca se ejecuta cuando clickea
                String titulo=binding.etLibro.getText().toString();
                vm.Buscar(titulo);

            }
        });

        vm.getLibro().observe(this,libro ->{
            if (libro != null){
                Intent intent = new Intent(MainActivity.this, LibroActivity.class);
                intent.putExtra("libro", libro);

                startActivity(intent);
            }
        });


        vm.getMensajeMutable().observe(this, msg -> {
            binding.tvError.setText(msg);
        });

    }
}
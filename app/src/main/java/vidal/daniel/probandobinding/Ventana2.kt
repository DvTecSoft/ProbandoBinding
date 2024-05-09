package vidal.daniel.probandobinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vidal.daniel.probandobinding.databinding.ActivityMainBinding
import vidal.daniel.probandobinding.databinding.ActivityVentana2Binding

class Ventana2 : AppCompatActivity() {

    lateinit var binding : ActivityVentana2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Se configura el binding
        binding = ActivityVentana2Binding.inflate(layoutInflater)

        // Vamos a setear a la pantalla la vista que debe mostrar
        setContentView(binding.root)


        binding.txtPantalla.text = MainActivity.titulopantalla

        // MainActivity.saludo()

    }
}
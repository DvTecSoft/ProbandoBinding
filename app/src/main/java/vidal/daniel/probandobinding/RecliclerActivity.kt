package vidal.daniel.probandobinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vidal.daniel.probandobinding.adapter.PeliculasAdapter
import vidal.daniel.probandobinding.databinding.ActivityVentana2Binding
import vidal.daniel.probandobinding.databinding.ReciclerBinding

class RecliclerActivity : AppCompatActivity() 
{
    lateinit var binding : ReciclerBinding

    override fun onCreate(savedInstanceState: Bundle?) 
    {
        super.onCreate(savedInstanceState)

        // Se configura el binding
        binding = ReciclerBinding.inflate(layoutInflater)
        // Vamos a setear a la pantalla la vista que debe mostrar
        setContentView(binding.root)

        val peliculas = arrayOf("Ghost", "Shrek I", "Shrek II", "Shrek III", "Shrek IV", "Top Gun","La edad de oro"
            ,"los paracaidistas del submarino rojo"
            ,"los muertos luchan por vivir"
            ,"el discreto encanto de la burguesía"
            ,"el séptimo sello"
            ,"El Padrino"
            ,"Día de los Santos Inocentes"
            ,"Top Gun"
            ,"niño en ´pijama de rayas"
            ,"el mundo de wain"
            ,"en busca de la felicidad"
            ,"naranja mecanica"
            ,"El perfecto asesino"
            ,"Mision Imposible"
            ,"solaris"
            ,"el resplandor"
            ,"Negocio redondo"
            ,"el guardaespaldas"
            ,"incendio bajo el mar"
            ,"agachate que vienen los indios"
            ,"frankenstain"
            ,"el siete machos")

        // Configuramos el adaptador que se va a encargar de unir los datos con la vista
        val adaptadorPeliculas = PeliculasAdapter(peliculas.sortedArray())

        binding.reciLista.adapter = adaptadorPeliculas






    }
}
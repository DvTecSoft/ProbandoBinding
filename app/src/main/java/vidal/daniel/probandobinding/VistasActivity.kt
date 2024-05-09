package vidal.daniel.probandobinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import vidal.daniel.probandobinding.databinding.ActivityVentana2Binding
import vidal.daniel.probandobinding.databinding.VistasBinding
import android.R

class VistasActivity : AppCompatActivity()
{
    lateinit var binding : VistasBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.vistas)

        // Se configura el binding
        binding = VistasBinding.inflate(layoutInflater)

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

        // Vamos a llenar la lista
        val adaptador =  ArrayAdapter(this, R.layout.simple_list_item_1 ,peliculas)

        // Se enlaza el adaptador con la lista definida
        binding.listaPeli.adapter = adaptador






    }
}
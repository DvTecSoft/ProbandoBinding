package vidal.daniel.probandobinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vidal.daniel.probandobinding.R
import vidal.daniel.probandobinding.databinding.ItemFilaBinding

// Se crea una clase y se debe EXTENDER de la clase RecyclerView.Adapter que agrega los métodos de abajo
class PeliculasAdapter (private val listaPeliculas : Array<String>) : RecyclerView.Adapter<PeliculasAdapter.ViewHolder>()
{

    /**
    Esta clase define los diferentes elementos que están definidos en la fila que va  a mostrar la información
    */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        // Ejemplo sin binding
        val tituloPelicula : TextView
        val subtituloPelicula : TextView

        init
        {
            tituloPelicula = view.findViewById(R.id.txt_titulopelicula)
            subtituloPelicula = view.findViewById(R.id.txt_subtitulopelicula)
        }
    }

    // Enlaza el archivo XML item_fila.xml con la clase ViewHolder creada anteriormente
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        // Creando una nueva vista que define la celda que vamos a pintas la información
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fila, parent, false)
        return ViewHolder(view)
    }

    // Devuelve la cantidad de item a mostrar en el recycler
    override fun getItemCount(): Int
    {
        return listaPeliculas.size
    }

    // Vamos a configurar la información en cada celda que vamos a mostrar en la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        // Obtiene el elemento desde la lista con su posición y reemplaza el contenido en los view de la celda
        // Se muestra el título de la película
        holder.tituloPelicula.text = listaPeliculas[position]
        // Vamos a agregar un texto en el subtitulo
        holder.subtituloPelicula.text = "Estoy en la posición $position"
        // Si tengo clic, si tengo imágenes, todo va acá
    }



}
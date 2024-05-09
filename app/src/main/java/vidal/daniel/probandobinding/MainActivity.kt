package vidal.daniel.probandobinding

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import vidal.daniel.probandobinding.databinding.ActivityMainBinding
import vidal.daniel.probandobinding.databinding.ReciclerBinding

class MainActivity : AppCompatActivity()
{

    lateinit var binding : ActivityMainBinding
    val MY_PERMISSIONS_REQUEST_CAMERA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se configura el binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Vamos a setear a la pantalla la vista que debe mostrar
        setContentView(binding.root)

        // textchangedlistener = lostfocus -> Buscar

        // Texto cambiando mientras escribe
        /*
        binding.txtNombre.addTextChangedListener {
            Toast.makeText(this, "Despues", Toast.LENGTH_SHORT).show()
        }
        */

        binding.txtNombre.setOnFocusChangeListener { view, hasFocus ->
            if(!hasFocus) {
                var nombre  = binding.txtNombre.text.toString()

                Toast.makeText(this, "Salio", Toast.LENGTH_SHORT).show()

                binding.txtNombre.setText(nombre.uppercase());

            }
        }

        binding.btnGuardar.setOnClickListener {

            var nombre  = binding.txtNombre.text.toString()
            var correo  = binding.txtCorreo.text.toString()
            var edad    = binding.txtEdad.text.toString()

            if ( validaDatos(nombre, correo, edad) == true )
            {
                Toast.makeText(this, "$nombre", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnOnClic.setOnClickListener {
            // Abro la Ventana2 y debe aparecer los mensajes
            //val ventana2 = Intent(this, Ventana2::class.java)
            // startActivity(ventana2)

            pedirPermisos()

        }

        // Llama a pedir permiso
        pedirPermisos()

        binding.btnLista.setOnClickListener {
            val winLista = Intent(this, VistasActivity::class.java)
            startActivity(winLista)
        }

        // Llamo a botón Reclicer
        binding.btnRecicler.setOnClickListener {
            val winRecicler = Intent(this, RecliclerActivity::class.java)
            startActivity(winRecicler)
        }

    }

    companion object
    {
        val titulopantalla = "Desde la pantalla 1"

        //fun saludo()
        //{
            // Toast.makeText(this, "Hola mundo", Toast.LENGTH_SHORT).show()
        //}
    }

    // Función Valida datos
    private fun validaDatos(pNombre : String, pCorreo : String, pEdad : String ): Boolean
    {
        if (pNombre.isEmpty())
        {
            binding.txtLNombre.error = "Debe ingresar el nombre. Valide y reintente."
            binding.txtNombre.requestFocus();
            return false
        }
        else
        {
            binding.txtLNombre.error = null
        }

        if (pCorreo.isEmpty())
        {
            binding.txtLCorreo.error = "Debe ingresar el correo. Valide y reintente."
            binding.txtCorreo.requestFocus();
            return false
        }
        else
        {
            binding.txtLCorreo.error = null
        }

        if (pEdad.isEmpty())
        {
            binding.txtLEdad.error = "Debe ingresar la edad. Valide y reintente."
            binding.txtEdad.requestFocus();
            return false
        }
        else
        {
            binding.txtLEdad.error = null
        }
        return true
    }

    private fun pedirPermisos()
    {
        if (ContextCompat.checkSelfPermission(this, CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            // El permiso no ha sido otorgado, solicítalo al usuario
            ActivityCompat.requestPermissions(this, arrayOf(CAMERA, ACCESS_FINE_LOCATION), MY_PERMISSIONS_REQUEST_CAMERA )
        }
        else
        {
            // El permiso ya ha sido otorgado, puedes realizar las operaciones necesarias

        }
    }

    // se debe sobreescribir esta funcion
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA)
        {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                // Permiso otorgado, puedes realizar las operaciones necesarias
            }
            else
            {
                // Permiso denegado, debes manejar esta situación (por ejemplo, mostrar un mensaje de error)
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Androidly Alert")
                builder.setMessage("No me diste acceso a la camara")

                builder.setPositiveButton(android.R.string.yes) { dialog, which -> pedirPermisos() }
                builder.show()


            }
        }


    }





}
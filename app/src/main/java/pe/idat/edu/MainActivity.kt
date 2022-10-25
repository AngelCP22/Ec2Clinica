package pe.idat.edu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.idat.edu.databinding.ActivityFormBinding
import pe.idat.edu.databinding.ActivityListBinding
import pe.idat.edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Evento click que lleva a la Actividad de Formulario(FormActivity)
        binding.btnFormulario.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    FormActivity::class.java
                )
            )
        }

        //Evento click que lleva a la Actividad de Listado de libros medicos(ListActivity)
        binding.btnListado.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ListActivity::class.java
                )
            )
        }

        //Evento click que lleva a la Actividad de Registro(RegisterActivity)
        binding.btnRegistro.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RegisterActivity::class.java
                )
            )
        }
    }

    override fun onClick(p0: View?) {

    }

}
package pe.idat.edu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_list.*
import pe.idat.edu.dataBooks.LibroAdapter
import pe.idat.edu.dataBooks.Libros

class ListActivity : AppCompatActivity(), View.OnClickListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_list)

        val libros = Libros("Neuroética. Una guía multifacética","una guía multifacética destaca la integración de información mediante el diálogo y la reflexión entre profesionales","Julio 2014",R.drawable.logo)
        val libros2 = Libros("Drake, R.L., Gray. Anatomía para estudiantes","Los docentes destacan su nueva edición su mayor enfoque clínico","Marzo 2012",R.drawable.logo)
        val libros3 = Libros("Netter, F.H., Atlas de anatomía humana, 6ª edición ","Un bestseller de la especialidad. Las tablas de músculos (lugar de inserción, inervación, funciones principales...) ","Abril 2017",R.drawable.logo)
        val libros4 = Libros("Hansen, J.T., Netter. Flashcards de anatomía, 4ª edición","La forma más cómoda y fácil de repasar la anatomía humana en cualquier momento. ","11 de enero del 2000",R.drawable.logo)
        val libros5 = Libros("Haines, D. E., Principios de Neurociencia, 4ª edición","La obra más práctica para adquirir los fundamentos imprescindibles de la neurociencia.","12 de noviembre de 2005",R.drawable.logo)
        val libros6 = Libros("Kumar, V., Robbins y Cotran. Patología estructural y funcional, 9ª edición","Primera elección para el estudio de la Anatomía Patológica. ","25 de Junio de 2000",R.drawable.logo)
        val libros7 = Libros("Hall, J.E., Guyton y Hall. Tratado de fisiología médica, 13ª edición","El principal tratado de fisiología médica del mundo.","Mayo 2022",R.drawable.logo)
        val libros8 = Libros("Baynes, J., Bioquímica médica, 4ª edición","Un referente gracias a su abordaje por órganos y su constante correlación clínica","D.L. 2014 ",R.drawable.logo)
        val libros9 = Libros("Murray, P.R., Microbiología médica, 8ª edición","Toda la información que el estudiante necesita conocer para diagnosticar y tratar a un paciente infectado por un microorganismo","Abril de 2017",R.drawable.logo)
        val libros10 = Libros("Townsend Jr., C.M., Sabiston. Tratado de cirugía, 20ª edición","Desde que fuera publicada por primera vez en 1936 ha sido considerada la obra de referencia por excelencia para el conocimiento de todas las áreas de la cirugía general.","24 Octubre 2017",R.drawable.logo)

        val listaLibros = listOf(libros,libros2,libros3,libros4,libros5,libros6,libros7,libros8,libros9,libros10)

        val adapter = LibroAdapter(this, listaLibros)

        lvBooks.adapter = adapter

    }

    override fun onClick(p0: View?) {

    }
}
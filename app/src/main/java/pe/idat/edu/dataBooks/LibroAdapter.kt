package pe.idat.edu.dataBooks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_libro.view.*
import pe.idat.edu.R

class LibroAdapter(private  val mContext: Context, private val listaLibros: List<Libros>) : ArrayAdapter<Libros>(mContext, 0, listaLibros) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_libro, parent, false)

        val libros = listaLibros[position]

        layout.titulo.text = libros.titulo
        layout.des.text = libros.des
        layout.fecha.text = libros.fecha
        layout.imageView2.setImageResource(libros.img)

        return layout
    }
}
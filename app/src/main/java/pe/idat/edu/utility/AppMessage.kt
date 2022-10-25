package pe.idat.edu.utility

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import pe.idat.edu.R

object AppMessage {
//Funcion de mensaje de validacion
    fun SendMessage(view: View, message: String, type: MessageType){
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        val snackBarView: View = snackbar.view
        if (type == MessageType.ERROR){
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    MyApp.instance, R.color.snackbarerror))
        }else{
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(MyApp.instance, R.color.snackbarsuccess))
        }
        snackbar.show()
    }

}
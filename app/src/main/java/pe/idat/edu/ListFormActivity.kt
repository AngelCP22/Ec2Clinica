package pe.idat.edu

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import pe.idat.edu.databinding.ActivityListFormBinding
import pe.idat.edu.utility.AppMessage
import pe.idat.edu.utility.MessageType

class ListFormActivity : AppCompatActivity() {

   private lateinit var binding : ActivityListFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val formslist = intent.getSerializableExtra("formlist")
                as ArrayList<String>
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, formslist)
        binding.lvForm.adapter = adapter
        AppMessage.SendMessage(binding.root, "Formulario registrado correctamente", MessageType.SUCCESSFULL)
    }
}
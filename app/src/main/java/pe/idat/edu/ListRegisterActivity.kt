package pe.idat.edu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import pe.idat.edu.databinding.ActivityListRegisterBinding
import android.R
import pe.idat.edu.utility.AppMessage
import pe.idat.edu.utility.MessageType

class ListRegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userlists = intent.getSerializableExtra("userlist")
                as ArrayList<String>
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, userlists)
        binding.lvRegister.adapter = adapter
        AppMessage.SendMessage(binding.root, "Medico registrado correctamente", MessageType.SUCCESSFULL)
//        setearControls()
    }
}
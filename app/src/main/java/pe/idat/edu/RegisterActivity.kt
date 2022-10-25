package pe.idat.edu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_register.*
import pe.idat.edu.databinding.ActivityRegisterBinding
import pe.idat.edu.utility.AppMessage
import pe.idat.edu.utility.MessageType

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding

    private val userlist = ArrayList<String>()
    private val hobbylist = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAcceder.setOnClickListener(this)
        binding.cbDeporte.setOnClickListener(this)
        binding.cbPintura.setOnClickListener(this)
        binding.cbOtro.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if (view is CheckBox){
            addRemoveHobby(view)
        }else{
            when(view.id){
                R.id.btnAcceder -> goRegisterList()
//                R.id.btnAcceder -> goUserList()
            }
        }
    }


    private fun goRegisterList() {

        if(registerValidate()){
            var infoUser = " DNI : " + binding.txtDni.text.toString()+
                    "\n Nombre : "+ binding.txtNombre.text.toString()+
                    "\n Apellidos : " + binding.txtApellidos.text.toString()+
                    "\n Email: " +binding.txtEmail.text.toString()+
                    "\n Password : " +binding.txtPassword.text.toString()+
                    "\n Genero : " +getSelectedGender()+
                    "\n Hobby : " +hobbylist.toString()+
                    "\n " +binding.txtHobby.text.toString()
            userlist.add(infoUser)
//            AppMessage.SendMessage(binding.root, "Medico registrado correctamente", MessageType.SUCCESSFULL)
            setearControls()

            val intentList = Intent(
                this, ListRegisterActivity::class.java
            ).apply {
                putExtra("userlist", userlist)
            }
            startActivity(intentList)
        }
    }

    //Funcion para limpiar los componentes e iniciar en el primer componente (DNi)
    private fun setearControls(){

        hobbylist.clear()
        binding.txtDni.setText("")
        binding.txtNombre.setText("")
        binding.txtApellidos.setText("")
        binding.txtEmail.setText("")
        binding.txtPassword.setText("")
        binding.rgGenero.clearCheck()
        binding.cbPintura.isChecked = false
        binding.cbDeporte.isChecked = false
        binding.cbOtro.isChecked = false
        binding.txtDni.isFocusableInTouchMode = true
        binding.txtDni.requestFocus()

    }

    //Funcion de lista de usuario
    private fun goUserList() {

    }

    //Remover o agregar los hobbies a la lista
    private fun addRemoveHobby(checkBox: CheckBox) {

        if (checkBox.isChecked){
            hobbylist.add(checkBox.text.toString())
        }else{
            hobbylist.remove(checkBox.text.toString())
        }

    }

    //Funcion Validacion de hobbies
    fun hobbyValidate(): Boolean{
        var respuesta = false
        if (binding.cbPintura.isChecked || binding.cbDeporte.isChecked || binding.cbOtro.isChecked){
            respuesta = true
        }else if(binding.txtHobby.text.toString().trim().isEmpty()){
            binding.txtHobby.isFocusableInTouchMode = true
            binding.txtHobby.requestFocus()
            respuesta = false
        }
        return respuesta
    }

    //Funcion Validacion de genero
    fun genderValidate() : Boolean{
        var respuesta = true
        if (binding.rgGenero.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    //Funcion Obtener genero seleccionado
    fun getSelectedGender(): String {
        var gender = ""
        when(binding.rgGenero.checkedRadioButtonId){
            R.id.rbHombre -> gender = binding.rbHombre.text.toString()
            R.id.rbFemenino -> gender = binding.rbFemenino.text.toString()
        }
        return gender
    }

    //Funcion para la validacion de datos usuario (DNI, nombres, Apellidos, Email y password)
    fun userDataValidation() : Boolean{
        var respuesta = true
        if (binding.txtDni.text.toString().trim().isEmpty()){
            binding.txtDni.isFocusableInTouchMode = true
            binding.txtDni.requestFocus()
            respuesta = false
            txtDni.error = getString(R.string.errorDNI)
        }else if (binding.txtNombre.text.toString().trim().isEmpty()){
            binding.txtNombre.isFocusableInTouchMode = true
            binding.txtNombre.requestFocus()
            respuesta = false
            txtNombre.error = getString(R.string.errorNombre)
        }else if (binding.txtApellidos.text.toString().trim().isEmpty()){
            binding.txtApellidos.isFocusableInTouchMode = true
            binding.txtApellidos.requestFocus()
            respuesta = false
            txtApellidos.error = getString(R.string.errorApellido)
        }else if (binding.txtEmail.text.toString().trim().isEmpty()){
            binding.txtEmail.isFocusableInTouchMode = true
            binding.txtEmail.requestFocus()
            respuesta = false
            txtEmail.error = getString(R.string.errorEmail)
        }else if (binding.txtPassword.text.toString().trim().isEmpty()){
            binding.txtPassword.isFocusableInTouchMode = true
            binding.txtPassword.requestFocus()
            respuesta = false
            txtPassword.error = getString(R.string.errorPassword)
        }
        return respuesta

    }

    //Validar el Registro
    fun registerValidate(): Boolean{
        var respuesta = false
        if(!userDataValidation()){
            AppMessage.SendMessage(binding.root, "Ingrese sus datos", MessageType.ERROR)
        }else if(!genderValidate()){
            AppMessage.SendMessage(binding.root, "Seleccione su genero", MessageType.ERROR)
        }else if(!hobbyValidate()){
            AppMessage.SendMessage(binding.root, "Ingrese un hobbie", MessageType.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }


}
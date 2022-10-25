package pe.idat.edu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import pe.idat.edu.databinding.ActivityFormBinding
import pe.idat.edu.utility.AppMessage
import pe.idat.edu.utility.MessageType

class FormActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var binding: ActivityFormBinding

    private val formlist = ArrayList<String>()
    private val serviceslist = ArrayList<String>()
    private val symptomlist = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnResolver.setOnClickListener(this)
        binding.cbDiminucion.setOnClickListener(this)
        binding.cbTos.setOnClickListener(this)
        binding.cbGarganta.setOnClickListener(this)
        binding.cbCongestion.setOnClickListener(this)
        binding.cbFiebre.setOnClickListener(this)
        binding.cbNinguno.setOnClickListener(this)
        binding.cbLuz.setOnClickListener(this)
        binding.cbAgua.setOnClickListener(this)
        binding.cbInternet.setOnClickListener(this)
        binding.cbCable.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if (view is CheckBox) {
            addRemoveSymptom(view)
        }
        if (view is CheckBox) {
            addRemoveServices(view)
        }else{
            when (view.id) {
                R.id.btnResolver -> goRegisterFormList()
            }
        }
    }

    private fun goRegisterFormList() {

        if (formValidate()){
            var infoForm = " Sus sintomas son: " +symptomlist.toString()+
                    "\n Fiebre mayor a 37 grados? " +getSelectedCheck1()+
                    "\n Vive solo en casa? " +getSelectedCheck2()+
                    "\n Vive con un alduto mayor en casa? " +getSelectedCheck3()+
                    "\n Sus servicios son: " +serviceslist.toString()+"\n"
            formlist.add(infoForm)
            setearControls()

            val intentList = Intent(
                this, ListFormActivity::class.java
            ).apply {
                putExtra("formlist", formlist)
            }
            startActivity(intentList)

        }

    }

    //Funcion agregar o eliminar sintoma
    private fun addRemoveSymptom(checkBox: CheckBox) {
        if (checkBox.isChecked) {
            symptomlist.add(checkBox.text.toString())
        } else {
            symptomlist.remove(checkBox.text.toString())
        }

    }

    //Funcion validar sintoma
    fun symptomValidate(): Boolean {
        var respuesta = false
        if (binding.cbDiminucion.isChecked || binding.cbTos.isChecked || binding.cbGarganta.isChecked ||
            binding.cbCongestion.isChecked || binding.cbFiebre.isChecked || binding.cbNinguno.isChecked){
            respuesta = true
        }
        return respuesta
    }

    //Funcion validacion de fiebre mayor a 37
    fun check1Validate(): Boolean {
        var respuesta = true
        if (binding.radioGroup1.checkedRadioButtonId == -1) {
            respuesta = false
        }
        return respuesta
    }

    //Funcion Obtener fiebre mayor a 37 seleccionado
    fun getSelectedCheck1(): String {
        var check1 = ""
        when (binding.radioGroup1.checkedRadioButtonId) {
            R.id.rbSi2 -> check1 = binding.rbSi2.text.toString()
            R.id.rbNo2 -> check1 = binding.rbNo2.text.toString()
        }
        return check1
    }

    //Funcion validacion de vives solo en casa
    fun check2Validate(): Boolean {
        var respuesta = true
        if (binding.radioGroup2.checkedRadioButtonId == -1) {
            respuesta = false
        }
        return respuesta
    }

    //Funcion Obtener de vives solo en casa
    fun getSelectedCheck2(): String {
        var check2 = ""
        when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.rbSi3 -> check2 = binding.rbSi3.text.toString()
            R.id.rbNo3 -> check2 = binding.rbNo3.text.toString()
        }
        return check2
    }

    //Funcion validacion adulto mayor en casa
    fun check3Validate(): Boolean {
        var respuesta = true
        if (binding.radioGroup3.checkedRadioButtonId == -1) {
            respuesta = false
        }
        return respuesta
    }

    //Funcion Obtener adulto mayor en casa
    fun getSelectedCheck3(): String {
        var check3 = ""
        when (binding.radioGroup3.checkedRadioButtonId) {
            R.id.rbSi4 -> check3 = binding.rbSi4.text.toString()
            R.id.rbNo4 -> check3 = binding.rbNo4.text.toString()
        }
        return check3
    }

    //Funcion agregar o eliminar servicio
    private fun addRemoveServices(checkBox: CheckBox) {
        if (checkBox.isChecked) {
            serviceslist.add(checkBox.text.toString())
        } else {
            serviceslist.remove(checkBox.text.toString())
        }
    }

    //Funcion  Validacion de servicio
    fun servicesValidate(): Boolean {
        var respuesta = false
        if (binding.cbAgua.isChecked || binding.cbCable.isChecked ||
            binding.cbInternet.isChecked || binding.cbLuz.isChecked) {
            respuesta = true
        }
        return respuesta
    }

    //Funcion limpiar
    private fun setearControls() {

        symptomlist.clear()
        serviceslist.clear()
        binding.cbDiminucion.isChecked = false
        binding.cbTos.isChecked = false
        binding.cbGarganta.isChecked = false
        binding.cbCongestion.isChecked = false
        binding.cbFiebre.isChecked = false
        binding.cbNinguno.isChecked = false
        binding.radioGroup1.clearCheck()
        binding.radioGroup2.clearCheck()
        binding.radioGroup3.clearCheck()
        binding.cbLuz.isChecked = false
        binding.cbAgua.isChecked = false
        binding.cbInternet.isChecked = false
        binding.cbCable.isChecked = false

    }

    //Funcion validacion de Formulario
    fun formValidate(): Boolean {
        var respuesta = false
        if (!symptomValidate()) {
            AppMessage.SendMessage(binding.root, "Marque un sintoma", MessageType.ERROR)
        } else if (!check1Validate()) {
            AppMessage.SendMessage(binding.root, "Selecione una opcion de la pregunta 2", MessageType.ERROR)
        } else if (!check2Validate()) {
            AppMessage.SendMessage(binding.root, "Selecione una opcion de la pregunta 3", MessageType.ERROR)
        } else if (!check3Validate()) {
            AppMessage.SendMessage(binding.root, "Selecione una opcion de la pregunta 4", MessageType.ERROR)
        } else if (!servicesValidate()) {
            AppMessage.SendMessage(binding.root, "Marque un servicio ", MessageType.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }

}
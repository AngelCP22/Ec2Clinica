package pe.idat.edu.utility

import android.app.Application
import android.provider.CalendarContract.Instances

class MyApp : Application (){

    companion object{
        lateinit var instance: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
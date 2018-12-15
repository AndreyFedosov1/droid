package bsu.by.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import java.util.concurrent.TimeUnit

class MessageService: Service() {


    class MessageServiceBinder: Binder(){
        fun getService():MessageService{
            return MessageService()
        }
    }



    override fun onBind(intent: Intent?): IBinder {
        return MessageServiceBinder()
    }

    fun sendMessage(message: String){
        val localIntent=Intent("main_activity_toast")
        localIntent.putExtra("msg","(MessageService) " + message)
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent)
    }

}
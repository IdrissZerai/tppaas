package com.tppaas.tppaasapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.tppaas.tppaasapk.entities.Emergency
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

class MainActivity : AppCompatActivity() {
    private lateinit var webSocketClient: WebSocketClient

    companion object {
        const val WEB_SOCKET_URL = "ws://host.docker.internal:8080/topic/emergency"
        const val TAG = "EMERGENCY"
    }
    override fun onResume() {
        super.onResume()
        initWebSocket()
    }

    private fun initWebSocket() {
        val coinbaseUri: URI? = URI(WEB_SOCKET_URL)
        createWebSocketClient(coinbaseUri)
    }

    private fun createWebSocketClient(coinbaseUri: URI?) {
        webSocketClient = object : WebSocketClient(coinbaseUri) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                Log.d(TAG, "onOpen")
                subscribe()
            }

            override fun onMessage(message: String?) {
                Log.d(TAG, "onMessage: $message")
                setUpSubText(message)
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Log.d(TAG, "onClose")
                unsubscribe()
            }

            override fun onError(ex: Exception?) {
                Log.e(TAG, "onError: ${ex?.message}")
            }

        }
    }

    private fun unsubscribe() {
        webSocketClient.send(
            "{\n" +
                    "    \"type\": \"unsubscribe\",\n" +
                    "    \"channels\": [\"emergency\"]\n" +
                    "}"
        )
    }

    private fun setUpSubText(message: String?) {
        message?.let {
            val moshi = Moshi.Builder().build()
            val adapter: JsonAdapter<Emergency> = moshi.adapter(Emergency::class.java)
            val emergency = adapter.fromJson(message)
            runOnUiThread {coach_emergency.text = "Emergency type: ${emergency?.type} " }
        }

    }

    private fun subscribe() {
        webSocketClient.send(
            "{\n" +
                    "    \"type\": \"subscribe\",\n" +
                    "    \"channels\": [{ \"topic\": \"emergency\"] }]\n" +
                    "}"
        )
    }

    override fun onPause() {
        super.onPause()
        webSocketClient.close()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
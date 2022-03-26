package mx.tecnm.tepic.u2p2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mx.tecnm.tepic.u2p2.databinding.ActivityMainBinding
import java.lang.Exception


class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
        lateinit var cartas : Cartas
        lateinit var mediaPlayer : MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        cartas = Cartas(this)
        setContentView(binding.root)

        var card = cartas.cc
        fun corrutina() =  GlobalScope.launch {
                for(cart in card) {
                    runOnUiThread {
                        binding.faltan.text = cart
                    }
                    delay(3000L)
                }
        }


        binding.iniciar.setOnClickListener{
                cartas = Cartas(this)
                cartas.start()
                binding.iniciar.isClickable=false

        }

        binding.reiniciar.setOnClickListener {
            cartas.reiniciar()
            binding.iniciar.isClickable=true
        }

        binding.acabar.setOnClickListener {
            cartas.acabarLoteria()

        }

        binding.pausa.setOnClickListener {
            cartas.pausar()
        }

        binding.cartasB.setOnClickListener {
            corrutina()
        }




    }


}






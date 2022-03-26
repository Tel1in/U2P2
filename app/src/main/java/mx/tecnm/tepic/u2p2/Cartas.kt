package mx.tecnm.tepic.u2p2

import android.media.MediaPlayer
import android.view.View
import android.widget.ImageView
import kotlin.random.Random

class Cartas(p: MainActivity): Thread(){
    private var iniciar = true
    private var pausar = false
    private var act = p

        var cartaI = mutableListOf<Int>((R.drawable.gallo),R.drawable.diablo,R.drawable.dama,R.drawable.catrin,R.drawable.paraguas,
            R.drawable.sirena,R.drawable.escalera,R.drawable.botella,R.drawable.barril,R.drawable.arbol,R.drawable.melon,
            R.drawable.valiente,R.drawable.gorrito,R.drawable.muerte,R.drawable.pera,R.drawable.bandera,R.drawable.bandolon,
            R.drawable.violoncello,R.drawable.garza,R.drawable.pajaro,R.drawable.mano,R.drawable.bota,R.drawable.luna,
            R.drawable.cotorri,R.drawable.bardo,R.drawable.cesar,R.drawable.corazon,R.drawable.sandia,R.drawable.tambor,R.drawable.camaron,
            R.drawable.jaras,R.drawable.musico,R.drawable.arana,R.drawable.soldado,R.drawable.estrella,R.drawable.cazo,
            R.drawable.mundo,R.drawable.apache,R.drawable.nopla,R.drawable.alacran,R.drawable.rosa,R.drawable.calavera,R.drawable.campana,
            R.drawable.cantarito,R.drawable.venado,R.drawable.sol,R.drawable.corona,R.drawable.chalupa,R.drawable.pino,R.drawable.pescado,
            R.drawable.palma,R.drawable.maceta,R.drawable.arpa,R.drawable.rana)

        var nombres = mutableListOf<String>("GALLO","DIABLO","DAMA","CATRIN","PARAGUAS","SIRENA","ESCALERA","BOTELLA","BARRIL","ARBOL","MELON","VALINTE",
        "GORRITO","MUERTE","PERA","BANDERA","BANDOLON","VIOLONCELLO","GARZAR","PAJARO","MANO","BOTA","LUNA",
        "COTORRO","BORRACHO","NEGRO","CORAZON","SANDIA","TAMBOR","CAMARON","JARAS","MUSICO","ARAÑA","SOLDADO",
        "ESTRELLA","CAZO","MUNDO","APACHE","NOPaL","ALACRAN","ROSA","CALAVERA","CAMPANA","CANTARITO","VENADO",
        "SOL","CORONA","CHALUPA","PINO","PESCADO","PALMA","MACETA","ARPA","RANA")

        var sonido = mutableListOf<Int>(R.raw.gallo,R.raw.diablo,R.raw.dama,R.raw.catrin,R.raw.paraguas,R.raw.sirena,R.raw.escalera,
            R.raw.bottela,R.raw.barril,R.raw.arbol,R.raw.melon,R.raw.valiente,R.raw.gorrito,R.raw.muerte,R.raw.pera,R.raw.bandera,R.raw.bandolon,R.raw.violoncello,R.raw.garza,R.raw.pajaro,
            R.raw.mano,R.raw.bota,R.raw.luna,R.raw.cotorro,R.raw.bardo,R.raw.cesar,R.raw.corazon,R.raw.sandia,R.raw.tambor,R.raw.camaron,R.raw.jaras,
            R.raw.musico,R.raw.arana,R.raw.soldado,R.raw.estrella,R.raw.cazo,R.raw.mundo,R.raw.apache,R.raw.nopla,R.raw.alacran,
            R.raw.rosa,R.raw.calavera,R.raw.campana,R.raw.cantarito,R.raw.venado,R.raw.sol,R.raw.corona,R.raw.chalupa,R.raw.pino,R.raw.pescado,R.raw.palma,R.raw.maceta ,
            R.raw.arpa,R.raw.rana)



        var cartaIcopia = cartaI
        var nombreCopia = nombres
        var sonidoCopia = sonido

        var cc = nombres


    var x = 54
    fun loteria(){
        var random = Random.nextInt(x)
        act.binding.cartaLoteria.setImageResource(cartaI[random])
        act.binding.texto.text = nombres[random]
        act.mediaPlayer = MediaPlayer.create(act,sonido[random])
        act.mediaPlayer.start()
        act.binding.indice.text = x.toString()
        cartaI.removeAt(random)
        nombres.removeAt(random)
        sonido.removeAt(random)
        x--
        sleep(1000)
    }

    fun sinCartas(){
        act.binding.texto.setTextSize(10F)
        act.binding.texto.text="SE ACABARON LAS CARTAS"

    }

    fun reiniciar(){
        cartaI=cartaIcopia
        nombres=nombreCopia
        sonido=sonidoCopia
    }

    fun acabarLoteria(){
        iniciar=false
        act.binding.texto.setTextSize(30F)
        act.binding.texto.textAlignment=View.TEXT_ALIGNMENT_CENTER
        act.binding.texto.text="LOTERIA"
        act.mediaPlayer.stop()
        act.binding.cartaLoteria.setImageResource(R.drawable.loteria)
        cc = nombres
    }

    fun pausar(){
        pausar = pausar ==false

    }


    override fun run() {
        super.run()
        while (iniciar){
            if(!pausar){
                if(cartaI.size>0) {
                    act.runOnUiThread{
                        loteria()
                    }
                }
                if(cartaI.size==0){
                    act.runOnUiThread{
                        sinCartas()
                    }
                }
                sleep(2000)
            }


        }
    }

}



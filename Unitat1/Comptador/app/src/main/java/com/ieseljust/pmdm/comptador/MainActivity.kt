package com.ieseljust.pmdm.comptador


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.ieseljust.pmdm.comptador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var comptador=0

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // Referencia al TextView
        // val textViewContador=findViewById<TextView>(R.id.textViewComptador)

        // Inicialitzem el TextView amb el comptador a 0
        //textViewContador.setText(comptador.toString())

        binding.textViewComptador.setText(comptador.toString())

        // Referencia al botón
        val btAdd=binding.btAdd
        val btResta=binding.btResta
        val btReset=binding.btReset


        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        binding.btAdd.setOnClickListener {
            comptador++
            binding.textViewComptador.text = comptador.toString()
        }
        // Boton para restar
        binding.btResta.setOnClickListener {
            comptador--
            binding.textViewComptador.text = comptador.toString()
        }
        // Boton para resetear
        binding.btReset.setOnClickListener {
            comptador = 0
            binding.textViewComptador.text = comptador.toString()
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Code to save the state
        Log.d("DEPURACION", "Estoy en onSave")
        outState.putInt("Comptador", comptador)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Code to restore the state
        Log.d("DEPURACION", "Estoy en onRestore")
        comptador = savedInstanceState.getInt("Comptador")
        binding.textViewComptador.text = comptador.toString()
    }
    override fun onStart() {
        super.onStart()
        Log.d("DEPURACION", "Al metodo onStart")
    }
}
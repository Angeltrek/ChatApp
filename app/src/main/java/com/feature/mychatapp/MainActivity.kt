package com.feature.mychatapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.feature.mychatapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set content view only once\

        if (firebaseAuth.currentUser == null) {
            // User is already authenticated, navigate to the next screen
            startActivity(Intent(this, AuthActivity::class.java))
            finish() // Opcional: Termina la actividad actual para que el usuario no pueda volver a ella con el botón "Atrás"
        }
    }
}
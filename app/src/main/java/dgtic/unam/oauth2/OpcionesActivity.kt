package dgtic.unam.oauth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import dgtic.unam.oauth2.databinding.ActivityOpcionesBinding

enum class TipoProvedor {
    CORREO,
    GOOGLE,
    FACEBOOK
}
class OpcionesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOpcionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpcionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //datos que manda la actividad
        var bundle: Bundle? = intent.extras
        var email: String? = bundle?.getString("email")
        var provedor: String? = bundle?.getString("provedor")
        inicio(email ?: "", provedor ?: "")
    }
    private fun inicio(email: String, provedor: String) {
        binding.mail.text = email
        binding.provedor.text = provedor
        binding.closeSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
package br.com.claudio.appaulavi.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.claudio.appaulavi.data.login.LoginRepository
import br.com.claudio.appaulavi.databinding.ActivityLoginBinding
import br.com.claudio.appaulavi.network.LoginService
import br.com.claudio.appaulavi.network.RetrofitClient

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this, LoginRepository(RetrofitClient.createService(LoginService::class.java)))

        binding.btLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            presenter.login(username, password)
        }
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun showLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
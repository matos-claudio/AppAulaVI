package br.com.claudio.appaulavi.ui.login

import br.com.claudio.appaulavi.data.login.Data
import br.com.claudio.appaulavi.data.login.LoginRepository

class LoginPresenter (
    private val view: LoginContract.View,
    private val repository: LoginRepository
): LoginContract.Presenter {
    override fun login(username: String, password: String) {
        view.showLoading()
        repository.login(username, password, object : LoginRepository.LoginCallback {
            override fun onSuccess(data: Data, success: Boolean, message: String) {
                view.hideLoading()
                view.showLoginSuccess(message)
            }

            override fun onError(success: Boolean, message: String) {
                view.hideLoading()
                view.showLoginError(message)
            }
        })
    }
}
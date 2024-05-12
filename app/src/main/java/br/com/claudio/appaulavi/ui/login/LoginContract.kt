package br.com.claudio.appaulavi.ui.login

interface LoginContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showLoginSuccess(message: String)
        fun showLoginError(message: String)
    }
    interface Presenter {
        fun login(username: String, password: String)
    }
}
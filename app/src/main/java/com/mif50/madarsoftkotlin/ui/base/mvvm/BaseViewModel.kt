package com.mif50.madarsoftkotlin.ui.base.mvvm

import androidx.lifecycle.ViewModel
import com.androidnetworking.common.ANConstants
import com.androidnetworking.error.ANError
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.mif50.madarsoftkotlin.R
import com.mif50.madarsoftkotlin.app.helper.rx.SchedulerProvider
import com.mif50.madarsoftkotlin.data.DataManager
import com.mif50.madarsoftkotlin.data.remote.api.model.Model
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import javax.net.ssl.HttpsURLConnection

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
open class BaseViewModel<N : MvvmNavigator>(
    var dataManager: DataManager,
    var schedulerProvider: SchedulerProvider,
    var compositeDisposable: CompositeDisposable
) : ViewModel(), MvvmModel<N> {

    private lateinit var navigator: N

    override fun attachNavigator(navigator: N) {
        this.navigator = navigator
    }

    override fun getNavigator(): N {
        return navigator
    }

    override fun handleError(error: Throwable) {
        when (error) {
            is ANError -> {

                if (error.errorBody == null) {
                    getNavigator().showError(R.string.text_no_network_found_)
                    return
                }

                if (error.errorCode == 0 && error.errorDetail == ANConstants.CONNECTION_ERROR) {
                    getNavigator().showError(R.string.api_connection_error)
                    return
                }

                if (error.errorCode == 0 && error.errorDetail == ANConstants.REQUEST_CANCELLED_ERROR) {
                    getNavigator().showError(R.string.text_no_network_found_)
                    return
                }

                val gson = Gson()

                try {
                    val apiError = gson.fromJson(error.errorBody, Model::class.java)

                    if (apiError == null) {
                        getNavigator().showError(R.string.text_no_network_found_)
                        return
                    }
//                    if (apiError.response != HttpsURLConnection.HTTP_OK) {
//                        getNavigator().showError(apiError.message!!)
//                        return
//                    }
//                    if (apiError.response == HttpsURLConnection.HTTP_OK) {
//                        getNavigator().showMessage(apiError.message!!)
//                        return
//                    }
//                    if (apiError.response == HttpsURLConnection.HTTP_NO_CONTENT) {
//                        getNavigator().showError(apiError.message!!)
//                        return
//                    }
//                    if (apiError.response == HttpsURLConnection.HTTP_CONFLICT) {
//                        getNavigator().showError(apiError.message!!)
//                        return
//                    }
//                    if (apiError.response == HttpsURLConnection.HTTP_GONE) {
//                        getNavigator().showError(apiError.message!!)
//                        return
//                    }
//                    if (apiError.response == HttpsURLConnection.HTTP_NOT_FOUND) {
//                        getNavigator().showError(apiError.message!!)
//                        return
//                    }

                    when (error.errorCode) {
                        HttpsURLConnection.HTTP_UNAUTHORIZED, HttpsURLConnection.HTTP_FORBIDDEN -> {

                        }
                        HttpsURLConnection.HTTP_INTERNAL_ERROR, HttpsURLConnection.HTTP_NOT_FOUND -> getNavigator().showMessage(
                            apiError.message!!
                        )
                        else -> getNavigator().showMessage(apiError.message!!)
                    }
                } catch (e: JsonSyntaxException) {
                    Logger.d(e)
                    getNavigator().showError(R.string.error_internal_server_error)
                } catch (e: NullPointerException) {
                    Logger.d(e)
                    getNavigator().showError(0)
                }
            }
        }
    }

    public override fun onCleared() {
        super.onCleared()
//        compositeDisposable.clear()
        Logger.w("view model is Cleared")
    }

    open fun onDetach() {

    }

    override fun checkStatus(model: Model): Boolean {
//        return if (!model.isSuccess()) {
//            model.message?.let { getNavigator().showError(it) }
//            true
//        } else {
          return  false
//        }
    }

}
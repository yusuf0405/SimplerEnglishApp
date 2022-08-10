package com.joseph.core_mvvm.presentation

import androidx.annotation.StringRes
import com.joseph.core_mvvm.R
import com.joseph.core_mvvm.core.ManageResource
import com.joseph.core_mvvm.data.HandleError
import com.joseph.core_mvvm.domain.NoInternetConnectionException
import com.joseph.core_mvvm.domain.ServiceUnavailableException

abstract class HandleUiErrorAbstract(
    private val manageResources: ManageResource,
    private val globalErrorCommunication: GlobalErrorCommunication.Update,
    private val handleError: HandleError = HandleGenericUiError(manageResources, globalErrorCommunication)
) : HandleError {

    @StringRes
    protected open val noConnectionExceptionMessage: Int = R.string.network_error

    @StringRes
    protected open val serviceUnavailableExceptionMessage: Int = R.string.service_unavailable

    override fun handle(error: Exception): Exception {
        val messageId = when (error) {
            is NoInternetConnectionException -> noConnectionExceptionMessage
            is ServiceUnavailableException -> serviceUnavailableExceptionMessage
            else -> 0
        }
        return if (messageId == 0)
            handleError.handle(error)
        else {
            globalErrorCommunication.map(manageResources.string(messageId))
            error
        }
    }
}

class HandleGenericUiError(
    private val manageResources: ManageResource,
    private val globalErrorCommunication: GlobalErrorCommunication.Update
) : HandleError {

    override fun handle(error: Exception): Exception {
        globalErrorCommunication.map(manageResources.string(R.string.generic_error))
        return error
    }
}

class HandleUiError(
    manageResources: ManageResource,
    globalErrorCommunication: GlobalErrorCommunication.Update
) : HandleUiErrorAbstract(manageResources, globalErrorCommunication)
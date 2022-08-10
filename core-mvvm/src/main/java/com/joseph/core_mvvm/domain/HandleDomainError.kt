package com.joseph.core_mvvm.domain

import com.joseph.core_mvvm.data.HandleError
import java.net.UnknownHostException

class HandleDomainError : HandleError {

    override fun handle(error: Exception): Exception =
        if (error is UnknownHostException)
            NoInternetConnection()
        else
            ServiceUnavailableExemption()
}
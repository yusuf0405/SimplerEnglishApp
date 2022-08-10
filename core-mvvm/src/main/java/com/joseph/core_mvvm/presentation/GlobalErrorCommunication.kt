package com.joseph.core_mvvm.presentation

interface GlobalErrorCommunication {

    interface Observe : Communication.Observe<String>

    interface Update : Communication.Update<String>

    interface Mutable : Communication.Mutable<String>, Observe, Update

    class Base : Communication.SinglePostUpdate<String>(), Mutable
}
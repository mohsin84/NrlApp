package mohsin.reza.nrlapp.Util

/*
* CallBack interface for retrying network call in case of network outage
* */
interface RetryCallback {
    fun retry()
}

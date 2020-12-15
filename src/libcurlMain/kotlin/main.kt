import kotlinx.cinterop.*
import libcurl.*
import platform.posix.exit

import sample.libcurl.CUrl

fun main() {
    println("Hello, Kotlin/Native!")

    NativeLib.Test()
    testCurl()
    println("...")
    testCUrlKt()

    println("Bye, Kotlin/Native!")
    //exit(0)
}

private fun testCUrlKt(){

    println("testCUrlKt++")

    val c = CUrl("https://www.viveport.com/api/optionsl18n/v1/storeServiceConfig/en-us")

    println("{{{")
    c.fetch()
    println("}}}")

    println("testCUrlKt--${c.body}")
    c.close()

}

fun testCurl() {

    println("testCurl++")

    val curl = curl_easy_init()
    if (curl != null) {
        curl_easy_setopt(curl, CURLOPT_URL, "https://www.viveport.com/api/optionsl18n/v1/storeServiceConfig/en-us")
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L)
        val res = curl_easy_perform(curl)
        if (res != CURLE_OK) {
            println("curl_easy_perform() failed ${curl_easy_strerror(res)?.toKString()}")
        }
        curl_easy_cleanup(curl)
    }

    println("testCurl++")
}
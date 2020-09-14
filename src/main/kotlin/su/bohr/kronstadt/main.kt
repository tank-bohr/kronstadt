package su.bohr.kronstadt

import spark.kotlin.Http
import spark.kotlin.ignite

fun main() {
    val http: Http = ignite()

    http.get("/hello") {
        "Hello world!"
    }
}

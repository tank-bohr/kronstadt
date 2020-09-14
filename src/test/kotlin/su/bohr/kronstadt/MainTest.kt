package su.bohr.kronstadt

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.spekframework.spek2.style.specification.xdescribe
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

object MainTest: Spek({
    xdescribe("function main") {
        val output by memoized { ByteArrayOutputStream() }

        beforeEachTest {
            System.setOut(PrintStream(output))
        }

        it("prints hello world") {
            main()
            assertEquals("Hello world!\n", output.toString())
        }

        afterEachTest {
            System.setOut(null)
        }
    }
})

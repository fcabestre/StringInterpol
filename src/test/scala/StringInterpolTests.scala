import org.specs2.mutable._

/**
 *
 * @author Frédéric Cabestre
 */
object StringInterpolTests extends Specification {

  "The simple string interpolation feature" should {
    "Allow to interpolate a string" in {
      val i = "S"
      s"AAA${i}BBB" must beEqualTo("AAASBBB")
    }
    "Allow to interpolate a character" in {
      val i = 'S'
      s"AAA${i}BBB" must beEqualTo("AAASBBB")
    }
    "Allow to interpolate an integer" in {
      val i = 5
      s"AAA${i}BBB" === ("AAA5BBB")
    }
    "Allow to interpolate a float" in {
      val i = 5.0
      s"AAA${i}BBB" === ("AAA5.0BBB")
    }
    "Allow to interpolate an expression returning a string" in {
      val u = "C"
      val j = "CCCSCCC"
      s"AAA${j.replace(u, "")}BBB" === ("AAASBBB")
    }
    "Allow to interpolate an expression returning a float" in {
      import scala.math.{ Pi, cos }
      s"AAA${cos(Pi)}BBB" === ("AAA-1.0BBB")
    }
  }

  "The formatted string interpolation feature" should {
    "Allow to interpolate a formatted float" in {
      val i = 5.0
      f"AAA$i%#2.2fBBB" === ("AAA5,00BBB")
    }
    "Allow to interpolate a formatted string" in {
      val i = "C"
      f"AAA[$i%-3s]BBB" === ("AAA[C  ]BBB")
    }
  }

  "The raw string interpolation feature" should {
    "Allow to interpolate a formatted string with no escaping" in {
      val i = 5.0
      raw"AAA\nC\bBBB" === ("AAA\\nC\\bBBB")
    }
  }

  "A custom string interpolation feature" should {
    "Allow to interpolate a formatted string... in a customized way!" in {
      import StringInterpol._
      val i = "C"
      custom"AAA${i}BBB" === ("AAACBBB")
    }
  }

}

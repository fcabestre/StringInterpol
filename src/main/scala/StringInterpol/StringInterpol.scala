/**
 * @author Frédéric Cabestre
 */
package object StringInterpol {
  implicit class CustomHelper(val sc: StringContext) extends AnyVal {
    def custom(args: Any*): String = {
      val strings = sc.parts.iterator
      val expressions = args.iterator
      val buf = new StringBuffer(strings.next)
      while (strings.hasNext) {
        buf append expressions.next
        buf append strings.next
      }
      buf.toString
    }
  }
}

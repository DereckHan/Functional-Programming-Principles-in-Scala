// In IntelliJ, no need to define object in worksheet
val x = new Rational(1, 3)
val y = new Rational(5, 7)

x + y

-x

x - y

//x.less(y) = x less y just like 1 + 1

x < y

x.<(y)

x.max(y)

val m = new Rational(1)


class Rational(x: Int, y: Int) {

  // Add requirement
  require(y != 0, "Denominator must be nonzero")

  //Add another constructor
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x

  def denom = y

  //< is a legal identifier
  def <(that: Rational) = numer * that.denom < that.numer * denom

  //  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def +(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  //  def neg = new Rational(-numer, denom)
  def unary_- = new Rational(-numer, denom)

  def -(that: Rational) = this + -that

  override def toString = numer + "/" + denom

}
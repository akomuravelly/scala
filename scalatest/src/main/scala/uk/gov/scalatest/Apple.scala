package uk.gov.scalatest

/* Companion object for the apply method.*/
object Apple{
  val price:Double = 60.0
  def apply() = {
    new Apple(price)
  }
}
/*
 * Light weight Apple class
 */
class Apple(price:Double) extends Item(name="Apple",price=price)

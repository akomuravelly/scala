package uk.gov.scalatest

/* Companion object for the apply method.*/
object Apple{
  def apply() = {
    new Apple
  }
}
/*
 * Light weight Apple class
 */
class Apple(price:Double=60.0) extends Item(name="Apple",price=price)

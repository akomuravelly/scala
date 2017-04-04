package uk.gov.scalatest


object Apple{
  def apply() = {
    new Apple
  }
}
/*
 * Light weight Apple class
 */
class Apple(price:Double=60.0) extends Item(name="Apple",price=price)

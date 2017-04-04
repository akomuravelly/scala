package uk.gov.scalatest

/* Companion object for the apply method.*/
object Orange{
  val price:Double = 25.0
  def apply() = {
    new Orange(price)
  }
}
/*
 * Light weight Orange Class
 */
class Orange(price:Double) extends Item(name="Orange",price=price)

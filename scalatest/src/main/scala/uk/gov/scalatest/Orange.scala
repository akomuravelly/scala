package uk.gov.scalatest

/* Companion object for the apply method.*/
object Orange{
  def apply() = {
    new Orange
  }
}
/*
 * Light weight Orange Class
 */
class Orange(price:Double=25.0) extends Item(name="Orange",price=price)

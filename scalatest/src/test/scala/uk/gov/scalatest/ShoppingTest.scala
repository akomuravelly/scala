package uk.gov.scalatest

import uk.gov.scalatest.{Orange,Apple,Item}
import org.scalatest.{ Matchers, GivenWhenThen, FeatureSpec }

class ShoppingTest extends FeatureSpec with GivenWhenThen with Matchers {
  feature("Shopping Bucket") {
    scenario("Constructing a Empty Shopping Bucket") {
      val sp = new ShoppingBucket(List())
      sp.checkOut() should be(0.0)
    }
    
    scenario("Constructing a non Empty Shopping Bucket") {
      val sp = new ShoppingBucket(List(new Apple, new Orange))
      sp.checkOut() should be(85.0)
      
    }
    
    scenario("Adding Items to the list after consturctor") {
      val sp = new ShoppingBucket(List(new Apple, new Orange))
      sp.addItem(List(new Apple,new Apple))
      sp.checkOut() should be(205.0)  
    }
    
  }
}
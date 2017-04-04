package uk.gov.scalatest

import uk.gov.scalatest.{Orange,Apple,Item}
import org.scalatest.{ Matchers, GivenWhenThen, FeatureSpec }

class ShoppingTest extends FeatureSpec with GivenWhenThen with Matchers {
  feature("Shopping Bucket with out offers") {
    scenario("Constructing a Empty Shopping Bucket") {
      val sp = new ShoppingBucket(List())
      sp.checkOut() should be(0.0)
    }
    
    scenario("Constructing a non Empty Shopping Bucket") {
      val sp = new ShoppingBucket(List(Apple(), Orange()))
      sp.checkOut() should be(85.0)
      
    }
    
    scenario("Adding Items to the list after consturctor") {
      val sp = new ShoppingBucket(List(Apple(), Orange()))
      sp.addItem(List(Apple(),Apple()))
      sp.checkOut() should be(205.0)  
    }
    
  }
  
  feature("Shopping Bucket with offers") {
    scenario("Constructing a Empty Shopping Bucket") {
      val sp = new ShoppingBucket(List())
      sp.checkOutwithOffer() should be(0.0)
    }
    
    scenario("Non Empty Shopping Bucket with single eligible offer per item") {
     // Three Apples in the basket and 3 Oranges=> Total amount with out offer  minus price for one apple and price for one orange
      //=>180+75 - (60+25)
      val sp = new ShoppingBucket(List(Apple(),Apple(),Apple(), Orange(), Orange(), Orange()))
      sp.checkOutwithOffer() should be(170)
      
    }
    
    scenario("Non Empty Shopping basket with multiple offers for apple and multiple offers for Oranges") {
      // 5 Apples and 7 oranges=> Total amount with out offer -price of 2 apples and 2 oranges 
      //=> 300+175-(120+50) = 305
      val sp = new ShoppingBucket(List(Apple(), Apple(),Apple(),Apple(),Apple(), Orange(),Orange(), Orange(),
          Orange(),Orange(), Orange(),Orange()))
      sp.checkOutwithOffer() should be(305.0)  
    }
    
    scenario("Non Empty Shopping basket with multiple offers for apple No Oranges in the basket and vice versa") {
      // six apples with 0 oranges=> 360-3*60=180
      val sp = new ShoppingBucket(List(Apple(), Apple(),Apple(), Apple(),Apple(), Apple()))
      sp.checkOutwithOffer() should be(180.00)  
    }
    
  }
}
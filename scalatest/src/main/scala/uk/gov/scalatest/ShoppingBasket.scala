package uk.gov.scalatest

/*
 * Light weight Shopping Basket to add items and also check out the items
 */
class ShoppingBucket(var itemList: List[Item]){
  
  /**
   * checkOut method is used to calculate the amount. This is a plance calculation of amount with out involving any discounts or offers
   * @author jay
   * @params Returns a double
   */
    def checkOut():Double ={
      val amt = itemList.foldLeft(0.0)((acc,elem)=>acc+elem.price)
      amt
    }
    
    
   /**
    * Items can be added as part of the constructor or after the instance is created.
    * @author jay
    * @param list of Items that need to be added. Supposed to add to the shopping basket list of items.
    */
   def addItem(it:List[Item]):Unit={
     itemList=itemList++it
   }
    
    
}
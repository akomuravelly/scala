package uk.gov.scalatest

/*
 * Light weight Shopping Basket to add items and also check out the items
 */
class ShoppingBucket(var itemList: List[Item]){
  
  /**
   * checkOut method is used to calculate the amount. This is a plance calculation of amount with out involving any discounts or offers
   * @author jay
   * @params Returns a double that is the amount to be billed
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
    
   /**
    * checkOutwithOffer applies discount after the actual amount is calculated.
    * @author jay
    * @params Returns a double that is the amount to be billed
    * 
    */
    def checkOutwithOffer():Double={
      val amt = checkOut()
      var appleCount:Int=0
      var orangeCount:Int=0
      var discount:Double=0.0
      /* First get the count of both apples and Oranges in the shopping cart)*/
      for(item<-itemList){
        item match{
          case item: Apple=> appleCount+=1
          case item: Orange=> orangeCount+=1
          case others=> 0
        }
        
      // calculate the discount based on the counts
       discount=(appleCount/2)*Apple.price+(orangeCount/3)*Orange.price
         
      }
      
      //Actual amount minus the discount is returned as the billable amount
      amt-discount
       
      
    }
    
    
}
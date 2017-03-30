package CSIS202JunitTests.Program8.Lydia;// ltaw16@georgefox.edu
// use static somewhere

public class InventoryLineItem 
{

   private static int totalILI;
   private Product _product;
   private int _lineItemQty;
   private double _lineItemDiscountRate;
   private double _lineItemSubtotal;
   private int _lineItemNum;
   
   public InventoryLineItem(Product product, int lineItemQty)
   {
      _product = product;
      _lineItemQty = lineItemQty;
      _lineItemNum = ++totalILI;
      setLineItemDiscountRate();
      setLineItemSubtotal();
   }
   public void setLineItemDiscountRate()
   {
      if (_lineItemQty <= 9)
      {
         _lineItemDiscountRate = 0.0;
      }
      else if (_lineItemQty <= 24)
      {
         _lineItemDiscountRate = .1;
      }
      else if (_lineItemQty <= 49)
      {
         _lineItemDiscountRate = .2;
      }
      else
      {
         _lineItemDiscountRate = .25;
      }
   }
   public void setLineItemSubtotal()
   {
      _lineItemSubtotal = _product.getProductPrice() *
              (1 - _lineItemDiscountRate) * _lineItemQty;
   }
   public int getLineItemNum()
   {
      return _lineItemNum;
   }
   public Product getProduct()
   {
      return _product;
   }
   public int getLineItemQty()
   {
      return _lineItemQty;
   }
   public double getLineItemDiscountRate()
   {
      return _lineItemDiscountRate;
   }
   public double getLineItemSubtotal()
   {
      return _lineItemSubtotal;
   }
   public String toString()
   {
      return "NDY";
   }
   

}

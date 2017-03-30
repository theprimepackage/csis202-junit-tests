package CSIS202JunitTests.Program8.Lydia;// ltaw16@georgefox.edu

/**
 * public class Product contains the product id, description, and price. 
 * @author Lydia
 *
 */

public class Product
{
   private String _productID;
   private String _productDesc;
   private double _productPrice;
   
   
   /**
    * Constructor initializes the product ID, description, and price. 
    * @param id String
    * @param desc String
    * @param price double 
    */
   public Product(String id, String desc, double price)
   {
      _productID = id;
      _productDesc = desc;
      _productPrice = price;
   }
   public String getProductID()
   {
      return _productID;
   }
   public String getProductDesc()
   {
      return _productDesc;
   }
   public double getProductPrice()
   {
      return _productPrice;
   }
   
   @Override
   public String toString()
   {
      return "Product [_productID=" + _productID + ", _productDesc="
            + _productDesc + ", _productPrice=" + _productPrice + "]";
   }

}

package CSIS202JunitTests.Program8.Lydia;

// ltaw16@georgefox.edu
public class CD extends Product
{
   private String _cdTitle;
   
   public CD(String id, String desc, double price, String title)
   {
      super(id, desc, price);
      _cdTitle = title;
   }
   
   public String getCDTitle()
   {
      return _cdTitle;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + "CD [_cdTitle=" + _cdTitle + "]";
   }

}

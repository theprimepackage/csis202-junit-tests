package CSIS202JunitTests.Program8.Lydia;

// ltaw16@georgefox.edu
public class FlashDrive extends Product
{
   private int _flashDriveCapacity;
   public FlashDrive(String id, String desc, double price, int capacity)
   {
      super(id, desc, price);
      _flashDriveCapacity = capacity;     
   }
   public int getFlashDriveCapacity()
   {
      return _flashDriveCapacity;
   }
   
   @Override
   public String toString()
   {
      return "FlashDrive [_flashDriveCapacity=" + _flashDriveCapacity + "]";
   }

}

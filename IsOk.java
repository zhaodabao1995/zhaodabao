package light;

public class IsOk
{
 public static boolean isNumber(String str)
 {
  int i;
  try
  {
   i = Integer.parseInt(str);
   return true;
  } catch (NumberFormatException e)
  {
   return false;
  }
 }
}
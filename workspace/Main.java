//This file contains an example of how to read user input. Use this in conjunction with your linked list class to test your program.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args)
        throws IOException
    {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

          //hard code test for reverse
      LinkedList list1 = new LinkedList();
      list1.addAValue("Alpha");
      list1.addAValue("Beta");
      list1.addAValue("Charlie");
      list1.addAValue("Delta");
      System.out.println(list1.showValues());
      list1.reverse();
      System.out.println(list1.showValues());

        // Reading data using readLine
        LinkedList list = new LinkedList();
        String input= reader.readLine();
        while(!input.equals("exit"))
        {
          if(input.length()>3 && input.substring(0, 3).equals("add"))
          {
            System.out.println(list.addAValue(input.substring(4)).getValue());
          }
          else if(input.equals("show"))
          {
            System.out.println(list.showValues());
          }
          else if(input.length() > 7 && input.substring(0, 6).equals("remove")){
              System.out.println("removing "+input.substring(7));
              System.out.println(list.deleteAValue(input.substring(7)).getValue());
          }
          else if(input.equals("clear"))
          {
            list.clear();
          }
          else if(!input.equals("exit")){
              System.out.println("I don't know how to "+input);
          }
          input= reader.readLine();
        }
 
        // Printing the read line
        System.out.println("thanks for playing!");
    }
}

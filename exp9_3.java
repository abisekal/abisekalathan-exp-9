package Exercise9;
import java.io.*;
public class exp9_3
{
    public static void main(String[] args)throws Exception
    {
        FileInputStream FI;
        FileWriter FW;
        FileReader FR;
        try (DataInputStream dis = new DataInputStream(System.in)) 
        {
            FI = new FileInputStream("sample1.txt");
            FW = new FileWriter("Char.txt");
            FR = new FileReader("sample.txt");
            String str;
            int read;
            System.out.println("It is FileWriter class");
            System.out.println("Enter your information to write in files");
            str=dis.readLine();
            FW.write(str);
            FW.flush();
            System.out.println("\n\n-----------------------------------------\n\n");
            System.out.println("It is FileInputStream class");
            while((read=FI.read())!=-1)
            {
                System.out.print((char)read);
            }   
            System.out.println("\n\n------------------------------------------------\n\n");
            System.out.println("It is chararrayreader class");
            String s="welcome to files concept";
            char c[]=s.toCharArray();
            char c1[]={'s','t','u','d','e','n','t','s'};
            CharArrayReader ca=new CharArrayReader(c);
            while((read=ca.read())!=-1)
            {
                System.out.print((char)read);
            }   System.out.println("\n\n\n-------------------------------------------\n\n\n");
            System.out.println("It is filereader class");
            while((read=FR.read())!=-1)
            {
                System.out.println((char)read);
            }
        }
        FI.close();
        FW.close();
        FR.close();
        
    }
    
}
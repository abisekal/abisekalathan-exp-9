package Exercise9;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class exp9_1 
{
    public static void main(String[] args)throws FileNotFoundException, IOException
    {
        // TODO code application logic here
        String name,dept,position;
        int code,choice,len;
        Scanner o=new Scanner(System.in);
        faculty fa[]=new faculty[10];
        
        while(true)
        {
            System.out.println("1.To Create File \t 2.To Find Content File \t 3.Exit");
            System.out.print("Enter your choice: ");
            choice=o.nextInt();
         
        if(choice==1)
        {
        System.out.print("Enter Number of Faculty:");
        len=o.nextInt();
        for(int k=0;k<len;k++)
        {
            System.out.print("Enter the file new code:");
            code=o.nextInt();
            System.out.print("Enter the file new name:");
            name=o.next();
            System.out.print("Enter the file new Department:");
            dept=o.next();
            System.out.print("Enter the file new position:");
            position=o.next();
            File f=new File(code+".txt");
            if (!f.exists()) 
            {
                System.out.println("File created: " + f.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
            FileOutputStream f1=new FileOutputStream(code+".txt");
            ObjectOutputStream f2=new ObjectOutputStream(f1);
            fa[k]=new faculty(code,name,dept,position);
            f2.writeObject(fa[k]);
            f2.close();
            f1.close();
            System.out.println(fa[k]);
        }
        }
        else if(choice==2)
        {
            System.out.println("Enter the file code:");
            code=o.nextInt();
            name="";dept="";position="";
            new faculty(code,name,dept,position).search(code);
        }
        else
        {
            break;
        }
       }
        System.out.println("Successfully Done!!!!!!");       
    }
    
}
class faculty implements Serializable
{
    String name,dept,position;
    int code;
    faculty(int d,String a,String b,String c)
    {
        code=d;
        name=a;
        dept=b;
        position=c;
    }
    public void search(int code) throws FileNotFoundException, IOException 
    {
        int i;
        faculty q;
        try (FileInputStream f5 = new FileInputStream(code+".txt")) {
            ObjectInputStream f3;
            f3 = new ObjectInputStream(f5);
            try 
            {
                q=(faculty)f3.readObject();
                System.out.println(q.name);
                System.out.println(q.dept);
                System.out.println(q.position);
            } catch (ClassNotFoundException ex) {
               System.out.println("Class Not Found");
            }
            finally
            {
                f3.close();
            }
        }
    }
    @Override
    public String toString()
    {
        return "\nName: "+name+"\nDepartment: "+dept+"\nPosition: "+position+"\n";
    }
}
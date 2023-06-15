import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 131225 on 9/24/2018.
 */
public class ListTester
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner list = new Scanner(new File("actors.txt"));
        LinkedList actlist = new LinkedList();

        while (list.hasNextLine())
        {
            actlist.add(new Actor(list.nextLine()));
        }

        for(int x = 0;x<actlist.size();x++)
        {
            System.out.println(actlist.get(x));
        }
        System.out.println(actlist.get(0));
        System.out.println(((Actor)(actlist.get(0))).getName());


        Scanner movielist = new Scanner(new File("movies.txt"));
        LinkedList movies = new LinkedList();

        while (movielist.hasNextLine())
        {
            int date;
            String name;
            LinkedList actors =new LinkedList();
            LinkedList directors =new LinkedList();


            date=movielist.nextInt();

            movielist.useDelimiter("  ");
            name=movielist.next();
            movielist.reset();

            String []splitted;
            String temp;

            temp = movielist.nextLine();
            splitted = temp.split("Dir: ");

            String[] tempactr =(splitted[0]).split(",");

            for(String x:tempactr)
                actors.add(new Actor(x.trim()));

            String[] tempdtr =(splitted[0]).split(",");

            for(String x:tempdtr)
                directors.add(new Actor(x.trim()));


            movies.add(new Movie(date,name,actors,directors));

        }


        for(int x = 0;x<movies.size();x++)
        {
            System.out.println((movies.get(x)).toString());
        }
        System.out.println(movies.get(0).toString());
        System.out.println(((Movie)(movies.get(0))).getTitle());







    }
}

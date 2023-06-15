/**
 * Created by 131225 on 9/26/2018.
 */
public class Movie
{
    int date;
    String title;
    LinkedList actors;
    LinkedList directors;

    Movie()
    {

    }
    Movie(int date, String title, LinkedList actors, LinkedList directors)
    {
        this.date = date;
        this.title = title;
        this.actors = actors;
        this.directors = directors;
    }

    int getDate()
    {
        return date;
    }

    void setDate(int date)
    {
        this.date = date;
    }

    String getTitle()
    {
        return title;
    }

    void setTitle(String title)
    {
        this.title = title;
    }

    LinkedList getActors() // returns a reference to the list
    {
        return actors;
    }

    void setActors(LinkedList actors) // sets the field to a list
    {
        this.actors=actors;
    }

    LinkedList getDirectors()
    {
        return directors;
    }

    void setDirectors(LinkedList actors)
    {
        this.directors=actors;
    }

    public String toString() // return a formatted string suitable for printing
    {
        String movie;
        String actrnames = "";
        for (int x = 0; x < actors.size(); x++)
            actrnames = actrnames + ((actors.get(x))).toString() + ", ";

        String dtrnames = "";
        for (int x = 0; x < directors.size(); x++)
            dtrnames = dtrnames + ((directors.get(x))).toString() + ",";

        movie = date + "\t" + title;
        int x;
        for (x = 10; x > title.length() / 4;x--)
            movie=movie+"\t";
        movie=movie+actrnames ;
        for (x = 13; x > (actrnames.length() / 4);x--)
            movie=movie+"\t";
        movie=movie+ "Dir: " + dtrnames;

        return movie;
    }
}

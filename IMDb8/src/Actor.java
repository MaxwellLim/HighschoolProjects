/**
 * Created by 131225 on 9/20/2018.
 */
public class Actor
{
    String name;

    Actor() // be sure to set the next field to null!
    {

    }

    Actor(String name) // be sure to set the next field to null!
    {
        this.name=name;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name=name;
    }


    public String toString() // return a formatted string suitable for printing
    {
        return name;
    }
}

import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE //define the different types of Gems, comma delimited
}

public class Gem 
{
    private GemType color;
    private int points;
    private final int []POINT= {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

	Gem() // create a gem with random color and point value
    {
        int rand = (int)(Math.random()*11);
        points=POINT[rand];
        rand=(int)(Math.random()*3);
        switch (rand)
        {
            case 0:
                color = GemType.GREEN;
                break;
            case 1:
                color = GemType.BLUE;
                break;
            case 2:
                color = GemType.ORANGE;
                break;
        }



    }

	Gem(GemType type, int points) // create a gem with the specified color and point value
    {
        color = type;
        this.points=points;

    }

	public String toString() // return a string representation of the gem
    {
        String temp = color.toString();
        temp+=" "+points;
        return temp;
    }

	GemType getType() // get the type of the gem
    {
        return color;
    }

	int getPoints() // get point value of the gem
    {
        return points;
    }

	void draw(double x, double y) // draw gem at (x, y)
    {
        String png="";
        if(color.toString().equals("BLUE"))
            png="gem_blue.png";
        else if(color.toString().equals("GREEN"))
            png="gem_green.png";
        else if(color.toString().equals("ORANGE"))
            png="gem_orange.png";

        StdDraw.picture(x,y,png);
        StdDraw.text(x,y,points+"");

    }

	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;

		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);

		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}

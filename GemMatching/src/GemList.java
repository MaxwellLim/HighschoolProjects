import java.util.LinkedList;

public class GemList extends LinkedList<Gem>
{

	void draw(double y) // draw all gems in the list at the given Y-coordinate
	{                    // see FAQ for help drawing gems at a particular loc.
        for (int i = 0; i <size(); i++)
        {
            get(i).draw(GemGame.indexToX(i),y);
        }
	}


	public String toString() // return a string representation of the list
	{
	    if(size()==0)
        {
            return ("<none>");
        }
	    String output= "";
        for(int x = 0;x<size()-1;x++)
            output+=get(x).getType()+ " -> ";
        output+=get(0).getType() + "\n";
        return output;

	}

	void insertBefore(Gem gem, int index)    // insert the given gem before the 0-based index
	{                                        // if index is >= size, the new gem is inserted at end
        if(index>size())
        {
            add(gem);
            return;
        }
        add(index,gem);
	}

	int score() // calculate the total score of the list
    {
	    int score=0;
	    int temp=0;
	    int numsame =1;
        for (int i = 0; i <size(); i++)
        {
            if(size()==1)
            {
                score =get(i).getPoints();
                break;
            }
            if(i==0)
            {
                temp += get(i).getPoints();
                continue;
            }
            if(size()==1)
            {
                score=temp;
                break;
            }
            if (get(i).getType().equals(get(i - 1).getType()))
            {
                temp += get(i).getPoints();
                numsame++;
            }
            if (!get(i).getType().equals(get(i - 1).getType()))
            {
                score += temp * numsame;
                numsame=1;
                temp = get(i).getPoints();
            }
            if (i==size()-1)
            {
                score += temp * numsame;
            }



        }
        return score;
	}

	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);

		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);
	}	
}

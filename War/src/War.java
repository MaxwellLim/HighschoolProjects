import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 131225 on 9/10/2018.
 */
public class War
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner cards = new Scanner(new File("War.txt"));
        ArrayQueue hand1 = new ArrayQueue(52);
        ArrayQueue hand2 = new ArrayQueue(52);
        String  order = "23456789TJQKA";


        while (cards.hasNext())
        {


            for(int x = 0;x<26;x++)
            {
                String cardIn = cards.next();
                hand1.enqueue(cardIn);
            }

            for(int x = 0;x<26;x++)
            {
                String cardIn = cards.next();
                hand2.enqueue(cardIn);
            }



            String card1;
            String card2;
            int valCard1;
            int valCard2;


            ArrayQueue cardPile=new ArrayQueue(52);


            for(int x = 0 ;x<100000;x++)
            {


                boolean whoWon=false;
                boolean tie=false;


                card1=hand1.dequeue();
                valCard1= order.indexOf(card1.charAt(0));

                card2=hand2.dequeue();
                valCard2= order.indexOf(card2.charAt(0));

                cardPile.enqueue(card1);
                cardPile.enqueue(card2);


                if(valCard1>valCard2)
                {
                    whoWon=true;
                }

                if(valCard1<valCard2)
                {
                    whoWon=false;
                }

                if(valCard1==valCard2)
                {
                    tie=true;
                }




                while (tie)
                {
                    cardPile.enqueue(hand1.dequeue());
                    cardPile.enqueue(hand2.dequeue());

                    card1=hand1.dequeue();
                    valCard1= order.indexOf(card1.charAt(0));

                    card2=hand2.dequeue();
                    valCard2= order.indexOf(card2.charAt(0));

                    cardPile.enqueue(card1);
                    cardPile.enqueue(card2);

                    if(valCard1>valCard2)
                    {
                        whoWon=true;
                        tie=false;
                    }

                    if(valCard1<valCard2)
                    {
                        whoWon=false;
                        tie=false;
                    }
                }



                if(whoWon)
                {
                    for(int y = 0;y<cardPile.size();y++)
                        hand1.enqueue(cardPile.dequeue());
                }
                else
                    if (!whoWon)
                {
                    for(int y = 0;y<cardPile.size();y++)
                        hand2.enqueue(cardPile.dequeue());
                }

                if(hand1.size()==0||hand2.size()==0)
                    break;

            }


            if(hand1.size()==52)
                System.out.println("Player 1 wins!");
            else
                {
                if (hand2.size()==52)
                    System.out.println("Player 2 wins!");
                else
                    System.out.println("Tie game stopped at 100000 plays.");
                }


        }
    }
}

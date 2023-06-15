import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PrettyPrint
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("input.dat"));
        BinaryTree tree = new BinaryTree();

        String tempin=input.nextLine();
        String[] tempnums=tempin.split(",");
        for (String e:tempnums)
        {

            tree.insertValue(Double.parseDouble(e.trim()));
        }
        tree.inOrder(tree.root);
        Stack<Node> output = tree.inorder;
        int iter=output.size();
        String strOut = "";
        for (int i = 0; i < iter; i++)
        {
            Node temp = output.pop();
            for (int j = 0; j < temp.depth; j++)
            {
                System.out.print("\t");
            }
            strOut=temp.value+", "+strOut;
            System.out.println(temp.value);

        }
        System.out.println("In order: "+strOut.substring(0,strOut.length()-2));


    }
}


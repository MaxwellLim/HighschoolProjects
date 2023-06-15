import java.util.Stack;

public class BinaryTree
{
    public Node root;
    Stack<Node> inorder;

    public BinaryTree()
    {
        inorder=new Stack<>();
    }

    public void insertValue(double k)
    {
        if(root==null)
        {
            root = new Node(k,0);
            return;
        }
        Node parent = findParent(k,root);
        if(k<=parent.value)
            parent.left = new Node(k,parent.depth+1);
        else
            parent.right = new Node(k,parent.depth+1);


    }

    public Node findParent(double k, Node v)
    {
        if(k <= v.value&&v.left ==null)
            return v;
        else
            if(k>v.value&&v.right ==null)
                return v;
            else
                {
                if(k<=v.value)
                    return findParent(k,v.left);
                else
                    return findParent(k,v.right);
                }
    }


    public void inOrder(Node root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            inorder.push(root);
            inOrder(root.right);
        }
    }
}

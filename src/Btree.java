
import java.util.ArrayList;
import java.util.HashMap;

 class BNode
{
	static int t;  //variable to determine order of tree

	int count; // number of keys in node

	int key[];  // array of key values

	BNode child[]; //array of references

	boolean leaf; //is node a leaf or not

	BNode parent;  //parent of current node.

// ----------------------------------------------------
// this will be default constructor for new node      |
// ----------------------------------------------------

	public BNode()
	{}
// ----------------------------------------------------
// initial value constructor for new node             |
// will be called from BTree.java                     |
// ----------------------------------------------------

	public BNode(int t, BNode parent)
	{
		this.t = t;  //assign size

		this.parent = parent; //assign parent

		key = new int[2*t - 1];  // array of proper size

		child = new BNode[2*t]; // array of refs proper size

		leaf = true; // everynode is leaf at first;

		count = 0; //until we add keys later.
	}

// -----------------------------------------------------
// this is method to return key value at index position|
// -----------------------------------------------------

	public int getValue(int index)
	{
		return key[index];
	}

// ----------------------------------------------------
// this is method to get ith child of node            |
// ----------------------------------------------------

	public BNode getChild(int index)
	{
		return child[index];
	}


}



public class Btree
{

    public static Btree t=new Btree(3);
     public static HashMap<Integer , ArrayList<String>> hm=new HashMap<>();
     public static  ArrayList<Integer> ai=new ArrayList<>();


	static int order; 

	BNode root;  



	public Btree(int order)
	{
		this.order = order;

		root = new BNode(order, null);

	}


// --------------------------------------------------------
// this will be method to search for a given node where   |
// we want to insert a key value. this method is called   |
// from SearchnPrintNode.  It returns a node with key     |
// value in it                                            |
// --------------------------------------------------------


	public BNode search(BNode root, int key)
	{
		int i = 0;//we always want to start searching the 0th index of node.

		while(i < root.count && key > root.key[i])//keep incrementing
                    							  //in node while key >
				                    			  //current value.
		{
			i++;
		}

		if(i <= root.count && key == root.key[i])//obviously if key is in node
							                     //we went to return node.
		{


			return root;
		}

		if(root.leaf)//since we've already checked root
    			    //if it is leaf we don't have anything else to check
        {

			return null ;

		}
		else//else if it is not leave recurse down through ith child
		{

			return search(root.getChild(i),key);

		}
	}
//  --------------------------------------------------------
//  this will be the split method.  It will split node we  |
//  want to insert into if it is full.                     |
//  --------------------------------------------------------

	public void split(BNode x, int i, BNode y)
	{
		BNode z = new BNode(order,null);//gotta have extra node if we are
	                					//to split.

		z.leaf = y.leaf;//set boolean to same as y

		z.count = order - 1;//this is updated size

		for(int j = 0; j < order - 1; j++)
		{
			z.key[j] = y.key[j+order]; //copy end of y into front of z
                       // System.out.println(z.key[j]+"dj,fkdfkd");

		}
		if(!y.leaf)//if not leaf we have to reassign child nodes.
		{
			for(int k = 0; k < order; k++)
			{
				z.child[k] = y.child[k+order]; //reassing child of y
			}
		}

		y.count = order - 1; //new size of y

		for(int j = x.count ; j> i ; j--)//if we push key into x we have
		{				 //to rearrange child nodes

			x.child[j+1] = x.child[j]; //shift children of x

		}
		x.child[i+1] = z; //reassign i+1 child of x

		for(int j = x.count; j> i; j--)
		{
			x.key[j] = x.key[j-1]; // shift keys
		}
		x.key[i] = y.key[order-1];//finally push value up into root.


    

		x.count ++;  //increase count of keys in x
	}

        
        
   
// ----------------------------------------------------------
// this will be insert method when node is not full.        |
// ----------------------------------------------------------

	public void nonfullInsert(BNode x, int key)
	{
		int i = x.count; //i is number of keys in node x

		if(x.leaf)
		{
			while(i >= 1 && key < x.key[i-1])//here find spot to put key.
			{
				x.key[i] = x.key[i-1];//shift values to make room

				i--;//decrement
			}

			x.key[i] = key;//finally assign value to node
			x.count ++; //increment count of keys in this node now.

		}


		else
		{
			int j = 0;
			while(j < x.count  && key > x.key[j])//find spot to recurse
			{			             //on correct child  		
				j++;
			}

		//	i++;

			if(x.child[j].count == order*2 - 1)
			{
				split(x,j,x.child[j]);//call split on node x's ith child

				if(key > x.key[j])
				{
					j++;
				}
			}

			nonfullInsert(x.child[j],key);//recurse
		}
	}


	public void insert(Btree t, int key)
	{
		BNode r = t.root;
				
		if(r.count == 2*order - 1)//if is full
		{
			BNode s = new BNode(order,null);//new node

			t.root = s;    
	    			       	
			s.leaf = false;
	    			          
			s.count = 0;   
	    			       	
			s.child[0] = r;

			split(s,0,r);

			nonfullInsert(s, key);
		}
		else
			nonfullInsert(r,key);
	}



	public void print(BNode n)
	{
		for(int i = 0; i < n.count; i++)
		{
			System.out.print(n.getValue(i)+" " );
		}

		if(!n.leaf)
		{

			for(int j = 0; j <= n.count  ; j++)
			{				  
				if(n.getChild(j) != null) 
				{			  
				System.out.println();	  
				print(n.getChild(j));    
				}
			}
		}
	}
        
        
      public  void  btree_inorder(BNode node){
    int j;
     
     for( j = 0; j < node.count  ; j++)
			{				  
				if(node.getChild(j) != null) 
				{			  
				  
				btree_inorder(node.getChild(j));
                                
				}
                                if(node.getValue(j)!=0)
                                 System.out.println(node.getValue(j)+" ");
                                ai.add(node.getValue(j));
			}
     if(node.getChild(j) != null) 
				{
     btree_inorder(node.child[j]);
     }
    
      }


	public int SearchPrintNode( Btree T,int x)
	{
		BNode temp= new BNode(order,null);

		temp= search(T.root,x);

		if (temp==null)
		{
                    System.out.println("The Key "+x+ " does not exist in this tree");
                 return 0;
		
		}

		else
		{
                    
                    System.out.println("the key "+ x+ " is found at this node : \t" );
		print(temp);
                return x;
		}


	}


       
       
       public static void main(String[] args) {
           
        

    }


}
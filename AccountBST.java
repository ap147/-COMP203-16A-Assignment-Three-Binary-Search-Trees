//Amarjot Parmar
//1255668

/*
  class has all methods needed to build and maintain your BST of Accounts
  insert an account following the standard BST ordering,
  remove an account according to the standard BST removal procedure,
  find an account, print accounts in order out,using there keys
 */
public class AccountBST {
	private Account root; 
	private AccountBST left;
	private AccountBST right;
	static int  Total = 0;     //Total amount of keys held in all BST
    
    //Constructor which is only used when creating the very first root
	public AccountBST(){ 
		root = null; right = null; left = null; 
	}
    //Constructor which is only used when creating a new tree(left/right)
	public AccountBST(Account _root){
		root= _root; 
		right = null; left= null;
    }
    
    
     /*Takes a key and an amount, creates a new Account with those values, 
      and adds it to your BST following the standard BST ordering */
	public void insert(int _key, float _amount){   
		Account newAccount = new Account(_key, _amount); //Creating account with given values
        
        if(root == null){       //If this BST does not have root
			root = newAccount;  //make the paass
            System.out.print(root.getKey() + " ");
		}
		else if (_key < root.getKey()){//key is less then root
			if(left == null){//check if left is null
				left = new AccountBST(newAccount);	 //if so Store newAccount in left subtree
                System.out.print(left.getRoot().getKey() + " ");
			}
            else//otherwise pass the values to left subtree to insert
				left.insert(_key,_amount);          
		}
		else{
			if(right == null){
				right = new AccountBST(newAccount);
                System.out.print(right.getRoot().getKey() + " ");
			}
			else
				right.insert(_key,_amount);	
		}
	  }	
	//Takes a key and returns a reference to the Account in the tree that is identified by that key; or null if the key is not found
	public Account find(int _key){   
		Account Target = null;
        if(root !=null){System.out.print(root.getKey() + " ");}
        if(root == null){ }//System.out.println("Key Not Found !");}
		else if (root.getKey() == _key){ Target = root;}
		else{
			if(_key < root.getKey()){
                if(left != null)
                    Target = left.find(_key);
			}
			else{
                if(right != null)
				Target = right.find(_key);
			}
		}
        if(Target != null){}
		return Target; 
     
	 }
	
	/*
	  Takes a key, finds the corresponding Account node and removes it according to the standard BST removal procedure 
	  (i.e. if a leaf node, just delete it; if has one child then replace it with that child; 
	  otherwise replace it with its successor ... which is the left-most node in the right subtree). 
	   If the Account is not found then this method does nothing.
	 */
	public void remove(int _key){
		AccountBST target = this;	   // holds _key that is being tested (is it the key we want to remove)
		AccountBST parent = this; 	   // holds parent of key that needs is being tested
		
		boolean isItLeftChild = true;  // gets toogled if key that needs to be removed is right child of parent
		
		//loop until key is found, if not then does nothing 
		while(target.root.getKey() != _key){
			
			parent = target; //While searching, keeps track of parent of this key its looking for
			
			if(_key < target.root.getKey()){ //toogleing if key is smaller then current target key
				isItLeftChild = true;
				target = target.left;
			}
			else{
				isItLeftChild = false;
				target = target.right;
			}
		}
		//CASE 1: Leaf Node
		if(target.left ==null && target.right == null){
			if(target.root.getKey() == root.getKey()){ // Removing last Only BSTTree
				root = null;		
			}else if(isItLeftChild){ //if target is left subtree of parent
				parent.left = null;  //simply removing it
			}else{
				parent.right = null; 
			}			
		}
		//CASE 2: 1 Subtrees  (Target has left child)
		else if(target.right == null){
			if(target == parent){  // Removing last Only BSTTree
                AccountBST temp = target.left;
                
                root = target.left.root;
                if(target.left.left !=null){ left = target.left.left;} //Copying
                if(temp.right != null){right= temp.right;}
                
                if(temp.left == null){left = null;}    //Deleting refrence to replacement
                if(temp.right == null){right = null;}
		    }
			else if(isItLeftChild){ //Deleting left subtree of parent & replaceing it
				parent.left = target.left;
			}else{
				parent.right = target.left;
			}
		}
		//CASE 2: 1 Subtrees (Target has right child)
		else if(target.left == null){
			if(target == parent){
                AccountBST temp = target.right;

                root = target.right.root;
                if(target.right.right !=null){ right = target.right.right;}
                if(temp.left != null){left= temp.left;}
                
                if(temp.right == null){right = null;}
                if(temp.left == null){ left = null;}
		    }
			else if(isItLeftChild){
				parent.left = target.right;
			}else{
				parent.right = target.right;	
			}
		}
		//CASE 3: 2 Subtrees
		else{
			AccountBST replacement = getReplacementNode(target);//getting Account which will replace Account that needs to be removed
		
            target.root = replacement.root;                 //copying
            target.right.remove(replacement.root.getKey()); //getting rid of duplicate
        }
	 }
	//method which returns the left-most node in the right subtree
	public AccountBST getReplacementNode(AccountBST _target){  
		AccountBST replacement = _target;
		AccountBST replacementParent = _target;
	
		AccountBST focusNode = replacement.right; //moving to the right subtree
		while(focusNode !=null){                  //then going down the lef subtrees until null
			replacementParent =replacement;
			replacement = focusNode;
			focusNode = focusNode.left; 
		}
		return replacement;
	}
	
	
	//print out all the account keys and corresponding balances, one pair per line, for the Accounts still in your BST. 
	public void InOrderTraverse(){  
		if(root != null){
			if(left!=null)
				left.InOrderTraverse();	
			
			processRoot();
            
			if(right !=null)
				right.InOrderTraverse();	
		}
	}
	//prints root's key value 
    public void processRoot(){  
		System.out.println(root.getKey() + " " +root.getBalance());
		Total++; //inrementing total amount of keys in BST
	}

    public Account getRoot(){
        if (root != null)
            return root;
        else
            System.out.println("Root Empty!");
      
        return root;
    }
    
    public int getTotal(){
    	return Total;
    }
	
}
//http://www.tutorialspoint.com/data_structures_algorithms/tree_traversal.htm
//https://www.youtube.com/watch?v=M6lYob8STMI
//https://www.youtube.com/watch?v=UcOxGmj45AA
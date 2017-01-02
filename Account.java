//Amarjot Parmar
//1255668
/*
 Class holds an integer "key" to hold the account number,
 and a floating point "balance" to keep track of how much money is in this account.
 There are public methods to get this information from this class
 And an method which updates the balance after a transaction
 */
public class Account {
	
	 private int key;  		     //account number
	 private float balance = 0;  //how much money is in this accoun
	
    //Constructor which sets account number and balance of this account.
	public Account(int _key, float _balance) {
		key = _key;
		balance = _balance; 
	}
    //Method which recalculates the remaininng balance after a transaction
	public void ReProcess(char _TransactionType,float _Amount){
		if(_TransactionType == 'd'){        //IF transaction is Deposit
			balance = balance + _Amount;    //Add the amount passed in to balance
		}
		else if (_TransactionType == 'w'){                              //Otherwise
			balance = balance - _Amount;    //Do the opposite
		}
	}
	

	
	public int getKey() {
		return key;
	}
	
    public float getBalance() {
		return balance;
	}
}

//Amarjot Parmar
//1255668
/*
  it takes a command-line argument the name of a text file which is expected to be in the same directory. 
  Each line of the file is comprised of three fields, separated by spaces. 
  Every field has set meaning, if these fields dont match what this class expects it skips that line, 
  but if anything is wrong with cmdline arguement program outputs an error message and terminate.
 
 */
import java.io.FileReader;
import java.io.BufferedReader;
public class XProcess {
        static AccountBST root = new AccountBST(); //Creating empty BST, used as refrence to maintain BST
		public static void main(String []args){
			System.out.println();
            //Making user user has only passed in one value
			if(args.length != 1){
				System.out.println("Error: Invalid address");
				return;
			}
            //if value is not valid try/catch will
            try{         
                BufferedReader br = new BufferedReader(new FileReader(args[0]));                    
                String line;
                //keep looping until end of file, each loop move to next line
                while ((line = br.readLine()) != null) {                      
				    process(line);
                }
                br.close();
            //throw error message
            }catch (Exception e){System.out.println("Error while reading file" + e);}

            //printing out results
            System.out.println("");
            System.out.println("------------------RESULTS------------------");
            root.InOrderTraverse();
            System.out.println("");
        System.out.println("Total Keys: " + root.getTotal());
        }
    
    // takes a line from a text file, breaks it down into array, calles the right methods
    public static void process(String line){
        int key =0; float amount =0; char type =0;
        
        String[] array = line.split(" "); //making an array of Strings which are seprated by a space
        //In case input is not correct/ format, method does nothing and prints error message
        try{
            if(array.length != 3){System.out.println("Error: line length not 3");}
            else{
               //Extracting information out of array, converting them into right data types
               key = Integer.parseInt(array[0]);
               type = array[1].charAt(0);
               amount = Float.parseFloat(array[2]);
                
               Account target = root.find(key); //varible will be null if account being processed doesnt already exist
                
               if(type == 'c'){
							int removeMe= target.getKey();
							root.remove(removeMe);         //passing in key that needs to be removed
                            System.out.print("CLOSE");
						}
						else{        
							if(target !=null){                  //If accoutn already exists
								target.ReProcess(type, amount); //update its balance with correct transaction
                                if(type == 'w'){System.out.print("WITHDRAW");}
                                if(type == 'd'){System.out.print("DEPOSIT");}
							}else{//if new account, then create a new account and add it to BST
                                if(type == 'w'){ amount = amount - amount *2; root.insert(key, amount); System.out.print("WITHDRAW");}
                                if(type == 'd'){root.insert(key, amount); System.out.print("DEPOSIT");}
							}
                        }
                        System.out.println();               
            }
        }catch(Exception e){
			if(type == 'c'){
				System.out.print("CLOSE");
				System.out.println(); 
				}
			else{
            System.out.println("Error while processing line.");
			}
        }
        
    }

}

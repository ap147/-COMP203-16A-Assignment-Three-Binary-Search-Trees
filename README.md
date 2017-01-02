# COMP203-16A-Assignment-Three-Binary-Search-Trees

COMP203-16A — Assignment Three
Binary Search Trees
Due: Sunday, May 22nd, 2016 — 11pm (15%)

Description: This assignment is intended to give you experience maintaining a binary search tree (BST) of words. You must write your own BST class and all its required operations.

The data in your BST are bank accounts, where an integer account number is the key that uniquely identifies a node and is used for ordering the tree. Associated with each node is a bank balance, expressed as a floating point number. Your program will process a file of bank transactions that include deposits, withdrawals and account closures, and these transactions will determine what happens to your BST.

Specification: Your program should run as a console program from the Linux command-line (i.e. no GUI). Your program object should be called XProcess.java and it should accept as a command-line argument the name of a text file expected to be in the same directory. Each line of the file is comprised of three fields, separated by spaces. The first field is an integer that is an account number; the second field is a single letter indicating whether the transaction is a deposit, a withdrawal or an account closure ('d', 'w' or 'c' respectively); and the third field is a floating point number specifying the magnitude of the transaction (i.e. how much money). Your program must also conform to the following specification:

    Define a data class called Account in a file on its own. Each Account needs an integer "key" to hold the account number, and a floating point "balance" to keep track of how much money is in this account. These fields must be private, but you will need public methods to "getKey()" and "getBalance()" to gain access to these values. And you will need a "setBalance()" public method to update the balance based upon the type and value of a transaction. This last method will take an argument indicating the magnitude of the change to the current balance.
    Define a class called AccountBST in a file by itself. This has all the methods needed to build and maintain your BST of Accounts. It will need a "root" node of type Account to refer to the datum at the root of the tree, and it will need a "left" and a "right" of type AccountBST to point to the two subtrees. These member variables must be private.
    Your BST class (i.e. AccountBST) will need a "find()" method that takes a key and returns a reference to the Account in the tree that is identified by that key; or null if the key is not found.
    Your BST will need an "insert()" method that takes a key and an amount, creates a new Account with those values, and adds it to your BST following the standard BST ordering (i.e. key values less than the root go in its left subtree, otherwise they go in the right).
    Your BST will need a "remove()" method that takes a key, finds the corresponding Account node and removes it according to the standard BST removal procedure (i.e. if a leaf node, just delete it; if has one child then replace it with that child; otherwise replace it with its successor ... which is the left-most node in the right subtree). If the Account is not found then this method does nothing.
    XProcess must make sure the commandline arguments are good, and if anything is wrong then your program should output an error message and terminate.
    If the commandline argument is good, then it is the name of a text file of transactions, one transaction per line, that must be processed. Your program will thus need an Account BST. Read the file one line at a time and update your Account BST accordingly. Each line will give you an int "account" key, a char transaction "type" and a float "amount".
    If the "account" key is not found in your BST then you must create a new Account and add it as a new node, and assume it starts with a zero "balance"; but only if the transaction type is 'd' or 'w' (see below).
    If the transaction "type" is 'd' then a deposit occurs and the "amount" of the transaction must be added to the "balance" of the Account identified by that key.
    If the transaction "type" is 'w' then a withdrawal occurs and the "amount" must be subtracted from the "balance" of the corresponding Account. The balance is allowed to be negative (i.e. overdrawn).
    If the transaction "type" is 'c' the account is being closed and the corresponding Account must be deleted from the BST. The "amount" of this transaction is ignored/irrelevant. If the "key" is not found in the BST then do nothing ... that is, don't create the Account just to delete it.
    Any errors detected on input should result in your program ignoring the entire transaction; just move on to the next line.
    For each transaction, your program is to output the list of "keys" encountered along the search path from the root to the target Account. These should be listed on one line, each key separated by a space; thus the list should start with the root "key" and end with the target's "key". After this, at the end of each line of output, should be the word "DEPOSIT" or "WITHDRAW" or "CLOSE" in accordance with the transaction "type".
    After the entire input file has been processed, your program must print out a line that just says "RESULT"; after which it must print out all the account keys and corresponding balances, one pair per line, for the Accounts still in your BST. To do this, add an in-order traversal method to your AccountBST class.
    The find, insert, remove, and traverse methods are the public interface for your AccountBST. You may add other methods if you find them useful (e.g. you might want an "update" method). 

The point of the output is just to make sure your tree has been maintained correctly. A sample file and its correct output will be posted on the course webpage (i.e. Moodle) so that you can check your program conforms to this specification; but your program will be tested on a much larger file and a sample will be posted on Moodle the week before your assignment is due.

Submission: Make sure your code is properly formatted and well-documented, including your name and student identification number. Submit your source code only (no .class files or data) using Moodle.

Tony C. Smith, 2/5/2016

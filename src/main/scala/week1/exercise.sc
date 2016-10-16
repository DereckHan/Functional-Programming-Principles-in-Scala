/* Exercise 1
  * The following pattern of numbers is called Pascal’s triangle.
  * 1
  * 1 1
  * 1 2 1
  * 1 3 3 1
  * 1 4 6 4 1
  * ...
  * The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it. Write a function that computes the elements of Pascal’s triangle by means of a recursive process.
  * *
  * Do this exercise by implementing the pascal function in Main.scala, which takes a column c and a row r, counting from 0 and returns the number at that spot in the triangle. For example, pascal(0,2)=1,pascal(1,2)=2 and pascal(1,3)=3.
  */

pascal(1, 2)
pascal(1, 3)

//When there is recursive in function, it is necessary to declare return type
def pascal(col: Int, row: Int): Int = {
  if (col == 0 || col == row) 1
  else pascal(col, row - 1) + pascal(col - 1, row - 1)
}

/*
  * Exercise 2
  * Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char] not a String. For example, the function should return true for the following strings:
  * (if (zero? x) max (/ 1 x))
  * I told him (that it’s not (yet) done). (But he wasn’t listening)
  * The function should return false for the following strings:
  * :-)
  * ())(
  * The last example shows that it’s not enough to verify that a string contains the same number of opening and closing parentheses.
  */

balance(List('(', 'i', 'f', ' ', '(', 'z', 'e', 'r', 'o', '?', ' ', 'x', ')', ' ', 'm', 'a', 'x', ' ', '(', '/', ' ', '1', ' ', 'x', ')', ')'))

balance(List(':', '-', ')'))


def balance(chars: List[Char]): Boolean = {
  def balanced(chars: List[Char], open: Int): Boolean =
    if (chars.isEmpty) open == 0
    else if (chars.head == '(') balanced(chars.tail, open + 1)
    else if (chars.head == ')') open > 0 && balanced(chars.tail, open - 1)
    else balanced(chars.tail, open)
  balanced(chars, 0)
}

/*
  * Exercise 3
  * Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.
  * Do this exercise by implementing the countChange function inMain.scala. This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:
  */

countChange(4, List(1, 2))

def countChange(money: Int, coins: List[Int]): Int = {
  if (coins.isEmpty) 0
  else if (money - coins.head == 0) 1
  else if (money - coins.head < 0) 0
  // sum of whether use this coins.head or not use it
  else countChange(money - coins.head, coins) + countChange(money, coins.tail)
}






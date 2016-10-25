# Functional Programming Principles in Scala

## Course: 
[Functional Programming Principles in Scala](https://www.coursera.org/learn/progfun1/home/welcome)

### Week 1 :

- Two ways of Main Method :

  ```scala
  object Main extends App{
    println("Hello, World")
  }

  object Main{
    def main(args: Array[String]){
      println("Hello, World")
    }
  }
  ```


- In IntelliJ IDEA, when using Scala WorkSheet, no need to define Object
- Object and Class are pretty similar to Java
- In Scala, the standard is to indent using 2 spaces (no tabs).

### Week 2 :

- Functions can be passed as parameters.

```scala
//Sum from a to b using function f
def sum(f:Int => Int, a: Int, b: Int):Int = {
  if(a>b)	0
  else	f(a) + sum(f,a+1,b)
}
// (x:Int) => x*x*x		(x:Int, y:Int) => x+y
// Types can be ommitted if it can be inferred by the compiler 
def sumInts(a:Int, b:Int) = sum(x => x,a,b)
def sumCubs(a:Int, b:Int) = sum(x => x*x*x,a,b)
```

- Define function:

```scala
def gcd(a: Int, b: Int): Int = 
  if (b == 0) a 
  else gcd(b, a % b)
```

parameter type is after parameter, and the return type is only necessary when there is a recursive in the function.

+, -, >, < can be funtion name, so we can define these method inside the class to operate new class just like 1 + 2

### Week 3:

Define Abstract Class:

```scala
abstract class Base{
  def foo = 1
  def bar: Int
}
class Sub extends Base{
  override def foo = 2
  def bar = 4
}
```

```scala
//Because the function inside doesn't have content, so it's neccessary to define the class as abstract, so we can extends subclass or object to override the variables and functions
abstract class IntSet{
  def incl(x:Int): IntSet
  def contains(x:Int): Boolean
  def union(other:IntSet): IntSet
}
class Empty extends IntSet{
  // if Empty is Object instead of Class, it will be initialized the first time we refer it, so there will be no 'new Empty' just 'Empty'
  def incl(x:Int):IntSet = new NonEmpty(x,new Empty, new Empty)
  def contains(x:Int): Boolean = false
  override def toString = "."
  def union(other:IntSet):IntSet = other
}
class NonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet{
  def incl(x:Int):IntSet = 
    if(x<elem)  new NonEmpty(elem, left incl x, right)
    else if(x>elem)  new NodeEmpty(elem,left,right incl x)
    else  this
  def contains(x:Int): Boolean = 
    if(x<elem)  left contains x
    else if(x>elem)  right contains x
    else  true
  override def toString = "{"+left+elem+right+"}"
  def union(other:IntSet):IntSet = 
    ((left union right) union other) incl elem
}
```

Higher order function — a function does at lease one of the followings:

- takes one or more functions as arguments
- returns a function as result

```scala
import week3._ // This means we can import everything that defines in package week3
import week3.Rational // Just import Rational
import week3.{Rational, Hello} // import both Rational and Hello
```

Scala Standard Libraryhttp://www.scala-lang.org/api/current/#package

In Scala, a class can only have one super class, which called single inheritance. So if we want to define a class that has multiple attributes from different class, we use trait. class, object and trait can inherite from at most one class but arbitrary many traits.

```scala
// Pretty like interface in java, but trait can contains field and concrete methods, but cannot have value parameters
trait Planar{
  def height:Int
  def width: Int
  def surface = height*width
}
// combine traits using "with"
class Square extends Shape with Planar
```

![Scala's Class Hierarchy](https://goo.gl/images/oKZIR3)

​										Scala's Class Hierarchy

Scala.Nothing:

- To signal abnormal termination 	(type of error method)
- As an elemnt type of empty collections

The value is null, the type of null is Null, Null is a subtype of any class inherits from Object, it's incompatible with subtypes of AnyVal.

```scala
val x = null		//x:Null
val y:String = null	//y:String
val z:Int = null	//error: type mismatch
```

We can use T to represent any type, so that we can write a more generic abstract class or trait, which is called "Polymorphism" — a function type comes "in many forms"

 


# Functional Programming Principles in Scala

## Course: 

[Functional Programming Principles]: https://www.coursera.org/learn/progfun1/home/welcome

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

- +, -, >, < can be funtion name, so we can define these method inside the class to operate new class just like 1 + 2
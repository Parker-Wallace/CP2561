# Assignment #1 Exception Handling Due Tues May 21st ( 42 marks total)
Please submit to the dropbox on d2l
___
1. Question: What exception types can be caught by the following handler? (2 marks)

```java
catch (Exception e) {
}
```
> **Answer**: the above code will catch any and all exception types and store them in variable e

What is wrong with using this type of exception handler? ( 2 marks)

> **Answer**: with catch all exceptions there is not much you can do to **handle** the exception due to there being so many types

2. Question: Is there anything wrong with this exception handler as written? Will this code compile? ( 2 marks)

```java
try {
} catch (Exception e;) {
} catch (ArithmeticException a;) {
}
```

> **Answer**: While the code **will** compile the ArithmeticException a will never be caught as Exception e 
is higher in the stack and will catch any arithmatic exception error first.

3. Exercise: Modify the following cat method so that it will compile: ( 3 marks )

```java
public static void cat(File file) {
    RandomAccessFile input = null;
    String line = null;
    try {
        input = new RandomAccessFile(file, "r");
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            }
    } finally {
        if (input != null) {
            input.close();
        }
    }
}
```

**Answer**:
> The code **will** compile by adding a throws clause in your method declaration:
> ```java
> import java.io.IOException;
>
> public static void cat(File file) throws IOException {
>     // the rest of your code
> }
> ```

> However, it is best practice to utilize a try-catch block. Here's an alternative:
> ```java
> import java.io.File;
> import java.io.IOException;
> 
> public static void cat(File file) {
>     try {
>         // Your code that may throw an IOException
>     } catch (IOException e) {
>         System.err.println(e); // Or handle the exception further
>     }
> }
> ```


4. Exercise: Use your solution to the “May 7th Review Exercise”, where you created
a simple program demonstrating a class heirarchy of shapes. (If you didn’t complete
this, you may use the zipped folder “review_soln.zip” posted on d2l) ( 12 marks )
   1. Create an InvalidShapeParameterException object ( 3 marks )
         - The object should extend exception 
         - It should contain a private static final string called MSG that says “Shape parameter is not
               valid!” 
         - Create a default constructor that uses this message
      
   > [Solution](Shapes/InvalidShapeParameterException.java)

   2. Whenever anyone tries to set an invalid value (negative number) into a Rectangle or a Circle
      throw an exception. (Throw the exception anywhere appropriate to prevent a shape from
      getting an invalid parameter.) ( 3 marks )
   
   > [Rectangle Solution](Shapes/Rectangle.java)
   > 
   > [Circle Solution](Shapes/Circle.java)

   3. Update CircleTester and ShapeTester objects to test that the exception works. (3 marks )
   
   > [Circle Tester Solution](Shapes/CircleExceptionTest.java)
   > 
   > [Rectangle test Solution](Shapes/RectangleExceptionTest.java)  

   4. In your ShapeGenerator object, generate negative and positive integers and catch the thrown
      Exceptions from negative values. (Be sure to print out when you encounter a negative
      parameter so the exception working can be demonstrated when your main application
      executes.) ( 3 marks )
   
   >[Shape Generator Object](Shapes/ShapeGenerator.java)
   > 
   > [Main](Shapes/FunWithShapes.java)


5. Book exercises from [Java: how to program early objects pg.1342](https://github.com/pkdandan/books-2/blob/master/Java%20How%20to%20Program%2011th%20Early%20Objects.pdf)
   1. 11.16 (Catching Exceptions with Superclasses) Use inheritance to create
      an exception superclass (called ExceptionA) and exception subclasses
      ExceptionB and ExceptionC, where ExceptionB inherits from
      ExceptionA and ExceptionC inherits from ExceptionB. Write a
      program to demonstrate that the catch block for type ExceptionA
      catches exceptions of types ExceptionB and ExceptionC. ( 6 marks )
   
   > [ExceptionA](BookExercises/Q11_16/ExceptionA.java)
   > 
   > [ExceptionB](BookExercises/Q11_16/ExceptionB.java)
   > 
   > [ExceptionC](BookExercises/Q11_16/ExceptionC.java) 
   > 
   > [Test](BookExercises/Q11_16/Test.java)

   2. 11.19 (Constructor Failure) Write a program that shows a constructor
      passing information about constructor failure to an exception handler.
      Define class SomeClass, which throws an Exception in the
      constructor. Your program should try to create an object of type
      SomeClass and catch the exception that’s thrown from the constructor. ( 5 marks )
   
   > [Constructor](BookExercises/Q11_19/BadConstructor.java)
   >
   > [Test Program](BookExercises/Q11_19/Main.java)

   3. 11.20 (Rethrowing Exceptions) Write a program that illustrates
      rethrowing an exception. Define methods someMethod and
      someMethod2. Method someMethod2 should initially throw an
      exception. Method someMethod should call someMethod2, catch the
      exception and rethrow it. Call someMethod from method main, and
      catch the rethrown exception. Print the stack trace of this exception. ( 5 marks )
   
   > [Solution](BookExercises/Q11_20/Main.java)

   4. Exercise: Create a class “WeightConverter” which has two methods to perform
   conversions, “poundsToKilos” and “kilosToPounds”. Add assertions to these
   methods to prevent the conversion of weights less than or equal to 0. Create a main
   method which tests these two methods with correct values and incorrect values. ( 4
   marks)

   > [Solution](WeightConverter.java)


6. Question: How do you enable assertions in Java? What happens when you release
your code and there are assertions in the code? Is there any performance penalty for
using assertions? ( 2 marks )

>**Answer**:
>>*option A*: IntelliJ's settings
>>1. right click on runnable script
>>2. more run/debug  
>>3. edit run config
>>4. modify options
>>5. add vm options
>>6. "-ea"
>
>>*option B*: Command line
>>```shell
>>java - ea {filename}
>>```
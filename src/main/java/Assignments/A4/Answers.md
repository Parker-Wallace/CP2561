1. Explain why inserting additional elements into an ArrayList object whose current size is less than its capacity is a relatively fast operation and why inserting additional elements into an ArrayList object whose current size is at its capacity is a relatively slow operation.

    **Answer**

    ArrayLists are initialized with a capacity of 10, since java 8 ArrayLists allocate additional memory ass elements are added beyond its capacity, this means that when adding to an arraylist beyond its capacity additional processing is needed to allocate the extra memory
    

2. Briefly answer the following questions:

    1. What is the primary difference between a Set and a Map?
        
        **Answer**
   
        sets are akin to python lists (unordered) and cannot contain duplicated values whereas a map stores data in key value pairs which can be easily indexed and can contain duplicate entries

    2. What happens when you add a primitive type (e.g., double)
    value to a collection?

        **Answer**

        you cannot add primitive types to a colleciton, they are autoboxed into their coorsponding wrapper class (int => Integer, double => Double, etc) before being added to the collection

    3. Can you print all the elements in a collection without using an
    Iterator? If yes, how?

        **Answer**

        you can print the elements without using explicit iterators by individually printing the index of each item.
        ```java
            system.out.println(List[index])
            system.out.println(List[index])
            system.out.println(List[index])
        ```
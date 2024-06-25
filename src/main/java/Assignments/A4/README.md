# Assignment #4 Java Collections ( 19 Marks )

1. Explain why inserting additional elements into an ArrayList
object whose current size is less than its capacity is a relatively fast
operation and why inserting additional elements into an ArrayList
object whose current size is at its capacity is a relatively slow operation.
    <details>
    <summary>Answer</summary>
    ArrayLists are initialized with a capacity of 10, since java 8 ArrayLists allocate additional memory ass elements are added beyond its capacity, this means that when adding to an arraylist beyond its capacity additional processing is needed to allocate the extra memory
    </details>

2. Briefly answer the following questions:
    1. What is the primary difference between a Set and a Map?
        <details>
        <summary>Answer</summary>
        set are akin to python lists (unordered) and cannot contain duplicated values whereas a map stores data in key value pairs which can be easily indexed and can contain duplicate entries
        </details>
    2. What happens when you add a primitive type (e.g., double)
    value to a collection?
            <details>
        <summary>Answer</summary>
        you cannot add primitive types to a colleciton, they are autoboxed into their coorsponding wrapper class (int => Integer, double => Double, etc) before being added to the collection
        </details>
    3. Can you print all the elements in a collection without using an
    Iterator? If yes, how?
          <details>
        <summary>Answer</summary>
        you can print the elements without using explicit iterators by individually printing the index of each item
        
        <code>system.out.println(List[index])
        system.out.println(List[index])
        system.out.println(List[index])</code>
        etc...
        </details>

3. Rewrite lines 10–25 in [Fig. 16.](ListTest.java) to be more concise by using the
asList method and the LinkedList constructor that takes a
Collection argument.

4. (Copying and Reversing LinkedLists) Write a program that
creates a LinkedList object of 10 characters, then creates a second
LinkedList object containing a copy of the first list, but in reverse
order.

5. (Changing a PriorityQueue’s Sort Order) The output of Fig.16.14 shows that Priority-Queue orders Double elements in ascending order. Rewrite [Fig. 16.14](PriorityQueueTest.java) so that it orders Double elements in descending order (i.e., 9.8 should be the highest-priority element rather than 3.2).
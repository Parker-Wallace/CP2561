# Assignment 5

## Background

In this assignment, you will create a program that checks RSS feeds in the background. The task will be represented by an object that implements `Runnable`, and the execution of this task will be managed using an executor service. This will help you understand how to create and manage threads effectively in a Java application.

### Objectives

1. Create a class that implements `Runnable` to perform the task of checking an RSS feed. (See example from Class)
2. Use an executor service to manage the execution of this task.
3. Implement synchronization to handle shared resources if necessary.
4. Ensure proper thread management using the `wait`, `notify`, and `notifyAll` methods where appropriate.
5. Demonstrate it works by letting it run before demo. Also look up some busy RSS feeds and create multiple feeds.

### Requirements

1. **Create the `RssFeedChecker` class:** 
    - This class should implement the `Runnable` interface.
    - The `run` method should contain logic to check an RSS feed and print the last 3 posts to the console.

2. **Implement the `Main` class:**
    - Prompt the user to input URLs for the RSS feeds.
    - Create an executor service to manage the execution of `RssFeedChecker`.
    - Schedule the RSS feed checker to run periodically using the executor service.

3. **Synchronization:**
    - If multiple threads access shared resources, ensure proper synchronization using the `synchronized` keyword.
    - Demonstrate the use of wait, notify, and notifyAll methods in a scenario where threads need to communicate.

4. Handling Thread Interruption:
    - Handle thread interruptions gracefully to ensure the application can shut down cleanly.

### busy feed for testing

- https://feeds.bbci.co.uk/news/world/rss.xml
- https://www.nytimes.com/svc/collections/v1/publish/https://www.nytimes.com/section/world/rss.xml
- https://defence-blog.com/feed/
- https://feeds.washingtonpost.com/rss/world

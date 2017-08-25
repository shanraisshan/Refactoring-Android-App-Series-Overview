# Episode 4
In this episode
1. Introduce exceptions in DatabaseBooksRepository.java class
2. Handle exceptions in BooksActivityPresenter.java class
3. New unit test for exception in BooksActivityPresenterTest.java class

Changes in Previous Episode Code
----
**Episode 2 and 3:** Changed Mockito initialization according to [Jereon Mols](https://www.youtube.com/watch?v=DJDBl0vURD4) video

Old code
```java
@RunWith(MockitoJUnitRunner.class)
```
New
```java
@Rule
public MockitoRule mockitoRule = MockitoJUnit.rule();
```

Overview
----
Main focus of episode 4 is on testing exceptions. Discussion about devoxx video Testing made sweet with a Mockito by [Jereon Mols](https://www.youtube.com/watch?v=DJDBl0vURD4).

![episode4-Jeroen](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/blob/master/Episode4/!shanraisshan/E4-Jeroen.PNG)

Apk
----
Apk is avaiable at [/!shanraisshan/](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/tree/master/Episode4/!shanraisshan)

![episode4-apk](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/blob/master/Episode4/!shanraisshan/E4.png)

Episode Link
----
Episode 4 - [Refactoring an Android App - #4 - MVP Testing continued (Exceptions)](https://www.youtube.com/watch?v=t_rlR8ZKvYA)

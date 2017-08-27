# Episode 6
In this episode
1. Retrolambda: make library work
2. RxJava: replace subscribe with subscribeWith
3. RxJava: disposing CompositeDisposable
4. Talk on code coverage

Changes in Previous Episode Code
----
**Episode 5:** Replace subscribe with subscribeWith according to [Jake Wharton](https://youtu.be/htIXKI5gOQU) video

Old code
```java
bookRepository.getBooks().subscribe(...
```
New
```java
bookRepository.getBooks().subscribeWith(...
```

Overview
----
Main focus of episode 6 is on RxJava. Code changes as suggested in GOTO Conferences video [GOTO 2016 • Exploring RxJava 2 for Android • Jake Wharton](https://youtu.be/htIXKI5gOQU).

![episode6-Jake](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/blob/master/Episode6/!shanraisshan/E6-Jake.PNG)

Apk
----
Apk is avaiable at [/!shanraisshan/](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/tree/master/Episode6/!shanraisshan)

![episode6-apk](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/blob/master/Episode6/!shanraisshan/E6.png)

Episode Link
----
Episode 6 - [Refactoring an Android App - #6 - RxJava 2 Composite Disposables](https://youtu.be/-gcMO7CRmWA)

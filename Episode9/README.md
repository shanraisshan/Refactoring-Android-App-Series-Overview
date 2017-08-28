# Episode 9
This episode focuses on answering Audience questions
1. Q1) MVP: What do you mean by MVP with repository?
2. Q2) MVP: Why presenter is not initialized in onStart and why is not destroyed?
3. Q3) RxJava: Why is obseverOn and subscribeOn are placed inside presenter?
4. Q4) MVP: Passing new BookRepository() from Activity to presenter, isn't it wrong according to MVP?
5. Q5) RxJava: Which thread should be used to perform .map operation?
6. Q6) RxJava: Never place obseverOn and subscribeOn inside presenter
7. Discussion about RxJava guy [Dávid Karnok](https://www.youtube.com/user/lgc314) explaination of [trampoline](https://youtu.be/1ZOiT09UDfE?t=2299) on episode 8 youtube comments

Changes in Previous Episode Code
----
Move Presenter initialization to OnStart from OnCreate

Overview
----
**[Q1](https://youtu.be/1ZOiT09UDfE?t=145). MVP: What do you mean by MVP with repository?**

**Ans:** Explained MVP with Clean architecture [04:20 - 18:50](https://youtu.be/1ZOiT09UDfE?t=260) using [Fernando Cejas article](https://fernandocejas.com/2015/07/18/architecting-android-the-evolution/)

![episode9-Clean](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/blob/master/Episode9/!shanraisshan/E9-Clean.png)

**[Q2](https://youtu.be/1ZOiT09UDfE?t=1129). MVP: Why presenter is not initialized in onStart and why is not destroyed?**

**Ans:** Changed, move Presenter initialization to OnStart from OnCreate

**[Q3](https://youtu.be/1ZOiT09UDfE?t=1370). RxJava: Why is obseverOn and subscribeOn are placed inside presenter?**

**Ans:** Depends on scenerio

More Discussion on this from [34:40 - 48:00](https://youtu.be/1ZOiT09UDfE?t=2080)

Explained at the end of video at [56:00](https://youtu.be/1ZOiT09UDfE?t=3360) that [Fernando Cejas article](https://fernandocejas.com/2015/07/18/architecting-android-the-evolution/) suggests that best practice is to place thread information in layer above and not in Presenter.

**[Q4](https://youtu.be/1ZOiT09UDfE?t=1758). MVP: Passing new BookRepository() from Activity to presenter, isn't it wrong according to MVP?**

**Ans:** Will be fixed in next epiosde using Dagger

**[Q5](https://youtu.be/1ZOiT09UDfE?t=1913). RxJava: Which thread should be used to perform .map operation?**

**Ans:** Depends on scenerio

**[Q6](https://youtu.be/1ZOiT09UDfE?t=2882). RxJava: Never place obseverOn and subscribeOn inside presenter**

**Ans:** Instead of passing 1 thread from constructor (observeOn) and hardcoding 2nd thread (subscribeOn), use [compose](http://blog.danlew.net/2015/03/02/dont-break-the-chain/)


Apk
----
Apk is avaiable at [/!shanraisshan/](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/tree/master/Episode9/!shanraisshan)

![episode5-apk](https://github.com/shanraisshan/Refactoring-Android-App-Series-Overview/blob/master/Episode9/!shanraisshan/E9.png)

Episode Link
----
Episode 9 - [Refactoring an Android App - #9 - Audience Questions](https://youtu.be/1ZOiT09UDfE)

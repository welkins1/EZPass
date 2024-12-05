# EZPass

This is a program that I created to generate strong passwords with ease. I got frustrated with always having to think of passwords or visit a website to create a password that meets a specific password complexity requirement, so I decided to make EZPass, which allows a user to generate a complex password quickly from a terminal.

I had a lot of fun working on this project and learned a couple of things throughout its development. I used many methods to speed up and simplify the coding, as well as many for loops to change the output of the password, which is a printed array.

I also completed the bulk of this program on my phone using an app called CodeBrew, a Java IDE that doesn't require underlying software on your phone or internet access. I thought it was pretty neat, and while I code faster on my computer, it wasn't too much of an adjustment coding on my phone. In fact, that's why I created the randomInt methods: I couldn't use as many shortcuts as I would with Apache NetBeans, for example.

The only hiccup I had while coding this program was implementing the quit function for the inputCheck() method used to determine the password size. I originally had the method return a regular Int without it having to be parsed, but this approach didn't work well for me when validating the input. Even after I made the switch, I was running into problems with the quit conditional statement being skipped over within the user input, and I had to settle with adding a try-catch block. I tried to avoid adding that because it looks clunky, but it was the best thing I could figure out then.

Even with that "minor" hiccup, I still enjoyed making this program. I'm currently working on EZPass2, which can be invoked directly from the command line using the main method within String args[]. My goal is to make it so a user could just type something like java EZPass2 15 x x x x and generate a strong password with specific parameters in the blink of an eye.

# ⚙️ Setup 
You can run this program by downloading the .java file and running java ```EZPass.java``` in the directory where you installed it. 

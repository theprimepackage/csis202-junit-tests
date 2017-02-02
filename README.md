# Welcome the CSIS202 JUnit Test Repo!

Here is where we will collaboratively create JUnit tests descriptive we can test our programs before submission.
Ideally this will ensure that our classes will be essential flawless.

## Getting Started
- First you need to make sure that JUnit5 is installed and configured in your IDE
- Then go and download the hamcrest library from [hereasily- Once it is downloaded extract the hamcrest zip file. Then move the extracted zip file into your Intellij program folder
- Then to import the module to your Intellij library follow the steps [here][2]. Import the hamcrest-all-1.3.jar file

## Cloning this repo
Create a folder in the directory where you are creating your programs. I recommand making one big directory that holds every CSIS202 program and then grouping the multifile programs into subdirectories. This eliminates the need to create a new project for every program, as well as, having to reclone the repo, as the repo must be in the same directory as the program that you are testing.

Once you have a folder for the unit test repo, for instance "CSIS202-JUnit-tests", go to the folder in windows explorer. Then hold shift and right click somewhere in the folder. In the menu that pops up there should be an option that says "Git bash here". Click that and then issue the following commands (this assumes that you already have git installed. If not see **Installing Git**).

- `git clone https://github.com/theprimepackage/csis202-junit-tests.git`
- `git config --global user.name "[Your Name]"`
- `git config --global user.email "[Your email]@georgefox.edu"`

## Installing Git
- To install git first download it from [here][3].
- Then run it. In the installation window after the GNU General Public License page, make sure that under Windows Explorer integration that "Git Bash Here" is checked. 
- Click Next. Then choose whether to run it from Git Bash (Basically a terminal window like in linux) only or from the Windows Command Prompt as well. I personal like to have both options. 
- Click Next. You can read this section about line endings but I just move along. 
- Click Next. Yes use MinTTy&mdash;its a pretty terminal emulator.
- Click Next.
- Click Next. Install the difftool if you want. It is use to compare the differences between two files (I believe) I haven't used it before
- Click Install. Finally...

## Important note about using git
When editing a file in the repo, **make sure that you always push changes when done editing the file!!!**
If you do not do this and someone else comes onto the repo and makes changes to the same file, when you go to push your changes the 
files will not match and will result in a merge conflict. To avoid this please follow the steps outlined below (See **Basic Usage**).

## Basic Usage
- You have just sat down and are ready to code some unit tests so you open IntelliJ and start to writing some&mdash;**STOP!!** Forever stop this. **Never ever do this!** The first thing that you do before writing *any* code is to run:
```
git pull
```
- Now you may begin editing the files within the repo. 
- You finally decide to call it quits. You just wrote over 150 unit tests and decide that will suffice for now. Your buddy says "Hey man lets grab some grub!" Nothing would please your fatigued brain more. And so you get up to leave your computer and&mdash;**NO!! DO NOT DARE!!!** You *must must must* first commit your changes. To do so please issue the following commands *whenever* you are done editing the file:

```
git commit -a -m "[Enter a very descriptive commit message here]"
```
Note: the `-a` flag is to add all changes to be staged for committing.
- That is basically it. If you would like a really simple yet informative overview, or if you are **unsure about anything**, please refer to this lovely [git guide][4]
- Branching is very useful so definitely learn up on that.

## JUnit Testing
Here are some links to helpful websites about JUnit Testing.
- One of my favorite references for JUnit testing. I go here often: http://www.vogella.com/tutorials/JUnit/article.html
- A *very* brief overview of some of Hamcrest's capabilities: https://github.com/junit-team/junit4/wiki/Matchers-and-assertthat
- Yesss Vogella tutorial on Hamcrest!! I love vogella&mdash;http://www.vogella.com/tutorials/Hamcrest/article.html

### Running JUnit Test
In IntelliJ it is rather simple. Just click on the class name of the test (i.e. `CarTest`). Then hit alt-enter to and select run test. 

[1]: https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/hamcrest/hamcrest-1.3.zip
[2]: http://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project/#answer-32853178
[3]: http://git-scm.com/download/win
[4]: http://rogerdudler.github.io/git-guide/

# Style Guide
We want to be uniform (cookie cutter) in formatting our Unit Tests. Thus, please follow the rules outlined in this section.

- NOTE: **Please comment!!** Some tests need explanation. They don't have to be javadoc just simple comments. Thanks!!

```java
class CarTest {

    @Test
    void instantiatesWithFullTank() // Make sure method names are very descriptive don't be afraid to make them long
    {
        Car car = new Car(20, 50, 3000); // Let us instantiate a new object per test, that way we ensure the tests don't interfere
        Assertions.assertEquals(50, car.getGasInTank()); //One Assertion per test. That way we can easily tell what broke
    }
    
}
```



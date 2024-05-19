# Project Name - sirisha129-ME_QA_FLIPKART

## Project Name and Description:
FlipKart Automation , Automate the flipkart website and return the count of items with different Star ratings, Prices and number of Reviews.

## Installation Instructions:
setUp a local Environment,for that you need 
1. IDE(of your choice,i used VSCode)
2. Java(Latest Version)
3. Gradle(Iam using a build tool called Gradle in my Project)
4. Git(Latest Version for clone,add,commit,push and change the code)
5. TestNG(get the Latest version from MVNrepository) and check the attachment below
6. Under Test Folder u need to Create Resources Folder
7. Create testng.xml and provide your class path

> Example:
```
# java version 17 
java --version
# Gradle version 8.6
gradle --version
# Git 2.44
git --version
#VSCode 1.89.1
code --version
#TestNG 6.14.3
Add dependeny into build.gradle
```

## Usage and Examples:
Iam providing some scenarios to showcase how the project works.
1. Go to www.flipkart.com. Search for “Washing Machine” and click on search .
   Sort by popularity and print the count of items with rating less than or equal to 4 stars.
   My Print statements gives clear Output on how many <= 4star ratings products are there particular to the FIrst Page only.

2. Next Search for “iPhone”, print the Titles and discount % of items with more than 17% discount.
   Here iam printing the Tittles along with discount % above 17%.

3. Lastly Search for “Coffee Mug”, select 4 stars and above, and print the Title and image URL of the 5 
   items with highest number of reviews.
   Here iam showing my log statements with the Top 5 highest reveiws(ex: 6543) you will see Titles and ImageURLs.

TestNG Instructions:
1. I also want to tell, Follow TestNG setup folder structure into your 'build.gradle' is important to run your Unit Testacses,so please follow the Link which is under Important Links.
In breif: 
1. Add dependency of testNG (//https://mvnrepository.com/artifact/org.testng/testng/7.9.0
    testImplementation group: 'org.testng', name: 'testng', version: '6.14.3')
2. cretae a test task like this (test{})
3. Inside test  give useTestNG() {provide your testng.xml path}
4. make sure to save your build or refresh the build.
5. IMPORTANT( when u create a unit test file u will easily annotate using testNG annotations,if not ur testNG setup or xml is having issue.)


> Example:
```
# to run the project
./gradlew clean test
```

## Important Links:
Details about checklist to set up your project in Local,follow these:
https://docs.google.com/spreadsheets/d/15uUgUlgdKQS-QhhZOhwukZU1lGAUbtcYDDX4WDOqu_A/edit#gid=0

This is a TestNG setup to do in your Project:
https://docs.google.com/document/d/1D6Gj7eLWDoCVPFf7RZiM-i1ghRDwx-b9VcFpkAKp9Ys/edit#heading=h.fy8vja196thb
 

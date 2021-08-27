Project Name : **uiautomation**

**Project Structure details**<br/>
pages(src/main/java) : This package is contains all the objects & subsequent methods related to one web page <br/>
utilities(src/main/java) : This package consist of opening browser, handling properties of configuration file & handling JSON data & all ui element interaction method <br/>
TestRunner(src/test/java/runner) : this package consist of TestRunner to run all testscripts<br/>
testScripts: This package contains test scripts<br/>
dataFiles(src/test/java/resources) : This folder contains JSON file which consist of expected message & search text file<br/>

**Executing Scripts**<br/>
we can run through TestRunner Class using "Run as Junit"<br/>
we can run through cmd as well using command "_mvn test_"<br/>
we can run through cmd as well using command "_mvn site_"<br/>
if we want to create a report for the junit we need to run it as "**_mvn site_**"<br/>

Guide to run test script:
Setup environment:
- Install FireFox (since I'm using FirefoxDriver)
- Install Java (I'm using Java 13.0.1, not sure the older version can execute successfully.)
- Install Maven and add Maven to System variable (I'm using Maven 3.6.3)

Execute test:
- Open Cmd, cd to {your_local_parrent_folder}\karros_web_ui_test\web_ui_test (folder which file pom.xml stored)
- Run cmd: mvn clean test
Because I fix the test suite xml file in pom.xml, so you don't need to pass the test file xml here.

Note:
- Because this is the sample script, I set the params directly in test script. If in the real project, the params should be defined in a separate xml file. Then we will pass the params to test script from xml data file.
- I'm not using logging there (log info, log pass, log fail...), just using print method of Java to print console log. If in the real project, I'll use a logging library to print test log.

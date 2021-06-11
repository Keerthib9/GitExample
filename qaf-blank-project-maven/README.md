# qaf-blank-project-maven

This is automation project skeleton to start with using MAVEN. Please refer [documentaion](https://qmetry.github.io/qaf/) for more help.


This is sample project with Maven directory structure:
 
The 'config' directory contains testng.xml file, and is a place holder for configuration files.

The 'resources' directory contains all required resources including properties files and data files, and is a place holder for other resources.

The 'src' directory contains all java files and is a place holder for other java files.

The 'test-results' directory contains result files.

The 'scenarios' directory is the default place holder for all the scenario files. 


To change/modify dependencies check pom.xml
To run the project, from command prompt go to project home and run mvn. Open dashboard.htm to view results.

Note: This sample project uses chrome driver and it requires chrome driver binary.
You need to download and set webdriver.chrome.driver property in application.properties file with driver binary path.

Please refer https://qmetry.github.io/qaf/ 
Thanks,
QAS Team.



Java API configuration 
JDK
Version: Java SE Development Kit 11 (recommended)
Download link:
 https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

Maven
Version: apache-maven-3.6.0
Download link: 
https://archive.apache.org/dist/maven/maven-3/3.6.0/binaries/

System setting steps
1): download and install JDK
2): go to This PC 
3):  right click and select properties 
4): click into advanced system setting
5): click into environment variable
6): add JAVA_HOME and M2_HOME 
  Exp: variable name:  JAVA_HOME variable value: C:\Program Files\Java\jdk-11.0.11
  Exp: variable name:  M2_HOME 
  variable value: C:\Program Files\Apache Maven Foundation\apache-maven-3.6.0
 7): add system path below arguments
%JAVA_HOME%\bin 
 %JAVA_HOME%\bin
 

Editor
Eclipse IDE (Recommended)
Version:  2020-09 (4.17.0)
Download link: 
https://www.eclipse.org/downloads/packages/release/2020-09/r


JAVA HTTP Client
Dependency:
Not required for JDK11, 
Preferred documents link:
https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html
http://openjdk.java.net/groups/net/httpclient/recipes.html


JSON Data Parser
Dependency:
<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
<dependency>
<groupId>com.googlecode.json-simple</groupId>
<artifactId>json-simple</artifactId>
<version>1.1.1</version>
</dependency>


TestNG 
Version: 6.10.0
<! -- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>6.10</version>
    <scope>test</scope>
</dependency>


Note: the configuration documents prepared based on windows 10 OS.






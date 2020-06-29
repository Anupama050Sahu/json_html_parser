 ## Jsoup: Java HTML Parser
***
### HTML TO JSON PARSER
***
### Overview:
    This script is used to parse an input html file and generate the output.json based on some criteria.
## Getting Started
***
1.[Clone the repository  uri ]() the latest **Jsoup** jar(or add it to your Maven)
### Enviromental SetUp
***
System must have configured with [JAVA]() [JRE]().

##  Dependencies
  ```maven
    <dependencies>
<dependency>
     <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.12.1</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.10.2</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.10.2</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.10.2</version>
</dependency>  
</dependencies>
```

## Procedure
***
1.*Application Build Procedure*:
*** 
Use the following **Command** to build the Application:

1)Go to the Html_to_Jsoup Project root Directory using **Shell Script** or **Command Prompt** and use the following Command.

## Syntax
  ```maven
     mvn clean install
```
2.*Application Run Procedure*:

 Using the Command Prompt go to the Application root Directory and find the target directory and from that directory use the following **Syntax**
## Syntax
    java -jar  Html_jsoup_parse.jar 
   
   	provide the path of html file

   3.After Sucessful execution of the Application it will generate [Output.json]() under the Application directory.
       




   
















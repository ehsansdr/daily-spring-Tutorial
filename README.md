# **here we have my journey of learning Spring boot**

_after adding by copy pasting press maven icon on top right of pom.xml file to download that_


## first we created these dependencies :

### 1. spring web

### 2. spring boot Devtool

### 3. h2                    : for dgl

### 4. jpa                   : for data base  (instal plugin : Jakarta EE: Persistence ​(JPA))

### 5. validation     

### 6. lombok 
(but I added it by adding external library .jar)
(add 
<Bulid> <plugings> ... <plugings> <Bulid>
part too if you want to add this by dependency and you can copy past that from pom.xml or start.spring site)

### 7. mysql                   

#####  (but i write it by myself) [https://spring.io/guides/gs/accessing-data-mysql/](https://spring.io/guides/gs/accessing-data-mysql/)   
##### "Convert YAML and Properties file" plugin is installed
##### I use this site to convert the properties to yml format :https://www.javainuse.com/app2yaml
##### MAKE SURE YOU DON'T HAVE ANOTHER yml OR .properties FORMAT FILE IT CHANGE THE FILE FORMAT AND THE STRUCTURE
##### and you lose your comments when you use that plugin
     
### 8. actuator                   
if you want to monitor your  application    
or if you want to know how your application performing   
or if you want to how particular application healthy   
or what are different beans created    
or what are different objects created    
use this dependency    

### postgresql : (for sql data base i think)
and  if it works correctly you see this in your console:
###### Exposing 1 endpoint(s) beneath base path '/actuator'
and add the path to the end of *localhost:(yourp port)/actuator*   

************************************************************************************************************************
use this in application.properties ti change th port:

    server.port = 800 

if you want to change  the server port in application.yml use this format
    `server:
      port: 800`
************************************************************************************************************************

# **annotations Hint**



* if you use annotation it means you  add all its local annotations 


* instead of adding **@Component** and below that **@controller**
you can have only **@controller** 
because
in **@controller** annotation class **@controller** have **@component** and by just adding **@controller** you add its pre-defined
annotation like @Component




### **@RestController**  

is annotation and if you open that by ctrl+click you see these annotations
so you can create rest API
**@Target(ElementType.TYPE)**  
**@Retention(RetentionPolicy.RUNTIME)**  
**@Documented**   
**@Controller**   
**@ResponseBody**     

* of curse, we don't see @Component but in last example we said **@Controller** has **@component** so
by declaring **@RestController** we have its local annotation and ANNOTATION OF ITS LOCAL ANNOTATIONS





### **@RequestMapping(value = "/e",method = RequestMethod.GET)**
is annotation that is used to have Get operation in bakend

####   value = "/(your defined path)" , method = RequestMethod.GET / POST / DELETE / HEAD / PUT / ...

for having GET you can use 
@GetMapping"/(your defined path)" == @RequestMapping(value = "/e",method = RequestMethod.GET)
@PostMapping"/(your defined path)" == @RequestMapping(value = "/e",method = RequestMethod.POSt)
...    


### **@Component**   
//if you want to have this class as component have this annotation
be careful if you want to scan this by special class add **@ComponentScan** to that class

### **@Entity**
this annotaion let this class contract with jpa and can contact with database

### **@Autowired**
this attaches to the particular reference

### **@RequestBody**
Default is true, leading to an exception thrown in case there is nobody content.
Switch this to false if you prefer null to be passed when the body content is null.
without this we should to lots of thing manually but with this json object return to department automatically


### **@PathVariable**
if you want to get some value not in local code text of your local code editor anything else
and you want to get value from link of http or from for example searching in browser 
or insomnia or postman you can declare that in the link in  `{}` and your program 
inform it is special like `"/d/d/{id}"` in this example `d\d\` is not special but 
becuase we store id in `{id}` we can get the value that search in the link
 if you want to get put the value in variable in code and program use the before declaring 
parameter:      
`public void putMapping(@PathVariable("id") Integer id){`
and the value as id store in your parameter of method and you can use that


************************************************************************************************************************
# DATABASE HINT:
#### you can do your database settings in to format files:
* ##### .properties
* ##### .yml

###### but be careful about how code forming you should use for them

### **h2 database** 
in  
#### **.properties**:

    spring.h2.console.enabled=true
    spring.datasource.url=jdbc:h2:mem:dcbapp
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sdr
    spring.datasource.password=1235
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

if you see :   
_Initialized JPA EntityManagerFactory for persistence unit 'default'_   
it means it created 
not 
_No JTA platform available on top of that_   
search and be careful about site title check this 



### **search : http://localhost:(yourPort)/h2-console**   

#### **be careful about this option that you see**
###### Saved Settings: Generic H2 (Server)    
###### Setting Name:    Generic H2 (Server)    
###### Driver Class: org.h2.Driver //or maybe base on your codes up here   
###### JDBC URL:     jdbc:h2:mem:dcbapp    
###### User Name:   (u t define that)    
###### Password:    (u t define that)   



### **h2 database**
in
#### **.yml**:


**be careful about incidentals**  

    spring:        
      profile: qa         
      datasource:        
        driverClassName: org.h2.Driver       
        password: 1235        
        url: jdbc:h2:mem:dcbapp-qa       
        username: sdr      
      h2:      
        console:     
          enabled: true      
      jpa:      
        database-platform: org.hibernate.dialect.H2Dialect



### **sql database**
in
#### **.properties**:


**you can check this link and copy paste the pure code from this link:**    
#### **https://spring.io/guides/gs/accessing-data-mysql/**

    spring.jpa.hibernate.ddl-auto=update     
    spring.datasource.url=jdbc:mysql://localhost:3306/dcbapp     
    spring.datasource.username=root    
    spring.datasource.password=admin    
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver 


### **sql database**
in
#### **.yml**:

    spring:
      profile: dev
      datasource:
        driver-class-name: com.mysql.jdbc.Driver
        password: admin
        url: jdbc:mysql://localhost:3306/dcbapp
        username: root
      jpa:
        hibernate:
          ddl-auto: update
        show-sql: true

###### but it is not working for me 


************************************************************************************************************************

## **problem solution :**

************************************************************************************************************************
if you want to use plugin of java and it doesn't work check `pom.xml`
and in the text find this part (maybe parent part):

    <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.1.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
    </parent>

#### and remove `.RELEASE` from `<version>3.2.1.RELEASE</version>` to have this :

    <parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.2.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

and refresh maven by top right icon and let intellij to it work and after moment 
you have your perfect spring app 


## how to add dependency:

https://www.jetbrains.com/help/idea/spring-support.html

in `pom.xml` alt + insert in widows ot right click and click on generate to have generate frame:

<img alt="img_1.png" src="img_1.png" width="350"/>

chose `add dependency` and find your dependency on the opened part in bottom

and search your dependency there

![img_3.png](img_3.png)


then after finding the dependency click add to add your dependency in your `pom.xml`

![img_4.png](img_4.png)

and done!!!

************************************************************************************************************************
i had error in my pom.xml file with

    <build>
        <plugins>
            <plugin>
                     <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                </plugin>
        </plugins>
    </build>

so I add
    
    <version>${project.parent.version}</version>

in that so ia have this:

    <build>
    		<plugins>
    			<plugin>
	    			<groupId>org.springframework.boot</groupId>
	    			<artifactId>spring-boot-maven-plugin</artifactId>
	    			<version>${project.parent.version}</version>
	    		</plugin>
	    	</plugins>
	    </build>

but it fixed and i don't know how

********************************
**for activating runtime and parallel execution do this:**     
For IntelliJ IDEA 12+ releases we can build automatically the edited sources if we are using    
the external compiler option. The only thing needed is to check the option "Build project   
automatically", located under "Compiler" settings:

<img alt="img.png" height="480" src="pics/img.png" width="720"/>


Also, if you would like to hot deploy, while the application is running or 
if you are using spring boot devtools you should enable the compiler.automake.allow.when.app.running from registry too. This will automatically compile your changes.

For versions greater than 2021.2, we need check 'Allow auto-make t o 
start even id the development application is currently running' option:

<img alt="img_1.png" height="480" src="pics/img_1.png" width="720"/>

and 

for old version use this:
<img alt="img_2.png" height="480" src="pics/img_2.png" width="720"/>


solution of this in :
https://stackoverflow.com/questions/12744303/intellij-idea-java-classes-not-auto-compiling-on-save




********************************

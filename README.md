**here we have my journey of learning Spring boot**

first we created dependencies :
1. spring web
2. spring boot Devtool
3. h2 : for dgl
4. jpa : for data base


************************************************************************************************************************

**annotations Hint**



* if you use annotation it means you  add all its local annotations 


* instead of adding **@Component** and below that **@controller**
you can have only **@controller** 
because
in **@controller** annotation class @controller have **@component** and by just adding **@controller** you add its pre-defined
annotation like @Component




* **@RestController** is annotation and if you open that by ctrl+click you see these annotations

@Target(ElementType.TYPE)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented   
@Controller   
@ResponseBody     

* of curse, we don't see @Component but in last example we said **@Controller** has **@component** so
by declaring **@RestController** we have its local annotation and ANNOTATION OF ITS LOCAL ANNOTATIONS





* @RequestMapping(value = "/e",method = RequestMethod.GET) is annotation that is used to have Get operation in bakend
  value = "/(your defined path)" , method = RequestMethod.GET / POST / DELETE / HEAD / PUT / ...
for having GET you can use 
@GetMapping"/(your defined path)" == @RequestMapping(value = "/e",method = RequestMethod.GET)
@PostMapping"/(your defined path)" == @RequestMapping(value = "/e",method = RequestMethod.POSt)
...







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


**@Component**   
//if you want to have this class as component have this annotation
be careful if you want to scan this by special class add **@ComponentScan** to that class
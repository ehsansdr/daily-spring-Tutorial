package demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
//@NoArgsConstructor//default constructor added
//@AllArgsConstructor//lombok create all args constructor
//@ToString

@Builder//prepare the builder that we use in DepartmentServiceTest class
//it used when ho multiple properties available  and you and to use different type properties



@Entity//this annotaion let this class contract with jpa and can contact with database
public class Department {/**   if you want to change the name that appear to table change here  */


    //all the database could have primary key and section exactly like this key
    //but we should define it for spring and at the data base table we have section that we define by
    //filed so:

    @Id//to amke primary key we need to annotate this for or field
    @GeneratedValue(strategy = GenerationType.AUTO)//created by itself by order of creation ,and it gets value automatically
    //but you declare entity and for using in database to should have use controller in
    private long departmentId;
    /*@Positive(message = "the number is not positive")//if you have this the number should be  > 0 else you get bad request
    //@PositiveOrZero(message = "the number is negative")//if you have this the number should be  >= 0 else you get bad request
    //@Negative
    @Positive*/
    private long departmentId2;
    /*@NotBlank(message = "information require")//if you don't want s.t not to be blank or empty use this
    //use this for String fields not for integer
    //and do some changes in @PostMapping methods because it checks in there*/
    /*
    //@Length(max = 8,min = 2,message = "Length is not allowed")//the length or number of character will check by this

    //@Size(max = 6,min = 2,message = "size is too short")//the length or number of character will check by this

    //@Email(message = "email is not ok")//if you have this and enter data not in Email format you will get bad request

    //@Future

    //@FutureOrPresent

    //@Past
    */
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    public Department(long departmentId, long departmentId2, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentId2 = departmentId2;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }
}

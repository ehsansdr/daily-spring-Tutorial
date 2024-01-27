package demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@ToString

@Entity//this annotaion let this class contract with jpa and can contact with database
public class Department {/**   if you want to change the name that appear to table change here  */


    //all the database could have primary key and section exactly like this key
    //but we should define it for spring and at the data base table we have section that we define by
    //filed so:

    @Id//to amke primary key we need to annotate this for or field
    @GeneratedValue(strategy = GenerationType.AUTO)//created
    //but you declare entity and for using in database to should have use controller in
    private long departmentId;
    private long departmentId2;
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

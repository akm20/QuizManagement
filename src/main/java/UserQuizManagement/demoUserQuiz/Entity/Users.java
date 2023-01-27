package UserQuizManagement.demoUserQuiz.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
//        (name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "user_email"))
public class Users {
    @GeneratedValue
    @Id
    private Long user_id;
    private String user_name;
    private String user_phone_no;
    @Column(name="user_email")
    private String userEmail;
    private String user_password;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date dob;

    private  Roles roles;
    // dob
//    @OneToMany
//    private Marks mark;
    public Users(){

    }

    public Users(Long user_id, String user_name, String user_phone_no, String userEmail,
                 String user_password, Date dob,Roles roles) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phone_no = user_phone_no;
        this.userEmail = userEmail;
        this.user_password = user_password;
        this.dob = dob;
        this.roles=roles;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone_no() {
        return user_phone_no;
    }

    public void setUser_phone_no(String user_phone_no) {
        this.user_phone_no = user_phone_no;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_phone_no='" + user_phone_no + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", user_password='" + user_password + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}


package UserQuizManagement.demoUserQuiz.Entity;

import javax.persistence.*;

@Entity
@Table
public class Users {
    @GeneratedValue
    @Id
    private Long user_id;
    private String user_name;
    private String user_phone_no;
    @Column(name="user_email")
    private String userEmail;
    private String user_password;
    // dob
//    @OneToMany
//    private Marks mark;

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

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_phone_no='" + user_phone_no + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}


package UserQuizManagement.demoUserQuiz.Utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScoreId implements Serializable  {
    private Long userId ;
    private Long subjectId ;

    //equals() && hashcode()

    public boolean equals(Object o ){
        if(this == o) return true ;
        if(o == null ) return false ;
        if(getClass() != o.getClass()) return false ;
        ScoreId thatId = (ScoreId) o ;

        return Objects.equals(this.userId,thatId.userId) && Objects.equals(subjectId,thatId.subjectId) ;

    }

    public int hashCode(){
        return Objects.hash(userId,subjectId) ;
    }

    @Override
    public String toString() {
        return "ScoreId{" +
                "userId=" + userId +
                ", subjectId=" + subjectId +
                '}';
    }
}

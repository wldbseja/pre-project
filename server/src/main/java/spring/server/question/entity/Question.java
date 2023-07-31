package spring.server.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.server.answer.entity.Answer;
import spring.server.audit.BaseEntity;
import spring.server.questionVote.entity.QuestionVote;
import spring.server.tag.entity.TagQuestion;
import spring.server.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "Question")
@Entity
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String title; //질문제목

    private String content; //질문내용

    @Column(nullable = false)
    private int questionViews; //조회수

    @Column(nullable = false)
    private int questionVotes;  //투표


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)  //태그와 n:n
    private List<TagQuestion> tagQuestions = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL) // 질문과 답변은 1:n
    private List<Answer> answers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "question")  //질문과 투표는 1:n
    private List<QuestionVote> questionVote = new ArrayList<>(); //투표

    @ManyToOne(fetch = FetchType.LAZY) //유저와 n:1
    @JoinColumn(name = "userID")
    private User user;
    //정렬위해 추가해봄
    @Column(nullable = false)
    private int answerCount = 0; // 답변 개수


    //여기까지

    //회원 닉네임 가져오기
    public String getUserName(){
        return user.getUserName();
    }

    //회원 회원id 가져오기
    public long getUserId(){
        return user.getUserId();
    }

    //회원 이미지 가져오기
    public String getImage() {
        return user.getUserImage();
    }

    //투표 개수 가져오기
    public int getVotes() {
        questionVotes = questionVote.stream()
                .mapToInt(questionVote -> questionVote.getQuestionVoteStatus() ? 1 : -1)
                .sum();
        return questionVotes;
    }

    //투표 가져오기
    public void setVotes(QuestionVote votes) {
        this.questionVote.add(votes);
        if(votes.getQuestion() != this){
            votes.setQuestion(this);
        }
    }

    //질문 개수 가져오기
    public int getAnswersCount(){
        return answers == null ? 0 : answers.size();
    }

    //댓글 정보 가져오기
    public void setAnswer(Answer answer){

        this.answers.add(answer);
        if(answer.getQuestion() != this){
            answer.setQuestion(this);
        }
    }

    //유저 정보 가져오기
    public void setUser(User user) {

        this.user = user;
        if(!this.user.getQuestions().contains(this)){
            this.user.getQuestions().add(this);
        }

    }

    // 조회수 증가해서 가져오기
    public void addViews(){
        this.questionViews++;
    }


    public String getUserEmail() {
        return user.getUserEmail();
    }

    public void setTagNames(List<String> tagNames) {
        
    }

    public void addAnswersCount() {
        answerCount += 1;
    }

    public void subtractAnswersCount() {
        answerCount -= 1;
    }
}




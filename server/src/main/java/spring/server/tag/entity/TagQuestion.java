package spring.server.tag.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.server.question.entity.Question;
import spring.server.user.entity.User;

import javax.persistence.*;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "TagQuestion")
public class TagQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagQuestingId;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

}

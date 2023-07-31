package spring.server.question.search;

import org.springframework.data.jpa.domain.Specification;
import spring.server.question.entity.Question;
import spring.server.tag.entity.Tag;
import spring.server.tag.entity.TagQuestion;

import javax.persistence.criteria.Join;

public class QuestionSpec {

    public static Specification like(String type, String keyword) {
        return (root, query, cb) -> cb.like(root.get(type), "%" + keyword + "%");
    }

//    public static Specification tagLike(String tag){
//        return (root, query, cb) -> cb.like(root.get("question"), "%" + tag + "%");
//    }

    public static Specification tagLike(String tag) {
        return (root, query, cb) -> {
            Join<Question, TagQuestion> tagQuestionJoin = root.join("tagQuestions");
            Join<TagQuestion, Tag> tagJoin = tagQuestionJoin.join("tag");
            return cb.like(tagJoin.get("tagName"), "%" + tag + "%");
        };
    }

}

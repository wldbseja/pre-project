package spring.server.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.server.tag.entity.TagQuestion;

import java.util.List;

@Repository
public interface TagQuestionRepository extends JpaRepository<TagQuestion, Long> {

    List<TagQuestion> findAllByQuestionQuestionId(Long questionId);
    @Query(value = "delete from TagQuestion t where t.question.questionId = :questionId")
    void deleteByQuestionId(Long questionId);

    @Query(value = "select tq from TagQuestion tq join fetch tq.tag where tq.question.questionId = :questionId")
    List<TagQuestion> findTagQuestions(Long questionId);
}

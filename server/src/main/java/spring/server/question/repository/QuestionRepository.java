package spring.server.question.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.server.answer.entity.Answer;
import spring.server.question.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByQuestionId(Long questionId);

    Page<Question> findAllByAnswerCount(int answerCount, Pageable pageable);

    Page<Question> findAll(Specification spec, Pageable pageable);

    @Query(value = "select q from Question q where q.answerCount > 0")
    Page<Question> findAllQuestionsAnswered(Pageable pageable);


}

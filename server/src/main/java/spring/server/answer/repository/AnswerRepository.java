package spring.server.answer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.server.answer.dto.AnswerResponseDto;
import spring.server.answer.entity.Answer;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "select a " +
            "from Answer a " +
            "join fetch a.user u " +
            "where a.question.questionId = :questionId "
    )
    List<Answer> findAllSorting(Long questionId, Sort sort);

    Optional<Answer> findByAnswerId(long answerId);


}

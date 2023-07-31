import React from 'react';
import styled from 'styled-components';

import Tag from './Tag';

function QuestionCard({ question }) {
  return (
    <QuestionCardSection>
      <QuestionCardLeft>
        <div>
          {question.votes}
          {' '}
          votes
        </div>
        <div>
          {question.answerCount}
          {' '}
          answers
        </div>
      </QuestionCardLeft>
      <QuestionCardRight>
        <QuestionCardTitle href={`/questions/${question.questionId}`}>
          {question.title}
        </QuestionCardTitle>
        <QuestionCardBody>{question.content}</QuestionCardBody>
        <QuestionCardTagList>
          {question.tagInfo.map((tag) => (
            <Tag key={tag.tagId} name={tag.tagName} />
          ))}
        </QuestionCardTagList>
        <QuestionCardInfo>
          {question.userInfo.userName}
          {' '}
          {question.createAt}
        </QuestionCardInfo>
      </QuestionCardRight>
    </QuestionCardSection>
  );
}

export default QuestionCard;

const QuestionCardSection = styled.section`
  width: 750px;
  padding: 16px;
  display: flex;
  border-bottom: 1px solid #dadada;
`;

const QuestionCardLeft = styled.section`
  width: 108px;
  text-align: right;
  font-size: small;
  padding-top: 2px;
`;

const QuestionCardRight = styled.section`
  width: 600px;
  margin-left: 16px;
`;

const QuestionCardTitle = styled.a`
  font-size: large;
  font-weight: 400;
  color: #0063BF;
  text-decoration: none;
`;

const QuestionCardBody = styled.div`
  font-size: small;
  font-weight:400;
  margin-bottom: 8px;
`;

const QuestionCardInfo = styled.section`
  text-align: right;
  font-size: x-small;
  cursor: pointer;
`;

const QuestionCardTagList = styled.section`
  display: flex;
`;

import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useSearchParams, useLocation } from 'react-router-dom';

import QuestionFilter from './QuestionFilter';

function QuestionTop({ totalQuestion }) {
  const [searchParams] = useSearchParams();
  const location = useLocation();
  const [title, setTitle] = useState('All Question');

  useEffect(() => {
    if (location.pathname === '/search') {
      setTitle('Search Results');
    }
  }, [location.pathname]);

  return (
    <QuestionTopSection>
      <Top>
        <div>
          <div>{title}</div>
          {title === 'Search Results' ? (
            <SearchContent>
              Results for
              {' '}
              {searchParams.get('q')}
            </SearchContent>
          ) : null}
        </div>
        <AskQuestion href="/questions/ask">Ask Question</AskQuestion>
      </Top>
      <Bottom>
        <div>
          {totalQuestion.toLocaleString('ko-KR')}
          {' '}
          questions
        </div>
        <QuestionFilter />
      </Bottom>
    </QuestionTopSection>
  );
}

export default QuestionTop;

const QuestionTopSection = styled.section`
  padding: 24px 16px 0 16px;
  width: 727px;
  border-bottom: 1px solid #d7dce0;
`;

const Top = styled.section`
  font-size: x-large;
  display: flex;
  justify-content: space-between;
  margin-bottom: 25px;
`;

const SearchContent = styled.div`
  font-size: 12px;
  margin-top: 10px;
`;

const AskQuestion = styled.a`
  color: white;
  background-color: #0A95FF;
  padding: 10.4px;
  font-size: small;
  border: 1px solid white;
  border-radius: 3px;
  box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  text-decoration: none;
`;

const Bottom = styled.section`
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
`;

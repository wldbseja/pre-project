import React from 'react';
import styled from 'styled-components';
import { useLocation, useSearchParams } from 'react-router-dom';

function QuestionFilter() {
  const location = useLocation();
  const [searchParams] = useSearchParams();
  const searchKeyword = searchParams.get('q');

  return (
    <section>
      <FilterBtn href={searchKeyword ? `${location.pathname}?q=${searchKeyword}&tab=newest` : `${location.pathname}?tab=newest`}>Newest</FilterBtn>
      <FilterBtn href={searchKeyword ? `${location.pathname}?q=${searchKeyword}&tab=answered` : `${location.pathname}?tab=answered`}>Answered</FilterBtn>
      <FilterBtn href={searchKeyword ? `${location.pathname}?q=${searchKeyword}&tab=unanswered` : `${location.pathname}?tab=unanswered`}>Unanswered</FilterBtn>
    </section>
  );
}

export default QuestionFilter;

const FilterBtn = styled.a`
  color: #3B4045;
  font-size: 13px;
  padding: 9.6px;
  text-decoration: none;
  border: 1px solid gray;
  border-radius: 3px;
  &: hover {
    background-color: #E3E6E8;
  }
`;

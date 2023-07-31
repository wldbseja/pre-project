import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';
import styled from 'styled-components';

function QuestionPagination({ pageInfo }) {
  const pageList = new Array(pageInfo.totalPages).fill(0);
  const location = useLocation();
  const [searchParams] = useSearchParams();
  const query = {
    tab: searchParams.get('tab') !== null ? searchParams.get('tab') : 'newest',
    q: searchParams.get('q') !== null ? searchParams.get('q') : '',
  };

  return (
    <PaginationSection>
      {pageList.map((_, pageNumber) => (
        <PageBox href={`${location.pathname}?page=${pageNumber + 1}${query.q && `&q=${query.q}`}&tab=${query.tab}`} key={pageNumber}>{pageNumber + 1}</PageBox>
      ))}
    </PaginationSection>
  );
}

export default QuestionPagination;

const PaginationSection = styled.section`
  display: flex;
  margin: 30px;
`;

const PageBox = styled.a`
  padding: 5px 8px;
  font-size: 13px;
  color: white;
  background-color: #F48225;
  border: 1px solid white;
  border-radius: 3px;
  text-decoration: none;
`;

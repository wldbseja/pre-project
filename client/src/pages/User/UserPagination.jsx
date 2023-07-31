import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';
import styled from 'styled-components';

function UserPagination() {
  const location = useLocation();
  const [searchParams] = useSearchParams();
  const query = {
    tab: searchParams.get('tab') !== null ? searchParams.get('tab') : 'newest',
    q: searchParams.get('q') !== null ? searchParams.get('q') : '',
  };

  return (
    <PaginationSection>
      <PageBox href={`${location.pathname}?page=1${query.q && `&q=${query.q}`}&tab=${query.tab}`}>1</PageBox>
      <PageBox href={`${location.pathname}?page=2${query.q && `&q=${query.q}`}&tab=${query.tab}`}>2</PageBox>
      <PageBox href={`${location.pathname}?page=3${query.q && `&q=${query.q}`}&tab=${query.tab}`}>3</PageBox>
      <PageBox href={`${location.pathname}?page=4${query.q && `&q=${query.q}`}&tab=${query.tab}`}>4</PageBox>
      <PageBox href={`${location.pathname}?page=5${query.q && `&q=${query.q}`}&tab=${query.tab}`}>5</PageBox>
    </PaginationSection>
  );
}

export default UserPagination;

const PaginationSection = styled.section`
  display: flex;
  margin: 30px;
  padding-top: 25px;
  justify-content: center;
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

/* eslint-disable react/no-array-index-key */
import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';
import { PageBox, PaginationSection } from '../../styles/Tags/TagPagination';

function TagPagination({ pageInfo }) {
  const pageList = new Array(pageInfo.totalPages).fill(0);
  const location = useLocation();
  const [searchParams] = useSearchParams();
  const query = {
    tab: searchParams.get('tab') !== null ? searchParams.get('tab') : 'popular',
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

export default TagPagination;

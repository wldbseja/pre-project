import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';

import { FilterBtn } from '../../styles/Tags/TagFilter';

function TagFilter() {
  const location = useLocation();
  const [searchParams] = useSearchParams();
  const searchKeyword = searchParams.get('q');

  return (
    <section>
      <FilterBtn href={searchKeyword ? `${location.pathname}?q=${searchKeyword}&tab=popular` : `${location.pathname}?tab=popular`}>Popular</FilterBtn>
      <FilterBtn href={searchKeyword ? `${location.pathname}?q=${searchKeyword}&tab=name` : `${location.pathname}?tab=name`}>Name</FilterBtn>
      <FilterBtn href={searchKeyword ? `${location.pathname}?q=${searchKeyword}&tab=new` : `${location.pathname}?tab=new`}>New</FilterBtn>
    </section>
  );
}

export default TagFilter;

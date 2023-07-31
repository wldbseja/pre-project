import React from 'react';
import styled from 'styled-components';

function UserTop() {
  return (
    <UserTopSection>
      <h1>Users</h1>
      <SearchFeature>
        <FilterTab>
          <SearchIcon />
          <input
            type="text"
            placeholder="Filter by member"
          />
        </FilterTab>
        <SortTab>
          <NewUser> New Users</NewUser>
          <OldUser> Old Users </OldUser>
        </SortTab>
      </SearchFeature>
    </UserTopSection>

  );
}

export default UserTop;

const UserTopSection = styled.section`
  display: block;
  padding: 30px 17px 50px 17px;
  margin: auto;
  margin-bottom: 40px;

`;

const SearchFeature = styled.div`
  display:flex;
  justify-content: space-between;
`;
const SearchIcon = styled.div`

`;
const FilterTab = styled.div`
  display:inline-flex;
`;
const SortTab = styled.button`
  display: flex;
  align-items: center;
  border: 1px solid;
  border-radius: 5px;
  background-color: white;
  font-size: 12px;
  padding: 10px 10px;
  cursor: pointer;
  color: grey;


`;
const NewUser = styled.div`
  border-right: 1px solid gray;
  background-color: white;
  padding: 3px;
  cursor: pointer;
  :hover {
    background-color: grey;
  }

`;
const OldUser = styled.div`
  cursor: pointer;
  padding: 3px;

`;

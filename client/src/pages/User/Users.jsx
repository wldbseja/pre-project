import React from 'react';
import styled from 'styled-components';

import UserCard from './UserCard';
import UserTop from './UserTop';
import { UsersData } from './data/data';
import UserPagination from './UserPagination';

function Users() {
  return (
    <UserSection>
      <UserTop />
      <UserGrid>
        {UsersData.users.map((user) => (
          <UserCard user={user} key={user.id} />
        ))}
      </UserGrid>
      <UserPagination />
    </UserSection>
  );
}

export default Users;

const UserSection = styled.section`
  display: block;
  padding: 30px 50px 60px 50px;
  margin: auto;
  width: 700px;

`;
const UserGrid = styled.div`
  display: grid;
  justify-content: center;
  align-items: center;
  grid-template-columns: repeat(3, minmax(0, 1fr));
  gap: 4em;
`;

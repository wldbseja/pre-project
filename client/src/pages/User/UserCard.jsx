import React from 'react';
import styled from 'styled-components';

function UserCard({ user }) {
  return (
    <UserBrowse>
      <UsersStyled>
        <UserImage href={`/users/${user.id}/${user.name}`}>
          <img src={user.img} alt="UserImage" width={50} height={50} />
        </UserImage>
        <UserInfo>
          <UserName href={`/users/${user.id}`}>
            {user.name}
          </UserName>
          <UserEmail>
            {user.email}
          </UserEmail>
        </UserInfo>
      </UsersStyled>
    </UserBrowse>
  );
}

export default UserCard;

const UserBrowse = styled.section`
  display:flex;
  padding: 10px;
`;

const UsersStyled = styled.div`
  display:flex;

`;
const UserImage = styled.a`
  display:flex;
  border-radius: 40px;
  > img {
  border-radius: 5px;
  }
`;
const UserInfo = styled.div`
  display:flex;
  flex-direction: column;
  margin-left: 10px;

`;
const UserName = styled.a`
  display:flex;
  flex:1;
  font-weight: 500;
  text-decoration:none;
`;
const UserEmail = styled.div`
  display:flex;
  align-items: end;
  flex:1;
  font-size: 0.8em;

`;

import React from 'react';
import styled from 'styled-components';
import { useParams } from 'react-router-dom';

import { UsersData } from './data/data';
import { QuestionsData } from '../../dummyData/questionData';
import QuestionCard from '../../components/Questions/QuestionCard';

function UserProfile() {
  const { id } = useParams();
  const user = UsersData.users.find((user) => user.id === parseInt(id, 10));
  return (
    <UserProfileSection>
      <UserProfileTop>
        <UserImage href={`/users/${user.id}/${user.name}`}>
          <img src={user.img} alt="UserImage" width={100} height={100} />
        </UserImage>
        <UserInfo>
          <UserName>
            {user.name}
            <EditButton href={`/users/${user.id}/${user.name}`}>
              📝
            </EditButton>
          </UserName>
          <UserEmail>
            {user.email}
          </UserEmail>
        </UserInfo>
      </UserProfileTop>
      <TitleElement>Questions</TitleElement>
      <UserQuestions>
        {QuestionsData.results.map((question) => (
          <QuestionCard question={question} key={question.id} />
        ))}
      </UserQuestions>

    </UserProfileSection>
  );
}

export default UserProfile;

const UserProfileSection = styled.section`
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
`;

const UserProfileTop = styled.div`
display: flex;
width: 700px;
margin-top: 50px;
margin-bottom: 50px;

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
  font-size:25px;
  font-weight: 500;
  align-items: end;
  margin-left: 5px;
`;
const EditButton = styled.a`
  display:flex;
  margin-left: 15px;
  text-decoration:none
`;
const UserEmail = styled.div`
  display:flex;
  flex:1;
  font-size: 0.8em;
  margin-left: 5px;
`;

const UserQuestions = styled.div`

`;

const TitleElement = styled.div`
  font-size: 20px;
  font-weight:500;
  width: 600px;
`;

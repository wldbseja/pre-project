import React, { useState } from 'react';
import styled from 'styled-components';

function QuestionAsk() {
  const [form, setForm] = useState({});
  const url = import.meta.env.VITE_URL;
  const clientUrl = import.meta.env.VITE_CLIENT_DOMAIN;

  const onChangeHandler = (e) => {
    if (e.target.name === 'title') {
      const result = { ...form };
      result.title = e.target.value;
      setForm(result);
    } else if (e.target.name === 'content') {
      const result = { ...form };
      result.content = e.target.value;
      setForm(result);
    } else if (e.target.name === 'tagNames') {
      const result = { ...form };
      result.tagNames = e.target.value;
      result.tagNames = result.tagNames.split(' ');
      setForm(result);
    }
    console.log(form);
  };

  const askPost = () => {
    fetch(`${url}/questions/ask?userId=1`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'ngrok-skip-browser-warning': true,
      },
      body: JSON.stringify(form),
    })
      .then((res) => res.json())
      .then((json) => {
        window.location.href = `${clientUrl}/questions/${json.questionId}`;
      });
  };

  return (
    <QuestionAskSection>
      <AskContainer>
        <PageTitle>Review your question</PageTitle>
        <InputBox>
          <InputBoxTitle>Title</InputBoxTitle>
          <InputBoxEx>
            Be specific and imagine you’re asking a question to another person.
          </InputBoxEx>
          <Input type="text" name="title" onChange={onChangeHandler} />
        </InputBox>
        <InputBox>
          <InputBoxTitle>Body</InputBoxTitle>
          <InputBoxEx>
            The body of your question contains your problem details and results.
            Minimum 220 characters.
          </InputBoxEx>
          <TextArea name="content" onChange={onChangeHandler} />
        </InputBox>
        <InputBox>
          <InputBoxTitle>Tags</InputBoxTitle>
          <InputBoxEx>
            Add up to 5 tags to describe what your question is about.
            Start typing to see suggestions.
          </InputBoxEx>
          <Input type="text" name="tagNames" onChange={onChangeHandler} />
        </InputBox>
        <PostQuestion type="submit" onClick={askPost}>Post your question</PostQuestion>
      </AskContainer>
    </QuestionAskSection>
  );
}

export default QuestionAsk;

const QuestionAskSection = styled.section`
  height: 94vh;
  background-color: #f5f5f5;
  padding: 0 24px;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
`;

const AskContainer = styled.section`
  width: 70%;
  max-width: 600px;
`;

const PageTitle = styled.div`
  font-size: x-large;
  font-weight: 600;
  padding: 24px 0;
`;

const InputBox = styled.section`
  background-color: white;
  border: 1px solid #d8d8d8;
  border-radius: 3px;
  margin-bottom: 50px;
  padding: 24px;
`;

const InputBoxTitle = styled.div`
  font-weight: 600;
`;

const InputBoxEx = styled.div`
  font-size: 0.7rem;
  margin-top: 5px;
  margin-bottom: 10px;
`;

const Input = styled.input`
  width: 97%;
  padding: 7.8px;
`;

const TextArea = styled.textarea`
  width: 97%;
  height: 100px;
  padding: 7.8px;
`;

const PostQuestion = styled.button`
  color: white;
  background-color: #0A95FF;
  padding: 10.4px;
  font-size: small;
  border: 1px solid white;
  border-radius: 3px;
  box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  text-decoration: none;
  cursor: pointer;
`;

import styled from 'styled-components';

export const LoginSection = styled.section`
  min-height: 100vh;
  margin: 0% auto;
  background-color: #f1f2f3;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const LoginContainer = styled.div`
  min-width: 20%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
  margin-right: 30px;
`;
export const GoogleBtn = styled.button`
  width: 280px;
  height: 36px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: white;
  border-radius: 8px;
  border: 1px solid lightgray;
  margin-bottom: 20px;
  cursor: pointer;
  &:hover {
    background-color: lightgray;
  }
  box-shadow: 0 10px 25px rgb(0 0 0 / 5%),
    0 20px 48px rgb(0 0 0/5%),
    0 1px 4px rgb(0 0 0 / 10%);
`;

export const GoggleLogo = styled.div`
  display: flex;
  margin-right: 8px;
  > img {
    width: 20px;
  }
`;

export const LoginLogo = styled.img`
  padding: 10px;
  width: 50px;
  height: 50px;
  cursor: pointer;
`;

export const LoginForm = styled.form`
  width: 80%;
  padding: 20px;
  background-color: white;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  box-shadow: 0 10px 25px rgb(0 0 0 / 5%),
    0 20px 48px rgb(0 0 0/5%),
    0 1px 4px rgb(0 0 0 / 10%);
`;

export const FormInputLabel = styled.label`
  display: flex;
  flex-direction: column;
  margin-bottom: 5px;
  margin-top: 10px;

  h4 {
    margin: 0;
  }
`;

export const FormInput = styled.input`
  padding: 10px;
  width: calc(100% - 30px);
  border: solid 1px #0000003e;
  border-radius: 3px;
  font-size: 13px;
`;

export const FormRow = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const FormForgotPassword = styled.p`
  color: #007ac6;
  font-size: 11px;
  cursor:pointer;
`;

export const LoginButton = styled.button`
  margin-top: 10px;
  padding: 10px 5px;
  background-color: #009dff;
  border: solid 1px #009dff;
  border-radius: 5px;
  color: white;
  transition: 0.2s;
  cursor: pointer;
  font-size: 13px;
  font-weight: 500;

  &:hover {
    background-color: #018ce3;
  }
`;

export const SignupButton = styled.button`
  background-color: transparent;
  color: #007ac6;
  border: none;
  font-size: 13px;
  cursor: pointer;
`;

export const SignUpInfo = styled.p`
  font-size: 12px;
`;

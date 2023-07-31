import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import
{
  LoginSection,
  LoginContainer,
  LoginLogo,
  LoginForm,
  FormInputLabel,
  FormInput,
  FormRow,
  FormForgotPassword,
  LoginButton,
  SignupButton,
  SignUpInfo,
  GoogleBtn,
  GoggleLogo,
}
  from './StyledLogin';
import icon from '../../assets/login/StackoverflowLogo.svg';

function Login() {
  const [isSignup] = useState(false);
  const navigate = useNavigate();

  return (
    <LoginSection>
      <LoginContainer>
        {!isSignup && <LoginLogo src={icon} alt="stack overflow" onClick={() => navigate('/questions')} />}
        <GoogleBtn>
          <GoggleLogo>
            <img
              src="https://cdn-icons-png.flaticon.com/512/2991/2991148.png"
              alt="Googlelogo"
            />
          </GoggleLogo>
          Log in with Google
        </GoogleBtn>
        <LoginForm>
          <FormInputLabel htmlFor="email">
            <h4>Email</h4>
            <FormInput
              type="email"
              name="email"
              id="email"
            />
          </FormInputLabel>
          <FormInputLabel htmlFor="password">
            <FormRow>
              <h4>Password</h4>
              {!isSignup && <FormForgotPassword>Forgot password?</FormForgotPassword>}
            </FormRow>
            <FormInput
              type="password"
              name="password"
              id="password"
            />
          </FormInputLabel>
          <FormInputLabel />
          <LoginButton
            type="submit"
            className="login-btn"
          >
            {isSignup ? 'Signup' : 'Login'}
          </LoginButton>
        </LoginForm>
        <SignUpInfo>
          Dont have an account?
          <SignupButton
            type="button"
            className="signup-btn"
            onClick={() => navigate('/')}
          >
            Sign up
          </SignupButton>
        </SignUpInfo>
      </LoginContainer>
    </LoginSection>
  );
}

export default Login;

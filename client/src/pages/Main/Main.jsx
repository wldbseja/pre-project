import React from 'react';

import {
  MainBody,
  MainContain,
  AllSection,
  LeftSection,
  LeftTitle,
  LeftContents,
  LeftIconImg,
  GoogleSection,
  GoogleForm,
  GoogleIconImg,
  SignForm,
  SignInput,
  SignButton,
  BigTest,
  SmallTest,
} from '../../styles/Main/Main';
import QuestionIcon from '../../assets/main/QuestionIcon.png';
import VoteIcon from '../../assets/main/VoteIcon.png';
import FavoritesIcon from '../../assets/main/FavoritesIcon.png';
import BadgeIcon from '../../assets/main/BadgeIcon.png';
import GoogleIcon from '../../assets/main/GoogleIcon.png';

function Main() {
  return (
    <MainBody>
      <MainContain>
        <AllSection>
          <LeftTitle>Join the Stack Overflow community</LeftTitle>
          <LeftSection>
            <LeftIconImg src={QuestionIcon} />
            <LeftContents>Get unstuck — ask a question</LeftContents>
          </LeftSection>
          <LeftSection>
            <LeftIconImg src={VoteIcon} />
            <LeftContents>Unlock new privileges like voting and commenting</LeftContents>
          </LeftSection>
          <LeftSection>
            <LeftIconImg src={FavoritesIcon} />
            <LeftContents>Save your favorite questions, answers, watch tags, and more</LeftContents>
          </LeftSection>
          <LeftSection>
            <LeftIconImg src={BadgeIcon} />
            <LeftContents>Earn reputation and badges</LeftContents>
          </LeftSection>
          <LeftSection>
            <SmallTest>
              Collaborate and share knowledge
              with a private group for FREE.
            </SmallTest>
          </LeftSection>
        </AllSection>
        <AllSection>
          <GoogleSection>
            <GoogleForm>
              <GoogleIconImg src={GoogleIcon} />
              Sign up with Google
            </GoogleForm>
          </GoogleSection>
          <SignForm>
            <BigTest>Display name</BigTest>
            <SignInput />
            <BigTest>Email</BigTest>
            <SignInput />
            <BigTest>Password</BigTest>
            <SignInput />
            <SmallTest>
              Passwords must contain at least eight characters,
              including at least 1 letter and 1 number.
            </SmallTest>
            <SignButton>Sign up</SignButton>
            <SmallTest>
              By clicking “Sign up”, you agree to our terms of service and
              acknowledge that you have read and understand our privacy policy and code of conduct.
            </SmallTest>
          </SignForm>
        </AllSection>
      </MainContain>
    </MainBody>
  );
}

export default Main;

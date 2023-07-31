import React from 'react';
import styled from 'styled-components';
import { useLocation } from 'react-router-dom';
import OverflowLogo from '../../assets/login/StackoverflowLogo.svg';
import GithubLogo from '../../assets/login/GithubLogo.svg';
import NotionLogo from '../../assets/login/NotionLogo.svg';

function Footer() {
  const { pathname } = useLocation();
  if (pathname === '/') return null;
  if (pathname === '/login') return null;
  if (pathname === '/logout') return null;
  return (
    <FooterSection>
      <FooterWrapper>
        <FooterContent>
          <FooterLogo>
            <img src={OverflowLogo} alt="StackOverflow icon" />

          </FooterLogo>
          <Container>
            <StackOverflow>
              STACK OVERFLOW
            </StackOverflow>
            <Questions>
              Questions
            </Questions>
          </Container>
          <FooterLogo>
            <img src={GithubLogo} alt="Github icon" />

          </FooterLogo>
          <FooterLogo>
            <img src={NotionLogo} alt="Notion icon" />

          </FooterLogo>
        </FooterContent>
      </FooterWrapper>
    </FooterSection>
  );
}

export const FooterSection = styled.footer`
  position:relative;
  width:100%;
  height: 150px;
  background-color: #232629;
  display: flex;
`;
export const FooterWrapper = styled.div`
  color: white;
  margin: 0 auto;
  display:flex;
  justify-content:center;
  align-items:center;
`;

export const FooterContent = styled.div`
  display:flex;

`;
export const Container = styled.div`
  display:flex;
  flex-direction: column;
  margin-left: 20px ;
  height: 10px;
`;
export const StackOverflow = styled.div`
  font-weight: bold;
  font-size:13px;
`;
export const Questions = styled.div`
  font-size:12px;
`;

export const FooterLogo = styled.div`
margin-left: 15px;

  > img {
    width: 35px;
    cursor: pointer;
  }
`;

export default Footer;

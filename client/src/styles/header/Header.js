import styled from 'styled-components';

import HeaderLogo from '../../assets/header/HeaderLogo.png';
import SearchIcon from '../../assets/header/SearchIcon.png';

const HeaderBody = styled.div`
    height: 52px;
    display: flex;
    margin: 0 auto;
    align-items: center;
    text-align: center;

    border-top: 3px solid  #E5883E;
    border-bottom: 1px solid #D7D9DC;

    justify-content: center;
    position: sticky;
    top: 0;
    width: 100%;

    background-color: white;
`;

const HeaderSection = styled.a`
   margin-left: 10px;
`;

const HeaderMenuImg = styled.img`
    width: 35px;
    height: 35px;
    cursor: pointer;
`;

const HeaderLogoImg = styled.div`
    background-image: url(${HeaderLogo});
    background-size: 156px;
    width: 156px;
    height: 42px;  
    cursor: pointer;
`;

const InputSection = styled.div`
    position: relative ;
    align-items: center;
    display: flex;
    margin-left: 100px;
    margin-right: 100px;
    
`;

const HeaderSearchIconImg = styled.div`
    background-image: url(${SearchIcon});
    background-size: 20px;
    width: 20px;
    height: 20px;
    position: absolute ;
    margin-left: 20px;
    cursor: pointer;
`;

const HeaderSearchInput = styled.input`
    width: 600px;
    height: 30px;
    margin: 8px;
    padding-inline-start: 40px;

    border-radius: 4px;
    border-width: 1px;
    border: solid 1px rgba(0, 0, 0, 0.3);
    border-color: #D7D9DC;
`;

const HeaderLoginButton = styled.button`
  width: 68px;
  height: 35px;
  font-weight: 500;
  padding: 3px;
  flex-shrink: 0;
  cursor: pointer;

  border-style: solid;
  border-radius: 4px;
  border-width: 1px;
  border-color: #749BBD;

  &:hover{  
    background-color : #B2D3EC;
    }
  background-color: #E3ECF3;
  color:  #487299;
`;

const HeaderSignUpButton = styled.button`
  width: 68px;
  height: 35px;
  font-weight: 500;
  padding: 3px;
  flex-shrink: 0;
  cursor: pointer;

  border-style: solid;
  border-radius: 4px;
  border-width: 1px;
  border-color: #4393F7;
  
  &:hover{  
    background-color : #2E75AC;
    }
    background-color : #4393F7;
    color: white;
`;

export {
  HeaderBody,
  HeaderSection,
  HeaderMenuImg,
  HeaderLogoImg,
  InputSection,
  HeaderSearchIconImg,
  HeaderLoginButton,
  HeaderSignUpButton,
  HeaderSearchInput,
};

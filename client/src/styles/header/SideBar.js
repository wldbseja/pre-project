import styled from 'styled-components';

import WorldIcon from '../../assets/header/WorldIcon.png';

const SideBarBody = styled.ul`
  border-right: 1px solid #e0e0e0;
  display: flex;
  flex-direction: column;
  width: calc(25vw - 3.8vw);
  height: 100%;
  position: fixed;
  margin: 0;
  padding: 0;
  background-color: white;
  align-items: center;
  z-index: 2;
`;

const SideBarTopSection = styled.li`
  display: flex;
  margin-top: 80px;
  margin-bottom: 20px;
  font-size: 13px;
    color: #8C8C8C;
`;

const SideBarSection = styled.a`
  display: flex;
  text-decoration: none;
  width: calc(25vw - 4.1vw);
  height: 46px;
  align-items: center;
  justify-content: center;
  font-size: 16px;
  color: #8C8C8C;
  
  &:hover{  
    background-color : #D7D9DC;
    border-right: 5px solid #E5883E ;
    color: black;
    }
    cursor: pointer;
`;

const WorldIconImg = styled.div`
    background-image: url(${WorldIcon});
    background-size: 20px;
    height: 20px;
    width: 20px;
    margin-right: 19px;
    margin-left: 10px;

    &:hover{  
    color: black;
    }
`;

const SideBarText = styled.li`
    display: flex;
    margin-left: 18px;
`;

export {
  SideBarBody,
  WorldIconImg,
  SideBarTopSection,
  SideBarSection,
  SideBarText,
};

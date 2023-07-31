import styled from 'styled-components';

import WorldIcon from '../../assets/header/WorldIcon.png';

const DropDownBody = styled.ul`
    z-index: 3;
    height: 250px;
    width: 240px;
    position : absolute;
    background-color: white;
    top: 37px;
    left: auto;
    right: 1080px;
    padding: 0;
    box-shadow: 0 2px 3px rgba(0,0,0,0.12), 0 2px 2px rgba(0,0,0,0.24);`;

const DropDownSectionTop = styled.li`
    display: flex;
    height: 50px;
    justify-content: left;

    border-bottom: 0.5px solid rgba(0,0,0,0.1);
    background-color: white;

`;

const DropDownSection = styled.a`
    text-decoration: none;
    display: flex;
    height: 50px;
    justify-content: left;
    align-items: center;

    background-color: white;
    border-bottom: 0.5px solid rgba(0,0,0,0.1);

    &:hover{  
    background-color : #D7D9DC;
    border-right: 5px solid #E5883E ;
    }
    cursor: pointer;
`;

const DropDownTopText = styled.li`
    display: flex;
    height: 50px;
    justify-content: left;
    align-items: center;
    font-size: 11px;
    margin-left: 20px;
    margin-top: 14px;

    color: #8C8C8C;
`;

const DropDownText1 = styled.li`
    display: flex;
    height: 50px;
    width: 100%;
    justify-content: left;
    align-items: center;
    font-size: 14px;
    margin-left: 10px;

    color: #8C8C8C;
    &:hover{  
    color: black;
    }
`;

const DropDownText2 = styled.li`
    display: flex;
    height: 50px;
    width: 100%;
    justify-content: left;
    align-items: center;
    font-size: 14px;
    margin-left: 40px;

    color: #8C8C8C;
    &:hover{  
    color: black;
    }
`;

const WorldIconImg = styled.div`
    background-image: url(${WorldIcon});
    background-size: 19px;
    height: 19px;
    width: 23px;
    margin-left: 10px;
    &:hover{  
    color: black;
    }
`;

export {
  DropDownBody,
  DropDownSectionTop,
  DropDownTopText,
  DropDownSection,
  DropDownText1,
  DropDownText2,
  WorldIconImg,
};

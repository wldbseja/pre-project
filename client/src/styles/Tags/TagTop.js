import styled from 'styled-components';

import SearchIcon from '../../assets/header/SearchIcon.png';

const TagTopSection = styled.section`
  padding: 24px 20px 0 20px;
  width: 900px;
`;

const Top = styled.section`
  font-size: x-large;
  display: flex;
  flex-direction: column;
  margin-bottom: 10px;
  margin-left: 10px;
`;

const TopTitle = styled.div`
  font-size: 25px;
  margin-bottom: 25px;
`;

const TopContent = styled.div`
  font-size: 15px;
`;

const Bottom = styled.section`
  display: flex;
  align-items: center;
  justify-content: space-between;
  /* margin-top: 40px; */
`;

const InputSection = styled.div`
    align-items: center;
    margin-right: 400px
   
`;

const TagSearchInput = styled.input`
    background-image: url(${SearchIcon});
    background-size: 19px;
    background-position: 10px;
    background-repeat: no-repeat;
    width: 160px;
    height: 35px;
    margin: 8px;
    padding-inline-start: 40px;
    border-radius: 4px;
    border-width: 1px;
    border: solid 1px rgba(0, 0, 0, 0.3);
    border-color: #D7D9DC;
`;

export {
  TagTopSection, Top, TopTitle, TopContent, Bottom, InputSection, TagSearchInput,
};

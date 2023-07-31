import styled from 'styled-components';

const TagCardSection = styled.section`
  padding: 20px;
  margin: 10px;
  display: flex;
  flex-direction: column;
  border: 1px solid #dadada;
  border-radius: 4px;
  height: 160px;
`;

const TagCardTextTopBox = styled.section`
  display: flex;
  flex-direction: column;
  width: 210px;
  height: 140px;
  font-size: small;
  overflow: hidden;
`;

const TagCardTitle = styled.button`
    font-size: 12px;
    height: 25px;
    width: 70px;
    color: #487299;
    background-color: #E3ECF3;
    border: 0px;
    border-radius: 3px;
    cursor: pointer;
    &:hover{  
    background-color : #C7DCED;
    }

`;

const TagCardTopContent = styled.a`
    margin-top: 20px;
    font-size: small;
`;

const TagCardTextBottomBox = styled.section`
  display: flex;
  flex-direction: column;
  margin-top: 18px;
 

`;

const TagCardBottomContent = styled.div`
    font-size: 12px;
    color: #858C94;
`;

export {
  TagCardSection,
  TagCardTitle,
  TagCardTextTopBox,
  TagCardTopContent,
  TagCardTextBottomBox,
  TagCardBottomContent,
};

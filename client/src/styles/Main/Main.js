import styled from 'styled-components';

const MainBody = styled.div`
    display: flex;
    justify-content: center;
    height: 100vh;
    background-color: #F2F2F2;
`;

const MainContain = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: center;
    padding: 30px;
`;

const AllSection = styled.div`
    display: flex;
    flex-direction: column;
    margin: 0;
    padding: 0;
    font-size: 30px;
    justify-content: center;
`;

const LeftSection = styled.ul`
    display: flex;
    margin: 0;
    padding: 0;
    align-items: center;
    margin-bottom: 20px;
`;

const LeftTitle = styled.li`
    display: flex;
    font-size: 25px;
    justify-content: left;
    margin-bottom: 20px;
    margin-top: 150px;
`;

const LeftContents = styled.li`
    font-size: 14px;
    display: flex;
    margin-right: 50px;
`;

const LeftIconImg = styled.img`
    height: 28px;
    width: 28px;
    margin-right: 10px;
`;

const GoogleSection = styled.div`
    display: flex;
    position: relative;
    margin: 0;
    padding: 0;
    margin-bottom: 70px;
   
`;

const GoogleForm = styled.button`
    display: flex;
    position: absolute;
    justify-content: center;
    align-items: center;
    width: 340px;
    height: 45px;
    padding: 10px;

    border: 1px solid #D7D9DC;
    border-radius: 6px;

    &:hover{  
    background-color : #EDEFF0;
    }
    color: #585A5B;
    background-color: white;
    cursor: pointer;
`;

const GoogleIconImg = styled.img`
    height: 17px;
    width: 17px;
    margin-right: 6px;
`;

const SignForm = styled.div`
    height: 480px;
    width: 280px;
    display: flex;
    flex-direction: column;
    padding: 30px;

    border-radius: 6px;
    box-shadow: 0 5px 17px rgba(0,0,0,0.12);

    background-color: white;
`;

const SignInput = styled.input`
    width: 273px;
    height: 35px;
    margin-bottom: 13px;

    border: 1px solid #D7D9DC;
    border-radius: 4px;

    background-color: white;
`;

const SignButton = styled.button`
    width: 280px;
    height: 42px;
    margin-bottom: 20px;
    margin-top: 40px;

    border-color: #4393F7;
    border-radius: 4px;
    border: 1px solid #D7D9DC;
    
  
    &:hover{  
    background-color : #2E75AC;
    }
    background-color : #4393F7;
    color: white;
    cursor: pointer;
`;

const BigTest = styled.text`
    font-size: 15px;
    font-weight: 600;
    margin-bottom: 6px;
`;

const SmallTest = styled.text`
    font-size: 11px;
    margin-bottom: 10px;
    color: #585A5B;
`;

export {
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
};

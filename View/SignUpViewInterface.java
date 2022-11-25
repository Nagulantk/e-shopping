package View;

import Model.Enums;

public interface SignUpViewInterface
{
     String userNameInputting();
     long phoneNumberInputting();
     void genderMenu();
     Enums.Gender genderInputting();
     String emailInputting();
     String passwordInputting();
     long aadhaarNumberInputting();
     int houseNumberInputting();
     String streetNameInputting();
     String townNameInputting();
     String districtNameInputting();
     String stateNameInputting();
     int pinCodeInputting();
     void uniquePhoneNumberValidateResult();
     void signUpResult();
}

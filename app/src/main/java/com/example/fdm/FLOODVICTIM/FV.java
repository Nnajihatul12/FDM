package com.example.fdm.FLOODVICTIM;

public class FV {
    public String fullname, email, password;
    public String mPhoneString, mAgeString, mOccupationString, mIncomeString, mAddress1String, mAddress2String, gender, spinnerPostcodeString;
    public String mBabyString, mChildrenString, mTeenagerString, mAdultString, mElderlyString, mDisableString;
    //DONATION FORM 1
    public String mDryFoodString, mHygieneKitsString, mPortableWaterString, mMedicinesString, mAmbulanString, mBlanketString;
    //DONATION FORM 2
    public String mHouseCleaningString, mPowerbankString, mFoodWaterString, mInfrastructureString, mCashString, mElectricalString;
    //DONATION FORM 3
    public String mRiceString, mMilkString, mBiscuitString, mCandleString, mDiaperString;
    //DONATION FORM 4
    public String mHygieneString, mCleaningString, mFoodString, mMedicString, mClothesString;

    public FV(){

    }

    public FV(String fullname, String email, String password,
              String mPhoneString, String mAgeString, String mOccupationString, String mIncomeString, String mAddress1String, String mAddress2String, String gender, String spinnerPostcodeString,
              String mBabyString, String mChildrenString, String mTeenagerString, String mAdultString, String mElderlyString, String mDisableString,
              String mDryFoodString, String mHygieneKitsString, String mPortableWaterString, String mMedicinesString, String mAmbulanString, String mBlanketString,
              String mHouseCleaningString, String mPowerbankString, String mFoodWaterString, String mInfrastructureString, String mCashString, String mElectricalString,
              String mRiceString, String mMilkString, String mBiscuitString, String mCandleString, String mDiaperString,
              String mHygieneString, String mCleaningString, String mFoodString, String mMedicString, String mClothesString){
        this.fullname = fullname;
        this.email = email;
        this.password=password;

        //USERFORM
        this.mPhoneString = mPhoneString;
        this.mAgeString=mAgeString;
        this.mOccupationString=mOccupationString;
        this.mIncomeString=mIncomeString;
        this.mAddress1String=mAddress1String;
        this.mAddress2String=mAddress2String;
        this.gender=gender;
        this.spinnerPostcodeString=spinnerPostcodeString;
        
        //HOUSEHOLD 
        this.mBabyString = mBabyString;
        this.mChildrenString=mChildrenString;
        this.mTeenagerString=mTeenagerString;
        this.mAdultString=mAdultString;
        this.mElderlyString=mElderlyString;
        this.mDisableString=mDisableString;
       
        //DONATION FORM 1
        this.mDryFoodString = mDryFoodString;
        this.mHygieneKitsString=mHygieneKitsString;
        this.mPortableWaterString=mPortableWaterString;
        this.mMedicinesString=mMedicinesString;
        this.mAmbulanString=mAmbulanString;
        this.mBlanketString=mBlanketString;
        
        //DONATION FORM 2
        this.mHouseCleaningString = mHouseCleaningString;
        this.mPowerbankString=mPowerbankString;
        this.mFoodWaterString=mFoodWaterString;
        this.mInfrastructureString=mInfrastructureString;
        this.mCashString=mCashString;
        this.mElectricalString=mElectricalString;
        
        //DONATION FORM 3
        this.mRiceString=mRiceString;
        this.mMilkString=mMilkString;
        this.mBiscuitString=mBiscuitString;
        this.mCandleString=mCandleString;
        this.mDiaperString=mDiaperString;

        //DONATION FORM4
        this.mHygieneString=mHygieneString;
        this.mCleaningString=mCleaningString;
        this.mFoodString=mFoodString;
        this.mMedicString=mMedicString;
        this.mClothesString=mClothesString;

    

    }
    public String getFullname(){
        return fullname;
    }
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    // form 1

    public String getmPhoneString(){
        return mPhoneString;
    }
    public void setmPhoneString(String mPhoneString){
        this.mPhoneString=mPhoneString;
    }
    
    
    public String getmAgeString(){
        return mAgeString;
    }
    public void setmAgeString(String mAgeString)
    {
        this.mAgeString=mAgeString;
    }
    
    
    public String getmOccupationString()
    {
        return mOccupationString;
    }
    public void setmOccupationString(String mOccupationString)
    {
        this.mOccupationString=mOccupationString;
    }
    
    
    public String getmIncomeString(){
        return mIncomeString;
    }
    public void setmIncomeString(String mIncomeString){
        this.mIncomeString=mIncomeString;
    }
    
    
    public String getmAddress1String(){
        return mAddress1String;
    }
    public void setmAddress1String(String mAddress1String)
    {
        this.mAddress1String=mAddress1String;
    }
    
    
    public String getmAddress2String()
    {
        return mAddress2String;
    }
    public void setmAddress2String(String mAddress2String)
    {
        this.mAddress2String=mAddress2String;
    }
    
    
    public String getgender()
    {
        return gender;
    }
    public void setgender(String gender)
    {
        this.gender=gender;
    }
    
    
    public String getspinnerPostcodeString()
    {
        return spinnerPostcodeString;
    }
    public void setspinnerPostcodeString(String spinnerPostcodeString)
    {
        this.spinnerPostcodeString=spinnerPostcodeString;
    }
   

    //HOUSEHOLD

    public String getmBabyString()
    {
        return mBabyString;
    }
    public void setmBabyString(String mBabyString)
    {
        this.mBabyString=mBabyString;
    }
    
    
    public String getmChildrenString()
    {
        return mChildrenString;
    }
    public void setmChildrenString(String mChildrenString)
    {
        this.mChildrenString=mChildrenString;
    }
    
    
    public String getmTeenagerString()
    {
        return mTeenagerString;
    }
    public void setmTeenagerString(String mTeenagerString)
    {
        this.mTeenagerString=mTeenagerString;
    }
    
    
    public String getmAdultString()
    {
        return mAdultString;
    }
    public void setmAdultString(String mAdultString)
    {
        this.mAdultString=mAdultString;
    }
    
    
    public String getmElderlyString()
    {
        return mElderlyString;
    }
    public void setmElderlyString(String mElderlyString)
    {
        this.mElderlyString=mElderlyString;
    }
    
    
    public String getmDisableString()
    {
        return mDisableString;
    }
    public void setmDisableString(String mDisableString)
    {
        this.mDisableString=mDisableString;
    }
    

    //DONATION FORM 1

    public String getmDryFoodString()
    {
        return mDryFoodString;
    }
    public void setmDryFoodString(String mDryFoodString)
    {
        this.mDryFoodString=mDryFoodString;
    }
    
    
    public String getmHygieneKitsString()
    {
        return mHygieneKitsString;
    }
    public void setmHygieneKitsString(String mHygieneKitsString)
    {
        this.mHygieneKitsString=mHygieneKitsString;
    }
    
    
    public String getmPortableWaterString()
    {
        return mPortableWaterString;
    }
    public void setmPortableWaterString(String mPortableWaterString)
    {
        this.mPortableWaterString=mPortableWaterString;
    }
    
    
    public String getmMedicinesString()
    {
        return mMedicinesString;
    }
    public void setmMedicinesString(String mMedicinesString)
    {
        this.mMedicinesString=mMedicinesString;
    }
    
    
    public String getmAmbulanString()
    {
        return mAmbulanString;
    }
    public void setmAmbulanString(String mAmbulanString)
    {
        this.mAmbulanString=mAmbulanString;
    }
    
    
    public String getmBlanketString()
    {
        return mBlanketString;
    }
    public void setmBlanketString(String mBlanketString)
    {
        this.mBlanketString=mBlanketString;
    }
    
    
 //DONATION FORM2
    public String getmHouseCleaningString()
    {
        return mHouseCleaningString;
    }
    public void setmHouseCleaningString(String mHouseCleaningString)
    {
        this.mHouseCleaningString=mHouseCleaningString;
    }


    public String getmPowerbankString()
    {
        return mPowerbankString;
    }
    public void setmPowerbankString(String mPowerbankString)
    {
        this.mPowerbankString=mPowerbankString;
    }


    public String getmFoodWaterString()
    {
        return mFoodWaterString;
    }
    public void setmFoodWaterString(String mFoodWaterString)
    {
        this.mFoodWaterString=mFoodWaterString;
    }


    public String getmInfrastructureString()
    {
        return mInfrastructureString;
    }
    public void setmInfrastructureString(String mInfrastructureString)
    {
        this.mInfrastructureString=mInfrastructureString;
    }


    public String getmCashString()
    {
        return mCashString;
    }
    public void setmCashString(String mCashString)
    {
        this.mCashString=mCashString;
    }


    public String getmElectricalString()
    {
        return mElectricalString;
    }
    public void setmElectricalString(String mElectricalString)
    {
        this.mElectricalString=mElectricalString;
    }


    //DONATION FORM 3
    public String getmRiceString()
    {
        return mRiceString;
    }
    public void setmRiceString(String mRiceString)
    {
        this.mRiceString=mRiceString;
    }


    public String getmMilkString()
    {
        return mMilkString;
    }
    public void setmMilkString(String mMilkString)
    {
        this.mMilkString=mMilkString;
    }


    public String getmBiscuitString()
    {
        return mBiscuitString;
    }
    public void setmBiscuitString(String mBiscuitString)
    {
        this.mBiscuitString=mBiscuitString;
    }


    public String getmCandleString()
    {
        return mCandleString;
    }
    public void setmCandleString(String mCandleString)
    {
        this.mCandleString=mCandleString;
    }


    public String getmDiaperString()
    {
        return mDiaperString;
    }
    public void setmDiaperString(String mDiaperString)
    {
        this.mDiaperString=mDiaperString;
    }



    //DONATION FORM 4
    public String getmHygieneString()
    {
        return mHygieneString;
    }
    public void setmHygieneString(String mHygieneString)
    {
        this.mHygieneString=mHygieneString;
    }


    public String getmCleaningString()
    {
        return mCleaningString;
    }
    public void setmCleaningString(String mCleaningString)
    {
        this.mCleaningString=mCleaningString;
    }


    public String getmFoodString()
    {
        return mFoodString;
    }
    public void setmFoodString(String mFoodString)
    {
        this.mFoodString=mFoodString;
    }


    public String getmMedicString()
    {
        return mMedicString;
    }
    public void setmMedicString(String mMedicString)
    {
        this.mMedicString=mMedicString;
    }


    public String getmClothesString()
    {
        return mClothesString;
    }
    public void setmClothesString(String mClothesString)
    {
        this.mClothesString=mClothesString;
    }
}

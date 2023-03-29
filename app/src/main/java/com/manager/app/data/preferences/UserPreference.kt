package com.manager.app.data.preferences

import android.content.Context


object UserPreference {

//    private val preferenceName = "user_prefs"
//    private val key = "current_user_value"
//
//    @JvmStatic
//    fun setCurrentUser(currentUser: User, ctx: Context) {
//        val complexPreferences = ModelPreferences.getModelPreferences(ctx, preferenceName)
//        complexPreferences.putObject(key,  encryptObj(ctx,currentUser))
//        complexPreferences.commit()
//    }
//
//    @JvmStatic
//    fun getCurrentUser(ctx: Context): User? {
//        try {
//            val complexPreferences = ModelPreferences.getModelPreferences(ctx, preferenceName)
//            val currentUser = complexPreferences.getObject(key, User::class.java)
//            return currentUser?.let { decryptObj(ctx, it) }
//        }catch (e: IllegalArgumentException){
//            return null
//        }
//    }
//
//    @JvmStatic
//    fun clearCurrentUser(ctx: Context) {
//        val complexPreferences = ModelPreferences.getModelPreferences(ctx, preferenceName)
//        complexPreferences.clearObject(key)
//        complexPreferences.commit()
//    }
//
//    fun encryptObj(context: Context, user: User): User {
//        val value1 = encrypt(context, user.name)
//        val value2 = encrypt(context, user.cnic)
//        val value3 = encrypt(context, user.mobileNumber)
//        val value4 = encrypt(context, user.accountNumber)
//        val value5 = encrypt(context, user.mobileIMEI)
//        val value6 = encrypt(context, user.mobileModel)
//        val value7 = encrypt(context, user.mobileCompany)
//        val value8 = encrypt(context, user.balance)
//        //        String value9= EncryptStringData.INSTANCE.encrypt(context,user.getImagePath());
//        val value10 = encrypt(context, user.ipAddress)
//        user.name = value1
//        user.cnic = value2
//        user.mobileNumber = value3
//        user.accountNumber = value4
//        user.mobileIMEI = value5
//        user.mobileModel = value6
//        user.mobileCompany = value7
//        user.balance = value8
//        //        user.setImagePath(value9);
//        user.ipAddress = value10
//        return user
//    }
//
//    fun decryptObj(context: Context, user: User): User {
//        val value1 = decrypt(context, user.name)
//        val value2 = decrypt(context, user.cnic)
//        val value3 = decrypt(context, user.mobileNumber)
//        val value4 = decrypt(context, user.accountNumber)
//        val value5 = decrypt(context, user.mobileIMEI)
//        val value6 = decrypt(context, user.mobileModel)
//        val value7 = decrypt(context, user.mobileCompany)
//        val value8 = decrypt(context, user.balance)
//        //        String value9= EncryptStringData.INSTANCE.decrypt(context,user.getImagePath());
//        val value10 = decrypt(context, user.ipAddress)
//        user.name = value1
//        user.cnic = value2
//        user.mobileNumber = value3
//        user.accountNumber = value4
//        user.mobileIMEI = value5
//        user.mobileModel = value6
//        user.mobileCompany = value7
//        user.balance = value8
//        //        user.setImagePath(value9);
//        user.ipAddress = value10
//        return user
//    }

}

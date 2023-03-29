package com.manager.app.common.extenstions

//fun Fragment.handleApiError(
//    failure: Resource.Failure,
//    retry: (() -> Unit)? = null
//) {
//    when {
//        failure.isNetworkError -> {
////            requireView().snackbar(getString(R.string.accountStatement_error_failAccountStatement), retry)
//            alert(message = getString(R.string.accountStatement_error_failAccountStatement)) {
//                positiveButton("OK"){}
//                negativeButton("") {}
//            }.show()
//        }
//        failure.errorCode == 401 -> {
//            if (this is LoginFragment) {
//                alert(message = "You've entered incorrect email or password") {
//                    positiveButton("OK"){}
//                    negativeButton("") {  }
//                }.show()
//            } else {
//                logout()
//            }
//        }
//        else -> {
//            val error = failure.errorMessage
//            alert(message = error) {
//                positiveButton("OK"){}
//                negativeButton("") {}
//            }.show()
//        }
//    }
//}
//fun Fragment.handleValidation(
//    validation: Resource.Validation
//) {
////    requireView().snackbar(validation.value)
//    requireView().toast(validation.value)
//}
//
//fun Fragment.handleZero(
//    validation: Resource.Success<Any>
//) {
//    if (validation.value is AbstractResponse){
//        if (validation.value.response == 0){
//            validation.value.message?.let {
//                alert(message = it) {
//                    positiveButton("OK"){}
//                    negativeButton("") {  }
//                }.show()
//            }
//        }
//    }
//}
//
//
//
//fun Fragment.logout() = lifecycleScope.launch {
//    if (activity is HomeActivity) {
//        (activity as HomeActivity).signOut()
//    }
//}

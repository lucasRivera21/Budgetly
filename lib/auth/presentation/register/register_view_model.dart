import 'dart:developer';

import 'package:budgetly/auth/domain/models/register_form_model.dart';
import 'package:flutter/material.dart';

class RegisterViewModel extends ChangeNotifier {
  RegisterFormModel _registerFormModel = RegisterFormModel();
  RegisterFormModel get registerFormModel => _registerFormModel;

  void updateFields({
    String? name,
    String? email,
    String? password,
    String? confirmPassword,
  }) {
    _registerFormModel = _registerFormModel.onChangeRegisterForm(
      name,
      email,
      password,
      confirmPassword,
    );
  }

  void onRegister() {
    log("register form model: ${_registerFormModel.toString()}");
  }
}

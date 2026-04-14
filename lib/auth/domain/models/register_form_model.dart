class RegisterFormModel {
  final String name;
  final String email;
  final String password;
  final String confirmPassword;

  RegisterFormModel({
    this.name = '',
    this.email = '',
    this.password = '',
    this.confirmPassword = '',
  });

  RegisterFormModel onChangeRegisterForm(
    String? name,
    String? email,
    String? password,
    String? confirmPassword,
  ) {
    return RegisterFormModel(
      name: name ?? this.name,
      email: email ?? this.email,
      password: password ?? this.password,
      confirmPassword: confirmPassword ?? this.confirmPassword,
    );
  }

  @override
  String toString() {
    return "name: $name, email: $email, password: $password, confirmPassword: $confirmPassword";
  }
}

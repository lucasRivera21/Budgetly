// ignore: unused_import
import 'package:intl/intl.dart' as intl;
import 'app_localizations.dart';

// ignore_for_file: type=lint

/// The translations for English (`en`).
class AppLocalizationsEn extends AppLocalizations {
  AppLocalizationsEn([String locale = 'en']) : super(locale);

  @override
  String get terms => '';

  @override
  String get email => 'Email';

  @override
  String get emailPlaceholder => 'your@email.com';

  @override
  String get password => 'Password';

  @override
  String get loginScreen => '';

  @override
  String get loginDescription => 'Sign in to manage your budget';

  @override
  String get forgetPassword => 'Did you forget your password?';

  @override
  String get signIn => 'Sign in';

  @override
  String get signInWithGoogle => 'Sign in with Google';

  @override
  String get dontAccount => 'Don\'t you have an account?';

  @override
  String get createAccount => 'Create Account';
}

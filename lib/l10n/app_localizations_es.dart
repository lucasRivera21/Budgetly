// ignore: unused_import
import 'package:intl/intl.dart' as intl;
import 'app_localizations.dart';

// ignore_for_file: type=lint

/// The translations for Spanish Castilian (`es`).
class AppLocalizationsEs extends AppLocalizations {
  AppLocalizationsEs([String locale = 'es']) : super(locale);

  @override
  String get terms => '';

  @override
  String get email => 'Correo';

  @override
  String get emailPlaceholder => 'tu@correo.com';

  @override
  String get password => 'Contraseña';

  @override
  String get loginScreen => '';

  @override
  String get loginDescription => 'Inicia sesión para gestionar tu presupuesto';

  @override
  String get forgetPassword => '¿Olvidaste tu Contraseña?';

  @override
  String get signIn => 'Iniciar sesión';

  @override
  String get signInWithGoogle => 'Continuar con Google';

  @override
  String get dontAccount => '¿No tienes cuenta?';

  @override
  String get createAccount => 'Crear cuenta';
}

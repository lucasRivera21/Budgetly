import 'package:budgetly/auth/presentation/login/login_screen.dart';
import 'package:budgetly/auth/presentation/register/register_screen.dart';
import 'package:budgetly/auth/presentation/register/register_view_model.dart';
import 'package:budgetly/navigation/app_route.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';

final router = GoRouter(routes: _routes);

final _routes = [
  GoRoute(
    path: AppRoute.loginRoute,
    builder: (context, state) => LoginScreen(),
  ),

  GoRoute(
    path: AppRoute.registerRoute,
    builder: (context, state) {
      return ChangeNotifierProvider(
        create: (context) => RegisterViewModel(),
        child: RegisterScreen(),
      );
    },
  ),
];

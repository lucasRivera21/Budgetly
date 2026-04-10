import 'package:budgetly/core/presentation/components/custom_button.dart';
import 'package:budgetly/core/presentation/components/custom_text_field.dart';
import 'package:budgetly/l10n/app_localizations.dart';
import 'package:budgetly/navigation/app_route.dart';
import 'package:budgetly/theme/custom_color.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: CustomColor.surface,
        child: SafeArea(
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            child: Column(
              spacing: 20,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                header(context),
                form(context),
                forgotPassword(context),
                buttonContainer(context),
                createAccountContainer(context),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Row createAccountContainer(BuildContext context) {
    return Row(
      spacing: 4,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          AppLocalizations.of(context)!.dontAccount,
          style: TextStyle(
            color: CustomColor.onSurfaceContainer,
            fontSize: 12,
            fontWeight: FontWeight.w500,
          ),
        ),
        GestureDetector(
          onTap: () {
            context.go(AppRoute.registerRoute);
          },
          child: Text(
            AppLocalizations.of(context)!.createAccount,
            style: TextStyle(
              color: CustomColor.primary,
              fontWeight: FontWeight.w700,
              fontSize: 12,
            ),
          ),
        ),
      ],
    );
  }

  Text forgotPassword(BuildContext context) {
    return Text(
      AppLocalizations.of(context)!.forgetPassword,
      style: TextStyle(
        color: CustomColor.primary,
        fontSize: 12,
        fontWeight: FontWeight.w700,
      ),
    );
  }

  Column buttonContainer(BuildContext context) {
    return Column(
      spacing: 8,
      children: [
        CustomButton(
          textButton: AppLocalizations.of(context)!.signIn,
          bgButton: CustomColor.primary,
          textColor: CustomColor.onPrimary,
          borderColor: CustomColor.primary,
          onPressed: () {},
        ),
        CustomButton(
          textButton: AppLocalizations.of(context)!.signInWithGoogle,
          bgButton: CustomColor.surfaceContainer,
          textColor: CustomColor.onSurface,
          borderColor: CustomColor.outline,
          textIcon: "G",
          onPressed: () {},
        ),
      ],
    );
  }

  Column form(BuildContext context) {
    return Column(
      spacing: 12,
      children: [
        CustomTextField(
          labelText: AppLocalizations.of(context)!.email,
          placeholderText: AppLocalizations.of(context)!.emailPlaceholder,
          onValueChange: (String p1) {},
          textInputType: TextInputType.emailAddress,
        ),
        CustomTextField(
          labelText: AppLocalizations.of(context)!.password,
          placeholderText: '••••••••',
          onValueChange: (String p1) {},
          textInputType: TextInputType.visiblePassword,
          isPasswordInput: true,
        ),
      ],
    );
  }

  Column header(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      spacing: 8,
      children: [
        Text(
          "Budgetly",
          style: TextStyle(
            color: CustomColor.onSurface,
            fontSize: 32,
            fontWeight: FontWeight(800),
          ),
        ),
        Text(
          AppLocalizations.of(context)!.loginDescription,
          style: TextStyle(color: CustomColor.onSurfaceContainer),
        ),
      ],
    );
  }
}

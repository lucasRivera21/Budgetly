import 'package:budgetly/auth/presentation/register/components/button_container.dart';
import 'package:budgetly/auth/presentation/register/components/form_container_register_screen.dart';
import 'package:budgetly/auth/presentation/register/components/have_account_container.dart';
import 'package:budgetly/auth/presentation/register/components/header_register_screen.dart';
import 'package:budgetly/theme/custom_color.dart';
import 'package:flutter/material.dart';

class RegisterScreen extends StatelessWidget {
  const RegisterScreen({super.key});

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
              children: [
                HeaderRegisterScreen(),
                FormContainerRegisterScreen(),
                ButtonContainer(),
                HaveAccountContainer(),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

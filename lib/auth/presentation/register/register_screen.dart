import 'package:budgetly/auth/presentation/register/components/button_container.dart';
import 'package:budgetly/auth/presentation/register/components/form_container_register_screen.dart';
import 'package:budgetly/auth/presentation/register/components/have_account_container.dart';
import 'package:budgetly/auth/presentation/register/components/header_register_screen.dart';
import 'package:budgetly/auth/presentation/register/register_view_model.dart';
import 'package:budgetly/theme/custom_color.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class RegisterScreen extends StatelessWidget {
  const RegisterScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final viewModel = Provider.of<RegisterViewModel>(context, listen: false);
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
                FormContainerRegisterScreen(viewModel: viewModel),
                ButtonContainer(viewModel: viewModel),
                HaveAccountContainer(),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

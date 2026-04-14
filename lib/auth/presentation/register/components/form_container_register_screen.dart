import 'package:budgetly/auth/presentation/register/register_view_model.dart';
import 'package:budgetly/core/presentation/components/custom_text_field.dart';
import 'package:budgetly/l10n/app_localizations.dart';
import 'package:flutter/material.dart';

class FormContainerRegisterScreen extends StatelessWidget {
  final RegisterViewModel viewModel;

  const FormContainerRegisterScreen({super.key, required this.viewModel});

  @override
  Widget build(BuildContext context) {
    return Column(
      spacing: 16,
      children: [
        CustomTextField(
          labelText: AppLocalizations.of(context)!.nameLabel,
          placeholderText: AppLocalizations.of(context)!.namePlaceholder,
          onValueChange: (value) {
            viewModel.updateFields(name: value);
          },
        ),
        CustomTextField(
          labelText: AppLocalizations.of(context)!.email,
          placeholderText: AppLocalizations.of(context)!.emailPlaceholder,
          onValueChange: (value) {
            viewModel.updateFields(email: value);
          },
        ),
        CustomTextField(
          labelText: AppLocalizations.of(context)!.password,
          placeholderText: "",
          onValueChange: (value) {
            viewModel.updateFields(password: value);
          },
          isPasswordInput: true,
        ),
        CustomTextField(
          labelText: AppLocalizations.of(context)!.confirmPassword,
          placeholderText: "",
          onValueChange: (value) {
            viewModel.updateFields(confirmPassword: value);
          },
          isPasswordInput: true,
        ),
      ],
    );
  }
}

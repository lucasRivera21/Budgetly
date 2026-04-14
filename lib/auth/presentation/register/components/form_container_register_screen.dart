import 'package:budgetly/core/presentation/components/custom_text_field.dart';
import 'package:budgetly/l10n/app_localizations.dart';
import 'package:flutter/material.dart';

class FormContainerRegisterScreen extends StatelessWidget {
  const FormContainerRegisterScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      spacing: 16,
      children: [
        CustomTextField(
          labelText: AppLocalizations.of(context)!.nameLabel,
          placeholderText: AppLocalizations.of(context)!.namePlaceholder,
          onValueChange: (value) {},
        ),
        CustomTextField(
          labelText: AppLocalizations.of(context)!.email,
          placeholderText: AppLocalizations.of(context)!.emailPlaceholder,
          onValueChange: (value) {},
        ),
        CustomTextField(
          labelText: AppLocalizations.of(context)!.password,
          placeholderText: "••••••••",
          onValueChange: (value) {},
        ),
        CustomTextField(
          labelText: AppLocalizations.of(context)!.confirmPassword,
          placeholderText: "••••••••",
          onValueChange: (value) {},
        ),
      ],
    );
  }
}

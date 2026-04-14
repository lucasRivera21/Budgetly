import 'package:budgetly/core/presentation/components/custom_button.dart';
import 'package:budgetly/l10n/app_localizations.dart';
import 'package:budgetly/theme/custom_color.dart';
import 'package:flutter/material.dart';

class ButtonContainer extends StatelessWidget {
  const ButtonContainer({super.key});

  @override
  Widget build(BuildContext context) {
    return CustomButton(
      textButton: AppLocalizations.of(context)!.createAccount,
      bgButton: CustomColor.primary,
      textColor: CustomColor.onPrimary,
      borderColor: CustomColor.primary,
      onPressed: () {},
    );
  }
}

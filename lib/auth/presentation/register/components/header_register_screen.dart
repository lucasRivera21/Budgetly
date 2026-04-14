import 'package:flutter/material.dart';
import 'package:budgetly/l10n/app_localizations.dart';
import 'package:budgetly/theme/custom_color.dart';

class HeaderRegisterScreen extends StatelessWidget {
  const HeaderRegisterScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      spacing: 8,
      children: [
        Text(
          AppLocalizations.of(context)!.createAccount,
          style: TextStyle(
            color: CustomColor.onSurface,
            fontSize: 32,
            fontWeight: FontWeight(800),
          ),
        ),
        Text(
          AppLocalizations.of(context)!.registerDescription,
          style: TextStyle(color: CustomColor.onSurfaceContainer),
        ),
      ],
    );
  }
}

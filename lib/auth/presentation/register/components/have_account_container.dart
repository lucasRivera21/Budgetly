import 'package:budgetly/l10n/app_localizations.dart';
import 'package:budgetly/theme/custom_color.dart';
import 'package:flutter/material.dart';

class HaveAccountContainer extends StatelessWidget {
  const HaveAccountContainer({super.key});

  @override
  Widget build(BuildContext context) {
    return Row(
      spacing: 4,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          AppLocalizations.of(context)!.haveAccount,
          style: TextStyle(
            color: CustomColor.onSurfaceContainer,
            fontSize: 12,
            fontWeight: FontWeight.w500,
          ),
        ),
        GestureDetector(
          onTap: () {},
          child: Text(
            AppLocalizations.of(context)!.signIn,
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
}

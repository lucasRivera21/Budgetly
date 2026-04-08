import 'package:flutter/material.dart';

class CustomButton extends StatelessWidget {
  final String textButton;
  final IconData? iconButton;
  final String? textIcon;
  final Color bgButton;
  final Color textColor;
  final Color borderColor;
  final Function onPressed;

  const CustomButton({
    super.key,
    required this.textButton,
    required this.bgButton,
    required this.textColor,
    required this.borderColor,
    required this.onPressed,
    this.iconButton,
    this.textIcon,
  });

  @override
  Widget build(BuildContext context) {
    return OutlinedButton(
      style: ButtonStyle(
        backgroundColor: WidgetStatePropertyAll(bgButton),
        foregroundColor: WidgetStatePropertyAll(textColor),
        side: WidgetStatePropertyAll(BorderSide(color: borderColor)),
      ),
      onPressed: () {
        onPressed;
      },
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        spacing: 8,
        children: [
          if (textIcon != null)
            Text(
              textIcon!,
              style: TextStyle(fontWeight: FontWeight.w900, fontSize: 18),
            )
          else if (iconButton != null)
            Icon(iconButton),

          Text(textButton, style: TextStyle(fontWeight: FontWeight.w700)),
        ],
      ),
    );
  }
}

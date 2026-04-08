import 'package:budgetly/theme/custom_color.dart';
import 'package:flutter/material.dart';

class CustomTextField extends StatefulWidget {
  final String labelText;
  final String placeholderText;
  final Function(String) onValueChange;
  final bool isPasswordInput;
  final TextInputType textInputType;

  const CustomTextField({
    super.key,
    required this.labelText,
    required this.placeholderText,
    required this.onValueChange,
    this.isPasswordInput = false,
    this.textInputType = TextInputType.none,
  });

  @override
  State<CustomTextField> createState() => _CustomTextFieldState();
}

class _CustomTextFieldState extends State<CustomTextField> {
  bool _showPassword = false;

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      spacing: 4,
      children: [
        Text(
          widget.labelText,
          style: TextStyle(
            fontSize: 12,
            color: CustomColor.onSurfaceContainer,
            fontWeight: FontWeight(600),
          ),
        ),
        TextField(
          decoration: InputDecoration(
            hintText: widget.placeholderText,
            hintStyle: TextStyle(color: CustomColor.onSurfaceContainer),
            enabledBorder: OutlineInputBorder(
              borderSide: BorderSide(color: CustomColor.outline),
              borderRadius: BorderRadius.circular(12),
            ),
            focusedBorder: OutlineInputBorder(
              borderSide: BorderSide(color: CustomColor.outline),
              borderRadius: BorderRadius.circular(12),
            ),
            fillColor: CustomColor.surfaceContainer,
            filled: true,
            suffixIcon: getIcon(),
          ),
          keyboardType: widget.textInputType,
          obscureText: widget.isPasswordInput && !_showPassword,
          enableSuggestions: !widget.isPasswordInput,
          autocorrect: !widget.isPasswordInput,
          cursorColor: CustomColor.primary,
          style: TextStyle(
            color: CustomColor.onSurfaceContainer,
            fontWeight: FontWeight(500),
          ),
          maxLines: 1,
          onChanged: (value) {
            widget.onValueChange(value);
          },
        ),
      ],
    );
  }

  Widget? getIcon() {
    return widget.isPasswordInput
        ? IconButton(
            icon: Icon(
              _showPassword
                  ? Icons.visibility_outlined
                  : Icons.visibility_off_outlined,
            ),
            color: CustomColor.onSurfaceContainer,
            onPressed: () {
              setState(() {
                _showPassword = !_showPassword;
              });
            },
          )
        : null;
  }
}

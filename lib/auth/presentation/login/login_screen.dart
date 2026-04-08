import 'package:budgetly/core/presentation/components/custom_button.dart';
import 'package:budgetly/core/presentation/components/custom_text_field.dart';
import 'package:budgetly/theme/custom_color.dart';
import 'package:flutter/material.dart';

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
                header(),
                form(),
                forgotPassword(),
                buttonContainer(),
                Row(
                  spacing: 4,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      "¿No tienes cuenta?",
                      style: TextStyle(
                        color: CustomColor.onSurfaceContainer,
                        fontSize: 12,
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                    Text(
                      "Crear cuenta",
                      style: TextStyle(
                        color: CustomColor.primary,
                        fontWeight: FontWeight.w700,
                        fontSize: 12,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Text forgotPassword() {
    return Text(
      "¿Olvidaste tu contraseña?",
      style: TextStyle(
        color: CustomColor.primary,
        fontSize: 12,
        fontWeight: FontWeight.w700,
      ),
    );
  }

  Column buttonContainer() {
    return Column(
      spacing: 8,
      children: [
        CustomButton(
          textButton: 'Iniciar sesión',
          bgButton: CustomColor.primary,
          textColor: CustomColor.onPrimary,
          borderColor: CustomColor.primary,
          onPressed: () {},
        ),
        CustomButton(
          textButton: 'Continuar con Google',
          bgButton: CustomColor.surfaceContainer,
          textColor: CustomColor.onSurface,
          borderColor: CustomColor.outline,
          textIcon: "G",
          onPressed: () {},
        ),
      ],
    );
  }

  Column form() {
    return Column(
      spacing: 12,
      children: [
        CustomTextField(
          labelText: 'Correo',
          placeholderText: 'tu@correo.com',
          onValueChange: (String p1) {},
          textInputType: TextInputType.emailAddress,
        ),
        CustomTextField(
          labelText: 'Contraseña',
          placeholderText: '••••••••',
          onValueChange: (String p1) {},
          textInputType: TextInputType.visiblePassword,
          isPasswordInput: true,
        ),
      ],
    );
  }

  Column header() {
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
          "Inicia sesión para gestionar tu presupuesto",
          style: TextStyle(color: CustomColor.onSurfaceContainer),
        ),
      ],
    );
  }
}

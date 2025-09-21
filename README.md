# Banca Ficticia – Automatización de Pruebas (Módulo 4)

---

## 🎯 Objetivo  
Automatizar la validación de las funcionalidades principales del sitio web [Banca Ficticia](https://bco-selenium.netlify.app/), simulando la experiencia de un usuario real mediante pruebas funcionales automatizadas.

---

## 🛠️ Tecnologías Utilizadas  
- Selenium WebDriver  
- JUnit 5  
- WebDriverManager  
- Maven  
- Google Chrome  

---

## 🧩 Estructura del Proyecto  
- Proyecto Maven configurado con las dependencias necesarias.  
- Pruebas implementadas en:  
  `src/test/java/com/bancaficticia/BancaFicticiaTest.java`  
- Patrón Page Object Model aplicado en:  
  `src/main/java/cl/kibernum/bancaficticia/Pages/BancaFicticiaPage.java`  

---

## ✅ Casos de Prueba Automatizados

1. **Login exitoso con usuario válido**  
   Se ingresan credenciales válidas (`sofia / academy`) y se verifica el mensaje de bienvenida.

2. **Login fallido con credenciales incorrectas**  
   Se ingresan datos inválidos y se verifica el mensaje `"Credenciales incorrectas"`.

3. **Consulta de saldo tras iniciar sesión**  
   Luego de un login exitoso, se consulta el saldo y se valida que la información sea visible.

4. **Transferencia bancaria exitosa**  
   Se realiza una transferencia con monto válido y se verifica el mensaje de éxito.

5. **Transferencia con saldo insuficiente**  
   Se intenta transferir un monto mayor al disponible y se verifica el mensaje `"Saldo insuficiente"`.

6. **Logout y retorno al formulario de login**  
   Tras cerrar sesión, se verifica que el usuario vuelve a la pantalla de login con el texto `"Iniciar Sesión"`.

---

## 🌐 Detalles del Sitio  
- URL: [https://bco-selenium.netlify.app/](https://bco-selenium.netlify.app/)  
- Usuario válido: `sofia`  
- Contraseña: `academy`

---


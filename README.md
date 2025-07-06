# 📱 Basic Calculator App - Jetpack Compose
A simple calculator built using **Jetpack Compose** and **Kotlin**, capable of basic arithmetic operations (`+`, `-`, `*`, `/`) with a clean UI.

---

## ✨ Features
- 📐 Basic arithmetic support: `+`, `-`, `*`, `/`
- 📲 Jetpack Compose-based UI
- 🧮 Expression evaluation
- 🔄 Clear and reset functionality
- 📉 Rounds result to 3 decimal places

---

## 🛠 Tech Stack
- Kotlin  
- Jetpack Compose  
- Android Studio  
- Material 3 (Compose)

---

## 🚀 Steps I Followed

### 1. **Create Android Studio Project**
- Language: **Kotlin**
- Template: **Empty Activity**
- Min SDK: **21 or higher**

---

### 2. **Enable Edge-to-Edge Layout**
```kotlin
enableEdgeToEdge()
```

**## ▶️ How to Run**

-Open Android Studio

-Create a new Empty Compose Activity

-Replace contents of MainActivity.kt with the calculator code

-Run the app on emulator or physical Android device

 **Result:**

 <br>
 
![image](https://github.com/user-attachments/assets/33c83f83-1b3e-42a3-bd51-c0ee93393cd3)


**Emulator output:**

<br>

![image](https://github.com/user-attachments/assets/a97f8bca-6ea7-4c13-8192-0cae081ab7f5)


---

## ✅ Conclusion

This simple calculator app demonstrates the power and simplicity of **Jetpack Compose** for building modern Android UIs. It supports basic arithmetic operations and evaluates expressions dynamically using a custom parser.

The project also helped in understanding:
- State handling with `remember` and `mutableStateOf`
- UI composition with `Column`, `Row`, and `Box`
- Handling click events and displaying real-time results
- Structuring logic separately from UI components

With this base, the app can be extended further with features like decimal support, scientific functions, expression history, and a more advanced expression parser with precedence rules.

This project serves as a strong foundation for beginners getting started with **Compose** and modern Android development.

---

# Avito QA Trainee Testing Framework

## Описание проекта
Этот проект представляет собой Задание 1, Задание 2 для веб-сайта http://tech-avito-intern.jumpingcrab.com/.  
Фреймворк основан на **Selenide, TestNG, Rest Assured, Allure**.

## Требования
- **Java 17** 
- **Maven 3** 
- **Google Chrome**
- **ChromeDriver / WebDriverManager** (настройка автоматически через WebDriverManager)

## Установка и настройка
1. **Клонируйте репозиторий:**
   ```sh
   git clone https://github.com/your-repo/avito-qa-trainee-testing-framework.git
   cd avito-qa-trainee-testing-framework

2. **Установите зависимости:**
   ```sh
   mvn clean install

3. **Запуск всех тестов с отчетом Allure:**
   ```sh
   mvn clean test && mvn allure:serve   
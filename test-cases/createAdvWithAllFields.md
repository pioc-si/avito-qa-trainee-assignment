# Тест-кейс на создание объявления

### baseUrl приложения

```
http://tech-avito-intern.jumpingcrab.com
```

## Шаги тестирования:

####
- [ ] Открыть страницу Объявлений [baseUrl](http://tech-avito-intern.jumpingcrab.com) + [/advertisements/](/advertisements/)


# 📝 Сценарий: Пользователь создает объявление со всеми полями и находит его через поиск

## **ID**: TC-001
## **Название**: Создание объявления со всеми полями, сохранение
## **Предусловия**:
- Пользователь авторизован в системе.

---

## **Шаги**:

1. Открыть страницу с объявлениями [baseUrl](http://tech-avito-intern.jumpingcrab.com) + [/advertisements/](/advertisements/)
2. Нажать кнопку **"Создать"**
3. Заполнить форму со всеми полями
4. Нажать кнопку **"Сохранить"**

---

## **Ожидаемый результат**:
- Успешно открывается страница с Объявлениями
- Пользователь успешно создает объявление

---

## **ID**: TC-002
## **Название**: Поиск объявления
## **Предусловия**:
- успешно выполнен сценарий ## **ID**: TC-001

---

## **Шаги**:

1. На странице объявлений + [/advertisements/](/advertisements/) пользователь вводит название созданного объявления
2. Нажать кнопку **"Поиск"**
3. Объявление с именем отображено

---

## **Ожидаемый результат**:
- Название созданного объявления отображено
---



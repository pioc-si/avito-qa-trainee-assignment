# Тест-кейс на фильтр и сортировку объявлений

### baseUrl приложения

```
http://tech-avito-intern.jumpingcrab.com
```

## Шаги тестирования:

####
- [ ] Открыть страницу Объявлений [baseUrl](http://tech-avito-intern.jumpingcrab.com) + [/advertisements/](/advertisements/)


# 📝 Сценарий: Польлзователь фильтрует и сортирует объявления, указывает выводимое кол-во обявлений

## **ID**: TC-008
## **Название**: Фильтр и сортровка объявлений, проверка верного кол-ва объявлений

---

## **Шаги**:

1. Открыть страницу с объявлениями [baseUrl](http://tech-avito-intern.jumpingcrab.com) + [/advertisements/](/advertisements/)
2. Нажать кнопку **"ItemsOnPage"**
3. Выбрать 10
4. Нажать кнопку filter
5. Выбрать Цена
6. Нажать кнопку sort
7. Нажать кнопку **"По убыванию"** 

---

## **Ожидаемый результат**:
- Выводится 10 объявлений

---


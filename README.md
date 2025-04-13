## 🚀 Как проверить приложение

Есть **три способа**, чтобы запустить и проверить приложение:

---

### 🖥️ Вариант 1: Локально (сборка и запуск)

```bash
docker build -t frkntony/sber-app:kotlin-spring-boot .
docker run -p 1337:8080 frkntony/sber-app:kotlin-spring-boot
```

локальное API 
- http://localhost:1337/
- http://localhost:1337/jack

---

### 📦 Вариант 2: Использовать готовый Docker-образ

Если Docker уже установлен, можно просто спулить и запустить:

```bash
docker run -d -p 1337:8080 frkntony/sber-app:kotlin-spring-boot
```

локальное API 
- http://localhost:1337/
- http://localhost:1337/jack

---

### 🌍 Вариант 3: Посмотреть на проде

Приложение уже задеплоено и доступно по ссылкам:

- 🔗 [https://frmwrk.ru/](https://frmwrk.ru/)
- 🔗 [https://frmwrk.ru/jack](https://frmwrk.ru/jack)

---


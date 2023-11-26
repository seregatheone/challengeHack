# Challenge hack

## Android application, made afor organize group communication and share content


# Стек технологий
- Dependency Injection: Dagger hilt 
- ForegroundService + Stomp websockets
- UI Framework: Jetpack Compose
- Network: Retrofit + OkHttp
- Cache: SharedPreference / Datastore
- UI: Material Design 3, Base compose ui components
- Architecture: Clean Architecture 
- Pattern Presentation: MVVM, MVI
- Builder Project: Gradle KTS 
- Lifestreams: WebRtc + Hls  


# Параметры проекта
- Вертикальная модуляризация
- Сокеты на STOMP протоколе
- Поддержка WebRtc для аудиопотока и Hls для потоковых трансляций с сервера
- "Чистая архитекрута"
- Foreground сервис, который может дать возможность добавить уведомления, пуши и управлять плеером.  



# Ссылки для просмотра работы приложения
- регистрация, авторизация, Jwt token, профиль, логаут ~ `https://disk.yandex.ru/i/OKQeWzNiMtFGVA`
- главная, библиотека ~ `https://disk.yandex.ru/i/tAQMPv-5yqaQug`
- вход в комнату для прослушивания, чаты, кнопки для webRtc, композиции в предложениях ~ `https://disk.yandex.ru/i/EtAlC-UwfJ1Y2A`
- проверка работы звука, запуск звука с другого устройства `https://disk.yandex.ru/i/N9BWWbR9jcyLeA`  


# Требования к запуску  
 Для сборки проекта нужна джава у грейдл сборщика > 18. Поддерживаемые api - 26..33.  
 Ссылка на сборку в стейдж варианте ~ `https://disk.yandex.ru/d/1pQgOP8ZxLZpAw`

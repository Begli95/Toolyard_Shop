Технологии:
            Spring Boot
            Spring Web
            Spring Security
            Frontend (HTML, CSS, JS)
            Spring Data JPA
            PostgreSQL
            
Дополнительные инструменты:
            Flyway
            Lombok
            
Основные функции:
            Аутентификация и регистрация пользователей:
            
            Реализация механизмов аутентификации и регистрации для пользователей.
            Защита веб-приложения:
            
            Применение мер безопасности для защиты веб-приложения от несанкционированного доступа.
            Просмотр товаров:
            
            Возможность просмотра списка товаров с основной информацией о каждом товаре.
            Добавление товаров в корзину:
            
            Функционал для добавления выбранных товаров в корзину пользователя.
            Формирование заказов:
            
            Создание и оформление заказа пользователя с выбранными товарами.
            
Оплата:
            Интеграция с платежными системами для проведения оплаты заказов.
            Фильтрация / сортировка товаров:
            
            Реализация возможности фильтрации и сортировки товаров для удобства пользователя.
            Управление корзиной:
            
            Возможность просмотра и редактирования содержимого корзины.
            Валидация вводимых данных (frontend & backend):
            
            Проверка корректности вводимых данных пользователем на клиентской и серверной сторонах.
            Оповещение по email:
            
            Рассылка уведомлений и оповещений по электронной почте.
            
Сущности:
          Product:
                  id (идентификатор)
                  title (название)
                  price (цена)
                  categories (категории, к которым принадлежит товар)
                  nds, sales (опционально, НДС и скидки)
          User:
                  id
                  username
                  email
                  password
                  phone
                  role
                  address
                  archive
          Role:  
                  USER (пользователь)
                  ADMIN (администратор)
                  MANAGER (менеджер)
                  GUEST (гость)
          Order:
                  id
                  created_date
                  last_change_date
                  complited_date
                  address
                  user_id
                  status (NEW, CANCEL, PAID, CLOSED, RETURNED)
                  details (product, price, amount, comment)
          Category:
                  id
                  title (название категории)
          Bucket:
                id
                user_id
                details (product, amount) / product_list
          Like:
                id
                user_id (идентификатор пользователя)
                product_id (идентификатор продукта)
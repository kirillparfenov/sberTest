# Документация SberTest
## Как настроить запуск
- Установите PostgreSQL ([скачать](https://www.postgresql.org/download/))
- Вручную создайте БД под именем **sber**
- Запустите приложение - **SberTestApplication**
- Перейдите по ссылке http://localhost:5557/api/sber/getAllFromTable1 , чтобы отобразить содержимое таблицы T1
- Перейдите по ссылке http://localhost:5557/api/sber/getAllFromTable2 , чтобы отобразить содержимое таблицы T2
- Чтобы запустить выполнение задачи - перейдите по ссылке http://localhost:5557/api/sber/startThreads

## Сущности приложения

### T1 & T2
- **Long id** - id записи в БД
- **Value value** - сущность со значениями в формате jsonb

### Value
- **boolean threadA** - булевское значение потока threadA. Меняется на true при выполнение задачи.
- **boolean threadB** - булевское значение потока threadB. Меняется на true при выполнение задачи.
- **List<String> queue** - список потоков, меняющих флаг у threadA/threadB
 